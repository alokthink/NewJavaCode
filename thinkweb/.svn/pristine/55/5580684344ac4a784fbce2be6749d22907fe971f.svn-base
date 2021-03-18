package com.mps.think.daoImpl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.mps.think.constants.SecurityConstants.ERROR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.mps.think.dao.OrderSourceOfferDao;
import com.mps.think.model.ComplaintServiceModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderCode;
import com.mps.think.model.SourceCode;
import com.mps.think.option.model.EditTrail;
import com.mps.think.resultMapper.ComplaintServiceMapper;
import com.mps.think.resultMapper.OrderSourceOfferMapper;
import com.mps.think.resultMapper.SourceCodeMapper;
import com.mps.think.setup.util.PropertyUtils;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.PropertyUtilityClass;

@Repository
public class OrderSourceOfferDaoImpl implements OrderSourceOfferDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderSourceOfferDaoImpl.class);
	private SimpleDateFormat formatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat formatYYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CustomerUtility  customerUtility;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<OrderCode> getOrderCode(String orderCodeType) {
		List<OrderCode> orderCodeList = new ArrayList<>();
		try {
			StringBuilder orderQuery = new StringBuilder();
			orderQuery.append("SELECT order_code_id,order_code.oc_id,order_code,o.oc,order_code.description,order_code_type,premium,t.term,media,edition,audit_qual_category,product_size,product_style,product_color,pkg_only_item,is_proforma,no_charge,controlled,perpetual_order,prepayment_req,active FROM order_code"
					+ " left join oc o on order_code.oc_id=o.oc_id"
					+ " left join term t on order_code.term_id=t.term_id" + " WHERE order_code.order_code LIKE '%' AND "
					+ " (active = 1 and order_code.order_code_type != 3 and order_code.order_code_type != 8 and premium != 2)");
					/*+ " and order_code_id in (117,119,118,120,121,122,123,124,243,252,125,255,127,259,131,128,126,263,269,272,275,281,278,266,287,284,163,291)");*/
					
					if(!"All".equals(orderCodeType)){
						orderQuery.append("AND order_code_type = "+orderCodeType);
					}
					orderQuery.append(" ORDER BY order_code.oc_id,order_code.order_code");
			
			orderCodeList = jdbcTemplate.query(orderQuery.toString(), new OrderSourceOfferMapper());			
		} catch (Exception e) {
			LOGGER.info("" + e);
		}
		return orderCodeList;
	}

	@Override
	public List<SourceCode> getSourceCode(String ocID) {
		List<SourceCode> sourceCodeList = new ArrayList<SourceCode>();
		try {
			StringBuilder orderQuery = new StringBuilder();	
			StringBuilder ocId= new StringBuilder();
			String ocType= jdbcTemplate.queryForObject("select oc_type from oc where oc_id = "+ocID, String.class);		 
			if(ocID == "") {
				orderQuery.append("select source_code.source_code_id,source_code.source_code,source_code.description,o.oc,source_code.source_code_type,source_code.generated,"  
						+ " source_code.offer,source_code.list,source_code.generic_agency from source_code source_code left join oc o on o.oc_id=source_code.oc_id"
						+ " WHERE source_code.source_code LIKE '%' AND source_code.active = 1 "
						+ " ORDER BY source_code.oc_id,source_code.source_code");
				
			}else {
			while(ocID!=null)
			{				
				ocId.append(ocID+",");
				ocID=jdbcTemplate.queryForObject("select parent_oc_id from oc where oc_id = "+ocID, String.class);			
			}			
			if(!"6".equals(ocType)) {
			orderQuery
					.append("select source_code.source_code_id,source_code.source_code,source_code.description,o.oc,source_code.source_code_type,source_code.generated,"
							+ " source_code.offer,source_code.list,source_code.generic_agency from source_code source_code left join oc o on o.oc_id=source_code.oc_id"
							+ " WHERE  (source_code.oc_id IN ("+ocId.substring(0, ocId.length()-1)+") AND source_code.active = 1"       
							+ " AND (GETDATE() BETWEEN source_code.from_date       AND source_code.to_date"       
							+ " OR (source_code.to_date IS NULL OR source_code.from_date IS NULL)) ");
							String dsn=new PropertyUtilityClass().getQuery("dsn");
							if(dsn.equals("ucp_cs_web1")) {
							orderQuery
								.append( "and (source_code_type = 2)"); } else {
							if("3".equals(ocType) || "4".equals(ocType) || "5".equals(ocType)) {
								orderQuery
								.append("and (source_code_type = 0 OR source_code_type = 1 OR source_code_type = 2 )");
							}else
							orderQuery
									.append("and ( source_code_type = 0 OR source_code_type = 2)");	
							}
							orderQuery
							.append(" and source_code_type != 3 and source_code_type != 4 and source_code_type != 5) ORDER BY source_code.oc_id,source_code.source_code");
			}else {
				orderQuery
				.append("select source_code.source_code_id,source_code.source_code,source_code.description,o.oc,source_code.source_code_type,source_code.generated,"
						+ " source_code.offer,source_code.list,source_code.generic_agency from source_code source_code left join oc o on o.oc_id=source_code.oc_id"
						+ " WHERE  (source_code_type != 3 and source_code_type != 4 and source_code_type != 5) ORDER BY source_code.oc_id,source_code.source_code ");
			}
			}
			sourceCodeList = jdbcTemplate.query(orderQuery.toString(), new SourceCodeMapper());			
		} catch (Exception e) {
			LOGGER.info("" + e);
		}
		return sourceCodeList;
	}
	
	@Override
	public List<DropdownModel> getCauseCode(){
		List<Map<String, Object>> rows=new ArrayList<>();
		List<DropdownModel> causeCode = new ArrayList<>();
			try {
				 rows = jdbcTemplate.queryForList("select cause_code,description from cause_code;");
				 for (Map<String, Object> row : rows) {
					 DropdownModel model = new DropdownModel();
						model.setKey(row.get("cause_code").toString());
						//model.setDisplay(row.get("cause_code").toString()+ ":" + row.get("description").toString());
						model.setDisplay(row.get("description").toString());
						causeCode.add(model);
					}
				}
			catch(Exception e){
				LOGGER.error("ERROR" + e);
			}
			return causeCode;
		}
	
	@Override
	public List<DropdownModel> getComplaintCode(){
		List<Map<String, Object>> rows=new ArrayList<>();
		List<DropdownModel> complaintCode = new ArrayList<>();
			try {
				 rows = jdbcTemplate.queryForList("select complaint_code,description from complaint_code;");
				 for (Map<String, Object> row : rows) {
					 DropdownModel model = new DropdownModel();
						model.setKey(row.get("complaint_code").toString());
						//model.setDisplay(row.get("complaint_code").toString()+ ":" + row.get("description").toString());
						model.setDisplay(row.get("description").toString());
						complaintCode.add(model);
					}
				}
			catch(Exception e){
				LOGGER.error("ERROR" + e);
				
			}
			return complaintCode;
			
		}
	@Override
	public List<DropdownModel> getServiceCode(){
		List<Map<String, Object>> rows=new ArrayList<>();
		
		List<DropdownModel> serviceCode = new ArrayList<>();
			try {
				 rows = jdbcTemplate.queryForList("select service_code,description from service_code;");
				 for (Map<String, Object> row : rows) {
					 DropdownModel model = new DropdownModel();
						model.setKey(row.get("service_code").toString());
						model.setDisplay(row.get("description").toString());
						serviceCode.add(model);
				    }
				 }
			    catch(Exception e){
				LOGGER.error("ERROR" + e);
				
			}
			return serviceCode;
		}
	@Override
	public List<DropdownModel> getServiceCodeTemplate(){
		List<Map<String, Object>> rows=new ArrayList<>();
		List<DropdownModel> serviceCode = new ArrayList<>();
			try {
				 rows = jdbcTemplate.queryForList(" SELECT  report_item_id, title, description, name, report_item_type from report_item where report_item_type=1 order by description asc");
				 for (Map<String, Object> row : rows) {
					 DropdownModel model = new DropdownModel();
						model.setKey(row.get("report_item_id")!=null?row.get("report_item_id").toString():"0");
						model.setDisplay(row.get("title")!=null?row.get("title").toString():"");
						model.setDescription(row.get("description")!=null?row.get("description").toString():"");
						model.setExtra(row.get("name")!=null?row.get("name").toString():null);
						serviceCode.add(model);
				    }
				 }
			    catch(Exception e){
				LOGGER.error("ERROR" + e);
				
			}
			return serviceCode;
		}
	@Override
	public List<Map<String, Object>> getOrderDetails(int orderId){
		List<Map<String, Object>> rows=new ArrayList<>();
			try {
				 rows = jdbcTemplate.queryForList("select isNull(subscrip_id,'') as subscrip_id,user_code,orderhdr_id,order_item_seq from order_item where orderhdr_id ="+orderId);
				 
				 }
			    catch(Exception e){
				LOGGER.error("ERROR" + e);
				
			}
			return rows;
		}

	
	@Override
	public boolean saveService(ComplaintServiceModel complaintServiceModel, int serviceFilter, int orderItemType){
		  StringBuilder serviceQuery = new StringBuilder();
	      Map<String, Object> serviceParameters = new HashMap<String,Object>();
	      int insertedStatus = 0;
		  try{
			  
		      long editTrailId = customerUtility.getmaxeditTrailId();
		      //customer
              if(serviceFilter == 1) {
			     serviceQuery.append("insert into service (customer_id,service_seq,user_code,complaint_code,cause_code,service_code,complaint_date,claim_ref_nbr,service_date,followup_date,service_status,mru_service_note_seq) ");
			     serviceQuery.append("values (:customer_id,:service_seq,:user_code,:complaint_code,:cause_code,:service_code,GETDATE(),:claim_ref_nbr,GETDATE(),:followup_date,:service_status,:mru_service_note_seq);"); 
			     
			     editTrailId = editTrailId +1;
			     
              }if(serviceFilter == 2 || serviceFilter ==5 || orderItemType == 0 || orderItemType ==4 ||orderItemType==5 ||orderItemType==6){
                 serviceQuery.append("insert into service (customer_id,service_seq,user_code,complaint_code,cause_code,service_code,orderhdr_id,order_item_seq,complaint_date,service_date,followup_date,claim_ref_nbr,service_status,subscrip_id,mru_service_note_seq) ");
                 serviceQuery.append(" values (:customer_id,:service_seq,:user_code,:complaint_code,:cause_code,:service_code,:orderhdr_id");  
                 serviceQuery.append(",:order_item_seq,GETDATE(),GETDATE(),:followup_date,:claim_ref_nbr,:service_status,:subscrip_id,:mru_service_note_seq);");
                 editTrailId = editTrailId + 2;
              }
              if(serviceFilter == 4 || serviceFilter ==3 || orderItemType == 1 || orderItemType == 2) {
            	 serviceQuery.append("insert into service (customer_id,service_seq,user_code,complaint_code,cause_code,service_code,orderhdr_id,order_item_seq,complaint_date,service_date,claim_ref_nbr,followup_date,service_status,mru_service_note_seq)"); 
            	 serviceQuery.append(" values (:customer_id,:service_seq,:user_code,:complaint_code,:cause_code,:service_code,:orderhdr_id ");
            	 serviceQuery.append(",:order_item_seq,GETDATE(),GETDATE(),:claim_ref_nbr,:followup_date,:service_status ,:mru_service_note_seq);"); 
            	 editTrailId = editTrailId + 2;
              }
	        
			
              Integer serviceSeq = jdbcTemplate.queryForObject("select max(service_seq) as service_seq from service where customer_id ="+complaintServiceModel.getCustomerId(), Integer.class);
              serviceSeq = serviceSeq!=null?Integer.valueOf(serviceSeq) + 1:1;
			serviceParameters.put("customer_id", complaintServiceModel.getCustomerId());
			serviceParameters.put("service_seq",serviceSeq);	
			if( ("null".equals(complaintServiceModel.getCauseCode())) | ("".equals(complaintServiceModel.getCauseCode()))) {
				serviceParameters.put("cause_code", null);
			}else {
				serviceParameters.put("cause_code", complaintServiceModel.getCauseCode());
			}
			if( ("null".equals(complaintServiceModel.getComplaintReference())) | ("".equals(complaintServiceModel.getComplaintReference()))) {
				serviceParameters.put("claim_ref_nbr", null);
			}else {
				serviceParameters.put("claim_ref_nbr", complaintServiceModel.getComplaintReference());
			}
			if( ("null".equals(complaintServiceModel.getComplaintCode())) | ("".equals(complaintServiceModel.getComplaintCode()))) {
				serviceParameters.put("complaint_code", null);
			}else {
				serviceParameters.put("complaint_code", complaintServiceModel.getComplaintCode());
			}
			if( ("null".equals(complaintServiceModel.getComplaintDate())) | ("".equals(complaintServiceModel.getComplaintDate()))) {
				serviceParameters.put("complaint_date", null);
			}else {
				serviceParameters.put("complaint_date", complaintServiceModel.getComplaintDate());
			}
			String followupDate = complaintServiceModel.getFollowupDate();
			serviceParameters.put("followup_date", followupDate==null||followupDate.equals("")?null:followupDate);
			serviceParameters.put("mru_service_note_seq",1);
			if( ("null".equals(complaintServiceModel.getOrderId())) | ("".equals(complaintServiceModel.getOrderId()))) {
				serviceParameters.put("orderhdr_id", null);
			}else {
				serviceParameters.put("orderhdr_id", complaintServiceModel.getOrderId());
			}
			if( ("null".equals(complaintServiceModel.getOrderItemSeq())) | ("".equals(complaintServiceModel.getOrderItemSeq()))) {
				serviceParameters.put("order_item_seq", null);
			}else {
				serviceParameters.put("order_item_seq", complaintServiceModel.getOrderItemSeq());
			}
			if( ("null".equals(complaintServiceModel.getServiceCode())) | ("".equals(complaintServiceModel.getServiceCode()))) {
				serviceParameters.put("service_code", null);
			}else {
				serviceParameters.put("service_code", complaintServiceModel.getServiceCode());
			}
			if( ("null".equals(complaintServiceModel.getServiceDate())) | ("".equals(complaintServiceModel.getServiceDate()))) {
				serviceParameters.put("service_date", null);
			}else {
				serviceParameters.put("service_date", complaintServiceModel.getServiceDate());
			}
			serviceParameters.put("service_status", complaintServiceModel.getServiceStatus());
			if( ("null".equals(complaintServiceModel.getSubscripId())) | ("".equals(complaintServiceModel.getSubscripId()))) {
				serviceParameters.put("subscrip_id", null);
			}else {
				Integer subscripId = jdbcTemplate.queryForObject("select subscrip_id from order_item where customer_id="+complaintServiceModel.getCustomerId()+" and order_code_id="+complaintServiceModel.getSubscripId(), Integer.class);
				serviceParameters.put("subscrip_id", subscripId);
			}
			serviceParameters.put("user_code", complaintServiceModel.getUserCode());
			insertedStatus = namedParameterJdbcTemplate.update(serviceQuery.toString(), serviceParameters);
			serviceParameters.clear();
			if(insertedStatus > 0) {
				 serviceQuery = new StringBuilder();
		         serviceQuery.append( " insert into service_note (customer_id,service_seq,service_note_seq,user_code,creation_date,note_field) ");
		         serviceQuery.append("values (:customer_id, :service_seq,  :service_note_seq, :user_code, GETDATE(),:note_field);");
		         serviceParameters.put("customer_id", complaintServiceModel.getCustomerId());
		         serviceParameters.put("service_seq", serviceSeq);
		         serviceParameters.put("service_note_seq", 1);
				 serviceParameters.put("user_code", complaintServiceModel.getUserCode());
				if( ("null".equals(complaintServiceModel.getNoteField())) | ("".equals(complaintServiceModel.getNoteField()))) {
					serviceParameters.put("note_field", null);
				}else {
					serviceParameters.put("note_field", complaintServiceModel.getNoteField());
				}
				insertedStatus = namedParameterJdbcTemplate.update(serviceQuery.toString(), serviceParameters);
             }
			if(insertedStatus > 0) {
				serviceQuery = new StringBuilder();
				serviceParameters.clear();
	            serviceQuery.append("insert into edit_trail (edit_trail_id,customer_id,user_code,edited,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name,service_seq)");
	            serviceQuery.append("values(:edit_trail_id, :customer_id, :user_code, :edited, :table_enum,:document_reference_id, :local_amount, :base_amount, :date_stamp,GETDATE(), :xaction_name, :service_seq);");
				serviceParameters.put("edit_trail_id",editTrailId);
				serviceParameters.put("customer_id",complaintServiceModel.getCustomerId());
				serviceParameters.put("user_code",complaintServiceModel.getUserCode());
				serviceParameters.put("edited",0);
				serviceParameters.put("table_enum", 11);
				serviceParameters.put("document_reference_id", complaintServiceModel.getDocumentReferenceId());
				serviceParameters.put("local_amount",0.00);
				serviceParameters.put("base_amount",0.00);
				serviceParameters.put("date_stamp",customerUtility.getmaxDateStamp());
				//serviceParameters.put("creation_date",propertyUtilityClass.getCurrentDateTime()); //it replaced by GETDATE() of sql
				serviceParameters.put("xaction_name","service_add_request");
				serviceParameters.put("service_seq",serviceSeq);
				insertedStatus = namedParameterJdbcTemplate.update(serviceQuery.toString(), serviceParameters);
				customerUtility.updateMruEditTrailId(editTrailId);
			}
			if(insertedStatus > 0) {
				serviceQuery = new StringBuilder();
				serviceQuery.append( "update order_item set service_exist=:service_exist where orderhdr_id= :orderhdr_id and order_item_seq= :order_item_seq;");
	     	     serviceParameters.put("service_exist",1);
	     	    if( ("null".equals(complaintServiceModel.getOrderId())) | ("".equals(complaintServiceModel.getOrderId()))) {
					serviceParameters.put("orderhdr_id", null);
				}else {
					serviceParameters.put("orderhdr_id", complaintServiceModel.getOrderId());
				}
				if( ("null".equals(complaintServiceModel.getOrderItemSeq())) | ("".equals(complaintServiceModel.getOrderItemSeq()))) {
					serviceParameters.put("order_item_seq", null);
				}else {
					serviceParameters.put("order_item_seq", complaintServiceModel.getOrderItemSeq());
				}
				insertedStatus = namedParameterJdbcTemplate.update(serviceQuery.toString(), serviceParameters);
				if(insertedStatus > 0) {
					serviceQuery = new StringBuilder();
					serviceParameters.clear();
					serviceQuery.append("update customer set mru_service_seq=:mru_service_seq where customer_id=:customer_id");
					serviceParameters.put("mru_service_seq", serviceSeq);
					serviceParameters.put("customer_id",complaintServiceModel.getCustomerId());
					insertedStatus = namedParameterJdbcTemplate.update(serviceQuery.toString(), serviceParameters);
				}
			}
			 
			return true;
		  }catch(Exception e){
				LOGGER.error("ERROR" +  e);
				return false;
				 
			}
				
	  }
	
	 @Override
	public boolean updateService(ComplaintServiceModel complaintServiceModel){
		 List<Map<String, Object>> existingServicesData=new ArrayList<>();
		 List<EditTrail> toInsertEditTrailDeltaList = new ArrayList<>();
		 EditTrail editModel = null;
		 int status = 0;
		  try{
		    Map<String, Object> serviceParameters = new HashMap<String,Object>();
		    StringBuilder serviceQuery = null;
		    //it stores data existing data
		    serviceQuery = new StringBuilder("SELECT * FROM service WHERE customer_id=").append(complaintServiceModel.getCustomerId()).append(" and service_seq=").append(complaintServiceModel.getServiceSeq()).append(" ORDER BY customer_id,service_seq");
		    existingServicesData = jdbcTemplate.queryForList(serviceQuery.toString());
		    
		    serviceQuery = new StringBuilder();
		    serviceQuery.append("update service set complaint_code = :complaint_code,cause_code=:cause_code,service_code=:service_code,");
		    serviceQuery.append("complaint_date=:complaint_date,service_date=:service_date,followup_date=:followup_date, service_status=:service_status ,claim_ref_nbr=:claim_ref_nbr ");
		    serviceQuery.append("where customer_id=").append(complaintServiceModel.getCustomerId()).append(" and service_seq= ").append(complaintServiceModel.getServiceSeq());
		   
		    String followupDate = complaintServiceModel.getFollowupDate();
		    if(followupDate.equals("")) {
		    	followupDate = null;
		    }
			serviceParameters.put("user_code", complaintServiceModel.getUserCode());
			if( ("null".equals(complaintServiceModel.getComplaintCode())) | ("".equals(complaintServiceModel.getComplaintCode()))) {
				serviceParameters.put("complaint_code", null);
			}else {
				serviceParameters.put("complaint_code", complaintServiceModel.getComplaintCode());
				String after_complaint_code = complaintServiceModel.getComplaintCode();
				String before_complaint_code = existingServicesData.get(0).get("complaint_code")!=null?existingServicesData.get(0).get("complaint_code").toString():null;
		    	if(!after_complaint_code.equals(before_complaint_code)) {
		    		editModel = new EditTrail();
				    editModel.setColumnName("complaint_code");
				    editModel.setBeforeChange(before_complaint_code);
				    editModel.setAfterChange(after_complaint_code);
				    toInsertEditTrailDeltaList.add(editModel);
		    	}
			}
			if( ("null".equals(complaintServiceModel.getCauseCode())) | ("".equals(complaintServiceModel.getCauseCode()))) {
				serviceParameters.put("cause_code", null);
			}else {
				serviceParameters.put("cause_code", complaintServiceModel.getCauseCode());
				String after_cause_code = complaintServiceModel.getCauseCode();
				String before_cause_code = existingServicesData.get(0).get("cause_code")!=null?existingServicesData.get(0).get("cause_code").toString():null;
		    	if(!after_cause_code.equals(before_cause_code)) {
		    		editModel = new EditTrail();
				    editModel.setColumnName("cause_code");
				    editModel.setBeforeChange(before_cause_code);
				    editModel.setAfterChange(after_cause_code);
				    toInsertEditTrailDeltaList.add(editModel);
		    	}
			}
			if( ("null".equals(complaintServiceModel.getServiceCode())) | ("".equals(complaintServiceModel.getServiceCode()))) {
				serviceParameters.put("service_code", null);
			}else {
				serviceParameters.put("service_code", complaintServiceModel.getServiceCode());
				String after_service_code = complaintServiceModel.getServiceCode();
				String before_service_code = existingServicesData.get(0).get("service_code")!=null?existingServicesData.get(0).get("service_code").toString():null;
		    	if(!after_service_code.equals(before_service_code)) {
		    		editModel = new EditTrail();
				    editModel.setColumnName("service_code");
				    editModel.setBeforeChange(before_service_code);
				    editModel.setAfterChange(after_service_code);
				    toInsertEditTrailDeltaList.add(editModel);
		    	}
			}
			if( ("null".equals(complaintServiceModel.getComplaintDate())) | ("".equals(complaintServiceModel.getComplaintDate()))) {
				serviceParameters.put("complaint_date", null);
			}else {
				serviceParameters.put("complaint_date", complaintServiceModel.getComplaintDate());
				String after_complaint_date = complaintServiceModel.getComplaintDate();
				String before_complaint_date = existingServicesData.get(0).get("complaint_date")!=null?existingServicesData.get(0).get("complaint_date").toString():null;
				if(before_complaint_date != null)
					before_complaint_date = before_complaint_date.substring(0,10);//remove time from 2020-04-13 00:00:00.0
		    	if(!after_complaint_date.equals(before_complaint_date)) {
		    		editModel = new EditTrail();
				    editModel.setColumnName("complaint_date");
				    editModel.setBeforeChange(before_complaint_date);
				    editModel.setAfterChange(after_complaint_date);
				    toInsertEditTrailDeltaList.add(editModel);
		    	}
			}
			if( ("null".equals(complaintServiceModel.getServiceDate())) | ("".equals(complaintServiceModel.getServiceDate()))) {
				serviceParameters.put("service_date", null);
			}else {
				serviceParameters.put("service_date", complaintServiceModel.getServiceDate());
				String afterServiceDate = complaintServiceModel.getServiceDate().toString();
				String beforServiceDate = existingServicesData.get(0).get("service_date")!=null?existingServicesData.get(0).get("service_date").toString():null;
				if(beforServiceDate != null)
					beforServiceDate = beforServiceDate.substring(0,10);
		    	if(!afterServiceDate.equals(beforServiceDate)) {
		    		editModel = new EditTrail();
				    editModel.setColumnName("service_date");
				    editModel.setBeforeChange(beforServiceDate);
				    editModel.setAfterChange(afterServiceDate);
				    toInsertEditTrailDeltaList.add(editModel);
		    	}
			}
			serviceParameters.put("followup_date", followupDate);
			if(followupDate != null && !"null".equals(followupDate)) {
				String beforFollowUpDate = existingServicesData.get(0).get("followup_date")!=null?existingServicesData.get(0).get("followup_date").toString():null;
				if(beforFollowUpDate != null)
					beforFollowUpDate = beforFollowUpDate.substring(0,10);
		    	if(!followupDate.equals(beforFollowUpDate)) {
		    		editModel = new EditTrail();
				    editModel.setColumnName("followup_date");
				    editModel.setBeforeChange(beforFollowUpDate);
				    editModel.setAfterChange(followupDate);
				    toInsertEditTrailDeltaList.add(editModel);
		    	}
			}
			serviceParameters.put("service_status", complaintServiceModel.getServiceStatus());
			String afterService_status = complaintServiceModel.getServiceStatus();
			String beforeService_status = existingServicesData.get(0).get("service_status").toString();
			if(!afterService_status.equals(beforeService_status)) {
				editModel = new EditTrail();
			    editModel.setColumnName("service_status");
			    editModel.setBeforeChange(beforeService_status);
			    editModel.setAfterChange(afterService_status);
			    toInsertEditTrailDeltaList.add(editModel);
	    	}
			if( ("null".equals(complaintServiceModel.getComplaintReference())) | ("".equals(complaintServiceModel.getComplaintReference()))) {
				serviceParameters.put("claim_ref_nbr", null);
			}else {
				serviceParameters.put("claim_ref_nbr", complaintServiceModel.getComplaintReference());
				String afterClaim_ref_nbr = complaintServiceModel.getComplaintReference();
				String beforeClaim_ref_nbr = existingServicesData.get(0).get("claim_ref_nbr")!=null?existingServicesData.get(0).get("claim_ref_nbr").toString():null;
		    	if(!afterClaim_ref_nbr.equals(beforeClaim_ref_nbr)) {
		    		editModel = new EditTrail();
				    editModel.setColumnName("claim_ref_nbr");
				    editModel.setBeforeChange(beforeClaim_ref_nbr);
				    editModel.setAfterChange(afterClaim_ref_nbr);
				    toInsertEditTrailDeltaList.add(editModel);
		    	}
			}
			if( ("null".equals(complaintServiceModel.getNoteField())) | ("".equals(complaintServiceModel.getNoteField()))) {
				serviceParameters.put("note_field", null);
			}else {
				serviceParameters.put("note_field", complaintServiceModel.getNoteField());
			}
	    	status = namedParameterJdbcTemplate.update(serviceQuery.toString(), serviceParameters);
	    	if(status > 0) {
	    		EditTrail editTrail = new EditTrail();
	    		editTrail.setCustomerId(Integer.valueOf(complaintServiceModel.getCustomerId()));
	    		editTrail.setUserCode(complaintServiceModel.getUserCode());
	    		editTrail.setEdited("1");
	    		editTrail.setTableEnum(11);
	    		editTrail.setDocumentReferenceId(Integer.valueOf(complaintServiceModel.getDocumentReferenceId()));
	    		editTrail.setXactionName("service_edit_request");
	    		editTrail.setServiceSeq(Integer.valueOf(complaintServiceModel.getServiceSeq()));
	    		long edit_trail_id = customerUtility.saveEditTrail(editTrail);
				 //insert data into edit trail delta using batch
    			 customerUtility.insertEditTrailDeltaByBatch(toInsertEditTrailDeltaList,edit_trail_id);
	    		 serviceQuery = new StringBuilder();
	    		 //SELECT * FROM service_note WHERE customer_id=150576 and service_seq=1 ORDER BY customer_id,service_seq,service_note_seq
	    		 //update service_note set note_field='Replaced BNF 67 : PHP1113655' where customer_id=150576 and service_seq=1 and service_note_seq=1
	    		 serviceQuery.append(" update service_note set note_field=:note_field where customer_id=" + complaintServiceModel.getCustomerId()+ " and service_seq= "+complaintServiceModel.getServiceSeq());
	    		 status = namedParameterJdbcTemplate.update(serviceQuery.toString(), serviceParameters);
	    	}
		  }catch(Exception e){
				LOGGER.error("ERROR" + e);
				e.printStackTrace();
				return false;
				
			}
			return true;
			
	  }

		
	@Override
	public List<Object> getServiceFilterData(int customerId ,int serviceFilter,int orderItemType ) {
			List<Object> servicefilterData=new ArrayList<>();
			try {
				StringBuilder query = new StringBuilder();
		          if(serviceFilter!=1 && serviceFilter!=0) {	    
		        	 query.append("select distinct CAST (s.service_seq AS NVARCHAR(MAX))as service_seq, (case when  s.complaint_date = '1900-01-01 00:00:00.000' then null else convert(varchar,s.complaint_date,121)end ) as complaint_date,CAST (s.complaint_code AS NVARCHAR(MAX))as complaint_code,CAST (s.cause_code AS NVARCHAR(MAX))as cause_code," + 
		        	 		"CAST (s.service_code AS NVARCHAR(MAX))as service_code,CAST (s.service_status AS NVARCHAR(MAX))as service_status,CAST (s.user_code AS NVARCHAR(MAX))as user_code," + 
		        	 		"isNull(s.subscrip_id,'') as subscrip_id, (case when  s.service_date = '1900-01-01 00:00:00.000' then null else convert(varchar,s.service_date,121)end ) as service_date ,CAST (s.order_item_seq AS NVARCHAR(MAX))as order_item_seq, CAST (sn.note_field AS NVARCHAR(MAX))as note_field ," + 
		        	 		"CAST (s.orderhdr_id AS NVARCHAR(MAX))as orderhdr_id,(case when  s.followup_date = '1900-01-01 00:00:00.000' then null else convert(varchar,s.followup_date,121)end ) as followup_date ,CAST (s.customer_id AS NVARCHAR(MAX))as customer_id," + 
		        	 		"(case when order_item_type=0 then 'Subscription' when order_item_type=1 then'Single Copy' when order_item_type=2 then" + 
		        	 		"'Product' when order_item_type=3 then 'Electronic Document'when order_item_type=5 then 'Package'" + 
		        	 		"when order_item_type=6 then 'Package' when order_item_type=7 then 'Package' end) as serviceFilter FROM service s " + 
		        	 		"left outer JOIN service_note sn ON sn.customer_id = s.customer_id and sn.service_seq=s.service_seq " + 
		        	 		"left join order_item on order_item.orderhdr_id=s.orderhdr_id and order_item.order_item_seq=s.order_item_seq " + 
		        	 		"  where s.customer_id ="+ customerId); 
		        	 //Subscription	
				if(serviceFilter == 2 || orderItemType==0)
					query.append(" AND s.subscrip_id IN (SELECT subscrip_id FROM order_item WHERE order_item_type = 0)");		
				   //Product
				if(serviceFilter == 3 || orderItemType==2)
					 query.append("AND s.orderhdr_id in (SELECT orderhdr_id FROM order_item WHERE s.orderhdr_id = orderhdr_id AND s.order_item_seq = order_item_seq ) AND order_item_type = 2");
				  //Single Issue	
				if(serviceFilter == 4 || orderItemType==1)
					query.append(" AND  s.orderhdr_id in (select orderhdr_id from order_item " + 
								" where s.orderhdr_id = orderhdr_id  AND s.order_item_seq = order_item_seq ) and order_item_type = 1");
				//Package		
				if(serviceFilter == 5 || orderItemType==4 || orderItemType==5 || orderItemType==6)
					query.append("AND s.subscrip_id IN (SELECT subscrip_id FROM order_item WHERE order_item_type in (4, 5, 6))");
		          }
		          
		        // ALL 
				if(serviceFilter == 0) {
				   query.append("select  s.service_seq,(case when  s.complaint_date = '1900-01-01 00:00:00.000' then null else convert(varchar,s.complaint_date,121)end ) as complaint_date  ,s.complaint_code,s.cause_code, s.service_code, s.service_status, s.user_code," + 
					"isNull(s.subscrip_id,'') as subscrip_id,(case when  s.service_date = '1900-01-01 00:00:00.000' then null else convert(varchar,s.service_date,121)end ) as service_date,s.order_item_seq,sn.note_field ,s.orderhdr_id,(case when  s.followup_date = '1900-01-01 00:00:00.000' then null else convert(varchar,s.followup_date,121)end ) as followup_date,s.customer_id " + 
					"  from service as s " + 
					"  left join service_note sn on sn.customer_id=s.customer_id AND  sn.service_seq =s.service_seq" + 
					"  where s.customer_id ="+ customerId); 
				}
		        //Customer
				if(serviceFilter==1) {
				   query.append("select  s.service_seq, (case when  s.complaint_date = '1900-01-01 00:00:00.000' then null else convert(varchar,s.complaint_date,121)end ) as complaint_date ,s.complaint_code,s.cause_code, s.service_code, s.service_status, s.user_code," + 
					"isNull(s.subscrip_id,'') as subscrip_id,(case when  s.service_date = '1900-01-01 00:00:00.000' then null else convert(varchar,s.service_date,121)end ) as service_date,s.order_item_seq,sn.note_field ,s.orderhdr_id,(case when  s.followup_date = '1900-01-01 00:00:00.000' then null else convert(varchar,s.followup_date,121)end ) as followup_date,s.customer_id" + 
					",'customer' as serviceFilter " + 
					"  from service as s" + 
					"  left join service_note sn on sn.customer_id=s.customer_id AND  sn.service_seq =s.service_seq" + 
					"  left join order_item on order_item.orderhdr_id=s.orderhdr_id" + 
					"  where s.customer_id ="+ customerId);
					 query.append(" AND s.orderhdr_id IS NULL AND s.subscrip_id IS NULL");
					 
					}
		    List<Map<String, Object>> rows = jdbcTemplate.queryForList(query.toString());
	        	for (Map<String, Object> row : rows) {
			     servicefilterData.add(row);
		     }
		  }catch(Exception e) {
				LOGGER.error(ERROR + e);
			}
			return servicefilterData;
		}
		@Override
		public String getRowCountValue(int customer_id) {
			String status=null;
			try {
				Long query = jdbcTemplate.queryForObject("select count(customer_id) from service where customer_id="+customer_id, Long.class);
				if(query== 0) {
				status = "No row present";
				}else {
					status =  "Row are present";
				}
			}
			catch(Exception e){
				LOGGER.error(ERROR + e);
			}
			return status;
			
		}
		

        @Override
		public Map<String, Object> getServiceSeq(int customerId) {
			LOGGER.info("Inside getProcessInput");
			Map<String, Object> result =  new LinkedHashMap<String, Object>();
				
				String s = jdbcTemplate.queryForObject("select max(service_seq) from service where customer_id ="+customerId,String.class);
				if(s!=null){
					int seq = Integer.parseInt(s)+1;
					result.put("complaintId", String.valueOf(customerId)+"-"+ seq);	
				}else{
					result.put("complaintId",String.valueOf(customerId)+"-"+ 1);
				}
			return result;
	}

		@Override
		public List<Map<String, Object>> getSelectedData(String compalintCode) {
			LOGGER.info("Inside getSelectedData");
			
			List<Map<String, Object>> selectData=new ArrayList<>();
			
			try {
				
				selectData = jdbcTemplate.queryForList("select cc.complaint_code, cc.description, sc.service_code, sc.description as serDesc, ca.cause_code ,ca.description as causeDesc,cc.memo_required  from complaint_code as cc LEFT JOIN  service_code as sc on sc.service_code=cc.service_code INNER JOIN cause_code as ca on ca.cause_code=cc.cause_code where cc.complaint_code= "+"'"+compalintCode+"'");
			}
			    catch(Exception e){
				LOGGER.error("ERROR" + e);
				
			}
			return selectData;
		}

		@Override
		public List<DropdownModel>  getselectRecord(int customerId, int serviceFilter) {
			LOGGER.info("Inside getselectRecord");
			List<DropdownModel> noteRecordList = new ArrayList<>();
			try {
				List<Map<String, Object>> rows;
				switch(serviceFilter) {
				case 2 : rows = jdbcTemplate.queryForList("SELECT s.subscrip_id,convert(varchar(10), s.orig_order_date, 101) as order_date,oc.description, oi.orderhdr_id, oi.order_item_seq FROM subscrip AS s INNER JOIN order_item AS oi ON s.subscrip_id = oi.subscrip_id INNER JOIN dbo.order_code AS oc ON oi.order_code_id = oc.order_code_id WHERE oi.customer_id="+customerId+" ORDER BY subscrip_id"); 						   
					            for(Map<String, Object> row:rows) {
					              DropdownModel model = new DropdownModel();
					              model.setKey(row.get("orderhdr_id").toString());
					              model.setDisplay(row.get("order_item_seq")!=null?row.get("order_item_seq").toString():"");
					              model.setDescription(row.get("description")!=null?row.get("description").toString():"");
					              model.setExtra(row.get("subscrip_id")!=null?row.get("subscrip_id").toString():"");
					              model.setExtraData(row.get("order_date")!=null?row.get("order_date").toString():"");
					              noteRecordList.add(model);
					            }	
				break;
				case 3: rows = jdbcTemplate.queryForList("SELECT orderhdr_id,order_item_seq,order_code_id,convert(varchar(10), order_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), order_date, 22),11) ) as order_date FROM order_item WHERE customer_id="+customerId+" AND order_item_type = 2 ORDER BY orderhdr_id,order_item_seq");
			                   for(Map<String, Object> row:rows) {
			                	 DropdownModel model = new DropdownModel(); 
			                	 model.setKey(row.get("orderhdr_id").toString());
			                	  model.setDisplay(row.get("order_item_seq")!=null?row.get("order_item_seq").toString():"");
					              model.setExtra(row.get("order_code_id")!=null?row.get("order_code_id").toString():"");
					              model.setExtraData(row.get("order_date")!=null?row.get("order_date").toString():"");
					              noteRecordList.add(model);
			                   }
				break;
				case 4 : rows = jdbcTemplate.queryForList("SELECT orderhdr_id,order_item_seq,order_code_id,convert(varchar(10), order_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), order_date, 22),11) ) as order_date FROM order_item WHERE customer_id=" +customerId+ " AND order_item_type = 1 ORDER BY orderhdr_id,order_item_seq" ); 
				                for(Map<String, Object> row:rows) {
		                         DropdownModel model = new DropdownModel();
			                	 model.setKey(row.get("orderhdr_id").toString());
			                	  model.setDisplay(row.get("order_item_seq")!=null?row.get("order_item_seq").toString():"");
					              model.setExtra(row.get("order_code_id")!=null?row.get("order_code_id").toString():"");
					              model.setExtraData(row.get("order_date")!=null?row.get("order_date").toString():"");
					              noteRecordList.add(model);
				                }	
				
				break;
				case 5 : rows = jdbcTemplate.queryForList("SELECT orderhdr_id,order_item_seq,order_code_id,convert(varchar(10), order_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), order_date, 22),11) ) as order_date FROM order_item WHERE customer_id=" +customerId+ " AND order_item_type IN (4,5,6) ORDER BY orderhdr_id,order_item_seq");
				                for(Map<String, Object> row:rows) {
                                DropdownModel model = new DropdownModel();
                            	model.setKey(row.get("orderhdr_id").toString());
                            	  model.setDisplay(row.get("order_item_seq")!=null?row.get("order_item_seq").toString():"");
					              model.setExtra(row.get("order_code_id")!=null?row.get("order_code_id").toString():"");
					              model.setExtraData(row.get("order_date")!=null?row.get("order_date").toString():"");
					              noteRecordList.add(model);
                  }
			 	break;  
                default:
                	
				}
			}catch(Exception e) {
				LOGGER.error("ERROR" + e);
			}
			return noteRecordList;
		}

		@Override
		public List<ComplaintServiceModel> getShowDataForUpdate(int customerId, int serviceSeq,int serviceFilter) {
			LOGGER.info("Inside getShowDataForUpdate");
			List<ComplaintServiceModel> responseObject = new ArrayList<>();
			try {
				StringBuilder query = new StringBuilder("select s.customer_id, s.service_seq, s.user_code, s.complaint_code, s.cause_code, s.service_code, s.orderhdr_id, s.order_item_seq, (case when  s.complaint_date = '1900-01-01 00:00:00.000' then null else convert(varchar,s.complaint_date,121)end ) as complaint_date , (case when  s.service_date = '1900-01-01 00:00:00.000' then null else convert(varchar,s.service_date,121)end ) as service_date , (case when  s.followup_date = '1900-01-01 00:00:00.000' then null else convert(varchar,s.followup_date,121)end ) as  followup_date, s.service_status, s.subscrip_id, sn.note_field,s.claim_ref_nbr from  service as s join service_note as sn On s.customer_id=sn.customer_id AND s.service_seq=sn.service_seq where s.customer_id = "+customerId +" AND s.service_seq ="+ serviceSeq);
				responseObject = jdbcTemplate.query(query.toString(), new ComplaintServiceMapper());
				
			}catch(Exception e) {
				LOGGER.error("ERROR" + e);
			}
			return responseObject;
		}

		@Override
		public List<DropdownModel> getCondetionCheckServiceFilter(int customerId) {
			LOGGER.info("Inside getCondetionCheckServiceFilter method");
			List<DropdownModel> serviceFilterList = new ArrayList<>();
			try {
				serviceFilterList.add(new DropdownModel("0","ALL",null,null,null,null));
				
				serviceFilterList.add(new DropdownModel("1","Customer",null,null,null,null));
				
				int  count1 = jdbcTemplate.queryForObject("select count(*) from service where subscrip_id IN (SELECT subscrip_id FROM order_item WHERE order_item_type = 0) AND customer_id = " + customerId, Integer.class);
				int  count2 = jdbcTemplate.queryForObject("select count(*) from order_item where  order_item_type=0 AND customer_id = " + customerId, Integer.class);
				if(count1>0 || count2>0) {
					serviceFilterList.add(new DropdownModel("2","Subscription",null,null,null,null));
				}
				
				 count1 = jdbcTemplate.queryForObject("select count(*) from service where  orderhdr_id in (SELECT orderhdr_id FROM order_item WHERE service.orderhdr_id = orderhdr_id AND service.order_item_seq = order_item_seq AND order_item_type = 2) AND customer_id = " + customerId, Integer.class);
				 count2 = jdbcTemplate.queryForObject("select count(*) from order_item where  order_item_type= 2 AND customer_id = " + customerId, Integer.class);
				 if(count1>0 || count2>0) {
					serviceFilterList.add(new DropdownModel("3","Product",null,null,null,null));
				}
				
			    count1 = jdbcTemplate.queryForObject("select count(*) from service where  orderhdr_id in (select orderhdr_id from order_item " + 
			    		"where service.orderhdr_id = orderhdr_id  AND service.order_item_seq = order_item_seq  and order_item_type = 1) AND customer_id = " + customerId, Integer.class);
			    count2 = jdbcTemplate.queryForObject("select count(*) from order_item where  order_item_type= 1 AND customer_id = " + customerId, Integer.class);
			    if(count1>0 || count2>0) {
						serviceFilterList.add(new DropdownModel("4","Single Issue",null,null,null,null));
					}
				
				count1 = jdbcTemplate.queryForObject("select count(*) from service where service.subscrip_id IN " + 
														"(SELECT subscrip_id FROM order_item WHERE order_item_type in (4, 5, 6)) AND customer_id = " + customerId, Integer.class);
				count2 = jdbcTemplate.queryForObject("select count(*) from order_item where  order_item_type in (4, 5, 6) AND customer_id = " + customerId, Integer.class);
				if(count1>0 || count2>0) {
						serviceFilterList.add(new DropdownModel("5","Package",null,null,null,null));
					}
			}catch(Exception e) {
				LOGGER.error("ERROR" + e);
			}
			return serviceFilterList;
		}		
		
		@Override
		public List<Map<String, Object>> getDataAddService(int customerId, Integer orderId, int orderItemSeq,int subscripId,
				int orderItemType) {
			LOGGER.info("Inside getDataAddService method");
			List<Map<String, Object>> data = new ArrayList<>();
			try {
				int custId = jdbcTemplate.queryForObject("SELECT count(customer_id) FROM service WHERE customer_id = "+customerId +" AND orderhdr_id= "+orderId +" AND order_item_seq = " +orderItemSeq , Integer.class);
				if(custId==0) {
					  if(subscripId!=0) {
					   data = jdbcTemplate.queryForList("select customer_id, user_code, isNull(subscrip_id,'')as subscrip_id,orderhdr_id, order_item_seq from order_item where customer_id =" 
							 +customerId+" AND subscrip_id = "+subscripId+ " OR (orderhdr_id="+ orderId + " AND order_item_seq= "+orderItemSeq+")");
				      }if(subscripId==0) {
					   data = jdbcTemplate.queryForList("select customer_id, user_code,orderhdr_id, order_item_seq from order_item where customer_id =" 
							 +customerId+" AND orderhdr_id="+ orderId + " AND order_item_seq= "+orderItemSeq);
				             }
			  }if(custId != 0) {
				  data = jdbcTemplate.queryForList("select isNull(subscrip_id,'') as subscrip_id,user_code,orderhdr_id,order_item_seq from order_item where orderhdr_id ="+orderId);
					
				}
			}catch(Exception e) {
				LOGGER.info(ERROR + e);
				
			}
			return data;
		}

		@Override
		public List<Object> getServiceHistory(Long customerId, int serviceSeq) throws SQLException {
			LOGGER.info("Inside getServiceHistory");
			List<Object> serviceHistory = new ArrayList<Object>();
			try {
				List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM view_edit_hist WHERE customer_id = "+customerId+" and service_seq = "+serviceSeq+" and"
						+ " table_enum = 11 order by creation_date");
				for (Map<String, Object> row : rows) {
					if(row.get("column_name") != null && row.get("column_name").equals("order_status")) {
						row.put("before_change", new PropertyUtilityClass().getConstantValue("order_item.order_status_" +row.get("before_change")));
						row.put("after_change", new PropertyUtilityClass().getConstantValue("order_item.order_status_" +row.get("after_change")));
					}
					else if(row.get("column_name") != null && row.get("column_name").equals("renewal_status")) {
						row.put("before_change", new PropertyUtilityClass().getConstantValue("order_item.renewal_status_" +row.get("before_change")));
						row.put("after_change", new PropertyUtilityClass().getConstantValue("order_item.renewal_status_" +row.get("after_change")));
					}
					else if(row.get("column_name") != null && row.get("column_name").equals("payment_status")) {
						row.put("before_change", new PropertyUtilityClass().getConstantValue("order_item.pay_status_" +row.get("before_change")));
						row.put("after_change",new PropertyUtilityClass().getConstantValue("order_item.pay_status_" + row.get("after_change")));
					}
					else if(row.get("column_name") != null && row.get("column_name").equals("order_date") ||
							row.get("column_name") != null && row.get("column_name").equals("cancel_date")) {
						row.put("before_change", row.get("before_change")!=null
								? new PropertyUtilityClass().getDateFormatter((String) row.get("before_change")) : "");
						row.put("after_change",row.get("after_change") !=null
								? new PropertyUtilityClass().getDateFormatter((String) row.get("after_change")) : "");
					}
					else {
						String before = row.get("before_change")!=null?row.get("before_change").toString():null;
						String after = row.get("after_change")!=null?row.get("after_change").toString():null;
						if(before !=null) {
							if(before.equals("0")) {
								row.put("before_change","False");
							}else if(before.equals("1")) {
								row.put("before_change","True");
							}else {
								row.put("before_change",before);
							}
						}else {
							row.put("before_change",before);
						}
						if(after !=null) {
							if(after.equals("1")) {
								row.put("after_change","True");
							}else if(after.equals("0")) {
								row.put("after_change","False");
							}else {
								row.put("after_change",after);
							}
						}else {
							row.put("after_change",after);
						}
					}
					serviceHistory.add(row);
				}
			} catch (Exception e) {
				LOGGER.error(ERROR + e);
			}
			return serviceHistory;

	   }

	public List<DropdownModel>appendedData(List<Map<String, Object>> list){
		List <DropdownModel> selectedData = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = list;
			 for (Map<String, Object> row :rows) {
				 DropdownModel model = new DropdownModel();
					model.setKey(row.get("report_item_id")!=null?row.get("report_item_id").toString():"");
					model.setDisplay(row.get("title")!=null?row.get("title").toString():"");
					model.setDescription(row.get("description")!=null?row.get("description").toString():"");
					model.setExtra(row.get("name")!=null?row.get("name").toString():"");
					selectedData.add(model);
				}
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return selectedData;
	}
	public List<DropdownModel>appendedZeroData(){
		List <DropdownModel> selectedData = new ArrayList<>();
		try {
				 DropdownModel model = new DropdownModel();
					model.setKey("0");
					model.setDisplay("");
					selectedData.add(model);
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return selectedData;
	}
	@Override
	public String getEmail(Integer customerId) {
		String result = "";
		StringBuilder query = new StringBuilder("select distinct(email) from customer_address where customer_id=").append(customerId).append(" and email is not null order by email");
		try {
			result = jdbcTemplate.queryForObject(query.toString(), String.class);
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return result;
	}

	@Override
	public List<DropdownModel> getSelectedServiceComplaintCode(String complaintCode) {
		List <DropdownModel> selectedData = new ArrayList<>();
		List<Map<String, Object>> rows;
		StringBuilder query = new StringBuilder("select isnull(report_item_id,0)as report_item_id ,title,description,name from view_report_item_lookup where report_item_type=1 and report_item_id =");
		try {
			 if(!complaintCode.equals("null") && !"".equals(complaintCode)) {
				 query.append("(select report_item_id from complaint_code where complaint_code='").append(complaintCode).append("')");
				 rows = jdbcTemplate.queryForList(query.toString());
				 if(rows.size()!=0) {
					 selectedData = appendedData(rows); 
				 }else {
					 selectedData = appendedZeroData();
				 }
			 }else{
				   selectedData = appendedZeroData();
		          }
	       }catch (Exception e) {
			LOGGER.error(ERROR + e);
		   }
		return selectedData;
	}

	@Override
	public List<DropdownModel> getSelectedServiceCauseCode(String causeCode) {
		List <DropdownModel> selectedData = new ArrayList<>();
		List<Map<String, Object>> rows;
		StringBuilder query = new StringBuilder("select isnull(report_item_id,0)as report_item_id ,title,description,name from view_report_item_lookup where report_item_type=1 and report_item_id =");
		try {
			  if(!causeCode.equals("null") && !"".equals(causeCode)){
				 query.append("(select report_item_id from cause_code where cause_code='").append(causeCode).append("')");
				 rows = jdbcTemplate.queryForList(query.toString());
				 if(rows.size()!=0) {
					 selectedData = appendedData(rows); 
				 }else {
					 selectedData = appendedZeroData();
				 }
			}else{
				   selectedData = appendedZeroData();
		         }
	       }catch (Exception e) {
			  LOGGER.error(ERROR + e);
		    }
		return selectedData;
	}

	@Override
	public List<DropdownModel> getSelectedServiceServiceCode(String serviceCode) {
		List <DropdownModel> selectedData = new ArrayList<>();
		List<Map<String, Object>> rows;
		StringBuilder query = new StringBuilder("select isnull(report_item_id,0)as report_item_id ,title,description,name from view_report_item_lookup where report_item_type=1 and report_item_id =");
		try {
			  if(!serviceCode.equals("null") && !"".equals(serviceCode)) {
				query.append("(select report_item_id from service_code where service_code='").append(serviceCode).append("')");
				 rows = jdbcTemplate.queryForList(query.toString());
				 if(rows.size()!=0) {
					 selectedData = appendedData(rows); 
				 }else {
					 selectedData = appendedZeroData();
				 }
				
		      }else{
				   selectedData = appendedZeroData();
		        }
	     }catch (Exception e) {
			LOGGER.error(ERROR + e);
		  }
		return selectedData;
	}

	@Override
	public List<SourceCode> getCatalogSource(String sourceCode ,String orderClass, String generated) {
		List<SourceCode> catalogSourceList = new ArrayList<>();
		try {
			StringBuilder catalogQuery = new StringBuilder();
			catalogQuery.append("SELECT source_code.source_code_id,source_code.source_code,source_code.description,o.oc,source_code.source_code_type,source_code.generated,source_code.offer,source_code.list,source_code.generic_agency FROM source_code left join oc o on o.oc_id=source_code.oc_id WHERE (source_code.active = 1 AND source_code_type = 3 AND (GETDATE() BETWEEN source_code.from_date AND source_code.to_date OR (source_code.to_date IS NULL OR source_code.from_date IS NULL))) ");
			if(!orderClass.equals("")){
				catalogQuery.append(" AND source_code.oc_id = "+orderClass);
			}
			if("*".equals(sourceCode)){
				catalogQuery.append(" AND source_code.source_code like '%'");
				}
			else if(sourceCode.contains("*")){
				catalogQuery.append(" AND source_code.source_code like '"+sourceCode.replace('*','%')+"'");
				}
			else if(!sourceCode.equals("")){
				catalogQuery.append(" AND source_code.source_code ='"+sourceCode+"'");
				}
			if(!generated.equals("")){
				catalogQuery.append(" AND source_code.generated = "+generated);
			}
			catalogQuery.append(" ORDER BY source_code.oc_id,source_code.source_code");
			
			catalogSourceList = jdbcTemplate.query(catalogQuery.toString(), new SourceCodeMapper());	
			
		} catch (Exception e) {
			LOGGER.info("" + e);
		}
		return catalogSourceList;
	}  
	
	@Override
	public List<DropdownModel> getGenerated() {
		List<DropdownModel> generated = new ArrayList<>();
		for (int i = 0; i <= 1; i++) {
			DropdownModel model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("serve_backlabels_" + i));
			generated.add(model);
		}
		return generated;
	}
	
	@Override
	public List<OrderCode> getCatalogOrder(String sourceCodeId, String orderCode ,String orderClass,String orderCodeType,String term) {
		List<OrderCode> catalogOrderList = new ArrayList<>();
		try {
			StringBuilder catalogOrder = new StringBuilder();	
			if(!sourceCodeId.equals("") || !sourceCodeId.isEmpty()) {
				catalogOrder.append(" SELECT order_code.order_code_id,order_code.oc_id,order_code,o.oc,order_code.description,order_code_type,"
						+ " premium,t.term,media,edition,audit_qual_category,product_size,product_style,product_color,pkg_only_item,"
						+ " is_proforma,no_charge,controlled,perpetual_order,prepayment_req,active,subscription_def_id FROM order_code "
						+ " left join oc o on order_code.oc_id=o.oc_id left join term t on order_code.term_id=t.term_id "
						+ " left join catalog_content cc on cc.order_code_id=order_code.order_code_id "
						+ " WHERE (active = 1 and order_code.order_code_type != 3 and order_code.order_code_type != 8 and "
						+ " order_code.order_code_id IN (SELECT DISTINCT order_code_id from catalog_content where "
						+ " source_code_id = " + sourceCodeId + ") and premium != 2)  ");
			
			if((!orderClass.equals("") || !orderClass.isEmpty()) && (!sourceCodeId.equals("") || !sourceCodeId.isEmpty())){
				catalogOrder.append(" AND order_code.oc_id = "+orderClass);
			}
			
			if((!orderCodeType.equals("") || !orderCodeType.isEmpty()) && (!sourceCodeId.equals("") || !sourceCodeId.isEmpty())){
				catalogOrder.append(" AND order_code_type = "+orderCodeType);
			}
			
			if((!term.equals("") || !term.isEmpty()) && (!sourceCodeId.equals("") || !sourceCodeId.isEmpty())){
				catalogOrder.append(" AND term = '"+term+"'");
			}
			
			if("*".equals(orderCode) && (!sourceCodeId.equals("") || !sourceCodeId.isEmpty())){
				catalogOrder.append(" AND order_code.order_code like '%'");}
			
			else if(orderCode.contains("*") && (!sourceCodeId.equals("") || !sourceCodeId.isEmpty())){
				catalogOrder.append(" AND order_code.order_code like '"+orderCode.replace('*','%')+"'");}
			
			else if((!orderCode.equals("") || !orderCode.isEmpty()) && (!sourceCodeId.equals("") || !sourceCodeId.isEmpty())){
				catalogOrder.append(" AND order_code.order_code ='"+orderCode+"'");
				}
			catalogOrder.append(" ORDER BY order_code.oc_id,order_code.order_code");
			}else {
				catalogOrder.append(" SELECT order_code_id,order_code.oc_id,order_code,o.oc,order_code.description,"
						+ " order_code_type,premium,t.term,media,edition,audit_qual_category,product_size,product_style,"
						+ " product_color,pkg_only_item,is_proforma,no_charge,controlled,perpetual_order,prepayment_req,"
						+ " active FROM order_code left join oc o on order_code.oc_id=o.oc_id "
						+ " left join term t on order_code.term_id=t.term_id WHERE (active = 1 and "
						+ " order_code.order_code_type != 3 and order_code.order_code_type != 8 and premium != 2) ");
			
			if((!orderClass.equals("") || !orderClass.isEmpty())){
				catalogOrder.append(" AND order_code.oc_id = "+orderClass);
			}
			
			if(!orderCodeType.equals("") || !orderCodeType.isEmpty()){
				catalogOrder.append(" AND order_code_type = "+orderCodeType);
			}
			
			if(!term.equals("") || !term.isEmpty()){
				catalogOrder.append(" AND term = '"+term+"'");
			}
			
			if("*".equals(orderCode)){
				catalogOrder.append(" AND order_code.order_code like '%'");}
			
			else if(orderCode.contains("*")){
				catalogOrder.append(" AND order_code.order_code like '"+orderCode.replace('*','%')+"'");}
			
			else if(!orderCode.equals("") || !orderCode.isEmpty()){
				catalogOrder.append(" AND order_code.order_code ='"+orderCode+"'");
				}
			catalogOrder.append(" ORDER BY order_code.oc_id,order_code.order_code");
			}
			
			catalogOrderList = jdbcTemplate.query(catalogOrder.toString(), new OrderSourceOfferMapper());	
		} catch (Exception e) {
			LOGGER.info("" + e);
		}
		return catalogOrderList;
	}
}