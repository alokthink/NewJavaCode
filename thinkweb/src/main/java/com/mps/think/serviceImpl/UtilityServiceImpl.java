/**
 * 
 */
package com.mps.think.serviceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.dao.UtilityDao;
import com.mps.think.service.UtilityService;
import com.mps.think.util.GeneralUtility;

/**
 * @author Harmohan
 *
 */
@Service("utilityService")
public class UtilityServiceImpl implements UtilityService {


	@Autowired
	UtilityDao  utilityDao;
	
	
	public Map<String, Object> getDispContextHeaders(String tableName) throws SQLException {
		
		return utilityDao.getDispContextHeaders(tableName);
	}

	public boolean sendMail(String subject,String msg) throws AddressException, MessagingException, IOException {

		boolean status=GeneralUtility.sendMail(subject, msg);
		return status;
		
	}

}
