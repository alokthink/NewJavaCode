package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.RegionListModel;
import com.mps.think.util.GeneralUtility;

public class RegionListMapper implements RowMapper<RegionListModel>{

	private static final Logger LOGGER = LoggerFactory.getLogger(RegionListMapper.class);
	
	@Override
	public RegionListModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegionListModel regionListModel = new RegionListModel();
			regionListModel.setRateClassId(rs.getInt("rate_class_id"));
			regionListModel.setCurrency(rs.getString("currency"));
			regionListModel.setRegion_list(rs.getString("region_list"));
			regionListModel.setState(rs.getString("state"));			
		return regionListModel;
	}

}
