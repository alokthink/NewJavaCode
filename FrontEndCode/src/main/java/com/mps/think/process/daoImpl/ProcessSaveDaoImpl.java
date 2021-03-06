package com.mps.think.process.daoImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mps.think.daoImpl.PaymentInfoDaoImpl;
import com.mps.think.process.dao.ProcessSaveDao;
import com.mps.think.process.model.EffortModel;
import com.mps.think.process.model.JobModel;
import com.mps.think.process.model.NthModel;
import com.mps.think.process.model.OutputModel;
import com.mps.think.process.model.ProcessModel;
import com.mps.think.process.model.RenewalEffortModel;
import com.mps.think.process.model.RenewalModel;
import com.mps.think.process.resultMapper.OutputMapper;


@Repository
public class ProcessSaveDaoImpl implements ProcessSaveDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentInfoDaoImpl.class);
	private static final String ERROR = "Error"; 
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public boolean billingDefinitionSave(ProcessModel processModel) {
		
		LOGGER.info("Inside billingDefinitionSave");
		try {

			String addBillingQuery = "update process set extract = :extract,label_group = :label_group ,label_keyline =:label_keyline,description =:description,active =:active, all_oc =:all_oc , renewals = :renewals , bills =:bills ,"  
					+ " splits =:splits , inserts =:inserts,label_length =:label_length,default_job_priority =:default_job_priority, process_oc_type =:process_oc_type, installment_bills=:installment_bills,auto_renewals =:auto_renewals ,"
					+ " grace_new =:grace_new , grace_current =:grace_current , output_sort =:output_sort , pick_list =:pick_list , queue =:queue , bundle_threshold =:bundle_threshold , days_passed_for_pulls =:days_passed_for_pulls ,"
					+ " priority_sort =:priority_sort , sql_script =:sql_script , manual_review_fulfillment =:manual_review_fulfillment, repeating_type =:repeating_type where process_id ="+processModel.getProcessId()+" ";
					
			Map<String, Object> addBillingParams = new HashMap<>();	
			addBillingParams.put("active", processModel.getStatus());
			addBillingParams.put("extract", processModel.getExtract()=="" ? null : processModel.getExtract());
			addBillingParams.put("label_group",processModel.getLabelGroup()=="" ? null : processModel.getLabelGroup());
			addBillingParams.put("description",processModel.getDescription()=="" ? null : processModel.getDescription());
			addBillingParams.put("bills",processModel.getBills()!=0?processModel.getBills():0);
			addBillingParams.put("all_oc",processModel.getAllOc()!=0?processModel.getAllOc():0);
			addBillingParams.put("renewals",processModel.getRenewals()!=0?processModel.getRenewals():0);
			if( ("null".equals(processModel.getAutoRenewals())) | ("".equals(processModel.getAutoRenewals()))) {
				addBillingParams.put("auto_renewals", null);
			}else {
				addBillingParams.put("auto_renewals", processModel.getAutoRenewals());
			}
			addBillingParams.put("splits",processModel.getSplits()!=null?processModel.getSplits():0);
			addBillingParams.put("inserts",processModel.getInserts()!=null?processModel.getInserts():0);
			addBillingParams.put("label_length", processModel.getLabelLength()!=null?processModel.getLabelLength():null);
			addBillingParams.put("default_job_priority",processModel.getDefaultPriority()!=null?processModel.getDefaultPriority():1);			
			addBillingParams.put("process_oc_type",processModel.getProcessOcType()!=null?processModel.getProcessOcType():0);
			addBillingParams.put("installment_bills",processModel.getInstallmentBills()!=null?processModel.getInstallmentBills():0);
			addBillingParams.put("grace_new",processModel.getGraceNew()!=null?processModel.getGraceNew():0);
			addBillingParams.put("grace_current",processModel.getGraceCurrent()!=null?processModel.getGraceCurrent():0);
			addBillingParams.put("pick_list", processModel.getPickList()!=null?processModel.getPickList():0);
			if( ("null".equals(processModel.getDefaultQueue())) | ("".equals(processModel.getDefaultQueue()))) {
				addBillingParams.put("queue", null);
			}else {
				addBillingParams.put("queue", processModel.getDefaultQueue());
			}
			addBillingParams.put("bundle_threshold", processModel.getBundleThreshold()!=null?processModel.getBundleThreshold():1);
			if( ("null".equals(processModel.getDaysPassedForPulls())) | ("".equals(processModel.getDaysPassedForPulls()))) {
				addBillingParams.put("days_passed_for_pulls", null);
			}else {
				addBillingParams.put("days_passed_for_pulls", processModel.getDaysPassedForPulls());
			}
			addBillingParams.put("repeating_type", processModel.getRepeatingType()!=null?processModel.getRepeatingType():0);
			addBillingParams.put("manual_review_fulfillment", processModel.getManualReview()!=null?processModel.getManualReview():0);
			addBillingParams.put("audit_type",processModel.getAuditType()!=""?processModel.getAuditType():null);
			addBillingParams.put("label_keyline", processModel.getLabelKeyline()!=""?processModel.getLabelKeyline():null);
			addBillingParams.put("output_sort", processModel.getOutputSort()!=""?processModel.getOutputSort():null);
			addBillingParams.put("priority_sort", processModel.getPrioritySort()!=""?processModel.getPrioritySort():null);
			addBillingParams.put("sql_script", processModel.getSqlScript()!=""?processModel.getSqlScript():null);
				
			namedParameterJdbcTemplate.update(addBillingQuery, addBillingParams);
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public String savePaymentDetails(ProcessModel processModel) {
		LOGGER.info("Inside savePaymentDetails");
		try {

			String processQuery = "UPDATE PROCESS SET"
					+ " extract = :extract,description = :description,active = :active,default_job_priority = :default_job_priority,process_oc_type = :process_oc_type,queue = :queue,"
					+ "ics_bank_def_id = :ics_bank_def_id,repeating_type = :repeating_type,driver_type = :driver_type,run_icverify = :run_icverify,process_deposit_payment = :process_deposit_payment,all_oc = :all_oc"
					+ " WHERE process_id="+processModel.getProcessId()+ " ";

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("extract", processModel.getExtract() == "" ? null : processModel.getExtract());
			parameters.put("description",processModel.getDescription());
			parameters.put("active", processModel.getStatus());
			parameters.put("default_job_priority",processModel.getDefaultPriority());
			parameters.put("process_oc_type",processModel.getProcessOcType());
			parameters.put("queue", processModel.getDefaultQueue());
			parameters.put("ics_bank_def_id", processModel.getBankDefId());
			parameters.put("repeating_type",processModel.getRepeatingType());
			parameters.put("driver_type", processModel.getDriverType());
			parameters.put("run_icverify", processModel.getRunIcVerify());
			parameters.put("process_deposit_payment", processModel.getProcessDepositPayment());
			parameters.put("all_oc", processModel.getAllOc());
			
			namedParameterJdbcTemplate.update(processQuery, parameters);

			return "Saved";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}

		
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean selectAllOCSave(String ocID,int processId) {

		LOGGER.info("Inside selectAllOCSave");
		try {
    
			String oc_ID[] = String.valueOf(ocID).split(",");
			String addProcessQuery = "insert into process_oc (process_id,oc_id) values ( ?, ?)"; 
			
			List<Object[]> list = new ArrayList<>();
            for(int i=0;i<oc_ID.length;i++) {                        	       					
            			Object[] objArr = {processId,oc_ID[i]};
            			list.add(objArr);
            }	

           jdbcTemplate.batchUpdate(addProcessQuery, list);
			return true;
         
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
		
	}
	
	
	@Override
	public boolean clearAllOC(String ocID,int processId) {

		LOGGER.info("Inside clearAllOC");
		try {
			Map<String, Object> addProcessParams = new HashMap<>();     
			String oc_ID[] = String.valueOf(ocID).split(",");
			String addProcessQuery = null;
            for(int i=0;i<oc_ID.length;i++) {                        
             addProcessQuery = "delete from process_oc where process_id =:process_id and oc_id =:oc_id";            			       					
            			addProcessParams.put("process_id",processId);	
            			addProcessParams.put("oc_id", oc_ID[i]);
            			namedParameterJdbcTemplate.update(addProcessQuery, addProcessParams);
            }		        
           
			return true;
         
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
		
	}
	
	@Override
	public String saveLabelDetails(ProcessModel processModel) {
		LOGGER.info("Inside saveLabelDetails");
		try {

			String processQuery = "UPDATE PROCESS SET"
					+ " extract = :extract,label_keyline = :label_keyline,label_group = :label_group,description = :description,active = :active,label_length = :label_length,default_job_priority = :default_job_priority,process_oc_type = :process_oc_type,"
					+ "queue = :queue,ics_bank_def_id = :ics_bank_def_id,repeating_type = :repeating_type,driver_type = :driver_type,manual_review_fulfillment = :manual_review_fulfillment,renewals = :renewals , bills =:bills ," + 
					"splits = :splits , inserts =:inserts,auto_renewals = :auto_renewals,sql_script =:sql_script,grace_new = :grace_new , grace_current = :grace_current,bundle_threshold = :bundle_threshold,output_sort = :output_sort WHERE process_id="+processModel.getProcessId()+ " ";

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("extract", processModel.getExtract() == "" ? null : processModel.getExtract());
			parameters.put("label_keyline",processModel.getLabelKeyline() == "" ? null:processModel.getLabelKeyline());
			parameters.put("label_group",processModel.getLabelGroup() == ""? null : processModel.getLabelGroup()); 
			parameters.put("description",processModel.getDescription());
			parameters.put("active", processModel.getStatus());
			parameters.put("label_length", processModel.getLabelLength());
			parameters.put("default_job_priority",processModel.getDefaultPriority());
			parameters.put("process_oc_type",processModel.getProcessOcType());
			parameters.put("queue", processModel.getDefaultQueue());
			parameters.put("ics_bank_def_id", processModel.getBankDefId());
			parameters.put("repeating_type",processModel.getRepeatingType());
			parameters.put("driver_type", processModel.getDriverType());
			parameters.put("manual_review_fulfillment", processModel.getManualReview());
			parameters.put("renewals", processModel.getRenewals());
			parameters.put("bills", processModel.getBills());
			parameters.put("splits", processModel.getSplits());
			parameters.put("inserts", processModel.getInserts());
			parameters.put("auto_renewals", processModel.getAutoRenewals());
			parameters.put("sql_script", processModel.getSqlScript() == "" ? null :processModel.getSqlScript());
			parameters.put("grace_new", processModel.getGraceNew());
			parameters.put("grace_current", processModel.getGraceCurrent());
			parameters.put("bundle_threshold", processModel.getBundleThreshold());
			parameters.put("output_sort",  processModel.getOutputSort()!=""?processModel.getOutputSort():null);
			
			namedParameterJdbcTemplate.update(processQuery, parameters);

			return "Saved";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public String saveRefundDetails(ProcessModel processModel) {
		LOGGER.info("Inside saveRefundDetails");
		try {

			String processQuery = "UPDATE PROCESS SET"
					+ " extract = :extract,description = :description,active = :active,default_job_priority = :default_job_priority,process_oc_type = :process_oc_type,"
					+ "queue = :queue,ics_bank_def_id = :ics_bank_def_id,repeating_type = :repeating_type,driver_type = :driver_type,all_oc = :all_oc,run_icverify = :run_icverify,"
					+ "process_deposit_payment = :process_deposit_payment WHERE process_id="+processModel.getProcessId()+ " ";

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("extract", processModel.getExtract() == ""?null:processModel.getExtract());
			parameters.put("description",processModel.getDescription());
			parameters.put("active", processModel.getStatus());
			parameters.put("default_job_priority",processModel.getDefaultPriority());
			parameters.put("process_oc_type",processModel.getProcessOcType());
			parameters.put("queue", processModel.getDefaultQueue());
			parameters.put("ics_bank_def_id", processModel.getBankDefId());
			parameters.put("repeating_type",processModel.getRepeatingType());
			parameters.put("driver_type", processModel.getDriverType());
			parameters.put("all_oc", processModel.getAllOc());
			parameters.put("run_icverify", processModel.getRunIcVerify());
			parameters.put("process_deposit_payment", processModel.getProcessDepositPayment());
			
			namedParameterJdbcTemplate.update(processQuery, parameters);

			return "Saved";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}

		
	}
	
	@Override
	public boolean addSelectedOrAllPC(String profitCenter,int processId) {

		LOGGER.info("Inside addSelectedOrAllPC");
		try {
			Map<String, Object> addProcessParams = new HashMap<>();     
			String profit_Center[] = String.valueOf(profitCenter).split(",");
			String addProcessQuery = null;
            for(int i=0;i<profit_Center.length;i++) {                        
             addProcessQuery = "insert into process_profit_center (process_id,profit_center) values "
            			+" (:process_id,:profit_center)";            			       					
            			addProcessParams.put("process_id",processId);	
            			addProcessParams.put("profit_center", profit_Center[i]);
            			 namedParameterJdbcTemplate.update(addProcessQuery, addProcessParams);
            }		        
           
			return true;
         
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
		
	}
	@Override

	public boolean clearSelectedAllPC(String profitCenter,int processId) {

		LOGGER.info("Inside clearSelectedAllPC");
		try {
			Map<String, Object> clearProcessParams = new HashMap<>();     
			String profit_center[] = String.valueOf(profitCenter).split(",");
			String clearProcessQuery = null;
            for(int i=0;i<profit_center.length;i++) {                        
            	   clearProcessQuery = "delete from process_oc where process_id =:process_id and profit_center =:profit_center";            			       					

                   clearProcessParams.put("process_id",processId);	
                   clearProcessParams.put("profit_center", profit_center[i]);
            	   namedParameterJdbcTemplate.update(clearProcessQuery, clearProcessParams);
            }		        
           
			return true;
         
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
		
	}
		
	/* Update for AuditGallery Details*/
	@Override
	public String auditGallerysaveDetails(ProcessModel processModel){
		LOGGER.info("inside UpdateAuditGalleryDetails");
		try {
			String processQueue="update process set" 
					+" description = :description,active = :active,default_job_priority = :default_job_priority, queue = :queue WHERE process_id="+processModel.getProcessId();

			
		Map<String,Object> parameters=new HashMap<>();
		parameters.put("description",processModel.getDescription());
		parameters.put("active",processModel.getStatus());
		parameters.put("default_job_priority",processModel.getDefaultPriority());
		parameters.put("queue", processModel.getDefaultQueue());
		
		namedParameterJdbcTemplate.update(processQueue, parameters);

		return "Saved";
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		return ERROR;
	  }

	}
	
	/* Update for CleanUp Details */
	@Override
	public String cleanUpsaveDetails(ProcessModel processModel) {
		LOGGER.info("Inside cleanUpDetails");
		try {
			
			String CleanUPQuery = "UPDATE PROCESS SET"
					+ " description = :description, active = :active, default_job_priority = :default_job_priority, repeating_type = :repeating_type  WHERE process_id="+processModel.getProcessId();
	
			Map<String, Object> parameters = new HashMap<>();
		
		parameters.put("description",processModel.getDescription());
		parameters.put("active", processModel.getStatus());
		parameters.put("default_job_priority",processModel.getDefaultPriority());
		//parameters.put("queue", processModel.getDefault_queue());
		parameters.put("repeating_type",processModel.getRepeatingType());
		
		namedParameterJdbcTemplate.update(CleanUPQuery, parameters);
		return "Saved";

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		return ERROR;
		}
	}
	
	/* credit-card-expiry-notify update details.*/

	@Override
	public String creditCardExpiryDetails(ProcessModel processModel) {
		LOGGER.info("Inside creditCardExpairyDetails");
		try {
			
			String ExpiryupdateQuery = "UPDATE PROCESS SET"
					+ " label_group = :label_group, label_keyline =:label_keyline,label_length = :label_length , extract = :extract,default_job_priority = :default_job_priority,queue = :queue,"
					+ "   repeating_type = :repeating_type,active =:active,description= :description WHERE process_id="+ processModel.getProcessId();
	
			Map<String, Object> parameters = new HashMap<>();
		
		parameters.put("label_group", processModel.getLabelGroup());
		parameters.put("label_keyline", processModel.getLabelKeyline());
		parameters.put("label_length", processModel.getLabelLength());
		parameters.put("extract", processModel.getExtract());
		parameters.put("default_job_priority",processModel.getDefaultPriority());
		parameters.put("queue", processModel.getDefaultQueue());
		parameters.put("repeating_type",processModel.getRepeatingType());
		parameters.put("active", processModel.getStatus());
		parameters.put("description",processModel.getDescription());
		
		namedParameterJdbcTemplate.update(ExpiryupdateQuery, parameters);
		return "Saved";

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		return ERROR;
		}
	}


	/* update details about Mass Kill*/
	
	@Override
	public String saveMasskillDetails(ProcessModel processModel) {
		LOGGER.info("Inside saveMassKillDetails");
		try {

			String UpdateQuery = "UPDATE PROCESS SET"
					+ " description = :description,active = :active,repeating_type = :repeating_type,default_job_priority =:default_job_priority,extract = :extract,process_oc_type = :process_oc_type,"
					+ "queue = :queue,output_sort =:output_sort ,grace_new =:grace_new,sql_script =:sql_script  WHERE process_id="+processModel.getProcessId();

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("description",processModel.getDescription());
			parameters.put("active", processModel.getStatus());
			parameters.put("repeating_type",processModel.getRepeatingType());
			parameters.put("extract", processModel.getExtract()==""?null: processModel.getExtract());
			parameters.put("output_sort", processModel.getOutputSort()==""?null:processModel.getOutputSort());
			parameters.put("default_job_priority",processModel.getDefaultPriority());
			parameters.put("process_oc_type",processModel.getProcessOcType());
			parameters.put("queue", processModel.getDefaultQueue());
			parameters.put("grace_new", processModel.getGraceNew());
			parameters.put("sql_script", processModel.getSqlScript()==""?null:processModel.getSqlScript());
			
			namedParameterJdbcTemplate.update(UpdateQuery, parameters);

			return "Saved";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}

		
	}


	@Override
	public String billRepeatingSave(ProcessModel processModel) {
		LOGGER.info("Inside billRepeatingSave");
		try {
			
			String billRepeatingSaveQuery = "UPDATE PROCESS SET"
					+ " interval_unit = :interval_unit, n_interval_units = :n_interval_units WHERE process_id="+processModel.getProcessId();
	
			Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("interval_unit",processModel.getIntervalUnit());
		parameters.put("n_interval_units", processModel.getnIntervalUnits());
		
		namedParameterJdbcTemplate.update(billRepeatingSaveQuery, parameters);
		return "Saved";

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		return ERROR;
		}
	}

	@Override
	public String billInstallmentSave(ProcessModel processModel) {
		LOGGER.info("Inside billInstallmentSave");
		String billIncludeAll=null;
		try {
			if(processModel.getIncludeAll()==1) {
				billIncludeAll = "UPDATE PROCESS SET"
					+ " all_installment_plans = 1   WHERE process_id="+processModel.getProcessId();					
		        jdbcTemplate.update(billIncludeAll);
		        String installmentPlanId[] = String.valueOf(processModel.getInstallmentPlanId()).split(",");
				String billInstallmentSaveQuery = null;				
				jdbcTemplate.update("delete from process_installment_plan where process_id="+processModel.getProcessId()+"");
	            for(int i=0;i<installmentPlanId.length;i++) { 
				billInstallmentSaveQuery = " insert into process_installment_plan(process_id,installment_plan_id) values "
						+ " (:process_id , :installment_plan_id )";
		
			    Map<String, Object> parameters = new HashMap<String, Object>();		
			    parameters.put("process_id",processModel.getProcessId());
			    parameters.put("installment_plan_id",installmentPlanId[i]);
			
			    namedParameterJdbcTemplate.update(billInstallmentSaveQuery, parameters);	
			 }return "Saved";
		     }else {
			billIncludeAll = "UPDATE PROCESS SET"
					+ " all_installment_plans = 0  WHERE process_id="+processModel.getProcessId();					
	        jdbcTemplate.update(billIncludeAll);	
			String installmentPlanId[] = String.valueOf(processModel.getInstallmentPlanId()).split(",");
			String billInstallmentSaveQuery = null;
			jdbcTemplate.update("delete from process_installment_plan where process_id="+processModel.getProcessId()+"");
            for(int i=0;i<installmentPlanId.length;i++) { 
			billInstallmentSaveQuery = "insert into process_installment_plan(process_id,installment_plan_id) values "
					+ " (:process_id , :installment_plan_id )";
	
		    Map<String, Object> parameters = new HashMap<String, Object>();		
		    parameters.put("process_id",processModel.getProcessId());
	    	parameters.put("installment_plan_id",installmentPlanId[i]);
		
		    namedParameterJdbcTemplate.update(billInstallmentSaveQuery, parameters);		
		    }
            return "Saved";
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		return ERROR;
		}
	}

	@Override
	public String massKillDefSave(ProcessModel processModel) {
		LOGGER.info("Inside massKillSave");
		try {
			
			String massKillUpdateQuery = "UPDATE PROCESS SET"
					+ " do_mass_kill = :do_mass_kill, do_mass_suspend =:do_mass_suspend,cancel_reason = :cancel_reason ,"
					+ " mass_kill_interval = :mass_kill_interval,mass_suspend_interval = :mass_suspend_interval"
					+ "  WHERE process_id="+ processModel.getProcessId();
			
			Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("do_mass_kill", processModel.getDoMassKill());
		parameters.put("do_mass_suspend", processModel.getDoMassSuspend());
		parameters.put("cancel_reason", processModel.getCancelReason());
		parameters.put("mass_kill_interval", processModel.getMassKillInterval());
		parameters.put("mass_suspend_interval",processModel.getMassSuspendInterval());
		
		namedParameterJdbcTemplate.update(massKillUpdateQuery, parameters);
		return "Saved";

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		return ERROR;
		}
	}
	
	/* Update Renewals details*/
	
	@Override
	public String saveRenewalsDetails(ProcessModel processModel) {
		LOGGER.info("Inside saveRenewalDetails");
		try {

			String UpdateQuery = "UPDATE PROCESS SET"
					+ " description = :description,active = :active,repeating_type = :repeating_type,default_job_priority =:default_job_priority,extract = :extract,"
					+ "queue = :queue,output_sort =:output_sort ,sql_script =:sql_script, auto_renewals =:auto_renewals ,label_length = :label_length ,label_group = :label_group,"
					+ "label_keyline =:label_keyline,renewals =:renewals WHERE process_id="+processModel.getProcessId();
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("description",processModel.getDescription());
			parameters.put("active", processModel.getStatus());
			parameters.put("repeating_type",processModel.getRepeatingType());
			parameters.put("default_job_priority",processModel.getDefaultPriority());
			parameters.put("extract", processModel.getExtract()==""?null: processModel.getExtract());
			parameters.put("queue", processModel.getDefaultQueue());
			parameters.put("output_sort", processModel.getOutputSort()==""?null: processModel.getOutputSort());
			parameters.put("sql_script", processModel.getSqlScript()==""?null: processModel.getSqlScript());
			parameters.put("label_length", processModel.getLabelLength());
			parameters.put("auto_renewals", processModel.getAutoRenewals());
			parameters.put("label_keyline", processModel.getLabelKeyline()==""?null:processModel.getLabelKeyline());
			parameters.put("label_group", processModel.getLabelGroup()==""?null:processModel.getLabelGroup());
			parameters.put("auto_renewals", processModel.getAutoRenewals());
			parameters.put("renewals", processModel.getRenewals());
			
			namedParameterJdbcTemplate.update(UpdateQuery, parameters);

			return "Saved";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public String autoRenewalDefSave(ProcessModel processModel) {
		LOGGER.info("Inside autoRenewalSave");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			String autoRenewalUpdateQuery = "UPDATE PROCESS SET"
					+ " schedule_payment_days = :schedule_payment_days"
					+ "  WHERE process_id="+ processModel.getProcessId();
			
		parameters.put("schedule_payment_days", processModel.getSchedulePaymentDays());
	
		namedParameterJdbcTemplate.update(autoRenewalUpdateQuery, parameters);
		return "Saved";

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		return ERROR;
		}
	}

	@Override
	public String renewalDefSave(ProcessModel processModel) {
		LOGGER.info("Inside renewalDefSave");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			
			String generateQuery = null;
			if(("true").equals(processModel.getGenerateSourceCode())) {
				generateQuery = "update renewal_def_oc set generate_source_code=1 where"
						+ " renewal_def='"+processModel.getRenewalDef()+"' and oc_id="+processModel.getOcId();
			}else {
			   generateQuery = "update renewal_def_oc set generate_source_code=0 where"
					+ " renewal_def='"+processModel.getRenewalDef()+"' and oc_id="+processModel.getOcId();
			}
			jdbcTemplate.update(generateQuery);
			
			String renewalUpdateQuery = "UPDATE PROCESS SET"
					+ " ren_grp_ren_to = :ren_grp_ren_to,ren_grp_oclass = :ren_grp_oclass,ren_grp_order = :ren_grp_order,"
					+ "ren_grp_currency = :ren_grp_currency,ren_grp_def = :ren_grp_def,nth_def = :nth_def,requal = :requal,"
					+ "generate_renew_offers = :generate_renew_offers,volume_group_id = :volume_group_id,incl_pkg_members = :incl_pkg_members"
					+ "  WHERE process_id="+ processModel.getProcessId();
			
		parameters.put("ren_grp_ren_to", processModel.getRenGrpRenTo());
		parameters.put("ren_grp_oclass", processModel.getRenGrpOclass());
		parameters.put("ren_grp_order", processModel.getRenGrpOrder());
		parameters.put("ren_grp_currency", processModel.getRenGroupCurrency());
		parameters.put("ren_grp_def", processModel.getRenGrpDef());
		parameters.put("nth_def", processModel.getNthDef() == "" ? null : processModel.getNthDef());
		parameters.put("requal", processModel.getRequal());
		parameters.put("generate_renew_offers", processModel.getGenerateRenewOffers());
		parameters.put("volume_group_id", processModel.getVolumeGroupId() == "" ? null : processModel.getVolumeGroupId());
		parameters.put("incl_pkg_members", processModel.getInclPkgMembers());
		
		namedParameterJdbcTemplate.update(renewalUpdateQuery, parameters);
		jdbcTemplate.update("update process set renewals=1 where process_id="+processModel.getProcessId()+ "");
		return "Saved";

	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		return ERROR;
		}
	}

	@Override
	public String addOCRenewalDef(String renewalDef,int ocId) {

		LOGGER.info("Inside addOCRenewalDef");
		try {
			Map<String, Object> addProcessParams = new HashMap<String,Object>();
			String addProcessQuery = null;                      
             addProcessQuery = "insert into renewal_def_oc (renewal_def,oc_id) values "
            			+" (:renewal_def,:oc_id)";            			       					
            			addProcessParams.put("renewal_def",renewalDef);	
            			addProcessParams.put("oc_id", ocId);
            			namedParameterJdbcTemplate.update(addProcessQuery, addProcessParams);	
            		        
			return "Inserted";
         
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}
	
	@Override
	public String deleteOCRenewaldef(String renewalDef,int ocID) {

		LOGGER.info("Inside deleteOCRenewalDef");
		try {
			Map<String, Object> deleteProcessParams = new HashMap<String,Object>();
			String deleteProcessQuery = null;                      
			deleteProcessQuery = "delete from renewal_def_oc where renewal_def=:renewal_def and oc_id=:oc_id ";            			       					
             deleteProcessParams.put("renewal_def",renewalDef);	
             deleteProcessParams.put("oc_id", ocID);
            			namedParameterJdbcTemplate.update(deleteProcessQuery, deleteProcessParams);	
            		        
			return "Deleted";
         
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
		
	}

	@Override
	public String addRenewalEffort(int processId, int effortNum, String renewalDef,int renewalDefTestSeq) {

		LOGGER.info("Inside addRenewalEffort");
		try {
			Map<String, Object> addEffortParams = new HashMap<String,Object>();
			String addProcessQuery = null;                      
             addProcessQuery = "insert into process_renewal_effort (process_id,renewal_def,effort_number,renewal_def_test_seq) values "
            			+" (:process_id,:renewal_def,:effort_number,:renewal_def_test_seq)"; 
             addEffortParams.put("process_id",processId);	
             addEffortParams.put("effort_number",effortNum);	
             addEffortParams.put("renewal_def", renewalDef);
             addEffortParams.put("renewal_def_test_seq", renewalDefTestSeq);
             
            namedParameterJdbcTemplate.update(addProcessQuery, addEffortParams);	
            		        
			return "Inserted";
         
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
		
	}
	
	@Override
	public String deleteRenewalEffort(int processId, int effortNum, String renewalDef,int renewalDefTestSeq) {

		LOGGER.info("Inside deleteRenewalEffort");
		try {
			Map<String, Object> deleteEffortParams = new HashMap<String,Object>();
			String deleteProcessQuery = null;                      
			deleteProcessQuery = "delete from process_renewal_effort where process_id=:process_id and effort_number=:effort_number "
					+ "and renewal_def=:renewal_def and renewal_def_test_seq=:renewal_def_test_seq";
            		 
			deleteEffortParams.put("process_id",processId);	
			deleteEffortParams.put("effort_number",effortNum);	
			deleteEffortParams.put("renewal_def", renewalDef);
			deleteEffortParams.put("renewal_def_test_seq", renewalDefTestSeq);
			
            namedParameterJdbcTemplate.update(deleteProcessQuery, deleteEffortParams);		        
			return "Deleted";
         
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
		
	}

	@Override

	public boolean billingSave(ProcessModel processModel) {
		LOGGER.info("Inside billingSave");
		try {

			String billingQuery = "update process set includes_proformas = :includes_proformas,bill_grp_bill_to = :bill_grp_bill_to ,bill_grp_currency =:bill_grp_currency,bill_grp_def =:bill_grp_def,bill_grp_oclass =:bill_grp_oclass, bill_grp_order =:bill_grp_order , nth_def = :nth_def "  
					+" where process_id ="+processModel.getProcessId()+" ";
					
			Map<String, Object> billingParams = new HashMap<String,Object>();	

			billingParams.put("includes_proformas", processModel.getIncludesProformas());
			billingParams.put("bill_grp_bill_to", processModel.getBillGrpBillTo());
			billingParams.put("bill_grp_currency", processModel.getBillGrpCurrency());
			billingParams.put("bill_grp_def", processModel.getBillGrpDef());
			billingParams.put("bill_grp_oclass", processModel.getBillGrpOclass());
			billingParams.put("bill_grp_order", processModel.getBillGrpOrder());
			billingParams.put("nth_def", processModel.getNthDef() == "" ? null : processModel.getNthDef());				
		    namedParameterJdbcTemplate.update(billingQuery, billingParams);
            
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean addBillingOc(int ocId, String billingDef) {
		LOGGER.info("Inside addBillingOc");
		try {			
			String addBillingOc = "insert into billing_def_oc (billing_def,oc_id) "
				    +" values ( :billing_def, :oc_id)";
			
			Map<String, Object> billingParams = new HashMap<String,Object>();	
			billingParams.put("billing_def", billingDef);
			billingParams.put("oc_id", ocId);
			namedParameterJdbcTemplate.update(addBillingOc, billingParams);
            
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean deleteBillingOC(int ocId, String billingDef) {
		LOGGER.info("Inside deleteBillingOC");
		try {			
			String deleteBillingOC ="delete from billing_def_oc where oc_id='"+ocId+"' and billing_def ='"+billingDef+"' ";			
			jdbcTemplate.update(deleteBillingOC);
            
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean addBillingEffort(int effortNum,int processId,String billingDef,int billingDefTestSeq) {
		LOGGER.info("Inside addBillingEffort");
		try {			
			String billingQuery = "insert into process_billing_effort (process_id,billing_def,billing_def_test_seq,effort_number) "
				    +" values ( :process_id, :billing_def, :billing_def_test_seq, :effort_number)";
			
			Map<String, Object> billingParams = new HashMap<String,Object>();	
			billingParams.put("process_id", processId);
			billingParams.put("billing_def", billingDef);
			billingParams.put("billing_def_test_seq", billingDefTestSeq);
			billingParams.put("effort_number",effortNum);
			namedParameterJdbcTemplate.update(billingQuery, billingParams);
            
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}
	
	@Override
	public boolean deleteBillingEffort(int effortNum,int processId,String billingDef) {
		LOGGER.info("Inside deleteBillingEffort");
		try {			
			String deleteBillingEffort ="delete from process_billing_effort where process_id='"+processId+"' and billing_def ='"+billingDef+"' and effort_number = '"+effortNum+"' ";			
			jdbcTemplate.update(deleteBillingEffort);
            
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean generateDefaultOutput(int processId) {
		LOGGER.info("Inside generateDefaultOutput");
		try {
			String billingQuery,installQuery=null;	
			List<Map<String, Object>> billingEffortList=null;
			List<Map<String, Object>> installmentPlanList=null;
			Map<String, Object> billingParams = new HashMap<>();
			jdbcTemplate.update("delete from process_output where process_id = '"+processId+"'");	
			billingQuery = "insert into process_output (process_id,process_output_seq,report,output_type,output_mode,output_step,def,test_seq,effort_number) "
				    +" values (:process_id,:process_output_seq,:report,:output_type,:output_mode,:output_step,:def,:test_seq,:effort_number)";
			
			billingEffortList=jdbcTemplate.queryForList("select * from process_billing_effort left join billing_def_effort on process_billing_effort.billing_def=billing_def_effort.billing_def " + 
					" and process_billing_effort.effort_number=billing_def_effort.effort_number where process_id=?", new Object[]{processId});
			for(Map<String,Object> map:billingEffortList){
			jdbcTemplate.update("update process set mru_process_output_seq = isnull(mru_process_output_seq,0) + 1 where process_id = '"+processId+"'");
			int seq= jdbcTemplate.queryForObject("select mru_process_output_seq from process where process_id = '"+processId+"'",Integer.class);
				
			billingParams.put("process_id", map.get("process_id").toString());
			billingParams.put("process_output_seq",seq);
			billingParams.put("report", map.get("report")!=""?(String)map.get("report"):null);
			billingParams.put("output_type",2);
			billingParams.put("output_mode",0);
			billingParams.put("output_step",1);
			billingParams.put("def",map.get("billing_def")!=""?(String)map.get("billing_def"):null);
			billingParams.put("test_seq",map.get("billing_def_test_seq")!=""?map.get("billing_def_test_seq"):null);
			billingParams.put("effort_number",map.get("effort_number")!=""?map.get("effort_number"):null);				
			namedParameterJdbcTemplate.update(billingQuery, billingParams);
			}
			installQuery="insert into process_output (process_id,process_output_seq,output_type,output_mode,output_step,installment_plan) "
				    +" values (:process_id,:process_output_seq,:output_type,:output_mode,:output_step,:installment_plan)";
			
			installmentPlanList=jdbcTemplate.queryForList("select * from process_installment_plan left join installment_plan on process_installment_plan.installment_plan_id=installment_plan.installment_plan_id " +
					 " where process_id=?", new Object[]{processId});
			for(Map<String,Object> map:installmentPlanList){
				jdbcTemplate.update("update process set mru_process_output_seq = isnull(mru_process_output_seq,0) + 1 where process_id = '"+processId+"'");
				int seq= jdbcTemplate.queryForObject("select mru_process_output_seq from process where process_id = '"+processId+"'",Integer.class);
					
				billingParams.put("process_id", map.get("process_id").toString());
				billingParams.put("process_output_seq",seq);
				billingParams.put("output_type",10);
				billingParams.put("output_mode",0);
				billingParams.put("output_step",1);
				billingParams.put("installment_plan",map.get("description").toString());			
				namedParameterJdbcTemplate.update(installQuery, billingParams);
				}
			return true;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public List<OutputModel> displayBillingOutput(int processId) {
		LOGGER.info("Inside displayBillingOutput");
		List<OutputModel> result = null;
		try {
			result = jdbcTemplate.query("select process_id,process_output_seq,output_type,oc.oc,process_output.report,output_mode,output_filename,append_job_id,cof.description as output_format,installment_plan,def,test_seq,effort_number,au.audit_report,param_values " + 
					" from process_output left join crystal_output_format cof on cof.crystal_output_format_id=process_output.crystal_output_format_id left join oc on oc.oc_id=process_output.oc_id left join audit_report au on au.audit_report_id=process_output.audit_report_id where process_id='"+processId+"'", new OutputMapper());
					
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public boolean saveBillingOutput(OutputModel outputModel) {
		LOGGER.info("Inside saveBillingOutput");
		try {
			String billingQuery;	
			Map<String, Object> billingParams = new HashMap<>();				
			billingQuery = "insert into process_output (process_id,process_output_seq,report,output_type,output_mode,output_filename,output_step,def,test_seq,effort_number,oc_id,audit_report_id,installment_plan,crystal_output_format_id,param_values,append_job_id) "
				    +" values (:process_id,:process_output_seq,:report,:output_type,:output_mode,:output_filename,:output_step,:def,:test_seq,:effort_number,:oc_id,:audit_report_id,:installment_plan,:crystal_output_format_id,:param_values,:append_job_id)";
						
			jdbcTemplate.update("update process set mru_process_output_seq = isnull(mru_process_output_seq,0) + 1 where process_id = '"+outputModel.getProcessId()+"'");
			int seq= jdbcTemplate.queryForObject("select mru_process_output_seq from process where process_id = '"+outputModel.getProcessId()+"'",Integer.class);
				
			billingParams.put("process_id", outputModel.getProcessId());
			billingParams.put("process_output_seq",seq);
			billingParams.put("report", outputModel.getOutput()!=""?outputModel.getOutput():null);			
			billingParams.put("output_type",outputModel.getOutputType());
			billingParams.put("output_mode",outputModel.getOutputMode());
			billingParams.put("output_filename", outputModel.getOutputFileName()!=""?outputModel.getOutputFileName():null);
			billingParams.put("output_step",1);
			billingParams.put("def",outputModel.getDef()!=""?outputModel.getDef():null);
			billingParams.put("test_seq",outputModel.getTestSeq()!=""?outputModel.getTestSeq(): null);
			billingParams.put("effort_number",outputModel.getEffortNumber()!=""?outputModel.getEffortNumber(): null);
			billingParams.put("oc_id", outputModel.getOc()!=""?outputModel.getOc():null);
			billingParams.put("audit_report_id", outputModel.getAuditReport()!=null?outputModel.getAuditReport():null);
			billingParams.put("installment_plan", outputModel.getInstallmentPlan()!=null?outputModel.getInstallmentPlan():null);
			billingParams.put("crystal_output_format_id", outputModel.getOutputFormat()!=null?outputModel.getOutputFormat():null);
			billingParams.put("param_values", outputModel.getParamValues()!=""?outputModel.getParamValues():null);
			billingParams.put("append_job_id", outputModel.getAppendJobId()!=0?outputModel.getAppendJobId():0);
			namedParameterJdbcTemplate.update(billingQuery, billingParams);	
			
			return true;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public String saveBackLabelDetails(ProcessModel processModel) {
		LOGGER.info("Inside saveBackLabelDetails");
		try {

			String processQuery = "UPDATE PROCESS SET"
					+ " extract = :extract,label_keyline = :label_keyline,label_group = :label_group,description = :description,active = :active,"
					+ "label_length = :label_length,default_job_priority = :default_job_priority,process_oc_type = :process_oc_type,"
					+ "queue = :queue,pick_list = :pick_list,repeating_type = :repeating_type,priority_sort = :priority_sort,manual_review_fulfillment = :manual_review_fulfillment,"
					+ "sql_script =:sql_script,grace_new = :grace_new , grace_current = :grace_current,bundle_threshold = :bundle_threshold,output_sort = :output_sort WHERE process_id="+processModel.getProcessId()+ " ";

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("extract", processModel.getExtract() == ""?null:processModel.getExtract());
			parameters.put("label_keyline",processModel.getLabelKeyline() == "" ? null : processModel.getLabelKeyline());
			parameters.put("label_group",processModel.getLabelGroup() == "" ? null : processModel.getLabelGroup()); 
			parameters.put("description",processModel.getDescription());
			parameters.put("active", processModel.getStatus());
			parameters.put("label_length", processModel.getLabelLength());
			parameters.put("default_job_priority",processModel.getDefaultPriority());
			parameters.put("process_oc_type",processModel.getProcessOcType());
			parameters.put("queue", processModel.getDefaultQueue());
			parameters.put("pick_list", processModel.getPickList());
			parameters.put("repeating_type",processModel.getRepeatingType());
			parameters.put("priority_sort", processModel.getPrioritySort() == "" ? null :processModel.getPrioritySort());
			parameters.put("manual_review_fulfillment", processModel.getManualReview());
			parameters.put("sql_script", processModel.getSqlScript()== "" ? null : processModel.getSqlScript());
			parameters.put("grace_new", processModel.getGraceNew());
			parameters.put("grace_current", processModel.getGraceCurrent());
			parameters.put("bundle_threshold", processModel.getBundleThreshold());
			parameters.put("output_sort", processModel.getOutputSort()== "" ? null : processModel.getOutputSort());
			
			namedParameterJdbcTemplate.update(processQuery, parameters);

			return "Saved";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}

	}

	@Override
	public String saveEmailNotification(ProcessModel processModel) {
		LOGGER.info("Inside saveEmailNotification");
		try {
			Map<String, Object> params = new HashMap<String,Object>();	
			String emailQuery = "update process set job_completion_email_address  = :job_completion_email_address"  
					+" where process_type = "+processModel.getProcessType()+" ";
					
			params.put("job_completion_email_address", processModel.getJobCompletionEmailAddress());

		    namedParameterJdbcTemplate.update(emailQuery, params);
            
			return "Updated";

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}
	
	@Override
	public boolean getSubmitJobSave(JobModel jobModel) {
		LOGGER.info("Inside getSubmitSave");
		try {
			Map<String, Object> submitJobParams = new HashMap<String,Object>();
			String submitJobQuery  = "insert into job (job_id,label_keyline, label_group, process_id, cutoff_date, drop_date, note, start_date_time, description, creation_date," + 
					"grace_new, grace_current, job_priority,back_issues_on_reinstated, queue, force_repeat, auto_renewals, " + 
					"user_code, repeating_type, interval_unit, n_interval_units," + 
					"job_completion_email_address, log_option, manual_review_fulfillment, status, step_number, step_name,  hold_bits," + 
					"generate_renew_offers, incl_pkg_members,select_start_date,select_end_date, n_updated_records, n_selected_records) "
					+ "values (:job_id,:label_keyline,:label_group,:process_id, :cutoff_date, :drop_date,:note, :start_date_time, :description, :creation_date,:grace_new, :grace_current, :job_priority, "
					+ ":back_issues_on_reinstated, :queue, :force_repeat, :auto_renewals ,:user_code,:repeating_type,:interval_unit,:n_interval_units,:job_completion_email_address,:log_option,:manual_review_fulfillment,"
					+ ":status,:step_number,:step_name,:hold_bits,:generate_renew_offers,:incl_pkg_members, :select_start_date, :select_end_date, :n_updated_records,:n_selected_records);" ; 
			
			int processId = jobModel.getProcessId();
		    String jobQueue = jobModel.getQueue();
		    
		    int areYouDead = jdbcTemplate.queryForObject("SELECT are_you_dead FROM job_running WHERE description = "+ "'"+jobQueue+"'", Integer.class);
		    if(areYouDead == 0) {
		    	jdbcTemplate.update("update job_running set are_you_dead = 1 where description ='"+jobQueue+"'");
		    }
			
		    int jodId = jdbcTemplate.queryForObject("select max(job_id) from job", Integer.class);
			
		    int id = jdbcTemplate.queryForObject("select id from mru_job_id", Integer.class);
			
		    jdbcTemplate.update("update mru_job_id set id = "+ (id + 1));
			
		    List<Map<String, Object>> processQuery = jdbcTemplate.queryForList("select description,job_completion_email_address,repeating_type,interval_unit,n_interval_units,auto_renewals from process where process_id="+processId);
			for(Map<String, Object> result: processQuery) {	
			int jobHold    = jobModel.getHoldJob() ;
			int holdOutput = jobModel.getHoldOutput();
			int holdUpdate = jobModel.getHoldUpdate();
			int holdBit = jobHold + holdOutput + holdUpdate;
			submitJobParams.put("job_id",(jodId+1));
			submitJobParams.put("label_keyline", jobModel.getLabelKeyline());
			submitJobParams.put("label_group", jobModel.getLabelGroup());
			submitJobParams.put("process_id", jobModel.getProcessId());
			submitJobParams.put("cutoff_date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			submitJobParams.put("drop_date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			submitJobParams.put("note", jobModel.getNote());
			submitJobParams.put("start_date_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			submitJobParams.put("description", jobModel.getDescription());
			submitJobParams.put("creation_date",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			submitJobParams.put("grace_new", result.get("grace_new")!=null ?result.get("grace_new"):0);
			submitJobParams.put("grace_current",result.get("grace_current")!=null ?result.get("grace_current"):0);
			submitJobParams.put("job_priority", jobModel.getDefaultPriority());
			submitJobParams.put("queue", jobModel.getQueue());
			submitJobParams.put("force_repeat", 0);
			submitJobParams.put("auto_renewals", jobModel.getAutoRenewals());
			submitJobParams.put("user_code", "THK");
			submitJobParams.put("repeating_type", result.get("repeating_type"));
			submitJobParams.put("interval_unit", result.get("interval_unit"));
			submitJobParams.put("n_interval_units",result.get("n_interval_units"));
			submitJobParams.put("job_completion_email_address",result.get("job_completion_email_address"));
			submitJobParams.put("interval_unit", result.get("interval_unit"));
			submitJobParams.put("auto_renewals", result.get("auto_renewals"));
			submitJobParams.put("log_option", jobModel.getLogOption());
			submitJobParams.put("manual_review_fulfillment", 0);
		    if(holdBit!=0) {
		    	submitJobParams.put("status", 1);
		    }else {
		    	submitJobParams.put("status", 0);
		    }
			submitJobParams.put("step_number", 0);
			submitJobParams.put("step_name", "select");
			submitJobParams.put("hold_bits", holdBit);
			submitJobParams.put("generate_renew_offers",  jobModel.getGenerateRenewOffers());
			submitJobParams.put("incl_pkg_members", result.get("incl_pkg_members"));
			submitJobParams.put("back_issues_on_reinstated", jobModel.getBackIssuesOnReinstated());
			submitJobParams.put("select_start_date", jobModel.getSelectStartDate());
			submitJobParams.put("select_end_date", jobModel.getSelectEndDate());
			submitJobParams.put("n_updated_records", 0);
			submitJobParams.put("n_selected_records", 0);
			submitJobParams.put("force_repeat", 1);
			}
			namedParameterJdbcTemplate.update(submitJobQuery, submitJobParams)	;
			return true;
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean addPaymentType(int processId, String paymentType) {
		LOGGER.info("Inside addPaymentType");
		try {			
			String paymenTypeQuery = "insert into process_pay_type_ccard (process_id,payment_type) "
				    +" values ( :process_id, :payment_type)";
			
			Map<String, Object> pymtTypeParams = new HashMap<String,Object>();	
			pymtTypeParams.put("process_id", processId);
			pymtTypeParams.put("payment_type", paymentType);
			namedParameterJdbcTemplate.update(paymenTypeQuery, pymtTypeParams);
			
			return true;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean addCurrency(int processId, String currency) {
		LOGGER.info("Inside addCurrency");
		try {			
			String currencyQuery = "insert into process_currency_relator (process_id,currency) "
				    +" values ( :process_id, :currency)";
			
			Map<String, Object> currencyParams = new HashMap<String,Object>();	
			currencyParams.put("process_id", processId);
			currencyParams.put("currency", currency);
			namedParameterJdbcTemplate.update(currencyQuery, currencyParams);
            
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}
	
	@Override
	public boolean clearPaymentType(int processId, String paymentType) {
		LOGGER.info("Inside clearPaymentType");
		try {			
			String clearPymtType ="delete from process_pay_type_ccard where process_id="+processId+" and payment_type ='"+paymentType+"'";			
			jdbcTemplate.update(clearPymtType);
            
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}
	
	@Override
	public boolean clearCurrency(int processId, String currency) {
		LOGGER.info("Inside clearCurrency");
		try {			
			String deleteBillingOC ="delete from process_currency_relator where process_id="+processId+" and currency ='"+currency+"'";			
			jdbcTemplate.update(deleteBillingOC);
            
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean generateRenewalSourceCode(int ocId, String renewalDef) {
		LOGGER.info("Inside addRenewalSourceCode");
		try {			
			String currencyQuery = "update renewal_def_oc set generate_source_code=1 where"
					+ " renewal_def='"+renewalDef+"' and oc_id="+ocId;
			jdbcTemplate.update(currencyQuery);
            
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}
	
	@Override
	public boolean editBillingOutput(OutputModel outputModel) {
		LOGGER.info("Inside editBillingOutput");
		try {
			String billingOutput;	
			Map<String, Object> billingOutputParams = new HashMap<>();				
			billingOutput = "update process_output set report = :report,output_type = :output_type,output_mode = :output_mode,output_filename = :output_filename, "
					+ " def = :def,test_seq = :test_seq,effort_number = :effort_number,oc_id = :oc_id,audit_report_id =:audit_report_id,installment_plan =:installment_plan,crystal_output_format_id =:crystal_output_format_id ,param_values =:param_values , append_job_id = :append_job_id "
					+ " where process_id='"+outputModel.getProcessId()+"' and process_output_seq='"+outputModel.getProcessOutputSeq()+"'";
			
			billingOutputParams.put("report", outputModel.getOutput()!=null?outputModel.getOutput():null);			
			billingOutputParams.put("output_type",outputModel.getOutputType()!=null?outputModel.getOutputType():null);
			billingOutputParams.put("output_mode",outputModel.getOutputMode()!=null?outputModel.getOutputMode():null);
			billingOutputParams.put("output_filename", outputModel.getOutputFileName()!=null?outputModel.getOutputFileName():null);
			billingOutputParams.put("def",outputModel.getDef()!=""?outputModel.getDef():null);
			billingOutputParams.put("test_seq",outputModel.getTestSeq()!=""?outputModel.getTestSeq(): null);
			billingOutputParams.put("effort_number",outputModel.getEffortNumber()!=""?outputModel.getEffortNumber(): null);
			billingOutputParams.put("oc_id", outputModel.getOc()!=""?outputModel.getOc():null);
			billingOutputParams.put("audit_report_id", outputModel.getAuditReport()!=""?outputModel.getAuditReport():null);
			billingOutputParams.put("installment_plan", outputModel.getInstallmentPlan()!=""?outputModel.getInstallmentPlan():null);
			billingOutputParams.put("crystal_output_format_id", outputModel.getOutputFormat()!=""?outputModel.getOutputFormat():null);
			billingOutputParams.put("param_values", outputModel.getParamValues()!=""?outputModel.getParamValues():null);
			billingOutputParams.put("append_job_id", outputModel.getAppendJobId()!=0?outputModel.getAppendJobId():0);
			namedParameterJdbcTemplate.update(billingOutput, billingOutputParams);	
			
			return true;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean saveOutput(OutputModel outputModel) {
		LOGGER.info("Inside saveOutput");
		try {
			String saveOutputQuery;	
			Map<String, Object> outputParams = new HashMap<>();				
			saveOutputQuery = "insert into report (report,description,filename,output_filename,output_mode,crystal_output_format_id) "
				    +" values (:report,:description,:filename,:output_filename,:output_mode,:crystal_output_format_id)";
				
			outputParams.put("report", outputModel.getOutput());			
			outputParams.put("description",outputModel.getDescription()!=null?outputModel.getDescription():null);
			outputParams.put("filename",outputModel.getFilename()!=null?outputModel.getFilename():null);
			outputParams.put("output_filename", outputModel.getOutputFileName()!=null?outputModel.getOutputFileName():null);
			outputParams.put("output_mode",outputModel.getOutputMode()!=null?outputModel.getOutputMode():null);
			outputParams.put("crystal_output_format_id", outputModel.getOutputFormat()!=null?outputModel.getOutputFormat():null);
			namedParameterJdbcTemplate.update(saveOutputQuery, outputParams);	
			
			return true;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean editOutput(OutputModel outputModel) {
		LOGGER.info("Inside editOutput");
		try {
			String editOutput;	
			Map<String, Object> editOutputParams = new HashMap<>();				
			editOutput = "update report set description = :description,filename = :filename,output_mode = :output_mode,output_filename = :output_filename, "
					+ " crystal_output_format_id =:crystal_output_format_id  where report='"+outputModel.getOutput()+"'";
			
			editOutputParams.put("description",outputModel.getDescription()!=null?outputModel.getDescription():null);
			editOutputParams.put("output_mode",outputModel.getOutputMode()!=null?outputModel.getOutputMode():null);
			editOutputParams.put("output_filename", outputModel.getOutputFileName()!=null?outputModel.getOutputFileName():null);
			editOutputParams.put("filename",outputModel.getFilename()!=""?outputModel.getFilename():null);
			editOutputParams.put("crystal_output_format_id", outputModel.getOutputFormat()!=null?outputModel.getOutputFormat():null);
			namedParameterJdbcTemplate.update(editOutput, editOutputParams);	
			
			return true;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public String saveQueue(String queue, String description) {
		LOGGER.info("Inside saveQueue ");
		try {
			int queue1 = jdbcTemplate.queryForObject("select count(queue) from queue where queue="+"'"+queue+"'", Integer.class);
			if(queue1 ==0){
			String saveQueueQuery = "insert into queue(queue,description)values(:queue,:description)";
			Map<String,Object> queueParam = new HashMap<>();
			queueParam.put("queue", queue);
			queueParam.put("description", description);
			namedParameterJdbcTemplate.update(saveQueueQuery, queueParam);
			return "queueSave";
			}else {
				return "duplicate";	
			}
			
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
 			return "Error";
		}
	}

	@Override
	public boolean addRenewalSourceCode(int ocId, String renewalDef) {
		LOGGER.info("Inside addRenewalSourceCode");
		try {			
			String currencyQuery = "update renewal_def_oc set generate_source_code=1 where"
					+ " renewal_def='"+renewalDef+"' and oc_id="+ocId;
			jdbcTemplate.update(currencyQuery);
            
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}
	
	@Override
	public boolean genearteBillingCode(int ocId, String billingDef) {
			LOGGER.info("Inside genearteBillingCode");
			try {			
				String currencyQuery = "update billing_def_oc set generate_billing_code=1 where"
						+ " billing_def='"+billingDef+"' and oc_id="+ocId;
				jdbcTemplate.update(currencyQuery);
				return true;
			} catch (Exception e) {
				LOGGER.error(ERROR + e);
				return false;
			}
		}

	@Override
	public boolean updateQueue(String queue, String description) {
		LOGGER.info("Inside updateQueue");
		Map<String, Object> updateQueueParam = new HashMap<>();
		try {
			String updateQueueQuery = "update queue set description = :description where queue="+"'"+queue+"'";
			updateQueueParam.put("description", description);
			namedParameterJdbcTemplate.update(updateQueueQuery, updateQueueParam);
			return true;
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
		
	}

	@Override
	public String addNewRenewalDef(RenewalModel renewalModel) {
		LOGGER.info("Inside addNewRenewalDef");
		try {
			int chkDuplicate = jdbcTemplate.queryForObject("select count(*) from renewal_def where renewal_def='"+renewalModel.getRenewalDef()+"'", Integer.class);
			if(chkDuplicate !=1) {
			Map<String, Object> result = new HashMap<>();				
			String addRenewalDefQuery  = "insert into renewal_def (renewal_def,description,renewal_type,extract,mru_renewal_def_test_seq) "
				    +" values (:renewal_def,:description,:renewal_type,:extract,:mru_renewal_def_test_seq)";
			
			String addRenTestingQuery  = "insert into renewal_def_test (renewal_def,renewal_def_test_seq,description) "
				    +" values (:renewal_def,:renewal_def_test_seq,:testDescription)";
				
			result.put("renewal_def", renewalModel.getRenewalDef());			
			result.put("description",renewalModel.getDescription()!=""?renewalModel.getDescription():null);
			result.put("renewal_type",renewalModel.getRenewalType()!=""?renewalModel.getRenewalType():null);
			result.put("extract",renewalModel.getExtract()!=""?renewalModel.getExtract():null);
			result.put("mru_renewal_def_test_seq", 1);
				
			result.put("renewal_def_test_seq",1);
			result.put("testDescription","Control");
			
			namedParameterJdbcTemplate.update(addRenewalDefQuery, result);	
			namedParameterJdbcTemplate.update(addRenTestingQuery, result);	
			
			return "Added";
			}
			else {
				return "Duplicate";
			}
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public String addNewRenewalEffort(RenewalEffortModel renewalEffortModel) {
		LOGGER.info("Inside addNewRenewalEffort");
		try {
			int chkDuplicate = jdbcTemplate.queryForObject("select count(*) from renewal_def_effort where renewal_def='"+renewalEffortModel.getRenewal_def()+"' and renewal_def_test_seq="+renewalEffortModel.getRenewalDefTestSeq()+" and effort_number="+renewalEffortModel.getEffortNumber(), Integer.class);
			if(chkDuplicate == 0) {
			Map<String, Object> result = new HashMap<>();			
			String addRenewalDefQuery  = "insert into renewal_def_effort (renewal_def,effort_number,renewal_def_test_seq,process_method,number_of_units,effort_type,send_to,pricing_date,report,attachment_code,message_string,suppress_email) "
				    +" values (:renewal_def,:effort_number,:renewal_def_test_seq,:process_method,:number_of_units,:effort_type,:send_to,:pricing_date,:report,:attachment_code,:message_string,:suppress_email)";
				
			result.put("renewal_def", renewalEffortModel.getRenewal_def());
			result.put("effort_number", renewalEffortModel.getEffortNumber());
			result.put("renewal_def_test_seq",renewalEffortModel.getRenewalDefTestSeq());
			result.put("process_method",renewalEffortModel.getProcessMethod());
			result.put("number_of_units",renewalEffortModel.getNumberOfUnits());
			result.put("effort_type",renewalEffortModel.getEffortType());
			result.put("send_to", renewalEffortModel.getSendTo());
			result.put("pricing_date", renewalEffortModel.getPricingDate());
			result.put("report", renewalEffortModel.getReport());
			result.put("attachment_code", renewalEffortModel.getAttachmentCode()!=""?renewalEffortModel.getAttachmentCode():null);
			result.put("message_string", renewalEffortModel.getMessageString()!=""?renewalEffortModel.getMessageString():null);
			result.put("suppress_email", renewalEffortModel.getSuppressEmail());
			namedParameterJdbcTemplate.update(addRenewalDefQuery, result);
			
			return "Added";
			}
			else {
				return "Duplicate";
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public boolean addTesting(String billingDef, String description, String nthDef) {
		LOGGER.info("Inside addTesting");
		try {
			String addTesting;	
			Map<String, Object> testingParams = new HashMap<>();				
			addTesting = "insert into billing_def_test (billing_def,billing_def_test_seq,nth_def,description) "
				    +" values (:billing_def,:billing_def_test_seq,:nth_def,:description)";
						
			jdbcTemplate.update("update billing_def set mru_billing_def_test_seq = mru_billing_def_test_seq + 1 where billing_def = '"+billingDef+"'");
			int seq= jdbcTemplate.queryForObject("select mru_billing_def_test_seq from billing_def where billing_def ='"+billingDef+"'",Integer.class);
				
			testingParams.put("billing_def", billingDef);
			testingParams.put("billing_def_test_seq",seq);
			testingParams.put("nth_def", nthDef!=""?nthDef:null);			
			testingParams.put("description",description!=""?description:null);
			
			namedParameterJdbcTemplate.update(addTesting, testingParams);	
			
			return true;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean addBillDefinition(String billingDef, String description, String extract) {
		LOGGER.info("Inside addBillDefinition");
		try {
			String addBillDefinition, addBillingTestQuery ;	
			Map<String, Object> addParams = new HashMap<>();				
			addBillDefinition = "insert into billing_def (billing_def,extract,description,mru_billing_def_test_seq,active_testing) "
				    +" values (:billing_def,:extract,:description,:mru_billing_def_test_seq,:active_testing)";
			addParams.put("extract",extract!=""?extract:null);
			addParams.put("billing_def", billingDef);
			addParams.put("description", description!=""?description:null);			
			addParams.put("active_testing", 0);
			int seq=jdbcTemplate.queryForObject("select max(billing_def_test_seq) from billing_def_test_seq where billing_def="+billingDef, Integer.class);
			addParams.put("mru_billing_def_test_seq",1);
			
			namedParameterJdbcTemplate.update(addBillDefinition, addParams);	
			

			List<Map<String,Object>> deatils=jdbcTemplate.queryForList("select billing_def,mru_billing_def_test_seq from billing_def where billing_def='"+billingDef+"'");
			for(Map<String,Object> result:deatils) {
				addBillingTestQuery  = "insert into billing_def_test (billing_def,billing_def_test_seq,description,nth_def) "
					    +" values (:billing_def,:billing_def_test_seq,:testDescription,:nth_def)";
				
				addParams.put("billing_def", result.get("billing_def"));
				addParams.put("billing_def_test_seq",1);
				addParams.put("testDescription","Control");	
				addParams.put("nth_def",null);	

				namedParameterJdbcTemplate.update(addBillingTestQuery, addParams);

			}
			return true;
			
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean addBillingEfforts(EffortModel effortModel) {
		LOGGER.info("Inside addBillingEffort");
		try {			
			String billingEfforts = "insert into billing_def_effort (billing_def,billing_def_test_seq,effort_number,interval,action,send_bill,send_to,attachment_code,message_string,process_method,report,suppress_email) "
				    +" values (:billing_def,:billing_def_test_seq,:effort_number,:interval,:action,:send_bill,:send_to,:attachment_code,:message_string,:process_method,:report,:suppress_email)";
			
			Map<String, Object> billingEffortsParams = new HashMap<String,Object>();	
			billingEffortsParams.put("billing_def", effortModel.getBillingDef());
			billingEffortsParams.put("billing_def_test_seq", effortModel.getBillingDefTestSeq());
			billingEffortsParams.put("effort_number", effortModel.getEffortNumber());			
			billingEffortsParams.put("interval",effortModel.getInterval()!=""?effortModel.getInterval():null);
			billingEffortsParams.put("action",effortModel.getAction());
			billingEffortsParams.put("send_bill",effortModel.getSendBill());
			billingEffortsParams.put("send_to",effortModel.getSendTo());
			billingEffortsParams.put("attachment_code",effortModel.getAttachmentCode()!=""?effortModel.getAttachmentCode():null);
			billingEffortsParams.put("message_string",effortModel.getMessageString()!=""?effortModel.getMessageString():null);
			billingEffortsParams.put("process_method",effortModel.getProcessMethod());
			billingEffortsParams.put("report",effortModel.getReport()!=""?effortModel.getReport():null);
			billingEffortsParams.put("suppress_email",effortModel.getSuppressEmail());			
			namedParameterJdbcTemplate.update(billingEfforts, billingEffortsParams);           
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		} 
	}

	@Override
	public String checkDuplicateEffort(EffortModel effortModel) {
		LOGGER.info("Inside checkDuplicateEffort");
		try {			
		int count= jdbcTemplate.queryForObject("select count(*) from  billing_def_effort where billing_def='"+effortModel.getBillingDef()+"' and billing_def_test_seq="+effortModel.getBillingDefTestSeq()+" and effort_number='"+effortModel.getEffortNumber()+"'",Integer.class);
		if(count==1)return "1";else return "0";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return "false";
		}
	}

	@Override
	public boolean generateRenewalOutput(int processId) {
		LOGGER.info("Inside generateRenewalOutput");
		try {	
			jdbcTemplate.update("delete from process_output where process_id = "+processId+"");	
			
			List<Map<String,Object>> effDetails = jdbcTemplate.queryForList("SELECT effort_number,renewal_def FROM process_renewal_effort WHERE process_id = "+processId+" and"
					+ " renewal_def_test_seq = 1 ORDER BY effort_number");
			
			Map<String, Object> result = new HashMap<String,Object>();
	
			for(Map<String, Object> map:effDetails) {
			   
			 int outputSeq=jdbcTemplate.queryForObject("select mru_process_output_seq from process where process_id = "+processId, Integer.class);
				 
			 String renOutput = "insert into process_output (process_id,process_output_seq,def,effort_number,output_mode,output_step,output_type,test_seq) "
						    +" values (:process_id,:process_output_seq,:def,:effort_number,:output_mode,:output_step,:output_type,:test_seq)";
					 
				 result.put("process_id",processId);
				 result.put("process_output_seq",outputSeq+1);
				 result.put("def",map.get("renewal_def"));
				 result.put("effort_number",map.get("effort_number"));
			     result.put("output_mode",0);
			     result.put("output_step",1);
			     result.put("output_type",1);
			     result.put("test_seq",1);
			
			    namedParameterJdbcTemplate.update(renOutput, result);  
				String processOutputSeq = "update process set mru_process_output_seq = "+(outputSeq+1)+" where process_id = "+processId;
			    jdbcTemplate.update(processOutputSeq);
			 }
		
			return true;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		} 
	}

	@Override
	public String saveAccountingReconciliation(ProcessModel processModel) {
		LOGGER.info("Inside saveAccountingReconciliation");
		try {

			String processQuery = "UPDATE PROCESS SET"
					+ " description = :description,active = :active,default_job_priority = :default_job_priority,queue = :queue,"
					+ "	upd_recon_tables = :upd_recon_tables,recon_work_dir = :recon_work_dir"
					+ " WHERE process_id="+processModel.getProcessId()+ " ";

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("description",processModel.getDescription());
			parameters.put("active", processModel.getStatus());
			parameters.put("default_job_priority",processModel.getDefaultPriority());
			parameters.put("queue", processModel.getDefaultQueue());
			parameters.put("upd_recon_tables", processModel.getUpdReconTables());
			parameters.put("recon_work_dir",processModel.getWorkDir() != ""?processModel.getWorkDir():null);
			
			namedParameterJdbcTemplate.update(processQuery, parameters);

			return "Saved";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}

		
	}

	@Override
	public boolean selectAllPCSave(String profitCenter, int processId) {

		LOGGER.info("Inside selectAllPCSave");
		try {
			Map<String, Object> addProcessParams = new HashMap<>();     
			String prCenter[] = String.valueOf(profitCenter).split(",");
			String addProcessQuery = null;
            for(int i=0;i<prCenter.length;i++) {                        
             addProcessQuery = "insert into process_profit_center (process_id,profit_center) values "
            			+" (:process_id,:profit_center)";            			       					
            			addProcessParams.put("process_id",processId);	
            			addProcessParams.put("profit_center", prCenter[i]);
            			namedParameterJdbcTemplate.update(addProcessQuery, addProcessParams);	
            }		        
			return true;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean clearAllPC(String profitCenter, int processId) {

		LOGGER.info("Inside clearAllPC");
		try {
			Map<String, Object> clearProcessParams = new HashMap<>();     
			String prCenter[] = String.valueOf(profitCenter).split(",");
			String clearProcessQuery = null;
            for(int i=0;i<prCenter.length;i++) {                        
             clearProcessQuery = "delete from process_profit_center where process_id =:process_id and profit_center =:profit_center";            			       					
                  clearProcessParams.put("process_id",processId);	
                  clearProcessParams.put("profit_center", prCenter[i]);
            			namedParameterJdbcTemplate.update(clearProcessQuery, clearProcessParams);
            }		        
			return true;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
		
	}

	@Override
	public String checkDuplicateBillDefinition(String billingDef) {
		LOGGER.info("Inside checkDuplicateBillDefinition");
		try {			
		int count= jdbcTemplate.queryForObject("select count(*) from billing_def where billing_def='"+billingDef+"'",Integer.class);
		if(count==1)return "1";else return "0";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return "false";
		}
	}

	@Override
	public String editRenewalDef(RenewalModel renewalModel) {
		LOGGER.info("Inside editRenewalDef");
		try {
		
			Map<String, Object> result = new HashMap<>();				
			String editRenewalDefQuery  = "update renewal_def set description = :description,renewal_type = :renewal_type"
					+ ",extract = :extract where renewal_def='"+renewalModel.getRenewalDef()+"'";
							
			result.put("description",renewalModel.getDescription()!=""?renewalModel.getDescription():null);
			result.put("renewal_type",renewalModel.getRenewalType()!=""?renewalModel.getRenewalType():0);
			result.put("extract",renewalModel.getExtract()!=""?renewalModel.getExtract():null);
			
			namedParameterJdbcTemplate.update(editRenewalDefQuery, result);	
			
			return "Updated";
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public String editRenewalEffort(RenewalEffortModel renewalEffortModel) {
		LOGGER.info("Inside editRenewalEffort");
		try {
			int chkInJob = jdbcTemplate.queryForObject("select count(*) from job_renewal_effort where renewal_def='"+renewalEffortModel.getRenewal_def()+"'"
					+ " and renewal_def_test_seq="+renewalEffortModel.getRenewalDefTestSeq()+" and effort_number="+renewalEffortModel.getPreviousEffNumber(), Integer.class);
			if(chkInJob == 0) {
				
			int chkDuplicate = jdbcTemplate.queryForObject("select count(*) from renewal_def_effort where renewal_def='"+renewalEffortModel.getRenewal_def()+"' "
					+ "and renewal_def_test_seq="+renewalEffortModel.getRenewalDefTestSeq()+" and effort_number="+renewalEffortModel.getPreviousEffNumber(), Integer.class);
			
			int chkDupInProcess = jdbcTemplate.queryForObject("select count(*) from process_renewal_effort" + 
					" where renewal_def='"+renewalEffortModel.getRenewal_def()+"' and renewal_def_test_seq="+renewalEffortModel.getRenewalDefTestSeq()+" and effort_number="+renewalEffortModel.getPreviousEffNumber()+ ""
							+ " and process_id="+renewalEffortModel.getProcessId(), Integer.class);
			
			Map<String, Object> result = new HashMap<>();
			String editRenewalEffortQuery=null ;
			String editRenewalEffInProcess=null;
			if(chkDuplicate == 0) {
				editRenewalEffortQuery  = "update renewal_def_effort set effort_number=:effort_number,process_method=:process_method,number_of_units=:number_of_units,"
					+ "effort_type=:effort_type,send_to=:send_to,pricing_date=:pricing_date,report=:report,attachment_code=:attachment_code,message_string=:message_string,"
					+ "suppress_email=:suppress_email where renewal_def='"+renewalEffortModel.getRenewal_def()+"' and renewal_def_test_seq="+renewalEffortModel.getRenewalDefTestSeq()+" and"
					+ " effort_number="+renewalEffortModel.getPreviousEffNumber()+"";
				
				 if(chkDupInProcess == 1) {
			    	  editRenewalEffInProcess = "update process_renewal_effort set effort_number=:effort_number where renewal_def='"+renewalEffortModel.getRenewal_def()+"'"
			    	  		+ " and renewal_def_test_seq="+renewalEffortModel.getRenewalDefTestSeq()+" and effort_number="+renewalEffortModel.getPreviousEffNumber()+" and process_id="+renewalEffortModel.getProcessId();
			       }
			}
			else if(chkDuplicate == 1) {
				editRenewalEffortQuery  = "update renewal_def_effort set process_method=:process_method,number_of_units=:number_of_units,"
						+ "effort_type=:effort_type,send_to=:send_to,pricing_date=:pricing_date,report=:report,attachment_code=:attachment_code,message_string=:message_string,"
						+ "suppress_email=:suppress_email where renewal_def='"+renewalEffortModel.getRenewal_def()+"' and renewal_def_test_seq="+renewalEffortModel.getRenewalDefTestSeq()+" and"
						+ " effort_number="+renewalEffortModel.getEffortNumber()+"";
			}
			
			result.put("effort_number", renewalEffortModel.getEffortNumber());			
			result.put("process_method",renewalEffortModel.getProcessMethod());
			result.put("number_of_units",renewalEffortModel.getNumberOfUnits());
			result.put("effort_type",renewalEffortModel.getEffortType());
			result.put("send_to", renewalEffortModel.getSendTo());
			result.put("pricing_date", renewalEffortModel.getPricingDate());
			result.put("report", renewalEffortModel.getReport());
			result.put("attachment_code", renewalEffortModel.getAttachmentCode()!=""?renewalEffortModel.getAttachmentCode():null);
			result.put("message_string", renewalEffortModel.getMessageString()!=""?renewalEffortModel.getMessageString():null);
			result.put("suppress_email", renewalEffortModel.getSuppressEmail());
			
			namedParameterJdbcTemplate.update(editRenewalEffortQuery, result);
			 if(chkDupInProcess == 1) {
			namedParameterJdbcTemplate.update(editRenewalEffInProcess, result);
			 }
			return "updated";	
			}else {
				return "Cannot Update, effort is in use!";
			}
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public boolean editBillingDef(String billingDef, String description, String extract) {
		LOGGER.info("Inside editBillingDef");
		try {
			Map<String, Object> result = new HashMap<>();				
			String editBillingDefQuery  = "update billing_def set description = :description ,extract = :extract where billing_def='"+billingDef+"'";
							
			result.put("description",description!=""?description:null);			
			result.put("extract",extract!=""?extract:null);
			
			namedParameterJdbcTemplate.update(editBillingDefQuery, result);	
			return true;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
		
	}

	@Override
	public String editBillingEffort(EffortModel effortModel) {
		LOGGER.info("Inside editRenewalEffort");
		try {
			int chkInJob = jdbcTemplate.queryForObject("select count(*) from job_billing_effort where billing_def='"+effortModel.getBillingDef()+"'"
					+ " and billing_def_test_seq="+effortModel.getBillingDefTestSeq()+" and effort_number="+effortModel.getPreviousEffNumber(), Integer.class);
			if(chkInJob == 0) {
				
			int chkDuplicate = jdbcTemplate.queryForObject("select count(*) from billing_def_effort where billing_def='"+effortModel.getBillingDef()+"' "
					+ "and billing_def_test_seq="+effortModel.getBillingDefTestSeq()+" and effort_number="+effortModel.getPreviousEffNumber(), Integer.class);
			
			int chkDupInProcess = jdbcTemplate.queryForObject("select count(*) from process_billing_effort" + 
					" where billing_def='"+effortModel.getBillingDef()+"' and billing_def_test_seq="+effortModel.getBillingDefTestSeq()+" and effort_number="+effortModel.getPreviousEffNumber()+ ""
							+ " and process_id="+effortModel.getProcessId(), Integer.class);
			
			Map<String, Object> result = new HashMap<>();
			String editRenewalEffortQuery=null ;
			String editRenewalEffInProcess=null;
			if(chkDuplicate == 0) {
				editRenewalEffortQuery  = "update billing_def_effort set effort_number=:effort_number,process_method=:process_method,interval =:interval ,"
					+ "action=:action,send_to=:send_to,send_bill=:send_bill,report=:report,attachment_code=:attachment_code,message_string=:message_string,"
					+ "suppress_email=:suppress_email where billing_def='"+effortModel.getBillingDef()+"' and billing_def_test_seq="+effortModel.getBillingDefTestSeq()+" and"
					+ " effort_number="+effortModel.getPreviousEffNumber()+"";
				
				 if(chkDupInProcess == 1) {
			    	  editRenewalEffInProcess = "update process_billing_effort set effort_number=:effort_number where billing_def='"+effortModel.getBillingDef()+"'"
			    	  		+ " and billing_def_test_seq="+effortModel.getBillingDefTestSeq()+" and effort_number="+effortModel.getPreviousEffNumber()+" and process_id="+effortModel.getProcessId();
			       }
			}
			else if(chkDuplicate == 1) {
				editRenewalEffortQuery  = "update billing_def_effort set process_method=:process_method,interval=:interval,"
						+ "action=:action,send_to=:send_to,send_bill=:send_bill,report=:report,attachment_code=:attachment_code,message_string=:message_string,"
						+ "suppress_email=:suppress_email where billing_def='"+effortModel.getBillingDef()+"' and billing_def_test_seq="+effortModel.getBillingDefTestSeq()+" and"
						+ " effort_number="+effortModel.getEffortNumber()+"";
			}
			
			result.put("effort_number", effortModel.getEffortNumber());			
			result.put("process_method",effortModel.getProcessMethod());
			result.put("interval",effortModel.getInterval());
			result.put("action",effortModel.getAction());
			result.put("send_to", effortModel.getSendTo());
			result.put("send_bill", effortModel.getSendBill());
			result.put("report", effortModel.getReport());
			result.put("attachment_code", effortModel.getAttachmentCode()!=""?effortModel.getAttachmentCode():null);
			result.put("message_string", effortModel.getMessageString()!=""?effortModel.getMessageString():null);
			result.put("suppress_email", effortModel.getSuppressEmail());
			
			namedParameterJdbcTemplate.update(editRenewalEffortQuery, result);
			 if(chkDupInProcess == 1) {
			namedParameterJdbcTemplate.update(editRenewalEffInProcess, result);
			 }
			return "updated";	
			}else {
				return "Cannot Update, effort is in use!";
			}
			
		} catch (Exception e) {
		LOGGER.error(ERROR + e);
		return ERROR;
	}
}

	@Override
	public boolean addRenTesting(String renewalDef, String description, String nthDef) {
		LOGGER.info("Inside addRenTesting");
		try {			
			String addRenTest = "insert into renewal_def_test (renewal_def,renewal_def_test_seq,description,nth_def) "
				    +" values (:renewal_def,:renewal_def_test_seq,:description,:nth_def)";
			
	        jdbcTemplate.update("update renewal_def set mru_renewal_def_test_seq = mru_renewal_def_test_seq + 1 where renewal_def = '"+renewalDef+"'");
	        int seq= jdbcTemplate.queryForObject("select mru_renewal_def_test_seq from renewal_def where renewal_def ='"+renewalDef+"'",Integer.class);
			
			Map<String, Object> renTestParams = new HashMap<String,Object>();	
			renTestParams.put("renewal_def",renewalDef);
			renTestParams.put("renewal_def_test_seq", seq);
			renTestParams.put("description", description!=""?description:null);			
			renTestParams.put("nth_def",nthDef!=""?nthDef:null);
		
			namedParameterJdbcTemplate.update(addRenTest, renTestParams);           
			return true;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		} 
	}

	@Override
	public boolean deleteQueue(String queue) {
		LOGGER.info("Inside delete Queue");
		try {
			int queueCol = jdbcTemplate.queryForObject("select count(queue) from process where queue="+"'"+queue+"'" , Integer.class);
			if(queueCol==0) {
			String queueProcessQuery  = "delete  from queue where queue ="+"'"+queue+"'";
			jdbcTemplate.update(queueProcessQuery);
			return true;
			}else{
				return false;
			}
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
	}

	@Override
	public boolean saveNthDef(NthModel nthModel) {
		LOGGER.info("inside saveNthDef() method");
		try {
			Map<String, Object> result = new HashMap<>();
			String query = "insert into nth_def(nth_def,description,active,process_sort,nth_count,nth_percent,start_with_record,get_every)values(:code,:description,:active,:processSort,:nthCount,:nthPercentage,:startingRecord,:everyNthRecord)";
		    result.put("code", nthModel.getCode());
		    result.put("description", nthModel.getDescription());
		    result.put("active", nthModel.getActive());
		    result.put("processSort", nthModel.getProcessSort());
		    result.put("nthCount", nthModel.getNthCount());
		    result.put("nthPercentage", nthModel.getNthPercentage());
		    result.put("startingRecord", nthModel.getStartingRecord());
		    result.put("everyNthRecord", nthModel.getEveryNthRecord());
		    namedParameterJdbcTemplate.update(query.toString(), result);
		    return true;
		 }catch(Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
		
	}

	@Override
	public boolean deleteNthDef(String nthDef) {
		LOGGER.info("inside deleteNthDef() method");
		try {
			String deleteQuery = "delete from nth_def where nth_def="+"'"+nthDef+"'";
			jdbcTemplate.update(deleteQuery);
			return true;
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			return false;
		}
		
	}

	@Override
	public int deleteBillingDef(String billingDef, int billingDefTestSeq,int ocId) {
		int status=0;
		try {
		String query="delete from billing_def_test where billing_def='"+billingDef+"' and billing_def_test_seq="+billingDefTestSeq;
		status=jdbcTemplate.update(query.toString());
		String deleteBillingDefOc="delete from billing_def_oc where billing_def='"+billingDef+"' and oc_id="+ocId;
		status=jdbcTemplate.update(deleteBillingDefOc);

		String query1="delete from billing_def where billing_def='"+billingDef+"'";
		status=jdbcTemplate.update(query1.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR+e);
			
		}
		return status;
	}

	@Override
	public int deleteBillingDefEffort(int effortNum,int processId, String billingDef) {
		int status=0;
		try {
			String deleteBillingEffort ="delete from process_billing_effort where process_id='"+processId+"' and billing_def ='"+billingDef+"' and effort_number = '"+effortNum+"' ";			
			status=jdbcTemplate.update(deleteBillingEffort);
			
			String query="delete from billing_def_effort where billing_def='"+billingDef+"' and effort_number="+effortNum;
			status=jdbcTemplate.update(query.toString());
		}catch (Exception e) {
			LOGGER.error(ERROR+e);
		}
		return status;
	}

	@Override
	public int editBillingDefTest(String billingDef, int billingDefTestSeq, String description, String nthDef) {
		Map<String,Object> updateParam=new HashMap<>();
		int status=0;
		StringBuilder query=new StringBuilder("update billing_def_test set description=:description,nth_def=:nth_def where billing_def='"+billingDef+"' and billing_def_test_seq="+billingDefTestSeq);
		try {
			updateParam.put("description", description);
			updateParam.put("nth_def", nthDef);
			status=namedParameterJdbcTemplate.update(query.toString(),updateParam);
		}catch (Exception e) {
			LOGGER.error(ERROR+e);
		}
		
		return status;
	}

	@Override
	public boolean billingCodeGeration(int ocId, String billingDef,int billingCode) {
		try {
			String query="update billing_def_oc set generate_billing_code="+billingCode+" where billing_def='"+billingDef+"' and oc_id="+ocId;
			jdbcTemplate.update(query);
			return true;
		}catch (Exception e) {
			LOGGER.error(ERROR+e);
			return false;

		}
	}

	@Override
	public boolean addBillTesting(String billingDef, String description, String nthDef) {
		Map<String,Object> addParams=new HashMap<>();
		try {
			String addRenTest = "insert into billing_def_test(billing_def,billing_def_test_seq,description,nth_def) "
				    +" values (:billing_def,:billing_def_test_seq,:description,:nth_def)";
	        Integer billingDefSeq=jdbcTemplate.queryForObject("select max(billing_def_test_seq) from billing_def_test where billing_def='"+billingDef+"'", Integer.class);
	        if(billingDefSeq==null) {
		        addParams.put("billing_def_test_seq", 1);
	        }else {
		        addParams.put("billing_def_test_seq", billingDefSeq+1);

	        }
	        addParams.put("billing_def",billingDef);
	        addParams.put("description", description!=""?description:null);			
	        addParams.put("nth_def",nthDef!=""?nthDef:null);
			namedParameterJdbcTemplate.update(addRenTest, addParams); 
			int seq= jdbcTemplate.queryForObject("select max(billing_def_test_seq) from billing_def_test where billing_def='"+billingDef+"'",Integer.class);
	        jdbcTemplate.update("update billing_def set mru_billing_def_test_seq ="+seq+" where billing_def = '"+billingDef+"'");
			
			return true;
		}catch (Exception e) {
			LOGGER.error(ERROR+e);
			return false;

		}
	}

	
	
	
}
