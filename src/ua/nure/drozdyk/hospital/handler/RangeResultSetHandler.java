package ua.nure.drozdyk.hospital.handler;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import ua.nure.drozdyk.hospital.annotation.Column;

/**
 * Converts ResultSet to model dates.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
class RangeResultSetHandler<T> implements ResultSetHandler<T> {

	private final Class<T> classEntity;

	RangeResultSetHandler(Class<T> classEntity) {
		this.classEntity = classEntity;
	}

	/**
	 * Converts ResultSet to model dates.
	 */
	@Override
	public T handle(ResultSet rs) throws SQLException {
		try {
			T entity = classEntity.newInstance();
			Field[] fields = classEntity.getDeclaredFields();
			for (Field field : fields) {
				if (Modifier.isStatic(field.getModifiers())) {
					// missing static field serialVersionUID
					continue;
				}
				field.setAccessible(true);

				String columnName = field.getName();
				Column columnAnnotation = field.getAnnotation(Column.class);
				if (columnAnnotation != null) {
					columnName = columnAnnotation.value();
				}

				Object value = rs.getObject(columnName);

				// converter from BigInteger type to Long type
				if (value.getClass().equals(BigInteger.class)) {
					BigInteger id = (BigInteger) value;
					value = id.longValue();
				}

				field.set(entity, value);
			}

			return entity;
		} catch (Exception ex) {
			throw new SQLException(ex);
		}
	}
}
