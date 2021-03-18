package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.IssueModel;
import com.mps.think.util.PropertyUtilityClass;

public class IssueMapper implements RowMapper<IssueModel>{

	@Override
	public IssueModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		IssueModel issueModel = new IssueModel();
			
			issueModel.setIssueId(rs.getLong("issue_id"));
			issueModel.setOcId(rs.getInt("oc_id"));
			issueModel.setIssueDate(new PropertyUtilityClass().getDateFormatter(rs.getString("issue_date").toString()));
			issueModel.setEnumeration(rs.getString("enumeration"));
			issueModel.setVolumeGroupId(rs.getString("volume_group_id")!=null?rs.getString("volume_group_id"):"");
		
		return issueModel;
	}

}
