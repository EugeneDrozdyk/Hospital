package ua.nure.drozdyk.hospital.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import ua.nure.drozdyk.hospital.annotation.Transactional;
import ua.nure.drozdyk.hospital.exception.ApplicationException;
import ua.nure.drozdyk.hospital.exception.Messages;
import ua.nure.drozdyk.hospital.repository.ConnectionUtils;
import ua.nure.drozdyk.hospital.service.BaseService;

/**
 * Factory for creating service instance.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class ServiceFactory {
	private static final Logger LOGGER = Logger.getLogger(ServiceFactory.class);

	@SuppressWarnings("unchecked")
	public static <T extends BaseService> T createService(DataSource dataSource, T realService) {

		return (T) Proxy.newProxyInstance(ServiceFactory.class.getClassLoader(), realService.getClass().getInterfaces(),
				new ServiceInvocationHandler<>(dataSource, realService));
	}

	private static class ServiceInvocationHandler<T> implements InvocationHandler {

		private final T realService;
		private final DataSource dataSource;

		public ServiceInvocationHandler(DataSource dataSource, T realService) {
			super();
			this.dataSource = dataSource;
			this.realService = realService;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Method m = findMethodForService(method);
			Transactional transactional = m.getAnnotation(Transactional.class);
			try {
				if (transactional != null) {
					return invokeTransactional(transactional, m, args);
				} else {
					return m.invoke(realService, args);
				}
			} catch (Exception e) {
				if (e instanceof InvocationTargetException) {
					throw ((InvocationTargetException) e).getTargetException();
				} else {
					throw e;
				}
			}
		}

		private Method findMethodForService(Method method) {
			for (Method m : realService.getClass().getDeclaredMethods()) {
				if (m.getName().equals(method.getName())
						&& Arrays.equals(m.getParameterTypes(), method.getParameterTypes())) {
					return m;
				}
			}
			String msg = Messages.ERR_CANNOT_FIND_SUCH_METHOD;
			LOGGER.error(msg + method);
			throw new IllegalArgumentException(msg + method);
		}

		@SuppressWarnings("unchecked")
		private T invokeTransactional(Transactional transactional, Method method, Object[] args)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			try (Connection conn = dataSource.getConnection()) {
				ConnectionUtils.setCurrentConnection(conn);
				if (transactional.readOnly()) {
					return (T) method.invoke(realService, args);
				} else {
					try {
						T result = (T) method.invoke(realService, args);
						conn.commit();
						return result;
					} catch (Exception ex) {
						if (ex instanceof RuntimeException) {
							conn.rollback();
						}
						throw ex;
					}
				}

			} catch (SQLException ex) {
				throw new ApplicationException(ex);
			} finally {
				ConnectionUtils.removeCurrentConnection();
			}
		}
	}
}
