package com.mps.think.resultMapper;

import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.OrderCode;
import com.mps.think.util.PropertyUtilityClass;

public class OrderSourceOfferMapper implements RowMapper<OrderCode>{

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderSourceOfferMapper.class);
	
	@Override
	public OrderCode mapRow(ResultSet rs, int rowNum) 
	{
		OrderCode orderCode=new OrderCode();
		try
		{
			orderCode.setOrderCodeId(rs.getInt("order_code_id"));
			orderCode.setOrderCode(rs.getString("order_code"));
			orderCode.setOcID(rs.getInt("oc_id"));
			orderCode.setOrderClass(rs.getString("oc"));
			orderCode.setDescription(rs.getString("description"));
			orderCode.setOrderCodeType(rs.getString("order_code_type"));
			orderCode.setOrderCodeTypeDescription(new PropertyUtilityClass().getConstantValue("order_code.order_code_type_"+rs.getString("order_code_type")));
			orderCode.setPremium(new PropertyUtilityClass().getConstantValue("order_code.premium_"+rs.getString("premium")));
			orderCode.setTerm(rs.getString("term"));
			orderCode.setMedia(rs.getString("media"));
			orderCode.setEdition(rs.getString("edition"));
			orderCode.setAuditQualCategory(rs.getInt("audit_qual_category"));
			orderCode.setProductSize(rs.getString("product_size"));
			orderCode.setProductStyle(rs.getString("product_style"));
			orderCode.setProductColor(rs.getString("product_color"));
			orderCode.setPkgOnlyItem(rs.getString("pkg_only_item"));
			orderCode.setIsProforma(rs.getString("is_proforma"));
			orderCode.setNoCharge(rs.getString("no_charge"));
			orderCode.setControlled(rs.getString("controlled"));
			orderCode.setPerpetualOrder(rs.getString("perpetual_order"));
			orderCode.setPrepaymentReq(rs.getString("prepayment_req"));
			orderCode.setActive(rs.getString("active"));
			//Added for THINKDEV-610,611,615
			orderCode.setRevenueMethod(rs.getInt("revenue_method"));
			orderCode.setStartType(rs.getInt("start_type"));
		}catch(Exception e)
		{
			LOGGER.info(""+e);
			e.printStackTrace();
		}
		return orderCode;
	}
}