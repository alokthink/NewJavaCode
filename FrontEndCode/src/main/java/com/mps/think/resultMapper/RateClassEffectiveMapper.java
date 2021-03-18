package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.RateClassEffectiveModel;
import com.mps.think.util.PropertyUtilityClass;

public class RateClassEffectiveMapper implements RowMapper<RateClassEffectiveModel>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RateClassEffectiveMapper.class);
	
	@Override
	public RateClassEffectiveModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		LOGGER.info("Enter RateClassEffectiveMapper : ");
		RateClassEffectiveModel rateClassEffectiveModel = new RateClassEffectiveModel();
		try{
			rateClassEffectiveModel.setRateClassId(rs.getInt("rate_class_id"));
			rateClassEffectiveModel.setRateClassEffectiveSeq(rs.getInt("rate_class_effective_seq"));
			rateClassEffectiveModel.setDescription(rs.getString("description"));
			rateClassEffectiveModel.setEffectiveDate(new PropertyUtilityClass().getDateFormatter(rs.getString("effective_date")));
			rateClassEffectiveModel.setLocalAmount(rs.getDouble("localAmount"));
			rateClassEffectiveModel.setBaseAmount(rs.getDouble("baseAmount"));
			rateClassEffectiveModel.setCurrency(rs.getString("currency"));
			rateClassEffectiveModel.setExchangeRate(rs.getString("exchange_rate"));
			rateClassEffectiveModel.setChargeNew(rs.getString("charge_new"));
			rateClassEffectiveModel.setRemitNew(rs.getString("remit_new"));
			rateClassEffectiveModel.setPercentNew(rs.getString("percent_new"));
			rateClassEffectiveModel.setChargeRen(rs.getString("charge_ren"));
			rateClassEffectiveModel.setRemitRen(rs.getString("remit_ren"));
			rateClassEffectiveModel.setPercentRen(rs.getString("percent_ren"));
			rateClassEffectiveModel.setHasTax(rs.getInt("has_tax"));
			rateClassEffectiveModel.setNew_commission(rs.getDouble("new_commission"));
			rateClassEffectiveModel.setRen_commission(rs.getDouble("ren_commission"));
			
		}catch(Exception e){
			LOGGER.info("RateClassEffectiveMapper : "+e);
		}
		return rateClassEffectiveModel;
	}

}
