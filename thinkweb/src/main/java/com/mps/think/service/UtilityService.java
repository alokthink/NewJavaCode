/**
 * 
 */
package com.mps.think.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * @author Harmohan
 *
 */

public interface UtilityService {

	public Map<String, Object> getDispContextHeaders(String tableName) throws SQLException;

	public boolean sendMail(String subject, String msg) throws AddressException, MessagingException, IOException;

}
