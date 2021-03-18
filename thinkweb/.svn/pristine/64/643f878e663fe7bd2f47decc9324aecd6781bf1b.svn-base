package com.mps.think.orderFunctionality.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mps.think.daoImpl.PaymentInfoDaoImpl;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderItem;
import com.mps.think.orderFunctionality.dao.OrderFunctionalityDao;
import com.mps.think.orderFunctionality.model.CustomerGroupModel;
import com.mps.think.orderFunctionality.model.DemoModel;
import com.mps.think.orderFunctionality.model.DemographicChildModel;
import com.mps.think.orderFunctionality.model.DemographicsModel;
import com.mps.think.orderFunctionality.model.EditSuspension;
import com.mps.think.orderFunctionality.model.GropDealModel;
import com.mps.think.orderFunctionality.model.GroupMemberModel;
import com.mps.think.orderFunctionality.model.Orderhdr;
import com.mps.think.orderFunctionality.model.ProspectModel;
import com.mps.think.orderFunctionality.model.SuspensionModel;
import com.mps.think.orderFunctionality.model.TransferOrderModel;
import com.mps.think.orderFunctionality.model.OrderItemModel;
import com.mps.think.orderFunctionality.model.UpDowngradeModel;
import com.mps.think.orderFunctionality.resultMapper.SuspensionMapper;
import com.mps.think.orderFunctionality.resultMapper.TransferOrderMapper;
import com.mps.think.orderFunctionality.resultMapper.UpDownGradeMapper;
import com.mps.think.setup.model.SubscriptionDef;
import com.mps.think.setup.util.PropertyUtils;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.PropertyUtilityClass;
import com.mps.think.wsdl.OrderAddWsdl;
import com.mps.think.wsdl.OrderItemDataWsdl;

import Think.XmlWebServices.Order_item_select_responseOrder_item;

@Repository
public class OrderFunctionalityDaoImp implements OrderFunctionalityDao {

