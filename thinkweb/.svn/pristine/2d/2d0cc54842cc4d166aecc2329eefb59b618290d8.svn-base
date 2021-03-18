package com.mps.think.wsdl;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mps.think.model.IssueModel;
import com.mps.think.model.OrderItem;
import com.mps.think.model.PackageDefinition;
import com.mps.think.model.Product;
import com.mps.think.service.CustomerOrderService;
import com.mps.think.util.PropertyUtilityClass;

import Think.XmlWebServices.Auxiliary_data;
import Think.XmlWebServices.Auxiliary_field;
import Think.XmlWebServices.Back_issue_full_list_select_request;
import Think.XmlWebServices.Back_issue_full_list_select_responseBack_issue;
import Think.XmlWebServices.Bundle_quantity_date_option_calculate_request;
import Think.XmlWebServices.Bundle_quantity_date_option_calculate_response;
import Think.XmlWebServices.Bundle_quantity_option_calculate_request;
import Think.XmlWebServices.Bundle_quantity_option_calculate_response;
import Think.XmlWebServices.Customer_address_identifier;
import Think.XmlWebServices.Customer_identifier;
import Think.XmlWebServices.Item_already_subscribed_list_request;
import Think.XmlWebServices.Item_amt_break_data;
import Think.XmlWebServices.Item_data;
import Think.XmlWebServices.Member_item_data;
import Think.XmlWebServices.Order_add_payment_add_request;
import Think.XmlWebServices.Order_add_request;
import Think.XmlWebServices.Order_add_response;
import Think.XmlWebServices.Order_code_for_price_list;
import Think.XmlWebServices.Order_data;
import Think.XmlWebServices.Order_date_option_calculate_request;
import Think.XmlWebServices.Order_date_option_calculate_response;
import Think.XmlWebServices.Order_item_break_type;
import Think.XmlWebServices.Order_item_edit_request;
import Think.XmlWebServices.Order_item_edit_response;
import Think.XmlWebServices.Order_quantity_option_calculate_request;
import Think.XmlWebServices.Order_quantity_option_calculate_response;
import Think.XmlWebServices.Package_edit_request;
import Think.XmlWebServices.Package_edit_response;
import Think.XmlWebServices.Package_item_data;
import Think.XmlWebServices.Payment_add_data;
import Think.XmlWebServices.Price_list_data;
import Think.XmlWebServices.Price_list_request;
import Think.XmlWebServices.Subscription_upgrade_downgrade_data;
import Think.XmlWebServices.Subscription_upgrade_downgrade_price_list_request;
import Think.XmlWebServices.ThinkSoap;
import Think.XmlWebServices.ThinkWSLocator;
import Think.XmlWebServices.Threshold_option_enum;
import Think.XmlWebServices.User_login_data;
import Think.XmlWebServices.ZZBoolean;
import Think.XmlWebServices.ZZItemIdentifier;
@Repository
public class OrderAddWsdl{

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderAddWsdl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	CustomerOrderService customerOrderService;
	
