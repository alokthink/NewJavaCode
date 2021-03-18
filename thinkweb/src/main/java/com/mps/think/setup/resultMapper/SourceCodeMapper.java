package com.mps.think.setup.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.setup.model.ParentOrderClassModel;
import com.mps.think.setup.util.PropertyUtils;

public class SourceCodeMapper implements RowMapper<ParentOrderClassModel> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParentOrderClassModel.class);
	
	@Override
	public ParentOrderClassModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ParentOrderClassModel parentModel = new ParentOrderClassModel();
		try {
			parentModel.setSourceCodeId(rs.getInt("source_code_id"));
			parentModel.setAgencyCustomerId(rs.getString("agency_customer_id")!=null?rs.getString("agency_customer_id").toString():"");
			parentModel.setAgencyCode(rs.getString("agency_code")!=null?rs.getString("agency_code").toString():"");
			parentModel.setAgencyDesc(rs.getString("company")!=null?rs.getString("company").toString():"");
			parentModel.setSourceFormat(rs.getString("source_format")!=null?rs.getString("source_format").toString():"");
			parentModel.setSourceDesc(rs.getString("sourceDesc")!=null?rs.getString("sourceDesc").toString():"");
			parentModel.setSourceCode(rs.getString("source_code")!=null?rs.getString("source_code").toString():"");
			parentModel.setDescription(rs.getString("description")!=null?rs.getString("description").toString():"");
			parentModel.setStateBreak(new PropertyUtils().getConstantValue("state_break_"+rs.getInt("state_break")));
			parentModel.setGenerated(new PropertyUtils().getConstantValue("generated_"+rs.getString("generated")));
			parentModel.setBreakeven(rs.getString("breakeven")!=null?rs.getString("breakeven").toString():"");
			parentModel.setOffer(rs.getString("offer")!=null?rs.getString("offer").toString():"");
			parentModel.setList(rs.getString("list")!=null?rs.getString("list").toString():"");
			parentModel.setFromDate(rs.getString("from_date")!=null?rs.getString("from_date").toString():"");
			parentModel.setToDate(rs.getString("to_date")!=null?rs.getString("to_date").toString():"");
			parentModel.setQty(rs.getString("qty")!=null?rs.getString("qty").toString():"");
			parentModel.setCost(rs.getFloat("cost"));
			parentModel.setAuditQualCategory(rs.getString("audit_qual_category")!=null?rs.getString("audit_qual_category").toString():"");
			parentModel.setAuditSubscriptionTypeId(rs.getString("audit_subscription_type_id")!=null?rs.getString("audit_subscription_type_id").toString():"");
			parentModel.setAuditQualSourceId(rs.getString("audit_qual_source_id")!=null?rs.getString("audit_qual_source_id").toString():"");
			parentModel.setAuditNameTitleId(rs.getString("audit_name_title_id")!=null?rs.getString("audit_name_title_id").toString():"");
			parentModel.setAuditSalesChannelId(rs.getString("audit_sales_channel_id")!=null?rs.getString("audit_sales_channel_id").toString():"");
			parentModel.setGenericAgency(rs.getString("generic_agency")!=null?rs.getString("generic_agency").toString():"");
			parentModel.setOcId(rs.getInt("oc_id"));
			parentModel.setActive(rs.getString("active").toString());
			parentModel.setRateClassId(rs.getString("newsub_rate_class_id")!=null?rs.getString("newsub_rate_class_id").toString():"");
			parentModel.setRateClass(rs.getString("rate_class")!=null?rs.getString("rate_class").toString():"");
			parentModel.setRateDesc(rs.getString("rateDesc")!=null?rs.getString("rateDesc").toString():"");
			parentModel.setRenewalCardId(rs.getString("new_renewal_card_id")!=null?rs.getString("new_renewal_card_id").toString():"");
			parentModel.setRenewalCard(rs.getString("renewal_card")!=null?rs.getString("renewal_card").toString():"");
			parentModel.setRenewalDesc(rs.getString("renewalDesc")!=null?rs.getString("renewalDesc").toString():"");
			parentModel.setDiscountClassId(rs.getString("newsub_discount_class_id")!=null?rs.getString("newsub_discount_class_id").toString():"");
			parentModel.setDiscountClass(rs.getString("discount_class")!=null?rs.getString("discount_class").toString():"");
			parentModel.setDiscountDesc(rs.getString("discountDesc")!=null?rs.getString("discountDesc").toString():"");
			parentModel.setPremiumOrderCodeId(rs.getString("premium_order_code_id")!=null?rs.getString("premium_order_code_id").toString():"");
			parentModel.setSourceCodeType(rs.getString("source_code_type").toString());
			parentModel.setMruCatalogContentSeq(rs.getString("mru_catalog_content_seq")!=null?rs.getString("mru_catalog_content_seq").toString():"");
			parentModel.setCurrency(rs.getString("currency")!=null?rs.getString("currency").toString():"");
			parentModel.setMruGenericPromotionCodeSeq(rs.getString("mru_generic_promotion_code_seq")!=null?rs.getString("mru_generic_promotion_code_seq").toString():"");
			parentModel.setIsDdp(rs.getString("is_ddp").toString());
			parentModel.setShippingPriceList(rs.getString("shipping_price_list")!=null?rs.getString("shipping_price_list").toString():"");
		}catch(Exception e) {
			System.out.println(" Exception " + e);
		}
		return parentModel;
	}
}

	