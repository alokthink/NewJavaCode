/**
 * 
 */
package com.mps.think.daoImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mps.think.dao.UtilityDao;

/**
 * @author Haramohan Implementation of General utility DAO
 *
 */
@Repository
public class UtilityDaoImpl implements UtilityDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilityDaoImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	/*
	 * @author Haramohan 
	 * @parameter (Tablename)View Name
	 * Method used to get display context headers for the view passed in the parameter.
	 * 
	 */
	public Map<String, Object> getDispContextHeaders(String tableName) throws SQLException {
		LOGGER.info("Inside get display contect header");
		Map<String, Object> headers = new LinkedHashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tableName", tableName);
		List<String> dispRe = namedParameterJdbcTemplate.queryForList(
				"select disp_context_to_load from disp_context_redirect where disp_context =:tableName;", parameters,
				String.class);
		List<Map<String,Object>> rows;
		if (!dispRe.isEmpty()) {

		//	parameters.replace("tableName", dispRe.get(0));
		
			rows = jdbcTemplate.queryForList(
		        "SELECT column_label,column_name FROM disp_context_column_tenant WHERE disp_context ='"+dispRe.get(0)+"'");
		} else {
			rows = jdbcTemplate.queryForList(
					"SELECT column_label,column_name FROM disp_context_column_think WHERE disp_context = '"+ tableName+"'");

		}
		System.out.println(rows);
		for (Map<String, Object> row : rows) {
			headers.put(row.get("column_label").toString(), row.get("column_name").toString());
		}
//		if(tableName == "order_item_payments"){
//			headers.put("Due", "due");
//			headers.put("", value)
//		}
		return headers;
	}

}
