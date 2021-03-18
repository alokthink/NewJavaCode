package com.mps.think.process.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import com.mps.think.process.model.ProcessModel;
import com.mps.think.process.util.PropertyUtility;

public class ProcessMapper implements RowMapper<ProcessModel> {

	
	@Override
	public ProcessModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProcessModel processModel = new ProcessModel();
		try {
		processModel.setProcessId(rs.getInt("process_id"));
		processModel.setDescription(rs.getString("description")!=null?rs.getString("description"):"");
		processModel.setProcessType(new PropertyUtility().getConstantValue("process_type_"+rs.getInt("process_type")));
		processModel.setStatus(rs.getInt("active"));
		processModel.setDefaultPriority(rs.getInt("default_job_priority"));
		processModel.setExtract(rs.getString("extract") != null ? rs.getString("extract"): "");
		processModel.setDriverType(rs.getInt("driver_type"));
		processModel.setBankDefId(rs.getInt("ics_bank_def_id"));
		processModel.setDefaultQueue(rs.getString("queue")!= null ? rs.getString("queue"): "");
		processModel.setAllOc(rs.getInt("all_oc"));
		processModel.setDaysBeforeEnd(rs.getInt("days_before_end"));
		processModel.setLabelGroup(rs.getString("label_group") != null ? rs.getString("label_group") : "");
		processModel.setLabelKeyline(rs.getString("label_keyline") != null ? rs.getString("label_keyline") : "");
		processModel.setLabelLength(rs.getInt("label_length"));
		processModel.setNoticeType(rs.getInt("notice_type"));
		processModel.setResendNotice(rs.getInt("resend_notice"));
		processModel.setBundleThreshold(rs.getInt("bundle_threshold"));
		processModel.setPickList(rs.getInt("pick_list"));
		processModel.setDaysPassedForPulls(rs.getString("days_passed_for_pulls") !=null ? rs.getString("days_passed_for_pulls") : "");
		processModel.setGraceCurrent(rs.getInt("grace_current"));
		processModel.setGraceNew(rs.getInt("grace_new"));
		processModel.setSqlScript(rs.getString("sql_script") !=null ? rs.getString("sql_script") : "");
		processModel.setOutputSort(rs.getString("output_sort") !=null ? rs.getString("output_sort") : "");
		processModel.setWorkDir(rs.getString("recon_work_dir") !=null ? rs.getString("recon_work_dir") :"");
		processModel.setAuddisType(rs.getString("auddis_type")!=null?rs.getString("auddis_type"):"");
		processModel.setLeaveDdAccountNumberPlainText(rs.getString("leave_dd_account_number_plain")!=null?rs.getString("leave_dd_account_number_plain"):"");
		processModel.setSkipManualPayResponse(rs.getString("skip_manual_pay_response")!=null?rs.getString("skip_manual_pay_response"):"");
		processModel.setUnpaidResubmit(rs.getInt("unpaid_resubmit"));
		processModel.setRepeatingType(rs.getInt("repeating_type"));
		processModel.setCcardExpireDays(rs.getString("ccard_expire_days")!=null?rs.getString("ccard_expire_days"):"");
		processModel.setAuditType(rs.getString("audit_type")!=null?rs.getString("audit_type"):"");
		processModel.setValidateAdds(rs.getInt("validate_adds") );
		processModel.setJobCompletionEmailAddress(rs.getString("job_completion_email_address") !=null ? rs.getString("job_completion_email_address") : "");
		processModel.setRunIcVerify(rs.getInt("run_icverify"));
		processModel.setProcessDepositPayment(rs.getInt("process_deposit_payment"));
		processModel.setIntervalUnit(rs.getInt("interval_unit"));
		processModel.setnIntervalUnits(rs.getInt("n_interval_units"));
		processModel.setPrioritySort(rs.getString("priority_sort") !=null ? rs.getString("priority_sort"):"");
		processModel.setInstallmentPlanId(rs.getInt("all_installment_plans"));
		processModel.setSchedulePaymentDays(rs.getString("schedule_payment_days")!=null?rs.getString("schedule_payment_days"):"");
		processModel.setRenGroupCurrency(rs.getInt("ren_grp_currency"));
		processModel.setRenGrpDef(rs.getInt("ren_grp_def"));
		processModel.setRenGrpOclass(rs.getInt("ren_grp_oclass"));
		processModel.setRenGrpOrder(rs.getInt("ren_grp_order"));
		processModel.setRenGrpRenTo(rs.getInt("ren_grp_ren_to"));
		processModel.setInclPkgMembers(rs.getString("incl_pkg_members")!=null?rs.getString("incl_pkg_members"):"");
		processModel.setNthDef(rs.getString("nth_def") !=null ? rs.getString("nth_def"): "");
		processModel.setRequal(rs.getInt("requal"));
		processModel.setVolumeGroupId(rs.getString("volume_group_id")!=null?rs.getString("volume_group_id"):"");
		processModel.setGenerateRenewOffers(rs.getString("generate_renew_offers")!=null?rs.getString("generate_renew_offers"):"");
		processModel.setPromotions(rs.getInt("promotions"));
		processModel.setProcessOcType(rs.getInt("process_oc_type"));
		processModel.setAllInstallmentPlans(rs.getInt("all_installment_plans"));
		processModel.setAllCreditCards(rs.getInt("all_credit_cards"));
		processModel.setCustomerType(rs.getInt("customer_type"));
		processModel.setAllProspectCategories(rs.getInt("all_prospect_categories"));
		processModel.setMultiplePerCustomer(rs.getInt("multiple_per_customer"));
		processModel.setOcId(rs.getString("oc_id")!=null?rs.getString("oc_id"):"");
		processModel.setBatchTemplate(rs.getString("batch_template")!=null ? rs.getString("batch_template"):"");
		processModel.setInclAuditParagraphReports(rs.getInt("incl_audit_paragraph_reports"));
		processModel.setCoMail(rs.getString("co_mail")!=null ?rs.getString("co_mail"):"");
		processModel.setAllListRentalCategories(rs.getString("all_list_rental_categories")!=null?rs.getString("all_list_rental_categories"):"");
		processModel.setInvServeLabel(rs.getInt("inv_serve_label"));
		processModel.setWriteReconDtl(rs.getInt("write_recon_dtl"));
		processModel.setUpdReconTables(rs.getInt("upd_recon_tables"));
		processModel.setItemsPerRequest(rs.getString("items_per_request")!=null?rs.getString("items_per_request"):"");
		processModel.setJobCompletionEmailAddress(rs.getString("job_completion_email_address")!= null ? rs.getString("job_completion_email_address"):"" );
		processModel.setAuditParagraphIgnoreBackIs(rs.getString("audit_paragraph_ignore_back_is")!=null?rs.getString("audit_paragraph_ignore_back_is"):"");
		processModel.setFromEmailAddress(rs.getString("from_email_address")!= null ? rs.getString("from_email_address"):"");
		processModel.setManualReviewFulfillment(rs.getInt("manual_review_fulfillment"));
		processModel.setAutoRenewExpireDays(rs.getString("auto_renew_expire_days")!=null?rs.getString("auto_renew_expire_days"):"");
		processModel.setOnHoldEmail(rs.getString("on_hold_email")!= null ? rs.getString("on_hold_email"):"");
		processModel.setOutputReadyEmail(rs.getString("output_ready_email")!= null ? rs.getString("output_ready_email"):"" );
		processModel.setReviewReadyEmail(rs.getString("review_ready_email")!= null ? rs.getString("review_ready_email"):"" );
		processModel.setJobDoneEmail(rs.getString("job_done_email")!= null ? rs.getString("job_done_email"):"");
		processModel.setWarningEmail(rs.getString("warning_email")!= null ? rs.getString("warning_email") :"");
		processModel.setFatal_email(rs.getString("fatal_email")!= null ? rs.getString("fatal_email") :"");
		processModel.setNoConnectEmail(rs.getString("no_connect_email")!= null ? rs.getString("no_connect_email"):"" );
		processModel.setNotification(rs.getString("notification_bits")!= null ? rs.getString("notification_bits"):"");
		processModel.setCleanupEvents(rs.getInt("cleanup_events"));
		processModel.setCancelReason(rs.getString("cancel_reason")!= null ? rs.getString("cancel_reason"):"");
		processModel.setStartDateTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())!=null
				?new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()):"");
		processModel.setAutoRenewals(rs.getString("auto_renewals")!=null?rs.getString("auto_renewals"):"");
		processModel.setRenewals(rs.getInt("renewals"));
		processModel.setProcessOutputSeq(rs.getInt("mru_process_output_seq")!=0?rs.getInt("mru_process_output_seq"):0);
		}catch(Exception e) {
			System.out.println("Exception"+e);
		}
		
		return processModel;
	}


}
