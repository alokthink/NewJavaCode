package com.mps.think.setup.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.mps.think.setup.model.Pub;
import com.mps.think.setup.util.PropertyUtils;

public class pubMapper implements RowMapper<Pub> {
	@Override
	public Pub mapRow(ResultSet rs, int rowNum) throws SQLException{
		Pub pub = new Pub();
		try {
			pub.setOcId(rs.getInt("oc_id"));
			pub.setnIssues(rs.getShort("n_issues"));
			pub.setnCalendarUnits(rs.getShort("n_calendar_units"));
			pub.setCalendarUnit(new PropertyUtils().getConstantValue("calendar_unit_"+rs.getInt("calendar_unit")));
			pub.setOnString(rs.getString("on_string"));
			pub.setOnCalendarUnit(new PropertyUtils().getConstantValue("on_calendar_unit_"+rs.getInt("on_calendar_unit")));
			pub.setVolumeCaption(rs.getString("volume_caption"));
			pub.setVolumeFormat(new PropertyUtils().getConstantValue("volume_format_"+rs.getInt("volume_format")));
			pub.setVolumeChangeDate(rs.getString("volume_change_date"));
			pub.setIssueCaption(rs.getString("issue_caption"));
			pub.setIssueFormat(new PropertyUtils().getConstantValue("issue_format_"+rs.getInt("issue_format")));
			pub.setIssueContinuous(rs.getShort("issue_continuous"));
			pub.setnIssuesPerVolume(rs.getShort("n_issues_per_volume"));
			pub.setNoSpacesInEnumeration(rs.getShort("no_spaces_in_enumeration"));
			pub.setSuppressEnumeration(rs.getShort("suppress_enumeration"));
			
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
		return pub;
		}
	}


