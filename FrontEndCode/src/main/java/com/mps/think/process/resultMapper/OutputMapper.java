package com.mps.think.process.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.process.model.OutputModel;
import com.mps.think.process.util.PropertyUtility;

public class OutputMapper implements RowMapper<OutputModel>  {

	@Override
	public OutputModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		OutputModel outputModel = new OutputModel();
		outputModel.setProcessId(rs.getInt("process_id"));
		outputModel.setProcessOutputSeq(rs.getInt("process_output_seq"));
		outputModel.setOutputType(new PropertyUtility().getConstantValue("output_type_"+rs.getString("output_type")));
		outputModel.setOc(rs.getString("oc")!=null ? rs.getString("oc"): "");
		outputModel.setOutput(rs.getString("report")!=null ? rs.getString("report"): "");
		outputModel.setOutputMode(new PropertyUtility().getConstantValue("output_mode_"+rs.getString("output_mode")));
		outputModel.setOutputFileName(rs.getString("output_filename")!=null ? rs.getString("output_filename") : "");
		outputModel.setAppendJobId(rs.getInt("append_job_id"));
		outputModel.setOutputFormat(rs.getString("output_format")!=null ? rs.getString("output_format"): "");
		outputModel.setInstallmentPlan(rs.getString("installment_plan")!=null ? rs.getString("installment_plan") : "");
		outputModel.setDef(rs.getString("def")!=null ? rs.getString("def") : "");
		outputModel.setTestSeq(rs.getString("test_seq")!=null ? rs.getString("test_seq") : "");
		outputModel.setEffortNumber(rs.getString("effort_number")!=null ? rs.getString("effort_number") : "" );
		outputModel.setAuditReport(rs.getString("audit_report")!=null ? rs.getString("audit_report") : "");
		outputModel.setParamValues(rs.getString("param_values")!=null ? rs.getString("param_values") :"");
		
		return outputModel;
	}

}
