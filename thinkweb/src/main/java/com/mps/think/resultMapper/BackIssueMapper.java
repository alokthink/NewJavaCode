package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.BackIssuesModel;

public class BackIssueMapper implements RowMapper<BackIssuesModel>{

	@Override
	public BackIssuesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		BackIssuesModel backIssue = new BackIssuesModel();
		
		backIssue.setIssue_date(rs.getString("issue_date"));
		backIssue.setStatus("0");
		backIssue.setQty_sent("0");
		backIssue.setQty_ordered("1");
		backIssue.setReason("0");
		backIssue.setIssue_id(rs.getString("issue_id"));
		backIssue.setRollback_job_id("");
		backIssue.setIssue_type("");
		
		return backIssue;
	}

}
