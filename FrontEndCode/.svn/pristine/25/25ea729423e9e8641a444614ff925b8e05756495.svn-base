package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.BasicPackageItemModel;
import com.mps.think.model.RateClassEffectiveModel;
import com.mps.think.model.RatecardModel;

public class BasicPackageItemMapper implements RowMapper<BasicPackageItemModel>{

	@Override
	public BasicPackageItemModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		BasicPackageItemModel basicPackageItemModel = new BasicPackageItemModel();
		
		basicPackageItemModel.setPkgDefId(rs.getInt("pkg_def_id"));
		if(!(rs.getInt("orderCodeType")==5)) {
		basicPackageItemModel.setOrderCodeId(rs.getInt("item_order_code_id"));
		basicPackageItemModel.setPkgContentSeq(rs.getInt("pkg_content_seq"));
		basicPackageItemModel.setSubscriptionDefId(rs.getInt("subscription_def_id"));
		basicPackageItemModel.setIssueId(rs.getInt("issue_id"));
		basicPackageItemModel.setProductId(rs.getInt("product_id"));
		basicPackageItemModel.setContentOcId(rs.getInt("contentOcId"));
		basicPackageItemModel.setRateClassId(rs.getInt("rate_class_id"));
		basicPackageItemModel.setRevenuePercent(rs.getDouble("revenue_percent"));
		}
		basicPackageItemModel.setOrderCode(rs.getString("order_code"));
		basicPackageItemModel.setOrderClass(rs.getString("oc"));
		basicPackageItemModel.setOrderQty(1);
		basicPackageItemModel.setBundleQty(rs.getInt("qty"));
		basicPackageItemModel.setBillingType("Balance Due");
		//basicPackageItemModel.setQty(rs.getInt("qty"));
		basicPackageItemModel.setOcId(rs.getInt("oc_id"));
		basicPackageItemModel.setOrderCodeType(rs.getInt("orderCodeType"));
		basicPackageItemModel.setPkgPriceMethod(rs.getInt("pkg_price_method"));	
		//basicPackageItemModel.setPrice(rs.getString("price"));
		
		/*basicPackageItemModel.setRevenuePercent(rs.getInt("revenue_percent"));		
		basicPackageItemModel.setItemOrderCodeId(rs.getInt("item_order_code_id"));	
		basicPackageItemModel.setPkgContentDescription(rs.getString("description"));		
		basicPackageItemModel.setRequired(rs.getInt("required"));
		basicPackageItemModel.setPkgDef(rs.getString("pkg_def"));
		basicPackageItemModel.setPkgDefDescription(rs.getString("pkg_def_description"));
		basicPackageItemModel.setActive(rs.getInt("active"));
		basicPackageItemModel.setPkgPriceMethod(rs.getInt("pkg_price_method"));		
		basicPackageItemModel.setFromQty(rs.getInt("from_qty"));
		basicPackageItemModel.setRegionList(rs.getString("region_list"));
		basicPackageItemModel.setRegion(rs.getString("region"));
		basicPackageItemModel.setCurrency(rs.getString("currency"));
		basicPackageItemModel.setToQty(rs.getInt("to_qty"));*/
		
		/*basicPackageItemModel.setCommodityCode(rs.getString("commodity_code"));
		basicPackageItemModel.setPrepaymentReq(rs.getInt("prepayment_req"));
		basicPackageItemModel.setTaxable(rs.getInt("taxable"));*/
		
		return basicPackageItemModel;
	}

}