	/*
	 *  Order Add and renew functionality
	 * Itee Gupta
	 */
    public String orderAdd(OrderItem orderItem,int itemCount,String subscriptionIdList,Optional<Integer> changeAmount) throws Exception {
		String status="true";
		SimpleDateFormat inSDF = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-MM-dd");
		List<PackageDefinition> basicPackageList = null;
		String[] subscriptionIdList1 = null;
		int counter = 0,amtBreakCount=1;
		List<String> subscriptionIdListFromFronEnd = new ArrayList<String>();
		List<Map<String, Object>> subscriptionDefinitionList = null;
		List<Map<String, Object>> auxiliaryField = null;
		List<IssueModel> issueModelsList = null;
		List<Product> productModelsList = null;
		Order_add_request orderAddRequest = new Order_add_request();
		Predicate<String> isNullOrEmpty = s-> s != null && !s.trim().isEmpty();
		try{
			String tempContentID="001";
			ThinkSoap soap = null;
			ThinkWSLocator locator = new ThinkWSLocator();
			soap = locator.getThinkSoap();
			
			orderAddRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
			orderAddRequest.setDoc_ref_id(orderItem.getDocRefId());		
			orderAddRequest.setCheck_missing_fields(ZZBoolean.no);			
			User_login_data login=new User_login_data();
			login.setLogin(new PropertyUtilityClass().getQuery("login"));	
			login.setPassword( new PropertyUtilityClass().getQuery("password"));
			orderAddRequest.setUser_login_data(login);
			Customer_identifier customer_identifier = new Customer_identifier(); 
			customer_identifier.setCustomer_id(orderItem.getCustomerId());			
			Customer_address_identifier customer_address_identifier = new Customer_address_identifier();
			customer_address_identifier.setCustomer_identifier(customer_identifier);
			customer_address_identifier.setCustomer_address_seq(1);		
			orderAddRequest.setCustomer_address_identifier(customer_address_identifier);
			int dataCount=0;
			String orderCode_ID[] = String.valueOf((orderItem.getOrderCodeID())).split(",");
			String sourceCode_ID[] =String.valueOf((orderItem.getSourceCodeID())).split(",");
			String subscriptionDef_Id[] =String.valueOf((orderItem.getSubscriptionDefId())).split(",");
			String start_issue_id[] = String.valueOf((orderItem.getStartIssueId())).split(",");
			String product_id[]=String.valueOf((orderItem.getProductId())).split(",");
			String subscrip_Id[]= String.valueOf((orderItem.getSubscripId())).split(",");
			String orderCodeType[] = (orderItem.getOrderCodeType()).split(",");
            
			dataCount=itemCount;
			for(int count=0;count<orderCodeType.length;count++) {				
				if(orderCodeType[count].equals("4")) {
					int memberCount=jdbcTemplate.queryForObject("select count(item_order_code_id) from pkg_content where order_code_id="+orderCode_ID[count]+"", Integer.class);
					dataCount=dataCount+memberCount;
				}/*else {
					dataCount=itemCount;
				}*/
			}
			Item_data[] item_data = new Item_data[dataCount];
			for(int k=0;k<itemCount;k++) {
			for(int i=0;i<item_data.length;i++) {	
				
				if(!((orderCodeType[k].equals("4")) || (orderCodeType[k].equals("5")) || (orderCodeType[k].equals("6")))){
				Item_data data =new Item_data();
				Order_data order_data = new Order_data();
				if(!(subscrip_Id[k].equals("0"))) {
					data.setSubscrip_id(Integer.parseInt(subscrip_Id[k]));
				}
				data.setIgnore_bad_credit(ZZBoolean.yes);
				if(orderItem.getRateClassId()!=0) {data.setRate_class_id(orderItem.getRateClassId());}
				if(orderItem.getRateClassEffectiveSeq()!=0) {data.setRate_class_effective_seq(orderItem.getRateClassEffectiveSeq());}
				if(orderItem.getAgencyCustomerId() != null && !"".equals(orderItem.getAgencyCustomerId()))					
				{data.setAgency_customer_id(Integer.parseInt(orderItem.getAgencyCustomerId()));}
				if(orderItem.getAgencyRefNbr()!=null) {data.setAgent_ref_nbr(orderItem.getAgencyRefNbr());}
				if(orderItem.getBundleQty()!=0) {data.setBundle_qty(orderItem.getBundleQty());}
				if(orderItem.getOrderCategory()!=null) {data.setOrder_category(orderItem.getOrderCategory());}
				if(orderItem.getAltShipCustomerId()!=0) {data.setAlt_ship_customer_id(orderItem.getAltShipCustomerId());}
				if(orderItem.getAltShipCustomerAddressSeq()!=0) {data.setAlt_ship_customer_address_seq(orderItem.getAltShipCustomerAddressSeq());}
				if(orderItem.getRenewToCustomerId()!=0) {data.setRenew_to_customer_id(orderItem.getRenewToCustomerId());}
				if(orderItem.getRenewToCustomerAddressSeq()!=0) {data.setRenew_to_customer_address_seq(orderItem.getRenewToCustomerAddressSeq());}
				if(orderItem.getBillToCustomerId()!=0) {data.setBill_to_customer_id(orderItem.getBillToCustomerId());}
				if(orderItem.getBillToCustomerAddressSeq()!=0) {data.setBill_to_customer_address_seq(orderItem.getBillToCustomerAddressSeq());}				
				if(orderItem.getCurrency()!=null) {data.setCurrency(orderItem.getCurrency());}				
				if(orderItem.getInvoiceDate()!=null) {					
					Date invDate = inSDF.parse(orderItem.getInvoiceDate());
					String invFinalDate = outSDF.format(invDate);
			    data.setInvoice_date(new PropertyUtilityClass().dateFormatter(invFinalDate));	}
				if(orderItem.getHasTax()!=0) {
				data.setInclude_tax(ZZBoolean.yes);}
				if(orderItem.getIsProforma()!=0) {
					data.setIs_proforma(Boolean.TRUE);}
				if(orderItem.getShippingPriceList()!=null) {
					data.setShipping_price_list(orderItem.getShippingPriceList());}					
				if(isNullOrEmpty.test(orderItem.getStartDate())) {
					Date startDate = inSDF.parse(orderItem.getStartDate());
					String startFinalDate = outSDF.format(startDate);
				data.setStart_date(new PropertyUtilityClass().dateFormatter(startFinalDate));}
				if(isNullOrEmpty.test(orderItem.getExpireDate())) {
					Date expireDate = inSDF.parse(orderItem.getExpireDate());
					String expireFinalDate = outSDF.format(expireDate);
				data.setExpire_date(new PropertyUtilityClass().dateFormatter(expireFinalDate));}
				
			data.setOrder_code_id(Integer.parseInt(orderCode_ID[k]));		
			data.setSource_code_id(Integer.parseInt(sourceCode_ID[k]));
			if(orderItem.getGenericPromotionCode()!=null) {data.setGeneric_promotion_code(orderItem.getGenericPromotionCode());}
			// Code Added: When Audit Tracking is "ON" from set up 
			if(orderItem.getAuditQualCategory()!=null) {data.setAudit_qual_category(Integer.parseInt(orderItem.getAuditQualCategory()));}
			if(orderItem.getAuditSourceId()!=null) {data.setAudit_qual_source_id(Integer.parseInt(orderItem.getAuditSourceId()));}
			if(orderItem.getAuditSubscriptionTypeId()!=null) {data.setAudit_subscription_type_id(Integer.parseInt(orderItem.getAuditSubscriptionTypeId()));}
			if(orderItem.getAuditNameTitleId()!=null) {data.setAudit_name_title_id(Integer.parseInt(orderItem.getAuditNameTitleId()));}
			if(orderItem.getAuditSalesChannelId()!=null) {data.setAudit_sales_channel_id(Integer.parseInt(orderItem.getAuditSalesChannelId()));}
			if(orderItem.getQualDate()!=null) {
				Date qualDate = inSDF.parse(orderItem.getQualDate());
				String qualFinalDate = outSDF.format(qualDate);
				data.setQual_date(new PropertyUtilityClass().dateFormatter(qualFinalDate));	}
				if(orderItem.getSqualDate()!=null) {
				Date sualDate = inSDF.parse(orderItem.getSqualDate());
				String sualFinalDate = outSDF.format(sualDate);			
			    data.setSqual_date(new PropertyUtilityClass().dateFormatter(sualFinalDate));	}
			// Code Added: When Audit Tracking is "ON" from set up 
			String agency_customer_id=jdbcTemplate.queryForObject("select agency_customer_id from source_code where source_code_id="+sourceCode_ID[k]+"", String.class);
			if(agency_customer_id!=null) { data.setAgency_customer_id(Integer.parseInt(agency_customer_id));}
			if(!subscriptionDef_Id[k].equals("0")) {
			data.setSubscription_def_id(Integer.parseInt(subscriptionDef_Id[k]));}
			if(!start_issue_id[k].equals("0")) {
			data.setStart_issue_id(Integer.parseInt(start_issue_id[k]));}
			if(!product_id[k].equals("0")) {
				data.setProduct_id(Integer.parseInt(product_id[k]));}
			if(orderItem.getQuickOrderCodeId()!=0) {
				data.setQuick_order_code_id(orderItem.getQuickOrderCodeId());
			}
			if(orderItem.getGroupOrder()!=0) {
				data.setGroup_order(Boolean.TRUE);
			}	
			
			if(orderItem.getAuxFlag()==1) {	
				List<Map<String,Object>> orderItemAux =jdbcTemplate.queryForList("SELECT column_name,column_datatype FROM aux_field WHERE table_name = 'order_item' and custsvc_edit_disposition !=0 ");
				Set<Entry<String, Object>> auxSize= orderItem.getAuxiliaryFieldList().get(0).entrySet();
				Auxiliary_data[] auxDataList = new Auxiliary_data[auxSize.size()];		
				int auxIndex=0;
				for(Map.Entry<String,Object> aux:orderItem.getAuxiliaryFieldList().get(0).entrySet()) { 
					for(int auxType=0;auxType<orderItemAux.size();auxType++) {
					Auxiliary_data auxData = new Auxiliary_data();
					if(orderItemAux.get(auxType).get("column_name").equals(aux.getKey())) {
					auxData.setName(aux.getKey().toString());
					int type = Integer.parseInt(orderItemAux.get(auxType).get("column_datatype").toString());
					switch(type) {
					case 0:
						auxData.setText_val(aux.getValue().toString());	
						break;					
					case 1:
						auxData.setInt_val(Integer.parseInt(aux.getValue().toString()));	
						break;						
					case 2:
						auxData.setDec_val(new BigDecimal(aux.getValue().toString()));	
						break;
					case 3:
						auxData.setDate_val(new PropertyUtilityClass().dateFormatter(aux.getValue().toString()));	
						break;
					default:
						break;
				   
				    }
					auxDataList[auxIndex]= auxData;					
					}
				}auxIndex++;
				}
				data.setAuxiliary_data(auxDataList);
			}
			
			if(changeAmount.isPresent()) {
				if(changeAmount.get()!=0) {
			if(Double.parseDouble(orderItem.getTotalTaxLocalAmount())!=0.00) {
				amtBreakCount+=1;
			}
			if(Double.parseDouble(orderItem.getLocalCommission())!=0.00) {
				amtBreakCount+=1;
			}			
			Item_amt_break_data[] amtBreak = new Item_amt_break_data[amtBreakCount];		
			for(int amt=0;amt<amtBreakCount;amt++) {
				Item_amt_break_data amtBreakData = new Item_amt_break_data();
				if(amt==0) {
				amtBreakData.setOrder_item_break_type(Order_item_break_type.item);
				amtBreakData.setLocal_amount(new BigDecimal(String.valueOf(orderItem.getLocalAmount())));
				
				}
				if(amt==1) {
				if(orderItem.getLocalCommission()!="0.00") {
				amtBreakData.setOrder_item_break_type(Order_item_break_type.commission);
				amtBreakData.setLocal_amount(new BigDecimal(String.valueOf(orderItem.getLocalCommission())));
				
				}else {
					amtBreakData.setOrder_item_break_type(Order_item_break_type.commission);
					amtBreakData.setLocal_amount(new BigDecimal(String.valueOf(orderItem.getTotalTaxLocalAmount())));
					
				}
				}
				if(amt==2) {
					if(orderItem.getTotalTaxLocalAmount()!="0.00") {
						amtBreakData.setOrder_item_break_type(Order_item_break_type.commission);
						amtBreakData.setLocal_amount(new BigDecimal(String.valueOf(orderItem.getTotalTaxLocalAmount())));
						
						}else {
							amtBreakData.setOrder_item_break_type(Order_item_break_type.commission);
							amtBreakData.setLocal_amount(new BigDecimal(String.valueOf(orderItem.getLocalCommission())));
							
						}
				}
				amtBreak[amt]= amtBreakData;
				}
			data.setItem_amt_break_data(amtBreak);		
			}
			}
			if(orderItem.getManualDiscAmtBase()!=0) {
				data.setManual_disc_amt_base(new BigDecimal(orderItem.getManualDiscAmtBase()));
			}
			if(orderItem.getManualDiscAmtLocal()!=0) {
				data.setManual_disc_amt_local(new BigDecimal(orderItem.getManualDiscAmtLocal()));
			}
			if(orderItem.getManualDiscPercentage()!=0) {
				data.setManual_disc_percentage(new BigDecimal(orderItem.getManualDiscPercentage()));
			}
			item_data[i] = data;
		 	order_data.setItem_data(item_data);			
		 	if((orderItem.getOrderhdrId())!=0) { 
			order_data.setOrderhdr_id(Integer.parseInt(String.valueOf(orderItem.getOrderhdrId())));}
			order_data.setPo_number(orderItem.getPoNumber());
			orderAddRequest.setOrder_data(order_data);
			}else {		
				Item_data data =new Item_data();
				Order_data order_data = new Order_data();
				if(!(subscrip_Id[k].equals("0"))) {
					data.setSubscrip_id(Integer.parseInt(subscrip_Id[k]));
				}
			
			String pkgDefId[] = (orderItem.getPkgDefId()).split(",");
			data.setOrder_code_id(Integer.parseInt(orderCode_ID[k]));		
			data.setSource_code_id(Integer.parseInt(sourceCode_ID[k]));
			String sourceCode=sourceCode_ID[k];
			if(!subscriptionDef_Id[k].equals("0")) {
			data.setSubscription_def_id(Integer.parseInt(subscriptionDef_Id[k]));}
			if(!start_issue_id[k].equals("0")) {
			data.setStart_issue_id(Integer.parseInt(start_issue_id[k]));}
			if(!product_id[k].equals("0")) {
			data.setProduct_id(Integer.parseInt(product_id[k]));}
							
			// it checks that subscriptionIdList is empty or not
						Predicate<String> isSubscriptionIdListNotEmpty = _subscriptionIdList -> _subscriptionIdList.length() > 0;
						if(isSubscriptionIdListNotEmpty.test(subscriptionIdList)) {
							subscriptionIdList1 = subscriptionIdList.split(",");
							subscriptionIdListFromFronEnd = Arrays.asList(subscriptionIdList1);
						}
						basicPackageList = customerOrderService.getBasicPackageList(Integer.valueOf(data.getOrder_code_id()));
						if (basicPackageList.size() != 0 && basicPackageList.size() == 1) {
							pkgDefId[k] = String.valueOf(basicPackageList.get(0).getPkgDefId());
						}else {
							pkgDefId[k] = subscriptionIdListFromFronEnd.get(counter++);
						}
		    if(!pkgDefId[k].equals("0")) {
			data.setPkg_def_id(Integer.parseInt(pkgDefId[k]));}		
			if(Integer.parseInt(pkgDefId[k])!=0) 
			{
			data.setTemp_id(String.valueOf(tempContentID));
			}else {
				if((orderCodeType[k].equals("5") ||(orderCodeType[k].equals("6"))) && (Integer.parseInt(pkgDefId[k])==0)) {
					data.setContent_of(String.valueOf(tempContentID));
				}
			}
			if(orderItem.getGroupOrder()!=0) {
				data.setGroup_order(Boolean.TRUE);
			}
			if(orderItem.getRateClassId()!=0) {data.setRate_class_id(orderItem.getRateClassId());}
			if(orderItem.getRateClassEffectiveSeq()!=0) {data.setRate_class_effective_seq(orderItem.getRateClassEffectiveSeq());}
			if(orderItem.getAgencyCustomerId() != null && !"".equals(orderItem.getAgencyCustomerId()))					
			{data.setAgency_customer_id(Integer.parseInt(orderItem.getAgencyCustomerId()));}
			if(orderItem.getAgencyRefNbr()!=null) {data.setAgent_ref_nbr(orderItem.getAgencyRefNbr());}
			if(orderItem.getBundleQty()!=0) {data.setBundle_qty(orderItem.getBundleQty());}
			if(orderItem.getOrderCategory()!=null) {data.setOrder_category(orderItem.getOrderCategory());}
			if(orderItem.getAltShipCustomerId()!=0) {data.setAlt_ship_customer_id(orderItem.getAltShipCustomerId());}
			if(orderItem.getAltShipCustomerAddressSeq()!=0) {data.setAlt_ship_customer_address_seq(orderItem.getAltShipCustomerAddressSeq());}
			if(orderItem.getRenewToCustomerId()!=0) {data.setRenew_to_customer_id(orderItem.getRenewToCustomerId());}
			if(orderItem.getRenewToCustomerAddressSeq()!=0) {data.setRenew_to_customer_address_seq(orderItem.getRenewToCustomerAddressSeq());}
			if(orderItem.getBillToCustomerId()!=0) {data.setBill_to_customer_id(orderItem.getBillToCustomerId());}
			if(orderItem.getBillToCustomerAddressSeq()!=0) {data.setBill_to_customer_address_seq(orderItem.getBillToCustomerAddressSeq());}				
			if(orderItem.getCurrency()!=null) {data.setCurrency(orderItem.getCurrency());}				
			if(orderItem.getInvoiceDate()!=null) {					
				Date invDate = inSDF.parse(orderItem.getInvoiceDate());
				String invFinalDate = outSDF.format(invDate);
		    data.setInvoice_date(new PropertyUtilityClass().dateFormatter(invFinalDate));	}
			if(orderItem.getHasTax()!=0) {
			data.setInclude_tax(ZZBoolean.yes);}
			if(orderItem.getIsProforma()!=0) {
				data.setIs_proforma(Boolean.TRUE);}
			if(orderItem.getShippingPriceList()!=null) {
				data.setShipping_price_list(orderItem.getShippingPriceList());}
			if(orderItem.getStartDate()!=null) {
				Date startDate = inSDF.parse(orderItem.getStartDate());
				String startFinalDate = outSDF.format(startDate);
			data.setStart_date(new PropertyUtilityClass().dateFormatter(startFinalDate));}
			if(orderItem.getExpireDate()!=null) {
				Date expireDate = inSDF.parse(orderItem.getExpireDate());
				String expireFinalDate = outSDF.format(expireDate);
			data.setExpire_date(new PropertyUtilityClass().dateFormatter(expireFinalDate));}
			if(orderItem.getGenericPromotionCode()!=null) {data.setGeneric_promotion_code(orderItem.getGenericPromotionCode());}
			if(orderItem.getIsProforma()!=0) {
				data.setIs_proforma(Boolean.TRUE);}
			if(orderItem.getManualDiscAmtBase()!=0) {
				data.setManual_disc_amt_base(new BigDecimal(orderItem.getManualDiscAmtBase()));
			}
			if(orderItem.getManualDiscAmtLocal()!=0) {
				data.setManual_disc_amt_local(new BigDecimal(orderItem.getManualDiscAmtLocal()));
			}
			if(orderItem.getManualDiscPercentage()!=0) {
				data.setManual_disc_percentage(new BigDecimal(orderItem.getManualDiscPercentage()));
			}
			item_data[i] = data;
		 	order_data.setItem_data(item_data);			
		 	if((orderItem.getOrderhdrId())!=0) { 
			order_data.setOrderhdr_id(Integer.parseInt(String.valueOf(orderItem.getOrderhdrId())));}
			order_data.setPo_number(orderItem.getPoNumber());
						
			orderAddRequest.setOrder_data(order_data);
			
			if(orderCodeType[k].equals("4")) {
				
			StringBuilder query= new StringBuilder("select pkg_def_content.pkg_def_id, pkg_def_content.order_code_id, pkg_def_content.pkg_content_seq,pkg_content.qty,item_order_code_id,");
			query.append("pkg_def_content.subscription_def_id, order_code.order_code,oc.oc,pkg_def_content.revenue_percent,oc.oc_id,case when subscription_def.rate_class_id is null then (case when order_code.newsub_rate_class_id is not null " ); 
			query.append("then order_code.newsub_rate_class_id else pkg_def.rate_class_id end) else subscription_def.rate_class_id end as rate_class_id, ");
			query.append("pkg_def_content.issue_id,pkg_def_content.product_id,pkg_def_content.subscription_def_id , ");
			query.append("(select order_code_type from order_code where order_code.order_code_id=pkg_content.item_order_code_id)as orderCodeType, ");
			query.append("(select oc_id from order_code where order_code.order_code_id=pkg_content.item_order_code_id)as contentOcId, pkg_def.pkg_price_method  ");
			query.append("from pkg_def inner join pkg_def_content on pkg_def.pkg_def_id=pkg_def_content.pkg_def_id ");  
			query.append("inner join pkg_content on pkg_content.pkg_content_seq=pkg_def_content.pkg_content_seq ");
			query.append("inner join order_code on order_code.order_code_id= pkg_content.order_code_id ");
			query.append("inner join oc on oc.oc_id = order_code.oc_id left join subscription_def on subscription_def.subscription_def_id = pkg_def_content.subscription_def_id ");
			query.append("where pkg_def_content.order_code_id = '"+data.getOrder_code_id()+"' and pkg_def_content.pkg_def_id = '"+pkgDefId[k]+"' and order_code.order_code_id = '"+data.getOrder_code_id()+"'");
			
			List<Map<String, Object>> pkgMemberList = null;
			List<OrderItem>packageMemberList = new ArrayList<>();
				pkgMemberList = jdbcTemplate.queryForList(query.toString());
				//Item_data[] itemData = new Item_data[(pkgMemberList.size())];				    
				for(int j=0;j<pkgMemberList.size();j++) {
					i++;
					Item_data pkgdata =new Item_data();
			         Order_data pkgOrderData = new Order_data();
			         if(!(orderItem.getHasBeenRenewed()==1)) {
				//for (Map<String, Object> pkgMember : pkgMemberList) {	
			        pkgdata.setOrder_code_id(Integer.parseInt(pkgMemberList.get(j).get("item_order_code_id").toString()));		
					pkgdata.setSource_code_id(Integer.parseInt(sourceCode));
					pkgdata.setPkg_content_seq(Integer.parseInt(pkgMemberList.get(j).get("pkg_content_seq").toString()));
					pkgdata.setContent_of(String.valueOf(tempContentID));
					switch(Integer.parseInt(pkgMemberList.get(j).get("orderCodeType").toString())) { 
			        case 0:			        	
			        	if(pkgMemberList.get(j).get("subscription_def_id")!=null) {
						    pkgdata.setSubscription_def_id(Integer.parseInt(pkgMemberList.get(j).get("subscription_def_id").toString()));
			        	}else {			     
			        		subscriptionDefinitionList = customerOrderService.getSubscriptionDetailsByOrderCodeId(Integer.parseInt(pkgMemberList.get(j).get("item_order_code_id").toString()));
							int subscription_def_id = 0;
							if (subscriptionDefinitionList.size() != 0 && subscriptionDefinitionList.size() == 1) {
								subscription_def_id = Integer
										.parseInt(subscriptionDefinitionList.get(0).get("subscription_def_id").toString());
							} else {
								subscription_def_id = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
							}
						    pkgdata.setSubscription_def_id(subscription_def_id);							
			        	}
			        	break;
			        case 1:
			        	  	if(pkgMemberList.get(j).get("issue_id")!=null){
							pkgdata.setStart_issue_id(Integer.parseInt(pkgMemberList.get(j).get("issue_id").toString()));
			        	}else {
			        		issueModelsList = customerOrderService.getSubscriptionStartDate(Integer.parseInt(pkgMemberList.get(j).get("contentOcId").toString()));
							int issueId = 0;
							if (issueModelsList.size() != 0 && issueModelsList.size() == 1) {
								issueId = (int) issueModelsList.get(0).getIssueId();
							} else {
								issueId = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
							}
			        		pkgdata.setStart_issue_id(issueId);	
			        	}
			        	break;
			        case 2:
			        	     	
			        	if(pkgMemberList.get(j).get("product_id")!=null) {
							pkgdata.setProduct_id(Integer.parseInt(pkgMemberList.get(j).get("product_id").toString()));
			        	}else {
			        		int productId = 0;
							productModelsList = customerOrderService.getProductDefinitionList(Integer.parseInt(pkgMemberList.get(j).get("item_order_code_id").toString()));
							if (productModelsList.size() != 0 && productModelsList.size() == 1) {
								productId = productModelsList.get(0).getProductId();
							} else {
								productId = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
							}	
			        		pkgdata.setProduct_id(productId);
			        	}					  
					}	
				}else {
					packageMemberList = orderItem.getPackageMemberList();
					pkgdata.setOrder_code_id(Integer.parseInt(packageMemberList.get(j).getOrderCodeID().toString()));		
					pkgdata.setSource_code_id(Integer.parseInt(sourceCode));
					pkgdata.setPkg_content_seq(Integer.parseInt(pkgMemberList.get(j).get("pkg_content_seq").toString()));
					pkgdata.setContent_of(String.valueOf(tempContentID));
					if(Integer.parseInt(packageMemberList.get(j).getOrderCodeType())==0) {
					if(packageMemberList.get(j).getSubscriptionDefId()!=null) {pkgdata.setSubscription_def_id(Integer.parseInt(packageMemberList.get(j).getSubscriptionDefId().toString()));}
					}
					if(Integer.parseInt(packageMemberList.get(j).getOrderCodeType())==1) {
					if(packageMemberList.get(j).getStartIssueId()!=null) {pkgdata.setStart_issue_id(Integer.parseInt(packageMemberList.get(j).getStartIssueId().toString()));}
					}else {
					if(packageMemberList.get(j).getProductId()!=null) {pkgdata.setProduct_id(Integer.parseInt(packageMemberList.get(j).getProductId().toString()));}
					}
					pkgdata.setSubscrip_id(Integer.parseInt(packageMemberList.get(j).getSubscripId().toString()));				
				}
			         
			item_data[i] = pkgdata;
			pkgOrderData.setItem_data(item_data);			
		 	if((orderItem.getOrderhdrId())!=0) { 
		 		pkgOrderData.setOrderhdr_id(Integer.parseInt(String.valueOf(orderItem.getOrderhdrId())));}
		 	pkgOrderData.setPo_number(orderItem.getPoNumber());
			orderAddRequest.setOrder_data(pkgOrderData);
			
			}
			}
			}  k++;
			} tempContentID=tempContentID+1;
			}
			System.out.println("orderAddRequest : "+orderAddRequest.toString());
			soap.orderAdd(orderAddRequest);
						
		}
		catch(AxisFault e){			
			//SOAPFault sf=new org.apache.axis.message.SOAPFault(e);
			String fault=e.getFaultDetails()[0].getAttributes().getNamedItem("error_description").getNodeValue().toString();
			LOGGER.info("OrderAddWsdl = "+fault);		
			status=fault;
		}
		catch(Exception e){
			LOGGER.info("OrderAddWsdl = "+e);
			status="false";
		}
		return status;			
	}
	

	
    public String addOrderWithPayment(OrderItem orderItem,int itemCount,String subscriptionIdList) throws Exception 
    {
		String status="true";
		SimpleDateFormat inSDF = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-MM-dd");
		List<PackageDefinition> basicPackageList = null;
		String[] subscriptionIdList1 = null;
		int counter = 0;
		List<String> subscriptionIdListFromFronEnd = new ArrayList<String>();
		List<Map<String, Object>> subscriptionDefinitionList = null;
		List<IssueModel> issueModelsList = null;
		List<Product> productModelsList = null;
		Order_add_payment_add_request  order_add_payment_add_request_obj  = new Order_add_payment_add_request();
		try{
			String tempContentID="001";
			ThinkSoap soap = null;
			ThinkWSLocator locator = new ThinkWSLocator();
			soap = locator.getThinkSoap();
			
			order_add_payment_add_request_obj.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
			order_add_payment_add_request_obj.setSubmit(ZZBoolean.yes);
			order_add_payment_add_request_obj.setDoc_ref_id(orderItem.getDocRefId());		
			order_add_payment_add_request_obj.setCheck_missing_fields(ZZBoolean.no);
			
			User_login_data login=new User_login_data();
			login.setLogin(new PropertyUtilityClass().getQuery("login"));	
			login.setPassword( new PropertyUtilityClass().getQuery("password"));
			
			order_add_payment_add_request_obj.setUser_login_data(login);
			
			Customer_address_identifier customer_address_identifier = new Customer_address_identifier();
			
			Customer_identifier customer_identifier = new Customer_identifier(); 
			customer_identifier.setCustomer_id(orderItem.getCustomerId());			
			
			customer_address_identifier.setCustomer_identifier(customer_identifier);
			customer_address_identifier.setCustomer_address_seq(1);		
			order_add_payment_add_request_obj.setCustomer_address_identifier(customer_address_identifier);
			
			int dataCount=0;
			String orderCode_ID[] = String.valueOf((orderItem.getOrderCodeID())).split(",");
			String sourceCode_ID[] =String.valueOf((orderItem.getSourceCodeID())).split(",");
			String subscriptionDef_Id[] =String.valueOf((orderItem.getSubscriptionDefId())).split(",");
			String start_issue_id[] = String.valueOf((orderItem.getStartIssueId())).split(",");
			String product_id[]=String.valueOf((orderItem.getProductId())).split(",");
			String subscrip_Id[]= String.valueOf((orderItem.getSubscripId())).split(",");
			String orderCodeType[] = (orderItem.getOrderCodeType()).split(",");
            
			dataCount=itemCount;
			for(int count=0;count<orderCodeType.length;count++) 
			{				
				if(orderCodeType[count].equals("4")) 
				{
					int memberCount=jdbcTemplate.queryForObject("select count(item_order_code_id) from pkg_content where order_code_id="+orderCode_ID[count]+"", Integer.class);
					dataCount=dataCount+memberCount;
				}
			}
			Item_data[] item_data = new Item_data[dataCount];
			for(int k=0;k<itemCount;k++) 
			{
				for(int i=0;i<item_data.length;i++) 
				{	
					if(!((orderCodeType[k].equals("4")) || (orderCodeType[k].equals("5")) || (orderCodeType[k].equals("6"))))
					{
						Order_data order_data = new Order_data();
						Item_data data =new Item_data();
						if(!(subscrip_Id[k].equals("0"))) 
						{
							data.setSubscrip_id(Integer.parseInt(subscrip_Id[k]));
						}
						data.setIgnore_bad_credit(ZZBoolean.yes);
						if(null!=orderItem.getThreshold_option())
						{
							if(orderItem.getThreshold_option().equalsIgnoreCase("fullunderPayment")||orderItem.getThreshold_option().equalsIgnoreCase("full"))
							{
								data.setThreshold_option(Threshold_option_enum.full);
							}
							else if(orderItem.getThreshold_option().equalsIgnoreCase("partial"))
							{
								data.setThreshold_option(Threshold_option_enum.partial);
							}
							else if(orderItem.getThreshold_option().equalsIgnoreCase("prorateundr")||orderItem.getThreshold_option().equalsIgnoreCase("prorate"))
							{
								data.setThreshold_option(Threshold_option_enum.prorate);
							}
							/*else if(orderItem.getThreshold_option().equalsIgnoreCase("deposit"))
							{
								data.setThreshold_option(Threshold_option_enum.deposit);
							}
							else if(orderItem.getThreshold_option().equalsIgnoreCase("refund"))
							{
								data.setThreshold_option(Threshold_option_enum.refund);
							}*/
							else if(orderItem.getThreshold_option().equalsIgnoreCase("full_ignore_setups"))
							{
								data.setThreshold_option(Threshold_option_enum.full_ignore_setups);
							}
						}
						if(orderItem.getRateClassId()!=0) 
						{
							data.setRate_class_id(orderItem.getRateClassId());
						}
						if(orderItem.getRateClassEffectiveSeq()!=0) 
						{
							data.setRate_class_effective_seq(orderItem.getRateClassEffectiveSeq());
						}
						if(orderItem.getAgencyCustomerId() != null && !"".equals(orderItem.getAgencyCustomerId()))					
						{
							data.setAgency_customer_id(Integer.parseInt(orderItem.getAgencyCustomerId()));
						}
						if(orderItem.getAgencyRefNbr()!=null) 
						{
							data.setAgent_ref_nbr(orderItem.getAgencyRefNbr());
						}
						if(orderItem.getBundleQty()!=0) 
						{
							data.setBundle_qty(orderItem.getBundleQty());
						}
						if(orderItem.getOrderCategory()!=null) 
						{
							data.setOrder_category(orderItem.getOrderCategory());
						}
						if(orderItem.getAltShipCustomerId()!=0) 
						{
							data.setAlt_ship_customer_id(orderItem.getAltShipCustomerId());
						}
						if(orderItem.getAltShipCustomerAddressSeq()!=0) 
						{
							data.setAlt_ship_customer_address_seq(orderItem.getAltShipCustomerAddressSeq());
						}
						if(orderItem.getRenewToCustomerId()!=0) 
						{
							data.setRenew_to_customer_id(orderItem.getRenewToCustomerId());
						}
						if(orderItem.getRenewToCustomerAddressSeq()!=0) 
						{
							data.setRenew_to_customer_address_seq(orderItem.getRenewToCustomerAddressSeq());
						}
						if(orderItem.getBillToCustomerId()!=0) 
						{
							data.setBill_to_customer_id(orderItem.getBillToCustomerId());
						}
						if(orderItem.getBillToCustomerAddressSeq()!=0) 
						{
							data.setBill_to_customer_address_seq(orderItem.getBillToCustomerAddressSeq());
						}				
						if(orderItem.getCurrency()!=null) 
						{
							data.setCurrency(orderItem.getCurrency());
						}				
						if(orderItem.getInvoiceDate()!=null) 
						{					
							Date invDate = inSDF.parse(orderItem.getInvoiceDate());
							String invFinalDate = outSDF.format(invDate);
							data.setInvoice_date(new PropertyUtilityClass().dateFormatter(invFinalDate));	
					    }
						if(orderItem.getHasTax()!=0) 
						{
							data.setInclude_tax(ZZBoolean.yes);
						}
						if(orderItem.getIsProforma()!=0) 
						{
							data.setIs_proforma(Boolean.TRUE);
						}
						if(orderItem.getShippingPriceList()!=null) 
						{
							data.setShipping_price_list(orderItem.getShippingPriceList());
						}
						if(orderItem.getStartDate()!=null) 
						{
							Date startDate = inSDF.parse(orderItem.getStartDate());
							String startFinalDate = outSDF.format(startDate);
							data.setStart_date(new PropertyUtilityClass().dateFormatter(startFinalDate));
						}
						if(orderItem.getExpireDate()!=null) 
						{
							Date expireDate = inSDF.parse(orderItem.getExpireDate());
							String expireFinalDate = outSDF.format(expireDate);
							data.setExpire_date(new PropertyUtilityClass().dateFormatter(expireFinalDate));
						}
						data.setOrder_code_id(Integer.parseInt(orderCode_ID[k]));		
						data.setSource_code_id(Integer.parseInt(sourceCode_ID[k]));
						if(orderItem.getGenericPromotionCode()!=null) 
						{
							data.setGeneric_promotion_code(orderItem.getGenericPromotionCode());
						}
						// Code Added: When Audit Tracking is "ON" from set up 
						if(orderItem.getAuditQualCategory()!=null) 
						{
							data.setAudit_qual_category(Integer.parseInt(orderItem.getAuditQualCategory()));
						}
						if(orderItem.getAuditSourceId()!=null) 
						{
							data.setAudit_qual_source_id(Integer.parseInt(orderItem.getAuditSourceId()));
						}
						if(orderItem.getAuditSubscriptionTypeId()!=null) 
						{
							data.setAudit_subscription_type_id(Integer.parseInt(orderItem.getAuditSubscriptionTypeId()));
						}
						if(orderItem.getAuditNameTitleId()!=null) 
						{
							data.setAudit_name_title_id(Integer.parseInt(orderItem.getAuditNameTitleId()));
						}
						if(orderItem.getAuditSalesChannelId()!=null) 
						{
							data.setAudit_sales_channel_id(Integer.parseInt(orderItem.getAuditSalesChannelId()));
						}
						if(orderItem.getQualDate()!=null) 
						{
							Date qualDate = inSDF.parse(orderItem.getQualDate());
							String qualFinalDate = outSDF.format(qualDate);
							data.setQual_date(new PropertyUtilityClass().dateFormatter(qualFinalDate));	
						}
						if(orderItem.getSqualDate()!=null) 
						{
							Date sualDate = inSDF.parse(orderItem.getSqualDate());
							String sualFinalDate = outSDF.format(sualDate);			
						    data.setSqual_date(new PropertyUtilityClass().dateFormatter(sualFinalDate));	
					    }
						// Code Added: When Audit Tracking is "ON" from set up 
						String agency_customer_id=jdbcTemplate.queryForObject("select agency_customer_id from source_code where source_code_id="+sourceCode_ID[k]+"", String.class);
						if(agency_customer_id!=null) 
						{
							data.setAgency_customer_id(Integer.parseInt(agency_customer_id));
						}
						if(!subscriptionDef_Id[k].equals("0")) 
						{
							data.setSubscription_def_id(Integer.parseInt(subscriptionDef_Id[k]));
						}
						if(!start_issue_id[k].equals("0")) 
						{
							data.setStart_issue_id(Integer.parseInt(start_issue_id[k]));
						}
						if(!product_id[k].equals("0")) 
						{
							data.setProduct_id(Integer.parseInt(product_id[k]));
						}
						if(orderItem.getQuickOrderCodeId()!=0) 
						{
							data.setQuick_order_code_id(orderItem.getQuickOrderCodeId());
						}
						if(orderItem.getGroupOrder()!=0) 
						{
							data.setGroup_order(Boolean.TRUE);
						}
						item_data[i] = data;
						
						order_data.setItem_data(item_data);			
					 	if((orderItem.getOrderhdrId())!=0) 
					 	{ 
					 		order_data.setOrderhdr_id(Integer.parseInt(String.valueOf(orderItem.getOrderhdrId())));
					 	}
						order_data.setPo_number(orderItem.getPoNumber());
						
						order_add_payment_add_request_obj.setOrder_data(order_data);
					}else
					{		
							Order_data order_data = new Order_data();
							Item_data data =new Item_data();
							if(!(subscrip_Id[k].equals("0"))) 
							{
								data.setSubscrip_id(Integer.parseInt(subscrip_Id[k]));
							}
							String pkgDefId[] = (orderItem.getPkgDefId()).split(",");
							data.setOrder_code_id(Integer.parseInt(orderCode_ID[k]));		
							data.setSource_code_id(Integer.parseInt(sourceCode_ID[k]));
							String sourceCode=sourceCode_ID[k];
							if(!subscriptionDef_Id[k].equals("0")) 
							{
								data.setSubscription_def_id(Integer.parseInt(subscriptionDef_Id[k]));
							}
							if(!start_issue_id[k].equals("0")) 
							{
								data.setStart_issue_id(Integer.parseInt(start_issue_id[k]));
							}
							if(!product_id[k].equals("0")) 
							{
								data.setProduct_id(Integer.parseInt(product_id[k]));
							}
							//It checks that subscriptionIdList is empty or not
							Predicate<String> isSubscriptionIdListNotEmpty = _subscriptionIdList -> _subscriptionIdList.length() > 0;
							if(isSubscriptionIdListNotEmpty.test(subscriptionIdList)) 
							{
								subscriptionIdList1 = subscriptionIdList.split(",");
								subscriptionIdListFromFronEnd = Arrays.asList(subscriptionIdList1);
							}
							basicPackageList = customerOrderService.getBasicPackageList(Integer.valueOf(data.getOrder_code_id()));
							if (basicPackageList.size() != 0 && basicPackageList.size() == 1) 
							{
								pkgDefId[k] = String.valueOf(basicPackageList.get(0).getPkgDefId());
							}else 
							{
								pkgDefId[k] = subscriptionIdListFromFronEnd.get(counter++);
							}
							if(!pkgDefId[k].equals("0")) 
							{
								data.setPkg_def_id(Integer.parseInt(pkgDefId[k]));
							}		
							if(Integer.parseInt(pkgDefId[k])!=0) 
							{
								data.setTemp_id(String.valueOf(tempContentID));
							}else 
							{
								if((orderCodeType[k].equals("5") ||(orderCodeType[k].equals("6"))) && (Integer.parseInt(pkgDefId[k])==0)) 
								{
									data.setContent_of(String.valueOf(tempContentID));
								}
							}
							if(orderItem.getGroupOrder()!=0) 
							{
								data.setGroup_order(Boolean.TRUE);
							}
							if(orderItem.getGenericPromotionCode()!=null) 
						 	{
						 		data.setGeneric_promotion_code(orderItem.getGenericPromotionCode());
						 	}
						 	if(orderItem.getIsProforma()!=0) 
						 	{
						 		data.setIs_proforma(Boolean.TRUE);
						 	}
							item_data[i] = data;
						 	order_data.setItem_data(item_data);			
						 	
						 	if((orderItem.getOrderhdrId())!=0) 
						 	{ 
						 		order_data.setOrderhdr_id(Integer.parseInt(String.valueOf(orderItem.getOrderhdrId())));
						 	}
						 	order_data.setPo_number(orderItem.getPoNumber());
						 	
						 	order_add_payment_add_request_obj.setOrder_data(order_data);
						
						if(orderCodeType[k].equals("4")) 
						{
								
							StringBuilder query= new StringBuilder("select pkg_def_content.pkg_def_id, pkg_def_content.order_code_id, pkg_def_content.pkg_content_seq,pkg_content.qty,item_order_code_id,");
							query.append("pkg_def_content.subscription_def_id, order_code.order_code,oc.oc,pkg_def_content.revenue_percent,oc.oc_id,case when subscription_def.rate_class_id is null then (case when order_code.newsub_rate_class_id is not null " ); 
							query.append("then order_code.newsub_rate_class_id else pkg_def.rate_class_id end) else subscription_def.rate_class_id end as rate_class_id, ");
							query.append("pkg_def_content.issue_id,pkg_def_content.product_id,pkg_def_content.subscription_def_id , ");
							query.append("(select order_code_type from order_code where order_code.order_code_id=pkg_content.item_order_code_id)as orderCodeType, ");
							query.append("(select oc_id from order_code where order_code.order_code_id=pkg_content.item_order_code_id)as contentOcId, pkg_def.pkg_price_method  ");
							query.append("from pkg_def inner join pkg_def_content on pkg_def.pkg_def_id=pkg_def_content.pkg_def_id ");  
							query.append("inner join pkg_content on pkg_content.pkg_content_seq=pkg_def_content.pkg_content_seq ");
							query.append("inner join order_code on order_code.order_code_id= pkg_content.order_code_id ");
							query.append("inner join oc on oc.oc_id = order_code.oc_id left join subscription_def on subscription_def.subscription_def_id = pkg_def_content.subscription_def_id ");
							query.append("where pkg_def_content.order_code_id = '"+data.getOrder_code_id()+"' and pkg_def_content.pkg_def_id = '"+pkgDefId[k]+"' and order_code.order_code_id = '"+data.getOrder_code_id()+"'");
							
							List<Map<String, Object>> pkgMemberList = null;
							pkgMemberList = jdbcTemplate.queryForList(query.toString());
							for(int j=0;j<pkgMemberList.size();j++) 
							{
										i++;
										 Item_data pkgdata =new Item_data();
								         Order_data pkgOrderData = new Order_data();
								        pkgdata.setOrder_code_id(Integer.parseInt(pkgMemberList.get(j).get("item_order_code_id").toString()));		
										pkgdata.setSource_code_id(Integer.parseInt(sourceCode));
										pkgdata.setContent_of(String.valueOf(tempContentID));
										switch(Integer.parseInt(pkgMemberList.get(j).get("orderCodeType").toString())) 
										{ 
									        case 0:
									        	subscriptionDefinitionList = customerOrderService.getSubscriptionDetailsByOrderCodeId(Integer.parseInt(pkgMemberList.get(j).get("item_order_code_id").toString()));
												int subscription_def_id = 0;
												if (subscriptionDefinitionList.size() != 0 && subscriptionDefinitionList.size() == 1) {
													subscription_def_id = Integer
															.parseInt(subscriptionDefinitionList.get(0).get("subscription_def_id").toString());
												} else {
													subscription_def_id = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
												}
									        	if(pkgMemberList.get(j).get("subscription_def_id")!=null) {
												    pkgdata.setSubscription_def_id(Integer.parseInt(pkgMemberList.get(j).get("subscription_def_id").toString()));
									        	}else {			        		
												    pkgdata.setSubscription_def_id(subscription_def_id);							
									        	}
									        	break;
									        case 1:
									        	issueModelsList = customerOrderService.getSubscriptionStartDate(Integer.parseInt(pkgMemberList.get(j).get("contentOcId").toString()));
												int issueId = 0;
												if (issueModelsList.size() != 0 && issueModelsList.size() == 1) {
													issueId = (int) issueModelsList.get(0).getIssueId();
												} else {
													issueId = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
												}
									        	if(pkgMemberList.get(j).get("issue_id")!=null){
													pkgdata.setStart_issue_id(Integer.parseInt(pkgMemberList.get(j).get("issue_id").toString()));
									        	}else {
									        		pkgdata.setStart_issue_id(issueId);	
									        	}
									        	break;
									        case 2:
									        	int productId = 0;
												productModelsList = customerOrderService.getProductDefinitionList(Integer.parseInt(pkgMemberList.get(j).get("item_order_code_id").toString()));
												if (productModelsList.size() != 0 && productModelsList.size() == 1) {
													productId = productModelsList.get(0).getProductId();
												} else {
													productId = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
												}			        	
									        	if(pkgMemberList.get(j).get("product_id")!=null) {
													pkgdata.setProduct_id(Integer.parseInt(pkgMemberList.get(j).get("product_id").toString()));
									        	}else {
									        		pkgdata.setProduct_id(productId);
									        	}					  
										}					
										item_data[i] = pkgdata;
										pkgOrderData.setItem_data(item_data);			
									 	if((orderItem.getOrderhdrId())!=0) 
									 	{ 
									 		pkgOrderData.setOrderhdr_id(Integer.parseInt(String.valueOf(orderItem.getOrderhdrId())));
									 	}
									 	pkgOrderData.setPo_number(orderItem.getPoNumber());
									 	order_add_payment_add_request_obj.setOrder_data(pkgOrderData);
							}
						}
					}  k++;
				} tempContentID=tempContentID+1;
			}
			Payment_add_data payment_add_data_obj=new Payment_add_data();
			payment_add_data_obj.setAmount(BigDecimal.valueOf(orderItem.getCancelledOrderAmount()));
			payment_add_data_obj.setPay_currency_amount(BigDecimal.valueOf(orderItem.getCancelledOrderAmount()));
			payment_add_data_obj.setCurrency(orderItem.getCurrency());
			payment_add_data_obj.setPayment_type(orderItem.getPayment_type());
			
			order_add_payment_add_request_obj.setPayment_add_data(payment_add_data_obj);
			soap.orderAddPaymentAdd(order_add_payment_add_request_obj);
		}
		catch(AxisFault e)
		{			
			String fault=e.getFaultDetails()[0].getAttributes().getNamedItem("error_description").getNodeValue().toString();
			LOGGER.info("OrderAddWsdl = "+fault);
			e.printStackTrace();
			status=fault;
		}
		catch(Exception e)
		{
			LOGGER.info("OrderAddWsdl = "+e);
			e.printStackTrace();
			status="false";
		}
		return status;			
	}
    
    
    
