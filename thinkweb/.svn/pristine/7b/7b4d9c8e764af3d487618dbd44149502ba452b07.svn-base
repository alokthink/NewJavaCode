package com.mps.think.setup.catalogs.daoImpl;

import static com.mps.think.constants.SecurityConstants.ERROR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mps.think.daoImpl.PaymentInfoDaoImpl;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderCode;
import com.mps.think.model.SourceCode;
import com.mps.think.model.SubscriptionDefinition;
import com.mps.think.resultMapper.OrderSourceOfferMapper;
import com.mps.think.resultMapper.SubscriptionPackageDefMapper;
import com.mps.think.setup.catalogs.dao.CatalogsDao;
import com.mps.think.setup.catalogs.model.CatalogContentModel;
import com.mps.think.setup.catalogs.model.ParentCatalogsModel;

@Repository
public class CatalogsDaoImpl implements CatalogsDao{
	

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentInfoDaoImpl.class);
	private static final String ERROR = "Error"; 

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate; 

	
		
	@Override
	public List<DropdownModel> getCatalogCodeDetails(Integer sourceCodeId, String action) {
		
		List<DropdownModel> descriptionList = new ArrayList<>();
		String actionvalue = action.toLowerCase();
		try {
			switch(actionvalue) 
			{
			
				case "all":
					
					actionvalue="all";
					List<Map<String,Object>> details = jdbcTemplate.queryForList("select source_code_id,source_code,description,active as status,from_date,to_date from source_code  ");
					System.out.println(details);
					for(Map<String,Object> detail:details){
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("source_code_id").toString());
						model.setDescription(detail.get("source_code")!=null?detail.get("source_code").toString():"");
						model.setExtra(detail.get("description")!=null?detail.get("description").toString():"");
						descriptionList.add(model);
					}
					break;
				case "active":
					actionvalue = "active";
					System.out.println("active");
					List<Map<String,Object>> activeDetails = jdbcTemplate.queryForList("select source_code_id,source_code,description,active as status,from_date,to_date from source_code where active="+1);
					System.out.println(activeDetails);
					System.out.println(jdbcTemplate.queryForList("select source_code.source_code_id,source_code.source_code,source_code.description,source_code.active as status,source_code.from_date,source_code.to_date from source_code inner join source_code_state on source_code_state.source_code_id=source_code.source_code_id  where source_code.active=1"));
					for(Map<String,Object> detail:activeDetails){
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("source_code_id").toString());	
						model.setDescription(detail.get("source_code")!=null?detail.get("source_code").toString():"");
					model.setExtra(detail.get("description")!=null?detail.get("description").toString():"");
					descriptionList.add(model);
				}
					break;
				case "inactive":
					actionvalue = "inactive";
					List<Map<String,Object>> inactiveDetails = jdbcTemplate.queryForList("select source_code.source_code_id,source_code.source_code,source_code.description,source_code.active as status,source_code.from_date,source_code.to_date from source_code left join source_code_state on source_code.source_code_id=source_code_state.source_code_id  where source_code.active=0 order by source_code.source_code_id ;");
					for(Map<String,Object> detail:inactiveDetails){
						DropdownModel model = new DropdownModel();
						model.setDisplay(detail.get("source_code_id").toString());
						model.setDescription(detail.get("source_code")!=null?detail.get("source_code").toString():"");
						model.setExtra(detail.get("description")!=null?detail.get("description").toString():"");
						descriptionList.add(model);
					}
					break;
		    }
		
			
	}
	catch (Exception e) {
		LOGGER.error(ERROR + e);
	}
 return descriptionList;	
}



	@Override
	public int addCatalogCode(ParentCatalogsModel catalogModel) {
		Map<String, Object> addSourceParams = new HashMap<>();
		int status=0;
		StringBuilder sourceCodeQuery = new StringBuilder("insert into source_code(source_code_id,agency_customer_id,source_format,source_code,description,state_break,generated,breakeven,")
				.append("offer,list,from_date,to_date,qty,cost,audit_qual_category,generic_agency,oc_id,active,newsub_rate_class_id,new_renewal_card_id,")
				.append("newsub_discount_class_id,audit_subscription_type_id,audit_qual_source_id,audit_name_title_id,audit_sales_channel_id,")
				.append("premium_order_code_id,source_code_type,mru_catalog_content_seq,currency,mru_generic_promotion_code_seq,is_ddp,shipping_price_list)")
				.append(" values (:source_code_id,:agency_customer_id,:source_format,:source_code,:description,:state_break,:generated,:breakeven,")
				.append(":offer,:list,:from_date,:to_date,:qty,:cost,:audit_qual_category,:generic_agency,:oc_id,:active,:newsub_rate_class_id,:new_renewal_card_id,")
				.append(":newsub_discount_class_id,:audit_subscription_type_id,:audit_qual_source_id,:audit_name_title_id,:audit_sales_channel_id,")
				.append(":premium_order_code_id,:source_code_type,:mru_catalog_content_seq,:currency,:mru_generic_promotion_code_seq,:is_ddp,:shipping_price_list)");
		
	
		try {
			//for source_code table
			addSourceParams.clear();
			
			String sourceCodeId = jdbcTemplate.queryForObject("select MAX(source_code_id) from source_code",
					String.class);
			LOGGER.info("sourceCodeId:{}",sourceCodeId);
			if ( sourceCodeId == null) {
				addSourceParams.put("source_code_id", 1);// if table order_code_id column is null then add 1 to first
														// record
			} else {
				addSourceParams.put("source_code_id", Integer.parseInt( sourceCodeId) + 1);
			}
			
			
			
			addSourceParams.put("agency_customer_id",catalogModel.getAgencyCustomerId()!=null?catalogModel.getAgencyCustomerId():null);
			addSourceParams.put("source_format", catalogModel.getSourceFormat()!=null?catalogModel.getSourceFormat():null);
			if( ("null".equals(catalogModel.getSourceFormat()) ) | ("".equals(catalogModel.getSourceFormat()) )  ) {
				addSourceParams.put("source_format", null);
			}else {
				addSourceParams.put("source_format", catalogModel.getSourceFormat());
			}
			addSourceParams.put("source_code", catalogModel.getEntryCode());
			
				addSourceParams.put("description", catalogModel.getDescription());
			
			addSourceParams.put("state_break", catalogModel.getStateBreak()!=null?catalogModel.getStateBreak():0);
			addSourceParams.put("generated", catalogModel.getGenerated()!=null?catalogModel.getGenerated():0);
			addSourceParams.put("breakeven", catalogModel.getBreakeven()!=null?catalogModel.getBreakeven():null);
			if( ("null".equals(catalogModel.getOffer()) ) | ("".equals(catalogModel.getOffer()) )  ) {
				addSourceParams.put("offer", null);
			}else {
				addSourceParams.put("offer", catalogModel.getOffer());
			}
			
			if( ("null".equals(catalogModel.getList()) ) | ("".equals(catalogModel.getList()) )  ) {
				addSourceParams.put("list", null);
			}else {
				addSourceParams.put("list", catalogModel.getList());
			}
			
			if( ("null".equals(catalogModel.getFromDate()) ) | ("".equals(catalogModel.getFromDate()) )  ) {
				addSourceParams.put("from_date", null);
			}else {
				addSourceParams.put("from_date", catalogModel.getFromDate());
			}
			
			if( ("null".equals(catalogModel.getToDate()) ) | ("".equals(catalogModel.getToDate()) )  ) {
				addSourceParams.put("to_date", null);
			}else {
				addSourceParams.put("to_date", catalogModel.getToDate());
			}
			addSourceParams.put("qty", catalogModel.getQty()!=null?catalogModel.getQty():null);
			addSourceParams.put("cost", catalogModel.getCost());
			addSourceParams.put("audit_qual_category", catalogModel.getAuditQualCategory());
			addSourceParams.put("generic_agency", catalogModel.getGenericAgency()!=null?catalogModel.getGenericAgency():0);
			addSourceParams.put("oc_id", catalogModel.getOcId());
			addSourceParams.put("active", catalogModel.getActive());
			addSourceParams.put("newsub_rate_class_id", catalogModel.getNewsubRateClassId()!=null?catalogModel.getNewsubRateClassId():null);
			addSourceParams.put("new_renewal_card_id", catalogModel.getNewRenewalCardId()!=null?catalogModel.getNewRenewalCardId():null);
			addSourceParams.put("newsub_discount_class_id", catalogModel.getNewsubDiscountClassId()!=null?catalogModel.getNewsubDiscountClassId():null);
			addSourceParams.put("audit_subscription_type_id", catalogModel.getAuditSubscriptionTypeId()!=null?catalogModel.getAuditSubscriptionTypeId():null);
			addSourceParams.put("audit_qual_source_id", catalogModel.getAuditQualSourceId()!=null?catalogModel.getAuditQualSourceId():null);
			addSourceParams.put("audit_name_title_id", catalogModel.getAuditNameTitleId()!=null?catalogModel.getAuditNameTitleId():null);
			addSourceParams.put("audit_sales_channel_id", catalogModel.getAuditSalesChannelId()!=null?catalogModel.getAuditSalesChannelId():null);
			addSourceParams.put("premium_order_code_id", catalogModel.getPremiumOrderCodeId()!=null?catalogModel.getPremiumOrderCodeId():null);
			addSourceParams.put("source_code_type", catalogModel.getSourceCodeType());
			addSourceParams.put("mru_catalog_content_seq", catalogModel.getMruCatalogContentSeq()!=null?catalogModel.getMruCatalogContentSeq():null);
			addSourceParams.put("currency", catalogModel.getCurrency()!=null?catalogModel.getCurrency():null);
			addSourceParams.put("mru_generic_promotion_code_seq", catalogModel.getMruGenericPromotionCodeSeq()!=null?catalogModel.getMruGenericPromotionCodeSeq():null);
			addSourceParams.put("is_ddp", catalogModel.getIsDdp()!=null?catalogModel.getIsDdp():0);
			addSourceParams.put("shipping_price_list", catalogModel.getShippingPriceList()!=null?catalogModel.getShippingPriceList():null);
			
			status=namedParameterJdbcTemplate.update(sourceCodeQuery.toString(), addSourceParams);
			System.out.println(status);
		}catch (Exception e) {
			LOGGER.error(ERROR+e);
		}
            
		return status;
	}



	@Override
	public int savePremium(ParentCatalogsModel catalogModel) {
		
		Map<String, Object> addSourceParams = new HashMap<>();
		int status = 0;
		try {
		Integer productIdsresult = jdbcTemplate.queryForObject("select max(product_id) from product ",Integer.class);
		System.out.println(productIdsresult);
		int productCodeId = (productIdsresult)+1;
		String SavePremium = "insert into product(product_id,oc_id,inventory_id,description,rate_class_id,product,order_code_id,taxonomy)values(:product_id,:inventory_id,:oc_id,:description,:rate_class_id,:product,:order_code_id,:taxonomy)";
		addSourceParams.put("product_id",productCodeId );
		LOGGER.info("product_id:{}",productCodeId);
		addSourceParams.put("oc_id", catalogModel.getOcId());
			
		LOGGER.info("ocId:{}",catalogModel.getOcId());
		addSourceParams.put("inventory_id", catalogModel.getInventory_id());
		
		addSourceParams.put("description", catalogModel.getDescription());
		addSourceParams.put("rate_class_id", catalogModel.getRate_class_id());
		addSourceParams.put("product", catalogModel.getProduct());
		addSourceParams.put("order_code_id", catalogModel.getOrderCodeId());
		addSourceParams.put("taxonomy", catalogModel.getTaxonomy());
		
		
	
		status=namedParameterJdbcTemplate.update(SavePremium, addSourceParams);
	}catch (Exception e) {
		LOGGER.error(ERROR+e);
	}
		
		return status;
	
}



	@Override
	public int saveAgency(ParentCatalogsModel catalogModel) {
		Map<String, Object> addSourceParams = new HashMap<>();
		int status = 0;
		try {
			Integer customerIdResult = jdbcTemplate.queryForObject("select max(customer_id) from customer where customer_id>299 ",Integer.class);
			int customerId = (customerIdResult)+1;
			String SaveAgency= "insert into agency(customer_id,payment_threshold,agency_code,company,ren_commission,new_commission)values(:customer_id,:payment_threshold,:agency_code,:company,:ren_commission,:new_commission)";
			
					
			addSourceParams.put("customer_id",customerId);
			LOGGER.info("customer_id:{}",customerId);
			
			addSourceParams.put("agency_code", catalogModel.getAgencyCode());
			LOGGER.info("agency_code:{}",catalogModel.getAgencyCode());
			
			addSourceParams.put("company", catalogModel.getCompany());
			LOGGER.info("company:{}",catalogModel.getCompany());
			
			addSourceParams.put("payment_threshold", catalogModel.getPaymentThreshhold());
			LOGGER.info("payment_threshold:{}",catalogModel.getPaymentThreshhold());
			
			addSourceParams.put("ren_commission", catalogModel.getRenCommission());
			LOGGER.info("ren_commission:{}",catalogModel.getRenCommission());
			
			addSourceParams.put("new_commission", catalogModel.getNewCommission());
			LOGGER.info("new_commission:{}",catalogModel.getNewCommission());
			
			status=namedParameterJdbcTemplate.update(SaveAgency, addSourceParams);
		}catch (Exception e) {
			LOGGER.error(ERROR+e);
		}
			
			return status;
	}



	@Override
	public int saveSorceCodeState(ParentCatalogsModel catalogModel) {
		Map<String, Object> addSourceParams = new HashMap<>();
		int status = 0;
		try{
		StringBuilder saveSourceCodestateQuery = new StringBuilder("insert into source_code_state(state,source_code_id,cost_mailing,qty_mailed)values(:state,:source_code_id,:cost_mailing,:qty_mailed)");
		addSourceParams.put("source_code_id", catalogModel.getSourceCodeId());
		addSourceParams.put("state", catalogModel.getState());
		addSourceParams.put("cost_mailing", catalogModel.getCostMailed());
		addSourceParams.put("qty_mailed", catalogModel.getQtyMailed());
		status=namedParameterJdbcTemplate.update(saveSourceCodestateQuery.toString(), addSourceParams);
		}
		catch (Exception e) {
		LOGGER.error(ERROR + e);
		}
				
		
		return status;
	}
	
	
	


	@Override
	public List<OrderCode> getOrderCodeData(String orderCode, String orderClass, String orderCodeType, String term) {

		List<OrderCode> orderCodeList = new ArrayList<OrderCode>();
		try {
			StringBuilder orderQuery = new StringBuilder();
			orderQuery.append("SELECT order_code_id,order_code.oc_id,order_code,o.oc,order_code.description,order_code_type,premium,t.term,media,edition,audit_qual_category,product_size,product_style,product_color,pkg_only_item,is_proforma,no_charge,controlled,perpetual_order,prepayment_req,active FROM order_code"
					+ " left join oc o on order_code.oc_id=o.oc_id"
					+ " left join term t on order_code.term_id=t.term_id" + " WHERE"
					+ " (active = 1 and order_code.order_code_type != 3 and order_code.order_code_type != 8 and premium != 2)");
						
			
					if(!orderClass.equals("")){
						orderQuery.append(" AND order_code.oc_id = "+orderClass);
					}
					if(!orderCodeType.equals("")){
						orderQuery.append(" AND order_code_type = "+orderCodeType);
					}
					if(!term.equals("")){
						orderQuery.append(" AND term = '"+term+"'");
					}
					if("*".equals(orderCode)){
						orderQuery.append(" AND order_code.order_code like '%'");}
					else if(orderCode.contains("*")){
						orderQuery.append(" AND order_code.order_code like '"+orderCode.replace('*','%')+"'");}
					else if(!orderCode.equals("")){
							orderQuery.append(" AND order_code.order_code ='"+orderCode+"'");
						}
					orderQuery.append(" ORDER BY order_code.oc_id,order_code.order_code");
			
			orderCodeList = jdbcTemplate.query(orderQuery.toString(), new OrderSourceOfferMapper());			
		} catch (Exception e) {
			LOGGER.info("" + e);
		}
		return orderCodeList;
	}
		
		



	@Override
	public List<Map<String, Object>> getCatalogdetailsfromSourceCode(int sourceCodeId) {
		Map<String,Object> responseObject=new HashMap<>();
		List<Map<String, Object>> sourceCodeDetails = new ArrayList<>();
		List<Map<String, Object>> allCatalogCodeDetails = new ArrayList<>();
		try {
			sourceCodeDetails = jdbcTemplate.queryForList("SELECT description,active,from_date,to_date,source_format,source_code,offer,qty,cost,list,shipping_price_list FROM source_code WHERE source_code_id = "+sourceCodeId+" ORDER BY source_code_id");
			allCatalogCodeDetails=jdbcTemplate.queryForList("select source_code.description,source_code.active,source_code.from_date,source_code.to_date,source_code.source_format,source_code.offer,source_code.qty,source_code.cost,"+
			         "source_code.list,source_code.shipping_price_list,source_attribute_value.source_attribute,source_attribute_value.source_attribute,source_attribute_value."+
					"description,product.product,product.description,agency.agency_code,agency.company,source_code_state.state,source_code_state.cost_mailing,"+
					"source_code_state.qty_mailed from source_code_state left join source_code on source_Code.source_code_id=source_code_state.source_code_id "+
					"left join source_attribute_value on source_attribute_value.source_attribute=source_code.source_code  left join agency on source_code.agency_customer_id=agency.customer_id "+
					"left join product on product.oc_id=source_code.oc_id where source_code_id="+sourceCodeId) ;
			responseObject.put("sourceCOdeDEtails", sourceCodeDetails);
			responseObject.put("allCatalogCodeDetails", allCatalogCodeDetails);
			
			sourceCodeDetails.add(responseObject);
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return sourceCodeDetails;
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
	public int saveCatalogCode(CatalogContentModel catalogModel) {
		Map<String, Object> addSourceParams = new HashMap<>();
		int status = 0;
		try {
			String SaveCatalogcontent = "insert into catalog_content(source_code_id,catalog_content_seq,order_code_id,item_price,generated_price,discount_class_id,rate_class_id,issue_id,product_id,subscription_def_id,pkg_def_id)values( :source_code_id,:catalog_content_seq,:order_code_id,:item_price,:generated_price,:discount_class_id,:rate_class_id,:issue_id,:product_id,:subscription_def_id,:pkg_def_id)";
			addSourceParams.put("source_code_id",catalogModel.getSourceCodeId() );
			LOGGER.info("sourceCodeId:{}",catalogModel.getSourceCodeId());
			
			addSourceParams.put("catalog_content_seq",catalogModel.getCatalogContentSeq() );
			LOGGER.info("catalogcontentSeq:{}",catalogModel.getCatalogContentSeq());
			
			addSourceParams.put("order_code_id", catalogModel.getOrderCodeId());
			LOGGER.info("orderCodeId:{}",catalogModel.getOrderCodeId());
			
			addSourceParams.put("item_price", catalogModel.getItemPrice());
			LOGGER.info("itemPrice:{}",catalogModel.getItemPrice());
			
			addSourceParams.put("generated_price", catalogModel.getGeneratedPrice());
			LOGGER.info("generatedPrice:{}",catalogModel.getGeneratedPrice());
			
			addSourceParams.put("discount_class_id", catalogModel.getDiscountClassId());
			LOGGER.info("discountClassId:{}", catalogModel.getDiscountClassId());
			
			addSourceParams.put("rate_class_id", catalogModel.getRateClassId());
			LOGGER.info("rateClassId:{}",catalogModel.getRateClassId());
			
			addSourceParams.put("issue_id", catalogModel.getIssueId());
			LOGGER.info("issueId:{}",catalogModel.getIssueId());
			
			addSourceParams.put("product_id", catalogModel.getProductId());
			LOGGER.info("productId:{}",catalogModel.getProductId());
			
			addSourceParams.put("subscription_def_id", catalogModel.getSubscriptionDefId());
			LOGGER.info("subscriptionDefId:{}",catalogModel.getSubscriptionDefId());
			
			addSourceParams.put("pkg_def_id", catalogModel.getPkgDefId());
			LOGGER.info("pkgDefId:{}",catalogModel.getPkgDefId());
				
			status=namedParameterJdbcTemplate.update(SaveCatalogcontent, addSourceParams);
		}catch (Exception e) {
			LOGGER.error(ERROR+e);
		}
			
		
		return status;
	}



	@Override
	public List<DropdownModel> getstate() {
		List<DropdownModel> states = new ArrayList<>();
		try {
			List<Map<String,Object>> states1 = jdbcTemplate.queryForList("select state from state");
			for(Map<String,Object> state:states1){
				DropdownModel model = new DropdownModel();
				model.setKey(state.get("state").toString());
				
				states.add(model);
			}
		}catch (Exception e) {
			LOGGER.error(ERROR+e);
		}
		return states;
	}



	@Override
	public List<Map<String, Object>> getCatalogContentDetails(int sourceCodeId) {
		
		List<Map<String, Object>> sourceCodeDetails = new ArrayList<>();
		
		try {
			LOGGER.info("sourceCOdeID:{}",sourceCodeId);
			sourceCodeDetails = jdbcTemplate.queryForList("select source_code_id,catalog_content_seq,order_code_id,item_price,generated_price,discount_class_id,rate_class_id,issue_id,product_id,subscription_def_id,pkg_def_id  from catalog_content where source_code_id=" + sourceCodeId);
			LOGGER.info("sourceCOdeID:{}",sourceCodeDetails);			
			
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return sourceCodeDetails;
		
		}



	@Override
	public List<DropdownModel> getCurrencytDetails() {
		List<DropdownModel> currencyDetails = new ArrayList<>();
		try {
			List<Map<String,Object>> sourceCodeAttribute = jdbcTemplate.queryForList(" select currency,description from currency");
			for(Map<String,Object> sourceCode:sourceCodeAttribute){
				DropdownModel model = new DropdownModel();
				model.setKey(sourceCode.get("currency").toString());
				model.setDisplay(sourceCode.get("description").toString());
				
				currencyDetails.add(model);
			}
		}catch (Exception e) {
			LOGGER.error(ERROR+e);
		}
		return currencyDetails;
	}
	
	@Override
	public List<Map<String, Object>> getpackageDefinationDetails(int pkgDefId, int ocId) {
		List<Map<String, Object>> packageDetails=new ArrayList<>();
		StringBuilder query=new StringBuilder("select pkg_def_id,order_code_id,");
		query.append("pkg_def,description,n_calendar_units,calendar_unit,active,discount_class_id ,");
		query.append("pkg_price_method,qty_discount_schedule,rate_class_id ,revenue_percentage_option ,");
		query.append("renewal_card_id , pkg_price,oc_id,subscriber_site_allowance_type,pkg_contents_together,");
		query.append("multiline_discount_schedule,auxiliary_1,auxiliary_2,pkg_start_match_order_date,premium_order_code_id from pkg_def");
		query.append(" where pkg_def_id=");
		query.append(pkgDefId);
		query.append(" and oc_id=");
		query.append(ocId);
		try {
			packageDetails=jdbcTemplate.queryForList(query.toString());
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		
		return packageDetails;
	}



	
	
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		


