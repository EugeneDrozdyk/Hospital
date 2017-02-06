package ua.nure.drozdyk.hospital.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * Listener of application session.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebListener
public class AplicationSessionListener implements HttpSessionListener {
	private static final Logger LOGGER = Logger.getLogger(AplicationSessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		LOGGER.info("Session created: " + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		LOGGER.info("Session destroyed" + se.getSession().getId());
	}
}
