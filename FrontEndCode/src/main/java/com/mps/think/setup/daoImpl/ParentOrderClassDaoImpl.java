package com.mps.think.setup.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.dao.ParentOrderDao;
import com.mps.think.setup.model.DiscountClassModel;
import com.mps.think.setup.model.OrderClassModel;
import com.mps.think.setup.model.ParentOrderClassModel;
import com.mps.think.setup.model.ProfitCenterModel;
import com.mps.think.setup.model.RateCardModel;
import com.mps.think.setup.model.RateClassModel;
@Repository
public class ParentOrderClassDaoImpl implements ParentOrderDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(ParentOrderClassDaoImpl.class);
	private static final String ERROR = "Error"; 
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Override
	public int addSourceCode(ParentOrderClassModel parentOrderClassModel){
		Map<String, Object> addSourceParams = new HashMap<>();
		int status= 0;
		StringBuilder addSourceCode = new StringBuilder("insert into source_code(source_code_id,agency_customer_id,source_format,source_code,description,state_break,generated,breakeven,"
				+ "offer,list,from_date,to_date,qty,cost,audit_qual_category,generic_agency,oc_id,active,newsub_rate_class_id,new_renewal_card_id,"
				+ "newsub_discount_class_id,audit_subscription_type_id,audit_qual_source_id,audit_name_title_id,audit_sales_channel_id,"
				+ "premium_order_code_id,source_code_type,mru_catalog_content_seq,currency,mru_generic_promotion_code_seq,"
				+ "is_ddp,shipping_price_list) values (:source_code_id,:agency_customer_id,:source_format,:source_code,:description,:state_break,:generated,:breakeven,"
				+ ":offer,:list,:from_date,:to_date,:qty,:cost,:audit_qual_category,:generic_agency,:oc_id,:active,:newsub_rate_class_id,:new_renewal_card_id,"
				+ ":newsub_discount_class_id,:audit_subscription_type_id,:audit_qual_source_id,:audit_name_title_id,:audit_sales_channel_id,"
				+ ":premium_order_code_id,:source_code_type,:mru_catalog_content_seq,:currency,:mru_generic_promotion_code_seq,"
				+ ":is_ddp,:shipping_price_list)");
		try {
			String maxId = jdbcTemplate.queryForObject("select MAX(source_code_id) from source_code ",String.class);
			if(maxId == null) {
				addSourceParams.put("source_code_id", 1);
			}else {
				addSourceParams.put("source_code_id", Integer.parseInt(maxId)+1);	
			}
			addSourceParams.put("agency_customer_id",parentOrderClassModel.getAgencyCustomerId()!=null?parentOrderClassModel.getAgencyCustomerId():null);
			addSourceParams.put("source_format", parentOrderClassModel.getSourceFormat()!=null?parentOrderClassModel.getSourceFormat():null);
			if( ("null".equals(parentOrderClassModel.getSourceFormat()) ) | ("".equals(parentOrderClassModel.getSourceFormat()) )  ) {
				addSourceParams.put("source_format", null);
			}else {
				addSourceParams.put("source_format", parentOrderClassModel.getSourceFormat());
			}
			addSourceParams.put("source_code", parentOrderClassModel.getSourceCode());
			if( ("null".equals(parentOrderClassModel.getDescription()) ) | ("".equals(parentOrderClassModel.getDescription()) )  ) {
				addSourceParams.put("description", null);
			}else {
				addSourceParams.put("description", parentOrderClassModel.getDescription());
			}
			addSourceParams.put("state_break", parentOrderClassModel.getStateBreak()!=null?parentOrderClassModel.getStateBreak():0);
			addSourceParams.put("generated", parentOrderClassModel.getGenerated()!=null?parentOrderClassModel.getGenerated():0);
			addSourceParams.put("breakeven", parentOrderClassModel.getBreakeven()!=null?parentOrderClassModel.getBreakeven():null);
			if( ("null".equals(parentOrderClassModel.getOffer()) ) | ("".equals(parentOrderClassModel.getOffer()) )  ) {
				addSourceParams.put("offer", null);
			}else {
				addSourceParams.put("offer", parentOrderClassModel.getOffer());
			}
			if( ("null".equals(parentOrderClassModel.getList()) ) | ("".equals(parentOrderClassModel.getList()) )  ) {
				addSourceParams.put("list", null);
			}else {
				addSourceParams.put("list", parentOrderClassModel.getList());
			}
			if( ("null".equals(parentOrderClassModel.getFromDate()) ) | ("".equals(parentOrderClassModel.getFromDate()) )  ) {
				addSourceParams.put("from_date", null);
			}else {
				addSourceParams.put("from_date", parentOrderClassModel.getFromDate());
			}
			if( ("null".equals(parentOrderClassModel.getToDate()) ) | ("".equals(parentOrderClassModel.getToDate()) )  ) {
				addSourceParams.put("to_date", null);
			}else {
				addSourceParams.put("to_date", parentOrderClassModel.getToDate());
			}
			addSourceParams.put("qty", parentOrderClassModel.getQty()!=null?parentOrderClassModel.getQty():null);
			addSourceParams.put("cost", parentOrderClassModel.getCost()!=null?parentOrderClassModel.getCost():0);
			addSourceParams.put("audit_qual_category", parentOrderClassModel.getAuditQualCategory());
			addSourceParams.put("generic_agency", parentOrderClassModel.getGenericAgency().equalsIgnoreCase("true")?1:0);
			addSourceParams.put("oc_id", parentOrderClassModel.getOcId());
			addSourceParams.put("active", parentOrderClassModel.getActive().equalsIgnoreCase("true")?1:0);
			addSourceParams.put("newsub_rate_class_id", parentOrderClassModel.getNewsubRateClassId()!=null?parentOrderClassModel.getNewsubRateClassId():null);
			addSourceParams.put("new_renewal_card_id", parentOrderClassModel.getNewRenewalCardId()!=null?parentOrderClassModel.getNewRenewalCardId():null);
			addSourceParams.put("newsub_discount_class_id", parentOrderClassModel.getNewsubDiscountClassId()!=null?parentOrderClassModel.getNewsubDiscountClassId():null);
			addSourceParams.put("audit_subscription_type_id", parentOrderClassModel.getAuditSubscriptionTypeId()!=null?parentOrderClassModel.getAuditSubscriptionTypeId():null);
			addSourceParams.put("audit_qual_source_id", parentOrderClassModel.getAuditQualSourceId()!=null?parentOrderClassModel.getAuditQualSourceId():null);
			addSourceParams.put("audit_name_title_id", parentOrderClassModel.getAuditNameTitleId()!=null?parentOrderClassModel.getAuditNameTitleId():null);
			addSourceParams.put("audit_sales_channel_id", parentOrderClassModel.getAuditSalesChannelId()!=null?parentOrderClassModel.getAuditSalesChannelId():null);
			addSourceParams.put("premium_order_code_id", parentOrderClassModel.getPremiumOrderCodeId()!=null?parentOrderClassModel.getPremiumOrderCodeId():null);
			addSourceParams.put("source_code_type", parentOrderClassModel.getSourceCodeType());
			addSourceParams.put("mru_catalog_content_seq", parentOrderClassModel.getMruCatalogContentSeq()!=null?parentOrderClassModel.getMruCatalogContentSeq():null);
			addSourceParams.put("currency", parentOrderClassModel.getCurrency()!=null?parentOrderClassModel.getCurrency():null);
			addSourceParams.put("mru_generic_promotion_code_seq", parentOrderClassModel.getMruGenericPromotionCodeSeq()!=null?parentOrderClassModel.getMruGenericPromotionCodeSeq():null);
			addSourceParams.put("is_ddp", parentOrderClassModel.getIsDdp().equalsIgnoreCase("true")?1:0);
			addSourceParams.put("shipping_price_list", parentOrderClassModel.getShippingPriceList()!=null?parentOrderClassModel.getShippingPriceList():null);
			status=namedParameterJdbcTemplate.update(addSourceCode.toString(), addSourceParams);
		} catch (Exception e) {
			 LOGGER.error(ERROR + e);
		}
		return status;
	}
	@Override
	public int addOrderClass(OrderClassModel orderClassModel){
		int status= 0;
		try {

			String addOrderClassQuery = "insert into oc (oc_id,oc,oc_type,billing_code_format,payment_threshold,source_format,parent_oc_id,profit_center,description,track_inven,"
					+ "renewal_source_format,promotion_source_format,report,disallow_install_billing,post_conversion_reconcile,low_stock,"
					+ "low_sample_stock,sample_issue_selection,new_group_member_action,group_cannot_override,net_source_code_id,"
					+ "upsell_on,reasonable_gap,pkg_net_source_code_id,process_ons_offs,do_cancel_credit_on_cancel,notification_from_email,"
					+ "subscriber_site_short_desc,subscriber_site_long_desc)values(:oc_id,:oc,:oc_type,:billing_code_format,:payment_threshold,"
					+ ":source_format,:parent_oc_id,:profit_center,:description,:track_inven,:renewal_source_format,:promotion_source_format,:report,"
					+ ":disallow_install_billing,:post_conversion_reconcile,:low_stock,:low_sample_stock,:sample_issue_selection,:new_group_member_action,"
					+ ":group_cannot_override,:net_source_code_id,:upsell_on,:reasonable_gap,:pkg_net_source_code_id,:process_ons_offs,"
					+ ":do_cancel_credit_on_cancel,:notification_from_email,:subscriber_site_short_desc,:subscriber_site_long_desc)";

			Map<String, Object> addOrderClassParams = new HashMap<>();
			//System.out.println("parentOcId:"+orderClassModel.getOcId());
			//Long parentOcId  = orderClassModel.getOcId() !=null? orderClassModel.getOcId():null;

			String ocIdsresult = jdbcTemplate.queryForObject("select MAX(oc_id) from oc ",String.class);
			//System.out.println("ocIdsresult:"+ocIdsresult);
			addOrderClassParams.put("oc_id", Integer.parseInt(ocIdsresult)+1);	
			//String ocType = jdbcTemplate.queryForObject("select oc_type from oc where oc_id="+ocIdsresult, String.class);
			int oc = orderClassModel.getOcType();
			String ocType = Integer.toString(oc);
			switch(ocType){
			case "0":							
				addOrderClassParams.put("oc", "<group>");
				break;
			case "1":
				addOrderClassParams.put("oc", "<pub>");
				break;
			case "2":
				addOrderClassParams.put("oc", "<product>");
				break;
			case "3":
				addOrderClassParams.put("oc", "<package>");
				break;
			case "4":
				addOrderClassParams.put("oc", "<package>");
				break;
			case "5":
				addOrderClassParams.put("oc", "<package>");
				break;
			case "6":
				addOrderClassParams.put("oc", "<group>");
				break;
			case "7":
				addOrderClassParams.put("oc", "<group>");
				break;
			case "8":
				addOrderClassParams.put("oc", "<group>");
				break;		
			}
			//System.out.println("ocType:"+ocType);
			addOrderClassParams.put("oc_type", orderClassModel.getOcType());	
			addOrderClassParams.put("billing_code_format",("null".equals(orderClassModel.getBillingCodeFormat())) | ("".equals(orderClassModel.getBillingCodeFormat()))?null:orderClassModel.getBillingCodeFormat());	
			addOrderClassParams.put("payment_threshold",("null".equals(orderClassModel.getPaymentThreshold())) | ("".equals(orderClassModel.getPaymentThreshold()))?null:orderClassModel.getPaymentThreshold());	
			addOrderClassParams.put("source_format", ("null".equals(orderClassModel.getSourceFormat())) | ("".equals(orderClassModel.getSourceFormat()))?null:orderClassModel.getSourceFormat());
			
			List<Map<String, Object>> parentOc = new ArrayList<>();
			parentOc = jdbcTemplate.queryForList("select oc_id,oc,description,parent_oc_id,oc_type from oc where oc_id ="+orderClassModel.getOcId());
			if (Integer.valueOf(parentOc.get(0).get("oc_type").toString()).equals(0)) {
				addOrderClassParams.put("parent_oc_id",orderClassModel.getOcId()!= null?orderClassModel.getOcId():null );
			}
			else {
				addOrderClassParams.put("parent_oc_id",parentOc.get(0).get("parent_oc_id"));
			}
			
			addOrderClassParams.put("profit_center", ("null".equals(orderClassModel.getProfitCenter())) | ("".equals(orderClassModel.getProfitCenter()))?null:orderClassModel.getProfitCenter());	
			addOrderClassParams.put("description", ("null".equals(orderClassModel.getDescription())) | ("".equals(orderClassModel.getDescription()))?null:orderClassModel.getDescription());	
			addOrderClassParams.put("track_inven", orderClassModel.getTrackInven()!=null?orderClassModel.getTrackInven():0);	
			addOrderClassParams.put("renewal_source_format", ("null".equals(orderClassModel.getRenewalSourceFormat())) | ("".equals(orderClassModel.getRenewalSourceFormat()))?null:orderClassModel.getRenewalSourceFormat());	
			addOrderClassParams.put("promotion_source_format",("null".equals(orderClassModel.getPromotionSourceFormat())) | ("".equals(orderClassModel.getPromotionSourceFormat()))?null:orderClassModel.getPromotionSourceFormat());	
			addOrderClassParams.put("report", ("null".equals(orderClassModel.getReport())) | ("".equals(orderClassModel.getReport()))?null:orderClassModel.getReport());
			addOrderClassParams.put("disallow_install_billing", orderClassModel.getDisallowInstallBilling()!=null?orderClassModel.getDisallowInstallBilling():0);
			addOrderClassParams.put("post_conversion_reconcile", orderClassModel.getPostConversionReconcile()!=null?orderClassModel.getPostConversionReconcile():0);
			addOrderClassParams.put("low_stock", orderClassModel.getLowStock()!=null?orderClassModel.getLowStock():0);
			addOrderClassParams.put("low_sample_stock", orderClassModel.getLowSampleStock()!=null?orderClassModel.getLowSampleStock():0);
			addOrderClassParams.put("sample_issue_selection", orderClassModel.getSampleIssueSelection()!=null?orderClassModel.getSampleIssueSelection():0);
			addOrderClassParams.put("new_group_member_action", orderClassModel.getNewGroupMemberAction()!=null?orderClassModel.getNewGroupMemberAction():0);
			addOrderClassParams.put("group_cannot_override", orderClassModel.getGroupCannotOverride()!=null?orderClassModel.getGroupCannotOverride():null);
			addOrderClassParams.put("net_source_code_id", orderClassModel.getNetSourceCodeId()!=null?orderClassModel.getNetSourceCodeId():null);
			addOrderClassParams.put("upsell_on", orderClassModel.getUpsellOn()!=null?orderClassModel.getUpsellOn():0);
			addOrderClassParams.put("reasonable_gap", orderClassModel.getReasonableGap()!=null?orderClassModel.getReasonableGap():null);
			addOrderClassParams.put("pkg_net_source_code_id", orderClassModel.getPkgNetSourceCodeId()!=null?orderClassModel.getPkgNetSourceCodeId():null);
			addOrderClassParams.put("process_ons_offs", orderClassModel.getProcessOnsOffs());
			addOrderClassParams.put("do_cancel_credit_on_cancel", orderClassModel.getDoCancelCreditOnCancel()!=null?orderClassModel.getDoCancelCreditOnCancel():0);
			addOrderClassParams.put("notification_from_email",("null".equals(orderClassModel.getNotificationFromEmail())) | ("".equals(orderClassModel.getNotificationFromEmail()))?null:orderClassModel.getNotificationFromEmail());
			addOrderClassParams.put("subscriber_site_short_desc",("null".equals(orderClassModel.getSubscriberSiteLongDesc())) | ("".equals(orderClassModel.getSubscriberSiteLongDesc()))?null:orderClassModel.getSubscriberSiteShortDesc());
			addOrderClassParams.put("subscriber_site_long_desc",("null".equals(orderClassModel.getSubscriberSiteLongDesc())) | ("".equals(orderClassModel.getSubscriberSiteLongDesc()))?null:orderClassModel.getSubscriberSiteLongDesc());
			
			 status=namedParameterJdbcTemplate.update(addOrderClassQuery, addOrderClassParams);

		} catch (Exception e) {
			 LOGGER.error(ERROR + e);
		}
		
		return status;
	}
	
	@Override
	public int addProfitCenter(ProfitCenterModel profitCenterModel){
		int status= 0;
		try {

			String addProfitCanterQuery = "insert into profit_center(profit_center,description,incl_tax_liab,incl_del_liab,incl_com_liab,incl_tax_ar,incl_del_ar,incl_com_ar,"
					+ "mru_profit_center_calendar_seq)values(:profit_center,:description,:incl_tax_liab,:incl_del_liab,:incl_com_liab,:incl_tax_ar,:incl_del_ar,:incl_com_ar,:mru_profit_center_calendar_seq)";
			Map<String, Object> addProfitCenterParams = new HashMap<String,Object>();
			addProfitCenterParams.put("profit_center", profitCenterModel.getProfitCenter());	
			addProfitCenterParams.put("description", profitCenterModel.getDescription());	
			addProfitCenterParams.put("incl_tax_liab", profitCenterModel.getInclTaxLiab());	
			addProfitCenterParams.put("incl_del_liab", profitCenterModel.getInclDelLiab());
			addProfitCenterParams.put("incl_com_liab", profitCenterModel.getInclDelLiab());
			addProfitCenterParams.put("incl_tax_ar", profitCenterModel.getInclDelLiab());
			addProfitCenterParams.put("incl_del_ar", profitCenterModel.getInclDelLiab());
			addProfitCenterParams.put("incl_com_ar", profitCenterModel.getInclDelLiab());
			addProfitCenterParams.put("mru_profit_center_calendar_seq", profitCenterModel.getInclDelLiab());
			 status=namedParameterJdbcTemplate.update(addProfitCanterQuery, addProfitCenterParams);

		} catch (Exception e) {
			 LOGGER.error(ERROR + e);
			
		}
		return status;
	}
	
	@Override
	public int addRateClass(RateClassModel rateClassModel){
		int status= 0;
		try {

			String addRateClassQuery = "insert into rate_class (rate_class_id,rate_class,oc_id,description,region_list,renewal_card_id,"
					+ "mru_rate_class_effective_seq,is_package) values(:rate_class_id,:rate_class,:oc_id,:description,:region_list,"
					+ ":renewal_card_id,:mru_rate_class_effective_seq,:is_package)";
			Map<String, Object> addRateClassParams = new HashMap<>();
           String rateClassIdResult = jdbcTemplate.queryForObject("select MAX(rate_class_id) from rate_class ",String.class);
           addRateClassParams.put("rate_class_id",rateClassIdResult==null?1:Integer.parseInt(rateClassIdResult)+1);
           addRateClassParams.put("rate_class", rateClassModel.getRateClass().isEmpty()?null:rateClassModel.getRateClass());	
           addRateClassParams.put("oc_id", rateClassModel.getOcId());	
           addRateClassParams.put("description", rateClassModel.getDescription().isEmpty()?null:rateClassModel.getDescription());	
           addRateClassParams.put("region_list", rateClassModel.getRegionList().isEmpty()?null:rateClassModel.getRegionList());	
           addRateClassParams.put("renewal_card_id", rateClassModel.getRenewalCardId()==0?null:rateClassModel.getRenewalCardId());	
           //addRateClassParams.put("mru_rate_class_effective_seq", rateClassModel.getMruRateClassEffectiveSeq()==0?null:rateClassModel.getMruRateClassEffectiveSeq());	
           addRateClassParams.put("mru_rate_class_effective_seq", rateClassModel.getMruRateClassEffectiveSeq()==0?null:null);	
           addRateClassParams.put("is_package", rateClassModel.getIsPackage());	
           
		   status=namedParameterJdbcTemplate.update(addRateClassQuery, addRateClassParams);

		} catch (Exception e) {
			 LOGGER.error(ERROR + e);
			
		}
		return status;
	}
	
	 @Override
	public int updateRateClassRecords(RateClassModel model) {
		
		String updateRateClassQuery = "update rate_class set rate_class=:rate_class,description=:description,"
				+ "region_list=:region_list,renewal_card_id=:renewal_card_id,"
					+ "is_package=:is_package where rate_class_id=" +model.getRateClassId()
					+"and oc_id="+model.getOcId() ;
		
		int status = 0;
		try{
			Map<String, Object> updateRateClassParams = new HashMap<>();
			   updateRateClassParams.put("rate_class_id",model.getRateClassId());
	           updateRateClassParams.put("rate_class", model.getRateClass().isEmpty()?null:model.getRateClass());	
	           updateRateClassParams.put("oc_id", model.getOcId());	
	           updateRateClassParams.put("description", model.getDescription().isEmpty()?null:model.getDescription());	
	           updateRateClassParams.put("region_list", model.getRegionList().isEmpty()?null:model.getRegionList());	
	           updateRateClassParams.put("renewal_card_id", model.getRenewalCardId()==0?null:model.getRenewalCardId());	
	           //updateRateClassParams.put("mru_rate_class_effective_seq", model.getMruRateClassEffectiveSeq()==0?null:model.getMruRateClassEffectiveSeq());	
	           updateRateClassParams.put("is_package", model.getIsPackage());
			
			 status=namedParameterJdbcTemplate.update(updateRateClassQuery, updateRateClassParams);
		}catch(Exception e){
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	@Override
	public int addRateCard(RateCardModel rateCardModel){
		int status= 0;
		try {

			String addRateCardQuery = "insert into rate_card(rate_class_id,rate_class_effective_seq,ratecard_seq,from_qty,region_list,region,currency,to_qty,price,charge_new,remit_new,"
					+ "percent_new,basic,charge_ren,remit_ren,percent_ren,lookup_currency,qty_discount_schedule,baseline_qty,unit_type) values(rate_class_id,rate_class_effective_seq,"
					+ "ratecard_seq,from_qty,region_list,region,currency,to_qty,price,charge_new,remit_new,percent_new,basic,charge_ren,remit_ren,percent_ren,lookup_currency,"
					+ "qty_discount_schedule,baseline_qty,unit_type)";
			Map<String, Object> addRateCardParams = new HashMap<>();
           String rateClassIdResult = jdbcTemplate.queryForObject("select MAX(rate_class_id) from rate_class ",String.class);
           addRateCardParams.put("rate_class_id", Integer.parseInt(rateClassIdResult)+1);
           addRateCardParams.put("rate_class_effective_seq", rateCardModel.getRateClassEffectiveSeq());	
           addRateCardParams.put("ratecard_seq", rateCardModel.getRatecardSeq());
           addRateCardParams.put("from_qty", rateCardModel.getFromQty());
           addRateCardParams.put("region_list", rateCardModel.getRegion());
           addRateCardParams.put("region", rateCardModel.getRegion());
           addRateCardParams.put("currency", rateCardModel.getCurrency());
           addRateCardParams.put("to_qty", rateCardModel.getToQty());
           addRateCardParams.put("price", rateCardModel.getPrice());
           addRateCardParams.put("charge_new", rateCardModel.getChargeNew());
           addRateCardParams.put("remit_new", rateCardModel.getRemitNew());
           addRateCardParams.put("basic", rateCardModel.getBasic());
           addRateCardParams.put("percent_new", rateCardModel.getPercentNew());
           addRateCardParams.put("charge_ren", rateCardModel.getChargeRen());
           addRateCardParams.put("remit_ren", rateCardModel.getRemitRen());
           addRateCardParams.put("percent_ren", rateCardModel.getPercentRen());
           addRateCardParams.put("lookup_currency", rateCardModel.getLookupCurrency());
           addRateCardParams.put("qty_discount_schedule", rateCardModel.getQtyDiscountSchedule());
           addRateCardParams.put("baseline_qty", rateCardModel.getBaselineQty());
           addRateCardParams.put("unit_type", rateCardModel.getUnitType());
           
			 status=namedParameterJdbcTemplate.update(addRateCardQuery, addRateCardParams);

		} catch (Exception e) {
			 LOGGER.error(ERROR + e);
			
		}
		return status;
	}

	@Override
	public int discountClassSave(DiscountClassModel discountClassModel){
		int status= 0;
		try {

			String addDiscountClassQuery = "insert into discount_class (discount_class_id,discount_class,description,region_list,oc_id,mru_disc_class_effective_seq,"
					+ " use_on_renewal,is_package) values(:discount_class_id,:discount_class,:description,:region_list,:oc_id,:mru_disc_class_effective_seq,"
					+ " :use_on_renewal,:is_package)";
			
		   Map<String, Object> discountClassParams = new HashMap<>();
           String discountClassIdResult = jdbcTemplate.queryForObject("select MAX(discount_class_id) from discount_class",String.class);
           discountClassParams.put("discount_class_id",discountClassIdResult==null?1:Integer.parseInt(discountClassIdResult)+1);
           discountClassParams.put("discount_class", discountClassModel.getDiscountClass());
           discountClassParams.put("oc_id", discountClassModel.getOcId());
           discountClassParams.put("description",discountClassModel.getDescription().isEmpty()?null:discountClassModel.getDescription()); 
           discountClassParams.put("region_list",discountClassModel.getRegionList().isEmpty()?null:discountClassModel.getRegionList()); 
           //discountClassParams.put("mru_disc_class_effective_seq",discountClassModel.getMruDiscClassEffectiveSeq()!=0?discountClassModel.getMruDiscClassEffectiveSeq():null); 
           discountClassParams.put("mru_disc_class_effective_seq",discountClassModel.getMruDiscClassEffectiveSeq()!=0?null:null);
           discountClassParams.put("use_on_renewal",discountClassModel.getUseOnRenewal()==0?0:discountClassModel.getUseOnRenewal()); 
           discountClassParams.put("is_package",discountClassModel.getIsPackage()==0?0:discountClassModel.getIsPackage()); 
		   status=namedParameterJdbcTemplate.update(addDiscountClassQuery, discountClassParams);

		} catch (Exception e) {
			 LOGGER.error(ERROR + e);
		}
		return status;
	}
	
	@Override
	public int addOrderClassSave(OrderClassModel orderClassModel){
		int status= 0;
		try {

			String updateOrderClassQuery = "update oc set oc=:oc,oc_type=:oc_type,billing_code_format=:billing_code_format,payment_threshold=:payment_threshold,source_format=:source_format,"
					+ "parent_oc_id=:parent_oc_id,profit_center=:profit_center,description=:description,track_inven=:track_inven,renewal_source_format=:renewal_source_format,"
					+ " promotion_source_format=:promotion_source_format,report=:report,disallow_install_billing=:disallow_install_billing,post_conversion_reconcile=:post_conversion_reconcile,"
					+ "low_stock=:low_stock,low_sample_stock=:low_sample_stock,sample_issue_selection=:sample_issue_selection,new_group_member_action=:new_group_member_action,"
					+ "group_cannot_override=:group_cannot_override,net_source_code_id=:net_source_code_id,upsell_on=:upsell_on,reasonable_gap=:reasonable_gap,"
					+ "pkg_net_source_code_id=:pkg_net_source_code_id,process_ons_offs=:process_ons_offs,do_cancel_credit_on_cancel=:do_cancel_credit_on_cancel,"
					+ "notification_from_email=:notification_from_email,subscriber_site_short_desc=:subscriber_site_short_desc,subscriber_site_long_desc=:subscriber_site_long_desc where oc_id ="+orderClassModel.getOcId();

			Map<String, Object> addOrderClassParams = new HashMap<>();
			addOrderClassParams.put("oc", orderClassModel.getOc());
			addOrderClassParams.put("oc_type", orderClassModel.getOcType());	
			addOrderClassParams.put("billing_code_format",("null".equals(orderClassModel.getBillingCodeFormat())) | ("".equals(orderClassModel.getBillingCodeFormat()))?null:orderClassModel.getBillingCodeFormat());	
			addOrderClassParams.put("payment_threshold",("null".equals(orderClassModel.getPaymentThreshold())) | ("".equals(orderClassModel.getPaymentThreshold()))?null:orderClassModel.getPaymentThreshold());	
			addOrderClassParams.put("source_format", ("null".equals(orderClassModel.getSourceFormat())) | ("".equals(orderClassModel.getSourceFormat()))?null:orderClassModel.getSourceFormat());	
			addOrderClassParams.put("parent_oc_id",orderClassModel.getParentOcId()!= null?orderClassModel.getParentOcId():null );	
			addOrderClassParams.put("profit_center", ("null".equals(orderClassModel.getProfitCenter())) | ("".equals(orderClassModel.getProfitCenter()))?null:orderClassModel.getProfitCenter());	
			addOrderClassParams.put("description", ("null".equals(orderClassModel.getDescription())) | ("".equals(orderClassModel.getDescription()))?null:orderClassModel.getDescription());	
			addOrderClassParams.put("track_inven", orderClassModel.getTrackInven()!=null?orderClassModel.getTrackInven():0);	
			addOrderClassParams.put("renewal_source_format", ("null".equals(orderClassModel.getRenewalSourceFormat())) | ("".equals(orderClassModel.getRenewalSourceFormat()))?null:orderClassModel.getRenewalSourceFormat());	
			addOrderClassParams.put("promotion_source_format",("null".equals(orderClassModel.getPromotionSourceFormat())) | ("".equals(orderClassModel.getPromotionSourceFormat()))?null:orderClassModel.getPromotionSourceFormat());	
			addOrderClassParams.put("report", ("null".equals(orderClassModel.getReport())) | ("".equals(orderClassModel.getReport()))?null:orderClassModel.getReport());
			addOrderClassParams.put("disallow_install_billing", orderClassModel.getDisallowInstallBilling()!=null?orderClassModel.getDisallowInstallBilling():0);
			addOrderClassParams.put("post_conversion_reconcile", orderClassModel.getPostConversionReconcile()!=null?orderClassModel.getPostConversionReconcile():0);
			addOrderClassParams.put("low_stock", orderClassModel.getLowStock()!=null?orderClassModel.getLowStock():0);
			addOrderClassParams.put("low_sample_stock", orderClassModel.getLowSampleStock()!=null?orderClassModel.getLowSampleStock():0);
			addOrderClassParams.put("sample_issue_selection", orderClassModel.getSampleIssueSelection()!=null?orderClassModel.getSampleIssueSelection():0);
			addOrderClassParams.put("new_group_member_action", orderClassModel.getNewGroupMemberAction()!=null?orderClassModel.getNewGroupMemberAction():0);
			addOrderClassParams.put("group_cannot_override", orderClassModel.getGroupCannotOverride()!=null?orderClassModel.getGroupCannotOverride():null);
			addOrderClassParams.put("net_source_code_id", orderClassModel.getNetSourceCodeId()!=null?orderClassModel.getNetSourceCodeId():null);
			addOrderClassParams.put("upsell_on", orderClassModel.getUpsellOn()!=null?orderClassModel.getUpsellOn():0);
			addOrderClassParams.put("reasonable_gap", orderClassModel.getReasonableGap()!=null?orderClassModel.getReasonableGap():null);
			addOrderClassParams.put("pkg_net_source_code_id", orderClassModel.getPkgNetSourceCodeId()!=null?orderClassModel.getPkgNetSourceCodeId():null);
			addOrderClassParams.put("process_ons_offs", orderClassModel.getProcessOnsOffs());
			addOrderClassParams.put("do_cancel_credit_on_cancel", orderClassModel.getDoCancelCreditOnCancel()!=null?orderClassModel.getDoCancelCreditOnCancel():0);
			addOrderClassParams.put("notification_from_email",("null".equals(orderClassModel.getNotificationFromEmail())) | ("".equals(orderClassModel.getNotificationFromEmail()))?null:orderClassModel.getNotificationFromEmail());
			addOrderClassParams.put("subscriber_site_short_desc",("null".equals(orderClassModel.getSubscriberSiteLongDesc())) | ("".equals(orderClassModel.getSubscriberSiteLongDesc()))?null:orderClassModel.getSubscriberSiteShortDesc());
			addOrderClassParams.put("subscriber_site_long_desc",("null".equals(orderClassModel.getSubscriberSiteLongDesc())) | ("".equals(orderClassModel.getSubscriberSiteLongDesc()))?null:orderClassModel.getSubscriberSiteLongDesc());
			
			status=namedParameterJdbcTemplate.update(updateOrderClassQuery, addOrderClassParams);

		} catch (Exception e) {
			 LOGGER.error(ERROR + e);
		}
		
		return status;
	}

	@Override
	public int getDiscountId() {
		int discountId = 0;
		try {
			String maxId = jdbcTemplate.queryForObject("select max(discount_class_id) from discount_class", String.class);
			if(maxId == null) {
				discountId = 0;
			}else {
				discountId = Integer.valueOf(maxId);
			}
		}catch (Exception e) {
		}
			
		return discountId;
	}

	@Override
	public int getRateClassId() {
		int rateClassId = 0;
		try {
			String maxId = jdbcTemplate.queryForObject("select max(rate_class_id) from rate_class", String.class);
			if(maxId == null) {
				rateClassId = 0;
			}else {
				rateClassId = Integer.valueOf(maxId);
			}
		}catch (Exception e) {
		}
			
		return rateClassId;
	}
  @Override
  public Integer getDisc_class_effective_Seq() {
		int disc_class_effective_Seq = 0;
		try {
			String disc_class_effective_seq = jdbcTemplate.queryForObject("select max(disc_class_effective_seq) from disc_class_effective where discount_class_id =(select MAX(discount_class_id) from disc_class_effective )", String.class);
			if(disc_class_effective_seq == null) {
				disc_class_effective_Seq = 0;
			}else {
				disc_class_effective_Seq = Integer.valueOf(disc_class_effective_seq);
			}
		}catch (Exception e) {
		}
			
		return disc_class_effective_Seq;
	}
@Override
public int getOcId() {
	int ocId = 0;
	try {
		String maxId = jdbcTemplate.queryForObject("select max(oc_id) from oc", String.class);
		if(maxId == null) {
			ocId = 0;
		}else {
			ocId = Integer.valueOf(maxId);
		}
	}catch (Exception e) {
	}
		
	return ocId;
}
@Override
public int updateSourceCode(ParentOrderClassModel parentOrderClassModel){
	Map<String, Object> updateSourceParams = new HashMap<>();
	int status= 0;
	StringBuilder updateSourceCode = new StringBuilder("update source_code set agency_customer_id=:agency_customer_id,source_format=:source_format,source_code=:source_code,description=:description,state_break=:state_break,generated=:generated,breakeven=:breakeven,"
			+ "offer=:offer,list=:list,from_date=GETDATE(),to_date=GETDATE(),qty=:qty,cost=:cost,audit_qual_category=:audit_qual_category,generic_agency=:generic_agency,active=:active,newsub_rate_class_id=:newsub_rate_class_id,new_renewal_card_id=:new_renewal_card_id,"
			+ "newsub_discount_class_id=:newsub_discount_class_id,audit_subscription_type_id=:audit_subscription_type_id,audit_qual_source_id=:audit_qual_source_id,audit_name_title_id=:audit_name_title_id,audit_sales_channel_id=:audit_sales_channel_id,"
			+ "premium_order_code_id=:premium_order_code_id,source_code_type=:source_code_type,mru_catalog_content_seq=:mru_catalog_content_seq,currency=:currency,mru_generic_promotion_code_seq=:mru_generic_promotion_code_seq,"
			+ "is_ddp=:is_ddp,shipping_price_list=:shipping_price_list where oc_id=:oc_id and source_code_id=:source_code_id");
	try {
		updateSourceParams.put("source_code_id", parentOrderClassModel.getSourceCodeId());	
		updateSourceParams.put("agency_customer_id",parentOrderClassModel.getAgencyCustomerId()!=null?parentOrderClassModel.getAgencyCustomerId():null);
		if("null".equals(parentOrderClassModel.getSourceFormat())|("".equals(parentOrderClassModel.getSourceFormat()))){
			updateSourceParams.put("source_format", null);
		}else {
			updateSourceParams.put("source_format", parentOrderClassModel.getSourceFormat());
		}
		updateSourceParams.put("source_code", parentOrderClassModel.getSourceCode());
		
		if("null".equals(parentOrderClassModel.getDescription())|("".equals(parentOrderClassModel.getDescription()))) {
			updateSourceParams.put("description", null);
		}else {
			updateSourceParams.put("description", parentOrderClassModel.getDescription());
		}
		updateSourceParams.put("state_break", parentOrderClassModel.getStateBreak());
		updateSourceParams.put("generated", parentOrderClassModel.getGenerated());
		updateSourceParams.put("breakeven", parentOrderClassModel.getBreakeven()!=null?parentOrderClassModel.getBreakeven():null);
		if("null".equals(parentOrderClassModel.getOffer())|("".equals(parentOrderClassModel.getOffer()))) {
			updateSourceParams.put("offer", null);
		}else {
			updateSourceParams.put("offer", parentOrderClassModel.getOffer());
		}
		if("null".equals(parentOrderClassModel.getList())|("".equals(parentOrderClassModel.getList()))) {
			updateSourceParams.put("list", null);
		}else{
			updateSourceParams.put("list", parentOrderClassModel.getList());	
		}
		/*addSourceParams.put("from_date", parentOrderClassModel.getFromDate());
		addSourceParams.put("to_date", parentOrderClassModel.getToDate());*/
		updateSourceParams.put("qty", parentOrderClassModel.getQty()!=null?parentOrderClassModel.getQty():null);
		updateSourceParams.put("cost", parentOrderClassModel.getCost());
		updateSourceParams.put("audit_qual_category", parentOrderClassModel.getAuditQualCategory()!=null?parentOrderClassModel.getAuditQualCategory():null);
		updateSourceParams.put("generic_agency", parentOrderClassModel.getGenericAgency().equalsIgnoreCase("true")?1:0);
		updateSourceParams.put("oc_id", parentOrderClassModel.getOcId());
		updateSourceParams.put("active", parentOrderClassModel.getActive().equalsIgnoreCase("true")?1:0);
		updateSourceParams.put("newsub_rate_class_id", parentOrderClassModel.getNewsubRateClassId()!=null?parentOrderClassModel.getNewsubRateClassId():null);
		updateSourceParams.put("new_renewal_card_id", parentOrderClassModel.getNewRenewalCardId()!=null?parentOrderClassModel.getNewRenewalCardId():null);
		updateSourceParams.put("newsub_discount_class_id", parentOrderClassModel.getNewsubDiscountClassId()!=null?parentOrderClassModel.getNewsubDiscountClassId():null);
		updateSourceParams.put("audit_subscription_type_id", parentOrderClassModel.getAuditSubscriptionTypeId()!=null?parentOrderClassModel.getAuditSubscriptionTypeId():null);
		updateSourceParams.put("audit_qual_source_id", parentOrderClassModel.getAuditQualSourceId()!=null?parentOrderClassModel.getAuditQualSourceId():null);
		updateSourceParams.put("audit_name_title_id", parentOrderClassModel.getAuditNameTitleId()!=null?parentOrderClassModel.getAuditNameTitleId():null);
		updateSourceParams.put("audit_sales_channel_id", parentOrderClassModel.getAuditSalesChannelId()!=null?parentOrderClassModel.getAuditSalesChannelId():null);
		updateSourceParams.put("premium_order_code_id", parentOrderClassModel.getPremiumOrderCodeId()!=null?parentOrderClassModel.getPremiumOrderCodeId():null);
		updateSourceParams.put("source_code_type", parentOrderClassModel.getSourceCodeType());
		updateSourceParams.put("mru_catalog_content_seq", parentOrderClassModel.getMruCatalogContentSeq()!=null?parentOrderClassModel.getMruCatalogContentSeq():null);
		//addSourceParams.put("currency", parentOrderClassModel.getCurrency());
		if("null".equals(parentOrderClassModel.getCurrency())|("".equals(parentOrderClassModel.getCurrency()))) {
			updateSourceParams.put("currency", null);
		}else {
			updateSourceParams.put("currency", parentOrderClassModel.getCurrency());
		}
		updateSourceParams.put("mru_generic_promotion_code_seq", parentOrderClassModel.getMruGenericPromotionCodeSeq()!=null?parentOrderClassModel.getMruGenericPromotionCodeSeq():null);
		updateSourceParams.put("is_ddp", parentOrderClassModel.getIsDdp().equalsIgnoreCase("true")?1:0);
		updateSourceParams.put("shipping_price_list", parentOrderClassModel.getShippingPriceList()!=null?parentOrderClassModel.getShippingPriceList():null);
		 status=namedParameterJdbcTemplate.update(updateSourceCode.toString(), updateSourceParams);
	} catch (Exception e) {
		 LOGGER.error(ERROR + e);
	}
	return status;
}

	@Override
	public String deleteSourceCodeDetails(Integer sourceCodeId) {
		StringBuilder returnStatus = new StringBuilder();
		int status = 0;
		StringBuilder deleteSourceCodeQuery = new StringBuilder("delete source_code from source_code");	
	    	deleteSourceCodeQuery.append(" left join promotion_card_from_effort on source_code.source_code_id=promotion_card_from_effort.source_code_id");
	    	deleteSourceCodeQuery.append(" left join source_code_state on source_code.source_code_id = source_code_state.source_code_id");
	    	deleteSourceCodeQuery.append(" left join ren_card_order_code on source_code.source_code_id = ren_card_order_code.source_code_id");
	    	deleteSourceCodeQuery.append(" left join source_code_attribute on source_code.source_code_id = source_code_attribute.source_code_id");
	    	deleteSourceCodeQuery.append(" left join order_item on source_code.source_code_id = order_item.source_code_id");
	    	deleteSourceCodeQuery.append(" left join subscrip on source_code.source_code_id = subscrip.source_code_id ");
	    	deleteSourceCodeQuery.append(" left join customer_prospect on source_code.source_code_id = customer_prospect.source_code_id");
	    	deleteSourceCodeQuery.append(" left join renewal_history on source_code.source_code_id = renewal_history.source_code_id");
	    	deleteSourceCodeQuery.append(" left join promotion_history on source_code.source_code_id = promotion_history.source_code_id");
	    	deleteSourceCodeQuery.append(" left join work_promotion on source_code.source_code_id = work_promotion.source_code_id");
	    	deleteSourceCodeQuery.append(" left join upsell on source_code.source_code_id = upsell.source_code_id");
	    	deleteSourceCodeQuery.append(" left join deal_order_code on source_code.source_code_id = deal_order_code.source_code_id");
	    	deleteSourceCodeQuery.append(" left join catalog_content on source_code.source_code_id = catalog_content.source_code_id");
	    	deleteSourceCodeQuery.append(" left join generic_promotion_code on source_code.source_code_id = generic_promotion_code.source_code_id");
	    	deleteSourceCodeQuery.append(" left join generic_promotion on source_code.source_code_id = generic_promotion.source_code_id");
	    	deleteSourceCodeQuery.append(" where source_code.source_code_id = ");
	    	deleteSourceCodeQuery.append(sourceCodeId);
	    	try{
	    		status = jdbcTemplate.update(deleteSourceCodeQuery.toString());
	    		returnStatus.append(status);	
	    	} catch(Exception e){
	    		LOGGER.error(ERROR + e);
	    		returnStatus.append(e);
	    	}
	    	return returnStatus.toString();
	}
	@Override
	public int getSourceCodeId() {
		int sourceCodeId = 0;
		try {
			String max = jdbcTemplate.queryForObject("select max(source_code_id) from source_code", String.class);
		if(max == null){
			sourceCodeId = 0;
		}else {
			sourceCodeId =Integer.valueOf(max);
		}
		}catch(Exception e) {
		}
		return sourceCodeId;
	}
}
