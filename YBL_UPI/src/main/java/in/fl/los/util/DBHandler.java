package in.fl.los.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository("DBHandler")
public class DBHandler {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger log = Logger.getLogger(DBHandler.class);

	public float getSingleDBValueFloat(String query) {
		Float ret = null;
		try {
			ret = jdbcTemplate.queryForObject(query, Float.class);
		} catch (EmptyResultDataAccessException ee) {

		} catch (Exception e) {
			log.error("ERROE in sql: " + query);
			log.error("Error log: ", e);
		}
		if (ret != null)
			return ret.floatValue();
		return -1;
	}

	public int getSingleDBValueInt(String query) {
		Integer ret = new Integer(-1);
		try {
			ret = jdbcTemplate.queryForObject(query, Integer.class);
		} catch (EmptyResultDataAccessException ee) {

		} catch (Exception e) {
			log.error("ERROE in sql: " + query);
			log.error("Error log: ", e);
		}
		if (ret != null)
			return ret.intValue();
		return -1;
	}

	public String getSingleDBValueString(String query) {
		String ret = "";
		try {
			ret = jdbcTemplate.queryForObject(query, String.class);
		} catch (EmptyResultDataAccessException ee) {

		} catch (Exception e) {
			log.error("ERROE in sql: " + query);
			log.error("Error log: ", e);
		}
		if (ret != null)
			return ret;
		return "";
	}

	public void executeQuery(String query) {
		// log.debug(query);
		try {
			jdbcTemplate.execute(query);
		} catch (EmptyResultDataAccessException ee) {

		} catch (Exception e) {
			log.error("SQL failed : " + query);
			log.error("Query exec failed ", e);
		}
	}

	public HashMap<String, String> getOneRow(String query) {
		HashMap<String, String> stringMap = jdbcTemplate.query(query,
				new ResultSetExtractor<HashMap<String, String>>() {
					@Override
					public HashMap<String, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
						HashMap<String, String> row = new HashMap<String, String>();
						if (rs.next()) {
							java.sql.ResultSetMetaData rsmd = rs.getMetaData();
							for (int i = 1; i <= rsmd.getColumnCount(); i++) {
								String label = rsmd.getColumnLabel(i);
								String value = rs.getString(label);
								row.put(label, value);
							}
						}
						return row;
					}
				});
		return stringMap;
	}

	public List<String> getStringList(String query) {
		List<String> stringList = jdbcTemplate.query(query, new ResultSetExtractor<List<String>>() {
			@Override
			public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<String> tailList = new ArrayList<String>();
				while (rs.next()) {
					String item = rs.getString(1);
					if (item != null && item.trim().length() > 0) {
						tailList.add(item);
					}
				}
				return tailList;
			}
		});
		return stringList;
	}
}
