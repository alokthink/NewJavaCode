package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.ServiceFilterModel;

public class ServiceFilterMapper implements RowMapper<ServiceFilterModel>{
//service.subscrip_id,service.service_date,service.order_item_seq,service.orderhdr_id,service.followup_date,service.customer_id 
	@Override
	public ServiceFilterModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ServiceFilterModel serviceFilterModel = new ServiceFilterModel();
		try {
			serviceFilterModel.setComplait_date(rs.getString("complaint_date"));
			serviceFilterModel.setComplaint_code(rs.getString("complaint_code"));
			serviceFilterModel.setCause_code(rs.getString("cause_code"));
			serviceFilterModel.setService_code(rs.getString("service_code"));
			serviceFilterModel.setNote(rs.getString("note_field"));
			serviceFilterModel.setClosed(rs.getInt("service_status"));
			serviceFilterModel.setOperator(rs.getString("user_code"));
			serviceFilterModel.setService_seq(rs.getInt("service_seq"));
			serviceFilterModel.setSubscripId(rs.getString("subscrip_id")!=null ? rs.getString("subscrip_id"):"");
			serviceFilterModel.setServiceDate(rs.getString("service_date"));
			serviceFilterModel.setOrderItemSeq(rs.getInt("order_item_seq"));
			serviceFilterModel.setOrderhdrId(rs.getString("orderhdr_id"));
			serviceFilterModel.setFollowupDate(rs.getString("followup_date"));
			serviceFilterModel.setCustomerId(rs.getInt("customer_id"));
			
		}
		catch(Exception e) {
			
		}
		
		return serviceFilterModel;
	}
	

}