	private SimpleDateFormat formatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat formatDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formatYYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentInfoDaoImpl.class);
	private static final String ERROR = "Error";
	private static final String STATE = "state";
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private CustomerUtility customerUtility;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	OrderAddWsdl orderAddWsdl;
	
	@Autowired
	OrderItemDataWsdl  orderItemAddWsdl;
	

	@Override
	public List<Map<String, Object>> getEditOrderHeader(long orderhdrId) {
		List<Map<String, Object>> editOrderHeaderList = new ArrayList<>();
		try {
			editOrderHeaderList = jdbcTemplate.queryForList("SELECT orderhdr_id, CONVERT(VARCHAR(10), order_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), order_date, 22), 11)) as order_date, isNull(cast(po_number as varchar),'') as po_number from orderhdr where orderhdr_id= "+ orderhdrId + " ORDER BY orderhdr_id");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return editOrderHeaderList;
	}

	@Override
	public int updateEditOrderHeader(Orderhdr orderhdr) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder updateQuery = new StringBuilder("update orderhdr set order_date=:order_date, po_number=:po_number where orderhdr_id=:orderhdr_id");
		try {
			updateParams.put("orderhdr_id", orderhdr.getOrderhdrId());
			if (("null".equals(orderhdr.getOrderDate())) || ("".equals(orderhdr.getOrderDate()))) {
				updateParams.put("order_date", null);
			} else {
				updateParams.put("order_date", orderhdr.getOrderDate());
			}
			if (("null".equals(orderhdr.getPoNumber())) | ("".equals(orderhdr.getPoNumber()))) {
				updateParams.put("po_number", null);
			} else {
				updateParams.put("po_number", orderhdr.getPoNumber());
			}
			namedParameterJdbcTemplate.update(updateQuery.toString(), updateParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<SuspensionModel> getTemporarySuspension(long orderhdrId, int orderItemSeq) {
		List<SuspensionModel> temporarySuspensionList = new ArrayList<>();
		StringBuilder query = new StringBuilder("");
		try {
			List<String> order = jdbcTemplate.queryForList("select Top 1 suspension_seq from suspension where orderhdr_id = "+orderhdrId+" and order_item_seq="+orderItemSeq+" and suspended_order_status in (9)" , String.class);
			String order1 = "";
			if(order.size() != 0)
				order1 = order.get(0);
			if(order1.isEmpty() || order1.equals(null) || order1.equals("")) {
				query.append(" select distinct  (case when customer.fname is null then CONVERT(nvarchar(10),customer.customer_id) else customer.fname + ' ' + lname end) AS customer, description,'' as orderhdr_id,'' as order_item_seq,'' as suspension_seq,'' as subscrip_id,'' as user_code,'' as creation_date ,'' as suspension_status, '' as old_order_status, '' as suspended_order_status,'' as suspend_from_date,'' as suspend_to_date,'' as begin_issue_id,'' as end_issue_id,'' as serve_backlabels,'' as n_backlabels,'' as rollback_suspension_status,'' as rollback_old_order_status,'' as rollback_suspend_from_date,'' as rollback_suspend_to_date,'' as rollback_begin_issue_id,'' as rollback_end_issue_id,'' as rollback_serve_backlabels,'' as rollback_n_backlabels,'' as rollback_job_id,'' as mru_suspension_note_seq ,'' as  note_exist "); 
				query.append(" from order_item left join suspension on order_item.orderhdr_id = suspension.orderhdr_id left join order_code on order_item.order_code_id = order_code.order_code_id left join customer on order_item.customer_id = customer.customer_id left join suspension_note sn on sn.orderhdr_id=order_item.orderhdr_id and sn.suspension_seq=suspension.suspension_seq where order_item.orderhdr_id=" + orderhdrId + " and order_item.order_item_seq="+ orderItemSeq );
				temporarySuspensionList = namedParameterJdbcTemplate.query(query.toString(), new SuspensionMapper());
			}else {
				query.append(" select distinct  (case when customer.fname is null then CONVERT(nvarchar(10),customer.customer_id) else customer.fname + ' ' + lname end) AS customer, description,suspension.orderhdr_id,suspension.order_item_seq,suspension.suspension_seq,suspension.subscrip_id,suspension.user_code,STUFF(CONVERT(CHAR(20), suspension.creation_date, 22), 7, 2, YEAR(suspension.creation_date)) as creation_date ,suspension_status, old_order_status, suspended_order_status,CONVERT(VARCHAR, suspend_from_date, 101) as suspend_from_date,CONVERT(VARCHAR, suspend_to_date, 101) as suspend_to_date,begin_issue_id,end_issue_id,serve_backlabels,n_backlabels,rollback_suspension_status,rollback_old_order_status,rollback_suspend_from_date,rollback_suspend_to_date,rollback_begin_issue_id,rollback_end_issue_id,rollback_serve_backlabels,rollback_n_backlabels,rollback_job_id,mru_suspension_note_seq ,(case when note_field is not null then 1 else 0 end)as note_exist "); 
				query.append(" from order_item left join suspension on order_item.orderhdr_id = suspension.orderhdr_id left join order_code on order_item.order_code_id = order_code.order_code_id left join customer on order_item.customer_id = customer.customer_id left join suspension_note sn on sn.orderhdr_id=order_item.orderhdr_id and sn.suspension_seq=suspension.suspension_seq where order_item.orderhdr_id=" + orderhdrId + " and order_item.order_item_seq="+ orderItemSeq+"and suspended_order_status in (9)" );
				temporarySuspensionList = namedParameterJdbcTemplate.query(query.toString(), new SuspensionMapper());
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return temporarySuspensionList;
	}

	@Override
	public EditSuspension getAddTempSuspension(long orderhdrId, int orderItemSeq) {
		EditSuspension editSuspension = new EditSuspension();
		List<Map<String, Object>> addTempSuspensionList = null;
		try {
			String startIssueId = jdbcTemplate.queryForObject(" select max(start_issue_id) as start_issue_id from order_item where orderhdr_id = "
					+ orderhdrId + " and order_item_seq= " + orderItemSeq, String.class);
			StringBuilder query = new StringBuilder("");
			query.append("  select top 1 (case when customer.fname is null then CONVERT(nvarchar(10),customer.customer_id) else customer.fname + ' ' + lname end) AS customer, ");
			if (startIssueId == null) {
				query.append(" CONVERT(VARCHAR, GETDATE(), 101) as start_date ,");  
			}else {
				String issueDate = jdbcTemplate.queryForObject(" select CONVERT(VARCHAR, max(issue_close_date), 101) as date from issue where oc_id=(select oc_id from order_item  where orderhdr_id = "+ orderhdrId + " and order_item_seq= " + orderItemSeq + ")", String.class);
				if ( issueDate == null) {
					query.append(" CONVERT(VARCHAR, start_date, 101) as start_date,");
				}else {
					query.append(" CONVERT(VARCHAR, (SELECT DATEADD(day,1,(select top 1 issue_date from issue where oc_id= (select oc_id from order_item where order_item.orderhdr_id ="+ orderhdrId +" and order_item.order_item_seq= " + orderItemSeq +") and   issue_close_date=(select max(issue_close_date) from issue where oc_id=(select oc_id from order_item where order_item.orderhdr_id =" + orderhdrId + " and order_item.order_item_seq= " + orderItemSeq+")) order by issue_id desc ) ) AS DateAdd ), 101) as start_date,");
				}
			}
			query.append(" '' as expire_date,'1' as serve_backlabels, description, order_item.user_code as user_code from order_item left join order_code on order_item.order_code_id=order_code.order_code_id left join suspension on order_item.orderhdr_id=suspension.orderhdr_id left join customer on order_item.customer_id=customer.customer_id  where order_item.orderhdr_id =" + orderhdrId + " and order_item.order_item_seq = " + orderItemSeq);	
			addTempSuspensionList = jdbcTemplate.queryForList(query.toString());
			for(Map<String, Object> tempSuspension:addTempSuspensionList){	
				editSuspension.setCustomer(tempSuspension.get("customer").toString());
				editSuspension.setStartDate(tempSuspension.get("start_date").toString());
				editSuspension.setExpireDate(tempSuspension.get("expire_date")!=null?tempSuspension.get("expire_date").toString():"");
				editSuspension.setServeBacklabels(Integer.parseInt(tempSuspension.get("serve_backlabels").toString()));
				editSuspension.setDescription(tempSuspension.get("description").toString());
				editSuspension.setUserCode(tempSuspension.get("user_code").toString());
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return editSuspension;
	}

	@Override
	public int saveAddTempSuspension(SuspensionModel suspensionModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder addQuery = new StringBuilder(
				"insert into suspension (orderhdr_id,order_item_seq,suspension_seq,subscrip_id,user_code,creation_date,suspension_status,old_order_status,suspended_order_status,suspend_from_date,suspend_to_date,begin_issue_id,serve_backlabels,n_backlabels,rollback_begin_issue_id, rollback_end_issue_id, rollback_job_id, rollback_n_backlabels, rollback_old_order_status, rollback_serve_backlabels, rollback_suspend_from_date, rollback_suspend_to_date, rollback_suspension_status, mru_suspension_note_seq ) values (:orderhdr_id,:order_item_seq,:suspension_seq,:subscrip_id,:user_code,:creation_date,:suspension_status,:old_order_status,:suspended_order_status,:suspend_from_date,:suspend_to_date,:begin_issue_id,:serve_backlabels,:n_backlabels,:rollback_begin_issue_id, :rollback_end_issue_id, :rollback_job_id, :rollback_n_backlabels, :rollback_old_order_status, :rollback_serve_backlabels, :rollback_suspend_from_date, :rollback_suspend_to_date, :rollback_suspension_status, :mru_suspension_note_seq )");
		try {
			addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
			addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
			String maxSeq = jdbcTemplate.queryForObject("select max(suspension_seq) from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId(),String.class);
			if (maxSeq == null) {
				addParams.put("suspension_seq", 1);
			} else {
				addParams.put("suspension_seq", Integer.parseInt(maxSeq) + 1);
			}
			String userCode = jdbcTemplate.queryForObject("select user_code from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq() , String.class);
			addParams.put("user_code", userCode);
			addParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			String subscripId = jdbcTemplate.queryForObject("select subscrip_id from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("subscrip_id", subscripId);
			addParams.put("suspension_status", 1);
			String oldOrderStatus = jdbcTemplate.queryForObject("select order_status from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("old_order_status", oldOrderStatus);
			addParams.put("suspended_order_status", 9);
			
			String ds2 = suspensionModel.getSuspendFromDate();
			SimpleDateFormat sdf3 = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
			String ds3 = sdf4.format(sdf3.parse(ds2));
			addParams.put("suspend_from_date", ds3);
			addParams.put("serve_backlabels", suspensionModel.getServeBacklabels());
			addParams.put("n_backlabels", 0);
			if (("null".equals(suspensionModel.getSuspendToDate())) | ("".equals(suspensionModel.getSuspendToDate()))) {
				addParams.put("suspend_to_date", null);
			} else {
				String ds1 = suspensionModel.getSuspendToDate();
				SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				String ds4 = sdf2.format(sdf1.parse(ds1));
				addParams.put("suspend_to_date", ds4);
			}
			String issueId = jdbcTemplate.queryForObject("SELECT start_issue_id from order_item where orderhdr_id="+suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(), String.class);
			addParams.put("begin_issue_id", issueId);
			addParams.put("rollback_begin_issue_id", null);
			addParams.put("rollback_end_issue_id", null);
			addParams.put("rollback_job_id", null);
			addParams.put("rollback_n_backlabels", null);
			addParams.put("rollback_old_order_status", null);
			addParams.put("rollback_serve_backlabels", null);
			addParams.put("rollback_suspend_from_date", null);
			addParams.put("rollback_suspend_to_date", null);
			addParams.put("rollback_suspension_status", null);
			addParams.put("mru_suspension_note_seq", null);
			namedParameterJdbcTemplate.update(addQuery.toString(), addParams);
			addParams.clear();

			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;

			StringBuilder editTrail = new StringBuilder(
					"insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,"
							+ "edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name)"
							+ "values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,"
							+ ":edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");

			addParams.put("edit_trail_id", editTrailId);
			String custumerId = jdbcTemplate.queryForObject("select customer_id from order_item where orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("customer_id", custumerId);
			addParams.put("customer_address_seq", 1);
			addParams.put("user_code", userCode);
			addParams.put("subscrip_id", subscripId);
			addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
			addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
			addParams.put("edited", 1);
			String currency = jdbcTemplate.queryForObject("select currency from order_item where orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("currency", currency);
			addParams.put("table_enum", 3);
			addParams.put("document_reference_id", 1);
			String localAmount = jdbcTemplate.queryForObject("select gross_local_amount from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("local_amount", localAmount);
			String baseAmount = jdbcTemplate.queryForObject("select gross_base_amount from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("base_amount", baseAmount);
			addParams.put("date_stamp", dateStamp);
			addParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			addParams.put("xaction_name", "suspension_add_request");
			namedParameterJdbcTemplate.update(editTrail.toString(), addParams);
			customerUtility.updateMruEditTrailId(editTrailId);
			addParams.clear();

			StringBuilder orderItem = new StringBuilder("update order_item set order_status=:order_status,mru_suspension_seq=:mru_suspension_seq where orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq="+ suspensionModel.getOrderItemSeq());
			addParams.put("order_status", 9);
			String mruSuspensionSeq = jdbcTemplate.queryForObject("select max(suspension_seq) from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("mru_suspension_seq", mruSuspensionSeq);
			namedParameterJdbcTemplate.update(orderItem.toString(), addParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public EditSuspension getEditSuspension(long orderhdrId, int orderItemSeq, int suspensionSeq) {
		EditSuspension editSuspension = new EditSuspension();
		List<Map<String, Object>> editSuspensionList = null;
		try {
			
			StringBuilder query = new StringBuilder("");
			query.append("  select top 1 (case when customer.fname is null then CONVERT(nvarchar(10),customer.customer_id) else customer.fname + ' ' + lname end) AS customer, "
					+ "order_item.user_code as user_code,description,old_order_status,suspended_order_status,suspension_status, "
					+ " CONVERT(VARCHAR, suspend_from_date, 101) as suspend_from_date,CONVERT(VARCHAR, suspend_to_date, 101)  as suspend_to_date,serve_backlabels,n_backlabels,"
					+ "suspension_seq,begin_issue_id,end_issue_id,STUFF(CONVERT(CHAR(20), suspension.creation_date, 22), 7, 2, YEAR(suspension.creation_date)) as creation_date "
					+ " from order_item "
					+ " left join order_code on order_item.order_code_id=order_code.order_code_id "
					+ " left join customer on order_item.customer_id=customer.customer_id "
					+ " left join suspension on order_item.orderhdr_id=suspension.orderhdr_id "
					+ " where order_item.orderhdr_id = " + orderhdrId + " and order_item.order_item_seq="
					+ orderItemSeq + " and suspension_seq= " + suspensionSeq);
				editSuspensionList = jdbcTemplate.queryForList(query.toString());
				int alwaysSendIssue = jdbcTemplate.queryForObject("select always_send_backissues from config", Integer.class);
			
				for(Map<String, Object> tempSuspension:editSuspensionList){	
					editSuspension.setCustomer(tempSuspension.get("customer").toString());
					editSuspension.setUserCode(tempSuspension.get("user_code").toString());
					editSuspension.setDescription(tempSuspension.get("description").toString());
					editSuspension.setOldOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_"+tempSuspension.get("old_order_status").toString()));
					editSuspension.setSuspendedOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_"+tempSuspension.get("suspended_order_status").toString()));
					editSuspension.setSuspensionStatus(new PropertyUtilityClass().getConstantValue("suspension_status_"+tempSuspension.get("suspension_status").toString()));
					editSuspension.setStartDate(tempSuspension.get("suspend_from_date").toString());
					editSuspension.setExpireDate(tempSuspension.get("suspend_to_date")!=null?tempSuspension.get("suspend_to_date").toString():"");
					editSuspension.setServeBacklabels(Integer.parseInt(tempSuspension.get("serve_backlabels").toString()));
					editSuspension.setnBacklabels(Integer.parseInt(tempSuspension.get("n_backlabels").toString()));
					editSuspension.setSuspensionSeq(Integer.parseInt(tempSuspension.get("suspension_seq").toString()));
					editSuspension.setStartIssueId(tempSuspension.get("begin_issue_id")!=null?tempSuspension.get("begin_issue_id").toString():"");
					editSuspension.setStopIssueId(tempSuspension.get("end_issue_id")!=null?tempSuspension.get("end_issue_id").toString():"");
					editSuspension.setCreationDate(tempSuspension.get("creation_date")!=null?tempSuspension.get("creation_date").toString():"");
					editSuspension.setAlwaysSendBackissues(alwaysSendIssue);
				}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return editSuspension;
	}

	@Override
	public int updateEditSuspension(SuspensionModel suspensionModel) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		try {
			int suspendedOrder = jdbcTemplate.queryForObject("select top 1 suspended_order_status from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq()+"  order by orderhdr_id,order_item_seq desc", Integer.class);
			if(suspendedOrder == 9) {
				StringBuilder updateQuery = new StringBuilder(
						"update suspension set suspend_to_date=:suspend_to_date,serve_backlabels=:serve_backlabels where orderhdr_id="+ suspensionModel.getOrderhdrId() +" and order_item_seq="+ suspensionModel.getOrderItemSeq() +" and suspension_seq="+suspensionModel.getSuspensionSeq());
				if (("null".equals(suspensionModel.getSuspendToDate())) | "".equals(suspensionModel.getSuspendToDate())) {
					updateParams.put("suspend_to_date", null);
				} else {
					String ds1 = suspensionModel.getSuspendToDate();
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
					String ds2 = sdf2.format(sdf1.parse(ds1));
					updateParams.put("suspend_to_date", ds2);
				}
				updateParams.put("serve_backlabels", "1".equals(suspensionModel.getServeBacklabels())?1:0);
				namedParameterJdbcTemplate.update(updateQuery.toString(), updateParams);
			} else if(suspendedOrder == 8 | suspendedOrder == 10) {
				StringBuilder updateQuery = new StringBuilder("update suspension set serve_backlabels=:serve_backlabels where orderhdr_id="+ suspensionModel.getOrderhdrId() +" and order_item_seq="+ suspensionModel.getOrderItemSeq() +" and suspension_seq="+suspensionModel.getSuspensionSeq());
				updateParams.put("serve_backlabels", "1".equals(suspensionModel.getServeBacklabels())?1:0);
				namedParameterJdbcTemplate.update(updateQuery.toString(), updateParams);
			}else if(suspendedOrder == 16) {
				StringBuilder updateQuery = new StringBuilder(
						"update suspension set suspend_to_date=:suspend_to_date,serve_backlabels=:serve_backlabels where orderhdr_id="+ suspensionModel.getOrderhdrId() +" and order_item_seq="+ suspensionModel.getOrderItemSeq() +" and suspension_seq="+suspensionModel.getSuspensionSeq());
				if (("null".equals(suspensionModel.getSuspendToDate())) | "".equals(suspensionModel.getSuspendToDate())) {
					updateParams.put("suspend_to_date", null);
				} else {
					String ds1 = suspensionModel.getSuspendToDate();
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
					String ds2 = sdf2.format(sdf1.parse(ds1));
					updateParams.put("suspend_to_date", ds2);
				}
				updateParams.put("serve_backlabels", 1);
				namedParameterJdbcTemplate.update(updateQuery.toString(), updateParams);
			}
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public EditSuspension getReinstateOrderItem(long orderhdrId, int orderItemSeq, int suspensionSeq) {
		EditSuspension editSuspension = new EditSuspension();
		List<Map<String, Object>> reinstateOrderItemList = new ArrayList<>();
		try {
				StringBuilder query = new StringBuilder(" select CONCAT(fname, ' ', lname) AS fname,order_code.description as description,order_code.active as active,suspended_order_status, old_order_status,CONVERT(VARCHAR, start_date, 101) as start_date,CONVERT(VARCHAR, expire_date, 101) as expire_date,subscrip.start_issue_id as start_issue_id, '0' as back_issue,suspension_seq,suspension_status,(select CONVERT(varchar,CONVERT(DATE,suspension.creation_date,101),101)) as creation_date, subscrip.stop_issue_id as stop_issue_id,serve_backlabels,n_backlabels,customer.user_code " 
								+ " from order_item "
								+ " left join suspension on order_item.orderhdr_id=suspension.orderhdr_id "
								+ " left join order_code on order_item.order_code_id=order_code.order_code_id "
								+ " left join subscrip on order_item.subscrip_id=subscrip.subscrip_id "
								+ " left join customer on order_item.customer_id=customer.customer_id "
								+ " where order_item.orderhdr_id = " + orderhdrId + " and order_item.order_item_seq=" + orderItemSeq+ " and suspension_seq=" + suspensionSeq);
				reinstateOrderItemList = jdbcTemplate.queryForList(query.toString());
				int alwaysSendIssue = jdbcTemplate.queryForObject("select always_send_backissues from config", Integer.class);
				for(Map<String, Object> tempSuspension:reinstateOrderItemList){	
					editSuspension.setCustomer(tempSuspension.get("fname").toString());
					editSuspension.setDescription(tempSuspension.get("description").toString());
					editSuspension.setActive(Integer.parseInt(tempSuspension.get("active").toString()));
					editSuspension.setSuspendedOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_"+tempSuspension.get("suspended_order_status").toString()));
					editSuspension.setStartDate(tempSuspension.get("start_date")!=null?tempSuspension.get("start_date").toString():"");
					editSuspension.setOldOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_"+tempSuspension.get("old_order_status").toString()));
					editSuspension.setExpireDate(tempSuspension.get("expire_date")!=null?tempSuspension.get("expire_date").toString():"");
					editSuspension.setStartIssueId(tempSuspension.get("start_issue_id")!=null?tempSuspension.get("start_issue_id").toString():"");
					editSuspension.setCreationDate(tempSuspension.get("creation_date").toString());
					editSuspension.setStopIssueId(tempSuspension.get("stop_issue_id")!=null?tempSuspension.get("stop_issue_id").toString():"");
					editSuspension.setServeBacklabels(Integer.parseInt(tempSuspension.get("serve_backlabels").toString()));
					editSuspension.setnBacklabels(Integer.parseInt(tempSuspension.get("n_backlabels").toString()));
					editSuspension.setSuspensionSeq(Integer.parseInt(tempSuspension.get("suspension_seq").toString()));
					editSuspension.setBackIssue(Integer.parseInt(tempSuspension.get("back_issue").toString()));
					editSuspension.setUserCode(tempSuspension.get("user_code").toString());
					editSuspension.setSuspensionStatus(new PropertyUtilityClass().getConstantValue("suspension_status_"+tempSuspension.get("suspension_status").toString()));
					editSuspension.setAlwaysSendBackissues(alwaysSendIssue);
				}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return editSuspension;
	}

	@Override
	public int updateReinstateOrderItem(SuspensionModel suspensionModel) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		try {
			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			StringBuilder editTrail = new StringBuilder(
					"insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name)"
							+ "values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
			updateParams.put("edit_trail_id", editTrailId);
			String custumerId = jdbcTemplate.queryForObject("select customer_id from order_item where orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			updateParams.put("customer_id", custumerId);
			updateParams.put("customer_address_seq", 1);
			String userCode = jdbcTemplate.queryForObject("select user_code from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			updateParams.put("user_code", userCode);
			String subscripId = jdbcTemplate.queryForObject("select subscrip_id from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			updateParams.put("subscrip_id", subscripId);
			updateParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
			updateParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
			updateParams.put("edited", 1);
			String currency = jdbcTemplate.queryForObject("select currency from order_item where orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			updateParams.put("currency", currency);
			updateParams.put("table_enum", 3);
			updateParams.put("document_reference_id", 1);
			String localAmount = jdbcTemplate.queryForObject("select gross_local_amount from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			updateParams.put("local_amount", localAmount);
			String baseAmount = jdbcTemplate.queryForObject("select gross_base_amount from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			updateParams.put("base_amount", baseAmount);
			updateParams.put("date_stamp", dateStamp);
			updateParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			updateParams.put("xaction_name", "suspension_edit_request");
			namedParameterJdbcTemplate.update(editTrail.toString(), updateParams);
			customerUtility.updateMruEditTrailId(editTrailId);
			updateParams.clear();
			
			StringBuilder orderItem = new StringBuilder("update order_item set order_status=0 where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq());
			namedParameterJdbcTemplate.update(orderItem.toString(), updateParams);
			updateParams.clear();
			
			int suspendedOrder = jdbcTemplate.queryForObject("select top 1 suspended_order_status from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by orderhdr_id,order_item_seq desc", Integer.class);
			if(suspendedOrder == 9 || suspendedOrder == 16) {
				StringBuilder suspension = new StringBuilder("");
				suspension.append("update suspension set suspension_status=3, suspend_to_date=:suspend_to_date, serve_backlabels=:serve_backlabels,end_issue_id=:end_issue_id where orderhdr_id="+ suspensionModel.getOrderhdrId() +" and order_item_seq="+ suspensionModel.getOrderItemSeq() +" and suspension_seq="+suspensionModel.getSuspensionSeq());
				String endIssue = jdbcTemplate.queryForObject("select distinct begin_issue_id from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(), String.class);
				updateParams.put("end_issue_id",  endIssue);
				updateParams.put("suspend_to_date",  formatYYYYMMDDHHMMSS.format(new Date()));
				updateParams.put("serve_backlabels",  "1".equals(suspensionModel.getServeBacklabels()) ? 1 : 0);
				namedParameterJdbcTemplate.update(suspension.toString(), updateParams);
			}else if(suspendedOrder == 8 | suspendedOrder == 10) {
				StringBuilder suspension1 = new StringBuilder("");
				suspension1.append("update suspension set suspension_status=3, suspend_to_date=:suspend_to_date, serve_backlabels=1 ,end_issue_id=:end_issue_id where orderhdr_id="+ suspensionModel.getOrderhdrId() +" and order_item_seq="+ suspensionModel.getOrderItemSeq() );
				String endIssue = jdbcTemplate.queryForObject("select distinct begin_issue_id from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(), String.class);
				updateParams.put("end_issue_id",  endIssue);
				updateParams.put("suspend_to_date",  formatYYYYMMDDHHMMSS.format(new Date()));
				namedParameterJdbcTemplate.update(suspension1.toString(), updateParams);
			}
			
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getExtendSubscription(long orderhdrId, int orderItemSeq) {
		List<Map<String, Object>> extendSubscriptionList = new ArrayList<>();
		//String order = "";
		StringBuilder query = new StringBuilder(" ");
		query.append(" select subscrip_id,order_code,description,");
		int revenueMethod = jdbcTemplate.queryForObject("select revenue_method from order_item where orderhdr_id="
				+ orderhdrId + " and order_item_seq=" + orderItemSeq, Integer.class);
		if (revenueMethod == 0) {
			query.append(" isNull(cast(ext_iss_tot as varchar),'') as ext_iss_tot,");
		}else if(revenueMethod == 1){
			query.append(" isNull(cast(extended_days as varchar),'') as ext_iss_tot,");
		}
		query.append(" CONVERT(varchar,CONVERT(DATE,expire_date,101),101) as expire_date,orderhdr_id from order_item left join order_code on order_item.order_code_id=order_code.order_code_id where orderhdr_id=" + orderhdrId + " and order_item_seq=" + orderItemSeq);
		
		try {
			String order = jdbcTemplate.queryForObject("select  CONCAT(order_item.subscrip_id, ' ', order_code.order_code) from order_item left join order_code on order_code.order_code_id = order_item.order_code_id where orderhdr_id=" + orderhdrId + " and order_item_seq=" + orderItemSeq, String.class);
			String desc = jdbcTemplate.queryForObject("select  description from order_item left join order_code on order_code.order_code_id = order_item.order_code_id where orderhdr_id=" + orderhdrId + " and order_item_seq=" + orderItemSeq, String.class);
			extendSubscriptionList = jdbcTemplate.queryForList(query.toString());
			for (Map<String, Object> extend : extendSubscriptionList) {
				extend.put("description", order+"  "+desc);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return extendSubscriptionList;
	}

	@Override
	public Map<String, Object> getExtSubscripChange(long orderhdrId, int orderItemSeq, int count) {
		Map<String, Object> Object = new LinkedHashMap<>();
		try {
			int revenueMethod = jdbcTemplate.queryForObject("select revenue_method from order_item where orderhdr_id="
					+ orderhdrId + " and order_item_seq=" + orderItemSeq, Integer.class);
			if (revenueMethod == 1) {
				String expireDate = jdbcTemplate.queryForObject(" select CONVERT(VARCHAR(10),expire_date, 120) as expire_date from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq,String.class);
				int extendDay = jdbcTemplate.queryForObject(" select extended_days from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq,Integer.class);
				if(count == 0) {
					LocalDate date = LocalDate.parse(expireDate);
					LocalDate addedDate = date.minusDays(extendDay);
					String newDate = addedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
					Object.put("expireDate", newDate);
					extendDay = count;
					Object.put("extendDay", extendDay);
				}else if(extendDay < count) {
					int extend = count-extendDay;
					LocalDate date = LocalDate.parse(expireDate);
					LocalDate addedDate = date.plusDays(extend);
					String newDate = addedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
					Object.put("expireDate", newDate);
					extendDay = count;
					Object.put("extendDay", extendDay);
				}else if(extendDay > count){
					extendDay = extendDay-count;
					int co = extendDay;
					LocalDate date = LocalDate.parse(expireDate);
					LocalDate addedDate = date.minusDays(co);
					String newDate = addedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
					Object.put("expireDate", newDate);
					extendDay = count;
					Object.put("extendDay", extendDay);
				}else if(extendDay == count) {
					String ds1 = expireDate;
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat sdf4 = new SimpleDateFormat("MM/dd/yyyy");
					String ds4 = sdf4.format(sdf1.parse(ds1));
					Object.put("expireDate", ds4);
					extendDay = count;
					Object.put("extendDay", extendDay);
				}
			}
			if (revenueMethod == 0) {
				List<Map<String, Object>> issueList = new ArrayList<>();
				StringBuilder query = new StringBuilder(" select issue_id,CONVERT(VARCHAR, issue_date, 101) as issue_date  from issue where oc_id = (select oc_id from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq +") and issue_id >= (select stop_issue_id from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq +")");
				issueList = jdbcTemplate.queryForList(query.toString());
				for(int i=0;i<=count;i++) {
					if(count != issueList.size()) {
						Object.put("expireDate", issueList.get(count).get("issue_date"));
						Object.put("extendDay", count);
					}
				}
			}
				
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return Object;
	}

	@Override
	public int updateExtendSubscription(long orderhdrId, int orderItemSeq, int count) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		try {
			List<Map<String, Object>> order = null;
			StringBuilder query2 = new StringBuilder("select * from order_item where orderhdr_id=" + orderhdrId+ " and order_item_seq=" + orderItemSeq+" and order_status in (0,5,7,8,9,10,11,12,13)");
			order = jdbcTemplate.queryForList(query2.toString());
			
			int revenueMethod = jdbcTemplate.queryForObject("select revenue_method from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq, Integer.class);
			if (revenueMethod == 1) {
				StringBuilder query = new StringBuilder("update order_item set expire_date=:expire_date, extended_days=:extended_days where orderhdr_id =:orderhdr_id and order_item_seq=:order_item_seq");
				String expireDate = jdbcTemplate.queryForObject(" select CONVERT(VARCHAR(10), expire_date, 101) as expire_date from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq,String.class);
     			int extendDay = jdbcTemplate.queryForObject(" select extended_days from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq,Integer.class);
     			if(count == 0) {
					String ds2 = expireDate;
					SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
					SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
					String ds3 = sdf3.format(sdf2.parse(ds2));
					LocalDate date = LocalDate.parse(ds3);
					LocalDate addedDate = date.minusDays(extendDay);
					String newDate = addedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
					SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
					String ds4 = sdf4.format(sdf1.parse(newDate));
					updateParams.put("expire_date", ds4);
					extendDay = count;
				}else if(extendDay < count) {
					int extend = count-extendDay;
					String ds2 = expireDate;
					SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
					SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
					String ds3 = sdf3.format(sdf2.parse(ds2));
					LocalDate date = LocalDate.parse(ds3);
					LocalDate addedDate = date.plusDays(extend);
					String newDate = addedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
					SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
					String ds4 = sdf4.format(sdf1.parse(newDate));
					updateParams.put("expire_date", ds4);
					extendDay = count;
				}else if(extendDay > count){
					extendDay = extendDay-count;
					int co = extendDay;
					String ds2 = expireDate;
					SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
					SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
					String ds3 = sdf3.format(sdf2.parse(ds2));
					LocalDate date = LocalDate.parse(ds3);
					LocalDate addedDate = date.minusDays(co);
					String newDate = addedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
					SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
					String ds4 = sdf4.format(sdf1.parse(newDate));
					updateParams.put("expire_date", ds4);
					extendDay = count;
				}else if(extendDay == count) {
					String ds1 = expireDate;
					SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
					SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
					String ds4 = sdf4.format(sdf1.parse(ds1));
					updateParams.put("expire_date", ds4);
					extendDay = count;
				}
				updateParams.put("orderhdr_id", orderhdrId);
				updateParams.put("order_item_seq", orderItemSeq);
				updateParams.put("extended_days", extendDay);
				namedParameterJdbcTemplate.update(query.toString(), updateParams);
				updateParams.clear();
				
				Long dateStamp = customerUtility.getmaxDateStamp();
				Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
				StringBuilder editTrail = new StringBuilder("insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name)"
								+ "values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
				updateParams.put("edit_trail_id", editTrailId);
				updateParams.put("customer_id", order.get(0).get("customer_id"));
				updateParams.put("customer_address_seq", order.get(0).get("customer_address_seq"));
				updateParams.put("user_code", order.get(0).get("user_code"));
				updateParams.put("subscrip_id", order.get(0).get("subscrip_id"));
				updateParams.put("orderhdr_id", orderhdrId);
				updateParams.put("order_item_seq", orderItemSeq);
				updateParams.put("edited", 1);
				updateParams.put("currency", order.get(0).get("currency"));
				updateParams.put("table_enum", 3);
				updateParams.put("document_reference_id", 1);
				updateParams.put("local_amount", order.get(0).get("gross_local_amount"));
				updateParams.put("base_amount", order.get(0).get("gross_base_amount"));
				updateParams.put("date_stamp", dateStamp);
				updateParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				updateParams.put("xaction_name", "order_item_edit_request");
				namedParameterJdbcTemplate.update(editTrail.toString(), updateParams);
				customerUtility.updateMruEditTrailId(editTrailId);
			}
			if (revenueMethod == 0) {
				List<Map<String, Object>> issueList = new ArrayList<>();
				StringBuilder query1 = new StringBuilder(" select issue_id,CONVERT(VARCHAR, issue_date, 101) as issue_date  from issue where oc_id = (select oc_id from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq +") and issue_id >= (select stop_issue_id from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq +")");
				issueList = jdbcTemplate.queryForList(query1.toString());
				for(int i=0;i<=count;i++) {
					if(count != issueList.size()) {
						System.out.println(issueList);
					}
				}
				int extIssTot = jdbcTemplate.queryForObject("select ext_iss_tot from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq, Integer.class);
				int nIssuesLeft = jdbcTemplate.queryForObject("select n_issues_left from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq, Integer.class);
				if(count == 0) {
					extIssTot = extIssTot - count;
					nIssuesLeft = nIssuesLeft - count;
				}else if(extIssTot < count) {
					extIssTot = count - extIssTot;
				   nIssuesLeft = nIssuesLeft + extIssTot;
				} else if(extIssTot > count){
					extIssTot = extIssTot - count;
					nIssuesLeft = nIssuesLeft - extIssTot;
				} else if(extIssTot == count){
					nIssuesLeft = nIssuesLeft+0;
				}
				StringBuilder query = new StringBuilder("update order_item set expire_date =:expire_date, stop_issue_id=:stop_issue_id, n_issues_left=:n_issues_left, ext_iss_left=:ext_iss_left, ext_iss_tot=:ext_iss_tot where orderhdr_id =:orderhdr_id and order_item_seq =:order_item_seq");
				updateParams.put("expire_date", issueList.get(count).get("issue_date"));
				updateParams.put("stop_issue_id", issueList.get(count).get("issue_id"));
				updateParams.put("orderhdr_id", orderhdrId);
				updateParams.put("order_item_seq", orderItemSeq);
				updateParams.put("n_issues_left", nIssuesLeft);
				updateParams.put("ext_iss_left", count);
				updateParams.put("ext_iss_tot", count);
				namedParameterJdbcTemplate.update(query.toString(), updateParams);
				updateParams.clear();
				
				StringBuilder subscripQuery = new StringBuilder("update subscrip set n_total_issues_left=:n_total_issues_left where subscrip_id in (select subscrip_id from order_item  where orderhdr_id ="+ orderhdrId + " and order_item_seq =" + orderItemSeq + ")");
				updateParams.put("n_total_issues_left", nIssuesLeft);
				updateParams.put("orderhdr_id", orderhdrId);
				updateParams.put("order_item_seq", orderItemSeq);
				namedParameterJdbcTemplate.update(subscripQuery.toString(), updateParams);
				updateParams.clear();

				Long dateStamp = customerUtility.getmaxDateStamp();
				Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
				StringBuilder editTrail = new StringBuilder("insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name)"
								+ "values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
				updateParams.put("edit_trail_id", editTrailId);
				updateParams.put("customer_id", order.get(0).get("customer_id"));
				updateParams.put("customer_address_seq", order.get(0).get("customer_address_seq"));
				updateParams.put("user_code", order.get(0).get("user_code"));
				updateParams.put("subscrip_id", order.get(0).get("subscrip_id"));
				updateParams.put("orderhdr_id", orderhdrId);
				updateParams.put("order_item_seq", orderItemSeq);
				updateParams.put("edited", 1);
				updateParams.put("currency", order.get(0).get("currency"));
				updateParams.put("table_enum", 3);
				updateParams.put("document_reference_id", 1);
				updateParams.put("local_amount", order.get(0).get("gross_local_amount"));
				updateParams.put("base_amount", order.get(0).get("gross_base_amount"));
				updateParams.put("date_stamp", dateStamp);
				updateParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				updateParams.put("xaction_name", "order_item_edit_request");
				namedParameterJdbcTemplate.update(editTrail.toString(), updateParams);
				customerUtility.updateMruEditTrailId(editTrailId);
				updateParams.clear();
				
			}
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<SuspensionModel> getBehavioralSuspension(long orderhdrId, int orderItemSeq) {
		List<SuspensionModel> behavioralSuspensionList = new ArrayList<>();
		try {
			List<String> order = jdbcTemplate.queryForList("select Top 1 suspension_seq from suspension where orderhdr_id = "+orderhdrId+" and order_item_seq="+orderItemSeq+" and suspended_order_status in (16)" , String.class);
			String order1 = "";
			if(order.size() != 0)
				order1 = order.get(0);
			if(order1.isEmpty() || order1.equals(null) || order1.equals("")) {
				StringBuilder query = new StringBuilder(" select distinct  (case when customer.fname is null then CONVERT(nvarchar(10),customer.customer_id) else customer.fname + ' ' + lname end) AS customer, description,'' as orderhdr_id,'' as order_item_seq,'' as suspension_seq,'' as subscrip_id,'' as user_code,'' as creation_date,'' as suspension_status, '' as old_order_status, '' as suspended_order_status,'' as suspend_from_date,'' as suspend_to_date,'' as begin_issue_id,'' as end_issue_id,'' as serve_backlabels,'' as n_backlabels,'' as rollback_suspension_status,'' as rollback_old_order_status,'' as rollback_suspend_from_date,'' as rollback_suspend_to_date,'' as rollback_begin_issue_id,'' as rollback_end_issue_id,'' as rollback_serve_backlabels,'' as rollback_n_backlabels,'' as rollback_job_id,'' as mru_suspension_note_seq ,'' as note_exist ");  
				query.append(" from order_item left join suspension on order_item.orderhdr_id = suspension.orderhdr_id left join order_code on order_item.order_code_id = order_code.order_code_id left join customer on order_item.customer_id = customer.customer_id left join suspension_note sn on sn.orderhdr_id=order_item.orderhdr_id and sn.suspension_seq=suspension.suspension_seq where order_item.orderhdr_id=" + orderhdrId + " and order_item.order_item_seq="+ orderItemSeq);
				behavioralSuspensionList = namedParameterJdbcTemplate.query(query.toString(), new SuspensionMapper());
			}else {
				StringBuilder query = new StringBuilder(" select distinct  (case when customer.fname is null then CONVERT(nvarchar(10),customer.customer_id) else customer.fname + ' ' + lname end) AS customer, description,suspension.orderhdr_id,suspension.order_item_seq,suspension.suspension_seq,suspension.subscrip_id,suspension.user_code,convert(varchar,suspension.creation_date,103)+' '+convert(varchar,convert(time,suspension.creation_date),22) as creation_date,suspension_status, old_order_status, suspended_order_status,Convert(varchar,CONVERT(date,suspend_from_date,106),103) as suspend_from_date,Convert(varchar,CONVERT(date,suspend_to_date,106),103) as suspend_to_date,begin_issue_id,end_issue_id,serve_backlabels,n_backlabels,rollback_suspension_status,rollback_old_order_status,rollback_suspend_from_date,rollback_suspend_to_date,rollback_begin_issue_id,rollback_end_issue_id,rollback_serve_backlabels,rollback_n_backlabels,rollback_job_id,mru_suspension_note_seq ,(case when note_field is not null then 1 else 0 end)as note_exist ");  
				query.append(" from order_item left join suspension on order_item.orderhdr_id = suspension.orderhdr_id left join order_code on order_item.order_code_id = order_code.order_code_id left join customer on order_item.customer_id = customer.customer_id left join suspension_note sn on sn.orderhdr_id=order_item.orderhdr_id and sn.suspension_seq=suspension.suspension_seq where order_item.orderhdr_id=" + orderhdrId + " and order_item.order_item_seq="+ orderItemSeq+" and suspended_order_status in (16)");
				behavioralSuspensionList = namedParameterJdbcTemplate.query(query.toString(), new SuspensionMapper());
			}
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return behavioralSuspensionList;
	}

	@Override
	public EditSuspension getAddBehavioralSuspension(long orderhdrId, int orderItemSeq) {
		EditSuspension editSuspension = new EditSuspension();
		List<Map<String, Object>> addBehavioralSuspensionList = null;
		try {
			int revenueMethod = jdbcTemplate.queryForObject("select revenue_method from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq, Integer.class);
			if (revenueMethod == 1 | revenueMethod == 2 ) {
				StringBuilder query = new StringBuilder(" select top 1 (case when customer.fname is null then CONVERT(nvarchar(10),customer.customer_id) else customer.fname + ' ' + lname end) AS fname,CONVERT(varchar,getdate(),101) as start_date,'' as expire_date, description,order_item.user_code as user_code from order_item left join order_code on order_item.order_code_id=order_code.order_code_id left join customer on order_item.customer_id=customer.customer_id  where order_item.orderhdr_id =" + orderhdrId + " and order_item.order_item_seq ="+ orderItemSeq);
				addBehavioralSuspensionList = jdbcTemplate.queryForList(query.toString());
				for(Map<String, Object> addBehavioral:addBehavioralSuspensionList){
					editSuspension.setCustomer(addBehavioral.get("fname").toString());
					editSuspension.setStartDate(addBehavioral.get("start_date").toString());
					editSuspension.setExpireDate(addBehavioral.get("expire_date")!=null?addBehavioral.get("expire_date").toString():"");
					editSuspension.setDescription(addBehavioral.get("description").toString());
					editSuspension.setUserCode(addBehavioral.get("user_code").toString());
				}
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return editSuspension;
	}

	@Override
	public int saveAddBehavioralSuspension(SuspensionModel suspensionModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder addQuery = new StringBuilder(
				"insert into suspension (orderhdr_id,order_item_seq,suspension_seq,subscrip_id,user_code,creation_date,suspension_status,old_order_status,suspended_order_status,suspend_from_date,suspend_to_date,begin_issue_id,serve_backlabels,n_backlabels,rollback_begin_issue_id, rollback_end_issue_id, rollback_job_id, rollback_n_backlabels, rollback_old_order_status, rollback_serve_backlabels, rollback_suspend_from_date, rollback_suspend_to_date, rollback_suspension_status, mru_suspension_note_seq ) values (:orderhdr_id,:order_item_seq,:suspension_seq,:subscrip_id,:user_code,:creation_date,1,:old_order_status,16,:suspend_from_date,:suspend_to_date,:begin_issue_id,:serve_backlabels,0,null , null , null , null , null , null , null , null , null , :mru_suspension_note_seq )");
		try {
			addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
			addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
			String maxSeq = jdbcTemplate.queryForObject("select max(suspension_seq) from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId(),String.class);
			if (maxSeq == null) {
				addParams.put("suspension_seq", 1);
			} else {
				addParams.put("suspension_seq", Integer.parseInt(maxSeq) + 1);
			}
			String userCode = jdbcTemplate.queryForObject("select user_code from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("user_code", userCode);
			addParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			String subscripId = jdbcTemplate.queryForObject("select subscrip_id from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("subscrip_id", subscripId);
			String oldOrderStatus = jdbcTemplate.queryForObject("select order_status from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("old_order_status", oldOrderStatus);
			String ds2 = suspensionModel.getSuspendFromDate();
			SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
			String ds3 = sdf4.format(sdf3.parse(ds2));
			addParams.put("suspend_from_date", ds3);
			if (("null".equals(suspensionModel.getSuspendToDate())) | ("".equals(suspensionModel.getSuspendToDate()))) {
				addParams.put("suspend_to_date", null);
			} else {
				String ds1 = suspensionModel.getSuspendToDate();
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				String ds4 = sdf2.format(sdf1.parse(ds1));
				addParams.put("suspend_to_date", ds4);
			}
			addParams.put("serve_backlabels",  0);
			String issueId = jdbcTemplate.queryForObject("SELECT start_issue_id from order_item where orderhdr_id="+suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(), String.class);
			addParams.put("begin_issue_id", issueId);
			addParams.put("mru_suspension_note_seq", null);
			namedParameterJdbcTemplate.update(addQuery.toString(), addParams);
			addParams.clear();
			
			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			StringBuilder editTrail = new StringBuilder("insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name)"
							+ "values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
			addParams.put("edit_trail_id", editTrailId);
			int custumerId = jdbcTemplate.queryForObject("select customer_id from order_item where orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq(),Integer.class);
			addParams.put("customer_id", custumerId);
			addParams.put("customer_address_seq", 1);
			addParams.put("user_code", userCode);
			addParams.put("subscrip_id", subscripId);
			addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
			addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
			addParams.put("edited", 1);
			String currency = jdbcTemplate.queryForObject("select currency from order_item where orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("currency", currency);
			addParams.put("table_enum", 3);
			addParams.put("document_reference_id", 1);
			String localAmount = jdbcTemplate.queryForObject("select gross_local_amount from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("local_amount", localAmount);
			String baseAmount = jdbcTemplate.queryForObject("select gross_base_amount from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("base_amount", baseAmount);
			addParams.put("date_stamp", dateStamp);
			addParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			addParams.put("xaction_name", "suspension_add_request");
			namedParameterJdbcTemplate.update(editTrail.toString(), addParams);
			customerUtility.updateMruEditTrailId(editTrailId);
			addParams.clear();
			
			StringBuilder orderItem = new StringBuilder(
			"update order_item set order_status=:order_status,mru_suspension_seq=:mru_suspension_seq where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq ");
			addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
			addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
			addParams.put("order_status", 16);
			addParams.put("mru_suspension_seq", maxSeq);
			namedParameterJdbcTemplate.update(orderItem.toString(), addParams);	
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public EditSuspension getEditBehavioralSuspension(long orderhdrId, int orderItemSeq,int suspensionSeq) {
		EditSuspension editSuspension = new EditSuspension();
		List<Map<String, Object>> editBehavioralSuspensionList = null;
		try {
			int status = jdbcTemplate.queryForObject("select suspension_status from suspension where orderhdr_id = " + orderhdrId+ " and order_item_seq=" + orderItemSeq + " and suspension_seq= " + suspensionSeq,Integer.class);
			if (status == 1) {
				StringBuilder query = new StringBuilder(" select (case when customer.fname is null then CONVERT(nvarchar(10),customer.customer_id) else customer.fname + ' ' + lname end) AS fname, description, order_status, suspended_order_status,suspension_status,order_item.user_code, CONVERT(varchar,CONVERT(DATE,suspend_from_date,101),101) as start_date, CONVERT(varchar,suspend_to_date,101) as expire_date,suspension.suspension_seq,serve_backlabels,n_backlabels,begin_issue_id,end_issue_id,suspension.creation_date from order_item left join order_code on order_item.order_code_id=order_code.order_code_id left join customer on order_item.customer_id=customer.customer_id left join suspension on order_item.orderhdr_id=suspension.orderhdr_id where suspension.orderhdr_id = " + orderhdrId + " and suspension.order_item_seq="+ orderItemSeq + " and suspension_seq= " + suspensionSeq);
				editBehavioralSuspensionList = jdbcTemplate.queryForList(query.toString());
				for(Map<String, Object> editBehav:editBehavioralSuspensionList){	
					editSuspension.setCustomer(editBehav.get("fname").toString());
					editSuspension.setUserCode(editBehav.get("user_code").toString());
					editSuspension.setDescription(editBehav.get("description").toString());
					editSuspension.setOldOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_"+editBehav.get("order_status").toString()));
					editSuspension.setSuspendedOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_"+editBehav.get("suspended_order_status").toString()));
					editSuspension.setSuspensionStatus(new PropertyUtilityClass().getConstantValue("suspension_status_"+editBehav.get("suspension_status").toString()));
					editSuspension.setStartDate(editBehav.get("start_date").toString());
					editSuspension.setExpireDate(editBehav.get("expire_date")!=null?editBehav.get("expire_date").toString():"");
					editSuspension.setServeBacklabels(Integer.parseInt(editBehav.get("serve_backlabels").toString()));
					editSuspension.setnBacklabels(Integer.parseInt(editBehav.get("n_backlabels").toString()));
					editSuspension.setSuspensionSeq(Integer.parseInt(editBehav.get("suspension_seq").toString()));
					editSuspension.setStartIssueId(editBehav.get("begin_issue_id")!=null?editBehav.get("begin_issue_id").toString():"");
					editSuspension.setStopIssueId(editBehav.get("end_issue_id")!=null?editBehav.get("end_issue_id").toString():"");
					editSuspension.setCreationDate(editBehav.get("creation_date")!=null?editBehav.get("creation_date").toString():"");
				}
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return editSuspension;
	}

	@Override
	public EditSuspension getReinstateBehavioralSuspension(long orderhdrId, int orderItemSeq,int suspensionSeq) {
		EditSuspension editSuspension = new EditSuspension();
		List<Map<String, Object>> reinstateBehavioralSuspensionList = null;
		try {
			int status = jdbcTemplate.queryForObject("select suspension_status from suspension where orderhdr_id = " + orderhdrId + " and order_item_seq=" + orderItemSeq + " and suspension_seq= " + suspensionSeq,Integer.class);
			if (status == 1) {
				StringBuilder query = new StringBuilder("select (case when customer.fname is null then CONVERT(nvarchar(10),customer.customer_id) else customer.fname + ' ' + lname end) AS fname, CONVERT(varchar,CONVERT(DATE,suspension.creation_date,101),101) as creation_date,suspension_status, order_code.description, suspended_order_status, old_order_status, order_code.active, CONVERT(varchar,CONVERT(DATE,suspend_from_date,101),101) as start_date,start_issue_id,stop_issue_id,serve_backlabels,n_backlabels,suspension_seq,order_item.user_code,suspension_status from order_item left join suspension on order_item.orderhdr_id=suspension.orderhdr_id left join order_code on order_item.order_code_id=order_code.order_code_id  left join customer on order_item.customer_id=customer.customer_id  where suspension.orderhdr_id =" + orderhdrId + " and suspension.order_item_seq="+ orderItemSeq + " and suspension_seq=" + suspensionSeq);
				reinstateBehavioralSuspensionList = jdbcTemplate.queryForList(query.toString());
				for(Map<String, Object> tempSuspension:reinstateBehavioralSuspensionList){	
					editSuspension.setCustomer(tempSuspension.get("fname").toString());
					editSuspension.setDescription(tempSuspension.get("description").toString());
					editSuspension.setActive(Integer.parseInt(tempSuspension.get("active").toString()));
					editSuspension.setSuspendedOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_"+tempSuspension.get("suspended_order_status").toString()));
					editSuspension.setStartDate(tempSuspension.get("start_date")!=null?tempSuspension.get("start_date").toString():"");
					editSuspension.setOldOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_"+tempSuspension.get("old_order_status").toString()));
					editSuspension.setExpireDate(tempSuspension.get("expire_date")!=null?tempSuspension.get("expire_date").toString():"");
					editSuspension.setStartIssueId(tempSuspension.get("start_issue_id")!=null?tempSuspension.get("start_issue_id").toString():"");
					editSuspension.setCreationDate(tempSuspension.get("creation_date").toString());
					editSuspension.setStopIssueId(tempSuspension.get("stop_issue_id")!=null?tempSuspension.get("stop_issue_id").toString():"");
					editSuspension.setServeBacklabels(Integer.parseInt(tempSuspension.get("serve_backlabels").toString()));
					editSuspension.setnBacklabels(Integer.parseInt(tempSuspension.get("n_backlabels").toString()));
					editSuspension.setSuspensionSeq(Integer.parseInt(tempSuspension.get("suspension_seq").toString()));
					editSuspension.setUserCode(tempSuspension.get("user_code").toString());
					editSuspension.setSuspensionStatus(new PropertyUtilityClass().getConstantValue("suspension_status_"+tempSuspension.get("suspension_status").toString()));
				}
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return editSuspension;
	}

	@Override
	public int savePayHoldSuspension(SuspensionModel suspensionModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		try {
			List<Map<String, Object>> order = null;
			StringBuilder query = new StringBuilder("select * from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" and order_status in (0,5,7,8,9,10,11,12,13)");
			order = jdbcTemplate.queryForList(query.toString());
			
			StringBuilder addQuery = new StringBuilder("insert into suspension (orderhdr_id,order_item_seq,suspension_seq,subscrip_id,user_code,creation_date,suspension_status,old_order_status,suspended_order_status,suspend_from_date,begin_issue_id,serve_backlabels,n_backlabels,rollback_begin_issue_id, rollback_end_issue_id, rollback_job_id, rollback_n_backlabels, rollback_old_order_status, rollback_serve_backlabels, rollback_suspend_from_date, rollback_suspend_to_date, rollback_suspension_status, mru_suspension_note_seq ) values (:orderhdr_id,:order_item_seq,:suspension_seq,:subscrip_id,:user_code,:creation_date,:suspension_status,:old_order_status,:suspended_order_status,:suspend_from_date,:begin_issue_id,:serve_backlabels,:n_backlabels,:rollback_begin_issue_id, :rollback_end_issue_id, :rollback_job_id, :rollback_n_backlabels, :rollback_old_order_status, :rollback_serve_backlabels, :rollback_suspend_from_date, :rollback_suspend_to_date, :rollback_suspension_status, :mru_suspension_note_seq )");
			addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
			addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
			String maxSeq = jdbcTemplate.queryForObject("select max(suspension_seq) from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId() +" and order_item_seq =" +suspensionModel.getOrderItemSeq() ,String.class);
			if (maxSeq == null) {
				addParams.put("suspension_seq", 1);
			} else {
				addParams.put("suspension_seq", Integer.parseInt(maxSeq) + 1);
			}
			addParams.put("user_code", order.get(0).get("user_code"));
			addParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			addParams.put("subscrip_id", order.get(0).get("subscrip_id"));
			addParams.put("suspension_status", 1);
			addParams.put("old_order_status", order.get(0).get("order_status"));
			addParams.put("suspended_order_status", 10);
			Integer revenueMethod = jdbcTemplate.queryForObject("select revenue_method from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(), Integer.class);
			if(revenueMethod == 1) {
				addParams.put("suspend_from_date", formatYYYYMMDDHHMMSS.format(new Date()));
			}else {
				int orderType = jdbcTemplate.queryForObject("select order_item_type from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(), Integer.class);
				if(orderType == 0) {
					addParams.put("suspend_from_date", order.get(0).get("start_date"));
				}else {
					addParams.put("suspend_from_date", formatYYYYMMDDHHMMSS.format(new Date()));
				}
			}
			addParams.put("serve_backlabels", 1);
			addParams.put("n_backlabels", 0);
			addParams.put("begin_issue_id", order.get(0).get("start_issue_id"));
			addParams.put("rollback_begin_issue_id", null);
			addParams.put("rollback_end_issue_id", null);
			addParams.put("rollback_job_id", null);
			addParams.put("rollback_n_backlabels", null);
			addParams.put("rollback_old_order_status", null);
			addParams.put("rollback_serve_backlabels", null);
			addParams.put("rollback_suspend_from_date", null);
			addParams.put("rollback_suspend_to_date", null);
			addParams.put("rollback_suspension_status", null);
			addParams.put("mru_suspension_note_seq", null);
			namedParameterJdbcTemplate.update(addQuery.toString(), addParams);
			addParams.clear();

			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			StringBuilder editTrail = new StringBuilder("insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name)"
							+ "values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
			addParams.put("edit_trail_id", editTrailId);
			addParams.put("customer_id", order.get(0).get("customer_id"));
			addParams.put("customer_address_seq", 1);
			addParams.put("user_code", order.get(0).get("user_code"));
			addParams.put("subscrip_id", order.get(0).get("subscrip_id"));
			addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
			addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
			addParams.put("edited", 1);
			addParams.put("currency", order.get(0).get("currency"));
			addParams.put("table_enum", 3);
			addParams.put("document_reference_id", 1);
			addParams.put("local_amount", order.get(0).get("gross_local_amount"));
			addParams.put("base_amount", order.get(0).get("gross_base_amount"));
			addParams.put("date_stamp", dateStamp);
			addParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			addParams.put("xaction_name", "suspension_add_request");
			namedParameterJdbcTemplate.update(editTrail.toString(), addParams);
			customerUtility.updateMruEditTrailId(editTrailId);
			addParams.clear();
			
			StringBuilder orderItem = new StringBuilder("update order_item set order_status=:order_status,mru_suspension_seq=:mru_suspension_seq where orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq="+ suspensionModel.getOrderItemSeq());
			addParams.put("order_status", 10);
			String mruSuspensionSeq = jdbcTemplate.queryForObject("select max(suspension_seq) from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("mru_suspension_seq", mruSuspensionSeq);
			namedParameterJdbcTemplate.update(orderItem.toString(), addParams);
			
			List<String> subscrip = jdbcTemplate.queryForList("select subscrip_id from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(), String.class);
			String subId = null;
			if(subscrip.size() != 0)
				subId = subscrip.get(0);
			if(subId != null) {
				StringBuilder addDelete = new StringBuilder("insert into additions_deletions (subscrip_id,additions_deletions_seq,orderhdr_id,order_item_seq,issue_id,customer_id,n_addition_copies,n_deletion_copies,sub_add,sub_kill,sub_kill_reason,sub_on,sub_off,sub_off_reason,sub_start,sub_stop,sub_stop_reason,add_kill_status,creation_date,bundle_qty,start_stop_status) values (:subscrip_id,:additions_deletions_seq,:orderhdr_id,:order_item_seq,:issue_id,:customer_id,:n_addition_copies,:n_deletion_copies,:sub_add,:sub_kill,:sub_kill_reason,:sub_on,:sub_off,:sub_off_reason,:sub_start,:sub_stop,:sub_stop_reason,:add_kill_status,:creation_date,:bundle_qty,:start_stop_status)");
				addParams.put("subscrip_id", order.get(0).get("subscrip_id"));
				String addDelSeq = jdbcTemplate.queryForObject("select max(additions_deletions_seq) from additions_deletions where subscrip_id="+order.get(0).get("subscrip_id"), String.class);
				if (addDelSeq == null) {
					addParams.put("additions_deletions_seq", 1);
				} else {
					addParams.put("additions_deletions_seq", Integer.parseInt(addDelSeq) + 1);
				}
				addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
				addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
				addParams.put("issue_id", order.get(0).get("start_issue_id"));
				addParams.put("customer_id", order.get(0).get("customer_id"));
				addParams.put("n_addition_copies", 0);
				addParams.put("n_deletion_copies", 1);
				addParams.put("sub_add", 0);
				addParams.put("sub_kill", 1);
				addParams.put("sub_kill_reason", 15);
				addParams.put("sub_on", 0);
				addParams.put("sub_off", 1);
				addParams.put("sub_off_reason", 15);
				addParams.put("sub_start", 0);
				addParams.put("sub_stop", 1);
				addParams.put("sub_stop_reason", 15);
				addParams.put("add_kill_status", 0);
				addParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				addParams.put("bundle_qty", 1);
				addParams.put("start_stop_status", 0);
				namedParameterJdbcTemplate.update(addDelete.toString(), addParams);
				addParams.clear();
				
				StringBuilder subscripTab = new StringBuilder("update subscrip set mru_additions_deletions_seq=:mru_additions_deletions_seq where subscrip_id="+ order.get(0).get("subscrip_id"));
				addParams.put("mru_additions_deletions_seq", Integer.parseInt(addDelSeq) + 1);
				namedParameterJdbcTemplate.update(subscripTab.toString(), addParams);
				addParams.clear();
			}
			StringBuilder eventQueue = new StringBuilder("insert into event_queue (event_queue_id,orderhdr_id,order_item_seq,customer_id,customer_address_seq,oc_id,transaction_event,suspension_seq,status,creation_date) values (:event_queue_id,:orderhdr_id,:order_item_seq,:customer_id,:customer_address_seq,:oc_id,:transaction_event,:suspension_seq,:status,:creation_date)");
			Long maxEventQueueId = customerUtility.getMaxEventQueueId() + 1;
			addParams.put("event_queue_id", maxEventQueueId);
			addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
			addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
			addParams.put("customer_id", order.get(0).get("customer_id"));
			addParams.put("customer_address_seq", order.get(0).get("customer_address_seq"));
			addParams.put("oc_id", order.get(0).get("oc_id"));
			addParams.put("transaction_event", 22);
			int seq = jdbcTemplate.queryForObject("select top 1 suspension_seq from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(), Integer.class);
			addParams.put("suspension_seq", seq);
			addParams.put("status", 0);
			addParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			namedParameterJdbcTemplate.update(eventQueue.toString(), addParams);
			customerUtility.updateEventQueueId(maxEventQueueId);
			
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int saveNonPaymentSuspension(SuspensionModel suspensionModel) {
		Map<String, Object> addParams = new LinkedHashMap<>();
		int status = 0;
		try {
			List<String> order = jdbcTemplate.queryForList("select top 1 orderhdr_id from suspension where orderhdr_id="+suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(), String.class);
			String issueId = jdbcTemplate.queryForObject("SELECT start_issue_id from order_item where orderhdr_id="+suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(), String.class);
			if(!order.isEmpty()) {
				StringBuilder suspension = new StringBuilder("update suspension set suspension_status=:suspension_status,suspend_to_date=:suspend_to_date,end_issue_id=:end_issue_id where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq and suspension_seq=:suspension_seq");
						addParams.put("suspension_status", 2);
						addParams.put("suspend_to_date", formatYYYYMMDDHHMMSS.format(new Date()));
						addParams.put("end_issue_id", issueId);
						addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
						addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
						String maxSeq = jdbcTemplate.queryForObject("select max(suspension_seq) from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId(),String.class);
						//addParams.put("suspension_seq", Integer.parseInt(maxSeq) + 1);
						addParams.put("suspension_seq", Integer.parseInt(maxSeq));
						namedParameterJdbcTemplate.update(suspension.toString(), addParams);
			}
			
			List<String> suspensionOrder = jdbcTemplate.queryForList("select suspended_order_status from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq() +" and suspension_seq in (select top 1 suspension_seq from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc)", String.class);
			String susOrder="";
			if(suspensionOrder.size() != 0)
				susOrder = suspensionOrder.get(0);
			List<String> suspensionStatus = jdbcTemplate.queryForList("select suspension_status from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq() +" and suspension_seq in (select top 1 suspension_seq from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc)", String.class);
			String susStatus="";
			if(suspensionStatus.size() != 0)
				susStatus = suspensionStatus.get(0);
			if(susOrder == "10" && susStatus == "1") {
				StringBuilder update = new StringBuilder("update suspension set suspension_status=2,suspend_to_date=:suspend_to_date,end_issue_id=:end_issue_id where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq() +" and suspension_seq in (select top 1 suspension_seq from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq()+" order by suspension_seq desc) ");
				addParams.put("suspend_to_date", formatYYYYMMDDHHMMSS.format(new Date()));
				//String issueId = jdbcTemplate.queryForObject("SELECT start_issue_id from order_item where orderhdr_id="+suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(), String.class);
				addParams.put("end_issue_id", issueId);
				namedParameterJdbcTemplate.update(update.toString(), addParams);
			}
			
		    StringBuilder addQuery = new StringBuilder("insert into suspension (orderhdr_id,order_item_seq,suspension_seq,subscrip_id,user_code,creation_date,suspension_status,old_order_status,suspended_order_status,suspend_from_date,begin_issue_id,serve_backlabels,n_backlabels,rollback_begin_issue_id, rollback_end_issue_id, rollback_job_id, rollback_n_backlabels, rollback_old_order_status, rollback_serve_backlabels, rollback_suspend_from_date, rollback_suspend_to_date, rollback_suspension_status, mru_suspension_note_seq ) values (:orderhdr_id,:order_item_seq,:suspension_seq,:subscrip_id,:user_code,:creation_date,:suspension_status,:old_order_status,:suspended_order_status,:suspend_from_date,:begin_issue_id,:serve_backlabels,:n_backlabels,:rollback_begin_issue_id, :rollback_end_issue_id, :rollback_job_id, :rollback_n_backlabels, :rollback_old_order_status, :rollback_serve_backlabels, :rollback_suspend_from_date, :rollback_suspend_to_date, :rollback_suspension_status, :mru_suspension_note_seq )");
			addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
			addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
			String maxSeq = jdbcTemplate.queryForObject("select max(suspension_seq) from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId(),String.class);
			if (maxSeq == null) {
				addParams.put("suspension_seq", 1);
			} else {
				addParams.put("suspension_seq", Integer.parseInt(maxSeq) + 1);
			}
			String userCode = jdbcTemplate.queryForObject("select user_code from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("user_code", userCode);
			addParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			String subscripId = jdbcTemplate.queryForObject("select subscrip_id from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("subscrip_id", subscripId);
			addParams.put("suspension_status", 1);
			String oldOrderStatus = jdbcTemplate.queryForObject("select order_status from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("old_order_status", oldOrderStatus);
			addParams.put("suspended_order_status", 8);
			Integer revenueMethod = jdbcTemplate.queryForObject("select revenue_method from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(), Integer.class);
			if(revenueMethod == 1) {
				addParams.put("suspend_from_date", formatYYYYMMDDHHMMSS.format(new Date()));
			}else {
				int orderType = jdbcTemplate.queryForObject("select order_item_type from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(), Integer.class);
				if(orderType == 0) {
					String date = jdbcTemplate.queryForObject("select start_date from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(), String.class);
					addParams.put("suspend_from_date", date);
				}else {
					addParams.put("suspend_from_date", formatYYYYMMDDHHMMSS.format(new Date()));
				}
			}
			addParams.put("serve_backlabels", 1);
			addParams.put("n_backlabels", 0);
			
			addParams.put("begin_issue_id", issueId);
			addParams.put("rollback_begin_issue_id", null);
			addParams.put("rollback_end_issue_id", null);
			addParams.put("rollback_job_id", null);
			addParams.put("rollback_n_backlabels", null);
			addParams.put("rollback_old_order_status", null);
			addParams.put("rollback_serve_backlabels", null);
			addParams.put("rollback_suspend_from_date", null);
			addParams.put("rollback_suspend_to_date", null);
			addParams.put("rollback_suspension_status", null);
			addParams.put("mru_suspension_note_seq", null);
			namedParameterJdbcTemplate.update(addQuery.toString(), addParams);
			addParams.clear();
			
			Long dateStamp = customerUtility.getmaxDateStamp();

			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			StringBuilder editTrail = new StringBuilder("insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name)"
							+ "values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
			addParams.put("edit_trail_id", editTrailId);
			String custumerId = jdbcTemplate.queryForObject("select customer_id from order_item where orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("customer_id", custumerId);
			addParams.put("customer_address_seq", 1);
			addParams.put("user_code", userCode);
			addParams.put("subscrip_id", subscripId);
			addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
			addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
			addParams.put("edited", 1);
			String currency = jdbcTemplate.queryForObject("select currency from order_item where orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("currency", currency);
			addParams.put("table_enum", 3);
			addParams.put("document_reference_id", 1);
			String localAmount = jdbcTemplate.queryForObject("select gross_local_amount from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("local_amount", localAmount);
			String baseAmount = jdbcTemplate.queryForObject("select gross_base_amount from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("base_amount", baseAmount);
			addParams.put("date_stamp", dateStamp);
			addParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			addParams.put("xaction_name", "suspension_add_request");
			namedParameterJdbcTemplate.update(editTrail.toString(), addParams);
			customerUtility.updateMruEditTrailId(editTrailId);
			addParams.clear();
			
			StringBuilder orderItem = new StringBuilder("update order_item set order_status=:order_status,mru_suspension_seq=:mru_suspension_seq where orderhdr_id="+ suspensionModel.getOrderhdrId() + " and order_item_seq="+ suspensionModel.getOrderItemSeq());
			addParams.put("order_status", 8);
			String mruSuspensionSeq = jdbcTemplate.queryForObject("select max(suspension_seq) from suspension where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(),String.class);
			addParams.put("mru_suspension_seq", mruSuspensionSeq);
			namedParameterJdbcTemplate.update(orderItem.toString(), addParams);
			addParams.clear();
			
			List<String> subscrip = jdbcTemplate.queryForList("select subscrip_id from order_item where orderhdr_id=" + suspensionModel.getOrderhdrId()+ " and order_item_seq=" + suspensionModel.getOrderItemSeq(), String.class);
			String subId = null;
			if(subscrip.size() != 0)
				subId = subscrip.get(0);
			if(subId != null) {
				StringBuilder addDelete = new StringBuilder("insert into additions_deletions (subscrip_id,additions_deletions_seq,orderhdr_id,order_item_seq,issue_id,customer_id,n_addition_copies,n_deletion_copies,sub_add,sub_kill,sub_kill_reason,sub_on,sub_off,sub_off_reason,sub_start,sub_stop,sub_stop_reason,add_kill_status,creation_date,bundle_qty,start_stop_status) values (:subscrip_id,:additions_deletions_seq,:orderhdr_id,:order_item_seq,:issue_id,:customer_id,:n_addition_copies,:n_deletion_copies,:sub_add,:sub_kill,:sub_kill_reason,:sub_on,:sub_off,:sub_off_reason,:sub_start,:sub_stop,:sub_stop_reason,:add_kill_status,:creation_date,:bundle_qty,:start_stop_status)");
				addParams.put("subscrip_id", subscripId);
				String addDelSeq = jdbcTemplate.queryForObject("select max(additions_deletions_seq) from additions_deletions where subscrip_id="+subscripId, String.class);
				if (addDelSeq == null) {
					addParams.put("additions_deletions_seq", 1);
				} else {
					addParams.put("additions_deletions_seq", Integer.parseInt(addDelSeq) + 1);
				}
				addParams.put("orderhdr_id", suspensionModel.getOrderhdrId());
				addParams.put("order_item_seq", suspensionModel.getOrderItemSeq());
				//String issueId = jdbcTemplate.queryForObject("select start_issue_id from order_item where orderhdr_id="+suspensionModel.getOrderhdrId()+" and order_item_seq="+suspensionModel.getOrderItemSeq(), String.class);
				addParams.put("issue_id", issueId);
				addParams.put("customer_id", custumerId);
				addParams.put("n_addition_copies", 0);
				addParams.put("n_deletion_copies", 1);
				addParams.put("sub_add", 0);
				addParams.put("sub_kill", 1);
				addParams.put("sub_kill_reason", 15);
				addParams.put("sub_on", 0);
				addParams.put("sub_off", 1);
				addParams.put("sub_off_reason", 15);
				addParams.put("sub_start", 0);
				addParams.put("sub_stop", 1);
				addParams.put("sub_stop_reason", 15);
				addParams.put("add_kill_status", 0);
				addParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				addParams.put("bundle_qty", 1);
				addParams.put("start_stop_status", 0);
				namedParameterJdbcTemplate.update(addDelete.toString(), addParams);
				addParams.clear();
				
				StringBuilder subscripQuery = new StringBuilder("update subscrip set mru_additions_deletions_seq=:mru_additions_deletions_seq where subscrip_id=:subscrip_id");
				addParams.put("mru_additions_deletions_seq", Integer.parseInt(addDelSeq) + 1);
				addParams.put("subscrip_id", subscripId);
				namedParameterJdbcTemplate.update(subscripQuery.toString(), addParams);
				addParams.clear();
			}
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<SuspensionModel> getPayHoldNonPaySuspension(long orderhdrId, int orderItemSeq) {
		List<SuspensionModel> payHoldNonPayList = new ArrayList<>();
		try {
			List<String> order = jdbcTemplate.queryForList("select Top 1 suspension_seq from suspension where orderhdr_id = "+orderhdrId+" and order_item_seq="+orderItemSeq+" and suspended_order_status in (8,10)" , String.class);
			String order1 = "";
			if(order.size() != 0)
				order1 = order.get(0);
			if(order1.isEmpty() || order1.equals(null) || order1.equals("")) {
				StringBuilder query = new StringBuilder("");
				query.append(" select distinct  (case when customer.fname is null then CONVERT(nvarchar(10),customer.customer_id) else customer.fname + ' ' + lname end) AS customer, description,'' as orderhdr_id,'' as order_item_seq,'' as suspension_seq,'' as subscrip_id,'' as user_code,'' as creation_date,'' as suspension_status, '' as old_order_status, '' as suspended_order_status,'' as suspend_from_date,'' as suspend_to_date,'' as begin_issue_id,'' as end_issue_id,'' as serve_backlabels,'' as n_backlabels,'' as rollback_suspension_status,'' as rollback_old_order_status,'' as rollback_suspend_from_date,'' as rollback_suspend_to_date,'' as rollback_begin_issue_id,'' as rollback_end_issue_id,'' as rollback_serve_backlabels,'' as rollback_n_backlabels,'' as rollback_job_id,'' as mru_suspension_note_seq ,'' as note_exist ");
				query.append(" from order_item left join suspension on order_item.orderhdr_id = suspension.orderhdr_id left join order_code on order_item.order_code_id = order_code.order_code_id left join customer on order_item.customer_id = customer.customer_id left join suspension_note sn on sn.orderhdr_id=order_item.orderhdr_id and sn.suspension_seq=suspension.suspension_seq where order_item.orderhdr_id=" + orderhdrId + " and order_item.order_item_seq="+ orderItemSeq );
				payHoldNonPayList = namedParameterJdbcTemplate.query(query.toString(), new SuspensionMapper());
			}else {
				StringBuilder query = new StringBuilder("");
				query.append(" select distinct  (case when customer.fname is null then CONVERT(nvarchar(10),customer.customer_id) else customer.fname + ' ' + lname end) AS customer, description,suspension.orderhdr_id,suspension.order_item_seq,suspension.suspension_seq,suspension.subscrip_id,suspension.user_code,convert(varchar,suspension.creation_date,103)+' '+convert(varchar,convert(time,suspension.creation_date),22) as creation_date,suspension_status, old_order_status, suspended_order_status,Convert(varchar,CONVERT(date,suspend_from_date,106),103) as suspend_from_date,Convert(varchar,CONVERT(date,suspend_to_date,106),103) as suspend_to_date,begin_issue_id,end_issue_id,serve_backlabels,n_backlabels,rollback_suspension_status,rollback_old_order_status,rollback_suspend_from_date,rollback_suspend_to_date,rollback_begin_issue_id,rollback_end_issue_id,rollback_serve_backlabels,rollback_n_backlabels,rollback_job_id,mru_suspension_note_seq ,(case when note_field is not null then 1 else 0 end)as note_exist ");
				query.append(" from order_item left join suspension on order_item.orderhdr_id = suspension.orderhdr_id left join order_code on order_item.order_code_id = order_code.order_code_id left join customer on order_item.customer_id = customer.customer_id left join suspension_note sn on sn.orderhdr_id=order_item.orderhdr_id and sn.suspension_seq=suspension.suspension_seq where order_item.orderhdr_id=" + orderhdrId + " and order_item.order_item_seq="+ orderItemSeq+"and suspended_order_status in (8,10)" );
				payHoldNonPayList = namedParameterJdbcTemplate.query(query.toString(), new SuspensionMapper());
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return payHoldNonPayList;
	}
 
	@Override
	public List<SubscriptionDef> getUpgradeSubscription(int subscriptionDefId, int orderCodeId) {
		List<SubscriptionDef> upgradeSubscription = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					" SELECT subscription_def_id,subscription_def,term_id,pub_rotation_id,oc_id, "
							+ " rate_class_id,description,media,edition,renewal_card_id,order_code_id,subscription_category_id,allow_on_internet, "
							+ " tag_line,issn,expire_gap,logical_start,audit_n_grace_issues_allowed,auxiliary_1,auxiliary_2,forced_expire_month, "
							+ " extfree_qty,upgrade_downgrade_value,cancel_policy_id,inactive,premium_order_code_id  "
							+ " FROM subscription_def " + " WHERE inactive = 0 and subscription_def_id != "
							+ subscriptionDefId + " and order_code_id = " + orderCodeId + " and "
							+ " upgrade_downgrade_value >= "
							+ "(select upgrade_downgrade_value from subscription_def where " + " subscription_def_id ="
							+ subscriptionDefId + " and order_code_id = " + orderCodeId + ")");
			upgradeSubscription = jdbcTemplate.query(query.toString(), new UpDownGradeMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return upgradeSubscription;
	}

	@Override
	public List<SubscriptionDef> getUpgradeSearch(UpDowngradeModel upDowngradeModel,int orderSubscriptionDefId) {
		List<SubscriptionDef> upgradeSearch = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
			" select subscription_def.* from subscription_def where (subscription_def.inactive = 0 and order_code_id = (select order_code_id from subscription_def where subscription_def_id = "+ orderSubscriptionDefId+") and subscription_def.upgrade_downgrade_value >= (select upgrade_downgrade_value from subscription_def where subscription_def_id = "+  orderSubscriptionDefId+") and subscription_def.subscription_def_id ! = "+ orderSubscriptionDefId+") ");
			if (upDowngradeModel.getSubscriptionDefId() != null && !"".equals(upDowngradeModel.getSubscriptionDefId())) 
				query.append(" and subscription_def_id =" + upDowngradeModel.getSubscriptionDefId());
			
			if ("*".equals(upDowngradeModel.getSubscriptionDef())) 
				query.append(" and subscription_def LIKE '%'");
			else if (upDowngradeModel.getSubscriptionDef() != null && !"".equals(upDowngradeModel.getSubscriptionDef())) 
				query.append(" and subscription_def LIKE '" + upDowngradeModel.getSubscriptionDef() + "'");
			
			if ("*".equals(upDowngradeModel.getDescription())) 
				query.append(" and description LIKE '%'");
			else if (upDowngradeModel.getDescription() != null && !"".equals(upDowngradeModel.getDescription())) 
				query.append(" and description LIKE '" + upDowngradeModel.getDescription() + "'");
			
			if (upDowngradeModel.getUpgradeDowngradeValue() != null && !"".equals(upDowngradeModel.getUpgradeDowngradeValue())) 
				query.append(" and upgrade_downgrade_value =" + upDowngradeModel.getUpgradeDowngradeValue());
			
			upgradeSearch = jdbcTemplate.query(query.toString(), new UpDownGradeMapper());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return upgradeSearch;
	}

	@Override
	public List<SubscriptionDef> getUpgradeItem(int subscriptionDefId) {
		List<SubscriptionDef> upgradeSubscription = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(" select subscription_def_id,"
					+ " subscription_def,term_id,pub_rotation_id,oc_id, "
					+ " rate_class_id,description,media,edition,renewal_card_id,order_code_id,"
					+ " subscription_category_id,allow_on_internet,tag_line,issn,expire_gap,logical_start,audit_n_grace_issues_allowed,"
					+ " auxiliary_1,auxiliary_2,forced_expire_month,extfree_qty,upgrade_downgrade_value,cancel_policy_id,inactive,"
					+ " premium_order_code_id from subscription_def where subscription_def_id=" + subscriptionDefId);

			upgradeSubscription = jdbcTemplate.query(query.toString(), new UpDownGradeMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return upgradeSubscription;
	}

	@Override
	public List<SubscriptionDef> getDowngradeSubscription(int subscriptionDefId, int orderCodeId) {
		List<SubscriptionDef> downgradeSubscriptionList = null;
		try {
			StringBuilder downGradeQuery = new StringBuilder(
					" SELECT subscription_def_id,subscription_def,term_id,pub_rotation_id, "
							+ " oc_id,rate_class_id,description,media,edition,renewal_card_id,order_code_id,subscription_category_id, "
							+ " allow_on_internet,tag_line,issn,expire_gap,logical_start,audit_n_grace_issues_allowed,auxiliary_1, "
							+ " auxiliary_2,forced_expire_month,extfree_qty,upgrade_downgrade_value,cancel_policy_id,inactive, "
							+ " premium_order_code_id"
							+ " FROM subscription_def "
							+ " WHERE inactive = 0 and subscription_def_id != " + subscriptionDefId + " and "
							+ " order_code_id = " + orderCodeId + " and upgrade_downgrade_value <="
							+ " (select upgrade_downgrade_value " + " from subscription_def where subscription_def_id ="
							+ subscriptionDefId + " and order_code_id = " + orderCodeId + ")");
			downgradeSubscriptionList = jdbcTemplate.query(downGradeQuery.toString(), new UpDownGradeMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return downgradeSubscriptionList;
	}

	@Override
	public List<SubscriptionDef> getDowngradeSearch(UpDowngradeModel upDowngradeModel,int orderSubscriptionDefId) {
		List<SubscriptionDef> downgradeSearch = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					"select subscription_def.* from subscription_def where (subscription_def.inactive = 0 and order_code_id = (select order_code_id from subscription_def where subscription_def_id = "+ orderSubscriptionDefId+") and subscription_def.upgrade_downgrade_value <= (select upgrade_downgrade_value from subscription_def where subscription_def_id = "+  orderSubscriptionDefId+") and subscription_def.subscription_def_id ! = "+ orderSubscriptionDefId+") ");
				
				if (upDowngradeModel.getSubscriptionDefId() != null && !"".equals(upDowngradeModel.getSubscriptionDefId()))
					query.append(" and subscription_def_id LIKE '" + upDowngradeModel.getSubscriptionDefId() + "'");

				if ("*".equals(upDowngradeModel.getSubscriptionDef()))
					query.append(" and subscription_def LIKE '%'");
				else if (upDowngradeModel.getSubscriptionDef() != null && !"".equals(upDowngradeModel.getSubscriptionDef()))
					query.append(" and subscription_def LIKE '" + upDowngradeModel.getSubscriptionDef() + "'");
			
				if (upDowngradeModel.getUpgradeDowngradeValue() != null && !"".equals(upDowngradeModel.getUpgradeDowngradeValue())) 
					query.append(" and upgrade_downgrade_value =" + upDowngradeModel.getUpgradeDowngradeValue());
				
				if ("*".equals(upDowngradeModel.getDescription()))
					query.append(" and description LIKE '%'");
				else if (upDowngradeModel.getDescription() != null && !"".equals(upDowngradeModel.getDescription()))
					query.append(" and description LIKE '" + upDowngradeModel.getDescription() + "'");
			
			downgradeSearch = jdbcTemplate.query(query.toString(), new UpDownGradeMapper());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return downgradeSearch;
	}

	@Override
	public List<OrderItemModel> getTransferOrder(long orderhdrId) {
		List<OrderItemModel> transferOrder = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					" select distinct order_item.orderhdr_id,order_item.order_item_seq,order_code,order_item.user_code,order_item.currency, delivery_method,source_code_id, order_category,package_id,package_content_seq,order_item.date_stamp,"
							+ " order_item_type,order_qty,order_status,order_type,gross_base_amount, gross_local_amount,net_base_amount, net_local_amount,has_been_renewed,has_delivery_charge,CONVERT(varchar ,CONVERT(DATE,bill_date,101),101) "
							+ " as bill_date,isNull(addon_to_order_item_seq,'') as addon_to_order_item_seq,addon_to_orderhdr_id,agency_customer_id,agent_ref_nbr, alt_ship_customer_address_seq,alt_ship_customer_id, alt_ship_del_calc,asynchronous_auto_renew, "
							+ " attach_exist,order_item.audit_name_title_id,order_item.audit_qual_category,order_item.audit_qual_source_id,order_item.audit_sales_channel_id, order_item.audit_subscription_type_id,order_item.auto_payment, auto_renew_notify_sent,backord_qty,bill_to_customer_address_seq, "
							+ " bill_to_customer_id,billing_def, billing_def_test_seq,billing_type,bundle_qty, calendar_unit, CONVERT(VARCHAR(10), cancel_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), cancel_date, 22), 11)) as  "
							+ " cancel_date,cancel_reason, change_qty_flag,charge_on_cancellation,order_item.customer_address_seq, customer_group_id, order_item.customer_id,order_item. deal_id,delivery_method_perm,disc_class_effective_seq, "
							+ " discount_card_seq,order_item.discount_class_id,distribution_method, duration,order_item.electronic_delivery, electronic_document_identifier, exchange_rate,CONVERT(varchar ,CONVERT(DATE,expire_date,101),101) as  expire_date, ext_iss_left,ext_iss_tot, "
							+ " extended_days,extended_rate,order_item.fulfillment_date,generic_promotion_code_seq, group_order,has_premium,has_tax, order_item.installment_plan_id,inventory_id,CONVERT(varchar ,CONVERT(DATE,invoice_date,101),101) as  invoice_date, "
							+ " invoice_id,is_back_ordered, is_complimentary,order_item.is_proforma,order_item.item_url,last_inv_date,last_ren_date, last_tax_invoice_date,manual_disc_amt_base,manual_disc_amt_local, manual_disc_percentage,max_check_out_amt, "
							+ " mru_billing_history_seq,mru_grp_mbr_item_dtl_seq,mru_order_item_amt_break_seq,mru_order_item_note_seq, mru_order_item_sgl_issues_seq, mru_order_item_ship_seq,isNull(cast(mru_suspension_seq as varchar),'') as mru_suspension_seq,mru_unit_history_seq, "
							+ " multiline_disc_amount,multiline_disc_eff_seq, multiline_discount_schedule,n_cal_units_per_seg, n_days_graced,n_del_iss_left,n_inv_efforts,n_issues_left,n_items_per_seg,n_nonpaid_issues, "
							+ " n_remaining_nonpaid_issues,n_remaining_paid_issues, n_ren_effort,n_segments_left,n_tax_updates,note_exist, number_volume_sets,order_item.oc_id, order_item.order_code_id,CONVERT(VARCHAR(10), order_date, 101)  "
							+ " + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), order_date, 22), 11)) as order_date, orig_order_qty, order_item.payment_account_seq, payment_status,percent_of_basic_price,order_item.perpetual_order,pkg_def_id,"
							+ " pkg_item_seq,prem_to_order_item_seq, order_item.prepayment_req,product_id,order_item.pub_rotation_id,qual_date, rate_class_effective_seq,rate_class_id,ratecard_seq,refund_status, renew_to_customer_address_seq, "
							+ " renew_to_customer_id,renewal_category,renewal_def, renewal_def_test_seq,renewal_status,renewed_from_subscrip_id, order_item.revenue_method,segment_expire_date,service_exist,ship_qty,shipping_price_list, squal_date, "
							+ " CONVERT(varchar ,CONVERT(DATE,start_date,101),101) as start_date,start_issue_id,stop_issue_id, order_item.subscrip_id,subscrip_start_type,subscription_def_id,order_item.time_unit_options,total_tax_base_amount, "
							+ " total_tax_local_amount,order_item.trial_period,order_item.trial_type,order_item.unit_excess, order_item.unit_type_id, isNull(customer.fname,'') as fname, isNull(customer.lname,'') as lname, (select concat(address1 ,' ', address2 ,' ', address3,' ',city,' ',state,' ',zip ) as address from customer_address where customer_id = (select customer_id from order_item where orderhdr_id="+orderhdrId+" and order_item_seq=1) and customer_address_seq=(select customer_address_seq from order_item where orderhdr_id="+orderhdrId+" and order_item_seq=1)) as address   from order_item "
							+ " left join customer on customer.customer_id=order_item.customer_id left join order_code on order_code.order_code_id=order_item.order_code_id where order_item.orderhdr_id="+ orderhdrId);
			transferOrder = jdbcTemplate.query(query.toString(), new TransferOrderMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return transferOrder;
	}

	@Override
	public int saveTransferOrder(TransferOrderModel transferOrderModel) {
		Map<String, Object> saveParams = new LinkedHashMap<>();
		int status = 0;
		
		try {
			StringBuilder saveQuery = new StringBuilder("insert into customer_note (customer_id,customer_note_seq,user_code,creation_date,note_field) values (:customer_id,:customer_note_seq,:user_code,:creation_date,:note_field)");
			String description = jdbcTemplate.queryForObject("select isNull(description,'') as description  from oc where oc_id = (select oc_id from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+" and order_item_seq="+transferOrderModel.getOrderItemSeq()+")",String.class);
			String userCode = jdbcTemplate.queryForObject("select user_code from customer where customer_id="+transferOrderModel.getCustomerId(), String.class);
			int custId = jdbcTemplate.queryForObject("select customer_id from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+" and order_item_seq="+transferOrderModel.getOrderItemSeq(), Integer.class);
			saveParams.put("customer_id", custId);
			String maxCustomerNoteSeq = jdbcTemplate.queryForObject("select max(customer_note_seq) from customer_note where customer_id="+ custId, String.class);
			if (maxCustomerNoteSeq == null) {
				saveParams.put("customer_note_seq", 1);
			} else {
				saveParams.put("customer_note_seq", Integer.parseInt(maxCustomerNoteSeq) + 1);
			}
			saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			String name = jdbcTemplate.queryForObject("select distinct concat(fname,' ',lname) as name from customer where customer_id="+transferOrderModel.getCustomerId(), String.class);
			String noteField = " Order # " + transferOrderModel.getOrderhdrId() + " Line "+ transferOrderModel.getOrderItemSeq() +"  ("+description + ") " + "transferred to customer "+ transferOrderModel.getCustomerId() + "  ("+name+")  " + " on " + new Date() + " by "+ userCode;
			saveParams.put("note_field", noteField);
			saveParams.put("user_code", userCode);
			namedParameterJdbcTemplate.update(saveQuery.toString(), saveParams);
			saveParams.clear();

			StringBuilder orderItemNoteQuery = new StringBuilder(
					"insert into order_item_note (orderhdr_id,order_item_seq,order_item_note_seq,user_code,creation_date,note_field) values (:orderhdr_id,:order_item_seq,:order_item_note_seq,:user_code,:creation_date,:note_field)");
			saveParams.put("orderhdr_id", transferOrderModel.getOrderhdrId());
			saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			String name2 = jdbcTemplate.queryForObject("select distinct concat(fname,' ',lname) as name from customer where customer_id="+custId, String.class);
			String noteField2 = " Order # " + transferOrderModel.getOrderhdrId() + " Line "+ transferOrderModel.getOrderItemSeq() +"  ("+description + ") " + "transferred from customer "+ custId + "  ("+name2+")  " + " on " + new Date() + " by "+ userCode;
			saveParams.put("note_field", noteField2);
			saveParams.put("user_code", userCode);
			String maxOrderItemNoteSeq = jdbcTemplate.queryForObject("select max(order_item_note_seq) from order_item_note where orderhdr_id="+ transferOrderModel.getOrderhdrId(), String.class);
			if (maxOrderItemNoteSeq == null) {
				saveParams.put("order_item_note_seq", 1);
			} else {
				saveParams.put("order_item_note_seq", Integer.parseInt(maxOrderItemNoteSeq) + 1);
			}
			saveParams.put("order_item_seq", transferOrderModel.getOrderItemSeq());
			namedParameterJdbcTemplate.update(orderItemNoteQuery.toString(), saveParams);
			saveParams.clear();

			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			StringBuilder editTrailQuery = new StringBuilder(
					"insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name) values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
			saveParams.put("edit_trail_id", editTrailId);
			saveParams.put("orderhdr_id",transferOrderModel.getOrderhdrId());
			saveParams.put("customer_id",transferOrderModel.getCustomerId());
			saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			saveParams.put("user_code", userCode);
			saveParams.put("order_item_seq",transferOrderModel.getOrderItemSeq());
			String amount = jdbcTemplate.queryForObject("select gross_base_amount from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+ " and order_item_seq="+transferOrderModel.getOrderItemSeq(), String.class);
			saveParams.put("base_amount",amount);
			
			String currency = jdbcTemplate.queryForObject("select currency from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+ " and order_item_seq="+transferOrderModel.getOrderItemSeq(), String.class);
			saveParams.put("currency",currency);
			saveParams.put("customer_address_seq",transferOrderModel.getCustomerAddressSeq());
			int dateStamp = jdbcTemplate.queryForObject("select date_stamp from date_stamp where date_stamp = (select max(date_stamp) from date_stamp)",Integer.class);
			saveParams.put("date_stamp", dateStamp);
			saveParams.put("document_reference_id", 1);
			saveParams.put("edited", 1);
			saveParams.put("local_amount",amount);
			String subscripId = jdbcTemplate.queryForObject("select subscrip_id from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+ " and order_item_seq="+transferOrderModel.getOrderItemSeq(), String.class);
			saveParams.put("subscrip_id",subscripId);
			saveParams.put("table_enum",3);
			saveParams.put("xaction_name", "order_transfer_request");
			namedParameterJdbcTemplate.update(editTrailQuery.toString(), saveParams);
			customerUtility.updateMruEditTrailId(editTrailId);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int updateTransferOrder(TransferOrderModel transferOrderModel) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		try {
			StringBuilder saveQuery = new StringBuilder("update customer set mru_customer_note_seq=:mru_customer_note_seq where customer_id=:customer_id");
			int custId = jdbcTemplate.queryForObject("select customer_id from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+" and order_item_seq="+transferOrderModel.getOrderItemSeq(), Integer.class);
			updateParams.put("customer_id", custId);
			int custNoteSeq = jdbcTemplate.queryForObject("select max(customer_note_seq) from customer_note where customer_id="+custId, Integer.class);
			updateParams.put("mru_customer_note_seq",custNoteSeq);
			namedParameterJdbcTemplate.update(saveQuery.toString(), updateParams);
			updateParams.clear();

			StringBuilder orderItem = new StringBuilder("update order_item set bill_to_customer_id=:bill_to_customer_id,bill_to_customer_address_seq=:bill_to_customer_address_seq,renew_to_customer_id=:renew_to_customer_id,renew_to_customer_address_seq=:renew_to_customer_address_seq,customer_id=:customer_id,note_exist=:note_exist,mru_order_item_note_seq=:mru_order_item_note_seq where orderhdr_id=:orderhdr_id ");
			updateParams.put("orderhdr_id", transferOrderModel.getOrderhdrId());
			updateParams.put("customer_id", transferOrderModel.getCustomerId());
			updateParams.put("bill_to_customer_id", transferOrderModel.getBillToCustomerId());
			updateParams.put("bill_to_customer_address_seq", transferOrderModel.getBillToCustAddSeq());
			updateParams.put("renew_to_customer_id", transferOrderModel.getRenewToCustomerId());
			updateParams.put("renew_to_customer_address_seq", transferOrderModel.getRenewToCustAddSeq());
			updateParams.put("note_exist", 1);
			//updateParams.put("order_item_seq", transferOrderModel.getOrderItemSeq());
			int orderItemNoteSeq = jdbcTemplate.queryForObject("select max(order_item_note_seq) from order_item_note where orderhdr_id="+transferOrderModel.getOrderhdrId()+" and order_item_seq="+transferOrderModel.getOrderItemSeq(), Integer.class);
			updateParams.put("mru_order_item_note_seq", orderItemNoteSeq);
			namedParameterJdbcTemplate.update(orderItem.toString(), updateParams);
			updateParams.clear();

			String subscripId = jdbcTemplate.queryForObject("select subscrip_id from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+ " and order_item_seq="+transferOrderModel.getOrderItemSeq(), String.class);
			StringBuilder subscrip = new StringBuilder("update subscrip set customer_id=:customer_id where subscrip_id="+subscripId);
			updateParams.put("customer_id", transferOrderModel.getCustomerId());
			namedParameterJdbcTemplate.update(subscrip.toString(), updateParams);
			updateParams.clear();
			
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<DropdownModel> getAutoPayCreditCard(long orderhdrId, int orderItemSeq) {
		List<DropdownModel> autoPayCreditCard = new ArrayList<>();
		try {
			List<Map<String, Object>> creditCard = jdbcTemplate.queryForList(" select payment_account_seq,description,id_nbr_last_four FROM payment_account WHERE payment_type in (select payment_type from payment_type where payment_form = 1) and customer_id=(select customer_id from order_item where orderhdr_id="+orderhdrId+" and order_item_seq="+orderItemSeq+")");
			for (Map<String, Object> card : creditCard) {
				DropdownModel model = new DropdownModel();
				model.setKey(card.get("payment_account_seq").toString());
				model.setDisplay(card.get("description") != null ? card.get("description").toString() : "");
				model.setDescription(card.get("id_nbr_last_four") != null ? card.get("id_nbr_last_four").toString() : "");
				autoPayCreditCard.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return autoPayCreditCard;
	}

	@Override
	public List<DropdownModel> getAutoPayDirectDebit(long orderhdrId, int orderItemSeq) {
		List<DropdownModel> autoPayDirectDebit = new ArrayList<>();
		try {
			List<Map<String, Object>> directDebit = jdbcTemplate.queryForList(" select payment_account_seq,description,id_nbr_last_four FROM payment_account WHERE payment_type in (select payment_type from payment_type where payment_form = 4) and customer_id=(select customer_id from order_item where orderhdr_id="+orderhdrId+" and order_item_seq="+orderItemSeq+")");
			for (Map<String, Object> card : directDebit) {
				DropdownModel model = new DropdownModel();
				model.setKey(card.get("payment_account_seq").toString());
				model.setDisplay(card.get("description") != null ? card.get("description").toString() : "");
				model.setDescription(card.get("id_nbr_last_four") != null ? card.get("id_nbr_last_four").toString() : "");
				autoPayDirectDebit.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return autoPayDirectDebit;
	}

	@Override
	public List<DropdownModel> getCancelReason() {
		List<DropdownModel> cancelReason = new ArrayList<>();
		try {
			List<Map<String, Object>> reason = jdbcTemplate.queryForList(" select cancel_reason,description from cancel_reason where active = 1 and cancel_type in (0,2) and applies_to_any_oc = 1");
			for (Map<String, Object> reasons : reason) {
				DropdownModel model = new DropdownModel();
				model.setKey(reasons.get("cancel_reason").toString());
				model.setDisplay(reasons.get("description") != null ? reasons.get("description").toString() : "");
				cancelReason.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return cancelReason;
	}

	@Override
	public List<Map<String, Object>> getRenewalOption(long orderhdrId, int orderItemSeq, int renewalStatus,
			String autoPayment) {
		List<Map<String, Object>> renewalOption = null;
		StringBuilder sendRenewalQuery = new StringBuilder();
		try {

			if (renewalStatus == 0) {
				sendRenewalQuery.append(" select renewal_status,order_item.auto_payment,cancel_reason,order_code.description as order_description from order_item left join order_code on order_code.order_code_id=order_item.order_code_id where orderhdr_id=" + orderhdrId + " and order_item_seq=" + orderItemSeq);
			}
			if (renewalStatus == 1) {
				sendRenewalQuery.append(" select  renewal_status,order_item.auto_payment,order_code.description as order_description,isnull(order_item.cancel_reason,'') as cancel_reason,isnull(cancel_reason.description,'' )as cancel_description from order_item left join order_code on order_code.order_code_id=order_item.order_code_id left join cancel_reason on cancel_reason.cancel_reason = order_item.cancel_reason where orderhdr_id=" + orderhdrId + " and order_item_seq=" + orderItemSeq);
			}
			if (renewalStatus == 2) {
				if (autoPayment.equals("0")) {
					sendRenewalQuery.append(" select renewal_status,order_item.auto_payment,cancel_reason,order_code.description as order_description from order_item left join order_code on order_code.order_code_id=order_item.order_code_id where orderhdr_id=" + orderhdrId + " and order_item_seq=" + orderItemSeq);
				}
				if (autoPayment.equals("1")) {
					sendRenewalQuery.append(" select renewal_status,order_item.auto_payment,cancel_reason,order_code.description as order_description, isnull(convert(varchar,payment_account.payment_account_seq),'') as payment_account_seq, isnull(payment_account.description,'') as payment_description from order_item left join order_code on order_code.order_code_id=order_item.order_code_id left join payment_account on payment_account.payment_account_seq=order_item.payment_account_seq and payment_type in (select payment_type from payment_type where payment_form = 1) where orderhdr_id=" + orderhdrId + " and order_item_seq=" + orderItemSeq);
				}
				if (autoPayment.equals("2")) {
					sendRenewalQuery.append(" select renewal_status,order_item.auto_payment,cancel_reason,order_code.description as order_description, isnull(convert(varchar,payment_account.payment_account_seq),'') as payment_account_seq, isnull(payment_account.description,'') as payment_description from order_item left join order_code on order_code.order_code_id=order_item.order_code_id left join payment_account on payment_account.payment_account_seq=order_item.payment_account_seq and payment_type in (select payment_type from payment_type where payment_form = 4) where orderhdr_id=" + orderhdrId + " and order_item_seq=" + orderItemSeq);
				}
			}
			renewalOption = jdbcTemplate.queryForList(sendRenewalQuery.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return renewalOption;
	}

	@Override
	@Transactional
	public int updateRenewalOption(OrderItem orderItem) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		int renStatus = orderItem.getRenewalStatus();
		try {
			StringBuilder updateQuery = new StringBuilder("update order_item set  renewal_status=:renewal_status ");
			if (renStatus == 0) {
				updateQuery.append(",payment_account_seq =null,cancel_reason=null ");
			}
			if (renStatus == 1) {
				updateQuery.append(",cancel_reason=:cancel_reason, payment_account_seq =null ");
			}
			if (renStatus == 2) {
				int autoPaymt = orderItem.getAutoPayment();
				if (autoPaymt == 0) {
					updateQuery.append(", auto_payment =:auto_payment, payment_account_seq =null,cancel_reason=null ");
				}
				if (autoPaymt == 1) {
					updateQuery.append(", payment_account_seq =:payment_account_seq, auto_payment =:auto_payment, cancel_reason=null ");
				}
				if (autoPaymt == 2) {
					updateQuery.append(", payment_account_seq =:payment_account_seq, auto_payment =:auto_payment, cancel_reason=null ");
				}
			}
			updateQuery.append("where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq");
			updateParams.put("orderhdr_id", orderItem.getOrderhdrId());
			updateParams.put("order_item_seq", orderItem.getOrderItemSeq());
			if (("null".equals(orderItem.getPaymentAccountSeq())) | ("".equals(orderItem.getPaymentAccountSeq()))) {
				updateParams.put("payment_account_seq", null);
			} else {
				updateParams.put("payment_account_seq", orderItem.getPaymentAccountSeq());
			}
			updateParams.put("auto_payment",orderItem.getAutoPayment()!=0?orderItem.getAutoPayment():"");
			updateParams.put("renewal_status",orderItem.getRenewalStatus() );
			if (("null".equals(orderItem.getCancelReason())) | ("".equals(orderItem.getCancelReason()))) {
				updateParams.put("cancel_reason", null);
			} else {
				updateParams.put("cancel_reason", orderItem.getCancelReason());
			}
			namedParameterJdbcTemplate.update(updateQuery.toString(), updateParams);
			updateParams.clear();
			
			StringBuilder editTrailQuery = new StringBuilder("insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name) values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
//			String maxEditTrailId = jdbcTemplate.queryForObject("select max(edit_trail_id) from edit_trail",String.class);
//			if (maxEditTrailId == null) {
//				updateParams.put("edit_trail_id", 1);
//			} else {
//				updateParams.put("edit_trail_id", Integer.parseInt(maxEditTrailId) + 1);
//			}
			Long maxEditTrailId = customerUtility.getmaxeditTrailId() + 1;
			updateParams.put("edit_trail_id", maxEditTrailId);
			updateParams.put("orderhdr_id",orderItem.getOrderhdrId());
			updateParams.put("order_item_seq",orderItem.getOrderItemSeq());
			int customerId = jdbcTemplate.queryForObject("select customer_id from order_item where orderhdr_id="+ orderItem.getOrderhdrId()+ " and  order_item_seq=" + orderItem.getOrderItemSeq(), Integer.class);
			updateParams.put("customer_id",customerId);
			updateParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			String userCode = jdbcTemplate.queryForObject("select user_code from order_item where orderhdr_id=" + orderItem.getOrderhdrId() + " and order_item_seq=" + orderItem.getOrderItemSeq(),String.class);
			updateParams.put("user_code", userCode);
			updateParams.put("order_item_seq",orderItem.getOrderItemSeq());
			
			String amount = jdbcTemplate.queryForObject("select gross_base_amount from order_item where orderhdr_id=" + orderItem.getOrderhdrId()+ " and order_item_seq=" + orderItem.getOrderItemSeq(),String.class);
			updateParams.put("base_amount",amount);
			String currency = jdbcTemplate.queryForObject("select currency from order_item where orderhdr_id=" + orderItem.getOrderhdrId()+ " and order_item_seq=" + orderItem.getOrderItemSeq(),String.class);
			updateParams.put("currency", currency);
			updateParams.put("customer_address_seq",1);
			int dateStamp = jdbcTemplate.queryForObject("select date_stamp from date_stamp where date_stamp = (select max(date_stamp) from date_stamp)",Integer.class);
			updateParams.put("date_stamp", dateStamp);
			updateParams.put("document_reference_id", 1);
			updateParams.put("edited", 1);
			updateParams.put("local_amount", amount);
			String subscripId = jdbcTemplate.queryForObject("select subscrip_id from order_item where orderhdr_id=" + orderItem.getOrderhdrId()+ " and order_item_seq=" + orderItem.getOrderItemSeq(),String.class);
			updateParams.put("subscrip_id",subscripId);
			updateParams.put("table_enum", 3);
			updateParams.put("xaction_name", "order_item_edit_request");
			namedParameterJdbcTemplate.update(editTrailQuery.toString(), updateParams);
			customerUtility.updateMruEditTrailId(maxEditTrailId);
			updateParams.clear();

			StringBuilder eventQueueQuery = new StringBuilder("insert into event_queue (event_queue_id,orderhdr_id,order_item_seq,customer_id,customer_address_seq,oc_id,transaction_event,status,creation_date) values (:event_queue_id,:orderhdr_id,:order_item_seq,:customer_id,:customer_address_seq,:oc_id,:transaction_event,:status,:creation_date)");
//			String maxEventQueueId = jdbcTemplate.queryForObject("select max(event_queue_id) from event_queue ",String.class);
//			if (maxEventQueueId == null) {
//				updateParams.put("event_queue_id", 1);
//			} else {
//				updateParams.put("event_queue_id", Integer.parseInt(maxEventQueueId) + 1);
//			}
			Long maxEventQueueId = customerUtility.getMaxEventQueueId() + 1;
			updateParams.put("event_queue_id", maxEventQueueId);
			updateParams.put("orderhdr_id",orderItem.getOrderhdrId());
			updateParams.put("order_item_seq",orderItem.getOrderItemSeq());
			updateParams.put("customer_id",customerId);
			updateParams.put("customer_address_seq",1);
			String ocId = jdbcTemplate.queryForObject("select oc_id from order_item where orderhdr_id=" + orderItem.getOrderhdrId()+ " and order_item_seq=" + orderItem.getOrderItemSeq(),String.class);
			updateParams.put("oc_id", ocId);
			updateParams.put("transaction_event", 24);
			updateParams.put("status", 0);
			updateParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			namedParameterJdbcTemplate.update(eventQueueQuery.toString(), updateParams);
			customerUtility.updateEventQueueId(maxEventQueueId);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<DropdownModel> getGroupGroup() {
		List<DropdownModel> group = new ArrayList<>();
		try {
			List<Map<String, Object>> Group = jdbcTemplate.queryForList(" select customer_group,description from customer_group ");
			for (Map<String, Object> groups : Group) {
				DropdownModel model = new DropdownModel();
				model.setKey(groups.get("customer_group").toString());
				model.setDisplay(groups.get("description") != null ? groups.get("description").toString() : "");
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return group;
	}

	@Override
	public List<Map<String, Object>> getGroupMember(Long customerId) {
		List<Map<String, Object>> groupMember = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(" select group_member.customer_id,fname,lname,isnull(company,'') as company,n_copies,active,customer_group_customer_id,group_member.customer_address_seq,authorized,(SELECT Top 1 group_order FROM order_item_with_aux WHERE order_status in (0,5,7,8,9,10,11,12,13) and group_order = 1 and customer_id = 230) as group_order from group_member left join customer on customer.customer_id=group_member.customer_id where group_member.customer_group_customer_id="+customerId);
			groupMember = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return groupMember;
	}

	@Override
	public List<GroupMemberModel> getGrpMbrSetUp() {
		GroupMemberModel model =new GroupMemberModel();
		List<GroupMemberModel> groupMemberSetUp = new ArrayList<>();
		try {
			model.setCustomerId(0);
			model.setCustomerName("");
			model.setAddressToUse("0");
			model.setAddress("");
			model.setnCopies(1);
			model.setActive(1);
			model.setAuthorized(1);
			groupMemberSetUp.add(model);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return groupMemberSetUp;
	}

	@Override
	public List<DropdownModel> getAddress(int customerId) {
		List<DropdownModel> address = new ArrayList<>();
		try {
			List<Map<String, Object>> Address = jdbcTemplate.queryForList(" select customer_id,address1,city,state,zip from customer_address where customer_id=" + customerId);
			for (Map<String, Object> add : Address) {
				DropdownModel model = new DropdownModel();
				model.setKey(add.get("customer_id").toString());
				model.setDisplay(add.get("address1") != null ? add.get("address1").toString():"");
				model.setDescription(add.get("city") != null ? add.get("city").toString() : "");
				model.setExtra(add.get("state") != null ? add.get("state").toString() : "");
				model.setExtraData(add.get("zip") != null ? add.get("zip").toString() : "");
				address.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return address;
	}

	@Override
	public List<DropdownModel> getAddress() {
		List<DropdownModel> address = new ArrayList<>();
		try {
			DropdownModel model = new DropdownModel();
			model.setKey("");
			model.setDisplay("");
			model.setDescription("");
			model.setExtra("");
			model.setExtraData("");
			address.add(model);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return address;
	}

	@Override
	public int saveGroupMember(TransferOrderModel transferOrderModel) {
		Map<String, Object> saveParams = new LinkedHashMap<>();
		int status = 0;
		try {
			StringBuilder groupMemberQuery = new StringBuilder("insert into group_member (customer_group_customer_id,customer_id,customer_address_seq,n_copies,creation_date,active,authorized) values (:customer_group_customer_id,:customer_id,:customer_address_seq,:n_copies,:creation_date,:active,:authorized)");
			saveParams.put("customer_group_customer_id", transferOrderModel.getCustomerGroupCustomerId());
			saveParams.put("customer_id", transferOrderModel.getCustomerId());
			saveParams.put("customer_address_seq", transferOrderModel.getCustomerAddressSeq());
			saveParams.put("n_copies", transferOrderModel.getnCopies());
			saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			saveParams.put("active", transferOrderModel.getStatus());
			saveParams.put("authorized", transferOrderModel.getAuthorized());
			namedParameterJdbcTemplate.update(groupMemberQuery.toString(), saveParams);
			saveParams.clear();

			StringBuilder custGrpMbrHist = new StringBuilder("insert into cust_grp_mbr_hist (customer_group_customer_id,cust_grp_mbr_hist_seq,user_code,creation_date,mbr_action,customer_id,customer_address_seq,n_copies,active,authorized) values (:customer_group_customer_id,:cust_grp_mbr_hist_seq,:user_code,:creation_date,:mbr_action,:customer_id,:customer_address_seq,:n_copies,:active,:authorized)");
			saveParams.put("customer_group_customer_id", transferOrderModel.getCustomerGroupCustomerId());

			String maxCustGrpMbrHistSeq = jdbcTemplate.queryForObject("select max(cust_grp_mbr_hist_seq) from cust_grp_mbr_hist ", String.class);
			if (maxCustGrpMbrHistSeq == null) {
				saveParams.put("cust_grp_mbr_hist_seq", 1);
			} else {
				saveParams.put("cust_grp_mbr_hist_seq", Integer.parseInt(maxCustGrpMbrHistSeq) + 1);
			}
			String userCode = jdbcTemplate.queryForObject("select user_code from customer where customer_id="+transferOrderModel.getCustomerId(), String.class);
			saveParams.put("user_code", userCode);
			saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			saveParams.put("mbr_action", 1);
			saveParams.put("customer_id", transferOrderModel.getCustomerId());
			saveParams.put("customer_address_seq", transferOrderModel.getCustomerAddressSeq());
			saveParams.put("n_copies", transferOrderModel.getnCopies());
			saveParams.put("active", transferOrderModel.getStatus());
			saveParams.put("authorized", transferOrderModel.getAuthorized());
			namedParameterJdbcTemplate.update(custGrpMbrHist.toString(), saveParams);
			saveParams.clear();

			StringBuilder customer = new StringBuilder("update customer set mru_cust_grp_mbr_hist_seq=:mru_cust_grp_mbr_hist_seq where customer_id="+ transferOrderModel.getCustomerGroupCustomerId());
			String mruCustGrpMbrHistSeq = jdbcTemplate.queryForObject("select max(cust_grp_mbr_hist_seq) from cust_grp_mbr_hist where customer_group_customer_id="+ transferOrderModel.getCustomerGroupCustomerId(),String.class);
			saveParams.put("mru_cust_grp_mbr_hist_seq", mruCustGrpMbrHistSeq);
			namedParameterJdbcTemplate.update(customer.toString(), saveParams);
			String newMember = jdbcTemplate.queryForObject("select new_group_member_action from customer_group where customer_id="+transferOrderModel.getCustomerGroupCustomerId(), String.class);
			List<String> grpOrd = jdbcTemplate.queryForList("select distinct group_order from order_item where customer_id="+transferOrderModel.getCustomerGroupCustomerId()+" and order_status in (0,5,7,8,9,10,11,12,13) and group_order = 1", String.class);
			String grp="";
			if(grpOrd.size() != 0)
				grp = grpOrd.get(0);
			if(newMember == "2" && grp=="1") {
				List<Map<String, Object>> groupOrder = null;
				StringBuilder query = new StringBuilder("select * from order_item where customer_id="+transferOrderModel.getCustomerGroupCustomerId()+" and order_status in (0,5,7,8,9,10,11,12,13) and group_order = 1");
				groupOrder = jdbcTemplate.queryForList(query.toString());
				for(int i=0;i<groupOrder.size();i++) {
					StringBuilder grpMbrItemDtl = new StringBuilder("insert into grp_mbr_item_dtl (orderhdr_id,order_item_seq,grp_mbr_item_dtl_seq,customer_group_customer_id,customer_id,n_copies) values (:orderhdr_id,:order_item_seq,:grp_mbr_item_dtl_seq,:customer_group_customer_id,:customer_id,:n_copies)");
					saveParams.put("orderhdr_id", groupOrder.get(i).get("orderhdr_id"));
					saveParams.put("order_item_seq", groupOrder.get(i).get("order_item_seq"));
					String grpMbrItemDtlSeq = jdbcTemplate.queryForObject("select max(grp_mbr_item_dtl_seq) from grp_mbr_item_dtl where orderhdr_id="+groupOrder.get(i).get("orderhdr_id")+" and order_item_seq="+groupOrder.get(i).get("order_item_seq"), String.class);
					if (grpMbrItemDtlSeq == null) {
						saveParams.put("grp_mbr_item_dtl_seq", 1);
					} else {
						saveParams.put("grp_mbr_item_dtl_seq", Integer.parseInt(grpMbrItemDtlSeq) + 1);
					}
					saveParams.put("customer_group_customer_id", transferOrderModel.getCustomerGroupCustomerId());
					saveParams.put("customer_id", transferOrderModel.getCustomerId());
					saveParams.put("n_copies", transferOrderModel.getnCopies());
					namedParameterJdbcTemplate.update(grpMbrItemDtl.toString(), saveParams);
					saveParams.clear();
					
					StringBuilder addDel = new StringBuilder("insert into additions_deletions (subscrip_id,additions_deletions_seq,orderhdr_id,order_item_seq,issue_id,customer_id,n_addition_copies,n_deletion_copies,sub_add,sub_add_reason,sub_kill,sub_on,sub_on_reason,sub_off,sub_start,sub_start_reason,sub_stop,add_kill_status,creation_date,bundle_qty,start_stop_status) values (:subscrip_id,:additions_deletions_seq,:orderhdr_id,:order_item_seq,:issue_id,:customer_id,:n_addition_copies,:n_deletion_copies,:sub_add,:sub_add_reason,:sub_kill,:sub_on,:sub_on_reason,:sub_off,:sub_start,:sub_start_reason,:sub_stop,:add_kill_status,:creation_date,:bundle_qty,:start_stop_status)");
					//String subscripId = jdbcTemplate.queryForObject("select subscrip_id from order_item where orderhdr_id="+groupOrder.get(i).get("orderhdr_id")+" and order_item_seq="+groupOrder.get(i).get("order_item_seq"), String.class);
					saveParams.put("subscrip_id", groupOrder.get(i).get("subscrip_id"));
					String addDelSeq = jdbcTemplate.queryForObject("select max(additions_deletions_seq) from additions_deletions where subscrip_id="+groupOrder.get(i).get("subscrip_id"), String.class);
					if (addDelSeq == null) {
						saveParams.put("additions_deletions_seq", 1);
					} else {
						saveParams.put("additions_deletions_seq", Integer.parseInt(addDelSeq) + 1);
					}
					saveParams.put("orderhdr_id", groupOrder.get(i).get("orderhdr_id"));
					saveParams.put("order_item_seq", groupOrder.get(i).get("order_item_seq"));
					//String issueId = jdbcTemplate.queryForObject("select start_issue_id from order_item where orderhdr_id="+groupOrder.get(i).get("orderhdr_id")+" and order_item_seq="+groupOrder.get(i).get("order_item_seq"), String.class);
					saveParams.put("issue_id", groupOrder.get(i).get("start_issue_id"));
					saveParams.put("customer_id", transferOrderModel.getCustomerGroupCustomerId());
					int copies = transferOrderModel.getnCopies();
					int bundle = jdbcTemplate.queryForObject("select bundle_qty from order_item where orderhdr_id="+groupOrder.get(i).get("orderhdr_id")+" and order_item_seq="+groupOrder.get(i).get("order_item_seq"), Integer.class);;
					int cobu = copies+bundle;
					saveParams.put("n_addition_copies", cobu);
					saveParams.put("n_deletion_copies", 0);
					saveParams.put("sub_add", 1);
					saveParams.put("sub_add_reason", 3);
					saveParams.put("sub_kill", 0);
					saveParams.put("sub_on", 1);
					saveParams.put("sub_on_reason", 3);
					saveParams.put("sub_off", 0);
					saveParams.put("sub_start", 1);
					saveParams.put("sub_start_reason", 3);
					saveParams.put("sub_stop", 0);
					saveParams.put("add_kill_status", 0);
					saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
					saveParams.put("bundle_qty", cobu);
					saveParams.put("start_stop_status", 0);
					namedParameterJdbcTemplate.update(addDel.toString(), saveParams);
					saveParams.clear();
					
					Long dateStamp = customerUtility.getmaxDateStamp();
					StringBuilder journal = new StringBuilder("insert into journal (journal_id,date_stamp,orderhdr_id,order_item_seq,posting_reference,tax_amount,net_amount,del_amount,com_amount,debit_account,qty_debit_account,credit_account,qty_credit_account,qty,bndl_qty) values (:journal_id,:date_stamp,:orderhdr_id,:order_item_seq,:posting_reference,:tax_amount,:net_amount,:del_amount,:com_amount,:debit_account,:qty_debit_account,:credit_account,:qty_credit_account,:qty,:bndl_qty)");
					
					/*String journalId = jdbcTemplate.queryForObject("select max(journal_id) from journal", String.class);
					
					if (journalId == null) {
						saveParams.put("journal_id", 1);
					} else {
						saveParams.put("journal_id", Integer.parseInt(journalId) + 1);
					}*/
					
					long journalId = customerUtility.getMaxJournalId() + 1;
					jdbcTemplate.update("set nocount on if not exists (select 1 from information_schema.tables where table_name = 'mru_journal_id') begin create"
													+ "  table mru_journal_id (id int) insert mru_journal_id (id) values (1) end else update mru_journal_id with (TABLOCKX)"
													+ "  set id =" + journalId);
					
					saveParams.put("journal_id",journalId);
					
					saveParams.put("date_stamp", dateStamp);
					saveParams.put("orderhdr_id", groupOrder.get(i).get("orderhdr_id"));
					saveParams.put("order_item_seq", groupOrder.get(i).get("order_item_seq"));
					saveParams.put("posting_reference", 3);
					String tax = jdbcTemplate.queryForObject("select total_tax_local_amount from order_item where orderhdr_id="+groupOrder.get(i).get("orderhdr_id")+" and order_item_seq="+groupOrder.get(i).get("order_item_seq"), String.class);
					saveParams.put("tax_amount", tax);
					String net = jdbcTemplate.queryForObject("select gross_base_amount/bundle_qty as amount from order_item where orderhdr_id="+groupOrder.get(i).get("orderhdr_id")+" and order_item_seq="+groupOrder.get(i).get("order_item_seq"), String.class);
					saveParams.put("net_amount", net);
					saveParams.put("del_amount", 0);
					saveParams.put("com_amount", 0);
					saveParams.put("debit_account", 1);
					saveParams.put("qty_debit_account", 1);
					saveParams.put("credit_account", 3);
					saveParams.put("qty_credit_account", 2);
					int qty = jdbcTemplate.queryForObject("select order_qty from order_item where orderhdr_id="+groupOrder.get(i).get("orderhdr_id")+" and order_item_seq="+groupOrder.get(i).get("order_item_seq"), Integer.class);
					saveParams.put("qty", qty);
					saveParams.put("bndl_qty", 1);
				    customerUtility.updateJournalId(journalId);
					namedParameterJdbcTemplate.update(journal.toString(), saveParams);
					saveParams.clear();
					
					StringBuilder subscrip = new StringBuilder("update subscrip set mru_additions_deletions_seq=:mru_additions_deletions_seq where subscrip_id=:subscrip_id");
					saveParams.put("mru_additions_deletions_seq", Integer.parseInt(addDelSeq) + 1);
					saveParams.put("subscrip_id", groupOrder.get(i).get("subscrip_id"));
					namedParameterJdbcTemplate.update(subscrip.toString(), saveParams);
					saveParams.clear();
					
					StringBuilder orderItem = new StringBuilder("update order_item set gross_base_amount=:gross_base_amount,gross_local_amount=:gross_local_amount,net_base_amount=:net_base_amount,net_local_amount=:net_local_amount,bundle_qty=:bundle_qty,mru_grp_mbr_item_dtl_seq=:mru_grp_mbr_item_dtl_seq where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq");
					saveParams.put("orderhdr_id", groupOrder.get(i).get("orderhdr_id"));
					saveParams.put("order_item_seq", groupOrder.get(i).get("order_item_seq"));
					double amount = jdbcTemplate.queryForObject("select gross_base_amount/bundle_qty from order_item where orderhdr_id="+groupOrder.get(i).get("orderhdr_id")+" and order_item_seq="+groupOrder.get(i).get("order_item_seq"), double.class);
					double amt=amount*cobu;
					saveParams.put("gross_base_amount", amt);
					saveParams.put("gross_local_amount", amt);
					String agency = jdbcTemplate.queryForObject("select isNull(agency_customer_id,'') as agency_customer_id from order_item where orderhdr_id="+groupOrder.get(i).get("orderhdr_id")+" and order_item_seq="+groupOrder.get(i).get("order_item_seq"), String.class);
					if(agency.equals("0") || agency.equals(" ")) {
						saveParams.put("net_base_amount", amt);
						saveParams.put("net_local_amount", amt);
					}else {
						double commission = jdbcTemplate.queryForObject("select new_commission from agency where customer_id=(select agency_customer_id from order_item where orderhdr_id="+groupOrder.get(i).get("orderhdr_id")+" and order_item_seq="+groupOrder.get(i).get("order_item_seq")+")", double.class);
						double com = commission*cobu;
						double netPrice = amt-com;
						saveParams.put("net_base_amount", netPrice);
						saveParams.put("net_local_amount", netPrice);
					}
					
					saveParams.put("bundle_qty", cobu);
					saveParams.put("mru_grp_mbr_item_dtl_seq", Integer.parseInt(grpMbrItemDtlSeq) + 1);
					namedParameterJdbcTemplate.update(orderItem.toString(), saveParams);
					saveParams.clear();
					
					StringBuilder orderItemAmtBreak = new StringBuilder("update order_item_amt_break set local_amount=:local_amount,base_amount=:base_amount where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq and order_item_amt_break_seq=:order_item_amt_break_seq");
					saveParams.put("orderhdr_id", groupOrder.get(i).get("orderhdr_id"));
					saveParams.put("order_item_seq", groupOrder.get(i).get("order_item_seq"));
					saveParams.put("order_item_amt_break_seq", groupOrder.get(i).get("mru_order_item_amt_break_seq"));
					saveParams.put("base_amount", amt);
					saveParams.put("local_amount", amt);
					namedParameterJdbcTemplate.update(orderItemAmtBreak.toString(), saveParams);
					saveParams.clear();
					
					Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
					StringBuilder editTrail = new StringBuilder("insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name) values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
					saveParams.put("edit_trail_id", editTrailId);
					saveParams.put("customer_id", transferOrderModel.getCustomerGroupCustomerId());
					saveParams.put("customer_address_seq", transferOrderModel.getCustomerAddressSeq());
					//String userCode = jdbcTemplate.queryForObject("select user_code from customer where customer_id="+transferOrderModel.getCustomerId(), String.class);
					saveParams.put("user_code", groupOrder.get(i).get("user_code"));
					saveParams.put("subscrip_id", groupOrder.get(i).get("subscrip_id"));
					saveParams.put("orderhdr_id", groupOrder.get(i).get("orderhdr_id"));
					saveParams.put("order_item_seq", groupOrder.get(i).get("order_item_seq"));
					saveParams.put("edited", 1);
					//String currency = jdbcTemplate.queryForObject("select currency from order_item where orderhdr_id="+groupOrder.get(i).get("orderhdr_id")+" and order_item_seq="+groupOrder.get(i).get("order_item_seq"), String.class);
					saveParams.put("currency", groupOrder.get(i).get("currency"));
					saveParams.put("table_enum", 3);
					saveParams.put("document_reference_id", 1);
					saveParams.put("local_amount", amt);
					saveParams.put("base_amount", amt);
					saveParams.put("date_stamp", dateStamp);
					saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
					saveParams.put("xaction_name", "customer_edit_request");
					namedParameterJdbcTemplate.update(editTrail.toString(), saveParams);
					customerUtility.updateMruEditTrailId(editTrailId);
					saveParams.clear();
					editTrailId = customerUtility.getmaxeditTrailId() + 1;
					StringBuilder editTrail2 = new StringBuilder("insert into edit_trail (edit_trail_id,user_code,orderhdr_id,order_item_seq,order_item_amt_break_seq,edited,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name) values (:edit_trail_id,:user_code,:orderhdr_id,:order_item_seq,:order_item_amt_break_seq,:edited,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
					saveParams.put("edit_trail_id", editTrailId);
					saveParams.put("user_code", groupOrder.get(i).get("user_code"));
					saveParams.put("orderhdr_id", groupOrder.get(i).get("orderhdr_id"));
					saveParams.put("order_item_seq", groupOrder.get(i).get("order_item_seq"));
					saveParams.put("order_item_amt_break_seq", 1);
					saveParams.put("edited", 1);
					saveParams.put("table_enum", 6);
					saveParams.put("document_reference_id", 1);
					saveParams.put("local_amount", amt);
					saveParams.put("base_amount", amt);
					saveParams.put("date_stamp", dateStamp);
					saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
					saveParams.put("xaction_name", "customer_edit_request");
					namedParameterJdbcTemplate.update(editTrail2.toString(), saveParams);
					customerUtility.updateMruEditTrailId(editTrailId);
					saveParams.clear();
				}
			}
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public GroupMemberModel getEditGroupMemberSetUp(int customerId, int customerAddressSeq) {
		List<Map<String, Object>> editGroupMemberSetUp = null;
		GroupMemberModel model = new GroupMemberModel();
		try {
			StringBuilder query = new StringBuilder(" select group_member.customer_id as customer_id,concat(fname,' ',lname) as customer_name,address1,concat(address1 ,' ', address2 ,' ', address3 ,' ', state ,' ', city  ,' ', zip) as customer_address,isNull(n_copies,'') as n_copies ,active,authorized,customer_address.customer_address_seq,customer_group_customer_id from group_member left join customer_address  on customer_address .customer_id=group_member.customer_id where group_member.customer_id="+ customerId + " and customer_address.customer_address_seq=" + customerAddressSeq);
			editGroupMemberSetUp = jdbcTemplate.queryForList(query.toString());
			for (Map<String, Object> group : editGroupMemberSetUp) {
				model.setCustomerId(Integer.parseInt(group.get("customer_id").toString()));
				model.setCustomerName(group.get("customer_name").toString());
				model.setAddressToUse(group.get("address1")!=null?group.get("address1").toString():"");
				model.setAddress(group.get("customer_name").toString() +" "+ group.get("customer_address").toString());
				model.setnCopies(Integer.parseInt(group.get("n_copies").toString()));
				model.setActive(Integer.parseInt(group.get("active").toString()));
				model.setAuthorized(Integer.parseInt(group.get("authorized").toString()));
				model.setCustomerAddressSeq(Integer.parseInt(group.get("customer_address_seq").toString()));
				model.setCustomerGroupCustomerId(Integer.parseInt(group.get("customer_group_customer_id").toString()));
				
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return model;
	}

	@Override
	public int updateEditGroupMember(TransferOrderModel transferOrderModel) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		try {
			StringBuilder custGrpMbrHist = new StringBuilder("insert into cust_grp_mbr_hist (customer_group_customer_id,cust_grp_mbr_hist_seq,user_code,creation_date,mbr_action,customer_id,customer_address_seq,n_copies,active,authorized) values(:customer_group_customer_id,:cust_grp_mbr_hist_seq,:user_code,:creation_date,:mbr_action,:customer_id,:customer_address_seq,:n_copies,:active,:authorized)");
			updateParams.put("customer_id", transferOrderModel.getCustomerId());
			updateParams.put("customer_address_seq", transferOrderModel.getCustomerAddressSeq());
			updateParams.put("customer_group_customer_id", transferOrderModel.getCustomerGroupCustomerId());
			String maxCustGrpMbrHistSeq = jdbcTemplate.queryForObject("select max(cust_grp_mbr_hist_seq) from cust_grp_mbr_hist ", String.class);
			if (maxCustGrpMbrHistSeq == null) {
				updateParams.put("cust_grp_mbr_hist_seq", 1);
			} else {
				updateParams.put("cust_grp_mbr_hist_seq", Integer.parseInt(maxCustGrpMbrHistSeq) + 1);
			}
			String userCode = jdbcTemplate.queryForObject("select user_code from customer where customer_id="+transferOrderModel.getCustomerId(), String.class);
			updateParams.put("user_code", userCode);
			updateParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			updateParams.put("mbr_action", 1);
			updateParams.put("n_copies", transferOrderModel.getnCopies());
			updateParams.put("active", transferOrderModel.getStatus());
			updateParams.put("authorized", transferOrderModel.getAuthorized());
			namedParameterJdbcTemplate.update(custGrpMbrHist.toString(), updateParams);
			updateParams.clear();

			StringBuilder customer = new StringBuilder("update customer set mru_cust_grp_mbr_hist_seq=:mru_cust_grp_mbr_hist_seq where customer_id="+ transferOrderModel.getCustomerId());
			String mruCustGrpMbrHistSeq = jdbcTemplate.queryForObject("select max(cust_grp_mbr_hist_seq) from cust_grp_mbr_hist where customer_group_customer_id="+ transferOrderModel.getCustomerGroupCustomerId(),String.class);
			updateParams.put("mru_cust_grp_mbr_hist_seq", mruCustGrpMbrHistSeq);
			namedParameterJdbcTemplate.update(customer.toString(), updateParams);
			updateParams.clear();

			StringBuilder groupMember = new StringBuilder("update group_member set customer_address_seq=:customer_address_seq,n_copies=:n_copies,active=:active,authorized=:authorized where customer_group_customer_id="+ transferOrderModel.getCustomerGroupCustomerId() + " and customer_id="+ transferOrderModel.getCustomerId());
			updateParams.put("customer_address_seq", transferOrderModel.getCustomerAddressSeq());
			updateParams.put("n_copies", transferOrderModel.getnCopies());
			updateParams.put("active", transferOrderModel.getStatus());
			updateParams.put("authorized", transferOrderModel.getAuthorized());
			namedParameterJdbcTemplate.update(groupMember.toString(), updateParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public int deleteGroupMember(int customerId, int customerGroupcustomerId, int customerAddressSeq) {
		int Status = 0;
		try {
			String deleteGroupMember = "delete from group_member where customer_id=" + customerId+ " and customer_group_customer_id=" + customerGroupcustomerId + " and customer_address_seq="+ customerAddressSeq;
			Status = jdbcTemplate.update(deleteGroupMember);
			
			String maxSeq = jdbcTemplate.queryForObject("select max(cust_grp_mbr_hist_seq) from cust_grp_mbr_hist where customer_group_customer_id="+customerGroupcustomerId,String.class);
			String userCode = jdbcTemplate.queryForObject("select user_code from customer where customer_id="+customerGroupcustomerId, String.class);
			String querySave = "insert into cust_grp_mbr_hist (customer_group_customer_id,cust_grp_mbr_hist_seq,user_code,creation_date,mbr_action,customer_id) values ("+customerGroupcustomerId+","+Integer.parseInt(maxSeq) + 1+","+userCode+",GETDATE(),0,"+customerId+")";
			Status = jdbcTemplate.update(querySave);
			
			int grpMbr = jdbcTemplate.queryForObject("select max(cust_grp_mbr_hist_seq) from cust_grp_mbr_hist where customer_group_customer_id="+ customerGroupcustomerId,Integer.class);
			String queryUpdate = "update customer set mru_cust_grp_mbr_hist_seq="+grpMbr+" where customer_id="+customerGroupcustomerId;
			Status = jdbcTemplate.update(queryUpdate);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return Status;
	}

	@Override
	public List<Map<String, Object>> getCustomerGroupMemberHistory(int custGrpCustomerId) {
		List<Map<String, Object>> customerGroupMemberHistory = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(" SELECT * FROM view_cust_grp_mbr_hist WHERE customer_group_customer_id =" + custGrpCustomerId);
			customerGroupMemberHistory = jdbcTemplate.queryForList(query.toString());

			for (Map<String, Object> customerGroup : customerGroupMemberHistory) {

				if (customerGroup.get("bill_to_customer_address_seq") == null) {
					customerGroup.put("bill_to_customer_address_seq", "");
				}
				if (customerGroup.get("bill_to_customer_id") == null) {
					customerGroup.put("bill_to_customer_id", "");
				}
				if (customerGroup.get("description") == null) {
					customerGroup.put("description", "");
				}
				if (customerGroup.get("fte_cnt_added") == null) {
					customerGroup.put("fte_cnt_added", "");
				}
				if (customerGroup.get("fte_cnt_avail") == null) {
					customerGroup.put("fte_cnt_avail", "");
				}
				if (customerGroup.get("fte_count") == null) {
					customerGroup.put("fte_count", "");
				}
				if (customerGroup.get("fte_grace_cnt") == null) {
					customerGroup.put("fte_grace_cnt", "");
				}
				if (customerGroup.get("fte_grace_pct") == null) {
					customerGroup.put("fte_grace_pct", "");
				}
				if (customerGroup.get("new_group_member_action") == null) {
					customerGroup.put("new_group_member_action", "");
				}
				if (customerGroup.get("renew_to_customer_address_seq") == null) {
					customerGroup.put("renew_to_customer_address_seq", "");
				}
				if (customerGroup.get("renew_to_customer_id") == null) {
					customerGroup.put("renew_to_customer_id", "");
				}
				if (customerGroup.get("ship_type") == null) {
					customerGroup.put("ship_type", "");
				}
				if (customerGroup.get("customer_category") == null) {
					customerGroup.put("customer_category", "");
				}
				if (customerGroup.get("oc_id") == null) {
					customerGroup.put("oc_id", "");
				}
				if (customerGroup.get("initial_name") == null) {
					customerGroup.put("initial_name", "");
				}
				if (customerGroup.get("salutation") == null) {
					customerGroup.put("salutation", "");
				}
				if (customerGroup.get("suffix") == null) {
					customerGroup.put("suffix", "");
				}
				if (customerGroup.get("title") == null) {
					customerGroup.put("title", "");
				}
				if (customerGroup.get("email") == null) {
					customerGroup.put("email", "");
				}
				if (customerGroup.get("list_rental_category") == null) {
					customerGroup.put("list_rental_category", "");
				}
				if (customerGroup.get("old_customer_id") == null) {
					customerGroup.put("old_customer_id", "");
				}
				if (customerGroup.get("nbr_times_issued") == null) {
					customerGroup.put("nbr_times_issued", "");
				}
				if (customerGroup.get("mru_customer_prospect_seq") == null) {
					customerGroup.put("mru_customer_prospect_seq", "");
				}
				if (customerGroup.get("mru_demographic_seq") == null) {
					customerGroup.put("mru_demographic_seq", "");
				}
				if (customerGroup.get("mru_payment_seq") == null) {
					customerGroup.put("mru_payment_seq", "");
				}
				if (customerGroup.get("mru_promotion_history_seq") == null) {
					customerGroup.put("mru_promotion_history_seq", "");
				}
				if (customerGroup.get("mru_service_seq") == null) {
					customerGroup.put("mru_service_seq", "");
				}
				if (customerGroup.get("mru_customer_note_seq") == null) {
					customerGroup.put("mru_customer_note_seq", "");
				}
				if (customerGroup.get("sales_representative_id") == null) {
					customerGroup.put("sales_representative_id", "");
				}
				if (customerGroup.get("institutional_identifier") == null) {
					customerGroup.put("institutional_identifier", "");
				}
				if (customerGroup.get("old_email") == null) {
					customerGroup.put("old_email", "");
				}
				if (customerGroup.get("parent_inst_identifier") == null) {
					customerGroup.put("parent_inst_identifier", "");
				}
				if (customerGroup.get("mru_cust_grp_mbr_hist_seq") == null) {
					customerGroup.put("mru_cust_grp_mbr_hist_seq", "");
				}
				if (customerGroup.get("company") == null) {
					customerGroup.put("company", "");
				}
				if (customerGroup.get("n_copies") == null) {
					customerGroup.put("n_copies", "");
				}
				if (customerGroup.get("active") == null) {
					customerGroup.put("active", "");
				}
				if (customerGroup.get("authorized") == null) {
					customerGroup.put("authorized", "");
				}
				if (customerGroup.get("customer_address_seq") == null) {
					customerGroup.put("customer_address_seq", "");
				}
				if (customerGroup.get("default_cust_addr_seq") == null) {
					customerGroup.put("default_cust_addr_seq", "");
				}
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return customerGroupMemberHistory;
	}

	@Override
	 public List<DropdownModel> getShipType(){
		 List<DropdownModel> shipType = new ArrayList<>();
		  DropdownModel model = null;
		  try{
			  for (int i=1; i<=5; i++) {
			    model = new DropdownModel();		  
				model.setKey(""+i);
				model.setDisplay(new PropertyUtilityClass().getConstantValue("ship_type_"+i));
				shipType.add(model);
			  }
		  } catch (Exception e){
			LOGGER.  error(ERROR+e);
		  }
		  return shipType;
	  }

	@Override
	public List<DropdownModel> getNewGroupMemberAction() {
		List<DropdownModel> newGroupMemberAction = new ArrayList<>();
		DropdownModel model = null;
		for (int i = 0; i <= 5; i++) {
			if(i !=1) {
			model = new DropdownModel();
			model.setKey("" + i);
			model.setDisplay(new PropertyUtils().getConstantValue("new_group_member_action_" + i));
			newGroupMemberAction.add(model);
		}
			}
		return newGroupMemberAction;
	}

	
		 @Override
		 public List<DropdownModel> getBackIssueShipType(){
			 List<DropdownModel> backIssueShipType = new ArrayList<>();
			  DropdownModel model = null;
			  try{
				  for (int i=0; i<=1; i++) {
				    model = new DropdownModel();		  
					model.setKey(""+i);
					model.setDisplay(new PropertyUtilityClass().getConstantValue("back_issue_ship_type_"+i));
					backIssueShipType.add(model);
				  }
			  } catch (Exception e){
				LOGGER.  error(ERROR+e);
			  }
			  return backIssueShipType;
		  }

		 @Override
			public CustomerGroupModel getGroup(int customerId, int customerAddressSeq) {
				List<Map<String, Object>> group = null;
				CustomerGroupModel model =new CustomerGroupModel();
				try {
					StringBuilder query = new StringBuilder();
					query.append(
							" select customer_group,description,rep_customer_id,rep_customer_address_seq,address1,(select concat(fname,' ',lname) from customer_address where customer_id="
									+ "(select rep_customer_id from customer_group where customer_id=" + customerId + " and customer_address.customer_address_seq=" + customerAddressSeq+ ") and customer_address.customer_address_seq=" + customerAddressSeq +")as group_rep,(select address1 from customer_address where customer_id="
									+ "(select rep_customer_id from customer_group where customer_id=" + customerId + " and customer_address.customer_address_seq=" + customerAddressSeq+ ") and customer_address.customer_address_seq=" + customerAddressSeq +")as group_rep_address,renew_to_customer_id,renew_to_customer_address_seq,(select concat(fname,' ',lname) from customer_address where customer_id="
									+ "(select renew_to_customer_id from customer_group where customer_id=" + customerId + " and customer_address.customer_address_seq=" + customerAddressSeq+ ") and customer_address.customer_address_seq=" + customerAddressSeq +")as renew_to,(select address1 from customer_address where customer_id="
									+ "(select renew_to_customer_id from customer_group where customer_id=" + customerId + " and customer_address.customer_address_seq=" + customerAddressSeq+ ") and customer_address.customer_address_seq=" + customerAddressSeq +")as renew_to_address,bill_to_customer_id,bill_to_customer_address_seq,(select concat(fname,' ',lname) from customer_address where customer_id="
									+ "(select bill_to_customer_id from customer_group where customer_id=" + customerId + " and customer_address.customer_address_seq=" + customerAddressSeq+ ") and customer_address.customer_address_seq=" + customerAddressSeq +")as bill_to,(select address1 from customer_address where customer_id="
									+ "(select bill_to_customer_id from customer_group where customer_id=" + customerId + " and customer_address.customer_address_seq=" + customerAddressSeq+ ") and customer_address.customer_address_seq=" + customerAddressSeq +")as bill_to_address,ship_type,new_group_member_action,back_issue_ship_type,fte_count,fte_grace_cnt,fte_grace_pct,"
									+ "fte_cnt_added,fte_cnt_avail from customer_address left join customer_group on customer_group.customer_id=customer_address.customer_id where customer_address.customer_id="+ customerId + " and customer_address.customer_address_seq=" + customerAddressSeq);
					group = jdbcTemplate.queryForList(query.toString());
					for (Map<String, Object> grp : group) {
					model.setCustomerId(customerId);	
					model.setCustomerAddressSeq(customerAddressSeq);
					model.setCustomerGroup(grp.get("customer_group")!=null?grp.get("customer_group").toString():"");
					model.setDescription(grp.get("description")!=null?grp.get("description").toString():" ");
					model.setAddress(grp.get("address1")!=null?grp.get("address1").toString():"");
					model.setRepCustomerId(grp.get("rep_customer_id")!=null?grp.get("rep_customer_id").toString():"");
					model.setRepCustomerAddressSeq(grp.get("rep_customer_address_seq")!=null?grp.get("rep_customer_address_seq").toString():"");
					model.setGroupRep(grp.get("group_rep")!=null?grp.get("group_rep").toString():"");
					model.setRepCustomerAddress(grp.get("group_Rep_address")!=null?grp.get("group_Rep_address").toString():"");
					model.setBillToCustomerId(grp.get("bill_to_customer_id")!=null?grp.get("bill_to_customer_id").toString():"");
					model.setBillToCustomerAddressSeq(grp.get("bill_to_customer_address_seq")!=null?grp.get("bill_to_customer_address_seq").toString():"");
					model.setBillTo(grp.get("bill_to")!=null?grp.get("bill_to").toString():"");
					model.setBillToCustomerAddress(grp.get("bill_to_address")!=null?grp.get("bill_to_address").toString():"");
					model.setRenewToCustomerId(grp.get("renew_to_customer_id")!=null?grp.get("renew_to_customer_id").toString():"");
					model.setRenewToCustomerAddressSeq(grp.get("renew_to_customer_address_seq")!=null?grp.get("renew_to_customer_address_seq").toString():"");
					model.setRenewTo(grp.get("renew_to")!=null?grp.get("renew_to").toString():"");
					model.setRenewToCustomerAddress(grp.get("renew_to_address")!=null?grp.get("renew_to_address").toString():"");
					model.setNewGroupMemberAction(grp.get("new_group_member_action")!=null?grp.get("new_group_member_action").toString():"0");
					model.setBackIssueShipType(grp.get("back_issue_ship_type")!=null?grp.get("back_issue_ship_type").toString():"0");
					model.setFteCount(grp.get("fte_count")!=null?grp.get("fte_count").toString():"");
					model.setFteGraceCnt(grp.get("fte_grace_cnt")!=null?grp.get("fte_grace_cnt").toString():"");
					model.setFteGracePct(grp.get("fte_grace_pct")!=null?grp.get("fte_grace_pct").toString():"");
					model.setFteCntAdded(grp.get("fte_cnt_added")!=null?grp.get("fte_cnt_added").toString():"");
					model.setFteCntAvail(grp.get("fte_cnt_avail")!=null?grp.get("fte_cnt_avail").toString():"");
					if(grp.get("ship_type")==null ) {
						model.setShipType("1");
					}else {
						model.setShipType(grp.get("ship_type")!=null?grp.get("ship_type").toString():"");
					}
					}
				} catch (Exception e) {
					LOGGER.error(ERROR + e);
				}
				return model;
			}

	@Override
	public List<Map<String, Object>> getGroupSearch(UpDowngradeModel upDowngradeModel) {
		List<Map<String, Object>> groupSearch = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(" select customer.*, customer_group, description, customer_address_seq from customer_group left join customer on customer.customer_id = customer_group.customer_id where (inactive = 0 OR inactive is NULL)");

			if ("GroupName".equals(upDowngradeModel.getSearchBy())) {
				
				if ("*".equals(upDowngradeModel.getGroupName())) 
					query.append(" and customer_group.customer_group LIKE '%'");
				else if (upDowngradeModel.getGroupName() != null && !"".equals(upDowngradeModel.getGroupName())) 
					if (upDowngradeModel.getGroupName().contains("*")) {
						query.append(" AND customer_group.customer_group LIKE '" + upDowngradeModel.getGroupName().replace('*','%')+ "'");
					} else {
						query.append(" AND customer_group.customer_group LIKE '" + upDowngradeModel.getGroupName() + "'");
					}
				
				if ("*".equals(upDowngradeModel.getDescription())) 
					query.append(" and customer_group.description LIKE '%'");
				else if (upDowngradeModel.getDescription() != null && !"".equals(upDowngradeModel.getDescription())) 
					if (upDowngradeModel.getDescription().contains("*")) {
						query.append(" AND customer_group.description LIKE '" + upDowngradeModel.getDescription().replace('*','%') + "'");
					} else {
						query.append(" AND customer_group.description LIKE '" + upDowngradeModel.getDescription() + "'");
					}
			}

			if ("CustomerName".equals(upDowngradeModel.getSearchBy())) {

				if ("*".equals(upDowngradeModel.getFirstName())) 
					query.append(" and customer.fname LIKE '%'");
				else if (upDowngradeModel.getFirstName() != null && !"".equals(upDowngradeModel.getFirstName())) 
					if (upDowngradeModel.getFirstName().contains("*")) {
						query.append(" AND customer.fname LIKE '" + upDowngradeModel.getFirstName().replace('*','%') + "'");
					} else {
						query.append(" AND customer.fname LIKE '" + upDowngradeModel.getFirstName() + "'");
					}
				
				if ("*".equals(upDowngradeModel.getLastName())) 
					query.append(" and customer.lname LIKE '%'");
				else if (upDowngradeModel.getLastName() != null && !"".equals(upDowngradeModel.getLastName())) 
					if (upDowngradeModel.getLastName().contains("*")) {
						query.append(" AND customer.lname LIKE '" + upDowngradeModel.getLastName().replace('*','%') + "'");
					} else {
						query.append(" AND customer.lname LIKE '" + upDowngradeModel.getLastName() + "'");
					}
			}

			if ("CustomerGroupId".equals(upDowngradeModel.getSearchBy())) {

				if (upDowngradeModel.getCustomerId() != null && !"".equals(upDowngradeModel.getCustomerId()))
					query.append(" and customer.customer_id=" + upDowngradeModel.getCustomerId());
			}

			if ("addressLookup".equals(upDowngradeModel.getSearchBy())) {

				if (upDowngradeModel.getId() != null && !"".equals(upDowngradeModel.getId()))
					query.append(" and " + upDowngradeModel.getId());

				if ("*".equals(upDowngradeModel.getDescription()))
					query.append(" and customer_group.description LIKE '%'");
				else if (upDowngradeModel.getDescription() != null && !"".equals(upDowngradeModel.getDescription()))
					if (upDowngradeModel.getDescription().contains("*")) {
						query.append(" AND customer_group.description LIKE '" + upDowngradeModel.getDescription().replace('*','%') + "'");
					} else {
						query.append(" AND customer_group.description LIKE '" + upDowngradeModel.getDescription() + "'");
					}
			}
			
			groupSearch = jdbcTemplate.queryForList(query.toString());

			for (Map<String, Object> grpSrc : groupSearch) {

				if (grpSrc.get("customer_category") == null) {
					grpSrc.put("customer_category", "");
				}
				if (grpSrc.get("oc_id") == null) {
					grpSrc.put("oc_id", "");
				}
				if (grpSrc.get("initial_name") == null) {
					grpSrc.put("initial_name", "");
				}
				if (grpSrc.get("salutation") == null) {
					grpSrc.put("salutation", "");
				}
				if (grpSrc.get("suffix") == null) {
					grpSrc.put("suffix", "");
				}
				if (grpSrc.get("title") == null) {
					grpSrc.put("title", "");
				}
				if (grpSrc.get("email") == null) {
					grpSrc.put("email", "");
				}
				if (grpSrc.get("old_customer_id") == null) {
					grpSrc.put("old_customer_id", "");
				}
				if (grpSrc.get("nbr_times_issued") == null) {
					grpSrc.put("nbr_times_issued", "");
				}
				if (grpSrc.get("mru_customer_prospect_seq") == null) {
					grpSrc.put("mru_customer_prospect_seq", "");
				}
				if (grpSrc.get("mru_demographic_seq") == null) {
					grpSrc.put("mru_demographic_seq", "");
				}
				if (grpSrc.get("mru_payment_seq") == null) {
					grpSrc.put("mru_payment_seq", "");
				}
				if (grpSrc.get("mru_promotion_history_seq") == null) {
					grpSrc.put("mru_promotion_history_seq", "");
				}
				if (grpSrc.get("mru_service_seq") == null) {
					grpSrc.put("mru_service_seq", "");
				}
				if (grpSrc.get("mru_customer_note_seq") == null) {
					grpSrc.put("mru_customer_note_seq", "");
				}
				if (grpSrc.get("sales_representative_id") == null) {
					grpSrc.put("sales_representative_id", "");
				}
				if (grpSrc.get("institutional_identifier") == null) {
					grpSrc.put("institutional_identifier", "");
				}
				if (grpSrc.get("old_email") == null) {
					grpSrc.put("old_email", "");
				}
				if (grpSrc.get("company") == null) {
					grpSrc.put("company", "");
				}
				if (grpSrc.get("parent_inst_identifier") == null) {
					grpSrc.put("parent_inst_identifier", "");
				}
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return groupSearch;
	}

	@Override
	public int saveCustomerGroupEdit(CustomerGroupModel customerGroupModel) {
		Map<String, Object> saveParams = new LinkedHashMap<>();
		int status = 0;
		try {
			StringBuilder customerGroupEditQuery = new StringBuilder(
					"insert into customer_group (customer_id,creation_date,description,customer_group,ship_type,rep_customer_id,rep_customer_address_seq,new_group_member_action,back_issue_ship_type,customer_address_seq,bill_to_customer_id,bill_to_customer_address_seq,renew_to_customer_id,renew_to_customer_address_seq,fte_cnt_added,fte_cnt_avail,fte_count,fte_grace_cnt,fte_grace_pct ) values (:customer_id,:creation_date,:description,:customer_group,:ship_type,:rep_customer_id,:rep_customer_address_seq,:new_group_member_action,:back_issue_ship_type,:customer_address_seq,:bill_to_customer_id,:bill_to_customer_address_seq,:renew_to_customer_id,:renew_to_customer_address_seq,:fte_cnt_added,:fte_cnt_avail,:fte_count,:fte_grace_cnt,:fte_grace_pct )");
			saveParams.put("customer_id", customerGroupModel.getCustomerId());
			saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			if (("null".equals(customerGroupModel.getDescription())) || ("".equals(customerGroupModel.getDescription()))) {
				saveParams.put("description", null);
			} else {
				saveParams.put("description", customerGroupModel.getDescription());
			}
			saveParams.put("customer_group", customerGroupModel.getCustomerGroup());
			if (("null".equals(customerGroupModel.getShipType())) || ("".equals(customerGroupModel.getShipType()))) {
				saveParams.put("ship_type", null);
			} else {
				saveParams.put("ship_type", customerGroupModel.getShipType());
			}
			if (("null".equals(customerGroupModel.getRepCustomerId())) || ("".equals(customerGroupModel.getRepCustomerId()))) {
				saveParams.put("rep_customer_id", null);
			} else {
				saveParams.put("rep_customer_id", customerGroupModel.getRepCustomerId());
			}
			if (("null".equals(customerGroupModel.getRepCustomerAddressSeq())) || ("".equals(customerGroupModel.getRepCustomerAddressSeq()))) {
				saveParams.put("rep_customer_address_seq", null);
			} else {
				saveParams.put("rep_customer_address_seq", customerGroupModel.getRepCustomerAddressSeq());
			}
			if (("null".equals(customerGroupModel.getNewGroupMemberAction())) || ("".equals(customerGroupModel.getNewGroupMemberAction()))) {
				saveParams.put("new_group_member_action", null);
			} else {
				saveParams.put("new_group_member_action", customerGroupModel.getNewGroupMemberAction());
			}
			if (("null".equals(customerGroupModel.getBackIssueShipType())) || ("".equals(customerGroupModel.getBackIssueShipType()))) {
				saveParams.put("back_issue_ship_type", 0);
			} else {
				saveParams.put("back_issue_ship_type", customerGroupModel.getBackIssueShipType());
			}
			saveParams.put("customer_address_seq", customerGroupModel.getCustomerAddressSeq());
			if (("null".equals(customerGroupModel.getBillToCustomerId())) || ("".equals(customerGroupModel.getBillToCustomerId()))) {
				saveParams.put("bill_to_customer_id", null);
			} else {
				saveParams.put("bill_to_customer_id", customerGroupModel.getBillToCustomerId());
			}
			if (("null".equals(customerGroupModel.getBillToCustomerAddressSeq())) || ("".equals(customerGroupModel.getBillToCustomerAddressSeq()))) {
				saveParams.put("bill_to_customer_address_seq", null);
			} else {
				saveParams.put("bill_to_customer_address_seq", customerGroupModel.getBillToCustomerAddressSeq());
			}
			if (("null".equals(customerGroupModel.getRenewToCustomerId())) || ("".equals(customerGroupModel.getRenewToCustomerId()))) {
				saveParams.put("renew_to_customer_id", null);
			} else {
				saveParams.put("renew_to_customer_id", customerGroupModel.getRenewToCustomerId());
			}
			if (("null".equals(customerGroupModel.getRenewToCustomerAddressSeq())) || ("".equals(customerGroupModel.getRenewToCustomerAddressSeq()))) {
				saveParams.put("renew_to_customer_address_seq", null);
			} else {
				saveParams.put("renew_to_customer_address_seq", customerGroupModel.getRenewToCustomerAddressSeq());
			}
			if (("null".equals(customerGroupModel.getFteCntAdded())) || ("".equals(customerGroupModel.getFteCntAdded()))) {
				saveParams.put("fte_cnt_added", null);
			} else {
				saveParams.put("fte_cnt_added", customerGroupModel.getFteCntAdded());
			}
			if (("null".equals(customerGroupModel.getFteCntAvail())) || ("".equals(customerGroupModel.getFteCntAvail()))) {
				saveParams.put("fte_cnt_avail", null);
			} else {
				saveParams.put("fte_cnt_avail", customerGroupModel.getFteCntAvail());
			}
			if (("null".equals(customerGroupModel.getFteCount())) || ("".equals(customerGroupModel.getFteCount()))) {
				saveParams.put("fte_count", null);
			} else {
				saveParams.put("fte_count", customerGroupModel.getFteCount());
			}
			if (("null".equals(customerGroupModel.getFteGraceCnt())) || ("".equals(customerGroupModel.getFteGraceCnt()))) {
				saveParams.put("fte_grace_cnt", null);
			} else {
				saveParams.put("fte_grace_cnt", customerGroupModel.getFteGraceCnt());
			}
			if (("null".equals(customerGroupModel.getFteGracePct())) || ("".equals(customerGroupModel.getFteGracePct()))) {
				saveParams.put("fte_grace_pct", null);
			} else {
				saveParams.put("fte_grace_pct", customerGroupModel.getFteGracePct());
			}
			namedParameterJdbcTemplate.update(customerGroupEditQuery.toString(), saveParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public String updateCustomerGroup(CustomerGroupModel customerGroupModel) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		try {
			StringBuilder query = new StringBuilder(
					"update customer_group set creation_date=:creation_date,description=:description,customer_group=:customer_group,ship_type=:ship_type,rep_customer_id=:rep_customer_id,rep_customer_address_seq=:rep_customer_address_seq,new_group_member_action=:new_group_member_action,back_issue_ship_type=:back_issue_ship_type,customer_address_seq=:customer_address_seq,bill_to_customer_id=:bill_to_customer_id,bill_to_customer_address_seq=:bill_to_customer_address_seq,renew_to_customer_id=:renew_to_customer_id,renew_to_customer_address_seq=:renew_to_customer_address_seq,fte_cnt_added=:fte_cnt_added,fte_cnt_avail=:fte_cnt_avail,fte_count=:fte_count,fte_grace_cnt=:fte_grace_cnt,fte_grace_pct=:fte_grace_pct where customer_id=:customer_id and customer_address_seq=:customer_address_seq ");
			updateParams.put("customer_id", customerGroupModel.getCustomerId());
			updateParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			if (("null".equals(customerGroupModel.getDescription())) || ("".equals(customerGroupModel.getDescription()))) {
				updateParams.put("description", null);
			} else {
				updateParams.put("description", customerGroupModel.getDescription());
			}
			if (("null".equals(customerGroupModel.getShipType())) || ("".equals(customerGroupModel.getCustomerGroup()))) {
				updateParams.put("customer_group", null);
			} else {
				updateParams.put("customer_group", customerGroupModel.getCustomerGroup());
			}
			if (("null".equals(customerGroupModel.getShipType())) || ("".equals(customerGroupModel.getShipType()))) {
				updateParams.put("ship_type", null);
			} else {
				updateParams.put("ship_type", customerGroupModel.getShipType());
			}
			if (("null".equals(customerGroupModel.getRepCustomerId())) || ("".equals(customerGroupModel.getRepCustomerId()))) {
				updateParams.put("rep_customer_id", null);
			} else {
				updateParams.put("rep_customer_id", customerGroupModel.getRepCustomerId());
			}
			if (("null".equals(customerGroupModel.getRepCustomerAddressSeq())) || ("".equals(customerGroupModel.getRepCustomerAddressSeq()))) {
				updateParams.put("rep_customer_address_seq", null);
			} else {
				updateParams.put("rep_customer_address_seq", customerGroupModel.getRepCustomerAddressSeq());
			}
			if (("null".equals(customerGroupModel.getNewGroupMemberAction())) || ("".equals(customerGroupModel.getNewGroupMemberAction()))) {
				updateParams.put("new_group_member_action", null);
			} else {
				updateParams.put("new_group_member_action", customerGroupModel.getNewGroupMemberAction());
			}
			if (("null".equals(customerGroupModel.getBackIssueShipType())) || ("".equals(customerGroupModel.getBackIssueShipType()))) {
				updateParams.put("back_issue_ship_type", null);
			} else {
				updateParams.put("back_issue_ship_type", customerGroupModel.getBackIssueShipType());
			}
			updateParams.put("customer_address_seq", customerGroupModel.getCustomerAddressSeq());
			if (("null".equals(customerGroupModel.getBillToCustomerId())) || ("".equals(customerGroupModel.getBillToCustomerId()))) {
				updateParams.put("bill_to_customer_id", null);
			} else {
				updateParams.put("bill_to_customer_id", customerGroupModel.getBillToCustomerId());
			}
			if (("null".equals(customerGroupModel.getBillToCustomerAddressSeq())) || ("".equals(customerGroupModel.getBillToCustomerAddressSeq()))) {
				updateParams.put("bill_to_customer_address_seq", null);
			} else {
				updateParams.put("bill_to_customer_address_seq", customerGroupModel.getBillToCustomerAddressSeq());
			}
			if (("null".equals(customerGroupModel.getRenewToCustomerId())) || ("".equals(customerGroupModel.getRenewToCustomerId()))) {
				updateParams.put("renew_to_customer_id", null);
			} else {
				updateParams.put("renew_to_customer_id", customerGroupModel.getRenewToCustomerId());
			}
			if (("null".equals(customerGroupModel.getRenewToCustomerAddressSeq())) || ("".equals(customerGroupModel.getRenewToCustomerAddressSeq()))) {
				updateParams.put("renew_to_customer_address_seq", null);
			} else {
				updateParams.put("renew_to_customer_address_seq", customerGroupModel.getRenewToCustomerAddressSeq());
			}
			if (("null".equals(customerGroupModel.getFteCntAdded())) || ("".equals(customerGroupModel.getFteCntAdded()))) {
				updateParams.put("fte_cnt_added", null);
			} else {
				updateParams.put("fte_cnt_added", customerGroupModel.getFteCntAdded());
			}
			if (("null".equals(customerGroupModel.getFteCntAvail())) || ("".equals(customerGroupModel.getFteCntAvail()))) {
				updateParams.put("fte_cnt_avail", null);
			} else {
				updateParams.put("fte_cnt_avail", customerGroupModel.getFteCntAvail());
			}
			if (("null".equals(customerGroupModel.getFteCount())) || ("".equals(customerGroupModel.getFteCount()))) {
				updateParams.put("fte_count", null);
			} else {
				updateParams.put("fte_count", customerGroupModel.getFteCount());
			}
			if (("null".equals(customerGroupModel.getFteGraceCnt())) || ("".equals(customerGroupModel.getFteGraceCnt()))) {
				updateParams.put("fte_grace_cnt", null);
			} else {
				updateParams.put("fte_grace_cnt", customerGroupModel.getFteGraceCnt());
			}
			if (("null".equals(customerGroupModel.getFteGracePct())) || ("".equals(customerGroupModel.getFteGracePct()))) {
				updateParams.put("fte_grace_pct", null);
			} else {
				updateParams.put("fte_grace_pct", customerGroupModel.getFteGracePct());
			}
			namedParameterJdbcTemplate.update(query.toString(), updateParams);
			return "updated";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return ERROR;
	}

	@Override
	public String deleteCustomerGroup(int customerId) {
		StringBuilder returnStatus = new StringBuilder();
		int Status = 0;
		try {
			String deleteGroupMember = "delete from group_member where customer_group_customer_id=" + customerId;
			Status = jdbcTemplate.update(deleteGroupMember);
			
			String deleteCustomerGroup = "delete customer_group from customer_group where customer_id =" + customerId;
			Status = jdbcTemplate.update(deleteCustomerGroup);
			returnStatus.append(Status);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			returnStatus.append(e);
		}
		return returnStatus.toString();
	}
	
	
	@Override
	public List<Map<String, Object>> getDemForm(String demFormId, String ocId) {
		List<Map<String, Object>> demForm = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder();
			StringBuilder parentOcId = new StringBuilder();

			if (ocId == null) {
				query.append(
						" select oc.oc_id,oc,isnull(oc.description,'') as oc_description, CONVERT(varchar ,CONVERT(DATE,GETDATE(),101),101) as qual_date from oc  where oc.oc_id="+ ocId);
				demForm = jdbcTemplate.queryForList(query.toString());
			} else if (ocId != null && demFormId == null) {
				
				query.append(
						" select oc.oc_id,oc,isnull(oc.description,'') as oc_description, upsell_on as global_question, CONVERT(varchar ,CONVERT(DATE,GETDATE(),101),101) as qual_date from oc  where oc.oc_id="
								+ ocId);
				demForm = jdbcTemplate.queryForList(query.toString());
			} else {
				while (ocId != null) {
					parentOcId.append(ocId + ",");
					ocId = jdbcTemplate.queryForObject("select parent_oc_id from oc where oc_id = " + ocId,
							String.class);
				}
				if (demFormId != null) {
					int demQuestionId = jdbcTemplate.queryForObject("select dem_question_id from dem_form_question where dem_form_id="+demFormId, Integer.class);
					query.append(" "
							+ "select oc.oc_id,oc,isnull(oc.description,'') as oc_description,dem_form.dem_form_id,dem_form.description as dem_description, CONVERT(varchar ,CONVERT(DATE,GETDATE(),101),101) as qual_date,global_question from oc left join dem_form on dem_form.oc_id = oc.oc_id left join dem_form_question on dem_form_question.dem_form_id =dem_form.dem_form_id left join dem_question on dem_question.dem_question_id = dem_form_question.dem_question_id where oc.oc_id in ("
							+ parentOcId.substring(0, parentOcId.length() - 1) + ") and dem_form.dem_form_id="
							+ demFormId + " and dem_form_question.dem_question_id=" + demQuestionId);
					demForm = jdbcTemplate.queryForList(query.toString());
				}
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return demForm;
	}

	@Override
	public List<Map<String, Object>> getDemForm1(String demFormId, String ocId) {
		List<Map<String, Object>> group = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder();
			query.append(" select label_q,descr_q_override from dem_form_question left join dem_form on dem_form.dem_form_id=dem_form_question.dem_form_id where oc_id="+ ocId +" and dem_form_question.dem_form_id=" + demFormId );
			group = jdbcTemplate.queryForList(query.toString());
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return group;
	}
	
	@Override
	public List<DropdownModel> getDemographicForm(String demFormId, String ocId) {
		List<DropdownModel> demographicForm = new ArrayList<>();
		try {
			List<Map<String, Object>> demoForm = jdbcTemplate.queryForList(" select dem_form_id,description from dem_form where oc_id=" +ocId +" and dem_form_id=" + demFormId);
			for (Map<String, Object> demo : demoForm) {
				DropdownModel model = new DropdownModel();
				model.setKey(demo.get("dem_form_id").toString());
				model.setDisplay(demo.get("description") != null ? demo.get("description").toString() : "");
				demographicForm.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return demographicForm;
	}

	@Override
	public List<Map<String, Object>> getProspect(Long customerId) {
		List<Map<String, Object>> prospect = new ArrayList<>();
		/*try {
			StringBuilder query = new StringBuilder("");
					query.append(" select  active_prospect,oc,customer_prospect.prospect_category,source_code_id,CONVERT(VARCHAR(10), GETDATE(), 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), GETDATE(), 22), 11)) as creation_date," 
							+ "CONVERT(varchar ,CONVERT(DATE,GETDATE(),101),101) as qual_date,audit_sales_channel_id,referred_by_customer_id,audit_qual_category,customer_address_seq,audit_qual_source_id,audit_subscription_type_id,customer_id,customer_prospect_seq,audit_name_title_id from customer_prospect left join oc on oc.oc_id= customer_prospect.oc_id " 
							+ "left join prospect_category on prospect_category.prospect_category= customer_prospect.prospect_category where customer_id="+ customerId );
					prospect = jdbcTemplate.queryForList(query.toString());
						for (Map<String, Object> pros : prospect) {
						pros.put("oc", "");
						if (pros.get("source_code_id") == null) {
							pros.put("source_code_id", "");
						}
						if (pros.get("audit_sales_channel_id") == null) {
							pros.put("audit_sales_channel_id", "");
						}
						if (pros.get("referred_by_customer_id") == null) {
							pros.put("referred_by_customer_id", "");
						}
						if (pros.get("audit_qual_category") == null) {
							pros.put("audit_qual_category", "");
						}
						if (pros.get("customer_address_seq") == null) {
							pros.put("customer_address_seq", "");
						}
						if (pros.get("audit_qual_source_id") == null) {
							pros.put("audit_qual_source_id", "");
						}
						if (pros.get("audit_subscription_type_id") == null) {
							pros.put("audit_subscription_type_id", "");
						}
						if (pros.get("audit_name_title_id") == null) {
							pros.put("audit_name_title_id", "");
						}
					}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}*/
		
		try {
			StringBuilder query = new StringBuilder("");
					query.append(" select  active_prospect,isnull(oc,'') as oc,customer_prospect.prospect_category,isnull(cast(source_code_id as varchar),'') as source_code_id,CONVERT(VARCHAR(10), GETDATE(), 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), GETDATE(), 22), 11)) as creation_date, CONVERT(varchar ,CONVERT(DATE,GETDATE(),101),101) as qual_date,isnull(cast(audit_sales_channel_id as varchar),'') as audit_sales_channel_id,isnull(cast(referred_by_customer_id as varchar),'') as referred_by_customer_id,isnull(cast(audit_qual_category as varchar),'') as audit_qual_category,customer_address_seq,isnull(cast(audit_qual_source_id as varchar),'') as audit_qual_source_id,isnull(cast(audit_subscription_type_id as varchar),'') as audit_subscription_type_id,customer_id,customer_prospect_seq,isnull(cast(audit_name_title_id as varchar),'') as audit_name_title_id from customer_prospect left join oc on oc.oc_id= customer_prospect.oc_id  left join prospect_category on prospect_category.prospect_category= customer_prospect.prospect_category where customer_id="+ customerId );
					prospect = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return prospect;
	}
	
	@Override
	public ProspectModel getProspectSetup(Long customerId, int customerAddressSeq) {
		ProspectModel prospectModel = new ProspectModel();
		List<Map<String, Object>>  prospectSetup = null;
		StringBuilder query = new StringBuilder(" ");
		
		try {
			String address =jdbcTemplate.queryForObject("select concat(address1 ,' ', address2 ,' ', address3) from customer_address where customer_id="+customerId +" and customer_address_seq="+customerAddressSeq,String.class);
			query.append(" select customer_id,");
				if(address == null) {
					query.append(" concat(city,' ',state) as address, ");
				}else{
					query.append(" concat(address1,' ',address2,' ',address3) as address, ");
				}
			query.append(" CONVERT(VARCHAR(10), GETDATE(), 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), GETDATE(), 22), 11)) as creation_date, " 
					+ " CONVERT(varchar ,CONVERT(DATE,GETDATE(),101),101) as qual_date "  
					+ " from customer_address "
			        + " where customer_id="+ customerId +" and customer_address_seq="+customerAddressSeq);	
			prospectSetup = jdbcTemplate.queryForList(query.toString());
				
				for(Map<String, Object> prospect:prospectSetup){	
				prospectModel.setCustomerId(prospect.get("customer_id").toString());
				prospectModel.setAddress(prospect.get("address").toString());
				prospectModel.setCreationDate(prospect.get("creation_date").toString());
				prospectModel.setQualDate(prospect.get("qual_date").toString());
				prospectModel.setActiveProspect("1");
				
				}	
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return prospectModel;
	}
	
	@Override
	public ProspectModel getEditProspectSetup(long customerId, int customerProspectSeq){
		ProspectModel prospectModel = new ProspectModel();
		List<Map<String, Object>> editProspectSetup = null;
		StringBuilder query = new StringBuilder("");
		try {
			String address =jdbcTemplate.queryForObject("select concat(address1 ,' ', address2 ,' ', address3) from customer_address where customer_id="+customerId +" and customer_address_seq=(select customer_address_seq from customer_prospect where customer_id="+customerId+" and customer_prospect_seq="+customerProspectSeq+")",String.class);
			query.append(" select top 1 customer_prospect.customer_id as customer_id, customer_prospect_seq,");
			if(address == null) {
				query.append(" concat(city,' ',state) as address, ");
			}else {
				query.append(" concat(address1,' ',address2,' ',address3) as address, ");
			}
			query.append(" isNull(source_code,'') as source_code,isNull(source_code.description,'') as source_description, "  
					 + " isNull(concat(fname,' ',lname),'') as referred_by,referred_by_customer_id, "
					 + " CONVERT(varchar, creation_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(varchar, creation_date, 22), 11))as creation_date, " 
					 + " CONVERT(varchar ,CONVERT(DATE,qual_date,101),101) as qual_date, " 
					 + " active_prospect,customer_prospect.oc_id,oc,isNull(oc.description,'') as oc_description,customer_prospect.prospect_category, "  
					 + " isnull(prospect_category.description,'') as prospect_description "  
					 + " from customer_prospect  "  
					 + " left join oc on oc.oc_id = customer_prospect.oc_id "  
					 + " left join source_code on source_code.source_code_id = customer_prospect.source_code_id "  
					 + " left join prospect_category on prospect_category.prospect_category = customer_prospect.prospect_category "  
					 + " left join customer_address on customer_address.customer_id=customer_prospect.customer_id  "  
					 + " where customer_prospect.customer_id="+customerId +" and customer_prospect_seq="+customerProspectSeq);
			editProspectSetup = jdbcTemplate.queryForList(query.toString());
			for(Map<String, Object> prospect:editProspectSetup){	
				prospectModel.setCustomerId(prospect.get("customer_id").toString());
				prospectModel.setCustomerProspectSeq(prospect.get("customer_prospect_seq").toString());
				prospectModel.setAddress(prospect.get("address").toString());
				prospectModel.setSourceCodeId(prospect.get("source_code")!=null?prospect.get("source_code").toString():"");
				prospectModel.setSourceDescription(prospect.get("source_description").toString());
				prospectModel.setReferredBy(prospect.get("referred_by")!=null?prospect.get("referred_by").toString():"");
				prospectModel.setReferredByCustomerId(prospect.get("referred_by_customer_id")!=null?prospect.get("referred_by_customer_id").toString():"");
				prospectModel.setCreationDate(prospect.get("creation_date").toString());
				prospectModel.setQualDate(prospect.get("qual_date").toString());
				prospectModel.setActiveProspect(prospect.get("active_prospect").toString());
				prospectModel.setOrderCode(prospect.get("oc")!=null?prospect.get("oc").toString():"");
				prospectModel.setOcId(prospect.get("oc_id").toString());
				prospectModel.setOcDescription(prospect.get("oc_description").toString());
				prospectModel.setProspectCategory(prospect.get("prospect_category").toString());
				prospectModel.setProspectDescription(prospect.get("prospect_description").toString());
				}	
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return prospectModel;
	}
	
	@Override
	public int deleteProspect(Long customerId, int customerProspectSeq) {
		int Status = 0;
		try {
			String query = " delete from customer_prospect where customer_id="+ customerId +" and customer_prospect_seq="+ customerProspectSeq;
			Status = jdbcTemplate.update(query);
			
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return Status;
	}
	
	@Override
	public int saveProspectSetup(ProspectModel prospectModel) {
		Map<String, Object> saveParams = new LinkedHashMap<>();
		int status = 0;
		try {
			int prospect = jdbcTemplate.queryForObject("select count(*) as oc_id from customer_prospect where customer_id="+prospectModel.getCustomerId()+" and oc_id="+prospectModel.getOrderCode(), Integer.class);
			if(prospect == 0) {
				StringBuilder saveQuery = new StringBuilder(
					       " insert into customer_prospect (customer_id,customer_prospect_seq,source_code_id,referred_by_customer_id,creation_date,active_prospect,oc_id,prospect_category,qual_date,customer_address_seq, audit_qual_category, audit_qual_source_id,audit_subscription_type_id,audit_name_title_id,audit_sales_channel_id) values (:customer_id,:customer_prospect_seq,:source_code_id,:referred_by_customer_id,:creation_date,:active_prospect,:oc_id,:prospect_category,:qual_date,:customer_address_seq,:audit_qual_category, :audit_qual_source_id,:audit_subscription_type_id,:audit_name_title_id,:audit_sales_channel_id)");
					saveParams.put("customer_id", prospectModel.getCustomerId());
					int custAddrSeq = jdbcTemplate.queryForObject("select top 1 customer_address_seq from customer_address where customer_id="+prospectModel.getCustomerId(), Integer.class);
					saveParams.put("customer_address_seq", custAddrSeq);
					String maxCustomerProspectSeq = jdbcTemplate.queryForObject("select max(customer_prospect_seq) from customer_prospect where customer_id="+prospectModel.getCustomerId(), String.class);
					if (maxCustomerProspectSeq == null) {
						saveParams.put("customer_prospect_seq", 1);
					} else {
						saveParams.put("customer_prospect_seq", Integer.parseInt(maxCustomerProspectSeq) + 1);
					}
					if(("null".equals(prospectModel.getSourceCodeId())) || ("".equals(prospectModel.getSourceCodeId()))) {
						saveParams.put("source_code_id", null);
					}else {
						saveParams.put("source_code_id", prospectModel.getSourceCodeId());
					}
					if(("null".equals(prospectModel.getReferredByCustomerId())) || ("".equals(prospectModel.getReferredByCustomerId()))) {
						saveParams.put("referred_by_customer_id", null);
					}else {
						saveParams.put("referred_by_customer_id", prospectModel.getReferredByCustomerId());
					}
					saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
					//String oc = jdbcTemplate.queryForObject("select oc_id from order_item where customer_id="+prospectModel.getCustomerId(), String.class);
					saveParams.put("active_prospect", "1".equals(prospectModel.getActiveProspect()) ? 1 : 0);
					saveParams.put("prospect_category", prospectModel.getProspectCategory());
					saveParams.put("qual_date", prospectModel.getQualDate());
					if(("null".equals(prospectModel.getOrderCode())) || ("".equals(prospectModel.getOrderCode()))) {
						saveParams.put("oc_id", null);
						saveParams.put("audit_qual_category", null);
						saveParams.put("audit_qual_source_id", null);
						saveParams.put("audit_subscription_type_id", null);
						saveParams.put("audit_name_title_id", null);
						saveParams.put("audit_sales_channel_id", null);
					}else {
						saveParams.put("oc_id", prospectModel.getOrderCode());
						List<Integer> auditedList = jdbcTemplate.queryForList("select audited from pub where oc_id="+ prospectModel.getOrderCode(), Integer.class);
						Integer audited = 0;
						if(auditedList.size() != 0)
							audited = auditedList.get(0);
						if(audited == 1) {
							saveParams.put("audit_qual_category", prospectModel.getAuditQualCategory());
							saveParams.put("audit_qual_source_id", prospectModel.getAuditQualSourceId());
							saveParams.put("audit_subscription_type_id", prospectModel.getAuditSubscriptionTypeId());
							saveParams.put("audit_name_title_id", prospectModel.getAuditNameTitleId());
							saveParams.put("audit_sales_channel_id", prospectModel.getAuditSalesChannelId());
						}else {
							saveParams.put("audit_qual_category", null);
							saveParams.put("audit_qual_source_id", null);
							saveParams.put("audit_subscription_type_id", null);
							saveParams.put("audit_name_title_id", null);
							saveParams.put("audit_sales_channel_id", null);
						}
					}
					
					namedParameterJdbcTemplate.update(saveQuery.toString(), saveParams);
					saveParams.clear();
					
					Long dateStamp = customerUtility.getmaxDateStamp();

					Long editTrailId = customerUtility.getmaxeditTrailId() + 1;

					StringBuilder editTrail = new StringBuilder(
							"insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,"
									+ "edited,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name)"
									+ "values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,"
									+ ":edited,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");

					saveParams.put("edit_trail_id", editTrailId);
					saveParams.put("customer_id", prospectModel.getCustomerId());
					saveParams.put("customer_address_seq", custAddrSeq);
					String userCode = jdbcTemplate.queryForObject("select user_code from customer where customer_id="+prospectModel.getCustomerId(), String.class);
					saveParams.put("user_code", userCode);
					saveParams.put("edited", 0);
					saveParams.put("table_enum", 2);
					saveParams.put("document_reference_id", 1);
					saveParams.put("local_amount", 0);
					saveParams.put("base_amount", 0);
					saveParams.put("date_stamp", dateStamp);
					saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
					saveParams.put("xaction_name", "prospect_add_request");
					namedParameterJdbcTemplate.update(editTrail.toString(), saveParams);
					customerUtility.updateMruEditTrailId(editTrailId);
					saveParams.clear();
					
					StringBuilder customer = new StringBuilder("update customer set mru_customer_prospect_seq=:mru_customer_prospect_seq ");
					List<String> prospectOnly = jdbcTemplate.queryForList("select distinct orderhdr_id from order_item where customer_id="+prospectModel.getCustomerId(), String.class);
					if(prospectOnly.isEmpty()) {
						customer.append(" , prospect_only= 1 "); 
					}else {
						customer.append(" , prospect_only= 0 "); 
					}
					customer.append(" where customer_id="+prospectModel.getCustomerId()); 
					String mruCustProsSeq = jdbcTemplate.queryForObject("select max(customer_prospect_seq) from customer_prospect where customer_id="+prospectModel.getCustomerId(), String.class);
					saveParams.put("mru_customer_prospect_seq", mruCustProsSeq);
					
					namedParameterJdbcTemplate.update(customer.toString(), saveParams);
			}else {
					StringBuilder updateQuery = new StringBuilder("update customer_prospect set active_prospect=:active_prospect,prospect_category=:prospect_category,qual_date=:qual_date,referred_by_customer_id=:referred_by_customer_id, source_code_id=:source_code_id,audit_qual_category=:audit_qual_category, audit_qual_source_id=:audit_qual_source_id,audit_subscription_type_id=:audit_subscription_type_id,audit_name_title_id=:audit_name_title_id,audit_sales_channel_id=:audit_sales_channel_id where customer_id="+prospectModel.getCustomerId() +" and oc_id="+prospectModel.getOrderCode()+" and customer_prospect_seq=:customer_prospect_seq");
				    saveParams.put("active_prospect", "1".equals(prospectModel.getActiveProspect()) ? 1 : 0);
					saveParams.put("prospect_category", prospectModel.getProspectCategory());
					int prospectSeq = jdbcTemplate.queryForObject("select top 1 customer_prospect_seq from customer_prospect where customer_id="+prospectModel.getCustomerId()+" and oc_id="+prospectModel.getOrderCode()+" order by customer_prospect_seq desc", Integer.class);
					saveParams.put("customer_prospect_seq", prospectSeq);
					saveParams.put("qual_date", prospectModel.getQualDate());
					if(("null".equals(prospectModel.getReferredByCustomerId())) || ("".equals(prospectModel.getReferredByCustomerId()))) {
						saveParams.put("referred_by_customer_id", null);
					}else {
						saveParams.put("referred_by_customer_id", prospectModel.getReferredByCustomerId());
					}
					if(("null".equals(prospectModel.getSourceCodeId())) || ("".equals(prospectModel.getSourceCodeId()))) {
						saveParams.put("source_code_id", null);
					}else {
						saveParams.put("source_code_id", prospectModel.getSourceCodeId());
					}
					if(("null".equals(prospectModel.getOrderCode())) || ("".equals(prospectModel.getOrderCode()))) {
						saveParams.put("oc_id", null);
						saveParams.put("audit_qual_category", null);
						saveParams.put("audit_qual_source_id", null);
						saveParams.put("audit_subscription_type_id", null);
						saveParams.put("audit_name_title_id", null);
						saveParams.put("audit_sales_channel_id", null);
					}else {
						saveParams.put("oc_id", prospectModel.getOrderCode());
						List<Integer> auditedList = jdbcTemplate.queryForList("select audited from pub where oc_id="+ prospectModel.getOrderCode(), Integer.class);
						Integer audited = 0;
						if(auditedList.size() != 0)
							audited = auditedList.get(0);
						if(audited == 1) {
							saveParams.put("audit_qual_category", prospectModel.getAuditQualCategory());
							saveParams.put("audit_qual_source_id", prospectModel.getAuditQualSourceId());
							saveParams.put("audit_subscription_type_id", prospectModel.getAuditSubscriptionTypeId());
							saveParams.put("audit_name_title_id", prospectModel.getAuditNameTitleId());
							saveParams.put("audit_sales_channel_id", prospectModel.getAuditSalesChannelId());
						}else {
							saveParams.put("audit_qual_category", null);
							saveParams.put("audit_qual_source_id", null);
							saveParams.put("audit_subscription_type_id", null);
							saveParams.put("audit_name_title_id", null);
							saveParams.put("audit_sales_channel_id", null);
						}
					namedParameterJdbcTemplate.update(updateQuery.toString(), saveParams);
					}
			}
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	
	@Override
	public int updateProspectSetup(ProspectModel prospectModel) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		try {
			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			StringBuilder editTrail = new StringBuilder(
					"insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,"
							+ "edited,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name)"
							+ "values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,"
							+ ":edited,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
			updateParams.put("edit_trail_id", editTrailId);
			updateParams.put("customer_id", prospectModel.getCustomerId());
			updateParams.put("customer_address_seq", prospectModel.getCustomerProspectSeq());
			String userCode = jdbcTemplate.queryForObject("select user_code from customer where customer_id="+prospectModel.getCustomerId(), String.class);
			updateParams.put("user_code", userCode);
			updateParams.put("edited", 0);
			updateParams.put("table_enum", 2);
			updateParams.put("document_reference_id", 1);
			updateParams.put("local_amount", 0);
			updateParams.put("base_amount", 0);
			updateParams.put("date_stamp", dateStamp);
			updateParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			updateParams.put("xaction_name", "prospect_add_request");
			namedParameterJdbcTemplate.update(editTrail.toString(), updateParams);
			customerUtility.updateMruEditTrailId(editTrailId);
			updateParams.clear();
			
			StringBuilder customerProspect = new StringBuilder("update customer_prospect set active_prospect=:active_prospect,prospect_category=:prospect_category,qual_date=:qual_date,referred_by_customer_id=:referred_by_customer_id, source_code_id=:source_code_id where customer_id="+prospectModel.getCustomerId() +" and customer_prospect_seq="+prospectModel.getCustomerProspectSeq());
			    updateParams.put("active_prospect", "1".equals(prospectModel.getActiveProspect()) ? 1 : 0);
				updateParams.put("prospect_category", prospectModel.getProspectCategory());
				updateParams.put("qual_date", prospectModel.getQualDate());
				if(("null".equals(prospectModel.getReferredByCustomerId())) || ("".equals(prospectModel.getReferredByCustomerId()))) {
					updateParams.put("referred_by_customer_id", null);
				}else {
					updateParams.put("referred_by_customer_id", prospectModel.getReferredByCustomerId());
				}
				if(("null".equals(prospectModel.getSourceCodeId())) || ("".equals(prospectModel.getSourceCodeId()))) {
					updateParams.put("source_code_id", null);
				}else {
					updateParams.put("source_code_id", prospectModel.getSourceCodeId());
				}
			namedParameterJdbcTemplate.update(customerProspect.toString(), updateParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	
	@Override
	public List<Map<String, Object>> getGroupMemberOrderDetail(Long customerId){
		List<Map<String, Object>> groupMemberOrder = null;
		try {
			StringBuilder query = new StringBuilder("select grp_mbr_item_dtl.orderhdr_id,grp_mbr_item_dtl.order_item_seq,grp_mbr_item_dtl_seq, "  
					+ " customer_group_customer_id,grp_mbr_item_dtl.customer_id,n_copies,oc,order_code, ");  
			query.append(" case when order_status=0 then 'Order Placed' when order_status=1 then 'Canceled - Nonpayment' "
					+ "when order_status=2 then 'Canceled - Customer Request' when order_status=3 "
					+ "then 'Canceled - Credit Card Not Authorized'when order_status=4 "
					+ "then 'Canceled - Audit Information Problem' when order_status=5 "
					+ "then 'Active / Shipping'when order_status=6 then 'Complete' when order_status=7 "
					+ "then 'Grace Period' when order_status=8 then 'Suspend - Nonpayment' when order_status=9 "
					+ "then 'Suspend - Temporary' when order_status=10 then 'Hold for Payment' when order_status=11 "
					+ "then 'Suspended - Delivery Problem' when order_status=12 then 'Suspended - Distribution Problem' "
					+ "when order_status=13 then 'Suspended - Audit Information Problem' when order_status=14 "
					+ "then 'Canceled - Audit Information Problem' when order_status=15 then 'Hold Until Fulfillment Date' "
					+ "when order_status=16 then 'Suspended - Behavior' end as order_status,");
			query.append(" CONVERT(varchar ,CONVERT(DATE,start_date,101),101) as start_date, "  
					+ " CONVERT(varchar ,CONVERT(DATE,expire_date,101),101) as expire_date,start_issue_id, "  
					+ " stop_issue_id,customer_group.description from grp_mbr_item_dtl "  
					+ " left join order_item on order_item.orderhdr_id=grp_mbr_item_dtl.orderhdr_id "  
					+ " left join oc on oc.oc_id=order_item.oc_id "  
					+ " left join order_code on order_code.order_code_id=order_item.order_code_id "  
					+ " left join customer_group on customer_group.customer_id=order_item.customer_id "  
					+ "  where grp_mbr_item_dtl.customer_id="+customerId);
			groupMemberOrder = jdbcTemplate.queryForList(query.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return groupMemberOrder;
	}
	
	@Override
	public List<DropdownModel> getAuditNameTitle(int ocId) {
		List<DropdownModel> auditNameTitle  = new ArrayList<>();
		try {
			List<Map<String, Object>> nameTitle = jdbcTemplate.queryForList(
					" select audit_name_title_id,audit_name_title,description from pub left join audit_name_title on audit_name_title.audit_pub_group = pub.name_title_pub_group where oc_id="+ocId);
			for (Map<String, Object> audit : nameTitle) {
				DropdownModel model = new DropdownModel();
				model.setKey(audit.get("audit_name_title_id")!=null?audit.get("audit_name_title_id").toString():"");
				model.setDisplay(audit.get("audit_name_title")!=null?audit.get("audit_name_title").toString():"");
				model.setDescription(audit.get("description")!=null?audit.get("description").toString():"");
				auditNameTitle.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return auditNameTitle;
	}
	
	@Override
	public List<DropdownModel> getAuditQualSource(int ocId) {
		List<DropdownModel> auditQualSource  = new ArrayList<>();
		try {
			List<Map<String, Object>> qualSource = jdbcTemplate.queryForList(
					" select audit_qual_source_id,audit_qual_source,description from pub left join audit_qual_source on audit_qual_source.audit_pub_group = pub.qual_source_pub_group where oc_id="+ocId);
			for (Map<String, Object> audit : qualSource) {
				DropdownModel model = new DropdownModel();
				model.setKey(audit.get("audit_qual_source_id")!=null?audit.get("audit_qual_source_id").toString():"");
				model.setDisplay(audit.get("audit_qual_source")!=null?audit.get("audit_qual_source").toString():"");
				model.setDescription(audit.get("description")!=null?audit.get("description").toString():"");
				auditQualSource.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return auditQualSource;
	}
	
	@Override
	public List<DropdownModel> getAuditSalesChannel(int ocId) {
		List<DropdownModel> auditSalesChannel  = new ArrayList<>();
		try {
			List<Map<String, Object>> salesChannel = jdbcTemplate.queryForList(
					" select audit_sales_channel_id,audit_sales_channel,description from pub left join audit_sales_channel on audit_sales_channel.audit_pub_group = pub.sales_channel_pub_group where oc_id="+ocId);
			for (Map<String, Object> audit : salesChannel) {
				DropdownModel model = new DropdownModel();
				model.setKey(audit.get("audit_sales_channel_id")!=null?audit.get("audit_sales_channel_id").toString():"");
				model.setDisplay(audit.get("audit_sales_channel")!=null?audit.get("audit_sales_channel").toString():"");
				model.setDescription(audit.get("description")!=null?audit.get("description").toString():"");
				auditSalesChannel.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return auditSalesChannel;
	}
	
	@Override
	public List<DropdownModel> getAuditSubscriptionType(int ocId) {
		List<DropdownModel> auditSubscriptionType  = new ArrayList<>();
		try {
			List<Map<String, Object>> subscriptionType = jdbcTemplate.queryForList(
					" select audit_subscription_type_id,audit_subscription_type,description from pub left join audit_subscription_type on audit_subscription_type.audit_pub_group = pub.sub_type_pub_group where oc_id="+ocId);
			for (Map<String, Object> audit : subscriptionType) {
				DropdownModel model = new DropdownModel();
				model.setKey(audit.get("audit_subscription_type_id")!=null?audit.get("audit_subscription_type_id").toString():"");
				model.setDisplay(audit.get("audit_subscription_type")!=null?audit.get("audit_subscription_type").toString():"");
				model.setDescription(audit.get("description")!=null?audit.get("description").toString():"");
				auditSubscriptionType.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return auditSubscriptionType;
	}
	
	@Override
	public ProspectModel getEditAuditInfo(Long orderHdrId, int orderItemSeq, int ocId){
		List<Map<String, Object>> edtiAuditInfo = null;
		ProspectModel model = new ProspectModel();
		
		try {
			StringBuilder query = new StringBuilder(" select  order_item.audit_qual_category,  CONVERT(varchar ,CONVERT(DATE,qual_date,101),101) as qual_date,CONVERT(varchar ,CONVERT(DATE,squal_date,101),101) as squal_date,isNull(cast(order_item.audit_qual_source_id as varchar),'') as audit_qual_source_id,isNull(cast(order_item.audit_subscription_type_id as varchar),'') as audit_subscription_type_id,isNull(cast(order_item.audit_name_title_id as varchar),'') as audit_name_title_id,isNull(cast(order_item.audit_sales_channel_id as varchar),'') as audit_sales_channel_id,isNull(cast(percent_of_basic_price as varchar),'') as percent_of_basic_price ,order_code,pub.qp,pub.qf,pub.nqp,pub.nqf  from order_item   left join order_code on order_code.order_code_id = order_item.order_code_id  left join pub on pub.oc_id = order_item.oc_id where orderhdr_id="+orderHdrId+" and order_item_seq="+orderItemSeq+" and order_item.oc_id="+ocId );
			edtiAuditInfo = jdbcTemplate.queryForList(query.toString());
			String duration = jdbcTemplate.queryForObject("select  top 1 description from audit_duration left join pub on pub.duration_pub_group = audit_duration.audit_pub_group where low_n_months=(select top 1 duration from order_item where oc_id="+ocId+")", String.class);
			
			for (Map<String, Object> audit : edtiAuditInfo) {
				model.setAuditQualCategory(audit.get("audit_qual_category")!=null?audit.get("audit_qual_category").toString():"0");
				model.setQualDate(audit.get("qual_date")!=null?audit.get("qual_date").toString():"");
				model.setSqualDate(audit.get("squal_date")!=null?audit.get("squal_date").toString():"");
				model.setAuditQualSourceId(audit.get("audit_qual_source_id").toString());
				model.setAuditSubscriptionTypeId(audit.get("audit_subscription_type_id").toString());
				model.setAuditNameTitleId(audit.get("audit_name_title_id").toString());
				model.setAuditSalesChannelId(audit.get("audit_sales_channel_id").toString());
				model.setBasicPrice(audit.get("percent_of_basic_price").toString());
				model.setDuration(duration);
				model.setOrderCode(audit.get("order_code").toString());
				model.setQP(Integer.parseInt(audit.get("qp").toString()));
				model.setQF(Integer.parseInt(audit.get("qf").toString()));
				model.setNQP(Integer.parseInt(audit.get("nqp").toString()));
				model.setNQF(Integer.parseInt(audit.get("nqf").toString()));
			}
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return model;
	}
	
	@Override
	public int updateEditAuditInfo(OrderItem orderItem) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		try {
			StringBuilder query = new StringBuilder(" update order_item set audit_qual_category=:audit_qual_category,qual_date=:qual_date,"
					+ "squal_date=:squal_date,audit_name_title_id=:audit_name_title_id,audit_qual_source_id=:audit_qual_source_id,"
					+ "audit_sales_channel_id=:audit_sales_channel_id,audit_subscription_type_id=:audit_subscription_type_id "
					+ "where orderhdr_id="+orderItem.getOrderhdrId()+" and order_item_seq="+orderItem.getOrderItemSeq());
			updateParams.put("audit_qual_category", orderItem.getAuditQualCategory());
			updateParams.put("qual_date", orderItem.getQualDate());
			updateParams.put("squal_date", orderItem.getSqualDate());
			updateParams.put("audit_name_title_id", orderItem.getAuditNameTitleId());
			updateParams.put("audit_qual_source_id", orderItem.getAuditSourceId());
			updateParams.put("audit_sales_channel_id", orderItem.getAuditSalesChannelId());
			updateParams.put("audit_subscription_type_id", orderItem.getAuditSubscriptionTypeId());
			namedParameterJdbcTemplate.update(query.toString(), updateParams);
			
			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			
			StringBuilder editTrail = new StringBuilder(" insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited, "
					+" currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name) "
					+" values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited, " 
					+" :currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
			
			updateParams.put("orderhdr_id", orderItem.getOrderhdrId());
			updateParams.put("order_item_seq", orderItem.getOrderItemSeq());
			updateParams.put("edit_trail_id", editTrailId);
			String customer = jdbcTemplate.queryForObject(" select customer_id from order_item where orderhdr_id="+orderItem.getOrderhdrId()+" and order_item_seq="+orderItem.getOrderItemSeq(), String.class);
			updateParams.put("customer_id", customer);
			updateParams.put("customer_address_seq", 1);
			String userCode = jdbcTemplate.queryForObject(" select user_code from order_item where orderhdr_id="+orderItem.getOrderhdrId()+" and order_item_seq="+orderItem.getOrderItemSeq(), String.class);
			updateParams.put("user_code", userCode);
			String subscripId = jdbcTemplate.queryForObject(" select subscrip_id from order_item where orderhdr_id="+orderItem.getOrderhdrId()+" and order_item_seq="+orderItem.getOrderItemSeq(), String.class);
			updateParams.put("subscrip_id", subscripId);
			updateParams.put("edited", 1);
			String currency = jdbcTemplate.queryForObject(" select currency from order_item where orderhdr_id="+orderItem.getOrderhdrId()+" and order_item_seq="+orderItem.getOrderItemSeq(), String.class);
			updateParams.put("currency", currency);
			updateParams.put("table_enum", 3);
			updateParams.put("document_reference_id", 1);
			String amount = jdbcTemplate.queryForObject(" select gross_base_amount from order_item where orderhdr_id="+orderItem.getOrderhdrId()+" and order_item_seq="+orderItem.getOrderItemSeq(), String.class);
			updateParams.put("local_amount", amount);
			updateParams.put("base_amount", amount);
			updateParams.put("date_stamp", dateStamp);
			updateParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			updateParams.put("xaction_name", "order_item_edit_request");
			namedParameterJdbcTemplate.update(editTrail.toString(), updateParams);
			customerUtility.updateMruEditTrailId(editTrailId);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	
	@Override
	public ProspectModel getAudit(int ocId){
		List<Map<String, Object>> edtiAuditInfo = null;
		ProspectModel model = new ProspectModel();
		try {
			StringBuilder query = new StringBuilder("select '' as audit_qual_category, (select( CONVERT(varchar ,CONVERT(DATE,getdate(),101),101))) as qual_date, '' as squal_date,'' as audit_qual_source_id,  '' as audit_subscription_type_id, '' as audit_name_title_id,'' as audit_sales_channel_id,'' as percent_of_basic_price,pub.qp,pub.qf,pub.nqp,pub.nqf  from pub left join customer_prospect on pub.oc_id = customer_prospect.oc_id where pub.oc_id="+ocId);
			edtiAuditInfo = jdbcTemplate.queryForList(query.toString());
			
			for (Map<String, Object> audit : edtiAuditInfo) {
				model.setAuditQualCategory(audit.get("audit_qual_category").toString());
				model.setQualDate(audit.get("qual_date").toString());
				model.setSqualDate(audit.get("squal_date").toString());
				model.setAuditQualSourceId(audit.get("audit_qual_source_id").toString());
				model.setAuditSubscriptionTypeId(audit.get("audit_subscription_type_id").toString());
				model.setAuditNameTitleId(audit.get("audit_name_title_id").toString());
				model.setAuditSalesChannelId(audit.get("audit_sales_channel_id").toString());
				model.setBasicPrice(audit.get("percent_of_basic_price").toString());
				model.setQP(Integer.parseInt(audit.get("qp").toString()));
				model.setQF(Integer.parseInt(audit.get("qf").toString()));
				model.setNQP(Integer.parseInt(audit.get("nqp").toString()));
				model.setNQF(Integer.parseInt(audit.get("nqf").toString()));
			}
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return model;
	}
	
	@Override
	public ProspectModel getAuditOrder(int ocId,String orderCodeId){
		List<Map<String, Object>> edtiAuditInfo = null;
		ProspectModel model = new ProspectModel();
		try {
			StringBuilder query = new StringBuilder("select order_code,'0' as audit_qual_category, audited,'' as qual_date, '' as squal_date,isnull(cast(audit_qual_source_id as varchar),'') as audit_qual_source_id,isnull(cast(audit_subscription_type_id as varchar),'') as audit_subscription_type_id,isnull(cast(audit_name_title_id as varchar),'') as audit_name_title_id,isnull(cast(audit_sales_channel_id as varchar),'') as audit_sales_channel_id,'' as percent_of_basic_price,pub.qp,pub.qf,pub.nqp,pub.nqf  from order_code left join pub on order_code.oc_id = pub.oc_id where order_code.order_code_id="+orderCodeId);
			edtiAuditInfo = jdbcTemplate.queryForList(query.toString());
			
			String duration = jdbcTemplate.queryForObject("select  top 1 description from audit_duration left join pub on pub.duration_pub_group = audit_duration.audit_pub_group where low_n_months=(select top 1 duration from order_item where oc_id="+ocId+")", String.class);
			for (Map<String, Object> audit : edtiAuditInfo) {
				model.setAuditQualCategory(audit.get("audit_qual_category").toString());
				model.setQualDate(audit.get("qual_date").toString());
				model.setSqualDate(audit.get("squal_date").toString());
				model.setAuditQualSourceId(audit.get("audit_qual_source_id").toString());
				model.setAuditSubscriptionTypeId(audit.get("audit_subscription_type_id").toString());
				model.setAuditNameTitleId(audit.get("audit_name_title_id").toString());
				model.setAuditSalesChannelId(audit.get("audit_sales_channel_id").toString());
				model.setBasicPrice(audit.get("percent_of_basic_price").toString());
				model.setQP(Integer.parseInt(audit.get("qp").toString()));
				model.setQF(Integer.parseInt(audit.get("qf").toString()));
				model.setNQP(Integer.parseInt(audit.get("nqp").toString()));
				model.setNQF(Integer.parseInt(audit.get("nqf").toString()));
				model.setOrderCode(audit.get("order_code").toString());
				model.setDuration(duration);
			}
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return model;
	}
	
	@Override
	public ProspectModel getAddAuditInfo(Long orderHdrId, int orderItemSeq, int ocId){
		List<Map<String, Object>> edtiAuditInfo = null;
		ProspectModel model = new ProspectModel();
		try {
				StringBuilder query = new StringBuilder(" select order_item.audit_qual_category, " 
						+ " CONVERT(varchar ,CONVERT(DATE,qual_date,101),101) as qual_date, " 
						+ " CONVERT(varchar ,CONVERT(DATE,squal_date,101),101) as squal_date, " 
						+ " isNull(cast(order_item.audit_qual_source_id as varchar),'') as audit_qual_source_id, " 
						+ " isNull(cast(order_item.audit_subscription_type_id as varchar),'') as audit_subscription_type_id," 
						+ " isNull(cast(order_item.audit_name_title_id as varchar),'') as audit_name_title_id, "  
						+ " isNull(cast(order_item.audit_sales_channel_id as varchar),'') as audit_sales_channel_id,"
						+ " isNull(cast(percent_of_basic_price as varchar),'') as percent_of_basic_price,pub.qp,pub.qf,pub.nqp,pub.nqf,order_code " 
						+ " from order_item "
						+ " left join order_code on order_code.order_code_id = order_item.order_code_id "  
						+ " left join pub on pub.oc_id = order_item.oc_id "
						+ " where orderhdr_id="+orderHdrId+" and order_item_seq="+orderItemSeq+" and order_item.oc_id="+ocId );
				edtiAuditInfo = jdbcTemplate.queryForList(query.toString());
				String duration = jdbcTemplate.queryForObject("select  top 1 description from audit_duration left join pub on pub.duration_pub_group = audit_duration.audit_pub_group where low_n_months=(select top 1 duration from order_item where oc_id="+ocId+")", String.class);
				
				for (Map<String, Object> audit : edtiAuditInfo) {
					model.setAuditQualCategory(audit.get("audit_qual_category")!=null?audit.get("audit_qual_category").toString():"0");
					model.setQualDate(audit.get("qual_date")!=null?audit.get("qual_date").toString():"");
					model.setSqualDate(audit.get("squal_date")!=null?audit.get("squal_date").toString():"");
					model.setAuditQualSourceId(audit.get("audit_qual_source_id").toString());
					model.setAuditSubscriptionTypeId(audit.get("audit_subscription_type_id").toString());
					model.setAuditNameTitleId(audit.get("audit_name_title_id").toString());
					model.setAuditSalesChannelId(audit.get("audit_sales_channel_id").toString());
					model.setBasicPrice(audit.get("percent_of_basic_price").toString());
					model.setDuration(duration);
					model.setQP(Integer.parseInt(audit.get("qp").toString()));
					model.setQF(Integer.parseInt(audit.get("qf").toString()));
					model.setNQP(Integer.parseInt(audit.get("nqp").toString()));
					model.setNQF(Integer.parseInt(audit.get("nqf").toString()));
					model.setOrderCode(audit.get("order_code").toString());
				}
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return model;
	}
	
	@Override
	public int saveAuditInfo(OrderItem orderItem) {
		Map<String, Object> saveParams = new LinkedHashMap<>();
		int status = 0;
		try {
			StringBuilder query = new StringBuilder("insert into order_item (orderhdr_id,order_item_seq,audit_qual_category,qual_date,squal_date,audit_name_title_id,audit_qual_source_id,audit_sales_channel_id,audit_subscription_type_id) values(:orderhdr_id,:order_item_seq,:audit_qual_category,:qual_date,:squal_date,:audit_name_title_id,:audit_qual_source_id,:audit_sales_channel_id,:audit_subscription_type_id)");
			saveParams.put("audit_qual_category", orderItem.getAuditQualCategory());
			saveParams.put("qual_date", orderItem.getQualDate());
			saveParams.put("squal_date", orderItem.getSqualDate());
			saveParams.put("audit_name_title_id", orderItem.getAuditNameTitleId());
			saveParams.put("audit_qual_source_id", orderItem.getAuditSourceId());
			saveParams.put("audit_sales_channel_id", orderItem.getAuditSalesChannelId());
			saveParams.put("audit_subscription_type_id", orderItem.getAuditSubscriptionTypeId());
			namedParameterJdbcTemplate.update(query.toString(), saveParams);
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	
	@Override
	public List<Map<String, Object>> getUpsellItem(int ocId){
		List<Map<String , Object>> upsellItem = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(" select order_code,(case when upsell_type=0 then 'Upsell' when upsell_type=1 then ' Cross-Sell' end) as upsell_type,isNull(cast(upsell_suggestion_id as varchar),'') as upsell_suggestion_id,order_code.description," 
					+ " source_code,upsell.order_code_id,upsell.oc_id,upsell.source_code_id,upsell_id,calendar_campaign_id, " 
					+ " isNull(cast(package_id as varchar),'') as package_id,isNull(cast(sou_source_code_id as varchar),'') as sou_source_code_id," 
					+ " isNull(script_text,'') as script_text,upsell_on  from upsell "  
					+ " left join order_code on order_code.order_code_id = upsell.order_code_id "  
					+ " left join source_code on source_code.source_code_id = upsell.source_code_id "  
					+ " left join oc on oc.oc_id = upsell.oc_id where upsell.oc_id=(select parent_oc_id from oc where oc_id = "+ocId+" ) and "  
					+ " calendar_campaign_id in (select calendar_campaign_id from calendar_campaign where calendar_campaign_id in " 
					+ " (select(case when (begin_month=1 and end_month in (SELECT month(getDate()) AS Year )) then calendar_campaign_id "  
					+ " when (begin_month=2 and end_month in (1,(SELECT month(getDate()) AS Year ))) then calendar_campaign_id "  
					+ " when (begin_month=3 and end_month in (1,2,(SELECT month(getDate()) AS Year ))) then calendar_campaign_id " 
					+ " when (begin_month=4 and end_month in (1,2,3,(SELECT month(getDate()) AS Year ))) then calendar_campaign_id "  
					+ " when (begin_month=5 and end_month in (1,2,3,4,(SELECT month(getDate()) AS Year ))) then calendar_campaign_id "  
					+ " when (begin_month=6 and end_month in (1,2,3,4,5,(SELECT month(getDate()) AS Year ))) then calendar_campaign_id "  
					+ " when (begin_month=7 and end_month in (1,2,3,4,5,6,(SELECT month(getDate()) AS Year ))) then calendar_campaign_id "  
					+ " when (begin_month=8 and end_month in (1,2,3,4,5,6,7,(SELECT month(getDate()) AS Year ))) then calendar_campaign_id "  
					+ " when (begin_month=9 and end_month in (1,2,3,4,5,6,7,8,(SELECT month(getDate()) AS Year ))) then calendar_campaign_id " 
					+ " when (begin_month=10 and end_month in (1,2,3,4,5,6,7,8,9,(SELECT month(getDate()) AS Year ))) then calendar_campaign_id " 
					+ " when (begin_month=11 and end_month in (1,2,3,4,5,6,7,8,9,10,(SELECT month(getDate()) AS Year ))) then calendar_campaign_id "  
					+ " when (begin_month=12 and end_month in (1,2,3,4,5,6,7,8,9,10,11,(SELECT month(getDate()) AS Year ))) then calendar_campaign_id "  
					+ " end ) as id from calendar_campaign))");
			upsellItem = jdbcTemplate.queryForList(query.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return upsellItem;
	}

	@Override
	public String getUpgradeDowngrade(int subscription_def_id, String gridDefID, long orderhdrId, int orderItemSeq) throws Exception {
		String orderstatus="false";
		orderstatus= orderAddWsdl.subscriptionUpgradeDowngrade(subscription_def_id, gridDefID, orderhdrId, orderItemSeq);
		return orderstatus;
	}
	
	
	@Override
	public List<DropdownModel> getstartDate(String orderCode) {
		
			List<DropdownModel> startDateresult = new ArrayList<>();
			try {
				List<Map<String, Object>> startDate = jdbcTemplate.queryForList(
						" select issue.issue_id,issue.issue_date,issue.enumeration from issue left join order_code on issue.oc_id=order_code.oc_id where order_code.order_code='"+orderCode+"'");
				for (Map<String, Object> date : startDate) {
					DropdownModel model = new DropdownModel();
					model.setKey(date.get("issue_id").toString());
					model.setDisplay(date.get("issue_date") != null ? date.get("issue_date").toString() : "");
					model.setDescription(
							date.get("enumeration") != null ? date.get("enumeration").toString() : "");
					model.setExtra(date.get("volume") != null ? date.get("volume").toString() : "");
					startDateresult.add(model);
				}
			} catch (Exception e) {
				LOGGER.error(ERROR + e);
			}
			return startDateresult;
		}

	@Override
	public List<DropdownModel> getBackIssueDetails(String orderCode) {
		List<DropdownModel> backIssueDetails = new ArrayList<>();
		try {
			List<Map<String, Object>> backIssue = jdbcTemplate.queryForList(
					"select back_issue.status,back_issue.qty_ordered,back_issue.qty_sent,back_issue.reason,order_code.issue_id  from  order_code left join back_issue on back_issue.issue_id=order_code.issue_id where order_code.order_code='" +orderCode+"'");
			for (Map<String, Object> back : backIssue) {
				DropdownModel model = new DropdownModel();
				model.setKey(back.get("status").toString());
				model.setDisplay(back.get("issue") != null ? back.get("issue").toString() : "");
				model.setDescription(back.get("qty_ordered") != null ? back.get("qty_ordered").toString() : "");
				model.setExtra(back.get("qty_sent") != null ? back.get("qty_sent").toString() : "");
				model.setExtraData(back.get("reason") != null ? back.get("reason").toString() : "");
				model.setExtraDataDef(back.get("issue_id") != null ? back.get("issue_id").toString() : "");
				backIssueDetails.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return backIssueDetails;
	}

	@Override
	public List<DropdownModel> getRateClassDetails(String orderCode) {
		List<DropdownModel> rateClassDetails = new ArrayList<>();
		try {
			List<Map<String, Object>> rateClass1 = jdbcTemplate.queryForList(
					"select rate_class_effective.description,rate_class_effective.effective_date,rate_class.rate_class from rate_class left join rate_class_effective on rate_class.rate_class_id=rate_class_effective.rate_class_id left join order_code on order_code.newsub_rate_class_id=rate_class_effective.rate_class_id where order_code.order_code='" +orderCode+"'");
			for (Map<String, Object> rate : rateClass1) {
				DropdownModel model = new DropdownModel();
				model.setKey(rate.get("description").toString());
				model.setDisplay(rate.get("effective_date") != null ? rate.get("effective_date").toString() : "");
				rateClassDetails.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rateClassDetails;
	}

	@Override
	public List<DropdownModel> getCategoryDetails() {
		
			List<DropdownModel> categoryDetails = new ArrayList<>();
			try {
				List<Map<String, Object>> category = jdbcTemplate.queryForList(
						"select order_category,description from order_category");
				for (Map<String, Object> details : category) {
					DropdownModel model = new DropdownModel();
					model.setKey(details.get("order_category").toString());
					model.setDisplay(details.get("description") != null ? details.get("description").toString() : "");
					categoryDetails.add(model);
				}
			} catch (Exception e) {
				LOGGER.error(ERROR + e);
			}
			return categoryDetails;
			
	}

	@Override
	public List<DropdownModel> getShippingDeliveryDetails() {
		List<DropdownModel> shippingDeliveryDetails = new ArrayList<>();
		try {
			List<Map<String, Object>> shippingDetails = jdbcTemplate.queryForList(
					"select shipping_method as delivery_method,description from shipping_method");
			for (Map<String, Object> details : shippingDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(details.get("delivery_method").toString());
				model.setDisplay(details.get("description") != null ? details.get("description").toString() : "");
				shippingDeliveryDetails.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return shippingDeliveryDetails;
		
	}

	@Override
	public List<DropdownModel> getDemographicDetails() {
		List<DropdownModel> demographicDetails = new ArrayList<>();
		try {
			List<Map<String, Object>> demoDetails = jdbcTemplate.queryForList(
					"select dem_form,description from dem_form");
			for (Map<String, Object> details : demoDetails) {
				DropdownModel model = new DropdownModel();
				model.setKey(details.get("dem_form").toString());
				model.setDisplay(details.get("description") != null ? details.get("description").toString() : "");
				demographicDetails.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return demographicDetails;
	}
	
	
	
	
	@Override
	public List<DropdownModel> getAddressDetails(int customerId) {
		List<DropdownModel> address = new ArrayList<>();
		try {
			List<Map<String, Object>> Address = jdbcTemplate.queryForList(
					" select address_type,address1,city,state,zip,phone from customer_address where customer_id=" + customerId);
			for (Map<String, Object> add : Address) {
				DropdownModel model = new DropdownModel();
				model.setKey(add.get("address_type").toString());
				model.setDisplay(add.get("address1") != null ? add.get("address1").toString() : "");
				model.setDescription(add.get("city") != null ? add.get("city").toString() : "");
				model.setExtra(add.get("state") != null ? add.get("state").toString() : "");
				model.setExtraData(add.get("zip") != null ? add.get("zip").toString() : "");
				model.setExtraDataDef(add.get("phone") != null ? add.get("phone").toString() : "");
				address.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return address;
	
	}

	@Override
	public List<Map<String, Object>>  getUpsellOrder(int ocId,int orderCodeId, int sourceCodeId,int upsellId){
		List<Map<String, Object>> upsellOrder = new ArrayList<>();
		try {
				StringBuilder query = new StringBuilder(" select upsell_id,upsell.order_code_id,order_code,order_code.description as ocDescription,upsell.source_code_id,source_code,source_code.description as scDescription,order_code.oc_id,upsell_on,order_code_type  from upsell left join order_code on order_code.order_code_id = upsell.order_code_id left join source_code on source_code.source_code_id = upsell.source_code_id left join oc on oc.oc_id = upsell.oc_id where upsell.oc_id="+ocId+" and upsell.order_code_id="+orderCodeId+" and upsell.source_code_id="+sourceCodeId+" and upsell_id="+ upsellId);
				upsellOrder = jdbcTemplate.queryForList(query.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return upsellOrder;
	}
	
	 
	 
 	@Override
public OrderItem getOrderItemEditDetails(int orderHdrId, int order_item_seq) {
	List<OrderItem> orderItems = new ArrayList<>();
	List<OrderItem> orderItemDetails =null;
	List<Map<String,Object>> order=new ArrayList<>();
	
	OrderItem orderDetails=new OrderItem();
		try {
		
		String query="select order_code_id,source_code_id,order_item_seq from order_item where orderhdr_id="+orderHdrId;
			order= jdbcTemplate.queryForList(query.toString());
			int sourceId=order.get(0).get("source_code_id")!=null?Integer.parseInt(order.get(0).get("source_code_id").toString()):0;
			int orderCodeId=order.get(0).get("order_code_id")!=null?Integer.parseInt(order.get(0).get("order_code_id").toString()):0;
			String queryToGetCode="select order_code.order_code,source_code.source_code from order_code left join source_code on order_code.oc_id=source_code.oc_id  where order_code.order_code_id="+orderCodeId+" or source_code.source_code_id="+sourceId;
			List<Map<String, Object>> codes= jdbcTemplate.queryForList(queryToGetCode.toString());
			
			for(Map<String, Object> items:codes) {
				orderDetails.setSourceCode(items.get("source_code")!= null ? items.get("source_code").toString() : "");
				orderDetails.setOrderCode(items.get("order_code")!= null ? items.get("order_code").toString() : "");
				orderDetails.setOrderItemSeq(order_item_seq);
				
			}
						
				List<Order_item_select_responseOrder_item[]> list=  orderItemAddWsdl.getOrderItemEditDetails( orderHdrId, order_item_seq);
				
			for(Order_item_select_responseOrder_item[] map:list){
				
				orderDetails.setOrderCodeID(String.valueOf(map[0].getOrder_code_id()));
				orderDetails.setUserCode(String.valueOf(map[0].getUser_code()));
				orderDetails.setOrderItemType(map[0].getOrder_item_type());
				orderDetails.setSourceCodeID(String.valueOf(map[0].getSource_code_id()));
				orderDetails.setStartDate(String.valueOf(map[0].getStart_date()));
				orderDetails.setnIssueLeft(String.valueOf(map[0].getN_issues_left()));
				orderDetails.setnRemainingNonPaidIssues(map[0].getN_remaining_nonpaid_issues());
				orderDetails.setExtendedDays(map[0].getExtended_days());
				orderDetails.setExtendedRate(String.valueOf(map[0].getExtended_rate()));
				orderDetails.setSubscriptionDefId(String.valueOf(map[0].getSubscription_def_id()));
				orderDetails.setRateClassId(map[0].getRate_class_id());
				orderDetails.setExRateClassEffectiveSeq(String.valueOf(map[0].getRate_class_effective_seq()));
				orderDetails.setOrderDate1((map[0].getOrder_date()));
				Calendar date=orderDetails.getOrderDate1();
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String dateFormatted = format.format(date.getTime());
				orderDetails.setOrderDate(dateFormatted);
				orderDetails.setNumberVolumeSets(String.valueOf(map[0].getNumber_volume_sets()));
				orderDetails.setTrialType((map[0].getTrial_type()));
				orderDetails.setManualDiscPercentage(Double.parseDouble(map[0].getManual_disc_percentage().toString()));
				orderDetails.setOrderCategory(map[0].getOrder_category());
				orderDetails.setOrder_status(String.valueOf(map[0].getOrder_status()));
				orderDetails.setPayment_status(String.valueOf(map[0].getPayment_status()));
				orderDetails.setRenewalDef(String.valueOf(map[0].getRenewal_def()));
				orderDetails.setOrderType(map[0].getOrder_type());
				orderDetails.setProductId(String.valueOf(map[0].getProduct_id()));
				orderDetails.setOcId(map[0].getOc_id());
				orderDetails.setOrderCategory(map[0].getOrder_category());
				orderDetails.setExpireDate(String.valueOf((map[0].getExpire_date())));
				orderDetails.setSubscripStartType(map[0].getSubscrip_start_type());
				orderDetails.setInvoiceId(String.valueOf(map[0].getInvoice_id()));
				orderDetails.setInventoryId(String.valueOf(map[0].getInventory_id()));
				orderDetails.setRateClassEffectiveSeq(map[0].getRate_class_effective_seq());
				orderDetails.setBillDate(String.valueOf(map[0].getBill_date()));
				orderDetails.setBillToCustomerAddress(String.valueOf(map[0].getBill_to_customer_address_seq()));
				orderDetails.setGrossLocalAmount(String.valueOf(map[0].getGross_local_amount()));
				orderDetails.setGrossBaseAmount(String.valueOf(map[0].getGross_base_amount()));
				orderDetails.setNetLocalAmount(String.valueOf(map[0].getNet_local_amount()));
				orderDetails.setNetBaseAmount(map[0].getNet_base_amount().toString());
				orderDetails.setTotalTaxBaseAmount(map[0].getTotal_tax_base_amount().toString());
				orderDetails.setTotalTaxLocalAmount(String.valueOf(map[0].getTotal_tax_local_amount()));
				orderDetails.setCurrency(String.valueOf(map[0].getCurrency()));
				orderDetails.setInvoiceDate(String.valueOf(map[0].getInvoice_date()));
				orderDetails.setAmountCharged(map[0].getChange_qty_flag());
				orderDetails.setBaseAmount((map[0].getManual_disc_amt_base().toString()));
				orderDetails.setLocalAmount(String.valueOf(map[0].getManual_disc_amt_local()));
				}
			
			
			return orderDetails;
					
	}catch(Exception e){
		LOGGER.info("get OrderItemEditDetails : "+e);
	}
		return orderDetails;
}
 	
 	@Override
	public List<Map<String, Object>>  getAudited(String ocId){
		List<Map<String, Object>> audited = new ArrayList<>();
		try {
				String query = " select audited from pub where oc_id="+ocId;
				audited = jdbcTemplate.queryForList(query.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return audited;
	}
 	
 	@Override
	public List<Map<String, Object>> getDealDetails(Long customerId) {

		List<Map<String, Object>> dealDetails = new ArrayList<>();
		

		try {
			StringBuilder query = new StringBuilder(
					"select deal_id ,deal,description,deal_type,deal_status,customer_id,start_date,end_date,row_version,deal_ord_cust_required from deal where customer_id="
							+ customerId);
			dealDetails = jdbcTemplate.queryForList(query.toString());
			

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return dealDetails;
	}

	@Override
	public List<DropdownModel> getDealType() {
		List<DropdownModel> dealtype = new ArrayList<>();
		try {
			List<Map<String, Object>> type = jdbcTemplate.queryForList("select deal_type,description from deal_type");
			for (Map<String, Object> deal : type) {
				DropdownModel model = new DropdownModel();
				model.setKey(deal.get("deal_type").toString());
				model.setDisplay(deal.get("description") != null ? deal.get("description").toString() : "");
				dealtype.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return dealtype;

	}

	@Override
	public List<DropdownModel> getDealStatus() {
		List<DropdownModel> dealstatus = new ArrayList<>();
		try {
			List<Map<String, Object>> type = jdbcTemplate
					.queryForList("select deal_status,description from deal_status");
			for (Map<String, Object> deal : type) {
				DropdownModel model = new DropdownModel();
				model.setKey(deal.get("deal_status").toString());
				model.setDisplay(deal.get("description") != null ? deal.get("description").toString() : "");
				dealstatus.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return dealstatus;
	}

	@Override
	public String getStartEndDate1() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDateTime  localDate = LocalDateTime .now();
		dtf.format(localDate);
		return dtf.format(localDate);

	}

	@Override
	public List<Map<String, Object>> getDealOrderCodeDetails(int dealId) {
		List<Map<String, Object>> dealorderCodeDetails = new ArrayList<>();

		try {
			StringBuilder query = new StringBuilder(
					"select deal_id,order_code_id,(case when deal_order_code_type=0 then 'Orderable' when deal_order_code_type=1 then 'DDP' when deal_order_code_type=2 then 'Do not Cancel' end) as  deal_order_code_type,source_code_id from deal_order_code where deal_id="+dealId);
			dealorderCodeDetails = jdbcTemplate.queryForList(query.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return dealorderCodeDetails;
	}

	@Override
	public int saveDealDetails(GropDealModel deal) {
		Map<String, Object> saveParams = new LinkedHashMap<>();
		int result=0;
		String dealOrdCustRequired="false";
		try {
						
				StringBuilder saveQuery = new StringBuilder(
						" insert into deal (deal_id ,deal,description,deal_type,deal_status,customer_id,start_date,end_date,deal_ord_cust_required) values (:deal_id,:deal,:description,:deal_type,:deal_status,:customer_id,:start_date,:end_date,:deal_ord_cust_required)");
			Integer maxDealId = jdbcTemplate.queryForObject("select max(deal_id) from deal", Integer.class);
				
				System.out.println("maxDealId>="+maxDealId);

				if (maxDealId == null) {
					saveParams.put("deal_id", 1);
				} else {
					saveParams.put("deal_id", maxDealId+1);
				}
					System.out.println(deal.getDeal());
					saveParams.put("deal", deal.getDeal());
								
				
				if (("null".equals(deal.getDescription())) || ("".equals(deal.getDescription()))) {
					saveParams.put("description", null);
				} else {
					saveParams.put("description", deal.getDescription());
				}
				
				if (("null".equals(deal.getDealType())) || ("".equals(deal.getDealType()))) {
					saveParams.put("deal_type", null);
				} else {
					saveParams.put("deal_type", deal.getDealType());
				}
				
				if (("null".equals(deal.getDealStatus())) || ("".equals(deal.getDealStatus()))) {
					saveParams.put("deal_status", null);
				} else {
					saveParams.put("deal_status", deal.getDealStatus());
				}
				
				saveParams.put("customer_id", deal.getCustomerId());
				
				if (("null".equals(deal.getStartDate())) || ("".equals(deal.getStartDate()))) {
					saveParams.put("start_date", null);
				} else {
					saveParams.put("start_date", deal.getStartDate());
				}
				
				if (("null".equals(deal.getEndDate())) || ("".equals(deal.getEndDate()))) {
					saveParams.put("end_date", null);
				} else {
					saveParams.put("end_date", deal.getEndDate());
				}
				
				
				saveParams.put("deal_ord_cust_required",deal.isDealOrdCustRequired());
				
				result = namedParameterJdbcTemplate.update(saveQuery.toString(), saveParams);
				}			
			
		catch (Exception e) {
			LOGGER.error(ERROR + e);
			
	}
		System.out.println(result);
		return result;
	
	}
	

	@Override
	public int saveDealOrderCodeDetails(GropDealModel groupModel) {
		Map<String, Object> saveParams = new LinkedHashMap<>();
		int status = 0;
		
		try {
			String saveQuery = " insert into deal_order_code(deal_id,order_code_id,deal_order_code_type,source_code_id) values (:deal_id,:order_code_id,:deal_order_code_type,:source_code_id)";

			Integer maxDealId = jdbcTemplate.queryForObject("select max(deal_id) from deal", Integer.class);
			
			System.out.println("maxID="+maxDealId);
			
			if (maxDealId == 0) {
				saveParams.put("deal_id", 1);
				
			} else {
				saveParams.put("deal_id", groupModel.getDealId());
				
			}
			saveParams.put("order_code_id", groupModel.getOrderCodeId());
			saveParams.put("deal_order_code_type", groupModel.getDealOrderCodeType());
			saveParams.put("source_code_id", groupModel.getSourceCodeId());
			status = namedParameterJdbcTemplate.update(saveQuery.toString(), saveParams);
		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	}

	@Override
	public int updateDeals(GropDealModel groupdeal) {
		Map<String, Object> updateParams = new LinkedHashMap<>();
		int status = 0;
		try {
			StringBuilder query = new StringBuilder(
					" update deal set deal=:deal,description=:description,"
							+ "deal_type=:deal_type,deal_status=:deal_status,start_date=:start_date,"
							+ "end_date=:end_date,deal_ord_cust_required=:deal_ord_cust_required "
							+ "where deal_id=" + groupdeal.getDealId() );
			updateParams.put("deal", groupdeal.getDeal());
			updateParams.put("description", groupdeal.getDescription());
			updateParams.put("deal_type",  groupdeal.getDealType());
			updateParams.put("deal_status", groupdeal.getDealStatus());
			updateParams.put("start_date", groupdeal.getStartDate());
			updateParams.put("end_date", groupdeal.getEndDate());
			updateParams.put("deal_ord_cust_required", groupdeal.isDealOrdCustRequired());
			status=namedParameterJdbcTemplate.update(query.toString(), updateParams);
			StringBuilder query1 = new StringBuilder(
					" update deal_order_code set deal_order_code_type=:deal_order_code_type where deal_id=" + groupdeal.getDealId());
			updateParams.put("deal_order_code_type", groupdeal.getDealOrderCodeType());
			status=namedParameterJdbcTemplate.update(query1.toString(), updateParams);
			StringBuilder query2 = new StringBuilder(
					" update deal_ordering_customer set deal_id=:deal_id,customer_id=:customer_id where deal_id=" + groupdeal.getDealId());
			updateParams.put("deal_id", groupdeal.getDealId());
			updateParams.put("customer_id", groupdeal.getgCustomerId());
			System.out.println("gcustomerId="+groupdeal.getgCustomerId());
			status=namedParameterJdbcTemplate.update(query2.toString(), updateParams);
			
			status++;
			
		}
		 catch (Exception e) {
				LOGGER.error(ERROR + e);
			}
		return status;
	}
 	
	@Override
	public int saveSubgroupStructure(int pcustomerId,int cCustomerId) {
			int status = 0;
			Map<String,Object> saveParams=new HashMap<>();
			
		try {
			String insert="insert into group_group(parent_group_customer_id,child_group_customer_id) values(:parent_group_customer_id,:child_group_customer_id)";
			saveParams.put("parent_group_customer_id", pcustomerId);
			saveParams.put("child_group_customer_id", cCustomerId);
			status=namedParameterJdbcTemplate.update(insert.toString(), saveParams);
			}
		
			catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	}

	@Override
	public int deleteStructures(int customerId) {
		StringBuilder returnStatus = new StringBuilder();
		int Status = 0;
		try {
			int parentId=jdbcTemplate.queryForObject("select parent_group_customer_id from group_group where child_group_customer_id="+customerId,Integer.class);
			String deleteCustomerGroup = "delete from group_group where parent_group_customer_id="+parentId+"and child_group_customer_id="+customerId;
			Status = jdbcTemplate.update(deleteCustomerGroup);
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			returnStatus.append(e);
		}
				
		return Status;
	}

	@Override
	public String getGroupGroupDescription(int gcustomerId) {
		String groupName=null;
		try {
			List<Map<String, Object>> Group = jdbcTemplate.queryForList(" select customer_group,description from customer_group where customer_id="+gcustomerId);
			 groupName=Group.get(0).get("customer_group").toString().concat("(").concat(Group.get(0).get("description").toString()).concat(")");
			}
		 catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return groupName;
	}

	@Override
	public List<DropdownModel> getGroupMemberNames(int gcustomerId) {
		List<Map<String, Object>> groupMember = new ArrayList<>();
		List<DropdownModel> names = new ArrayList<>();
		try {
				
			StringBuilder query = new StringBuilder(" select customer.fname,customer.lname from customer left join group_member on customer.customer_id=group_member.customer_id where group_member.customer_group_customer_id="+gcustomerId);
			groupMember = jdbcTemplate.queryForList(query.toString());
			for(Map<String, Object> memeber:groupMember) {
				DropdownModel model = new DropdownModel();
				model.setKey(memeber.get("fname").toString().concat(" ").concat(memeber.get("lname").toString()));
				names.add(model);
			}
								
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return names;
	}
 	
	@Override
	public List<Map<String, Object>> getDemoDetails(int customerId) {
		List<Map<String, Object>> demoDetails = new ArrayList<>();
		try {
			
    demoDetails = jdbcTemplate.queryForList("select df.from_date ,df.to_date,q.descr_q_default,q.global_question ,r.label_r_default,r.descr_r_default,dq.label_q,d.last_response_date     from dem_form df \r\n" + 
					"Inner JOIN dem_form_question dq ON dq.dem_form_id=df.dem_form_id INNER JOIN "
					+ " dem_question q on q.dem_question_id =dq.dem_question_id INNER JOIN  "
					+ "dem_response R on r.dem_question_id =q.dem_question_id INNER JOIN"
					+ " demographic d on d.dem_form_id =df.dem_form_id  and "
					+ "d.dem_question_id =q.dem_question_id  where d.customer_id ="+customerId);
					
    } catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return demoDetails;
	}
	
	@Override
	public List<DropdownModel> orderClassDetails() {
		List<DropdownModel>  orderClassList=new ArrayList<>();
		List<Map<String,Object>> orderClass=new ArrayList<>();
		
		try {
			 orderClass=jdbcTemplate.queryForList("select oc,oc_type,description,oc_id from oc");
			
			for(Map<String,Object> order: orderClass) {
				DropdownModel model=new DropdownModel();
				model.setKey(order.get("oc").toString());
				model.setDisplay(new PropertyUtilityClass().getConstantValue("oc_type_" +order.get("oc_type")));
				model.setDescription(order.get("description") != null ? (String) order.get("description") :"");
				model.setExtra(order.get("oc_id").toString());
				
				orderClassList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		
		return  orderClassList;
	}
	@Override
	public  List<DropdownModel> getDemographicForm1(int ocId) {
		List<DropdownModel>  DemographicFormList=new ArrayList<>();
		List<Map<String,Object>> demographic=new ArrayList<>();
		try {
			//demographic=jdbcTemplate.queryForList("select dem_form,description from dem_form");
			//select oc,dem_form,dm.description  from oc O  inner join dem_form dm on O.oc_id=dm.oc_id where oc='DAILY';
			demographic=jdbcTemplate.queryForList("select dem_form,dm.description  from oc O  inner join dem_form dm on O.oc_id=dm.oc_id where  O.oc_id="+ocId);
			for(Map<String,Object> dem: demographic) {
				DropdownModel model=new DropdownModel();
				model.setKey(dem.get("dem_form").toString());
				model.setDescription(dem.get("description") != null ? (String) dem.get("description") :"");
				DemographicFormList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return   DemographicFormList;
	}

	

	@Override
	public int saveDemoDetails(DemographicsModel demographicsModel) {
		int status = 0;
		try {

			Map<String, Object> addDemFormDetails = new LinkedHashMap<>();
			String addDemFormQuery = "insert into dem_form(dem_form_id,dem_form,description,oc_id,from_date,to_date)"
					+ "values(:dem_form_id,:dem_form,:description,:oc_id,:from_date,:to_date)";
			int MaxDemFormId = jdbcTemplate.queryForObject("select max(dem_form_id) from dem_form", Integer.class);
			MaxDemFormId = MaxDemFormId + 1;
			addDemFormDetails.put("dem_form_id", MaxDemFormId);
			addDemFormDetails.put("dem_form", demographicsModel.getDemForm());
			addDemFormDetails.put("description", demographicsModel.getDescription());
			addDemFormDetails.put("oc_id", demographicsModel.getOcId());
			//addDemFormDetails.put("from_date", demographicsModel.getFromDate());
			if(demographicsModel.getFromDate()!=null) {
			   addDemFormDetails.put("from_date",demographicsModel.getFromDate());
			}
			else {
			 addDemFormDetails.put("from_date", new Date());
		  }
			
		   // addDemFormDetails.put("to_date", demographicsModel.getToDate());
			
			if(demographicsModel.getToDate()!=null) {
				   addDemFormDetails.put("to_date",demographicsModel.getFromDate());
				}
				else {
				 addDemFormDetails.put("to_date", new Date());
			  }
			status = namedParameterJdbcTemplate.update(addDemFormQuery,addDemFormDetails);

			Map<String, Object> addDemQuestionDetails = new LinkedHashMap<>();
			String demQuestionQuery = "insert into  dem_question(dem_question_id,descr_q_default,global_question,mru_dem_response_seq)"
					+ "values(:dem_question_id,:descr_q_default,:global_question,:mru_dem_response_seq)";
			int MaxDemQuestionId = jdbcTemplate.queryForObject("select max(dem_question_id) from dem_question",
					Integer.class);
			MaxDemQuestionId = MaxDemQuestionId + 1;
			addDemQuestionDetails.put("dem_question_id", MaxDemQuestionId);
			LOGGER.info("demQuestionId:{}", MaxDemQuestionId);
			addDemQuestionDetails.put("descr_q_default", demographicsModel.getDescrQuesDefault());
			addDemQuestionDetails.put("global_question", demographicsModel.isGlobalQuestion());
			addDemQuestionDetails.put("mru_dem_response_seq", demographicsModel.getMruDemRespSeq());
			status = namedParameterJdbcTemplate.update(demQuestionQuery, addDemQuestionDetails);

			Map<String, Object> addDemRespDetails = new LinkedHashMap<>();
			String demRespQuery = "insert into  dem_response(dem_question_id,dem_response_seq,label_r_default,descr_r_default,free_form_input,qualified)"
					+ "values(:dem_question_id,:dem_response_seq,:label_r_default,:descr_r_default,:free_form_input,:qualified)";
			addDemRespDetails.put("dem_question_id", MaxDemQuestionId);
			LOGGER.info("demQuestionId:{}", MaxDemQuestionId);
			addDemRespDetails.put("dem_response_seq", demographicsModel.getDemRespSeq());
			addDemRespDetails.put("label_r_default", demographicsModel.getLabelResDefault());
			addDemRespDetails.put("descr_r_default", demographicsModel.getDescrRespDefault());
			addDemRespDetails.put("free_form_input", demographicsModel.getFreeFormInput());// need to be added if its come from front end
			addDemRespDetails.put("qualified", demographicsModel.getQualified());// need to be added if its come from front end
			status = namedParameterJdbcTemplate.update(demRespQuery, addDemRespDetails);

			Map<String, Object> addDemFormQuestionDetails = new LinkedHashMap<>();
			String addDemFormQuestionQuery = "insert into dem_form_question(dem_form_id,dem_form_question_seq,dem_question_id,label_q)"
					+ "values(:dem_form_id,:dem_form_question_seq,:dem_question_id,:label_q)";
			addDemFormQuestionDetails.put("dem_question_id", MaxDemQuestionId);
			addDemFormQuestionDetails.put("dem_form_id", MaxDemFormId);
			addDemFormQuestionDetails.put("dem_form_question_seq", demographicsModel.getDemFormQuestionSeq());
			addDemFormQuestionDetails.put("label_q", demographicsModel.getLabelq());
			status = namedParameterJdbcTemplate.update(addDemFormQuestionQuery, addDemFormQuestionDetails);
			
			Map<String, Object> addDemographicDetails = new LinkedHashMap<>();
			String addDemographicQuery = "insert into demographic(last_response_date)" 
			+ "values(:last_response_date)";
			addDemographicDetails.put("last_response_date",demographicsModel.getLastResponseDate());
			
			status = namedParameterJdbcTemplate.update(addDemographicQuery,addDemographicDetails);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;

		
	}

	

	@Override
	public int updateDemoDetails(DemographicsModel demographicsModel) {
		int status = 0;
        
		try {
			 Map<String, Object> updateDemFormDetails = new LinkedHashMap<>();
			 String updateDemFormQuery = "update dem_form set dem_form=:dem_form,description=:description,from_date=:from_date,to_date=:to_date where dem_form_id="
					+ demographicsModel.getDemFormId() + " and oc_id=" + demographicsModel.getOcId();
			updateDemFormDetails.put("dem_form", demographicsModel.getDemForm());
			updateDemFormDetails.put("description", demographicsModel.getDescription());
			//updateDemFormDetails.put("from_date", demographicsModel.getFromDate());
		
			if(demographicsModel.getFromDate()!=null) {
				updateDemFormDetails.put("from_date",demographicsModel.getFromDate());
				}
				else {
					updateDemFormDetails.put("from_date", new Date());
			  }
			//updateDemFormDetails.put("to_date", demographicsModel.getToDate());
			
			if(demographicsModel.getToDate()!=null) {
				updateDemFormDetails.put("to_date",demographicsModel.getFromDate());
				}
				else {
					updateDemFormDetails.put("to_date", new Date());
			  }
			status = namedParameterJdbcTemplate.update(updateDemFormQuery, updateDemFormDetails);

			Map<String, Object> updateDemQuestionDetails = new LinkedHashMap<>();
			String updateDemQuestionQuery = "update dem_question set  descr_q_default=:descr_q_default,global_question=:global_question,mru_dem_response_seq=:mru_dem_response_seq   where dem_question_id ="
					+ demographicsModel.getDemQuestionId();
			// updateDemQuestionDetails.put("dem_question_id",demographicsModel.getDemQuestionId());
			updateDemQuestionDetails.put("descr_q_default", demographicsModel.getDescrQuesDefault());
			updateDemQuestionDetails.put("global_question", demographicsModel.isGlobalQuestion());
			updateDemQuestionDetails.put("mru_dem_response_seq", demographicsModel.getMruDemRespSeq());
			status = namedParameterJdbcTemplate.update(updateDemQuestionQuery, updateDemQuestionDetails);

			Map<String, Object> updateDemRespDetails = new LinkedHashMap<>();
			String updateDemRespQuery = "update dem_response set label_r_default=:label_r_default,descr_r_default=:descr_r_default where dem_question_id="
					+ demographicsModel.getDemQuestionId() + " and  dem_response_seq="
					+ demographicsModel.getDemRespSeq();

			// updateDemRespDetails.put("dem_question_id",demographicsModel.getDemQuestionId());
			updateDemRespDetails.put("label_r_default", demographicsModel.getLabelResDefault());
			LOGGER.info("labelResDefault:{}", demographicsModel.getLabelResDefault());
			updateDemRespDetails.put("descr_r_default", demographicsModel.getDescrRespDefault());
			LOGGER.info("descrRespDefault:{}", demographicsModel.getDescrRespDefault());
			// updateDemRespDetails.put("dem_response_seq",demographicsModel.getDemRespSeq());
			status = namedParameterJdbcTemplate.update(updateDemRespQuery, updateDemRespDetails);

			Map<String, Object> updateDemFormQuestionDetails = new LinkedHashMap<>();
			String updateDemFormQuestionQuery = "update dem_form_question set label_q=:label_q where" + "dem_form_id="
					+ demographicsModel.getDemFormId() + " and dem_form_question_seq="
					+ demographicsModel.getDemFormQuestionSeq() + " and dem_question_id="
					+ demographicsModel.getDemQuestionId();
			updateDemFormQuestionDetails.put("label_q", demographicsModel.getLabelq());
			status = namedParameterJdbcTemplate.update(updateDemFormQuestionQuery, updateDemFormQuestionDetails);
			
			Map<String, Object> updateDemographicDetails = new LinkedHashMap<>();
			String  updateDemographicQuery = "update demographic set last_response_date=:last_response_date  where customer_id="+demographicsModel.getCustomerId()+" and demographic_seq="+demographicsModel.getDemographicSeq();
			updateDemFormQuestionDetails.put("last_response_date",demographicsModel.getLastResponseDate());
			status = namedParameterJdbcTemplate.update(updateDemographicQuery,updateDemographicDetails);
			
			

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteDemoDetails(DemographicsModel demographicsModel) {
		int status = 0;
		try {
            
			String deleteDemForm ="delete from dem_form where dem_form_id="+demographicsModel.getDemFormId();
			
			status = jdbcTemplate.update(deleteDemForm);
			String deleteDemQuestion = "delete from dem_question where dem_question_id= " +demographicsModel.getDemQuestionId();

			status = jdbcTemplate.update(deleteDemQuestion);
			String deleteDemResp="delete from dem_response where dem_question_id= " + demographicsModel.getDemQuestionId()+ " and dem_response_seq=" + demographicsModel.getDemRespSeq();
			
				
			status = jdbcTemplate.update(deleteDemResp);
			String deleteDemFormQuestion = "delete from dem_form_question where dem_question_id= " +demographicsModel.getDemQuestionId()+ " and dem_form_id=" +demographicsModel.getDemFormId() + " and dem_form_question_seq=" + demographicsModel.getDemFormQueSeq();
		    status = jdbcTemplate.update(deleteDemFormQuestion);
		
		    String deleteDemographic="delete from demographic where customer_id="+demographicsModel.getCustomerId()+" and demographic_seq="+demographicsModel.getDemographicSeq();
		    status = jdbcTemplate.update(deleteDemographic);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return status;

	}

	
	
	
	@Override
	public List<DropdownModel> getorderClassProspect() {
		LOGGER.info("Inside getorderClass");
		List<DropdownModel>  OrderClassProspect = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
			"select distinct oc.oc_id,oc,oc.description,oc.oc_type from oc oc left join order_code ord on ord.oc_id=oc.oc_id" 
                              +" AND  (active = 1 and ord.order_code_type != 3 and ord.order_code_type != 8 and premium != 2)  where not(oc_type=0) "
					          +" ORDER BY oc.description");
			//+" and oc.oc_id in(33,37,35,39,41,43,46,47,49,61,51,82,55,138,190,198,200,202,204,212,206,217,215,213,214,220,222,224,229) ORDER BY oc.oc");
								
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("oc").toString());
				model.setDisplay(row.get("oc").toString());
				model.setDescription(row.get("description")!=null?row.get("description").toString():null);
				model.setExtra(new PropertyUtilityClass().getConstantValue("oc_type_"+row.get("oc_type").toString()));
				model.setExtraData(row.get("oc_id").toString());
				OrderClassProspect.add(model);
			}
		} catch (Exception e) {
			LOGGER.info("Error:" + e);
		}
		return OrderClassProspect;
	}
	
	
	@Override
	public List<Integer> getAllSubgroups(int gcustomerId) {
		LOGGER.info("Inside getAllSubgroupDetails");
		List<String> childIds = new ArrayList<String>();
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		try {
			rows = jdbcTemplate.queryForList(
					";WITH security_menu_Recursive(parent_group_customer_id,child_group_customer_id)" + "AS  " + "(  "
							+ "    select parent_group_customer_id,child_group_customer_id from group_group  where  parent_group_customer_id ="
							+ gcustomerId + "    UNION ALL "
							+ "    select c.parent_group_customer_id,c.child_group_customer_id from group_group C with(nolock) "
							+ "    INNER JOIN security_menu_Recursive AS smr ON C.parent_group_customer_id  = smr.child_group_customer_id "
							+ " " + ") "
							+ "select child_group_customer_id from security_menu_Recursive");
			
			for (Map<String, Object> row : rows) {
				
			childIds.add(row.get("child_group_customer_id").toString());
		}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		List<Integer> childsId = new ArrayList<Integer>();

		for (int i = 0; i < childIds.size(); i++) {
			childsId.add(Integer.parseInt(childIds.get(i)));
		}
		return childsId;

	}

	@Override
	public int getDealId() {
		int dealId = 0;
		try {
			Integer maxId = jdbcTemplate.queryForObject("select max(deal_id) from deal", Integer.class);
			if(maxId == 0) {
				dealId = 0;
			}else {
				dealId = maxId;
			}
		}catch (Exception e) {
		}
			
		return dealId;
	}

	@Override
	public int saveDealOrderingCustomer(GropDealModel gropDealModel) {
		Map<String, Object> saveParams = new LinkedHashMap<>();
		int status = 0;
		try {
			String saveQuery = " insert into deal_ordering_customer(deal_id,customer_id) values (:deal_id,:customer_id)";

			Integer maxDealId = jdbcTemplate.queryForObject("select max(deal_id) from deal", Integer.class);
			if (maxDealId == 0) {
				saveParams.put("deal_id", 1);
			} else {
				saveParams.put("deal_id", gropDealModel.getDealId());
			}
						saveParams.put("customer_id", gropDealModel.getgCustomerId());
						status=namedParameterJdbcTemplate.update(saveQuery.toString(), saveParams);
			
		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	
	}

	@Override
	public List<Map<String, Object>> getDealOrderingCustomer(int dealId) {
		List<Map<String, Object>> dealorderinCustomerDetails = new ArrayList<>();

		try {
			StringBuilder query = new StringBuilder(
					"select deal_id,customer_id from deal_ordering_customer where deal_id="+dealId);
			dealorderinCustomerDetails = jdbcTemplate.queryForList(query.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return dealorderinCustomerDetails;
	}
	
	
	@Override
	public List<Map<String, Object>> getGrpMbrActOrdHandling(int customerId){
		List<Map<String , Object>> grpMbrActOrdHandling = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(" select customer_id,orderhdr_id,order_item_seq,oa.oc_id,oc,oa.order_code_id,order_code,bundle_qty,cast(gross_base_amount as int) as gross_base_amount,((cast(gross_base_amount as int)/bundle_qty)*(bundle_qty+1)) as amount, (bundle_qty+1) as issue from order_item oa left join oc on oc.oc_id=oa.oc_id left join order_code on order_code.order_code_id=oa.order_code_id where order_status in (0,5,7,8,9,10,11,12,13) and group_order = 1 and customer_id ="+customerId);
			grpMbrActOrdHandling = jdbcTemplate.queryForList(query.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return grpMbrActOrdHandling;
	}

	
	@Override
	public int saveGrpMbrOrdHandling(TransferOrderModel transferOrderModel) {
		Map<String, Object> saveParams = new LinkedHashMap<>();
		int status = 0;
		try {
			
			StringBuilder grpMbrItemDtl = new StringBuilder("insert into grp_mbr_item_dtl (orderhdr_id,order_item_seq,grp_mbr_item_dtl_seq,customer_group_customer_id,customer_id,n_copies) values (:orderhdr_id,:order_item_seq,:grp_mbr_item_dtl_seq,:customer_group_customer_id,:customer_id,:n_copies)");
			saveParams.put("orderhdr_id", transferOrderModel.getOrderhdrId());
			saveParams.put("order_item_seq", transferOrderModel.getOrderItemSeq());
			String grpMbrItemDtlSeq = jdbcTemplate.queryForObject("select max(grp_mbr_item_dtl_seq) from grp_mbr_item_dtl where orderhdr_id="+transferOrderModel.getOrderhdrId()+" and order_item_seq="+transferOrderModel.getOrderItemSeq(), String.class);
			if (grpMbrItemDtlSeq == null) {
				saveParams.put("grp_mbr_item_dtl_seq", 1);
			} else {
				saveParams.put("grp_mbr_item_dtl_seq", Integer.parseInt(grpMbrItemDtlSeq) + 1);
			}
			saveParams.put("customer_group_customer_id", transferOrderModel.getCustomerGroupCustomerId());
			saveParams.put("customer_id", transferOrderModel.getCustomerId());
			saveParams.put("n_copies", transferOrderModel.getnCopies());
			namedParameterJdbcTemplate.update(grpMbrItemDtl.toString(), saveParams);
			saveParams.clear();
			
			StringBuilder addDel = new StringBuilder("insert into additions_deletions (subscrip_id,additions_deletions_seq,orderhdr_id,order_item_seq,issue_id,customer_id,n_addition_copies,n_deletion_copies,sub_add,sub_add_reason,sub_kill,sub_on,sub_on_reason,sub_off,sub_start,sub_start_reason,sub_stop,add_kill_status,creation_date,bundle_qty,start_stop_status) values (:subscrip_id,:additions_deletions_seq,:orderhdr_id,:order_item_seq,:issue_id,:customer_id,:n_addition_copies,:n_deletion_copies,:sub_add,:sub_add_reason,:sub_kill,:sub_on,:sub_on_reason,:sub_off,:sub_start,:sub_start_reason,:sub_stop,:add_kill_status,:creation_date,:bundle_qty,:start_stop_status)");
			String subscripId = jdbcTemplate.queryForObject("select subscrip_id from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+" and order_item_seq="+transferOrderModel.getOrderItemSeq(), String.class);
			saveParams.put("subscrip_id", subscripId);
			String addDelSeq = jdbcTemplate.queryForObject("select max(additions_deletions_seq) from additions_deletions where subscrip_id="+subscripId, String.class);
			if (addDelSeq == null) {
				saveParams.put("additions_deletions_seq", 1);
			} else {
				saveParams.put("additions_deletions_seq", Integer.parseInt(addDelSeq) + 1);
			}
			saveParams.put("orderhdr_id", transferOrderModel.getOrderhdrId());
			saveParams.put("order_item_seq", transferOrderModel.getOrderItemSeq());
			String issueId = jdbcTemplate.queryForObject("select start_issue_id from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+" and order_item_seq="+transferOrderModel.getOrderItemSeq(), String.class);
			saveParams.put("issue_id", issueId);
			saveParams.put("customer_id", transferOrderModel.getCustomerGroupCustomerId());
			saveParams.put("n_addition_copies", transferOrderModel.getBndlQty());
			saveParams.put("n_deletion_copies", 0);
			saveParams.put("sub_add", 1);
			saveParams.put("sub_add_reason", 3);
			saveParams.put("sub_kill", 0);
			saveParams.put("sub_on", 1);
			saveParams.put("sub_on_reason", 3);
			saveParams.put("sub_off", 0);
			saveParams.put("sub_start", 1);
			saveParams.put("sub_start_reason", 3);
			saveParams.put("sub_stop", 0);
			saveParams.put("add_kill_status", 0);
			saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			saveParams.put("bundle_qty", transferOrderModel.getBndlQty());
			saveParams.put("start_stop_status", 0);
			namedParameterJdbcTemplate.update(addDel.toString(), saveParams);
			saveParams.clear();
			
			Long dateStamp = customerUtility.getmaxDateStamp();
			StringBuilder journal = new StringBuilder("insert into journal (journal_id,date_stamp,orderhdr_id,order_item_seq,posting_reference,tax_amount,net_amount,del_amount,com_amount,debit_account,qty_debit_account,credit_account,qty_credit_account,qty,bndl_qty) values (:journal_id,:date_stamp,:orderhdr_id,:order_item_seq,:posting_reference,:tax_amount,:net_amount,:del_amount,:com_amount,:debit_account,:qty_debit_account,:credit_account,:qty_credit_account,:qty,:bndl_qty)");
		   /* String journalId = jdbcTemplate.queryForObject("select max(journal_id) from journal", String.class);
			
		    if (journalId == null) {
				saveParams.put("journal_id", 1);
			} else {
				saveParams.put("journal_id", Integer.parseInt(journalId) + 1);
			}*/
		    
		    long journalId = customerUtility.getMaxJournalId() + 1;
		    jdbcTemplate.update("set nocount on if not exists (select 1 from information_schema.tables where table_name = 'mru_journal_id') begin create"
		    								+ "  table mru_journal_id (id int) insert mru_journal_id (id) values (1) end else update mru_journal_id with (TABLOCKX)"
		    								+ "  set id =" + journalId);
		    saveParams.put("journal_id",journalId);
			saveParams.put("date_stamp", dateStamp);
			saveParams.put("orderhdr_id", transferOrderModel.getOrderhdrId());
			saveParams.put("order_item_seq", transferOrderModel.getOrderItemSeq());
			saveParams.put("posting_reference", 3);
			String tax = jdbcTemplate.queryForObject("select cast(total_tax_local_amount as int) as tax from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+" and order_item_seq="+transferOrderModel.getOrderItemSeq(), String.class);
			saveParams.put("tax_amount", tax);
			String net = jdbcTemplate.queryForObject("select (cast(gross_base_amount as int)/bundle_qty) as amount from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+" and order_item_seq="+transferOrderModel.getOrderItemSeq(), String.class);
			saveParams.put("net_amount", net);
			saveParams.put("del_amount", 0);
			saveParams.put("com_amount", 0);
			saveParams.put("debit_account", 1);
			saveParams.put("qty_debit_account", 1);
			saveParams.put("credit_account", 3);
			saveParams.put("qty_credit_account", 2);
			int qty = jdbcTemplate.queryForObject("select order_qty from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+" and order_item_seq="+transferOrderModel.getOrderItemSeq(), Integer.class);
			saveParams.put("qty", qty);
			saveParams.put("bndl_qty", 1);
			namedParameterJdbcTemplate.update(journal.toString(), saveParams);
			customerUtility.updateJournalId(journalId);
			saveParams.clear();
			
			StringBuilder subscrip = new StringBuilder("update subscrip set mru_additions_deletions_seq=:mru_additions_deletions_seq where subscrip_id=:subscrip_id");
			saveParams.put("mru_additions_deletions_seq", Integer.parseInt(addDelSeq) + 1);
			saveParams.put("subscrip_id", subscripId);
			namedParameterJdbcTemplate.update(subscrip.toString(), saveParams);
			saveParams.clear();
			
			StringBuilder orderItem = new StringBuilder("update order_item set gross_base_amount=:gross_base_amount,gross_local_amount=:gross_local_amount,net_base_amount=:net_base_amount,net_local_amount=:net_local_amount,bundle_qty=:bundle_qty,mru_grp_mbr_item_dtl_seq=:mru_grp_mbr_item_dtl_seq where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq");
			saveParams.put("orderhdr_id", transferOrderModel.getOrderhdrId());
			saveParams.put("order_item_seq", transferOrderModel.getOrderItemSeq());
			saveParams.put("gross_base_amount", transferOrderModel.getGrossBaseAmount());
			saveParams.put("gross_local_amount", transferOrderModel.getGrossBaseAmount());
			saveParams.put("net_base_amount", transferOrderModel.getGrossBaseAmount());
			saveParams.put("net_local_amount", transferOrderModel.getGrossBaseAmount());
			saveParams.put("bundle_qty", transferOrderModel.getBndlQty());
			saveParams.put("mru_grp_mbr_item_dtl_seq", Integer.parseInt(grpMbrItemDtlSeq) + 1);
			namedParameterJdbcTemplate.update(orderItem.toString(), saveParams);
			saveParams.clear();
			
			StringBuilder orderItemAmtBreak = new StringBuilder("update order_item_amt_break set local_amount=:local_amount,base_amount=:base_amount where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq and order_item_amt_break_seq=1");
			saveParams.put("orderhdr_id", transferOrderModel.getOrderhdrId());
			saveParams.put("order_item_seq", transferOrderModel.getOrderItemSeq());
			saveParams.put("base_amount", transferOrderModel.getGrossBaseAmount());
			saveParams.put("local_amount", transferOrderModel.getGrossBaseAmount());
			namedParameterJdbcTemplate.update(orderItemAmtBreak.toString(), saveParams);
			saveParams.clear();
			
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			StringBuilder editTrail = new StringBuilder("insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name) values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
			saveParams.put("edit_trail_id", editTrailId);
			saveParams.put("customer_id", transferOrderModel.getCustomerGroupCustomerId());
			saveParams.put("customer_address_seq", transferOrderModel.getCustomerAddressSeq());
			String userCode = jdbcTemplate.queryForObject("select user_code from customer where customer_id="+transferOrderModel.getCustomerId(), String.class);
			saveParams.put("user_code", userCode);
			saveParams.put("subscrip_id", subscripId);
			saveParams.put("orderhdr_id", transferOrderModel.getOrderhdrId());
			saveParams.put("order_item_seq", transferOrderModel.getOrderItemSeq());
			saveParams.put("edited", 1);
			String currency = jdbcTemplate.queryForObject("select currency from order_item where orderhdr_id="+transferOrderModel.getOrderhdrId()+" and order_item_seq="+transferOrderModel.getOrderItemSeq(), String.class);
			saveParams.put("currency", currency);
			saveParams.put("table_enum", 3);
			saveParams.put("document_reference_id", 1);
			saveParams.put("local_amount", transferOrderModel.getGrossBaseAmount());
			saveParams.put("base_amount", transferOrderModel.getGrossBaseAmount());
			saveParams.put("date_stamp", dateStamp+1);
			saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			saveParams.put("xaction_name", "customer_edit_request");
			namedParameterJdbcTemplate.update(editTrail.toString(), saveParams);
			customerUtility.updateMruEditTrailId(editTrailId);
			saveParams.clear();
			editTrailId = customerUtility.getmaxeditTrailId() + 1;
			StringBuilder editTrail2 = new StringBuilder("insert into edit_trail (edit_trail_id,user_code,orderhdr_id,order_item_seq,order_item_amt_break_seq,edited,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name) values (:edit_trail_id,:user_code,:orderhdr_id,:order_item_seq,:order_item_amt_break_seq,:edited,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
			saveParams.put("edit_trail_id", editTrailId);
			saveParams.put("user_code", userCode);
			saveParams.put("orderhdr_id", transferOrderModel.getOrderhdrId());
			saveParams.put("order_item_seq", transferOrderModel.getOrderItemSeq());
			saveParams.put("order_item_amt_break_seq", 1);
			saveParams.put("edited", 1);
			saveParams.put("table_enum", 6);
			saveParams.put("document_reference_id", 1);
			saveParams.put("local_amount", transferOrderModel.getGrossBaseAmount());
			saveParams.put("base_amount", transferOrderModel.getGrossBaseAmount());
			saveParams.put("date_stamp", dateStamp+1);
			saveParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			saveParams.put("xaction_name", "customer_edit_request");
			namedParameterJdbcTemplate.update(editTrail2.toString(), saveParams);
			customerUtility.updateMruEditTrailId(editTrailId);
			saveParams.clear();
			
			status++;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	
	@Override
	public List<DemographicChildModel> getDemographicChildList() {
		String  demographicQuery= "select dq.dem_question_id,descr_q_default,last_response_date,dem.oc_id  from dem_question dq inner join "
		+ "demographic dem on dq.dem_question_id=dem.dem_question_id";
		
		//String  demographicQuery= "select O.oc,O.description ,q.descr_q_default, dem.last_response_date,dem.oc_id  from  dem_question q  inner join demographic dem on q.dem_question_id =dem.dem_question_id "
	 //+ "Inner JOIN OC O on O.oc_id =dem.oc_id";
	  return jdbcTemplate.query(demographicQuery,new ResultSetExtractor<List<DemographicChildModel>>()
	     {
			@Override
			public List<DemographicChildModel> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<DemographicChildModel> demographicList=new ArrayList<DemographicChildModel>();
				while(rs.next())
				{
					DemographicChildModel demographicChildModel=new DemographicChildModel();
					demographicChildModel.setRootname(getRootName(rs.getInt("oc_id")));
					demographicChildModel.setDemQuestionId(rs.getInt("dem_question_id"));
					demographicChildModel.setDate(rs.getString("last_response_date"));
				    demographicChildModel.setDescQDefault(rs.getString("descr_q_default"));
				    demographicChildModel.setData(getDemographicList(rs.getInt("dem_question_id")));
				    demographicList.add(demographicChildModel);
				}
			  return  demographicList;
			}
		});
	}

private  DemoModel getDemographicList(int demQuesId) {
		LOGGER.info("Inside demographics");
		String demographicsQuery= "select label_r_default,descr_r_default from dem_response where dem_question_id="+demQuesId;
	  return  jdbcTemplate.query(demographicsQuery,new ResultSetExtractor<DemoModel>()
		{
			@Override
			public DemoModel extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				DemoModel demographic =new DemoModel();
				if(rs.next())
				{
					demographic.setDescrRDefault(rs.getString("descr_r_default"));
					demographic.setLabelrDefault(rs.getInt("label_r_default"));
			}
				 return  demographic;
			}
		});
	    
	}

private String  getRootName(int ocId)
{
	String Query="select description from oc where oc_id="+ocId;
			
	String  desc= jdbcTemplate.queryForObject(Query,String.class);

   return desc;

}

@Override
public List<DropdownModel> getDemResponse(int demQuesId) {
	
	List<DropdownModel>  demResponseList=new ArrayList<>();
	List<Map<String,Object>>  demResponse=new ArrayList<>();
	try {
		demResponse=jdbcTemplate.queryForList("select  descr_q_default,label_r_default,descr_r_default from dem_response dr inner join dem_question dq on   dr.dem_question_id=dq.dem_question_id where dr.dem_question_id="+demQuesId);
		for(Map<String,Object>  demResp: demResponse) {
			DropdownModel model=new DropdownModel();
			model.setKey(demResp.get("label_r_default").toString());
			model.setDisplay(demResp.get("descr_r_default").toString());
			model.setDescription(demResp.get("descr_q_default").toString());
			
		
			demResponseList.add(model);
		}
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
 return   demResponseList;
}

@Override
public List<Map<String, Object>> addDemResponse(int ocId) {
	List<Map<String, Object>> addDemRespDetails = new ArrayList<>();
	try {
		
		addDemRespDetails= jdbcTemplate.queryForList("select distinct dq.dem_question_id,descr_q_default,oc_id from dem_question dq inner join demographic d on d.dem_question_id=dq.dem_question_id where oc_id="+ocId);
				
} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  addDemRespDetails;
}

@Override
public List<Map<String, Object>> getgroupDetails(int dealId) {
	List<Map<String, Object>> groupDetails = new ArrayList<>();
	try {
		
		groupDetails= jdbcTemplate.queryForList("select deal_ordering_customer.deal_id,customer_group.customer_id,customer_group.customer_group,customer_group.description from customer_group "
				+ "inner join deal_ordering_customer on deal_ordering_customer.customer_id=customer_group.customer_id where deal_ordering_customer.deal_id="+dealId);
				
} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return  groupDetails;
}


@Override
public List<Map<String, Object>> getGroupOrder(int customerId) {
	List<Map<String, Object>> group = new ArrayList<>();
	try {
		String query="select isNull(customer_id,'') as customer_id from customer_group where customer_id="+customerId;	
		group = jdbcTemplate.queryForList(query.toString());
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	
	return group;
}
	
@Override
public List<Map<String, Object>> getActiveOC(int customerId, int ocId) {
	List<Map<String, Object>> activeOC = new ArrayList<>();
	try {
		String query="select distinct oc_id from order_item where oc_id="+ocId+" and customer_id="+customerId+" and order_status in (0,5,7,8,9,10,11,12,13)";	
		activeOC = jdbcTemplate.queryForList(query.toString());
	}catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	
	return activeOC;
}


@Override
public String getAddrStatus(int customerId) {
	String addressStatus = null;
	try {
		addressStatus = jdbcTemplate.queryForObject(
				"SELECT count(*) FROM customer_address WHERE customer_id="+customerId+" and address_status= 'UNDEL'", String.class);
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
	return addressStatus;
}

}
 



 	