    public List<Order_date_option_calculate_response> getExpireDateCalculate(int orderhdrId,int orderItemSeq,String expireDate,String defaultPricing) throws ServiceException {
		
				
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		Order_date_option_calculate_request OrderDateOptionCalculate =new Order_date_option_calculate_request(); 
		Order_date_option_calculate_response OrderDateOptionResponse = new Order_date_option_calculate_response();
		List<Order_date_option_calculate_response> responseList = new ArrayList<>();
		OrderDateOptionCalculate.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
		
		User_login_data login=new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));	
		login.setPassword( new PropertyUtilityClass().getQuery("password"));	
		
		ZZItemIdentifier itemIdentifier= new ZZItemIdentifier();
		itemIdentifier.setOrderhdr_id(orderhdrId);
		itemIdentifier.setOrder_item_seq(orderItemSeq);
		
		OrderDateOptionCalculate.setItem_identifier(itemIdentifier);
		OrderDateOptionCalculate.setUser_login_data(login);
		OrderDateOptionCalculate.setNew_expire_date(new PropertyUtilityClass().dateFormatter(expireDate));
		Item_data data =new Item_data();		
		OrderDateOptionCalculate.setItem_data(data);
		if(defaultPricing.equals("default")) {
			OrderDateOptionCalculate.setDefault_pricing(ZZBoolean.yes);} else {
			OrderDateOptionCalculate.setDefault_pricing(ZZBoolean.no);	
  			}
		try {
		OrderDateOptionResponse=soap.orderDateOptionCalculate(OrderDateOptionCalculate);
		if(OrderDateOptionResponse != null)
		{
			responseList.add(OrderDateOptionResponse);
		}
		}
		catch(Exception ex) {
			LOGGER.info("ExpireDateCalculate = "+ ex);
		}
		return responseList;
		
	}
	public List<Bundle_quantity_date_option_calculate_response> getnoOfCopiesforDateOption(int orderhdrId,int orderItemSeq,int oldQuantity,int quantity) throws ServiceException {
		
		
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		Bundle_quantity_date_option_calculate_request quantityDateOption =new Bundle_quantity_date_option_calculate_request(); 
		Bundle_quantity_date_option_calculate_response quantityDateOptionResponse = new Bundle_quantity_date_option_calculate_response();
		List<Bundle_quantity_date_option_calculate_response> responseList = new ArrayList<>();
		quantityDateOption.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
		
		User_login_data login=new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));	
		login.setPassword( new PropertyUtilityClass().getQuery("password"));
		
		ZZItemIdentifier itemIdentifier= new ZZItemIdentifier();
		itemIdentifier.setOrderhdr_id(orderhdrId);
		itemIdentifier.setOrder_item_seq(orderItemSeq);
		quantityDateOption.setItem_identifier(itemIdentifier);
		quantityDateOption.setUser_login_data(login);
		quantityDateOption.setNew_quantity(quantity);
		Item_data data =new Item_data();
		data.setBundle_qty(oldQuantity);
		quantityDateOption.setItem_data(data);
		try {
			quantityDateOptionResponse=soap.bundleQuantityDateOptionCalculate(quantityDateOption);
		if(quantityDateOptionResponse != null)
		{
			responseList.add(quantityDateOptionResponse);
		}
		}
		catch(Exception ex) {
			LOGGER.info("No.Of Copies for Date Option = "+ ex);
		}
		return responseList;
		
	}	
      public List<Bundle_quantity_option_calculate_response> getnoOfCopiesforIssueOption(int orderhdrId,int orderItemSeq,int quantity) throws ServiceException {
		
		
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		Bundle_quantity_option_calculate_request quantityIssueOption =new Bundle_quantity_option_calculate_request(); 
		Bundle_quantity_option_calculate_response quantityIssueOptionResponse = new Bundle_quantity_option_calculate_response();
		List<Bundle_quantity_option_calculate_response> responseList = new ArrayList<>();
		quantityIssueOption.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
		
		User_login_data login=new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));	
		login.setPassword( new PropertyUtilityClass().getQuery("password"));
		
		ZZItemIdentifier itemIdentifier= new ZZItemIdentifier();
		itemIdentifier.setOrderhdr_id(orderhdrId);
		itemIdentifier.setOrder_item_seq(orderItemSeq);
		
		quantityIssueOption.setItem_identifier(itemIdentifier);
		quantityIssueOption.setUser_login_data(login);
		quantityIssueOption.setNew_quantity(quantity);
		Item_data data =new Item_data();		
		quantityIssueOption.setItem_data(data);
		
		try {
			quantityIssueOptionResponse=soap.bundleQuantityOptionCalculate(quantityIssueOption);
		if(quantityIssueOptionResponse != null)
		{
			responseList.add(quantityIssueOptionResponse);
		}
		}
		catch(Exception ex) {
			LOGGER.info("No.Of Copies for Issue Option = "+ ex);
		}
		return responseList;
		
	}
      
      public List<Bundle_quantity_option_calculate_response> getDataForChangeNumberOfCopye(int orderhdrId,int orderItemSeq,int quantity,int newQuantity) throws ServiceException {
  		
  		
  		ThinkSoap soap = null;
  		ThinkWSLocator locator = new ThinkWSLocator();
  		soap = locator.getThinkSoap();
  		Bundle_quantity_option_calculate_request quantityIssueOption =new Bundle_quantity_option_calculate_request(); 
  		Bundle_quantity_option_calculate_response quantityIssueOptionResponse = new Bundle_quantity_option_calculate_response();
  		List<Bundle_quantity_option_calculate_response> responseList = new ArrayList<>();
  		quantityIssueOption.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
  		
  		User_login_data login=new User_login_data();
  		login.setLogin(new PropertyUtilityClass().getQuery("login"));	
  		login.setPassword( new PropertyUtilityClass().getQuery("password"));
  		
  		ZZItemIdentifier itemIdentifier= new ZZItemIdentifier();
  		itemIdentifier.setOrderhdr_id(orderhdrId);
  		itemIdentifier.setOrder_item_seq(orderItemSeq);
  		
  		quantityIssueOption.setItem_identifier(itemIdentifier);
  		quantityIssueOption.setUser_login_data(login);
  		quantityIssueOption.setNew_quantity(newQuantity);
  		Item_data data =new Item_data();
  		data.setQuantity(quantity);
  		quantityIssueOption.setItem_data(data);
  		
  		try {
  			quantityIssueOptionResponse=soap.bundleQuantityOptionCalculate(quantityIssueOption);
  		if(quantityIssueOptionResponse != null)
  		{
  			responseList.add(quantityIssueOptionResponse);
  		}
  		}
  		catch(Exception ex) {
  			LOGGER.info("No.Of Copies for Issue Option = "+ ex);
  		}
  		return responseList;
  		
  	}
      
      
      public List<Order_quantity_option_calculate_response> getnoOfIssueChange(int orderhdrId,int orderItemSeq,int quantity,String defaultPricing) throws ServiceException {
  		
  		
  		ThinkSoap soap = null;
  		ThinkWSLocator locator = new ThinkWSLocator();
  		soap = locator.getThinkSoap();
  		Order_quantity_option_calculate_request noOfIssueChangeRequest =new Order_quantity_option_calculate_request(); 
  		Order_quantity_option_calculate_response noOfIssueChangeResponse = new Order_quantity_option_calculate_response();
  		List<Order_quantity_option_calculate_response> responseList = new ArrayList<>();
  		noOfIssueChangeRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
  		
  		User_login_data login=new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));	
		login.setPassword( new PropertyUtilityClass().getQuery("password"));
  		
  		ZZItemIdentifier itemIdentifier= new ZZItemIdentifier();
  		itemIdentifier.setOrderhdr_id(orderhdrId);
  		itemIdentifier.setOrder_item_seq(orderItemSeq);
  		
  		noOfIssueChangeRequest.setItem_identifier(itemIdentifier);
  		noOfIssueChangeRequest.setUser_login_data(login);
  		noOfIssueChangeRequest.setNew_quantity(quantity);
  		Item_data data =new Item_data();		
  		noOfIssueChangeRequest.setItem_data(data);
  		
  		if(defaultPricing.equals("default")) {
  			noOfIssueChangeRequest.setDefault_pricing(ZZBoolean.yes);} else {
  				noOfIssueChangeRequest.setDefault_pricing(ZZBoolean.no);	
  			}
  		
  		try {
  			noOfIssueChangeResponse=soap.orderQuantityOptionCalculate(noOfIssueChangeRequest);
  		if(noOfIssueChangeResponse != null)
  		{
  			responseList.add(noOfIssueChangeResponse);
  		}
  		}
  		catch(Exception ex) {
  			LOGGER.info("No.Of Issue Change = "+ ex);
  		}
  		return responseList;
  		
  	}
	public List<Order_code_for_price_list[][]> getPrice(int customerId, int subscriptionId, String sourceCodeId,
			String state, String currency, int orderCodeType, int orderCodeId) throws ServiceException {

  		ThinkSoap soap = null;
  		ThinkWSLocator locator = new ThinkWSLocator();
  		soap = locator.getThinkSoap();
  		Price_list_request priceListRequest = new Price_list_request(); 
  		Order_code_for_price_list[][] priceListResponse =null;
  		List<Order_code_for_price_list[][]> responseList = new ArrayList<>();
  		priceListRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
  		
  		User_login_data login=new User_login_data();
  		login.setLogin(new PropertyUtilityClass().getQuery("login"));	
  		login.setPassword( new PropertyUtilityClass().getQuery("password"));
  		
  		priceListRequest.setInternet_only(ZZBoolean.no);
  		priceListRequest.setUser_login_data(login);
  		try {
  		Price_list_data[] price_list_data= new Price_list_data[1];
  		Price_list_data list = new Price_list_data();
  		if(orderCodeType==2) {
  			list.setProduct_id(subscriptionId);
  		}else if(orderCodeType==1) {
  			list.setOrder_code_id(orderCodeId);
  		}else if(orderCodeType==4  || orderCodeType==6 ) {
  			list.setPkg_def_id(subscriptionId);
  		}else {
  		list.setSubscription_def_id(subscriptionId);}
  		list.setSource_code_id(Integer.parseInt(sourceCodeId));
  		list.setState(state);
  		list.setCurrency(currency);  
  		price_list_data[0]=list;
  		priceListRequest.setPrice_list_data(price_list_data);
  		
  			priceListResponse=soap.priceList(priceListRequest);
  		if(priceListResponse != null)
  		{
  			responseList.add(priceListResponse);
  		}
  		}
  		catch(Exception ex) 
  		{
  			LOGGER.info("Price Value = "+ ex);
  			ex.printStackTrace();
  		}
  		return responseList;
	}
	
	public List<Back_issue_full_list_select_responseBack_issue[]> getBackIssueList(int subscripId) throws ServiceException {
		
		
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		Back_issue_full_list_select_request backIssueFullList =new Back_issue_full_list_select_request(); 
		Back_issue_full_list_select_responseBack_issue[] backIssueFullListResponse = null;
		
		List<Back_issue_full_list_select_responseBack_issue[]> responseList = new ArrayList<>();
		backIssueFullList.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
		
		User_login_data login=new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));	
		login.setPassword( new PropertyUtilityClass().getQuery("password"));	
		
		backIssueFullList.setSubscrip_id(subscripId);
		backIssueFullList.setUser_login_data(login);
		
		try {
			backIssueFullListResponse=soap.backIssueFullListSelect(backIssueFullList);
		if(backIssueFullListResponse != null)
		{
			responseList.add(backIssueFullListResponse);
		}
		}
		catch(Exception ex) {
			LOGGER.info("BackIssueList = "+ ex);
		}
		return responseList;
		
	}
	
	
  @Transactional
  public String subscriptionUpgradeDowngrade(int subsccription_def_id,String gridDefID,long orderhdrId, int orderItemSeq) throws ServiceException {

		
		Order_code_for_price_list[][] subscriptionUpgradeDowngradeDataResponse=null;
		
		List<Order_code_for_price_list[][]> responseList = new ArrayList<>();
		String status="true";
		double grossBaseAmt=0.0,grossLocalAmt=0.0,netBase=0.0,netLocal=0.0,taxCalcLocal=0.0,taxCalcBase=0.0,localAmt=0.0,baseAmt=0.0,localComm=0,baseComm=0;
		int stopIssueId=0;
		long tax = 0L;
		List<Map<String, Object>> orderData1= null;
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		try {
			ThinkSoap soap = null;
			ThinkWSLocator locator = new ThinkWSLocator();
			soap = locator.getThinkSoap();
			LOGGER.info("Inside subscriptionUpgradeDowngrade method");
			
			Subscription_upgrade_downgrade_price_list_request subscriptionUpgradeDowngradeDataRequest=new Subscription_upgrade_downgrade_price_list_request();
			soap = locator.getThinkSoap();
			
			User_login_data login=new User_login_data();
			login.setLogin(new PropertyUtilityClass().getQuery("login"));	
			login.setPassword( new PropertyUtilityClass().getQuery("password"));
				
			Subscription_upgrade_downgrade_data[] upgradeDowngrade_data= new Subscription_upgrade_downgrade_data[1];
			
			Subscription_upgrade_downgrade_data list = new Subscription_upgrade_downgrade_data();
				
			list.setSubscription_def_id(subsccription_def_id);
		
			upgradeDowngrade_data[0]=list;
			
			subscriptionUpgradeDowngradeDataRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
			subscriptionUpgradeDowngradeDataRequest.setInternet_only(ZZBoolean.yes);	
	  		subscriptionUpgradeDowngradeDataRequest.setIgnore_override_price(ZZBoolean.yes);
			subscriptionUpgradeDowngradeDataRequest.setUser_login_data(login);
			subscriptionUpgradeDowngradeDataRequest.setSubscription_upgrade_downgrade_data(upgradeDowngrade_data);
			subscriptionUpgradeDowngradeDataResponse=soap.subscriptionUpgradeDowngradePriceList(subscriptionUpgradeDowngradeDataRequest);
					
			if(subscriptionUpgradeDowngradeDataResponse != null)
			{				
		    responseList.add(subscriptionUpgradeDowngradeDataResponse);
		    String baseQuery="select start_issue_id,subscrip_id,order_qty,exchange_rate,order_code_id,customer_id,agency_customer_id from order_item where orderhdr_id="+orderhdrId+" and order_item_seq="+orderItemSeq;
		   //calculate duration and expire date
		    int duration = findDuration(subsccription_def_id);
		    LocalDate expiredDate = findExpiredDate(orderhdrId, orderItemSeq,duration);
		    
		    orderData1 = jdbcTemplate.queryForList(baseQuery.toString());
		    int customerId= orderData1.get(0).get("agency_customer_id")!=null?Integer.parseInt(orderData1.get(0).get("agency_customer_id").toString()):0;
		    List<Map<String, Object>> agencyData = jdbcTemplate.queryForList("select new_commission,ren_commission from agency where customer_id="+customerId);
			tax = customerOrderService.getTaxRate(Long.parseLong(orderData1.get(0).get("customer_id").toString()),Integer.parseInt(orderData1.get(0).get("order_code_id").toString()));
			for(Order_code_for_price_list[][] map:responseList){
			   int l= map[0][0].getSubscription_price().length;
			   for(int i=0;i<l;i++) {
				  if(gridDefID.equals(String.valueOf(map[0][0].getSubscription_price()[i].getSubscription_def_id()))) {
					  localAmt= map[0][0].getSubscription_price()[i].getCc_item_price().doubleValue() ;
					  baseAmt=  map[0][0].getSubscription_price()[i].getCc_item_price().doubleValue()* Double.parseDouble(orderData1.get(0).get("exchange_rate").toString());
				      if(orderData1.get(0).get("agency_customer_id")!=null && agencyData.get(0).get("new_commission")!=null) {
				    	  localComm=(localAmt)* Double.parseDouble(agencyData.get(0).get("new_commission").toString())/100;
				    	  baseComm= (baseAmt)* Double.parseDouble(agencyData.get(0).get("new_commission").toString())/100;
				    	  localAmt=localAmt-localComm;
				    	  baseAmt=baseAmt-baseComm;
				      }
				      if(tax!=0)
					  {
						  taxCalcLocal=(Double.parseDouble(String.valueOf(tax))/100)* localAmt;
						  taxCalcBase=(Double.parseDouble(String.valueOf(tax))/100)* baseAmt;
					  }
					  
					  netLocal= localAmt+taxCalcLocal;
					  netBase=  baseAmt+ taxCalcBase;
					  grossLocalAmt=localAmt+taxCalcLocal+localComm;
					  grossBaseAmt=baseAmt+ taxCalcBase+baseComm;
					 
					  StringBuilder query= new StringBuilder("update order_item set gross_base_amount="+grossBaseAmt+",gross_local_amount="+grossLocalAmt+",net_base_amount="+netBase+",net_local_amount="+netLocal+", duration="+duration);
				           
				      if(Integer.parseInt(orderData1.get(0).get("order_qty").toString())!=0) {
				    	  stopIssueId=(Integer.parseInt(orderData1.get(0).get("start_issue_id").toString()) + (map[0][0].getSubscription_price()[i].getN_issues()))-1 ;
					      String issueDate = jdbcTemplate.queryForObject("select issue_date from issue where issue_id="+stopIssueId+"",String.class);
						  query.append(",order_qty="+map[0][0].getSubscription_price()[i].getN_issues()+",n_issues_left="+map[0][0].getSubscription_price()[i].getN_issues()+",n_remaining_paid_issues="+map[0][0].getSubscription_price()[i].getN_issues()+" ,stop_issue_id="+stopIssueId+", expire_date='"+issueDate+"'");
							       
				      }else {
				    	  query.append(", expire_date='"+expiredDate+"'");
				      }
				      		query.append(",subscription_def_id="+gridDefID+" , total_tax_local_amount="+taxCalcLocal+",total_tax_base_amount="+taxCalcBase+" where orderhdr_id="+orderhdrId+" and order_item_seq="+orderItemSeq);
				     
				      		 jdbcTemplate.update(query.toString());
				      		 if((orderData1.get(0).get("start_issue_id"))!=null) {
				      			 jdbcTemplate.update("update subscrip set n_total_issues_left="+map[0][0].getSubscription_price()[i].getN_issues()+",stop_issue_id="+stopIssueId+" where subscrip_id="+orderData1.get(0).get("subscrip_id").toString());

				      		 }
				      		 String orderAmtBreakQuery= "update order_item_amt_break set local_amount="+localAmt+",base_amount="+baseAmt+" where orderhdr_id="+orderhdrId+" and order_item_amt_break_seq=1 ";
				    	     jdbcTemplate.update(orderAmtBreakQuery.toString());  
				      		 
				      if(tax!=0 && taxCalcLocal!=0) {
				    	  String taxQuery= "update order_item_amt_break set local_amount="+taxCalcLocal+",base_amount="+taxCalcBase+" where orderhdr_id="+orderhdrId+" and order_item_amt_break_seq=2 ";
				    	     jdbcTemplate.update(taxQuery.toString());    	  
				      }
				      if(localComm!=0) {
				    	  String commQuery= "update order_item_amt_break set local_amount="+localComm+",base_amount="+baseComm+" where orderhdr_id="+orderhdrId+" and order_item_amt_break_seq=3 ";
				         	 jdbcTemplate.update(commQuery.toString());    	  
				      }
				      
				     
			}
			}
			
			}
			}
			}catch(Exception ex) {
				
	  			LOGGER.info("subscription upgrade downgrade = "+ ex);
	  			status="false";
	  		}
	  		return status;
			

			}


	private LocalDate findExpiredDate(long orderhdrId, int orderItemSeq,int duration) throws ParseException{
		String startDate = null;
		LocalDate expireDate = null;
		String query = "SELECT FORMAT(order_item.start_date, 'yyyy-MM-dd ') as start_date from order_item where orderhdr_id="+ orderhdrId + " and order_item_seq=" + orderItemSeq;
		try {
			    startDate = jdbcTemplate.queryForObject(query.toString(), String.class);
				Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(startDate);  
				Instant instant = Instant.ofEpochMilli(date1.getTime()); 
				LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); 
				expireDate = localDateTime.toLocalDate(); 
				Long days = (long) (duration * 30.436875);
				expireDate.plusDays(days);
		} catch (Exception e) {
			LOGGER.info("findExpiredDate():"+e);
		}
		return expireDate;
	}


	private int findDuration(int subsccription_def_id) {
		int duration = 0;
		StringBuilder query = new StringBuilder("SELECT CASE ")
		.append("WHEN term.term = '1' THEN 0 ")
		.append("WHEN term.term = '1MD' THEN 1 ")
		.append("WHEN term.term = '1Y12I' THEN 12 ")
		.append("WHEN term.term = '1Y6' THEN 12 ")
		.append("WHEN term.term = '1Y4' THEN 12 ")
		.append("WHEN term.term = '1Y52' THEN 12 ")
		.append("WHEN term.term = '2Y24' THEN 24 ")
		.append("WHEN term.term = '3Y36' THEN 36 ")
		.append("WHEN term.term = '1YD' THEN 12 ")
		.append("WHEN term.term = '3M' THEN 3 ")
		.append("WHEN term.term = '500U' THEN 3 ")
		.append("WHEN term.term = '1Y' THEN 12 ")
		.append("WHEN term.term = '1M' THEN 1 ")
		.append("END AS duration FROM subscription_def ")
		.append("left join term on term.term_id=subscription_def.term_id WHERE subscription_def_id=").append(subsccription_def_id);
		try {
			 duration = jdbcTemplate.queryForObject(query.toString(), Integer.class);
		} catch (Exception e) {
			LOGGER.info("findDuration() = "+e);
		}
		return duration;
	}	
	
	/*
	 * Added orderProgressAddAdd to get orderDetails before order Placed from EDIT ITEM
	 * Itee Gupta
	 */
	public List<Order_add_response> orderProgressAddAdd(OrderItem orderItem,Integer subscriptionId,int itemCount,String subscriptionIdList) throws Exception {			
		 String status="true";
			SimpleDateFormat inSDF = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-MM-dd");
			List<PackageDefinition> basicPackageList = null;
			List<Map<String, Object>> dataList=new ArrayList<>();
			String[] subscriptionIdList1 = null;
			int counter = 0;
			List<String> subscriptionIdListFromFronEnd = new ArrayList<String>();
			List<Map<String, Object>> subscriptionDefinitionList = null;
			List<IssueModel> issueModelsList = null;
			List<Product> productModelsList = null;
			Order_add_request orderAddRequest = new Order_add_request();
			Predicate<String> isNullOrEmpty = s-> s != null && !s.trim().isEmpty();

			Order_add_response response =new Order_add_response();
			List<Order_add_response> list = new ArrayList<>();
			try{
				String tempContentID="001";
				ThinkSoap soap = null;
				ThinkWSLocator locator = new ThinkWSLocator();
				soap = locator.getThinkSoap();
				
				orderAddRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
				orderAddRequest.setDoc_ref_id(orderItem.getDocRefId());		
				orderAddRequest.setCheck_missing_fields(ZZBoolean.no);	
				orderAddRequest.setSubmit(ZZBoolean.no);
				User_login_data login=new User_login_data();
				login.setLogin(new PropertyUtilityClass().getQuery("login"));	
				login.setPassword( new PropertyUtilityClass().getQuery("password"));
				orderAddRequest.setUser_login_data(login);
				Customer_identifier customer_identifier = new Customer_identifier(); 
				customer_identifier.setCustomer_id(orderItem.getCustomerId());			
				Customer_address_identifier customer_address_identifier = new Customer_address_identifier();
				customer_address_identifier.setCustomer_identifier(customer_identifier);
				customer_address_identifier.setCustomer_address_seq(1);		
				orderAddRequest.setCustomer_address_identifier(customer_address_identifier);
				int dataCount=0;
				
				if(orderItem.getOrderCodeType().equals("0")) {
					orderItem.setStartIssueId("0");
					orderItem.setProductId("0");
				}
				if(orderItem.getOrderCodeType().equals("1")) {
					orderItem.setSubscriptionDefId("0");
					orderItem.setProductId("0");
				}
				if(orderItem.getOrderCodeType().equals("2")) {
					orderItem.setSubscriptionDefId("0");
					orderItem.setStartIssueId("0");
				}if(orderItem.getOrderCodeType().equals("4")) {
					orderItem.setSubscriptionDefId("0");
					orderItem.setStartIssueId("0");
					orderItem.setProductId(String.valueOf("0"));}
				
				String orderCode_ID[] = String.valueOf((orderItem.getOrderCodeID())).split(",");
				String sourceCode_ID[] =String.valueOf((orderItem.getSourceCodeID())).split(",");
				String subscriptionDef_Id[] =String.valueOf((orderItem.getSubscriptionDefId())).split(",");
				String start_issue_id[] = String.valueOf((orderItem.getStartIssueId())).split(",");
				String product_id[]=String.valueOf((orderItem.getProductId())).split(",");
			//	String subscrip_Id[]= String.valueOf((orderItem.getSubscripId())).split(",");
				String orderCodeType[] = (orderItem.getOrderCodeType()).split(",");
	            	            
				dataCount=itemCount;
				for(int count=0;count<orderCodeType.length;count++) {				
					if(orderCodeType[count].equals("4")) {
						int memberCount=jdbcTemplate.queryForObject("select count(item_order_code_id) from pkg_content where order_code_id="+orderCode_ID[count]+"", Integer.class);
						dataCount=dataCount+memberCount;
					}/*else {
						dataCount=itemCount;
					}*/
				}
				Item_data[] item_data = new Item_data[dataCount];
				for(int k=0;k<itemCount;k++) {
				for(int i=0;i<item_data.length;i++) {	
					
					if(!((orderCodeType[k].equals("4")) || (orderCodeType[k].equals("5")) || (orderCodeType[k].equals("6")))){
					Item_data data =new Item_data();
					Order_data order_data = new Order_data();
//					if(!(subscrip_Id[k].equals("0"))) {
//						data.setSubscrip_id(Integer.parseInt(subscrip_Id[k]));
//					}
					data.setIgnore_bad_credit(ZZBoolean.yes);
					if(orderItem.getRateClassId()!=0) {data.setRate_class_id(orderItem.getRateClassId());}
					if(orderItem.getRateClassEffectiveSeq()!=0) {data.setRate_class_effective_seq(orderItem.getRateClassEffectiveSeq());}
					if(orderItem.getAgencyCustomerId() != null && !"".equals(orderItem.getAgencyCustomerId()))					
					{data.setAgency_customer_id(Integer.parseInt(orderItem.getAgencyCustomerId()));}
					if(orderItem.getAgencyRefNbr()!=null) {data.setAgent_ref_nbr(orderItem.getAgencyRefNbr());}
					if(orderItem.getBundleQty()!=0) {data.setBundle_qty(orderItem.getBundleQty());}
					if(orderItem.getOrderQty()!=0) {data.setOrder_qty(orderItem.getOrigOrderQty());}
					if(orderItem.getOrderCategory()!=null) {data.setOrder_category(orderItem.getOrderCategory());}
					if(orderItem.getAltShipCustomerId()!=0) {data.setAlt_ship_customer_id(orderItem.getAltShipCustomerId());}
					if(orderItem.getAltShipCustomerAddressSeq()!=0) {data.setAlt_ship_customer_address_seq(orderItem.getAltShipCustomerAddressSeq());}
					if(orderItem.getRenewToCustomerId()!=0) {data.setRenew_to_customer_id(orderItem.getRenewToCustomerId());}
					if(orderItem.getRenewToCustomerAddressSeq()!=0) {data.setRenew_to_customer_address_seq(orderItem.getRenewToCustomerAddressSeq());}
					if(orderItem.getBillToCustomerId()!=0) {data.setBill_to_customer_id(orderItem.getBillToCustomerId());}
					if(orderItem.getBillToCustomerAddressSeq()!=0) {data.setBill_to_customer_address_seq(orderItem.getBillToCustomerAddressSeq());}				
					if(orderItem.getCurrency()!=null) {data.setCurrency(orderItem.getCurrency());}
					if(orderItem.getInvoiceDate()!=null) {					
						Date invDate = inSDF.parse(orderItem.getInvoiceDate());
						String invFinalDate = outSDF.format(invDate);
				    data.setInvoice_date(new PropertyUtilityClass().dateFormatter(invFinalDate));	}
					if(orderItem.getHasTax()!=0) {
					data.setInclude_tax(ZZBoolean.yes);}
					if(orderItem.getIsProforma()!=0) {
						data.setIs_proforma(Boolean.TRUE);}
					if(orderItem.getShippingPriceList()!=null) {
						data.setShipping_price_list(orderItem.getShippingPriceList());}
					if(isNullOrEmpty.test(orderItem.getStartDate())) {
						Date startDate = inSDF.parse(orderItem.getStartDate());
						String startFinalDate = outSDF.format(startDate);
					data.setStart_date(new PropertyUtilityClass().dateFormatter(startFinalDate));}
					if(isNullOrEmpty.test(orderItem.getExpireDate())) {
						Date expireDate = inSDF.parse(orderItem.getExpireDate());
						String expireFinalDate = outSDF.format(expireDate);
					data.setExpire_date(new PropertyUtilityClass().dateFormatter(expireFinalDate));}
					
				data.setOrder_code_id(Integer.parseInt(orderCode_ID[k]));		
				data.setSource_code_id(Integer.parseInt(sourceCode_ID[k]));
				if(orderItem.getGenericPromotionCode()!=null) {data.setGeneric_promotion_code(orderItem.getGenericPromotionCode());}
				// Code Added: When Audit Tracking is "ON" from set up 
				if(orderItem.getAuditQualCategory()!=null) {data.setAudit_qual_category(Integer.parseInt(orderItem.getAuditQualCategory()));}
				if(orderItem.getAuditSourceId()!=null) {data.setAudit_qual_source_id(Integer.parseInt(orderItem.getAuditSourceId()));}
				if(orderItem.getAuditSubscriptionTypeId()!=null) {data.setAudit_subscription_type_id(Integer.parseInt(orderItem.getAuditSubscriptionTypeId()));}
				if(orderItem.getAuditNameTitleId()!=null) {data.setAudit_name_title_id(Integer.parseInt(orderItem.getAuditNameTitleId()));}
				if(orderItem.getAuditSalesChannelId()!=null) {data.setAudit_sales_channel_id(Integer.parseInt(orderItem.getAuditSalesChannelId()));}
				if(orderItem.getQualDate()!=null) {
					Date qualDate = inSDF.parse(orderItem.getQualDate());
					String qualFinalDate = outSDF.format(qualDate);
					data.setQual_date(new PropertyUtilityClass().dateFormatter(qualFinalDate));	}
					if(orderItem.getSqualDate()!=null) {
					Date sualDate = inSDF.parse(orderItem.getSqualDate());
					String sualFinalDate = outSDF.format(sualDate);			
				    data.setSqual_date(new PropertyUtilityClass().dateFormatter(sualFinalDate));	}
				// Code Added: When Audit Tracking is "ON" from set up 
				/*String agency_customer_id=jdbcTemplate.queryForObject("select agency_customer_id from source_code where source_code_id="+sourceCode_ID[k]+"", String.class);
				if(agency_customer_id!=null) { data.setAgency_customer_id(Integer.parseInt(agency_customer_id));}*/
				//	if(orderItem.getAgencyCustomerId()!=null) { data.setAgency_customer_id(Integer.parseInt(orderItem.getAgencyCustomerId()));}   //Malini 22-04-2020
					if(!subscriptionDef_Id[k].equals("0")) {
				data.setSubscription_def_id(Integer.parseInt(subscriptionDef_Id[k]));}
				if(!start_issue_id[k].equals("0")) {
				data.setStart_issue_id(Integer.parseInt(start_issue_id[k]));}
				if(!product_id[k].equals("0")) {
					data.setProduct_id(Integer.parseInt(product_id[k]));}
				if(orderItem.getQuickOrderCodeId()!=0) {
					data.setQuick_order_code_id(orderItem.getQuickOrderCodeId());
				}
					if(orderItem.getGroupOrder()!=0) {
					data.setGroup_order(Boolean.TRUE);
				}
				if(orderItem.getManualDiscAmtBase()!=0) {
					data.setManual_disc_amt_base(new BigDecimal(orderItem.getManualDiscAmtBase()));
				}
				if(orderItem.getManualDiscAmtLocal()!=0) {
					data.setManual_disc_amt_local(new BigDecimal(orderItem.getManualDiscAmtLocal()));
				}
				if(orderItem.getManualDiscPercentage()!=0) {
					data.setManual_disc_percentage(new BigDecimal(orderItem.getManualDiscPercentage()));
				}
				item_data[i] = data;
			 	order_data.setItem_data(item_data);			
			 	if((orderItem.getOrderhdrId())!=0) { 
				order_data.setOrderhdr_id(Integer.parseInt(String.valueOf(orderItem.getOrderhdrId())));}
				order_data.setPo_number(orderItem.getPoNumber());
				orderAddRequest.setOrder_data(order_data);
				}else {		
					Item_data data =new Item_data();
					Order_data order_data = new Order_data();
//					if(!(subscrip_Id[k].equals("0"))) {
//						data.setSubscrip_id(Integer.parseInt(subscrip_Id[k]));
//					}
				
				String pkgDefId[] = (orderItem.getPkgDefId()).split(",");
				data.setOrder_code_id(Integer.parseInt(orderCode_ID[k]));		
				data.setSource_code_id(Integer.parseInt(sourceCode_ID[k]));
				String sourceCode=sourceCode_ID[k];
				if(!subscriptionDef_Id[k].equals("0")) {
				data.setSubscription_def_id(Integer.parseInt(subscriptionDef_Id[k]));}
				if(!start_issue_id[k].equals("0")) {
				data.setStart_issue_id(Integer.parseInt(start_issue_id[k]));}
				if(!product_id[k].equals("0")) {
				data.setProduct_id(Integer.parseInt(product_id[k]));}
								
				// it checks that subscriptionIdList is empty or not
							Predicate<String> isSubscriptionIdListNotEmpty = _subscriptionIdList -> _subscriptionIdList.length() > 0;
							if(isSubscriptionIdListNotEmpty.test(subscriptionIdList)) {
								subscriptionIdList1 = subscriptionIdList.split(",");
								subscriptionIdListFromFronEnd = Arrays.asList(subscriptionIdList1);
							}
							basicPackageList = customerOrderService.getBasicPackageList(Integer.valueOf(data.getOrder_code_id()));
							if (basicPackageList.size() != 0 && basicPackageList.size() == 1) {
								pkgDefId[k] = String.valueOf(basicPackageList.get(0).getPkgDefId());
							}else {
								pkgDefId[k] = subscriptionIdListFromFronEnd.get(counter++);
							}
			    if(!pkgDefId[k].equals("0")) {
				data.setPkg_def_id(Integer.parseInt(pkgDefId[k]));}		
				if(Integer.parseInt(pkgDefId[k])!=0) 
				{
				data.setTemp_id(String.valueOf(tempContentID));
				}else {
					if((orderCodeType[k].equals("5") ||(orderCodeType[k].equals("6"))) && (Integer.parseInt(pkgDefId[k])==0)) {
						data.setContent_of(String.valueOf(tempContentID));
					}
				}
				if(orderItem.getGroupOrder()!=0) {
					data.setGroup_order(Boolean.TRUE);
				}
				if(orderItem.getRateClassId()!=0) {data.setRate_class_id(orderItem.getRateClassId());}
				if(orderItem.getRateClassEffectiveSeq()!=0) {data.setRate_class_effective_seq(orderItem.getRateClassEffectiveSeq());}
				if(orderItem.getAgencyCustomerId() != null && !"".equals(orderItem.getAgencyCustomerId()))					
				{data.setAgency_customer_id(Integer.parseInt(orderItem.getAgencyCustomerId()));}
				if(orderItem.getAgencyRefNbr()!=null) {data.setAgent_ref_nbr(orderItem.getAgencyRefNbr());}
				if(orderItem.getBundleQty()!=0) {data.setBundle_qty(orderItem.getBundleQty());}
				if(orderItem.getOrderQty()!=0) {data.setOrder_qty(orderItem.getOrigOrderQty());}
				if(orderItem.getOrderCategory()!=null) {data.setOrder_category(orderItem.getOrderCategory());}
				if(orderItem.getAltShipCustomerId()!=0) {data.setAlt_ship_customer_id(orderItem.getAltShipCustomerId());}
				if(orderItem.getAltShipCustomerAddressSeq()!=0) {data.setAlt_ship_customer_address_seq(orderItem.getAltShipCustomerAddressSeq());}
				if(orderItem.getRenewToCustomerId()!=0) {data.setRenew_to_customer_id(orderItem.getRenewToCustomerId());}
				if(orderItem.getRenewToCustomerAddressSeq()!=0) {data.setRenew_to_customer_address_seq(orderItem.getRenewToCustomerAddressSeq());}
				if(orderItem.getBillToCustomerId()!=0) {data.setBill_to_customer_id(orderItem.getBillToCustomerId());}
				if(orderItem.getBillToCustomerAddressSeq()!=0) {data.setBill_to_customer_address_seq(orderItem.getBillToCustomerAddressSeq());}				
				if(orderItem.getCurrency()!=null) {data.setCurrency(orderItem.getCurrency());}				
				if(orderItem.getInvoiceDate()!=null) {					
					Date invDate = inSDF.parse(orderItem.getInvoiceDate());
					String invFinalDate = outSDF.format(invDate);
			    data.setInvoice_date(new PropertyUtilityClass().dateFormatter(invFinalDate));	}
				if(orderItem.getHasTax()!=0) {
				data.setInclude_tax(ZZBoolean.yes);}
				if(orderItem.getIsProforma()!=0) {
					data.setIs_proforma(Boolean.TRUE);}
				if(orderItem.getShippingPriceList()!=null) {
					data.setShipping_price_list(orderItem.getShippingPriceList());}
				if(orderItem.getStartDate()!=null) {
					Date startDate = inSDF.parse(orderItem.getStartDate());
					String startFinalDate = outSDF.format(startDate);
				data.setStart_date(new PropertyUtilityClass().dateFormatter(startFinalDate));}
				if(orderItem.getExpireDate()!=null) {
					Date expireDate = inSDF.parse(orderItem.getExpireDate());
					String expireFinalDate = outSDF.format(expireDate);
				data.setExpire_date(new PropertyUtilityClass().dateFormatter(expireFinalDate));}
				if(orderItem.getGenericPromotionCode()!=null) {data.setGeneric_promotion_code(orderItem.getGenericPromotionCode());}
				if(orderItem.getIsProforma()!=0) {
					data.setIs_proforma(Boolean.TRUE);}
				if(orderItem.getManualDiscAmtBase()!=0) {
					data.setManual_disc_amt_base(new BigDecimal(orderItem.getManualDiscAmtBase()));
				}
				if(orderItem.getManualDiscAmtLocal()!=0) {
					data.setManual_disc_amt_local(new BigDecimal(orderItem.getManualDiscAmtLocal()));
				}
				if(orderItem.getManualDiscPercentage()!=0) {
					data.setManual_disc_percentage(new BigDecimal(orderItem.getManualDiscPercentage()));
				}
				item_data[i] = data;
			 	order_data.setItem_data(item_data);			
			 	if((orderItem.getOrderhdrId())!=0) { 
				order_data.setOrderhdr_id(Integer.parseInt(String.valueOf(orderItem.getOrderhdrId())));}
				order_data.setPo_number(orderItem.getPoNumber());
				if(orderItem.getGenericPromotionCode()!=null) {data.setGeneric_promotion_code(orderItem.getGenericPromotionCode());}
				if(orderItem.getIsProforma()!=0) {
					data.setIs_proforma(Boolean.TRUE);}
				orderAddRequest.setOrder_data(order_data);
				
				if(orderCodeType[k].equals("4")) {
					
				StringBuilder query= new StringBuilder("select pkg_def_content.pkg_def_id, pkg_def_content.order_code_id, pkg_def_content.pkg_content_seq,pkg_content.qty,item_order_code_id,");
				query.append("pkg_def_content.subscription_def_id, order_code.order_code,oc.oc,pkg_def_content.revenue_percent,oc.oc_id,case when subscription_def.rate_class_id is null then (case when order_code.newsub_rate_class_id is not null " ); 
				query.append("then order_code.newsub_rate_class_id else pkg_def.rate_class_id end) else subscription_def.rate_class_id end as rate_class_id, ");
				query.append("pkg_def_content.issue_id,pkg_def_content.product_id,pkg_def_content.subscription_def_id , ");
				query.append("(select order_code_type from order_code where order_code.order_code_id=pkg_content.item_order_code_id)as orderCodeType, ");
				query.append("(select oc_id from order_code where order_code.order_code_id=pkg_content.item_order_code_id)as contentOcId, pkg_def.pkg_price_method  ");
				query.append("from pkg_def inner join pkg_def_content on pkg_def.pkg_def_id=pkg_def_content.pkg_def_id ");  
				query.append("inner join pkg_content on pkg_content.pkg_content_seq=pkg_def_content.pkg_content_seq ");
				query.append("inner join order_code on order_code.order_code_id= pkg_content.order_code_id ");
				query.append("inner join oc on oc.oc_id = order_code.oc_id left join subscription_def on subscription_def.subscription_def_id = pkg_def_content.subscription_def_id ");
				query.append("where pkg_def_content.order_code_id = '"+data.getOrder_code_id()+"' and pkg_def_content.pkg_def_id = '"+pkgDefId[k]+"' and order_code.order_code_id = '"+data.getOrder_code_id()+"'");
				
				List<Map<String, Object>> pkgMemberList = null;
					pkgMemberList = jdbcTemplate.queryForList(query.toString());
					//Item_data[] itemData = new Item_data[(pkgMemberList.size())];				    
					for(int j=0;j<pkgMemberList.size();j++) {
						i++;
						 Item_data pkgdata =new Item_data();
				         Order_data pkgOrderData = new Order_data();
					//for (Map<String, Object> pkgMember : pkgMemberList) {	
				        pkgdata.setOrder_code_id(Integer.parseInt(pkgMemberList.get(j).get("item_order_code_id").toString()));		
						pkgdata.setSource_code_id(Integer.parseInt(sourceCode));
						pkgdata.setPkg_content_seq(Integer.parseInt(pkgMemberList.get(j).get("pkg_content_seq").toString()));
						pkgdata.setContent_of(String.valueOf(tempContentID));
						switch(Integer.parseInt(pkgMemberList.get(j).get("orderCodeType").toString())) { 
				        case 0:			        	
				        	if(pkgMemberList.get(j).get("subscription_def_id")!=null) {
							    pkgdata.setSubscription_def_id(Integer.parseInt(pkgMemberList.get(j).get("subscription_def_id").toString()));
				        	}else {			     
				        		subscriptionDefinitionList = customerOrderService.getSubscriptionDetailsByOrderCodeId(Integer.parseInt(pkgMemberList.get(j).get("item_order_code_id").toString()));
								int subscription_def_id = 0;
								if (subscriptionDefinitionList.size() != 0 && subscriptionDefinitionList.size() == 1) {
									subscription_def_id = Integer
											.parseInt(subscriptionDefinitionList.get(0).get("subscription_def_id").toString());
								} else {
									subscription_def_id = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
								}
							    pkgdata.setSubscription_def_id(subscription_def_id);							
				        	}
				        	break;
				        case 1:
				        	  	if(pkgMemberList.get(j).get("issue_id")!=null){
								pkgdata.setStart_issue_id(Integer.parseInt(pkgMemberList.get(j).get("issue_id").toString()));
				        	}else {
				        		issueModelsList = customerOrderService.getSubscriptionStartDate(Integer.parseInt(pkgMemberList.get(j).get("contentOcId").toString()));
								int issueId = 0;
								if (issueModelsList.size() != 0 && issueModelsList.size() == 1) {
									issueId = (int) issueModelsList.get(0).getIssueId();
								} else {
									issueId = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
								}
				        		pkgdata.setStart_issue_id(issueId);	
				        	}
				        	break;
				        case 2:
				        	     	
				        	if(pkgMemberList.get(j).get("product_id")!=null) {
								pkgdata.setProduct_id(Integer.parseInt(pkgMemberList.get(j).get("product_id").toString()));
				        	}else {
				        		int productId = 0;
								productModelsList = customerOrderService.getProductDefinitionList(Integer.parseInt(pkgMemberList.get(j).get("item_order_code_id").toString()));
								if (productModelsList.size() != 0 && productModelsList.size() == 1) {
									productId = productModelsList.get(0).getProductId();
								} else {
									productId = Integer.parseInt(subscriptionIdListFromFronEnd.get(counter++));
								}	
				        		pkgdata.setProduct_id(productId);
				        	}					  
						}					
				item_data[i] = pkgdata;
				pkgOrderData.setItem_data(item_data);			
			 	if((orderItem.getOrderhdrId())!=0) { 
			 		pkgOrderData.setOrderhdr_id(Integer.parseInt(String.valueOf(orderItem.getOrderhdrId())));}
			 	pkgOrderData.setPo_number(orderItem.getPoNumber());
				orderAddRequest.setOrder_data(pkgOrderData);
				
				}
				}
				}  k++;
				} tempContentID=tempContentID+1;
				}
				System.out.println("orderAddRequest : "+orderAddRequest.toString());
				response=soap.orderAdd(orderAddRequest);
				list.add(response);		
			}
			catch(AxisFault e){			
				//SOAPFault sf=new org.apache.axis.message.SOAPFault(e);
				String fault=e.getFaultDetails()[0].getAttributes().getNamedItem("error_description").getNodeValue().toString();
				LOGGER.info("OrderAddWsdl = "+fault);		
				status=fault;
			}
			catch(Exception e){
				LOGGER.info("OrderAddWsdl = "+e);
				status="false";
			}
			return list;		
		}
	
	public List<Order_item_edit_response> getDataExpireDateCal(Integer orderhdrId, Integer orderItemSeq,
			Integer docDefId, String expireDate, BigDecimal localAmount) throws ServiceException, ParseException {
		Item_amt_break_data list[] = new Item_amt_break_data[10];
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		Order_item_edit_request expireDateOption = new Order_item_edit_request();
		Order_item_edit_response expireDateCalResponse = new Order_item_edit_response();
		List<Order_item_edit_response> responseList = new ArrayList<>();
		expireDateOption.setDsn(new PropertyUtilityClass().getQuery("dsn"));
		expireDateOption.setDoc_ref_id(docDefId);

		User_login_data login = new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));
		login.setPassword(new PropertyUtilityClass().getQuery("password"));

		ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
		itemIdentifier.setOrderhdr_id(orderhdrId);
		itemIdentifier.setOrder_item_seq(orderItemSeq);

		expireDateOption.setItem_identifier(itemIdentifier);
		expireDateOption.setUser_login_data(login);
		Item_data data = new Item_data();
		SimpleDateFormat inSDF = new SimpleDateFormat("MM/dd/yyyy");
		Date expire1 = inSDF.parse(expireDate);
		data.setExpire_date(expire1);
		Item_amt_break_data itemAmtBreakData = new Item_amt_break_data();
		itemAmtBreakData.setLocal_amount(localAmount);
		itemAmtBreakData.setOrder_item_break_type(Order_item_break_type.item);
		list[0] = itemAmtBreakData;
		data.setItem_amt_break_data(list);
		expireDateOption.setItem_data(data);

		try {
			expireDateCalResponse = soap.orderItemEdit(expireDateOption);
			if (expireDateCalResponse != null) {
				responseList.add(expireDateCalResponse);
			}
		} catch (Exception ex) {
			LOGGER.info("expire date change for date base order = " + ex);
		}
		return responseList;

		}
	public String getalreadySubscribed(int customerId,int orderCodeType,String orderCodeID,Optional<Integer> sourceCode,Optional<Integer> packageDefId,int itemCount) throws Exception {
		String status="true";
			Item_already_subscribed_list_request alreadySubscribedRequest = new Item_already_subscribed_list_request();
			Order_data[]response= null;
			List<Order_data[]> list = new ArrayList<>();
			try{
				String tempContentID="001";
				ThinkSoap soap = null;
				ThinkWSLocator locator = new ThinkWSLocator();
				soap = locator.getThinkSoap();
				
				alreadySubscribedRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
				User_login_data login=new User_login_data();
				login.setLogin(new PropertyUtilityClass().getQuery("login"));	
				login.setPassword( new PropertyUtilityClass().getQuery("password"));
				alreadySubscribedRequest.setUser_login_data(login);
				Customer_identifier customer_identifier = new Customer_identifier(); 
				customer_identifier.setCustomer_id(customerId);			
				Customer_address_identifier customer_address_identifier = new Customer_address_identifier();
				customer_address_identifier.setCustomer_identifier(customer_identifier);
				customer_address_identifier.setCustomer_address_seq(1);		
				alreadySubscribedRequest.setCustomer_address_identifier(customer_address_identifier);
				int dataCount=0;
				String subscrip_Id=jdbcTemplate.queryForObject("select top 1 subscrip_id  from order_item where order_code_id="+orderCodeID+" and customer_id= "+customerId+" and cancel_date is  null order by orderhdr_id desc " , String.class);
				dataCount=itemCount;
				if(String.valueOf(orderCodeType).equals("4")) {
						int memberCount=jdbcTemplate.queryForObject("select count(item_order_code_id) from pkg_content where order_code_id="+orderCodeID+"", Integer.class);
						dataCount=dataCount+memberCount;
					}
				Item_data[] item_data = new Item_data[dataCount];
				for(int k=0;k<itemCount;k++) {
				for(int i=0;i<item_data.length;i++) {	
				
					Item_data data =new Item_data();
					Order_data order_data = new Order_data();
				
				data.setOrder_code_id(Integer.parseInt(orderCodeID));		
				data.setSource_code_id(sourceCode.get());
				data.setPkg_def_id(packageDefId.get());
				if(packageDefId.isPresent()) 
				{
				data.setTemp_id(String.valueOf(tempContentID));
				}
				data.setSubscrip_id(Integer.parseInt(subscrip_Id));
				item_data[i] = data;
			 	order_data.setItem_data(item_data);			
			 	alreadySubscribedRequest.setOrder_data(order_data);
				
				if(String.valueOf(orderCodeType).equals("4")) {
					
				StringBuilder query= new StringBuilder("select pkg_def_content.pkg_def_id, pkg_def_content.order_code_id, pkg_def_content.pkg_content_seq,pkg_content.qty,item_order_code_id,");
				query.append("pkg_def_content.subscription_def_id, order_code.order_code,oc.oc,pkg_def_content.revenue_percent,oc.oc_id,case when subscription_def.rate_class_id is null then (case when order_code.newsub_rate_class_id is not null " ); 
				query.append("then order_code.newsub_rate_class_id else pkg_def.rate_class_id end) else subscription_def.rate_class_id end as rate_class_id, ");
				query.append("pkg_def_content.issue_id,pkg_def_content.product_id,pkg_def_content.subscription_def_id , ");
				query.append("(select order_code_type from order_code where order_code.order_code_id=pkg_content.item_order_code_id)as orderCodeType, ");
				query.append("(select oc_id from order_code where order_code.order_code_id=pkg_content.item_order_code_id)as contentOcId, pkg_def.pkg_price_method  ");
				query.append("from pkg_def inner join pkg_def_content on pkg_def.pkg_def_id=pkg_def_content.pkg_def_id ");  
				query.append("inner join pkg_content on pkg_content.pkg_content_seq=pkg_def_content.pkg_content_seq ");
				query.append("inner join order_code on order_code.order_code_id= pkg_content.order_code_id ");
				query.append("inner join oc on oc.oc_id = order_code.oc_id left join subscription_def on subscription_def.subscription_def_id = pkg_def_content.subscription_def_id ");
				query.append("where pkg_def_content.order_code_id = '"+data.getOrder_code_id()+"' and pkg_def_content.pkg_def_id = '"+packageDefId.get()+"' and order_code.order_code_id = '"+data.getOrder_code_id()+"'");
				
				List<Map<String, Object>> pkgMemberList = null;
					pkgMemberList = jdbcTemplate.queryForList(query.toString());
					//Item_data[] itemData = new Item_data[(pkgMemberList.size())];				    
					for(int j=0;j<pkgMemberList.size();j++) {
						i++;
						 Item_data pkgdata =new Item_data();
				         Order_data pkgOrderData = new Order_data();
					//for (Map<String, Object> pkgMember : pkgMemberList) {	
				        pkgdata.setOrder_code_id(Integer.parseInt(pkgMemberList.get(j).get("item_order_code_id").toString()));		
						pkgdata.setSource_code_id(sourceCode.get());
						pkgdata.setPkg_content_seq(Integer.parseInt(pkgMemberList.get(j).get("pkg_content_seq").toString()));
						pkgdata.setContent_of(String.valueOf(tempContentID));
						switch(Integer.parseInt(pkgMemberList.get(j).get("orderCodeType").toString())) { 
				        case 0:			        	
				        	if(pkgMemberList.get(j).get("subscription_def_id")!=null) {
							    pkgdata.setSubscription_def_id(Integer.parseInt(pkgMemberList.get(j).get("subscription_def_id").toString()));}
				        	   	break;
				        case 1:
				        	  	if(pkgMemberList.get(j).get("issue_id")!=null){
								pkgdata.setStart_issue_id(Integer.parseInt(pkgMemberList.get(j).get("issue_id").toString()));
				        	}
				        	break;
				        case 2:				        	     	
				        	if(pkgMemberList.get(j).get("product_id")!=null) {
								pkgdata.setProduct_id(Integer.parseInt(pkgMemberList.get(j).get("product_id").toString()));
				        	}					  
						}					
				item_data[i] = pkgdata;
				pkgOrderData.setItem_data(item_data);			
				alreadySubscribedRequest.setOrder_data(pkgOrderData);
				
				}
				}
				}  k++;
				} tempContentID=tempContentID+1;
				
				System.out.println("alreadySubscribedRequest : "+alreadySubscribedRequest.toString());
				response=soap.itemAlreadySubscribedList(alreadySubscribedRequest);
				list.add(response);		
			}
			catch(AxisFault e){			
				//SOAPFault sf=new org.apache.axis.message.SOAPFault(e);
				String fault=e.getFaultDetails()[0].getAttributes().getNamedItem("error_description").getNodeValue().toString();
				LOGGER.info("alreadySubscribedRequest = "+fault);		
				status=fault;
			}
			catch(Exception e){
				LOGGER.info("alreadySubscribedRequest = "+e);
				status="false";
			}
			return status;				
		}


	public List<Package_edit_response> getpkgDefinitionChangeData(Integer orderhdrId, Integer orderItemSeq,
			Integer docDefId, Integer pkgDefId, List<Map<String, Object>> listDataForPkg, int pkgMemberCount)
			throws ServiceException {
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		Package_edit_request pkgEditRequest = new Package_edit_request();
		Package_edit_response pkgEditResponse = new Package_edit_response();
		List<Package_edit_response> responseList = new ArrayList<>();
		pkgEditRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
		pkgEditRequest.setDoc_ref_id(docDefId);

		User_login_data login = new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));
		login.setPassword(new PropertyUtilityClass().getQuery("password"));

		ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
		itemIdentifier.setOrderhdr_id(orderhdrId);
		itemIdentifier.setOrder_item_seq(orderItemSeq);

		pkgEditRequest.setItem_identifier(itemIdentifier);
		pkgEditRequest.setUser_login_data(login);

		Package_item_data pkgItemData = new Package_item_data();
		pkgItemData.setPkg_def_id(pkgDefId);
		pkgEditRequest.setPackage_item_data(pkgItemData);
		int OdrItemSeq = 0;
		Member_item_data[] member_item_data = new Member_item_data[pkgMemberCount];
		for (int i = 1; i <= pkgMemberCount; i++) {
			Member_item_data memberData = new Member_item_data();
			ZZItemIdentifier itemData = new ZZItemIdentifier();
			itemData.setOrderhdr_id(orderhdrId);
			itemData.setOrder_item_seq(Integer.parseInt((listDataForPkg.get(i).get("order_item_seq").toString())));
			memberData.setItem_identifier(itemData);
			member_item_data[OdrItemSeq] = memberData;
			OdrItemSeq++;
		}
		pkgEditRequest.setMember_item_data(member_item_data);
		try {
			pkgEditResponse = soap.packageEdit(pkgEditRequest);
			if (pkgEditResponse != null) {
				responseList.add(pkgEditResponse);
			}
		} catch (Exception ex) {
			LOGGER.info("pkg def change  = " + ex);
		}
		return responseList;

	}


	public List<Package_edit_response> getExpireDateChangeInPkgData(Integer orderhdrId, Integer orderItemSeq,
			Integer docDefId, String expireDate) throws ServiceException, ParseException {
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		Package_edit_request pkgEditRequest = new Package_edit_request();
		Package_edit_response pkgEditResponse = new Package_edit_response();
		List<Package_edit_response> responseList = new ArrayList<>();
		pkgEditRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
		pkgEditRequest.setDoc_ref_id(docDefId);

		User_login_data login = new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));
		login.setPassword(new PropertyUtilityClass().getQuery("password"));

		ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
		itemIdentifier.setOrderhdr_id(orderhdrId);
		itemIdentifier.setOrder_item_seq(orderItemSeq);

		pkgEditRequest.setItem_identifier(itemIdentifier);
		pkgEditRequest.setUser_login_data(login);

		Package_item_data pkgItemData = new Package_item_data();
		SimpleDateFormat inSDF = new SimpleDateFormat("MM/dd/yyyy");
		Date expire1 = inSDF.parse(expireDate);
		pkgItemData.setExpire_date(expire1);
		pkgEditRequest.setPackage_item_data(pkgItemData);
		try {
			pkgEditResponse = soap.packageEdit(pkgEditRequest);
			if (pkgEditResponse != null) {
				responseList.add(pkgEditResponse);
			}
		} catch (Exception ex) {
			LOGGER.info("expire date chnage  = " + ex);
		}
		return responseList;

	}



	public List<Package_edit_response> getDataOrderQunatityChangeInPkg(Integer orderhdrId, Integer orderItemSeq,
			Integer docDefId, int orderQuantity) throws ServiceException {
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		Package_edit_request pkgEditRequest = new Package_edit_request();
		Package_edit_response pkgEditResponse = new Package_edit_response();
		List<Package_edit_response> responseList = new ArrayList<>();
		pkgEditRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
		pkgEditRequest.setDoc_ref_id(docDefId);

		User_login_data login = new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));
		login.setPassword(new PropertyUtilityClass().getQuery("password"));

		ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
		itemIdentifier.setOrderhdr_id(orderhdrId);
		itemIdentifier.setOrder_item_seq(orderItemSeq);

		pkgEditRequest.setItem_identifier(itemIdentifier);
		pkgEditRequest.setUser_login_data(login);

		Package_item_data pkgItemData = new Package_item_data();
		pkgItemData.setBundle_qty(orderQuantity);
		pkgEditRequest.setPackage_item_data(pkgItemData);
		try {
			pkgEditResponse = soap.packageEdit(pkgEditRequest);
			if (pkgEditResponse != null) {
				responseList.add(pkgEditResponse);
			}
		} catch (Exception ex) {
			LOGGER.info("expire date chnage  = " + ex);
		}
		return responseList;

	}



	public List<Order_item_edit_response> getStartDateCalculation(int orderhdrId, int orderItemSeq, Integer docDefId,
			String startDate) throws ParseException, ServiceException {
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		Order_item_edit_request startDateOption = new Order_item_edit_request();
		Order_item_edit_response startDateCalResponse = new Order_item_edit_response();
		List<Order_item_edit_response> responseList = new ArrayList<>();
		startDateOption.setDsn(new PropertyUtilityClass().getQuery("dsn"));
		startDateOption.setDoc_ref_id(docDefId);

		User_login_data login = new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));
		login.setPassword(new PropertyUtilityClass().getQuery("password"));

		ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
		itemIdentifier.setOrderhdr_id(orderhdrId);
		itemIdentifier.setOrder_item_seq(orderItemSeq);

		startDateOption.setItem_identifier(itemIdentifier);
		startDateOption.setUser_login_data(login);
		Item_data data = new Item_data();
		SimpleDateFormat inSDF = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate1 = inSDF.parse(startDate);
		data.setStart_date(startDate1);
		startDateOption.setItem_data(data);

		try {
			startDateCalResponse = soap.orderItemEdit(startDateOption);
			if (startDateCalResponse != null) {
				responseList.add(startDateCalResponse);
			}
		} catch (Exception ex) {
			LOGGER.info("start date change for date base order = " + ex);
		}
		return responseList;

		}



	public List<Package_edit_response> getOnEditCodeChange(Integer orderhdrId, Integer orderItemSeq, Integer docDefId,
			Integer sourceCodeId, BigDecimal localAmount) throws ServiceException {
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		Package_edit_request pkgEditRequest = new Package_edit_request();
		Package_edit_response pkgEditResponse = new Package_edit_response();
		List<Package_edit_response> responseList = new ArrayList<>();
		pkgEditRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
		pkgEditRequest.setDoc_ref_id(docDefId);
		pkgEditRequest.setSubmit(ZZBoolean.no);
		User_login_data login = new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));
		login.setPassword(new PropertyUtilityClass().getQuery("password"));

		ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
		itemIdentifier.setOrderhdr_id(orderhdrId);
		itemIdentifier.setOrder_item_seq(orderItemSeq);

		pkgEditRequest.setItem_identifier(itemIdentifier);
		pkgEditRequest.setUser_login_data(login);

		Package_item_data pkgItemData = new Package_item_data();
		if(sourceCodeId !=null) {
		pkgItemData.setSource_code_id(sourceCodeId);
		}else if(localAmount != null) {
			Item_amt_break_data itemAmtBreakData = new Item_amt_break_data();
			itemAmtBreakData.setLocal_amount(localAmount);
			itemAmtBreakData.setOrder_item_break_type(Order_item_break_type.item);
			//list[0] = itemAmtBreakData;
			pkgItemData.setItem_amt_break_data(itemAmtBreakData);
		}
		pkgEditRequest.setPackage_item_data(pkgItemData);
		try {
			pkgEditResponse = soap.packageEdit(pkgEditRequest);
			if (pkgEditResponse != null) {
				responseList.add(pkgEditResponse);
			}
		} catch (Exception ex) {
			LOGGER.info("expire date chnage  = " + ex);
		}
		return responseList;

	}



	public List<Package_edit_response> getPkgIssueIdChange(Integer orderhdrId, Integer orderItemSeq, Integer docDefId,
			Integer startIssueId,Integer memberOrderItemSeq, String startDate) throws ServiceException, ParseException {
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		Package_edit_request pkgEditRequest = new Package_edit_request();
		Package_edit_response pkgEditResponse = new Package_edit_response();
		List<Package_edit_response> responseList = new ArrayList<>();
		pkgEditRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
		pkgEditRequest.setDoc_ref_id(docDefId);

		User_login_data login = new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));
		login.setPassword(new PropertyUtilityClass().getQuery("password"));

		ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
		itemIdentifier.setOrderhdr_id(orderhdrId);
		itemIdentifier.setOrder_item_seq(orderItemSeq);

		pkgEditRequest.setItem_identifier(itemIdentifier);
		pkgEditRequest.setUser_login_data(login);

		Member_item_data[] member_item_data = new Member_item_data[1];
			Member_item_data memberData = new Member_item_data();
			ZZItemIdentifier itemData = new ZZItemIdentifier();
			itemData.setOrderhdr_id(orderhdrId);
			itemData.setOrder_item_seq(memberOrderItemSeq);
			memberData.setItem_identifier(itemData);
			if(startIssueId !=null) {
				memberData.setStart_issue_id(startIssueId);
			}
			else if(!startDate.equals(null)) {
				SimpleDateFormat inSDF1 = new SimpleDateFormat("MM/dd/yyyy");
				SimpleDateFormat outSDF1 = new SimpleDateFormat("yyyy-MM-dd");
				Date startDate1 = inSDF1.parse(startDate);
				String startFinalDate = outSDF1.format(startDate1);
				memberData.setStart_date(new PropertyUtilityClass().dateFormatter(startFinalDate));
			
			}
						
			member_item_data[0] = memberData;
		pkgEditRequest.setMember_item_data(member_item_data);
		try {
			pkgEditResponse = soap.packageEdit(pkgEditRequest);
			if (pkgEditResponse != null) {
				responseList.add(pkgEditResponse);
			}
		} catch (Exception ex) {
			LOGGER.info("issue id chnage  = " + ex);
		}
		return responseList;

	}



	public List<Package_edit_response> getIncludeTax(Integer orderhdrId, Integer orderItemSeq, Integer docDefId,
			int yesNo) throws ServiceException {
		
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
		Package_edit_request pkgEditRequest = new Package_edit_request();
		Package_edit_response pkgEditResponse = new Package_edit_response();
		List<Package_edit_response> responseList = new ArrayList<>();
		pkgEditRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
		pkgEditRequest.setDoc_ref_id(docDefId);
		pkgEditRequest.setSubmit(ZZBoolean.no);
		User_login_data login = new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));
		login.setPassword(new PropertyUtilityClass().getQuery("password"));

		ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
		itemIdentifier.setOrderhdr_id(orderhdrId);
		itemIdentifier.setOrder_item_seq(orderItemSeq);

		pkgEditRequest.setItem_identifier(itemIdentifier);
		pkgEditRequest.setUser_login_data(login);
		Package_item_data pkgItemData = new Package_item_data();
		if(yesNo == 1) {
				pkgItemData.setInclude_tax(ZZBoolean.yes );
		}else{
			pkgItemData.setInclude_tax(ZZBoolean.no);
		}
		pkgEditRequest.setPackage_item_data(pkgItemData);
		try {
			pkgEditResponse = soap.packageEdit(pkgEditRequest);
			if (pkgEditResponse != null) {
				responseList.add(pkgEditResponse);
			}
		} catch (Exception ex) {
			LOGGER.info("include tax .....  = " + ex);
		}
		return responseList;

	}
}
