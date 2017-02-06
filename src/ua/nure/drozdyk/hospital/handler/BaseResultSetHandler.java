package ua.nure.drozdyk.hospital.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

/**
 * Base ResultSetHandler of application, that defines processing dates: single
 * or list.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
public class BaseResultSetHandler implements ResultSetHandler<Object> {

	private boolean isCollection;
	private RangeResultSetHandler<?> rangeHandler;

	public BaseResultSetHandler(Class<?> classEntity, boolean isCollection) {
		this.rangeHandler = new RangeResultSetHandler<>(classEntity);
		this.isCollection = isCollection;
	}

	@Override
	public Object handle(ResultSet rs) throws SQLException {
		if (isCollection) {
			List<Object> list = new ArrayList<Object>();
			while (rs.next()) {
				list.add(rangeHandler.handle(rs));
			}
			return list;
		} else {
			if (rs.next()) {
				return rangeHandler.handle(rs);
			} else {
				return null;
			}
		}
	}
}
