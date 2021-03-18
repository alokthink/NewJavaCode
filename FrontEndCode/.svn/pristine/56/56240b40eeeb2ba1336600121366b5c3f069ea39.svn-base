package com.mps.think.daoImpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mps.think.dao.UserInfoDAO;
import com.mps.think.model.UserInfo;

@Repository
@Transactional
public class UserInfoDAOImpl implements UserInfoDAO {
	
	public UserInfo getActiveUser(String userName) {
		UserInfo activeUserInfo = new UserInfo();
		activeUserInfo.setUserName("thinktest@test.com");
		activeUserInfo.setPassword("$2a$10$XgoUpwiINHYMDQcCDypn2OXUz0DW8FoemyZc8Fw8th0C.S9kMfUse");
		activeUserInfo.setRole("USER");
		return activeUserInfo;
	}
	
} 

