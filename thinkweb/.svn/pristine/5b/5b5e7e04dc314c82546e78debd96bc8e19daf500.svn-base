package com.mps.think.setup.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.mps.think.setup.model.PubRotation;
import com.mps.think.setup.util.PropertyUtils;

public class PubRotationMapper implements RowMapper<PubRotation> {

	@Override
	public PubRotation mapRow(ResultSet rs, int rowNum) throws SQLException{
		PubRotation pubRotation = new PubRotation();
		try{
			pubRotation.setPubRotationId(rs.getInt("pub_rotation_id"));
			pubRotation.setOcId(rs.getInt("oc_id"));
			pubRotation.setDescription(rs.getString("description"));
			pubRotation.setOnString(rs.getString("on_string"));
			pubRotation.setOnCalendarUnit(new PropertyUtils().getConstantValue("on_calendar_unit_"+rs.getInt("on_calendar_unit")));
			pubRotation.setOnDay(rs.getShort("on_day"));
			
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
		return pubRotation;
		
	}
	
}
