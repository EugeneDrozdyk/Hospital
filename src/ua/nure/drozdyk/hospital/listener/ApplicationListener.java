package ua.nure.drozdyk.hospital.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import ua.nure.drozdyk.hospital.service.impl.ServiceManager;

/**
 * Listener of application context, that creates instance of ServiceManager
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
	private static final Logger LOGGER = Logger.getLogger(ApplicationListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServiceManager.getInstance(sce.getServletContext());
		LOGGER.info("Servlet context is initialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServiceManager.getInstance(sce.getServletContext()).close();
		LOGGER.info("Servlet context is destroyed");
	}
}
