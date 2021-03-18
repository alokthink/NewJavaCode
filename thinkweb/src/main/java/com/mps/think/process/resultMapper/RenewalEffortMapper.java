package com.mps.think.process.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.process.model.RenewalEffortModel;
import com.mps.think.process.util.PropertyUtility;

public class RenewalEffortMapper implements RowMapper<RenewalEffortModel> {
	
	public RenewalEffortModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		RenewalEffortModel renewalEffortModel = new RenewalEffortModel();
		renewalEffortModel.setRenewal_def(rs.getString("renewal_def"));
		renewalEffortModel.setAttachmentCode(rs.getString("attachment_code") != null ? rs.getString("attachment_code") : "");
		renewalEffortModel.setEffortNumber(rs.getInt("effort_number"));
		renewalEffortModel.setEffortType(rs.getInt("effort_type"));
		renewalEffortModel.setMessageString(rs.getString("message_string") != null ? rs.getString("message_string") : "");
		renewalEffortModel.setNumberOfUnits(rs.getInt("number_of_units"));
		renewalEffortModel.setPricingDate(rs.getInt("pricing_date"));
		renewalEffortModel.setProcessMethod(new PropertyUtility().getConstantValue("process_method_"+rs.getInt("process_method")));
		renewalEffortModel.setRenewalDefTestSeq(rs.getInt("renewal_def_test_seq"));
		renewalEffortModel.setReport(rs.getString("report")!= null ?rs.getString("report"):"");
		renewalEffortModel.setSendTo(new PropertyUtility().getConstantValue("send_to_"+rs.getInt("send_to")));
		renewalEffortModel.setSuppressEmail(rs.getInt("suppress_email"));
		renewalEffortModel.setVolumeGroupMonthDay(rs.getString("volume_group_month_day") != null ? rs.getString("volume_group_month_day") : "");
		
		return renewalEffortModel;
	}

}
