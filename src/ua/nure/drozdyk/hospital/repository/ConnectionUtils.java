package ua.nure.drozdyk.hospital.repository;

import java.sql.Connection;

import org.apache.log4j.Logger;

import ua.nure.drozdyk.hospital.exception.Messages;

/**
 * Holds local variable of connection to database.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class ConnectionUtils {
	private static final Logger LOGGER = Logger.getLogger(ConnectionUtils.class);

	private static final ThreadLocal<Connection> connections = new ThreadLocal<>();

	private ConnectionUtils() {

	}

	public static Connection getCurrentConnection() {
		Connection conn = connections.get();
		if (conn == null) {
			LOGGER.error(Messages.ERR_CANNOT_FOUND_CONNECTION);
			throw new IllegalStateException(Messages.ERR_CANNOT_FOUND_CONNECTION);
		}
		return conn;
	}

	public static void setCurrentConnection(Connection c) {
		connections.set(c);
	}

	public static void removeCurrentConnection() {
		connections.remove();
	}
}
