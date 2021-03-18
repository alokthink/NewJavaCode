package com.mps.think.daoImpl;
import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mps.think.dao.CustomerOrderDao;
import com.mps.think.model.*;
import com.mps.think.option.model.EditTrail;
import com.mps.think.resultMapper.*;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.PropertyUtilityClass;
import com.mps.think.wsdl.OrderAddWsdl;
import java.time.temporal.ChronoUnit;

import Think.XmlWebServices.Order_add_response;
import Think.XmlWebServices.Order_code_for_price_list;
import Think.XmlWebServices.Package_edit_response;


@Repository
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerOrderDaoImpl.class);
	private SimpleDateFormat formatYYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	OrderAddWsdl orderAddWsdl;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private CustomerUtility customerUtility;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	OrderSourceOfferDaoImpl orderSourceOfferDaoImpl;
	@Override
	public List<CustomerOrderModel> getCustomerOrder(Long customerId,String inActive, String paid, String controlled, String complimentary, String orderType, String billToCustNotOwner,String pkg,String limitToOc) {
		List<CustomerOrderModel> customerOrderList=null;
		try {
			StringBuilder customerOrderQuery = new StringBuilder();	
					
			customerOrderQuery.append("SELECT  cast(gross_local_amount as NUMERIC(18,2))as gross_local_amount,cast(gross_base_amount as NUMERIC(18,2)) as gross_base_amount,order_code.no_charge,"  
					+ " cast(net_local_amount  as NUMERIC(18,2))as net_local_amount ,cast(net_base_amount  as NUMERIC(18,2))as net_base_amount, "
					+ "cast(((gross_local_amount-total_tax_local_amount)-isnull(((agency.new_commission/100)*(gross_local_amount-total_tax_local_amount)),0)) as NUMERIC(18,2)) as localAmount,"
					+ "cast(((gross_base_amount-total_tax_base_amount)-isnull(((agency.new_commission/100)*(gross_base_amount-total_tax_base_amount)),0))as NUMERIC(18,2))  as baseAmount," 
					+ "order_item.*,oc.oc as order_class,order_code.order_code,order_code.order_code_type,agency_code,"
					+ "(select enumeration from issue where issue.issue_id=order_item.start_issue_id)as startIssueId," 
					+ "(select enumeration from issue where issue.issue_id=order_item.stop_issue_id)as stopIssueId ,"
					+ " (SELECT CONVERT(varchar,A.issue_date,101) from view_issue_volume A INNER JOIN (SELECT ROW_NUMBER() OVER(ORDER BY oc_id) AS 'RN', *   FROM view_issue_volume) B   "
					+ " ON A.issue_id= B.issue_id AND B.RN=(SELECT RowNumer+1 FROM(SELECT ROW_NUMBER () OVER (ORDER BY oc_id) RowNumer,issue_id,oc_id FROM view_issue_volume ) qry1 WHERE issue_id =(select top 1 stop_issue_id from order_item where subscrip_id=order_item.subscrip_id order by orderhdr_id desc)  and oc_id=order_item.oc_id)  and  A.oc_id=order_item.oc_id) as renew_start_date	," 
					+ " (SELECT CONVERT(varchar,A.issue_date,101) from view_issue_volume A INNER JOIN (SELECT ROW_NUMBER() OVER(ORDER BY oc_id) AS 'RN', *  FROM view_issue_volume) B  ON A.issue_id= B.issue_id AND  "
					+ " B.RN=(SELECT RowNumer+ order_item.n_issues_left FROM(SELECT ROW_NUMBER () OVER (ORDER BY oc_id) RowNumer,issue_id,oc_id FROM view_issue_volume ) qry1 WHERE issue_id =(select top 1 stop_issue_id from order_item where subscrip_id=order_item.subscrip_id order by orderhdr_id desc)  and oc_id=order_item.oc_id)  and  A.oc_id=order_item.oc_id) as renew_expire_date ,"
					+ " order_code.start_type as start_type, (case when ((order_code.start_type=0 or order_code.start_type=1) and order_code.order_code_type=0) then 'Issue Based Subscription' when ((order_code.start_type=0 or order_code.start_type=1) and order_code.order_code_type=1) then 'Single Copy' when order_code.order_code_type=4 then 'Package Edit'  when order_code.order_code_type=2 then 'Product' when ((order_code.start_type=4 or order_code.start_type=5) and order_code.order_code_type=0) then 'Unit Based Subscription' else 'Date Based Subscription' end) as pageName ,"
					+ " oin.install_auto_payment,oin.cancel_dd,subscription_def_id,(select upsell_on from oc where oc_id = (select parent_oc_id from oc where oc_id = order_item.oc_id)) as upsell_on,audited,pub.qp,pub.qf,pub.nqp,pub.nqf,order_item.inventory_id "
					+ " FROM order_item order_item"
					+ " left join order_code order_code on order_item.order_code_id=order_code.order_code_id"
					+ " left join oc oc on order_item.oc_id=oc.oc_id"
					+ " left join pub on order_item.oc_id=pub.oc_id"
					+ " left join agency on order_item.agency_customer_id=agency.customer_id"
					+ " left join order_item_install oin on oin.orderhdr_id=order_item.orderhdr_id and oin.order_item_seq=order_item.order_item_seq "
					+ " WHERE ");
			if(!"0".equals(billToCustNotOwner))
				customerOrderQuery.append(" bill_to_customer_id ="+customerId+" and bill_to_customer_id != order_item.customer_id");
			else
				customerOrderQuery.append(" order_item.customer_id = "+customerId+"");
			if(pkg!=null) {
				if(!inActive.equals("0")) {	
					 customerOrderQuery.append(" and pkg_item_seq is not null");}
						
				else {
				
					customerOrderQuery.append(" and pkg_item_seq is not null and (order_status in (0,5,7,8,9,10,11,12,13,15,16,17) or( order_status in (6) and payment_status not in (1,2,3,4) and "
						+ " gross_base_amount > 0.0 ))");			
				}
			}else if(!inActive.equals("0")) {	
				 customerOrderQuery.append(" and pkg_item_seq is null");}
					
			else {
			
				customerOrderQuery.append(" and pkg_item_seq is null and (order_status in (0,5,7,8,9,10,11,12,13,15,16,17) or( order_status in (6) and payment_status not in (1,2,3,4) and "
					+ " gross_base_amount > 0.0 ))");			
			}
			 
			if((!paid.equals("0")) && ((!controlled.equals("0")) || (!complimentary.equals("0")))) {
				
			customerOrderQuery.append(" and ((is_complimentary = 0 and subscrip_start_type != 2)");		
			}else if(!paid.equals("0")){
				customerOrderQuery.append(" and ((is_complimentary = 0 and subscrip_start_type != 2))");	
			}
			
			if(!controlled.equals("0")) 
				if((!paid.equals("0")) && (!complimentary.equals("0"))) {
				customerOrderQuery.append(" or subscrip_start_type = 2 ");	
			}else if((!controlled.equals("0")) && (!complimentary.equals("0"))) {
				customerOrderQuery.append(" or (subscrip_start_type = 2 ");	
			}else if(!paid.equals("0")){
				customerOrderQuery.append(" or subscrip_start_type = 2 )");	
			}else {
				customerOrderQuery.append(" and (subscrip_start_type = 2)");
			}
			
			if(!complimentary.equals("0")) 
			   if (!controlled.equals("0") || (!paid.equals("0"))){
				customerOrderQuery.append(" or is_complimentary = 1)");	
			}else if(orderType.equals("0") || (orderType.equals("-1"))){
				customerOrderQuery.append(" and (is_complimentary = 1)");
			}
			
			if(!limitToOc.equals("0")) {
				
			customerOrderQuery.append(" and (order_item.oc_id = '"+limitToOc+"') ");		
			}
			
			if(orderType.equals("-1")) 
				customerOrderQuery.append(" ORDER BY order_date desc");	
			else if(orderType.equals("0"))
				customerOrderQuery.append(" and (order_item_type in("+orderType+") or order_item_type in(4,5,6))  ORDER BY order_date desc");
			else
			customerOrderQuery.append(" and order_item_type in("+orderType+")  ORDER BY order_date desc");
			
			customerOrderList=jdbcTemplate.query(customerOrderQuery.toString(), new CustomerOrderMapper());
			
		} catch (Exception e) {
			LOGGER.info("customerOrderList" + e);
		}

		return customerOrderList;
	}

	@Override
	public List<OrderItem> getOrderinProgressData(int orderCodeType, String orderCode, String sourceCode) {
		List<OrderItem> orderList=new ArrayList<>();		
		try{
			StringBuilder orderQuery = new StringBuilder();			
			if(orderCodeType==2){
				orderQuery.append("select top 1 odr.order_code_id,odr.oc_id,odr.order_code_type,odr.order_code,o.oc,odr.qty,p.price,odr.newsub_rate_class_id,r.default_price_per_issue from product p left join order_code odr on odr.order_code_id=p.order_code_id left join oc o on o.oc_id=odr.oc_id left join rate_class_effective r on r.rate_class_id=odr.newsub_rate_class_id where p.order_code_id="+orderCode);				
				orderList=jdbcTemplate.query(orderQuery.toString(), new OrderItemMapper());	
				
			}else if(orderCodeType==0){				
				orderQuery.append("select top 1 oc.oc, order_code.order_code_id, order_code.oc_id, order_code.order_code_type, "
						+ " order_code.order_code, order_code.newsub_rate_class_id, order_code.term_id, term.n_issues, "
						+ " term.number_volume_sets as qty, rate_class_effective.default_price_per_issue, rate_class_effective.default_price_per_issue as price from order_code order_code "
						+ " left join term term on order_code.term_id = term.term_id "
						+ " left join rate_class_effective rate_class_effective on order_code.newsub_rate_class_id = rate_class_effective.rate_class_id "
						+ " left join oc oc on order_code.oc_id = oc.oc_id where order_code.order_code_id= "+orderCode+" order by rate_class_effective.effective_date desc");
				
				orderList=jdbcTemplate.query(orderQuery.toString(), new OrderItemMapper());
			}
		}catch (Exception e) {
			LOGGER.info("orderList" + e);
		}
		return orderList;
	}

	@Override
	public boolean saveOrder(OrderItem orderItem) {
		boolean status = false;
		try{			
			String orderSaveQuery = "select count(*) from order_item where order_code_id = ? and source_code_id = ? and customer_id = ?";
			int count=jdbcTemplate.queryForObject(orderSaveQuery,new Object[] { orderItem.getOrderCodeID(),orderItem.getSourceCodeID(),orderItem.getCustomerId() }, Integer.class);
			
			if(count==0){
							
				String effectiveSeqQuery = "select top 1 rate_class_effective_seq from rate_class_effective where rate_class_id=(select newsub_rate_class_id from order_code where order_code_id=" + orderItem.getOrderCodeID()+") order by effective_date desc";
				
				String customerAddressQuery = "select c.customer_id,s.state,cur.currency,cur.exchange_rate from customer_address c "
											+ " left join state s on c.state=s.state left join currency cur on cur.currency=s.currency where customer_id=" + orderItem.getCustomerId();
								
				long orderHdrId = jdbcTemplate.queryForObject("select max(orderhdr_id) from orderhdr", Long.class);	
				long effectiveSeq = jdbcTemplate.queryForObject(effectiveSeqQuery, Long.class);
				
				List<Map<String, Object>> orderCodesList  = jdbcTemplate.queryForList("select ord.* from order_code ord where ord.order_code_id = " + orderItem.getOrderCodeID());			
				
				List<Map<String, Object>> customerQueryList  = jdbcTemplate.queryForList("select * from customer where customer_id = " + orderItem.getCustomerId());
				List<Map<String, Object>> customerAddressQueryList  = jdbcTemplate.queryForList(customerAddressQuery);	
				
				/* Set data in class model from List */
				CustomerDetails customerDetails=getCustomerDetails(customerQueryList);
				CustomerAddressModel addressModel=getAddressCustomerDetails(customerAddressQueryList);
				
				/* Data Save in particular table. */
				this.orderHdrSave(orderHdrId,1);
				
				if(orderItem.getOrderCodeType()=="2"){
					List<Map<String, Object>> productQueryList  = jdbcTemplate.queryForList("select * from product where order_code_id = " + orderItem.getOrderCodeID());
					Product product=getProductDetails(productQueryList);
					this.orderItemSave(orderHdrId, orderItem, orderCodesList, customerDetails, addressModel, product, effectiveSeq);
					
				}					
				if(orderItem.getOrderCodeType()=="0"){
					this.subscrip(orderItem);
					this.orderItemSaveSubscrip(orderHdrId, orderItem, orderCodesList, customerDetails, addressModel, effectiveSeq);
				}
				
				
				this.journalSave(orderHdrId, orderItem);
				
				/* Data save into "order_item_account" table */
				this.orderItemAccountSave(orderHdrId);	
				
				/* Data save into "order_item_acc_break" table */
				this.orderItemAccBreakSave(orderHdrId);
				
				/* Data save into "order_item_amt_break" table */
				//need to correct it further
				//this.orderItemBreakSave(orderHdrId,orderItem.getCustomerId(),orderItemAmtBreak);				
				
				/* Data save into "addition_deletions" table */
				if(orderItem.getOrderCodeType()=="0"){
					this.additionsDeletionsSave(orderHdrId,orderItem);
				}
				
				/* Data save into "edit_trail" table */
				this.editTrailSave1(orderHdrId, orderItem);				
				this.editTrailSave2(orderHdrId, orderItem);				
				
				/* Data save into "event_queue" table */
				this.eventQueueSave(orderHdrId, orderItem);
								
				status=true;
			}
			
		}catch(Exception e){
			LOGGER.error(ERROR +e);
		}
		return status;
	}
	
	
	public OrderCode getOrderCode(List<Map<String, Object>> orderCodeList){
		
		OrderCode orderCode=new OrderCode();
		for(Map<String, Object> map:orderCodeList){
			orderCode.setOrderCode(map.get("user_code").toString());
			orderCode.setOrderCodeType(map.get("order_code_type").toString());
			
			LOGGER.info(""+orderCode);
		}
		return orderCode;
	}
	
	public CustomerAddressModel getAddressCustomerDetails(List<Map<String, Object>> customerAddressQueryList){
		CustomerAddressModel addressModel=new CustomerAddressModel();
		try{
		for(Map<String, Object> map:customerAddressQueryList){
			addressModel.setCurrency(map.get("currency").toString());
			addressModel.setExchangeRate(map.get("exchange_rate").toString());
		}
	}catch(Exception e){
		LOGGER.info("getAddressCustomerDetails : "+e);
	}
		return addressModel;
	}
	
	public CustomerDetails getCustomerDetails(List<Map<String, Object>> customerDeatilsList){
		CustomerDetails customerDetails=new CustomerDetails();
		try{
		for(Map<String, Object> customerDetailsMap:customerDeatilsList){			
			customerDetails.setDefaultBillToCustomerId(customerDetailsMap.get("default_bill_to_customer_id").toString());
			customerDetails.setDefaultRenewToCustomerId(customerDetailsMap.get("default_renew_to_customer_id").toString());
			customerDetails.setDefBillToCustAddrSeq(customerDetailsMap.get("def_bill_to_cust_addr_seq").toString());
			customerDetails.setDefRenewToCustAddrSeq(customerDetailsMap.get("def_renew_to_cust_addr_seq").toString());			
		}
	}catch(Exception e){
		LOGGER.info("getCustomerDetails : "+e);
	}
		return customerDetails;
	}
	
	public Product getProductDetails(List<Map<String, Object>> productList){
		Product product=new Product();
		try{		
		for(Map<String, Object> productDetailsMap:productList){
			product.setProductId(Integer.parseInt(productDetailsMap.get("product_id").toString()));
			
			product.setInventoryId((productDetailsMap.get("inventory_id").toString().isEmpty())?"":productDetailsMap.get("inventory_id").toString());
			
		}
		}catch(Exception e){
			LOGGER.info("getProductDetails : "+e);
		}
		LOGGER.info("product : "+product);
		return product;
	}
	
	public void orderHdrSave(long orderHdrId, int mruOrderItemSeq){
		try{			
			String orderHdrQuery="insert into orderhdr (orderhdr_id,order_date,mru_order_item_seq) values (:orderhdr_id, GETDATE(), :mru_order_item_seq)";	
			
			Map<String, Object> parameters = new HashMap<String,Object>();
			parameters.put("orderhdr_id", (orderHdrId));
			parameters.put("mru_order_item_seq", mruOrderItemSeq);	
			
			LOGGER.info("**************Save in Orderhdr Table.**********************");
			LOGGER.info("Query : "+orderHdrQuery);
			LOGGER.info("Parameter : "+parameters);
			
			namedParameterJdbcTemplate.update(orderHdrQuery, parameters);
			
		}catch(Exception e){
			LOGGER.info("orderHdrSave : "+e);
		}		
	}
	
	public void orderItemSave(long orderHdrId,OrderItem orderItem,List<Map<String, Object>> orderCodesList,CustomerDetails customerDetails,CustomerAddressModel addressModel,Product product,long effectiveSeq){
		try{
			String orderItemQuery="insert into order_item (orderhdr_id,order_item_seq,user_code,currency,source_code_id,date_stamp,"
					  +" order_item_type,order_date,order_qty,gross_base_amount,gross_local_amount,net_base_amount,net_local_amount,"
					  +" has_tax,has_delivery_charge,bill_date,payment_status,refund_status,order_type,billing_type,has_premium,"
					  +" prepayment_req,product_id,bundle_qty,is_complimentary,subscrip_start_type,order_code_id,duration,renewal_status,"
					  +" delivery_method_perm,change_qty_flag,n_remaining_paid_issues,ext_iss_left,ext_iss_tot,order_status,renewal_category,"
					  +" exchange_rate,rate_class_id,rate_class_effective_seq,inventory_id,oc_id,auto_payment,perpetual_order,"
					  +" bill_to_customer_id,bill_to_customer_address_seq,renew_to_customer_id,renew_to_customer_address_seq,customer_id,"
					  +" customer_address_seq,note_exist,service_exist,mru_order_item_amt_break_seq,has_been_renewed,revenue_method,"
					  +" trial_type,orig_order_qty,unit_excess,is_proforma,n_tax_updates,total_tax_local_amount,total_tax_base_amount,"
					  +" electronic_delivery,time_unit_options,group_order,invoice_date,auto_renew_notify_sent,extended_days,"
					  +" asynchronous_auto_renew,n_days_graced,is_back_ordered,mru_grp_mbr_item_dtl_seq) values ("									  
					  +" :orderhdr_id, :order_item_seq, :user_code, :currency, :source_code_id, :date_stamp,"
					  +" :order_item_type, GETDATE(), :order_qty, :gross_base_amount, :gross_local_amount, :net_base_amount, :net_local_amount,"
					  +" :has_tax, :has_delivery_charge, GETDATE(), :payment_status, :refund_status, :order_type, :billing_type, :has_premium,"
					  +" :prepayment_req, :product_id, :bundle_qty, :is_complimentary, :subscrip_start_type, :order_code_id, :duration, :renewal_status,"
					  +" :delivery_method_perm, :change_qty_flag, :n_remaining_paid_issues, :ext_iss_left, :ext_iss_tot, :order_status, :renewal_category,"
					  +" :exchange_rate, :rate_class_id, :rate_class_effective_seq, :inventory_id, :oc_id, :auto_payment, :perpetual_order,"
					  +" :bill_to_customer_id, :bill_to_customer_address_seq, :renew_to_customer_id, :renew_to_customer_address_seq, :customer_id,"
					  +" :customer_address_seq, :note_exist, :service_exist, :mru_order_item_amt_break_seq, :has_been_renewed, :revenue_method,"
					  +" :trial_type, :orig_order_qty, :unit_excess, :is_proforma, :n_tax_updates, :total_tax_local_amount, :total_tax_base_amount,"
					  +" :electronic_delivery, :time_unit_options, :group_order, GETDATE(), :auto_renew_notify_sent, :extended_days,"
					  +" :asynchronous_auto_renew, :n_days_graced, :is_back_ordered, :mru_grp_mbr_item_dtl_seq )" ;
			
			Map<String, Object> orderItemParameters = new HashMap<String,Object>();
			for(Map<String, Object> orderCodeList:orderCodesList)
			{	
				orderItemParameters.put("orderhdr_id", (orderHdrId+1));
				orderItemParameters.put("order_item_seq", 1);
				orderItemParameters.put("user_code", orderCodeList.get("user_code"));
				orderItemParameters.put("currency", addressModel.getCurrency());
				orderItemParameters.put("source_code_id", orderItem.getSourceCodeID());
				orderItemParameters.put("date_stamp", 1);
				orderItemParameters.put("order_item_type", orderCodeList.get("order_code_type"));
				orderItemParameters.put("order_qty",orderCodeList.get("qty"));
				orderItemParameters.put("gross_base_amount",orderItem.getAmountCharged());
				orderItemParameters.put("gross_local_amount", orderItem.getAmountCharged());
				orderItemParameters.put("net_base_amount", orderItem.getAmountCharged());
				orderItemParameters.put("net_local_amount", orderItem.getAmountCharged());
				orderItemParameters.put("has_tax",0);
				orderItemParameters.put("has_delivery_charge", 0);
				orderItemParameters.put("payment_status", 0);
				orderItemParameters.put("refund_status",0);
				orderItemParameters.put("order_type",3);
				orderItemParameters.put("billing_type",1);// 1- balance due
				orderItemParameters.put("has_premium", orderCodeList.get("premium"));
				orderItemParameters.put("prepayment_req", orderCodeList.get("prepayment_req"));
				orderItemParameters.put("product_id",product.getProductId());
				orderItemParameters.put("bundle_qty",1);
				orderItemParameters.put("is_complimentary",0);
				orderItemParameters.put("subscrip_start_type",0);
				orderItemParameters.put("order_code_id", orderCodeList.get("order_code_id"));
				orderItemParameters.put("duration",0);
				orderItemParameters.put("renewal_status",0);
				orderItemParameters.put("delivery_method_perm",0);
				orderItemParameters.put("change_qty_flag",0);
				orderItemParameters.put("n_remaining_paid_issues",0);
				orderItemParameters.put("ext_iss_left",0);
				orderItemParameters.put("ext_iss_tot",0);
				orderItemParameters.put("order_status",0);
				orderItemParameters.put("renewal_category",0);
				orderItemParameters.put("exchange_rate",addressModel.getExchangeRate());
				orderItemParameters.put("rate_class_id", orderCodeList.get("newsub_rate_class_id"));
				orderItemParameters.put("rate_class_effective_seq",effectiveSeq);
				//orderItemParameters.put("inventory_id",product.getInventoryId());
				orderItemParameters.put("inventory_id",null);
				orderItemParameters.put("oc_id", orderCodeList.get("oc_id"));
				orderItemParameters.put("auto_payment", orderCodeList.get("auto_payment"));
				orderItemParameters.put("perpetual_order", orderCodeList.get("perpetual_order"));
				orderItemParameters.put("bill_to_customer_id", customerDetails.getDefaultBillToCustomerId());
				orderItemParameters.put("bill_to_customer_address_seq", customerDetails.getDefBillToCustAddrSeq());
				orderItemParameters.put("renew_to_customer_id", customerDetails.getDefaultRenewToCustomerId());
				orderItemParameters.put("renew_to_customer_address_seq", customerDetails.getDefRenewToCustAddrSeq());
				orderItemParameters.put("customer_id", orderItem.getCustomerId());
				orderItemParameters.put("customer_address_seq", 1);
				orderItemParameters.put("note_exist",0);
				orderItemParameters.put("service_exist",0);
				orderItemParameters.put("mru_order_item_amt_break_seq",1);
				orderItemParameters.put("has_been_renewed",0);
				orderItemParameters.put("revenue_method", orderCodeList.get("revenue_method"));
				orderItemParameters.put("trial_type", orderCodeList.get("trial_type"));
				orderItemParameters.put("orig_order_qty",orderCodeList.get("qty"));
				orderItemParameters.put("unit_excess", orderCodeList.get("unit_excess"));
				orderItemParameters.put("is_proforma", orderCodeList.get("is_proforma"));
				orderItemParameters.put("n_tax_updates",0);
				orderItemParameters.put("total_tax_local_amount","0.0000");
				orderItemParameters.put("total_tax_base_amount","0.0000");
				orderItemParameters.put("electronic_delivery", orderCodeList.get("electronic_delivery"));
				orderItemParameters.put("time_unit_options", orderCodeList.get("time_unit_options"));
				orderItemParameters.put("group_order",0);
				/*orderItemParameters.put("invoice_date",);*/
				orderItemParameters.put("auto_renew_notify_sent",0);
				orderItemParameters.put("extended_days",0);
				orderItemParameters.put("asynchronous_auto_renew",0);
				orderItemParameters.put("n_days_graced",0);
				orderItemParameters.put("is_back_ordered",0);
				orderItemParameters.put("mru_grp_mbr_item_dtl_seq",0);
			}
			
			namedParameterJdbcTemplate.update(orderItemQuery, orderItemParameters);

		}catch(Exception e){
			LOGGER.info("orderItemSave : "+e);
		}		
	}
	
	public void orderItemAccountSave(long orderHdrId){
		try{
			String orderItemAccountQuery = "insert into order_item_account (orderhdr_id,order_item_seq,deferred_qty,earned_qty,no_more_liability,no_more_ar,recon_upd) values "
					  + " (:orderhdr_id, :order_item_seq, :deferred_qty, :earned_qty, :no_more_liability, :no_more_ar, :recon_upd)";
			Map<String, Object> itemAccountParameters = new HashMap<String,Object>();
			itemAccountParameters.put("orderhdr_id", (orderHdrId+1));
			itemAccountParameters.put("order_item_seq", 1);
			itemAccountParameters.put("deferred_qty", 0);
			itemAccountParameters.put("earned_qty", 0);
			itemAccountParameters.put("no_more_liability", 0);
			itemAccountParameters.put("no_more_ar", 0);
			itemAccountParameters.put("recon_upd", 0);				
			
			namedParameterJdbcTemplate.update(orderItemAccountQuery, itemAccountParameters);
		}catch(Exception e){
			LOGGER.info("orderHdrSave : "+e);
		}
	}
	
	public void journalSave(long orderHdrId, OrderItem orderItem){
		try{
			
			String journalQuery = "insert into journal (journal_id,date_stamp,orderhdr_id,order_item_seq,posting_reference,tax_amount,net_amount,del_amount,com_amount,debit_account,qty_debit_account,credit_account,qty_credit_account,qty,bndl_qty) values "
					   + " (:journal_id, :date_stamp, :orderhdr_id, :order_item_seq, :posting_reference, :tax_amount, :net_amount, :del_amount, :com_amount, :debit_account, :qty_debit_account, :credit_account, :qty_credit_account, :qty, :bndl_qty)";
			
			long journalId = customerUtility.getMaxJournalId() + 1;
			jdbcTemplate.update("set nocount on if not exists (select 1 from information_schema.tables where table_name = 'mru_journal_id') begin create"
											+ "  table mru_journal_id (id int) insert mru_journal_id (id) values (1) end else update mru_journal_id with (TABLOCKX)"
											+ "  set id =" + journalId);
			
			 Map<String, Object> journalParameters = new HashMap<String,Object>();
			journalParameters.put("journal_id",journalId);
			journalParameters.put("date_stamp", 1);
			journalParameters.put("orderhdr_id", (orderHdrId+1));
			journalParameters.put("order_item_seq", 1);
			journalParameters.put("posting_reference", 1); // 1 - Order Add
			journalParameters.put("tax_amount", 0.0000);
			journalParameters.put("net_amount", orderItem.getAmountCharged());
			journalParameters.put("del_amount", 0.0000);
			journalParameters.put("com_amount", 0.0000);
			journalParameters.put("debit_account", 1);
			journalParameters.put("qty_debit_account", 1);
			journalParameters.put("credit_account", 3);
			journalParameters.put("qty_credit_account", 2);
			journalParameters.put("qty", orderItem.getOrderQty());
			journalParameters.put("bndl_qty", orderItem.getBundleQty());
			namedParameterJdbcTemplate.update(journalQuery, journalParameters);
		    customerUtility.updateJournalId(journalId);
		}catch(Exception e){
			LOGGER.info("orderHdrSave : "+e);
		}
	}
	
	public void orderItemAccBreakSave(long orderHdrId){
		try{
			String orderItemAccBreakQuery = "insert into order_item_acc_break (orderhdr_id,order_item_seq,acc_break_type,ar,cash,liability,revenue) values "
					 + " (:orderhdr_id, :order_item_seq, :acc_break_type, :ar, :cash, :liability, :revenue)";
			for(int i=0;i<4;i++){
				Map<String, Object> itemAccBreakParameters = new HashMap<String,Object>();
				itemAccBreakParameters.put("orderhdr_id", (orderHdrId+1) );
				itemAccBreakParameters.put("order_item_seq", 1);
				itemAccBreakParameters.put("acc_break_type", i);
				itemAccBreakParameters.put("ar", 0);
				itemAccBreakParameters.put("cash", 0);
				itemAccBreakParameters.put("liability", 0);
				itemAccBreakParameters.put("revenue", 0);
				namedParameterJdbcTemplate.update(orderItemAccBreakQuery, itemAccBreakParameters);
			}
			
		}catch(Exception e){
			LOGGER.info("orderHdrSave : "+e);
		}
	}
	
	public void editTrailSave1(long orderHdrId, OrderItem orderItem){
		try{
			String editTrailQuery1 = " insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name) values "
					+ " (:edit_trail_id, :customer_id, :customer_address_seq, :user_code, :orderhdr_id, :order_item_seq, :edited, :currency, :table_enum, :document_reference_id, :local_amount, :base_amount, :date_stamp, GETDATE(), :xaction_name)";

			Map<String, Object> editTrailParameters_1 = new HashMap<String,Object>();
			Long maxEditTrailId = customerUtility.getmaxeditTrailId() + 1;
			editTrailParameters_1.put("edit_trail_id",maxEditTrailId);
			editTrailParameters_1.put("customer_id", orderItem.getCustomerId());
			editTrailParameters_1.put("customer_address_seq", 1);
			editTrailParameters_1.put("user_code", "THK");
			editTrailParameters_1.put("orderhdr_id", (orderHdrId+1));
			editTrailParameters_1.put("order_item_seq", 1);
			editTrailParameters_1.put("edited", 0);
			editTrailParameters_1.put("currency", orderItem.getCurrency());
			editTrailParameters_1.put("table_enum", 3);
			editTrailParameters_1.put("document_reference_id", 1);
			editTrailParameters_1.put("local_amount", orderItem.getAmountCharged());
			editTrailParameters_1.put("base_amount", orderItem.getAmountCharged());
			editTrailParameters_1.put("date_stamp", 1);				
			editTrailParameters_1.put("xaction_name", "order_add_request");
			
			namedParameterJdbcTemplate.update(editTrailQuery1, editTrailParameters_1);
			customerUtility.updateMruEditTrailId(maxEditTrailId);
		}catch(Exception e){
			LOGGER.info("orderHdrSave : "+e);
		}
	}
	
	public void editTrailSave2(long orderHdrId, OrderItem orderItem){
		try{
			String editTrailQuery2 = "insert into edit_trail (edit_trail_id,user_code,orderhdr_id,order_item_seq,order_item_amt_break_seq,edited,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name) values "
					+" (:edit_trail_id, :user_code, :orderhdr_id, :order_item_seq, :order_item_amt_break_seq, :edited, :table_enum, :document_reference_id, :local_amount, :base_amount, :date_stamp, GETDATE(), :xaction_name)";
			Map<String, Object> editTrailParameters_2 = new HashMap<String,Object>();
			//editTrailParameters_2.put("edit_trail_id", (jdbcTemplate.queryForObject("select max(edit_trail_id) from edit_trail", Long.class))+1);				
			Long maxEditTrailId = customerUtility.getmaxeditTrailId() + 1;
			editTrailParameters_2.put("edit_trail_id",maxEditTrailId);
			editTrailParameters_2.put("user_code", "THK");
			editTrailParameters_2.put("orderhdr_id", (orderHdrId+1));
			editTrailParameters_2.put("order_item_seq", 1);
			editTrailParameters_2.put("order_item_amt_break_seq", 1);
			editTrailParameters_2.put("edited", 0);				
			editTrailParameters_2.put("table_enum", 6);
			editTrailParameters_2.put("document_reference_id", 1);
			editTrailParameters_2.put("local_amount", orderItem.getAmountCharged());
			editTrailParameters_2.put("base_amount", orderItem.getAmountCharged());
			editTrailParameters_2.put("date_stamp", 1);				
			editTrailParameters_2.put("xaction_name", "order_add_request");
			
			namedParameterJdbcTemplate.update(editTrailQuery2, editTrailParameters_2);	
			customerUtility.updateMruEditTrailId(maxEditTrailId);
		}catch(Exception e){
			LOGGER.info("orderHdrSave : "+e);
		}
	}
	
	public void eventQueueSave(long orderHdrId, OrderItem orderItem){
		try{
			String eventQueueQuery="insert into event_queue (event_queue_id,orderhdr_id,order_item_seq,customer_id,customer_address_seq,oc_id,transaction_event,status,creation_date) values "
					+" (:event_queue_id, :orderhdr_id, :order_item_seq, :customer_id, :customer_address_seq, :oc_id, :transaction_event, :status, GETDATE())";

			Map<String, Object> eventQueueParameters = new HashMap<String,Object>();
			
			Long maxEventQueueId = customerUtility.getMaxEventQueueId() + 1;
			eventQueueParameters.put("event_queue_id", maxEventQueueId);
			eventQueueParameters.put("orderhdr_id", (orderHdrId+1));
			eventQueueParameters.put("order_item_seq", 1);
			eventQueueParameters.put("customer_id", orderItem.getCustomerId());
			eventQueueParameters.put("customer_address_seq", 1);
			eventQueueParameters.put("oc_id", orderItem.getOcId());
			eventQueueParameters.put("transaction_event", 0);
			eventQueueParameters.put("status", 0);
			namedParameterJdbcTemplate.update(eventQueueQuery, eventQueueParameters);	
			customerUtility.updateEventQueueId(maxEventQueueId);
		}catch(Exception e){
			LOGGER.info("orderHdrSave : "+e);
		}
	}

	@Override
	public List<OrderItem> customerOrderPackageEdit(long orderhdrId,int orderItemType,int orderCodeId,long customerId, int orderItemSeq,Integer showInactive) {		
		List<Map<String, Object>> altCustomerAddress=null;
		List<Map<String, Object>> billToCustomerAddress=null;
		List<Map<String, Object>> orderItemList = null;
		List<OrderItem> OrderItemLists = new ArrayList<>();
		try{
			StringBuilder editQuery=new StringBuilder();
			editQuery.append("select distinct 0 as required,revenue_percent,oc.commodity_code,cadrs.special_tax_id,s.subscription_def,rc.description,sc.subscription_category_id,s.media,s.edition,sc.description as subscriptionCategoryDescription,t.description as termDescription,cadrs.fname,cadrs.lname, cadrs.address1,cadrs.address2,cadrs.address3,oc.order_code,oc.description as orderCodeDes," + 
					" oc.start_type as start_type, (case when ((oc.start_type=0 or oc.start_type=1) and oc.order_code_type=0) then 'Issue Based Subscription' when ((oc.start_type=0 or oc.start_type=1) and oc.order_code_type=1) then 'Single Copy' when oc.order_code_type=4 then 'Package Edit'  when oc.order_code_type=2 then 'Product' else 'Date Based Subscription' end) as pageName,src.source_code,src.description as sourceCodeDes," + 
					" (isnull((agency.new_commission),0)) as new_commission , (isnull((agency.ren_commission),0)) as ren_commission, " + 
					" cast(((oi.gross_local_amount-oi.total_tax_local_amount)-isnull(((agency.new_commission/100)*(oi.gross_local_amount-oi.total_tax_local_amount)),0)) as NUMERIC(18,2)) as localAmount," + 
					" cast(((oi.gross_base_amount-oi.total_tax_base_amount)-isnull(((agency.new_commission/100)*(oi.gross_base_amount-oi.total_tax_base_amount)),0))as NUMERIC(18,2))  as baseAmount," + 
					" cast(((oi.gross_local_amount-oi.total_tax_local_amount)-isnull(((agency.ren_commission/100)*(oi.gross_local_amount-oi.total_tax_local_amount)),0)) as NUMERIC(18,2)) as renlocalAmount," + 
					" cast(((oi.gross_base_amount-oi.total_tax_base_amount)-isnull(((agency.ren_commission/100)*(oi.gross_base_amount-oi.total_tax_base_amount)),0))as NUMERIC(18,2))  as renbaseAmount, " + 
					" cast((isnull(((agency.new_commission/100)*(oi.gross_local_amount-oi.total_tax_local_amount)),0))as decimal(10,2))  as localCommission ," + 
					" cast((isnull(((agency.new_commission/100)*(oi.gross_base_amount-oi.total_tax_base_amount)),0))as decimal(10,2))  as baseCommission , " + 
					" cast((isnull(((agency.ren_commission/100)*(oi.gross_local_amount-oi.total_tax_local_amount)),0))as decimal(10,2))  as renlocalCommission ," + 
					" cast((isnull(((agency.ren_commission/100)*(oi.gross_base_amount-oi.total_tax_base_amount)),0))as decimal(10,2))  as renbaseCommission , " + 
					" oi.manual_disc_amt_local,oi.manual_disc_amt_base,oi.manual_disc_percentage,oi.order_code_id,oi.source_code_id,oi.*,(rate_class_effective.description +' - '+ CONVERT(varchar,rate_class_effective.effective_date,101)) as rateClassDescription,rate_class_effective.effective_date,orderhdr.po_number,agency.customer_id as agency_customer_id ,agency.agency_code,agency.company," + 
					" enumeration,issue_date,CONVERT(varchar,(DATEADD(DAY, 1,expire_date)),101) as subscription_start_date,CONVERT(varchar,(DATEADD(YEAR, 1,expire_date)),101) as subscription_end_date, (select CONVERT(varchar,issue_date,101) from view_issue_volume where issue_id=oi.stop_issue_id+1) as renew_start_date, (select CONVERT(varchar,issue_date,101) from view_issue_volume where issue_id=oi.stop_issue_id+n_issues_left) as renew_expire_date  " + 
					" from order_item oi" + 
					" left join order_code oc on oc.order_code_id=oi.order_code_id" + 
					" left join source_code src on src.source_code_id=oi.source_code_id " + 
					" left join customer_address cadrs on (cadrs.customer_id=oi.customer_id and cadrs.customer_address_seq = oi.customer_address_seq)" + 
					" left join subscription_def s on s.subscription_def_id = oi.subscription_def_id" + 
					" left join subscription_category sc on sc.subscription_category_id = s.subscription_category_id" + 
					" left join term t on t.term_id = s.term_id" + 
					" left join rate_class_effective rate_class_effective on rate_class_effective.rate_class_id = oi.rate_class_id and rate_class_effective.rate_class_effective_seq = oi.rate_class_effective_seq " + 
					" left join orderhdr on orderhdr.orderhdr_id=oi.orderhdr_id" + 
					" left join agency on agency.customer_id=oi.agency_customer_id" + 
					" left join view_issue_volume vi on vi.issue_id=oi.start_issue_id" + 
					" left join pkg_def_content on pkg_def_content.order_code_id=oi.order_code_id " +
					" left join rate_class rc on rc.rate_class_id=oi.rate_class_id" +
					" where oi.orderhdr_id = "+orderhdrId+" and oi.pkg_item_seq="+orderItemSeq+" ");
			        //and pkg_def_content.order_code_id="+orderCodeId+"");
			if(showInactive ==null || showInactive==0) {
				editQuery.append("and oi.order_status not in (1,2,3,4) order by oi.order_item_seq ");
			}else {
				editQuery.append(" order by oi.order_item_seq ");
			}	
			orderItemList = jdbcTemplate.queryForList(editQuery.toString());
						
			for(Map<String, Object> orderItemMap:orderItemList){	
				OrderItem orderItem=new OrderItem();
				orderItem.setPageName(orderItemMap.get("pageName").toString());
				orderItem.setSubscripId(orderItemMap.get("subscrip_id")!=null?orderItemMap.get("subscrip_id").toString():null);
				orderItem.setStartType(Integer.parseInt(orderItemMap.get("start_type").toString()));
				orderItem.setOrderhdrId(Long.parseLong(orderItemMap.get("orderhdr_id").toString()));				
				orderItem.setOrderItemSeq(Integer.parseInt(orderItemMap.get("order_item_seq").toString()));				
				orderItem.setUserCode(orderItemMap.get("user_code").toString());	
				orderItem.setDateStamp(Integer.parseInt(orderItemMap.get("date_stamp").toString()));				
				orderItem.setOrderItemType(Integer.parseInt(orderItemMap.get("order_item_type").toString()));	
			    Date parseDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(orderItemMap.get("order_date").toString());
				DateFormat formater = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");				 	
				orderItem.setOrderDate(formater.format(parseDate));
				orderItem.setLocalAmount((orderItemMap.get("localAmount").toString()));				
				orderItem.setBaseAmount((orderItemMap.get("baseAmount").toString()));
				orderItem.setGrossBaseAmount(orderItemMap.get("gross_base_amount").toString());				
				orderItem.setGrossLocalAmount(orderItemMap.get("gross_local_amount").toString());				
				orderItem.setNetBaseAmount(orderItemMap.get("net_base_amount").toString());				
				orderItem.setNetLocalAmount(orderItemMap.get("net_local_amount").toString());				
				
				/*long tax = getTaxRate(customerId,orderCodeId);			
				orderItem.setTaxRateAmount(tax);*/
				orderItem.setTaxRateAmount(getPackageTaxRate(customerId,(orderItemMap.get("commodity_code")!=null?orderItemMap.get("commodity_code").toString():"")));
				orderItem.setRevenue_percent(Double.parseDouble((orderItemMap.get("revenue_percent")!=null?orderItemMap.get("revenue_percent").toString():"0")));	
				orderItem.setHasDeliveryCharge(Integer.parseInt(orderItemMap.get("has_delivery_charge").toString()));				
				orderItem.setBillDate(new PropertyUtilityClass().getDateFormatter((orderItemMap.get("bill_date").toString())));				
				orderItem.setPaymentStatus(Integer.parseInt(orderItemMap.get("payment_status").toString()));				
				orderItem.setPayment_status(new PropertyUtilityClass().getConstantValue("order_item.pay_status_"+orderItemMap.get("payment_status").toString()));
				orderItem.setRefundStatus(Integer.parseInt(orderItemMap.get("refund_status").toString()));
				orderItem.setOrderType(Integer.parseInt(orderItemMap.get("order_type").toString()));
				orderItem.setHasPremium(Integer.parseInt(orderItemMap.get("has_premium").toString()));
				orderItem.setPrepaymentReq(Integer.parseInt(orderItemMap.get("prepayment_req").toString()));
				orderItem.setNumberVolumeSets(orderItemMap.get("number_volume_sets")!=null?orderItemMap.get("number_volume_sets").toString():" ");
				
				orderItem.setIsComplimentary(Integer.parseInt(orderItemMap.get("is_complimentary").toString()));
				orderItem.setSubscripStartType(Integer.parseInt(orderItemMap.get("subscrip_start_type").toString()));
				orderItem.setDuration(Integer.parseInt(orderItemMap.get("duration").toString()));				
				orderItem.setRenewalStatus(Integer.parseInt(orderItemMap.get("renewal_status").toString()));
				orderItem.setDeliveryMethodPerm(Integer.parseInt(orderItemMap.get("delivery_method_perm").toString()));
				orderItem.setChangeQtyFlag(Integer.parseInt(orderItemMap.get("change_qty_flag").toString()));
				orderItem.setnRemainingPaidIssue(Integer.parseInt((orderItemMap.get("n_remaining_paid_issues")!=null?orderItemMap.get("n_remaining_paid_issues").toString():"0")));
				orderItem.setExtIssleft(Integer.parseInt((orderItemMap.get("ext_iss_left")!=null?orderItemMap.get("ext_iss_left").toString():"0")));
				orderItem.setExtIssTot(Integer.parseInt((orderItemMap.get("ext_iss_tot")!=null?orderItemMap.get("ext_iss_tot").toString():"0")));
				orderItem.setOrderStatus(Integer.parseInt(orderItemMap.get("order_status").toString()));
				orderItem.setOrder_status(new PropertyUtilityClass().getConstantValue("order_item.order_status_"+orderItemMap.get("order_status").toString()));
				
				orderItem.setRenewalCategory(Integer.parseInt(orderItemMap.get("renewal_category").toString()));				
				orderItem.setExchangeRate(orderItemMap.get("exchange_rate").toString());
				
				orderItem.setSubscriptionDefId(orderItemMap.get("subscription_def_id")!=null?orderItemMap.get("subscription_def_id").toString():"0");
				orderItem.setStartDate(new PropertyUtilityClass().getDateFormatter((orderItemMap.get("start_date").toString())));
				if(orderItemMap.get("renew_to_customer_id")!=null){
						List<Map<String, Object>> renewCustomerAddress=jdbcTemplate.queryForList("select (case when customer_address.fname is null then customer_address.company else customer_address.fname + ' ' + customer_address.lname end )as name , concat(customer_address.address1,' ',customer_address.address2,' ' ,customer_address.address3) as address from customer_address where customer_id="+orderItemMap.get("renew_to_customer_id")+" and customer_address_seq="+orderItemMap.get("renew_to_customer_address_seq"));
						for(Map<String,Object> map:renewCustomerAddress){
							orderItem.setRenewFullNameTo(map.get("name")!=null?(String)map.get("name"):null);
							orderItem.setRenewToCustomerAddress(map.get("address")!=null?(String)map.get("address"):null);
						}					
					}								
				
					List<Map<String, Object>> subscripDef=jdbcTemplate.queryForList("select * from view_pkg_def where order_code_id="+orderCodeId+" and pkg_def_id="+orderItemMap.get("pkg_def_id")+"");
					for(Map<String,Object> map:subscripDef) {
						orderItem.setSubscriptionDef(map.get("pkg_def")!=null?(String)map.get("pkg_def"):null);
						orderItem.setSubscriptionDefDescription(map.get("description")!=null?(String)map.get("description"):null);
				}
				
				orderItem.setExpireDate(new PropertyUtilityClass().getDateFormatter(orderItemMap.get("expire_date").toString()));				     
				orderItem.setnNonPaidIssues(Integer.parseInt(orderItemMap.get("n_nonpaid_issues")!=null?orderItemMap.get("n_nonpaid_issues").toString():"0"));
				orderItem.setnRemainingNonPaidIssues(Integer.parseInt(orderItemMap.get("n_remaining_nonpaid_issues")!=null?orderItemMap.get("n_remaining_nonpaid_issues").toString():"0"));				
				orderItem.setRateClassId(Integer.parseInt(orderItemMap.get("rate_class_id")!=null?orderItemMap.get("rate_class_id").toString():"0"));
				orderItem.setRateClassEffectiveSeq(Integer.parseInt(orderItemMap.get("rate_class_effective_seq")!=null?orderItemMap.get("rate_class_effective_seq").toString():"0"));								
				orderItem.setInventoryId((orderItemMap.get("inventory_id")!=null? orderItemMap.get("inventory_id").toString():" "));				
				orderItem.setOcId(Integer.parseInt(orderItemMap.get("oc_id").toString()));				
				orderItem.setAutoPayment(Integer.parseInt(orderItemMap.get("auto_payment").toString()));
				orderItem.setPerpetualOrder(Integer.parseInt(orderItemMap.get("perpetual_order").toString()));
				orderItem.setBillToCustomerId(Integer.parseInt(orderItemMap.get("bill_to_customer_id").toString()));
				orderItem.setBillToCustomerAddressSeq(Integer.parseInt(orderItemMap.get("bill_to_customer_address_seq").toString()));
				orderItem.setRenewToCustomerId(Integer.parseInt(orderItemMap.get("renew_to_customer_id").toString()));
				orderItem.setRenewToCustomerAddressSeq(Integer.parseInt(orderItemMap.get("renew_to_customer_address_seq").toString()));
				orderItem.setCustomerId(Integer.parseInt(orderItemMap.get("customer_id")!=null?orderItemMap.get("customer_id").toString():"0"));
				orderItem.setCustomerAddressSeq(Integer.parseInt(orderItemMap.get("customer_address_seq").toString()));
				orderItem.setAltShipCustomerId(Integer.parseInt(orderItemMap.get("alt_ship_customer_id")!=null?orderItemMap.get("alt_ship_customer_id").toString():"0"));
				orderItem.setAltShipCustomerAddressSeq(Integer.parseInt(orderItemMap.get("alt_ship_customer_address_seq")!=null?orderItemMap.get("alt_ship_customer_address_seq").toString():"0"));
				orderItem.setStartIssueId(orderItemMap.get("start_issue_id")!=null?orderItemMap.get("start_issue_id").toString():"0");
				orderItem.setStopIssueId(Integer.parseInt(orderItemMap.get("stop_issue_id")!=null?orderItemMap.get("stop_issue_id").toString():"0"));
				orderItem.setNoteExist(Integer.parseInt(orderItemMap.get("note_exist").toString()));
				orderItem.setServiceExist(Integer.parseInt(orderItemMap.get("service_exist").toString()));
				orderItem.setMruOrderItemAmtBreakSeq(Integer.parseInt(orderItemMap.get("mru_order_item_amt_break_seq").toString()));
				orderItem.setHasBeenRenewed(Integer.parseInt(orderItemMap.get("has_been_renewed").toString()));
				orderItem.setRevenueMethod(Integer.parseInt(orderItemMap.get("revenue_method").toString()));
				orderItem.setTrialType(Integer.parseInt(orderItemMap.get("trial_type").toString()));
				orderItem.setOrigOrderQty(Integer.parseInt(orderItemMap.get("orig_order_qty").toString()));
				orderItem.setUnitExcess((orderItemMap.get("unit_excess").toString()));
				orderItem.setIsProforma(Integer.parseInt(orderItemMap.get("is_proforma").toString()));
				orderItem.setnTaxUpdates(Integer.parseInt(orderItemMap.get("n_tax_updates").toString()));
				orderItem.setTotalTaxLocalAmount(orderItemMap.get("total_tax_local_amount").toString());
				orderItem.setTotalTaxBaseAmount(orderItemMap.get("total_tax_base_amount").toString());				
				orderItem.setElectronicDelivery(Integer.parseInt(orderItemMap.get("electronic_delivery").toString()));
				orderItem.setTimeUnitOptions(Integer.parseInt(orderItemMap.get("time_unit_options").toString()));
				orderItem.setGroupOrder(Integer.parseInt(orderItemMap.get("group_order").toString()));
				orderItem.setInvoiceDate(new PropertyUtilityClass().getDateFormatter((orderItemMap.get("invoice_date").toString())));
				orderItem.setAutoRenewNotifySent(Integer.parseInt(orderItemMap.get("auto_renew_notify_sent").toString()));
				orderItem.setExtendedDays(Integer.parseInt(orderItemMap.get("extended_days")!=null?orderItemMap.get("extended_days").toString():"0"));
				orderItem.setAsynchronousAutoRenew(Integer.parseInt(orderItemMap.get("asynchronous_auto_renew")!=null?orderItemMap.get("asynchronous_auto_renew").toString():"0"));
				orderItem.setnDaysGraced(Integer.parseInt(orderItemMap.get("n_days_graced")!=null?orderItemMap.get("n_days_graced").toString():"0"));
				orderItem.setIsBackOrdered(Integer.parseInt(orderItemMap.get("is_back_ordered").toString()));
				orderItem.setMruGrpMbrItemDtlSeq(Integer.parseInt(orderItemMap.get("mru_grp_mbr_item_dtl_seq")!=null?orderItemMap.get("mru_grp_mbr_item_dtl_seq").toString():"0"));	
				orderItem.setOrderCodeID(orderItemMap.get("order_code_id").toString());
				orderItem.setSourceCodeID(orderItemMap.get("source_code_id").toString());
				orderItem.setOrderCodeType(orderItemMap.get("order_item_type").toString());
				orderItem.setOrderCode(orderItemMap.get("order_code").toString());
				orderItem.setSourceCode(orderItemMap.get("source_code").toString());
				orderItem.setSourceCodeDescription(orderItemMap.get("sourceCodeDes").toString());
				orderItem.setOrderCodeDescription(orderItemMap.get("orderCodeDes").toString());				
				orderItem.setBundleQty(Integer.parseInt(orderItemMap.get("bundle_qty").toString()));
				orderItem.setOrderQty(Integer.parseInt(orderItemMap.get("order_qty").toString()));
				orderItem.setShipQty((orderItemMap.get("ship_qty")!=null?(String) orderItemMap.get("ship_qty"):""));
	            orderItem.setnIssueLeft(orderItemMap.get("n_issues_left")==null?null:orderItemMap.get("n_issues_left").toString());
				orderItem.setBackordQty(orderItemMap.get("backord_qty")!=null?(String) orderItemMap.get("backord_qty"):"");
				orderItem.setCurrency(orderItemMap.get("currency").toString());
				orderItem.setDeliveryMethod((orderItemMap.get("delivery_method")!=null?(String) orderItemMap.get("delivery_method"):"0"));
				orderItem.setBillingType(new PropertyUtilityClass().getConstantValue("billing_type_"+orderItemMap.get("billing_type").toString()));				
				orderItem.setFullName(orderItemMap.get("fname")!=null?(String) orderItemMap.get("fname"):null +" "+ orderItemMap.get("lname")!=null?(String) orderItemMap.get("lname"):null);				
				orderItem.setAddress1((orderItemMap.get("address1")!=null?(String) orderItemMap.get("address1"):null));
				orderItem.setRateClassDescription((orderItemMap.get("rateClassDescription")!=null?(String) orderItemMap.get("rateClassDescription"):null));
				orderItem.setRateClassEffectiveDate(orderItemMap.get("effective_date")==null?null : new PropertyUtilityClass().getDateFormatter(orderItemMap.get("effective_date").toString()));
				orderItem.setPoNumber((orderItemMap.get("po_number")!=null?(String) orderItemMap.get("po_number"):null));
				orderItem.setMedia((orderItemMap.get("media")!=null?(String) orderItemMap.get("media"):null));
				orderItem.setEdition((orderItemMap.get("edition")!=null?(String) orderItemMap.get("edition"):null));
				orderItem.setRotation(Integer.parseInt(orderItemMap.get("pub_rotation_id")!=null?orderItemMap.get("pub_rotation_id").toString():"0"));
				orderItem.setPackageID((orderItemMap.get("package_id")!=null?(String) orderItemMap.get("package_id"):null));
				orderItem.setAgencyCode((orderItemMap.get("agency_code")!=null?(String) orderItemMap.get("agency_code"):null));
				orderItem.setAgencyName((orderItemMap.get("company")!=null?(String) orderItemMap.get("company"):null));
				orderItem.setAgencyCustomerId(orderItemMap.get("agency_customer_id")!=null?orderItemMap.get("agency_customer_id").toString():"");				
				orderItem.setAgencyRefNbr((orderItemMap.get("agent_ref_nbr")!=null?(String) orderItemMap.get("agent_ref_nbr"):null));
				orderItem.setInvoiceNo((orderItemMap.get("invoice_id")!=null?orderItemMap.get("invoice_id").toString():"0"));
				orderItem.setOrderCategory((orderItemMap.get("order_category")!=null?(String) orderItemMap.get("order_category"):null));
				orderItem.setLocalCommission((orderItemMap.get("localCommission")!=null?orderItemMap.get("localCommission").toString():"0"));
				orderItem.setBaseCommission((orderItemMap.get("baseCommission")!=null?orderItemMap.get("baseCommission").toString():"0"));
				orderItem.setNew_commission((orderItemMap.get("new_commission")!=null?orderItemMap.get("new_commission").toString():"0"));
				orderItem.setRen_commission((orderItemMap.get("ren_commission")!=null?orderItemMap.get("ren_commission").toString():"0"));
				orderItem.setManualDiscAmtLocal(Double.parseDouble(orderItemMap.get("manual_disc_amt_local")!=null?orderItemMap.get("manual_disc_amt_local").toString():"0.0"));	
				orderItem.setManualDiscAmtBase(Double.parseDouble(orderItemMap.get("manual_disc_amt_base")!=null?orderItemMap.get("manual_disc_amt_base").toString():"0.0"));	
				orderItem.setManualDiscPercentage(Double.parseDouble(orderItemMap.get("manual_disc_percentage")!=null?orderItemMap.get("manual_disc_percentage").toString():"0.0"));	
				orderItem.setRequired((int) orderItemMap.get("required"));
				if(orderItemMap.get("special_tax_id").toString().equals("0")) {
					orderItem.setHasTax(Integer.parseInt(orderItemMap.get("has_tax")!=null?orderItemMap.get("has_tax").toString():"0"));
				}else {
					orderItem.setHasTax(0);							
				}
				if(orderItemMap.get("alt_ship_customer_id")!=null){
					altCustomerAddress=jdbcTemplate.queryForList("select (case when customer_address.fname is null then customer_address.company else customer_address.fname + ' ' + customer_address.lname end )as name , concat(customer_address.address1,' ',customer_address.address2,' ' ,customer_address.address3) as address from customer_address where customer_id="+orderItemMap.get("alt_ship_customer_id")+" and customer_address_seq="+orderItemMap.get("alt_ship_customer_address_seq"));
					for(Map<String,Object> map:altCustomerAddress){
						orderItem.setAltFullNameTo(map.get("name")!=null?(String)map.get("name"):null);
						orderItem.setAltCustomerAddress(map.get("address")!=null?(String)map.get("address"):null);
					}					
				}
				if(orderItemMap.get("bill_to_customer_id")!=null){					
					billToCustomerAddress = jdbcTemplate.queryForList("select (case when customer_address.fname is null then customer_address.company else customer_address.fname + ' ' + customer_address.lname end )as name , concat(customer_address.address1,' ',customer_address.address2,' ' ,customer_address.address3) as address from customer_address where customer_id="+orderItemMap.get("bill_to_customer_id")+" and customer_address_seq="+orderItemMap.get("bill_to_customer_address_seq"));
					for(Map<String,Object> map: billToCustomerAddress){
						orderItem.setBillToFullName(map.get("name")!=null?(String)map.get("name"):null);
						orderItem.setBillToCustomerAddress(map.get("address")!=null?(String)map.get("address"):null);
					}
				}else{
					orderItem.setBillToFullName(orderItemMap.get("fname").toString()+" "+ orderItemMap.get("lname").toString());
					orderItem.setBillToCustomerAddress(orderItemMap.get("address1")!=null?(String)orderItemMap.get("address1"):null);
				}	
				OrderItemLists.add(orderItem);				
			}				
			
		}catch(Exception e){
			LOGGER.info("customerOrderPackageEdit : "+e);
		}
		return OrderItemLists;
	}
	@Override
	public OrderItem customerOrderEdit(long orderhdrId,int orderItemType,int orderCodeId,long customerId, int orderItemSeq, int isrenewd) {		
		OrderItem orderItem=new OrderItem();
		List<Map<String, Object>> altCustomerAddress=null;
		List<Map<String, Object>> billToCustomerAddress=null;
		List<Map<String, Object>> orderItemList = null;
		try
		{
			String query="SELECT distinct oi.delivery_method,dm.description AS delivery_method_description,oi.distribution_method,cadrs.special_tax_id,pkg_def_id,s.subscription_def,rc.description,sc.subscription_category_id,s.media,s.edition,sc.description as subscriptionCategoryDescription,t.description as termDescription,cadrs.fname,cadrs.lname,cadrs.address1,cadrs.address2,cadrs.address3,oc.order_code,oc.description as orderCodeDes,"
							   +" oc.start_type as start_type, (case when ((oc.start_type=0 or oc.start_type=1) and oc.order_code_type=0) then 'Issue Based Subscription' when ((oc.start_type=0 or oc.start_type=1) and oc.order_code_type=1) then 'Single Copy' when oc.order_code_type=4 then 'Package Edit'  when oc.order_code_type=2 then 'Product' when ((oc.start_type=4 or oc.start_type=5) and oc.order_code_type=0) then 'Unit Based Subscription' when oc.order_code_type=8 then 'Shipping Price List' else 'Date Based Subscription' end) as pageName,src.source_code,src.description as sourceCodeDes,"
							   +" (isnull((agency.new_commission),0)) as new_commission , (isnull((agency.ren_commission),0)) as ren_commission, "
							   +" cast(((oi.gross_local_amount-isnull(oi.total_tax_local_amount,0))-isnull(((agency.new_commission/100)*(oi.gross_local_amount-isnull(oi.total_tax_local_amount,0))),0)) as NUMERIC(18,2)) as localAmount," 
							   +" cast(((oi.gross_base_amount-isnull(oi.total_tax_base_amount,0))-isnull(((agency.new_commission/100)*(oi.gross_base_amount-isnull(oi.total_tax_base_amount,0))),0))as NUMERIC(18,2))  as baseAmount,"
							   +" cast(((oi.gross_local_amount-isnull(oi.total_tax_local_amount,0))-isnull(((agency.ren_commission/100)*(oi.gross_local_amount-isnull(oi.total_tax_local_amount,0))),0)) as NUMERIC(18,2)) as renlocalAmount, "  
							   +" cast(((oi.gross_base_amount-isnull(oi.total_tax_base_amount,0))-isnull(((agency.ren_commission/100)*(oi.gross_base_amount-isnull(oi.total_tax_base_amount,0))),0))as NUMERIC(18,2))  as renbaseAmount, " 
							   +" cast((isnull(((agency.new_commission/100)*(oi.gross_local_amount-oi.total_tax_local_amount)),0))as decimal(10,2))  as localCommission ," 
							   +" cast((isnull(((agency.new_commission/100)*(oi.gross_base_amount-oi.total_tax_base_amount)),0))as decimal(10,2))  as baseCommission , "
							   +" cast((isnull(((agency.ren_commission/100)*(oi.gross_local_amount-oi.total_tax_local_amount)),0))as decimal(10,2))  as renlocalCommission ,"
							   +" cast((isnull(((agency.ren_commission/100)*(oi.gross_base_amount-oi.total_tax_base_amount)),0))as decimal(10,2))  as renbaseCommission , "
							   +" oi.manual_disc_amt_local,oi.manual_disc_amt_base,oi.manual_disc_percentage,oi.order_code_id,oi.source_code_id,oi.*,(rate_class_effective.description +' - '+ CONVERT(varchar,rate_class_effective.effective_date,101)) as rateClassDescription,rate_class_effective.effective_date,orderhdr.po_number,agency.customer_id as agency_customer_id ,agency.agency_code,agency.company,"
							   +" enumeration,issue_date,CONVERT(varchar,(DATEADD(DAY, 1,expire_date)),101) as subscription_start_date,CONVERT(varchar,(DATEADD(YEAR, 1,expire_date)),101) as subscription_end_date, (SELECT CONVERT(varchar,A.issue_date,101) from view_issue_volume A INNER JOIN (SELECT ROW_NUMBER() OVER(ORDER BY oc_id) AS 'RN', *   FROM view_issue_volume) B  ON A.issue_id= B.issue_id AND B.RN=(SELECT RowNumer+1 FROM(SELECT ROW_NUMBER () OVER (ORDER BY oc_id) RowNumer,issue_id,oc_id FROM view_issue_volume ) qry1 WHERE issue_id =oi.stop_issue_id  and oc_id=oi.oc_id)  and  A.oc_id=oi.oc_id) as renew_start_date	,"  
							   +" (SELECT CONVERT(varchar,A.issue_date,101) from view_issue_volume A INNER JOIN (SELECT ROW_NUMBER() OVER(ORDER BY oc_id) AS 'RN', *   FROM view_issue_volume) B  ON A.issue_id= B.issue_id AND B.RN=(SELECT RowNumer+ oi.n_issues_left FROM(SELECT ROW_NUMBER () OVER (ORDER BY oc_id) RowNumer,issue_id,oc_id FROM view_issue_volume ) qry1 WHERE issue_id =oi.stop_issue_id  and oc_id=oi.oc_id)  and  A.oc_id=oi.oc_id) as renew_expire_date, "
							   +" ut.label,ut.description as unitTypeDescription,"
							   +" p.product_id,p.product,p.product_size,p.product_color,p.product_style,p.taxonomy,p.price ,ratecard.charge_new,ratecard.remit_new,ratecard.percent_new,ratecard.charge_ren,ratecard.remit_ren,ratecard.percent_ren,pub.audited,pub.qp,pub.qf,pub.nqp,pub.nqf from order_item oi"
							   +" left join order_code oc on oc.order_code_id=oi.order_code_id"
					           +" left join source_code src on src.source_code_id=oi.source_code_id"  
							   +" left join customer_address cadrs on (cadrs.customer_id=oi.customer_id and cadrs.customer_address_seq = oi.customer_address_seq)"
							   +" left join subscription_def s on s.subscription_def_id = oi.subscription_def_id"
							   +" left join subscription_category sc on sc.subscription_category_id = s.subscription_category_id"
							   +" left join term t on t.term_id = s.term_id"
							   +" left join rate_class_effective rate_class_effective on rate_class_effective.rate_class_id = oi.rate_class_id and rate_class_effective.rate_class_effective_seq = oi.rate_class_effective_seq "
							   +" left join orderhdr on orderhdr.orderhdr_id=oi.orderhdr_id"
							   +" left join agency on agency.customer_id=oi.agency_customer_id"
							   +" left join view_issue_volume vi on vi.issue_id=oi.start_issue_id"
							//   +" left join order_item_amt_break as oiab on oiab.orderhdr_id=oi.orderhdr_id"
							   +" left join product p on p.product_id=oi.product_id"
							   +" left join pub  on pub.oc_id=oi.oc_id"
							   +" left join rate_class rc on rc.rate_class_id=oi.rate_class_id"
							   +" left join unit_type ut on ut.unit_type_id = oi.unit_type_id"
							   +" left join ratecard ratecard on ratecard.rate_class_id=oi.rate_class_id"
							   +" left join delivery_method dm on dm.delivery_method=oi.delivery_method"
							   +" where oi.orderhdr_id = "+orderhdrId+" and oi.order_item_seq="+orderItemSeq+";";
				orderItemList = jdbcTemplate.queryForList(query);

			for(Map<String, Object> orderItemMap:orderItemList)
			{	
				orderItem.setPageName(orderItemMap.get("pageName").toString());
				orderItem.setSubscripId(orderItemMap.get("subscrip_id")!=null?orderItemMap.get("subscrip_id").toString():null);
				orderItem.setStartType(Integer.parseInt(orderItemMap.get("start_type").toString()));
				orderItem.setOrderhdrId(Long.parseLong(orderItemMap.get("orderhdr_id").toString()));				
				orderItem.setOrderItemSeq(Integer.parseInt(orderItemMap.get("order_item_seq").toString()));				
				orderItem.setUserCode(orderItemMap.get("user_code").toString());	
				orderItem.setDateStamp(Integer.parseInt(orderItemMap.get("date_stamp").toString()));				
				orderItem.setOrderItemType(Integer.parseInt(orderItemMap.get("order_item_type").toString()));	
				orderItem.setInstallmentPlanId(orderItemMap.get("installment_plan_id")!=null?(orderItemMap.get("installment_plan_id").toString()):null);
			    Date parseDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(orderItemMap.get("order_date").toString());
				DateFormat formater = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");				 	
				orderItem.setOrderDate(formater.format(parseDate));
				if(isrenewd==1) 
				{
					orderItem.setLocalAmount((orderItemMap.get("renlocalAmount").toString()));				
					orderItem.setBaseAmount((orderItemMap.get("renbaseAmount").toString()));
					orderItem.setPoNumber("");
					
				}else 
				{
					orderItem.setLocalAmount((orderItemMap.get("localAmount").toString()));				
					orderItem.setBaseAmount((orderItemMap.get("baseAmount").toString()));
					orderItem.setPoNumber((orderItemMap.get("po_number")!=null?(String) orderItemMap.get("po_number"):null));
					
				}
				orderItem.setGrossBaseAmount(orderItemMap.get("gross_base_amount").toString());				
				orderItem.setGrossLocalAmount(orderItemMap.get("gross_local_amount").toString());				
				orderItem.setNetBaseAmount(orderItemMap.get("net_base_amount").toString());				
				orderItem.setNetLocalAmount(orderItemMap.get("net_local_amount").toString());				
				long tax = getTaxRate(customerId,orderCodeId);			
				orderItem.setTaxRateAmount(tax);
				orderItem.setHasDeliveryCharge(Integer.parseInt(orderItemMap.get("has_delivery_charge").toString()));				
				orderItem.setBillDate(new PropertyUtilityClass().getDateFormatter((orderItemMap.get("bill_date").toString())));				
				orderItem.setRefundStatus(Integer.parseInt(orderItemMap.get("refund_status").toString()));
				orderItem.setOrderType(Integer.parseInt(orderItemMap.get("order_type").toString()));
				orderItem.setHasPremium(Integer.parseInt(orderItemMap.get("has_premium").toString()));
				orderItem.setPrepaymentReq(Integer.parseInt(orderItemMap.get("prepayment_req").toString()));				
				orderItem.setIsComplimentary(Integer.parseInt(orderItemMap.get("is_complimentary").toString()));
				orderItem.setSubscripStartType(Integer.parseInt(orderItemMap.get("subscrip_start_type").toString()));
				orderItem.setDuration(Integer.parseInt(orderItemMap.get("duration").toString()));				
				orderItem.setRenewalStatus(Integer.parseInt(orderItemMap.get("renewal_status").toString()));
				orderItem.setDeliveryMethodPerm(Integer.parseInt(orderItemMap.get("delivery_method_perm").toString()));
				orderItem.setChangeQtyFlag(Integer.parseInt(orderItemMap.get("change_qty_flag").toString()));
				orderItem.setnRemainingPaidIssue(Integer.parseInt((orderItemMap.get("n_remaining_paid_issues")!=null?orderItemMap.get("n_remaining_paid_issues").toString():"0")));
				orderItem.setExtIssleft(Integer.parseInt((orderItemMap.get("ext_iss_left")!=null?orderItemMap.get("ext_iss_left").toString():"0")));
				orderItem.setExtIssTot(Integer.parseInt((orderItemMap.get("ext_iss_tot")!=null?orderItemMap.get("ext_iss_tot").toString():"0")));				
				orderItem.setRenewalCategory(Integer.parseInt(orderItemMap.get("renewal_category").toString()));				
				orderItem.setExchangeRate(orderItemMap.get("exchange_rate").toString());
				orderItem.setPkgDefId(orderItemMap.get("pkg_def_id")!=null?(orderItemMap.get("pkg_def_id").toString()):null);
				orderItem.setSubscriptionDefId(orderItemMap.get("subscription_def_id")!=null?orderItemMap.get("subscription_def_id").toString():"0");
				if(isrenewd==1)
				{
					if(orderItemMap.get("pageName").equals("Issue Based Subscription")) 
					{
						orderItem.setStartDate(orderItemMap.get("renew_start_date").toString());
					}else 
					{
						orderItem.setStartDate(orderItemMap.get("subscription_start_date").toString());
					}
					orderItem.setPaymentStatus(0);
					orderItem.setPayment_status("No Payment");
					orderItem.setOrderStatus(10);
					orderItem.setOrder_status("Hold for Payment");
				}else 
				{
					orderItem.setStartDate(orderItemMap.get("start_date")!=null?(new PropertyUtilityClass().getDateFormatter((orderItemMap.get("start_date").toString()))):null);
					orderItem.setPaymentStatus(Integer.parseInt(orderItemMap.get("payment_status").toString()));				
					orderItem.setPayment_status(new PropertyUtilityClass().getConstantValue("order_item.pay_status_"+orderItemMap.get("payment_status").toString()));
					orderItem.setOrderStatus(Integer.parseInt(orderItemMap.get("order_status").toString()));
					orderItem.setOrder_status(new PropertyUtilityClass().getConstantValue("order_item.order_status_"+orderItemMap.get("order_status").toString()));
				}
				if(orderItemType == 0)
				{
					orderItem.setSubscriptionDef(orderItemMap.get("subscription_def")!=null?orderItemMap.get("subscription_def").toString():null);
					orderItem.setSubscriptionDefDescription(orderItemMap.get("description")!=null?orderItemMap.get("description").toString():null);
					orderItem.setTermDescription(orderItemMap.get("termDescription")!=null?orderItemMap.get("termDescription").toString():null);
					orderItem.setSubscriptionCategoryId(orderItemMap.get("subscription_category_id")!=null?orderItemMap.get("subscription_category_id").toString():"0");
					orderItem.setSubscriptionCategoryDescription(orderItemMap.get("subscriptionCategoryDescription")!=null?orderItemMap.get("subscriptionCategoryDescription").toString():null);
					orderItem.setRenewToCustomerId(orderItemMap.get("renew_to_customer_id")!=null?(Integer.parseInt(orderItemMap.get("renew_to_customer_id").toString())):0);
					orderItem.setRenewToCustomerAddressSeq(Integer.parseInt(orderItemMap.get("renew_to_customer_address_seq").toString()));											
				}
				if(orderItemMap.get("renew_to_customer_id")!=null)
				{
					List<Map<String, Object>> renewCustomerAddress=jdbcTemplate.queryForList("select (case when customer_address.fname is null and customer_address.lname is null then customer_address.company else (customer_address.fname + ' ' + customer_address.lname) end )as name , (isnull(customer_address.address1,'')+ ' ' +isnull(customer_address.address2,'')+ ' ' +isnull(customer_address.address3,'')) as address from customer_address where customer_id="+orderItemMap.get("renew_to_customer_id")+" and customer_address_seq="+orderItemMap.get("renew_to_customer_address_seq"));
					String customer = jdbcTemplate.queryForObject("select renew_to_customer_id from order_item where orderhdr_id="+orderhdrId+" and order_item_seq="+orderItemSeq, String.class);
					for(Map<String,Object> map:renewCustomerAddress)
					{
						if(map.get("name")!=null) {
							orderItem.setRenewFullNameTo(map.get("name")!=null?(String)map.get("name"):null);
						}else {
							orderItem.setRenewFullNameTo(customer);
						}
						String add1 = jdbcTemplate.queryForObject("select address1 as address from customer_address where customer_id="+orderItemMap.get("renew_to_customer_id")+" and customer_address_seq="+orderItemMap.get("renew_to_customer_address_seq"), String.class);
						String add2 = jdbcTemplate.queryForObject("select address2 as address from customer_address where customer_id="+orderItemMap.get("renew_to_customer_id")+" and customer_address_seq="+orderItemMap.get("renew_to_customer_address_seq"), String.class);
						String add3 = jdbcTemplate.queryForObject("select address3 as address from customer_address where customer_id="+orderItemMap.get("renew_to_customer_id")+" and customer_address_seq="+orderItemMap.get("renew_to_customer_address_seq"), String.class);
						String cityState = jdbcTemplate.queryForObject("select concat(city, '  ' ,state) as address from customer_address where customer_id="+orderItemMap.get("renew_to_customer_id")+" and customer_address_seq="+orderItemMap.get("renew_to_customer_address_seq"), String.class);
						if(add1 == null && add2 == null && add3 == null ) {
							orderItem.setRenewToCustomerAddress(cityState);
						}else {
							orderItem.setRenewToCustomerAddress(map.get("address")!=null?(String)map.get("address"):null);
						}
					}					
				}
				if(orderItemType == 4)
				{
					List<Map<String, Object>> subscripDef=jdbcTemplate.queryForList("select * from view_pkg_def where order_code_id="+orderCodeId+" and pkg_def_id="+orderItemMap.get("pkg_def_id")+"");
					for(Map<String,Object> map:subscripDef) 
					{
						orderItem.setSubscriptionDef(map.get("pkg_def")!=null?(String)map.get("pkg_def"):null);
						orderItem.setPkgDef(map.get("pkg_def")!=null?(String)map.get("pkg_def"):null);
						//orderItem.setSubscriptionDefDescription(map.get("description")!=null?(String)map.get("description"):null);
					}
					 orderItem.setSubscriptionDefDescription(orderItemMap.get("description")!=null?orderItemMap.get("description").toString():null);	
				}
				else if(orderItemType == 2)
				{
					orderItem.setProductId((orderItemMap.get("product_id")!=null?orderItemMap.get("product_id").toString():null));
					orderItem.setProduct((orderItemMap.get("product")!=null?(String)orderItemMap.get("product"):null));
					orderItem.setProductSize((orderItemMap.get("product_size")!=null?(String)orderItemMap.get("product_size"):null));
					orderItem.setProductStyle((orderItemMap.get("product_style")!=null?(String)orderItemMap.get("product_style"):null));
					orderItem.setProductColor((orderItemMap.get("product_color")!=null?(String)orderItemMap.get("product_color"):null));
					orderItem.setProductTaxonomy((orderItemMap.get("taxonomy")!=null?(String)orderItemMap.get("taxonomy"):null));
					orderItem.setProductPrice((orderItemMap.get("price")!=null?orderItemMap.get("price").toString():null));
				}
				if(orderItemType==8) 
				{
					orderItem.setShippingPriceList(orderItemMap.get("shipping_price_list").toString());
				}
			    if(orderItemType == 1) 
			    {
			    	orderItem.setExpireDate(null);
			    	orderItem.setEnumeration((orderItemMap.get("enumeration")!=null?(String)orderItemMap.get("enumeration"):null));
			    }
			    else if(isrenewd==1)
			    {
			    	if(orderItemMap.get("pageName").equals("Issue Based Subscription")) 
			    	{
						orderItem.setExpireDate(orderItemMap.get("renew_expire_date").toString());
					}else 
					{
						orderItem.setExpireDate(orderItemMap.get("subscription_end_date").toString());	
					}
			    }else 
			    {
			    	orderItem.setExpireDate(orderItemMap.get("expire_date")!=null?(new PropertyUtilityClass().getDateFormatter(orderItemMap.get("expire_date").toString())):"");
			    }
				orderItem.setnNonPaidIssues(Integer.parseInt(orderItemMap.get("n_nonpaid_issues")!=null?orderItemMap.get("n_nonpaid_issues").toString():"0"));
				orderItem.setnRemainingNonPaidIssues(Integer.parseInt(orderItemMap.get("n_remaining_nonpaid_issues")!=null?orderItemMap.get("n_remaining_nonpaid_issues").toString():"0"));
				orderItem.setRateClassId(Integer.parseInt(orderItemMap.get("rate_class_id")!=null?orderItemMap.get("rate_class_id").toString():"0"));
				orderItem.setRateClassEffectiveSeq(Integer.parseInt(orderItemMap.get("rate_class_effective_seq")!=null?orderItemMap.get("rate_class_effective_seq").toString():"0"));								
				orderItem.setInventoryId((orderItemMap.get("inventory_id")!=null? orderItemMap.get("inventory_id").toString():" "));				
				orderItem.setOcId(Integer.parseInt(orderItemMap.get("oc_id").toString()));				
				orderItem.setAutoPayment(Integer.parseInt(orderItemMap.get("auto_payment").toString()));
				orderItem.setPerpetualOrder(Integer.parseInt(orderItemMap.get("perpetual_order").toString()));
				orderItem.setBillToCustomerId(orderItemMap.get("bill_to_customer_id")!=null?(Integer.parseInt(orderItemMap.get("bill_to_customer_id").toString())):0);
				orderItem.setBillToCustomerAddressSeq(Integer.parseInt(orderItemMap.get("bill_to_customer_address_seq").toString()));
				orderItem.setRenewToCustomerId(orderItemMap.get("renew_to_customer_id")!=null?(Integer.parseInt(orderItemMap.get("renew_to_customer_id").toString())):0);
				orderItem.setRenewToCustomerAddressSeq(Integer.parseInt(orderItemMap.get("renew_to_customer_address_seq").toString()));
				orderItem.setCustomerId(Integer.parseInt(orderItemMap.get("customer_id")!=null?orderItemMap.get("customer_id").toString():"0"));
				orderItem.setCustomerAddressSeq(Integer.parseInt(orderItemMap.get("customer_address_seq").toString()));
				orderItem.setAltShipCustomerId(Integer.parseInt(orderItemMap.get("alt_ship_customer_id")!=null?orderItemMap.get("alt_ship_customer_id").toString():"0"));
				orderItem.setAltShipCustomerAddressSeq(Integer.parseInt(orderItemMap.get("alt_ship_customer_address_seq")!=null?orderItemMap.get("alt_ship_customer_address_seq").toString():"0"));
				orderItem.setStartIssueId(orderItemMap.get("start_issue_id")!=null?orderItemMap.get("start_issue_id").toString():"0");
				orderItem.setStopIssueId(Integer.parseInt(orderItemMap.get("stop_issue_id")!=null?orderItemMap.get("stop_issue_id").toString():"0"));
				orderItem.setNoteExist(Integer.parseInt(orderItemMap.get("note_exist").toString()));
				orderItem.setServiceExist(Integer.parseInt(orderItemMap.get("service_exist").toString()));
				orderItem.setMruOrderItemAmtBreakSeq(Integer.parseInt(orderItemMap.get("mru_order_item_amt_break_seq").toString()));
				orderItem.setHasBeenRenewed(Integer.parseInt(orderItemMap.get("has_been_renewed").toString()));
				orderItem.setRevenueMethod(Integer.parseInt(orderItemMap.get("revenue_method").toString()));
				orderItem.setTrialType(Integer.parseInt(orderItemMap.get("trial_type").toString()));
				orderItem.setTrialPeriod(orderItemMap.get("trial_period")!=null?orderItemMap.get("trial_period").toString():null);
				orderItem.setOrigOrderQty(Integer.parseInt(orderItemMap.get("orig_order_qty").toString()));
				orderItem.setUnitType(orderItemMap.get("label")!=null?orderItemMap.get("label").toString():null);
				orderItem.setUnitTypeDescription(orderItemMap.get("unitTypeDescription")!=null?orderItemMap.get("unitTypeDescription").toString():null);
				orderItem.setUnitExcess(new PropertyUtilityClass().getConstantValue("unit_excess_"+orderItemMap.get("unit_excess")).toString());
				orderItem.setIsProforma(Integer.parseInt(orderItemMap.get("is_proforma").toString()));
				orderItem.setnTaxUpdates(Integer.parseInt(orderItemMap.get("n_tax_updates").toString()));
				orderItem.setTotalTaxLocalAmount(orderItemMap.get("total_tax_local_amount").toString());
				orderItem.setTotalTaxBaseAmount(orderItemMap.get("total_tax_base_amount").toString());				
				orderItem.setElectronicDelivery(Integer.parseInt(orderItemMap.get("electronic_delivery").toString()));
				orderItem.setTimeUnitOptions(Integer.parseInt(orderItemMap.get("time_unit_options").toString()));
				orderItem.setGroupOrder(Integer.parseInt(orderItemMap.get("group_order").toString()));
				orderItem.setInvoiceDate(new PropertyUtilityClass().getDateFormatter((orderItemMap.get("invoice_date").toString())));
				orderItem.setAutoRenewNotifySent(Integer.parseInt(orderItemMap.get("auto_renew_notify_sent").toString()));
				int revenueMethod = jdbcTemplate.queryForObject("select revenue_method from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq, Integer.class);
				if (revenueMethod == 0) {
					orderItem.setExtendedDays(Integer.parseInt(orderItemMap.get("ext_iss_tot")!=null?orderItemMap.get("ext_iss_tot").toString():"0"));
				}else if(revenueMethod == 1){
					orderItem.setExtendedDays(Integer.parseInt(orderItemMap.get("extended_days")!=null?orderItemMap.get("extended_days").toString():"0"));
				}else {
					orderItem.setExtendedDays(Integer.parseInt(orderItemMap.get("extended_days")!=null?orderItemMap.get("extended_days").toString():"0"));
				}
				//orderItem.setExtendedDays(Integer.parseInt(orderItemMap.get("extended_days")!=null?orderItemMap.get("extended_days").toString():"0"));
				orderItem.setAsynchronousAutoRenew(Integer.parseInt(orderItemMap.get("asynchronous_auto_renew")!=null?orderItemMap.get("asynchronous_auto_renew").toString():"0"));
				orderItem.setnDaysGraced(Integer.parseInt(orderItemMap.get("n_days_graced")!=null?orderItemMap.get("n_days_graced").toString():"0"));
				orderItem.setIsBackOrdered(Integer.parseInt(orderItemMap.get("is_back_ordered").toString()));
				orderItem.setMruGrpMbrItemDtlSeq(Integer.parseInt(orderItemMap.get("mru_grp_mbr_item_dtl_seq")!=null?orderItemMap.get("mru_grp_mbr_item_dtl_seq").toString():"0"));	
				orderItem.setOrderCodeID(orderItemMap.get("order_code_id").toString());		
				orderItem.setOrderCodeType(orderItemMap.get("order_item_type").toString());
				orderItem.setOrderCode(orderItemMap.get("order_code").toString());
				if(isrenewd==1) {
      			int count= jdbcTemplate.queryForObject("select count (*) from source_code where active=1  AND (GETDATE() BETWEEN from_date AND to_date OR (source_code.to_date IS NULL OR source_code.from_date IS NULL)) and source_code_id="+orderItemMap.get("source_code_id").toString()+"", Integer.class);
				if(count>0) {
      			orderItem.setSourceCodeID(orderItemMap.get("source_code_id").toString());
				orderItem.setSourceCode(orderItemMap.get("source_code").toString());
				orderItem.setSourceCodeDescription(orderItemMap.get("sourceCodeDes")!=null?orderItemMap.get("sourceCodeDes").toString():"");
				}else {
					orderItem.setSourceCodeID("");
					orderItem.setSourceCode("");
					orderItem.setSourceCodeDescription("");
				} 
				}else {
					orderItem.setSourceCodeID(orderItemMap.get("source_code_id").toString());
					orderItem.setSourceCode(orderItemMap.get("source_code").toString());
					orderItem.setSourceCodeDescription(orderItemMap.get("sourceCodeDes")!=null?orderItemMap.get("sourceCodeDes").toString():"");
				
				}
				orderItem.setOrderCodeDescription(orderItemMap.get("orderCodeDes").toString());				
				orderItem.setBundleQty(Integer.parseInt(orderItemMap.get("bundle_qty").toString()));
				orderItem.setOrderQty(Integer.parseInt(orderItemMap.get("order_qty").toString()));
				orderItem.setShipQty(orderItemMap.get("ship_qty")!=null?(String) orderItemMap.get("ship_qty"):"");
				if(orderItemType==0) 
				{
					if (revenueMethod == 0) {
						orderItem.setnIssueLeft(orderItemMap.get("order_qty")!=null?orderItemMap.get("order_qty").toString():"0");
					}else {
						orderItem.setnIssueLeft(orderItemMap.get("n_issues_left")==null?null:orderItemMap.get("n_issues_left").toString());
					}
				}else 
				{
					orderItem.setnIssueLeft(orderItemMap.get("n_issues_left")==null?null:orderItemMap.get("n_issues_left").toString());
				}
				orderItem.setBackordQty(orderItemMap.get("backord_qty")!=null?(String) orderItemMap.get("backord_qty"):"");
				orderItem.setCurrency(orderItemMap.get("currency").toString());
				orderItem.setDeliveryMethod((orderItemMap.get("delivery_method")!=null?(String) orderItemMap.get("delivery_method"):"0"));
				orderItem.setBillingType(new PropertyUtilityClass().getConstantValue("billing_type_"+orderItemMap.get("billing_type").toString()));				
				orderItem.setFullName(orderItemMap.get("fname")!=null?(String) orderItemMap.get("fname"):null +" "+ orderItemMap.get("lname")!=null?(String) orderItemMap.get("lname"):null);				
			  	orderItem.setAddress1((orderItemMap.get("address1")!=null?(String) orderItemMap.get("address1"):"") + " " +(orderItemMap.get("address2")!=null?(String) orderItemMap.get("address2"):"")+ " "+ (orderItemMap.get("address3")!=null?(String) orderItemMap.get("address3"):""));
				orderItem.setRateClassDescription((orderItemMap.get("rateClassDescription")!=null?(String) orderItemMap.get("rateClassDescription"):null));
				orderItem.setRateClassEffectiveDate(orderItemMap.get("effective_date")==null?null : new PropertyUtilityClass().getDateFormatter(orderItemMap.get("effective_date").toString()));
				orderItem.setMedia((orderItemMap.get("media")!=null?(String) orderItemMap.get("media"):null));
				orderItem.setEdition((orderItemMap.get("edition")!=null?(String) orderItemMap.get("edition"):null));
				orderItem.setRotation(Integer.parseInt(orderItemMap.get("pub_rotation_id")!=null?orderItemMap.get("pub_rotation_id").toString():"0"));
				orderItem.setPackageID((orderItemMap.get("package_id")!=null?(String) orderItemMap.get("package_id"):null));
				orderItem.setAgencyCode((orderItemMap.get("agency_code")!=null?(String) orderItemMap.get("agency_code"):null));
				orderItem.setAgencyName((orderItemMap.get("company")!=null?(String) orderItemMap.get("company"):null));
				orderItem.setAgencyCustomerId(orderItemMap.get("agency_customer_id")!=null?orderItemMap.get("agency_customer_id").toString():"");				
				orderItem.setAgencyRefNbr((orderItemMap.get("agent_ref_nbr")!=null)?orderItemMap.get("agent_ref_nbr").toString():"");
				orderItem.setInvoiceNo((orderItemMap.get("invoice_id")!=null?orderItemMap.get("invoice_id").toString():"0"));
				orderItem.setOrderCategory((orderItemMap.get("order_category")!=null?(String) orderItemMap.get("order_category"):null));
				if(isrenewd==1) 
				{
					orderItem.setLocalCommission((orderItemMap.get("renlocalCommission")!=null?orderItemMap.get("renlocalCommission").toString():"0"));
					orderItem.setBaseCommission((orderItemMap.get("renbaseCommission")!=null?orderItemMap.get("renbaseCommission").toString():"0"));
					orderItem.setChargeRen((orderItemMap.get("charge_ren")!=null?orderItemMap.get("charge_ren").toString():null));
					orderItem.setRemitRen((orderItemMap.get("remit_ren")!=null?orderItemMap.get("remit_ren").toString():null));
					orderItem.setPercentRen((orderItemMap.get("percent_ren")!=null?orderItemMap.get("percent_ren").toString():null));
				}else 
				{
					orderItem.setLocalCommission((orderItemMap.get("localCommission")!=null?orderItemMap.get("localCommission").toString():"0"));
					orderItem.setBaseCommission((orderItemMap.get("baseCommission")!=null?orderItemMap.get("baseCommission").toString():"0"));
					orderItem.setChargeNew((orderItemMap.get("charge_new")!=null?orderItemMap.get("charge_new").toString():null));
					orderItem.setRemitNew((orderItemMap.get("remit_new")!=null?orderItemMap.get("remit_new").toString():null));
					orderItem.setPercentNew((orderItemMap.get("percent_new")!=null?orderItemMap.get("percent_new").toString():null));
				}
				orderItem.setNew_commission((orderItemMap.get("new_commission")!=null?orderItemMap.get("new_commission").toString():"0"));
				orderItem.setRen_commission((orderItemMap.get("ren_commission")!=null?orderItemMap.get("ren_commission").toString():"0"));
				orderItem.setManualDiscAmtLocal(Double.parseDouble(orderItemMap.get("manual_disc_amt_local")!=null?orderItemMap.get("manual_disc_amt_local").toString():"0.0"));	
				orderItem.setManualDiscAmtBase(Double.parseDouble(orderItemMap.get("manual_disc_amt_base")!=null?orderItemMap.get("manual_disc_amt_base").toString():"0.0"));	
				orderItem.setManualDiscPercentage(Double.parseDouble(orderItemMap.get("manual_disc_percentage")!=null?orderItemMap.get("manual_disc_percentage").toString():"0.0"));	
				if(orderItemMap.get("special_tax_id").toString().equals("0")) 
				{
					orderItem.setHasTax(Integer.parseInt(orderItemMap.get("has_tax")!=null?orderItemMap.get("has_tax").toString():"0"));
				}else 
				{
					orderItem.setHasTax(0);							
				}
				
				if(orderItemMap.get("alt_ship_customer_id")!=null)
				{
					altCustomerAddress=jdbcTemplate.queryForList("select (case when customer_address.fname is null and customer_address.lname is null then customer_address.company else  (customer_address.fname + ' ' + customer_address.lname) end )as name , (isnull(customer_address.address1,'')+ ' ' +isnull(customer_address.address2,'')+ ' ' +isnull(customer_address.address3,'')) as address from customer_address where customer_id="+orderItemMap.get("alt_ship_customer_id")+" and customer_address_seq="+orderItemMap.get("alt_ship_customer_address_seq"));
					String customer = jdbcTemplate.queryForObject("select alt_ship_customer_id from order_item where orderhdr_id="+orderhdrId+" and order_item_seq="+orderItemSeq, String.class);
					for(Map<String,Object> map:altCustomerAddress)
					{
						if(map.get("name")!=null) {
							orderItem.setAltFullNameTo(map.get("name")!=null?(String)map.get("name"):null);
						}else {
							orderItem.setAltFullNameTo(customer);
						}
						String add1 = jdbcTemplate.queryForObject("select address1 as address from customer_address where customer_id="+orderItemMap.get("alt_ship_customer_id")+" and customer_address_seq="+orderItemMap.get("alt_ship_customer_address_seq"), String.class);
						String add2 = jdbcTemplate.queryForObject("select address2 as address from customer_address where customer_id="+orderItemMap.get("alt_ship_customer_id")+" and customer_address_seq="+orderItemMap.get("alt_ship_customer_address_seq"), String.class);
						String add3 = jdbcTemplate.queryForObject("select address3 as address from customer_address where customer_id="+orderItemMap.get("alt_ship_customer_id")+" and customer_address_seq="+orderItemMap.get("alt_ship_customer_address_seq"), String.class);
						String cityState = jdbcTemplate.queryForObject("select concat(city, '  ' ,state) as address from customer_address where customer_id="+orderItemMap.get("alt_ship_customer_id")+" and customer_address_seq="+orderItemMap.get("alt_ship_customer_address_seq"), String.class);
						if(add1 == null && add2 == null && add3 == null ) {
							orderItem.setAltCustomerAddress(cityState);
						}else {
							orderItem.setAltCustomerAddress(map.get("address")!=null?(String)map.get("address"):null);
						}
					}					
				}
				if(orderItemMap.get("bill_to_customer_id")!=null)
				{					
					billToCustomerAddress = jdbcTemplate.queryForList("select (case when customer_address.fname is null and customer_address.lname is null then customer_address.company else  (customer_address.fname + ' ' + customer_address.lname) end )as name , (isnull(customer_address.address1,'')+ ' ' +isnull(customer_address.address2,'')+ ' ' +isnull(customer_address.address3,'')) as address from customer_address where customer_id="+orderItemMap.get("bill_to_customer_id")+" and customer_address_seq="+orderItemMap.get("bill_to_customer_address_seq"));
					String customer = jdbcTemplate.queryForObject("select bill_to_customer_id from order_item where orderhdr_id="+orderhdrId+" and order_item_seq="+orderItemSeq, String.class);
					for(Map<String,Object> map: billToCustomerAddress)
					{
						if(map.get("name")!=null) {
							orderItem.setBillToFullName(map.get("name")!=null?(String)map.get("name"):null);
						}else {
							orderItem.setBillToFullName(customer);
						}
						String add1 = jdbcTemplate.queryForObject("select address1 as address from customer_address where customer_id="+orderItemMap.get("bill_to_customer_id")+" and customer_address_seq="+orderItemMap.get("bill_to_customer_address_seq"), String.class);
						String add2 = jdbcTemplate.queryForObject("select address2 as address from customer_address where customer_id="+orderItemMap.get("bill_to_customer_id")+" and customer_address_seq="+orderItemMap.get("bill_to_customer_address_seq"), String.class);
						String add3 = jdbcTemplate.queryForObject("select address3 as address from customer_address where customer_id="+orderItemMap.get("bill_to_customer_id")+" and customer_address_seq="+orderItemMap.get("bill_to_customer_address_seq"), String.class);
						String cityState = jdbcTemplate.queryForObject("select concat(city, '  ' ,state) as address from customer_address where customer_id="+orderItemMap.get("bill_to_customer_id")+" and customer_address_seq="+orderItemMap.get("bill_to_customer_address_seq"), String.class);
						if(add1 == null && add2 == null && add3 == null ) {
							orderItem.setBillToCustomerAddress(cityState);
						}else {
							orderItem.setBillToCustomerAddress(map.get("address")!=null?(String)map.get("address"):null);
						}
					}
				}else
				{
					orderItem.setBillToFullName(orderItemMap.get("fname").toString()+" "+ orderItemMap.get("lname").toString());
					orderItem.setBillToCustomerAddress(orderItemMap.get("address1")!=null?(String)orderItemMap.get("address1"):null);
				}	
				if(isrenewd==1 && (orderItem.getAgencyCustomerId()!="")) 
				{
					if((orderItem.getChargeRen()!=null && !(orderItem.getRemitRen()!=null) && !(orderItem.getPercentRen()!=null)))
					{
						orderItem.setLocalAmount(orderItem.getChargeRen());
						orderItem.setBaseAmount(String.valueOf(Double.parseDouble(orderItem.getChargeRen())* (Double.parseDouble(orderItem.getExchangeRate()))));
						if(Integer.parseInt(orderItem.getRen_commission())!=0) 
						{
							orderItem.setLocalCommission(String.valueOf((Double.parseDouble(orderItem.getLocalAmount())* Double.parseDouble(orderItem.getNew_commission()))/100));
							orderItem.setBaseCommission(String.valueOf((Double.parseDouble(orderItem.getBaseAmount())* Double.parseDouble(orderItem.getNew_commission()))/100));					
							orderItem.setLocalAmount(String.valueOf(Double.parseDouble(orderItem.getChargeRen())- Double.parseDouble(orderItem.getLocalCommission())));
							orderItem.setBaseAmount(String.valueOf((Double.parseDouble(orderItem.getChargeRen())- Double.parseDouble(orderItem.getLocalCommission()))* (Double.parseDouble(orderItem.getExchangeRate()))));
						}
					}
					if((orderItem.getRemitRen()!=null && !(orderItem.getChargeRen()!=null) && !(orderItem.getPercentRen()!=null)))
					{
						orderItem.setLocalCommission(String.valueOf(Double.parseDouble(orderItem.getLocalAmount())- (Double.parseDouble(orderItem.getRemitRen()))));
						orderItem.setBaseCommission(String.valueOf(Double.parseDouble(orderItem.getBaseAmount())- (Double.parseDouble(orderItem.getRemitRen()))));
						orderItem.setLocalAmount(String.valueOf(Double.parseDouble(orderItem.getRemitRen())));
						orderItem.setBaseAmount(String.valueOf(Double.parseDouble(orderItem.getRemitRen())* (Double.parseDouble(orderItem.getExchangeRate()))));
						
					}
					if((orderItem.getPercentRen()!=null && !(orderItem.getChargeRen()!=null) && !(orderItem.getRemitRen()!=null))) 
					{
					orderItem.setLocalAmount(String.valueOf(((Double.parseDouble(orderItem.getLocalAmount())-(Double.parseDouble(orderItem.getLocalAmount())))* Double.parseDouble(orderItem.getPercentRen()))/100));
					orderItem.setBaseAmount(String.valueOf(((Double.parseDouble(orderItem.getBaseAmount())-(Double.parseDouble(orderItem.getBaseAmount())))* Double.parseDouble(orderItem.getPercentRen())/100)* (Double.parseDouble(orderItem.getExchangeRate()))));
					orderItem.setLocalCommission(orderItem.getPercentRen());
					orderItem.setBaseCommission(orderItem.getPercentRen());
					}
					if((orderItem.getPercentRen()!=null && (orderItem.getRemitRen()!=null) && !(orderItem.getChargeRen()!=null))) {
						orderItem.setLocalCommission(String.valueOf(Double.parseDouble(orderItem.getLocalAmount())-(Double.parseDouble(orderItem.getRemitRen()))));
						orderItem.setBaseCommission(String.valueOf(Double.parseDouble(orderItem.getBaseAmount())- (Double.parseDouble(orderItem.getRemitRen()))));
						orderItem.setLocalAmount(orderItem.getRemitRen());
						orderItem.setBaseAmount(String.valueOf(Double.parseDouble(orderItem.getRemitRen())* (Double.parseDouble(orderItem.getExchangeRate()))));
						
					}
					if((orderItem.getChargeRen()!=null && (orderItem.getPercentRen()!=null) && !(orderItem.getRemitRen()!=null)))
					{
						orderItem.setLocalAmount(String.valueOf(Double.parseDouble(orderItem.getChargeRen())-((Double.parseDouble(orderItem.getChargeRen()) * Double.parseDouble(orderItem.getPercentRen())/100))));
						orderItem.setBaseAmount(String.valueOf(Double.parseDouble(orderItem.getChargeRen())-((Double.parseDouble(orderItem.getChargeRen()) * Double.parseDouble(orderItem.getPercentRen())/100))* (Double.parseDouble(orderItem.getExchangeRate()))));
						orderItem.setLocalCommission(String.valueOf((Double.parseDouble(orderItem.getChargeRen()) * Double.parseDouble(orderItem.getPercentRen()))/100));
						orderItem.setBaseCommission(String.valueOf((Double.parseDouble(orderItem.getChargeRen()) * Double.parseDouble(orderItem.getPercentRen()))/100));
					}
					if((orderItem.getChargeRen()!=null && (orderItem.getRemitRen()!=null) && !(orderItem.getPercentRen()!=null)))
					{
						orderItem.setLocalAmount(orderItem.getRemitRen());
						orderItem.setBaseAmount(String.valueOf(Double.parseDouble(orderItem.getRemitRen())* (Double.parseDouble(orderItem.getExchangeRate()))));
						orderItem.setLocalCommission(String.valueOf((Double.parseDouble(orderItem.getChargeRen()))- (Double.parseDouble(orderItem.getRemitRen()))));
						orderItem.setBaseCommission(String.valueOf((Double.parseDouble(orderItem.getChargeRen()))- (Double.parseDouble(orderItem.getRemitRen()))));
					}
					if((orderItem.getChargeRen()!=null && (orderItem.getRemitRen()!=null) && (orderItem.getPercentRen()!=null)))
					{
						orderItem.setLocalAmount(orderItem.getRemitRen());
						orderItem.setBaseAmount(String.valueOf(Double.parseDouble(orderItem.getRemitRen())* (Double.parseDouble(orderItem.getExchangeRate()))));
						orderItem.setLocalCommission(String.valueOf((Double.parseDouble(orderItem.getChargeRen()))- (Double.parseDouble(orderItem.getRemitRen()))));
						orderItem.setBaseCommission(String.valueOf((Double.parseDouble(orderItem.getChargeRen()))- (Double.parseDouble(orderItem.getRemitRen()))));
					}
				}
				else 
				{
					if((orderItem.getAgencyCustomerId()!="")&&(orderItem.getChargeNew()!=null || orderItem.getRemitNew()!=null || orderItem.getPercentNew()!=null)) 
					{
						orderItem.setLocalCommission(String.valueOf((Double.parseDouble(orderItem.getGrossLocalAmount())-Double.parseDouble(orderItem.getNetLocalAmount()))));
						orderItem.setBaseCommission(String.valueOf((Double.parseDouble(orderItem.getGrossBaseAmount())- Double.parseDouble(orderItem.getNetBaseAmount()))));					
						orderItem.setLocalAmount(String.valueOf((Double.parseDouble(orderItem.getGrossLocalAmount())-Double.parseDouble(orderItem.getLocalCommission()))- Double.parseDouble(orderItem.getTotalTaxLocalAmount())));
						orderItem.setBaseAmount(String.valueOf(((Double.parseDouble(orderItem.getGrossBaseAmount())-
						Double.parseDouble(orderItem.getBaseCommission()))- Double.parseDouble(orderItem.getTotalTaxLocalAmount())) * (Double.parseDouble(orderItem.getExchangeRate()))));
				    }
			    }
//	            @Alok
//				if(orderItemType==0) {
//					orderItem.setLocalAmount(orderItemMap.get("localAmount1")!=null ?orderItemMap.get("localAmount1").toString():"");
//					orderItem.setBaseAmount(orderItemMap.get("baseAmount1")!=null ?orderItemMap.get("baseAmount1").toString():"");
//				}
				orderItem.setDeliveryMethod(orderItemMap.get("delivery_method")!=null?orderItemMap.get("delivery_method").toString():null);
				orderItem.setDeliverydisc(orderItemMap.get("delivery_method_description")!=null?orderItemMap.get("delivery_method_description").toString():null);
				orderItem.setDistributionMethod(orderItemMap.get("distribution_method")!=null?orderItemMap.get("distribution_method").toString():null);
//				orderItem.setAudited(Integer.parseInt(orderItemMap.get("audited").toString()));
//				orderItem.setQP(Integer.parseInt(orderItemMap.get("qp").toString()));
//				orderItem.setQF(Integer.parseInt(orderItemMap.get("qf").toString()));
//				orderItem.setNQP(Integer.parseInt(orderItemMap.get("nqp").toString()));
//				orderItem.setNQF(Integer.parseInt(orderItemMap.get("nqf").toString()));
				orderItem.setAudited(orderItemMap.get("audited")!=null?Integer.parseInt(orderItemMap.get("audited").toString()):0);
				orderItem.setAudited(orderItemMap.get("qp")!=null?Integer.parseInt(orderItemMap.get("qp").toString()):0);
				orderItem.setAudited(orderItemMap.get("qf")!=null?Integer.parseInt(orderItemMap.get("qf").toString()):0);
				orderItem.setAudited(orderItemMap.get("nqp")!=null?Integer.parseInt(orderItemMap.get("nqp").toString()):0);
				orderItem.setAudited(orderItemMap.get("nqf")!=null?Integer.parseInt(orderItemMap.get("nqf").toString()):0);
			}				
			LOGGER.info("orderItem : "+orderItem);
		}catch(Exception e)
		{
			LOGGER.info("customerOrderEdit : "+e);
			e.printStackTrace();
		}
		return orderItem;
	}

	
	@Override
	public List<Map<String, Object>> getDeliveryMethodList() {
		List<Map<String, Object>> deliveryMethodList = new ArrayList<Map<String, Object>>();
		Map<String, String> deliveryMethod = new LinkedHashMap<String, String>();
		try{			
			deliveryMethodList = jdbcTemplate.queryForList("select delivery_method,description from delivery_method");
			
			/*for(Map<String,Object> map:deliveryMethodList ){
				deliveryMethod.put(map.get("delivery_method").toString(), map.get("delivery_method").toString()+" : "+map.get("description").toString());
			}*/
			
		}catch(Exception e){
			LOGGER.info("getDeliveryMethodList : "+e);
		}
		return deliveryMethodList;
	}

	@Override
	public List<Map<String, Object>> getAgencyChangeData(long customerId,String agencyID) {
		List<Map<String, Object>> agencyDataQueryList = new ArrayList<Map<String, Object>>();
		try{
			String agencyChangeDataQuery = " select top 1 (case when agency_pays_tax=0 then cast(isnull(tax_rate_commodity.tax_rate,0) as decimal(10,2)) else 0 end) as tax_rate,agency.new_commission,agency.ren_commission,(case when (customer_address.fname is not null and customer_address.lname is not null) then "
								+ " (customer_address.fname + ' '+ customer_address.lname) else customer_address.company end) as contact_name,concat(customer_address.address1,customer_address.address2,customer_address.address3) as address"
								+ " from customer_address customer_address "
								+ " left join state state on state.state = customer_address.state "
								+ " left join tax_rate_commodity tax_rate_commodity on tax_rate_commodity.state =state.state or tax_rate_commodity.state = state.state_code_for_taxes "
								+ " left join order_code order_code on order_code.commodity_code = tax_rate_commodity.commodity_code "
								+ " left join agency on agency.customer_id= customer_address.customer_id "
								+ " where customer_address.customer_id = case when '"+agencyID+"'='' then '"+customerId+"'  else '"+agencyID+"'  end"
								+ " order by tax_rate_commodity.effective_date desc";
			agencyDataQueryList = jdbcTemplate.queryForList(agencyChangeDataQuery);
			
		}catch(Exception e){
			LOGGER.info("agencyDataQueryList : "+e);
		}
		return agencyDataQueryList;
	}
	
	@Override
	public List<DropdownModel> getOrderCategory() {
		List<DropdownModel> getOrderCategoryList = new ArrayList<>();
		try{
			List<Map<String,Object>> dropdownDet = jdbcTemplate.queryForList("select order_category,description from order_category ");
			for(Map<String,Object> row:dropdownDet) {
				DropdownModel model=new DropdownModel();
				model.setKey(row.get("order_category").toString());
				model.setDisplay(row.get("description").toString());
				getOrderCategoryList.add(model);
			}
			
		}catch(Exception e){
			LOGGER.info("getOrderCategoryList : "+e);
		}
		return getOrderCategoryList;
	}
	
	
	/**Updated by Sohrab for Order level Distribution*/
	@Override
	@Transactional
	public String orderUpdate(OrderItem orderItem) 
	{
		String status="";
		String productMessage="";
		String invalidDeliveryMethodMessage="";
		 Predicate<String> isNullOrEmpty = s-> (s != null && !s.equals("0")) && !s.trim().isEmpty();
		try
		{			
			StringBuilder orderUpdateQuery = new StringBuilder();
			orderUpdateQuery.append("UPDATE order_item SET order_qty = :order_qty,gross_base_amount = :gross_base_amount,"+ 
									"gross_local_amount = :gross_local_amount,net_base_amount = :net_base_amount,net_local_amount = :net_local_amount,"+
									"total_tax_local_amount = :total_tax_local_amount,total_tax_base_amount = :total_tax_base_amount,"+
									"bill_to_customer_id = :bill_to_customer_id,bill_to_customer_address_seq = :bill_to_customer_address_seq,"+ 
									"customer_address_seq = :customer_address_seq,bundle_qty = :bundle_qty,"+
									"pub_rotation_id = :pub_rotation_id,invoice_date = :invoice_date,"+ 
									"order_status = :order_status,"+"payment_status = :payment_status,currency = :currency,rate_class_id = :rate_class_id,"+
									"rate_class_effective_seq = :rate_class_effective_seq,is_proforma = :is_proforma,source_code_id = :source_code_id");
			
			if(null!=orderItem.getAgencyCustomerId())
			{				
					orderUpdateQuery.append(",agency_customer_id = :agency_customer_id");
			}
			if(null!=orderItem.getAgencyRefNbr())
			{
			    	orderUpdateQuery.append(",agent_ref_nbr = :agent_ref_nbr");
			}
			if(null!=orderItem.getOrderCategory())
			{				
			        orderUpdateQuery.append(",order_category = :order_category");
				
			}                               
			if(orderItem.getOrderItemType()==0) 
			{
				orderUpdateQuery.append(",start_date = :start_date,expire_date = :expire_date,stop_issue_id = :stop_issue_id, n_issues_left = :n_issues_left ,duration = :duration");
				orderUpdateQuery.append(",subscription_def_id = :subscription_def_id,renew_to_customer_id = :renew_to_customer_id,renew_to_customer_address_seq = :renew_to_customer_address_seq");
				orderUpdateQuery.append(",delivery_method = :delivery_method,distribution_method = :distribution_method,mru_suspension_seq = :mru_suspension_seq");
			}
			if(orderItem.getOrderItemType()==1)
			{
				orderUpdateQuery.append(",single_issue_id=:single_issue_id,start_date = :start_date,delivery_method = :delivery_method");
			}
			if(orderItem.getOrderItemType()==2)
			{
				orderUpdateQuery.append(",product_id =:product_id,delivery_method = :delivery_method");
			}
			double tax= 0.0;
			if(orderItem.getTotalTaxLocalAmount() != null || orderItem.getTotalTaxLocalAmount().equals("null") || orderItem.getTotalTaxLocalAmount().trim().length() > 0) 
			{
				tax= Double.parseDouble(orderItem.getTotalTaxLocalAmount());
			}
			if(tax == 0.0) 
			{
				orderUpdateQuery.append(", has_tax = 0");
			}else 
			{
				orderUpdateQuery.append(", has_tax = 1");
			}
			orderUpdateQuery.append(" where orderhdr_id = "+orderItem.getOrderhdrId()+" and order_item_seq="+orderItem.getOrderItemSeq());
            if (orderItem.getOrderItemType() == 0 && orderItem.getSubscripStartType() == 6) 
            {
				int editTrailId = jdbcTemplate.queryForObject("select * from mru_edit_trail_id", Integer.class);
				editTrailId = +2;
				jdbcTemplate.update("set nocount on if not exists (select 1 from information_schema.tables where table_name = 'mru_edit_trail_id') "
								+ "begin create table mru_edit_trail_id (id int) insert mru_edit_trail_id (id) values (2) end else update mru_edit_trail_id"
								+ " with (TABLOCKX) set id =" + editTrailId);

//				int journalId = jdbcTemplate.queryForObject("select id from mru_edit_trail_id with (TABLOCKX)",Integer.class);
//				journalId = +1;
				long journalId = customerUtility.getMaxJournalId() + 1;
				jdbcTemplate.update("set nocount on if not exists (select 1 from information_schema.tables where table_name = 'mru_journal_id') begin create"
								+ "  table mru_journal_id (id int) insert mru_journal_id (id) values (1) end else update mru_journal_id with (TABLOCKX)"
								+ "  set id =" + journalId);

				orderUpdateQuery.append("  insert into journal(journal_id,date_stamp,orderhdr_id,order_item_seq,posting_reference,tax_amount,net_amount,del_amount,com_amount,"
								+ "debit_account,qty_debit_account,credit_account,qty_credit_account,qty,bndl_qty) values (= :journal_id,= :date_stamp,= :orderhdr_id,= :order_item_seq,= :posting_reference,= :tax_amount,= :net_amount,= :del_amount,= :com_amount,"
								+ " = :debit_account,= :qty_debit_account,= :credit_account,= :qty_credit_account,= : qty,bndl_qty)");
			}
            
			if(tax == 0.0) 
			{
				orderUpdateQuery.append(" update order_item_amt_break set local_amount= :localAmount,base_amount= :baseAmount where orderhdr_id="+orderItem.getOrderhdrId()+" and order_item_seq="+orderItem.getOrderItemSeq()+" and order_item_amt_break_seq=1 ");
			}else 
			{
				orderUpdateQuery.append(" update order_item_amt_break set local_amount= :localAmount,base_amount= :baseAmount where orderhdr_id="+orderItem.getOrderhdrId()+" and order_item_seq="+orderItem.getOrderItemSeq()+" and order_item_amt_break_seq=1 ");
				orderUpdateQuery.append(" update order_item_amt_break set local_amount= :total_tax_local_amount,base_amount= :total_tax_base_amount where orderhdr_id="+orderItem.getOrderhdrId()+" and order_item_seq="+orderItem.getOrderItemSeq()+" and order_item_amt_break_seq=2");
			}
			if(orderItem.getOrderItemType()==1) {
				orderUpdateQuery.append(" update order_item_sgl_issues set order_qty= :order_qty where orderhdr_id="+orderItem.getOrderhdrId()+"  and order_item_seq="+orderItem.getOrderItemSeq()+" and order_item_sgl_issues_seq=1 ");	
			}
			if(orderItem.getOrderItemType()==0) {
				orderUpdateQuery.append(" update subscrip set n_total_issues_left=:n_total_issues_left,stop_issue_id=:stop_issue_id where subscrip_id="+orderItem.getSubscripId()+" " );	
			}
			
			Map<String, Object> parameter = new HashMap<String, Object>();		
			if(orderItem.getOrderItemType()==1) 
			{
				parameter.put("order_qty", String.valueOf(orderItem.getBundleQty()));
			}else 
			{
				parameter.put("order_qty", String.valueOf(orderItem.getOrigOrderQty()));	
			}	
			if(isNullOrEmpty.test(orderItem.getExtendedRate())) {
                orderUpdateQuery.append(",extended_rate=:extended_rate "); 
    			parameter.put("extended_rate", getAmountValue(orderItem.getExtendedRate()));
             } 
			if(isNullOrEmpty.test(String.valueOf(orderItem.getAltShipCustomerId()))) {
                orderUpdateQuery.append(",alt_ship_customer_id=:alt_ship_customer_id "); 
    			parameter.put("alt_ship_customer_id", getAmountValue(String.valueOf(orderItem.getAltShipCustomerId())));
             } 
			if(isNullOrEmpty.test(String.valueOf(orderItem.getAltShipCustomerAddressSeq()))) {
                orderUpdateQuery.append(",alt_ship_customer_address_seq=:alt_ship_customer_address_seq "); 
    			parameter.put("alt_ship_customer_address_seq", getAmountValue(String.valueOf(orderItem.getAltShipCustomerAddressSeq())));
             } 
			parameter.put("gross_base_amount", getAmountValue(orderItem.getGrossBaseAmount()));
			parameter.put("local_amount", getAmountValue(orderItem.getLocalAmount()));
			parameter.put("base_amount", getAmountValue(orderItem.getBaseAmount()));
			parameter.put("gross_local_amount", getAmountValue(orderItem.getGrossLocalAmount()));
			parameter.put("net_base_amount", getAmountValue(orderItem.getNetBaseAmount()));
			parameter.put("net_local_amount", getAmountValue(orderItem.getNetLocalAmount()));
			parameter.put("total_tax_local_amount", getAmountValue(orderItem.getTotalTaxLocalAmount()));
			parameter.put("total_tax_base_amount", getAmountValue(orderItem.getTotalTaxBaseAmount()));
			parameter.put("bill_to_customer_id",String.valueOf(orderItem.getBillToCustomerId()));
			parameter.put("bill_to_customer_address_seq",String.valueOf(orderItem.getBillToCustomerAddressSeq()));
			parameter.put("customer_address_seq",String.valueOf(orderItem.getCustomerAddressSeq()));
			parameter.put("bundle_qty", String.valueOf(orderItem.getBundleQty()));
			parameter.put("pub_rotation_id", orderItem.getRotation()!=0?String.valueOf(orderItem.getRotation()):null);
			parameter.put("invoice_date", String.valueOf(orderItem.getInvoiceDate()));
			if(null!=orderItem.getAgencyCustomerId())
			{
				
					parameter.put("agency_customer_id",orderItem.getAgencyCustomerId()!=""? String.valueOf(orderItem.getAgencyCustomerId()):null);
			}
			
			if(null!=orderItem.getAgencyRefNbr())
			{
				
					parameter.put("agent_ref_nbr", orderItem.getAgencyRefNbr()!=""?String.valueOf(orderItem.getAgencyRefNbr()):null);
				
			}
			if(null!=orderItem.getOrderCategory())
			{
					parameter.put("order_category",orderItem.getOrderCategory()!=""?String.valueOf(orderItem.getOrderCategory()):null);
				
			}
			if(orderItem.getOrderItemType()==2)
			{
				if(null!=orderItem.getProduct())
				{
					if("null".equalsIgnoreCase(orderItem.getProduct().trim()))
					{
						productMessage="product parameter should not be 'null'.";
					}else
					{
						if(!"".equals(orderItem.getProduct().trim()))
						{
							int isProduct_idExists = jdbcTemplate.queryForObject("Select COUNT(*) from product where product='"+orderItem.getProduct().trim()+"';", Integer.class);
							if(isProduct_idExists>0)
							{
								int product_id = jdbcTemplate.queryForObject("Select product_id from product where product='"+orderItem.getProduct().trim()+"';", Integer.class);
								parameter.put("product_id",String.valueOf(product_id));
							}else
							{
								productMessage="product (parameter value) is not valid. Please take the valid product (parameter value).";
							}
						}else
						{
							productMessage="product (parameter value) should not be empty.";
						}
					}
				}else
				{
					productMessage="product (parameter value) should not be null.";
				}
			}
			parameter.put("payment_status", String.valueOf(orderItem.getPaymentStatus()));
			parameter.put("currency", orderItem.getCurrency());
			parameter.put("rate_class_id", String.valueOf(orderItem.getRateClassId()));
			if(orderItem.getRateClassEffectiveSeq()==0) 
			{
				parameter.put("rate_class_effective_seq",null);
			}
			else 
			{
				parameter.put("rate_class_effective_seq",String.valueOf(orderItem.getRateClassEffectiveSeq()));
			}
			
			if(orderItem.getManualDiscAmtLocal()!=0.0) {
				orderUpdateQuery.append(",manual_disc_amt_local=:manual_disc_amt_local "); 
				parameter.put("manual_disc_amt_local", getAmountValue(String.valueOf(orderItem.getManualDiscAmtLocal())));
             } 
			if(orderItem.getManualDiscAmtBase()!=0.0) {
				orderUpdateQuery.append(",manual_disc_amt_base=:manual_disc_amt_base "); 
				parameter.put("manual_disc_amt_base", getAmountValue(String.valueOf(orderItem.getManualDiscAmtBase())));
             } 
			if(orderItem.getManualDiscPercentage()!=0.0) {
				orderUpdateQuery.append(",manual_disc_percentage=:manual_disc_percentage "); 
				parameter.put("manual_disc_percentage", getAmountValue(String.valueOf(orderItem.getManualDiscPercentage())));
             } 
			String dsn=new PropertyUtilityClass().getQuery("dsn");
			if(dsn.equals("ucp_cs_web1")) 
			{
				int rateCardSeq=jdbcTemplate.queryForObject("select top 1 ratecard_seq from ratecard where rate_class_id="+orderItem.getRateClassId()+" and rate_class_effective_seq="+orderItem.getRateClassEffectiveSeq()+"", Integer.class);
				parameter.put("ratecard_seq", String.valueOf(rateCardSeq));
			}
			parameter.put("is_proforma",String.valueOf(orderItem.getIsProforma()));
			parameter.put("source_code_id", String.valueOf(orderItem.getSourceCodeID()));		   
			parameter.put("localAmount", getAmountValue(orderItem.getLocalAmount()));
			parameter.put("baseAmount", getAmountValue(orderItem.getBaseAmount()));
			if(orderItem.getOrderItemType()==1) {
				parameter.put("start_date", String.valueOf(orderItem.getStartDate()));
				if(isNullOrEmpty.test(String.valueOf(orderItem.getStartIssueId()))) {
	                orderUpdateQuery.append(",start_issue_id=:start_issue_id "); 
	    			parameter.put("start_issue_id",Integer.parseInt(orderItem.getStartIssueId())!=0?String.valueOf(orderItem.getStartIssueId()):null);
	             } 
				parameter.put("single_issue_id", String.valueOf(orderItem.getStartIssueId()));
				}
			if(orderItem.getOrderItemType()==0) 
			{
				parameter.put("start_date", String.valueOf(orderItem.getStartDate()));
				parameter.put("expire_date", "".equals(orderItem.getExpireDate())?null:String.valueOf(orderItem.getExpireDate()));
				if(orderItem.getCurrIssueId().equals("") || orderItem.getCurrIssueId()=="") 
				{

					parameter.put("agency_customer_id",orderItem.getAgencyCustomerId()!=""? String.valueOf(orderItem.getAgencyCustomerId()):null);
					
					if(isNullOrEmpty.test(String.valueOf(orderItem.getStartIssueId()))) {
		                orderUpdateQuery.append(",start_issue_id=:start_issue_id "); 
		    			parameter.put("start_issue_id",Integer.parseInt(orderItem.getStartIssueId())!=0?String.valueOf(orderItem.getStartIssueId()):null);
		             } 
					parameter.put("stop_issue_id",orderItem.getStopIssueId()!=0?String.valueOf(orderItem.getStopIssueId()):null);
				}
				else 
				{
					if(isNullOrEmpty.test(String.valueOf(orderItem.getStartIssueId()))) {
		                orderUpdateQuery.append(",start_issue_id=:start_issue_id "); 
						parameter.put("start_issue_id", String.valueOf(orderItem.getCurrIssueId())!=null? String.valueOf(orderItem.getCurrIssueId()):null);
		             } 
					parameter.put("stop_issue_id",String.valueOf(Integer.parseInt(orderItem.getCurrIssueId())-1 + (Integer.parseInt(orderItem.getnIssueLeft()))));
				}
				parameter.put("n_issues_left", orderItem.getnIssueLeft()!=null? orderItem.getnIssueLeft():null);
				parameter.put("n_total_issues_left",orderItem.getnIssueLeft()!=null?orderItem.getnIssueLeft():0);
				if(isNullOrEmpty.test(String.valueOf(orderItem.getnIssueLeft()))) {
					orderUpdateQuery.append(",n_remaining_paid_issues=:n_remaining_paid_issues ");
					parameter.put("n_remaining_paid_issues",orderItem.getnIssueLeft());
	             } 
				parameter.put("order_qty", orderItem.getnIssueLeft());
				parameter.put("subscription_def_id",String.valueOf(orderItem.getSubscriptionDefId()));
				parameter.put("renew_to_customer_id",String.valueOf(orderItem.getRenewToCustomerId()));
				parameter.put("renew_to_customer_address_seq",String.valueOf(orderItem.getRenewToCustomerAddressSeq()));
				if(isNullOrEmpty.test(String.valueOf(orderItem.getExtIssleft()))) {
					orderUpdateQuery.append(",ext_iss_left=:ext_iss_left ");
					parameter.put("ext_iss_left", String.valueOf(orderItem.getExtIssleft()));
	             } 
				if(isNullOrEmpty.test(String.valueOf(orderItem.getPercentOfBasicPrice()))) {
					orderUpdateQuery.append(",percent_of_basic_price=:percent_of_basic_price ");
					parameter.put("percent_of_basic_price", orderItem.getPercentOfBasicPrice());
	             } 				
				if(orderItem.getPageName().equals("Date Based Subscription")) {
					parameter.put("duration", orderItem.getDuration());	
				}else{
					parameter.put("duration", orderItem.getnIssueLeft());
				}
			}
			//Updated by Sohrab for Order level Distribution
			if(orderItem.getOrderItemType()==1 || orderItem.getOrderItemType()==2)
			{
				if(null!=orderItem.getDeliveryMethod())
				{
					if(!"".equals(orderItem.getDeliveryMethod().trim()) && !"null".equalsIgnoreCase(orderItem.getDeliveryMethod().trim()))
					{
						parameter.put("delivery_method", orderItem.getDeliveryMethod().trim());
					}else
					{
						parameter.put("delivery_method", null);
					}	
				}else
				{
					parameter.put("delivery_method", null);
				}	
			}
			if(orderItem.getOrderItemType()==0)
			{
				int mru_suspension_seq_int=0,isAnydeliveryMethodExists=0,isChosenDeliveryMethodSameAsExistingOneInDB=0,isAnyCustomerDistributionValueExists=0;
				int isCustomerDistributionRelatedToChosenDeliveryMethodExists=0,deleteDistributionRelatedToChosenDeliveryMethodStatus=0;
				String mru_suspension_seq_query="SELECT mru_suspension_seq FROM order_item WHERE customer_id="+orderItem.getCustomerId()+" AND orderhdr_id="+orderItem.getOrderhdrId()+" AND subscrip_id='"+orderItem.getSubscripId().trim()+"' AND order_item_seq="+orderItem.getOrderItemSeq()+";";
				String mru_suspension_seq = jdbcTemplate.queryForObject(mru_suspension_seq_query, String.class);
				if(null!=mru_suspension_seq)
				{
					if(!"".equals(mru_suspension_seq.trim()) && !"null".equalsIgnoreCase(mru_suspension_seq.trim()))
					{
						mru_suspension_seq_int=Integer.parseInt(mru_suspension_seq.trim());
					}
				} 
				String order_status=null;           //"0"; This is altime updating wrong status as 0 means orderPlaced so only declaration needed
				if(null!=orderItem.getDeliveryMethod())
				{
					if(!"".equals(orderItem.getDeliveryMethod().trim()) && !"null".equalsIgnoreCase(orderItem.getDeliveryMethod().trim()))
					{
						parameter.put("delivery_method", orderItem.getDeliveryMethod().trim());
						parameter.put("distribution_method", orderItem.getDeliveryMethod().trim());
						
						String isChosenDeliveryMethodSameAsExistingOneInDBQuery="SELECT COUNT(*) FROM order_item WHERE customer_id = "+orderItem.getCustomerId()+" AND orderhdr_id = "+orderItem.getOrderhdrId()+" AND subscrip_id='"+orderItem.getSubscripId().trim()+"' AND delivery_method ='"+orderItem.getDeliveryMethod().trim()+"' AND order_item_seq="+orderItem.getOrderItemSeq()+";";
						isChosenDeliveryMethodSameAsExistingOneInDB = jdbcTemplate.queryForObject(isChosenDeliveryMethodSameAsExistingOneInDBQuery, Integer.class);
						
						String isCustomerDistributionRelatedToChosenDeliveryMethodExistsQuery="SELECT COUNT(*) FROM customer_address_dist WHERE customer_address_seq=1 AND customer_id = "+orderItem.getCustomerId()+" AND distribution_method = '"+orderItem.getDeliveryMethod().trim()+"';";
						isCustomerDistributionRelatedToChosenDeliveryMethodExists = jdbcTemplate.queryForObject(isCustomerDistributionRelatedToChosenDeliveryMethodExistsQuery, Integer.class);
						
						String isAnydeliveryMethodExistsQuery="SELECT COUNT(*) FROM order_item WHERE customer_id = "+orderItem.getCustomerId()+" AND orderhdr_id = "+orderItem.getOrderhdrId()+" AND subscrip_id='"+orderItem.getSubscripId().trim()+"' AND delivery_method is not null AND distribution_method is not null AND order_item_seq="+orderItem.getOrderItemSeq()+";";
						isAnydeliveryMethodExists = jdbcTemplate.queryForObject(isAnydeliveryMethodExistsQuery, Integer.class);
						
						String isAnyCustomerDistributionValueExistsQuery="SELECT COUNT(*) FROM customer_address_dist WHERE customer_id = "+orderItem.getCustomerId()+" AND customer_address_seq=1;";
						isAnyCustomerDistributionValueExists = jdbcTemplate.queryForObject(isAnyCustomerDistributionValueExistsQuery, Integer.class);

						if(isAnydeliveryMethodExists==0)
						{
							System.out.println("There is no Delivery Method.");
						}else
						{
							System.out.println("Delivery Method is available.");
							if(isChosenDeliveryMethodSameAsExistingOneInDB==0)
							{
								System.out.println("No, chosen Delivery Method (parameter value) is not same As existing one in DB.");
								if(isCustomerDistributionRelatedToChosenDeliveryMethodExists>0)
								{
									System.out.println("Yes, Customer Distribution Value related to chosen Delivery Method exists in DB.");
									String deleteDistributionRelatedToChosenDeliveryMethodQuery="DELETE FROM customer_address_dist WHERE customer_address_seq=1 AND customer_id = "+orderItem.getCustomerId()+" AND distribution_method = '"+orderItem.getDeliveryMethod().trim()+"';";
									deleteDistributionRelatedToChosenDeliveryMethodStatus=jdbcTemplate.update(deleteDistributionRelatedToChosenDeliveryMethodQuery);
									if(deleteDistributionRelatedToChosenDeliveryMethodStatus>0)
									{
										LOGGER.info("All "+orderItem.getDeliveryMethod().trim()+" related Distribution for Customer's Address Values Deleted.");
										String isAnyCustomerDistributionValueExistsAfterDeletionQuery="SELECT COUNT(*) FROM customer_address_dist WHERE customer_id = "+orderItem.getCustomerId()+" AND customer_address_seq=1;";
										int isAnyCustomerDistributionValueExistsAfterDeletion = jdbcTemplate.queryForObject(isAnyCustomerDistributionValueExistsAfterDeletionQuery, Integer.class);
										if(isAnyCustomerDistributionValueExistsAfterDeletion==0)
										{
											System.out.println("customer_address_dist table is empty.");
											order_status="0";
										}else
										{
											System.out.println("There are values in customer_address_dist table.");
											order_status="12";
										}
									}
								}else
								{
									System.out.println("No, Customer Distribution Value related to chosen Delivery Method does not exist in DB.");
									order_status="0";
								}
							}else
							{
								System.out.println("YES, chosen Delivery Method (parameter value) is same As existing one in DB.");
							}
						}
						/** ------for Customer Distribution Values ----- */
						if(null!=orderItem.getCustomerDistributionValues())
						{
							int isCustomerDistributionMethodExists=0,isCustomerDistributionValueExists=0,insertcustomerDistributionValueStatus=0;
							if(!"".equals(orderItem.getCustomerDistributionValues().trim()))
							{
								String[]customerDistributionValuesArray=orderItem.getCustomerDistributionValues().trim().split(",");
								for(int i=0;i<customerDistributionValuesArray.length;i++)
								{
									String[]subArray=customerDistributionValuesArray[i].split(":");
									String distribution_method=null,distribution_attribute=null,dist_attribute_value=null;
									if(null!=subArray[0])
									{
										if(!"".equals(subArray[0].trim()) && !"null".equalsIgnoreCase(subArray[0].trim()))
										{
											distribution_method="'"+subArray[0].trim()+"'";
										}
									}
									if(null!=subArray[1])
									{
										if(!"".equals(subArray[1].trim()) && !"null".equalsIgnoreCase(subArray[1].trim()))
										{
											distribution_attribute="'"+subArray[1].trim()+"'";
										}
									}
									if(null!=subArray[2])
									{
										if(!"".equals(subArray[2].trim()) && !"null".equalsIgnoreCase(subArray[2].trim()))
										{
											dist_attribute_value="'"+subArray[2].trim()+"'";
										}
									}
									String isCustomerDistributionMethodExistsQuery="SELECT COUNT(*) FROM customer_address_dist WHERE customer_address_seq=1 AND customer_id = "+orderItem.getCustomerId()+" AND distribution_method = "+distribution_method+";";
									isCustomerDistributionMethodExists = jdbcTemplate.queryForObject(isCustomerDistributionMethodExistsQuery, Integer.class);
									
									String isCustomerDistributionValueExistQuery="SELECT COUNT(*) FROM customer_address_dist WHERE customer_address_seq=1 AND customer_id = "+orderItem.getCustomerId()+" AND distribution_method = "+distribution_method+" AND distribution_attribute="+distribution_attribute+";";
									isCustomerDistributionValueExists = jdbcTemplate.queryForObject(isCustomerDistributionValueExistQuery, Integer.class);
									if(isCustomerDistributionValueExists==0)
									{
										System.out.println("No, chosen Customer Distribution Value (parameter value) does not exist in DB.");
										String insertcustomerDistributionValueQuery="Insert into customer_address_dist(customer_id,customer_address_seq,distribution_method,distribution_attribute,dist_attribute_value)VALUES("+orderItem.getCustomerId()+",1,"+distribution_method+","+distribution_attribute+","+dist_attribute_value+");";
										insertcustomerDistributionValueStatus=jdbcTemplate.update(insertcustomerDistributionValueQuery);
										if(insertcustomerDistributionValueStatus>0)
										{
											LOGGER.info("Customer Distribution Values Inserted.");
											order_status="12";
											if(isCustomerDistributionRelatedToChosenDeliveryMethodExists==0 && isCustomerDistributionMethodExists==0)
											{
												mru_suspension_seq_int++;
											}
										}
									}else
									{
										System.out.println("Yes, chosen Customer Distribution Value (parameter value) already exists in DB.");
									}
								}
							}
						}
					}
					else
					{
						parameter.put("delivery_method", null);
						parameter.put("distribution_method", null);
					}
				}else
				{
					parameter.put("delivery_method", null);
					parameter.put("distribution_method", null);
				}
				parameter.put("order_status", order_status!=null?order_status : String.valueOf(orderItem.getOrderStatus()));
				if(null!=mru_suspension_seq)
				{
					if(!"".equals(mru_suspension_seq.trim()) && !"null".equalsIgnoreCase(mru_suspension_seq.trim()))
					{
						parameter.put("mru_suspension_seq", String.valueOf(mru_suspension_seq_int));
					}
				}else 
					if(mru_suspension_seq==null && order_status==null) {
						
						parameter.put("mru_suspension_seq", mru_suspension_seq);
						
				}
					else if(order_status!=null && order_status.equals("12"))
				{
					parameter.put("mru_suspension_seq", String.valueOf(mru_suspension_seq_int));
				}
				else
				{
					parameter.put("mru_suspension_seq", mru_suspension_seq);
				}
			}else
			{
				parameter.put("order_status", String.valueOf(orderItem.getOrderStatus()));
			}
			if(null!=orderItem.getDeliveryMethod())
			{
				if(!"".equals(orderItem.getDeliveryMethod().trim()) && !"null".equalsIgnoreCase(orderItem.getDeliveryMethod().trim()))
				{
					if(!orderItem.getDeliveryMethod().equals("Ranges") && orderItem.getDeliveryMethod().equals("City"))
					{
						invalidDeliveryMethodMessage="";
					}
					else if(!orderItem.getDeliveryMethod().equals("City") && orderItem.getDeliveryMethod().equals("Ranges"))
					{
						invalidDeliveryMethodMessage="";
					}
					else
					{
						invalidDeliveryMethodMessage="Delivery Method (parameter value) does not exist. Please take City or Ranges. It is case sensitive.";
					}
				}
				else
				{
					invalidDeliveryMethodMessage="";
				}
			}else
			{
				invalidDeliveryMethodMessage="";
			}
			if(!invalidDeliveryMethodMessage.equals(""))
			{
				status="Order Not updated"+". "+invalidDeliveryMethodMessage;
			}
			if(orderItem.getOrderItemType()==2 && !productMessage.equals("") && invalidDeliveryMethodMessage.equals(""))
			{
				status="Order Not updated"+". "+productMessage;
			}
			else if(orderItem.getOrderItemType()==2 && !productMessage.equals("") && !invalidDeliveryMethodMessage.equals(""))
			{
				status=status+" "+productMessage;
			}
			if(!status.contains("Order Not updated"))
			{
				status = "Order updated successfully.";
				namedParameterJdbcTemplate.update(orderUpdateQuery.toString(), parameter);
			}
			if(status.contains("Order Not updated"))
			{
				LOGGER.info("Order Not updated.");
			}
			if(orderItem.getCurrIssueId()!=null && orderItem.getCurrIssueId()!="" && !orderItem.getCurrIssueId().isEmpty()) 
			{
				Map<String, Object> addParams = new HashMap<>(); 
				String query="select distinct CONVERT(varchar,issue_date,101)as issue_date,issue_id from issue where issue_id between "+orderItem.getCurrIssueId()+"  and "+(Integer.parseInt(orderItem.getStartIssueId())-1)+"";
				List<Map<String, Object>> backIssueList = null;  String addQuery=null;
				backIssueList = jdbcTemplate.queryForList(query.toString());
				jdbcTemplate.update("delete from back_issue where subscrip_id="+ orderItem.getSubscripId()+"");
				for(int i=0;i<backIssueList.size();i++) 
				{
					addQuery="insert into back_issue(subscrip_id,issue_id,qty_ordered,qty_sent,status,reason) values(:subscrip_id,:issue_id,:qty_ordered,:qty_sent,:status,:reason)";
					addParams.put("subscrip_id", orderItem.getSubscripId());
					addParams.put("issue_id", backIssueList.get(i).get("issue_id"));
					addParams.put("qty_ordered", 1);
					addParams.put("qty_sent", 0);
					addParams.put("status", 0);
					addParams.put("reason", 0);
					namedParameterJdbcTemplate.update(addQuery, addParams);
				}
			}
		}catch(Exception e)
		{
			LOGGER.info("orderUpdate = "+e);
			e.printStackTrace();
		}
		return status;
	}
	
//	public Double getAmountValue(String value) {
//		return  value!=null && !value.equals("")?Double.valueOf(value):0.0;
//	}
	public BigDecimal getAmountValue(String value) {
		return  value!=null && !value.equals("")?BigDecimal.valueOf(Double.valueOf(value)):null;
	}

	@Override
	public List<Map<String, Object>> customerAddressDetail(long customerId) {		
		List<Map<String, Object>> customerAddress=null;
		try{
			customerAddress = jdbcTemplate.queryForList("SELECT customer_id, customer_address_seq, state, city, zip, address1, address_type, phone FROM customer_address WHERE customer_id="+customerId+" ORDER BY customer_id,customer_address_seq");
			
		}catch(Exception e){
			LOGGER.info("customerAddressDetail = "+e);
		}
		return customerAddress;
	}

	@Override
	public List<Map<String, Object>> getCustomerDetails(String customerId) {
		 List<Map<String, Object>> customerDetails=null;		 
		try{
			StringBuilder query=new StringBuilder();
			query.append("SELECT DISTINCT customer_address.* FROM customer_address, (select top 100 customer_address.customer_id from customer,"
						+ " customer_address where (customer.inactive = 0 OR customer.inactive is NULL)"
						+ " AND customer.customer_id = customer_address.customer_id ORDER BY customer_address.customer_id desc) as customer  WHERE");
			
			if(!"All".equals(customerId)){
				query.append(" customer.customer_id = " +customerId + " AND ");
			}			
			query.append(" customer.customer_id = customer_address.customer_id ORDER BY customer_address.customer_id desc");
			
			customerDetails = jdbcTemplate.queryForList(query.toString());
			
			
		}catch(Exception e){
			LOGGER.info("getCustomerDetails = "+e);
		}
		return customerDetails;
	}
	
	@Override
	public List<Map<String, Object>> getAddressDetails(String customerId, int orderCodeId,int orderItemType) {
		 List<Map<String, Object>> addressDetails=null;		 
		try{
			StringBuilder query=new StringBuilder();
			query.append("SELECT distinct c.*,tax_rate_commodity.effective_date, case when (special_tax_id!=0) then 0 else  tax_rate_commodity.tax_rate end as tax_rate " 
					+ " FROM customer_address c left join customer on customer.customer_id=c.customer_id"  
					+ " left join state state on state.state=c.state" 
					+ " left  join tax_rate_commodity tax_rate_commodity on ((state.state=tax_rate_commodity.state or tax_rate_commodity.state is null) or (tax_rate_commodity.state = state.state_code_for_taxes))" 
					+ " and tax_rate_commodity.effective_date=((select max( tax_rate_commodity.effective_date) from tax_rate_commodity)) or tax_rate_commodity.effective_date is null "
					+ " left  join order_code order_code on ((order_code.commodity_code = tax_rate_commodity.commodity_code)or (tax_rate_commodity.commodity_code is null)) " );
					if(orderItemType==4) {
						query.append(" WHERE  (customer.inactive = 0 OR customer.inactive is NULL) and  c.customer_id = "+customerId+" and  order_code.order_code_id in (select item_order_code_id from pkg_content where order_code_id="+orderCodeId+")");	
					}else {
						query.append(" WHERE  (customer.inactive = 0 OR customer.inactive is NULL) and  c.customer_id = "+customerId+" and  order_code.order_code_id ="+orderCodeId+"");
					}					  
					query.append(" ORDER BY c.customer_id , tax_rate_commodity.effective_date desc");
								
			addressDetails = jdbcTemplate.queryForList(query.toString());
						
		}catch(Exception e){
			LOGGER.info("getCustomerDetails = "+e);
		}
		return addressDetails;
	}
	
	public void subscrip(OrderItem orderItem){
		
		String issueIdQuery = "select top 1 issue.issue_id from order_code left join issue issue on order_code.oc_id = issue.oc_id where order_code_id = ?";		
		Long issueId = (Long)jdbcTemplate.queryForObject(issueIdQuery, new Object[] { orderItem.getOrderCodeID() }, Long.class);
		
		String totalIssueQuery = "select top 1 term.n_issues from order_code order_code left join term term on order_code.term_id = term.term_id where order_code_id = ?";		
		Long totalIssue = (Long)jdbcTemplate.queryForObject(totalIssueQuery, new Object[] { orderItem.getOrderCodeID() }, Long.class);
		
		String subscripQuery = "insert into subscrip (subscrip_id,oc_id,customer_id,source_code_id,orig_order_date,audit_name_change,"
						+ " audit_title_change,n_times_sub_renewed,n_total_issues_left,start_issue_id,stop_issue_id,mru_additions_deletions_seq) "
						+ " values (:subscrip_id, :oc_id, :customer_id, :source_code_id, GETDATE(), :audit_name_change,"
						+ " :audit_title_change, :n_times_sub_renewed, :n_total_issues_left, :start_issue_id, :stop_issue_id, :mru_additions_deletions_seq)";
		
		Map<String, Object> subscripParameters = new HashMap<String,Object>();
		
		subscripParameters.put("subscrip_id", (jdbcTemplate.queryForObject("select max(subscrip_id) from subscrip", Long.class))+1);
		subscripParameters.put("oc_id", orderItem.getOcId());
		subscripParameters.put("customer_id", orderItem.getCustomerId());
		subscripParameters.put("source_code_id", orderItem.getSourceCodeID());		
		subscripParameters.put("audit_name_change", 0);
		subscripParameters.put("audit_title_change", 0);
		subscripParameters.put("n_times_sub_renewed", 0);
		subscripParameters.put("n_total_issues_left", totalIssue);
		subscripParameters.put("start_issue_id", issueId);
		subscripParameters.put("stop_issue_id", (issueId+totalIssue)-1);
		subscripParameters.put("mru_additions_deletions_seq", 1);
		
		namedParameterJdbcTemplate.update(subscripQuery, subscripParameters);
		
	}
	public void orderItemSaveSubscrip(long orderHdrId,OrderItem orderItem,List<Map<String, Object>> orderCodesList,CustomerDetails customerDetails,CustomerAddressModel addressModel,long effectiveSeq){
		try{
						
			String issueIdQuery = "select top 1 issue.issue_id from order_code left join issue issue on order_code.oc_id = issue.oc_id where order_code_id = ?";		
			Long issueId = (Long)jdbcTemplate.queryForObject(issueIdQuery, new Object[] { orderItem.getOrderCodeID() }, Long.class);
			
			String totalIssueQuery = "select top 1 term.n_issues from order_code order_code left join term term on order_code.term_id = term.term_id where order_code_id = ?";		
			Long totalIssue = (Long)jdbcTemplate.queryForObject(totalIssueQuery, new Object[] { orderItem.getOrderCodeID() }, Long.class);
			
			String orderItemQuery="insert into order_item (orderhdr_id,order_item_seq,user_code,currency,source_code_id,date_stamp,order_item_type,order_date,order_qty,"
					+ " gross_base_amount,gross_local_amount,net_base_amount,net_local_amount,has_tax,has_delivery_charge,bill_date,payment_status,refund_status,order_type,"
					+ " billing_type,has_premium,prepayment_req,subscrip_id,bundle_qty,is_complimentary,subscrip_start_type,order_code_id,duration,renewal_status,"
					+ " delivery_method_perm,change_qty_flag,n_issues_left,n_remaining_paid_issues,ext_iss_left,ext_iss_tot,order_status,renewal_category,exchange_rate,"
					+ " subscription_def_id,rate_class_id,rate_class_effective_seq,oc_id,auto_payment,perpetual_order,bill_to_customer_id,bill_to_customer_address_seq,"
					+ " renew_to_customer_id,renew_to_customer_address_seq,start_issue_id,stop_issue_id,customer_id,customer_address_seq,note_exist,service_exist,"
					+ " mru_order_item_amt_break_seq,has_been_renewed,revenue_method,start_date,expire_date,trial_type,orig_order_qty,unit_excess,n_nonpaid_issues,"
					+ " n_remaining_nonpaid_issues,is_proforma,n_tax_updates,total_tax_local_amount,total_tax_base_amount,electronic_delivery,time_unit_options,group_order,"
					+ " invoice_date,auto_renew_notify_sent,asynchronous_auto_renew,n_days_graced,extended_rate,is_back_ordered,mru_grp_mbr_item_dtl_seq) values ("									  
					+ " :orderhdr_id, :order_item_seq, :user_code, :currency, :source_code_id, :date_stamp, :order_item_type, GETDATE(), :order_qty, :gross_base_amount, :gross_local_amount,"
					+ " :net_base_amount, :net_local_amount, :has_tax, :has_delivery_charge, GETDATE(), :payment_status, :refund_status, :order_type, :billing_type, :has_premium, :prepayment_req,"
					+ " :subscrip_id, :bundle_qty, :is_complimentary, :subscrip_start_type, :order_code_id, :duration, :renewal_status, :delivery_method_perm, :change_qty_flag, :n_issues_left,"
					+ " :n_remaining_paid_issues, :ext_iss_left, :ext_iss_tot, :order_status, :renewal_category, :exchange_rate, :subscription_def_id, :rate_class_id, :rate_class_effective_seq,"
					+ " :oc_id, :auto_payment, :perpetual_order, :bill_to_customer_id, :bill_to_customer_address_seq, :renew_to_customer_id, :renew_to_customer_address_seq, :start_issue_id,"
					+ " :stop_issue_id, :customer_id, :customer_address_seq, :note_exist, :service_exist, :mru_order_item_amt_break_seq, :has_been_renewed, :revenue_method, GETDATE(),"
					+ " GETDATE(), :trial_type, :orig_order_qty, :unit_excess, :n_nonpaid_issues, :n_remaining_nonpaid_issues, :is_proforma, :n_tax_updates, :total_tax_local_amount,"
					+ " :total_tax_base_amount, :electronic_delivery, :time_unit_options, :group_order, GETDATE(), :auto_renew_notify_sent, :asynchronous_auto_renew, :n_days_graced,"
					+ " :extended_rate, :is_back_ordered, :mru_grp_mbr_item_dtl_seq)" ;
			
			Map<String, Object> orderItemParameters = new HashMap<String,Object>();
			
			for(Map<String, Object> orderCodeList:orderCodesList)
			{	
				orderItemParameters.put("orderhdr_id", (orderHdrId+1));
				orderItemParameters.put("order_item_seq", 1);
				orderItemParameters.put("user_code", orderCodeList.get("user_code"));
				orderItemParameters.put("currency", addressModel.getCurrency());
				orderItemParameters.put("source_code_id", orderItem.getSourceCodeID());
				orderItemParameters.put("date_stamp", 1);
				orderItemParameters.put("order_item_type", orderCodeList.get("order_code_type"));
				orderItemParameters.put("order_qty",orderItem.getOrderQty());
				orderItemParameters.put("gross_base_amount",orderItem.getAmountCharged());
				orderItemParameters.put("gross_local_amount", orderItem.getAmountCharged());
				orderItemParameters.put("net_base_amount", orderItem.getAmountCharged());
				orderItemParameters.put("net_local_amount", orderItem.getAmountCharged());
				orderItemParameters.put("has_tax",0);
				orderItemParameters.put("has_delivery_charge", 0);
				orderItemParameters.put("payment_status", 0);
				orderItemParameters.put("refund_status",0);
				orderItemParameters.put("order_type",orderItem.getOrderCodeType());
				orderItemParameters.put("billing_type",1);// 1- balance due
				orderItemParameters.put("has_premium", orderCodeList.get("premium"));
				orderItemParameters.put("prepayment_req", orderCodeList.get("prepayment_req"));
				orderItemParameters.put("subscrip_id",(jdbcTemplate.queryForObject("select max(subscrip_id) from subscrip", Long.class)));
				orderItemParameters.put("bundle_qty",1);
				orderItemParameters.put("is_complimentary",0);
				orderItemParameters.put("subscrip_start_type",0);
				orderItemParameters.put("order_code_id", orderCodeList.get("order_code_id"));
				orderItemParameters.put("duration",0);
				orderItemParameters.put("renewal_status",0);
				orderItemParameters.put("delivery_method_perm",0);
				orderItemParameters.put("change_qty_flag",0);
				orderItemParameters.put("n_issues_left", (Long)jdbcTemplate.queryForObject("select top 1 term.n_issues from order_code order_code left join term term on order_code.term_id = term.term_id where order_code_id = ?", new Object[] { orderItem.getOrderCodeID() }, Long.class));
				orderItemParameters.put("n_remaining_paid_issues",0);
				orderItemParameters.put("ext_iss_left",0);
				orderItemParameters.put("ext_iss_tot",0);
				orderItemParameters.put("order_status",0);
				orderItemParameters.put("renewal_category",0);
				orderItemParameters.put("exchange_rate",addressModel.getExchangeRate());
				orderItemParameters.put("subscription_def_id",(Long)jdbcTemplate.queryForObject("select subscription_def_id from subscription_def where order_code_id = ?",new Object[] { orderItem.getOrderCodeID() }, Long.class));
				orderItemParameters.put("rate_class_id", orderCodeList.get("newsub_rate_class_id"));
				orderItemParameters.put("rate_class_effective_seq",effectiveSeq);
				orderItemParameters.put("oc_id", orderCodeList.get("oc_id"));
				orderItemParameters.put("auto_payment", orderCodeList.get("auto_payment"));
				orderItemParameters.put("perpetual_order", orderCodeList.get("perpetual_order"));
				orderItemParameters.put("bill_to_customer_id", customerDetails.getDefaultBillToCustomerId());
				orderItemParameters.put("bill_to_customer_address_seq", customerDetails.getDefBillToCustAddrSeq());
				orderItemParameters.put("renew_to_customer_id", customerDetails.getDefaultRenewToCustomerId());
				orderItemParameters.put("renew_to_customer_address_seq", customerDetails.getDefRenewToCustAddrSeq());
				orderItemParameters.put("start_issue_id", (Long)jdbcTemplate.queryForObject("select top 1 issue.issue_id from order_code left join issue issue on order_code.oc_id = issue.oc_id where order_code_id = ?", new Object[] { orderItem.getOrderCodeID() }, Long.class));
				orderItemParameters.put("stop_issue_id", (issueId+totalIssue)-1);
				orderItemParameters.put("customer_id", orderItem.getCustomerId());
				orderItemParameters.put("customer_address_seq", 1);
				orderItemParameters.put("note_exist",0);
				orderItemParameters.put("service_exist",0);
				orderItemParameters.put("mru_order_item_amt_break_seq",1);
				orderItemParameters.put("has_been_renewed",0);				
				orderItemParameters.put("revenue_method", orderCodeList.get("revenue_method"));
				orderItemParameters.put("trial_type", orderCodeList.get("trial_type"));
				orderItemParameters.put("orig_order_qty",orderItem.getOrderQty());
				orderItemParameters.put("unit_excess", orderCodeList.get("unit_excess"));				
				orderItemParameters.put("n_nonpaid_issues", 0);
				orderItemParameters.put("n_remaining_nonpaid_issues", 0);				
				orderItemParameters.put("is_proforma", orderCodeList.get("is_proforma"));
				orderItemParameters.put("n_tax_updates",0);
				orderItemParameters.put("total_tax_local_amount","0.0000");
				orderItemParameters.put("total_tax_base_amount","0.0000");
				orderItemParameters.put("electronic_delivery", orderCodeList.get("electronic_delivery"));
				orderItemParameters.put("time_unit_options", orderCodeList.get("time_unit_options"));
				orderItemParameters.put("group_order",0);
				/*orderItemParameters.put("invoice_date",);*/
				orderItemParameters.put("auto_renew_notify_sent",0);				
				orderItemParameters.put("asynchronous_auto_renew",0);
				orderItemParameters.put("n_days_graced",0);
				orderItemParameters.put("extended_rate",0);				
				orderItemParameters.put("is_back_ordered",0);
				orderItemParameters.put("mru_grp_mbr_item_dtl_seq",0);
			}
			
			namedParameterJdbcTemplate.update(orderItemQuery, orderItemParameters);

		}catch(Exception e){
			LOGGER.info("orderItemSave : "+e);
		}		
	}
	
	public void additionsDeletionsSave(Long orderHdrId, OrderItem orderItem){
		try{
			String issueIdQuery = "select top 1 issue.issue_id from order_code left join issue issue on order_code.oc_id = issue.oc_id where order_code_id = ?";		
			Long issueId = (Long)jdbcTemplate.queryForObject(issueIdQuery, new Object[] { orderItem.getOrderCodeID() }, Long.class);
			
			String additionsDeletionsQuery = " insert into additions_deletions (subscrip_id,additions_deletions_seq,orderhdr_id,order_item_seq,issue_id,customer_id,"
											+ " n_addition_copies,n_deletion_copies,sub_add,sub_add_reason,sub_kill,sub_on,sub_on_reason,sub_off,sub_start,sub_start_reason,"
											+ " sub_stop,add_kill_status,creation_date,bundle_qty,start_stop_status) values "
											+ " (:subscrip_id, :additions_deletions_seq, :orderhdr_id, :order_item_seq, :issue_id, :customer_id, :n_addition_copies, "
											+ " :n_deletion_copies, :sub_add, :sub_add_reason, :sub_kill, :sub_on, :sub_on_reason,"
											+ " :sub_off, :sub_start, :sub_start_reason, :sub_stop, :add_kill_status, GETDATE(), :bundle_qty, :start_stop_status)";
			
			Map<String, Object> parameters = new HashMap<String,Object>();
			parameters.put("subscrip_id", (jdbcTemplate.queryForObject("select max(subscrip_id) from subscrip", Long.class)));
			parameters.put("additions_deletions_seq", 1);
			parameters.put("orderhdr_id", (orderHdrId+1));
			parameters.put("order_item_seq", 1);
			parameters.put("issue_id", issueId);
			parameters.put("customer_id", orderItem.getCustomerId());
			parameters.put("n_addition_copies", 1);
			parameters.put("n_deletion_copies", 0);
			parameters.put("sub_add", 1);
			parameters.put("sub_add_reason", 0);
			parameters.put("sub_kill", 0);
			parameters.put("sub_on", 1);
			parameters.put("sub_on_reason", 0);
			parameters.put("sub_off", 0);
			parameters.put("sub_start", 1);
			parameters.put("sub_start_reason", 0);
			parameters.put("sub_stop", 0);			
			parameters.put("add_kill_status", 0);
			parameters.put("bundle_qty", 1);
			parameters.put("start_stop_status", 0);
			
			namedParameterJdbcTemplate.update(additionsDeletionsQuery, parameters);
		}catch(Exception e){
			LOGGER.info("additionsDeletionsSave : "+e);
		}
		
	}

	@Override
	public List<IssueModel> getSubscriptionStartDate(int ocId) {
		List<IssueModel> issueModelsList = null;
		try{
			String issueQuery = "select * from view_issue_volume where oc_id = "+ocId+"";			
			issueModelsList = jdbcTemplate.query(issueQuery,new IssueMapper());
			
		}catch(Exception e){
			LOGGER.info("getSubscriptionStartDate = "+e);
		}
		return issueModelsList;
	}

	
	public List<DropdownModel> getPkgDef(String orderCodeId) {
		LOGGER.info("packageDefinitionList ");
		List<DropdownModel> pkgDefList = new ArrayList<>();
		try{
			List<Map<String,Object>> packageDefinition = 
			jdbcTemplate.queryForList("select pkg_def,pkg_def_id,description,n_calendar_units, CASE calendar_unit"
				+	" WHEN 0 THEN 'Day(s)'"
				+	" WHEN 1 THEN 'Week(s)' "
				+	" WHEN 2 THEN 'Months(s)' "
				+	" WHEN 3 THEN 'Year(s)' "
				+   " END  as calendar_unit,order_code_id,CASE subscriber_site_allowance_type "
				+   " WHEN 0 THEN 'Disallow'"  
				+	" WHEN 1 THEN 'Members Control'"  
				+	" WHEN 2 THEN 'Allow'" 
				+	" END as allowance_type" 
				+	" from pkg_def where order_code_id="+orderCodeId );
			for(Map<String,Object> row:packageDefinition) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("pkg_def").toString());
				model.setDescription(row.get("n_calendar_units").toString());
				model.setDisplay(row.get("order_code_id").toString());
				model.setExtra(row.get("calendar_unit").toString());
				model.setExtraData(row.get("pkg_def_id").toString());
				model.setExtraDataDef(row.get("allowance_type").toString());
				pkgDefList.add(model);
			}
		}catch(Exception e){
			LOGGER.info("getPackageDefinitionList : "+e);
		}
		return pkgDefList;
	}
	
	@Override public List<PackageDefinition> getPackageDefinitionList(int orderCodeId) {	
		List<PackageDefinition> packageDefinitionList = null;
		try{
			StringBuilder query= new StringBuilder("select pkg_def_id,p.order_code_id,pkg_def,p.description,n_calendar_units,case when calendar_unit=0 then 'Day(s)' when calendar_unit=1 then 'Week(s)' when calendar_unit=2 then 'Month(s)' else 'Year(s)' end as calendar_unit , ");
			query.append("isnull(p.discount_class_id,'') as discount_class_id,pkg_price,revenue_percentage_option,isnull(p.renewal_card_id,'') as renewal_card_id,pkg_price,p.oc_id, ");
			query.append(" subscriber_site_allowance_type,order_code.order_code  from pkg_def as p inner join order_code on p.order_code_id=order_code.order_code_id   where p.order_code_id =").append(orderCodeId);
			packageDefinitionList = jdbcTemplate.query(query.toString(),new PackageDefinitionMapper());
			LOGGER.info("packageDefinitionList = "+packageDefinitionList);
		}catch(Exception e){
			LOGGER.info("getPackageDefinitionList : "+e);
		}
		return packageDefinitionList;
	}

	@Override
public List<SubscriptionDefinition> getSubscription(int orderCodeId) {
	List<SubscriptionDefinition> subscriptionDefinitionList = null;
	try{
		String query = "select order_code.order_code,subscription_category.description as subscription_category_description,"
				+ "rate_class_effective.rate_class_effective_seq,rate_class_effective.effective_date,"
				+ "subscription_def.* from subscription_def left join order_code order_code on order_code.order_code_id = subscription_def.order_code_id "
				+ "left join source_code source_code on source_code.oc_id= order_code.oc_id left join subscription_category subscription_category on subscription_category.subscription_category_id = subscription_def.subscription_category_id "
				+ "left join rate_class_effective rate_class_effective on rate_class_effective.rate_class_id = subscription_def.rate_class_id where subscription_def.order_code_id = ? and (rate_class_effective.effective_date=(select max(rate_class_effective.effective_date) from rate_class_effective"
				+ " where  rate_class_effective.rate_class_id = subscription_def.rate_class_id)or rate_class_effective.effective_date is null) and agency_customer_id is null order by subscription_def.subscription_def_id";
				subscriptionDefinitionList = jdbcTemplate.query(query, new Object[]{orderCodeId},new SubscriptionDefinitionMapper());
				System.out.println(subscriptionDefinitionList);
		
	}catch(Exception e){
		LOGGER.info("getSubscription : "+e);
	}
	return subscriptionDefinitionList;
}

	@Override
	public List<SubscriptionDefinition> getSubscriptionPackageDefList(int customerId, int orderCodeId,int sourceCodeId, int subscriptionDefId,int orderCodeType,String agencyID) {
			List<SubscriptionDefinition> subscriptionPackageDefList = new ArrayList<>();
			List<SubscriptionDefinition> subscriptionList = new ArrayList<>();
			List<Map<String, Object>> currencyList=null;
			try {
			String subsriptionQuery;
			if(subscriptionDefId!=0) {			
			int subscriptionCategId=jdbcTemplate.queryForObject("select isnull(subscription_category_id,0)as subscription_category_id from subscription_def where subscription_def_id="+subscriptionDefId+"", Integer.class);
			if((subscriptionCategId==7)||(subscriptionCategId==8)) {
				subsriptionQuery=new PropertyUtilityClass().getQuery("gratisQuery");				
				subscriptionPackageDefList = jdbcTemplate.query(subsriptionQuery,new Object[]{customerId,orderCodeId,customerId,customerId}, new SubscriptionPackageDefMapper());
				for (SubscriptionDefinition SubscriptionDef1 : subscriptionPackageDefList) {
					if(String.valueOf(SubscriptionDef1.getLocalAmount()).equals("0.0")) {
						int noCharge=jdbcTemplate.queryForObject("select no_charge from order_code where order_code_id="+orderCodeId+"", Integer.class);
						if(noCharge==1) {
						SubscriptionDef1.setBillingType("Undefined");
						}else{
							SubscriptionDef1.setBillingType("Balance Due");
						}
					}else {
						
							SubscriptionDef1.setBillingType("Balance Due");}
				
				subscriptionList.add(SubscriptionDef1);}
			}else {		
			 subsriptionQuery = " select top 1 order_code.*, oc.*, term.*, subscription_def.*, rate_class_effective.*, (case when ratecard.currency is null then (case when state.currency is null then (select currency from config) else state.currency end) else ratecard.currency end) as currency,state.state,ratecard.price as ratecard_price,c.exchange_rate,isnull((case when ratecard.currency is null then (case when calendar_unit=2 then (((1/(c.exchange_rate))* ratecard.price)*n_calendar_units)/12 else (1/(c.exchange_rate))* ratecard.price end) else (case when calendar_unit=2 then ((ratecard.price)*n_calendar_units)/12 else (ratecard.price) end) end),0.00)as localAmount,"
			 		                + " isnull((case when ratecard.currency is null then (case when calendar_unit=2 then ((ratecard.price)*n_calendar_units)/12 else (ratecard.price) end) else (case when calendar_unit=2 then ((ratecard.price * c.exchange_rate)*n_calendar_units)/12 else (ratecard.price * c.exchange_rate) end)end),0.00) as baseAmount,ratecard.charge_new,ratecard.remit_new,ratecard.percent_new,ratecard.charge_ren,ratecard.remit_ren,ratecard.percent_ren  from order_code order_code "
									+ " inner join oc oc on oc.oc_id = order_code.oc_id  inner join source_code on source_code_id=?"
									+ " inner join subscription_def subscription_def on subscription_def.order_code_id = order_code.order_code_id "
									+ " inner join term term on term.term_id = subscription_def.term_id "
									+ " left join rate_class on rate_class.oc_id =oc.oc_id "
									+ " left join rate_class_effective rate_class_effective on rate_class_effective.rate_class_id = case when source_code.newsub_rate_class_id is not null then  source_code.newsub_rate_class_id else( case when subscription_def.rate_class_id is null then (case when order_code.newsub_rate_class_id is not null then order_code.newsub_rate_class_id else rate_class.rate_class_id end) else subscription_def.rate_class_id end)end    "
									+"  and rate_class_effective.effective_date=(select max(rate_class_effective.effective_date) from rate_class_effective where  rate_class_effective.rate_class_id =  case when source_code.newsub_rate_class_id is not null then  source_code.newsub_rate_class_id else( case when subscription_def.rate_class_id is null then (case when order_code.newsub_rate_class_id is not null then order_code.newsub_rate_class_id else rate_class.rate_class_id end) else subscription_def.rate_class_id end)end) "
									+ " left join ratecard ratecard on(ratecard.rate_class_effective_seq = rate_class_effective.rate_class_effective_seq ) "
							  //    + " and rate_class_effective.rate_class_id= case when ratecard.rate_class_id is not null then ratecard.rate_class_id else rate_class_effective.rate_class_id end "
									+ " and ratecard.unit_type=order_code.revenue_method"
									+ " inner join customer_address on customer_id=? "
									+ " inner join state on state.state=customer_address.state or state.state_code_for_taxes=customer_address.state"
									+ " inner join currency c on c.currency=(case when ratecard.currency is null then (case when state.currency is null then (select currency from config) else state.currency end) else ratecard.currency end)"
									+ " where order_code.order_code_id = ? and subscription_def.subscription_def_id = ? "
									+ " and (ratecard.region=(select region from region_state where state=(select case when state_code_for_taxes is null then state else state_code_for_taxes end as state from state"
									+ " where state=(select top 1 state from customer_address where customer_id= ?)) and (region_list=(select top 1 region_list from region_state where state=(select top 1 state from customer_address where customer_id= ?)))) or region is not null"  
									+ " or ratecard.region is null) " ;
								//	+ " and  (ratecard.baseline_qty= (case when calendar_unit=3 and n_issues!=1 then (term.n_issues) when calendar_unit=3 and n_issues=1 then (n_calendar_units*365) when calendar_unit=2 and n_issues=1 then (select top 1 baseline_qty from ratecard where from_qty=1 and (to_qty=11 or to_qty= 365)) end) or ratecard.baseline_qty= 365)order by ratecard_seq desc";
			
			subscriptionPackageDefList = jdbcTemplate.query(subsriptionQuery,new Object[]{sourceCodeId,customerId,orderCodeId,subscriptionDefId,customerId,customerId}, new SubscriptionPackageDefMapper());
			for (SubscriptionDefinition SubscriptionDef : subscriptionPackageDefList) {
				if(agencyID!="" && (SubscriptionDef.getRateClassEffectiveModel().getChargeNew()!=null)) {
					  	  SubscriptionDef.setLocalAmount(Double.parseDouble(SubscriptionDef.getRateClassEffectiveModel().getChargeNew()));
						  SubscriptionDef.setBaseAmount(Double.parseDouble(SubscriptionDef.getRateClassEffectiveModel().getChargeNew())* (Double.parseDouble(SubscriptionDef.getRatecardModel().getExchangeRate())));
						
				}else {
				
				List<Order_code_for_price_list[][]> priceList= orderAddWsdl.getPrice(customerId, subscriptionDefId,String.valueOf(sourceCodeId),subscriptionPackageDefList.get(0).getState(),null,orderCodeType,orderCodeId);
				for(Order_code_for_price_list[][] map:priceList){
					String curr= map[0][0].getSubscription_price()[0].getCc_actual_currency()==""?map[0][0].getSubscription_price()[0].getCc_currency():map[0][0].getSubscription_price()[0].getCc_actual_currency();
					currencyList = jdbcTemplate.queryForList("select exchange_rate from currency where currency='"+curr+"'");
					RatecardModel ratecardModel = new RatecardModel();
					ratecardModel.setCurrency(map[0][0].getSubscription_price()[0].getCc_actual_currency());
					ratecardModel.setExchangeRate(currencyList.get(0).get("exchange_rate").toString());		
					SubscriptionDef.setRatecardModel(ratecardModel);
					SubscriptionDef.setLocalAmount(map[0][0].getSubscription_price()[0].getCc_item_price().doubleValue()) ;
					SubscriptionDef.setBaseAmount((map[0][0].getSubscription_price()[0].getCc_item_price().doubleValue())* Double.parseDouble(SubscriptionDef.getRatecardModel().getExchangeRate()));
				   
				}
				}
				if(String.valueOf(SubscriptionDef.getLocalAmount()).equals("0.0")) {
					int noCharge=jdbcTemplate.queryForObject("select no_charge from order_code where order_code_id="+orderCodeId+"", Integer.class);
					if(noCharge==1) {
					SubscriptionDef.setBillingType("Undefined");
					}else{
						SubscriptionDef.setBillingType("Balance Due");
					}
				}else {
					
						SubscriptionDef.setBillingType("Balance Due");}
			
				subscriptionList.add(SubscriptionDef);
				}
			}	
		}
		}catch(Exception e){
			LOGGER.info("getSubscription : "+e);
		}
			return subscriptionList;
	}
	
	
	@Override
	public List<SingleCopyOrder> getSingleCopyOrder(int customerId, int orderCodeId,String sourceCodeId, int subscriptionDefId,int orderCodeType) {
		List<SingleCopyOrder> singleOrderList = new ArrayList<>();
		List<SingleCopyOrder> singleOrder = new ArrayList<>();
    	String state=null;
		List<Map<String, Object>> currencyList=null;
		try
		{
			//Fixed Issue of Multiple states
			state=jdbcTemplate.queryForObject("select distinct(state.state) from customer_address inner join state on state.state=customer_address.state or state.state_code_for_taxes=customer_address.state  where customer_address_seq=1 AND customer_id ="+customerId ,String.class);
			currencyList = jdbcTemplate.queryForList("select state.currency,c.exchange_rate from state inner join currency c on c.currency= state.currency where state = '"+state+"'");
			List<Order_code_for_price_list[][]> priceList= orderAddWsdl.getPrice(customerId, subscriptionDefId,sourceCodeId,state,currencyList.get(0).get("currency").toString(),orderCodeType,orderCodeId);
			SingleCopyOrder singleCopyOrder=new SingleCopyOrder();
				for(Order_code_for_price_list[][] map:priceList){
					singleCopyOrder.setIssueID(subscriptionDefId);
     				singleCopyOrder.setDescription(map[0][0].getDescription());
					singleCopyOrder.setOrderCodeId(String.valueOf(map[0][0].getOrder_code_id()));
					singleCopyOrder.setOrderCode(map[0][0].getOrder_code());		
					singleCopyOrder.setOrderCodeType(String.valueOf(map[0][0].getOrder_code_type()));
					singleCopyOrder.setOrderClass(jdbcTemplate.queryForObject("select oc from oc where oc_id="+map[0][0].getOc_id()+"", String.class));				singleCopyOrder.setOrderQty(1);
					singleCopyOrder.setOrderQty(1);
					singleCopyOrder.setBundleQty(1);
					singleCopyOrder.setLocalAmount(map[0][0].getSingle_issue_price().getCc_item_price().doubleValue());
					singleCopyOrder.setBaseAmount((map[0][0].getSingle_issue_price().getCc_item_price().doubleValue())* (Double.parseDouble(currencyList.get(0).get("exchange_rate").toString())));
//					singleCopyOrder.setCommodityCode(rs.getString("commodity_code"));
					singleCopyOrder.setState(state);					
					// Will Add RatecardEffective model if required in future
					RatecardModel ratecardModel = new RatecardModel();
					ratecardModel.setPrice(String.valueOf(singleCopyOrder.getBaseAmount()));
					ratecardModel.setCurrency(currencyList.get(0).get("currency").toString());
					ratecardModel.setExchangeRate(currencyList.get(0).get("exchange_rate").toString());					
					singleCopyOrder.setRatecardModel(ratecardModel);
					if(String.valueOf(singleCopyOrder.getLocalAmount()).equals("0.0")) {
						singleCopyOrder.setBillingType("Balance Due");
						}else {
							singleCopyOrder.setBillingType("Balance Due");}
				}				
				singleOrder.add(singleCopyOrder);
			}
		catch(Exception e){
			LOGGER.info("getSingleCopyOrder : "+e);
			e.printStackTrace();
		}
		return singleOrder;
	}
	
	
	
	@Override
	public long getTaxRate(long customerId, int orderCodeId) {
		long taxRate = 0;
		try{
			int taxable= jdbcTemplate.queryForObject("select taxable from order_code where order_code_id="+orderCodeId+"",Integer.class);
			if(taxable!=0) {
			String taxRateQuery = "select top 1 case when (special_tax_id!=0) then 0 else "
					+ " isnull((case when state.tax_detail_type=0 then trb.tax_rate  when state.tax_detail_type=2 then trj.tax_rate when "
					+ " state.tax_detail_type=1 and order_code.commodity_code is not null then  tax_rate_commodity.tax_rate when "
					+ " state.tax_detail_type=3 and order_code.commodity_code is not null then trjc.tax_rate else trb.tax_rate end),0) end as tax_rate "
					+ "  from customer_address customer_address "
					+ "  left join state state on state.state = customer_address.state  "
					+ "  left join tax_rate_basic trb on trb.state=state.state or trb.state = state.state_code_for_taxes "
					+ "  left join tax_rate_jurisdiction trj on trj.state=state.state or trj.state = state.state_code_for_taxes " 
					+ "  left join tax_rate_commodity tax_rate_commodity on tax_rate_commodity.state =state.state "
					+ "  or tax_rate_commodity.state = state.state_code_for_taxes "
					+ "  left join tax_rate_juris_commodity trjc on trjc.state=state.state or trjc.state = state.state_code_for_taxes "
					+ "  left join order_code order_code on  order_code.commodity_code = tax_rate_commodity.commodity_code "
					+ "  and  order_code.order_code_id= "+orderCodeId+" "
					+ " where customer_address.customer_id = "+customerId+" order by tax_rate_commodity.effective_date desc";
			taxRate = jdbcTemplate.queryForObject(taxRateQuery,long.class );		
			}
		}
		catch (EmptyResultDataAccessException e)
		{
			taxRate= 0;			
		}
		catch(Exception e){
			LOGGER.info("getTaxRate : "+e);
		}
		return taxRate;
	}
	
	@Override
	public long getPackageTax(long customerId, int orderCodeId) {
		long taxRate = 0;
		int isTaxRateAvailable = 0;
		try{
			List<Map<String, Object>> orderCodes = null;
			StringBuilder orderCodeIds= new StringBuilder();
			orderCodes= jdbcTemplate.queryForList("select item_order_code_id from pkg_content where order_code_id="+orderCodeId+""); 
			for(int i=0;i<orderCodes.size();i++) {
				orderCodeIds.append(orderCodes.get(i).get("item_order_code_id").toString()+",");
			}
			if(orderCodes.size() != 0) 
			{
				//Updated for THINKDEV-610,611,615
				String taxRateExistsQuery=null;
				if(orderCodes.size()==1)
				{
					taxRateExistsQuery = "SELECT COUNT(*) FROM customer_address customer_address "
					+ " left join state state on state.state = customer_address.state "
					+ " left join tax_rate_commodity tax_rate_commodity on tax_rate_commodity.state =state.state or tax_rate_commodity.state = state.state_code_for_taxes "
					+ " left join order_code order_code on order_code.commodity_code = tax_rate_commodity.commodity_code "
					+ " where customer_address.customer_id = "+customerId+" and  order_code.order_code_id="+orderCodes.get(0).get("item_order_code_id").toString()+";";
				}else if(orderCodes.size()>1)
				{
					taxRateExistsQuery = "SELECT COUNT(*) FROM customer_address customer_address "
							+ " left join state state on state.state = customer_address.state "
							+ " left join tax_rate_commodity tax_rate_commodity on tax_rate_commodity.state =state.state or tax_rate_commodity.state = state.state_code_for_taxes "
							+ " left join order_code order_code on order_code.commodity_code = tax_rate_commodity.commodity_code "
							+ " where customer_address.customer_id = "+customerId+" and  order_code.order_code_id in("+orderCodeIds.substring(0, orderCodeIds.length()-1)+")";
				}
			    isTaxRateAvailable = jdbcTemplate.queryForObject(taxRateExistsQuery, Integer.class);
		   }
			if(isTaxRateAvailable>0)
			{
				//Updated for THINKDEV-610,611,615
				String taxRateQuery =null;
				if(orderCodes.size()==1)
				{
					taxRateQuery = " select top 1 case when (special_tax_id!=0) then 0 else  tax_rate_commodity.tax_rate end "
							+ " from customer_address customer_address "
							+ " left join state state on state.state = customer_address.state "
							+ " left join tax_rate_commodity tax_rate_commodity on tax_rate_commodity.state =state.state or tax_rate_commodity.state = state.state_code_for_taxes "
							+ " left join order_code order_code on order_code.commodity_code = tax_rate_commodity.commodity_code "
							+ " where customer_address.customer_id = "+customerId+" and  order_code.order_code_id="+orderCodes.get(0).get("item_order_code_id").toString()+" order by tax_rate_commodity.effective_date desc";
				}else if(orderCodes.size()>1)
				{	
					taxRateQuery = " select top 1 case when (special_tax_id!=0) then 0 else  tax_rate_commodity.tax_rate end "
						+ " from customer_address customer_address "
						+ " left join state state on state.state = customer_address.state "
						+ " left join tax_rate_commodity tax_rate_commodity on tax_rate_commodity.state =state.state or tax_rate_commodity.state = state.state_code_for_taxes "
						+ " left join order_code order_code on order_code.commodity_code = tax_rate_commodity.commodity_code "
						+ " where customer_address.customer_id = "+customerId+" and  order_code.order_code_id in("+orderCodeIds.substring(0, orderCodeIds.length()-1)+") order by tax_rate_commodity.effective_date desc";
				}
				taxRate = jdbcTemplate.queryForObject(taxRateQuery,long.class);			
			}
		}
		catch(Exception e)
		{
			LOGGER.info("getTaxRate : "+e);
			e.printStackTrace();
		}
		return taxRate;
	}
	
	@Override
	public List<Map<String, Object>> getRateCardChange(int rateClassId, int rateClassEffectiveSeq, long customerId,String orderhdrId) {
		List<Map<String, Object>> rateCard = null;
		try{
			String rateCardQuery = " select top 1 (case when rc.currency is null then (1/(c.exchange_rate))* price else price end) as netLocalAmt,"
					+ " (case when rc.currency is null then price else (price * c.exchange_rate) end ) as netBaseAmt, c.currency,c.exchange_rate  from ratecard rc left join rate_class_effective rct on rct.rate_class_id=rc.rate_class_id and "  
					+ " rct.rate_class_effective_seq=rc.rate_class_effective_seq left join order_item oi on rct.rate_class_id=oi.rate_class_id"
					+ " left join currency c on (oi.currency=c.currency) where rct.rate_class_id = "+rateClassId+"and rct.rate_class_effective_seq="+rateClassEffectiveSeq+" and orderhdr_id="+orderhdrId+" "
				    + " and (rc.region=(select region from region_state where state=(select case when state_code_for_taxes is null then state end as state from state where state=(select state from customer_address where customer_id="+customerId+"))"
				    + "	and region_list=(select top 1 region_list from region_state where state=(select top 1 state from customer_address where customer_id= "+customerId+"))) or rc.region is null)  ";
			rateCard = jdbcTemplate.queryForList(rateCardQuery.toString());			
		}catch(Exception e){
			LOGGER.info("getRateCardChange : "+e);
		}
		return rateCard;
	}

	
	@Override
	public List<RateClassEffectiveModel> getRateClassEffectiveList(String agencyID,int rateClassId, String orderCodeId, long customerId,long orderhdrId,int orderItemSeq,int subscription_def_id) {
		List<RateClassEffectiveModel> rateClassEffectiveList = new ArrayList<>();
		List<RateClassEffectiveModel> rateClassEffectiveList1 =  new ArrayList<>();
		long tax,days=0;
		StringBuilder rateClassEffectiveQuery = new StringBuilder();
		StringBuilder baseQuery = new StringBuilder();
		Integer baselineQty;
		List<Map<String, Object>> dates = null;
		String query="select convert(varchar,start_date,23) as start_date,convert(varchar,expire_date,23) as expire_date from order_item where orderhdr_id="+orderhdrId+" and order_item_seq="+orderItemSeq+"";
		
		try{
			dates = jdbcTemplate.queryForList(query.toString());
			
			LocalDate startDate = LocalDate.parse(dates.get(0).get("start_date").toString());
			LocalDate expireDate = dates.get(0).get("expire_date")!=null?LocalDate.parse(dates.get(0).get("expire_date").toString()): null;
				
			//calculating number of days in between
			if(!(startDate==null || expireDate==null)) {
			days = ChronoUnit.DAYS.between(startDate, expireDate)+1;}
			baseQuery.append(" select distinct top 1 rc.baseline_qty from  rate_class_effective rct left join ratecard rc  on rc.rate_class_id=rct.rate_class_id and  rct.rate_class_effective_seq=rc.rate_class_effective_seq left join order_item oi on oi.revenue_method=(rc.unit_type) or rc.region is null ");
			baseQuery.append(" left join  subscription_def sd on sd.order_code_id = oi.order_code_id and sd.subscription_def_id="+subscription_def_id+" left join term term on term.term_id = sd.term_id left join currency c on (oi.currency=c.currency) where (rc.region=(select region from region_state where state=(select case when state_code_for_taxes is null  then state else state_code_for_taxes end as state from state where state=(select top 1 state from customer_address where customer_id="+customerId+"))");
			baseQuery.append(" and region_list=(select top 1 region_list from region_state where state=(select top 1 state from customer_address where customer_id="+customerId+"))) ");
		    
			List<Map<String, Object>> dataQuery =jdbcTemplate.queryForList("select * from rate_class_effective rct left join ratecard rc on rct.rate_class_id=rc.rate_class_id and  rct.rate_class_effective_seq=rc.rate_class_effective_seq where "
							 + "  rct.rate_class_id="+rateClassId+" and (rc.region=(select region from region_state where state=(select case when state_code_for_taxes is null"
							 + "  then state else state_code_for_taxes end as state from state where state=(select top 1 state from customer_address where customer_id="+customerId+")) "
							 + "  and region_list=(select top 1 region_list from region_state where state=(select top 1 state from customer_address where customer_id="+customerId+")))) ");
							if(dataQuery.size()!=0) {
								baseQuery.append("or rc.region is null)");
							}else {
								baseQuery.append("or rc.region is null or region is not null) ");
							}
							
		    baseQuery.append(" and  rct.rate_class_id = (case when "+rateClassId+"='' then oi.rate_class_id else "+rateClassId+" end) and orderhdr_id="+orderhdrId+" and oi.order_item_seq="+orderItemSeq+"  and (rc.baseline_qty= (case when (term.calendar_unit=3 and n_issues!=1) then 	(term.n_issues) when (term.calendar_unit=3 and n_issues=1)  then (case when rc.baseline_qty=6 then (n_calendar_units*rc.baseline_qty) 	else (n_calendar_units* 366) end) when (term.calendar_unit=2 and n_issues=1) then (select top 1 baseline_qty from ratecard where from_qty=1 and (to_qty=11 or to_qty= 366)) end) or (rc.baseline_qty= 366) or rc.region is null) order by baseline_qty desc ");
			baselineQty=jdbcTemplate.queryForObject(baseQuery.toString(), Integer.class);
			if(null!=baselineQty && days==365 && baselineQty==366 ) 
			{
				baselineQty=365;
			}
			 rateClassEffectiveQuery.append(" select distinct case when rc.rate_class_effective_seq is not null then (isnull((case when rc.currency is null then (case when oi.revenue_method=1  then (((1/(c.exchange_rate))* rc.price) * bundle_qty * "+days+")/"+baselineQty+" when  oi.revenue_method=0 or oi.revenue_method=2 then (1/(c.exchange_rate))*(rc.price)*term.n_issues end) else (case when oi.revenue_method=1 then ((rc.price) * bundle_qty * "+days+")/"+baselineQty+"  else ((rc.price)*term.n_issues)/"+baselineQty+"  end) end),0.00)) else  (case when oi.subscrip_start_type in(3,4,5) then rct.cost_per_day * bundle_qty * "+days+" else rct.default_price_per_issue * term.n_issues end) end as localAmount,");
			 rateClassEffectiveQuery.append( " case when rc.rate_class_effective_seq is not null then (isnull((case when rc.currency is null then (case when oi.revenue_method=1  then ((rc.price) * bundle_qty * "+days+")/"+baselineQty+"  when  oi.revenue_method=0 or oi.revenue_method=2 then (rc.price)*term.n_issues end) else (case when oi.revenue_method=1 then ((rc.price * c.exchange_rate) * bundle_qty * "+days+")/"+baselineQty+"  else (rc.price * c.exchange_rate*term.n_issues)/"+baselineQty+"  end)end),0.00)) else (case when oi.subscrip_start_type in(3,4,5) then rct.cost_per_day * bundle_qty * "+days+" else rct.default_price_per_issue * term.n_issues end) end  as baseAmount,");
			 rateClassEffectiveQuery.append( " c.currency,c.exchange_rate,oi.has_tax,rc.region," );
			 rateClassEffectiveQuery.append( " rct.rate_class_id,rct.rate_class_effective_seq,(rct.description+' - '+CONVERT(varchar,rct.effective_date,101)) as description,rct.effective_date, ");
			 rateClassEffectiveQuery.append( " rc.charge_new,rc.remit_new,rc.percent_new,rc.charge_ren,rc.remit_ren,rc.percent_ren , new_commission,ren_commission ");
			 rateClassEffectiveQuery.append( " from  rate_class_effective rct "  );
			 rateClassEffectiveQuery.append( " left join ratecard rc  on rc.rate_class_id=rct.rate_class_id and ");  
			 rateClassEffectiveQuery.append( " rct.rate_class_effective_seq=rc.rate_class_effective_seq " );
			 rateClassEffectiveQuery.append( " left join order_item oi on oi.revenue_method=(rc.unit_type) or rc.region is null " );
			 rateClassEffectiveQuery.append( " left join  subscription_def sd on sd.order_code_id = oi.order_code_id and sd.subscription_def_id='"+subscription_def_id+"'" );
			 rateClassEffectiveQuery.append( " left join term term on term.term_id = sd.term_id");
			 rateClassEffectiveQuery.append( " left join currency c on (oi.currency=c.currency)  left join agency on agency.customer_id=oi.agency_customer_id  " );
			 rateClassEffectiveQuery.append( " where (rc.region=(select region from region_state where state=(select case when state_code_for_taxes is null "  );
			 rateClassEffectiveQuery.append( " then state else state_code_for_taxes end as state from state where state=(select top 1 state from customer_address where customer_id="+customerId+")) " ); 
			 rateClassEffectiveQuery.append( " and region_list=(select top 1 region_list from region_state where state=(select top 1 state from customer_address where customer_id="+customerId+"))) ");
					
			 List<Map<String, Object>> data =jdbcTemplate.queryForList("select * from rate_class_effective rct left join ratecard rc on rct.rate_class_id=rc.rate_class_id and  rct.rate_class_effective_seq=rc.rate_class_effective_seq where "
					 + "  rct.rate_class_id="+rateClassId+" and (rc.region=(select region from region_state where state=(select case when state_code_for_taxes is null"
					 + "  then state else state_code_for_taxes end as state from state where state=(select top 1 state from customer_address where customer_id="+customerId+")) "
					 + "  and region_list=(select top 1 region_list from region_state where state=(select top 1 state from customer_address where customer_id="+customerId+")))) ");
					if(data.size()!=0) {
						rateClassEffectiveQuery.append("or rc.region is null)");
					}else {
						rateClassEffectiveQuery.append("or rc.region is null or region is not null) ");
					}
					
					rateClassEffectiveQuery.append( " and  rct.rate_class_id = (case when "+rateClassId+"='' then oi.rate_class_id else "+rateClassId+" end) and orderhdr_id="+orderhdrId+" and oi.order_item_seq="+orderItemSeq+"");
					rateClassEffectiveQuery.append( " and  (rc.baseline_qty= "+baselineQty+" or  rc.region is null)");
					
					
			rateClassEffectiveList = jdbcTemplate.query(rateClassEffectiveQuery.toString(),new RateClassEffectiveMapper());
		    tax = getTaxRate(customerId,Integer.parseInt(orderCodeId));
			for (RateClassEffectiveModel rateClassEffectiveModel : rateClassEffectiveList) {
			if(agencyID!="") {
			  if((rateClassEffectiveModel.getChargeNew()!=null && !(rateClassEffectiveModel.getRemitNew()!=null) && !(rateClassEffectiveModel.getPercentNew()!=null)))
				{
				    rateClassEffectiveModel.setLocalAmount(Double.parseDouble(rateClassEffectiveModel.getChargeNew()));
					rateClassEffectiveModel.setBaseAmount(Double.parseDouble(rateClassEffectiveModel.getChargeNew())* (Double.parseDouble(rateClassEffectiveModel.getExchangeRate())));
					
					if(rateClassEffectiveModel.getNew_commission()!=0) {
					rateClassEffectiveModel.setLocalcommission(((rateClassEffectiveModel.getLocalAmount())* rateClassEffectiveModel.getNew_commission())/100);
					rateClassEffectiveModel.setBasecommission(((rateClassEffectiveModel.getBaseAmount())* rateClassEffectiveModel.getNew_commission())/100);					
					rateClassEffectiveModel.setLocalAmount(Double.parseDouble(rateClassEffectiveModel.getChargeNew())- (rateClassEffectiveModel.getLocalcommission()));
					rateClassEffectiveModel.setBaseAmount((Double.parseDouble(rateClassEffectiveModel.getChargeNew())-(rateClassEffectiveModel.getLocalcommission()))* (Double.parseDouble(rateClassEffectiveModel.getExchangeRate())));
					}
				}
				if((rateClassEffectiveModel.getRemitNew()!=null && !(rateClassEffectiveModel.getChargeNew()!=null) && !(rateClassEffectiveModel.getPercentNew()!=null)))
				{
					rateClassEffectiveModel.setLocalcommission(((rateClassEffectiveModel.getLocalAmount())- (Double.parseDouble(rateClassEffectiveModel.getRemitNew()))));
					rateClassEffectiveModel.setBasecommission(((rateClassEffectiveModel.getBaseAmount())- (Double.parseDouble(rateClassEffectiveModel.getRemitNew()))));
					rateClassEffectiveModel.setLocalAmount(Double.parseDouble(rateClassEffectiveModel.getRemitNew()));
					rateClassEffectiveModel.setBaseAmount(Double.parseDouble(rateClassEffectiveModel.getRemitNew())* (Double.parseDouble(rateClassEffectiveModel.getExchangeRate())));
					
				}
				if((rateClassEffectiveModel.getPercentNew()!=null && !(rateClassEffectiveModel.getChargeNew()!=null) && !(rateClassEffectiveModel.getRemitNew()!=null))) 
				{
				rateClassEffectiveModel.setLocalAmount(rateClassEffectiveModel.getLocalAmount()-((rateClassEffectiveModel.getLocalAmount()* Double.parseDouble(rateClassEffectiveModel.getPercentNew()))/100));
				rateClassEffectiveModel.setBaseAmount(rateClassEffectiveModel.getBaseAmount()-((rateClassEffectiveModel.getBaseAmount()* Double.parseDouble(rateClassEffectiveModel.getPercentNew()))/100)* (Double.parseDouble(rateClassEffectiveModel.getExchangeRate())));
				rateClassEffectiveModel.setLocalcommission(Double.parseDouble(rateClassEffectiveModel.getPercentNew()));
				rateClassEffectiveModel.setBasecommission(Double.parseDouble(rateClassEffectiveModel.getPercentNew()));
				}
				if((rateClassEffectiveModel.getPercentNew()!=null && (rateClassEffectiveModel.getRemitNew()!=null) && !(rateClassEffectiveModel.getChargeNew()!=null))) {
					rateClassEffectiveModel.setLocalcommission((rateClassEffectiveModel.getLocalAmount())- (Double.parseDouble(rateClassEffectiveModel.getRemitNew())));
					rateClassEffectiveModel.setBasecommission((rateClassEffectiveModel.getBaseAmount())- (Double.parseDouble(rateClassEffectiveModel.getRemitNew())));
					rateClassEffectiveModel.setLocalAmount(Double.parseDouble(rateClassEffectiveModel.getRemitNew()));
					rateClassEffectiveModel.setBaseAmount(Double.parseDouble(rateClassEffectiveModel.getRemitNew())* (Double.parseDouble(rateClassEffectiveModel.getExchangeRate())));
					
				}
				if((rateClassEffectiveModel.getChargeNew()!=null && (rateClassEffectiveModel.getPercentNew()!=null) && !(rateClassEffectiveModel.getRemitNew()!=null)))
				{
					rateClassEffectiveModel.setLocalAmount(Double.parseDouble(rateClassEffectiveModel.getChargeNew())-((Double.parseDouble(rateClassEffectiveModel.getChargeNew()) * Double.parseDouble(rateClassEffectiveModel.getPercentNew())/100)));
					rateClassEffectiveModel.setBaseAmount(Double.parseDouble(rateClassEffectiveModel.getChargeNew())-((Double.parseDouble(rateClassEffectiveModel.getChargeNew()) * Double.parseDouble(rateClassEffectiveModel.getPercentNew())/100))* (Double.parseDouble(rateClassEffectiveModel.getExchangeRate())));
					rateClassEffectiveModel.setLocalcommission((Double.parseDouble(rateClassEffectiveModel.getChargeNew()) * Double.parseDouble(rateClassEffectiveModel.getPercentNew()))/100);
					rateClassEffectiveModel.setBasecommission((Double.parseDouble(rateClassEffectiveModel.getChargeNew()) * Double.parseDouble(rateClassEffectiveModel.getPercentNew()))/100);
				}
				if((rateClassEffectiveModel.getChargeNew()!=null && (rateClassEffectiveModel.getRemitNew()!=null) && !(rateClassEffectiveModel.getPercentNew()!=null)))
				{
					rateClassEffectiveModel.setLocalAmount(Double.parseDouble(rateClassEffectiveModel.getRemitNew()));
					rateClassEffectiveModel.setBaseAmount(Double.parseDouble(rateClassEffectiveModel.getRemitNew())* (Double.parseDouble(rateClassEffectiveModel.getExchangeRate())));
					rateClassEffectiveModel.setLocalcommission((Double.parseDouble(rateClassEffectiveModel.getChargeNew()))- (Double.parseDouble(rateClassEffectiveModel.getRemitNew())));
					rateClassEffectiveModel.setBasecommission((Double.parseDouble(rateClassEffectiveModel.getChargeNew()))- (Double.parseDouble(rateClassEffectiveModel.getRemitNew())));
				}
				if((rateClassEffectiveModel.getChargeNew()!=null && (rateClassEffectiveModel.getRemitNew()!=null) && (rateClassEffectiveModel.getPercentNew()!=null)))
				{
					rateClassEffectiveModel.setLocalAmount(Double.parseDouble(rateClassEffectiveModel.getRemitNew()));
					rateClassEffectiveModel.setBaseAmount(Double.parseDouble(rateClassEffectiveModel.getRemitNew())* (Double.parseDouble(rateClassEffectiveModel.getExchangeRate())));
					rateClassEffectiveModel.setLocalcommission((Double.parseDouble(rateClassEffectiveModel.getChargeNew()))- (Double.parseDouble(rateClassEffectiveModel.getRemitNew())));
					rateClassEffectiveModel.setBasecommission((Double.parseDouble(rateClassEffectiveModel.getChargeNew()))- (Double.parseDouble(rateClassEffectiveModel.getRemitNew())));
				}
			}
				rateClassEffectiveModel.setTax_rate(tax);
				rateClassEffectiveList1.add(rateClassEffectiveModel);
			}
			
		}catch(EmptyResultDataAccessException e){
			baselineQty = null;
			LOGGER.info("getRateClassEffectiveList : "+e);
		}catch(Exception e) {
			LOGGER.info("getRateClassEffectiveList : "+e);
		}
		return rateClassEffectiveList1;
	}

	@Override
	public List<RatecardModel> getCustomerOrderPriceTax(int rateClassId, int rateClassEffectiveSeq, String ratecardSeq, String state, String commodityCode) {
		List<RatecardModel> orderPriceTaxList = new ArrayList<>();
		try{
			String orderPriceTaxQuery = "select rate_class_effective.effective_date, ratecard.price, tax_rate_commodity.tax_rate "
									  + " from rate_class_effective rate_class_effective "
									  + " left join ratecard ratecard on ratecard.rate_class_id=rate_class_effective.rate_class_id " 
									  + " and ratecard.rate_class_effective_seq =rate_class_effective.rate_class_effective_seq "
									  + " and ratecard.ratecard_seq = rate_class_effective.mru_ratecard_seq "
									  + " left join tax_rate_commodity tax_rate_commodity on tax_rate_commodity.state = '?' and tax_rate_commodity.commodity_code = '?' " 
									  + " and rate_class_effective.effective_date = tax_rate_commodity.effective_date "
									  + " where rate_class_effective.rate_class_id = ? and rate_class_effective.rate_class_effective_seq = ? and rate_class_effective.mru_ratecard_seq = ? ";
			
			orderPriceTaxList = jdbcTemplate.query(orderPriceTaxQuery, new Object[]{state,commodityCode,rateClassId,rateClassEffectiveSeq,ratecardSeq}, new RatecardMapper());
		}catch(Exception e){
			LOGGER.info("getCustomerOrderPriceTax : "+e);
		}
		return orderPriceTaxList;
	}

	@Override
	public List<DropdownModel> getorderClass() {
		LOGGER.info("Inside getorderClass");
		List<DropdownModel>  OrderClassList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
			"select distinct oc.oc_id,oc,oc.description,oc.oc_type from oc oc left join order_code ord on ord.oc_id=oc.oc_id" 
                              +" AND  (active = 1 and ord.order_code_type != 3 and ord.order_code_type != 8 and premium != 2)  where not(oc_type=0) "
					          +" ORDER BY oc.description");
			//+" and oc.oc_id in(33,37,35,39,41,43,46,47,49,61,51,82,55,138,190,198,200,202,204,212,206,217,215,213,214,220,222,224,229) ORDER BY oc.oc");
								
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("oc_id").toString());
				model.setDisplay(row.get("oc").toString());
				model.setDescription(row.get("description")!=null?row.get("description").toString():null);
				model.setExtra(new PropertyUtilityClass().getConstantValue("oc_type_"+row.get("oc_type").toString()));
				OrderClassList.add(model);
			}
			
			
		} catch (Exception e) {
			LOGGER.info("Error:" + e);
		}
		return OrderClassList;
	}
	
	@Override
	public List<DropdownModel> getOrderCode() {		
		List<DropdownModel> orderCode = new ArrayList<>();
		try {			
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
			"select distinct order_code_type,case when order_code_type=0 then 'Subscription' when  order_code_type=1 then 'Single Copy'"
					 + " when order_code_type=3 then 'Electronic Document' when  order_code_type=4 then 'Basic Package' when  order_code_type=5 then 'Ad-hoc Package' when order_code_type=6 then 'Pooled Package' when order_code_type=2 then 'Product' when order_code_type=7 then 'Quick Order' when order_code_type=8 then 'Shipping' end as order_description"
					 + " from order_code order by order_code_type asc");
								
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("order_code_type").toString());
				model.setDisplay(row.get("order_description").toString());
				orderCode.add(model);
			}
			
		} catch (Exception e) {
			LOGGER.info("" + e);
		}
		return orderCode;
	}
	
	@Override
	public List<DropdownModel> getOrderTerm() {
		List<DropdownModel> termList = new ArrayList<>();
		try {			

			List<Map<String, Object>> rows = jdbcTemplate.queryForList("select term,description from term");								
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("term").toString());
				model.setDisplay(row.get("description").toString());
				termList.add(model);
			}
			
		} catch (Exception e) {
			LOGGER.info("" + e);
		}
		return termList;
	}
	
	
	
	@Override
	public List<OrderCode> getOrderCodeData(String orderCode ,String orderClass,String orderCodeType,String term) {
		List<OrderCode> orderCodeList = new ArrayList<OrderCode>();
		try 
		{
			StringBuilder orderQuery = new StringBuilder();
			//Edited for THINKDEV-610,611,615
			orderQuery.append("SELECT order_code.order_code_type,order_code.revenue_method,order_code.start_type,order_code_id,order_code.oc_id,order_code,o.oc,order_code.description,premium,t.term,media,edition,audit_qual_category,product_size,product_style,product_color,pkg_only_item,is_proforma,no_charge,controlled,perpetual_order,prepayment_req,active FROM order_code"
					+ " left join oc o on order_code.oc_id=o.oc_id"
					+ " left join term t on order_code.term_id=t.term_id" + " WHERE"
					+ " (active = 1 and order_code.order_code_type != 3 and order_code.order_code_type != 8 and premium != 2)");
			
					if(!orderClass.equals(""))
					{
						orderQuery.append(" AND order_code.oc_id = "+orderClass);
					}
					if(!orderCodeType.equals(""))
					{
						orderQuery.append(" AND order_code_type = "+orderCodeType);
					}
					if(!term.equals(""))
					{
						orderQuery.append(" AND term = '"+term+"'");
					}
					if("*".equals(orderCode))
					{
						orderQuery.append(" AND order_code.order_code like '%'");
					}
					else if(orderCode.contains("*"))
					{
						orderQuery.append(" AND order_code.order_code like '"+orderCode.replace('*','%')+"'");
					}
					else if(!orderCode.equals(""))
					{
							orderQuery.append(" AND order_code.order_code ='"+orderCode+"'");
					}
					orderQuery.append(" ORDER BY order_code.oc_id,order_code.order_code");
					orderCodeList = jdbcTemplate.query(orderQuery.toString(), new OrderSourceOfferMapper());			
		} catch (Exception e) 
		{
			LOGGER.info("" + e);
		}
		return orderCodeList;
	}
	
	
	
	@Override
	public List<DropdownModel>  getviewOrderTypeList() {
		LOGGER.info("Inside getviewOrderTypeList");
		List<DropdownModel>  viewOrderTypeList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"SELECT X.* FROM   (VALUES ('-1','All Orders'),('0', 'Subscriptions'),('1', 'Single Copy Orders'),('2', 'Product Orders'),('3', 'Electronic Document'),(cast('4,5,6' as varchar(10)), 'Package Orders')) AS X (order_code, description)");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("order_code").toString());
				model.setDisplay(row.get("description").toString());
				viewOrderTypeList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error("Error: " + e);
		}
		return viewOrderTypeList;

	
	}
	
	@Override
	public List<DropdownModel>  getOrderStatus() {
		LOGGER.info("Inside getOrderStatus");
		List<DropdownModel>  getOrderStatusList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"SELECT X.* FROM (VALUES ('0','Order Placed'),('1', 'Canceled - Nonpayment'),('2', 'Canceled - Customer Request'),('3', 'Canceled - Credit Card Not Authorized'),('4', 'Canceled - Audit Information Problem'),"
					+ " ('5', 'Active / Shipping'),('6', 'Complete'),('7', 'Grace Period 8 Suspend - Nonpayment'),('9', 'Suspend - Temporary'),('10', 'Hold for Payment')," 
					+ " ('11', 'Suspended - Delivery Problem'),('12', 'Suspended - Distribution Problem'),('13', 'Suspended - Audit Information Problem'),('14', 'Canceled - Audit Information Problem'),('15', 'Hold Until Fulfillment Date')," 
					+ " ('16', 'Suspended')) AS X (order_status, description)");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("order_status").toString());
				model.setDisplay(row.get("description").toString());
				getOrderStatusList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error("Error: " + e);
		}
		return getOrderStatusList;

	
	}
	
	@Override
	public List<DropdownModel>  getpaymentStatus() {
		LOGGER.info("Inside getpaymentStatus");
		List<DropdownModel>  getpaymentStatusList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"  SELECT X.* FROM (VALUES ('0','No Payment'),('1', 'Paid'),('2', 'Paid - Overpayment'),('3', 'Paid - Underpayment'),('4', 'Paid - Prorated'),"
					+ " ('5', 'Partial Payment')) AS X (payment_status, description)");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("payment_status").toString());
				model.setDisplay(row.get("description").toString());
				getpaymentStatusList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error("Error: " + e);
		}
		return getpaymentStatusList;

	
	}
	@Override
	public List<Object> getDuplicateOrder(OrderItem orderItem){		
		List<Object> duplicateRecords = new ArrayList<Object>();
		try {
		String record="select top 1 start_date,expire_date,convert(date,DATEADD(DAY, 1,expire_date)) as subscription_start_date,DATEADD(YEAR, 1,expire_date)as subscription_end_date, subscrip_id,source_code_id,subscription_def_id, order_code_id,oc,oc.oc_id,orderhdr_id, order_item_type,order_status,payment_status from order_item " 
				+ "left join oc on oc.oc_id=order_item.oc_id where customer_id = "+orderItem.getCustomerId()+" and order_item.oc_id="+orderItem.getOcId()+" and cancel_date is null and start_date=(select max(start_date)as start_date from order_item  WHERE customer_id = "+orderItem.getCustomerId()+"  and order_item.oc_id="+orderItem.getOcId()+"and cancel_date is null)" ;
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(record.toString());
		for (Map<String, Object> row : rows) {
		   duplicateRecords.add(row);
		}
		}
		  catch (Exception e) {
		   LOGGER.error(ERROR + e);
		}
		  return duplicateRecords;
		
	}
	@Override
	public List<Object> getRenewalOrder(int subscripId){		
		List<Object> renewalRecord = new ArrayList<Object>();
		try {
		String record="SELECT  top 1 CONVERT(varchar,(DATEADD(DAY, 1,expire_date)),101) as subscription_start_date,CONVERT(varchar,(DATEADD(YEAR, 1,expire_date)),101) as subscription_end_date,orderhdr_id,customer_id,order_code_id,source_code_id,subscription_def_id,order_item_type,payment_status,subscrip_id FROM order_item WHERE subscrip_id="+subscripId+"  and cancel_reason is  null ORDER BY orderhdr_id desc,order_item_seq" ;
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(record.toString());
		for (Map<String, Object> row : rows) {
			renewalRecord.add(row);
		}
		}
		  catch (Exception e) {
		   LOGGER.error(ERROR + e);
		}
		  return renewalRecord;
		
	}
	@Override
	public boolean addBasicPackage(OrderItem orderItem) { 

		  try{
		   LOGGER.info("Inside CustomerOrderDaoImple : addBasicPackage "+orderItem);
		   int orderItemSeq = 1;
		   OrderItemAmtBreak orderItemAmtBreak = new OrderItemAmtBreak();
		   List<SubscriptModel> subscriptList = new LinkedList<>();
		   
		   /* Get orderHdrId from "orderhdr" table*/
		   long orderHdrId = jdbcTemplate.queryForObject("select max(orderhdr_id)+1 from orderhdr where orderhdr_id not like '10000%' ", Long.class);
		   int expireYear = jdbcTemplate.queryForObject("select n_calendar_units from pkg_def where pkg_def_id = "+orderItem.getPkgDefId(), Integer.class);
		   
		   orderHdrSave(orderHdrId,3);   
		   orderItem.setOrderhdrId(orderHdrId);
		   
		 /*  / Save into subscrip table /*/
		   long subscripId = addSubscripBasicPackage(orderItem,subscriptList);
		   
		   /*setEditTrailValue(String.valueOf(orderItem.getCustomerId()), String.valueOf(orderItem.getCustomerAddressSeq()), 
		     orderItem.getUserCode(), String.valueOf(subscripId), String.valueOf(orderHdrId), String.valueOf(orderItemSeq), null, "0", "3", "null",
		     "null", orderItem.getGrossLocalAmount(), orderItem.getNetBaseAmount(), String.valueOf(orderItem.getDateStamp()), "", 
		     "order_add_request", "null", "null", "null","null", "null");*/
		   
		   orderItem.setSubscripId(String.valueOf(subscripId));
		   orderItem.setStartIssueId("0");
		   orderItem.setStopIssueId(0);
		   orderItem.setOrderItemSeq(1);
		   orderItem.setOrderItemType(4);
		   orderItem.setSubscriptionDefId("0");
		   orderItem.setSubscripStartType(7);
		   orderItem.setExpireYear(expireYear);
		   orderItem.setOrigOrderQty(orderItem.getBundleQty());
		   
		   orderItemAmtBreak.setOrderhdrId(orderHdrId);
		   orderItemAmtBreak.setOrderItemSeq(String.valueOf(1));
		   orderItemAmtBreak.setLocalAmount(String.valueOf(orderItem.getAmountCharged()));
		   orderItemAmtBreak.setBaseAmount(String.valueOf(orderItem.getAmountCharged()));
		   
		   System.out.println("orderItemAmtBreak : "+orderItemAmtBreak);
		   /*/ Save into order_item_amt_break table /*/
		   
		   /*setEditTrailValue(null, null, orderItem.getUserCode(), null, String.valueOf(orderHdrId), String.valueOf(orderItemSeq), "1", "0", "6", "", null, 
		     orderItem.getGrossLocalAmount(), orderItem.getNetBaseAmount(), String.valueOf(orderItem.getDateStamp()), "creationDate", 
		     "order_add_request", null,null, null, null, null);*/
		   
		  /* / Save into order_item table /*/
		   orderItemSave(orderItem, orderItem.getOrderCodeID(), orderItem.getOrderCodeType());
		   orderItemBreakSave(orderHdrId,orderItem.getCustomerId(),orderItemAmtBreak);
		   /*setEditTrailValue(null, null, orderItem.getUserCode(), null, String.valueOf(orderHdrId), String.valueOf(orderItemSeq), "1", "0", "6", "", null, 
		     "0", "0", String.valueOf(orderItem.getDateStamp()), "creationDate", 
		     "order_add_request", null,null, null, null, null);*/
		   
		   orderItemAmtBreak.setOrderItemAmtBreakSeq("2");
		   orderItemAmtBreak.setOrderItemBreakType("1");
		   orderItemAmtBreak.setLocalAmount("0");
		   orderItemAmtBreak.setBaseAmount("0");
		   
		   orderItemAmtBreak.setState(jdbcTemplate.queryForObject("select state from customer_address where customer_id = "+orderItem.getCustomerId(), String.class));
		   orderItemAmtBreak.setTaxType("VATUK");
		   orderItemAmtBreak.setTaxRateCategory("ZERO");
		   orderItemAmtBreak.setTaxRate("0");
		   orderItemAmtBreak.setTaxDelivery("1");
		   orderItemAmtBreak.setTaxActive("1");
		   orderItemAmtBreak.setOrderItemBreakType("1");
		   System.out.println("orderItemAmtBreak : "+orderItemAmtBreak);
		/*   / Save into order_item_amt_break table /*/
		   orderItemBreakSave(orderHdrId,orderItem.getCustomerId(),orderItemAmtBreak);
		   
		   StringBuilder query = new StringBuilder();
		   query.append("select pkg_content.item_order_code_id, order_code.oc_id,order_code.order_code_type,start_date.* from pkg_content");
		   query.append(" left join order_code on pkg_content.item_order_code_id = order_code.order_code_id");
		   query.append(" left join start_date on order_code.oc_id = start_date.oc_id and year(start_date.from_date) = year(GETDATE())");
		   query.append(" where pkg_content.order_code_id = ? and order_code.active = 1");
		   
		   subscriptList = jdbcTemplate.query(query.toString(), new Object[]{orderItem.getOrderCodeID()},new SubscripMapper());
		   
		   query = new StringBuilder();
		   query.append("select subscription_def.subscription_def_id, subscription_def.oc_id,(case when subscription_def.rate_class_id is null then (pkg_def.rate_class_id) else subscription_def.rate_class_id end) as rate_class_id, ");
		   query.append("rate_class_effective.rate_class_effective_seq,subscription_def.order_code_id, subscription_def.forced_expire_month as duration, ");
		   query.append("pkg_def_content.order_code_id,pkg_def_content.pkg_content_seq,");
		   query.append("pkg_def_content.pkg_item_price_method,pkg_def_content.revenue_percent,order_code.order_code_id as orderCodeID,order_code.taxable as hasTax,order_code.oc_id,order_code.active,order_code.order_code_type,");
		   query.append("order_code.taxable,order_code.item_type,order_code.is_proforma,ratecard.price,ratecard.rate_class_effective_seq,rate_class_effective.mru_ratecard_seq,term.n_issues as orderQty,");
		   query.append("ratecard.price as grossBaseAmount,ratecard.price as grossLocalAmount,ratecard.price as netBaseAmount,ratecard.price as netLocalAmount ");
		   query.append("from pkg_def_content pkg_def_content inner join pkg_def pkg_def on pkg_def.pkg_def_id=pkg_def_content.pkg_def_id ");
		   query.append("inner join  subscription_def subscription_def on subscription_def.subscription_def_id = pkg_def_content.subscription_def_id "); 
		   query.append("inner join order_code on subscription_def.term_id = order_code.term_id and order_code.order_code_id = subscription_def.order_code_id ");
		   query.append("inner join rate_class_effective rate_class_effective on rate_class_effective.rate_class_id = case when subscription_def.rate_class_id is null then(pkg_def.rate_class_id) else subscription_def.rate_class_id end ");
		   query.append("inner join ratecard on ratecard.rate_class_id = rate_class_effective.rate_class_id and ratecard.rate_class_effective_seq = rate_class_effective.rate_class_effective_seq ");
		  // query.append("and ratecard.ratecard_seq = rate_class_effective.mru_ratecard_seq ");
		   query.append("left join term on term.term_id = order_code.term_id ");
		   query.append("where  (ratecard.region=(select region from region_state where state=(select case when state_code_for_taxes is null then state else state_code_for_taxes end as state from state where state=(select top 1 state from customer_address where customer_id="+orderItem.getCustomerId()+")) ");
		   query.append("and region_list='RPSR') or ratecard.region is null) and pkg_def_content.order_code_id = ?  and rate_class_effective.effective_date=( ");
		   query.append("select max(rate_class_effective.effective_date) from rate_class_effective where  rate_class_effective.rate_class_id =  case when subscription_def.rate_class_id is null then(pkg_def.rate_class_id)");
		   query.append(" else subscription_def.rate_class_id end) and pkg_def_content.pkg_def_id = "+orderItem.getPkgDefId()+" ");
		   
		  
		   @SuppressWarnings("unchecked")
		   List<OrderItem> orderItemList = jdbcTemplate.query(query.toString(), new Object[]{orderItem.getOrderCodeID()}, new BeanPropertyRowMapper(OrderItem.class));
		   
		   Set<Integer> orderCodeList = new LinkedHashSet<>();
		     
		   //get unique order code id
		   for (SubscriptModel subscriptModel : subscriptList) {
		    orderCodeList.add(subscriptModel.getOrderCodeId());    
		   }
		   Iterator<Integer> iterator = orderCodeList.iterator();
		   int x=0;
		   while(iterator.hasNext()){
		    OrderItem newOrderItem = orderItemList.get(x);
		    x++; orderItemSeq++;
		    int ordercode = iterator.next();
		    int count = 0;
		    int startIssueId = 0;
		    int stopIssueId = 0;
		    for(SubscriptModel subscriptModel : subscriptList){
		     if(ordercode == subscriptModel.getOrderCodeId()){
		      count++;
		      if(count == 1){
		       startIssueId = subscriptModel.getIssueId();
		      }else{
		       stopIssueId = subscriptModel.getIssueId();
		      }
		     }
		    }
		    
		    if(stopIssueId == 0){
		      stopIssueId = startIssueId;
		    }
		    
		    orderItem.setStartIssueId(String.valueOf(startIssueId));
		    orderItem.setStopIssueId(stopIssueId);
		    
		    //System.out.println("*****Order Item : ***********************"+orderItem);
		    subscripId = addSubscripBasicPackage(orderItem,subscriptList); 
		    
		    /*setEditTrailValue(String.valueOf(orderItem.getCustomerId()), String.valueOf(orderItem.getCustomerAddressSeq()), 
		      orderItem.getUserCode(), String.valueOf(subscripId), String.valueOf(orderHdrId), String.valueOf(orderItemSeq), null, "0", "3", null,
		      orderItem.getDocumentReferenceId(), orderItem.getGrossLocalAmount(), orderItem.getNetBaseAmount(), String.valueOf(orderItem.getDateStamp()), "", 
		      "order_add_request", null, null, null,null, null);*/
		    
		    orderItemAmtBreak.setOrderItemSeq(String.valueOf(x+1));
		    orderItemAmtBreak.setOrderItemAmtBreakSeq("1");
		    orderItemAmtBreak.setOrderItemBreakType("0");
		    orderItemAmtBreak.setLocalAmount(newOrderItem.getGrossLocalAmount());
		    orderItemAmtBreak.setBaseAmount(newOrderItem.getNetBaseAmount());
		    
		    /*setEditTrailValue(null, null, orderItem.getUserCode(), null, String.valueOf(orderHdrId), String.valueOf(orderItemSeq), String.valueOf(count), "0", "6", orderItem.getDocumentReferenceId(), null, 
		      newOrderItem.getGrossLocalAmount(), newOrderItem.getNetBaseAmount(), String.valueOf(orderItem.getDateStamp()), "creationDate", 
		      "order_add_request", null,null, null, null, null);*/
		    newOrderItem.setExpireYear(expireYear);
		    newOrderItem.setnIssueLeft(String.valueOf(count));
		    newOrderItem.setnRemainingPaidIssue(count);
		    newOrderItem.setCustomerId(orderItem.getCustomerId());
		    newOrderItem.setSourceCodeID(orderItem.getSourceCodeID());
		    newOrderItem.setCurrency(orderItem.getCurrency());
		    newOrderItem.setSubscripId(String.valueOf(subscripId));
		    newOrderItem.setStartIssueId(String.valueOf(startIssueId));
		    newOrderItem.setStopIssueId(stopIssueId);
		    newOrderItem.setOrderhdrId(orderHdrId);    
		    newOrderItem.setOrderItemSeq(x+1); 
		    newOrderItem.setSubscripStartType(0);
		    newOrderItem.setExRatecardSeq(String.valueOf(1));
		    newOrderItem.setPkgItemSeq(String.valueOf(1));
		    newOrderItem.setOrigOrderQty(count);
		    newOrderItem.setnNonPaidIssues(0);
		    newOrderItem.setnRemainingNonPaidIssues(0);
		    newOrderItem.setExtendedDays(0);
		    
		    orderItemSave(newOrderItem, newOrderItem.getOrderCodeID(),newOrderItem.getOrderCodeType());
		    orderItemBreakSave(orderHdrId,orderItem.getCustomerId(),orderItemAmtBreak);
		    
//		    orderItemAmtBreak.setLocalAmount("0");
//		    orderItemAmtBreak.setBaseAmount("0");
		    orderItemAmtBreak.setLocalAmount(orderItem.getGrossLocalAmount());
		    orderItemAmtBreak.setBaseAmount(orderItem.getGrossLocalAmount());
		    orderItemAmtBreak.setState(jdbcTemplate.queryForObject("select state from customer_address where customer_id = "+orderItem.getCustomerId(), String.class));
		    orderItemAmtBreak.setTaxType("VATUK");
		    orderItemAmtBreak.setTaxRateCategory("ZERO");
		    orderItemAmtBreak.setTaxRate("0");
		    orderItemAmtBreak.setTaxDelivery("1");
		    orderItemAmtBreak.setTaxActive("1");    
		    orderItemAmtBreak.setOrderItemAmtBreakSeq("2");
		    orderItemAmtBreak.setOrderItemBreakType("1");
		    
		   // System.out.println("orderItemAmtBreak : "+orderItemAmtBreak);
		    
		    orderItemBreakSave(orderHdrId,orderItem.getCustomerId(),orderItemAmtBreak);
		    /*setEditTrailValue(null, null, orderItem.getUserCode(), null, String.valueOf(orderHdrId), String.valueOf(orderItemSeq), String.valueOf(count), "0", "6", "", null, 
		      "0", "0", String.valueOf(orderItem.getDateStamp()), "creationDate", 
		      "order_add_request", null,null, null, null, null);*/
		   }
		      
		  }catch(Exception e){
		   LOGGER.info("CustomerOrderDaoImple : addBasicPackage : "+e);
		  }
		  return true;
		 }
	
	public long addSubscripBasicPackage(OrderItem orderItem, List<SubscriptModel> subscriptList){
		StringBuilder query = new StringBuilder();
		SubscriptModel subscriptModel = new SubscriptModel();
		
		long subscripId = (jdbcTemplate.queryForObject("select max(subscrip_id) from subscrip", Long.class))+1;
		if(!subscriptList.isEmpty()){
			subscriptModel = (SubscriptModel) subscriptList.get(0);
		}
				
		try{
			LOGGER.info("Inside CustomerOrderDaoImple : addSubscripBasicPackage ");
			
			query.append("insert into subscrip (subscrip_id,oc_id,customer_id,source_code_id,orig_order_date,audit_name_change,audit_title_change,n_times_sub_renewed");
			
			if(!subscriptList.isEmpty()){
				query.append(",n_total_issues_left,start_issue_id,stop_issue_id,mru_additions_deletions_seq)");				
			}
			
			if(orderItem.getOrderCodeType() == "4" && subscriptList.isEmpty()){
				query.append(",is_pkg) ");
			}
			query.append("values(:subscrip_id, :oc_id, :customer_id, :source_code_id, GETDATE(), :audit_name_change, :audit_title_change, :n_times_sub_renewed");
			if(orderItem.getOrderCodeType() == "4" && subscriptList.isEmpty()){
				query.append(",:is_pkg) ");
			}
			
			if(!subscriptList.isEmpty()){
				query.append(",:n_total_issues_left, :start_issue_id, :stop_issue_id, :mru_additions_deletions_seq)");				
			}
			
			Map<String, Object> parameter = new HashMap<>();
			parameter.put("subscrip_id", subscripId);
			
			parameter.put("customer_id", orderItem.getCustomerId());
			parameter.put("source_code_id", orderItem.getSourceCodeID());			
			parameter.put("audit_name_change", 0);
			parameter.put("audit_title_change", 0);
			parameter.put("n_times_sub_renewed", 0);
			parameter.put("is_pkg", 1);
			
			if(!subscriptList.isEmpty()){				
				parameter.put("oc_id", subscriptModel.getOcId());
				parameter.put("n_total_issues_left", 1);
				parameter.put("start_issue_id", String.valueOf(orderItem.getStartIssueId()) != null ? orderItem.getStartIssueId() : 0);
				parameter.put("stop_issue_id", String.valueOf(orderItem.getStopIssueId()) != null ? orderItem.getStopIssueId() : 0);
				parameter.put("mru_additions_deletions_seq", 1);				
			}else{
				parameter.put("oc_id", orderItem.getOcId());
			}
			LOGGER.info("**************Save in Subscrip Table. : "+orderItem+"**********************");
			LOGGER.info("Query : "+query);
			LOGGER.info("Parameter : "+parameter);
			int row = namedParameterJdbcTemplate.update(query.toString(), parameter);
			if(row!=0){
				LOGGER.info("Data inserted into subscrip ");
				OrderItemAmtBreak orderItemAmtBreak = new OrderItemAmtBreak();
				orderItemAmtBreak.setState(jdbcTemplate.queryForObject("select max(state) from customer_address where customer_id = "+orderItem.getCustomerId(), String.class));
				orderItemAmtBreak.setTaxType("VATUK");
				orderItemAmtBreak.setTaxRateCategory("ZERO");
				orderItemAmtBreak.setTaxRate("0");
				orderItemAmtBreak.setTaxDelivery("1");
				orderItemAmtBreak.setTaxActive("1");
			}else{
				LOGGER.info("Data not inserted into subscrip ");
			}
		}catch(Exception e){
			LOGGER.info("CustomerOrderDaoImple : addSubscripBasicPackage : "+e);
		}
		return subscripId;
	}
	
	public String orderItemSave(OrderItem orderItem, String orderCodeId, String orderCodeType){

		System.out.println("orderItemSave : Inside : "+orderItem);
		try{
		
		StringBuilder query = new StringBuilder();
		
		query.append("insert into order_item (orderhdr_id,order_item_seq,user_code,currency,source_code_id,date_stamp,order_item_type,order_date,order_qty,");
		query.append("gross_base_amount,gross_local_amount,net_base_amount,net_local_amount,has_tax,has_delivery_charge,bill_date,payment_status,refund_status,");
		query.append("order_type,billing_type,has_premium,prepayment_req,subscrip_id,bundle_qty,is_complimentary,subscrip_start_type,order_code_id,duration,renewal_status,");
		query.append("delivery_method_perm,change_qty_flag,n_remaining_paid_issues,ext_iss_left,ext_iss_tot,order_status,renewal_category,exchange_rate,oc_id,auto_payment,");
		query.append("perpetual_order,bill_to_customer_id,bill_to_customer_address_seq,renew_to_customer_id,renew_to_customer_address_seq,customer_id,customer_address_seq,");
		query.append("note_exist,service_exist,mru_order_item_amt_break_seq,mru_suspension_seq,has_been_renewed,revenue_method,start_date,expire_date,trial_type,");
		query.append("orig_order_qty,unit_excess,is_proforma,n_tax_updates,total_tax_local_amount,total_tax_base_amount,pkg_item_seq,pkg_def_id,electronic_delivery,time_unit_options");
		query.append(",percent_of_basic_price,n_issues_left,subscription_def_id,rate_class_id,rate_class_effective_seq,ratecard_seq,start_issue_id,stop_issue_id,n_remaining_nonpaid_issues,");
		query.append("group_order,invoice_date,auto_renew_notify_sent,extended_days,asynchronous_auto_renew,n_days_graced,is_back_ordered,mru_grp_mbr_item_dtl_seq)");
		query.append("values (:orderhdr_id, :order_item_seq, :user_code, :currency, :source_code_id, :date_stamp, :order_item_type, GETDATE(), :order_qty,");
		query.append(":gross_base_amount, :gross_local_amount, :net_base_amount, :net_local_amount, :has_tax, :has_delivery_charge, GETDATE(), :payment_status, :refund_status,");
		query.append(":order_type, :billing_type, :has_premium, :prepayment_req, :subscrip_id, :bundle_qty, :is_complimentary, :subscrip_start_type, :order_code_id, :duration,:renewal_status,");
		query.append(":delivery_method_perm, :change_qty_flag, :n_remaining_paid_issues, :ext_iss_left, :ext_iss_tot, :order_status, :renewal_category, :exchange_rate, :oc_id, :auto_payment,");
		query.append(":perpetual_order, :bill_to_customer_id, :bill_to_customer_address_seq, :renew_to_customer_id, :renew_to_customer_address_seq, :customer_id, :customer_address_seq,");
		query.append(":note_exist, :service_exist, :mru_order_item_amt_break_seq, :mru_suspension_seq, :has_been_renewed, :revenue_method, GETDATE(), (SELECT DATEADD(year," +orderItem.getExpireYear()+", getdate())), :trial_type,");
		query.append(":orig_order_qty, :unit_excess, :is_proforma, :n_tax_updates, :total_tax_local_amount, :total_tax_base_amount,:pkg_item_seq, :pkg_def_id, :electronic_delivery, :time_unit_options");
		query.append(",:percent_of_basic_price, :n_issues_left, :subscription_def_id, :rate_class_id,:rate_class_effective_seq, :ratecard_seq, :start_issue_id, :stop_issue_id, :n_remaining_nonpaid_issues,");
		query.append(":group_order, GETDATE(), :auto_renew_notify_sent, :extended_days, :asynchronous_auto_renew, :n_days_graced, :is_back_ordered, :mru_grp_mbr_item_dtl_seq)");
		
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("orderhdr_id",orderItem.getOrderhdrId());
		parameter.put("order_item_seq",orderItem.getOrderItemSeq() != 0 ? orderItem.getOrderItemSeq() : 1);
		parameter.put("user_code","THK");
		parameter.put("currency",orderItem.getCurrency() != null ? orderItem.getCurrency() : "");
		parameter.put("delivery_method", orderItem.getDeliveryMethod() != null ? orderItem.getDeliveryMethod() : null);
		parameter.put("source_code_id",orderItem.getSourceCodeID() != null ? orderItem.getSourceCodeID() :null);
		parameter.put("order_category", orderItem.getOrderCategory() != null ? orderItem.getOrderCategory() : null);
		parameter.put("package_id", orderItem.getPackageID() !=null ? orderItem.getPackageID() : null);
		parameter.put("package_content_seq", orderItem.getPackageContentSeq() != null ? orderItem.getPackageContentSeq() : null);
		parameter.put("date_stamp", jdbcTemplate.queryForObject("select max(date_stamp) from date_stamp", Integer.class));
		parameter.put("order_item_type", orderItem.getOrderItemType() != 0 ? orderItem.getOrderItemType() : 0);
		parameter.put("order_qty",orderItem.getOrderQty() != 0 ? orderItem.getOrderQty() : 0);
		parameter.put("gross_base_amount", orderItem.getGrossBaseAmount()!=null?orderItem.getGrossBaseAmount():orderItem.getAmountCharged());
		parameter.put("gross_local_amount", orderItem.getGrossLocalAmount()!=null?orderItem.getGrossLocalAmount():orderItem.getAmountCharged());
		parameter.put("net_base_amount", orderItem.getNetBaseAmount()!=null?orderItem.getNetBaseAmount():orderItem.getAmountCharged());
		parameter.put("net_local_amount", orderItem.getNetLocalAmount()!=null?orderItem.getNetLocalAmount():orderItem.getAmountCharged());
		parameter.put("has_tax",orderItem.getHasTax()!= 0 ? orderItem.getHasTax():1);
		parameter.put("has_delivery_charge", orderItem.getHasDeliveryCharge()!= 0 ? orderItem.getHasDeliveryCharge():0);
		//parameter.put("bill_date", orderItem.getBillDate() != null ? orderItem.getBillDate() : "00:00.0");
		parameter.put("n_inv_efforts",orderItem.getnInvEffort() != null ? orderItem.getnInvEffort() : null);
		parameter.put("last_inv_date", orderItem.getLastInvDate() != null ? orderItem.getLastInvDate() : null);
		parameter.put("payment_status",orderItem.getPaymentStatus() != 0 ? orderItem.getPaymentStatus() : 0);
		parameter.put("refund_status",orderItem.getRefundStatus() != 0 ? orderItem.getRefundStatus() : 0);
		parameter.put("order_type", orderItem.getOrderType() != 0 ? orderItem.getOrderType() : 3);
		parameter.put("billing_type", orderItem.getBillingType() != null ? orderItem.getBillingType() : 1);
		parameter.put("has_premium", orderItem.getHasPremium() != 0 ? orderItem.getHasPremium() : 0);
		parameter.put("prepayment_req", orderItem.getPrepaymentReq() != 0 ? orderItem.getPrepaymentReq() : 1);
		parameter.put("product_id", String.valueOf(orderItem.getProductId()) != null ? orderItem.getProductId() : null);
		parameter.put("ship_qty", String.valueOf(orderItem.getShipQty()) != null ? orderItem.getShipQty() : null);
		parameter.put("backord_qty", String.valueOf(orderItem.getBackordQty()) != null ? orderItem.getBackordQty() : null);
		parameter.put("subscrip_id",orderItem.getSubscripId() != null ? orderItem.getSubscripId() : null);
		parameter.put("bundle_qty", orderItem.getBundleQty() != 0 ? orderItem.getBundleQty() : 1);
		parameter.put("audit_qual_category", orderItem.getAuditQualCategory() != null ? orderItem.getAuditQualCategory() : null);
		parameter.put("is_complimentary", orderItem.getIsComplimentary() != 0 ? orderItem.getIsComplimentary() : 0);
		parameter.put("subscrip_start_type",orderItem.getSubscripStartType() != 0 ? orderItem.getSubscripStartType() : 0);
		parameter.put("order_code_id",orderItem.getOrderCodeID() != null ? orderItem.getOrderCodeID() : null);
		parameter.put("cancel_reason",orderItem.getCancelReason() != null ? orderItem.getCancelReason() : null);
		parameter.put("customer_group_id",orderItem.getCustomerGroupId() != null ? orderItem.getCustomerGroupId() : null);
		parameter.put("audit_qual_source_id",orderItem.getAuditSourceId() != null ? orderItem.getAuditSourceId() : null);
		parameter.put("audit_subscription_type_id",orderItem.getAuditSubscriptionTypeId() != null ? orderItem.getAuditSubscriptionTypeId() : null);
		parameter.put("percent_of_basic_price",orderItem.getPercentOfBasicPrice() != null ? orderItem.getPercentOfBasicPrice() : null);		
		parameter.put("duration",orderItem.getDuration() != 0 ? orderItem.getDuration() : 0);
		parameter.put("renewal_status",orderItem.getRevenueMethod() != 0 ? orderItem.getRevenueMethod() : 0);
		parameter.put("delivery_method_perm",orderItem.getDeliveryMethodPerm() != 0 ? orderItem.getDeliveryMethodPerm() : 0);
		parameter.put("change_qty_flag",orderItem.getChangeQtyFlag() != 0 ? orderItem.getChangeQtyFlag() : 0);
		parameter.put("n_issues_left", orderItem.getnIssueLeft() != null ? orderItem.getnIssueLeft() : null);
		
		System.out.println("NIssueLeft : "+orderItem.getnIssueLeft());
		System.out.println("getnRemainingPaidIssue : "+orderItem.getnRemainingPaidIssue());
		parameter.put("n_ren_effort", orderItem.getnRenEffort() != null ? orderItem.getnRenEffort() : 0);
		parameter.put("last_ren_date", orderItem.getLastRenDate() != null ? orderItem.getLastRenDate() : 0);
		parameter.put("n_del_iss_left", orderItem.getnDelIssLeft() != null ? orderItem.getnDelIssLeft() : 0);
		parameter.put("n_remaining_paid_issues",orderItem.getnRemainingPaidIssue() != 0 ? orderItem.getnRemainingPaidIssue() : 0);
		parameter.put("ext_iss_left",orderItem.getExtIssleft() != 0 ? orderItem.getExtIssleft() : 0);
		parameter.put("ext_iss_tot",orderItem.getExtIssTot() != 0 ? orderItem.getExtIssTot() : 0);
		parameter.put("audit_name_title_id", orderItem.getAuditNameTitleId() != null ? orderItem.getAuditNameTitleId() : null);
		parameter.put("audit_sales_channel_id", orderItem.getAuditSalesChannelId() != null ? orderItem.getAuditSalesChannelId() : null);
		parameter.put("qual_date", orderItem.getQualDate() != null ? orderItem.getQualDate() : null);
		parameter.put("squal_date", orderItem.getSqualDate() != null ? orderItem.getSqualDate() : null);			
		parameter.put("order_status", orderItem.getOrderStatus() != 0 ? orderItem.getOrderStatus() : 10); // 10 : hold for payment
		parameter.put("renewal_category",orderItem.getRenewalCategory() != 0 ? orderItem.getRenewalCategory() : 0);
		parameter.put("exchange_rate",orderItem.getExchangeRate() != null ? orderItem.getExchangeRate() : 1);
		parameter.put("oc_id", orderItem.getOcId() != 0 ? orderItem.getOcId() : 0);
		parameter.put("auto_payment",orderItem.getAutoPayment() != 0 ? orderItem.getAutoPayment() : 0);
		parameter.put("perpetual_order",orderItem.getPerpetualOrder() != 0 ? orderItem.getPerpetualOrder() : 0	);
		parameter.put("bill_to_customer_id",orderItem.getCustomerId() != 0 ? orderItem.getCustomerId() : 0);
		parameter.put("bill_to_customer_address_seq",orderItem.getBillToCustomerAddressSeq() != 0 ? orderItem.getBillToCustomerAddressSeq() : 1);
		parameter.put("renew_to_customer_id",orderItem.getCustomerId() != 0 ? orderItem.getCustomerId() : 0);
		parameter.put("renew_to_customer_address_seq",orderItem.getRenewToCustomerAddressSeq() != 0 ? orderItem.getRenewToCustomerAddressSeq() : 1);
		parameter.put("customer_id",orderItem.getCustomerId() != 0 ? orderItem.getCustomerId() : 0);
		parameter.put("customer_address_seq", orderItem.getCustomerAddressSeq() != 0 ? orderItem.getCustomerAddressSeq() : 1);
		parameter.put("note_exist", orderItem.getNoteExist() != 0 ? orderItem.getNoteExist() : 0);
		parameter.put("service_exist", orderItem.getServiceExist() != 0 ? orderItem.getServiceExist() : 0);
		parameter.put("mru_order_item_amt_break_seq",orderItem.getMruOrderItemAmtBreakSeq() != 0 ? orderItem.getMruOrderItemAmtBreakSeq() : 2);
		parameter.put("mru_suspension_seq",orderItem.getMruSuspensionSeq() != null ? orderItem.getMruSuspensionSeq() : 1);
		parameter.put("has_been_renewed",orderItem.getHasBeenRenewed() != 0 ? orderItem.getHasBeenRenewed() : 0);
		parameter.put("revenue_method", orderItem.getRevenueMethod() != 0 ? orderItem.getRevenueMethod() : 0);
		
		parameter.put("trial_type",orderItem.getTrialType() != 0 ? orderItem.getTrialType() : 0);
		parameter.put("orig_order_qty",orderItem.getOrigOrderQty() != 0 ? orderItem.getOrigOrderQty() : 0);
	//	parameter.put("unit_excess",orderItem.getUnitExcess() != 0 ? orderItem.getUnitExcess() : 0);
		parameter.put("is_proforma",orderItem.getIsProforma() != 0 ? orderItem.getIsProforma() : 1);
		parameter.put("n_tax_updates",orderItem.getnTaxUpdates() != 0 ? orderItem.getnTaxUpdates() : 0);
		parameter.put("total_tax_local_amount",orderItem.getTotalTaxLocalAmount() != null ? orderItem.getTotalTaxLocalAmount() : 0);
		parameter.put("total_tax_base_amount",orderItem.getTotalTaxBaseAmount() != null ? orderItem.getTotalTaxBaseAmount() : 0);
		parameter.put("pkg_def_id", orderItem.getPkgDefId() != null ? orderItem.getPkgDefId() : null);
		parameter.put("electronic_delivery",orderItem.getElectronicDelivery() != 0 ? orderItem.getElectronicDelivery() : 0);
		parameter.put("time_unit_options",orderItem.getTimeUnitOptions() != 0 ? orderItem.getTimeUnitOptions() : 0);
		parameter.put("group_order",orderItem.getGroupOrder() != 0 ? orderItem.getGroupOrder() : 0);
		parameter.put("invoice_date",orderItem.getInvoiceDate() != null ? orderItem.getInvoiceDate() : null);
		parameter.put("auto_renew_notify_sent",orderItem.getAutoRenewNotifySent() != 0 ? orderItem.getAutoRenewNotifySent() : 0);
		parameter.put("extended_days",orderItem.getExtendedDays() != 0 ? orderItem.getExtendedDays() : null);
		parameter.put("asynchronous_auto_renew",orderItem.getAsynchronousAutoRenew() != 0 ? orderItem.getAsynchronousAutoRenew() : 0);
		parameter.put("n_days_graced",orderItem.getnDaysGraced() != 0 ? orderItem.getnDaysGraced() : 0);
		parameter.put("is_back_ordered",orderItem.getIsBackOrdered() != 0 ? orderItem.getIsBackOrdered() : 0);
		parameter.put("mru_grp_mbr_item_dtl_seq",orderItem.getMruGrpMbrItemDtlSeq() != 0 ? orderItem.getMruGrpMbrItemDtlSeq() : 0);
		parameter.put("percent_of_basic_price", orderItem.getPercentOfBasicPrice() != null ? orderItem.getPercentOfBasicPrice() : null);
		parameter.put("n_issues_left",orderItem.getnIssueLeft() != null ? orderItem.getnIssueLeft() : 0);
		parameter.put("subscription_def_id",orderItem.getSubscriptionDefId() != null ? orderItem.getSubscriptionDefId() : null);
		parameter.put("rate_class_id",orderItem.getRateClassId() != 0 ? orderItem.getRateClassId() : null); 
		parameter.put("rate_class_effective_seq",orderItem.getRateClassEffectiveSeq() != 0 ? orderItem.getRateClassEffectiveSeq() : null);
		parameter.put("ratecard_seq",orderItem.getExRatecardSeq() != null ? orderItem.getExRatecardSeq() : null);
		parameter.put("start_issue_id",orderItem.getStartIssueId() != null ? orderItem.getStartIssueId() : null);
		parameter.put("stop_issue_id",orderItem.getStopIssueId() != 0 ? orderItem.getStopIssueId() : null);
		parameter.put("n_remaining_nonpaid_issues",orderItem.getnRemainingNonPaidIssues() != 0 ? orderItem.getnRemainingNonPaidIssues() : null);
		parameter.put("pkg_item_seq", orderItem.getPkgItemSeq() != null ? orderItem.getPkgItemSeq() : null);
		LOGGER.info("**************Save in Order Item Table.**********************");
		LOGGER.info("Query : "+query);
		LOGGER.info("Parameter : "+parameter);
		
		int row = namedParameterJdbcTemplate.update(query.toString(), parameter);
		if(row!=0){
			LOGGER.info("Data inserted into order_item ");
		}else{
			LOGGER.info("Data not inserted into order_item ");
		}
		
		}catch(Exception e){
			LOGGER.error("Order Item Save : "+e);
		}
		return null;
	
	}
	
	public void editTrail(EditTrailModel editTrail){
		try{
			StringBuilder query = new StringBuilder();
			Map<String, Object> parameter = new HashMap<>();
			query.append("insert into edit_trail(edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,order_item_amt_break_seq,edited,currency,table_enum,");
			query.append("document_reference_id,document_reference_seq,local_amount,base_amount,date_stamp,creation_date,xaction_name,payment_seq,demographic_seq,job_id,payment_account_seq,service_seq)");
			query.append("values(:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:order_item_amt_break_seq,:edited,:currency,:table_enum,");
			query.append(":document_reference_id,:document_reference_seq,:local_amount,:base_amount,:date_stamp,GETDATE(),:xaction_name,:payment_seq,:demographic_seq,:job_id,:payment_account_seq,:service_seq)");
			
			parameter.put("edit_trail_id", editTrail.getEditTrailId());	
			parameter.put("customer_id", editTrail.getCustomerId() != null ? editTrail.getCustomerId() : 0 );	
			parameter.put("customer_address_seq", editTrail.getCustomerAddressSeq() != null ? editTrail.getCustomerAddressSeq() : null);	
			parameter.put("user_code", "ps");	
			parameter.put("subscrip_id", editTrail.getSubscripId() != null ? editTrail.getSubscripId() : null);	
			parameter.put("orderhdr_id", editTrail.getOrderhdrId() != null ? editTrail.getOrderhdrId() : null);	
			parameter.put("order_item_seq", editTrail.getOrderItemSeq() != null ? editTrail.getOrderItemSeq() : null);	
			parameter.put("order_item_amt_break_seq", editTrail.getOrderItemAmtBreakSeq() != null ? editTrail.getOrderItemAmtBreakSeq() : null);	
			parameter.put("edited", editTrail.getEdited() != null ? editTrail.getEdited() : "0");	
			parameter.put("currency", editTrail.getCurrency() != null ? editTrail.getCurrency() : null);	
			parameter.put("table_enum", editTrail.getTableEnum() != null ? editTrail.getTableEnum() : "0");
			parameter.put("document_reference_id","10262");
			//parameter.put("document_reference_id", editTrail.getDocumentReferenceId() != null ? editTrail.getDocumentReferenceId() : null);	
			parameter.put("document_reference_seq", editTrail.getDocumentReferenceSeq() != null ? editTrail.getDocumentReferenceSeq() : null);	
			parameter.put("local_amount", editTrail.getLocalAmount() != null ? editTrail.getLocalAmount() : "0.0");	
			parameter.put("base_amount", editTrail.getBaseAmount() != null ? editTrail.getBaseAmount() : "0.0");	
			parameter.put("date_stamp", editTrail.getDateStamp() != null ? editTrail.getDateStamp() : null);	
			//parameter.put("creation_date", editTrail.getCreationDate() != null ? editTrail.getCreationDate() : null);	
			parameter.put("xaction_name", editTrail.getXactionName() != null ? editTrail.getXactionName() : null);	
			parameter.put("payment_seq", editTrail.getPaymentSeq() != null ? editTrail.getPaymentSeq() : null);	
			parameter.put("demographic_seq", editTrail.getDemographicSeq() != null ? editTrail.getDemographicSeq() : null);	
			parameter.put("job_id", editTrail.getJobId() != null ? editTrail.getJobId() : null);	
			parameter.put("payment_account_seq", editTrail.getPaymentAccountSeq() != null ? editTrail.getPaymentAccountSeq() : null);
			parameter.put("service_seq",editTrail.getServiceSeq() != null ? editTrail.getServiceSeq() : null);
			
			LOGGER.info("************** Edit trail **********************"+parameter);
			int row = namedParameterJdbcTemplate.update(query.toString(), parameter);
			
			LOGGER.info("**************Save in Edit_trail Table.**********************");
			LOGGER.info("Query : "+query);
			LOGGER.info("Parameter : "+parameter);
			
		}catch(Exception e){
			LOGGER.info("editTrail : "+e);
		}
	}
	
	public void orderItemBreakSave(long orderHdrId, long customerId, OrderItemAmtBreak orderItemAmtBreak){
		try{
			System.out.println("orderItemBreakSave : OrderItem : "+orderItemAmtBreak);
			/*String orderItemBreakQuery = "insert into order_item_amt_break (orderhdr_id,order_item_seq,order_item_amt_break_seq,order_item_break_type,local_amount,base_amount,tax_delivery,tax_active) values "
					+ " (:orderhdr_id, :order_item_seq, :order_item_amt_break_seq, :order_item_break_type, :local_amount, :base_amount, :tax_delivery, :tax_active)";
*/
			StringBuilder query = new StringBuilder();
			query.append("insert into order_item_amt_break (orderhdr_id,order_item_seq,order_item_amt_break_seq,order_item_break_type,local_amount,base_amount,");
			query.append("state,tax_type,tax_rate_category,effective_date,orig_base_amount,tax_rate,tax_delivery,tax_active,");
			query.append("vrtx_jurisdiction,vrtx_jurisdiction_level,vrtx_tax_type) values");
			query.append("(:orderhdr_id,:order_item_seq,:order_item_amt_break_seq,:order_item_break_type,:local_amount,:base_amount,");
			query.append(":state,:tax_type,:tax_rate_category,GETDATE(),:orig_base_amount,:tax_rate,:tax_delivery,:tax_active,");
			query.append(":vrtx_jurisdiction,:vrtx_jurisdiction_level,:vrtx_tax_type)");
			
			Map<String, Object> itemBreakParameters = new HashMap<String,Object>();
			
			itemBreakParameters.put("orderhdr_id", orderItemAmtBreak.getOrderhdrId());
			itemBreakParameters.put("order_item_seq", String.valueOf(orderItemAmtBreak.getOrderItemSeq()) != null ? orderItemAmtBreak.getOrderItemSeq() : 1);
			itemBreakParameters.put("order_item_amt_break_seq", orderItemAmtBreak.getOrderItemAmtBreakSeq() != null ? orderItemAmtBreak.getOrderItemAmtBreakSeq() : 1);
			itemBreakParameters.put("order_item_break_type", orderItemAmtBreak.getOrderItemBreakType() != null ? orderItemAmtBreak.getOrderItemBreakType() : 0);
			itemBreakParameters.put("local_amount", orderItemAmtBreak.getLocalAmount() != null ? orderItemAmtBreak.getLocalAmount() : "0.0");
			itemBreakParameters.put("base_amount",  orderItemAmtBreak.getBaseAmount() != null ? orderItemAmtBreak.getBaseAmount() : "0.0");
			itemBreakParameters.put("jurisdiction_seq", orderItemAmtBreak.getJurisdictionSeq() != null ? orderItemAmtBreak.getJurisdictionSeq() : null);
			itemBreakParameters.put("state", jdbcTemplate.queryForObject("select state from customer_address where customer_id = "+customerId, String.class));
			itemBreakParameters.put("tax_type", orderItemAmtBreak.getTaxType() != null ? orderItemAmtBreak.getTaxType() : null);
			itemBreakParameters.put("tax_rate_category", orderItemAmtBreak.getTaxRateCategory() != null ? orderItemAmtBreak.getTaxRateCategory() : null);
			itemBreakParameters.put("orig_base_amount", orderItemAmtBreak.getOrigBaseAmount() != null ? orderItemAmtBreak.getOrigBaseAmount() : 0);
			itemBreakParameters.put("tax_rate",  orderItemAmtBreak.getTaxRate() != null ? orderItemAmtBreak.getTaxRate() : 0);
			itemBreakParameters.put("tax_delivery", orderItemAmtBreak.getTaxDelivery() != null ? orderItemAmtBreak.getTaxDelivery() : 0);
			itemBreakParameters.put("tax_active", orderItemAmtBreak.getTaxActive() != null ? orderItemAmtBreak.getTaxActive() : 0);
			itemBreakParameters.put("vrtx_jurisdiction", orderItemAmtBreak.getVrtxJurisdiction() != null ? orderItemAmtBreak.getVrtxJurisdiction() : null);
			itemBreakParameters.put("vrtx_jurisdiction_level", orderItemAmtBreak.getVrtxJurisdictionLevel() != null ? orderItemAmtBreak.getVrtxJurisdictionLevel() : 1);
			itemBreakParameters.put("vrtx_tax_type", orderItemAmtBreak.getVrtxJurisdictionLevel() != null ? orderItemAmtBreak.getVrtxJurisdictionLevel() : null);
			//itemBreakParameters.put("tx_incl", orderItemAmtBreak.getTxIncl() != null ? orderItemAmtBreak.getTxIncl() : 0);
			
			LOGGER.info("**************Save in order_item_amt_break Table.**********************");
			LOGGER.info("Query : "+query);
			LOGGER.info("Parameter : "+itemBreakParameters);
			
			namedParameterJdbcTemplate.update(query.toString(), itemBreakParameters);	
		}catch(Exception e){
			LOGGER.info("orderItemBreakSave : "+e);
		}		
	}
	
	public EditTrailModel setEditTrailValue(String customerId, String customerAddressSeq, String userCode, String subscripId,	String orderhdrId, String orderItemSeq, String orderItemAmtBreakSeq, String edited, String tableEnum, String documentReferenceId, String documentReferenceSeq, String localAmount,String baseAmount,String dateStamp, String creationDate, String xactionName,String paymentSeq,String demographicSeq, String jobId, String paymentAccountSeq, String serviceSeq){
		EditTrailModel editTrailModel = new EditTrailModel();
		
		editTrailModel.setEditTrailId(jdbcTemplate.queryForObject("select max(edit_trail_id)+1 from edit_trail",Long.class));			
		editTrailModel.setCustomerId(customerId);			
		editTrailModel.setCustomerAddressSeq(customerAddressSeq);	
		editTrailModel.setUserCode(userCode != null ? userCode : " ");	
		editTrailModel.setSubscripId(subscripId);	
		editTrailModel.setOrderhdrId(orderhdrId);	
		editTrailModel.setOrderItemSeq(orderItemSeq);	
		editTrailModel.setOrderItemAmtBreakSeq(orderItemAmtBreakSeq);	
		editTrailModel.setEdited(edited);	
		editTrailModel.setCurrency(jdbcTemplate.queryForObject("select state.currency from customer_address,state where customer_id = "+customerId+" and state.state = customer_address.state",String.class));
		editTrailModel.setTableEnum(tableEnum);	
		editTrailModel.setDocumentReferenceId(documentReferenceId);	
		editTrailModel.setDocumentReferenceSeq(documentReferenceSeq);	
		editTrailModel.setLocalAmount(localAmount);	
		editTrailModel.setBaseAmount(baseAmount);	
		editTrailModel.setDateStamp(String.valueOf(5689));	
		editTrailModel.setCreationDate(creationDate);	
		editTrailModel.setXactionName("order_add_request");	
		editTrailModel.setPaymentSeq(paymentSeq);	
		editTrailModel.setDemographicSeq(demographicSeq);	
		editTrailModel.setJobId(jobId);	
		editTrailModel.setPaymentAccountSeq(paymentAccountSeq);
		editTrailModel.setServiceSeq(serviceSeq);
		System.out.println("editTrailModel : "+editTrailModel);
		editTrail(editTrailModel);
		System.out.println("editTrailModel after: "+editTrailModel);
		return editTrailModel;
	}

	@Override
	public List<SubscriptionDefinition> getSubscriptionDefList(int customerId, int orderCodeId, int subscriptionDefId, int orderCodeType) {
		List<SubscriptionDefinition> subscriptionPackageDefList = new ArrayList<>();		
		try{			
			String subsriptionQuery = " select top 1 order_code.*, oc.*, term.*, subscription_def.*, rate_class_effective.*, ratecard.currency,ratecard.price as ratecard_price from order_code order_code "
						+ " left join oc oc on oc.oc_id = order_code.oc_id "
						+ " left join term term on term.term_id = order_code.term_id "
						+ " left join subscription_def subscription_def on subscription_def.order_code_id = order_code.order_code_id "
						+ " left join rate_class_effective rate_class_effective on rate_class_effective.rate_class_id = subscription_def.rate_class_id "
						+ " left join ratecard ratecard on(ratecard.rate_class_effective_seq = rate_class_effective.rate_class_effective_seq "
						+ " and ratecard.ratecard_seq = rate_class_effective.mru_ratecard_seq and ratecard.rate_class_id = rate_class_effective.rate_class_id) "
						+ " where order_code.order_code_id = ? and subscription_def.subscription_def_id = ? ";

			subscriptionPackageDefList = jdbcTemplate.query(subsriptionQuery,new Object[]{orderCodeId,subscriptionDefId}, new SubscriptionPackageDefMapper());				
		}catch(Exception e){
			LOGGER.info("getSubscription : "+e);
		}
		return subscriptionPackageDefList;
	}

	@Override
	public List<BasicPackageItemModel> getBasicPackageDefList(int customerId, int orderCodeId,int sourceCodeId, int packageDefId, int orderCodeType,String subscriptionIdList,Optional<Integer> docRefId) {
		
		List<BasicPackageItemModel> basicPackageItemModelsList = new ArrayList<>();
		List<BasicPackageItemModel> basicPackageItemModelList = new ArrayList<>();
		List<BasicPackageItemModel> basicPackageItemModelLists = new ArrayList<>();
		List<BasicPackageItemModel> packageItemList = new ArrayList<>();
		List<Map<String, Object>> currencyExchangeList=null;
		double totalPrice=0.0,localAmount=0,baseAmount=0,totalTaxLocalAmount=0,totalTaxBaseAmount=0;int pkgDefId=0,counter = 0;
		List<PackageDefinition> basicPackageList = null;
		String[] subscriptionIdList1 = null;
		List<String> subscriptionIdListFromFronEnd = new ArrayList<String>();					
		try{			
			StringBuilder query = new StringBuilder();
			StringBuilder customerQuery = new StringBuilder();
			
			//it checks that subscriptionIdList is empty or not
			Predicate<String> isSubscriptionIdListNotEmpty = _subscriptionIdList -> _subscriptionIdList.length() > 0;
			if(isSubscriptionIdListNotEmpty.test(subscriptionIdList)) {
				subscriptionIdList1 = subscriptionIdList.split(",");
				subscriptionIdListFromFronEnd = Arrays.asList(subscriptionIdList1);
			}
			basicPackageList = getBasicPackageList(Integer.valueOf(orderCodeId));
			if (basicPackageList.size() != 0 && basicPackageList.size() == 1) {
				pkgDefId =  Integer.parseInt(basicPackageList.get(0).getPkgDefId());
			}else {
				if(packageDefId == 0) {//this is for basic,pool and adhoc package
				pkgDefId = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
				}else {//this is for quick order
					pkgDefId = packageDefId;
				}
			}
				query.append("select pkg_def_content.pkg_def_id, pkg_def_content.order_code_id, pkg_def_content.pkg_content_seq,pkg_content.qty,item_order_code_id,");
				query.append("pkg_def_content.subscription_def_id, order_code.order_code,oc.oc,pkg_def_content.revenue_percent,oc.oc_id,case when subscription_def.rate_class_id is null then (case when order_code.newsub_rate_class_id is not null " ); 
				query.append("then order_code.newsub_rate_class_id else pkg_def.rate_class_id end) else subscription_def.rate_class_id end as rate_class_id, ");
				query.append("pkg_def_content.issue_id,pkg_def_content.product_id,pkg_def_content.subscription_def_id , ");
				query.append("(select order_code_type from order_code where order_code.order_code_id=pkg_content.item_order_code_id)as orderCodeType, ");
				query.append("(select oc_id from order_code where order_code.order_code_id=pkg_content.item_order_code_id)as contentOcId, pkg_def.pkg_price_method  ");
				query.append("from pkg_def inner join pkg_def_content on pkg_def.pkg_def_id=pkg_def_content.pkg_def_id ");  
				query.append("inner join pkg_content on pkg_content.pkg_content_seq=pkg_def_content.pkg_content_seq ");
				query.append("inner join order_code on order_code.order_code_id= pkg_content.order_code_id ");
				query.append("inner join oc on oc.oc_id = order_code.oc_id left join subscription_def on subscription_def.subscription_def_id = pkg_def_content.subscription_def_id ");
				query.append("where pkg_def_content.order_code_id = '"+orderCodeId+"' and pkg_def_content.pkg_def_id = '"+pkgDefId+"' and order_code.order_code_id = '"+orderCodeId+"'");
				if(orderCodeType==6) {
				
					query.append(" and pkg_content.required=1 ");
					
				}
				basicPackageItemModelsList = jdbcTemplate.query(query.toString(),new BasicPackageItemMapper());
				
				double price=0.0;double taxRate=0.0;double pkgPrice=0.0;
		    for(BasicPackageItemModel basicPackageItemModel : basicPackageItemModelsList){
		    	String currencyQuery="select top 1 state.currency,exchange_rate,state.state from customer_address left join state on customer_address.state = state.state left join region_state " 
						+ "on (state.state_code_for_taxes = region_state.state or state.state = region_state.state) left join "
						+ "ratecard on ratecard.region =  region_state.region join currency on currency.currency=state.currency where customer_address.customer_id = ? " ;
				
				currencyExchangeList= jdbcTemplate.queryForList(currencyQuery, new Object[]{customerId});
				
				for(Map<String,Object> map:currencyExchangeList){
					basicPackageItemModel.setState(map.get("state").toString());
					basicPackageItemModel.setCurrency(map.get("currency").toString());
					basicPackageItemModel.setExchange_rate(map.get("exchange_rate").toString());
				}			
				basicPackageItemModelList.add(basicPackageItemModel);
			}	    
			   // double taxAmt=0.0;
				BasicPackageItemModel basicPackageItemModel=new BasicPackageItemModel();
				basicPackageItemModel.setOrderCode(basicPackageItemModelList.get(0).getOrderCode().toString());
				basicPackageItemModel.setOrderCodeId(orderCodeId);// this is added because of orderCodeId=0
				basicPackageItemModel.setOrderClass(basicPackageItemModelList.get(0).getOrderClass().toString());
				basicPackageItemModel.setPkgDefId(basicPackageItemModelList.get(0).getPkgDefId());
				basicPackageItemModel.setState(basicPackageItemModelList.get(0).getState().toString());
				basicPackageItemModel.setCurrency(basicPackageItemModelList.get(0).getCurrency().toString());
				basicPackageItemModel.setExchange_rate(basicPackageItemModelList.get(0).getExchange_rate().toString());
				basicPackageItemModel.setOcId(basicPackageItemModelList.get(0).getOcId());
				basicPackageItemModel.setBillingType(basicPackageItemModelList.get(0).getBillingType().toString());
				basicPackageItemModel.setBundleQty(basicPackageItemModelList.get(0).getBundleQty());
				basicPackageItemModel.setOrderQty(basicPackageItemModelList.get(0).getOrderQty());
				basicPackageItemModel.setPkgPriceMethod(basicPackageItemModelList.get(0).getPkgPriceMethod());
								
					basicPackageItemModelLists.add(basicPackageItemModel);	
					OrderItem orderItem=new OrderItem();
					orderItem.setOrderCodeType(String.valueOf(orderCodeType));
					orderItem.setOrderCodeID(String.valueOf(orderCodeId));
					orderItem.setSourceCodeID(String.valueOf(sourceCodeId));
					orderItem.setDocRefId(docRefId.get());
					orderItem.setCustomerId(customerId);
					orderItem.setPkgDefId(String.valueOf(packageDefId));
					List<Order_add_response> orderProgress= orderAddWsdl.orderProgressAddAdd(orderItem,packageDefId,1, subscriptionIdList);
					for (BasicPackageItemModel basicPackageItem : basicPackageItemModelLists) {
						for(Order_add_response map:orderProgress){
							double netLocalAmt=Double.parseDouble(map.getOrderhdr().getOrder_item(0).getNet_local_amount().toString());
							double netBaseAmt =Double.parseDouble(map.getOrderhdr().getOrder_item(0).getNet_base_amount().toString());
							double taxLocal=Double.parseDouble(map.getOrderhdr().getOrder_item(0).getTotal_tax_local_amount().toString());
							double taxBase =Double.parseDouble(map.getOrderhdr().getOrder_item(0).getTotal_tax_base_amount().toString());
							
							basicPackageItem.setLocalAmount(netLocalAmt-taxLocal);
							basicPackageItem.setBaseAmount(netBaseAmt-taxBase);
							basicPackageItem.setTotalTaxLocalAmount(taxLocal);
						    basicPackageItem.setTotalTaxBaseAmount(taxBase);
						
							if(String.valueOf(basicPackageItem.getLocalAmount()).equals("0.0")) {
								int noCharge=jdbcTemplate.queryForObject("select no_charge from order_code where order_code_id="+orderCodeId+"", Integer.class);
								if(noCharge==1) {
									basicPackageItem.setBillingType("Undefined");
								}else{
									basicPackageItem.setBillingType("Balance Due");
								}
							}else {
								
								basicPackageItem.setBillingType("Balance Due");}
							
							   
						}				
						packageItemList.add(basicPackageItem);
					}
		}catch(Exception e){
			LOGGER.info("CustomerOrderDaoImpl -> getPackageDefList : "+e);
		}
		return packageItemList;
	}
	
	@Override
	public List<BasicPackageItemModel> onPkgDefChange(int customerId, int orderCodeId, int packageDefId, int orderCodeType) {
		
		List<BasicPackageItemModel> basicPackageItemModelsList = new ArrayList<>();
		List<BasicPackageItemModel> basicPackageItemModelList = new ArrayList<>();
		List<Map<String, Object>> currencyExchangeList=null;
		double totalPrice=0.0;
		try{			
			StringBuilder query = new StringBuilder();
			StringBuilder customerQuery = new StringBuilder();
			StringBuilder taxQuery = new StringBuilder();
				query.append("select pkg_def_content.pkg_def_id, pkg_def_content.order_code_id, pkg_def_content.pkg_content_seq,pkg_content.qty,item_order_code_id,");
				query.append("pkg_def_content.subscription_def_id, order_code.order_code,oc.oc,pkg_def_content.revenue_percent,oc.oc_id,case when subscription_def.rate_class_id is null then (case when order_code.newsub_rate_class_id is not null " ); 
				query.append("then order_code.newsub_rate_class_id else pkg_def.rate_class_id end) else subscription_def.rate_class_id end as rate_class_id ");
				query.append("from pkg_def,pkg_def_content,pkg_content,subscription_def,order_code,oc ");
				query.append("where pkg_def_content.order_code_id = ? and pkg_def_content.pkg_def_id = ? ");
				query.append("and pkg_def_content.subscription_def_id = subscription_def.subscription_def_id and order_code.order_code_id = ? and pkg_def.pkg_def_id=pkg_def_content.pkg_def_id and oc.oc_id = order_code.oc_id  and pkg_content.order_code_id= order_code.order_code_id "); 
				query.append("and pkg_content.pkg_content_seq=pkg_def_content.pkg_content_seq");
				basicPackageItemModelsList = jdbcTemplate.query(query.toString(), new Object[]{orderCodeId,packageDefId,orderCodeId},new BasicPackageItemMapper());
				
				double price=0.0 ;double taxRate=0.0;
			    for(BasicPackageItemModel basicPackageItemModel : basicPackageItemModelsList){
				customerQuery.append("select top 1 cast(case when "+basicPackageItemModel.getRevenuePercent()+" = 0  then ((100)/100)*ratecard.price else  (("+basicPackageItemModel.getRevenuePercent()+")/100)*ratecard.price end as  decimal(10,2))as price from customer_address ");
				customerQuery.append("left join state on customer_address.state = state.state ");
				customerQuery.append("left join region_state on (state.state_code_for_taxes = region_state.state or state.state = region_state.state) ");
				customerQuery.append("left join ratecard on ratecard.region =  region_state.region ");
				customerQuery.append("where customer_address.customer_id = ? and ratecard.rate_class_id = ? order by ratecard.price desc");				
				
				price = jdbcTemplate.queryForObject(customerQuery.toString(), new Object[]{customerId,basicPackageItemModel.getRateClassId()}, Double.class);
				taxQuery.append("select top 1 cast(case when (special_tax_id!=0) then 0 else ((tax_rate_commodity.tax_rate/100)* ("+price+")) end as decimal(10,2)) as price "); 
				taxQuery.append("from customer_address customer_address ");
				taxQuery.append("left join state state on state.state = customer_address.state ");
				taxQuery.append("left join tax_rate_commodity tax_rate_commodity on tax_rate_commodity.state =state.state or tax_rate_commodity.state = state.state_code_for_taxes ");
				taxQuery.append("left join order_code order_code on order_code.commodity_code = tax_rate_commodity.commodity_code ");
				taxQuery.append("where customer_address.customer_id =? and  order_code.order_code_id= ? order by tax_rate_commodity.effective_date desc ");
				try {
				taxRate=jdbcTemplate.queryForObject(taxQuery.toString(), new Object[]{customerId,basicPackageItemModel.getOrderCodeId()}, Double.class); 
				}
				catch(Exception e){
					LOGGER.info("taxRate -> taxRate : "+e);
				} 
				String currencyQuery="select top 1 state.currency,exchange_rate from customer_address left join state on customer_address.state = state.state left join region_state " 
						+ "on (state.state_code_for_taxes = region_state.state or state.state = region_state.state) left join "
						+ "ratecard on ratecard.region =  region_state.region join currency on currency.currency=state.currency where customer_address.customer_id = ? " ;
				
				currencyExchangeList= jdbcTemplate.queryForList(currencyQuery, new Object[]{customerId});
				
				for(Map<String,Object> map:currencyExchangeList){
					
					basicPackageItemModel.setCurrency(map.get("currency").toString());
					basicPackageItemModel.setExchange_rate(map.get("exchange_rate").toString());
				}
				totalPrice = totalPrice + price;
				basicPackageItemModel.setPrice(String.valueOf(price));
			//	basicPackageItemModel.setAmountCharged(totalPrice);	
				basicPackageItemModel.setTaxAmt(taxRate);
				basicPackageItemModelList.add(basicPackageItemModel);
				customerQuery.setLength(0);
				taxQuery.setLength(0);
				
			}
		}catch(Exception e){
			LOGGER.info("CustomerOrderDaoImpl -> getPackageDefList : "+e);
		}
		return basicPackageItemModelList;
		
	}

	@Override
	public long getPackageTaxRate(long customerId,  String commodityCode){
		long taxRate = 0;
		try{
			StringBuilder customerQuery = new StringBuilder();
			StringBuilder taxRateQuery = new StringBuilder();
			customerQuery.append("select top 1 customer_address.customer_id, customer_address.state, state.currency, state.state_code_for_taxes ");
			customerQuery.append("from customer_address customer_address, state state ");
			customerQuery.append("where customer_address.customer_id = ? and customer_address.state = state.state");
			
			List<CustomerAddressModel> customerInformationList = jdbcTemplate.query(customerQuery.toString(), new Object[]{customerId}, new CustomerInformationMapper());
			System.out.println("customerInformationList = " +customerInformationList);
			for(CustomerAddressModel customerAddressModel : customerInformationList){
				taxRateQuery.append("select top 1 tax_rate from tax_rate_commodity where commodity_code = '"+commodityCode+"'");
				if(customerAddressModel.getStateCodeForTaxes()!=null){					
					taxRateQuery.append(" and state = '"+customerAddressModel.getStateCodeForTaxes()+"'");
				}else{
					taxRateQuery.append(" and state = '"+customerAddressModel.getState()+"'");
				}
				taxRateQuery.append(" order by effective_date desc");
				
				 taxRate = jdbcTemplate.queryForObject(taxRateQuery.toString(), Long.class);
				
			}
		}catch(EmptyResultDataAccessException e){
			taxRate = 0;
		}catch(Exception e){
			LOGGER.info("CustomerOrderDaoImpl -> getPackageTaxRate : "+e);
		}
		return taxRate;
	}

	@Override
	public String getOrderAdd(OrderItem orderItem, int itemCount,String subscriptionIdList,Optional<Integer> changeAmount) throws Exception {
		String orderstatus="false";
		orderstatus= orderAddWsdl.orderAdd(orderItem, itemCount,subscriptionIdList,changeAmount);
		if(orderstatus=="false") {
			Thread.sleep(20000);
		  orderstatus= orderAddWsdl.orderAdd(orderItem, itemCount,subscriptionIdList,changeAmount);}
		if(orderstatus=="false") {
			Thread.sleep(20000);
			orderstatus= orderAddWsdl.orderAdd(orderItem, itemCount,subscriptionIdList,changeAmount);
		}
		return orderstatus;
	}
	
	
	
	@Override
	public String saveOrderWithPaymentIntoDataSource(OrderItem orderItem, int itemCount,String subscriptionIdList) throws Exception 
	{
		String orderstatus="false";
		orderstatus= orderAddWsdl.addOrderWithPayment(orderItem, itemCount,subscriptionIdList);
		if(orderstatus=="false") 
		{
			Thread.sleep(20000);
		    orderstatus= orderAddWsdl.addOrderWithPayment(orderItem, itemCount,subscriptionIdList);
		}
		if(orderstatus=="false") 
		{
			Thread.sleep(20000);
			orderstatus= orderAddWsdl.addOrderWithPayment(orderItem, itemCount,subscriptionIdList);
		}
		//THINKDEV-610,615
		if(orderstatus.equals("true"))
		{
			double cancelledOrderAmount=orderItem.getCancelledOrderAmount();
			Map<String, Double>currencyMap=new HashMap<String, Double>();
	        List<Map<String, Object>> currencyRows = jdbcTemplate.queryForList("SELECT currency,exchange_rate FROM currency;");
	        for (Map<String, Object> eachRow : currencyRows) 
	        {
	        	BigDecimal bd=(BigDecimal) eachRow.get("exchange_rate");
	        	currencyMap.put((String) eachRow.get("currency"), bd.doubleValue());
	        }
	        String payment_query=null;
			String payment_count_query="SELECT COUNT(*) FROM payment WHERE customer_id="+orderItem.getCustomerId()+" AND currency='"+orderItem.getCurrency()+"' "
					+ "AND customer_deposit_pay_amt>="+orderItem.getCancelledOrderAmount()+";";
			int payment_count = jdbcTemplate.queryForObject(payment_count_query, Integer.class);
			if(payment_count>0)
			{
				payment_query="SELECT TOP 1 payment_seq,customer_deposit_pay_amt FROM payment"+ 
						" WHERE customer_id="+orderItem.getCustomerId()+" AND currency='"+orderItem.getCurrency()+"' "
						+ "AND customer_deposit_pay_amt>="+orderItem.getCancelledOrderAmount()+";"; 
				
			}else
			{
				Set<String>currencySet=currencyMap.keySet();
			    List<String> currencyList = new ArrayList<String>(currencySet.size()); 
			    for(String curr : currencySet) 
			    {	
			    	currencyList.add(curr);
			    }
				payment_count_query="SELECT COUNT(*) FROM payment WHERE customer_id="+orderItem.getCustomerId()+" AND currency='"+currencyList.get(0)+"'"
						+ "AND customer_deposit_pay_amt>="+(orderItem.getCancelledOrderAmount()*currencyMap.get(currencyList.get(0)))+";";
				payment_count = jdbcTemplate.queryForObject(payment_count_query, Integer.class);
				if(payment_count>0)
				{
					payment_query="SELECT TOP 1 payment_seq,customer_deposit_pay_amt FROM payment"+ 
							" WHERE customer_id="+orderItem.getCustomerId()+" AND currency='"+currencyList.get(0)+"' "
							+ "AND customer_deposit_pay_amt>="+(orderItem.getCancelledOrderAmount()*currencyMap.get(currencyList.get(0)))+";"; 
					cancelledOrderAmount=cancelledOrderAmount*currencyMap.get(currencyList.get(0));
				}else 
				{
					payment_count_query="SELECT COUNT(*) FROM payment WHERE customer_id="+orderItem.getCustomerId()+" AND currency='"+currencyList.get(1)+"'"
							+ "AND customer_deposit_pay_amt>="+(orderItem.getCancelledOrderAmount()*currencyMap.get(currencyList.get(1)))+";";
					payment_count = jdbcTemplate.queryForObject(payment_count_query, Integer.class);
					if(payment_count>0)
					{
						payment_query="SELECT TOP 1 payment_seq,customer_deposit_pay_amt FROM payment"+ 
								" WHERE customer_id="+orderItem.getCustomerId()+" AND currency='"+currencyList.get(1)+"' "
								+ "AND customer_deposit_pay_amt>="+(orderItem.getCancelledOrderAmount()*currencyMap.get(currencyList.get(1)))+";"; 
						cancelledOrderAmount=cancelledOrderAmount*currencyMap.get(currencyList.get(1));
					}else 
					{
						payment_count_query="SELECT COUNT(*) FROM payment WHERE customer_id="+orderItem.getCustomerId()+" AND currency='"+currencyList.get(2)+"'"
								+ "AND customer_deposit_pay_amt>="+(orderItem.getCancelledOrderAmount()*currencyMap.get(currencyList.get(2)))+";";
						payment_count = jdbcTemplate.queryForObject(payment_count_query, Integer.class);
						if(payment_count>0)
						{
							payment_query="SELECT TOP 1 payment_seq,customer_deposit_pay_amt FROM payment"+ 
									" WHERE customer_id="+orderItem.getCustomerId()+" AND currency='"+currencyList.get(2)+"' "
									+ "AND customer_deposit_pay_amt>="+(orderItem.getCancelledOrderAmount()*currencyMap.get(currencyList.get(2)))+";"; 
							cancelledOrderAmount=cancelledOrderAmount*currencyMap.get(currencyList.get(2));
						}
					}
				}
			}
			if(null!=payment_query)
			{
				Map<String,Object> resultMap = jdbcTemplate.queryForMap(payment_query);
				int payment_seq=Integer.parseInt(resultMap.get("payment_seq").toString());
				double customer_deposit_pay_amt=Double.parseDouble(resultMap.get("customer_deposit_pay_amt").toString());
				double difference=customer_deposit_pay_amt-cancelledOrderAmount;
				difference=Math.round(difference * 100.0) / 100.0;
				String updatePaymentQuery="UPDATE payment SET mru_paybreak_seq=1,customer_deposit_pay_amt="+difference+",deposit_transaction=0"+ 
				" WHERE customer_id="+orderItem.getCustomerId()+" AND payment_seq="+payment_seq+";";
				int updateFlag=jdbcTemplate.update(updatePaymentQuery);
				if(updateFlag>0)
				{
					LOGGER.info("Deposit Summary Updated successfully.");
				}
			}
		}
		return orderstatus;
	}
	
	
	
	@Override
	public List<CustomerAuxiliaryModel> getCustomerAuxiliaryFormField() throws SQLException {
		LOGGER.info("Inside getCustomerAuxiliaryFormField");
		List<CustomerAuxiliaryModel> result = null;
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("table_name", "order_item");
			parameters.put("custsvc_edit_disposition",0);
			result = namedParameterJdbcTemplate.query("SELECT * FROM aux_field WHERE LOWER(table_name) = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name", parameters, new CustomerAuxiliaryMapper());
			for (CustomerAuxiliaryModel customerAuxiliaryModel : result) {
				customerAuxiliaryModel.setColumnDatatype(new PropertyUtilityClass().getConstantValue("column_datatype_"+customerAuxiliaryModel.getColumnDatatype()));
				if(customerAuxiliaryModel.getLookupTableName()!=null) {
							LinkedHashMap<String, String> values =new LinkedHashMap<String, String>();							
							List<Map<String, Object>> rows = jdbcTemplate.queryForList("select "+customerAuxiliaryModel.getLookupDisplayColumnName()+","+customerAuxiliaryModel.getLookupValueColumnName()
																									+" from "+customerAuxiliaryModel.getLookupTableName());
							for (Map<String, Object> row : rows) {
									values.put(row.get(customerAuxiliaryModel.getLookupDisplayColumnName()).toString(),row.get(customerAuxiliaryModel.getLookupValueColumnName()).toString());
							}
							customerAuxiliaryModel.setValues(values);
					
				}
				}
		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		
		return result;
	}
	@Override
	public LinkedHashMap<String, String> setOrderAuxiliaryDetailByID(Long orderhdrId,int orderItemSeq)throws SQLException {
		LOGGER.info("Inside setOrderAuxiliaryDetailByID");
		LinkedHashMap<String, String> customerDetail = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> customerDetail2 = new LinkedHashMap<String, String>();
		try {
				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> parameters2 = new HashMap<String, Object>();
				parameters.put("orderhdr_id", orderhdrId);
				parameters.put("order_item_seq", orderItemSeq);
				parameters2.put("table_name", "order_item");
				parameters2.put("custsvc_edit_disposition",0);
				int count = namedParameterJdbcTemplate.queryForObject("select count(*) from order_item_ext where orderhdr_id= :orderhdr_id and order_item_seq= :order_item_seq",parameters, Integer.class);
				if(count>0) {
					List<String> fields = namedParameterJdbcTemplate.queryForList("SELECT column_name FROM aux_field WHERE table_name = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition", parameters2,String.class);
					Map<String, Object> rows = namedParameterJdbcTemplate.queryForMap("select * from order_item_ext where orderhdr_id= :orderhdr_id and order_item_seq= :order_item_seq",parameters);
					for (Map.Entry<String,Object> entry : rows.entrySet()) 
						for(int i=0;i<fields.size();i++) {
							if(fields.contains(entry.getKey())) {
								customerDetail.put(fields.get(i), rows.get(fields.get(i))==null?null:rows.get(fields.get(i)).toString());
							}
						}
					Set<Entry<String, String>> entries=customerDetail.entrySet();
					for (Entry<String, String> entry : entries) {
						if(entry.getKey().contains("date") && entry.getValue() != null) { 
							String value = entry.getValue();
							String date = value.substring(0, value.indexOf(' '));
							customerDetail2.put(entry.getKey(), date);
						}else {
							customerDetail2.put(entry.getKey(), entry.getValue());
						}
					  }
				}
				
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		
		return customerDetail2;
	}
	
	@Override
	public String saveOrderAuxiliary(HttpServletRequest request) throws SQLException {
		LOGGER.info("Inside saveOrderAuxiliary");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("table_name", "order_item");
			parameters.put("custsvc_edit_disposition",0);
			String query2 = "SELECT column_name FROM aux_field WHERE LOWER(table_name) = :table_name and ";
					if(!"true".equals(request.getParameter("updateFlag"))) {
						query2 = query2+ "custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name";
					}else {
						if(request.getParameter("zzaux_zold_sales_invoice_no") == null) {
							query2 = query2+ "custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name";
						}else {
							query2 = query2+ "custsvc_edit_disposition != :custsvc_edit_disposition and column_name != 'zzaux_zold_sales_invoice_no' ORDER BY table_name,column_name";
						}
					}
					
			List<String> columnName = namedParameterJdbcTemplate.queryForList(query2, parameters, String.class);
			parameters.clear();
			parameters.put("orderhdr_id", request.getParameter("orderhdrId"));
			parameters.put("order_item_seq",request.getParameter("orderItemSeq"));
			int auxiliaryCount = namedParameterJdbcTemplate.queryForObject("select count(*) from order_item_ext where orderhdr_id= :orderhdr_id and order_item_seq= :order_item_seq ",parameters,Integer.class);
			Map<String, Object> customerAuxiliaryPreviousData=null;
			if(auxiliaryCount>0)
				customerAuxiliaryPreviousData = namedParameterJdbcTemplate.queryForMap("select * from order_item_ext where orderhdr_id= :orderhdr_id and order_item_seq= :order_item_seq",parameters);
			parameters.clear();
			StringBuilder query = new StringBuilder("");
			
			if(!"true".equals(request.getParameter("updateFlag"))) {
				query.append("Insert into order_item_ext (orderhdr_id,order_item_seq,");
				
				for(String column: columnName) 
					query.append(column+",");
				query.setLength(query.length() - 1);
				
				query.append(") VALUES(:orderhdr_id,:order_item_seq,");
				
				for(String column: columnName) {
					query.append(":"+column+",");
					parameters.put(column, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				query.setLength(query.length() - 1);
				
				query.append(")");
			}
			else {
				query.append("UPDATE order_item_ext set ");
				
				for(String column: columnName) {
					query.append(column+"=:"+column+",");
					parameters.put(column, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				query.setLength(query.length() - 1);
				
				query.append(" where orderhdr_id=:orderhdr_id and order_item_seq= :order_item_seq");
				
			}	
			
			parameters.put("orderhdr_id", request.getParameter("orderhdrId"));
			parameters.put("order_item_seq", request.getParameter("orderItemSeq"));
			
			namedParameterJdbcTemplate.update(query.toString(), parameters);
			
			int count = customerUtility.getcurrentDateStampCount();

			if (count == 0) {
				Long dateStampId = customerUtility.getmaxDateStamp();
				customerUtility.insertDateStamp(dateStampId);
			}
			
			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			
			parameters.clear();
			String editTrailCodeQuery = "insert into edit_trail "
					+ "(edit_trail_id,customer_id,user_code,orderhdr_id,order_item_seq,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name) "
					+ "values (:edit_trail_id,:customer_id,:user_code,:orderhdr_id,:order_item_seq,:edited,:table_enum,:document_reference_id,:date_stamp,:creation_date,:xaction_name)";

			parameters.put("edit_trail_id", editTrailId);
			parameters.put("customer_id", request.getParameter("customerId"));			
			parameters.put("user_code", request.getParameter("userCode"));
			parameters.put("orderhdr_id", request.getParameter("orderhdrId"));
			parameters.put("order_item_seq", request.getParameter("orderItemSeq"));
			parameters.put("edited", 1);
			parameters.put("table_enum", 3);
			parameters.put("document_reference_id", request.getParameter("documentReferenceId"));
			parameters.put("date_stamp", dateStamp);
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			if(!"true".equals(request.getParameter("updateFlag"))) {
				parameters.put("xaction_name", "order_item_add_request");
			}else {
				parameters.put("xaction_name", "order_item_edit_request");
			}
			namedParameterJdbcTemplate.update(editTrailCodeQuery, parameters);
			
			customerUtility.updateMruEditTrailId(editTrailId);
			
			for(String column: columnName) {
				if(auxiliaryCount>0) {
					if(!(customerAuxiliaryPreviousData.get(column)==null?"":customerAuxiliaryPreviousData.get(column).toString()).equals(request.getParameter(column)))
						customerUtility.insertEditTrailDelta(editTrailId, column, customerAuxiliaryPreviousData.get(column), "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				else {
					if(!"".equals(request.getParameter(column)))
						customerUtility.insertEditTrailDelta(editTrailId, column, null, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
			}
			
			
			return "Added";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}
	@Override
	public List<Product> getProductDefinitionList(int orderCodeId) {
		List<Product> productModelsList = null;
		try{
			String productQuery = "select p.product_id,p.oc_id,inventory_id,p.description,p.product_size,p.product_style,p.product_color,p.price,p.rate_class_id ,p.product,order_code.order_code,oc.oc,'' as currency,''as exchange_rate,0 as n_issues,order_code.order_code_id from product p join order_code order_code on order_code.order_code_id=p.order_code_id  left join oc on oc.oc_id=order_code.oc_id where p.order_code_id = "+orderCodeId+"";			
			productModelsList = jdbcTemplate.query(productQuery,new ProductMapper());
			
		}catch(Exception e){
			LOGGER.info("productModelsList = "+e);
		}
		return productModelsList;
	}




	@Override
	public List<Product> getProductRate(int customerId, int orderCodeId,int sourceCodeId, int subscriptionId, int orderCodeType) {
		List<Product> productRate = new ArrayList<>();
		List<Product> productList = new ArrayList<>();
		try
		{
			String productQuery= new PropertyUtilityClass().getQuery("productQuery");				
			productRate = jdbcTemplate.query(productQuery,new Object[]{customerId,orderCodeId,subscriptionId}, new ProductMapper());
			List<Map<String, Object>> rows = jdbcTemplate.queryForList("select top 1 c.state,s.currency from customer_address c join state s on c.state=s.state where customer_id="+customerId+"");
			List<Order_code_for_price_list[][]> priceList= orderAddWsdl.getPrice(customerId, productRate.get(0).getProductId(),String.valueOf(sourceCodeId), rows.get(0).get("state").toString(),rows.get(0).get("currency").toString(),orderCodeType,orderCodeId);
			for (Product Product : productRate) 
			{
				for(Order_code_for_price_list[][] map:priceList)
				{
					  //Updated for 610,611,615	
					  Product.setLocalAmount((map[0][0].getProduct_price()[0].getCc_item_price().doubleValue())*(Product.getOrderQty()));
					  Product.setBaseAmount((map[0][0].getProduct_price()[0].getCc_item_price().doubleValue())*(Double.parseDouble(Product.getExchangeRate()))*(Product.getOrderQty()));
					  if(String.valueOf(Product.getLocalAmount()).equals("0.0")) 
					  {
						  int noCharge=jdbcTemplate.queryForObject("select no_charge from order_code where order_code_id="+orderCodeId+"", Integer.class);
						  if(noCharge==1) 
						  {
							  Product.setBillingType("Undefined");
						  }else
						  {
							  Product.setBillingType("Balance Due");
						  }
					  }else 
					  {
						  Product.setBillingType("Balance Due");
					  }
				}				
				productList.add(Product);
			}
		}
		catch(Exception e)
		{
			LOGGER.info("getProductRate : "+e);
		}
		return productList;
	}



	public Map<String, Object> getAmountChangByNoOfIssue(int orderhdrId,int numberOfIssu,int numberOfCopyPerIssue,int option,long issuId,float localAmount) {
		Map<String,Object> afterChangeAmount= new LinkedHashMap<>();
		try {
			float exdendedRate = 0;
			if(numberOfIssu!=0 && numberOfCopyPerIssue ==-1 ) {
			exdendedRate = jdbcTemplate.queryForObject("select extended_rate from order_item where orderhdr_id ="+orderhdrId, float.class);
			exdendedRate =  exdendedRate*numberOfIssu;
		    issuId = issuId + (numberOfIssu-1);
		    String expireDate = jdbcTemplate.queryForObject("select issue_date from issue where issue_id ="+issuId, String.class);
			afterChangeAmount.put("localAmount", exdendedRate);
			afterChangeAmount.put("baseAmount", exdendedRate);
			afterChangeAmount.put("expireDate", expireDate);
			afterChangeAmount.put("liability", numberOfIssu);
			
			}
			if(numberOfCopyPerIssue>0)
			{
				switch(option){
				case 1:
					if(numberOfIssu<=numberOfCopyPerIssue) {
						afterChangeAmount.put("numberOfIssue", 1);
						afterChangeAmount.put("numberOfCopyPerIssue", numberOfCopyPerIssue);
					}else {
					int numberOfIssue1 = numberOfIssu/numberOfCopyPerIssue;
					if(numberOfIssue1>= 2) {
						afterChangeAmount.put("numberOfIssue", numberOfIssue1);
						afterChangeAmount.put("numberOfCopyPerIssue", numberOfCopyPerIssue);
					 }
					if(numberOfIssue1<2)
						afterChangeAmount.put("numberOfIssue", 2);
					    afterChangeAmount.put("numberOfCopyPerIssue", numberOfCopyPerIssue);
					}
					break;
				case 2:
					exdendedRate = localAmount*numberOfCopyPerIssue;
					afterChangeAmount.put("baseAmount", exdendedRate);
					afterChangeAmount.put("localAmount", exdendedRate);
					break;
				case 3:
					exdendedRate = localAmount*numberOfCopyPerIssue;
					afterChangeAmount.put("baseAmount", exdendedRate);
					afterChangeAmount.put("localAmount", exdendedRate);
					break;
				case 4:
					exdendedRate = localAmount*numberOfCopyPerIssue;
					afterChangeAmount.put("baseAmount", exdendedRate);
					afterChangeAmount.put("localAmount", exdendedRate);
					break;
				default:
						break;
				   
				}
			}
			
		}catch(Exception e) {
			LOGGER.info(ERROR + e);
		}
		return afterChangeAmount;
	}

	
	@Override
	public Map<String, Object> getSaveAmountForNoOfIssue(long issueId, int numberOfIssue, float toOrderItemPrice) {
		LOGGER.info("inside getSaveAmountForNoOfIssue");
		Map<String,Object> responseObject =new LinkedHashMap<>();
		try 
			{
			double value = toOrderItemPrice;
			value =Double.parseDouble(new DecimalFormat("##.##").format(value));
			issueId = (issueId+numberOfIssue)-1;
			String expireDate = jdbcTemplate.queryForObject("select issue_date from issue where issue_id="+issueId, String.class);
			responseObject.put("baseAmount", value);
			responseObject.put("localAmount", value);
			responseObject.put("expireDate", expireDate);
			responseObject.put("liability", numberOfIssue);
			responseObject.put("numberOfIssue", numberOfIssue);
			
		}catch(Exception e) {
			LOGGER.info(ERROR +e);
		}
		return responseObject;
	}

	@Override
	public Map<String, Object> getBundleQuantityChangeOption(String orderClass, String orderCode, int orderNumber,
			int orderLineNumber, float localAmount, int numberOfIssue, int copyPerIssue, int preCopyPerIssue,
			long orderId) {
		LOGGER.info("inside getBundleQuantityChangeOption");
		Map<String,Object> responseObject =new LinkedHashMap<>();
		try {
			double localAmountForOpt3 = 0;
			double	toNumberOfIssue=0;
			float  nRemainingPaidIssues = jdbcTemplate.queryForObject("select  n_issues_left from order_item where orderhdr_id="+orderId+" AND order_item_seq="+orderLineNumber, float.class);
			float orgQty = jdbcTemplate.queryForObject("select  orig_order_qty from order_item where orderhdr_id="+orderId+" AND order_item_seq="+orderLineNumber, float.class);
			StringBuilder query =new StringBuilder("select local_amount,base_amount from order_item_amt_break where orderhdr_id=");
			query.append(orderId).append("and order_item_seq =").append(orderLineNumber);
			List<Map<String,Object>> list = jdbcTemplate.queryForList(query.toString());
			System.out.println(list.get(0).get("local_amount"));
			
			double localAmount1 =Double.parseDouble(new DecimalFormat("##.##").format(localAmount));
			if(nRemainingPaidIssues != 0) {
			toNumberOfIssue=(numberOfIssue*preCopyPerIssue)/copyPerIssue;
			toNumberOfIssue = (double)numberOfIssue*preCopyPerIssue/copyPerIssue;
			System.out.println(toNumberOfIssue);
			toNumberOfIssue  = (double)Math.round(toNumberOfIssue);
			System.out.println(toNumberOfIssue);
			if(toNumberOfIssue<1) {
				toNumberOfIssue=1;
			   }
			}
			float fromCastPerIssue = (float) ((localAmount1/numberOfIssue)/preCopyPerIssue);
			float toCastPerIssue   = (float) ((localAmount1/numberOfIssue)/copyPerIssue);
			double toOrderItemPrice =  ((localAmount1/preCopyPerIssue)*copyPerIssue) ;
			toNumberOfIssue= Math.round(toNumberOfIssue);
//			if(copyPerIssue ==1) {
//				List<Map<String,Object>> toOrderItemPrice2 = jdbcTemplate.queryForList("select local_amount from order_item_amt_break where orderhdr_id="+orderId);
//				localAmountForOpt3 =  Double.parseDouble(new DecimalFormat("##.##").format(toOrderItemPrice2.get(0).get("local_amount")));
//			}
			responseObject.put("fromNumberOfIssue", numberOfIssue);
			responseObject.put("fromRemainingIssue", numberOfIssue);
			responseObject.put("fromPreCopyPerIssue", preCopyPerIssue);
			responseObject.put("toNumberOfIssue", toNumberOfIssue);
			responseObject.put("toRemainingIssue", toNumberOfIssue);
			responseObject.put("toPreCopyPerIssue", copyPerIssue);
			responseObject.put("fromOrderItemPrice", localAmount1);
			responseObject.put("orderClass", orderClass);
			responseObject.put("orderCode", orderCode);
			responseObject.put("orderNumber", orderNumber);
			responseObject.put("orderLineNumber", orderLineNumber); 
			responseObject.put("fromCastPerIssue",Double.parseDouble(new DecimalFormat("##.##").format(fromCastPerIssue)));
			responseObject.put("toCastPerIssue", Double.parseDouble(new DecimalFormat("##.##").format(toCastPerIssue)));
			responseObject.put("prorateRemainingIssue", numberOfIssue);
			responseObject.put("toOrderItemPrice", Double.parseDouble(new DecimalFormat("##.##").format(toOrderItemPrice)));
//			if(copyPerIssue==1 && localAmount1 == localAmountForOpt3) {
//				responseObject.put("toOrderItemPrice", localAmount1);
//			}else {
//				responseObject.put("toOrderItemPrice", Double.parseDouble(new DecimalFormat("##.##").format(toOrderItemPrice)));
//			}
			}
	        catch(Exception e) {
		    LOGGER.info(ERROR +e);
	       }
    	   return responseObject;
		
	}

	@Override
	public Map<String, Object> clickOnBundleQuantityChangeOption(String orderClass, String orderCode, int orderNumber,
			int orderLineNumber, float localAmount, int numberOfIssue, int copyPerIssue, int preCopyPerIssue,
			long orderId, float baseAmount,int option,long startIssueId ,float baseNetAmount, float baseGrossAmount, float localNetAmount, float localGrossAmount,
			float localCommission,float baseCommission,float totalTaxLocalAmount,float totalTaxBaseAmount,float toCastPerIssue,String startDate) {
			LOGGER.info("inside getBundleQuantityChangeOption");
			Map<String,Object> responseObject =new LinkedHashMap<>();
			try {
				String expireDate=null;
				int year = 0;
				int month = 0;
				int day = 0;
				LocalDateTime newDate = null;
				float localAmountOption1 = localAmount;
				float baseAmountOption1 = baseAmount;
				localAmount = (localAmount/preCopyPerIssue)*copyPerIssue ;
				System.out.println(localAmount);
				baseAmount = (baseAmount/preCopyPerIssue)*copyPerIssue ;
				baseNetAmount = (baseNetAmount/preCopyPerIssue)*copyPerIssue ;
				baseGrossAmount = (baseGrossAmount/preCopyPerIssue)*copyPerIssue ;
				localNetAmount = (localNetAmount/preCopyPerIssue)*copyPerIssue ;
				localGrossAmount = (localGrossAmount/preCopyPerIssue)*copyPerIssue ;
				localCommission = (localCommission/preCopyPerIssue)*copyPerIssue ;
				baseCommission = (baseCommission/preCopyPerIssue)*copyPerIssue ;
				totalTaxLocalAmount = (totalTaxLocalAmount/preCopyPerIssue)*copyPerIssue ;
				totalTaxBaseAmount = (totalTaxBaseAmount/preCopyPerIssue)*copyPerIssue ;
				System.out.println(baseAmount);
				float numberOfIssue1 = 0;
				float orgQty=0;
				switch(option) {
				case 1:
					if(numberOfIssue>copyPerIssue) {
					orgQty = jdbcTemplate.queryForObject("select  orig_order_qty from order_item where orderhdr_id="+orderId+" AND order_item_seq="+orderLineNumber, float.class);
					int	nRemainingPaidIssues = numberOfIssue;
					numberOfIssue1=orgQty/copyPerIssue;
					numberOfIssue1= Math.round(numberOfIssue1);
					startIssueId = (long) ((startIssueId-numberOfIssue1)+1);
					}
				/*
				 * if(numberOfIssue<=copyPerIssue) { numberOfIssue=1; startIssueId = (long)
				 * ((startIssueId-numberOfIssue1)+1); }
				 */
				/*
				 * List<Map<String,Object>> listForData = jdbcTemplate.
				 * queryForList("Select start_date,expire_date ,oc_id from order_item where orderhdr_id="
				 * +orderId+" AND order_item_seq="+orderLineNumber); String startDate =
				 * listForData.get(0).get("start_date").toString(); String expDate =
				 * listForData.get(0).get("expire_date").toString(); int ocId =
				 * (int)listForData.get(0).get("oc_id"); StringBuilder dateQuery = new
				 * StringBuilder("select issue_date,* from view_issue_volume where issue_date between '"
				 * ); dateQuery.append(startDate).append("' and '").append(expDate).
				 * append("' and oc_id = ").append(ocId); int indexVar =(((int)numberOfIssue1)
				 * -1); List<Map<String,Object>> listForDate =
				 * jdbcTemplate.queryForList(dateQuery.toString());
				 */
					int  orgQnty = jdbcTemplate.queryForObject("select orig_order_qty  from order_item where  orderhdr_id=" + 
										  orderId+" AND order_item_seq="+orderLineNumber,Integer.class);
					String[] dateArr = startDate.split("/");
					for (int i = 0; i < dateArr.length; i++)
						month = Integer.parseInt(dateArr[0]);
					day = (Integer.parseInt(dateArr[1]));
					year = Integer.parseInt(dateArr[2]);
					LocalDateTime today = LocalDateTime.of(year, month, day, 0, 0);
					newDate = today.plusMonths(numberOfIssue - 1);
					DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					expireDate = newDate.format(format);
					System.out.println(expireDate);
					//String expireDate =listForDate.get(indexVar).get("issue_date").toString();
				  // String expireDate = jdbcTemplate.queryForObject("select format(cast(issue_date as date), 'MM/dd/yyyy') as expireDate from issue where issue_id="+startIssueId,String.class);
					if(orgQty<numberOfIssue && !((orgQty%2)==0)) {
						responseObject.put("copyPerIssue", copyPerIssue);
						responseObject.put("expireDate", expireDate);
						//responseObject.put("liability", numberOfIssue1);
						responseObject.put("liability", numberOfIssue);
						responseObject.put("preCopyPerIssue", preCopyPerIssue);
						//responseObject.put("numberOfIssue", numberOfIssue1);
						responseObject.put("numberOfIssue", numberOfIssue);
						responseObject.put("localAmount", 0.0);
						responseObject.put("baseAmount", 0.0);
						responseObject.put("orgQnty",orgQnty);
					}else {
					responseObject.put("copyPerIssue", copyPerIssue);
					responseObject.put("expireDate", expireDate);
					//responseObject.put("liability", numberOfIssue1);
					responseObject.put("liability", numberOfIssue);
					responseObject.put("preCopyPerIssue", preCopyPerIssue);
					//responseObject.put("numberOfIssue", numberOfIssue1);
					responseObject.put("numberOfIssue", numberOfIssue);
					responseObject.put("localAmount", Double.parseDouble(new DecimalFormat("##.##").format(localAmountOption1)));
					responseObject.put("baseAmount", Double.parseDouble(new DecimalFormat("##.##").format(baseAmountOption1)));
					responseObject.put("orgQnty",orgQnty);
					}
					break;
				case 2:
					System.out.println(localAmount);
					responseObject.put("localAmount", Double.parseDouble(new DecimalFormat("##.##").format(localAmount)));
					responseObject.put("copyPerIssue", copyPerIssue);
					responseObject.put("baseAmount", Double.parseDouble(new DecimalFormat("##.##").format(baseAmount)));
					responseObject.put("baseNetAmount", Double.parseDouble(new DecimalFormat("##.##").format(baseNetAmount)));
					responseObject.put("baseGrossAmount", Double.parseDouble(new DecimalFormat("##.##").format(baseGrossAmount)));
					responseObject.put("localNetAmount", Double.parseDouble(new DecimalFormat("##.##").format(localNetAmount)));
					responseObject.put("localGrossAmount", Double.parseDouble(new DecimalFormat("##.##").format(localGrossAmount)));
					responseObject.put("localCommission", Double.parseDouble(new DecimalFormat("##.##").format(localCommission)));
					responseObject.put("baseCommission", Double.parseDouble(new DecimalFormat("##.##").format(baseCommission)));
					responseObject.put("totalTaxLocalAmount", Double.parseDouble(new DecimalFormat("##.##").format(totalTaxLocalAmount)));
					responseObject.put("totalTaxBaseAmount", Double.parseDouble(new DecimalFormat("##.##").format(totalTaxBaseAmount)));
					break;
				case 3:
				    responseObject.put("toCastPerIssue", Double.parseDouble(new DecimalFormat("##.##").format(toCastPerIssue)));
					responseObject.put("copyPerIssue", copyPerIssue);
					break;
				case 4:
					responseObject.put("localAmount", Double.parseDouble(new DecimalFormat("##.##").format(localAmount)));
					responseObject.put("copyPerIssue", copyPerIssue);
					responseObject.put("baseAmount", Double.parseDouble(new DecimalFormat("##.##").format(baseAmount)));
					responseObject.put("baseNetAmount", Double.parseDouble(new DecimalFormat("##.##").format(baseNetAmount)));
					responseObject.put("baseGrossAmount", Double.parseDouble(new DecimalFormat("##.##").format(baseGrossAmount)));
					responseObject.put("localNetAmount", Double.parseDouble(new DecimalFormat("##.##").format(localNetAmount)));
					responseObject.put("localGrossAmount", Double.parseDouble(new DecimalFormat("##.##").format(localGrossAmount)));
					responseObject.put("localCommission", Double.parseDouble(new DecimalFormat("##.##").format(localCommission)));
					responseObject.put("baseCommission", Double.parseDouble(new DecimalFormat("##.##").format(baseCommission)));
					responseObject.put("totalTaxLocalAmount", Double.parseDouble(new DecimalFormat("##.##").format(totalTaxLocalAmount)));
					responseObject.put("totalTaxBaseAmount", Double.parseDouble(new DecimalFormat("##.##").format(totalTaxBaseAmount)));
					break;
					
					default:
					responseObject.put("localAmount", Double.parseDouble(new DecimalFormat("##.##").format(localAmount)));
					responseObject.put("baseAmount", Double.parseDouble(new DecimalFormat("##.##").format(baseAmount)));
								
				}
			    
			}catch(Exception e) {
				LOGGER.info(ERROR + e);
			}
			return responseObject;
}

	@Override
	public Map<String, Object> getExpirationDate(int issueId,int numIssue,int ocId,String subscripId) {
		LOGGER.info("inside getExpirationDate");
		Map<String,Object> responseObject =new LinkedHashMap<>();
		try 
			{
			//issueId = (issueId+numIssue)-1;
			
			issueId = jdbcTemplate.queryForObject("SELECT issue_id FROM (SELECT ROW_NUMBER() OVER (ORDER BY issue_date ASC) AS rownumber,issue_id,CONVERT(VARCHAR, issue_date, 101) as issue_date FROM issue where oc_id = "+ocId+" and issue_id>= "+issueId+" and issue_close_date is null ) as temptablename WHERE rownumber ="+numIssue, Integer.class);
			
			String count=jdbcTemplate.queryForObject("SELECT CONVERT(varchar,A.issue_date,101) from view_issue_volume A INNER JOIN (SELECT ROW_NUMBER() OVER(ORDER BY oc_id) AS 'RN', *   FROM view_issue_volume) B " + 
					" ON A.issue_id= B.issue_id AND B.RN=(SELECT RowNumer+ "+numIssue+" FROM(SELECT ROW_NUMBER () OVER (ORDER BY oc_id) RowNumer,issue_id,oc_id FROM view_issue_volume ) qry1 " + 
					" WHERE issue_id =(select top 1 stop_issue_id from order_item where subscrip_id="+subscripId+" order by orderhdr_id desc)  and oc_id="+ocId+")" , String.class);
			if(count!=null) {
			String expireDate = jdbcTemplate.queryForObject("select isnull(CONVERT(varchar,issue_date,101),'') as issue_date from issue where issue_id="+issueId+" and oc_id="+ocId, String.class);
			responseObject.put("expireDate", expireDate);
			}else {
				responseObject.put("expireDate", null);
			}
			}
			catch (EmptyResultDataAccessException e)
			{
				responseObject= null;			
			}catch(Exception e){
				LOGGER.info("getExpirationDate = "+e);
			}
		    return responseObject;
	}

	@Override
	public List<BackIssuesModel> getBackIssueList(int issueId, int currIssueId,String subscripId) {
		List<BackIssuesModel> backIssueList = new ArrayList<>();
		List<BackIssuesModel> backIssueFinalList = new ArrayList<>();
		try{
			String backIssueQuery = "select distinct CONVERT(varchar,issue_date,101)as issue_date,issue_id from issue where issue_id between "+currIssueId+"  and "+(issueId-1)+"";			
			backIssueList = jdbcTemplate.query(backIssueQuery , new BackIssueMapper());
			for (BackIssuesModel backIssuesModel : backIssueList) {
				backIssuesModel.setSubscrip_id(subscripId);
				backIssueFinalList.add(backIssuesModel);
			}
			
			
		}catch(Exception e){
			LOGGER.info("backIssueList = "+e);
		}
		return backIssueFinalList;
	}
	@Override
	public Object getChangeAmountByRateCard(long numberOfIssue, long customerId, int rateClassId,
			int rateClassEffectiveSeq) {
		LOGGER.info("inside getChangeAmountByRateCard");
		Map<String,Object> responseObject = new LinkedHashMap<>();
		try {
 			int baseLineQuatity=0;
			if(numberOfIssue<=11 && numberOfIssue>0) {
			   baseLineQuatity=6;	
			}
			if(numberOfIssue<=17 && numberOfIssue>11) {
			   baseLineQuatity=12;	
			}
			if(numberOfIssue>=18) {
			   baseLineQuatity=18;	
			}
			String state = jdbcTemplate.queryForObject("select state from customer_address where customer_address_seq=1 and customer_id="+customerId, String.class);
			String region = jdbcTemplate.queryForObject("select region from region_state where state="+"'"+state+"'", String.class);
			float baseAmount = jdbcTemplate.queryForObject("select price from ratecard where rate_class_id="+rateClassId+" AND region="+"'"+ region+"'"+" and rate_class_effective_seq=" +rateClassEffectiveSeq +" AND baseline_qty="+baseLineQuatity,float.class);
			float baseAmount1 = (baseAmount/baseLineQuatity)*numberOfIssue;
			responseObject.put("baseAmount", baseAmount1);
			responseObject.put("localAmount", baseAmount1);
			
		}catch(Exception e) {
			LOGGER.info(ERROR +e);
		}
		return responseObject;
	}

	@Override
	public List<Map<String, Object>> getOnSubscriptionChange(int subscription_def_id, Integer issueId,long orderhdrId, int orderItemSeq) {
		List<Map<String, Object>> dataList=new ArrayList<>();
		try {
		dataList=jdbcTemplate.queryForList("select term.description,term.n_issues as num_issue,term.n_issues as liability,sc.subscription_category_id,sc.description as categDescription,sd.subscription_def,sd.media,sd.edition,isnull(sd.pub_rotation_id,0)as pub_rotation_id  , " +
		        "  case when ((select CONVERT(varchar,issue_date,101) as issue_date from issue where issue_id=(0-1)+n_issues)) is null then (select CONVERT(varchar,expire_date,101) as expire_date  from order_item where orderhdr_id="+orderhdrId+" and order_item_seq="+orderItemSeq+") else " + 
		        " ((select CONVERT(varchar,issue_date,101) as issue_date from issue where issue_id=(0-1)+n_issues)) end as expire_date "+ 
		        " from subscription_def sd left join subscription_category sc on sc.subscription_category_id=sd.subscription_category_id " + 
				" left join term on term.term_id=sd.term_id where sd.subscription_def_id="+subscription_def_id+"");
		}catch(Exception e){
			LOGGER.info("dataList = "+e);
		}
		return dataList;
	}

	@Override
	public List<Map<String, Object>> getsourceCodeChange(int sourceCodeId,String agencyID) {
		List<Map<String, Object>> dataList=new ArrayList<>();
		try {
		dataList=jdbcTemplate.queryForList("select source_code_id,agency_customer_id,agency_code,company from source_code sc left join agency on agency.customer_id=sc.agency_customer_id  where source_code_id="+sourceCodeId+"");
		if((dataList.get(0).get("agency_customer_id")==null) && (agencyID!="")) {
		dataList=jdbcTemplate.queryForList("select customer_id,agency_code,company from agency where customer_id="+agencyID+"");			
		}
		}catch(Exception e){
			LOGGER.info("dataList = "+e);
		}
		return dataList;
	}


	@Override
	public Map<String,Object>  getAdjustQuatity(long preQty, long adjQty, long additionalQty,double localAmount,double baseAmount) {
	 Map<String,Object> returnObject = new HashMap<>();
	 try {
		 long total;
		 double localAmount1;
		 double  baseAmount1;
		 long newQty;
		 newQty = preQty +  adjQty;
		 total = preQty + adjQty + additionalQty;
		 localAmount1 = localAmount+ adjQty;
		 baseAmount1 = baseAmount + adjQty;
		 returnObject.put("quantity", newQty);
		 returnObject.put("total", total);
		 returnObject.put("localAmount", Double.parseDouble(new DecimalFormat("##.##").format(localAmount1)));
		 returnObject.put("baseAmount", Double.parseDouble(new DecimalFormat("##.##").format(baseAmount1)));
		 returnObject.put("baseTotalAmount", Double.parseDouble(new DecimalFormat("##.##").format(baseAmount1)));
		 returnObject.put("localTotalNet", Double.parseDouble(new DecimalFormat("##.##").format(localAmount1)));
		 returnObject.put("baseGrossAmount", Double.parseDouble(new DecimalFormat("##.##").format(baseAmount1)));
		 returnObject.put("localGrossAmount", Double.parseDouble(new DecimalFormat("##.##").format(localAmount1)));	 
	 }catch(Exception e) {
		 LOGGER.info(ERROR +e);
	 }
 		return returnObject;
	}

	@Override
	public Map<String, Object> getadjustAdditionalQty(long preAdditional, long adjustAdditional, long total) {
		Map<String, Object> returnObject = new LinkedHashMap<>();
		try {
		  	long total1;
		  	long additional;
		  	total1 = total + adjustAdditional;
		  	additional = preAdditional + adjustAdditional;
		  	returnObject.put("total", total1);
		  	returnObject.put("additional", additional);
		}catch(Exception e) {
			LOGGER.info(ERROR +e);
		}
		return returnObject;
	}
	
	@Override
	public List<Object> getOrderHistory(Long orderHdrId, int ordItemSeq) throws SQLException {
		LOGGER.info("Inside getOrderHistory");
		List<Object> orderHistory = new ArrayList<Object>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from view_edit_hist where "
					+ " orderhdr_id= "+orderHdrId+" and order_item_seq= "+ordItemSeq+" and table_enum=3 order by creation_date");
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
					row.put("before_change",row.get("before_change"));
					row.put("before_change",row.get("after_change"));
				}
				orderHistory.add(row);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderHistory;

  }

	@Override
	public String getCreditStatus(Long customerId) {
		String status = null;
		try {
			status = jdbcTemplate.queryForObject(
					"select credit_status from customer where customer_id=" + customerId + "", String.class);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	
		@Override
		public String getCetDefDetails(long orderhdrId,int orderItemSeq) {
			String  orderCategory="" ;
			try {
	        orderCategory = jdbcTemplate.queryForObject("select isnull(order_category,'') as order_category from order_item where orderhdr_id= "+orderhdrId + " and order_item_seq="+orderItemSeq, String.class);
			 
			}
			catch(Exception e) {
				 LOGGER.error(ERROR + e);
			}
			return orderCategory;
			
			
}

		@Override
		public Map<String, Object> getAmountForNoOfIssue(int orderhdrId, int orderItemSeq, int quantity,
				String defaultPricing, long customerId, int rateClassId, int rateClassEffectiveSeq,
				int priceMethodOption, float localAmount, float baseAmount, int preQuantity, int customerAddressSeq) {
			LOGGER.info("inside getAmountForNoOfIssue");
			Map<String,Object> responseObject =new LinkedHashMap<>();
			try {
				float price=0;
				float toOrderItemPrice = 0;
				float loacl1 = localAmount;
				float fromOrderItemPrice = localAmount;
				float fromCastPerIssue = (loacl1/quantity);
				float toCastPerIssue = loacl1/quantity;
				String isPriceAvailable = jdbcTemplate.queryForObject("select  count(*) as price from ratecard where rate_class_id = "+rateClassId+" and rate_class_effective_seq="+rateClassEffectiveSeq, String.class);
				switch(priceMethodOption)
				{
				case 0:
					if(quantity >= 1 && quantity <=12) {
						if(isPriceAvailable.equals("0") || isPriceAvailable != null) {
							price = jdbcTemplate.queryForObject("select price from ratecard where rate_class_id = "+ rateClassId+" and rate_class_effective_seq="+ rateClassEffectiveSeq+" and baseline_qty=6 and (ratecard.region=(select region from region_state where state=(select state from customer_address where customer_id =" + customerId + " AND  customer_address_seq ="+customerAddressSeq + "))or ratecard.region is null)", float.class);
							toOrderItemPrice =   (price/6)*quantity;
						}
					}
					if(quantity > 12 && quantity <=18) {
						if(isPriceAvailable.equals("0") || isPriceAvailable != null) {
							price = jdbcTemplate.queryForObject("select price from ratecard where rate_class_id = "+ rateClassId+" and rate_class_effective_seq="+ rateClassEffectiveSeq+" and baseline_qty=12 and (ratecard.region=(select region from region_state where state=(select state from customer_address where customer_id =" + customerId+ " AND customer_address_seq ="+customerAddressSeq + "))or ratecard.region is null)", float.class);
							toOrderItemPrice =   (price/12)*quantity;
						}
					}
					if(quantity > 18) {
						if(isPriceAvailable.equals("0") || isPriceAvailable != null) {
							price = jdbcTemplate.queryForObject("select price from ratecard where rate_class_id = "+ rateClassId+" and rate_class_effective_seq="+ rateClassEffectiveSeq+"  and baseline_qty=18 and (ratecard.region=(select region from region_state where state=(select state from customer_address where customer_id =" + customerId+" AND customer_address_seq ="+customerAddressSeq +" ))or ratecard.region is null)", float.class);
							toOrderItemPrice =   (price/18)*quantity;
						}
					}
					break;
				case 1:
					toOrderItemPrice =  (loacl1/preQuantity)*quantity;
					break;
					default:		
				}
				double fromOrderItemPrice1 = fromOrderItemPrice;
				double toOrderItemPrice1 = toOrderItemPrice;
				double fromCastPerIssue1 = fromCastPerIssue;
				double toCastPerIssue1 = toCastPerIssue;
				fromOrderItemPrice1 =Double.parseDouble(new DecimalFormat("##.##").format(fromOrderItemPrice1));
				responseObject.put("fromOrderItemPrice", Double.parseDouble(new DecimalFormat("##.##").format(fromOrderItemPrice1)));
				responseObject.put("toOrderItemPrice", Double.parseDouble(new DecimalFormat("##.##").format(toOrderItemPrice1)));
				responseObject.put("fromCastPerIssue", Double.parseDouble(new DecimalFormat("##.##").format(fromCastPerIssue1)));
				responseObject.put("toCastPerIssue", Double.parseDouble(new DecimalFormat("##.##").format(toCastPerIssue1)));
			}catch(Exception e) {
				LOGGER.info(ERROR +e);
			}
			return responseObject;
		}

		@Override
		public List<OrderClass> getorderClassLookUp(String orderCode, String ocID, String profitCenter,
				String description) {
			List<OrderClass> orderCodeList = new ArrayList<OrderClass>();
			try {
				StringBuilder orderQuery = new StringBuilder();
				orderQuery.append("select oc_id,oc,description,profit_center,(case  when parent_oc_id=4 then 'AUTOMATION'  when parent_oc_id=31  then '1'  when parent_oc_id=14   then 'CANCELPOL'   "
						+ "when parent_oc_id=21   then 'packages' "
						+ " when parent_oc_id=28   then 'package tests' else null "
						+ " end) as parent_oc_id,oc_type from oc where (1=1)");
						
				//"select oc_id,oc,description,profit_center,(case  when parent_oc_id=4 then 'AUTOMATION'  when parent_oc_id=31 then 'AUTO' end) as parent_oc_id,oc_type from oc where (1=1)");		
						
						
				
				if("*".equals(orderCode)){
					orderQuery.append(" and  oc.oc like '%'");}
				else if(orderCode.contains("*")){
					orderQuery.append("  and oc.oc like '"+orderCode.replace('*','%')+"'");}
				else if(!orderCode.equals("")){
						orderQuery.append("  and oc.oc ='"+orderCode+"'");
					}
				if("*".equals(ocID)){
					orderQuery.append(" and oc.oc_id like '%'");}
				else if(ocID.contains("*")){
					orderQuery.append(" and oc.oc_id like '"+ocID.replace('*','%')+"'");}
				else if(!ocID.equals("")){
						orderQuery.append(" and oc.oc_id ='"+ocID+"'");
					}
				if("*".equals(profitCenter)){
					orderQuery.append(" and oc.profit_center like '%'");}
				else if(profitCenter.contains("*")){
					orderQuery.append(" and oc.profit_center like '"+profitCenter.replace('*','%')+"'");}
				else if(!profitCenter.equals("")){
						orderQuery.append(" and oc.profit_center ='"+profitCenter+"'");
					}
						if("*".equals(description)){
							orderQuery.append(" and oc.description like '%'");}
						else if(description.contains("*")){
							orderQuery.append(" and oc.description like '"+description.replace('*','%')+"'");}
						else if(!description.equals("")){
								orderQuery.append(" and oc.description ='"+description+"'");
							}
						orderQuery.append(" ORDER BY oc.oc_id");
				
				orderCodeList = jdbcTemplate.query(orderQuery.toString(), new OrderClassMapper());			
			} catch (Exception e) {
				LOGGER.info("" + e);
			}
			return orderCodeList;
		}
		@Override
		public String getInstallmentPlanType(Integer installmentId) {
			String descripton = null;
			try {
				descripton = jdbcTemplate.queryForObject("select description from installment_plan where installment_plan_id="+installmentId, String.class);
				if(descripton == null) {
					descripton = "";
				}
			}catch (Exception e) {
				LOGGER.info("getInstallmentPlanType : "+e);
			}
			return descripton;
		}
		
		@Override
		public List<Map<String, Object>> getInstallmentPlan() {
			List<Map<String, Object>> installmentPlanList = new ArrayList<>();
			//String query = "select distinct ip.installment_plan_id,ip.description,ip.report,ip.auto_setup,ipd.nbr_installments,ip.nbr_installments,ip.interval,ip.unpaid_issues_new,ip.unpaid_issues_renew,ip.allow_default_usage,ip.interval_type,ip.mru_install_plan_detail_seq,ip.row_version from installment_plan as ip inner join install_plan_detail ipd on ip.installment_plan_id = ipd.installment_plan_id where allow_default_usage !=0";
			String query = "select distinct ip.installment_plan_id,ip.description,ip.report,ip.auto_setup,ip.nbr_installments,ip.interval,ip.unpaid_issues_new,ip.unpaid_issues_renew,ip.allow_default_usage,ip.interval_type,ip.mru_install_plan_detail_seq,ip.row_version from installment_plan as ip where allow_default_usage !=0";
			try{
				installmentPlanList = jdbcTemplate.queryForList(query.toString());
			}catch(Exception e){
				LOGGER.info("getInstallmentPlan : "+e);
			}
			return installmentPlanList;
		}
		
		@Override
		public List<Map<String, Object>> getOrderItemInstallmentDetails(Long orderHdrId, int ordItemSeq) {
			List<Map<String, Object>> installmentPlanList = new ArrayList<>();
			StringBuilder query = new StringBuilder("select installment_number,install_amount,date_sent,orderhdr_id,payment_seq,customer_id,order_item_seq,row_version from order_item_install_dtl ");
			                      query.append("where orderhdr_id=").append(orderHdrId).append(" and order_item_seq=").append(ordItemSeq);
			try{
				installmentPlanList = jdbcTemplate.queryForList(query.toString());
			}catch(Exception e){
				LOGGER.info("getInstallmentPlan : "+e);
			}
			return installmentPlanList;
		}
		@Override
		public List<Map<String, Object>> getCalculatedOrderItemInstallmentAmount(Long orderhdrId, Integer orderItemSeq,Integer installmentIdNew,Integer customerId,Integer subscriptionId,String sourceCodeId,String state,String currency, String orderCodeId,String orderCodeType) {
			List<Map<String, Object>> calculatedInstallmentAmount = new ArrayList<>();
			StringBuilder query = new StringBuilder("select installment_plan_id,gross_base_amount from order_item ");
            query.append("where orderhdr_id=").append(orderhdrId).append(" and order_item_seq=").append(orderItemSeq);
			try {
				List<Map<String, Object>> tableData = jdbcTemplate.queryForList(query.toString());
				//Integer intallmentPlanId = (Integer)tableData.get(0).get("installment_plan_id");
				BigDecimal amount = (BigDecimal)tableData.get(0).get("gross_base_amount");
				Double amount2 = amount.doubleValue();
				Map<String, Object> map = null;
				Integer noOfInstallment = jdbcTemplate.queryForObject("select max(install_plan_detail_seq) from install_plan_detail where installment_plan_id="+installmentIdNew,Integer.class);
				if(noOfInstallment == null) {
					map = new HashMap<>();
					String msg = "Business logic exception detected: cfff004b: No installments defined for this installment type.";
					map.put("msg", msg);
					calculatedInstallmentAmount.add(map);
				}else {
					Double dividedAmount = amount2/noOfInstallment;
					for(int i=1;i<=noOfInstallment;i++) {
						map = new HashMap<>();
						map.put("installment_number", i);
						map.put("install_amount", dividedAmount);
						map.put("date_sent", null);
						map.put("orderhdr_id", orderhdrId);
						map.put("payment_seq", null);
						map.put("customer_id", null);
						map.put("order_item_seq", orderItemSeq);
						calculatedInstallmentAmount.add(map);
					}
				}
			}catch (Exception e) {
				LOGGER.info("getCalculatedOrderItemInstallmentAmount : "+e);
			}
			return calculatedInstallmentAmount;
		}
		public List<Map<String, Object>> appendData(Map<String, Object> map){
			List<Map<String, Object>>calculatedInstallmentAmount = new ArrayList<>();
			calculatedInstallmentAmount.add(map);
			return calculatedInstallmentAmount;
		}

		@Override
		public List<Map<String, Object>> getDefaultOrderItemInstallmentDetails(Long orderHdrId, Integer ordItemSeq) {
			List<Map<String, Object>> defaultOrderItemInstallment = null;
			StringBuilder query = new StringBuilder();
			if(Objects.isNull(orderHdrId) && Objects.isNull(ordItemSeq)) {
				query.append("select top 1 case when order_item.billing_type=1 then 0 else 1 end as type,");
			}else {
				query.append("select case when order_item.billing_type=1 then 0 else 1 end as type,"); 
			}
			query.append("installment_plan.description as installment_plan,case when install_auto_payment is null then 0 else install_auto_payment end as install_auto_payment,"); 
			query.append("case when CONVERT(varchar(10),order_item_install.notice_date,120) is null then CONVERT(varchar(10),DATEADD(year,1,GETDATE()),120) else CONVERT(varchar(10),order_item_install.notice_date,120) end as notice_date,"); 
			query.append("case when order_item_install.send_notice is null then 1 else order_item_install.send_notice end as send_notice,order_item_install.current_year_sent,order_item_install.year_end_sent,"); 
			query.append("case when order_item_install.pull_day is null then config.pull_payment_days else order_item_install.pull_day end as pull_day,"); 
			query.append("config.pull_pay_start_for_cc,"); 
			query.append("convert(varchar(10),order_item_install.payment_start_date,120) as payment_start_date,convert(varchar(10),order_item_install.payment_end_date,120) as payment_end_date,convert(varchar(10),order_item_install.most_recent_payment_date,120) as most_recent_payment_date,convert(varchar(10),order_item_install.next_payment_date,120) as next_payment_date,"); 
			query.append("payment_account.id_nbr as credit_card_no,convert(varchar(10),payment_account.credit_card_expire,120) as credit_card_expire,payment_account.dd_bank_name,payment_account.branch_title,payment_account.ba_nbr as bank_account_no,payment_account.dd_id_nbr_transposed as transposed_acc_no,payment_account.dd_sorting_code as bank_sort_code,"); 
			query.append("case when order_item_install.debit_account_ref is null then mru_account_reference_id.id + 1 else order_item_install.debit_account_ref end as core_reference,"); 
			query.append("case when CONVERT(varchar(10),order_item_install.mandate_date,120) is null then CONVERT(varchar(10),GETDATE(),120) else CONVERT(varchar(10),order_item_install.mandate_date,120) end as mandate_date,"); 
			query.append("order_item_install.auddis_transaction_code,order_item_install.bacs_transaction_code,order_item_install.ddi_accepted,order_item_install.ddi_logged,cancel_dd from order_item "); 
			query.append("left join installment_plan on installment_plan.installment_plan_id = order_item.installment_plan_id "); 
			query.append("left join order_item_install on order_item_install.orderhdr_id = order_item.orderhdr_id and order_item_install.order_item_seq = order_item.order_item_seq ");  
			query.append("left join order_code on order_code.order_code_id = order_item.order_code_id and order_code.disallow_install_billing in (0,1) and order_code.installment_billing_only in (0,1) ");  
			query.append("left join payment_account on payment_account.customer_id = order_item.customer_id and payment_account.payment_account_seq = order_item_install.install_payment_account_seq "); 
			query.append("left join config on 1=1 "); 
			query.append("left join mru_account_reference_id on 1=1"); 
			if(Objects.nonNull(orderHdrId) && Objects.nonNull(ordItemSeq)) {
			 query.append(" where order_item.orderhdr_id=").append(orderHdrId).append(" and order_item.order_item_seq=").append(ordItemSeq);
			}
			try{
				defaultOrderItemInstallment = jdbcTemplate.queryForList(query.toString());
				if(defaultOrderItemInstallment.get(0).get("credit_card_no")!=null) {
					String credit_card_no = new CustomerUtility().decryptedCardNumber(defaultOrderItemInstallment.get(0).get("credit_card_no").toString());
					defaultOrderItemInstallment.get(0).replace("credit_card_no", credit_card_no);
				}if(defaultOrderItemInstallment.get(0).get("bank_account_no")!=null) {
					String bank_account_no = new CustomerUtility().decryptedCardNumber(defaultOrderItemInstallment.get(0).get("bank_account_no").toString());
					defaultOrderItemInstallment.get(0).replace("bank_account_no", bank_account_no);
				}if(defaultOrderItemInstallment.get(0).get("core_reference")!=null) {
					int coreReference = Integer.valueOf(defaultOrderItemInstallment.get(0).get("core_reference").toString());
					defaultOrderItemInstallment.get(0).replace("core_reference", countDigit(coreReference));
				}
			}catch(Exception e){
				LOGGER.info("getDefaultOrderItemInstallmentDetails : "+e);
			}
			return defaultOrderItemInstallment;
		}
		// I have to show minimum 6 digit for core reference if core reference is less than 6
		private String countDigit(int coreRefernce) {
			int actualCoreRefernce = coreRefernce;
			String finalCoreRefence = null;
			int count = 0;
			String append = null;
			while(coreRefernce!=0) {
				coreRefernce = coreRefernce/10;
				count++;
			}
			switch (count) {
			case 1:
				append = "00000"+actualCoreRefernce;
				finalCoreRefence = append;
				break;
			case 2:
				append = "0000"+actualCoreRefernce;
				finalCoreRefence = append;
				break;
			case 3:
				append = "000"+actualCoreRefernce;
				finalCoreRefence = append;
				break;
			case 4:
				append = "00"+actualCoreRefernce;
				finalCoreRefence = append;
				break;
			case 5:
				append = "0"+actualCoreRefernce;
				finalCoreRefence = append;
				break;
			default:
				finalCoreRefence = String.valueOf(actualCoreRefernce);
				break;
			}
			return finalCoreRefence;
		}
		@Override
		public String getTypeDetails(int orderCodeId,int type) {
			List<Map<String, Object>> typeDetails = new ArrayList<>();
			String message = null;
			StringBuilder query = new StringBuilder("select disallow_install_billing,installment_billing_only from order_code where order_code_id=").append(orderCodeId);
			try {
				typeDetails = jdbcTemplate.queryForList(query.toString());
				Integer disallowIntallment = (Integer)typeDetails.get(0).get("disallow_install_billing");
				Integer intallment = (Integer)typeDetails.get(0).get("installment_billing_only");
				if(disallowIntallment == 1 && type == 1) {
					message = "Installment billing has been disallowed by the order code, order class or term.";
				}else {
					
				}
				if(intallment == 1 && type ==0) {
					message = "The order code for this order is set to 'Installment Billing Only'. Cannot change the billing tyep from 'Installment Billing'.";
				}
			}catch (Exception e) {
				LOGGER.info("getTypeDetails : "+e);
			}
			return message;
		}

		@Override
		public int getDisallowInstallment(int orderCodeId) {
			int type = 0;
			try {
				 type = jdbcTemplate.queryForObject("select disallow_install_billing from order_code where order_code_id="+orderCodeId,Integer.class);
			}catch (Exception e) {
				LOGGER.info("getDisallowInstallment : "+e);
			}
			return type;
		}

		@Override
		public int getInstallmentOnly(int orderCodeId) {
			int type = 0;
			try {
				 type = jdbcTemplate.queryForObject("select installment_billing_only from order_code where order_code_id="+orderCodeId,Integer.class);
			}catch (Exception e) {
				LOGGER.info("getDisallowInstallment : "+e);
			}
			return type;
		}

		@Override
		public List<DropdownModel> getPaymentDropdwonList(int customerId, int isActive, String paymentType) {
			List<Map<String, Object>> paymentDetails = new ArrayList<>();
			List<DropdownModel> paymentDropdown = new ArrayList<>();
			StringBuilder creditCardQuery = new StringBuilder("SELECT payment_account_seq,description,id_nbr_last_four FROM payment_account WHERE customer_id = ").append(customerId).append(" and is_active = ").append(isActive).append(" and payment_type in (select payment_type from payment_type where payment_form in (1,6,7) )").append(" ORDER BY customer_id,payment_account_seq");
			StringBuilder debitCardQuery = new StringBuilder("SELECT payment_account_seq,description,id_nbr_last_four FROM payment_account WHERE customer_id = ").append(customerId).append(" and is_active = ").append(isActive).append(" and payment_type in (select payment_type from payment_type where payment_form = 4)").append(" ORDER BY customer_id,payment_account_seq");
			try {
				if(!paymentType.equalsIgnoreCase("DD")) { //if payment type is not DD then displays credit card details otherwise debit card details
					paymentDetails = jdbcTemplate.queryForList(creditCardQuery.toString());
				}else {
					paymentDetails = jdbcTemplate.queryForList(debitCardQuery.toString());
				}
				for(Map<String,Object> row:paymentDetails) {
					DropdownModel model=new DropdownModel();
					model.setKey(row.get("payment_account_seq").toString());
					model.setDisplay(row.get("description")!=null?row.get("description").toString():"");
					model.setExtra(row.get("id_nbr_last_four")!=null?row.get("id_nbr_last_four").toString():"");
					paymentDropdown.add(model);
				}
			}catch (Exception e) {
				LOGGER.info("getPaymentDropdwonList : "+e);
			}
			return paymentDropdown;
		}
		@Override
		public List<Map<String, Object>> getCreditCardDetails(int accountPaymentSeq, int idNbrLastFour) {
			List<Map<String, Object>> creditCardData = null;
			StringBuilder query = new StringBuilder("SELECT payment_account_seq,id_nbr,convert(varchar(10),payment_account.credit_card_expire,120) as credit_card_expire FROM payment_account")
					.append(" WHERE payment_account_seq = ")
					.append(accountPaymentSeq).append(" and id_nbr_last_four=").append(idNbrLastFour);
			try {
				creditCardData = jdbcTemplate.queryForList(query.toString());
				if(creditCardData.get(0).get("id_nbr")!=null) {
					String credit_card_no = new CustomerUtility().decryptedCardNumber(creditCardData.get(0).get("id_nbr").toString());
					creditCardData.get(0).replace("id_nbr", credit_card_no);
				}
				}catch (Exception e) {
					LOGGER.info("getCreditCardDetails: "+e);
			     }
			return creditCardData;
		}

		@Override
		public List<Map<String, Object>> getDebitCardDetails(Long orderHdrId, int customerId,int accountPaymentSeq) {
			List<Map<String, Object>> debitCardData = null;
			Map<String, Object> finalDebitCard = new LinkedHashMap<>();
			StringBuilder query = new StringBuilder("select  top 1 config.pull_payment_days,config.payment_start_interval,order_item_install.payment_end_date,order_item_install.most_recent_payment_date,")
			.append("config.next_payment_interval,payment_account.dd_bank_name,payment_account.branch_title,payment_account.ba_nbr as bank_account_no,payment_account.dd_id_nbr_transposed as transposed_acc_no,")
			.append("payment_account.dd_sorting_code as bank_sort_code,'ON' as auddis_transaction_code,1 as bacs_transaction_code,order_item_install.ddi_accepted,order_item_install.ddi_logged,order_item_install.cancel_dd from order_item ")
			.append("left outer join payment_account on payment_account.customer_id =order_item.customer_id ")
			.append("left outer join order_item_install on 1=1 ")
			.append("left outer join config on 1=1 where  order_item.orderhdr_id=").append(orderHdrId).append(" and order_item.customer_id=").append(customerId);
			if(accountPaymentSeq != 0) {
				query.append(" and payment_account.payment_account_seq=").append(accountPaymentSeq);
			}
			try {
				debitCardData = jdbcTemplate.queryForList(query.toString());
				Integer pullDay = null;
				//Integer paymentStartInterval = null;
				Short nextpaymentInteval  = null;
				for(Map<String,Object>row:debitCardData) {
					DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					if(row.get("pull_payment_days")!=null) {
					pullDay = Integer.valueOf(row.get("pull_payment_days").toString());
					finalDebitCard.put("pull_payment_days", pullDay);
					}
					if(pullDay != null) {
					LocalDate localDate = LocalDate.of(Year.now().getValue(), LocalDate.now().plusMonths(1).getMonthValue(), pullDay);
					String StartDate = FOMATTER.format(localDate);
					//replace original payment start date
					finalDebitCard.put("payment_start_date", StartDate);
					}
					finalDebitCard.put("payment_end_date", row.get("payment_end_date")!=null?row.get("payment_end_date"):null);
					finalDebitCard.put("most_recent_payment_date", row.get("most_recent_payment_date")!=null?row.get("most_recent_payment_date"):null);
					if(row.get("next_payment_interval")!=null) {
					nextpaymentInteval = (Short) row.get("next_payment_interval");
					LocalDate localDate2 = LocalDate.of(Year.now().getValue(), LocalDate.now().plusMonths(1).getMonthValue(), pullDay+nextpaymentInteval);
					String NextDate = FOMATTER.format(localDate2);
					finalDebitCard.put("next_payment_date", NextDate);
					}
					finalDebitCard.put("dd_bank_name", row.get("dd_bank_name"));
					finalDebitCard.put("description", row.get("description"));
					finalDebitCard.put("branch_title", row.get("branch_title"));
					finalDebitCard.put("bank_account_no", row.get("bank_account_no")!=null?new CustomerUtility().decryptedCardNumber(row.get("bank_account_no").toString()):null);
					finalDebitCard.put("transposed_acc_no", row.get("transposed_acc_no"));
					finalDebitCard.put("bank_sort_code", row.get("bank_sort_code"));
					//finalDebitCard.put("core_reference",getMru_account_reference_id());
					//finalDebitCard.put("mandate_date", new CustomerUtility().getCurrentFormattedDate());
					finalDebitCard.put("auddis_transaction_code", row.get("auddis_transaction_code"));
					finalDebitCard.put("bacs_transaction_code", row.get("bacs_transaction_code"));
					finalDebitCard.put("ddi_accepted", row.get("ddi_accepted"));
					finalDebitCard.put("ddi_logged", row.get("ddi_logged"));
					finalDebitCard.put("cancel_dd", row.get("cancel_dd"));
				}
				debitCardData.clear();
				finalDebitCard.put("bank_wizard_installed", isBank_wizard_installed());
				debitCardData.add(finalDebitCard);
			}catch (Exception e) {
				LOGGER.info("getDebitCardDetails: "+e);
			}
			return debitCardData;
		}


		@Override
		@Transactional
		public int saveBillingOptions(OrderItem billingOptions) {
			int status = 0;
			int insertedRecord = 0;
			Map<String, Object> saveBillingOptionParams = new HashMap<>();
			  String saveOrderItemInstall = "insert into order_item_install (orderhdr_id,order_item_seq,install_auto_payment,mandate_date,debit_account_ref,notice_date,send_notice,current_year_sent,year_end_sent,install_payment_account_seq,payment_start_date,payment_end_date,pull_day,ddi_logged,ddi_accepted,most_recent_payment_date,auddis_transaction_code,bacs_transaction_code,cancel_dd,next_payment_date) values (:orderhdr_id,:order_item_seq,:install_auto_payment,:mandate_date,:debit_account_ref,:notice_date,:send_notice,:current_year_sent,:year_end_sent,:install_payment_account_seq,:payment_start_date,:payment_end_date,:pull_day,:ddi_logged,:ddi_accepted,:most_recent_payment_date,:auddis_transaction_code,:bacs_transaction_code,:cancel_dd,:next_payment_date)";
			 //save the record at first time otherwise update
			  Integer rowCount = jdbcTemplate.queryForObject("select count(*) from order_item_install where orderhdr_id="+billingOptions.getOrderhdrId()+" and order_item_seq="+billingOptions.getOrderItemSeq(), Integer.class);
			  if(rowCount == 0 | rowCount == null) {
				  insertedRecord = saveOrderItemInstall(billingOptions, saveOrderItemInstall);
			  }
			  StringBuilder saveBillingOption = new StringBuilder("insert into order_item_install_dtl(orderhdr_id,order_item_seq,installment_number,customer_id,payment_seq,date_sent,install_amount) values(:orderhdr_id,:order_item_seq,:installment_number,:customer_id,:payment_seq,:date_sent,:install_amount)");
			try {
				Long orderHdrId = billingOptions.getOrderhdrId();
				Integer orderItemSeq = billingOptions.getOrderItemSeq();
				Integer installmentIdNew = billingOptions.getInstallmentIdNew();
				if(installmentIdNew != 0) {
					List<Map<String, Object>> dataList = getCalculatedOrderItemInstallmentAmount(orderHdrId, orderItemSeq, installmentIdNew, billingOptions.getCustomerId(),billingOptions.getSubscriptionId(), billingOptions.getSourceCodeID(), billingOptions.getState(), billingOptions.getCurrency(), billingOptions.getOrderCodeID(), billingOptions.getOrderCodeType());
				    Integer countRowInTable = jdbcTemplate.queryForObject("select count(*) from order_item_install_dtl where orderhdr_id="+orderHdrId+" and order_item_seq="+orderItemSeq,Integer.class);
					if(countRowInTable>0)//if data is available then this query delete first then insert new record
						jdbcTemplate.update("delete from order_item_install_dtl where orderhdr_id="+orderHdrId+" and order_item_seq="+orderItemSeq);
					for(Map<String,Object>row:dataList){
				    	saveBillingOptionParams.put("orderhdr_id", row.get("orderhdr_id"));
						saveBillingOptionParams.put("order_item_seq", row.get("order_item_seq"));
						saveBillingOptionParams.put("installment_number", row.get("installment_number"));
						saveBillingOptionParams.put("customer_id", row.get("customer_id")!=null?row.get("customer_id"):null);
						saveBillingOptionParams.put("payment_seq", row.get("payment_seq")!=null?row.get("payment_seq"):null);
						saveBillingOptionParams.put("date_sent", row.get("date_sent")!=null?row.get("date_sent"):null);
						saveBillingOptionParams.put("install_amount", row.get("install_amount"));
						status=namedParameterJdbcTemplate.update(saveBillingOption.toString(), saveBillingOptionParams);
				    }
				}
				StringBuilder editTrailquery = new StringBuilder("insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name) values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:edited,:currency,:table_enum,:document_reference_id,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name)");
				int count = customerUtility.getcurrentDateStampCount();

				if (count == 0) {
					Long dateStampId = customerUtility.getmaxDateStamp();
					customerUtility.insertDateStamp(dateStampId);
				}
				
				Long dateStamp = customerUtility.getmaxDateStamp();
				Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
				saveBillingOptionParams.clear();
				saveBillingOptionParams.put("edit_trail_id", editTrailId);
				saveBillingOptionParams.put("customer_id", billingOptions.getCustomerId()!=0?billingOptions.getCustomerId():null);	
				saveBillingOptionParams.put("customer_address_seq", billingOptions.getCustomerAddressSeq());
				saveBillingOptionParams.put("user_code", billingOptions.getUserCode());
				saveBillingOptionParams.put("subscrip_id", "".equals(billingOptions.getSubscripId())|"null".equals(billingOptions.getSubscripId())?null:billingOptions.getSubscripId());
				saveBillingOptionParams.put("orderhdr_id", billingOptions.getOrderhdrId());
				saveBillingOptionParams.put("order_item_seq", billingOptions.getOrderItemSeq());
				saveBillingOptionParams.put("edited", 1);
				saveBillingOptionParams.put("currency", "".equals(billingOptions.getCurrency())?null:billingOptions.getCurrency());
				saveBillingOptionParams.put("table_enum", 3);
				saveBillingOptionParams.put("document_reference_id", "".equals(billingOptions.getDocumentReferenceId())?null:billingOptions.getDocumentReferenceId());//inserted value should be 1
				saveBillingOptionParams.put("local_amount", "".equals(billingOptions.getLocalAmount())?null:billingOptions.getLocalAmount());
				saveBillingOptionParams.put("base_amount", "".equals(billingOptions.getBaseAmount())?null:billingOptions.getBaseAmount());
				saveBillingOptionParams.put("date_stamp", dateStamp);
				LocalDate date = LocalDate.now();
				String time = LocalTime.now().toString();
				String trimedTime = time.substring(0, time.indexOf("."));
				String finalDate = date+" "+trimedTime; 
				saveBillingOptionParams.put("creation_date", finalDate);
				saveBillingOptionParams.put("xaction_name", "order_item_edit_request");
				status = namedParameterJdbcTemplate.update(editTrailquery.toString(), saveBillingOptionParams);
				customerUtility.updateMruEditTrailId(editTrailId);
				saveBillingOptionParams.clear();
				saveBillingOptionParams.put("table_name","order_item_install");
				//column name of order_item table
				List<String> columnName = namedParameterJdbcTemplate.queryForList("SELECT column_name FROM information_schema.columns WHERE table_name=:table_name",saveBillingOptionParams, String.class);
				//List<String> ordrList = columnName.stream().filter(ordr -> ordr.startsWith("install_auto_payment")).collect(Collectors.toList());
				columnName.removeIf(filter-> filter.contains("orderhdr_id"));
				columnName.removeIf(filter-> filter.contains("order_item_seq"));
				columnName.removeIf(filter-> filter.contains("row_version"));
				saveBillingOptionParams.clear();
				saveBillingOptionParams.put("orderhdr_id",billingOptions.getOrderhdrId());
				saveBillingOptionParams.put("order_item_seq",billingOptions.getOrderItemSeq());
				int tableCount = namedParameterJdbcTemplate.queryForObject("select count(*) from order_item_install where orderhdr_id= :orderhdr_id and order_item_seq= :order_item_seq ",saveBillingOptionParams,Integer.class);
				Map<String, Object> updateOrderItemInstall = new HashMap<>();
				//update installment_plan_id for order_item table
				//if record inserted at first time then we have to upate two column billing_type and installment_plan_id otherwise update only installment_plan_id column
				 if(insertedRecord ==0) {
					 if(installmentIdNew != 0) {
						 jdbcTemplate.update("update order_item set installment_plan_id = "+installmentIdNew+" where orderhdr_id="+orderHdrId+" and order_item_seq="+orderItemSeq);
					 }
					 //update order_item_installment table 
						StringBuilder orderItemInstallmentQuery = new StringBuilder("update order_item_install set ");
						if(billingOptions.getInstallAutoPayment().equals("0")) {
							orderItemInstallmentQuery.append("install_auto_payment=:install_auto_payment");
							updateOrderItemInstall.put("install_auto_payment", "".equals(billingOptions.getInstallAutoPayment())?0:billingOptions.getInstallAutoPayment());
							orderItemInstallmentQuery.append(",notice_date=:notice_date");
							updateOrderItemInstall.put("notice_date", "".equals(billingOptions.getNoticeDate())?null:new PropertyUtilityClass().saveDateFormatter(billingOptions.getNoticeDate()));
							orderItemInstallmentQuery.append(",send_notice=:send_notice");
							updateOrderItemInstall.put("send_notice", "".equals(billingOptions.getSendNotice())?1:billingOptions.getSendNotice());
							orderItemInstallmentQuery.append(",current_year_sent=:current_year_sent");
							updateOrderItemInstall.put("current_year_sent", "".equals(billingOptions.getCurrentYearSent())?0:billingOptions.getCurrentYearSent());
							orderItemInstallmentQuery.append(",year_end_sent=:year_end_sent");
							updateOrderItemInstall.put("year_end_sent", "".equals(billingOptions.getYearEndSent())?0:billingOptions.getYearEndSent());
							orderItemInstallmentQuery.append(",debit_account_ref=:debit_account_ref");
							updateOrderItemInstall.put("debit_account_ref", "".equals(billingOptions.getDebitAccountRef())?null:billingOptions.getDebitAccountRef());
							orderItemInstallmentQuery.append(",mandate_date=:mandate_date");
							updateOrderItemInstall.put("mandate_date", "".equals(billingOptions.getMandateDate())?null:new PropertyUtilityClass().saveDateFormatter(billingOptions.getMandateDate()));
							orderItemInstallmentQuery.append(" where orderhdr_id=").append(billingOptions.getOrderhdrId()).append(" and order_item_seq=").append(billingOptions.getOrderItemSeq());
							status = namedParameterJdbcTemplate.update(orderItemInstallmentQuery.toString(), updateOrderItemInstall);
						}else {
							orderItemInstallmentQuery.append("install_auto_payment=:install_auto_payment");
							updateOrderItemInstall.put("install_auto_payment", "".equals(billingOptions.getInstallAutoPayment())?0:billingOptions.getInstallAutoPayment());
							orderItemInstallmentQuery.append(",notice_date=:notice_date");
							updateOrderItemInstall.put("notice_date", "".equals(billingOptions.getNoticeDate())?null:new PropertyUtilityClass().saveDateFormatter(billingOptions.getNoticeDate()));
							orderItemInstallmentQuery.append(",send_notice=:send_notice");
							updateOrderItemInstall.put("send_notice", "".equals(billingOptions.getSendNotice())?1:billingOptions.getSendNotice());
							orderItemInstallmentQuery.append(",current_year_sent=:current_year_sent");
							updateOrderItemInstall.put("current_year_sent", "".equals(billingOptions.getCurrentYearSent())?0:billingOptions.getCurrentYearSent());
							orderItemInstallmentQuery.append(",year_end_sent=:year_end_sent");
							updateOrderItemInstall.put("year_end_sent", "".equals(billingOptions.getYearEndSent())?0:billingOptions.getYearEndSent());
							orderItemInstallmentQuery.append(",mandate_date=:mandate_date");
							updateOrderItemInstall.put("mandate_date", "".equals(billingOptions.getMandateDate())?null:new PropertyUtilityClass().saveDateFormatter(billingOptions.getMandateDate()));
							orderItemInstallmentQuery.append(",debit_account_ref=:debit_account_ref");
							updateOrderItemInstall.put("debit_account_ref", "".equals(billingOptions.getDebitAccountRef())?null:billingOptions.getDebitAccountRef());
							orderItemInstallmentQuery.append(",install_payment_account_seq=:install_payment_account_seq");
							updateOrderItemInstall.put("install_payment_account_seq", billingOptions.getInstallPaymentAccountSeq()!=null?billingOptions.getInstallPaymentAccountSeq():null);
							orderItemInstallmentQuery.append(",pull_day=:pull_day");
							updateOrderItemInstall.put("pull_day", billingOptions.getPullDay()!=null?billingOptions.getPullDay():null);
							orderItemInstallmentQuery.append(",payment_start_date=:payment_start_date");
							updateOrderItemInstall.put("payment_start_date", "".equals(billingOptions.getPaymentStartDate())?null:new PropertyUtilityClass().saveDateFormatter(billingOptions.getPaymentStartDate()));
							orderItemInstallmentQuery.append(",payment_end_date=:payment_end_date");
							updateOrderItemInstall.put("payment_end_date", "".equals(billingOptions.getPaymentEndDate())?null:new PropertyUtilityClass().saveDateFormatter(billingOptions.getPaymentEndDate()));
							orderItemInstallmentQuery.append(",most_recent_payment_date=:most_recent_payment_date");
							updateOrderItemInstall.put("most_recent_payment_date", "".equals(billingOptions.getMostRecentPaymentDate())?null:new PropertyUtilityClass().saveDateFormatter(billingOptions.getMostRecentPaymentDate()));
							orderItemInstallmentQuery.append(",next_payment_date=:next_payment_date");
							updateOrderItemInstall.put("next_payment_date","".equals(billingOptions.getNextPaymentDate())?null:new PropertyUtilityClass().saveDateFormatter(billingOptions.getNextPaymentDate()));
							
							orderItemInstallmentQuery.append(",ddi_logged=:ddi_logged");
							updateOrderItemInstall.put("ddi_logged", "".equals(billingOptions.getDdiLogged())?0:billingOptions.getDdiLogged());
							orderItemInstallmentQuery.append(",ddi_accepted=:ddi_accepted");
							updateOrderItemInstall.put("ddi_accepted", "".equals(billingOptions.getDdiAccepted())?0:billingOptions.getDdiAccepted());
							orderItemInstallmentQuery.append(",auddis_transaction_code=:auddis_transaction_code");
							updateOrderItemInstall.put("auddis_transaction_code", "".equals(billingOptions.getAuddisTransactionCode())?null:billingOptions.getAuddisTransactionCode());
							orderItemInstallmentQuery.append(",bacs_transaction_code=:bacs_transaction_code");
							updateOrderItemInstall.put("bacs_transaction_code", "".equals(billingOptions.getBacsTransactionCode())?null:billingOptions.getBacsTransactionCode());
							orderItemInstallmentQuery.append(",cancel_dd=:cancel_dd");
							updateOrderItemInstall.put("cancel_dd", "".equals(billingOptions.getCancelDD())?0:billingOptions.getCancelDD());
							orderItemInstallmentQuery.append(" where orderhdr_id=").append(billingOptions.getOrderhdrId()).append(" and order_item_seq=").append(billingOptions.getOrderItemSeq());
							status = namedParameterJdbcTemplate.update(orderItemInstallmentQuery.toString(), updateOrderItemInstall);
						}
				
				}else {
					jdbcTemplate.update("update order_item set billing_type=2,installment_plan_id = "+installmentIdNew+" where orderhdr_id="+orderHdrId+" and order_item_seq="+orderItemSeq);
					updateOrderItemInstall = saveBillingOptionParams;
				}
				Map<String, Object> orderItemPreviousData=null;
				if(tableCount>0)
					orderItemPreviousData = namedParameterJdbcTemplate.queryForMap("select install_auto_payment,mandate_date,debit_account_ref,notice_date,send_notice,current_year_sent,year_end_sent,install_payment_account_seq,payment_start_date,payment_end_date,pull_day,ddi_logged,ddi_accepted,most_recent_payment_date,auddis_transaction_code,bacs_transaction_code,cancel_dd,next_payment_date from order_item_install where orderhdr_id= :orderhdr_id and order_item_seq= :order_item_seq",saveBillingOptionParams);
				
				saveBillingOptionParams.clear();
				for(String column: columnName) {
					if(tableCount>0) {
						if(!(orderItemPreviousData.get(column)==null?"":orderItemPreviousData.get(column).toString()).equals(updateOrderItemInstall.get(column)))
							customerUtility.insertEditTrailDelta(editTrailId, column, orderItemPreviousData.get(column), "".equals(updateOrderItemInstall.get(column))?null:updateOrderItemInstall.get(column));
					}else {
						if(!"".equals(column))
							customerUtility.insertEditTrailDelta(editTrailId, column, null, "".equals(updateOrderItemInstall.get(column))?null:updateOrderItemInstall.get(column));
					}
				}
			
				
			    
			}catch (Exception e) {
				LOGGER.info("saveBillingOptions: "+e);
			}
			return status;
		}
		@Transactional
		private int saveOrderItemInstall(OrderItem model,String query) {
			int status = 0;
			Map<String, Object> orderItemInstallParams = new HashMap<>();
			try {
				orderItemInstallParams.put("orderhdr_id", model.getOrderhdrId());
				orderItemInstallParams.put("order_item_seq", model.getOrderItemSeq());
				orderItemInstallParams.put("install_auto_payment", "".equals(model.getInstallAutoPayment())?0:model.getInstallAutoPayment());
				orderItemInstallParams.put("mandate_date", "".equals(model.getMandateDate())?null:new PropertyUtilityClass().saveDateFormatter(model.getMandateDate()));
				orderItemInstallParams.put("debit_account_ref", "".equals(model.getDebitAccountRef())?null:model.getDebitAccountRef());
				orderItemInstallParams.put("notice_date","".equals(model.getNoticeDate())?null:new PropertyUtilityClass().saveDateFormatter(model.getNoticeDate()));
				orderItemInstallParams.put("send_notice", "".equals(model.getSendNotice())?1:model.getSendNotice());
				orderItemInstallParams.put("current_year_sent", "".equals(model.getCurrentYearSent())?0:model.getCurrentYearSent());
				orderItemInstallParams.put("year_end_sent", "".equals(model.getYearEndSent())?0:model.getYearEndSent());
				orderItemInstallParams.put("install_payment_account_seq", model.getInstallPaymentAccountSeq()==null?null:model.getInstallPaymentAccountSeq());
				orderItemInstallParams.put("payment_start_date", "".equals(model.getPaymentStartDate())?null:new PropertyUtilityClass().saveDateFormatter(model.getPaymentStartDate()));
				orderItemInstallParams.put("payment_end_date", "".equals(model.getPaymentEndDate())?null:new PropertyUtilityClass().saveDateFormatter(model.getPaymentEndDate()));
				orderItemInstallParams.put("pull_day", model.getPullDay()!=null?model.getPullDay():null);
				orderItemInstallParams.put("ddi_logged", "".equals(model.getDdiLogged())?0:model.getDdiLogged());
				orderItemInstallParams.put("ddi_accepted", "".equals(model.getDdiAccepted())?0:model.getDdiAccepted());
				orderItemInstallParams.put("most_recent_payment_date", "".equals(model.getMostRecentPaymentDate())?null:new PropertyUtilityClass().saveDateFormatter(model.getMostRecentPaymentDate()));
				orderItemInstallParams.put("auddis_transaction_code", "".equals(model.getAuddisTransactionCode())?null:model.getAuddisTransactionCode());
				orderItemInstallParams.put("bacs_transaction_code", "".equals(model.getBacsTransactionCode())?null:model.getBacsTransactionCode());
				orderItemInstallParams.put("cancel_dd", "".equals(model.getCancelDD())?0:model.getCancelDD());
				orderItemInstallParams.put("next_payment_date","".equals(model.getNextPaymentDate())?null:new PropertyUtilityClass().saveDateFormatter(model.getNextPaymentDate()));
				
				status = namedParameterJdbcTemplate.update(query, orderItemInstallParams);
			}catch (Exception e) {
				LOGGER.info("saveOrderItemInstall: "+e);
			}
			return status;
		}

		@Override
		public List<Map<String, Object>> getPullDayData(Integer pull,Integer autoPayment) {
			List<Map<String, Object>> pullDayTableData = null;
			Map<String, Object> finalPullData = new LinkedHashMap<>();
			String query = "select pull_payment_days,payment_start_interval,next_payment_interval,pull_pay_start_for_cc from config";
			try {
				pullDayTableData = jdbcTemplate.queryForList(query.toString());
				Integer pullDay = null;
				//[{pull_payment_days=1, payment_start_interval=null, next_payment_interval=null, pull_pay_start_for_cc=1}]
				Short nextpaymentInteval  = null;
				for(Map<String,Object>row:pullDayTableData) {
					Integer pull_pay_start_for_cc = Integer.valueOf(row.get("pull_pay_start_for_cc").toString());
					if((pull != null && autoPayment == 1) && pull_pay_start_for_cc!=null) {
						//pullDay = Integer.valueOf(row.get("pull_payment_days").toString());
						pullDay = pull;
						finalPullData.put("pull_payment_days", pullDay);
						
						DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.of(Year.now().plusYears(0).getValue(), LocalDate.now().plusMonths(0).getMonthValue(), pullDay);
						String StartDate = FOMATTER.format(localDate);
						//replace original payment start date
						finalPullData.put("payment_start_date", StartDate);
						finalPullData.put("payment_end_date", row.get("payment_end_date"));
						finalPullData.put("most_recent_payment_date", row.get("most_recent_payment_date"));
						if(row.get("next_payment_interval")!=null) {
							nextpaymentInteval = Short.valueOf(row.get("next_payment_interval").toString());
						}else {
							nextpaymentInteval = null;
						}
						if(nextpaymentInteval != null) {
						LocalDate localDate2 = LocalDate.of(Year.now().plusYears(0).getValue(), LocalDate.now().plusMonths(0).getMonthValue(), pullDay+nextpaymentInteval);
						String NextDate = FOMATTER.format(localDate2);
						finalPullData.put("next_payment_date", NextDate);
						//finalPullData.put("pull_pay_start_for_cc", row.get("pull_pay_start_for_cc"));
						}
					}else {
						//pullDay = Integer.valueOf(row.get("pull_payment_days").toString());
						pullDay = pull;
						finalPullData.put("pull_payment_days", pullDay);
						
						DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						if(pullDay != null) {
						LocalDate localDate = LocalDate.of(Year.now().plusYears(0).getValue(), LocalDate.now().plusMonths(0).getMonthValue(), pullDay);
						String StartDate = FOMATTER.format(localDate);
						//replace original payment start date
						finalPullData.put("payment_start_date", StartDate);
					    }
						finalPullData.put("payment_end_date", row.get("payment_end_date"));
						finalPullData.put("most_recent_payment_date", row.get("most_recent_payment_date"));
						if(nextpaymentInteval != null) {
						LocalDate localDate2 = LocalDate.of(Year.now().plusYears(0).getValue(), LocalDate.now().plusMonths(0).getMonthValue(), pullDay+nextpaymentInteval);
						String NextDate = FOMATTER.format(localDate2);
						finalPullData.put("next_payment_date", NextDate);
						}
					}
					
				}
				pullDayTableData.clear();
				pullDayTableData.add(finalPullData);
				}catch (Exception e) {
					LOGGER.info("getPullDayData: "+e);
			     }
			return pullDayTableData;
		}

		@Override
		public String getUseUnitValue(long orderHdrId, int orderItemSeq) {
			LOGGER.info("inside getAmountForNoOfIssue");
			StringBuilder query = new StringBuilder();
			String nIssuesLeft = null;
			try {
				query.append("select n_issues_left from order_item where orderhdr_id = ");
				query.append(orderHdrId);
				query.append(" and order_item_seq =");
				query.append(orderItemSeq);
				nIssuesLeft = jdbcTemplate.queryForObject(query.toString(), String.class);
			} catch (EmptyResultDataAccessException e) {
				nIssuesLeft = null;
			}
			return nIssuesLeft;
		}
	
	@Override
	@Transactional
	public boolean getUnitSave(OrderItem orderItem) {
		LOGGER.info("inside getUnitSave");
		StringBuilder query = new StringBuilder();
		Map<String, Object> parameter = new HashMap<>();
		try {
			StringBuilder nIssuesQry = new StringBuilder("select n_issues_left from order_item where orderhdr_id=");
			nIssuesQry.append(orderItem.getOrderhdrId()).append(" and order_item_seq =").append(orderItem.getOrderItemSeq());
			int nIssuesLeft = jdbcTemplate.queryForObject(nIssuesQry.toString(), Integer.class);
			int nRemainingPaidIssues = jdbcTemplate
					.queryForObject(
							"select n_remaining_paid_issues from order_item where orderhdr_id="
									+ orderItem.getOrderhdrId() + " and order_item_seq =" + orderItem.getOrderItemSeq(),
							Integer.class);
			int useUnitNumber = orderItem.getUnitUse();
			nIssuesLeft = nIssuesLeft - useUnitNumber;
			nRemainingPaidIssues = nRemainingPaidIssues - useUnitNumber;
			query.append("update order_item set n_issues_left=:n_issues_left,n_remaining_paid_issues=:n_remaining_paid_issues,"
					+ "mru_unit_history_seq=:mru_unit_history_seq where orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq");
//			query.append(orderItem.getOrderhdrId());
//			query.append(" and order_item_seq =");
//			query.append(orderItem.getOrderItemSeq());

			query.append(
					" insert into unit_history (orderhdr_id,order_item_seq,unit_history_seq,user_code,subscrip_id,profit_center,profit_center_calendar_seq,unit_type_id,unit_usage,quantity,date_stamp,revenue_status,unit_description,creation_date) values"
							+ " (:orderhdr_id,:order_item_seq,:unit_history_seq,:user_code,:subscrip_id,:profit_center,:profit_center_calendar_seq,:unit_type_id,:unit_usage,:quantity,:date_stamp,:revenue_status,:unit_description,:creation_date)");

			int editTrailId = jdbcTemplate.queryForObject("select max(edit_trail_id) from edit_trail ",
					Integer.class);
			editTrailId =editTrailId+1;
			jdbcTemplate.update(
					"set nocount on if not exists (select 1 from information_schema.tables where table_name = 'mru_edit_trail_id') begin create table mru_edit_trail_id (id int) insert mru_edit_trail_id (id) values (1) end else update mru_edit_trail_id with (TABLOCKX) set id = "
							+ editTrailId);
			 editTrailId = jdbcTemplate.queryForObject("select id from mru_edit_trail_id with (TABLOCKX)",
					Integer.class);
			query.append(
					" insert into edit_trail (edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,edited,currency,table_enum,document_reference_id,local_amount,base_amount,date_stamp,creation_date,xaction_name) values "
							+ "(:edit_trail_id, :customer_id, :customer_address_seq, :user_code, :subscrip_id, :orderhdr_id, :order_item_seq, :edited, :currency, :table_enum, :document_reference_id, :local_amount, :base_amount, :date_stamp, :creation_date, :xaction_name)");
			parameter.put("n_issues_left", nIssuesLeft);
			parameter.put("edited", 1);
			parameter.put("table_enum", 3);
			parameter.put("local_amount", orderItem.getLocalAmount());
			parameter.put("base_amount", orderItem.getBaseAmount());
			parameter.put("xaction_name","unit_use_request");
			//parameter.put("document_reference_id", orderItem.getDocumentReferenceId());
			parameter.put("document_reference_id",1);
			parameter.put("currency", orderItem.getCurrency());
			parameter.put("customer_id", orderItem.getCustomerId());
			parameter.put("customer_address_seq", orderItem.getCustomerAddressSeq());
			parameter.put("edit_trail_id", editTrailId);
			parameter.put("n_remaining_paid_issues", nRemainingPaidIssues);
			parameter.put("orderhdr_id", orderItem.getOrderhdrId());
			parameter.put("order_item_seq", orderItem.getOrderItemSeq());
			int unitHistorySeq = jdbcTemplate.queryForObject("select max(unit_history_seq) from unit_history",
					Integer.class);
			unitHistorySeq =unitHistorySeq+1;
			parameter.put("unit_history_seq", unitHistorySeq);
			parameter.put("mru_unit_history_seq", orderItem.getMruUnitHistorySeq());
			parameter.put("user_code", orderItem.getUserCode());
			parameter.put("subscrip_id", orderItem.getSubscripId());
			StringBuilder profitCenterQry = new StringBuilder("select profit_center from oc inner join  order_item  on oc.oc_id=order_item.oc_id where order_item.orderhdr_id =");
			profitCenterQry.append(orderItem.getOrderhdrId());
			profitCenterQry.append("and order_item.order_item_seq=");
			profitCenterQry.append(orderItem.getOrderItemSeq());
			String profitCenter = jdbcTemplate.queryForObject(profitCenterQry.toString(), String.class);
			parameter.put("profit_center", profitCenter);
			int profitCenterCalendarSeq = jdbcTemplate.queryForObject("select profit_center_calendar_seq from profit_center_calendar where profit_center="+"'"+profitCenter+"'", Integer.class);
			parameter.put("profit_center_calendar_seq", profitCenterCalendarSeq);
			parameter.put("unit_type_id", orderItem.getUnitTypeId());
			parameter.put("unit_usage", orderItem.getUnitExcess());
			parameter.put("quantity", orderItem.getUnitUse());
			parameter.put("date_stamp", orderItem.getDateStamp());
			parameter.put("revenue_status", 1);
			parameter.put("unit_description", orderItem.getUnitDescription());
			parameter.put("creation_date", orderItem.getOrderDate());
			parameter.put("order_status", orderItem.getOrder_status());
			namedParameterJdbcTemplate.update(query.toString(), parameter);
			customerUtility.updateMruEditTrailId(editTrailId);
			return true;

		} catch (Exception e) {
			LOGGER.info(ERROR + e);
			return false;
		}
	
	}

	@Override
	public Map<String,Object> getOptionData(int oldNoOfCopy, int newNoOfCopy, long orderhdrId, int orderItemSeq, String orderClass,
			String orderCode, int orderLineNumber, float orderPrice,float fromNoOfDays) {
		LOGGER.info("inside getOptionData method");
		Map<String,Object> responsObject = null;
		responsObject = new HashMap<>();
		try {
			//float chageOrderAmountToPrice = orderPrice*newNoOfCopy;
			//float toNumberOfDays = (orderPrice*oldNoOfCopy)/newNoOfCopy; 
			//for option 1
			responsObject.put("changeBundleQtyPrice", orderPrice);
			responsObject.put("newNumberOfCopies", newNoOfCopy);
			//for option 2
			float price1 = fromNoOfDays*newNoOfCopy;
			responsObject.put("chageOrderAmountFromPrice", orderPrice);
			responsObject.put("chageOrderAmountToPrice", price1);
			//for option 3
			float toNumberOfDays = (fromNoOfDays*oldNoOfCopy)/newNoOfCopy; 
			responsObject.put("fromNumberOfDays", fromNoOfDays);
			responsObject.put("fromNumberOfCopies", oldNoOfCopy);
			responsObject.put("toNumberOfDays", toNumberOfDays);
			responsObject.put("fromNumberOfCopies", newNoOfCopy);
			// for option 4
			float price2 = (orderPrice*newNoOfCopy)/oldNoOfCopy;
			responsObject.put("prorateOrderFromPrice", orderPrice);
			responsObject.put("prorateOrderToPrice", price2);
			responsObject.put("fromNoOfCopy", oldNoOfCopy);
			responsObject.put("toNoOfCopy", newNoOfCopy);
			//common for all option
			responsObject.put("orderClass", orderClass);
			responsObject.put("orderNumber", orderhdrId);
			responsObject.put("orderCode", orderCode);
			responsObject.put("orderLineNumber", orderItemSeq);
		}catch(Exception e) {
			LOGGER.info(ERROR + e);	
		}
		return responsObject;
		
		
	}

	@Override
	public Map<String,Object> saveNoOfCopyChange(float price ,int numberOfCopy, int option) {
		LOGGER.info("inside into saveNoOfCopyChange method ");
		Map<String,Object> responseObject = null;
		                   responseObject = new HashMap<>();
		try {
			
			switch(option) {
			case 1:
				responseObject.put("numberOfCopy", numberOfCopy);
			case 2:
				responseObject.put("numberOfCopy", numberOfCopy);
				responseObject.put("localAmount", price);
				responseObject.put("baseAmount", price);
				responseObject.put("localNetAmount", price);
				responseObject.put("localGrossAmount", price);
				responseObject.put("BaseNetAmount", price);
				responseObject.put("BaseGrossAmount", price);
				
			    break;
			case 3:
				responseObject.put("numberOfCopy", numberOfCopy);
				responseObject.put("localAmount", price);
				responseObject.put("baseAmount", price);
				responseObject.put("localNetAmount", price);
				responseObject.put("localGrossAmount", price);
				responseObject.put("BaseNetAmount", price);
				responseObject.put("BaseGrossAmount", price);
				break;
			case 4:
				responseObject.put("proratedFromPrice", price);
				responseObject.put("proratedToPrice", price);
				
				break;
			
			default:
			
			}
			
			return responseObject;
		}catch(Exception e){
			LOGGER.error(e + ERROR);
			return responseObject;
		}
		
	
	}

	@Override
	public List<DropdownModel> getBillingTypeList(){
	List<DropdownModel> billingTypeList= new ArrayList<>();
		try{
			for (int i=0; i<=2; i++) {
				DropdownModel model = new DropdownModel();	
				if(i == 0)
				continue;
				model.setDisplay(new PropertyUtilityClass().getConstantValue("billing_type_"+i));
				int j = 0;
				if(i == 1) {
					j = 0;
				}else {
					j = 1;
				}
				model.setKey(""+j);
				billingTypeList.add(model);
			}
		
			} catch (Exception e){
			LOGGER. error(ERROR+e);
		}
		return billingTypeList;
	}
	 
	 @Override
	 public List<DropdownModel> getAutoPaymentList(){
		  List<DropdownModel> autoPaymentList= new ArrayList<>();
		  DropdownModel model = null;
		  try{
			  for (int i=0; i<=2; i++) {
			    model = new DropdownModel();		  
				model.setKey(""+i);
				model.setDisplay(new PropertyUtilityClass().getConstantValue("auto_payment_"+i));
				autoPaymentList.add(model);
			  }
		  } catch (Exception e){
			LOGGER.  error(ERROR+e);
		  }
		  return autoPaymentList;
	  }

	@Override
	public List<Map<String, Object>> getGenericPromoCodeDetails(String promoCode) {
		List<Map<String, Object>> promoDetails = new ArrayList<>();
		StringBuilder query = new StringBuilder("select distinct gpc.generic_promotion_code_seq, gpc.promotion_code,oc.order_code_id,oc.order_code,oc.description as order_code_description,sc.source_code_id,sc.source_code,sc.description as source_code_description,")
		.append("sd.subscription_def_id,sd.subscription_def,sd.description as subscription_def_description,") 
		.append("pkg_def.pkg_def_id,pkg_def.pkg_def,pkg_def.description as pkg_def_description,") 
		.append("product.product_id,product.product,product.description as product_description,")
		.append("issue.issue_id,convert(varchar(10), issue.issue_date,101) as issue_date,issue.enumeration,oc.oc_id,oc.order_code_type ")
		.append("from generic_promotion_code as gpc ") 
		.append("left join generic_promotion gp on gp.source_code_id=gpc.source_code_id ")
		.append("left join source_code as sc on gpc.source_code_id=sc.source_code_id ") 
		.append("left join order_code as oc on oc.order_code_id= gp.order_code_id ") 
		.append("left join subscription_def as sd on  sd.subscription_def_id = gp.subscription_def_id ")
		.append("left join product on product.product_id=gp.product_id ")
		.append("left join pkg_def on pkg_def.pkg_def_id = gp.pkg_def_id ")
		.append("left join issue on issue.issue_id = gp.issue_id ")
		.append("where gpc.promotion_code = '").append(promoCode).append("'");
		
		try {
			promoDetails = jdbcTemplate.queryForList(query.toString());
			promoDetails.forEach(Objects::isNull);
		}catch (Exception e) {
			LOGGER.  error(ERROR+e);
		}
		return promoDetails;
	}

	
	
	@Override
	 public List<ReviewAddsKillsModel> getVerifiedAddsKillsFromDataSource(int customer_id,int subscrip_id)
	 {
		 LOGGER.info("inside getVerifiedAddsKillsFromDataSource");
		 List<ReviewAddsKillsModel> reviewAddsKillsModelList=null;
			try 
			{
				String reviewAddsKillsQuery = "SELECT issue_id,sub_add,n_addition_copies,sub_add_reason,sub_kill,n_deletion_copies,sub_kill_reason,"+
						"additions_deletions_seq,bundle_qty,sub_start_reason,subscrip_id,order_item_seq,sub_on_reason,new_audit_qual_category,"+
						"sub_off,creation_date,sub_off_reason,orderhdr_id,sub_start,add_kill_status,"+
						"old_audit_qual_category,sub_stop_reason,job_id,sub_stop,sub_on"+
						" FROM additions_deletions where customer_id="+customer_id+" "
						+ "and subscrip_id="+subscrip_id+" and add_kill_status=1 AND (sub_add=1 OR sub_kill=1);";	
				
				reviewAddsKillsModelList=jdbcTemplate.query(reviewAddsKillsQuery, new ReviewAddsKillsMapper());
			} catch (Exception e) 
			{
				LOGGER.info("reviewAddsKillsModelList" + e);
				e.printStackTrace();
			}
			return reviewAddsKillsModelList;
	 }
	 
	 
	 
	 @Override
	 public List<ReviewAddsKillsModel> getNonVerifiedAddsKillsFromDataSource(int customer_id,int subscrip_id)
	 {
		 LOGGER.info("inside getNonVerifiedAddsKillsFromDataSource");
		 List<ReviewAddsKillsModel> reviewAddsKillsModelList=null;
			try 
			{
				String reviewAddsKillsQuery = "SELECT issue_id,sub_add,n_addition_copies,sub_add_reason,sub_kill,n_deletion_copies,sub_kill_reason,"+
						"additions_deletions_seq,bundle_qty,sub_start_reason,subscrip_id,order_item_seq,sub_on_reason,new_audit_qual_category,"+
						"sub_off,creation_date,sub_off_reason,orderhdr_id,sub_start,add_kill_status,old_audit_qual_category,sub_stop_reason,job_id,sub_stop,sub_on "
						+ "FROM additions_deletions where customer_id="+customer_id+" and subscrip_id="+subscrip_id+";";	
				
				reviewAddsKillsModelList=jdbcTemplate.query(reviewAddsKillsQuery, new ReviewAddsKillsMapper());
			} catch (Exception e) 
			{
				LOGGER.info("reviewAddsKillsModelList" + e);
				e.printStackTrace();
			}
			return reviewAddsKillsModelList;
	 }
	 
	 
	 
	 @Override
	 public List<ProposedAddsKillsModel> getProposedAddsKillsFromDataSource(int subscrip_id)
	 {
		 LOGGER.info("inside getProposedAddsKillsFromDataSource");
		 List<ProposedAddsKillsModel> proposedAddsKillsModelList=null;
			try 
			{
				String proposedAddsKillsQuery = "SELECT sub_add,sub_add_reason,sub_kill,sub_kill_reason,subscrip_id,sub_on_reason,sub_off,sub_off_reason,"+
						"additions_deletions_seq,sub_start,sub_start_reason,sub_stop_reason,sub_stop,sub_on,job_id"
						+ " FROM proposed_additions_deletions"
						+ " Where subscrip_id="+subscrip_id+" AND (sub_add=1 OR sub_kill=1);";	
				
				proposedAddsKillsModelList=jdbcTemplate.query(proposedAddsKillsQuery, new ProposedAddsKillsMapper());
			} catch (Exception e) 
			{
				LOGGER.info("proposedAddsKillsModelList" + e);
				e.printStackTrace();
			}
			return proposedAddsKillsModelList;
	 }
	 
	 
	 
	 @Override
	 public List<ReviewOnsOffsModel> getReviewOnsOffsFromDataSource(int customer_id,int subscrip_id)
	 {
		 LOGGER.info("inside getReviewOnsOffsFromDataSource");
		 List<ReviewOnsOffsModel> reviewOnsOffsModelList=null;
			try 
			{
				String reviewOnsOffsQuery = "SELECT issue_id,sub_on,n_addition_copies,sub_on_reason,sub_off,n_deletion_copies,sub_off_reason,"+
							"order_item_seq,sub_kill_reason,additions_deletions_seq,subscrip_id,bundle_qty,sub_start_reason,"+
							"new_audit_qual_category,orderhdr_id,creation_date,sub_add_reason,sub_kill,sub_start,sub_add,"+
							"add_kill_status,sub_stop_reason,job_id,sub_stop,old_audit_qual_category"+
						" FROM additions_deletions where customer_id="+customer_id+" "
						+ "and subscrip_id="+subscrip_id+" AND (sub_on=1 OR sub_off=1);";	
				
				reviewOnsOffsModelList=jdbcTemplate.query(reviewOnsOffsQuery, new ReviewOnsOffsMapper());
			} catch (Exception e) 
			{
				LOGGER.info("reviewOnsOffsModelList" + e);
				e.printStackTrace();
			}
			return reviewOnsOffsModelList;
	 }

	@Override
	public int getMru_account_reference_id() {
		int coreReference = 0;
		try {
				jdbcTemplate.batchUpdate("update mru_account_reference_id set id=id+1");
				coreReference = jdbcTemplate.queryForObject("select * from mru_account_reference_id", Integer.class);
			
			}catch(Exception e) {
				LOGGER.info("getPullDay" + e);
				e.printStackTrace();
				}
		return coreReference;
	}

	@Override
	public int isBank_wizard_installed() {
		Integer bankWizardInstalled = null;
		int isBankWizardInstalled = 0;
		try {
				bankWizardInstalled = jdbcTemplate.queryForObject("select bank_wizard_installed from config", Integer.class); 
				if(bankWizardInstalled != null) {
					isBankWizardInstalled =bankWizardInstalled;
				}
			
		}catch (Exception e) {
			LOGGER.info("isBank_wizard_installed" + e);
			e.printStackTrace();
		}
		return isBankWizardInstalled;
	}

	@Override
	public List<Map<String, Object>> shippingOrderPercentList() {
		List<Map<String, Object>> shippingList = null;
		try {
			shippingList = jdbcTemplate.queryForList("select * from ship_price_lst_dtl");
		} catch (Exception e) {
			LOGGER.info("shippingOrderPercentList : " + e);
		}
		return shippingList;
	}

	@Override
	public List<Map<String, Object>> getShippingOrderList(Integer orderhdrId) {
		List<Map<String, Object>> shippingOrderList = null;
		try {
			shippingOrderList = jdbcTemplate.queryForList("select oi.shipping_price_list,* from order_item oi left join customer_address ca on ca.customer_id=oi.customer_id left join order_code oc on oc.order_code_id = oi.order_code_id where orderhdr_id="+orderhdrId);
		} catch (Exception e) {
			LOGGER.info("getShippingOrderList : " + e);
		}
		return shippingOrderList;
	}

	@Override
	public int getOrderItemSeq(Integer orderhdrId) {
		int orderItemSeq = 0;
		try {
			orderItemSeq = jdbcTemplate.queryForObject("select count(order_item_seq) as order_item_seq  from order_item where orderhdr_id="+orderhdrId+" and order_item_type != 8", Integer.class);
		} catch (Exception e) {
			LOGGER.info("getOrderItemSeq : " + e);
		}
		return orderItemSeq;
	}
	
	@Override
	public List<DropdownModel> getShippingMethod() {
		LOGGER.info("Inside getQueueDetails");
		List<DropdownModel> shippingPriceMethod = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("select shipping_method as shipping_price_method,description from shipping_method");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("shipping_price_method").toString());
				model.setDisplay((String) row.get("description"));
				model.setDescription(row.get("description").toString());
				shippingPriceMethod.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return shippingPriceMethod;

	}

	@Override
	public int cancelDirectDebit(Integer orderhdrId, Integer orderItemSeq) {
		int status = 0;
		StringBuilder query = new StringBuilder("update order_item_install set cancel_dd=1").append(" where orderhdr_id=").append(orderhdrId).append(" and order_item_seq=").append(orderItemSeq);
		try {
			  status = jdbcTemplate.update(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public String shippingPriceUpdate(ShippingPriceListModel shippingPriceListModel) {
	String status=null;
			StringBuilder query = new StringBuilder();
			try {
				query.append("update order_item set gross_base_amount=:gross_base_amount,gross_local_amount=:gross_local_amount,net_base_amount=:net_base_amount,net_local_amount=:net_local_amount,shipping_price_list=:shipping_price_list where" + 
					" orderhdr_id=:orderhdr_id and order_item_seq=:order_item_seq");
				Map<String,Object> parambody = new HashMap<>();
				parambody.put("gross_base_amount", shippingPriceListModel.getGrossBaseAmount());
				parambody.put("gross_local_amount", shippingPriceListModel.getGrossLocalAmount());
				parambody.put("net_base_amount", shippingPriceListModel.getNetBaseAmount());
				parambody.put("net_local_amount", shippingPriceListModel.getNetLocalAmount());
				parambody.put("shipping_price_list", shippingPriceListModel.getShippingPriceList());
				parambody.put("orderhdr_id", shippingPriceListModel.getOrderhdrId());
				parambody.put("order_item_seq", shippingPriceListModel.getOrderItemSeq());
				namedParameterJdbcTemplate.update(query.toString(), parambody);
			    status = "Order Update Successfully";
	  }catch(Exception e){
		LOGGER.info("orderUpdate = "+e);
		status = "Order Update Not Successfully";
	}
	return status;
}

	@Override
	public List<DropdownModel> getPackageDropDownList(int orderCodeId) {
			List<DropdownModel> returnList = new ArrayList<>();
			try{
				
				List<Map<String,Object>> packageDefinition = 
				jdbcTemplate.queryForList("select pkg_def,description,n_calendar_units, CASE calendar_unit"
					+	" WHEN 0 THEN 'Day(s)'"
					+	" WHEN 1 THEN 'Week(s)' "
					+	" WHEN 2 THEN 'Months(s)' "
					+	" WHEN 3 THEN 'Year(s)' "
					+   " END  as calendar_unit,order_code_id,CASE subscriber_site_allowance_type "
					+   " WHEN 0 THEN 'Disallow'"  
					+	" WHEN 1 THEN 'Members Control'"  
					+	" WHEN 2 THEN 'Allow'" 
					+	" END as allowance_type" 
					+	" from pkg_def where order_code_id="+orderCodeId );
				for(Map<String,Object> row:packageDefinition) {
					DropdownModel model = new DropdownModel();
					model.setKey(row.get("pkg_def").toString());
					model.setDescription(row.get("n_calendar_units").toString());
					model.setDisplay(row.get("description")!=null?row.get("description").toString():"");
					model.setExtra(row.get("calendar_unit").toString());
					model.setExtraData(row.get("order_code_id").toString());
					model.setExtraDataDef(row.get("allowance_type").toString());
					returnList.add(model);
				}
			}catch(Exception e){
				LOGGER.info("getPackageDefinitionList : "+e);
			}
			return returnList;
		}
	
	
	
	@Override
	public List<QuickOrderInProgressModel> getQuickOrdersInProgressFromDataSource(int customerId, int orderCodeId,int sourceCodeId,int orderItemType) 
	{
		LOGGER.info("Inside getQuickOrdersInProgressFromDataSource");
		
			String customer_query = "SELECT custom.default_renew_to_customer_id,caddr.customer_address_seq,s.currency"+
			" FROM customer custom"+
			" INNER JOIN customer_address caddr ON caddr.customer_id=custom.customer_id"+
			" INNER JOIN state s ON s.state=caddr.state"+
			" AND caddr.customer_address_seq=custom.def_renew_to_cust_addr_seq"+
			" WHERE custom.customer_id=?;";
			
			Customer customer=jdbcTemplate.queryForObject(customer_query, new Object[]{customerId}, new CustomerRowMapper());
			if(null==customer.getCurrency() || "".equals(customer.getCurrency())|| "null".equalsIgnoreCase(customer.getCurrency()))
			{
				customer.setCurrency("USD");
			}
			String quickOrderInProgressQuery = "SELECT "+customer.getDefaultCustAddrSeq()+",'"+customer.getDefaultRenewToCustomerId()+"','"+customer.getCurrency()+"',qoc.qty,a.user_code,a.order_code,b.oc,a.order_code_type,qoc.item_order_code_id"+
			" FROM quick_order_content qoc"+
			" INNER JOIN order_code a ON a.order_code_id=qoc.item_order_code_id"+
			" INNER JOIN oc b ON b.oc_id=a.oc_id"+
			" WHERE qoc.order_code_id="+orderCodeId+";";	
			
			return jdbcTemplate.query(quickOrderInProgressQuery,new ResultSetExtractor<List<QuickOrderInProgressModel>>()
			{
				@Override
				public List<QuickOrderInProgressModel> extractData(ResultSet rs) throws SQLException,DataAccessException
				{
					List<QuickOrderInProgressModel> quickOrderInProgressList=new ArrayList<QuickOrderInProgressModel>();
					int line=1;
					while(rs.next())
					{
						QuickOrderInProgressModel quickOrderInProgressModel=new QuickOrderInProgressModel();
						quickOrderInProgressModel.setLine(line++);
						quickOrderInProgressModel.setOrderClass(rs.getString("oc"));
						quickOrderInProgressModel.setOrderCode(rs.getString("order_code"));
						quickOrderInProgressModel.setUser_code(rs.getString("user_code"));
						SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
						String currentDateString = sdf.format(new Date());
						quickOrderInProgressModel.setOrder_date(currentDateString);
						quickOrderInProgressModel.setBill_date(currentDateString);
						quickOrderInProgressModel.setCustomer_address_seq(rs.getString(1));
						if(rs.getString(2).equalsIgnoreCase("null"))
						{
							quickOrderInProgressModel.setRenew_to_customer_id(null);
						}else
						{
							quickOrderInProgressModel.setRenew_to_customer_id(rs.getString(2));
						}
						int order_code_type=rs.getInt("order_code_type");
						if(order_code_type==1 || order_code_type==2)//1 for Single Copy, 2 for Product
						{
							quickOrderInProgressModel.setOrderQty(rs.getInt("qty"));
							quickOrderInProgressModel.setBundleQty(1);
							if(order_code_type==2)
							{
								String product_inventory_id_query="SELECT inventory_id FROM product WHERE order_code_id="+rs.getInt("item_order_code_id")+";";
								String product_inventory_id = jdbcTemplate.queryForObject(product_inventory_id_query, String.class);
								if(product_inventory_id==null || product_inventory_id.equalsIgnoreCase("null"))
								{
									quickOrderInProgressModel.setInventory_id(null);
								}else
								{
									quickOrderInProgressModel.setInventory_id(product_inventory_id);
								}
							}
						}
						else if(order_code_type==4 || order_code_type==5)//4 for Basic Package, 5 for Ad-hoc Package
						{
							quickOrderInProgressModel.setBundleQty(rs.getInt("qty"));
							quickOrderInProgressModel.setOrderQty(1);
						}
						else if(order_code_type==0)//0 for Subscription
						{
							quickOrderInProgressModel.setBundleQty(rs.getInt("qty"));
						}
						if(order_code_type!=2)
						{
							quickOrderInProgressModel.setInventory_id(null);
						}
						quickOrderInProgressModel.setCurrency(rs.getString(3));
						quickOrderInProgressList.add(quickOrderInProgressModel);
				  }
				  return quickOrderInProgressList;
				}
			});
	}

	/*
	 * if billing type 0 (balance due) and install auto payment 0 (bill for each
	 * amount) then we have to delete rows from
	 * order_item_install,order_item_install_dtl,edit_trail,edit_trail_delta tables
	 */
	@Override
	public int deleteBillingOptions(long orderhdrId, int orderItemSeq) {
		int status = 0;
		try {
			StringBuilder deleteEditTrialDelta = new StringBuilder("delete from edit_trail_delta where edit_trail_id in (select distinct edit_trail_id from edit_trail where orderhdr_id =")
							.append(orderhdrId).append(" and order_item_seq = ").append(orderItemSeq).append(" and table_enum = 9)");
			status = jdbcTemplate.update(deleteEditTrialDelta.toString());
			StringBuilder deleteEditTrial = new StringBuilder("delete from edit_trail where orderhdr_id =")
					.append(orderhdrId).append(" and order_item_seq = ").append(orderItemSeq).append(" and table_enum = 9");
			status = jdbcTemplate.update(deleteEditTrial.toString());
			if (status > 0) {
				StringBuilder order_item_install_dtl = new StringBuilder("delete from order_item_install_dtl where orderhdr_id=").append(orderhdrId).append(" and order_item_seq = ").append(orderItemSeq);
				status = jdbcTemplate.update(order_item_install_dtl.toString());
			}
			if (status > 0) {
				StringBuilder order_item_install = new StringBuilder("delete from order_item_install where orderhdr_id=").append(orderhdrId).append(" and order_item_seq = ").append(orderItemSeq);
				status = jdbcTemplate.update(order_item_install.toString());
			}
			if (status > 0) {
				StringBuilder order_item = new StringBuilder("update order_item set billing_type=1,installment_plan_id = null where orderhdr_id=").append(orderhdrId).append(" and order_item_seq = ").append(orderItemSeq);
				status = jdbcTemplate.update(order_item.toString());
			}
		} catch (Exception e) {
			LOGGER.info("deleteBillingOptions: " + e);
		}
		return status;
	}

	@Override
	public List<ShippingModel> getShipOrderDetail(int customerId, int orderCodeId, int sourceCodeId,
			int orderCodeType) {
		List<ShippingModel> shippingData = new ArrayList<>();
		List<ShippingModel> shippingDataList = new ArrayList<>();
		try{
			String shippingQuery= new PropertyUtilityClass().getQuery("shippingQuery");				
			shippingData = jdbcTemplate.query(shippingQuery,new Object[]{orderCodeId}, new ShippingMapper());
			List<Map<String, Object>> rows = jdbcTemplate.queryForList("select top 1 c.state,case when s.currency is null then 'USD' else  s.currency end as currency ,cu.exchange_rate from customer_address c join state s on c.state=s.state join currency cu on cu.currency=case when s.currency is null then 'USD' else  s.currency end where customer_id="+customerId+"");
			for(ShippingModel shModel:shippingData ) {
				shModel.setCurrency(rows.get(0).get("currency").toString());
				shModel.setExchangeRate(rows.get(0).get("exchange_rate").toString());

				shippingDataList.add(shModel);
			}
		   }
		catch(Exception e){
			LOGGER.info("getProductRate : "+e);
		}
		return shippingDataList;
	}
	
	@Override
	public List<PackageDefinition> getAdhocPackageList(int orderCodeId) {
		List<PackageDefinition> adhocPackageDefinitionList = null;
		try{
			
			StringBuilder query = new StringBuilder("select order_code.order_code,Case pkg_def.calendar_unit ").
						append("WHEN 0 THEN 'Day(s)' ").
						append(" WHEN 1 THEN 'Week(s)' ").
						append(" WHEN 2 THEN 'Months(s)' ").
						append(" WHEN 3 THEN 'Year(s)' ").
						append(" END  as calendar_unit,CASE pkg_def.subscriber_site_allowance_type ").
						append(" WHEN 0 THEN 'Disallow'" ).
						append(" WHEN 1 THEN 'Members Control'").
						append(" WHEN 2 THEN 'Allow'" ).
						append(" END as subscriber_site_allowance_type ," ).
						append(" order_code.*,pkg_def.description,pkg_def.* from pkg_def left join  order_code on order_code.order_code_id=pkg_def.order_code_id where order_code.order_code_id=?");
			adhocPackageDefinitionList = jdbcTemplate.query(query.toString(), new Object[]{orderCodeId},new PackageDefinitionMapper());
			System.out.println(adhocPackageDefinitionList);
		}catch(Exception e){
			LOGGER.info("getSubscription : "+e);
		}
		return adhocPackageDefinitionList;      
	}

	@Override
	public List<PackageDefinition> getPooledPackageList(int orderCodeId) {
		List<PackageDefinition> PooledPackageList = null;
		try{
			StringBuilder query =new StringBuilder("select order_code.order_code,Case pkg_def.calendar_unit").
			append(" WHEN 0 THEN 'Day(s)'").
			append(" WHEN 1 THEN 'Week(s)' ").
			append(" WHEN 2 THEN 'Months(s)' ").
			append(" WHEN 3 THEN 'Year(s)' ").
			append(" END  as calendar_unit,CASE pkg_def.subscriber_site_allowance_type ").
			append(" WHEN 0 THEN 'Disallow'"  ).
			append(" WHEN 1 THEN 'Members Control'") .
			append(" WHEN 2 THEN 'Allow'" ).
			append(" END as subscriber_site_allowance_type ,"). 	
			append( " order_code.*,pkg_def.description,pkg_def.* from pkg_def left join  order_code on order_code.order_code_id=pkg_def.order_code_id where order_code.order_code_id=?");
			PooledPackageList = jdbcTemplate.query(query.toString(), new Object[]{orderCodeId},new PackageDefinitionMapper ());
			System.out.println(PooledPackageList);
		}catch(Exception e){
			LOGGER.info("getSubscription : "+e);
		}
		return PooledPackageList;      
	
	}
	
	
	@Override
	public CustomerDistributionValuesModel retrieveCustomerInformationFromDataSource(long customer_id) 
	{
		String customerAddressQuery = "select address1,address2,city,state,zip,effective_date,mailstop,carrier,"+
				"replace_customer_address_seq,audit_county,address_status,email,address_type,change_type,phone,supp_clean,"+
				"lname,delivery_point,lot_nbr,audit_name_change,faxnbr,reverse_date,salutation,eighthundred,title,county,"+
				"address3,initial_name,company,audit_company_id,special_tax_id,fname,cass_date,audit_title_change,"+
				"customer_id,suffix,tax_id_number FROM customer_address WHERE customer_id="+customer_id+";";	
					
					return jdbcTemplate.query(customerAddressQuery,new ResultSetExtractor<CustomerDistributionValuesModel>()
					{
						@Override
						public CustomerDistributionValuesModel extractData(ResultSet rs) throws SQLException,DataAccessException
						{
							CustomerDistributionValuesModel customerDistributionValuesModelObject = new CustomerDistributionValuesModel();
							
							if(rs.next())
							{
								customerDistributionValuesModelObject.setAddress1(rs.getString("address1"));
								customerDistributionValuesModelObject.setAddress2(rs.getString("address2"));
								customerDistributionValuesModelObject.setCity(rs.getString("city"));
								customerDistributionValuesModelObject.setCountry_or_state(rs.getString("state"));
								customerDistributionValuesModelObject.setPostal(rs.getString("zip"));
								customerDistributionValuesModelObject.setEffective_date(rs.getString("effective_date"));
								customerDistributionValuesModelObject.setMailstop(rs.getString("mailstop"));
								customerDistributionValuesModelObject.setCarrier(rs.getString("carrier"));
								customerDistributionValuesModelObject.setReplace_customer_address_seq(rs.getString("replace_customer_address_seq"));
								customerDistributionValuesModelObject.setAudit_county(rs.getString("audit_county"));
								customerDistributionValuesModelObject.setAddress_status(rs.getString("address_status"));
								customerDistributionValuesModelObject.setEmail(rs.getString("email"));
								customerDistributionValuesModelObject.setAddress_type(rs.getString("address_type"));
								customerDistributionValuesModelObject.setChange_type(rs.getString("change_type"));
								customerDistributionValuesModelObject.setPhone(rs.getString("phone"));
								if(rs.getInt("supp_clean")==0)
								{
									customerDistributionValuesModelObject.setSupp_clean("False");
								}else
								{
									customerDistributionValuesModelObject.setSupp_clean("True");
								}
								customerDistributionValuesModelObject.setLname(rs.getString("lname"));
								customerDistributionValuesModelObject.setDelivery_point(rs.getString("delivery_point"));
								customerDistributionValuesModelObject.setLot_nbr(rs.getString("lot_nbr"));
								if(rs.getInt("audit_name_change")==0)
								{
									customerDistributionValuesModelObject.setAudit_name_change("False");
								}else
								{
									customerDistributionValuesModelObject.setAudit_name_change("True");
								}
								customerDistributionValuesModelObject.setFaxnbr(rs.getString("faxnbr"));
								customerDistributionValuesModelObject.setReverse_date(rs.getString("reverse_date"));
								customerDistributionValuesModelObject.setSalutation(rs.getString("salutation"));
								customerDistributionValuesModelObject.setEighthundred(rs.getString("eighthundred"));
								customerDistributionValuesModelObject.setTitle(rs.getString("title"));
								customerDistributionValuesModelObject.setCounty(rs.getString("county"));
								customerDistributionValuesModelObject.setAddress3(rs.getString("address3"));
								customerDistributionValuesModelObject.setInitial(rs.getString("initial_name"));
								customerDistributionValuesModelObject.setCompany(rs.getString("company"));
								customerDistributionValuesModelObject.setAudit_company_id(rs.getString("audit_company_id"));
								if(rs.getInt("special_tax_id")==0)
								{
									customerDistributionValuesModelObject.setSpecial_tax_id("False");
								}else
								{
									customerDistributionValuesModelObject.setSpecial_tax_id("True");
								}
								customerDistributionValuesModelObject.setFname(rs.getString("fname"));
								customerDistributionValuesModelObject.setCass_date(rs.getString("cass_date"));
								if(rs.getInt("audit_title_change")==0)
								{
									customerDistributionValuesModelObject.setAudit_title_change("False");
								}else
								{
									customerDistributionValuesModelObject.setAudit_title_change("True");
								}
								customerDistributionValuesModelObject.setCustomer_id(customer_id);
								customerDistributionValuesModelObject.setSuffix(rs.getString("suffix"));
								customerDistributionValuesModelObject.setTax_id_number(rs.getString("tax_id_number"));
							}
						  return customerDistributionValuesModelObject;
						}
					});
	}
	
	
	@Override
	public List<DistributionMethodModel> retrieveDistributionMethodsFromDataSource() {
		LOGGER.info("Inside retrieveDistributionMethodsFromDataSource");
		String distributorMethodsQuery="select distribution_method,description from distribution_method;";
		return jdbcTemplate.query(distributorMethodsQuery,new ResultSetExtractor<List<DistributionMethodModel>>()
		{
			@Override
			public List<DistributionMethodModel> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<DistributionMethodModel> distributorMethodsList=new ArrayList<DistributionMethodModel>();
				while(rs.next())
				{
					DistributionMethodModel distributionMethodModel=new DistributionMethodModel();
					distributionMethodModel.setDistribution_method(rs.getString("distribution_method"));
					distributionMethodModel.setDescription(rs.getString("description"));
					
					distributorMethodsList.add(distributionMethodModel);
			  }
			  return distributorMethodsList;
			}
		});
	}

	
	
	@Override
	public List<DistributionAttributeModel> retrieveDistributionAttributesFromDataSource() {
		LOGGER.info("Inside retrieveDistributionAttributesFromDataSource");
		String distributorAttributesQuery="select distribution_attribute,description from distribution_attribute;";
		return jdbcTemplate.query(distributorAttributesQuery,new ResultSetExtractor<List<DistributionAttributeModel>>()
		{
			@Override
			public List<DistributionAttributeModel> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<DistributionAttributeModel> distributorAttributesList=new ArrayList<DistributionAttributeModel>();
				while(rs.next())
				{
					DistributionAttributeModel distributionAttributeModel=new DistributionAttributeModel();
					distributionAttributeModel.setDistribution_attribute(rs.getString("distribution_attribute"));
					distributionAttributeModel.setDescription(rs.getString("description"));
					
					distributorAttributesList.add(distributionAttributeModel);
			  }
			  return distributorAttributesList;
			}
		});
	}
	
	
	
	@Override
	public List<DistributionValueModel> retrieveDistributionValuesFromDataSource() {
		LOGGER.info("Inside retrieveDistributionValuesFromDataSource");
		String distributorValuesQuery="SELECT dist_attribute_value,region,state,city,begin_zip,end_zip FROM view_distribution_value;";
		return jdbcTemplate.query(distributorValuesQuery,new ResultSetExtractor<List<DistributionValueModel>>()
		{
			@Override
			public List<DistributionValueModel> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<DistributionValueModel> distributorValuesList=new ArrayList<DistributionValueModel>();
				while(rs.next())
				{
					DistributionValueModel distributionValueModel=new DistributionValueModel();
					distributionValueModel.setValue(rs.getString("dist_attribute_value"));
					distributionValueModel.setRegion(rs.getString("region"));
					distributionValueModel.setCountry_or_state(rs.getString("state"));
					distributionValueModel.setCity(rs.getString("city"));
					distributionValueModel.setLow_range(rs.getString("begin_zip"));
					distributionValueModel.setHigh_range(rs.getString("end_zip"));
					
					distributorValuesList.add(distributionValueModel);
			  }
			  return distributorValuesList;
			}
		});
	}

	@Override
	public List<Map<String, Object>> getQuickOrderList(int orderCodeId) {
		LOGGER.info("Inside getQuickOrderList(int orderCodeId)");
		List<Map<String, Object>> quickOrderList = null;
		StringBuilder query = new StringBuilder("select item_order_code_id as order_code_id,order_code_type,oc_id,quick_order_content_seq,order_code,")
		.append("qc.issue_id,pkg_def_id,product_id,subscription_def_id ")
		.append("from quick_order_content qc ")
		.append("left join order_code oc on qc.item_order_code_id=oc.order_code_id ")
		.append("WHERE qc.order_code_id=")
		.append(orderCodeId).append(" order by quick_order_content_seq");
		
		try {
			 quickOrderList = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.info("getQuickOrderList : "+e);
		}
		return quickOrderList;
	}

	public List<PackageDefinition> getBasicPackageList(int orderCodeId) {
		List<PackageDefinition> packageDefinitionList = null;
		try{
			StringBuilder query= new StringBuilder("select pkg_def_id,p.order_code_id,pkg_def,p.description,n_calendar_units,case when calendar_unit=0 then 'Day(s)' when calendar_unit=1 then 'Week(s)' when calendar_unit=2 then 'Month(s)' else 'Year(s)' end as calendar_unit , ");
			query.append("isnull(p.discount_class_id,'') as discount_class_id,pkg_price,revenue_percentage_option,isnull(p.renewal_card_id,'') as renewal_card_id,pkg_price,p.oc_id, ");
			query.append(" subscriber_site_allowance_type,order_code.order_code  from pkg_def as p inner join order_code on p.order_code_id=order_code.order_code_id   where p.order_code_id =").append(orderCodeId);
			packageDefinitionList = jdbcTemplate.query(query.toString(),new PackageDefinitionMapper());
		}catch(Exception e){
			LOGGER.info("getBasicPackageList : "+e);
		}
		return packageDefinitionList;      
	}

	@Override
	public List<CustomerAddressDistributionModel> retrieveCustomerAddressDistributionFromDataSource(long customer_id) {
		LOGGER.info("Inside retrieveCustomerAddressDistributionFromDataSource");
		String customerAddressDistributionQuery="SELECT distribution_method,distribution_attribute,dist_attribute_value "+
				" FROM customer_address_dist WHERE customer_id = "+customer_id+" AND customer_address_seq=1 ORDER BY customer_id,customer_address_seq,distribution_method,distribution_attribute;";
		return jdbcTemplate.query(customerAddressDistributionQuery,new ResultSetExtractor<List<CustomerAddressDistributionModel>>()
		{
			@Override
			public List<CustomerAddressDistributionModel> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<CustomerAddressDistributionModel> customerAddressDistributionList=new ArrayList<CustomerAddressDistributionModel>();
				while(rs.next())
				{
					CustomerAddressDistributionModel customerAddressDistributionModel=new CustomerAddressDistributionModel();
					customerAddressDistributionModel.setDistributionMethod(rs.getString("distribution_method"));
					customerAddressDistributionModel.setAttribute(rs.getString("distribution_attribute"));
					customerAddressDistributionModel.setValue(rs.getString("dist_attribute_value"));
					customerAddressDistributionModel.setCustomer_address_seq(1);
					customerAddressDistributionModel.setCustomer_id(customer_id);
					
					customerAddressDistributionList.add(customerAddressDistributionModel);
			   }
			   return customerAddressDistributionList;
			}
		});
	}

	@Override
	public OrderItem customerOrderPkgEdit(int customerId, String orderCodeId, String sourceCodeId,int orderCodeType,String productId,String agencyID) {
		LOGGER.info("inside customerOrderPkgEdit");
		OrderItem orderItem=new OrderItem();
		List<Map<String, Object>> orderItemList = null;
		List<OrderItem> OrderItemList = new ArrayList<>();
		double localComm = 0.0;
		double baseComm  = 0.0;
		double localAmount=0.0;
		double baseAmount = 0.0;
		double newCommision =0.0;
		double localAmt = 0.0;
		double baseAmt =0.0;
		Integer subscriptionDefPrice = null;
		try{
			StringBuilder query=new StringBuilder();
			 query.append("select top 1 order_code.order_code,source_code.source_code,order_code.description as orderCodeDes,order_code.trial_type ,GETDATE() as ");
			 query.append("order_date,case when order_code.order_code_type=0 then 'Subscription' when order_code.order_code_type=1 then 'Single Copy'when ");
			 query.append("order_code.order_code_type=2 then 'Product' when order_code.order_code_type=5 then 'Ad-hoc Package'  when order_code.order_code_type=6 then 'Pooled Package' END as order_code_type,order_code.user_code,");
			 query.append("isNull(order_code.min_n_items,'') as min_n_items,isnull(order_code.max_n_items,'') as max_n_items ,(case when ((order_code.start_type=0 or order_code ");
			 query.append(".start_type=1) and order_code.order_code_type=0) then 'Issue Based Subscription' when (( order_code.start_type=0 or order_code.start_type=1) and ");
			 query.append("order_code.order_code_type=1) then 'Single Copy' when order_code.order_code_type=4 then 'Package Edit'  when order_code.order_code_type=2 then ");
			 query.append("'Product' when ((order_code.start_type=4 or order_code.start_type=5) and  order_code.order_code_type=0) then 'Unit Based Subscription' ");
			 query.append(" when order_code.order_code_type=8 then 'Shipping Price List' else 'Date Based Subscription' end) as pageName,subscription_def.description as");
			 query.append(" subscriptionDescription,source_code.description as sourceCodeDes,cd.address1 ,subscription_def.subscription_def_id, CONCAT(cd.fname,' ' collate Latin1_General_CI_AS, cd.lname) AS fullName,cd.state, ");
			 query.append(" isNull(order_code.subscription_category_id ,'')as subscription_category_id, term.description as termDescription,term.n_issues,issue.issue_id,term.");
			 query.append(" number_volume_sets ,issue_date,issue.enumeration,subscription_def ,isNull(sc.description,'') as subscriptionCategoryDescription ,");
			 query.append(" order_code.newsub_rate_class_id as rate_class_id,rc.rate_class,");
			 query.append("  p.product, isNull(p.product_size,'') as product_size,isNull(p.product_style,'') as product_style,isNull(p.product_color,'') as product_color,isNull(p.taxonomy,'') as taxonomy,p.price ");
			 query.append("  from product as p ,customer_address as cd,source_code, order_code  ");
			 query.append(" left join term on order_code.term_id=term.term_id  "); 
			 query.append(" left join issue on issue.oc_id =order_code.oc_id ");
			 query.append("  left join rate_class on rate_class.oc_id=order_code.oc_id  ");
			 query.append("  left join  rate_class as rc on order_code.newsub_rate_class_id=rc.rate_class_id");
			 query.append(" left join subscription_def on subscription_def.order_code_id= ");
			 query.append("  order_code.order_code_id  left join subscription_category as sc on sc.subscription_category_id=order_code.order_code_id where ");
			 query.append(" order_code.order_code_id = ");
			 query.append(orderCodeId);
			 query.append(" and cd.customer_id = ");
			 query.append(customerId);
			 query.append(" and source_code.source_code_id=");
			 query.append(sourceCodeId);
			/*
			 * query.append(" and p.product_id="); query.append(productId);
			 */
           
			orderItemList = jdbcTemplate.queryForList(query.toString());
			for(Map<String, Object> orderItemMap:orderItemList) {
				 List<Map<String,Object>> list = jdbcTemplate.queryForList("select  currency.currency,currency.exchange_rate from state left join currency on state.currency=currency.currency where state.state="+"'"+orderItemMap.get("state")+"'");
				if(orderCodeType == 0)
				{
					subscriptionDefPrice = Integer.parseInt(orderItemMap.get("subscription_def_id").toString());
					List<Order_code_for_price_list[][]> priceList= orderAddWsdl.getPrice(customerId, Integer.parseInt(orderItemMap.get("subscription_def_id").toString()),String.valueOf(sourceCodeId),orderItemMap.get("state").toString(),list.get(0).get("currency").toString(),orderCodeType,Integer.parseInt(orderCodeId));
					for(Order_code_for_price_list[][] map:priceList)
					{
						 newCommision = jdbcTemplate.queryForObject("  select new_commission from agency where customer_id="+agencyID, double.class);
						 localAmt= map[0][0].getSubscription_price()[0].getCc_item_price().doubleValue() ;
						 baseAmt= (((( map[0][0].getSubscription_price()[0].getCc_item_price().doubleValue())*Double.parseDouble((list.get(0).get("exchange_rate").toString())))));
						 if(agencyID!=null && newCommision !=0) {
					    	  localComm=(localAmt)*newCommision/100;
					    	  baseComm= (baseAmt)*newCommision /100;
					    	  localAmount=localAmt-localComm;
					    	  baseAmount=baseAmt-baseComm;
					      }else {
					    	  localAmount=localAmt;
					    	  baseAmount=baseAmt;
					      }
					}
					orderItem.setSubscriptionDef(orderItemMap.get("subscription_def")!=null?orderItemMap.get("subscription_def").toString():null);
					orderItem.setSubscriptionDefDescription(orderItemMap.get("subscriptionDescription")!=null?orderItemMap.get("subscriptionDescription").toString():null);
					orderItem.setTermDescription(orderItemMap.get("termDescription")!=null?orderItemMap.get("termDescription").toString():null);
					orderItem.setSubscriptionCategoryId(orderItemMap.get("subscription_category_id")!=null?orderItemMap.get("subscription_category_id").toString():"0");
					orderItem.setSubscriptionCategoryDescription(orderItemMap.get("subscriptionCategoryDescription")!=null?orderItemMap.get("subscriptionCategoryDescription").toString():null);
					orderItem.setStartDate(orderItemMap.get("issue_date").toString());
					//orderItem.setRenewToCustomerId(orderItemMap.get("renew_to_customer_id")!=null?(Integer.parseInt(orderItemMap.get("renew_to_customer_id").toString())):0);
					//orderItem.setRenewToCustomerAddressSeq(Integer.parseInt(orderItemMap.get("renew_to_customer_address_seq").toString()));	
					
				}
				if(orderCodeType == 4 || orderCodeType == 5)
				{
					List<Map<String, Object>> subscripDef=jdbcTemplate.queryForList("select * from view_pkg_def where order_code_id="+orderCodeId+" and pkg_def_id="+orderItemMap.get("pkg_def_id")+"");
					for(Map<String,Object> map:subscripDef) 
					{
						orderItem.setSubscriptionDef(map.get("pkg_def")!=null?(String)map.get("pkg_def"):null);
						orderItem.setSubscriptionDefDescription(map.get("description")!=null?(String)map.get("description"):null);
					}
				}
				 if(orderCodeType == 1) 
				    {
				    	orderItem.setExpireDate(null);
				    	orderItem.setEnumeration((orderItemMap.get("enumeration")!=null?(String)orderItemMap.get("enumeration"):""));
				    }
			  if(orderCodeType == 2)
				{
					orderItem.setProductId(productId !=null? productId:null);
					orderItem.setProduct((orderItemMap.get("product")!=null?(String)orderItemMap.get("product"):null));
					orderItem.setProductSize((orderItemMap.get("product_size")!=null?(String)orderItemMap.get("product_size"):null));
					orderItem.setProductStyle((orderItemMap.get("product_style")!=null?(String)orderItemMap.get("product_style"):null));
					orderItem.setProductColor((orderItemMap.get("product_color")!=null?(String)orderItemMap.get("product_color"):null));
					orderItem.setProductTaxonomy((orderItemMap.get("taxonomy")!=null?(String)orderItemMap.get("taxonomy"):null));
					orderItem.setProductPrice((orderItemMap.get("price")!=null?orderItemMap.get("price").toString():null));
				}
				if(orderCodeType==8) 
				{
					orderItem.setShippingPriceList(orderItemMap.get("shipping_price_list").toString());
				}
				if(subscriptionDefPrice !=null) {
				List<Order_code_for_price_list[][]> priceList= orderAddWsdl.getPrice(customerId, subscriptionDefPrice,String.valueOf(sourceCodeId),orderItemMap.get("state").toString(),list.get(0).get("currency").toString(),orderCodeType,Integer.parseInt(orderCodeId));
				for(Order_code_for_price_list[][] map:priceList)
				{
					 newCommision = jdbcTemplate.queryForObject("  select new_commission from agency where customer_id="+agencyID, double.class);
					 localAmt= map[0][0].getSubscription_price()[0].getCc_item_price().doubleValue() ;
					 baseAmt= (((( map[0][0].getSubscription_price()[0].getCc_item_price().doubleValue())*Double.parseDouble((list.get(0).get("exchange_rate").toString())))));
					 if(agencyID!=null && newCommision !=0) {
				    	  localComm=(localAmt)*newCommision/100;
				    	  baseComm= (baseAmt)*newCommision /100;
				    	  localAmount=localAmt-localComm;
				    	  baseAmount=baseAmt-baseComm;
				      }else {
				    	  localAmount=localAmt;
				    	  baseAmount=baseAmt;
				      }
				}
				
			}
			  orderItem.setOrderCode(orderItemMap.get("order_code").toString());
			  orderItem.setMinItem(Integer.parseInt(orderItemMap.get("min_n_items").toString()));
			  orderItem.setMaxItem(Integer.parseInt(orderItemMap.get("max_n_items"). toString()));
			  orderItem.setUserCode(orderItemMap.get("user_code").toString());
			  orderItem.setSourceCode(orderItemMap.get("source_code").toString());
			  orderItem.setSourceCodeDescription(orderItemMap.get("sourceCodeDes")!=null?orderItemMap.get("sourceCodeDes").toString():"");
			  orderItem.setOrderCodeDescription(orderItemMap.get("orderCodeDes").toString());
			  orderItem.setBillToCustomerAddress(orderItemMap.get("address1").toString());
			  orderItem.setRenewToCustomerAddress(orderItemMap.get("address1").toString());
			  orderItem.setRenewFullNameTo(orderItemMap.get("fullName").toString());
			  orderItem.setBillToFullName(orderItemMap.get("fullName").toString());
			  orderItem.setOrderQty(1); 
			  orderItem.setCurrency(list.get(0).get("currency").toString()); 
			  Date parseDate =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(orderItemMap.get("order_date").toString()); 
			  DateFormat formater = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
			  orderItem.setOrderDate(formater.format(parseDate));
			  orderItem.setBillDate(formater.format(parseDate));
			  orderItem.setInvoiceDate(formater.format(parseDate));
			  orderItem.setTrialType(Integer.parseInt(orderItemMap.get("trial_type").toString()));
			  orderItem.setOrder_status("Order Placed ");
			  orderItem.setPayment_status("No Payment "); 
			  orderItem.setPkgType(orderItemMap.get("order_code_type").toString());
			  orderItem.setnIssueLeft(orderItemMap.get("n_issues")!=null?orderItemMap.get("n_issues").toString():"");
			  orderItem.setBundleQty(orderItemMap.get("n_issues")!=null?Integer.parseInt(orderItemMap.get("n_issues").toString()):0);
			  orderItem.setPageName(orderItemMap.get("pageName").toString());
			  orderItem.setRateClass(orderItemMap.get("rate_class")!=null?orderItemMap.get("rate_class").toString():"");
			  orderItem.setLocalAmount(String.valueOf(localAmount));
			  orderItem.setLocalAmount(String.valueOf(baseAmount));
			  orderItem.setLocalCommission(String.valueOf(localComm));
			  orderItem.setBaseCommission(String.valueOf(baseComm));
			  orderItem.setGrossBaseAmount(String.valueOf(baseAmt));
			  orderItem.setGrossLocalAmount(String.valueOf(localAmt));
			  }
		}catch(Exception e){
			LOGGER.info("customerOrderPkgEdit : "+e);
			e.printStackTrace();
		}
		return orderItem;
	}

	@Override
	public List<Product> getProductDefinition(int ocId) {
		List<Product> productModelsList = null;
		try{
			String productQuery = "select p.product_id,p.oc_id,inventory_id,p.description,p.product_size,p.product_style,p.product_color,p.price,p.rate_class_id ,p.product,order_code.order_code,oc.oc,'' as currency,''as exchange_rate,0 as n_issues from product p join order_code order_code on order_code.order_code_id=p.order_code_id  left join oc on oc.oc_id=order_code.oc_id where p.oc_id = "+ocId+"";			
			productModelsList = jdbcTemplate.query(productQuery,new ProductMapper());
			
		}catch(Exception e){
			LOGGER.info("productModelsList = "+e);
		}
		return productModelsList;
	}
	
	@Override
	public List<Map<String, Object>> getPoolMemeberDetails(int orderCodeId) {
		List<Map<String,Object>> poolDetails=new ArrayList<>();
		try {

			poolDetails=jdbcTemplate.queryForList("select DISTINCT pkg_content.item_order_code_id as id,order_code.order_code,order_code.description,view_item_data_pool.subscription_def,view_item_data_pool.product,view_item_data_pool.issue_date  from  order_code inner join  pkg_content  on order_code.order_code_id=pkg_content.item_order_code_id inner join view_item_data_pool on view_item_data_pool.order_code_id=pkg_content.item_order_code_id  where pkg_content.order_code_id="+orderCodeId); 
					
		}catch(Exception e) {
			LOGGER.error("getPoolMember:"+e);
		}
		return poolDetails;
	}


	@Override
	public Map<String, Object> getOrderDropdownData(int orderCodeId,int ocId, int orderCodeType,int customerId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		//List<Map<String,Object>> subscriptionDefinitionList = null;
		List<SubscriptionDefinition> subscriptionDefinitionList = null;
		List<IssueModel> issueModelsList = null;
		List<Product> productModelsList = null;
		List<PackageDefinition> basicPackageList = null;
		List<PackageDefinition> adhocPackageList = null;
		List<PackageDefinition> pooledPackageList = null;
		List<Map<String, Object>> orderList = null;
		List<Map<String, Object>> packageDefList = null;// it is basic(4) and pooled(6) package
		 int subscription = 0;
		 int singleCopy = 0;
		 int product  = 0;
		 int basicPackage = 0;
		 int adhockPackage = 0;
		 int pooledPackage = 0;
		 String required = null;
		 Integer pkg_def_id = null;
		try {
				 if(orderCodeType == 7) {
					 orderList = getQuickOrderList(orderCodeId);
					//This loop appends package related order at first then second loop appends rest of orders.
						for(Map<String,Object>map:orderList) {
							int orderCode_Id = Integer.parseInt(map.get("order_code_id").toString());
							int orderCode_Type = Integer.parseInt(map.get("order_code_type").toString());
							pkg_def_id = map.get("pkg_def_id")!=null?Integer.parseInt(map.get("pkg_def_id").toString()):null;
							switch (orderCode_Type) {
							case 4:
								basicPackageList = getPackageDefinitionList(orderCode_Id);
								if (basicPackageList.size() > 1 && Objects.isNull(pkg_def_id)) {
									basicPackage++;
									responseObject.put("basicPackageList " + basicPackage, basicPackageList);
								}
								break;
							case 5:
								adhocPackageList = getAdhocPackageList(orderCode_Id);
								if (adhocPackageList.size() > 1 && Objects.isNull(pkg_def_id)) {
									adhockPackage++;
									responseObject.put("adhocPackageList " + adhockPackage, adhocPackageList);
								}
								break;
							case 6:
								pooledPackageList = getBasicPackageList(orderCode_Id);
								if (pooledPackageList.size() > 1 && Objects.isNull(pkg_def_id)) {
									pooledPackage++;
									responseObject.put("pooledPackageList " + pooledPackage, pooledPackageList);
								}
								break;
							}
						}
						for(Map<String,Object>map:orderList) {
							int order_Code_Id = Integer.parseInt(map.get("order_code_id").toString());
							int order_Code_Type = Integer.parseInt(map.get("order_code_type").toString());
							int oc_Id = map.get("oc_id")!=null?Integer.parseInt(map.get("oc_id").toString()):0;
							Integer issue_id = map.get("issue_id")!=null?Integer.parseInt(map.get("issue_id").toString()):null;
							pkg_def_id = map.get("pkg_def_id")!=null?Integer.parseInt(map.get("pkg_def_id").toString()):null;
							Integer product_id = map.get("product_id")!=null?Integer.parseInt(map.get("product_id").toString()):null;
							Integer subscription_def_id = map.get("subscription_def_id")!=null?Integer.parseInt(map.get("subscription_def_id").toString()):null;
							switch (order_Code_Type) {
							case 0:
								//subscriptionDefinitionList = getSubscriptionDetails(oc_Id, order_Code_Id);
								subscriptionDefinitionList = getSubscription(orderCodeId);
								if(subscriptionDefinitionList.size() > 1 && Objects.isNull(subscription_def_id)) {
									subscription++;
									responseObject.put("subscriptionDefinitionList "+subscription, subscriptionDefinitionList);
								}
							break;
							case 1:
								issueModelsList = getSubscriptionStartDate(oc_Id);
								if(issueModelsList.size() >1 && Objects.isNull(issue_id)) {
									singleCopy++;
									responseObject.put("issueModelsList "+singleCopy, issueModelsList);
								}
								break;
							case 2:
								productModelsList = getProductDefinitionList(order_Code_Id);
								if(productModelsList.size() > 1 && Objects.isNull(product_id)) {
									product++;
									responseObject.put("productModelsList "+product, productModelsList);
								}
								break;
							case 4:
									basicPackageList = getBasicPackageList(order_Code_Id);
									//if (basicPackageList.size() > 1 && basicPackage == 0) {
									if (basicPackageList.size() > 1 && (Objects.isNull(pkg_def_id) && basicPackage == 0)) {
										basicPackage++;
										responseObject.put("basicPackageList " + basicPackage, basicPackageList);
									}	
									if(pkg_def_id == null) {
										pkg_def_id = Integer.parseInt(basicPackageList.get(0).getPkgDefId());
									}
									packageDefList = getPkgDefContentList(order_Code_Id, pkg_def_id);
									if(packageDefList.size()>1) {
										//append package response into responseObject
										responseObject.putAll(appendPackageResponseObject(responseObject,packageDefList,subscription,singleCopy,product,basicPackage,adhockPackage,pooledPackage));
										for(Map.Entry<String,Object> m:responseObject.entrySet()) {  
											String key = m.getKey();
											switch (key) {
											case "subscription":
												subscription = Integer.parseInt(m.getValue().toString());
												break;
											case "singleCopy":
												singleCopy = Integer.parseInt(m.getValue().toString());
												break;
											case "product":
												product = Integer.parseInt(m.getValue().toString());
												break;
											case "basicPackage":
												basicPackage = Integer.parseInt(m.getValue().toString());
												break;
											case "adhockPackage":
												adhockPackage = Integer.parseInt(m.getValue().toString());
												break;
											case "pooledPackage":
												pooledPackage = Integer.parseInt(m.getValue().toString());
												break;
											}
										} 
									}
								break;
							case 5:
								adhocPackageList = getAdhocPackageList(order_Code_Id);
								if (adhocPackageList.size() > 1 && (Objects.isNull(pkg_def_id) && adhockPackage == 0)) {
									adhockPackage++;
									responseObject.put("adhocPackageList " + adhockPackage, adhocPackageList);
								}
								break;
						case 6:
							pooledPackageList = getBasicPackageList(order_Code_Id);
							//if (pooledPackageList.size() > 1 && pooledPackage == 0) {
							if (pooledPackageList.size() > 1 && (Objects.isNull(pkg_def_id) && pooledPackage == 0)) {
								pooledPackage++;
								responseObject.put("pooledPackageList " + pooledPackage, pooledPackageList);
							}
							if(pkg_def_id == null) {
								pkg_def_id = Integer.parseInt(pooledPackageList.get(0).getPkgDefId());
							}
							packageDefList = getPkgDefContentList(order_Code_Id, pkg_def_id);
							  if(packageDefList.size()>1) {
								 //append package response into responseObject
								  responseObject.putAll(appendPackageResponseObject(responseObject,packageDefList,subscription,singleCopy,product,basicPackage,adhockPackage,pooledPackage));
								  for(Map.Entry<String,Object> m:responseObject.entrySet()) {  
									  String key = m.getKey();
										switch (key) {
										case "subscription":
											subscription = Integer.parseInt(m.getValue().toString());
											break;
										case "singleCopy":
											singleCopy = Integer.parseInt(m.getValue().toString());
											break;
										case "product":
											product = Integer.parseInt(m.getValue().toString());
											break;
										case "basicPackage":
											basicPackage = Integer.parseInt(m.getValue().toString());
											break;
										case "adhockPackage":
											adhockPackage = Integer.parseInt(m.getValue().toString());
											break;
										case "pooledPackage":
											pooledPackage = Integer.parseInt(m.getValue().toString());
											break;
										}
									}
							  }
							break;	
						}
					  }
						responseObject.remove("subscription");
						responseObject.remove("singleCopy");
						responseObject.remove("product");
						responseObject.remove("basicPackage");
						responseObject.remove("adhockPackage");
						responseObject.remove("pooledPackage");
			} else {
				switch (orderCodeType) {
				case 0:
					//subscriptionDefinitionList = getSubscriptionDetailsByOrderCodeId(orderCodeId);
					subscriptionDefinitionList = getSubscription(orderCodeId);
					if(subscriptionDefinitionList.size() > 1) {
						subscription++;
						responseObject.put("subscriptionDefinitionList "+subscription, subscriptionDefinitionList);
					}
					break;
				case 1:
					issueModelsList = getSubscriptionStartDate(ocId);
					if(issueModelsList.size() > 1) {
						singleCopy++;
						responseObject.put("issueModelsList "+singleCopy, issueModelsList);
					}
					break;
				case 2:
					productModelsList = getProductDefinitionList(orderCodeId);
					if(productModelsList.size() > 1) {
						product++;
						responseObject.put("productModelsList "+product, productModelsList);
					}
					break;
				case 4:
					basicPackageList = getBasicPackageList(orderCodeId);
					if (basicPackageList.size() > 1 && basicPackage == 0) {
						basicPackage++;
						responseObject.put("basicPackageList " + basicPackage, basicPackageList);
					}
				/* Dont delete this code. this will use later on */
					
//					packageDefList = getPkgDefContentList(orderCodeId,required);
//					if(packageDefList.size() != 0 && packageDefList.size()>1) {
//						//append package response into responseObject
//						responseObject.putAll(appendPackageResponseObject(responseObject,packageDefList,subscription,singleCopy,product,basicPackage,adhockPackage,pooledPackage));
//						
//						for (Map.Entry<String, Object> m : responseObject.entrySet()) {
//							String key = m.getKey();
//							switch (key) {
//							case "subscription":
//								subscription = Integer.parseInt(m.getValue().toString());
//								break;
//							case "singleCopy":
//								singleCopy = Integer.parseInt(m.getValue().toString());
//								break;
//							case "product":
//								product = Integer.parseInt(m.getValue().toString());
//								break;
//							case "basicPackage":
//								basicPackage = Integer.parseInt(m.getValue().toString());
//								break;
//							case "adhockPackage":
//								adhockPackage = Integer.parseInt(m.getValue().toString());
//								break;
//							case "pooledPackage":
//								pooledPackage = Integer.parseInt(m.getValue().toString());
//								break;
//							}
//						} 
//					}
					break;
				case 5:
					adhocPackageList = getAdhocPackageList(orderCodeId);
					if (adhocPackageList.size() > 1 && adhockPackage == 0) {
						adhockPackage++;
						responseObject.put("adhocPackageList " + adhockPackage, adhocPackageList);
					}
					break;
				case 6:
					pooledPackageList = getBasicPackageList(orderCodeId);
					if (pooledPackageList.size() > 1 && pooledPackage == 0) {
						pooledPackage++;
						responseObject.put("pooledPackageList " + pooledPackage, pooledPackageList);
					}
					required = "required";
					packageDefList = getPkgDefContentList(orderCodeId, required);
					  if(packageDefList.size() != 0 && packageDefList.size()>1) {
						 //append package response into responseObject
						  responseObject.putAll(appendPackageResponseObject(responseObject,packageDefList,subscription,singleCopy,product,basicPackage,adhockPackage,pooledPackage));
						for (Map.Entry<String, Object> m : responseObject.entrySet()) {
							String key = m.getKey();
							switch (key) {
							case "subscription":
								subscription = Integer.parseInt(m.getValue().toString());
								break;
							case "singleCopy":
								singleCopy = Integer.parseInt(m.getValue().toString());
								break;
							case "product":
								product = Integer.parseInt(m.getValue().toString());
								break;
							case "basicPackage":
								basicPackage = Integer.parseInt(m.getValue().toString());
								break;
							case "adhockPackage":
								adhockPackage = Integer.parseInt(m.getValue().toString());
								break;
							case "pooledPackage":
								pooledPackage = Integer.parseInt(m.getValue().toString());
								break;
							}
					  }
				}
					break;
					
				}
			responseObject.remove("subscription");
			responseObject.remove("singleCopy");
			responseObject.remove("product");
			responseObject.remove("basicPackage");
			responseObject.remove("adhockPackage");
			responseObject.remove("pooledPackage");
	      }	
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;
	}

	private Map<String, Object>appendPackageResponseObject(Map<String, Object> responseObject,List<Map<String, Object>> packageDefList,int subscription,int singleCopy,int product,int basicPackage,int adhockPackage,int pooledPackage) {
		//List<Map<String,Object>> subscriptionDefinitionList = null;
		List<SubscriptionDefinition> subscriptionDefinitionList = null;
		List<IssueModel> issueModelsList = null;
		List<Product> productModelsList = null;
		List<PackageDefinition> basicPackageList = null;
		List<PackageDefinition> adhocPackageList = null;
		List<PackageDefinition> pooledPackageList = null;
		//List<Map<String, Object>> packageDefList = null;// it is basic(4) and pooled(6) package
		 for(Map<String,Object>row:packageDefList) {
			 int orderCodeId = Integer.parseInt(row.get("order_code_id").toString());
			 int orderCodeType = Integer.parseInt(row.get("order_code_type").toString());
			 int ocId = row.get("oc_id")!=null?Integer.parseInt(row.get("oc_id").toString()):0;
			 Integer issue_id = row.get("issue_id")!=null?Integer.parseInt(row.get("issue_id").toString()):null;
			 Integer pkg_def_id = row.get("pkg_def_id")!=null?Integer.parseInt(row.get("pkg_def_id").toString()):null;
			 Integer product_id = row.get("product_id")!=null?Integer.parseInt(row.get("product_id").toString()):null;
			 Integer subscription_def_id = row.get("subscription_def_id")!=null?Integer.parseInt(row.get("subscription_def_id").toString()):null;
			 switch (orderCodeType) {
			case 0:
				//subscriptionDefinitionList = getSubscriptionDetails(ocId, orderCodeId);
				subscriptionDefinitionList = getSubscription(orderCodeId);
				if(subscriptionDefinitionList.size() > 1 && Objects.isNull(subscription_def_id)) {
					subscription++;
					responseObject.put("subscriptionDefinitionList "+subscription, subscriptionDefinitionList);
					responseObject.put("subscription",subscription);
				}
				break;
			case 1:
				issueModelsList = getSubscriptionStartDate(ocId);
				if(issueModelsList.size() > 1 && Objects.isNull(issue_id)) {
					singleCopy++;
					responseObject.put("issueModelsList "+singleCopy, issueModelsList);
					responseObject.put("singleCopy",singleCopy);
				}
				break;
			case 2:
				productModelsList = getProductDefinitionList(orderCodeId);
				//if(productModelsList.size() > 1 && product == 0) {
				if(productModelsList.size() > 1 && Objects.isNull(product_id)) {
					product++;
					responseObject.put("productModelsList "+product, productModelsList);
					responseObject.put("product",product);
				}
				break;
			case 4:
				basicPackageList = getBasicPackageList(orderCodeId);
				//if(basicPackageList.size()>1 && basicPackage == 0) {
				if (basicPackageList.size() > 1 && (Objects.isNull(pkg_def_id) && basicPackage == 0)) {
					basicPackage++;
					responseObject.put("basicPackageList "+basicPackage, basicPackageList);
					responseObject.put("basicPackage",basicPackage);
				}
				break;
			case 5:
				adhocPackageList = getAdhocPackageList(orderCodeId);
				//if (adhocPackageList.size() > 1 && adhockPackage == 0) {
				if (adhocPackageList.size() > 1 && (Objects.isNull(pkg_def_id) && adhockPackage == 0)) {
					adhockPackage++;
					responseObject.put("adhocPackageList " + adhockPackage, adhocPackageList);
					responseObject.put("adhockPackage",adhockPackage);
				}
				break;
			case 6:
				pooledPackageList = getBasicPackageList(orderCodeId);
				//if (pooledPackageList.size() > 1 && pooledPackage == 0) {
				if (pooledPackageList.size() > 1 && (Objects.isNull(pkg_def_id) && pooledPackage == 0)) {
					pooledPackage++;
					responseObject.put("pooledPackageList " + pooledPackage, pooledPackageList);
					responseObject.put("pooledPackage",pooledPackage);
				}
				break;
			}
		}
		 return responseObject;
	}

	@Override
	public List<Map<String, Object>> getSubscriptionDetails(int ocId, int orderCodeId) {
		List<Map<String,Object>> subscriptonDetails = null;
		try {
			  subscriptonDetails = jdbcTemplate.queryForList("select * from subscription_def where oc_id="+ocId+" and order_code_id="+orderCodeId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return subscriptonDetails;
	}
	@Override
	public List<Map<String, Object>> getSubscriptionDetailsByOrderCodeId(int orderCodeId) {
		List<Map<String,Object>> subscriptonDetails = null;
		try {
				 subscriptonDetails = jdbcTemplate.queryForList("select * from subscription_def where order_code_id="+orderCodeId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return subscriptonDetails;
	}

	@Override
	public List<Map<String, Object>> getQuickOrderData(String orderCodeId, String sourceCodeId, int orderCodeType,int customerId, String subscriptionIdList, String agencyID, Optional<Integer> orderhdrId,Optional<String> shippingPrice,Optional<Integer> docRefId) {
		Map<String, Object> responseObject = null;
		List<Map<String, Object>> orderList = new ArrayList<>();
		//List<Map<String, Object>> subscriptionDefinitionList = null;
		List<SubscriptionDefinition> subscriptionDefinitionList = null;
		List<IssueModel> issueModelsList = null;
		List<Product> productOrder = null;
		List<Product> productModelsList = null;
		List<PackageDefinition> basicPackageList = null;
		List<PackageDefinition> adhocPackageList = null;
		List<PackageDefinition> pooledPackageList = null;
		List<BasicPackageItemModel> basicPackageItemModelList = null;
		int orderCodeType1 = 0;
		int orderCodeId1 = 0;
		int ocId = 0;
		String[] subscriptionIdList1 = null;
		List<String> subscriptionIdListFromFronEnd = new ArrayList<>();
		int counter = 0;
		int pkgDefId = 0;
		//List<Map<String, Object>> packageDefList = null;// it is for basic(4) and pooled(6) package
		List<String> pkgIdFromFronEnd = null;
		int pkgCounter = 0;
		try {
			/**
			 *it checks that subscriptionIdList is empty or not. 
			 *If subscriptionIdList is not empty then we have to take out subscriptionId from the list based on index.
			 */
			Predicate<String> isSubscriptionIdListNotEmpty = _subscriptionIdList -> _subscriptionIdList.length() > 0;
			if(isSubscriptionIdListNotEmpty.test(subscriptionIdList)) {
				subscriptionIdList1 = subscriptionIdList.split(",");
				subscriptionIdListFromFronEnd = Arrays.asList(subscriptionIdList1);
			}
			pkgIdFromFronEnd = new ArrayList<>(subscriptionIdListFromFronEnd.size());
			List<Map<String, Object>> quickOrderList = getQuickOrderList(Integer.parseInt(orderCodeId));
			// pkgIdFromFronEnd is for basic, adhoc and pooled package
			for (Map<String, Object> map : quickOrderList){
				int type = Integer.parseInt(map.get("order_code_type").toString());
				int orderCode_Id = Integer.parseInt(map.get("order_code_id").toString());
				basicPackageList = getBasicPackageList(Integer.valueOf(orderCode_Id));
				if((type == 4 || type == 5 || type == 6) && basicPackageList.size() > 1) {
					pkgIdFromFronEnd.add(subscriptionIdListFromFronEnd.get(counter++));
				}
			}
			for (Map<String, Object> map : quickOrderList) {
				responseObject = new LinkedHashMap<String, Object>();
				orderCodeId1 = Integer.parseInt(map.get("order_code_id").toString());
				orderCodeType1 = Integer.parseInt(map.get("order_code_type").toString());
				ocId = map.get("oc_id")!=null?Integer.parseInt(map.get("oc_id").toString()):0;
				Integer issue_id = map.get("issue_id")!=null?Integer.parseInt(map.get("issue_id").toString()):null;
				Integer pkg_def_id = map.get("pkg_def_id")!=null?Integer.parseInt(map.get("pkg_def_id").toString()):null;
				Integer product_id = map.get("product_id")!=null?Integer.parseInt(map.get("product_id").toString()):null;
				Integer subscriptionDefId = map.get("subscription_def_id")!=null?Integer.parseInt(map.get("subscription_def_id").toString()):null;
				
					switch (orderCodeType1) {
		            case 0:
		            	//subscriptionDefinitionList = getSubscriptionDetailsByOrderCodeId(orderCodeId1);
		            	subscriptionDefinitionList = getSubscription(Integer.valueOf(orderCodeId));
						int subscription_def_id = 0;
						//Predicate<Collection<Map<String, Object>>>isList1 = list -> list.size() != 0;
						Predicate<Collection<SubscriptionDefinition>>isList1 = list -> list.size() != 0;
				    	//Predicate<Collection<Map<String, Object>>>isList2 = list -> list.size() == 1;
				    	Predicate<Collection<SubscriptionDefinition>>isList2 = list -> list.size() == 1;
						//if isList1 and isList2 is true then if block will execute otherwise else block
				    	if(Objects.nonNull(subscriptionDefId)){
				    		subscription_def_id = subscriptionDefId;//from quick_order_content_seq table where subscriptionDefId is present.
						}else if(isList1.and(isList2).test(subscriptionDefinitionList) && Objects.isNull(subscriptionDefId)) {
							//subscription_def_id = Integer.parseInt(subscriptionDefinitionList.get(0).get("subscription_def_id").toString());
							subscription_def_id = subscriptionDefinitionList.get(0).getSubscriptionDefId();
						}else {
							subscription_def_id = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
						}
						List<SubscriptionDefinition> subscriptionDefinitionsList = getSubscriptionPackageDefList(customerId, orderCodeId1, getSourcecode(ocId), subscription_def_id,orderCodeType1, agencyID);
						responseObject.put("subscriptionOrder", subscriptionDefinitionsList);
						String audited = jdbcTemplate.queryForObject("select audited from pub where oc_id=(select oc_id from order_code where order_code_id="+ orderCodeId1 + ")",String.class);
						responseObject.put("audited", audited);
						responseObject.put("taxRateAmount", getTaxRate(customerId, orderCodeId1));
						orderList.add(responseObject);
		            break;
		            case 1:
		            	issueModelsList = getSubscriptionStartDate(ocId);
						int issueId = 0;
						Predicate<Collection<IssueModel>>isIssue1 = list -> list.size() != 0;
				    	Predicate<Collection<IssueModel>>isIssue2 = list -> list.size() == 1;
				    	if(Objects.nonNull(issue_id)){
						      issueId = issue_id;//from quick_order_content_seq table where issue_id is present and don't take id from subscriptionIdListFromFronEnd.
						}else if (isIssue1.and(isIssue2).test(issueModelsList) && Objects.isNull(issue_id)) {
							issueId = (int) issueModelsList.get(0).getIssueId();
						}else {
						      issueId = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
						}
						  String sourceCodeID = String.valueOf(getSourcecode(ocId));
						  List<SingleCopyOrder> SingleCopyOrder = getSingleCopyOrder(customerId, orderCodeId1, sourceCodeID,issueId, orderCodeType1);
						  responseObject.put("singleCopyOrder", SingleCopyOrder);
						  responseObject.put("taxRateAmount", getTaxRate(customerId, orderCodeId1));
						  orderList.add(responseObject);
		            break;
		            case 2:
		            	int productId = 0;
		            	productModelsList = getProductDefinitionList(orderCodeId1);
		            	Predicate<Collection<Product>>isProdList1 = list -> list.size() != 0;
		            	Predicate<Collection<Product>>isProdList2 = list -> list.size() == 1;
		            	if(Objects.nonNull(product_id)){
							productId = product_id;//from quick_order_content_seq table where issue_id is present and don't take id from subscriptionIdListFromFronEnd.
						}else if (isProdList1.and(isProdList2).test(productModelsList) && Objects.isNull(product_id)) {
							productId = productModelsList.get(0).getProductId();
						}else {
							productId = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
						}
							productOrder = getProductRate(customerId, orderCodeId1,getSourcecode(ocId), productId, orderCodeType1);
							responseObject.put("productOrder", productOrder);
							responseObject.put("taxRateAmount", getTaxRate(customerId, orderCodeId1));
							orderList.add(responseObject);
		            break;
		            case 4:
		            	basicPackageList = getBasicPackageList(Integer.valueOf(orderCodeId1));
		            	if(Objects.nonNull(pkg_def_id)){
						//from quick_order_content_seq table where pkg_def_id is present and don't take id from pkgIdFromFronEnd.
		            		pkgDefId = pkg_def_id;
						}else if(isPackageListSatisfied(basicPackageList) && Objects.isNull(pkg_def_id)) {
							pkgDefId = Integer.parseInt(basicPackageList.get(0).getPkgDefId());
						}else{
			            	pkgDefId = Integer.valueOf(pkgIdFromFronEnd.get(pkgCounter++).toString());
						}
			            //packageDefList = getPkgDefContentList(orderCodeId1, pkgDefId);
						basicPackageItemModelList = getBasicPackageDefList(customerId, orderCodeId1,getSourcecode(ocId), pkgDefId, orderCodeType1,subscriptionIdList,docRefId);
						responseObject.put("basicPackageOrder", basicPackageItemModelList);
						responseObject.put("taxRateAmount", getTaxRate(customerId, orderCodeId1));
						orderList.add(responseObject);
		            break;
		            case 5:
		            	adhocPackageList = getAdhocPackageList(orderCodeId1);
		            	if(Objects.nonNull(pkg_def_id)){
		            	//from quick_order_content_seq table where pkg_def_id is present and don't take id from pkgIdFromFronEnd.
		            		pkgDefId = pkg_def_id;
						}else if(isPackageListSatisfied(adhocPackageList) && Objects.isNull(pkg_def_id)) {
							pkgDefId = Integer.parseInt(adhocPackageList.get(0).getPkgDefId());
						}else {
							pkgDefId = Integer.parseInt(pkgIdFromFronEnd.get(pkgCounter++));
						}
						String grossLocalAmt=null,grossBaseAmt = null;
						List<BasicPackageItemModel>adhocPackageList2 = getAdhocPackageData(customerId, orderCodeId1, getSourcecode(ocId), pkgDefId, orderCodeType1, subscriptionIdList, grossLocalAmt, grossBaseAmt);
						responseObject.put("adhocPackageOrder", adhocPackageList2);
						responseObject.put("taxRateAmount", getPackageTax(customerId, orderCodeId1));
						//responseObject.put("taxRateAmount", getTaxRate(customerId, orderCodeId1));
						orderList.add(responseObject);
		            break;
		            case 6:
		            	pooledPackageList = getBasicPackageList(Integer.valueOf(orderCodeId));
		            	if(Objects.nonNull(pkg_def_id)){
						//from quick_order_content_seq table where pkg_def_id is present and don't take id from pkgIdFromFronEnd.
		            		pkgDefId = pkg_def_id;
						}else if(isPackageListSatisfied(pooledPackageList) && Objects.isNull(pkg_def_id)) {
							pkgDefId = Integer.parseInt(basicPackageList.get(0).getPkgDefId());
						}else{
			            	pkgDefId = Integer.valueOf(pkgIdFromFronEnd.get(pkgCounter++).toString());
						}
					    //packageDefList = getPkgDefContentList(orderCodeId1, pkgDefId);
					    basicPackageItemModelList = getBasicPackageDefList(customerId, orderCodeId1,getSourcecode(ocId), pkgDefId, orderCodeType1,subscriptionIdList,docRefId);
					    responseObject.put("pooledPackageOrder", basicPackageItemModelList);
					    responseObject.put("taxRateAmount", getTaxRate(customerId, orderCodeId1));
						orderList.add(responseObject);
		            break;
		        }
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderList;
	}
	/**
	 * This is to be check the packageList size is 'not equal to 0 and greater than 1' . If it true then return true otherwise return false
	 * @author Chaman.Bharti
	 *
	 */
	boolean isPackageListSatisfied(List<PackageDefinition> packageList){
    	Predicate<Collection<PackageDefinition>>isPkg1 = list -> list.size() != 0;
    	Predicate<Collection<PackageDefinition>>isPkg2 = list -> list.size() == 1;
		if (isPkg1.and(isPkg2).test(packageList)) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * This is to be check the packageDefList size is 'not equal to 0 and greater than 1'. If it true then return true otherwise return false
	 * @author Chaman.Bharti
	 *
	 */
	boolean isPkgDefListSizeEqualToOne(List<Map<String, Object>> packageDefList){
    	Predicate<Collection<Map<String, Object>>>list1 = list -> list.size() != 0;
    	Predicate<Collection<Map<String, Object>>>list2 = list -> list.size() == 1;
		if (list1.and(list2).test(packageDefList)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Map<String, Object>> getPkgDefContentList(int orderCodeId, String required,int customerId,Integer pkgDefId) {
		List<Map<String, Object>> pkgDefContentList = null;
		try{
		//	null as subscription_def_id,null as pkg_def_id ,null as product_id, ");"
			StringBuilder query = new StringBuilder();
			query.append("select distinct order_code.order_code_id ,pkg_content.pkg_content_seq,order_code_type,order_code.oc_id as oc_id,");
			query.append("case when start_type in (0,1) then (case when pdc.issue_id is null then (select top 1 issue_id from issue where issue.oc_id=order_code.oc_id and issue_close_date is null) else pdc.issue_id end)");
			query.append("when start_type in (3,4,5) then (case when pdc.subscription_def_id is null then null else pdc.subscription_def_id end)");
			query.append("when start_type =2 then (case when pdc.subscription_def_id is null then (select top 1 issue_id from issue where issue.oc_id=order_code.oc_id and issue_date>getdate() and issue_close_date is null) else pdc.subscription_def_id end)end as issue_id,");
			query.append("case when start_type in (0,1) then (case when pdc.issue_id is null then (select top 1 issue_date from issue where issue.oc_id=order_code.oc_id and issue_close_date is null) else (select issue_date from issue where issue_id= pdc.issue_id) end)");
			query.append("when start_type in (3,4,5) then GETDATE()");
			query.append("when start_type =2 then GETDATE() end as start_date,null as subscription_def_id,null as pkg_def_id ,null as product_id, ");
			query.append("order_code,order_code.description,8 as orderTypeId,0 as item_Amt,null as subscription_def_id,null as pkg_def_id ,null as product_id,");
			query.append("(select top 1 (address1) from customer_address where customer_id=").append(customerId);
			query.append (" )as address1 from pkg_content ");
			query.append("inner join pkg_def_content pdc on pkg_content.pkg_content_seq=pdc.pkg_content_seq ");
			query.append("left join order_code on pkg_content.item_order_code_id=order_code.order_code_id,");
			query.append("customer_address where pkg_content.order_code_id = ").append(orderCodeId);
			if(pkgDefId != null) {
			query.append("and pkg_def_id=").append(pkgDefId);
			}
			if(required != null)
			query.append(" and required=1 ");
			query.append(" order by pkg_content.pkg_content_seq");
			pkgDefContentList = jdbcTemplate.queryForList(query.toString());			
		}catch(Exception e){
			LOGGER.info("getPkgDefContentList(int orderCodeId, Integer required): "+e);
		}
		return pkgDefContentList;      
	}

	@Override
	public List<DropdownModel> getCurrencyDropdown() {
		List<DropdownModel> responseObject=new ArrayList<>();
		try {
			String query ="select currency,description,currency_symbol from currency";
			List<Map<String,Object>> map=jdbcTemplate.queryForList(query);
			for(Map<String,Object> row:map) {
				DropdownModel model	=new DropdownModel();
				model.setKey(row.get("currency").toString());
				model.setDescription(row.get("description")!=null?row.get("description").toString():"");
				model.setDisplay(row.get("currency_symbol")!=null?row.get("currency_symbol").toString():"");
				responseObject.add(model);
				
			}
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return responseObject;
	}
	
	public int getSourcecode(int ocID) {
		int sourceCodeID =0;
		String ocID1=String.valueOf(ocID);
		List<SourceCode> sc =orderSourceOfferDaoImpl.getSourceCode(ocID1);
		sourceCodeID = sc.get(0).getSourceCodeId();
		return sourceCodeID;
		
	}
	
	@Override
	public List<Map<String, Object>> getPkgMember(String orderCodeId, String sourceCodeId, int orderCodeType,
     int customerId, String subscriptionIdList, String agencyID, Optional<Integer> orderhdrId,Optional<String> shippingPrice,Integer pkgDefId,Optional<Integer> docRefId) {
		Map<String, Object> responseObject1 = new LinkedHashMap<String, Object>();
		Map<String, Object> responseObject =null;
		List<Map<String, Object>> orderList = new ArrayList<>();
		List<Map<String, Object>> subscriptionDefinitionList = null;
		List<IssueModel> issueModelsList = null;
		List<Product> productOrder = null;
		List<Product> productModelsList = null;
		List<PackageDefinition> basicPackageList = null;
		List<PackageDefinition> adhocPackageList = null;
		List<PackageDefinition> pooledPackageList = null;
		List<BasicPackageItemModel> basicPackageItemModelList = null;
		long taxRateAmount = 0L;
		int orderCodeType1 = 0;
		int orderCodeId1 = 0;
		int ocId = 0;
		String[] subscriptionIdList1 = null;
		List<String> subscriptionIdListFromFronEnd = new ArrayList<String>();
		int counter = 0;
		int pkgDefId1 = 0;
		double localAount =0;
		double baseAmount = 0;
		List<Map<String, Object>> pkgMemberList=null;
		Integer count=0;
		
		try {
			int pkgIdCount = jdbcTemplate.queryForObject("select count(pkg_def_id) from pkg_def where order_code_id="+orderCodeId,Integer.class);
			if(pkgIdCount==1) {
				Integer pkgId = jdbcTemplate.queryForObject("select count(pkg_def_id),pkg_def_id from pkg_def where order_code_id="+orderCodeId,Integer.class);	
				pkgDefId = pkgId;
			}
			// it checks that subscriptionIdList is empty or not
			Predicate<String> isSubscriptionIdListNotEmpty = _subscriptionIdList -> _subscriptionIdList.length() > 0;
			if (isSubscriptionIdListNotEmpty.test(subscriptionIdList) && !isSubscriptionIdListNotEmpty.equals(null)) {
				subscriptionIdList1 = subscriptionIdList.split(",");
				subscriptionIdListFromFronEnd = Arrays.asList(subscriptionIdList1);
			}
			String required = "1";
			pkgMemberList = getPkgDefContentList(Integer.parseInt(orderCodeId),required,customerId,pkgDefId);
			if(pkgMemberList.size()!=0) {
			for (Map<String, Object> map : pkgMemberList) {
				count++;
				double itemAmt = 0;
				double baseAmt = 0;
				responseObject = new LinkedHashMap<String, Object>();
				orderCodeType1 = Integer.parseInt(map.get("order_code_type").toString());
				orderCodeId1 = Integer.parseInt(map.get("order_code_id").toString());
				ocId = Integer.parseInt(map.get("oc_id").toString());
				taxRateAmount  = getTaxRate(customerId, orderCodeId1);
				switch (orderCodeType1) {
				case 0:
					subscriptionDefinitionList = getSubscriptionDetailsByOrderCodeId(orderCodeId1);
					int subscription_def_id = 0;
					if (subscriptionDefinitionList.size() != 0 && subscriptionDefinitionList.size() == 1) {
						subscription_def_id = Integer
								.parseInt(subscriptionDefinitionList.get(0).get("subscription_def_id").toString());
					} else {
						subscription_def_id = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
					}
					map.put("orderTypeId", subscription_def_id);
					List<SubscriptionDefinition> subscriptionDefinitionsList = getSubscriptionPackageDefList(customerId,
							orderCodeId1, Integer.parseInt(sourceCodeId), subscription_def_id, orderCodeType1,
							agencyID);
					itemAmt = subscriptionDefinitionsList.get(0).getLocalAmount();
					baseAmt = subscriptionDefinitionsList.get(0).getBaseAmount();
					localAount = localAount + itemAmt;
					baseAmount = baseAmount + baseAmt;
					map.put("item_Amt",itemAmt);
					map.put("subscription_def_id",subscription_def_id);
					/*responseObject.put("subscriptionOrder", subscriptionDefinitionsList);*/
					String audited = jdbcTemplate.queryForObject(
							"select audited from pub where oc_id=(select oc_id from order_code where order_code_id="
									+ orderCodeId1 + ")",
							String.class);
					responseObject.put("audited", audited);
					//responseObject.put(key, pkgMemberList);
					//orderList.add(responseObject);
					break;
				case 1:
					issueModelsList = getSubscriptionStartDate(ocId);
					int issueId = 0;
					if (issueModelsList.size() != 0 && issueModelsList.size() == 1) {
						issueId = (int) issueModelsList.get(0).getIssueId();
					} else {
						issueId = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
						map.put("issue_id", issueId);
					}
					map.put("orderTypeId", issueId);
					String sourceCodeID = String.valueOf(getSourcecode(ocId));
					List<SingleCopyOrder> SingleCopyOrder = getSingleCopyOrder(customerId, orderCodeId1, sourceCodeID,
							issueId, orderCodeType1);
					itemAmt = SingleCopyOrder.get(0).getLocalAmount();
					baseAmt = SingleCopyOrder.get(0).getBaseAmount();
					localAount = localAount + itemAmt;
					baseAmount = baseAmount + baseAmt;
					map.put("item_Amt",itemAmt);
					/*responseObject.put("singleCopyOrder", SingleCopyOrder);*/
					responseObject.put("taxRateAmount", taxRateAmount);
					//orderList.add(responseObject);
					System.out.println("responseObject:" + responseObject);
					System.out.println("orderList:" + orderList);
					break;
				case 2:
					int productId = 0;
					productModelsList = getProductDefinitionList(orderCodeId1);
					if (productModelsList.size() != 0 && productModelsList.size() == 1) {
						productId = productModelsList.get(0).getProductId();
					} else {
						productId = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
					}
					map.put("orderTypeId", productId);
					productOrder = getProductRate(customerId, orderCodeId1, Integer.parseInt(sourceCodeId), productId,
							orderCodeType1);
					itemAmt = productOrder.get(0).getLocalAmount();
					baseAmt = productOrder.get(0).getBaseAmount();
					localAount = localAount + itemAmt;
					baseAmount = baseAmount + baseAmt;
					map.put("item_Amt",itemAmt);
					map.put("product_id",productId);
					/*responseObject.put("productOrder", productOrder);*/
					responseObject.put("taxRateAmount", taxRateAmount);
					//orderList.add(responseObject);
					System.out.println("responseObject:" + responseObject);
					System.out.println("orderList:" + orderList);
					break;
				case 4:
					basicPackageList = getBasicPackageList(Integer.valueOf(orderCodeId1));
					if (basicPackageList.size() != 0 && basicPackageList.size() == 1) {
						pkgDefId1 = Integer.parseInt(basicPackageList.get(0).getPkgDefId());
					} else {
						pkgDefId1 = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
					}
					basicPackageItemModelList = getBasicPackageDefList(customerId, orderCodeId1,
							Integer.parseInt(sourceCodeId), pkgDefId, orderCodeType1, subscriptionIdList, docRefId);
					long taxAmount = getPackageTax(customerId, orderCodeId1);
					responseObject.put("basicPackageOrder", basicPackageItemModelList);
					responseObject.put("taxRateAmount", taxAmount);
					//orderList.add(responseObject);
					System.out.println("responseObject:" + responseObject);
					System.out.println("orderList:" + orderList);
					break;
				case 5:
					adhocPackageList = getAdhocPackageList(orderCodeId1);
					if (adhocPackageList.size() != 0 && adhocPackageList.size() == 1) {
						pkgDefId1 = Integer.parseInt(adhocPackageList.get(0).getPkgDefId());
					} else {
						pkgDefId1 = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
					}
					basicPackageItemModelList = getBasicPackageDefList(customerId, orderCodeId1,
							Integer.parseInt(sourceCodeId), pkgDefId, orderCodeType1, subscriptionIdList,docRefId);
					taxAmount = getPackageTax(customerId, orderCodeId1);
					//responseObject.put("adhocPackageOrder", basicPackageItemModelList);
					responseObject.put("taxRateAmount", taxAmount);
					orderList.add(responseObject);
					System.out.println("responseObject:" + responseObject);
					System.out.println("orderList:" + orderList);
					break;
				case 6:
					pooledPackageList = getBasicPackageList(Integer.valueOf(orderCodeId));
					if (pooledPackageList.size() != 0 && pooledPackageList.size() == 1) {
						pkgDefId1 = Integer.parseInt(pooledPackageList.get(0).getPkgDefId());
					} else {
						pkgDefId1 = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
					}
					basicPackageItemModelList = getBasicPackageDefList(customerId, orderCodeId1,
							Integer.parseInt(sourceCodeId), pkgDefId, orderCodeType1, subscriptionIdList,docRefId);
					taxAmount = getPackageTax(customerId, orderCodeId1);
					responseObject.put("pooledPackageOrder", basicPackageItemModelList);
					responseObject.put("taxRateAmount", taxAmount);
				//	orderList.add(responseObject);
					System.out.println("responseObject:" + responseObject);
					System.out.println("orderList:" + orderList);
					break;
					
				}
			}
		}else {
			
		}
			if(count !=0) {
			responseObject.put("member", count);
			responseObject.put("pkgMemberList", pkgMemberList);
			responseObject.put("localAount", localAount);
			responseObject.put("baseAmount", baseAmount);
			orderList.add(responseObject);
			}
			else {
				responseObject1.put("member", count);
				responseObject1.put("pkgMemberList", pkgMemberList);
				responseObject1.put("localAount", localAount);
				responseObject1.put("baseAmount", baseAmount);
				orderList.add(responseObject1);
			}			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderList;
	}
	public static float round(float value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.floatValue();
	}

	@Override
	public float covertedAmountByCurrency(float amount, String currency) {
		float convertAmount=0;
		try {
			String query ="select exchange_rate from currency where currency ="+"'"+currency+"'";
			float exchangeRate = jdbcTemplate.queryForObject(query.toString(), float.class);
			     convertAmount = amount*exchangeRate;
			     convertAmount = round(convertAmount,2);
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		
		
		return convertAmount;
		
		
	}

	@Override
	public List<Map<String, Object>> getConfigTableDetails() {
		List<Map<String,Object>> configList = null;
		try {
			configList = jdbcTemplate.queryForList("select * from config");
		} catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return configList;
	}
	
	@Override
	public int getPromoStatus(String promoCode) {
		LOGGER.info("inside getPromoStatus");
		Integer status=0;
		try {
			status=jdbcTemplate.queryForObject("select distinct sc.active from source_code sc inner join generic_promotion_code gpc on gpc.source_code_id=sc.source_code_id inner join"
					+ "  order_item oi on sc.source_code_id=gpc.source_code_id  where gpc.promotion_code='"+promoCode+"'", Integer.class);
		
		
	} catch(Exception e) {
		LOGGER.error(ERROR + e);
	}
	return status;
}

	@Override
	public Date getPromoFutureDate(String promoCode) {
		LOGGER.info("inside futureDate method...");
		Date value=null;
		try {
			
			value=jdbcTemplate.queryForObject("select source_code.from_date from source_code inner join generic_promotion_code "
					+ "on generic_promotion_code.source_code_id=source_code.source_code_id where generic_promotion_code.promotion_code='"+promoCode+"'", Date.class);	
		}
		 catch(Exception e) {
				LOGGER.error(ERROR + e);
			}
		
		return value;
	}

	@Override
	public Integer getSourceCodeId(String promoCode) {
		LOGGER.info("inside futureDate method...");
		int value=0;
		try {
			
			value=jdbcTemplate.queryForObject("select source_code_id from generic_promotion_code where promotion_code='"+promoCode+"'", Integer.class);	
		}
		 catch(Exception e) {
				LOGGER.error(ERROR + e);
			}
		
		return value;
	}
	
	public List<Double> getPriceCostAmountList(int rate_class_id,int n_issues)
	{
		List<Double>priceCostAmountList=new ArrayList<Double>();
		double default_price_per_issue=1d,cost_per_day=1d,order_amount=0d;
		int rate_class_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM rate_class WHERE rate_class_id="+rate_class_id+";", Integer.class);
		if(rate_class_count>0)
		{
			String mru_rate_class_effective_seq=jdbcTemplate.queryForObject("SELECT mru_rate_class_effective_seq FROM rate_class WHERE rate_class_id="+rate_class_id+";", String.class);
			if(null!=mru_rate_class_effective_seq && !"".equals(mru_rate_class_effective_seq))
			{
				int mru_rate_class_effective_seq_int=Integer.parseInt(mru_rate_class_effective_seq);
				int count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM rate_class_effective WHERE rate_class_id="+rate_class_id+" AND rate_class_effective_seq="+mru_rate_class_effective_seq_int+";", Integer.class);
				if(count>0)
				{
					String query2="SELECT default_price_per_issue,cost_per_day FROM rate_class_effective WHERE rate_class_id=? AND rate_class_effective_seq=?;";
					Map<String,Object> resultMap2 = jdbcTemplate.queryForMap(query2,rate_class_id,mru_rate_class_effective_seq_int);
					if(null!=resultMap2.get("default_price_per_issue"))
					{
						default_price_per_issue=Double.parseDouble(resultMap2.get("default_price_per_issue").toString());
					}
					if(null!=resultMap2.get("cost_per_day"))
					{
						cost_per_day=Double.parseDouble(resultMap2.get("cost_per_day").toString());
					}
				}
				int ratecardCount=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ratecard WHERE rate_class_id="+rate_class_id+" AND rate_class_effective_seq="+mru_rate_class_effective_seq_int+";", Integer.class);
				if(ratecardCount>0 && ratecardCount==1)
				{
					String query3="SELECT from_qty,to_qty,basic FROM ratecard WHERE rate_class_id=? AND rate_class_effective_seq=?;";
					Map<String,Object> resultMap3 = jdbcTemplate.queryForMap(query3,rate_class_id,mru_rate_class_effective_seq_int);
					int from_qty=Integer.parseInt(resultMap3.get("from_qty").toString());
					int to_qty=Integer.parseInt(resultMap3.get("to_qty").toString());
					double basic=Double.parseDouble(resultMap3.get("basic").toString());
					if(n_issues>=from_qty && n_issues<=to_qty)
					{
						order_amount=basic;
					}else
					{
						order_amount=n_issues*basic;
					}
				}
			}
		}
		priceCostAmountList.add(default_price_per_issue);
		priceCostAmountList.add(cost_per_day);
		priceCostAmountList.add(order_amount);
		return priceCostAmountList;
	}
	
	
	
	public List<Object> getDataForIssueBasedSubscription(int start_type,int oc_id,int n_issues,double order_amount,double default_price_per_issue,int number_volume_sets)
	{
		List<Object>dataForIssueBasedSubscriptionList=new ArrayList<Object>();
		String start_date=null,expiration_date=null;
		int order_quantity=0;
		if(start_type==0)
		{
			int count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM issue WHERE oc_id="+oc_id+" AND issue_close_date IS NULL;", Integer.class);
			if(count>0)
			{
				String query3="SELECT TOP 1 issue_id,issue_date FROM issue WHERE oc_id=? AND issue_close_date IS NULL;";
				Map<String,Object> resultMap3 = jdbcTemplate.queryForMap(query3,oc_id);
				if(null!=resultMap3.get("issue_date"))
				{
					start_date=resultMap3.get("issue_date").toString();
					int issue_id=Integer.parseInt(resultMap3.get("issue_id").toString());
					int expiration_date_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM issue WHERE issue_id="+(issue_id+n_issues-1)+";", Integer.class);
					if(expiration_date_count>0)
					{
						expiration_date=jdbcTemplate.queryForObject("SELECT issue_date FROM issue WHERE issue_id="+(issue_id+n_issues-1)+";", String.class);
					}
				}
			}
			/*if(order_amount==0)
			{
				order_amount=n_issues*default_price_per_issue;
			}*/
			order_quantity=n_issues;
		}else if(start_type==1) 
		{
			int count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM issue WHERE oc_id="+oc_id+" AND issue_close_date IS NULL;", Integer.class);
			if(count>0)
			{
				String enum_volume_nbr=jdbcTemplate.queryForObject("SELECT TOP 1 enum_volume_nbr FROM issue WHERE oc_id="+oc_id+" AND issue_close_date IS NULL;", String.class);
				if(null!=enum_volume_nbr && !"".equals(enum_volume_nbr))
				{
					start_date=jdbcTemplate.queryForObject("SELECT TOP 1 issue_date FROM issue WHERE oc_id="+oc_id+" AND enum_volume_nbr="+Integer.parseInt(enum_volume_nbr)+";", String.class);
					expiration_date=jdbcTemplate.queryForObject("SELECT TOP 1 issue_date FROM issue WHERE oc_id="+oc_id+" AND enum_volume_nbr="+Integer.parseInt(enum_volume_nbr)+" ORDER BY issue_date DESC;", String.class);
					n_issues=jdbcTemplate.queryForObject("SELECT COUNT(enum_issue_nbr) FROM issue WHERE oc_id="+oc_id+" AND enum_volume_nbr="+Integer.parseInt(enum_volume_nbr)+";", Integer.class);
					/*if(order_amount==0)
					{
						order_amount=n_issues*number_volume_sets*default_price_per_issue;
					}*/
					order_quantity=n_issues*number_volume_sets;
				}
			}
		}
		dataForIssueBasedSubscriptionList.add(start_date);
		dataForIssueBasedSubscriptionList.add(expiration_date);
		dataForIssueBasedSubscriptionList.add(order_amount);
		dataForIssueBasedSubscriptionList.add(order_quantity);
		
		return dataForIssueBasedSubscriptionList;
	}
	
	
	
	public List<Object> getDataForTimeBasedSubscription(String order_date,int start_type,String term,int calendar_unit,int n_calendar_units,double cost_per_day)
	{
		List<Object>dataForTimeBasedSubscriptionList=new ArrayList<Object>();
		String start_date=null,expiration_date=null;
		double order_amount=0d;
		start_date=order_date;
		if(start_type==2 || start_type==3 || start_type==4)//Date Based with Issues,Date Based no Issues,Date Based with Units
		{
			if(null!=term)
			{
				DateFormat sdf = new SimpleDateFormat("M/d/yyyy");
				if(calendar_unit==0)//Day(s)
				{
					expiration_date=PropertyUtilityClass.getDateAfterAddingDays(start_date,sdf,n_calendar_units-1);
				}else if(calendar_unit==1)//Week(s)
				{
					expiration_date=PropertyUtilityClass.getDateAfterAddingDays(start_date,sdf,(n_calendar_units*7)-1);
				}
				else if(calendar_unit==2)//Month(s)
				{
					n_calendar_units=PropertyUtilityClass.addNumberOfMonthsInCurrentMonthAndProvideTotalNumberOfDays(start_date,n_calendar_units);
					expiration_date=PropertyUtilityClass.getDateAfterAddingDays(start_date,sdf,n_calendar_units-1);
				}else if(calendar_unit==3)//Year(s)
				{
					n_calendar_units=PropertyUtilityClass.addNumberOfYearsInCurrentYearAndProvideTotalNumberOfDays(start_date,n_calendar_units);
					expiration_date=PropertyUtilityClass.getDateAfterAddingDays(start_date,sdf,n_calendar_units-1);
				}
				//order_amount=n_calendar_units*cost_per_day;
			}
		}
		dataForTimeBasedSubscriptionList.add(start_date);
		dataForTimeBasedSubscriptionList.add(expiration_date);
		dataForTimeBasedSubscriptionList.add(n_calendar_units);
		dataForTimeBasedSubscriptionList.add(order_amount);
		
		return dataForTimeBasedSubscriptionList;
	}
	
	

	public List<Object> getDataForUnitBasedSubscription(String order_date,int start_type,int n_issues,double default_price_per_issue,String term,int calendar_unit,int n_calendar_units,double cost_per_day)
	{
		List<Object>dataForUnitBasedSubscriptionList=new ArrayList<Object>();
		String start_date=null,expiration_date=null;
		double order_amount=0d;
		int order_quantity=0,remaining_issues=0;
		start_date=order_date;
		if(start_type==5)//Unit Based no Time
		{
			/*if(order_amount==0)
			{
				order_amount=n_issues*default_price_per_issue;
			}*/
			order_quantity=n_issues;
			remaining_issues=order_quantity;
		}else if(start_type==4)//Date Based with Units
		{
			if(null!=term)
			{
				DateFormat sdf = new SimpleDateFormat("M/d/yyyy");
				if(calendar_unit==0)//Day(s)
				{
					expiration_date=PropertyUtilityClass.getDateAfterAddingDays(start_date,sdf,n_calendar_units-1);
				}else if(calendar_unit==1)//Week(s)
				{
					expiration_date=PropertyUtilityClass.getDateAfterAddingDays(start_date,sdf,(n_calendar_units*7)-1);
				}
				else if(calendar_unit==2)//Month(s)
				{
					n_calendar_units=PropertyUtilityClass.addNumberOfMonthsInCurrentMonthAndProvideTotalNumberOfDays(start_date,n_calendar_units);
					expiration_date=PropertyUtilityClass.getDateAfterAddingDays(start_date,sdf,n_calendar_units-1);
				}else if(calendar_unit==3)//Year(s)
				{
					n_calendar_units=PropertyUtilityClass.addNumberOfYearsInCurrentYearAndProvideTotalNumberOfDays(start_date,n_calendar_units);
					expiration_date=PropertyUtilityClass.getDateAfterAddingDays(start_date,sdf,n_calendar_units-1);
				}
				//order_amount=n_calendar_units*cost_per_day;
			}
		}
		dataForUnitBasedSubscriptionList.add(start_date);
		dataForUnitBasedSubscriptionList.add(order_amount);
		dataForUnitBasedSubscriptionList.add(order_quantity);
		dataForUnitBasedSubscriptionList.add(remaining_issues);
		dataForUnitBasedSubscriptionList.add(expiration_date);
		dataForUnitBasedSubscriptionList.add(n_calendar_units);
		
		return dataForUnitBasedSubscriptionList;
	}
	
	public List<Object> getPaymentThresholdHandlingDataForSubscriptionTypeOrder(String orderCodeId,int orderCodeType,Integer subscriptionDefId,int revenue_method,int start_type,String order_date)
	{
		List<Object>paymentThresholdHandlingDataList=new ArrayList<Object>();
		int rate_class_id=0,order_quantity=0,remaining_issues=0;
		String term=null,start_date=null,expiration_date=null;
		double default_price_per_issue=1d,cost_per_day=1d,order_amount=0d;
		boolean desiredDateFormatFlag=false;
		String query1="SELECT oc.oc_id,oc.oc,ocode.newsub_rate_class_id,t.term,t.n_issues,t.n_calendar_units,t.calendar_unit,t.number_volume_sets"+
		" FROM order_code ocode"+
		" INNER JOIN oc oc ON oc.oc_id=ocode.oc_id"+
		" INNER JOIN subscription_def sdef ON ocode.order_code_id=sdef.order_code_id"+
		" INNER JOIN term t ON t.term_id=sdef.term_id"+
		" WHERE ocode.order_code_id=? AND ocode.order_code_type=? AND sdef.subscription_def_id=?;";
		Map<String,Object> resultMap1 = jdbcTemplate.queryForMap(query1, orderCodeId,orderCodeType,subscriptionDefId);
		int oc_id=Integer.parseInt(resultMap1.get("oc_id").toString());
		String order_class=resultMap1.get("oc").toString();
		int n_issues=Integer.parseInt(resultMap1.get("n_issues").toString());
		int n_calendar_units=Integer.parseInt(resultMap1.get("n_calendar_units").toString());
		int calendar_unit=Integer.parseInt(resultMap1.get("calendar_unit").toString());
		int number_volume_sets=Integer.parseInt(resultMap1.get("number_volume_sets").toString());
		if(null!=resultMap1.get("newsub_rate_class_id"))
		{
			rate_class_id=Integer.parseInt(resultMap1.get("newsub_rate_class_id").toString());
		}
		if(null!=resultMap1.get("term"))
		{
			term=resultMap1.get("term").toString();
		}
		/*if(rate_class_id>0)
		{
			List<Double> priceCostAmountList=getPriceCostAmountList(rate_class_id,n_issues);
			default_price_per_issue=priceCostAmountList.get(0);
			cost_per_day=priceCostAmountList.get(1);
			order_amount=priceCostAmountList.get(2);
		}*/
		if(revenue_method==0)//Issue Based Subscription
		{
			List<Object>dataForIssueBasedSubscriptionList=getDataForIssueBasedSubscription(start_type,oc_id,n_issues,order_amount,default_price_per_issue,number_volume_sets);
			start_date=(String) dataForIssueBasedSubscriptionList.get(0);
			expiration_date=(String) dataForIssueBasedSubscriptionList.get(1);
			order_amount=(double) dataForIssueBasedSubscriptionList.get(2);
			order_quantity=(int) dataForIssueBasedSubscriptionList.get(3);
			remaining_issues=order_quantity;
		}else if(revenue_method==1)//Time Based Subscription
		{
			desiredDateFormatFlag=true;
			List<Object> dataForTimeBasedSubscriptionList=getDataForTimeBasedSubscription(order_date,start_type,term,calendar_unit,n_calendar_units,cost_per_day);
			start_date=(String) dataForTimeBasedSubscriptionList.get(0);
			expiration_date=(String) dataForTimeBasedSubscriptionList.get(1);
			n_calendar_units=(int) dataForTimeBasedSubscriptionList.get(2);
			order_amount=(double) dataForTimeBasedSubscriptionList.get(3);
		}else if(revenue_method==2)//Unit Based Subscription
		{
			desiredDateFormatFlag=true;
			List<Object> dataForUnitBasedSubscriptionList=getDataForUnitBasedSubscription(order_date,start_type,n_issues,default_price_per_issue,term,calendar_unit,n_calendar_units,cost_per_day);
			start_date=(String) dataForUnitBasedSubscriptionList.get(0);
			order_amount=(double) dataForUnitBasedSubscriptionList.get(1);
			order_quantity=(int) dataForUnitBasedSubscriptionList.get(2);
			remaining_issues=(int) dataForUnitBasedSubscriptionList.get(3);
			expiration_date=(String) dataForUnitBasedSubscriptionList.get(4);
			n_calendar_units=(int) dataForUnitBasedSubscriptionList.get(5);
		}
		paymentThresholdHandlingDataList.add(start_date);
		paymentThresholdHandlingDataList.add(expiration_date);
		paymentThresholdHandlingDataList.add(order_quantity);
		paymentThresholdHandlingDataList.add(order_amount);
		paymentThresholdHandlingDataList.add(remaining_issues);
		paymentThresholdHandlingDataList.add(default_price_per_issue);
		paymentThresholdHandlingDataList.add(cost_per_day);
		paymentThresholdHandlingDataList.add(order_class);
		paymentThresholdHandlingDataList.add(n_calendar_units);
		paymentThresholdHandlingDataList.add(desiredDateFormatFlag);
		paymentThresholdHandlingDataList.add(term);
		
		return paymentThresholdHandlingDataList;
	}
	
	
	public List<Object> getPaymentThresholdHandlingDataForSingleCopyTypeOrder(String orderCodeId,int orderCodeType,Integer subscriptionDefId)
	{
		List<Object>paymentThresholdHandlingDataList=new ArrayList<Object>();
		String query1="SELECT oc.oc_id,oc.oc,ocode.newsub_rate_class_id FROM order_code ocode"+ 
			      " INNER JOIN oc oc ON oc.oc_id=ocode.oc_id WHERE ocode.order_code_id=? AND ocode.order_code_type=?;";
		Map<String,Object> resultMap1 = jdbcTemplate.queryForMap(query1, orderCodeId,orderCodeType);
		int oc_id=Integer.parseInt(resultMap1.get("oc_id").toString());
		String order_class=resultMap1.get("oc").toString();
		int order_quantity=1;
		int remaining_issues=0,rate_class_id=0;
		double default_price_per_issue=1d,order_amount=0d;
		String start_date=null;
		if(null!=resultMap1.get("newsub_rate_class_id"))
		{
			rate_class_id=Integer.parseInt(resultMap1.get("newsub_rate_class_id").toString());
		}
		/*if(rate_class_id>0)
		{
			List<Double> priceCostAmountList=getPriceCostAmountList(rate_class_id,1);
			default_price_per_issue=priceCostAmountList.get(0);
		}*/
		int start_date_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM issue WHERE oc_id="+oc_id+" AND issue_id="+subscriptionDefId+";", Integer.class);
		if(start_date_count>0)
		{
			start_date=jdbcTemplate.queryForObject("SELECT issue_date FROM issue WHERE oc_id="+oc_id+" AND issue_id="+subscriptionDefId+";", String.class);
		}
		//order_amount=default_price_per_issue;
		paymentThresholdHandlingDataList.add(order_class);
		paymentThresholdHandlingDataList.add(order_quantity);
		paymentThresholdHandlingDataList.add(remaining_issues);
		paymentThresholdHandlingDataList.add(start_date);
		paymentThresholdHandlingDataList.add(order_amount);
		
		return paymentThresholdHandlingDataList;
	}
	
	
	
	public List<Object> getPaymentThresholdHandlingDataForProductTypeOrder(String orderCodeId,int orderCodeType,Integer subscriptionDefId)
	{
		List<Object>paymentThresholdHandlingDataList=new ArrayList<Object>();
		String query1="SELECT oc.oc,ocode.newsub_rate_class_id,ocode.qty FROM order_code ocode"+ 
			      " INNER JOIN oc oc ON oc.oc_id=ocode.oc_id WHERE ocode.order_code_id=? AND ocode.order_code_type=?;";
		Map<String,Object> resultMap1 = jdbcTemplate.queryForMap(query1, orderCodeId,orderCodeType);
		String order_class=resultMap1.get("oc").toString();
		String qty=resultMap1.get("qty").toString();
		int remaining_issues=0,order_quantity=0,rate_class_id=0;
		double default_price_per_issue=1d,order_amount=0d;
		if(null!=qty && !"".equals(qty))
		{
			order_quantity=Integer.parseInt(qty);
		}
		if(null!=resultMap1.get("newsub_rate_class_id"))
		{
			rate_class_id=Integer.parseInt(resultMap1.get("newsub_rate_class_id").toString());
		}
		/*int product_count=0;
		String price=null;
		if(subscriptionDefId>0)
		{
			product_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM product WHERE order_code_id="+orderCodeId+" AND product_id="+subscriptionDefId+";", Integer.class);
			if(product_count>0)
			{	
				price=jdbcTemplate.queryForObject("SELECT price FROM product WHERE order_code_id="+orderCodeId+" AND product_id="+subscriptionDefId+";", String.class);
			}	
		}else
		{
			product_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM product WHERE order_code_id="+orderCodeId+";", Integer.class);
			if(product_count>0)
			{	
				price=jdbcTemplate.queryForObject("SELECT price FROM product WHERE order_code_id="+orderCodeId+";", String.class);
			}	
		}
		if(null!=price && !"".equals(price))
		{
			order_amount=Double.parseDouble(price);
		}else
		{
			if(rate_class_id>0)
			{
				List<Double> priceCostAmountList=getPriceCostAmountList(rate_class_id,0);
				default_price_per_issue=priceCostAmountList.get(0);
				order_amount=default_price_per_issue;
			}
		}*/
		paymentThresholdHandlingDataList.add(order_class);
		paymentThresholdHandlingDataList.add(order_quantity);
		paymentThresholdHandlingDataList.add(order_amount*order_quantity);
		paymentThresholdHandlingDataList.add(remaining_issues);
		
		return paymentThresholdHandlingDataList;
	}
	
	
	public List<Object> getDataForEachPackageContent(int item_order_code_id,int qty,String order_date,int item_issue_id,int subscriptionDefId,DateFormat inputFormat,DateFormat outputFormat)
	{
		  List<Object>dataListForEachPackageContent=new ArrayList<Object>();
		  String item_start_date=null,start_date=null; 
		  double order_amount=0d;
		  boolean desiredDateFormatFlag=false;
		  String item_query="SELECT order_code_type,revenue_method,start_type FROM order_code WHERE order_code_id=?;";
		  Map<String,Object> item_order_code_map = jdbcTemplate.queryForMap(item_query, item_order_code_id);
		  int item_order_code_type=Integer.parseInt(item_order_code_map.get("order_code_type").toString());
		  int item_revenue_method=Integer.parseInt(item_order_code_map.get("revenue_method").toString());
		  int item_start_type=Integer.parseInt(item_order_code_map.get("start_type").toString());
		  if(item_order_code_type==0)//Subscription Type Order
		  {
				int item_subscription_def_id=jdbcTemplate.queryForObject("SELECT TOP 1 subscription_def_id FROM subscription_def WHERE order_code_id="+item_order_code_id+";", Integer.class);
				List<Object> paymentThresholdHandlingDataList=getPaymentThresholdHandlingDataForSubscriptionTypeOrder(String.valueOf(item_order_code_id),item_order_code_type,item_subscription_def_id,item_revenue_method,item_start_type,order_date);
				item_start_date=(String) paymentThresholdHandlingDataList.get(0);
				//order_amount=(double) paymentThresholdHandlingDataList.get(3)*qty;
				desiredDateFormatFlag=(boolean) paymentThresholdHandlingDataList.get(9);
				if(null!=item_start_date && !"".equals(item_start_date))
				{
					start_date=item_start_date;
					if(desiredDateFormatFlag==false)
					{
						start_date=PropertyUtilityClass.getDateInDesiredFormat(start_date, inputFormat, outputFormat);
					}
				}
		  }else if(item_order_code_type==1)//Single Copy Type Order
		  {
				List<Object> paymentThresholdHandlingDataList=getPaymentThresholdHandlingDataForSingleCopyTypeOrder(String.valueOf(item_order_code_id),item_order_code_type,item_issue_id);
				item_start_date=(String) paymentThresholdHandlingDataList.get(3);
				if(null!=item_start_date && !"".equals(item_start_date))
				{
					start_date=PropertyUtilityClass.getDateInDesiredFormat(item_start_date,inputFormat,outputFormat);
				}
				//order_amount=(double) paymentThresholdHandlingDataList.get(4)*qty;
		  }else if(item_order_code_type==2)//Product Type Order
		  {
				List<Object> paymentThresholdHandlingDataList=getPaymentThresholdHandlingDataForProductTypeOrder(String.valueOf(item_order_code_id),item_order_code_type,subscriptionDefId);
				//order_amount=(double) paymentThresholdHandlingDataList.get(2)*qty;
		  }
		  dataListForEachPackageContent.add(start_date);
		  dataListForEachPackageContent.add(order_amount);
		  System.out.println("item_order_code_id = "+item_order_code_id+" # item_revenue_method = "+item_revenue_method+" # item_start_type = "+item_start_type+" # start_date = "+start_date);
		return dataListForEachPackageContent;
	}
	
	
	
	public List<Object> getPaymentThresholdHandlingDataForBasicAndPooledPackage(int orderCodeType,String subscriptionIdList,String orderCodeId,String order_date,int subscriptionDefId,DateFormat inputFormat,DateFormat outputFormat)
	{
		    List<Object>dataListForBasicAndPooledPackage=new ArrayList<Object>();
		    boolean paymentThresholdHandlingExists=true,desiredDateFormatFlag=false;
			int pkg_def_id=0,item_issue_id=0;
			String[] subscriptionIdArray=null;
			double totalAmount=0d,order_amount=0d;
			String start_date=null,expiration_date=null,order_class=null,term=null;
			List<String> subscriptionIdListFromFrontEnd = new ArrayList<String>();	
			if(null!=subscriptionIdList && !"".equals(subscriptionIdList))
			{
				subscriptionIdArray=subscriptionIdList.split(",");
				subscriptionIdListFromFrontEnd=Arrays.asList(subscriptionIdArray);
			}
			String pkg_def_query=null;
			Map<String,Object> pkg_def_map =null;
			Map<Integer, String>start_dates_map=null;
			int pkg_def_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM pkg_def WHERE order_code_id="+orderCodeId+";", Integer.class);
			if(pkg_def_count>0)
			{
				if(pkg_def_count==1)
				{
					pkg_def_query="SELECT n_calendar_units,calendar_unit,pkg_price_method,pkg_price,rate_class_id FROM pkg_def WHERE order_code_id=?;";
					pkg_def_map = jdbcTemplate.queryForMap(pkg_def_query, orderCodeId);
					if(null!=subscriptionIdListFromFrontEnd && subscriptionIdListFromFrontEnd.size()>0)
					{
						item_issue_id=Integer.parseInt(subscriptionIdListFromFrontEnd.get(0));
					}
				}else
				{
					if(null!=subscriptionIdListFromFrontEnd && subscriptionIdListFromFrontEnd.size()>0)
					{
						pkg_def_id=Integer.parseInt(subscriptionIdListFromFrontEnd.get(0));
					}
					pkg_def_query="SELECT n_calendar_units,calendar_unit,pkg_price_method,pkg_price,rate_class_id FROM pkg_def WHERE order_code_id=? AND pkg_def_id=?;";
					pkg_def_map = jdbcTemplate.queryForMap(pkg_def_query, orderCodeId,pkg_def_id);
				}
			}
			int n_calendar_units=Integer.parseInt(pkg_def_map.get("n_calendar_units").toString());
			int calendar_unit=Integer.parseInt(pkg_def_map.get("calendar_unit").toString());
			int pkg_price_method=Integer.parseInt(pkg_def_map.get("pkg_price_method").toString());
			double pkg_price=Double.parseDouble(pkg_def_map.get("pkg_price").toString());
			if(pkg_price_method==3)//No Charge
			{
				paymentThresholdHandlingExists=false;
			}
			if(paymentThresholdHandlingExists)
			{
				double default_pkg_price=0d;
				String query1="SELECT oc.oc,ocode.newsub_rate_class_id,ocode.mru_pkg_content_seq,ocode.term_id"+
						      " FROM order_code ocode INNER JOIN oc oc ON oc.oc_id=ocode.oc_id WHERE ocode.order_code_id=?;";
				Map<String,Object> resultMap1 = jdbcTemplate.queryForMap(query1, orderCodeId);
				order_class=resultMap1.get("oc").toString();
				if(resultMap1.get("term_id")==null)
				{
					term=null;
				}else
				{
					int term_id_int=Integer.parseInt(resultMap1.get("term_id").toString());
					int term_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM term WHERE term_id="+term_id_int+";", Integer.class);
					if(term_count>0)
					{
						term=jdbcTemplate.queryForObject("SELECT term FROM term WHERE term_id="+term_id_int+";", String.class);
					}
				}
				if(null!=pkg_def_map.get("rate_class_id") && !"".equals(pkg_def_map.get("rate_class_id")))
				{
					int rate_class_id=Integer.parseInt(pkg_def_map.get("rate_class_id").toString());
					int rate_class_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM rate_class WHERE rate_class_id="+rate_class_id+";", Integer.class);
					if(rate_class_count>0)
					{
						String mru_rate_class_effective_seq=jdbcTemplate.queryForObject("SELECT mru_rate_class_effective_seq FROM rate_class WHERE rate_class_id="+rate_class_id+";", String.class);
						if(null!=mru_rate_class_effective_seq && !"".equals(mru_rate_class_effective_seq))
						{
							int mru_rate_class_effective_seq_int=Integer.parseInt(mru_rate_class_effective_seq);
							int count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM rate_class_effective WHERE rate_class_id="+rate_class_id+" AND rate_class_effective_seq="+mru_rate_class_effective_seq_int+";", Integer.class);
							if(count>0)
							{
								default_pkg_price=jdbcTemplate.queryForObject("SELECT default_pkg_price FROM rate_class_effective WHERE rate_class_id="+rate_class_id+" AND rate_class_effective_seq="+mru_rate_class_effective_seq_int+";", Double.class);
							}
						}
					}
				}
				start_dates_map=new HashMap<Integer, String>();
				List<Map<String, Object>> item_order_code_id_query_list  = jdbcTemplate.queryForList("SELECT * FROM pkg_content WHERE order_code_id="+orderCodeId+";");
				for(Map<String, Object> entryMap : item_order_code_id_query_list)
				{
					  int pkg_content_seq=Integer.parseInt(entryMap.get("pkg_content_seq").toString());
					  int item_order_code_id=Integer.parseInt(entryMap.get("item_order_code_id").toString());
					  int qty=1;
					  if(null!=entryMap.get("qty")&&!"".equals(entryMap.get("qty").toString()))
					  {
						  qty=Integer.parseInt(entryMap.get("qty").toString());
					  }
					  int required=Integer.parseInt(entryMap.get("required").toString());
					  if(orderCodeType==4)
					  {
						  List<Object>dataListForEachPackageContent=getDataForEachPackageContent(item_order_code_id,qty,order_date,item_issue_id,subscriptionDefId,inputFormat,outputFormat);
						  start_date=(String) dataListForEachPackageContent.get(0);
						  //order_amount=(double) dataListForEachPackageContent.get(1);
						  //totalAmount=totalAmount+order_amount;
						  start_dates_map.put(pkg_content_seq, start_date);
					  }
					  if(orderCodeType==6 && required==1)
					  {
						  List<Object>dataListForEachPackageContent=getDataForEachPackageContent(item_order_code_id,qty,order_date,item_issue_id,subscriptionDefId,inputFormat,outputFormat);
						  start_date=(String) dataListForEachPackageContent.get(0);
						  //order_amount=(double) dataListForEachPackageContent.get(1);
						  //totalAmount=totalAmount+order_amount;
						  start_dates_map.put(pkg_content_seq, start_date);
					  }
				}
				if(start_dates_map.size()>0)
				{
					start_date=start_dates_map.get(1);
				}
				if(null!=start_date && !"".equals(start_date))
				{
					DateFormat sdf = new SimpleDateFormat("M/d/yyyy");
					if(calendar_unit==0)//Day(s)
					{
						expiration_date=PropertyUtilityClass.getDateAfterAddingDays(start_date,sdf,n_calendar_units-1);
					}else if(calendar_unit==1)//Week(s)
					{
						expiration_date=PropertyUtilityClass.getDateAfterAddingDays(start_date,sdf,(n_calendar_units*7)-1);
					}
					else if(calendar_unit==2)//Month(s)
					{
						n_calendar_units=PropertyUtilityClass.addNumberOfMonthsInCurrentMonthAndProvideTotalNumberOfDays(start_date,n_calendar_units);
						expiration_date=PropertyUtilityClass.getDateAfterAddingDays(start_date,sdf,n_calendar_units-1);
					}else if(calendar_unit==3)//Year(s)
					{
						n_calendar_units=PropertyUtilityClass.addNumberOfYearsInCurrentYearAndProvideTotalNumberOfDays(start_date,n_calendar_units);
						expiration_date=PropertyUtilityClass.getDateAfterAddingDays(start_date,sdf,n_calendar_units-1);
					}
				    desiredDateFormatFlag=true;
				}
				/*if(pkg_price_method==0)//price
				{
					order_amount=pkg_price;
				}
				else if(pkg_price_method==1)//Rate
				{
					order_amount=default_pkg_price;
				}
				else if(pkg_price_method==2)//member
				{
					order_amount=totalAmount;
				}*/
			}
			dataListForBasicAndPooledPackage.add(paymentThresholdHandlingExists);
			dataListForBasicAndPooledPackage.add(order_class);
			dataListForBasicAndPooledPackage.add(term);
			dataListForBasicAndPooledPackage.add(start_date);
			dataListForBasicAndPooledPackage.add(n_calendar_units);
			dataListForBasicAndPooledPackage.add(expiration_date);
			dataListForBasicAndPooledPackage.add(desiredDateFormatFlag);
			dataListForBasicAndPooledPackage.add(order_amount);
			dataListForBasicAndPooledPackage.add(start_dates_map);
		
		return dataListForBasicAndPooledPackage;
	}
	
	
	
	public List<Object> getPaymentThresholdHandlingDataForAdhocPackage(String orderCodeId)
	{
		List<Object>dataListForAdhocPackage=new ArrayList<Object>();
		String order_class=null,term=null;
		String query1="SELECT oc.oc,ocode.newsub_rate_class_id,ocode.mru_pkg_content_seq,ocode.term_id"+
			      " FROM order_code ocode INNER JOIN oc oc ON oc.oc_id=ocode.oc_id WHERE ocode.order_code_id=?;";
		Map<String,Object> resultMap1 = jdbcTemplate.queryForMap(query1, orderCodeId);
		order_class=resultMap1.get("oc").toString();
		if(resultMap1.get("term_id")==null)
		{
			term=null;
		}else
		{
			int term_id_int=Integer.parseInt(resultMap1.get("term_id").toString());
			int term_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM term WHERE term_id="+term_id_int+";", Integer.class);
			if(term_count>0)
			{
				term=jdbcTemplate.queryForObject("SELECT term FROM term WHERE term_id="+term_id_int+";", String.class);
			}
		}
		dataListForAdhocPackage.add(order_class);
		dataListForAdhocPackage.add(term);
		
		return dataListForAdhocPackage;
	}

	
	
	//Added new method by Sohrab for THINKDEV-610,611,615
	@Override
	public PaymentThresholdHandlingDataModel retrievePaymentThresholdHandlingDataFromDataSource(String orderCodeId,int orderCodeType,String sourceCodeId,Integer subscriptionDefId,String subscriptionIdList,Double totalPaid,int customerId,int oc_type,int start_type,int revenue_method,double amount_of_order_in_progress) 
	{
		PaymentThresholdHandlingDataModel paymentThresholdHandlingDataModelObj=new PaymentThresholdHandlingDataModel();
		String order_class = null,term=null,start_date=null,source_code=null,currency=null,order_date=null,expiration_date=null;
		double order_amount=0d,subscription=0d,cost_per_day=1d,default_price_per_issue=1d;
		int order_quantity=0,remaining_issues=0,rate_class_id=0,n_calendar_units=0,calendar_unit=0;
		boolean desiredDateFormatFlag=false,paymentThresholdHandlingExists=true;
		Map<Integer, String>start_dates_map=null;
		try 
		{
			source_code=jdbcTemplate.queryForObject("SELECT source_code FROM source_code where source_code_id="+sourceCodeId+";", String.class);
			currency=jdbcTemplate.queryForObject("SELECT s.currency FROM customer_address cadd INNER JOIN state s ON s.state=cadd.state WHERE customer_address_seq=1 AND cadd.customer_id="+customerId+";",String.class);
			if(currency==null || currency.equals(""))
			{
				currency=jdbcTemplate.queryForObject("SELECT currency FROM config;",String.class);
			}
			DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			DateFormat outputFormat=new SimpleDateFormat("M/d/yyyy");
			Date orderDate=new Date();
			order_date= outputFormat.format(orderDate);
			if(orderCodeType==0)//Subscription Type Order
			{
				List<Object> paymentThresholdHandlingDataList=getPaymentThresholdHandlingDataForSubscriptionTypeOrder(orderCodeId,orderCodeType,subscriptionDefId,revenue_method,start_type,order_date);
				start_date=(String) paymentThresholdHandlingDataList.get(0);
				expiration_date=(String) paymentThresholdHandlingDataList.get(1);
				order_quantity=(int) paymentThresholdHandlingDataList.get(2);
				order_amount=(double) paymentThresholdHandlingDataList.get(3);
				remaining_issues=(int) paymentThresholdHandlingDataList.get(4);
				default_price_per_issue=(double) paymentThresholdHandlingDataList.get(5);
				cost_per_day=(double) paymentThresholdHandlingDataList.get(6);
				order_class=(String) paymentThresholdHandlingDataList.get(7);
				n_calendar_units=(int) paymentThresholdHandlingDataList.get(8);
				desiredDateFormatFlag=(boolean) paymentThresholdHandlingDataList.get(9);
				term=(String) paymentThresholdHandlingDataList.get(10);
			}else if(orderCodeType==1)//Single Copy Type Order
			{
				List<Object> paymentThresholdHandlingDataList=getPaymentThresholdHandlingDataForSingleCopyTypeOrder(orderCodeId,orderCodeType,subscriptionDefId);
				order_class=(String) paymentThresholdHandlingDataList.get(0);
				order_quantity=(int) paymentThresholdHandlingDataList.get(1);
				remaining_issues=(int) paymentThresholdHandlingDataList.get(2);
				start_date=(String) paymentThresholdHandlingDataList.get(3);
				order_amount=(double) paymentThresholdHandlingDataList.get(4);
			}else if(orderCodeType==2)//Product Type Order
			{
				List<Object> paymentThresholdHandlingDataList=getPaymentThresholdHandlingDataForProductTypeOrder(orderCodeId,orderCodeType,subscriptionDefId);
				order_class=(String) paymentThresholdHandlingDataList.get(0);
				order_quantity=(int) paymentThresholdHandlingDataList.get(1);
				order_amount=(double) paymentThresholdHandlingDataList.get(2);
				remaining_issues=(int) paymentThresholdHandlingDataList.get(3);
			}else if(orderCodeType==4 || orderCodeType==6)//Basic PKG, POOLED PKG
			{
				List<Object> dataListForBasicAndPooledPackage=getPaymentThresholdHandlingDataForBasicAndPooledPackage(orderCodeType,subscriptionIdList,orderCodeId,order_date,subscriptionDefId,inputFormat,outputFormat);
				paymentThresholdHandlingExists=(boolean) dataListForBasicAndPooledPackage.get(0);
				order_class=(String) dataListForBasicAndPooledPackage.get(1);
				term=(String) dataListForBasicAndPooledPackage.get(2);
				start_date=(String) dataListForBasicAndPooledPackage.get(3);
				n_calendar_units=(int) dataListForBasicAndPooledPackage.get(4);
				expiration_date=(String) dataListForBasicAndPooledPackage.get(5);
				desiredDateFormatFlag=(boolean) dataListForBasicAndPooledPackage.get(6);
				order_amount=(double) dataListForBasicAndPooledPackage.get(7);
				start_dates_map=(Map<Integer, String>) dataListForBasicAndPooledPackage.get(8);
			}/*else if(orderCodeType==5)//ADHOC PKG : Incomplete
			{
				List<Object>dataListForAdhocPackage=getPaymentThresholdHandlingDataForAdhocPackage(orderCodeId);
				order_class=(String) dataListForAdhocPackage.get(0);
				term=(String) dataListForAdhocPackage.get(1);
			}else if(orderCodeType==7)//QUICK ORDER
			{
				int content_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM quick_order_content WHERE order_code_id="+orderCodeId+";", Integer.class);
				if(content_count>0)
				{
					//String content_query="SELECT item_order_code_id,qty,issue_id,pkg_def_id,product_id,subscription_def_id FROM quick_order_content WHERE order_code_id=? AND quick_order_content_seq=1;";
					List<Map<String, Object>> quick_order_content_list  = jdbcTemplate.queryForList("SELECT * FROM quick_order_content WHERE order_code_id="+orderCodeId+";");
					for(Map<String, Object> content_map : quick_order_content_list)
					{
						    int item_order_code_id=Integer.parseInt(content_map.get("item_order_code_id").toString());
							int qty=Integer.parseInt(content_map.get("qty").toString());
							int issue_id=0,pkg_def_id=0,product_id=0,subscription_def_id=0;
							if(null!=content_map.get("issue_id"))
							{
								issue_id=Integer.parseInt(content_map.get("issue_id").toString());
							}
							if(null!=content_map.get("pkg_def_id"))
							{
								pkg_def_id=Integer.parseInt(content_map.get("pkg_def_id").toString());
							}
							if(null!=content_map.get("product_id"))
							{
								product_id=Integer.parseInt(content_map.get("product_id").toString());
							}
							if(null!=content_map.get("subscription_def_id"))
							{
								subscription_def_id=Integer.parseInt(content_map.get("subscription_def_id").toString());
							}
							int item_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM order_code WHERE order_code_id="+item_order_code_id+";", Integer.class);
							if(item_count>0)
							{
								String item_query="SELECT oc.oc,ocode.newsub_rate_class_id,ocode.term_id,ocode.order_code_type,ocode.revenue_method,ocode.start_type,"+
												  "ocode.min_n_items,ocode.max_n_items,ocode.no_charge,ocode.controlled"+
												  " FROM order_code ocode INNER JOIN oc oc ON oc.oc_id=ocode.oc_id WHERE ocode.order_code_id=?;";
							
								Map<String,Object> item_map = jdbcTemplate.queryForMap(item_query,item_order_code_id);
								order_class=item_map.get("oc").toString();
								int min_n_items=0,max_n_items=0;
								if(null!=item_map.get("newsub_rate_class_id"))
								{
									rate_class_id=Integer.parseInt(item_map.get("newsub_rate_class_id").toString());
								}
								if(item_map.get("term_id")==null)
								{
									term=null;
								}else
								{
									int term_id_int=Integer.parseInt(item_map.get("term_id").toString());
									int term_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM term WHERE term_id="+term_id_int+";", Integer.class);
									if(term_count>0)
									{
										term=jdbcTemplate.queryForObject("SELECT term FROM term WHERE term_id="+term_id_int+";", String.class);
									}
								}
								int item_order_code_type=Integer.parseInt(item_map.get("order_code_type").toString());
								revenue_method=Integer.parseInt(item_map.get("revenue_method").toString());
								start_type=Integer.parseInt(item_map.get("start_type").toString());
								if(null!=item_map.get("min_n_items"))
								{
									min_n_items=Integer.parseInt(item_map.get("min_n_items").toString());
								}
								if(null!=item_map.get("max_n_items"))
								{
									max_n_items=Integer.parseInt(item_map.get("max_n_items").toString());
								}
								int no_charge=Integer.parseInt(item_map.get("no_charge").toString());
								int controlled=Integer.parseInt(item_map.get("controlled").toString());
								if(item_order_code_type==0)//Subscription Type Order
								{
									List<Object> paymentThresholdHandlingDataList=getPaymentThresholdHandlingDataForSubscriptionTypeOrder(String.valueOf(item_order_code_id),item_order_code_type,subscription_def_id,revenue_method,start_type,order_date);
									start_date=(String) paymentThresholdHandlingDataList.get(0);
									expiration_date=(String) paymentThresholdHandlingDataList.get(1);
									order_quantity=(int) paymentThresholdHandlingDataList.get(2);
									order_amount=(double) paymentThresholdHandlingDataList.get(3)*qty;
									remaining_issues=(int) paymentThresholdHandlingDataList.get(4);
									desiredDateFormatFlag=(boolean) paymentThresholdHandlingDataList.get(9);
								}else if(orderCodeType==1)//Single Copy Type Order
								{
									List<Object> paymentThresholdHandlingDataList=getPaymentThresholdHandlingDataForSingleCopyTypeOrder(orderCodeId,orderCodeType,subscriptionDefId);
									order_quantity=(int) paymentThresholdHandlingDataList.get(1);
									remaining_issues=(int) paymentThresholdHandlingDataList.get(2);
									start_date=(String) paymentThresholdHandlingDataList.get(3);
									order_amount=(double) paymentThresholdHandlingDataList.get(4)*qty;
								}else if(orderCodeType==2)//Product Type Order
								{
									List<Object> paymentThresholdHandlingDataList=getPaymentThresholdHandlingDataForProductTypeOrder(orderCodeId,orderCodeType,subscriptionDefId);
									order_quantity=(int) paymentThresholdHandlingDataList.get(1);
									order_amount=(double) paymentThresholdHandlingDataList.get(2)*qty;
									remaining_issues=(int) paymentThresholdHandlingDataList.get(3);
								}
							}
					}
					}
				}
			subscription=order_amount;
			*/
			if(paymentThresholdHandlingExists)
			{
				if(null!=start_date && desiredDateFormatFlag==false)
				{
					start_date=PropertyUtilityClass.getDateInDesiredFormat(start_date, inputFormat, outputFormat);
				}
				if(null!=expiration_date && desiredDateFormatFlag==false)
				{
					expiration_date=PropertyUtilityClass.getDateInDesiredFormat(expiration_date, inputFormat, outputFormat);
				}
				DecimalFormat df = new DecimalFormat("#.##");
				paymentThresholdHandlingDataModelObj.setOrder_class(order_class);
				paymentThresholdHandlingDataModelObj.setTerm(term);
				paymentThresholdHandlingDataModelObj.setStart_date(start_date);
				paymentThresholdHandlingDataModelObj.setSource_code(source_code);
				paymentThresholdHandlingDataModelObj.setCurrency(currency);
				paymentThresholdHandlingDataModelObj.setCustomer_nbr(customerId);
				paymentThresholdHandlingDataModelObj.setOrder_date(order_date);
				paymentThresholdHandlingDataModelObj.setTotalPaid(Double.parseDouble(df.format(totalPaid)));
				paymentThresholdHandlingDataModelObj.setExpiration_date(expiration_date);
				paymentThresholdHandlingDataModelObj.setOrder_quantity(order_quantity);
				paymentThresholdHandlingDataModelObj.setRemaining_issues(remaining_issues);
				paymentThresholdHandlingDataModelObj.setDelivery(Double.parseDouble(df.format(0.00)));
				paymentThresholdHandlingDataModelObj.setTax(Double.parseDouble(df.format(0.00)));
				paymentThresholdHandlingDataModelObj.setNumber_of_days(n_calendar_units);
				paymentThresholdHandlingDataModelObj.setOrder_amount(Double.parseDouble(df.format(amount_of_order_in_progress)));
				paymentThresholdHandlingDataModelObj.setSubscription(Double.parseDouble(df.format(amount_of_order_in_progress)));
				paymentThresholdHandlingDataModelObj.setStart_dates_map(start_dates_map);
				//Used for testing
				//paymentThresholdHandlingDataModelObj.setOrder_amount_bymycalc(Double.parseDouble(df.format(order_amount)));
				//paymentThresholdHandlingDataModelObj.setSubscription_bymycalc(Double.parseDouble(df.format(subscription)));
			}else
			{
				paymentThresholdHandlingDataModelObj=null;
			}
		}catch(Exception e) 
		{
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}		
		return paymentThresholdHandlingDataModelObj;
	}

	
	
	@Override
	public Integer getRenew(int subscripId) {
		int value=0;
		try {
			
			value=jdbcTemplate.queryForObject("select isNull(new_renewal_card_id,'') as new_renewal_card_id from source_code where source_code_id=(select distinct source_code_id from order_item where subscrip_id="+subscripId+")", Integer.class);	
		}
		 catch(Exception e) {
				LOGGER.error(ERROR + e);
			}
		
		return value;
	}

	@Override
	public List<BasicPackageItemModel> getAdhocPackageData(int customerId, int orderCodeId, int sourceCodeId,
			Integer subscriptionId, int orderCodeType, String subscriptionIdList, String grossLocalAmt,
			String grossBaseAmt) {
		List<BasicPackageItemModel> adhocDataList = new ArrayList<>();
		List<BasicPackageItemModel> adhocDataFullList = new ArrayList<>();
		List<PackageDefinition> basicPackageList = null;
		basicPackageList = getBasicPackageList(orderCodeId);
		
		try{
			StringBuilder adhocData = new StringBuilder("select pkg_def_id,order_code_type as orderCodeType,order_code,oc, 1 as qty,odr.oc_id,pkg_price_method,c.currency from pkg_def inner join order_code odr on odr.order_code_id=pkg_def.order_code_id "); 
					adhocData.append( "inner join oc o on o.oc_id=odr.oc_id inner join customer_address on customer_id=").append(customerId).append(" and customer_address_seq=1");
					adhocData.append( "inner join state on state.state=customer_address.state or state.state_code_for_taxes=customer_address.state "); 
					adhocData.append( "inner join currency c on c.currency=state.currency where odr.order_code_id =").append(orderCodeId);	
					
			if (basicPackageList.size() != 0 && basicPackageList.size() > 1) {
				adhocData.append( " and pkg_def_id=").append(subscriptionId);
			}
			adhocDataList = jdbcTemplate.query(adhocData.toString(), new BasicPackageItemMapper());
			for(BasicPackageItemModel adhoc : adhocDataList) {
				adhoc.setLocalAmount(Objects.isNull(grossLocalAmt) || grossLocalAmt.equals("")?0:Double.parseDouble(grossLocalAmt));
				adhoc.setBaseAmount(Objects.isNull(grossBaseAmt) || grossBaseAmt.equals("")?0:Double.parseDouble(grossBaseAmt));
				adhocDataFullList.add(adhoc);
			}
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return adhocDataFullList;
			
	}

	@Override
	public List<Map<String, Object>> getPkgDefContentList(int orderCodeId, String required) {
		List<Map<String, Object>> pkgDefContentList = null;
		try{
			StringBuilder query = new StringBuilder("select item_order_code_id as order_code_id,ord.order_code_type,ord.oc_id,pkg_content_seq,ord.order_code from pkg_content ");
			query.append("left join order_code ord on ord.order_code_id=pkg_content.item_order_code_id ");
			query.append("where pkg_content.order_code_id=").append(orderCodeId);
			if(required != null)
			query.append(" and required=1 ");
			pkgDefContentList = jdbcTemplate.queryForList(query.toString());			
		}catch(Exception e){
			LOGGER.info("getPkgDefContentList(int orderCodeId, String required): "+e);
		}
		return pkgDefContentList;
	}

	@Override
	public List<Map<String, Object>> getPkgDefContentList(int orderCodeId, Integer pkgDefId) {
		List<Map<String, Object>> pkgDefContentList = null;
		try{
			StringBuilder query = new StringBuilder(" select item_order_code_id as order_code_id,ord.order_code_type,ord.oc_id,pc.pkg_content_seq,ord.order_code,pdc.subscription_def_id,");
			query.append("pdc.issue_id,pdc.product_id from ");
			query.append("pkg_def pd inner join pkg_def_content pdc on pd.pkg_def_id =pdc.pkg_def_id ");
			query.append("inner join pkg_content pc on pc.pkg_content_seq=pdc.pkg_content_seq ");
			query.append("inner join order_code ord on ord.order_code_id=pc.item_order_code_id ");
			query.append("where pc.order_code_id=").append(orderCodeId);
			query.append(" and pdc.pkg_def_id=").append(pkgDefId);
			pkgDefContentList = jdbcTemplate.queryForList(query.toString());			
		}catch(Exception e){
			LOGGER.info("getPkgDefContentList(int orderCodeId, String required): "+e);
		}
		return pkgDefContentList;
	}
	
	
	
	@Override
	public Map<String,Object>retrieveAgencyDataFromDataSource(int cancelled_order_code_type,int cancelled_order_id,int customerId)
	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try 
		{
			String agency_query=null;
			Map<String,Object> agency_map =null;
			int agency_customer_id_int=0,bill_to_customer_id_int=0,renew_to_customer_id_int=0;
			if(cancelled_order_code_type==0)//Subscription Type Order
			{
				String agency_count_query="SELECT COUNT(*) FROM order_item WHERE customer_id="+customerId+" AND orderhdr_id="+cancelled_order_id+";";
				int agency_count=jdbcTemplate.queryForObject(agency_count_query,Integer.class);
				if(agency_count>0)
				{
					agency_query="SELECT agency_customer_id,bill_to_customer_id,renew_to_customer_id FROM order_item WHERE customer_id=? AND orderhdr_id=?;";
					agency_map = jdbcTemplate.queryForMap(agency_query,customerId,cancelled_order_id);
					if(agency_map.get("agency_customer_id")!=null)
					{
						agency_customer_id_int=Integer.parseInt(agency_map.get("agency_customer_id").toString());
						responseObject.put("agency_customer_id",agency_customer_id_int);
					}else
					{
						responseObject.put("agency_customer_id",null);
					}
					if(agency_map.get("bill_to_customer_id")!=null)
					{
						bill_to_customer_id_int=Integer.parseInt(agency_map.get("bill_to_customer_id").toString());
						responseObject.put("bill_to_customer_id",bill_to_customer_id_int);
					}else
					{
						responseObject.put("bill_to_customer_id",null);
					}
					if(agency_map.get("renew_to_customer_id")!=null)
					{
						renew_to_customer_id_int=Integer.parseInt(agency_map.get("renew_to_customer_id").toString());
						responseObject.put("renew_to_customer_id",renew_to_customer_id_int);
					}else
					{
						responseObject.put("renew_to_customer_id",null);
					}
				}
			}
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;
	}

	@Override
	public List<Map<String, Object>> getcheckIssueBeyond(OrderItem orderItem) {
		
			List<Map<String, Object>> records = null;
			try {
		   StringBuilder record=new StringBuilder("select * FROM (SELECT ROW_NUMBER() OVER (ORDER BY issue_date ASC) AS rownumber,issue_id,CONVERT(VARCHAR, issue_date, 101) as issue_date FROM issue where oc_id =");
		             record.append(orderItem.getOcId()); 
		             record.append(" and issue_id>= (select stop_issue_id from order_item where subscrip_id=(select top 1 subscrip_id from order_item where order_code_id= ");
		             record.append( orderItem.getOrderCodeID());
		             record.append(" and customer_id=").append(orderItem.getCustomerId()).append(" and cancel_date is  null order by orderhdr_id desc )) ) as temptablename " ); 
		    		 record.append(" WHERE rownumber >(select n_issues_left from order_item where subscrip_id=(select top 1 subscrip_id from order_item where order_code_id= ").append(orderItem.getOrderCodeID()).append(" and customer_id= ").append(orderItem.getCustomerId());
		    		 record.append(" and cancel_date is  null order by orderhdr_id desc )) ");
		    		 records = jdbcTemplate.queryForList(record.toString());
			}
			  catch (Exception e) {
			   LOGGER.error(ERROR + e);
			   return records;
			}
			return records;
			  
			
		}

	@Override
	public String getalreadySubscribed(int customerId,int orderCodeType,
			String orderCodeID, Optional<Integer> sourceCode,
			Optional<Integer> packageDefId, int i) {
		 String dataSubscribed=null;
		try {
		 dataSubscribed =orderAddWsdl.getalreadySubscribed(customerId, orderCodeType, orderCodeID, sourceCode, packageDefId, 1);
				 
		}
		  catch (Exception e) {
		   LOGGER.error(ERROR + e);
		   return dataSubscribed;
		}
		return dataSubscribed;
		  
	}

	// Added by Malini to get Values of Edit Item page in orderInProgress
	@Override
	public OrderItem orderProgressAdd(OrderItem orderItem, Integer subscriptionId, int itemCount,
			Optional<String> subscriptionIdList) {
		List<Order_add_response> orderProgress = null;
		OrderItem orderItemModel = new OrderItem();
		List<OrderItem> orderItemList = new ArrayList();
		try {

			Integer defId = subscriptionId;
			String defIdList = subscriptionIdList.get();
			orderProgress = orderAddWsdl.orderProgressAddAdd(orderItem, defId, 1, defIdList);
			System.out.println("orderITemDEtails--->"
					+ orderProgress.get(0).getOrderhdr().getOrder_item(0).getGross_base_amount());
			for (Order_add_response orderItemMap : orderProgress) {
	
				orderItemModel.setGrossLocalAmount(
				orderItemMap.getOrderhdr().getOrder_item()[0].getGross_local_amount().toString());
				orderItemModel.setGrossBaseAmount(
						orderItemMap.getOrderhdr().getOrder_item()[0].getGross_base_amount().toString());
				orderItemModel.setNetLocalAmount(
						orderItemMap.getOrderhdr().getOrder_item()[0].getNet_local_amount().toString());
				orderItemModel.setNetBaseAmount(
						orderItemMap.getOrderhdr().getOrder_item()[0].getNet_base_amount().toString());
				orderItemModel.setOrderCategory(orderItemMap.getOrderhdr().getOrder_item()[0].getOrder_category());
				orderItemModel.setAgencyCustomerId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getAgency_customer_id()));
				if(orderItemMap.getOrderhdr().getOrder_item(0).getAgency_customer_id()==0)
				{
					orderItemModel.setAgencyCustomerId("");
				}
				orderItemModel
						.setBillToCustomerId(orderItemMap.getOrderhdr().getOrder_item(0).getBill_to_customer_id());
				int customerId = orderItemMap.getOrderhdr().getOrder_item(0).getCustomer_id();
				orderItemModel.setAddonToOrderhdrId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getAddon_to_orderhdr_id()));
				orderItemModel.setAltShipCustomerAddressSeq(
						orderItemMap.getOrderhdr().getOrder_item(0).getAlt_ship_customer_address_seq());
				orderItemModel.setAddonToOrderItemSeq(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getAddon_to_order_item_seq()));
				orderItemModel
						.setAltShipCustomerId(orderItemMap.getOrderhdr().getOrder_item(0).getAlt_ship_customer_id());
				orderItemModel.setAltShipDelCalc(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getAlt_ship_del_calc()));
				orderItemModel.setAsynchronousAutoRenew(
						orderItemMap.getOrderhdr().getOrder_item(0).getAsynchronous_auto_renew());
				orderItemModel
						.setAttachExist(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getAttach_exist()));
				orderItemModel.setAuditNameTitleId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getAudit_name_title_id()));
				orderItemModel.setAuditQualCategory(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getAudit_qual_category()));
				orderItemModel.setAuditSourceId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getAudit_qual_source_id()));
				orderItemModel.setAuditSalesChannelId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getAudit_sales_channel_id()));
				orderItemModel.setAuditSubscriptionTypeId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getAudit_subscription_type_id()));
				orderItemModel.setAutoPayment(orderItemMap.getOrderhdr().getOrder_item(0).getAuto_payment());
				orderItemModel.setAutoRenewNotifySent(
						orderItemMap.getOrderhdr().getOrder_item(0).getAuto_renew_notify_sent());
				orderItemModel.setBillToCustomerAddressSeq(
						orderItemMap.getOrderhdr().getOrder_item(0).getBill_to_customer_address_seq());
				orderItemModel
						.setBackordQty(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getBackord_qty()));
				Date billDate = orderItemMap.getOrderhdr().getOrder_item(0).getBill_date();
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				String dateFormatted = format.format(billDate.getTime());
				orderItemModel.setBillDate(dateFormatted);
				orderItemModel.setBillingDef(orderItemMap.getOrderhdr().getOrder_item(0).getBilling_def());
				orderItemModel.setBillingDefTestSeq(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getBilling_def_test_seq()));
				orderItemModel
						.setBillingType(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getBilling_type()));
				orderItemModel.setBundleQty(orderItemMap.getOrderhdr().getOrder_item(0).getBundle_qty());
				orderItemModel.setIsBackOrdered(orderItemMap.getOrderhdr().getOrder_item(0).getIs_back_ordered());
				orderItemModel.setCalendarUnit(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getCalendar_unit()));
				orderItemModel
						.setCancelDD(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getCancel_date()));
				orderItemModel.setCancelReason(orderItemMap.getOrderhdr().getOrder_item(0).getCancel_reason());
				orderItemModel.setCancelledOrderAmount(
						Double.parseDouble(orderItemMap.getOrderhdr().getOrder_item(0).getCc_amount_due().toString()));
				orderItemModel.setDue(Double.parseDouble(
						orderItemMap.getOrderhdr().getOrder_item(0).getCc_amount_due_paycurr().toString()));
				orderItemModel.setBaseAmount(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getCc_item_amount().toString()));
				orderItemModel.setChangeQtyFlag(orderItemMap.getOrderhdr().getOrder_item(0).getChange_qty_flag());
				orderItemModel.setChargeOnCancellation(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getCharge_on_cancellation()));
				orderItemModel.setCurrency(orderItemMap.getOrderhdr().getOrder_item(0).getCurrency());
				orderItemModel
						.setCustomerAddressSeq(orderItemMap.getOrderhdr().getOrder_item(0).getCustomer_address_seq());
				orderItemModel.setCustomerGroupId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getCustomer_group_id()));
				orderItemModel.setCustomerId(orderItemMap.getOrderhdr().getOrder_item(0).getCustomer_id());
				orderItemModel.setDateStamp(orderItemMap.getOrderhdr().getOrder_item(0).getDate_stamp());
				orderItemModel.setDealId(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getDeal_id()));
				orderItemModel.setDeliveryMethod(orderItemMap.getOrderhdr().getOrder_item(0).getDelivery_method());
				orderItemModel
						.setDeliveryMethodPerm(orderItemMap.getOrderhdr().getOrder_item(0).getDelivery_method_perm());
				orderItemModel.setDiscClassEffectiveSeq(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getDisc_class_effective_seq()));
				orderItemModel.setDiscountCardSeq(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getDiscount_card_seq()));
				orderItemModel.setDiscountClassId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getDiscount_class_id()));
				orderItemModel
						.setDistributionMethod(orderItemMap.getOrderhdr().getOrder_item(0).getDistribution_method());
				orderItemModel.setDuration(orderItemMap.getOrderhdr().getOrder_item(0).getDuration());
				orderItemModel
						.setElectronicDelivery(orderItemMap.getOrderhdr().getOrder_item(0).getElectronic_delivery());
				orderItemModel.setElectronicDocumentIdentifier(
						orderItemMap.getOrderhdr().getOrder_item(0).getElectronic_document_identifier());
				orderItemModel.setExRateClassEffectiveSeq(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getEx_rate_class_effective_seq()));
				orderItemModel.setExRateClassId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getEx_rate_class_id()));
				orderItemModel.setExRatecardSeq(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getEx_ratecard_seq()));
				orderItemModel
						.setExchangeRate(orderItemMap.getOrderhdr().getOrder_item(0).getExchange_rate().toString());
				orderItemModel.setExtIssleft(orderItemMap.getOrderhdr().getOrder_item(0).getExt_iss_left());
				orderItemModel.setExtIssTot(orderItemMap.getOrderhdr().getOrder_item(0).getExt_iss_tot());
				orderItemModel.setExtendedDays(orderItemMap.getOrderhdr().getOrder_item(0).getExtended_days());
				orderItemModel.setGroupOrder(orderItemMap.getOrderhdr().getOrder_item(0).getGroup_order());
				orderItemModel.setHasBeenRenewed(orderItemMap.getOrderhdr().getOrder_item(0).getHas_been_renewed());
				orderItemModel
						.setHasDeliveryCharge(orderItemMap.getOrderhdr().getOrder_item(0).getHas_delivery_charge());
				orderItemModel.setHasPremium(orderItemMap.getOrderhdr().getOrder_item(0).getHas_premium());
				orderItemModel.setHasTax(orderItemMap.getOrderhdr().getOrder_item(0).getHas_tax());
				orderItemModel
						.setInventoryId(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getInventory_id()));
				Date invoiceDate = orderItemMap.getOrderhdr().getOrder_item(0).getInvoice_date();
				SimpleDateFormat format3 = new SimpleDateFormat("MM/dd/yyyy");
				String dateFormatted3 = format3.format(invoiceDate.getTime());
				orderItemModel.setInvoiceDate(dateFormatted3);
				orderItemModel
						.setInvoiceId(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getInvoice_id()));
				orderItemModel.setIsBackOrdered(orderItemMap.getOrderhdr().getOrder_item(0).getIs_back_ordered());
				orderItemModel.setIsComplimentary(orderItemMap.getOrderhdr().getOrder_item(0).getIs_complimentary());
				orderItemModel.setIsProforma(orderItemMap.getOrderhdr().getOrder_item(0).getIs_proforma());
				orderItemModel.setItemUrl(orderItemMap.getOrderhdr().getOrder_item(0).getItem_url());

				orderItemModel.setMaxCheckOutAmt(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getMax_check_out_amt()));

				orderItemModel.setnCalUnitsPerSeg(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getN_cal_units_per_seg()));
				orderItemModel
						.setnCheckedOut(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getN_checked_out()));
				orderItemModel.setnDaysGraced(orderItemMap.getOrderhdr().getOrder_item(0).getN_days_graced());
				orderItemModel.setnDelIssLeft(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getN_del_iss_left()));
				orderItemModel
						.setnInvEffort(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getN_inv_efforts()));
				orderItemModel.setnNonPaidIssues(orderItemMap.getOrderhdr().getOrder_item(0).getN_nonpaid_issues());
				orderItemModel.setnRemainingNonPaidIssues(
						orderItemMap.getOrderhdr().getOrder_item(0).getN_remaining_nonpaid_issues());
				orderItemModel.setnRemainingPaidIssue(orderItemMap.getOrderhdr().getOrder_item(0).getN_remaining_paid_issues());
				orderItemModel.setnIssueLeft(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getN_issues_left()));
				orderItemModel
						.setnRenEffort(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getN_ren_effort()));
				orderItemModel.setnSegmentsLeft(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getN_segments_left()));
				orderItemModel.setnTax_updates(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getN_tax_updates()));
				orderItemModel.setNoteExist(orderItemMap.getOrderhdr().getOrder_item(0).getNote_exist());
				orderItemModel.setNumberVolumeSets(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getNumber_volume_sets()));
				orderItemModel.setOrderCategory(orderItemMap.getOrderhdr().getOrder_item(0).getOrder_category());
				int orderCodeId = orderItemMap.getOrderhdr().getOrder_item(0).getOrder_code_id();
				orderItemModel
						.setOrderCodeID(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getOrder_code_id()));
				
				Calendar date = orderItemMap.getOrderhdr().getOrder_item(0).getOrder_date().getInstance();
				SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
				String dateFormatted1 = format1.format(date.getTime());
				orderItemModel.setOrderDate(dateFormatted1);
				orderItemModel.setOrderItemType(orderItemMap.getOrderhdr().getOrder_item(0).getOrder_item_type());
				orderItemModel.setOrderQty(orderItemMap.getOrderhdr().getOrder_item(0).getOrder_qty());
				orderItemModel.setLocalAmount(orderItemMap.getOrderhdr().getOrder_item(0).getOrder_item_amt_break(0)
						.getLocal_amount().toString());
				orderItemModel.setBaseAmount(orderItemMap.getOrderhdr().getOrder_item(0).getOrder_item_amt_break(0)
						.getBase_amount().toString());
				orderItemModel
						.setState(orderItemMap.getOrderhdr().getOrder_item(0).getOrder_item_amt_break(0).getState());
				int Status = orderItemMap.getOrderhdr().getOrder_item(0).getOrder_status();
				String orderStatus = new PropertyUtilityClass().getConstantValue("order_item.order_status_"+Status);
				orderItemModel.setOrder_status(orderStatus);
				orderItemModel.setOrderStatus(Status);
				orderItemModel.setOrderType(orderItemMap.getOrderhdr().getOrder_item(0).getOrder_type());
				orderItemModel.setOrderCodeType(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getOrder_item_type()));
				orderItemModel.setOrigOrderQty(orderItemMap.getOrderhdr().getOrder_item(0).getOrig_order_qty());
				orderItemModel.setPackageContentSeq(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getPackage_content_seq()));
				orderItemModel
						.setPackageID(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getPackage_id()));
				orderItemModel.setPackageInstance(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getPackage_instance()));
				orderItemModel.setPackageContentSeq(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getPayment_account_seq()));
				int pStatus = orderItemMap.getOrderhdr().getOrder_item(0).getPayment_status();
				String payStatus = new PropertyUtilityClass().getConstantValue("order_item.pay_status_" + pStatus);
				orderItemModel.setPayment_status(payStatus);
				orderItemModel.setPercentOfBasicPrice(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getPercent_of_basic_price()));
				orderItemModel.setPerpetualOrder(orderItemMap.getOrderhdr().getOrder_item(0).getPerpetual_order());
				orderItemModel.setPkgDefId(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getPkg_def_id()));
				orderItemModel
						.setPkgItemSeq(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getPkg_item_seq()));
				orderItemModel.setPremToOrderItemSeq(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getPrem_to_order_item_seq()));
				orderItemModel.setPrepaymentReq(orderItemMap.getOrderhdr().getOrder_item(0).getPrepayment_req());
				orderItemModel
						.setProductId(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getProduct_id()));
				orderItemModel.setPubRotationId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getPub_rotation_id()));
				orderItemModel.setRateClassEffectiveSeq(
						orderItemMap.getOrderhdr().getOrder_item(0).getRate_class_effective_seq());
				orderItemModel.setRateClassId(orderItemMap.getOrderhdr().getOrder_item(0).getRate_class_id());
				int rateClassId = orderItemMap.getOrderhdr().getOrder_item(0).getRate_class_id();
				orderItemModel.setRefundStatus(orderItemMap.getOrderhdr().getOrder_item(0).getRefund_status());
				orderItemModel.setRenewToCustomerAddressSeq(
						orderItemMap.getOrderhdr().getOrder_item(0).getRenew_to_customer_address_seq());
				orderItemModel
						.setRenewToCustomerId(orderItemMap.getOrderhdr().getOrder_item(0).getRenew_to_customer_id());
				orderItemModel.setRenewalCategory(orderItemMap.getOrderhdr().getOrder_item(0).getRenewal_category());
				orderItemModel.setRenewalDef(orderItemMap.getOrderhdr().getOrder_item(0).getRenewal_def());
				orderItemModel.setRenewalDefTestSeq(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getRenewal_def_test_seq()));
				orderItemModel.setRenewalOrderItemSeq(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getRenewal_order_item_seq()));
				orderItemModel.setRenewalOrderhdrId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getRenewal_orderhdr_id()));
				orderItemModel.setRenewalStatus(orderItemMap.getOrderhdr().getOrder_item(0).getRenewal_status());
				orderItemModel.setRenewedFromSubscripId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getRenewed_from_subscrip_id()));
				orderItemModel.setRevenueMethod(orderItemMap.getOrderhdr().getOrder_item(0).getRevenue_method());
				orderItemModel.setServiceExist(orderItemMap.getOrderhdr().getOrder_item(0).getService_exist());
				orderItemModel.setShipQty(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getShip_qty()));
				orderItemModel
						.setShippingPriceList(orderItemMap.getOrderhdr().getOrder_item(0).getShipping_price_list());
				int sourceCodeId = orderItemMap.getOrderhdr().getOrder_item(0).getSource_code_id();
				orderItemModel.setSourceCodeID(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getSource_code_id()));
				Date startDate = orderItemMap.getOrderhdr().getOrder_item(0).getStart_date();
				SimpleDateFormat format4 = new SimpleDateFormat("MM/dd/yyyy");
				String dateFormatted4 = format4.format(startDate.getTime());
				orderItemModel.setStartDate(dateFormatted4);
				orderItemModel.setStartIssueId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getStart_issue_id()));
				orderItemModel.setStopIssueId(orderItemMap.getOrderhdr().getOrder_item(0).getStop_issue_id());
				orderItemModel
						.setSubscripId(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getSubscrip_id()));
				orderItemModel
						.setSubscripStartType(orderItemMap.getOrderhdr().getOrder_item(0).getSubscrip_start_type());
				orderItemModel.setSubscriptionDefId(
						String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getSubscription_def_id()));
				orderItemModel.setTimeUnitOptions(orderItemMap.getOrderhdr().getOrder_item(0).getTime_unit_options());
				orderItemModel.setTotalTaxBaseAmount(
						orderItemMap.getOrderhdr().getOrder_item(0).getTotal_tax_base_amount().toString());
				orderItemModel.setTotalTaxLocalAmount(
						orderItemMap.getOrderhdr().getOrder_item(0).getTotal_tax_local_amount().toString());
				orderItemModel
						.setTrialPeriod(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getTrial_period()));
				orderItemModel.setTrialType(orderItemMap.getOrderhdr().getOrder_item(0).getTrial_type());
				orderItemModel
						.setUnitExcess(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getUnit_excess()));
				orderItemModel
						.setUnitTypeId(String.valueOf(orderItemMap.getOrderhdr().getOrder_item(0).getUnit_type_id()));
				orderItemModel.setUserCode(orderItemMap.getOrderhdr().getOrder_item(0).getUser_code());
				orderItemModel.setAddress1(orderItemMap.getCustomer().getCustomer_address(0).getAddress1());
				int billToCustID= orderItemMap.getOrderhdr().getOrder_item(0).getBill_to_customer_id();
				int billToCustAddSeq=orderItemMap.getOrderhdr().getOrder_item(0).getBill_to_customer_address_seq();
				String add1 = jdbcTemplate.queryForObject("select address1 as address from customer_address where customer_id="+billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
				String add2 = jdbcTemplate.queryForObject("select address2 as address from customer_address where customer_id="+billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
				String add3 = jdbcTemplate.queryForObject("select address3 as address from customer_address where customer_id="+billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
				String cityState = jdbcTemplate.queryForObject("select concat(city, '  ' ,state) as address from customer_address where customer_id="+billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
				if(add1 == null && add2 == null && add3 == null ) {
					orderItemModel.setBillToCustomerAddress(cityState);
				}else {
					orderItemModel.setBillToCustomerAddress(String.valueOf(add1!=null?add1:"").concat(" ").concat( add2!=null?add2:"" ).concat(" ").concat(add3!=null?add3:""));
				}
				int renewToCustID= orderItemMap.getOrderhdr().getOrder_item(0).getRenew_to_customer_id();
				int renewToCustAddSeq=orderItemMap.getOrderhdr().getOrder_item(0).getRenew_to_customer_address_seq();
				String renAdd1 = jdbcTemplate.queryForObject("select address1 as address from customer_address where customer_id="+renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
				String renAdd2 = jdbcTemplate.queryForObject("select address2 as address from customer_address where customer_id="+renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
				String renAdd3 = jdbcTemplate.queryForObject("select address3 as address from customer_address where customer_id="+renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
				String renCityState = jdbcTemplate.queryForObject("select concat(city, '  ' ,state) as address from customer_address where customer_id="+renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
				if(renAdd1 == null && renAdd2 == null && renAdd3 == null ) {
					orderItemModel.setRenewToCustomerAddress(renCityState);
				}else {
					orderItemModel.setRenewToCustomerAddress(String.valueOf(renAdd1!=null?renAdd1:"").concat(" ").concat( renAdd2!=null?renAdd2:"" ).concat(" ").concat(renAdd3!=null?renAdd3:""));
				}
//				orderItemModel
//						.setBillToCustomerAddress(orderItemMap.getCustomer().getCustomer_address(0).getAddress1());
//				orderItemModel
//						.setRenewToCustomerAddress(orderItemMap.getCustomer().getCustomer_address(0).getAddress1());
//				orderItemModel.setCustomerAddressSeq(
//						orderItemMap.getCustomer().getCustomer_address(0).getCustomer_address_seq());
				orderItemModel.setUserCode(orderItemMap.getCustomer().getUser_code());
				String fname = jdbcTemplate.queryForObject(
						"select top 1 fname from customer_address where customer_id=" + customerId, String.class);
				orderItemModel.setFullName(fname);
				String fullname = jdbcTemplate.queryForObject(
						"select  top 1 (case when customer_address.fname is null then customer_address.company else customer_address.fname + ' ' + customer_address.lname end )as fullname from customer_address where customer_id="
								+ customerId,
						String.class);
				orderItemModel.setBillToFullName(fullname);
				orderItemModel.setRenewFullNameTo(fullname);
				String address = jdbcTemplate.queryForObject(
						"select top 1 fname from customer_address where customer_id=" + customerId, String.class);
				String orderCode = jdbcTemplate.queryForObject(
						"select order_code from order_code where order_code_id=" + orderCodeId, String.class);
				orderItemModel.setOrderCode(orderCode);
				String sourceCode = jdbcTemplate.queryForObject(
						"select source_code from source_code where source_code_id=" + sourceCodeId, String.class);
				orderItemModel.setSourceCode(sourceCode);
				String sourceDescription = jdbcTemplate.queryForObject(
						"select description from source_code where source_code_id=" + sourceCodeId, String.class);
				orderItemModel.setSourceCodeDescription(sourceDescription);
				String orderDescription = jdbcTemplate.queryForObject(
						"select description from order_code where order_code_id=" + orderCodeId, String.class);
				orderItemModel.setOrderCodeDescription(orderDescription);
				int orderCodeType = orderItemMap.getOrderhdr().getOrder_item(0).getOrder_item_type();
				String pageName = jdbcTemplate.queryForObject(
						"select top 1( case when ((start_type=0 or start_type=1) and order_code_type=0) then 'Issue Based Subscription' when ((start_type=0 or start_type=1) and order_code_type=1) then 'Single Copy' when order_code_type=4 then 'Package Edit'  when order_code_type=2 then 'Product' when ((start_type=4 or start_type=5) and order_code_type=0) then 'Unit Based Subscription' when order_code_type=8 then 'Shipping Price List'"
								+ " else 'Date Based Subscription' end)as pageName from order_code where order_code_id="
								+ orderCodeId,
						String.class);
				orderItemModel.setPageName(pageName);
				orderItemModel.setOcId(orderItemMap.getOrderhdr().getOrder_item(0).getOc_id());
				orderItemModel.setSubscripStartType(orderItemMap.getOrderhdr().getOrder_item(0).getSubscrip_start_type());
				int startType=jdbcTemplate.queryForObject("select start_type from order_code where order_code_id="+orderCodeId,Integer.class);
				orderItemModel.setStartType(startType);
				orderItemModel.setPaymentStatus(orderItemMap.getOrderhdr().getOrder_item(0).getPayment_status());
				int subscriptionDefID = orderItemMap.getOrderhdr().getOrder_item(0).getSubscription_def_id();
				if(orderCodeType==4 ) {
					Date expireDate = orderItemMap.getOrderhdr().getOrder_item(0).getExpire_date();
					SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
					String dateFormatted2 = format2.format(expireDate.getTime());
					orderItemModel.setExpireDate(dateFormatted2);
					int pkgId=orderItemMap.getOrderhdr().getOrder_item(0).getPkg_def_id();
					String pkgDef=jdbcTemplate.queryForObject("select pkg_def from pkg_def where pkg_def_id="+pkgId, String.class);
					orderItemModel.setPkgDef(pkgDef);
					orderItemModel.setSubscriptionDef(pkgDef);
					String pkgDefDesc=jdbcTemplate.queryForObject("select description from pkg_def where pkg_def_id="+pkgId, String.class);
					orderItemModel.setPkgDef(pkgDefDesc);
					}
				if(subscriptionDefID!=0) {
					Date expireDate = orderItemMap.getOrderhdr().getOrder_item(0).getExpire_date();
					SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
					String dateFormatted2 = format2.format(expireDate.getTime());
					orderItemModel.setExpireDate(dateFormatted2);
				String subscriptionDef = jdbcTemplate.queryForObject(
						"select subscription_def from subscription_def where subscription_def_id=" + subscriptionDefID,
						String.class);
				orderItemModel.setSubscriptionDef(subscriptionDef);
				String subscriptionDescrip = jdbcTemplate.queryForObject(
						"select description from subscription_def where subscription_def_id=" + subscriptionDefID,
						String.class);
				orderItemModel.setSubscriptionDefDescription(subscriptionDescrip);
				int subCatId= jdbcTemplate.queryForObject(
						"select subscription_category_id from subscription_def where subscription_def_id=" + subscriptionDefID,
						Integer.class);
				orderItemModel.setSubscriptionCategoryId(String.valueOf(subCatId));
				String term=jdbcTemplate.queryForObject("select term.term from term inner join subscription_def on term.term_id=subscription_def.term_id where subscription_def.subscription_def_id="+subscriptionDefID,String.class); 
				orderItemModel.setTermDescription(term);		
						
				String rateDesc = jdbcTemplate.queryForObject(
						"select top 1 description +' - '+ CONVERT(varchar,rate_class_effective.effective_date,101) as rateClassDescription  from rate_class_effective where rate_class_id="
								+ rateClassId,
						String.class);
				orderItemModel.setRateClassDescription(rateDesc);
				}
				if(Integer.parseInt(orderItem.getOrderCodeType())==1 && (Integer.parseInt(orderItem.getStartIssueId())!=0)) {
					Date issueDAte=jdbcTemplate.queryForObject("select issue_date from issue where issue_id="+orderItem.getStartIssueId(), Date.class);
					SimpleDateFormat issue = new SimpleDateFormat("MM/dd/yyyy");
					String issueFormat = issue.format(issueDAte.getTime());
					//orderItemModel.setEnumeration( issueFormat);
					String enumeration=jdbcTemplate.queryForObject("select enumeration from issue where issue_id="+orderItem.getStartIssueId(), String.class);
					orderItemModel.setEnumeration(enumeration);
				}
					
				/*Double renCommision=jdbcTemplate.queryForObject("select ren_commission from agency where customer_id="+customerId,Double.class);
				Double newCommision=jdbcTemplate.queryForObject("select new_commission from agency where customer_id="+customerId,Double.class);
				orderItemModel.setRen_commission(String.valueOf(renCommision));
				orderItemModel.setNew_commission(String.valueOf(newCommision));*/
				
			}
			System.out.println(orderItemModel);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return orderItemModel;
		}
		return orderItemModel;
	}
	@Override
	public Map<String, Object> getListDataForPkg(Integer orderhdrId) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> listDataForPkg = null;
		try {
			String query = "select orderhdr_id,order_item_seq from order_item where orderhdr_id=" + orderhdrId;
			int count = jdbcTemplate.queryForObject(
					"select count(orderhdr_id) from order_item where orderhdr_id=" + orderhdrId, Integer.class);
			count = count - 1;
			listDataForPkg = jdbcTemplate.queryForList(query.toString());
			responseObject.put("pkgMemberList", listDataForPkg);
			responseObject.put("pkgMemberListCount", count);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return responseObject;
		}
		return responseObject;
	}
	/**
	 * To Edit Package members and cancel members
	 * @author Chaman.Bharti
	 */
	@Override
	public String editPackage(OrderItem orderItem) {
		String status = null;
		List<OrderItem>packageMemberList = null;
		int updatedStatus = 0;
		List<Map<String, Object>> existingItermData=null;
		List<Map<String, Object>> existingItemBreakData=null;
		try {
			/**
			 * This isNullOrEmpty function is to handle null,0,"" for String type parameter to avoid NullPointerException
			 */
			Predicate<String> isNullOrEmpty = s-> (s != null && !s.equals("0")) && !s.trim().isEmpty();
			int orderItemType = orderItem.getOrderItemType();
			if(orderItemType == 4) {
				 existingItermData = getExistingOrderItemData(orderItem.getOrderhdrId(),orderItem.getOrderItemSeq());
				 if(existingItermData.size()==1) {
					 updatedStatus = updateOrderItemTable(orderItem,existingItermData);  
				 }
				 
				 if(updatedStatus > 0) {
					 //for order_item_amt_break_seq
					 Integer mru_order_item_amt_break_seq = jdbcTemplate.queryForObject(getQuery(orderItem.getOrderhdrId(),orderItem.getOrderItemSeq()), Integer.class);
					 orderItem.setOrder_item_amt_break_seq(mru_order_item_amt_break_seq!=null?mru_order_item_amt_break_seq:orderItem.getOrderItemSeq());
					 existingItemBreakData = getExistingOrderItemBreakData(orderItem.getOrderhdrId(),orderItem.getOrderItemSeq());
					 if(existingItemBreakData.size()==1) {
						 updatedStatus = updateOrderItemBreakTable(orderItem,existingItemBreakData); 
					 }
				 }
			 }
			// getting list of package members
			packageMemberList = orderItem.getPackageMemberList();
			if(packageMemberList.size() > 0) {
				 existingItermData = null;
				 existingItemBreakData = null;
				 for(OrderItem item: packageMemberList) {
				         existingItermData = getExistingOrderItemData(item.getOrderhdrId(),item.getOrderItemSeq());
				         if(existingItermData.size()==1) {
				        	 item.setDocumentReferenceId(orderItem.getDocumentReferenceId());
				        	 item.setUserCode(orderItem.getUserCode());
				        	 updatedStatus = updateOrderItemTable(item,existingItermData); 
				        	 existingItermData = null;
				        	 //storing existing subscrip table's data to update
				        	 if(isNullOrEmpty.test(item.getSubscripId())){
				        		 existingItermData = getExistingOrderItemData(orderItem.getOrderhdrId(),orderItem.getOrderItemSeq());
				        		 updateSubscripTable(item,existingItermData);
				        	 }
				        	 
						 }
				        
						 if(updatedStatus > 0) {
							 existingItemBreakData = getExistingOrderItemBreakData(item.getOrderhdrId(),item.getOrderItemSeq());
							 if(existingItemBreakData.size()==1) {
								 item.setDocumentReferenceId(orderItem.getDocumentReferenceId());
								 item.setUserCode(orderItem.getUserCode());
								 updatedStatus = updateOrderItemBreakTable(item,existingItemBreakData); 
							 }
						 }
						
				}
			}
			 if(updatedStatus > 0) {
				 status = "Updated"; 
			 }else {
				 status = "Not Updated"; 
			 }
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			LOGGER.info("editPackage(OrderItem orderItem): "+e);
			 status = "Not Updated due to exception";
		}
		return status;
	}

	private void updateSubscripTable(OrderItem item,List<Map<String, Object>> existingItemData) {
		StringBuilder query = new StringBuilder("update subscrip set ");
		Map<String,Object> parameter = new HashMap<>();
		int status = 0;
		List<EditTrail> toInsertEditTrailDeltaList = new ArrayList<>();
		EditTrail editTrail,editDelta = null;
		List<Map<String, Object>> existingSubscripData = null;
		try {
			  Predicate<String> isNullOrEmpty = s-> (s != null && !s.equals("0")) && !s.trim().isEmpty();
			  Function<Object,String>isNullOrNot = s1->s1==null?null:s1.toString();
			 
			 editTrail = new EditTrail(); 
			 editTrail.setCustomerId(item.getCustomerId());
			 editTrail.setUserCode(item.getUserCode()!=null?item.getUserCode():"THK");
			 if(isNullOrEmpty.test(item.getSubscripId())) {
				 editTrail.setSubscripId(Integer.valueOf(item.getSubscripId()));
			 }
			 editTrail.setEdited("1");//1 is update & 0 is add
			 editTrail.setTableEnum(8);//8 is Subscrip according data model
			 editTrail.setDocumentReferenceId(isNullOrEmpty.test(item.getDocumentReferenceId())?Integer.valueOf(item.getDocumentReferenceId()):1);
			 editTrail.setXactionName("package_edit_request");
			 existingSubscripData = getSubscripDetails(Integer.valueOf(item.getSubscripId()));
			if(existingSubscripData.size() != 0 && existingItemData.size() != 0) {
				query.append("n_total_issues_left = :n_total_issues_left,");
				parameter.put("n_total_issues_left",existingItemData.get(0).get("n_issues_left"));
				//toInsertEditTrailDeltaList to edit trail delta table
				editDelta = new EditTrail();
				editDelta.setColumnName("n_total_issues_left");
				editDelta.setBeforeChange(isNullOrNot.apply(existingSubscripData.get(0).get("n_total_issues_left")));
				editDelta.setAfterChange(isNullOrNot.apply(existingItemData.get(0).get("n_issues_left")));
			    toInsertEditTrailDeltaList.add(editDelta);
				    
				query.append("start_issue_id = :start_issue_id,");
				parameter.put("start_issue_id",existingItemData.get(0).get("start_issue_id"));
				//toInsertEditTrailDeltaList to edit trail delta table
				editDelta = new EditTrail();
				editDelta.setColumnName("start_issue_id");
				editDelta.setBeforeChange(isNullOrNot.apply(existingSubscripData.get(0).get("start_issue_id")));
				editDelta.setAfterChange(isNullOrNot.apply(existingItemData.get(0).get("start_issue_id")));
			    toInsertEditTrailDeltaList.add(editDelta);
			    
			    query.append("stop_issue_id = :stop_issue_id");
				parameter.put("stop_issue_id",existingItemData.get(0).get("stop_issue_id"));
				//toInsertEditTrailDeltaList to edit trail delta table
				editDelta = new EditTrail();
				editDelta.setColumnName("stop_issue_id");
				editDelta.setBeforeChange(isNullOrNot.apply(existingSubscripData.get(0).get("stop_issue_id")));
				editDelta.setAfterChange(isNullOrNot.apply(existingItemData.get(0).get("stop_issue_id")));
			    toInsertEditTrailDeltaList.add(editDelta);
			}
			 query.append(" where subscrip_id=").append(item.getSubscripId());
				status = namedParameterJdbcTemplate.update(query.toString(), parameter);
				if(status>0) {
					long edit_trail_id = customerUtility.saveEditTrail(editTrail);
					//insert data into edit trail delta using batch
	    			 customerUtility.insertEditTrailDeltaByBatch(toInsertEditTrailDeltaList, edit_trail_id);
				}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		
	}

	private String getQuery(long orderhdrId, int orderItemSeq) {
		String finalQuery = null;
		try {
				StringBuilder query = new StringBuilder("select case when mru_order_item_amt_break_seq =(select mru_order_item_amt_break_seq from order_item where orderhdr_id=").append(orderhdrId);
				query.append(" and order_item_seq=").append(orderItemSeq).append(")");
				query.append(" then mru_order_item_amt_break_seq else null");
				query.append(" end as mru_order_item_amt_break_seq");
				query.append(" from order_item where orderhdr_id=").append(orderhdrId).append(" and order_item_seq=").append(orderItemSeq);
				finalQuery = query.toString();
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			LOGGER.info("getQuery(long orderhdrId, int orderItemSeq): "+e);
		}
		return finalQuery;
	}
	/**
	 * To update OrderItem Break Amount Table
	 * @author Chaman.Bharti
	 */
	private int updateOrderItemBreakTable(OrderItem item,List<Map<String, Object>> row) {
		StringBuilder query = new StringBuilder("update order_item_amt_break set ");
		Map<String,Object> parameter = new HashMap<>();
		int status = 0;
		List<EditTrail> toInsertEditTrailDeltaList = new ArrayList<>();
		EditTrail editTrail,editDelta = null;
		try {
			   
				/**
				 * isNullOrEmpty checks s has null," " (whitespace) and "" (blank) value
				 */
				 //Predicate<String> isNullOrEmpty = s-> s != null && !s.trim().isEmpty();
			 	   Predicate<String> isNullOrEmpty = s-> (s != null && !s.equals("0")) && !s.trim().isEmpty();
			 	   Function<Object,String> isNullOrNot = s1->s1==null?null:s1.toString();
				 editTrail = new EditTrail(); 
				 editTrail.setUserCode(item.getUserCode()!=null?item.getUserCode():"THK");
				 editTrail.setOrderhdrId((int)item.getOrderhdrId());
				 editTrail.setOrderItemSeq((item.getOrderItemSeq()));
				 editTrail.setOrderItemAmtBreakSeq(row.get(0).get("order_item_amt_break_seq")!=null?(Integer)row.get(0).get("order_item_amt_break_seq"):null);
				 editTrail.setEdited("1");//1 is update & 0 is add
				 editTrail.setTableEnum(6);//6 is Order Item Amount Break according data model
				 editTrail.setDocumentReferenceId(item.getDocumentReferenceId()!=null?Integer.valueOf(item.getDocumentReferenceId()):1);
				 editTrail.setXactionName("package_edit_request");
				 if(isNullOrEmpty.test(item.getBaseAmount())) {
					 if(!(item.getBaseAmount().equals(row.get(0).get("base_amount")))) {
							query.append("base_amount = :base_amount,");
							parameter.put("base_amount",getAmountValue(item.getBaseAmount()));
							
							//add to list to insert edit trail and edit trail delta table
							editTrail.setBaseAmount(getAmountValue(item.getBaseAmount()));
							
							editDelta = new EditTrail();
							editDelta.setColumnName("base_amount");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("base_amount")));
							editDelta.setAfterChange(item.getBaseAmount());
						    toInsertEditTrailDeltaList.add(editDelta);
						}
				 }if(isNullOrEmpty.test(item.getEffective_date())) {
					 if(!item.getEffective_date().equals(customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("effective_date"))))) {
							query.append("effective_date = :effective_date,");
							parameter.put("effective_date",item.getEffective_date());
							editDelta = new EditTrail();
							editDelta.setColumnName("effective_date");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("effective_date")));
							editDelta.setAfterChange(item.getEffective_date());
						    toInsertEditTrailDeltaList.add(editDelta);
						}
				 }if(item.getJurisdiction_seq()!=0) {
					 if(!String.valueOf(item.getJurisdiction_seq()).equals(row.get(0).get("jurisdiction_seq"))) {
							query.append("jurisdiction_seq = :jurisdiction_seq,");
							parameter.put("jurisdiction_seq",item.getJurisdiction_seq());
							editDelta = new EditTrail();
							editDelta.setColumnName("jurisdiction_seq");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("jurisdiction_seq")));
							editDelta.setAfterChange(String.valueOf(item.getJurisdiction_seq()));
						    toInsertEditTrailDeltaList.add(editDelta);
					}
				 }if(isNullOrEmpty.test(item.getLocalAmount())) {
					 if(!item.getLocalAmount().equals(row.get(0).get("base_amount"))) {
						    query.append("local_amount = :local_amount,");
							parameter.put("local_amount",getAmountValue(item.getLocalAmount()));
							editTrail.setLocalAmount(getAmountValue(item.getLocalAmount()));
							
							editDelta = new EditTrail();
							editDelta.setColumnName("local_amount");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("local_amount")));
							editDelta.setAfterChange(item.getLocalAmount());
						    toInsertEditTrailDeltaList.add(editDelta);
						}
				 }if(item.getOrder_item_break_type()!=0) {
					 if(!String.valueOf(item.getOrder_item_break_type()).equals(row.get(0).get("order_item_break_type"))) {
							query.append("order_item_break_type = :order_item_break_type,");
							parameter.put("order_item_break_type",item.getOrder_item_break_type());
							editDelta = new EditTrail();
							editDelta.setColumnName("order_item_break_type");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("order_item_break_type")));
							editDelta.setAfterChange(String.valueOf(item.getOrder_item_break_type()));
						    toInsertEditTrailDeltaList.add(editDelta);
						}
				 }if(isNullOrEmpty.test(item.getOrig_base_amount())) {
					 if(!item.getOrig_base_amount().equals(row.get(0).get("orig_base_amount"))) {
							query.append("orig_base_amount = :orig_base_amount,");
							parameter.put("orig_base_amount",getAmountValue(item.getOrig_base_amount()));
							editDelta = new EditTrail();
							editDelta.setColumnName("orig_base_amount");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("orig_base_amount")));
							editDelta.setAfterChange(item.getOrig_base_amount());
						    toInsertEditTrailDeltaList.add(editDelta);
						} 
				 }if(isNullOrEmpty.test(item.getState())) {
					 if(!item.getState().equals(row.get(0).get("state"))) {
							query.append("state = :state,");
							parameter.put("state",item.getState());
							editDelta = new EditTrail();
							editDelta.setColumnName("state");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("state")));
							editDelta.setAfterChange(item.getState());
						    toInsertEditTrailDeltaList.add(editDelta);
						}
				 }if(item.getTax_active()!=0) {
					 if(!String.valueOf(item.getTax_active()).equals(row.get(0).get("tax_active"))) {
							query.append("tax_active = :tax_active,");
							parameter.put("tax_active",item.getTax_active());
							editDelta = new EditTrail();
							editDelta.setColumnName("tax_active");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("tax_active")));
							editDelta.setAfterChange(String.valueOf(item.getTax_active()));
						    toInsertEditTrailDeltaList.add(editDelta);
						} 
				 }if(item.getTax_delivery()!=0) {
					 if(!String.valueOf(item.getTax_delivery()).equals(row.get(0).get("tax_delivery"))) {
							query.append("tax_delivery = :tax_delivery,");
							parameter.put("tax_delivery",item.getTax_delivery());
							editDelta = new EditTrail();
							editDelta.setColumnName("tax_delivery");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("tax_delivery")));
							editDelta.setAfterChange(String.valueOf(item.getTax_delivery()));
						    toInsertEditTrailDeltaList.add(editDelta);
						}
				 }if(isNullOrEmpty.test(item.getTax_rate())) {
					 if(!item.getTax_rate().equals(row.get(0).get("tax_rate"))) {
							query.append("tax_rate = :tax_rate,");
							parameter.put("tax_rate",getAmountValue(item.getTax_rate()));
							editDelta = new EditTrail();
							editDelta.setColumnName("tax_rate");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("tax_rate")));
							editDelta.setAfterChange(item.getTax_rate());
						    toInsertEditTrailDeltaList.add(editDelta);
						} 
				 }if(isNullOrEmpty.test(item.getTax_rate_category())) {
					 if(!item.getTax_rate_category().equals(row.get(0).get("tax_rate_category"))) {
							query.append("tax_rate_category = :tax_rate_category,");
							parameter.put("tax_rate_category",item.getTax_rate_category());
							editDelta = new EditTrail();
							editDelta.setColumnName("tax_rate_category");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("tax_rate_category")));
							editDelta.setAfterChange(item.getTax_rate_category());
						    toInsertEditTrailDeltaList.add(editDelta);
						}
				 }if(isNullOrEmpty.test(item.getTax_type())) {
					 if(!item.getTax_type().equals(row.get(0).get("tax_type"))) {
							query.append("tax_type = :tax_type,");
							parameter.put("tax_type",item.getTax_type());
							editDelta = new EditTrail();
							editDelta.setColumnName("tax_type");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("tax_type")));
							editDelta.setAfterChange(item.getTax_type());
						    toInsertEditTrailDeltaList.add(editDelta);
						}
				 }if(item.getTx_incl()!=0) {
					 if(!String.valueOf(item.getTx_incl()).equals(row.get(0).get("tx_incl"))) {
							query.append("tx_incl = :tx_incl,");
							parameter.put("tx_incl",item.getTx_incl());
							editDelta = new EditTrail();
							editDelta.setColumnName("tx_incl");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("tx_incl")));
							editDelta.setAfterChange(String.valueOf(item.getTx_incl()));
						    toInsertEditTrailDeltaList.add(editDelta);
						} 
				 }if(isNullOrEmpty.test(item.getVrtx_jurisdiction())) {
					 if(!item.getVrtx_jurisdiction().equals(row.get(0).get("vrtx_jurisdiction"))) {
							query.append("vrtx_jurisdiction = :vrtx_jurisdiction,");
							parameter.put("vrtx_jurisdiction",item.getVrtx_jurisdiction());
							editDelta = new EditTrail();
							editDelta.setColumnName("vrtx_jurisdiction");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("vrtx_jurisdiction")));
							editDelta.setAfterChange(String.valueOf(item.getVrtx_jurisdiction()));
						    toInsertEditTrailDeltaList.add(editDelta);
						}  
				 }if(isNullOrEmpty.test(item.getVrtx_jurisdiction_level())) {
					 if(!item.getVrtx_jurisdiction_level().equals(row.get(0).get("vrtx_jurisdiction_level"))) {
							query.append("vrtx_jurisdiction_level = :vrtx_jurisdiction_level,");
							parameter.put("vrtx_jurisdiction_level",item.getVrtx_jurisdiction_level());
							editDelta = new EditTrail();
							editDelta.setColumnName("vrtx_jurisdiction_level");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("vrtx_jurisdiction_level")));
							editDelta.setAfterChange(String.valueOf(item.getVrtx_jurisdiction_level()));
						    toInsertEditTrailDeltaList.add(editDelta);
						}  
				 }if(isNullOrEmpty.test(item.getVrtx_tax_type())) {
					 if(!item.getVrtx_tax_type().equals(row.get(0).get("vrtx_tax_type"))) {
							query.append("vrtx_tax_type  = :vrtx_tax_type,");
							parameter.put("vrtx_tax_type ",item.getVrtx_tax_type());
							editDelta = new EditTrail();
							editDelta.setColumnName("vrtx_tax_type");
							editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("vrtx_tax_type")));
							editDelta.setAfterChange(String.valueOf(item.getVrtx_tax_type()));
						    toInsertEditTrailDeltaList.add(editDelta);
						} 
				 }
				
				if(query.length() > 0) {
					int lastIndexOfComma = query.lastIndexOf(",");
					query.deleteCharAt(lastIndexOfComma);
				}
				query.append(" where orderhdr_id=").append(item.getOrderhdrId()).append(" and order_item_seq=").append(item.getOrderItemSeq());//.append(" and order_item_amt_break_seq=").append(item.getOrder_item_amt_break_seq());
				status = namedParameterJdbcTemplate.update(query.toString(), parameter);
				if(status>0) {
					long edit_trail_id = customerUtility.saveEditTrail(editTrail);
					//insert data into edit trail delta using batch
	    			 customerUtility.insertEditTrailDeltaByBatch(toInsertEditTrailDeltaList, edit_trail_id);
				}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			LOGGER.info("updateOrderItemBreakTable(OrderItem item,List<Map<String, Object>> row): "+e);
		}
		return status;
	}
	/**
	 * To update OrderItem Table
	 * @author Chaman.Bharti
	 */
		private int updateOrderItemTable(OrderItem item, List<Map<String, Object>> row) {
		StringBuilder query = new StringBuilder("update order_item set ");
		Map<String,Object> parameter = new LinkedHashMap<>();
		int status = 0;
		List<EditTrail> toInsertEditTrailDeltaList = new ArrayList<>();
		EditTrail editTrail,editDelta = null;
		try {
				/**
				 * isNullOrEmpty checks s has null," " (whitespace) and "" (blank) value
				 */
				 Predicate<String> isNullOrEmpty = s-> (s != null && !s.equals("0")) && !s.trim().isEmpty();
				 BiPredicate<String,String> isEquals = (a,b) -> a.equals(b);
				 Function<Object,String>isNullOrNot = s1->s1==null?null:s1.toString();
				 
				 editTrail = new EditTrail(); 
				 //customerId and customerAddressSeq is required for orderItem update
				 editTrail.setCustomerId(item.getCustomerId());
				 editTrail.setCustomerAddressSeq(item.getCustomerAddressSeq());
				 editTrail.setUserCode(item.getUserCode()!=null?item.getUserCode():"THK");
				 editTrail.setSubscripId(item.getSubscripId()!=null?Integer.valueOf(item.getSubscripId()):null);
				 editTrail.setOrderhdrId((int)item.getOrderhdrId());
				 editTrail.setOrderItemSeq((item.getOrderItemSeq()));
				 editTrail.setEdited("1");//1 is update & 0 is add
				 editTrail.setCurrency(item.getCurrency());
				 editTrail.setTableEnum(3);//3 is Order Item according to data model
				 editTrail.setDocumentReferenceId(item.getDocumentReferenceId()!=null?Integer.valueOf(item.getDocumentReferenceId()):1);
				 editTrail.setXactionName("package_edit_request");
				 if(isNullOrEmpty.test(item.getAddonToOrderItemSeq())) {
					 if(isEquals.negate().test(item.getAddonToOrderItemSeq(),isNullOrNot.apply(row.get(0).get("addon_to_order_item_seq")))) {
						query.append("addon_to_order_item_seq = :addon_to_order_item_seq,");
						parameter.put("addon_to_order_item_seq",item.getAddonToOrderItemSeq());
						
						//add to list to insert edit trail and edit trail delta table
						editDelta = new EditTrail();
						editDelta.setColumnName("addon_to_order_item_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("addon_to_order_item_seq")));
						editDelta.setAfterChange(item.getAddonToOrderItemSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				 }if(isNullOrEmpty.test(item.getAddonToOrderhdrId())) {
				   if(isEquals.negate().test(item.getAddonToOrderhdrId(),isNullOrNot.apply(row.get(0).get("addon_to_orderhdr_id")))) {
					query.append("addon_to_orderhdr_id = :addon_to_orderhdr_id,");
					parameter.put("addon_to_orderhdr_id",item.getAddonToOrderhdrId());
					editDelta = new EditTrail();
					editDelta.setColumnName("addon_to_orderhdr_id");
					editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("addon_to_orderhdr_id")));
					editDelta.setAfterChange(item.getAddonToOrderhdrId());
				    toInsertEditTrailDeltaList.add(editDelta);
				  }
				}if(isNullOrEmpty.test(item.getAgencyCustomerId())) {
					if(isEquals.negate().test(item.getAgencyCustomerId(),isNullOrNot.apply(row.get(0).get("agency_customer_id")))) {
						query.append("agency_customer_id =:agency_customer_id,");
						parameter.put("agency_customer_id",item.getAgencyCustomerId());
						editDelta = new EditTrail();
						editDelta.setColumnName("addon_to_orderhdr_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("addon_to_orderhdr_id")));
						editDelta.setAfterChange(item.getAddonToOrderhdrId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getAgencyRefNbr())) {
					if(isEquals.negate().test(item.getAgencyRefNbr(),isNullOrNot.apply(row.get(0).get("agent_ref_nbr")))) {
						query.append("agent_ref_nbr = :agent_ref_nbr,");
						parameter.put("agent_ref_nbr",item.getAgencyRefNbr());
						editDelta = new EditTrail();
						editDelta.setColumnName("agent_ref_nbr");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("agent_ref_nbr")));
						editDelta.setAfterChange(item.getAgencyRefNbr());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getAltShipCustomerAddressSeq()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getAltShipCustomerAddressSeq()), isNullOrNot.apply(row.get(0).get("alt_ship_customer_address_seq")))) {
						query.append("alt_ship_customer_address_seq = :alt_ship_customer_address_seq,");
						parameter.put("alt_ship_customer_address_seq",item.getAltShipCustomerAddressSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("alt_ship_customer_address_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("alt_ship_customer_address_seq")));
						editDelta.setAfterChange(String.valueOf(item.getAltShipCustomerAddressSeq()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getAltShipCustomerId()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getAltShipCustomerId()), isNullOrNot.apply(row.get(0).get("alt_ship_customer_id")))) {
						query.append("alt_ship_customer_id =:alt_ship_customer_id,");
						parameter.put("alt_ship_customer_id",item.getAltShipCustomerId());
						editDelta = new EditTrail();
						editDelta.setColumnName("alt_ship_customer_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("alt_ship_customer_id")));
						editDelta.setAfterChange(String.valueOf(item.getAltShipCustomerId()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getAltShipDelCalc())) {
					if(isEquals.negate().test(item.getAltShipDelCalc(), isNullOrNot.apply(row.get(0).get("alt_ship_del_calc")))) {
						query.append("alt_ship_del_calc = :alt_ship_del_calc,");
						parameter.put("alt_ship_del_calc",item.getAltShipDelCalc());
						editDelta = new EditTrail();
						editDelta.setColumnName("alt_ship_del_calc");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("alt_ship_del_calc")));
						editDelta.setAfterChange(item.getAltShipDelCalc());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getAsynchronousAutoRenew()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getAsynchronousAutoRenew()), isNullOrNot.apply(row.get(0).get("asynchronous_auto_renew")))) {
						query.append("asynchronous_auto_renew = :asynchronous_auto_renew,");
						parameter.put("asynchronous_auto_renew",item.getAsynchronousAutoRenew());
						editDelta = new EditTrail();
						editDelta.setColumnName("asynchronous_auto_renew");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("asynchronous_auto_renew")));
						editDelta.setAfterChange(String.valueOf(item.getAsynchronousAutoRenew()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getAttachExist())) {
					if(isEquals.negate().test(item.getAttachExist(),isNullOrNot.apply(row.get(0).get("attach_exist")))) {
						query.append("attach_exist =:attach_exist,");
						parameter.put("attach_exist",item.getAttachExist());
						editDelta = new EditTrail();
						editDelta.setColumnName("attach_exist");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("attach_exist")));
						editDelta.setAfterChange(String.valueOf(item.getAttachExist()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getAuditNameTitleId())) {
					if(isEquals.negate().test(item.getAuditNameTitleId(),isNullOrNot.apply(row.get(0).get("audit_name_title_id")))) {
						query.append("audit_name_title_id = :audit_name_title_id,");
						parameter.put("audit_name_title_id",item.getAuditNameTitleId());
						editDelta = new EditTrail();
						editDelta.setColumnName("audit_name_title_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("audit_name_title_id")));
						editDelta.setAfterChange(item.getAuditNameTitleId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getAuditQualCategory())) {
					if(isEquals.negate().test(item.getAuditQualCategory(),isNullOrNot.apply(row.get(0).get("audit_qual_category")))) {
						query.append("audit_qual_category = :audit_qual_category,");
						parameter.put("audit_qual_category",item.getAuditQualCategory());
						editDelta = new EditTrail();
						editDelta.setColumnName("audit_qual_category");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("audit_qual_category")));
						editDelta.setAfterChange(item.getAuditQualCategory());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getAuditSourceId())) {
					if(isEquals.negate().test(item.getAuditSourceId(),isNullOrNot.apply(row.get(0).get("audit_qual_source_id")))) {
						query.append("audit_qual_source_id =:audit_qual_source_id,");
						parameter.put("audit_qual_source_id",item.getAuditSourceId());
						editDelta = new EditTrail();
						editDelta.setColumnName("audit_qual_source_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("audit_qual_source_id")));
						editDelta.setAfterChange(item.getAuditSourceId());
						toInsertEditTrailDeltaList.add(editDelta);  
				     }
				}if(isNullOrEmpty.test(item.getAuditSalesChannelId())) {
					if(isEquals.negate().test(item.getAuditSalesChannelId(),isNullOrNot.apply(row.get(0).get("audit_sales_channel_id")))) {
						query.append("audit_sales_channel_id = :audit_sales_channel_id,");
						parameter.put("audit_sales_channel_id",item.getAuditSalesChannelId());
						editDelta = new EditTrail();
						editDelta.setColumnName("audit_sales_channel_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("audit_sales_channel_id")));
						editDelta.setAfterChange(item.getAuditSalesChannelId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getAuditSubscriptionTypeId())) {
					if(isEquals.negate().test(item.getAuditSubscriptionTypeId(),isNullOrNot.apply(row.get(0).get("audit_subscription_type_id")))) {
						query.append("audit_subscription_type_id = :audit_subscription_type_id,");
						parameter.put("audit_subscription_type_id",item.getAuditSubscriptionTypeId());
						editDelta = new EditTrail();
						editDelta.setColumnName("audit_subscription_type_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("audit_subscription_type_id")));
						editDelta.setAfterChange(item.getAuditSubscriptionTypeId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getAutoPayment()!=0 && row.get(0).get("auto_payment")!=null) {
					if(isEquals.negate().test(String.valueOf(item.getAutoPayment()),isNullOrNot.apply(row.get(0).get("auto_payment")))) {
						query.append("auto_payment =:auto_payment,");
						parameter.put("auto_payment",item.getAutoPayment());
						editDelta = new EditTrail();
						editDelta.setColumnName("auto_payment");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("auto_payment")));
						editDelta.setAfterChange(String.valueOf(item.getAutoPayment()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}	
				}if(item.getAutoRenewNotifySent()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getAutoRenewNotifySent()),isNullOrNot.apply(row.get(0).get("auto_renew_notify_sent")))) {
						query.append("auto_renew_notify_sent = :auto_renew_notify_sent,");
						parameter.put("auto_renew_notify_sent",item.getAutoRenewNotifySent());
						editDelta = new EditTrail();
						editDelta.setColumnName("auto_renew_notify_sent");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("auto_renew_notify_sent")));
						editDelta.setAfterChange(String.valueOf(item.getAutoRenewNotifySent()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getBackordQty())) {
					if(isEquals.negate().test(item.getBackordQty(),isNullOrNot.apply(row.get(0).get("backord_qty")))) {
						query.append("backord_qty = :backord_qty,");
						parameter.put("backord_qty",item.getBackordQty());
						editDelta = new EditTrail();
						editDelta.setColumnName("backord_qty");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("backord_qty")));
						editDelta.setAfterChange(item.getBackordQty());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getBillDate())) {
					if(isEquals.negate().test(item.getBillDate(),customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("bill_date"))))) {
						query.append("bill_date =:bill_date,");
						parameter.put("bill_date",item.getBillDate());
						editDelta = new EditTrail();
						editDelta.setColumnName("bill_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("bill_date")));
						editDelta.setAfterChange(item.getBillDate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getBillToCustomerAddressSeq()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getBillToCustomerAddressSeq()),isNullOrNot.apply(row.get(0).get("bill_to_customer_address_seq")))) {
						query.append("bill_to_customer_address_seq = :bill_to_customer_address_seq,");
						parameter.put("bill_to_customer_address_seq",item.getBillToCustomerAddressSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("bill_to_customer_address_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("bill_to_customer_address_seq")));
						editDelta.setAfterChange(String.valueOf(item.getBillToCustomerAddressSeq()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getBillToCustomerId()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getBillToCustomerId()),isNullOrNot.apply(row.get(0).get("bill_to_customer_id")))) {
						query.append("bill_to_customer_id = :bill_to_customer_id,");
						parameter.put("bill_to_customer_id",item.getBillToCustomerId());
						editDelta = new EditTrail();
						editDelta.setColumnName("bill_to_customer_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("bill_to_customer_id")));
						editDelta.setAfterChange(String.valueOf(item.getBillToCustomerId()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getBillingDef())) {
					if(isEquals.negate().test(item.getBillingDef(),isNullOrNot.apply(row.get(0).get("billing_def")))) {
						query.append("billing_def =:billing_def,");
						parameter.put("billing_def",item.getBillingDef());
						editDelta = new EditTrail();
						editDelta.setColumnName("billing_def");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("billing_def")));
						editDelta.setAfterChange(item.getBillingDef());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getBillingDefTestSeq())) {
					if(isEquals.negate().test(item.getBillingDefTestSeq(),isNullOrNot.apply(row.get(0).get("billing_def_test_seq")))) {
						query.append("billing_def_test_seq = :billing_def_test_seq,");
						parameter.put("billing_def_test_seq",item.getBillingDefTestSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("billing_def_test_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("billing_def_test_seq")));
						editDelta.setAfterChange(String.valueOf(item.getBillingDefTestSeq()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}
				Function<String,String> billingType=i->i.equals("Balance Due")?"1":i.equals("Installment Billing")?"2":"0";
				if(isNullOrEmpty.test(item.getBillingType())) {
					if(isEquals.negate().test(billingType.apply(item.getBillingType()),isNullOrNot.apply(row.get(0).get("billing_type")))) {
						query.append("billing_type =:billing_type,");
						parameter.put("billing_type",billingType.apply(item.getBillingType()));
						editDelta = new EditTrail();
						editDelta.setColumnName("billing_type");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("billing_type")));
						editDelta.setAfterChange(billingType.apply(item.getBillingType()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getBundleQty()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getBillToCustomerAddressSeq()),isNullOrNot.apply(row.get(0).get("bundle_qty")))) {
						query.append("bundle_qty = :bundle_qty,");
						parameter.put("bundle_qty",item.getBundleQty());
						editDelta = new EditTrail();
						editDelta.setColumnName("bundle_qty");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("bundle_qty")));
						editDelta.setAfterChange(String.valueOf(item.getBundleQty()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getCalendarUnit())) {
					if(isEquals.negate().test(item.getCalendarUnit(),isNullOrNot.apply(row.get(0).get("calendar_unit")))) {
						query.append("calendar_unit = :calendar_unit,");
						parameter.put("calendar_unit",item.getCalendarUnit());
						editDelta = new EditTrail();
						editDelta.setColumnName("calendar_unit");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("calendar_unit")));
						editDelta.setAfterChange(item.getCalendarUnit());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getCancelDD())) {
					if(isEquals.negate().test(item.getCancelDD(), customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("cancel_date"))))) {
						query.append("cancel_date =:cancel_date,");
						parameter.put("cancel_date",item.getCancelDD());
						editDelta = new EditTrail();
						editDelta.setColumnName("cancel_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("cancel_date")));
						editDelta.setAfterChange(item.getCancelDD());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getCancelReason())) {
					if(isEquals.negate().test(item.getCancelReason(),isNullOrNot.apply(row.get(0).get("cancel_reason")))) {
						query.append("cancel_reason = :cancel_reason,");
						parameter.put("cancel_reason",item.getCancelReason());
						editDelta = new EditTrail();
						editDelta.setColumnName("cancel_reason");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("cancel_reason")));
						editDelta.setAfterChange(item.getCancelReason());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getChangeQtyFlag()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getChangeQtyFlag()),isNullOrNot.apply(row.get(0).get("change_qty_flag")))) {
						query.append("change_qty_flag = :change_qty_flag,");
						parameter.put("change_qty_flag",item.getChangeQtyFlag());
						editDelta = new EditTrail();
						editDelta.setColumnName("change_qty_flag");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("change_qty_flag")));
						editDelta.setAfterChange(String.valueOf(item.getChangeQtyFlag()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getChargeOnCancellation())) {
					if(isEquals.negate().test(item.getChargeOnCancellation(),isNullOrNot.apply(row.get(0).get("charge_on_cancellation")))) {
						query.append("charge_on_cancellation =:charge_on_cancellation,");
						parameter.put("charge_on_cancellation",item.getChargeOnCancellation());
						editDelta = new EditTrail();
						editDelta.setColumnName("charge_on_cancellation");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("charge_on_cancellation")));
						editDelta.setAfterChange(item.getChargeOnCancellation());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getCurrency())) {
					if(isEquals.negate().test(item.getCurrency(),isNullOrNot.apply(row.get(0).get("currency")))) {
						query.append("currency = :currency,");
						parameter.put("currency",item.getCurrency());
						editDelta = new EditTrail();
						editDelta.setColumnName("currency");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("currency")));
						editDelta.setAfterChange(item.getCurrency());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getCustomerAddressSeq()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getCustomerAddressSeq()),isNullOrNot.apply(row.get(0).get("customer_address_seq")))) {
						query.append("customer_address_seq = :customer_address_seq,");
						parameter.put("customer_address_seq",item.getCustomerAddressSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("customer_address_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("customer_address_seq")));
						editDelta.setAfterChange(String.valueOf(item.getCustomerAddressSeq()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getCustomerGroupId())) {
					if(isEquals.negate().test(item.getCustomerGroupId(),isNullOrNot.apply(row.get(0).get("customer_group_id")))) {
						query.append("customer_group_id =:customer_group_id,");
						parameter.put("customer_group_id",item.getCustomerGroupId());
						editDelta = new EditTrail();
						editDelta.setColumnName("customer_group_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("customer_group_id")));
						editDelta.setAfterChange(item.getCustomerGroupId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getCustomerId()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getCustomerId()),isNullOrNot.apply(row.get(0).get("customer_id")))) {
						query.append("customer_id = :customer_id,");
						parameter.put("customer_id",item.getCustomerId());
						editDelta = new EditTrail();
						editDelta.setColumnName("customer_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("customer_id")));
						editDelta.setAfterChange(String.valueOf(item.getCustomerId()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getDealId())) {
					if(isEquals.negate().test(item.getDealId(),isNullOrNot.apply(row.get(0).get("deal_id")))) {
						query.append("deal_id =:deal_id,");
						parameter.put("deal_id",item.getDealId());
						editDelta = new EditTrail();
						editDelta.setColumnName("deal_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("deal_id")));
						editDelta.setAfterChange(item.getDealId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}
//				if(item.getDateStamp()!=0) {
//					query.append("date_stamp = :date_stamp,");
//					parameter.put("date_stamp",item.getDateStamp());
//				}
				if(isNullOrEmpty.test(item.getDeliveryMethod())) {
					if(isEquals.negate().test(item.getDeliveryMethod(),isNullOrNot.apply(row.get(0).get("delivery_method")))) {
						query.append("delivery_method = :delivery_method,");
						parameter.put("delivery_method",item.getDeliveryMethod());
						editDelta = new EditTrail();
						editDelta.setColumnName("delivery_method");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("delivery_method")));
						editDelta.setAfterChange(item.getDeliveryMethod());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getDeliveryMethodPerm()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getDeliveryMethodPerm()),isNullOrNot.apply(row.get(0).get("delivery_method_perm")))) {
						query.append("delivery_method_perm = :delivery_method_perm,");
						parameter.put("delivery_method_perm",item.getDeliveryMethodPerm());
						editDelta = new EditTrail();
						editDelta.setColumnName("delivery_method_perm");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("delivery_method_perm")));
						editDelta.setAfterChange(String.valueOf(item.getDeliveryMethodPerm()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getDiscClassEffectiveSeq())) {
					if(isEquals.negate().test(item.getDiscClassEffectiveSeq(),isNullOrNot.apply(row.get(0).get("disc_class_effective_seq")))) {
						query.append("disc_class_effective_seq =:disc_class_effective_seq,");
						parameter.put("disc_class_effective_seq",item.getDiscClassEffectiveSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("disc_class_effective_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("disc_class_effective_seq")));
						editDelta.setAfterChange(item.getDiscClassEffectiveSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getDiscountCardSeq()) && row.get(0).get("discount_card_seq")!=null) {
					if(isEquals.negate().test(item.getDiscountCardSeq(),isNullOrNot.apply(row.get(0).get("discount_card_seq")))) {
						query.append("discount_card_seq = :discount_card_seq,");
						parameter.put("discount_card_seq",item.getDiscountCardSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("discount_card_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("discount_card_seq")));
						editDelta.setAfterChange(item.getDiscountCardSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getDiscountClassId())) {
					if(isEquals.negate().test(item.getDiscountClassId(),isNullOrNot.apply(row.get(0).get("discount_class_id")))) {
						query.append("discount_class_id = :discount_class_id,");
						parameter.put("discount_class_id",item.getDiscountClassId());
						editDelta = new EditTrail();
						editDelta.setColumnName("discount_class_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("discount_class_id")));
						editDelta.setAfterChange(item.getDiscountClassId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getDistributionMethod())) {
					if(isEquals.negate().test(item.getDistributionMethod(),isNullOrNot.apply(row.get(0).get("distribution_method")))) {
						query.append("distribution_method =:distribution_method,");
						parameter.put("distribution_method",item.getDistributionMethod());
						editDelta = new EditTrail();
						editDelta.setColumnName("distribution_method");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("distribution_method")));
						editDelta.setAfterChange(item.getDistributionMethod());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getDuration()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getDuration()),isNullOrNot.apply(row.get(0).get("duration")))) {
						query.append("duration = :duration,");
						parameter.put("duration",item.getDuration());
						editDelta = new EditTrail();
						editDelta.setColumnName("duration");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("duration")));
						editDelta.setAfterChange(String.valueOf(item.getDuration()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getEffective_expire_date())) {
					if(isEquals.negate().test(item.getEffective_expire_date(), customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("effective_expire_date"))))) {
						query.append("effective_expire_date = :effective_expire_date,");
						parameter.put("effective_expire_date",item.getEffective_expire_date());
						editDelta = new EditTrail();
						editDelta.setColumnName("effective_expire_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("effective_expire_date")));
						editDelta.setAfterChange(item.getEffective_expire_date());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getElectronicDelivery()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getElectronicDelivery()),isNullOrNot.apply(row.get(0).get("electronic_delivery")))) {
						query.append("electronic_delivery =:electronic_delivery,");
						parameter.put("electronic_delivery",item.getElectronicDelivery());
						editDelta = new EditTrail();
						editDelta.setColumnName("electronic_delivery");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("electronic_delivery")));
						editDelta.setAfterChange(String.valueOf(item.getElectronicDelivery()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getElectronicDocumentIdentifier())) {
					if(isEquals.negate().test(item.getElectronicDocumentIdentifier(),isNullOrNot.apply(row.get(0).get("electronic_document_identifier")))) {
						query.append("electronic_document_identifier = :electronic_document_identifier,");
						parameter.put("electronic_document_identifier",item.getElectronicDocumentIdentifier());
						editDelta = new EditTrail();
						editDelta.setColumnName("electronic_document_identifier");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("electronic_document_identifier")));
						editDelta.setAfterChange(item.getElectronicDocumentIdentifier());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getExchangeRate())) {
					if(isEquals.negate().test(item.getExchangeRate(),isNullOrNot.apply(row.get(0).get("exchange_rate")))) {
						query.append("exchange_rate = :exchange_rate,");
						parameter.put("exchange_rate",item.getExchangeRate());
						editDelta = new EditTrail();
						editDelta.setColumnName("exchange_rate");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("exchange_rate")));
						editDelta.setAfterChange(item.getExchangeRate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getExpireDate())) {
					if(isEquals.negate().test(item.getExpireDate(),customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("expire_date"))))) {
						query.append("expire_date =:expire_date,");
						parameter.put("expire_date",item.getExpireDate());
						editDelta = new EditTrail();
						editDelta.setColumnName("expire_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("expire_date")));
						editDelta.setAfterChange(item.getExpireDate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getExtIssleft()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getExtIssleft()),isNullOrNot.apply(row.get(0).get("ext_iss_left")))) {
						query.append("ext_iss_left = :ext_iss_left,");
						parameter.put("ext_iss_left",item.getExtIssleft());
						editDelta = new EditTrail();
						editDelta.setColumnName("ext_iss_left");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("ext_iss_left")));
						editDelta.setAfterChange(String.valueOf(item.getExtIssleft()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getExtIssTot()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getExtIssTot()),isNullOrNot.apply(row.get(0).get("ext_iss_tot")))) {
						query.append("ext_iss_tot = :ext_iss_tot,");
						parameter.put("ext_iss_tot",item.getExtIssTot());
						editDelta = new EditTrail();
						editDelta.setColumnName("ext_iss_tot");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("ext_iss_tot")));
						editDelta.setAfterChange(String.valueOf(item.getExtIssTot()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getExtendedDays()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getExtendedDays()),isNullOrNot.apply(row.get(0).get("extended_days")))) {
						query.append("extended_days =:extended_days,");
						parameter.put("extended_days",item.getExtendedDays());
						editDelta = new EditTrail();
						editDelta.setColumnName("extended_days");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("extended_days")));
						editDelta.setAfterChange(String.valueOf(item.getExtendedDays()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getExtendedRate())) {
					if(isEquals.negate().test(item.getExtendedRate(), customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("extended_rate"))))) {
						query.append("extended_rate = :extended_rate,");
						parameter.put("extended_rate",item.getExtendedRate());
						editDelta = new EditTrail();
						editDelta.setColumnName("extended_rate");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("extended_rate")));
						editDelta.setAfterChange(item.getExtendedRate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getFulfillmentDate())) {
					if(isEquals.negate().test(item.getFulfillmentDate(),customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("fulfillment_date"))))) {
						query.append("fulfillment_date = :fulfillment_date,");
						parameter.put("fulfillment_date",item.getFulfillmentDate());
						editDelta = new EditTrail();
						editDelta.setColumnName("fulfillment_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("fulfillment_date")));
						editDelta.setAfterChange(item.getFulfillmentDate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getGenericPromotionCode())) {
					if(isEquals.negate().test(item.getGenericPromotionCode(),isNullOrNot.apply(row.get(0).get("generic_promotion_code_seq")))) {
						query.append("generic_promotion_code_seq =:generic_promotion_code_seq,");
						parameter.put("generic_promotion_code_seq",item.getGenericPromotionCode());
						editDelta = new EditTrail();
						editDelta.setColumnName("generic_promotion_code_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("generic_promotion_code_seq")));
						editDelta.setAfterChange(item.getGenericPromotionCode());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getGrossBaseAmount() != null) {
					if (isEquals.negate().test(item.getGrossBaseAmount(),isNullOrNot.apply(row.get(0).get("gross_base_amount")))) {
						query.append("gross_base_amount =:gross_base_amount,");
						parameter.put("gross_base_amount",getAmountValue(item.getGrossBaseAmount()));
						editTrail.setBaseAmount(getAmountValue(item.getGrossBaseAmount()));
						editDelta = new EditTrail();
						editDelta.setColumnName("gross_base_amount");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("gross_base_amount")));
						editDelta.setAfterChange(item.getGrossBaseAmount());
					    toInsertEditTrailDeltaList.add(editDelta);
						
					}
				}if(item.getGrossLocalAmount() != null) {
					if (isEquals.negate().test(item.getGrossLocalAmount(),isNullOrNot.apply(row.get(0).get("gross_local_amount")))) {
						query.append("gross_local_amount =:gross_local_amount,");
						parameter.put("gross_local_amount",getAmountValue(item.getGrossLocalAmount()));
						editTrail.setLocalAmount(getAmountValue(item.getGrossLocalAmount()));
						editDelta = new EditTrail();
						editDelta.setColumnName("gross_local_amount");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("gross_local_amount")));
						editDelta.setAfterChange(item.getGrossLocalAmount());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getGroupOrder()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getGroupOrder()),isNullOrNot.apply(row.get(0).get("group_order")))) {
						query.append("group_order = :group_order,");
						parameter.put("group_order",item.getGroupOrder());
						editDelta = new EditTrail();
						editDelta.setColumnName("group_order");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("group_order")));
						editDelta.setAfterChange(String.valueOf(item.getGroupOrder()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getHasBeenRenewed()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getHasBeenRenewed()),isNullOrNot.apply(row.get(0).get("has_been_renewed")))) {
						query.append("has_been_renewed = :has_been_renewed,");
						parameter.put("has_been_renewed",item.getHasBeenRenewed());
						editDelta = new EditTrail();
						editDelta.setColumnName("has_been_renewed");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("has_been_renewed")));
						editDelta.setAfterChange(String.valueOf(item.getHasBeenRenewed()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getHasDeliveryCharge()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getHasDeliveryCharge()),isNullOrNot.apply(row.get(0).get("has_delivery_charge")))) {
						query.append("has_delivery_charge =:has_delivery_charge,");
						parameter.put("has_delivery_charge",item.getHasDeliveryCharge());
						editDelta = new EditTrail();
						editDelta.setColumnName("has_delivery_charge");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("has_delivery_charge")));
						editDelta.setAfterChange(String.valueOf(item.getHasDeliveryCharge()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getHasPremium()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getHasPremium()),isNullOrNot.apply(row.get(0).get("has_premium")))) {
						query.append("has_premium = :has_premium,");
						parameter.put("has_premium",item.getHasPremium());
						editDelta = new EditTrail();
						editDelta.setColumnName("has_premium");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("has_premium")));
						editDelta.setAfterChange(String.valueOf(item.getHasPremium()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getHasTax()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getHasTax()),isNullOrNot.apply(row.get(0).get("has_tax")))) {
						query.append("has_tax = :has_tax,");
						parameter.put("has_tax",item.getHasTax());
						editDelta = new EditTrail();
						editDelta.setColumnName("has_tax");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("has_tax")));
						editDelta.setAfterChange(String.valueOf(item.getHasTax()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getInstallmentPlanId())) {
					if(isEquals.negate().test(item.getInstallmentPlanId(),isNullOrNot.apply(row.get(0).get("installment_plan_id")))) {
						query.append("installment_plan_id =:installment_plan_id,");
						parameter.put("installment_plan_id",item.getInstallmentPlanId());
						editDelta = new EditTrail();
						editDelta.setColumnName("installment_plan_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("installment_plan_id")));
						editDelta.setAfterChange(item.getInstallmentPlanId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getInventoryId())) {
					if(isEquals.negate().test(item.getInventoryId(),isNullOrNot.apply(row.get(0).get("inventory_id")))) {
						query.append("inventory_id = :inventory_id,");
						parameter.put("inventory_id",item.getInventoryId());
						editDelta = new EditTrail();
						editDelta.setColumnName("inventory_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("inventory_id")));
						editDelta.setAfterChange(item.getInventoryId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getInvoiceDate())) {
					if(isEquals.negate().test(item.getInvoiceDate(),customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("invoice_date"))))) {
						query.append("invoice_date = :invoice_date,");
						//parameter.put("invoice_date",customerUtility.getCurrentDateYYMMDDWithTime(item.getInvoiceDate()));
						parameter.put("invoice_date",item.getInvoiceDate());
						editDelta = new EditTrail();
						editDelta.setColumnName("invoice_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("invoice_date")));
						editDelta.setAfterChange(item.getInvoiceDate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getInvoiceId())) {
					if(isEquals.negate().test(item.getInvoiceId(),isNullOrNot.apply(row.get(0).get("invoice_id")))) {
						query.append("invoice_id =:invoice_id,");
						parameter.put("invoice_id",item.getInvoiceId());
						editDelta = new EditTrail();
						editDelta.setColumnName("invoice_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("invoice_id")));
						editDelta.setAfterChange(item.getInvoiceId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getIsBackOrdered()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getIsBackOrdered()),isNullOrNot.apply(row.get(0).get("is_back_ordered")))) {
						query.append("is_back_ordered = :is_back_ordered,");
						parameter.put("is_back_ordered",item.getIsBackOrdered());
						editDelta = new EditTrail();
						editDelta.setColumnName("is_back_ordered");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("is_back_ordered")));
						editDelta.setAfterChange(String.valueOf(item.getIsBackOrdered()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getIsComplimentary()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getIsComplimentary()),isNullOrNot.apply(row.get(0).get("is_complimentary")))) {
						query.append("is_complimentary = :is_complimentary,");
						parameter.put("is_complimentary",item.getIsComplimentary());
						editDelta = new EditTrail();
						editDelta.setColumnName("is_complimentary");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("is_complimentary")));
						editDelta.setAfterChange(String.valueOf(item.getIsComplimentary()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getIsProforma()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getIsProforma()),isNullOrNot.apply(row.get(0).get("is_proforma")))) {
						query.append("is_proforma =:is_proforma,");
						parameter.put("is_proforma",item.getIsProforma());
						editDelta = new EditTrail();
						editDelta.setColumnName("is_proforma");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("is_proforma")));
						editDelta.setAfterChange(String.valueOf(item.getIsProforma()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getItemUrl())) {
					if(isEquals.negate().test(item.getItemUrl(),isNullOrNot.apply(row.get(0).get("item_url")))) {
						query.append("item_url = :item_url,");
						parameter.put("item_url",item.getItemUrl());
						editDelta = new EditTrail();
						editDelta.setColumnName("item_url");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("item_url")));
						editDelta.setAfterChange(item.getItemUrl());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getLastInvDate())) {
					if(isEquals.negate().test(item.getLastInvDate(),customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("last_inv_date"))))) {
						query.append("last_inv_date = :last_inv_date,");
						parameter.put("last_inv_date",item.getLastInvDate());
						editDelta = new EditTrail();
						editDelta.setColumnName("last_inv_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("last_inv_date")));
						editDelta.setAfterChange(item.getLastInvDate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getLastRenDate())) {
					if(isEquals.negate().test(item.getLastRenDate(),customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("last_ren_date"))))) {
						query.append("last_ren_date =:last_ren_date,");
						parameter.put("last_ren_date",item.getLastRenDate());
						editDelta = new EditTrail();
						editDelta.setColumnName("last_ren_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("last_ren_date")));
						editDelta.setAfterChange(item.getLastRenDate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getLastTaxInvoiceDate())) {
					if(isEquals.negate().test(item.getLastTaxInvoiceDate(),customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("last_tax_invoice_date"))))) {
						query.append("last_tax_invoice_date = :last_tax_invoice_date,");
						parameter.put("last_tax_invoice_date",item.getLastTaxInvoiceDate());
						editDelta = new EditTrail();
						editDelta.setColumnName("last_tax_invoice_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("last_tax_invoice_date")));
						editDelta.setAfterChange(item.getLastTaxInvoiceDate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getManualDiscAmtBase()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getManualDiscAmtBase()),isNullOrNot.apply(row.get(0).get("manual_disc_amt_base")))) {
						query.append("manual_disc_amt_base = :manual_disc_amt_base,");
						parameter.put("manual_disc_amt_base",getAmountValue(String.valueOf(item.getManualDiscAmtBase())));
						editDelta = new EditTrail();
						editDelta.setColumnName("manual_disc_amt_base");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("manual_disc_amt_base")));
						editDelta.setAfterChange(String.valueOf(item.getManualDiscAmtBase()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getManualDiscAmtLocal()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getBillToCustomerAddressSeq()),isNullOrNot.apply(row.get(0).get("manual_disc_amt_local")))) {
						query.append("manual_disc_amt_local =:manual_disc_amt_local,");
						parameter.put("manual_disc_amt_local",getAmountValue(String.valueOf(item.getManualDiscAmtLocal())));
						editDelta = new EditTrail();
						editDelta.setColumnName("manual_disc_amt_local");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("manual_disc_amt_local")));
						editDelta.setAfterChange(String.valueOf(item.getBillToCustomerAddressSeq()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getManualDiscPercentage()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getManualDiscPercentage()),isNullOrNot.apply(row.get(0).get("manual_disc_percentage")))) {
						query.append("manual_disc_percentage = :manual_disc_percentage");
						parameter.put("manual_disc_percentage",getAmountValue(String.valueOf(item.getManualDiscPercentage())));
						editDelta = new EditTrail();
						editDelta.setColumnName("manual_disc_percentage");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("manual_disc_percentage")));
						editDelta.setAfterChange(String.valueOf(item.getManualDiscPercentage()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getMaxCheckOutAmt())) {
					if(isEquals.negate().test(item.getMaxCheckOutAmt(),isNullOrNot.apply(row.get(0).get("max_check_out_amt")))) {
						query.append("max_check_out_amt = :max_check_out_amt,");
						parameter.put("max_check_out_amt",item.getMaxCheckOutAmt());
						editDelta = new EditTrail();
						editDelta.setColumnName("max_check_out_amt");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("max_check_out_amt")));
						editDelta.setAfterChange(item.getMaxCheckOutAmt());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getMruBillingHistorySeq())) {
					if(isEquals.negate().test(item.getMruBillingHistorySeq(),isNullOrNot.apply(row.get(0).get("mru_billing_history_seq")))) {
						query.append("mru_billing_history_seq =:mru_billing_history_seq,");
						parameter.put("mru_billing_history_seq",item.getMruBillingHistorySeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("mru_billing_history_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("mru_billing_history_seq")));
						editDelta.setAfterChange(item.getMruBillingHistorySeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getMruGrpMbrItemDtlSeq()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getMruGrpMbrItemDtlSeq()),isNullOrNot.apply(row.get(0).get("mru_grp_mbr_item_dtl_seq")))) {
						query.append("mru_grp_mbr_item_dtl_seq = :mru_grp_mbr_item_dtl_seq,");
						parameter.put("mru_grp_mbr_item_dtl_seq",item.getMruGrpMbrItemDtlSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("mru_grp_mbr_item_dtl_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("mru_grp_mbr_item_dtl_seq")));
						editDelta.setAfterChange(String.valueOf(item.getMruGrpMbrItemDtlSeq()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getMruOrderItemAmtBreakSeq()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getMruOrderItemAmtBreakSeq()),isNullOrNot.apply(row.get(0).get("mru_order_item_amt_break_seq")))) {
						query.append("mru_order_item_amt_break_seq = :mru_order_item_amt_break_seq,");
						parameter.put("mru_order_item_amt_break_seq",item.getMruOrderItemAmtBreakSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("mru_order_item_amt_break_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("mru_order_item_amt_break_seq")));
						editDelta.setAfterChange(String.valueOf(item.getMruOrderItemAmtBreakSeq()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getMruOrderItemNoteSeq())) {
					if(isEquals.negate().test(item.getMruOrderItemNoteSeq(),isNullOrNot.apply(row.get(0).get("mru_order_item_note_seq")))) {
						query.append("mru_order_item_note_seq =:mru_order_item_note_seq,");
						parameter.put("mru_order_item_note_seq",item.getMruOrderItemNoteSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("mru_order_item_note_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("mru_order_item_note_seq")));
						editDelta.setAfterChange(item.getMruOrderItemNoteSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getMruOrderItemSglIssuesSeq())) {
					if(isEquals.negate().test(item.getMruOrderItemSglIssuesSeq(),isNullOrNot.apply(row.get(0).get("mru_order_item_sgl_issues_seq")))) {
						query.append("mru_order_item_sgl_issues_seq = :mru_order_item_sgl_issues_seq,");
						parameter.put("mru_order_item_sgl_issues_seq",item.getMruOrderItemSglIssuesSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("mru_order_item_sgl_issues_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("mru_order_item_sgl_issues_seq")));
						editDelta.setAfterChange(item.getMruOrderItemSglIssuesSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getMruOrderItemShipSeq())) {
					if(isEquals.negate().test(item.getMruOrderItemShipSeq(),isNullOrNot.apply(row.get(0).get("mru_order_item_ship_seq")))) {
						query.append("mru_order_item_ship_seq = :mru_order_item_ship_seq,");
						parameter.put("mru_order_item_ship_seq",item.getMruOrderItemShipSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("mru_order_item_ship_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("mru_order_item_ship_seq")));
						editDelta.setAfterChange(item.getMruOrderItemShipSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getMruSuspensionSeq())) {
					if(isEquals.negate().test(item.getMruSuspensionSeq(),isNullOrNot.apply(row.get(0).get("mru_suspension_seq")))) {
						query.append("mru_suspension_seq =:mru_suspension_seq,");
						parameter.put("mru_suspension_seq",item.getMruSuspensionSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("mru_suspension_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("mru_suspension_seq")));
						editDelta.setAfterChange(item.getMruSuspensionSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getMruUnitHistorySeq())) {
					if(isEquals.negate().test(item.getMruUnitHistorySeq(),isNullOrNot.apply(row.get(0).get("mru_unit_history_seq")))) {
						query.append("mru_unit_history_seq = :mru_unit_history_seq,");
						parameter.put("mru_unit_history_seq",item.getMruUnitHistorySeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("mru_unit_history_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("mru_unit_history_seq")));
						editDelta.setAfterChange(item.getMruUnitHistorySeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getMultilineDiscAmount())) {
					if(isEquals.negate().test(item.getMultilineDiscAmount(),isNullOrNot.apply(row.get(0).get("multiline_disc_amount")))) {
						query.append("multiline_disc_amount = :multiline_disc_amount,");
						parameter.put("multiline_disc_amount",getAmountValue(item.getMultilineDiscAmount()));
						editDelta = new EditTrail();
						editDelta.setColumnName("multiline_disc_amount");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("multiline_disc_amount")));
						editDelta.setAfterChange(item.getMultilineDiscAmount());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getMultilineDiscEffSeq())) {
					if(isEquals.negate().test(item.getMultilineDiscEffSeq(),isNullOrNot.apply(row.get(0).get("multiline_disc_eff_seq")))) {
						query.append("multiline_disc_eff_seq =:multiline_disc_eff_seq,");
						parameter.put("multiline_disc_eff_seq",item.getMultilineDiscEffSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("multiline_disc_eff_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("multiline_disc_eff_seq")));
						editDelta.setAfterChange(item.getMultilineDiscEffSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getMultilineDiscountSchedule())) {
					if(isEquals.negate().test(item.getMultilineDiscountSchedule(),isNullOrNot.apply(row.get(0).get("multiline_discount_schedule")))) {
						query.append("multiline_discount_schedule = :multiline_discount_schedule,");
						parameter.put("multiline_discount_schedule",item.getMultilineDiscountSchedule());
						editDelta = new EditTrail();
						editDelta.setColumnName("multiline_discount_schedule");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("multiline_discount_schedule")));
						editDelta.setAfterChange(item.getMultilineDiscountSchedule());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getnCalUnitsPerSeg())) {
					if(isEquals.negate().test(item.getnCalUnitsPerSeg(),isNullOrNot.apply(row.get(0).get("n_cal_units_per_seg")))) {
						query.append("n_cal_units_per_seg = :n_cal_units_per_seg,");
						parameter.put("n_cal_units_per_seg",item.getnCalUnitsPerSeg());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_cal_units_per_seg");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_cal_units_per_seg")));
						editDelta.setAfterChange(item.getnCalUnitsPerSeg());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getnCheckedOut())) {
					if(isEquals.negate().test(item.getnCheckedOut(),isNullOrNot.apply(row.get(0).get("n_check_out")))) {
						query.append("n_check_out =:n_check_out,");
						parameter.put("n_check_out",item.getnCheckedOut());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_check_out");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_check_out")));
						editDelta.setAfterChange(item.getnCheckedOut());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getnDaysGraced()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getnDaysGraced()),isNullOrNot.apply(row.get(0).get("n_days_graced")))) {
						query.append("n_days_graced = :n_days_graced,");
						parameter.put("n_days_graced",item.getnDaysGraced());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_days_graced");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_days_graced")));
						editDelta.setAfterChange(String.valueOf(item.getnDaysGraced()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getnDelIssLeft())) {
					if(isEquals.negate().test(item.getnDelIssLeft(),isNullOrNot.apply(row.get(0).get("n_del_iss_left")))) {
						query.append("n_del_iss_left = :n_del_iss_left,");
						parameter.put("n_del_iss_left",item.getnDelIssLeft());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_del_iss_left");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_del_iss_left")));
						editDelta.setAfterChange(item.getnDelIssLeft());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getnInvEffort())) {
					if(isEquals.negate().test(item.getnInvEffort(),isNullOrNot.apply(row.get(0).get("n_inv_efforts")))) {
						query.append("n_inv_efforts =:n_inv_efforts,");
						parameter.put("n_inv_efforts",item.getnInvEffort());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_inv_efforts");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_inv_efforts")));
						editDelta.setAfterChange(item.getnInvEffort());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getnIssueLeft())) {
					if(isEquals.negate().test(item.getnIssueLeft(),isNullOrNot.apply(row.get(0).get("n_issues_left")))) {
						query.append("n_issues_left = :n_issues_left,");
						parameter.put("n_issues_left",item.getnIssueLeft());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_issues_left");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_issues_left")));
						editDelta.setAfterChange(item.getnIssueLeft());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getnItemsPerSeg())) {
					if(isEquals.negate().test(item.getnItemsPerSeg(),isNullOrNot.apply(row.get(0).get("n_items_per_seg")))) {
						query.append("n_items_per_seg = :n_items_per_seg,");
						parameter.put("n_items_per_seg",item.getnItemsPerSeg());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_items_per_seg");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_items_per_seg")));
						editDelta.setAfterChange(item.getnItemsPerSeg());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getnNonpaidIssues())) {
					if(isEquals.negate().test(item.getnNonpaidIssues(),isNullOrNot.apply(row.get(0).get("n_nonpaid_issues")))) {
						query.append("n_nonpaid_issues =:n_nonpaid_issues,");
						parameter.put("n_nonpaid_issues",item.getnNonpaidIssues());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_nonpaid_issues");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_nonpaid_issues")));
						editDelta.setAfterChange(item.getnNonpaidIssues());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getnRemainingNonpaidIssues())) {
					if(isEquals.negate().test(item.getnRemainingNonpaidIssues(),isNullOrNot.apply(row.get(0).get("n_remaining_nonpaid_issues")))) {
						query.append("n_remaining_nonpaid_issues = :n_remaining_nonpaid_issues,");
						parameter.put("n_remaining_nonpaid_issues",item.getnRemainingNonpaidIssues());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_remaining_nonpaid_issues");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_remaining_nonpaid_issues")));
						editDelta.setAfterChange(item.getnRemainingNonpaidIssues());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getnRemainingPaidIssue()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getnRemainingPaidIssue()),isNullOrNot.apply(row.get(0).get("n_remaining_paid_issues")))) {
						query.append("n_remaining_paid_issues = :n_remaining_paid_issues,");
						parameter.put("n_remaining_paid_issues",item.getnRemainingPaidIssue());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_remaining_paid_issues");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_remaining_paid_issues")));
						editDelta.setAfterChange(String.valueOf(item.getnRemainingPaidIssue()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getnRenEffort())) {
					if(isEquals.negate().test(item.getnRenEffort(),isNullOrNot.apply(row.get(0).get("n_ren_effort")))) {
						query.append("n_ren_effort =:n_ren_effort,");
						parameter.put("n_ren_effort",item.getnRenEffort());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_ren_effort");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_ren_effort")));
						editDelta.setAfterChange(item.getnRenEffort());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getnSegmentsLeft())) {
					if(isEquals.negate().test(item.getnSegmentsLeft(),isNullOrNot.apply(row.get(0).get("n_segments_left")))) {
						query.append("n_segments_left = :n_segments_left,");
						parameter.put("n_segments_left",item.getnSegmentsLeft());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_segments_left");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_segments_left")));
						editDelta.setAfterChange(item.getnSegmentsLeft());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getnTaxUpdates()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getnTaxUpdates()),isNullOrNot.apply(row.get(0).get("n_tax_updates")))) {
						query.append("n_tax_updates = :n_tax_updates,");
						parameter.put("n_tax_updates",item.getnTaxUpdates());
						editDelta = new EditTrail();
						editDelta.setColumnName("n_tax_updates");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("n_tax_updates")));
						editDelta.setAfterChange(String.valueOf(item.getnTaxUpdates()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getNetBaseAmount() != null) {
					if (isEquals.negate().test(item.getNetBaseAmount(),isNullOrNot.apply(row.get(0).get("net_base_amount")))) {
						query.append("net_base_amount =:net_base_amount,");
						parameter.put("net_base_amount",item.getNetBaseAmount() != null?getAmountValue(item.getNetBaseAmount()):null);
						editDelta = new EditTrail();
						editDelta.setColumnName("net_base_amount");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("net_base_amount")));
						editDelta.setAfterChange(item.getNetBaseAmount());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getNetLocalAmount() != null) {
					if (isEquals.negate().test(item.getNetLocalAmount(),isNullOrNot.apply(row.get(0).get("net_local_amount")))) {
					    query.append("net_local_amount =:net_local_amount,");
						parameter.put("net_local_amount",getAmountValue(item.getNetLocalAmount()));
						editDelta = new EditTrail();
						editDelta.setColumnName("net_local_amount");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("net_local_amount")));
						editDelta.setAfterChange(item.getNetLocalAmount());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getNoteExist()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getNoteExist()),isNullOrNot.apply(row.get(0).get("note_exist")))) {
						query.append("note_exist = :note_exist,");
						parameter.put("note_exist",item.getNoteExist());
						editDelta = new EditTrail();
						editDelta.setColumnName("note_exist");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("note_exist")));
						editDelta.setAfterChange(String.valueOf(item.getNoteExist()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getNumberVolumeSets())) {
					if(isEquals.negate().test(item.getNumberVolumeSets(),isNullOrNot.apply(row.get(0).get("number_volume_sets")))) {
						query.append("number_volume_sets =:number_volume_sets,");
						parameter.put("number_volume_sets",item.getNumberVolumeSets());
						editDelta = new EditTrail();
						editDelta.setColumnName("number_volume_sets");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("number_volume_sets")));
						editDelta.setAfterChange(item.getNumberVolumeSets());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getOcId()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getOcId()),isNullOrNot.apply(row.get(0).get("oc_id")))) {
						query.append("oc_id = :oc_id,");
						parameter.put("oc_id",item.getOcId());
						editDelta = new EditTrail();
						editDelta.setColumnName("oc_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("oc_id")));
						editDelta.setAfterChange(String.valueOf(item.getOcId()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}
	//			if(item.getOrderItemSeq()!=0) {
	//				query.append("ord_order_item_seq4 = :ord_order_item_seq4,");
	//				parameter.put("ord_order_item_seq4",item.getOrderItemSeq());
	//			}
	//			if(item.getOrderhdrId()!=0) {
	//				query.append("ord_orderhdr_id2 =:ord_orderhdr_id2,");
	//				parameter.put("ord_orderhdr_id2",item.getOrderhdrId());
	//			}
				if(isNullOrEmpty.test(item.getOrderCategory())) {
					if(isEquals.negate().test(item.getOrderCategory(),isNullOrNot.apply(row.get(0).get("order_category")))) {
						query.append("order_category = :order_category,");
						parameter.put("order_category",item.getOrderCategory());
						editDelta = new EditTrail();
						editDelta.setColumnName("order_category");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("order_category")));
						editDelta.setAfterChange(item.getOrderCategory());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getOrderCodeID())) {
					if(isEquals.negate().test(item.getOrderCodeID(),isNullOrNot.apply(row.get(0).get("order_code_id")))) {
						query.append("order_code_id = :order_code_id,");
						parameter.put("order_code_id",item.getOrderCodeID());
						editDelta = new EditTrail();
						editDelta.setColumnName("order_code_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("order_code_id")));
						editDelta.setAfterChange(item.getOrderCodeID());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getOrderDate())) {
					if(isEquals.negate().test(item.getOrderDate(),customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("order_date"))))) {
						query.append("order_date =:order_date,");
						parameter.put("order_date",item.getOrderDate());
						editDelta = new EditTrail();
						editDelta.setColumnName("order_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("order_date")));
						editDelta.setAfterChange(item.getOrderDate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getOrderItemType()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getOrderItemType()),isNullOrNot.apply(row.get(0).get("order_item_type")))) {
						query.append("order_item_type = :order_item_type,");
						parameter.put("order_item_type",item.getOrderItemType());
						editDelta = new EditTrail();
						editDelta.setColumnName("order_item_type");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("order_item_type")));
						editDelta.setAfterChange(String.valueOf(item.getOrderItemType()));
					    toInsertEditTrailDeltaList.add(editDelta);/// it is completed line
					}
				}if(item.getOrderQty()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getOrderQty()),isNullOrNot.apply(row.get(0).get("order_qty")))) {
						query.append("order_qty = :order_qty,");
						parameter.put("order_qty",item.getOrderQty());
						editDelta = new EditTrail();
						editDelta.setColumnName("order_qty");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("order_qty")));
						editDelta.setAfterChange(String.valueOf(item.getOrderQty()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(getOrderStatus(item.getOrder_status()))) {
					if(isEquals.negate().test(getOrderStatus(item.getOrder_status()),isNullOrNot.apply(row.get(0).get("order_status")) )) {
						query.append("order_status =:order_status,");
						parameter.put("order_status",getOrderStatus(item.getOrder_status()));
						editDelta = new EditTrail();
						editDelta.setColumnName("order_status");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("order_status")));
						editDelta.setAfterChange(item.getOrder_status());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getOrderType()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getOrderType()),isNullOrNot.apply(row.get(0).get("order_type")))) {
						query.append("order_type = :order_type,");
						parameter.put("order_type",item.getOrderType());
						editDelta = new EditTrail();
						editDelta.setColumnName("order_type");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("order_type")));
						editDelta.setAfterChange(String.valueOf(item.getOrderType()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getOrigOrderQty()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getOrigOrderQty()),isNullOrNot.apply(row.get(0).get("orig_order_qty")))) {
						query.append("orig_order_qty = :orig_order_qty,");
						parameter.put("orig_order_qty",item.getOrigOrderQty());
						editDelta = new EditTrail();
						editDelta.setColumnName("orig_order_qty");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("orig_order_qty")));
						editDelta.setAfterChange(String.valueOf(item.getOrigOrderQty()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getPackageContentSeq())) {
					if(isEquals.negate().test(item.getPackageContentSeq(),isNullOrNot.apply(row.get(0).get("package_content_seq")))) {
						query.append("package_content_seq =:package_content_seq,");
						parameter.put("package_content_seq",item.getPackageContentSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("package_content_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("package_content_seq")));
						editDelta.setAfterChange(item.getPackageContentSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getPackageID())) {
					if(isEquals.negate().test(item.getPackageID(),isNullOrNot.apply(row.get(0).get("package_id")))) {
						query.append("package_id = :package_id,");
						parameter.put("package_id",item.getPackageID());
						editDelta = new EditTrail();
						editDelta.setColumnName("package_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("package_id")));
						editDelta.setAfterChange(item.getPackageID());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getPaymentAccountSeq())) {
					if(isEquals.negate().test(item.getPaymentAccountSeq(),isNullOrNot.apply(row.get(0).get("payment_account_seq")))) {
						query.append("payment_account_seq = :payment_account_seq,");
						parameter.put("payment_account_seq",item.getPaymentAccountSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("payment_account_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("payment_account_seq")));
						editDelta.setAfterChange(item.getPaymentAccountSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(getPaymentStatus(item.getPayment_status()))) {
					if(isEquals.negate().test(getPaymentStatus(item.getPayment_status()),isNullOrNot.apply(row.get(0).get("payment_status")))) {
						query.append("payment_status =:payment_status,");
						parameter.put("payment_status",getPaymentStatus(item.getPayment_status()));
						editDelta = new EditTrail();
						editDelta.setColumnName("payment_status");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("payment_status")));
						editDelta.setAfterChange(item.getPayment_status());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getPercentOfBasicPrice())) {
					if(isEquals.negate().test(item.getPercentOfBasicPrice(),isNullOrNot.apply(row.get(0).get("percent_of_basic_price")))) {
						query.append("percent_of_basic_price = :percent_of_basic_price,");
						parameter.put("percent_of_basic_price",item.getPercentOfBasicPrice());
						editDelta = new EditTrail();
						editDelta.setColumnName("percent_of_basic_price");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("percent_of_basic_price")));
						editDelta.setAfterChange(item.getPercentOfBasicPrice());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getPerpetualOrder()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getPerpetualOrder()),isNullOrNot.apply(row.get(0).get("perpetual_order")))) {
						query.append("perpetual_order = :perpetual_order,");
						parameter.put("perpetual_order",item.getPerpetualOrder());
						editDelta = new EditTrail();
						editDelta.setColumnName("perpetual_order");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("perpetual_order")));
						editDelta.setAfterChange(String.valueOf(item.getPerpetualOrder()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getPkgDefId())) {
					if(isEquals.negate().test(item.getPkgDefId(),isNullOrNot.apply(row.get(0).get("pkg_def_id")))) {
						query.append("pkg_def_id =:pkg_def_id,");
						parameter.put("pkg_def_id",item.getPkgDefId());
						editDelta = new EditTrail();
						editDelta.setColumnName("pkg_def_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("pkg_def_id")));
						editDelta.setAfterChange(item.getPkgDefId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getPkgItemSeq())) {
					if(isEquals.negate().test(item.getPkgItemSeq(),isNullOrNot.apply(row.get(0).get("pkg_item_seq")))) {
						query.append("pkg_item_seq = :pkg_item_seq,");
						parameter.put("pkg_item_seq",item.getPkgItemSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("pkg_item_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("pkg_item_seq")));
						editDelta.setAfterChange(item.getPkgItemSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getPremToOrderItemSeq())) {
					if(isEquals.negate().test(item.getPremToOrderItemSeq(),isNullOrNot.apply(row.get(0).get("prem_to_order_item_seq")))) {
						query.append("prem_to_order_item_seq = :prem_to_order_item_seq,");
						parameter.put("prem_to_order_item_seq",item.getPremToOrderItemSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("prem_to_order_item_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("prem_to_order_item_seq")));
						editDelta.setAfterChange(item.getPremToOrderItemSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getPrepaymentReq()!=0) {
					if(isEquals.negate().test(String.valueOf(item.getPrepaymentReq()),isNullOrNot.apply(row.get(0).get("prepayment_req")))) {
						query.append("prepayment_req =:prepayment_req,");
						parameter.put("prepayment_req",item.getPrepaymentReq());
						editDelta = new EditTrail();
						editDelta.setColumnName("prepayment_req");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("prepayment_req")));
						editDelta.setAfterChange(String.valueOf(item.getPrepaymentReq()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getProductId())) {
					if (isEquals.negate().test(item.getProductId(),isNullOrNot.apply(row.get(0).get("product_id")))) {
						query.append("product_id = :product_id,");
						parameter.put("product_id",item.getProductId());
						editDelta = new EditTrail();
						editDelta.setColumnName("product_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("product_id")));
						editDelta.setAfterChange(item.getProductId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getPubRotationId())) {
					if (isEquals.negate().test(item.getPubRotationId(),isNullOrNot.apply(row.get(0).get("pub_rotation_id")))) {
						query.append("pub_rotation_id = :pub_rotation_id,");
						parameter.put("pub_rotation_id",item.getPubRotationId());
						editDelta = new EditTrail();
						editDelta.setColumnName("pub_rotation_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("pub_rotation_id")));
						editDelta.setAfterChange(item.getPubRotationId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getQualDate())) {
					if (isEquals.negate().test(item.getQualDate(),customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("qual_date"))))) {
						query.append("qual_date =:qual_date,");
						parameter.put("qual_date", item.getQualDate());
						editDelta = new EditTrail();
						editDelta.setColumnName("qual_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("qual_date")));
						editDelta.setAfterChange(item.getQualDate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getRateClassEffectiveSeq() != 0) {
					if (isEquals.negate().test(String.valueOf(item.getRateClassEffectiveSeq()),isNullOrNot.apply(row.get(0).get("rate_class_effective_seq")))) {
						query.append("rate_class_effective_seq = :rate_class_effective_seq,");
						parameter.put("rate_class_effective_seq",item.getRateClassEffectiveSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("rate_class_effective_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("rate_class_effective_seq")));
						editDelta.setAfterChange(String.valueOf(item.getRateClassEffectiveSeq()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getRatecard_id() != 0) {
					if (isEquals.negate().test(String.valueOf(item.getRatecard_id()),isNullOrNot.apply(row.get(0).get("rate_class_id")))) {
						query.append("rate_class_id = :rate_class_id,");
						parameter.put("rate_class_id",item.getRatecard_id());
						editDelta = new EditTrail();
						editDelta.setColumnName("rate_class_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("rate_class_id")));
						editDelta.setAfterChange(String.valueOf(item.getRatecard_id()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getRatecard_seq() != 0) {
					if (isEquals.negate().test(String.valueOf(item.getRatecard_seq()),isNullOrNot.apply(row.get(0).get("ratecard_seq")))) {
						query.append("ratecard_seq =:ratecard_seq,");
						parameter.put("ratecard_seq",item.getRatecard_seq());
						editDelta = new EditTrail();
						editDelta.setColumnName("ratecard_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("ratecard_seq")));
						editDelta.setAfterChange(String.valueOf(item.getRatecard_seq()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getRefundStatus() != 0) {
					if (isEquals.negate().test(String.valueOf(item.getRefundStatus()),isNullOrNot.apply(row.get(0).get("refund_status")))) {
						query.append("refund_status = :refund_status,");
						parameter.put("refund_status",item.getRefundStatus());
						editDelta = new EditTrail();
						editDelta.setColumnName("refund_status");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("refund_status")));
						editDelta.setAfterChange(String.valueOf(item.getRefundStatus()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getRenewToCustomerAddressSeq() != 0) {
					if (isEquals.negate().test(String.valueOf(item.getRenewToCustomerAddressSeq()),isNullOrNot.apply(row.get(0).get("renew_to_customer_address_seq")))) {
						query.append("renew_to_customer_address_seq = :renew_to_customer_address_seq,");
						parameter.put("renew_to_customer_address_seq",item.getRenewToCustomerAddressSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("renew_to_customer_address_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("renew_to_customer_address_seq")));
						editDelta.setAfterChange(String.valueOf(item.getRenewToCustomerAddressSeq()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getRenewToCustomerId() != 0) {
					if (isEquals.negate().test(String.valueOf(item.getRenewToCustomerId()),isNullOrNot.apply(row.get(0).get("renew_to_customer_id")))) {
						query.append("renew_to_customer_id = :renew_to_customer_id,");
						parameter.put("renew_to_customer_id",item.getRenewToCustomerId());
						editDelta = new EditTrail();
						editDelta.setColumnName("renew_to_customer_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("renew_to_customer_id")));
						editDelta.setAfterChange(String.valueOf(item.getRenewToCustomerId()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getRenewalCategory()!=0) {
					if (isEquals.negate().test(String.valueOf(item.getRenewalCategory()),isNullOrNot.apply(row.get(0).get("renewal_category")))) {
						query.append("renewal_category = :renewal_category,");
						parameter.put("renewal_category",item.getRenewalCategory());
						editDelta = new EditTrail();
						editDelta.setColumnName("renewal_category");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("renewal_category")));
						editDelta.setAfterChange(String.valueOf(item.getRenewalCategory()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getRenewalDef())) {
					if (isEquals.negate().test(item.getRenewalDef(),isNullOrNot.apply(row.get(0).get("renewal_def")))) {
						query.append("renewal_def =:renewal_def,");
						parameter.put("renewal_def",item.getRenewalDef());
						editDelta = new EditTrail();
						editDelta.setColumnName("renewal_def");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("renewal_def")));
						editDelta.setAfterChange(item.getRenewalDef());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getRenewalDefTestSeq())) {
					if (isEquals.negate().test(item.getRenewalDefTestSeq(),isNullOrNot.apply(row.get(0).get("renewal_def_test_seq")))) {
						query.append("renewal_def_test_seq =:renewal_def_test_seq,");
						parameter.put("renewal_def_test_seq",item.getRenewalDefTestSeq());
						editDelta = new EditTrail();
						editDelta.setColumnName("renewal_def_test_seq");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("renewal_def_test_seq")));
						editDelta.setAfterChange(item.getRenewalDefTestSeq());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getRenewalStatus()!=0) {
					if (isEquals.negate().test(String.valueOf(item.getRenewalStatus()),isNullOrNot.apply(row.get(0).get("renewal_status")))) {
						query.append("renewal_status = :renewal_status,");
						parameter.put("renewal_status",item.getRenewalStatus());
						editDelta = new EditTrail();
						editDelta.setColumnName("renewal_status");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("renewal_status")));
						editDelta.setAfterChange(String.valueOf(item.getRenewalStatus()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getRenewedFromSubscripId())) {
					if (isEquals.negate().test(item.getRenewedFromSubscripId(),isNullOrNot.apply(row.get(0).get("renewed_from_subscrip_id")))) {
						query.append("renewed_from_subscrip_id =:renewed_from_subscrip_id,");
						parameter.put("renewed_from_subscrip_id",item.getRenewedFromSubscripId());
						editDelta = new EditTrail();
						editDelta.setColumnName("renewed_from_subscrip_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("renewed_from_subscrip_id")));
						editDelta.setAfterChange(item.getRenewedFromSubscripId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getRevenueMethod()!=0) {
					if (isEquals.negate().test(String.valueOf(item.getRevenueMethod()),isNullOrNot.apply(row.get(0).get("revenue_method")))) {
						query.append("revenue_method =:revenue_method,");
						parameter.put("revenue_method",item.getRevenueMethod());
						editDelta = new EditTrail();
						editDelta.setColumnName("revenue_method");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("revenue_method")));
						editDelta.setAfterChange(String.valueOf(item.getRevenueMethod()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getSegmentExpireDate())) {
					if (isEquals.negate().test(item.getSegmentExpireDate(),customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("segment_expire_date"))))) {
						query.append("segment_expire_date = :segment_expire_date,");
						parameter.put("segment_expire_date",item.getSegmentExpireDate());
						editDelta = new EditTrail();
						editDelta.setColumnName("segment_expire_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("segment_expire_date")));
						editDelta.setAfterChange(item.getSegmentExpireDate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getServiceExist()!=0) {
					if (isEquals.negate().test(String.valueOf(item.getServiceExist()),isNullOrNot.apply(row.get(0).get("service_exist")))) {
						query.append("service_exist = :service_exist,");
						parameter.put("service_exist",item.getServiceExist());
						editDelta = new EditTrail();
						editDelta.setColumnName("service_exist");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("service_exist")));
						editDelta.setAfterChange(String.valueOf(item.getServiceExist()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getShipQty())) {
					if (isEquals.negate().test(item.getShipQty(),isNullOrNot.apply(row.get(0).get("ship_qty")))) {
						query.append("ship_qty =:ship_qty,");
						parameter.put("ship_qty",item.getShipQty());
						editDelta = new EditTrail();
						editDelta.setColumnName("ship_qty");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("ship_qty")));
						editDelta.setAfterChange(item.getShipQty());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getShippingPriceList())) {
					if (isEquals.negate().test(item.getShippingPriceList(),isNullOrNot.apply(row.get(0).get("shipping_price_list")))) {
						query.append("shipping_price_list = :shipping_price_list,");
						parameter.put("shipping_price_list",item.getShippingPriceList());
						editDelta = new EditTrail();
						editDelta.setColumnName("shipping_price_list");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("shipping_price_list")));
						editDelta.setAfterChange(item.getShippingPriceList());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getSourceCodeID())) {
					if (isEquals.negate().test(item.getSourceCodeID(),isNullOrNot.apply(row.get(0).get("source_code_id")))) {
						query.append("source_code_id = :source_code_id,");
						parameter.put("source_code_id",item.getSourceCodeID());
						editDelta = new EditTrail();
						editDelta.setColumnName("source_code_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("source_code_id")));
						editDelta.setAfterChange(item.getSourceCodeID());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getSqualDate())) {
					if (isEquals.negate().test(item.getSqualDate(),customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("squal_date"))))) {
						query.append("squal_date = :squal_date,");
						parameter.put("squal_date",item.getSqualDate());
						editDelta = new EditTrail();
						editDelta.setColumnName("squal_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("squal_date")));
						editDelta.setAfterChange(item.getSqualDate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getStartDate())) {
					if (isEquals.negate().test(item.getStartDate(),customerUtility.getFormattedDate(isNullOrNot.apply(row.get(0).get("start_date"))))) {
						query.append("start_date = :start_date,");
						parameter.put("start_date",item.getStartDate());
						editDelta = new EditTrail();
						editDelta.setColumnName("start_date");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("start_date")));
						editDelta.setAfterChange(item.getStartDate());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getStartIssueId())){
					if (isEquals.negate().test(item.getStartIssueId(),isNullOrNot.apply(row.get(0).get("start_issue_id")))) {
						query.append("start_issue_id = :start_issue_id,");
						parameter.put("start_issue_id",item.getStartIssueId());
						editDelta = new EditTrail();
						editDelta.setColumnName("start_issue_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("start_issue_id")));
						editDelta.setAfterChange(item.getStartIssueId());
					    toInsertEditTrailDeltaList.add(editDelta);
					 }
				}if(item.getStopIssueId()!=0){
					if (isEquals.negate().test(String.valueOf(item.getStopIssueId()),isNullOrNot.apply(row.get(0).get("stop_issue_id")))) {
						query.append("stop_issue_id =:stop_issue_id,");
						parameter.put("stop_issue_id",item.getStopIssueId());
						editDelta = new EditTrail();
						editDelta.setColumnName("stop_issue_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("stop_issue_id")));
						editDelta.setAfterChange(String.valueOf(item.getStopIssueId()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getSubscripId())){
					if (isEquals.negate().test(item.getSubscripId(),isNullOrNot.apply(row.get(0).get("subscrip_id")))) {
						query.append("subscrip_id = :subscrip_id,");
						parameter.put("subscrip_id",item.getSubscripId());
						editDelta = new EditTrail();
						editDelta.setColumnName("subscrip_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("subscrip_id")));
						editDelta.setAfterChange(item.getSubscripId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}	
				}if(item.getSubscripStartType()!=0){
					if (isEquals.negate().test(String.valueOf(item.getSubscripStartType()),isNullOrNot.apply(row.get(0).get("subscrip_start_type")))) {
						query.append("subscrip_start_type = :subscrip_start_type,");
						parameter.put("subscrip_start_type",item.getSubscripStartType());
						editDelta = new EditTrail();
						editDelta.setColumnName("subscrip_start_type");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("subscrip_start_type")));
						editDelta.setAfterChange(String.valueOf(item.getSubscripStartType()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getSubscriptionDefId())){
					//if (isNullOrEmpty.test(item.getSubscriptionDefId()) && item.getOrderItemType() != 4) {
					if (isEquals.negate().test(item.getSubscriptionDefId(),isNullOrNot.apply(row.get(0).get("subscription_def_id")))) {
						
						query.append("subscription_def_id =:subscription_def_id,");
						parameter.put("subscription_def_id",item.getSubscriptionDefId());
						editDelta = new EditTrail();
						editDelta.setColumnName("subscription_def_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("subscription_def_id")));
						editDelta.setAfterChange(item.getSubscriptionDefId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getTimeUnitOptions()!=0){
					if (isEquals.negate().test(String.valueOf(item.getTimeUnitOptions()),isNullOrNot.apply(row.get(0).get("time_unit_options")))) {
						query.append("time_unit_options = :time_unit_options,");
						parameter.put("time_unit_options",item.getTimeUnitOptions());
						editDelta = new EditTrail();
						editDelta.setColumnName("time_unit_options");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("time_unit_options")));
						editDelta.setAfterChange(String.valueOf(item.getTimeUnitOptions()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getTotalTaxBaseAmount())){
					if (isEquals.negate().test(item.getTotalTaxBaseAmount(),isNullOrNot.apply(row.get(0).get("total_tax_base_amount")))) {
						query.append("total_tax_base_amount = :total_tax_base_amount,");
						parameter.put("total_tax_base_amount",getAmountValue(item.getTotalTaxBaseAmount()));
						editDelta = new EditTrail();
						editDelta.setColumnName("total_tax_base_amount");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("total_tax_base_amount")));
						editDelta.setAfterChange(item.getTotalTaxBaseAmount());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getTotalTaxLocalAmount())){
					if (isEquals.negate().test(item.getTotalTaxLocalAmount(),isNullOrNot.apply(row.get(0).get("total_tax_local_amount")))) {
						query.append("total_tax_local_amount =:total_tax_local_amount,");
						parameter.put("total_tax_local_amount",getAmountValue(item.getTotalTaxLocalAmount()));
						editDelta = new EditTrail();
						editDelta.setColumnName("total_tax_local_amount");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("total_tax_local_amount")));
						editDelta.setAfterChange(item.getTotalTaxLocalAmount());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getTrialPeriod())){
					if (isEquals.negate().test(item.getTrialPeriod(),isNullOrNot.apply(row.get(0).get("trial_period")))) {
						query.append("trial_period = :trial_period,");
						parameter.put("trial_period",item.getTrialPeriod());
						editDelta = new EditTrail();
						editDelta.setColumnName("trial_period");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("trial_period")));
						editDelta.setAfterChange(item.getTrialPeriod());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(item.getTrialType()!=0){
					if (isEquals.negate().test(String.valueOf(item.getTrialType()),isNullOrNot.apply(row.get(0).get("trial_type")))) {
						query.append("trial_type = :trial_type,");
						parameter.put("trial_type",item.getTrialType());
						editDelta = new EditTrail();
						editDelta.setColumnName("trial_type");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("trial_type")));
						editDelta.setAfterChange(String.valueOf(item.getTrialType()));
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getUnitExcess())){
					if (isEquals.negate().test(item.getUnitExcess(),isNullOrNot.apply(row.get(0).get("unit_excess")))) {
						query.append("unit_excess =:unit_excess,");
						parameter.put("unit_excess",item.getUnitExcess());
						editDelta = new EditTrail();
						editDelta.setColumnName("unit_excess");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("unit_excess")));
						editDelta.setAfterChange(item.getUnitExcess());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getUnitTypeId())){
					if (isEquals.negate().test(item.getUnitTypeId(),isNullOrNot.apply(row.get(0).get("unit_type_id")))) {
						query.append("unit_type_id = :unit_type_id,");
						parameter.put("unit_type_id",item.getUnitTypeId());
						editDelta = new EditTrail();
						editDelta.setColumnName("unit_type_id");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("unit_type_id")));
						editDelta.setAfterChange(item.getUnitTypeId());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}if(isNullOrEmpty.test(item.getUserCode())){
					if (isEquals.negate().test(item.getUserCode(),isNullOrNot.apply(row.get(0).get("user_code")))) {
						query.append(" user_code = :user_code,");
						parameter.put("user_code",item.getUserCode());
						editDelta = new EditTrail();
						editDelta.setColumnName("user_code");
						editDelta.setBeforeChange(isNullOrNot.apply(row.get(0).get("user_code")));
						editDelta.setAfterChange(item.getUserCode());
					    toInsertEditTrailDeltaList.add(editDelta);
					}
				}
				
				if(query.length() > 0) {
					int lastIndexOfComma = query.lastIndexOf(",");
					query.deleteCharAt(lastIndexOfComma);
				}
				query.append(" where orderhdr_id=").append(item.getOrderhdrId()).append(" and order_item_seq=").append(item.getOrderItemSeq());
				status = namedParameterJdbcTemplate.update(query.toString(), parameter);
				if(status>0) {
					long edit_trail_id = customerUtility.saveEditTrail(editTrail);
					//insert data into edit trail delta using batch
	    			 customerUtility.insertEditTrailDeltaByBatch(toInsertEditTrailDeltaList, edit_trail_id);
				}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			LOGGER.info("updateOrderItemTable(OrderItem item, List<Map<String, Object>> row): "+e);
		}
		return status;
	}
	private String getPaymentStatus(String payment_status) {
		String finalStatus = null;
		int status = 0;
		switch (payment_status.trim()) {
		case "No Payment":
			status = 0;
			break;
		case "Paid":
			status = 1;
			break;
		case "Paid - Overpayment":
			status = 2;
			break;
		case "Paid - Underpayment":
			status = 3;
			break;
		case "Paid - Prorated":
			status = 4;
			break;
		default:
			break;
		}
		finalStatus = String.valueOf(status);
		return finalStatus;
		}


	private String getOrderStatus(String order_status) {
		String finalStatus = null;
		int status = 0;
		switch (order_status.trim()) {
		case "Order Placed":
			status = 0;
			break;
		case "Canceled - Nonpayment":
			status = 1;
			break;
		case "Canceled - Customer Request":
			status = 2;
			break;
		case "Canceled - Credit Card Not Authorized":
			status = 3;
			break;
		case "Canceled - Audit Information Problem":
			status = 4;
			break;
		case "Active / Shipping":
			status = 5;
			break;
		case "Complete":
			status = 6;
			break;
		case "Grace Period":
		case "Suspend - Nonpayment":
			status = 7;
			break;
		case "Suspend - Temporary":
			status = 8;
			break;
		case "Hold for Payment":
			status = 10;
			break;
		case "Suspended - Delivery Problem":
			status = 11;
			break;
		case "Suspended - Distribution Problem":
			status = 12;
			break;
		case "Suspended - Audit Information Problem":
			status = 13;
			break;
//				case "Canceled - Audit Information Problem": 
//					status = 14;
//					break;
		case "Hold Until Fulfillment Date":
			status = 16;
			break;
		case "Suspended - Behavior":
			status = 16;
			break;
		default:
			break;
		}
		finalStatus = String.valueOf(status);
		return finalStatus;
	}
	private int getOrderType(String order_type) {
		int status = 0;
		switch (order_type.trim()) {
		case "Undefined":
			status = 0;
			break;
		case "Agency Remits Net to Publishe":
			status = 1;
			break;
		case "Standing Order":
			status = 2;
			break;
		case "Regular Order":
			status = 3;
			break;
		case "Agency Remits Gross to Publis":
			status = 4;
			break;
		case "Rotated Copy Order":
			status = 5;
			break;
		default:
			break;
		}
		return status;
	}
	/**
	 * PackageMembersList query for edit package order for basic package
	 * @author Chaman.Bharti
	 */
	private List<Map<String,Object>> packageMembersList(Integer orderCodeId, Integer pkgDefId) {
		List<Map<String,Object>>packageMembersList = new ArrayList<>();
		StringBuilder query = new StringBuilder("select pkg_def_content.pkg_def_id, pkg_def_content.order_code_id, pkg_def_content.pkg_content_seq,pkg_content.qty,item_order_code_id,");
		query.append("pkg_def_content.subscription_def_id, order_code.order_code,oc.oc,pkg_def_content.revenue_percent,oc.oc_id,");
		query.append("case when subscription_def.rate_class_id is null "); 
		query.append("then (case when order_code.newsub_rate_class_id is not null ");  
		query.append("then order_code.newsub_rate_class_id else pkg_def.rate_class_id end) else subscription_def.rate_class_id end as rate_class_id,"); 
		query.append("pkg_def_content.issue_id,pkg_def_content.product_id,pkg_def_content.subscription_def_id,");
		query.append("(select order_code_type from order_code where order_code.order_code_id=pkg_content.item_order_code_id)as orderCodeType,"); 
		query.append("(select oc_id from order_code where order_code.order_code_id=pkg_content.item_order_code_id)as contentOcId, pkg_def.pkg_price_method from pkg_def "); 
		query.append("inner join pkg_def_content on pkg_def.pkg_def_id=pkg_def_content.pkg_def_id ");
		query.append("inner join pkg_content on pkg_content.pkg_content_seq=pkg_def_content.pkg_content_seq ");
		query.append("inner join order_code on order_code.order_code_id= pkg_content.order_code_id ");
		query.append("inner join oc on oc.oc_id = order_code.oc_id ");
		query.append("left join subscription_def on subscription_def.subscription_def_id = pkg_def_content.subscription_def_id ");
		query.append("where pkg_def_content.order_code_id =").append(orderCodeId).append(" and pkg_def_content.pkg_def_id =").append(pkgDefId).append(" and order_code.order_code_id =").append(orderCodeId);
		try {
			packageMembersList = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return packageMembersList;
	}
	
	@Override
	public List<CustomerOrderModel> getCustomerOrder(long customerId,Integer orderhdrId,Integer showInactive) {
		List<CustomerOrderModel> customerOrderList=null;
		StringBuilder orderQuery = new StringBuilder();	
		orderQuery.append("SELECT  0 as required,cast(gross_local_amount as NUMERIC(18,2))as gross_local_amount,cast(gross_base_amount as NUMERIC(18,2)) as gross_base_amount,order_code.no_charge,"  );
		orderQuery.append( " cast(net_local_amount  as NUMERIC(18,2))as net_local_amount ,cast(net_base_amount  as NUMERIC(18,2))as net_base_amount, " );
		orderQuery.append( "cast(((gross_local_amount-total_tax_local_amount)-isnull(((agency.new_commission/100)*(gross_local_amount-total_tax_local_amount)),0)) as NUMERIC(18,2)) as localAmount," );
		orderQuery.append( "cast(((gross_base_amount-total_tax_base_amount)-isnull(((agency.new_commission/100)*(gross_base_amount-total_tax_base_amount)),0))as NUMERIC(18,2))  as baseAmount," );
		orderQuery.append( "order_item.*,oc.oc as order_class,order_code.order_code,order_code.order_code_type,agency_code," );
		orderQuery.append( "(select enumeration from issue where issue.issue_id=order_item.start_issue_id)as startIssueId," );
		orderQuery.append( "(select enumeration from issue where issue.issue_id=order_item.stop_issue_id)as stopIssueId ," );
		orderQuery.append( " (SELECT CONVERT(varchar,A.issue_date,101) from view_issue_volume A INNER JOIN (SELECT ROW_NUMBER() OVER(ORDER BY oc_id) AS 'RN', *   FROM view_issue_volume) B   " );
		orderQuery.append( " ON A.issue_id= B.issue_id AND B.RN=(SELECT RowNumer+1 FROM(SELECT ROW_NUMBER () OVER (ORDER BY oc_id) RowNumer,issue_id,oc_id FROM view_issue_volume ) qry1 WHERE issue_id =(select top 1 stop_issue_id from order_item where subscrip_id=order_item.subscrip_id order by orderhdr_id desc)  and oc_id=order_item.oc_id)  and  A.oc_id=order_item.oc_id) as renew_start_date	," );
		orderQuery.append( " (SELECT CONVERT(varchar,A.issue_date,101) from view_issue_volume A INNER JOIN (SELECT ROW_NUMBER() OVER(ORDER BY oc_id) AS 'RN', *  FROM view_issue_volume) B  ON A.issue_id= B.issue_id AND  " );
		orderQuery.append( " B.RN=(SELECT RowNumer+ order_item.n_issues_left FROM(SELECT ROW_NUMBER () OVER (ORDER BY oc_id) RowNumer,issue_id,oc_id FROM view_issue_volume ) qry1 WHERE issue_id =(select top 1 stop_issue_id from order_item where subscrip_id=order_item.subscrip_id order by orderhdr_id desc)  and oc_id=order_item.oc_id)  and  A.oc_id=order_item.oc_id) as renew_expire_date ," );
		orderQuery.append( " order_code.start_type as start_type, (case when ((order_code.start_type=0 or order_code.start_type=1) and order_code.order_code_type=0) then 'Issue Based Subscription' when ((order_code.start_type=0 or order_code.start_type=1) and order_code.order_code_type=1) then 'Single Copy' when order_code.order_code_type=4 then 'Package Edit'  when order_code.order_code_type=2 then 'Product' when ((order_code.start_type=4 or order_code.start_type=5) and order_code.order_code_type=0) then 'Unit Based Subscription' else 'Date Based Subscription' end) as pageName ," );
		orderQuery.append( " oin.install_auto_payment,oin.cancel_dd,subscription_def_id,(select upsell_on from oc where oc_id = (select parent_oc_id from oc where oc_id = order_item.oc_id)) as upsell_on,audited,pub.qp,pub.qf,pub.nqp,pub.nqf,order_item.inventory_id " );
		orderQuery.append( " FROM order_item order_item" );
		orderQuery.append( " left join order_code order_code on order_item.order_code_id=order_code.order_code_id" );
		orderQuery.append( " left join oc oc on order_item.oc_id=oc.oc_id" );
		orderQuery.append( " left join pub on order_item.oc_id=pub.oc_id" );
		orderQuery.append( " left join agency on order_item.agency_customer_id=agency.customer_id" );
		orderQuery.append( " left join order_item_install oin on oin.orderhdr_id=order_item.orderhdr_id and oin.order_item_seq=order_item.order_item_seq " );
		orderQuery.append( " WHERE order_item.orderhdr_id="+orderhdrId+" and pkg_item_seq is not null " );
		/*This Condition for show inactive member  */
		if(showInactive==1) {
			orderQuery.append("  order by order_item.order_item_seq ");
		}else {
			orderQuery.append(" and (order_status in (0,5,7,8,9,10,11,12,13,15,16,17) or( order_status in (6) and payment_status not in (1,2,3,4) and  gross_base_amount > 0.0 ))");
			
		}	
		
		try {
			customerOrderList=jdbcTemplate.query(orderQuery.toString(), new CustomerOrderMapper());
			
		} catch (Exception e) {
			LOGGER.info("pkgOrderList" + e);
			e.printStackTrace();
		}

		return customerOrderList;
	}
	
	@Override
	public Map<String, Object> orderAuxiliary(HttpServletRequest request) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		try {
			
			parameters.put("table_name", "order_item");
			parameters.put("custsvc_edit_disposition",0);
			String query2 = "SELECT column_name FROM aux_field WHERE LOWER(table_name) = :table_name and ";
					if(!"true".equals(request.getParameter("updateFlag"))) {
						query2 = query2+ "custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name";
					}else {
						if(request.getParameter("zzaux_zold_sales_invoice_no") == null) {
							query2 = query2+ "custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name";
						}else {
							query2 = query2+ "custsvc_edit_disposition != :custsvc_edit_disposition and column_name != 'zzaux_zold_sales_invoice_no' ORDER BY table_name,column_name";
						}
					}
					
			List<String> columnName = namedParameterJdbcTemplate.queryForList(query2, parameters, String.class);
			parameters.clear();
			parameters.put("orderhdr_id", request.getParameter("orderhdrId"));
			parameters.put("order_item_seq",request.getParameter("orderItemSeq"));
			int auxiliaryCount = namedParameterJdbcTemplate.queryForObject("select count(*) from order_item_ext where orderhdr_id= :orderhdr_id and order_item_seq= :order_item_seq ",parameters,Integer.class);
			Map<String, Object> customerAuxiliaryPreviousData=null;
			if(auxiliaryCount>0)
				customerAuxiliaryPreviousData = namedParameterJdbcTemplate.queryForMap("select * from order_item_ext where orderhdr_id= :orderhdr_id and order_item_seq= :order_item_seq",parameters);
			parameters.clear();
			StringBuilder query = new StringBuilder("");
				for(String column: columnName) {
					if(request.getParameter(column) != null) {
						parameters.put(column, request.getParameter(column));
					}
					
				}
				return parameters;	
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return parameters;
	}

	@Override
	public List<RateClassEffectiveModel> getRateClassEffectiveListInEditItem(int rateClassId,int customerId,String currency,String orderCodeID) {
		System.out.println("inside getRateClassEffectiveListInEditItem method...");
		List<Map<String,Object>> responseObject=new ArrayList<>();
		List<RateClassEffectiveModel> values=new ArrayList<>(); 
		
		try {
			responseObject=jdbcTemplate.queryForList("select rate_class.rate_class_id,rate_class_effective.rate_class_effective_seq,"
			+ " (rate_class_effective.description+' - '+CONVERT(varchar,rate_class_effective.effective_date,101)) as description,CONVERT(varchar,rate_class_effective.effective_date,101) as effective_date from rate_class_effective inner join rate_class"
			+ " on rate_class.rate_class_id=rate_class_effective.rate_class_id where rate_class.rate_class_id="+ rateClassId );
			for(Map<String,Object> map:responseObject) {
			RateClassEffectiveModel rateClassValues=new RateClassEffectiveModel();
			rateClassValues.setRateClassId(Integer.parseInt(map.get("rate_class_id").toString()));
			rateClassValues.setRateClassEffectiveSeq(Integer.parseInt(map.get("rate_class_effective_seq").toString()));
			rateClassValues.setDescription(map.get("description").toString());
			rateClassValues.setEffectiveDate(map.get("effective_date").toString());
			values.add(rateClassValues);
			}
			}
			catch (Exception e) {
			e.printStackTrace();
			}
			return values;
			}


	@Override
	public List<Map<String, Object>> onChangeInEditItem(OrderItem orderItem, Integer subscriptionId, int itemCount,
			Optional<String> subscriptionIdList) {
		List<Order_add_response> orderProgress = null;
		OrderItem orderItemModel = new OrderItem();
		List<Map<String, Object>> orderItemList = new ArrayList();
		Map<String, Object> data = new HashMap<>();
		try {
			Integer defId = subscriptionId;
			String defIdList = subscriptionIdList.get();
			int customerId=orderItem.getCustomerId();
			orderProgress = orderAddWsdl.orderProgressAddAdd(orderItem, defId, 1, defIdList);
			System.out.println("value-->"+orderProgress.get(0).getOrderhdr().getOrder_item(0).getGross_base_amount());
			if(orderProgress.get(0).getOrderhdr().getOrder_item(0).getGross_base_amount()!=null) {
			data.put("grossBaseAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getGross_base_amount());
			System.out.println(orderProgress.get(0).getOrderhdr().getOrder_item(0).getGross_base_amount());}
			data.put("grossLocalAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getGross_local_amount());
			data.put("netBaseAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getNet_base_amount());
			data.put("netLocalAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getNet_local_amount());
			data.put("localAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(0)
					.getLocal_amount().toString());
			data.put("baseAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(0)
					.getBase_amount().toString());
			data.put("totalTaxBaseAmount",
					orderProgress.get(0).getOrderhdr().getOrder_item(0).getTotal_tax_base_amount());
			data.put("totalTaxLocalAmount",
					orderProgress.get(0).getOrderhdr().getOrder_item(0).getTotal_tax_local_amount());
			int orderItemBreakLength= orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break().length;
			if(orderItemBreakLength> 1 &&  orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(1).getOrder_item_break_type()==3 ) {
				
			if(orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(1).getLocal_amount()!=null ) {
			data.put("localCommission",
					orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(1).getLocal_amount());}
			if(orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(1).getBase_amount()!=null) {
			data.put("baseCommission",
					orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(1).getBase_amount());}	
			}
			if (orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_amt_base() != null) {
				data.put("manualDiscAmtLocal",
						orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_amt_base());
			} else {
				data.put("manualDiscAmtLocal", 0);
			}
			if (orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_amt_local() != null) {
				data.put("manualDiscAmtBase",
						orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_amt_local());
			} else {
				data.put("manualDiscAmtBase", 0);
			}
			if (orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_percentage() != null) {
				data.put("manualDiscAmtBase",
						orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_percentage());
			} else {
				data.put("manualDiscAmtBase", 0);
			}
			data.put("currency",orderProgress.get(0).getOrderhdr().getOrder_item(0).getCurrency());
			data.put("exchangeRate",orderProgress.get(0).getOrderhdr().getOrder_item(0).getExchange_rate());
			int Status = orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_status();
			String orderStatus = new PropertyUtilityClass().getConstantValue("order_item.order_status_"+Status);
			data.put("orderStatus",orderStatus);
			int pStatus = orderProgress.get(0).getOrderhdr().getOrder_item(0).getPayment_status();
			String payStatus = new PropertyUtilityClass().getConstantValue("order_item.pay_status_" + pStatus);
			data.put("paymentStatus",payStatus);
						if(orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_date()!=null) {
			Calendar orderDate=orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_date();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			String dateFormatted = format.format(orderDate.getTime());
			data.put("orderDate", dateFormatted);}
			if(orderItem.getRateClassId()!=0) {
			String rateDesc = jdbcTemplate.queryForObject(
					"select top 1 description +' - '+ CONVERT(varchar,rate_class_effective.effective_date,101) as rateClassDescription  from rate_class_effective where rate_class_id="
							+ orderItem.getRateClassId(),
					String.class);
			data.put("rateClassDescription", rateDesc);
			String desc = jdbcTemplate.queryForObject("select description from rate_class where rate_class_id="+orderItem.getRateClassId(),String.class);
			data.put("rateCard", desc);
			}
			int billToCustID= orderProgress.get(0).getOrderhdr().getOrder_item(0).getBill_to_customer_id();
			int billToCustAddSeq=orderProgress.get(0).getOrderhdr().getOrder_item(0).getBill_to_customer_address_seq();
			String add1 = jdbcTemplate.queryForObject("select address1 as address from customer_address where customer_id="+billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
			String add2 = jdbcTemplate.queryForObject("select address2 as address from customer_address where customer_id="+billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
			String add3 = jdbcTemplate.queryForObject("select address3 as address from customer_address where customer_id="+billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
			String cityState = jdbcTemplate.queryForObject("select concat(city, '  ' ,state) as address from customer_address where customer_id="+billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
			if (orderItem.getAgencyCustomerId()!="") {
				String addres = jdbcTemplate
						.queryForObject("select top 1 address1 as address from customer_address where customer_id="
								+ orderItem.getAgencyCustomerId(), String.class);
				data.put("billToCustomerAddress", String.valueOf(addres != null ? addres : ""));
				String billToFullName = jdbcTemplate.queryForObject(
						" select company from agency where customer_id="+orderItem.getAgencyCustomerId(),String.class);
				data.put("billToFullName", billToFullName);
			} else {
				if (add1 == null && add2 == null && add3 == null) {
					data.put("billToCustomerAddress", cityState);
				} else {
					data.put("billToCustomerAddress", String.valueOf(add1 != null ? add1 : "").concat(" ")
							.concat(add2 != null ? add2 : "").concat(" ").concat(add3 != null ? add3 : ""));
				}
				String billToFullName = jdbcTemplate.queryForObject(
						"select (case when customer_address.fname is null then customer_address.company else customer_address.fname + ' ' + customer_address.lname end )as name from customer_address where customer_id="
								+ billToCustID + " and customer_address_seq=" + billToCustAddSeq,
						String.class);
				data.put("billToFullName", billToFullName);
			}
			int renewToCustID= orderProgress.get(0).getOrderhdr().getOrder_item(0).getRenew_to_customer_id();
			int renewToCustAddSeq=orderProgress.get(0).getOrderhdr().getOrder_item(0).getRenew_to_customer_address_seq();
			String renAdd1 = jdbcTemplate.queryForObject("select address1 as address from customer_address where customer_id="+renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
			String renAdd2 = jdbcTemplate.queryForObject("select address2 as address from customer_address where customer_id="+renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
			String renAdd3 = jdbcTemplate.queryForObject("select address3 as address from customer_address where customer_id="+renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
			String renCityState = jdbcTemplate.queryForObject("select concat(city, '  ' ,state) as address from customer_address where customer_id="+renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
			if (orderItem.getAgencyCustomerId()!="") {
				String addres = jdbcTemplate
						.queryForObject("select top 1 address1 as address from customer_address where customer_id="
								+ orderItem.getAgencyCustomerId(), String.class);
				data.put("renewToCustomerAddress", String.valueOf(addres != null ? addres : ""));
				String renewFullNameTo = jdbcTemplate.queryForObject(
						" select company from agency where customer_id=" + orderItem.getAgencyCustomerId(),
						String.class);
				data.put("renewFullNameTo", renewFullNameTo);
			} else {
				if (renAdd1 == null && renAdd2 == null && renAdd3 == null) {
					data.put("renewToCustomerAddress", renCityState);
				} else {
					data.put("renewToCustomerAddress", String.valueOf(renAdd1 != null ? renAdd1 : "").concat(" ")
							.concat(renAdd2 != null ? renAdd2 : "").concat(" ").concat(renAdd3 != null ? renAdd3 : ""));
				}
				String renewFullName = jdbcTemplate.queryForObject(
						"select (case when customer_address.fname is null then customer_address.company else customer_address.fname + ' ' + customer_address.lname end )as name from customer_address where customer_id="
								+ renewToCustID + " and customer_address_seq=" + renewToCustAddSeq,
						String.class);
				data.put("renewFullNameTo", renewFullName);
			}
			data.put("hasTax",orderProgress.get(0).getOrderhdr().getOrder_item(0).getHas_tax());
			if(Integer.parseInt(orderItem.getSubscriptionDefId())!=0) {
				String subscriptionDef = jdbcTemplate
						.queryForObject("select subscription_def from subscription_def where subscription_def_id="
								+ orderItem.getSubscriptionDefId(), String.class);
				data.put("subscriptionDefinition",subscriptionDef);
				String subscriptionDescrip = jdbcTemplate
						.queryForObject("select description from subscription_def where subscription_def_id="
								+ orderItem.getSubscriptionDefId(), String.class);
				data.put("SubscriptionDefDescription",subscriptionDescrip);
				int subCatId = jdbcTemplate.queryForObject(
						"select subscription_category_id from subscription_def where subscription_def_id="
								+ orderItem.getSubscriptionDefId(),
						Integer.class);
				data.put("subscriptionCategoryId", subCatId);
				String term = jdbcTemplate.queryForObject(
						"select term.term from term inner join subscription_def on term.term_id=subscription_def.term_id where subscription_def.subscription_def_id="
								+ orderItem.getSubscriptionDefId(),
						String.class);
				data.put("termDescription",term);
				}if(Integer.parseInt(orderItem.getOrderCodeType())==1 && (Integer.parseInt(orderItem.getStartIssueId())!=0)) {
				Date issueDAte=jdbcTemplate.queryForObject("select issue_date from issue where issue_id="+orderItem.getStartIssueId(), Date.class);
				SimpleDateFormat issue = new SimpleDateFormat("MM/dd/yyyy");
				String issueFormat = issue.format(issueDAte.getTime());
				data.put("issueDate", issueFormat);
				String enumeration=jdbcTemplate.queryForObject("select enumeration from issue where issue_id="+orderItem.getStartIssueId(), String.class);
				data.put("enumeration",enumeration);
			}
			orderItemList.add(data);
			return orderItemList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItemList;
	}

	@Override
	public List<DropdownModel> getRateClassEffective(int rateClassId) {
		List<DropdownModel> getRateClassEffectiveList = new ArrayList<>();
		try{
			List<Map<String,Object>> dropdownDet = jdbcTemplate.queryForList("select rate_class.rate_class_id,rate_class_effective.rate_class_effective_seq, " + 
					" (rate_class_effective.description+' - '+CONVERT(varchar,rate_class_effective.effective_date,101)) as description,CONVERT(varchar,rate_class_effective.effective_date,101) as effective_date from rate_class_effective inner join rate_class " + 
					" on rate_class.rate_class_id=rate_class_effective.rate_class_id where rate_class.rate_class_id=" +rateClassId);
			for(Map<String,Object> row:dropdownDet) {
				DropdownModel model=new DropdownModel();
				model.setKey(row.get("description").toString());
				model.setDisplay(row.get("effective_date").toString());
				getRateClassEffectiveList.add(model);
			}
			
		}catch(Exception e){
			LOGGER.info("getRateClassEffectiveList : "+e);
		}
		return getRateClassEffectiveList;
	}

	@Override
	public List<Package_edit_response> getOnEditCodeChange(Integer orderhdrId, Integer orderItemSeq, Integer docDefId,
			Integer sourceCodeId,BigDecimal localAmount) {
		List<Package_edit_response> pkgItem = null;
		try {
			pkgItem = orderAddWsdl.getOnEditCodeChange(orderhdrId,orderItemSeq,docDefId,sourceCodeId,localAmount);
			}
		catch (Exception e) {
			e.printStackTrace();
		}
			return pkgItem;
	}
	
	@Override
	public List<Map<String, Object>> changeDateInEditItem(OrderItem orderItem, Integer subscriptionId, int itemCount,
			Optional<String> subscriptionIdList) {
		List<Order_add_response> orderProgress = null;
		OrderItem orderItemModel = new OrderItem();
		List<Map<String, Object>> orderItemList = new ArrayList();
		Map<String, Object> data = new HashMap<>();
		try {

			Integer defId = subscriptionId;
			String defIdList = subscriptionIdList.get();
			orderProgress = orderAddWsdl.orderProgressAddAdd(orderItem, defId, 1, defIdList);
			
			data.put("grossBaseAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getGross_base_amount());
			data.put("grossLocalAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getGross_local_amount());
			data.put("netBaseAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getNet_base_amount());
			data.put("netLocalAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getNet_local_amount());
			data.put("totalTaxBaseAmount",
					orderProgress.get(0).getOrderhdr().getOrder_item(0).getTotal_tax_base_amount());
			data.put("totalTaxLocalAmount",
					orderProgress.get(0).getOrderhdr().getOrder_item(0).getTotal_tax_local_amount());
			Date expireDate = orderProgress.get(0).getOrderhdr().getOrder_item(0).getExpire_date();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			String dateFormatted = format.format(expireDate.getTime());
			data.put("expireDate", dateFormatted);
			Date billDate = orderProgress.get(0).getOrderhdr().getOrder_item(0).getBill_date();
			SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
			String dateFormatted1 = format1.format(billDate.getTime());
			data.put("billDate", dateFormatted1);
			Date startDate = orderProgress.get(0).getOrderhdr().getOrder_item(0).getStart_date();
			SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
			String dateFormatted2 = format2.format(startDate.getTime());
			data.put("startDate", dateFormatted2);
			data.put("localAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(0)
					.getLocal_amount().toString());
			data.put("baseAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(0)
					.getBase_amount().toString());
			if (orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_amt_base() != null) {
				data.put("manualDiscAmtLocal",
						orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_amt_base());
			} else {
				data.put("manualDiscAmtLocal", 0);
			}
			if (orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_amt_local() != null) {
				data.put("manualDiscAmtBase",
						orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_amt_local());
			} else {
				data.put("manualDiscAmtBase", 0);
			}
			if (orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_percentage() != null) {
				data.put("manualDiscAmtBase",
						orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_percentage());
			} else {
				data.put("manualDiscAmtBase", 0);
			}
			int orderItemBreakLength= orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break().length;
			if(orderItemBreakLength> 1 &&  orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(1).getOrder_item_break_type()==3 ) {
				
			if(orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(1).getLocal_amount()!=null ) {
			data.put("localCommission",
					orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(1).getLocal_amount());}
			if(orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(1).getBase_amount()!=null) {
			data.put("baseCommission",
					orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(1).getBase_amount());}	
			}
			data.put("currency",orderProgress.get(0).getOrderhdr().getOrder_item(0).getCurrency());
			data.put("exchangeRate",orderProgress.get(0).getOrderhdr().getOrder_item(0).getExchange_rate());
			if(orderItem.getRateClassId()!=0) {
				String rateDesc = jdbcTemplate.queryForObject(
						"select top 1 description +' - '+ CONVERT(varchar,rate_class_effective.effective_date,101) as rateClassDescription  from rate_class_effective where rate_class_id="
								+ orderItem.getRateClassId(),
						String.class);
				data.put("rateClassDescription", rateDesc);
				String desc = jdbcTemplate.queryForObject("select description from rate_class where rate_class_id="+orderItem.getRateClassId(),String.class);
				data.put("rateCard", desc);
				}
				int billToCustID= orderProgress.get(0).getOrderhdr().getOrder_item(0).getBill_to_customer_id();
				int billToCustAddSeq=orderProgress.get(0).getOrderhdr().getOrder_item(0).getBill_to_customer_address_seq();
				String add1 = jdbcTemplate.queryForObject("select address1 as address from customer_address where customer_id="+billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
				String add2 = jdbcTemplate.queryForObject("select address2 as address from customer_address where customer_id="+billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
				String add3 = jdbcTemplate.queryForObject("select address3 as address from customer_address where customer_id="+billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
				String cityState = jdbcTemplate.queryForObject("select concat(city, '  ' ,state) as address from customer_address where customer_id="+billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
				if(add1 == null && add2 == null && add3 == null ) {
					data.put("billToCustomerAddress",cityState);
				}else {
					data.put("billToCustomerAddress",String.valueOf(add1!=null?add1:"").concat(" ").concat( add2!=null?add2:"" ).concat(" ").concat(add3!=null?add3:""));
				}
				int renewToCustID= orderProgress.get(0).getOrderhdr().getOrder_item(0).getRenew_to_customer_id();
				int renewToCustAddSeq=orderProgress.get(0).getOrderhdr().getOrder_item(0).getRenew_to_customer_address_seq();
				String renAdd1 = jdbcTemplate.queryForObject("select address1 as address from customer_address where customer_id="+renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
				String renAdd2 = jdbcTemplate.queryForObject("select address2 as address from customer_address where customer_id="+renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
				String renAdd3 = jdbcTemplate.queryForObject("select address3 as address from customer_address where customer_id="+renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
				String renCityState = jdbcTemplate.queryForObject("select concat(city, '  ' ,state) as address from customer_address where customer_id="+renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
				if(renAdd1 == null && renAdd2 == null && renAdd3 == null ) {
					data.put("renewToCustomerAddress",renCityState);
				}else {
					data.put("renewToCustomerAddress",String.valueOf(renAdd1!=null?renAdd1:"").concat(" ").concat( renAdd2!=null?renAdd2:"" ).concat(" ").concat(renAdd3!=null?renAdd3:""));
				}
				String billToFullName = jdbcTemplate.queryForObject(
						"select (case when customer_address.fname is null then customer_address.company else customer_address.fname + ' ' + customer_address.lname end )as name from customer_address where customer_id="+ billToCustID+" and customer_address_seq="+billToCustAddSeq, String.class);
				data.put("billToFullName",billToFullName);
				String renewFullName = jdbcTemplate.queryForObject(
						"select (case when customer_address.fname is null then customer_address.company else customer_address.fname + ' ' + customer_address.lname end )as name from customer_address where customer_id="+ renewToCustID+" and customer_address_seq="+renewToCustAddSeq, String.class);
				data.put("renewFullNameTo",renewFullName);
			
			orderItemList.add(data);
			return orderItemList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItemList;
	}

	@Override
	public List<OrderItem> packageMembersEditITem(OrderItem orderItem, Integer subscriptionId, int i,
			Optional<String> subscriptionIdList) {
		List<Order_add_response> orderProgress = null;
		
		List<OrderItem> orderItemList = new ArrayList();
		try {

			Integer defId = subscriptionId;
			String defIdList = subscriptionIdList.get();
			orderProgress = orderAddWsdl.orderProgressAddAdd(orderItem, defId, 1, defIdList);
			System.out.println("orderITemDEtails--->"
					+ orderProgress.get(0).getOrderhdr().getOrder_item(0).getGross_base_amount());
			int num=orderProgress.get(0).getOrderhdr().getOrder_item().length;
			
				if(num>1 ) {
					for (int j = 1; j < num; j++) {
					OrderItem orderItemModel = new OrderItem();	
					orderItemModel.setValue(String.valueOf(j));
				orderItemModel.setGrossLocalAmount(
						orderProgress.get(0).getOrderhdr().getOrder_item()[j].getGross_local_amount().toString());
				orderItemModel.setGrossBaseAmount(
						orderProgress.get(0).getOrderhdr().getOrder_item()[j].getGross_base_amount().toString());
				orderItemModel.setNetLocalAmount(
						orderProgress.get(0).getOrderhdr().getOrder_item()[j].getNet_local_amount().toString());
				orderItemModel.setNetBaseAmount(
						orderProgress.get(0).getOrderhdr().getOrder_item()[j].getNet_base_amount().toString());
				orderItemModel.setOrderCategory(orderProgress.get(0).getOrderhdr().getOrder_item()[j].getOrder_category());
				orderItemModel.setAgencyCustomerId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAgency_customer_id()));
				if(orderProgress.get(0).getOrderhdr().getOrder_item(0).getAgency_customer_id()==0)
				{
					orderItemModel.setAgencyCustomerId("");
				}
				orderItemModel
						.setBillToCustomerId(orderProgress.get(0).getOrderhdr().getOrder_item(j).getBill_to_customer_id());
				int customerId = orderProgress.get(0).getOrderhdr().getOrder_item(j).getCustomer_id();
				orderItemModel.setAddonToOrderhdrId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAddon_to_orderhdr_id()));
				orderItemModel.setAltShipCustomerAddressSeq(
						orderProgress.get(0).getOrderhdr().getOrder_item(j).getAlt_ship_customer_address_seq());
				orderItemModel.setAddonToOrderItemSeq(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAddon_to_order_item_seq()));
				orderItemModel
						.setAltShipCustomerId(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAlt_ship_customer_id());
				orderItemModel.setAltShipDelCalc(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAlt_ship_del_calc()));
				orderItemModel.setAddonToOrderItemSeq(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAddon_to_order_item_seq()));
				orderItemModel
						.setAltShipCustomerId(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAlt_ship_customer_id());
				orderItemModel.setAltShipDelCalc(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAlt_ship_del_calc()));
				orderItemModel.setAsynchronousAutoRenew(
						orderProgress.get(0).getOrderhdr().getOrder_item(j).getAsynchronous_auto_renew());
				orderItemModel
						.setAttachExist(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAttach_exist()));
			orderItemModel.setAuditNameTitleId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAudit_name_title_id()));
				orderItemModel.setAuditQualCategory(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAudit_qual_category()));
				orderItemModel.setAuditSourceId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAudit_qual_source_id()));
				orderItemModel.setAuditSalesChannelId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAudit_sales_channel_id()));
				orderItemModel.setAuditSubscriptionTypeId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAudit_subscription_type_id()));
				orderItemModel.setAutoPayment(orderProgress.get(0).getOrderhdr().getOrder_item(j).getAuto_payment());
				orderItemModel.setAutoRenewNotifySent(
						orderProgress.get(0).getOrderhdr().getOrder_item(j).getAuto_renew_notify_sent());
				orderItemModel.setBillToCustomerAddressSeq(
						orderProgress.get(0).getOrderhdr().getOrder_item(j).getBill_to_customer_address_seq());
				orderItemModel
						.setBackordQty(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getBackord_qty()));
				Date billDate = orderProgress.get(0).getOrderhdr().getOrder_item(j).getBill_date();
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				String dateFormatted = format.format(billDate.getTime());
				orderItemModel.setBillDate(dateFormatted);
				orderItemModel.setBillingDef(orderProgress.get(0).getOrderhdr().getOrder_item(j).getBilling_def());
				orderItemModel.setBillingDefTestSeq(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getBilling_def_test_seq()));
				orderItemModel
						.setBillingType(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getBilling_type()));
				orderItemModel.setBundleQty(orderProgress.get(0).getOrderhdr().getOrder_item(j).getBundle_qty());
				orderItemModel.setIsBackOrdered(orderProgress.get(0).getOrderhdr().getOrder_item(j).getIs_back_ordered());
				orderItemModel.setCalendarUnit(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getCalendar_unit()));
				orderItemModel
						.setCancelDD(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getCancel_date()));
				orderItemModel.setCancelReason(orderProgress.get(0).getOrderhdr().getOrder_item(j).getCancel_reason());
				orderItemModel.setCancelledOrderAmount(
						Double.parseDouble(orderProgress.get(0).getOrderhdr().getOrder_item(j).getCc_amount_due().toString()));
				orderItemModel.setDue(Double.parseDouble(
						orderProgress.get(0).getOrderhdr().getOrder_item(j).getCc_amount_due_paycurr().toString()));
				orderItemModel.setBaseAmount(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getCc_item_amount().toString()));
				orderItemModel.setChangeQtyFlag(orderProgress.get(0).getOrderhdr().getOrder_item(j).getChange_qty_flag());
				orderItemModel.setChargeOnCancellation(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getCharge_on_cancellation()));
				orderItemModel.setCurrency(orderProgress.get(0).getOrderhdr().getOrder_item(j).getCurrency());
				orderItemModel
						.setCustomerAddressSeq(orderProgress.get(0).getOrderhdr().getOrder_item(j).getCustomer_address_seq());
				orderItemModel.setCustomerGroupId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getCustomer_group_id()));
				orderItemModel.setCustomerId(orderProgress.get(0).getOrderhdr().getOrder_item(j).getCustomer_id());
				orderItemModel.setDateStamp(orderProgress.get(0).getOrderhdr().getOrder_item(j).getDate_stamp());
				orderItemModel.setDealId(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getDeal_id()));
				orderItemModel.setDeliveryMethod(orderProgress.get(0).getOrderhdr().getOrder_item(j).getDelivery_method());
				orderItemModel
						.setDeliveryMethodPerm(orderProgress.get(0).getOrderhdr().getOrder_item(j).getDelivery_method_perm());
				orderItemModel.setDiscClassEffectiveSeq(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getDisc_class_effective_seq()));
				orderItemModel.setDiscountCardSeq(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getDiscount_card_seq()));
				orderItemModel.setDiscountClassId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getDiscount_class_id()));
				orderItemModel
						.setDistributionMethod(orderProgress.get(0).getOrderhdr().getOrder_item(j).getDistribution_method());
				orderItemModel.setDuration(orderProgress.get(0).getOrderhdr().getOrder_item(j).getDuration());
				orderItemModel
						.setElectronicDelivery(orderProgress.get(0).getOrderhdr().getOrder_item(j).getElectronic_delivery());
				orderItemModel.setElectronicDocumentIdentifier(
						orderProgress.get(0).getOrderhdr().getOrder_item(j).getElectronic_document_identifier());
				orderItemModel.setExRateClassEffectiveSeq(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getEx_rate_class_effective_seq()));
				orderItemModel.setExRateClassId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getEx_rate_class_id()));
				orderItemModel.setExRatecardSeq(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getEx_ratecard_seq()));
				orderItemModel
						.setExchangeRate(orderProgress.get(0).getOrderhdr().getOrder_item(j).getExchange_rate().toString());
				Date expireDate = orderProgress.get(0).getOrderhdr().getOrder_item(j).getExpire_date();
				SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
				String dateFormatted2 = format2.format(expireDate.getTime());
				orderItemModel.setExpireDate(dateFormatted2);
				orderItemModel.setExtIssleft(orderProgress.get(0).getOrderhdr().getOrder_item(j).getExt_iss_left());
				orderItemModel.setExtIssTot(orderProgress.get(0).getOrderhdr().getOrder_item(j).getExt_iss_tot());
				orderItemModel.setExtendedDays(orderProgress.get(0).getOrderhdr().getOrder_item(j).getExtended_days());
				orderItemModel.setGroupOrder(orderProgress.get(0).getOrderhdr().getOrder_item(j).getGroup_order());
				orderItemModel.setHasBeenRenewed(orderProgress.get(0).getOrderhdr().getOrder_item(j).getHas_been_renewed());
				orderItemModel
						.setHasDeliveryCharge(orderProgress.get(0).getOrderhdr().getOrder_item(j).getHas_delivery_charge());
				orderItemModel.setHasPremium(orderProgress.get(0).getOrderhdr().getOrder_item(j).getHas_premium());
				orderItemModel.setHasTax(orderProgress.get(0).getOrderhdr().getOrder_item(j).getHas_tax());
				orderItemModel
						.setInventoryId(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getInventory_id()));
				Date invoiceDate = orderProgress.get(0).getOrderhdr().getOrder_item(j).getInvoice_date();
				SimpleDateFormat format3 = new SimpleDateFormat("MM/dd/yyyy");
				String dateFormatted3 = format3.format(invoiceDate.getTime());
				orderItemModel.setInvoiceDate(dateFormatted3);
				orderItemModel
						.setInvoiceId(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getInvoice_id()));
				orderItemModel.setIsBackOrdered(orderProgress.get(0).getOrderhdr().getOrder_item(j).getIs_back_ordered());
				orderItemModel.setIsComplimentary(orderProgress.get(0).getOrderhdr().getOrder_item(j).getIs_complimentary());
				orderItemModel.setIsProforma(orderProgress.get(0).getOrderhdr().getOrder_item(j).getIs_proforma());
				orderItemModel.setItemUrl(orderProgress.get(0).getOrderhdr().getOrder_item(j).getItem_url());

				orderItemModel.setMaxCheckOutAmt(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getMax_check_out_amt()));

				orderItemModel.setnCalUnitsPerSeg(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getN_cal_units_per_seg()));
				orderItemModel
						.setnCheckedOut(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getN_checked_out()));
				orderItemModel.setnDaysGraced(orderProgress.get(0).getOrderhdr().getOrder_item(j).getN_days_graced());
				orderItemModel.setnDelIssLeft(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getN_del_iss_left()));
				orderItemModel
						.setnInvEffort(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getN_inv_efforts()));
				orderItemModel.setnNonPaidIssues(orderProgress.get(0).getOrderhdr().getOrder_item(j).getN_nonpaid_issues());
				orderItemModel.setnRemainingNonPaidIssues(
						orderProgress.get(0).getOrderhdr().getOrder_item(j).getN_remaining_nonpaid_issues());
				orderItemModel.setnRemainingNonPaidIssues(
						orderProgress.get(0).getOrderhdr().getOrder_item(j).getN_remaining_paid_issues());
				orderItemModel
						.setnRenEffort(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getN_ren_effort()));
				orderItemModel.setnSegmentsLeft(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getN_segments_left()));
				orderItemModel.setnTax_updates(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getN_tax_updates()));
				orderItemModel.setNoteExist(orderProgress.get(0).getOrderhdr().getOrder_item(j).getNote_exist());
				orderItemModel.setNumberVolumeSets(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getNumber_volume_sets()));
				orderItemModel.setOrderCategory(orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_category());
				int orderCodeId = orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_code_id();
				orderItemModel
						.setOrderCodeID(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_code_id()));
				Calendar date = orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_date();
				SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
				String dateFormatted1 = format1.format(date.getTime());
				orderItemModel.setOrderDate(dateFormatted1);
				orderItemModel.setOrderItemType(orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_item_type());
				orderItemModel.setOrderCodeType(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_item_type()));
				orderItemModel.setOrderQty(orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_qty());
				orderItemModel.setLocalAmount(orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_item_amt_break(0)
						.getLocal_amount().toString());
				orderItemModel.setBaseAmount(orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_item_amt_break(0)
						.getBase_amount().toString());
				orderItemModel
						.setState(orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_item_amt_break(0).getState());
				int Status = orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_status();
				String orderStatus = new PropertyUtilityClass().getConstantValue("order_item.order_status_"+Status);
				orderItemModel.setOrder_status(orderStatus);
				orderItemModel.setOrderStatus(Status);
				orderItemModel.setOrderType(orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_type());
				orderItemModel.setOrigOrderQty(orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrig_order_qty());
				orderItemModel.setPackageContentSeq(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getPackage_content_seq()));
				orderItemModel
						.setPackageID(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getPackage_id()));
				orderItemModel.setPackageInstance(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getPackage_instance()));
				orderItemModel.setPackageContentSeq(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getPayment_account_seq()));
				int pStatus = orderProgress.get(0).getOrderhdr().getOrder_item(j).getPayment_status();
				String payStatus = new PropertyUtilityClass().getConstantValue("order_item.pay_status_" + pStatus);
				orderItemModel.setPayment_status(payStatus);
				orderItemModel.setPercentOfBasicPrice(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getPercent_of_basic_price()));
				orderItemModel.setPerpetualOrder(orderProgress.get(0).getOrderhdr().getOrder_item(j).getPerpetual_order());
				orderItemModel.setPkgDefId(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getPkg_def_id()));
				orderItemModel
						.setPkgItemSeq(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getPkg_item_seq()));
				orderItemModel.setPremToOrderItemSeq(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getPrem_to_order_item_seq()));
				orderItemModel.setPrepaymentReq(orderProgress.get(0).getOrderhdr().getOrder_item(j).getPrepayment_req());
				orderItemModel
						.setProductId(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getProduct_id()));
				orderItemModel.setPubRotationId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getPub_rotation_id()));
				orderItemModel.setRateClassEffectiveSeq(
						orderProgress.get(0).getOrderhdr().getOrder_item(j).getRate_class_effective_seq());
				orderItemModel.setRateClassId(orderProgress.get(0).getOrderhdr().getOrder_item(j).getRate_class_id());
				int rateClassId = orderProgress.get(0).getOrderhdr().getOrder_item(j).getRate_class_id();
				orderItemModel.setRefundStatus(orderProgress.get(0).getOrderhdr().getOrder_item(j).getRefund_status());
				orderItemModel.setRenewToCustomerAddressSeq(
						orderProgress.get(0).getOrderhdr().getOrder_item(j).getRenew_to_customer_address_seq());
				orderItemModel
						.setRenewToCustomerId(orderProgress.get(0).getOrderhdr().getOrder_item(j).getRenew_to_customer_id());
				orderItemModel.setRenewalCategory(orderProgress.get(0).getOrderhdr().getOrder_item(j).getRenewal_category());
				orderItemModel.setRenewalDef(orderProgress.get(0).getOrderhdr().getOrder_item(j).getRenewal_def());
				orderItemModel.setRenewalDefTestSeq(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getRenewal_def_test_seq()));
				orderItemModel.setRenewalOrderItemSeq(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getRenewal_order_item_seq()));
				orderItemModel.setRenewalOrderhdrId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getRenewal_orderhdr_id()));
				orderItemModel.setRenewalStatus(orderProgress.get(0).getOrderhdr().getOrder_item(j).getRenewal_status());
				orderItemModel.setRenewedFromSubscripId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getRenewed_from_subscrip_id()));
				orderItemModel.setRevenueMethod(orderProgress.get(0).getOrderhdr().getOrder_item(j).getRevenue_method());
				orderItemModel.setServiceExist(orderProgress.get(0).getOrderhdr().getOrder_item(j).getService_exist());
				orderItemModel.setShipQty(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getShip_qty()));
				orderItemModel
						.setShippingPriceList(orderProgress.get(0).getOrderhdr().getOrder_item(j).getShipping_price_list());
				int sourceCodeId = orderProgress.get(0).getOrderhdr().getOrder_item(j).getSource_code_id();
				orderItemModel.setSourceCodeID(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getSource_code_id()));
				Date startDate = orderProgress.get(0).getOrderhdr().getOrder_item(j).getStart_date();
				SimpleDateFormat format4 = new SimpleDateFormat("MM/dd/yyyy");
				String dateFormatted4 = format4.format(startDate.getTime());
				orderItemModel.setStartDate(dateFormatted4);
				orderItemModel.setStartIssueId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getStart_issue_id()));
				orderItemModel.setStopIssueId(orderProgress.get(0).getOrderhdr().getOrder_item(j).getStop_issue_id());
				orderItemModel
						.setSubscripId(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getSubscrip_id()));
				orderItemModel
						.setSubscripStartType(orderProgress.get(0).getOrderhdr().getOrder_item(j).getSubscrip_start_type());
				orderItemModel.setSubscriptionDefId(
						String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getSubscription_def_id()));
				orderItemModel.setTimeUnitOptions(orderProgress.get(0).getOrderhdr().getOrder_item(j).getTime_unit_options());
				orderItemModel.setTotalTaxBaseAmount(
						orderProgress.get(0).getOrderhdr().getOrder_item(j).getTotal_tax_base_amount().toString());
				orderItemModel.setTotalTaxLocalAmount(
						orderProgress.get(0).getOrderhdr().getOrder_item(j).getTotal_tax_local_amount().toString());
				orderItemModel
						.setTrialPeriod(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getTrial_period()));
				orderItemModel.setTrialType(orderProgress.get(0).getOrderhdr().getOrder_item(j).getTrial_type());
				orderItemModel
						.setUnitExcess(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getUnit_excess()));
				orderItemModel
						.setUnitTypeId(String.valueOf(orderProgress.get(0).getOrderhdr().getOrder_item(j).getUnit_type_id()));
				orderItemModel.setUserCode(orderProgress.get(0).getOrderhdr().getOrder_item(j).getUser_code());
				/*orderItemModel.setAddress1(orderProgress.get(0).getCustomer().getCustomer_address(j).getAddress1());
				orderItemModel
						.setBillToCustomerAddress(orderProgress.get(0).getCustomer().getCustomer_address(j).getAddress1());
				orderItemModel
						.setRenewToCustomerAddress(orderProgress.get(0).getCustomer().getCustomer_address(j).getAddress1());
				orderItemModel.setCustomerAddressSeq(
						orderProgress.get(0).getCustomer().getCustomer_address(j).getCustomer_address_seq());*/
				orderItemModel.setUserCode(orderProgress.get(0).getCustomer().getUser_code());
				String fname = jdbcTemplate.queryForObject(
						"select top 1 fname from customer_address where customer_id=" + customerId, String.class);
				orderItemModel.setFullName(fname);
				String fullname = jdbcTemplate.queryForObject(
						"select  top 1 CONCAT (fname ,lname) as fullname from customer_address where customer_id="
								+ customerId,
						String.class);
				orderItemModel.setBillToFullName(fullname);
				orderItemModel.setRenewFullNameTo(fullname);
				/*String address = jdbcTemplate.queryForObject(
						"select top 1 fname from customer_address where customer_id=" + customerId, String.class);*/
				String orderCode = jdbcTemplate.queryForObject(
						"select order_code from order_code where order_code_id=" + orderCodeId, String.class);
				orderItemModel.setOrderCode(orderCode);
				String sourceCode = jdbcTemplate.queryForObject(
						"select source_code from source_code where source_code_id=" + sourceCodeId, String.class);
				orderItemModel.setSourceCode(sourceCode);
				String sourceDescription = jdbcTemplate.queryForObject(
						"select description from source_code where source_code_id=" + sourceCodeId, String.class);
				orderItemModel.setSourceCodeDescription(sourceDescription);
				String orderDescription = jdbcTemplate.queryForObject(
						"select description from order_code where order_code_id=" + orderCodeId, String.class);
				orderItemModel.setOrderCodeDescription(orderDescription);
				int orderCodeType = orderProgress.get(0).getOrderhdr().getOrder_item(j).getOrder_item_type();
				String pageName = jdbcTemplate.queryForObject(
						"select top 1( case when ((start_type=0 or start_type=1) and order_code_type=0) then 'Issue Based Subscription' when ((start_type=0 or start_type=1) and order_code_type=1) then 'Single Copy' when order_code_type=4 then 'Package Edit'  when order_code_type=2 then 'Product' when ((start_type=4 or start_type=5) and order_code_type=0) then 'Unit Based Subscription' when order_code_type=8 then 'Shipping Price List'"
								+ " else 'Date Based Subscription' end)as pageName from order_code where order_code_id="
								+ orderCodeId,
						String.class);
				orderItemModel.setPageName(pageName);
				orderItemModel.setOcId(orderProgress.get(0).getOrderhdr().getOrder_item(j).getOc_id());
				orderItemModel.setSubscripStartType(orderProgress.get(0).getOrderhdr().getOrder_item(j).getSubscrip_start_type());
				int startType=jdbcTemplate.queryForObject("select start_type from order_code where order_code_id="+orderCodeId,Integer.class);
				orderItemModel.setStartType(startType);
				orderItemModel.setPaymentStatus(orderProgress.get(0).getOrderhdr().getOrder_item(j).getPayment_status());
				int ocId=orderProgress.get(0).getOrderhdr().getOrder_item(j).getOc_id();
				String oc = jdbcTemplate.queryForObject("select oc from oc where oc_id="+ocId, String.class);
				orderItemModel.setOrderClass(oc);
				orderItemList.add(orderItemModel);
			}
			}
				
			return orderItemList;
			} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return orderItemList;
		}
		
		}
	@Override
	public List<Map<String, Object>> getExistingOrderItemData(Long orderhdrId, Integer orderItemSeq) {
		List<Map<String, Object>> existingOrderItemData = null;
		try {
			 StringBuilder itemBreakQuery = new StringBuilder("SELECT * FROM order_item WHERE orderhdr_id=").append(orderhdrId).append(" and order_item_seq=").append(orderItemSeq).append(" ORDER BY orderhdr_id,order_item_seq");
			 existingOrderItemData = jdbcTemplate.queryForList(itemBreakQuery.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return existingOrderItemData;
	}

	@Override
	public List<Map<String, Object>> getExistingOrderItemBreakData(Long orderhdrId, Integer orderItemSeq) {
		List<Map<String, Object>> existingItemBreakData = null;
		try {
			 StringBuilder itemBreakQuery = new StringBuilder("SELECT * FROM order_item_amt_break WHERE orderhdr_id=").append(orderhdrId).append(" and order_item_seq=").append(orderItemSeq).append(" ORDER BY orderhdr_id,order_item_seq,order_item_amt_break_seq");
			 existingItemBreakData = jdbcTemplate.queryForList(itemBreakQuery.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return existingItemBreakData;
	}

	@Override
	public List<Map<String, Object>> onOrderCodeSelection(OrderItem orderItem, int subscriptionId, int i,
			Optional<String> subscriptionIdList) {
		List<Order_add_response> orderProgress = null;
		OrderItem orderItemModel = new OrderItem();
		List<Map<String, Object>> orderItemList = new ArrayList();
		Map<String, Object> data = new HashMap<>();
		try {

			Integer defId = subscriptionId;
			String defIdList = subscriptionIdList.get();
			orderProgress = orderAddWsdl.orderProgressAddAdd(orderItem, defId, 1, defIdList);
			
			data.put("grossBaseAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getGross_base_amount());
			data.put("grossLocalAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getGross_local_amount());
			data.put("netBaseAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getNet_base_amount());
			data.put("netLocalAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getNet_local_amount());
			data.put("totalTaxBaseAmount",
					orderProgress.get(0).getOrderhdr().getOrder_item(0).getTotal_tax_base_amount());
			data.put("totalTaxLocalAmount",
					orderProgress.get(0).getOrderhdr().getOrder_item(0).getTotal_tax_local_amount());
			Date billDate = orderProgress.get(0).getOrderhdr().getOrder_item(0).getBill_date();
			SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
			String dateFormatted1 = format1.format(billDate.getTime());
			data.put("billDate", dateFormatted1);
			Date startDate = orderProgress.get(0).getOrderhdr().getOrder_item(0).getStart_date();
			SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
			String dateFormatted2 = format2.format(startDate.getTime());
			data.put("startDate", dateFormatted2);
			data.put("localAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(0)
					.getLocal_amount().toString());
			data.put("baseAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(0)
					.getBase_amount().toString());
			if (orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_amt_base() != null) {
				data.put("manualDiscAmtLocal",
						orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_amt_base());
			} else {
				data.put("manualDiscAmtLocal", 0);
			}
			if (orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_amt_local() != null) {
				data.put("manualDiscAmtBase",
						orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_amt_local());
			} else {
				data.put("manualDiscAmtBase", 0);
			}
			if (orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_percentage() != null) {
				data.put("manualDiscAmtBase",
						orderProgress.get(0).getOrderhdr().getOrder_item(0).getManual_disc_percentage());
			} else {
				data.put("manualDiscAmtBase", 0);
			}
			int rateClassId=orderProgress.get(0).getOrderhdr().getOrder_item(0).getRate_class_id();
			data.put("currency", orderProgress.get(0).getOrderhdr().getOrder_item(0).getCurrency());
			data.put("rateClassId", rateClassId);
			if(rateClassId!=0) {
			String rateDesc = jdbcTemplate.queryForObject(
					"select top 1 description +' - '+ CONVERT(varchar,rate_class_effective.effective_date,101) as rateClassDescription  from rate_class_effective where rate_class_id="
							+ rateClassId,
					String.class);
			data.put("rateClassDescription", rateDesc);
			String desc = jdbcTemplate.queryForObject("select description from rate_class where rate_class_id="+rateClassId,String.class);
			data.put("rateCard", desc);
			}
			int Status = orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_status();
			String orderStatus = new PropertyUtilityClass().getConstantValue("order_item.order_status_"+Status);
			data.put("orderStatus",orderStatus);
			
			int pStatus = orderProgress.get(0).getOrderhdr().getOrder_item(0).getPayment_status();
			String payStatus = new PropertyUtilityClass().getConstantValue("order_item.pay_status_" + pStatus);
			data.put("paymentStatus",pStatus);
			if(Integer.parseInt(orderItem.getOrderCodeType())==0) {
			String subscriptionDescrip = jdbcTemplate.queryForObject(
					"select description from subscription_def where subscription_def_id=" + subscriptionId,
					String.class);
			data.put("subscriptionDefDescription",subscriptionDescrip);}
			if(orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_date()!=null) {
			Calendar date = orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_date();
				SimpleDateFormat format3 = new SimpleDateFormat("MM/dd/yyyy");
				String dateFormatted3 = format3.format(date.getTime());
				data.put("orderDate",dateFormatted3);}
			if(orderProgress.get(0).getOrderhdr().getOrder_item(0).getExpire_date()!=null) {
			Date expireDate = orderProgress.get(0).getOrderhdr().getOrder_item(0).getExpire_date();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			String dateFormatted = format.format(expireDate);
			data.put("expireDate", dateFormatted);
			}
				
			orderItemList.add(data);
			return orderItemList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItemList;
	}

	@Override
	public List<Map<String, Object>> getSubscripDetails(int subscrip_id) {
		LOGGER.info("Inside getorderClass");
		List<Map<String, Object>> subscripDetails = null;
		try {
				StringBuilder itemBreakQuery = new StringBuilder("SELECT subscrip_id,n_total_issues_left,start_issue_id,stop_issue_id FROM subscrip where subscrip_id=").append(subscrip_id);
				subscripDetails = jdbcTemplate.queryForList(itemBreakQuery.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return subscripDetails;
	}

	@Override
	public List<Map<String, Object>> getpkgMemberListForReq(int orderCodeId) {
		LOGGER.info("Inside getpkgMemberListForReq");
		List<Map<String, Object>> pkgMember = null;
		try {
				StringBuilder pkgMemberQuery = new StringBuilder("select required,item_order_code_id from pkg_content where required=1 and order_code_id= ").append(orderCodeId);
				pkgMember = jdbcTemplate.queryForList(pkgMemberQuery.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return pkgMember;
	}

	@Override
	public List<Package_edit_response> getIncludeTax(Integer orderhdrId, Integer orderItemSeq, Integer docDefId,
			int yesNo) {
		List<Package_edit_response> returnData = null;
		try {
			returnData = new OrderAddWsdl().getIncludeTax(orderhdrId,orderItemSeq,docDefId,yesNo); 
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return returnData;
	}

	@Override
	public List<Map<String, Object>> selectionOfRateClass(OrderItem orderItem, Integer subscriptionId, int i,
			Optional<String> subscriptionIdList) {
		List<Order_add_response> orderProgress = null;
		OrderItem orderItemModel = new OrderItem();
		// List<OrderItem> orderItemList = new ArrayList();
		List<Map<String, Object>> orderItemList = new ArrayList();
		Map<String, Object> data = new HashMap<>();
		try {

			Integer defId = subscriptionId;
			String defIdList = subscriptionIdList.get();
			orderProgress = orderAddWsdl.orderProgressAddAdd(orderItem, defId, 1, defIdList);
			System.out.println("orderITemDEtails--->"
					+ orderProgress.get(0).getOrderhdr().getOrder_item(0).getGross_base_amount());
			data.put("localAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(0)
					.getLocal_amount().toString());
			data.put("baseAmount", orderProgress.get(0).getOrderhdr().getOrder_item(0).getOrder_item_amt_break(0)
					.getBase_amount().toString());
			data.put("currency", orderProgress.get(0).getOrderhdr().getOrder_item(0).getCurrency());
			data.put("rateClassId", orderProgress.get(0).getOrderhdr().getOrder_item(0).getRate_class_id());
			data.put("rateClassEffectiveSeq",
					orderProgress.get(0).getOrderhdr().getOrder_item(0).getRate_class_effective_seq());
			data.put("exhangeRate", orderProgress.get(0).getOrderhdr().getOrder_item(0).getExchange_rate());
			if(orderItem.getRateClassId()!=0) {
				String rateDesc = jdbcTemplate.queryForObject(
						"select top 1 description +' - '+ CONVERT(varchar,rate_class_effective.effective_date,101) as rateClassDescription  from rate_class_effective where rate_class_id="
								+ orderItem.getRateClassId(),
						String.class);
				data.put("rateClassDescription", rateDesc);
				String desc = jdbcTemplate.queryForObject("select description from rate_class where rate_class_id="+orderItem.getRateClassId(),String.class);
				data.put("rateCard", desc);
				}
			orderItemList.add(data);
			return orderItemList;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderItemList;
	}

	@Override
	public int getmemberListCount(long orderhdrId) {
		int  memberCount=0 ;
		try {
			memberCount = jdbcTemplate.queryForObject("select count(orderhdr_id) from order_item where orderhdr_id= "+orderhdrId , Integer.class);
			memberCount = memberCount-1;
		}
		catch(Exception e) {
			 LOGGER.error(ERROR + e);
		}
		return memberCount;
		
	}
}
	