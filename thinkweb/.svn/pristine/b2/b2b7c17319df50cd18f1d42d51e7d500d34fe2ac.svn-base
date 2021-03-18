package com.mps.think.orderFunctionality.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.setup.model.SubscriptionDef;
import com.mps.think.setup.util.PropertyUtils;

public class UpDownGradeMapper implements RowMapper<SubscriptionDef>{

	@Override
	public SubscriptionDef mapRow(ResultSet rs, int rowNum) throws SQLException{
		SubscriptionDef subscriptionDef = new SubscriptionDef();
		try {
			subscriptionDef.setSubscriptionDefId(rs.getInt("subscription_def_id"));
			subscriptionDef.setSubscriptionDef(rs.getString("subscription_def"));
			subscriptionDef.setTermId(rs.getString("term_id")!=null?rs.getString("term_id"):"");
			subscriptionDef.setPubRotationId(rs.getString("pub_rotation_id")!=null?rs.getString("pub_rotation_id"):"");
			subscriptionDef.setOcId(rs.getLong("oc_id"));
			subscriptionDef.setSubscriptionCategoryId(rs.getString("subscription_category_id")!=null?rs.getString("subscription_category_id"):"");
			subscriptionDef.setRateClassId(rs.getString("rate_class_id")!=null?rs.getString("rate_class_id"):"");
			subscriptionDef.setDescription(rs.getString("description"));
			subscriptionDef.setMedia(rs.getString("media")!=null?rs.getString("media"):"");
			subscriptionDef.setEdition(rs.getString("edition")!=null?rs.getString("edition"):"");
			subscriptionDef.setRenewalCardId(rs.getString("renewal_card_id")!=null?rs.getString("renewal_card_id"):"");
			subscriptionDef.setOrderCodeId(rs.getString("order_code_id")!=null?rs.getString("order_code_id"):"");
			subscriptionDef.setAllowOnInternet(rs.getString("allow_on_internet"));
			subscriptionDef.setTagLine(rs.getString("tag_line")!=null?rs.getString("tag_line"):"");
			subscriptionDef.setIssn(rs.getString("issn")!=null?rs.getString("issn"):"");
			subscriptionDef.setExpireGap(rs.getInt("expire_gap"));
			subscriptionDef.setLogicalStart(new PropertyUtils().getConstantValue("logical_start_" + rs.getInt("logical_start")));
			subscriptionDef.setAuxiliary1(rs.getString("auxiliary_1")!=null?rs.getString("auxiliary_1"):"");
			subscriptionDef.setAuxiliary2(rs.getString("auxiliary_2")!=null?rs.getString("auxiliary_2"):"");
			subscriptionDef.setForcedExpireMonth(new PropertyUtils().getConstantValue("forced_expire_month_" + rs.getInt("forced_expire_month")));
			subscriptionDef.setUpgradeDowngradeValue(rs.getString("upgrade_downgrade_value")!=null?rs.getString("upgrade_downgrade_value"):"");
			subscriptionDef.setCancelPolicyId(rs.getString("cancel_policy_id")!=null?rs.getString("cancel_policy_id"):"");
			subscriptionDef.setInactive(rs.getString("inactive")!=null?rs.getString("inactive"):"");
			subscriptionDef.setPremiumOrderCodeId(rs.getString("premium_order_code_id")!=null?rs.getString("premium_order_code_id"):"");
			subscriptionDef.setAuditNGraceIssuesAllowed(rs.getString("audit_n_grace_issues_allowed")!=null?rs.getString("audit_n_grace_issues_allowed").toString():"");
			subscriptionDef.setExtfreeQty(rs.getString("extfree_qty")!=null?rs.getString("extfree_qty").toString():"");
		}catch(Exception e) {
			System.out.println(" Exception " + e);
		}
		return subscriptionDef;
	 }
}
