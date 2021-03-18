package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.RatecardModel;

public class RatecardMapper implements RowMapper<RatecardModel>{

	@Override
	public RatecardModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
