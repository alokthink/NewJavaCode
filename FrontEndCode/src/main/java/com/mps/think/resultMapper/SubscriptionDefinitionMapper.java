package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.SubscriptionDefinition;
import com.mps.think.util.PropertyUtilityClass;

public class SubscriptionDefinitionMapper implements RowMapper<SubscriptionDefinition>{

	private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionDefinitionMapper.class);
	@Override
	public SubscriptionDefinition mapRow(ResultSet rs, int rowNum) throws SQLException {
		SubscriptionDefinition subscriptionDefinition = new SubscriptionDefinition();
		try{
			subscriptionDefinition.setSubscriptionDefId(rs.getInt("subscription_def_id"));
			subscriptionDefinition.setSubscriptionDef(rs.getString("subscription_def"));
			subscriptionDefinition.setDescription(rs.getString("description"));
			subscriptionDefinition.setOrderCodeId(rs.getString("order_code_id"));
			subscriptionDefinition.setMedia(rs.getString("media"));
			subscriptionDefinition.setEdition(rs.getString("edition"));
			subscriptionDefinition.setSubscriptionCategoryId(rs.getString("subscription_category_id"));
			subscriptionDefinition.setPubRotationId(rs.getString("pub_rotation_id")!=null?rs.getString("pub_rotation_id"):null);	
			subscriptionDefinition.setOrderCode(rs.getString("order_code"));
			subscriptionDefinition.setSubscriptionCategoryDescription(rs.getString("subscription_category_description"));
			subscriptionDefinition.setTermId(new PropertyUtilityClass().getConstantValue("term_"+rs.getString("term_id")));
			subscriptionDefinition.setOcId(rs.getString("oc_id"));
			subscriptionDefinition.setRateClassId(rs.getInt("rate_class_id"));
			subscriptionDefinition.setRateClassEffectiveSeq(rs.getString("rate_class_effective_seq"));
			subscriptionDefinition.setRateClassEffectiveDate(rs.getString("effective_date"));
			subscriptionDefinition.setMedia(rs.getString("media"));
			subscriptionDefinition.setEdition(rs.getString("edition"));
			
			
			
		}catch(Exception e){
			LOGGER.info("SubscriptionDefinitionMapper : "+e);
		}
		return subscriptionDefinition;
	}

}
