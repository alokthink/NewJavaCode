package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.RateClassEffectiveModel;
import com.mps.think.model.RatecardModel;
import com.mps.think.model.SubscriptionDefinition;

public class SubscriptionPackageDefMapper implements RowMapper<SubscriptionDefinition>{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionPackageDefMapper.class);
	@Override
	public SubscriptionDefinition mapRow(ResultSet rs, int rowNum) throws SQLException {
		SubscriptionDefinition subscriptionDefinition = new SubscriptionDefinition();
		try{
			subscriptionDefinition.setSubscriptionDefId(rs.getInt("subscription_def_id"));
			subscriptionDefinition.setSubscriptionDef(rs.getString("subscription_def"));
			subscriptionDefinition.setDescription(rs.getString("description"));
			subscriptionDefinition.setOrderCodeId(rs.getString("order_code_id"));
			subscriptionDefinition.setOrderCode(rs.getString("order_code"));
			subscriptionDefinition.setOcId(rs.getString("oc_id"));
			subscriptionDefinition.setOrderClass(rs.getString("oc"));
			subscriptionDefinition.setMedia(rs.getString("media"));
			subscriptionDefinition.setEdition(rs.getString("edition"));
			if((rs.getString("start_type").equals("0") || rs.getString("start_type").equals("1")) && rs.getString("order_code_type").equals("0")) {
			subscriptionDefinition.setOrderQty(rs.getInt("n_issues"));
			subscriptionDefinition.setBundleQty(1);}
			else {
				subscriptionDefinition.setOrderQty(rs.getString("qty")!=null?rs.getInt("qty"):0);
				subscriptionDefinition.setBundleQty(1);
			}
			subscriptionDefinition.setSubscriptionCategoryId(rs.getString("subscription_category_id"));
			subscriptionDefinition.setPubRotationId(rs.getString("pub_rotation_id")!=null?rs.getString("pub_rotation_id"):"");	
			subscriptionDefinition.setLocalAmount(rs.getDouble("localAmount"));
			subscriptionDefinition.setBaseAmount(rs.getDouble("baseAmount"));
			subscriptionDefinition.setCommodityCode(rs.getString("commodity_code"));
			subscriptionDefinition.setState(rs.getString("state"));
			//subscriptionDefinition.setSubscriptionCategoryDescription(rs.getString("subscription_category_description")!=null?rs.getString("subscription_category_description"):"");
			
			RateClassEffectiveModel rateClassEffectiveModel = new RateClassEffectiveModel();
			rateClassEffectiveModel.setRateClassId(rs.getInt("rate_class_id"));
			rateClassEffectiveModel.setRateClassEffectiveSeq(rs.getInt("rate_class_effective_seq"));
			rateClassEffectiveModel.setMruRatecardSeq(rs.getString("mru_ratecard_seq"));
			rateClassEffectiveModel.setChargeNew(rs.getString("charge_new"));
			rateClassEffectiveModel.setRemitNew(rs.getString("remit_new"));
			rateClassEffectiveModel.setPercentNew(rs.getString("percent_new"));
			rateClassEffectiveModel.setChargeRen(rs.getString("charge_ren"));
			rateClassEffectiveModel.setRemitRen(rs.getString("remit_ren"));
			rateClassEffectiveModel.setPercentRen(rs.getString("percent_ren"));
			
			
			RatecardModel ratecardModel = new RatecardModel();
			ratecardModel.setPrice(rs.getString("ratecard_price"));
			ratecardModel.setCurrency(rs.getString("currency"));
			ratecardModel.setExchangeRate(rs.getString("exchange_rate"));
			
			subscriptionDefinition.setRateClassEffectiveModel(rateClassEffectiveModel);
			subscriptionDefinition.setRatecardModel(ratecardModel);
			
		}catch(Exception e){
			LOGGER.info("SubscriptionPackageDefMapper : "+e);
		}
		return subscriptionDefinition;
	}

}