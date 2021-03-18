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
			parentModel.setSourceFormat(rs.getString("source_format"));
			parentModel.setSourceCode(rs.getString("source_code"));
			parentModel.setDescription(rs.getString("description"));
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
			parentModel.setGenericAgency(new PropertyUtils().getConstantValue("generic_agency_"+rs.getString("generic_agency")));
			parentModel.setOcId(rs.getInt("oc_id"));
			parentModel.setActive(new PropertyUtils().getConstantValue("active_"+rs.getInt("active")));
			parentModel.setNewsubRateClassId(rs.getString("newsub_rate_class_id")!=null?rs.getString("newsub_rate_class_id").toString():"");
			parentModel.setNewRenewalCardId(rs.getString("new_renewal_card_id")!=null?rs.getString("new_renewal_card_id").toString():"");
			parentModel.setNewsubDiscountClassId(rs.getString("newsub_discount_class_id")!=null?rs.getString("newsub_discount_class_id").toString():"");
			parentModel.setAuditSubscriptionTypeId(rs.getString("audit_subscription_type_id")!=null?rs.getString("audit_subscription_type_id").toString():"");
			parentModel.setAuditQualSourceId(rs.getString("audit_qual_source_id")!=null?rs.getString("audit_qual_source_id").toString():"");
			parentModel.setAuditNameTitleId(rs.getString("audit_name_title_id")!=null?rs.getString("audit_name_title_id").toString():"");
			parentModel.setAuditSalesChannelId(rs.getString("audit_sales_channel_id")!=null?rs.getString("audit_sales_channel_id").toString():"");
			parentModel.setPremiumOrderCodeId(rs.getString("premium_order_code_id")!=null?rs.getString("premium_order_code_id").toString():"");
			parentModel.setSourceCodeType(new PropertyUtils().getConstantValue("source_code_type_"+rs.getInt("source_code_type")));
			parentModel.setMruCatalogContentSeq(rs.getString("mru_catalog_content_seq")!=null?rs.getString("mru_catalog_content_seq").toString():"");
			parentModel.setCurrency(rs.getString("currency")!=null?rs.getString("currency").toString():"");
			parentModel.setMruGenericPromotionCodeSeq(rs.getString("mru_generic_promotion_code_seq")!=null?rs.getString("mru_generic_promotion_code_seq").toString():"");
			parentModel.setIsDdp(new PropertyUtils().getConstantValue("is_ddp_"+rs.getString("is_ddp")));
			parentModel.setShippingPriceList(rs.getInt("shipping_price_list"));
		}catch(Exception e) {
			System.out.println(" Exception " + e);
		}
		return parentModel;
	}
}

	