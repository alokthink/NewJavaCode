package com.mps.think.process.resultMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import com.mps.think.process.model.EffortModel;
import com.mps.think.process.util.PropertyUtility;
import com.mps.think.resultMapper.CustomerOrderMapper;

public class EffortMapper implements RowMapper<EffortModel>{
	

	private static final Logger LOGGER = LoggerFactory.getLogger(EffortMapper.class);
	@Override
	public EffortModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	EffortModel effortModel  = new EffortModel();
	try {
		effortModel.setEffortNumber(rs.getInt("effort_number"));
		effortModel.setProcessMethod(new PropertyUtility().getConstantValue("process_method_"+rs.getString("process_method")));
		//effortModel.setInterval(rs.getString("interval")!=null?rs.getString("interval"):"");
		effortModel.setAction(new PropertyUtility().getConstantValue("action_"+rs.getInt("action")));
		effortModel.setSendTo(new PropertyUtility().getConstantValue("send_to_"+rs.getInt("send_to")));
		effortModel.setSendBill(rs.getInt("send_bill"));
		effortModel.setReport(rs.getString("report")!= null ? rs.getString("report"):"");
		effortModel.setAttachmentCode(rs.getString("attachment_code")!=null ? rs.getString("attachment_code"):"");
		effortModel.setMessageString(rs.getString("message_string")!=null ? rs.getString("message_string"):"");
		effortModel.setSuppressEmail(rs.getInt("suppress_email"));
		effortModel.setBillingDefTestSeq(rs.getInt("billing_def_test_seq"));
		effortModel.setBillingDef(rs.getString("billing_def"));
		effortModel.setStatus(rs.getInt("Active")!=0?rs.getInt("Active"):0);
		
	}catch(Exception e) {
		LOGGER.info("effortModel : "+e);
	}
	return effortModel;
	}
}
