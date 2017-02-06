package ua.nure.drozdyk.hospital.service.impl;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import ua.nure.drozdyk.hospital.constant.Attributes;
import ua.nure.drozdyk.hospital.exception.Messages;
import ua.nure.drozdyk.hospital.repository.AccountRepository;
import ua.nure.drozdyk.hospital.repository.CardRepository;
import ua.nure.drozdyk.hospital.repository.CategoryRepository;
import ua.nure.drozdyk.hospital.repository.RepositoryFactory;
import ua.nure.drozdyk.hospital.service.AdminService;
import ua.nure.drozdyk.hospital.service.CommonService;
import ua.nure.drozdyk.hospital.service.DoctorService;
import ua.nure.drozdyk.hospital.service.NurseService;

/**
 * Service manager, that works with MySQL DB.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public final class ServiceManager {
	private static final Logger LOGGER = Logger.getLogger(ServiceManager.class);

	private final DataSource dataSource;

	private final AccountRepository accountRepository;
	private final CategoryRepository categoryRepository;
	private final CardRepository cardRepository;

	private final CommonService commonService;
	private final AdminService adminService;
	private final DoctorService doctorService;
	private final NurseService nurseService;

	public static synchronized ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManager) context.getAttribute(Attributes.SERVICE_MANAGER);
		if (instance == null) {
			instance = new ServiceManager();
			context.setAttribute(Attributes.SERVICE_MANAGER, instance);
		}

		return instance;
	}

	private ServiceManager() {
		dataSource = obtainDataSource();
		accountRepository = RepositoryFactory.createRepository(AccountRepository.class);
		categoryRepository = RepositoryFactory.createRepository(CategoryRepository.class);
		cardRepository = RepositoryFactory.createRepository(CardRepository.class);

		commonService = ServiceFactory.createService(dataSource, new CommonServiceImpl(accountRepository));
		adminService = ServiceFactory.createService(dataSource,
				new AdminServiceImpl(accountRepository, categoryRepository));
		doctorService = ServiceFactory.createService(dataSource,
				new DoctorServiceImpl(accountRepository, cardRepository));
		nurseService = ServiceFactory.createService(dataSource,
				new NurseServiceImpl(accountRepository, cardRepository));
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public DoctorService getDoctorService() {
		return doctorService;
	}
	
	public NurseService getNurseService() {
		return nurseService;
	}

	public void close() {
		try {
			dataSource.getConnection().close();
		} catch (SQLException ex) {
			LOGGER.error(ex);
		}
	}

	/**
	 * Obtains data source with Naming Service That Uses JNDI API.
	 * 
	 * @return instance of data source
	 */
	private DataSource obtainDataSource() {
		DataSource ds = null;
		try {
			// Obtain an environment naming context
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			// Retrieve a data source
			ds = (DataSource) envContext.lookup("jdbc/hospital");
			LOGGER.debug("Data source: " + ds);
		} catch (NamingException ex) {
			LOGGER.error(Messages.ERR_CANNOT_OBTAIN_DATA_SOURCE, ex);
		}

		return ds;
	}
}
