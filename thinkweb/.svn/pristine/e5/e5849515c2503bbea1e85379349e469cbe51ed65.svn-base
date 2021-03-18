package com.mps.think.orderFunctionality.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.orderFunctionality.model.SuspensionModel;
import com.mps.think.util.PropertyUtilityClass;
	
	public class SuspensionMapper implements RowMapper<SuspensionModel>{

		@Override
		public SuspensionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			SuspensionModel model = new SuspensionModel();
			try{
				model.setCustomer(rs.getString("customer"));
				model.setDescription(rs.getString("description"));
				model.setOrderhdrId(rs.getString("orderhdr_id")!=null?rs.getString("orderhdr_id").toString():"");
				model.setOrderItemSeq(rs.getString("order_item_seq")!=null?rs.getString("order_item_seq").toString():"");
				model.setSuspensionSeq(rs.getString("suspension_seq")!=null?rs.getString("suspension_seq").toString():"");
				model.setSubscripId(rs.getString("subscrip_id")!=null?rs.getString("subscrip_id").toString():"");
				model.setUserCode(rs.getString("user_code")!=null?rs.getString("user_code").toString():"");
				model.setCreationDate(rs.getString("creation_date")!=null?rs.getString("creation_date").toString():"");
				if(rs.getString("suspension_status").equals(null) || rs.getString("suspension_status").equals("") || rs.getString("suspension_status").isEmpty()) {
					model.setSuspensionStatus("");
				}else {
					model.setSuspensionStatus(new PropertyUtilityClass().getConstantValue("suspension_status_" + rs.getInt("suspension_status")));
				}
				if(rs.getString("old_order_status").equals(null) || rs.getString("old_order_status").equals("") || rs.getString("old_order_status").isEmpty()) {
					model.setOldOrderStatus("");
				}else {
					model.setOldOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_" + rs.getInt("old_order_status")));
				}
				if(rs.getString("suspended_order_status").equals(null) || rs.getString("suspended_order_status").equals("") || rs.getString("suspended_order_status").isEmpty()) {
					model.setSuspendedOrderStatus("");
				}else {
					model.setSuspendedOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_" + rs.getInt("suspended_order_status")));
				}
				model.setSuspendFromDate(rs.getString("suspend_from_date")!=null?rs.getString("suspend_from_date").toString():"");
				model.setSuspendToDate(rs.getString("suspend_to_date")!=null?rs.getString("suspend_to_date").toString():"");
				model.setBeginIssueId(rs.getString("begin_issue_id")!=null?rs.getString("begin_issue_id").toString():"");
				model.setEndIssueId(rs.getString("end_issue_id")!=null?rs.getString("end_issue_id").toString():"");
				if(rs.getString("serve_backlabels").equals(null) || rs.getString("serve_backlabels").equals("") || rs.getString("serve_backlabels").isEmpty()) {
					model.setServeBacklabels("");
				}else {
					model.setServeBacklabels(new PropertyUtilityClass().getConstantValue("serve_backlabels_" + rs.getInt("serve_backlabels")));
				}
				model.setnBacklabels(rs.getString("n_backlabels")!=null?rs.getString("n_backlabels").toString():"");
				model.setRollbackSuspensionStatus(rs.getString("rollback_suspension_status")!=null?rs.getString("rollback_suspension_status").toString():"");
				model.setRollbackSuspendFromDate(rs.getString("rollback_suspend_from_date")!=null?rs.getString("rollback_suspend_from_date").toString():"");
				model.setRollbackSuspendToDate(rs.getString("rollback_suspend_to_date")!=null?rs.getString("rollback_suspend_to_date").toString():"");
				model.setRollbackBeginIssueId(rs.getString("rollback_begin_issue_id")!=null?rs.getString("rollback_begin_issue_id").toString():"");
				model.setRollbackEndIssueId(rs.getString("rollback_end_issue_id")!=null?rs.getString("rollback_end_issue_id").toString():"");
				model.setRollbackServeBacklabels(rs.getString("rollback_serve_backlabels")!=null?rs.getString("rollback_serve_backlabels").toString():"");
				model.setRollbackNBacklabels(rs.getString("rollback_n_backlabels")!=null?rs.getString("rollback_n_backlabels").toString():"");
				model.setRollbackOldOrderStatus(rs.getString("rollback_old_order_status")!=null?rs.getString("rollback_old_order_status").toString():"");
				model.setRollbackJobId(rs.getString("rollback_job_id")!=null?rs.getString("rollback_job_id").toString():"");
				model.setMruSuspensionNoteSeq(rs.getString("mru_suspension_note_seq")!=null?rs.getString("mru_suspension_note_seq").toString():"");
				model.setSuspensionNote(rs.getString("note_exist").toString());
				
			}catch(Exception e) {
				System.out.println("Exception:"+e);
			}
			return model;
		}

	}

