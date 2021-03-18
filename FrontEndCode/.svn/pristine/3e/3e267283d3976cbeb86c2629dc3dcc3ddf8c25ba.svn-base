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
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.mps.think.resultMapper.*;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.PropertyUtilityClass;
import com.mps.think.wsdl.OrderAddWsdl;
import java.time.temporal.ChronoUnit;
import Think.XmlWebServices.Order_code_for_price_list;
import com.mps.think.daoImpl.OrderSourceOfferDaoImpl;


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
			 //journalParameters.put("journal_id", (jdbcTemplate.queryForObject("select max(journal_id) from journal", Long.class))+1);
			 //long journal_id = customerUtility.getMaxJournalId() + 1;
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
			//editTrailParameters_1.put("edit_trail_id", (jdbcTemplate.queryForObject("select max(edit_trail_id) from edit_trail", Long.class))+1);
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
			
			//eventQueueParameters.put("event_queue_id", (jdbcTemplate.queryForObject("select max(event_queue_id) from event_queue", Long.class))+1) ;
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
	public List<OrderItem> customerOrderPackageEdit(long orderhdrId,int orderItemType,int orderCodeId,long customerId, int orderItemSeq) {		
		List<Map<String, Object>> altCustomerAddress=null;
		List<Map<String, Object>> billToCustomerAddress=null;
		List<Map<String, Object>> orderItemList = null;
		List<OrderItem> OrderItemLists = new ArrayList<>();
		try{
			StringBuilder editQuery=new StringBuilder();
			editQuery.append("select revenue_percent,oc.commodity_code,cadrs.special_tax_id,s.subscription_def,rc.description,sc.subscription_category_id,s.media,s.edition,sc.description as subscriptionCategoryDescription,t.description as termDescription,cadrs.fname,cadrs.lname, cadrs.address1,cadrs.address2,cadrs.address3,oc.order_code,oc.description as orderCodeDes," + 
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
					" left join pkg_def_content on pkg_def_content.subscription_def_id=oi.subscription_def_id" +
					" left join rate_class rc on rc.rate_class_id=oi.rate_class_id" +
					" where oi.orderhdr_id = "+orderhdrId+" and oi.pkg_item_seq="+orderItemSeq+" ");
			        //and pkg_def_content.order_code_id="+orderCodeId+"");
				
			orderItemList = jdbcTemplate.queryForList(editQuery.toString());
						
			for(Map<String, Object> orderItemMap:orderItemList){	
				OrderItem orderItem=new OrderItem();
				orderItem.setPageName(orderItemMap.get("pageName").toString());
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
				orderItem.setRateClassDescription(orderItemMap.get("rateClassDescription").toString());
				orderItem.setRateClassEffectiveDate(new PropertyUtilityClass().getDateFormatter((orderItemMap.get("effective_date").toString())));
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
			String query="SELECT oi.delivery_method,dm.description AS delivery_method_description,oi.distribution_method,cadrs.special_tax_id,pkg_def_id,s.subscription_def,rc.description,sc.subscription_category_id,s.media,s.edition,sc.description as subscriptionCategoryDescription,t.description as termDescription,cadrs.fname,cadrs.lname,cadrs.address1,cadrs.address2,cadrs.address3,oc.order_code,oc.description as orderCodeDes,"
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
				}else 
				{
					orderItem.setLocalAmount((orderItemMap.get("localAmount").toString()));				
					orderItem.setBaseAmount((orderItemMap.get("baseAmount").toString()));
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
					List<Map<String, Object>> renewCustomerAddress=jdbcTemplate.queryForList("select (case when customer_address.fname is null then customer_address.company else customer_address.fname + ' ' + customer_address.lname end )as name , concat(customer_address.address1,' ',customer_address.address2,' ' ,customer_address.address3) as address from customer_address where customer_id="+orderItemMap.get("renew_to_customer_id")+" and customer_address_seq="+orderItemMap.get("renew_to_customer_address_seq"));
					for(Map<String,Object> map:renewCustomerAddress)
					{
						orderItem.setRenewFullNameTo(map.get("name")!=null?(String)map.get("name"):null);
						orderItem.setRenewToCustomerAddress(map.get("address")!=null?(String)map.get("address"):null);
					}					
				}
				if(orderItemType == 4)
				{
					List<Map<String, Object>> subscripDef=jdbcTemplate.queryForList("select * from view_pkg_def where order_code_id="+orderCodeId+" and pkg_def_id="+orderItemMap.get("pkg_def_id")+"");
					for(Map<String,Object> map:subscripDef) 
					{
						orderItem.setSubscriptionDef(map.get("pkg_def")!=null?(String)map.get("pkg_def"):null);
						orderItem.setSubscriptionDefDescription(map.get("description")!=null?(String)map.get("description"):null);
					}
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
				orderItem.setSourceCodeDescription(orderItemMap.get("sourceCodeDes")!=null?orderItemMap.get("sourceCodeDes").toString():"");
				orderItem.setOrderCodeDescription(orderItemMap.get("orderCodeDes").toString());				
				orderItem.setBundleQty(Integer.parseInt(orderItemMap.get("bundle_qty").toString()));
				orderItem.setOrderQty(Integer.parseInt(orderItemMap.get("order_qty").toString()));
				orderItem.setShipQty(orderItemMap.get("ship_qty")!=null?(String) orderItemMap.get("ship_qty"):"");
				if(orderItemType==0) 
				{
					orderItem.setnIssueLeft(orderItemMap.get("n_issues_left").toString());
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
				orderItem.setPoNumber((orderItemMap.get("po_number")!=null?(String) orderItemMap.get("po_number"):null));
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
					altCustomerAddress=jdbcTemplate.queryForList("select (case when customer_address.fname is null then customer_address.company else customer_address.fname + ' ' + customer_address.lname end )as name , concat(customer_address.address1,' ',customer_address.address2,' ' ,customer_address.address3) as address from customer_address where customer_id="+orderItemMap.get("alt_ship_customer_id")+" and customer_address_seq="+orderItemMap.get("alt_ship_customer_address_seq"));
					for(Map<String,Object> map:altCustomerAddress)
					{
						orderItem.setAltFullNameTo(map.get("name")!=null?(String)map.get("name"):null);
						orderItem.setAltCustomerAddress(map.get("address")!=null?(String)map.get("address"):null);
					}					
				}
				if(orderItemMap.get("bill_to_customer_id")!=null)
				{					
					billToCustomerAddress = jdbcTemplate.queryForList("select (case when customer_address.fname is null then customer_address.company else customer_address.fname + ' ' + customer_address.lname end )as name , concat(customer_address.address1,' ',customer_address.address2,' ' ,customer_address.address3) as address from customer_address where customer_id="+orderItemMap.get("bill_to_customer_id")+" and customer_address_seq="+orderItemMap.get("bill_to_customer_address_seq"));
					for(Map<String,Object> map: billToCustomerAddress)
					{
						orderItem.setBillToFullName(map.get("name")!=null?(String)map.get("name"):null);
						orderItem.setBillToCustomerAddress(map.get("address")!=null?(String)map.get("address"):null);
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
				orderItem.setAudited(Integer.parseInt(orderItemMap.get("audited").toString()));
				orderItem.setQP(Integer.parseInt(orderItemMap.get("qp").toString()));
				orderItem.setQF(Integer.parseInt(orderItemMap.get("qf").toString()));
				orderItem.setNQP(Integer.parseInt(orderItemMap.get("nqp").toString()));
				orderItem.setNQF(Integer.parseInt(orderItemMap.get("nqf").toString()));
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
		try
		{			
			StringBuilder orderUpdateQuery = new StringBuilder();
			orderUpdateQuery.append("UPDATE order_item SET order_qty = :order_qty,gross_base_amount = :gross_base_amount,"+ 
									"gross_local_amount = :gross_local_amount,net_base_amount = :net_base_amount,net_local_amount = :net_local_amount,"+
									"total_tax_local_amount = :total_tax_local_amount,total_tax_base_amount = :total_tax_base_amount,"+
									"bill_to_customer_id = :bill_to_customer_id,bill_to_customer_address_seq = :bill_to_customer_address_seq,"+ 
									"customer_address_seq = :customer_address_seq,alt_ship_customer_id = :alt_ship_customer_id,"+
									"alt_ship_customer_address_seq = :alt_ship_customer_address_seq,bundle_qty = :bundle_qty,"+
									"pub_rotation_id = :pub_rotation_id,invoice_date = :invoice_date,"+ 
									"order_status = :order_status,"+"payment_status = :payment_status,currency = :currency,rate_class_id = :rate_class_id,"+
									"rate_class_effective_seq = :rate_class_effective_seq,manual_disc_amt_local = :manual_disc_amt_local,"+ 
									"manual_disc_amt_base = :manual_disc_amt_base,manual_disc_percentage = :manual_disc_percentage,"+
									"is_proforma = :is_proforma,source_code_id = :source_code_id");
			
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
				
			}if(null!=orderItem.getExtendedRate()) {
                  orderUpdateQuery.append(",extended_rate=:extended_rate "); 
               }                                
			if(orderItem.getOrderItemType()==0) 
			{
				orderUpdateQuery.append(",ext_iss_left = :ext_iss_left,start_date = :start_date,expire_date = :expire_date,start_issue_id = :start_issue_id,stop_issue_id = :stop_issue_id, n_issues_left = :n_issues_left,n_remaining_paid_issues = :n_remaining_paid_issues");
				orderUpdateQuery.append(",subscription_def_id = :subscription_def_id,renew_to_customer_id = :renew_to_customer_id,renew_to_customer_address_seq = :renew_to_customer_address_seq");
				orderUpdateQuery.append(",delivery_method = :delivery_method,distribution_method = :distribution_method,mru_suspension_seq = :mru_suspension_seq");
			}
			if(orderItem.getOrderItemType()==1)
			{
				orderUpdateQuery.append(",single_issue_id=:single_issue_id,start_issue_id = :start_issue_id,start_date = :start_date,delivery_method = :delivery_method");
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
			Map<String, Object> parameter = new HashMap<String, Object>();		
			if(orderItem.getOrderItemType()==1) 
			{
				parameter.put("order_qty", String.valueOf(orderItem.getBundleQty()));
			}else 
			{
				parameter.put("order_qty", String.valueOf(orderItem.getOrigOrderQty()));	
			}	
			parameter.put("gross_base_amount", getAmountValue(orderItem.getGrossBaseAmount()));
			parameter.put("extended_rate", getAmountValue(orderItem.getExtendedRate()));
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
			parameter.put("alt_ship_customer_id",String.valueOf(orderItem.getAltShipCustomerId()));
			parameter.put("alt_ship_customer_address_seq",String.valueOf(orderItem.getAltShipCustomerAddressSeq()));
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
			parameter.put("manual_disc_amt_local", getAmountValue(String.valueOf(orderItem.getManualDiscAmtLocal())));
			parameter.put("manual_disc_amt_base", getAmountValue(String.valueOf(orderItem.getManualDiscAmtBase())));
			parameter.put("manual_disc_percentage", getAmountValue(String.valueOf(orderItem.getManualDiscPercentage())));
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
				parameter.put("start_issue_id", String.valueOf(orderItem.getStartIssueId()));
				parameter.put("single_issue_id", String.valueOf(orderItem.getStartIssueId()));
				}
			if(orderItem.getOrderItemType()==0) 
			{
				parameter.put("start_date", String.valueOf(orderItem.getStartDate()));
				parameter.put("expire_date", "".equals(orderItem.getExpireDate())?null:String.valueOf(orderItem.getExpireDate()));
				if(orderItem.getCurrIssueId().equals("") || orderItem.getCurrIssueId()=="") 
				{
					parameter.put("start_issue_id", String.valueOf(orderItem.getStartIssueId()));
					parameter.put("stop_issue_id",String.valueOf(orderItem.getStopIssueId()));
				}
				else 
				{
					parameter.put("start_issue_id", String.valueOf(orderItem.getCurrIssueId()));
					parameter.put("stop_issue_id",String.valueOf(Integer.parseInt(orderItem.getCurrIssueId())-1 + (Integer.parseInt(orderItem.getnIssueLeft()))));
				}
				parameter.put("n_issues_left", orderItem.getnIssueLeft());
				parameter.put("n_remaining_paid_issues",String.valueOf(orderItem.getnRemainingPaidIssue()));
				parameter.put("order_qty", orderItem.getnIssueLeft());
				parameter.put("subscription_def_id",String.valueOf(orderItem.getSubscriptionDefId()));
				parameter.put("renew_to_customer_id",String.valueOf(orderItem.getRenewToCustomerId()));
				parameter.put("renew_to_customer_address_seq",String.valueOf(orderItem.getRenewToCustomerAddressSeq()));
				parameter.put("ext_iss_left", String.valueOf(orderItem.getExtIssleft()));
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
				String order_status="0";
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
				parameter.put("order_status", order_status);
				if(null!=mru_suspension_seq)
				{
					if(!"".equals(mru_suspension_seq.trim()) && !"null".equalsIgnoreCase(mru_suspension_seq.trim()))
					{
						parameter.put("mru_suspension_seq", String.valueOf(mru_suspension_seq_int));
					}
				}else if(mru_suspension_seq==null && order_status.equals("12"))
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
	
	@Override	public List<PackageDefinition> getPackageDefinitionList(int orderCodeId) {	List<PackageDefinition> packageDefinitionList = null;
		try{
			packageDefinitionList = jdbcTemplate.query("select * from pkg_def where order_code_id = ?", new Object[]{orderCodeId},new PackageDefinitionMapper());
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
			try {
			String subsriptionQuery;
			if(subscriptionDefId!=0) {
			int subscriptionCategId=jdbcTemplate.queryForObject("select isnull(subscription_category_id,0)as subscription_category_id from subscription_def where subscription_def_id="+subscriptionDefId+"", Integer.class);
			if((subscriptionCategId==7)||(subscriptionCategId==8)) {
				subsriptionQuery=new PropertyUtilityClass().getQuery("gratisQuery");				
				subscriptionPackageDefList = jdbcTemplate.query(subsriptionQuery,new Object[]{customerId,orderCodeId,customerId,customerId}, new SubscriptionPackageDefMapper());
				
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
								//	+ "  and ratecard.rate_class_id = rate_class_effective.rate_class_id) "
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
				List<Order_code_for_price_list[][]> priceList= orderAddWsdl.getPrice(customerId, subscriptionDefId,String.valueOf(sourceCodeId),subscriptionPackageDefList.get(0).getState(),subscriptionPackageDefList.get(0).getRatecardModel().getCurrency(),orderCodeType,orderCodeId);
				for(Order_code_for_price_list[][] map:priceList){
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
			orderCodes= jdbcTemplate.queryForList("select item_order_code_id from pkg_content where order_code_id="+orderCodeId+""); 
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
							+ " where customer_address.customer_id = "+customerId+" and  order_code.order_code_id in("+orderCodes.get(0).get("item_order_code_id").toString()+","+orderCodes.get(1).get("item_order_code_id").toString()+");";
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
						+ " where customer_address.customer_id = "+customerId+" and  order_code.order_code_id in("+orderCodes.get(0).get("item_order_code_id").toString()+","+orderCodes.get(1).get("item_order_code_id").toString()+") order by tax_rate_commodity.effective_date desc";
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
			
		}catch(Exception e)
		{
			LOGGER.info("getRateClassEffectiveList : "+e);
			e.printStackTrace();
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
	public List<BasicPackageItemModel> getBasicPackageDefList(int customerId, int orderCodeId,int sourceCodeId, int packageDefId, int orderCodeType,String subscriptionIdList) {
		
		List<BasicPackageItemModel> basicPackageItemModelsList = new ArrayList<>();
		List<BasicPackageItemModel> basicPackageItemModelList = new ArrayList<>();
		List<BasicPackageItemModel> basicPackageItemModelLists = new ArrayList<>();
		List<BasicPackageItemModel> packageItemList = new ArrayList<>();
		List<Map<String, Object>> currencyExchangeList=null;
		double totalPrice=0.0,localAmount=0,baseAmount=0;int pkgDefId=0,counter = 0;
		List<PackageDefinition> basicPackageList = null;
		String[] subscriptionIdList1 = null;
		List<String> subscriptionIdListFromFronEnd = new ArrayList<String>();					
		try{			
			StringBuilder query = new StringBuilder();
			StringBuilder customerQuery = new StringBuilder();
			StringBuilder taxQuery = new StringBuilder();
			//it checks that subscriptionIdList is empty or not
			Predicate<String> isSubscriptionIdListNotEmpty = _subscriptionIdList -> _subscriptionIdList.length() > 0;
			if(isSubscriptionIdListNotEmpty.test(subscriptionIdList)) {
				subscriptionIdList1 = subscriptionIdList.split(",");
				subscriptionIdListFromFronEnd = Arrays.asList(subscriptionIdList1);
			}
			basicPackageList = getBasicPackageList(Integer.valueOf(orderCodeId));
			if (basicPackageList.size() != 0 && basicPackageList.size() == 1) {
				pkgDefId = (int) basicPackageList.get(0).getPkgDefId();
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
				
//				    basicPackageItemModel.setTaxAmt(taxAmt);				
//					basicPackageItemModel.setTotalTaxLocalAmount(taxAmt);
//					basicPackageItemModel.setTotalTaxBaseAmount((taxAmt) * Double.parseDouble(basicPackageItemModelList.get(0).getExchange_rate().toString()));
//								
					basicPackageItemModelLists.add(basicPackageItemModel);
									
					List<Order_code_for_price_list[][]> priceList= orderAddWsdl.getPrice(customerId, basicPackageItemModel.getPkgDefId(),String.valueOf(sourceCodeId),basicPackageItemModel.getState(),basicPackageItemModel.getCurrency(),orderCodeType,orderCodeId);
					for (BasicPackageItemModel basicPackageItem : basicPackageItemModelLists) {
						for(Order_code_for_price_list[][] map:priceList){
							if(basicPackageItemModelLists.get(0).getPkgPriceMethod() ==2) {
							for(int i=0;i<basicPackageItemModelList.size();i++) {
								String sourceCodeID = String.valueOf(getSourcecode(basicPackageItemModelList.get(i).getContentOcId()));
								switch(basicPackageItemModelList.get(i).getOrderCodeType()) { 
								case 0:
									if(map[0][0].getPackage_price()[0].getOrder_code_for_pkg_def(i).getSubscription_price().length > 1) {
										List<Order_code_for_price_list[][]> subscriptionPrice= orderAddWsdl.getPrice(customerId,Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++)),String.valueOf(sourceCodeID),basicPackageItemModel.getState(),basicPackageItemModel.getCurrency(),basicPackageItemModelList.get(i).getOrderCodeType(),basicPackageItemModelList.get(i).getItemOrderCodeId());
										localAmount += Double.parseDouble(subscriptionPrice.get(0)[0][0].getSubscription_price()[0].getCc_item_price().toString());
										baseAmount  += Double.parseDouble(subscriptionPrice.get(0)[0][0].getSubscription_price()[0].getCc_item_price().toString()) * Double.parseDouble(basicPackageItem.getExchange_rate());
									//	basicPackageItem.setSubscriptionDefId(Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++)));
									}else {
										localAmount += Double.parseDouble(map[0][0].getPackage_price()[0].getOrder_code_for_pkg_def(i).getSubscription_price()[0].getCc_item_price().toString());
										baseAmount  += Double.parseDouble(map[0][0].getPackage_price()[0].getOrder_code_for_pkg_def(i).getSubscription_price()[0].getCc_item_price().toString()) * Double.parseDouble(basicPackageItem.getExchange_rate());
									
										}
									break;
								case 1:	
									if(map[0][0].getPackage_price()[0].getOrder_code_for_pkg_def(i).getSingle_issue_price().getCc_item_price()!=null) {
										localAmount += Double.parseDouble(map[0][0].getPackage_price()[0].getOrder_code_for_pkg_def(i).getSingle_issue_price().getCc_item_price().toString());
										baseAmount  += Double.parseDouble(map[0][0].getPackage_price()[0].getOrder_code_for_pkg_def(i).getSingle_issue_price().getCc_item_price().toString()) * Double.parseDouble(basicPackageItem.getExchange_rate());
									    counter++;
							        	}
									break;
								case 2:
									if(map[0][0].getPackage_price()[0].getOrder_code_for_pkg_def(i).getProduct_price().length>1) {
										List<Order_code_for_price_list[][]> subscriptionPrice= orderAddWsdl.getPrice(customerId,Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++)),String.valueOf(sourceCodeID),basicPackageItemModel.getState(),basicPackageItemModel.getCurrency(),basicPackageItemModelList.get(i).getOrderCodeType(),basicPackageItemModelList.get(i).getItemOrderCodeId());
										localAmount += Double.parseDouble(subscriptionPrice.get(0)[0][0].getProduct_price()[0].getCc_item_price().toString());
										baseAmount  += Double.parseDouble(subscriptionPrice.get(0)[0][0].getProduct_price()[0].getCc_item_price().toString()) * Double.parseDouble(basicPackageItem.getExchange_rate());
									//	basicPackageItem.setSubscriptionDefId(Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++)));
									}else {
										localAmount += Double.parseDouble(map[0][0].getPackage_price()[0].getOrder_code_for_pkg_def(i).getProduct_price()[0].getCc_item_price().toString());
										baseAmount  += Double.parseDouble(map[0][0].getPackage_price()[0].getOrder_code_for_pkg_def(i).getProduct_price()[0].getCc_item_price().toString()) * Double.parseDouble(basicPackageItem.getExchange_rate());
									}
									break;
								default:
									break;
							}								
							
						}       basicPackageItem.setLocalAmount(localAmount);
							    basicPackageItem.setBaseAmount(baseAmount);
					}      else {
								basicPackageItem.setLocalAmount((map[0][0].getPackage_price()[0].getCc_item_price())!=null?map[0][0].getPackage_price()[0].getCc_item_price().doubleValue():0.0) ;
								basicPackageItem.setBaseAmount((((map[0][0].getPackage_price()[0].getCc_item_price())!=null?map[0][0].getPackage_price()[0].getCc_item_price().doubleValue():0.0))* Double.parseDouble(basicPackageItem.getExchange_rate()));
									
								}
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
			System.out.println("TaxRate = "+taxRate);
		}catch(Exception e){
			LOGGER.info("CustomerOrderDaoImpl -> getPackageTaxRate : "+e);
		}
		return taxRate;
	}

	@Override
	public String getOrderAdd(OrderItem orderItem, int itemCount,String subscriptionIdList) throws Exception {
		String orderstatus="false";
		orderstatus= orderAddWsdl.orderAdd(orderItem, itemCount,subscriptionIdList);
		if(orderstatus=="false") {
			Thread.sleep(20000);
		  orderstatus= orderAddWsdl.orderAdd(orderItem, itemCount,subscriptionIdList);}
		if(orderstatus=="false") {
			Thread.sleep(20000);
			orderstatus= orderAddWsdl.orderAdd(orderItem, itemCount,subscriptionIdList);
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
			List<String> columnName = namedParameterJdbcTemplate.queryForList("SELECT column_name FROM aux_field WHERE LOWER(table_name) = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name", parameters, String.class);
			
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
			float	toNumberOfIssue=0;
			float  nRemainingPaidIssues = jdbcTemplate.queryForObject("select  n_issues_left from order_item where orderhdr_id="+orderId+" AND order_item_seq="+orderLineNumber, float.class);
			float orgQty = jdbcTemplate.queryForObject("select  orig_order_qty from order_item where orderhdr_id="+orderId+" AND order_item_seq="+orderLineNumber, float.class);
			StringBuilder query =new StringBuilder("select local_amount,base_amount from order_item_amt_break where orderhdr_id=");
			query.append(orderId).append("and order_item_seq =").append(orderLineNumber);
			List<Map<String,Object>> list = jdbcTemplate.queryForList(query.toString());
			System.out.println(list.get(0).get("local_amount"));
			
			double localAmount1 =Double.parseDouble(new DecimalFormat("##.##").format(localAmount));
			toNumberOfIssue = (numberOfIssue*preCopyPerIssue)/copyPerIssue;
			
			if(nRemainingPaidIssues != 0) {
			toNumberOfIssue=(numberOfIssue*preCopyPerIssue)/copyPerIssue;
			//toNumberOfIssue=orgQty/copyPerIssue;
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
//				toOrderItemPrice =  Double.parseDouble(new DecimalFormat("##.##").format(toOrderItemPrice2.get(0).get("local_amount")));
//			}
			responseObject.put("fromNumberOfIssue", nRemainingPaidIssues);
			responseObject.put("fromRemainingIssue", nRemainingPaidIssues);
			responseObject.put("fromPreCopyPerIssue", preCopyPerIssue);
			responseObject.put("toNumberOfIssue", toNumberOfIssue);
			responseObject.put("toRemainingIssue", toNumberOfIssue);
			responseObject.put("toPreCopyPerIssue", copyPerIssue);
			responseObject.put("fromOrderItemPrice", localAmount1);
			responseObject.put("orderClass", orderClass);
			responseObject.put("orderCode", orderCode);
			responseObject.put("orderNumber", orderNumber);
			responseObject.put("orderLineNumber", orderLineNumber); 
			responseObject.put("toOrderItemPrice", Double.parseDouble(new DecimalFormat("##.##").format(toOrderItemPrice)));
			responseObject.put("fromCastPerIssue",Double.parseDouble(new DecimalFormat("##.##").format(fromCastPerIssue)));
			responseObject.put("toCastPerIssue", Double.parseDouble(new DecimalFormat("##.##").format(toCastPerIssue)));
			responseObject.put("prorateRemainingIssue", numberOfIssue);
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
			float localCommission,float baseCommission,float totalTaxLocalAmount,float totalTaxBaseAmount,float toCastPerIssue) {
			LOGGER.info("inside getBundleQuantityChangeOption");
			Map<String,Object> responseObject =new LinkedHashMap<>();
			try {
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
				switch(option) {
				case 1:
					if(numberOfIssue>copyPerIssue) {
					float orgQty = jdbcTemplate.queryForObject("select  orig_order_qty from order_item where orderhdr_id="+orderId+" AND order_item_seq="+orderLineNumber, float.class);
					int	nRemainingPaidIssues = numberOfIssue;
					numberOfIssue1=orgQty/copyPerIssue;
					numberOfIssue1= Math.round(numberOfIssue1);
					startIssueId = (long) ((startIssueId+numberOfIssue1)-1);
					}
					if(numberOfIssue<=copyPerIssue) {
						numberOfIssue1=1;
						startIssueId = (long) ((startIssueId+numberOfIssue1)-1);
					}
				   String expireDate = jdbcTemplate.queryForObject("select format(cast(issue_date as date), 'MM/dd/yyyy') as expireDate from issue where issue_id="+startIssueId,String.class);
					responseObject.put("copyPerIssue", copyPerIssue);
					responseObject.put("expireDate", expireDate);
					responseObject.put("liability", numberOfIssue1);
					responseObject.put("numberOfIssue", numberOfIssue1);
					responseObject.put("localAmount", Double.parseDouble(new DecimalFormat("##.##").format(localAmountOption1)));
					responseObject.put("baseAmount", Double.parseDouble(new DecimalFormat("##.##").format(baseAmountOption1)));
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
			issueId = (issueId+numIssue)-1;
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
	public List<Map<String, Object>> getOnSubscriptionChange(int subscription_def_id, Integer issueId) {
		List<Map<String, Object>> dataList=new ArrayList<>();
		try {
		dataList=jdbcTemplate.queryForList("select term.description,term.n_issues as num_issue,term.n_issues as liability,sc.subscription_category_id,sc.description as categDescription,sd.subscription_def,sd.media,sd.edition,isnull(sd.pub_rotation_id,0)as pub_rotation_id,(select CONVERT(varchar,issue_date,101) as issue_date from issue where issue_id=("+issueId+"-1)+n_issues) as expire_date " +
				"from subscription_def sd left join subscription_category sc on sc.subscription_category_id=sd.subscription_category_id " + 
				"left join term on term.term_id=sd.term_id where sd.subscription_def_id="+subscription_def_id+"");
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
		List<PackageDefinition> BasicPackageDefinitionList = null;
		try{
			
			String query = "select * from pkg_def where order_code_id=?";
			BasicPackageDefinitionList = jdbcTemplate.query(query, new Object[]{orderCodeId},new PackageDefinitionMapper());
		}catch(Exception e){
			LOGGER.info("getBasicPackageList : "+e);
		}
		return BasicPackageDefinitionList;      
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
			 query.append(" subscriptionDescription,source_code.description as sourceCodeDes,cd.address1 ,subscription_def.subscription_def_id, CONCAT(cd.fname,' ', cd.lname) AS fullName,cd.state, ");
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
								basicPackageList = getBasicPackageList(orderCode_Id);
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
										pkg_def_id = (int) basicPackageList.get(0).getPkgDefId();
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
								pkg_def_id = (int) pooledPackageList.get(0).getPkgDefId();
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
					packageDefList = getPkgDefContentList(orderCodeId,required);
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
	public List<Map<String, Object>> getQuickOrderData(String orderCodeId, String sourceCodeId, int orderCodeType,int customerId, String subscriptionIdList, String agencyID, Optional<Integer> orderhdrId,Optional<String> shippingPrice) {
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
							pkgDefId = (int) basicPackageList.get(0).getPkgDefId();
						}else{
			            	pkgDefId = Integer.valueOf(pkgIdFromFronEnd.get(pkgCounter++).toString());
						}
			            //packageDefList = getPkgDefContentList(orderCodeId1, pkgDefId);
						basicPackageItemModelList = getBasicPackageDefList(customerId, orderCodeId1,getSourcecode(ocId), pkgDefId, orderCodeType1,subscriptionIdList);
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
							pkgDefId = (int) adhocPackageList.get(0).getPkgDefId();
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
							pkgDefId = (int) basicPackageList.get(0).getPkgDefId();
						}else{
			            	pkgDefId = Integer.valueOf(pkgIdFromFronEnd.get(pkgCounter++).toString());
						}
					    //packageDefList = getPkgDefContentList(orderCodeId1, pkgDefId);
					    basicPackageItemModelList = getBasicPackageDefList(customerId, orderCodeId1,getSourcecode(ocId), pkgDefId, orderCodeType1,subscriptionIdList);
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
     int customerId, String subscriptionIdList, String agencyID, Optional<Integer> orderhdrId,Optional<String> shippingPrice,Integer pkgDefId) {
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
						pkgDefId1 = (int) basicPackageList.get(0).getPkgDefId();
					} else {
						pkgDefId1 = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
					}
					basicPackageItemModelList = getBasicPackageDefList(customerId, orderCodeId1,
							Integer.parseInt(sourceCodeId), pkgDefId, orderCodeType1, subscriptionIdList);
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
						pkgDefId1 = (int) adhocPackageList.get(0).getPkgDefId();
					} else {
						pkgDefId1 = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
					}
					basicPackageItemModelList = getBasicPackageDefList(customerId, orderCodeId1,
							Integer.parseInt(sourceCodeId), pkgDefId, orderCodeType1, subscriptionIdList);
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
						pkgDefId1 = (int) pooledPackageList.get(0).getPkgDefId();
					} else {
						pkgDefId1 = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
					}
					basicPackageItemModelList = getBasicPackageDefList(customerId, orderCodeId1,
							Integer.parseInt(sourceCodeId), pkgDefId, orderCodeType1, subscriptionIdList);
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
				if(ratecardCount>0)
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
					expiration_date=jdbcTemplate.queryForObject("SELECT issue_date FROM issue WHERE issue_id="+(issue_id+n_issues-1)+";", String.class);
				}
			}
			if(order_amount==0)
			{
				order_amount=n_issues*default_price_per_issue;
			}
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
					if(order_amount==0)
					{
						order_amount=n_issues*number_volume_sets*default_price_per_issue;
					}
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
				order_amount=n_calendar_units*cost_per_day;
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
			if(order_amount==0)
			{
				order_amount=n_issues*default_price_per_issue;
			}
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
				order_amount=n_calendar_units*cost_per_day;
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
		if(rate_class_id>0)
		{
			List<Double> priceCostAmountList=getPriceCostAmountList(rate_class_id,n_issues);
			default_price_per_issue=priceCostAmountList.get(0);
			cost_per_day=priceCostAmountList.get(1);
			order_amount=priceCostAmountList.get(2);
		}
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
		if(rate_class_id>0)
		{
			List<Double> priceCostAmountList=getPriceCostAmountList(rate_class_id,1);
			default_price_per_issue=priceCostAmountList.get(0);
		}
		int start_date_count=jdbcTemplate.queryForObject("SELECT COUNT(*) FROM issue WHERE oc_id="+oc_id+" AND issue_id="+subscriptionDefId+";", Integer.class);
		if(start_date_count>0)
		{
			start_date=jdbcTemplate.queryForObject("SELECT issue_date FROM issue WHERE oc_id="+oc_id+" AND issue_id="+subscriptionDefId+";", String.class);
		}
		order_amount=default_price_per_issue;
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
		int product_count=0;
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
		}
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
				int item_subscription_def_id=jdbcTemplate.queryForObject("SELECT subscription_def_id FROM subscription_def WHERE order_code_id="+item_order_code_id+";", Integer.class);
				List<Object> paymentThresholdHandlingDataList=getPaymentThresholdHandlingDataForSubscriptionTypeOrder(String.valueOf(item_order_code_id),item_order_code_type,item_subscription_def_id,item_revenue_method,item_start_type,order_date);
				item_start_date=(String) paymentThresholdHandlingDataList.get(0);
				order_amount=(double) paymentThresholdHandlingDataList.get(3)*qty;
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
				order_amount=(double) paymentThresholdHandlingDataList.get(4)*qty;
		  }else if(item_order_code_type==2)//Product Type Order
		  {
				List<Object> paymentThresholdHandlingDataList=getPaymentThresholdHandlingDataForProductTypeOrder(String.valueOf(item_order_code_id),item_order_code_type,subscriptionDefId);
				order_amount=(double) paymentThresholdHandlingDataList.get(2)*qty;
		  }
		  dataListForEachPackageContent.add(start_date);
		  dataListForEachPackageContent.add(order_amount);
		  System.out.println("item_order_code_id = "+item_order_code_id+" # item_revenue_method"+item_revenue_method+" # item_start_type = "+item_start_type+" # start_date = "+start_date);
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
				Map<Integer, String>start_dates_map=new HashMap<Integer, String>();
				List<Map<String, Object>> item_order_code_id_query_list  = jdbcTemplate.queryForList("SELECT * FROM pkg_content WHERE order_code_id="+orderCodeId+";");
				for(Map<String, Object> entryMap : item_order_code_id_query_list)
				{
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
						  order_amount=(double) dataListForEachPackageContent.get(1);
						  totalAmount=totalAmount+order_amount;
						  start_dates_map.put(item_order_code_id, start_date);
					  }
					  if(orderCodeType==6 && required==1)
					  {
						  List<Object>dataListForEachPackageContent=getDataForEachPackageContent(item_order_code_id,qty,order_date,item_issue_id,subscriptionDefId,inputFormat,outputFormat);
						  start_date=(String) dataListForEachPackageContent.get(0);
						  order_amount=(double) dataListForEachPackageContent.get(1);
						  totalAmount=totalAmount+order_amount;
						  start_dates_map.put(item_order_code_id, start_date);
					  }
				}
				System.out.println("\n----------------------------------------------------------------\nstart_dates_map = "+start_dates_map);
				LOGGER.info("start_dates_map = "+start_dates_map);
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
				if(pkg_price_method==0)//price
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
				}
			}
			dataListForBasicAndPooledPackage.add(paymentThresholdHandlingExists);
			dataListForBasicAndPooledPackage.add(order_class);
			dataListForBasicAndPooledPackage.add(term);
			dataListForBasicAndPooledPackage.add(start_date);
			dataListForBasicAndPooledPackage.add(n_calendar_units);
			dataListForBasicAndPooledPackage.add(expiration_date);
			dataListForBasicAndPooledPackage.add(desiredDateFormatFlag);
			dataListForBasicAndPooledPackage.add(order_amount);
		
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
			}else if(orderCodeType==5)//ADHOC PKG : Incomplete
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
				paymentThresholdHandlingDataModelObj.setOrder_amount_bymycalc(Double.parseDouble(df.format(order_amount)));
				paymentThresholdHandlingDataModelObj.setSubscription_bymycalc(Double.parseDouble(df.format(subscription)));
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
}