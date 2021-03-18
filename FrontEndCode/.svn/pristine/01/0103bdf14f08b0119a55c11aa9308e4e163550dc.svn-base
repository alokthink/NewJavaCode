package com.mps.think.process.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.process.model.JobModel;
import com.mps.think.process.util.PropertyUtility;

public class JobQueueMapper implements RowMapper<JobModel> {

	@Override
	public JobModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		JobModel jobModel = new JobModel();
		jobModel.setJobId(rs.getInt("job_id"));
		jobModel.setDescription(rs.getString("description")!=null ? rs.getString("description"):"");
		jobModel.setNote(rs.getString("note")!=null ? rs.getString("note"):"");
		jobModel.setStatus(new PropertyUtility().getConstantValue("status_"+rs.getInt("status")));
		jobModel.setStepName(rs.getString("step_name")!=null ? rs.getString("step_name"):"");
		//jobModel.setJobPriority(rs.getInt("job_priority"));
		jobModel.setDefaultPriority(rs.getInt("job_priority"));
		jobModel.setSelected(rs.getInt("n_selected_records"));
		jobModel.setUpdated(rs.getInt("n_updated_records"));
		jobModel.setHasError(rs.getInt("has_errors"));
		jobModel.setCandidates(rs.getInt("n_candidate_records"));
		jobModel.setProcessId(rs.getInt("process_id"));
		jobModel.setDropDate(rs.getString("drop_date")!=null ? rs.getString("drop_date"):"");
		jobModel.setCutOffDate(rs.getString("cutOff_date")!=null ? rs.getString("cutOff_date"):"");
		jobModel.setNextStartDate(rs.getString("start_date_time")!=null ? rs.getString("start_date_time"):"");
		jobModel.setLabelGroup(rs.getString("label_group")!=null ? rs.getString("label_group"):"");
		jobModel.setLabelKeyline(rs.getString("label_keyline")!=null ? rs.getString("label_keyline"):"");
		jobModel.setCreationDate(rs.getString("creation_date")!=null ? rs.getString("creation_date"):"");
		jobModel.setGraceNew(rs.getInt("grace_new"));
		jobModel.setPurpose(rs.getString("purpose")!=null ? rs.getString("purpose"):"");
		jobModel.setNthDef(rs.getString("nth_def")!=null ? rs.getString("nth_def"):"");
		jobModel.setGraceCurrent(rs.getInt("grace_current"));
		jobModel.setListCompany(rs.getString("list_company"));

		
		return jobModel;
	}

}
