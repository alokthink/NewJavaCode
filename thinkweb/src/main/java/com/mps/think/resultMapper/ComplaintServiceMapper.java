package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.ComplaintServiceModel;

/*select s.customer_id, s.service_seq, s.user_code, s.complaint_code,
s.cause_code, s.service_code, s.orderhdr_id, s.order_item_seq, s.complaint_date,
s.service_date, s.followup_date, s.service_status, s.subscrip_id, 
s.claim_ref_nbr, sn.note_field from  service as s join service_note as sn
On s.customer_id=sn.customer_id AND s.service_seq=sn.service_seq */

public class ComplaintServiceMapper implements RowMapper<ComplaintServiceModel>{
	private static final Logger LOGGER = LoggerFactory.getLogger(RegionListMapper.class);

	public ComplaintServiceModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ComplaintServiceModel model = new ComplaintServiceModel();
		model.setCustomerId(rs.getString("customer_id").toString());
		model.setServiceSeq(rs.getString("service_seq"));
		model.setUserCode(rs.getString("user_code"));
		model.setComplaintCode(rs.getString("complaint_code"));
		model.setComplaintDate(rs.getString("complaint_date"));
		model.setCauseCode(rs.getString("cause_code"));
		model.setServiceCode(rs.getString("service_code"));
		model.setOrderId(rs.getString("orderhdr_id"));
		model.setOrderItemSeq(rs.getString("order_item_seq"));
		model.setServiceDate(rs.getString("service_date"));
		model.setFollowupDate(rs.getString("followup_date"));
		model.setServiceStatus(rs.getString("service_status"));
		model.setSubscripId(rs.getString("subscrip_id"));
		model.setNoteField(rs.getString("note_field"));
		model.setComplaintReference(rs.getString("claim_ref_nbr"));
		return model;
	}

}
