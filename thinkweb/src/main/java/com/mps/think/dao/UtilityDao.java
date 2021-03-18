/**
 * 
 */
package com.mps.think.dao;

import java.sql.SQLException;
import java.util.Map;

/**
 * @author Haramohan
 * General Utility DAO interface to handle common functionality
 */
public interface UtilityDao 
{
	public Map<String, Object> getDispContextHeaders(String tableName) throws SQLException;

}
