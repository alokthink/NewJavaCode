package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.IssueModel;
import com.mps.think.model.RateClassEffectiveModel;
import com.mps.think.model.RatecardModel;
import com.mps.think.model.SingleCopyOrder;
import com.mps.think.util.PropertyUtilityClass;

public class SingleOrderMapper  implements RowMapper<SingleCopyOrder>{

	private static final Logger LOGGER = LoggerFactory.getLogger(SingleOrderMapper.class);
	
	@Override
	public SingleCopyOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		SingleCopyOrder singleOrderData = new SingleCopyOrder();
		try {
			singleOrderData.setIssueID(rs.getInt("issue_id"));
			singleOrderData.setDescription(rs.getString("description"));
			singleOrderData.setOrderCodeId(rs.getString("order_code_id"));
			singleOrderData.setOrderCode(rs.getString("order_code"));		
			singleOrderData.setOrderCodeType(rs.getString("order_code_type"));
			singleOrderData.setOrderClass(rs.getString("oc"));
			singleOrderData.setOrderQty(1);
			singleOrderData.setBundleQty(1);
			singleOrderData.setLocalAmount(rs.getDouble("localAmount"));
			singleOrderData.setBaseAmount(rs.getDouble("baseAmount"));
			singleOrderData.setCommodityCode(rs.getString("commodity_code"));
			//singleOrderData.setSubscriptionCategoryDescription(rs.getString("subscription_category_description")!=null?rs.getString("subscription_category_description"):"");
			singleOrderData.setState(rs.getString("state"));
			RateClassEffectiveModel rateClassEffectiveModel = new RateClassEffectiveModel();
			rateClassEffectiveModel.setRateClassId(rs.getInt("rate_class_id"));
			rateClassEffectiveModel.setRateClassEffectiveSeq(rs.getInt("rate_class_effective_seq"));
			rateClassEffectiveModel.setMruRatecardSeq(rs.getString("mru_ratecard_seq"));
			
			RatecardModel ratecardModel = new RatecardModel();
			ratecardModel.setPrice(rs.getString("ratecard_price"));
			ratecardModel.setCurrency(rs.getString("currency"));
			ratecardModel.setExchangeRate(rs.getString("exchange_rate"));
			singleOrderData.setRateClassEffectiveModel(rateClassEffectiveModel);
			singleOrderData.setRatecardModel(ratecardModel);
	
		}catch(Exception e){
			LOGGER.info("SubscriptionPackageDefMapper : "+e);
		}
		return singleOrderData;
	
	}
}
