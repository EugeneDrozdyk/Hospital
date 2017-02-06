package ua.nure.drozdyk.hospital.repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.log4j.Logger;

import ua.nure.drozdyk.hospital.annotation.ReturnType;
import ua.nure.drozdyk.hospital.annotation.sql.Delete;
import ua.nure.drozdyk.hospital.annotation.sql.Insert;
import ua.nure.drozdyk.hospital.annotation.sql.Select;
import ua.nure.drozdyk.hospital.annotation.sql.Update;
import ua.nure.drozdyk.hospital.exception.ApplicationException;
import ua.nure.drozdyk.hospital.exception.Messages;
import ua.nure.drozdyk.hospital.handler.BaseResultSetHandler;

/**
 * Factory for creating repository instance.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class RepositoryFactory {
	private static final Logger LOGGER = Logger.getLogger(RepositoryFactory.class);

	/**
	 * Creates new proxy instance for repository.
	 * 
	 * @param repositoryInterface
	 *            interface of repository.
	 * @return repository proxy object.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends BaseRepository> T createRepository(Class<T> repositoryInterface) {
		return (T) Proxy.newProxyInstance(RepositoryFactory.class.getClassLoader(), new Class[] { repositoryInterface },
				new RepositoryInvocationHandler());
	}

	/**
	 * Handler of SQL annotations.
	 * 
	 * @author E.Drozdyk
	 * @version 1.0
	 */
	private static class RepositoryInvocationHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			try {
				Connection conn = ConnectionUtils.getCurrentConnection();

				Select aSelect = method.getAnnotation(Select.class);
				if (aSelect != null) {
					return select(conn, aSelect, method, args);
				}

				Delete aDelete = method.getAnnotation(Delete.class);
				if (aDelete != null) {
					return delete(conn, aDelete, method, args);
				}

				Insert aInsert = method.getAnnotation(Insert.class);
				if (aInsert != null) {
					return insert(conn, aInsert, method, args);
				}

				Update aUpdate = method.getAnnotation(Update.class);
				if (aUpdate != null) {
					return update(conn, aUpdate, method, args);
				}

			} catch (SQLException ex) {
				String msg = Messages.ERR_CANNOT_PERFORM_SQL_QUERY;
				LOGGER.error(msg, ex);
				throw new ApplicationException(msg, ex);
			}
			String msg = Messages.ERR_CANNOT_PERFORM_METHOD + method;
			LOGGER.error(msg);
			throw new UnsupportedOperationException(msg);
		}

		/**
		 * Handler of annotation {@link Select}.
		 */
		private Object select(Connection conn, Select aSelect, Method method, Object[] args) throws Exception {
			Class<?> returnType = setResultType(method);
			boolean isCollection = Collection.class.isAssignableFrom(method.getReturnType());
			BaseResultSetHandler rsh = build(returnType, isCollection, aSelect.resultSetHandlerClass());

			return new QueryRunner().query(conn, aSelect.sql(), rsh, args);
		}

		/**
		 * Handler of annotation {@link Delete}.
		 */
		private Object delete(Connection conn, Delete aDelete, Method method, Object[] args) throws SQLException {
			int result = new QueryRunner().update(conn, aDelete.sql(), args);
			if (method.getReturnType() == Integer.TYPE) {
				return result;
			} else if (method.getReturnType() == Void.TYPE) {
				return null;
			} else {
				String msg = Messages.ERR_CANNOT_RETURN_SUCH_TYPE;
				LOGGER.error(msg);
				throw new IllegalArgumentException(msg);
			}
		}

		/**
		 * Handler of annotation {@link Insert}.
		 */
		private Object insert(Connection conn, Insert aInsert, Method method, Object[] args) throws Exception {
			Object[] insertArgs = getInsertArguments(args);
			return new QueryRunner().update(conn, aInsert.sql(), insertArgs);
		}

		/**
		 * Handler of annotation {@link Update}.
		 */
		private Object update(Connection conn, Update aUpdate, Method method, Object[] args) throws Exception {
			Object[] insertArgs = getInsertArguments(args);
			return new QueryRunner().update(conn, aUpdate.sql(), insertArgs);
		}

		/**
		 * Sets return type of repository method.
		 * 
		 * @param method
		 *            of repository.
		 * @return type of class.
		 */
		private Class<?> setResultType(Method method) {
			ReturnType returnType = method.getAnnotation(ReturnType.class);
			if (returnType != null) {
				return returnType.entityClass();
			} else {
				return method.getReturnType();
			}
		}

		/**
		 * Builds ResultSetHandler instance.
		 */
		private BaseResultSetHandler build(Class<?> returnType, boolean isCollection,
				Class<? extends BaseResultSetHandler> resultSetHandlerClass) throws Exception {
			Constructor<? extends BaseResultSetHandler> constructor = resultSetHandlerClass.getConstructor(Class.class,
					Boolean.TYPE);
			return constructor.newInstance(returnType, isCollection);
		}

		/**
		 * Gets arguments for insertion.
		 */
		private Object[] getInsertArguments(Object[] args) throws IllegalArgumentException, IllegalAccessException {
			if (args.length >= 1) {
				Object entity = args[0];
				Field fields[] = entity.getClass().getDeclaredFields();
				List<Object> resolvedArgs = new ArrayList<>();
				for (Field f : fields) {
					if (f.getName().equals("id") || Modifier.isStatic(f.getModifiers())) {
						continue;
					} else {
						f.setAccessible(true);
						resolvedArgs.add(f.get(entity));
					}
				}
				if (args.length == 2) {
					// args[1] always id.
					resolvedArgs.add(args[1]);
				}

				return resolvedArgs.toArray();
			} else {
				return args;
			}
		}
	}

}
