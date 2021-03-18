package com.mps.think.setup.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.setup.model.CalendarCampaignModel;
import com.mps.think.setup.util.PropertyUtils;

public class CalendarCompaignMapper implements RowMapper<CalendarCampaignModel>{

	@Override
	public CalendarCampaignModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalendarCampaignModel model = new CalendarCampaignModel();
		try{
			model.setCalendarCampainId(rs.getInt("calendar_campaign_id"));
			model.setCampaign(rs.getString("campaign"));
			model.setBeginDay(rs.getInt("begin_day"));
			model.setBeginMonth(new PropertyUtils().getConstantValue("begin_month_"+rs.getInt("begin_month")));
			model.setEndDay(rs.getInt("end_day"));
			model.setEndMonth(new PropertyUtils().getConstantValue("end_month_"+rs.getInt("end_month")));
		}catch(Exception e) {
			System.out.println("Exception:"+e);
		}
		return model;
	}

}
