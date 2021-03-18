package com.mps.think.resultMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import com.mps.think.model.RenewableItemsModel;
import com.mps.think.util.PropertyUtilityClass;


public class RenewableItemsMapper implements RowMapper<RenewableItemsModel>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RenewableItemsMapper.class);
	
	@Override
	public RenewableItemsModel mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		RenewableItemsModel renewableItemsModel=new RenewableItemsModel();
		try
		{
			renewableItemsModel.setN(rs.getInt("note_exist"));
			renewableItemsModel.setS(rs.getInt("service_exist"));
			renewableItemsModel.setOrder(rs.getInt("orderhdr_id"));
			renewableItemsModel.setLine(rs.getInt("order_item_seq"));
			renewableItemsModel.setDate(rs.getString("order_date"));
			renewableItemsModel.setOrder_class(rs.getString("oc"));
			renewableItemsModel.setOrder_code(rs.getString("order_code"));
			renewableItemsModel.setQty(rs.getInt("order_qty"));
			renewableItemsModel.setLiability(rs.getString("n_issues_left"));
			renewableItemsModel.setCharged(rs.getDouble("gross_local_amount"));
			renewableItemsModel.setOrder_status(new PropertyUtilityClass().getConstantValue("order_item.order_status_"+rs.getInt("order_status")).trim());
			renewableItemsModel.setPay_status(new PropertyUtilityClass().getConstantValue("order_item.pay_status_"+rs.getInt("payment_status")).trim());
			renewableItemsModel.setAgency(rs.getString("agency_customer_id"));
			renewableItemsModel.setBundle_qty(rs.getInt("bundle_qty"));
			renewableItemsModel.setAddress_seq(rs.getInt("customer_address_seq"));
			renewableItemsModel.setCustomer_id(rs.getInt("customer_id"));
			renewableItemsModel.setSubscrip_id(rs.getString("subscrip_id"));
			renewableItemsModel.setGross_base_amount(rs.getDouble("gross_base_amount"));
			renewableItemsModel.setNet_base_amount(rs.getDouble("net_base_amount"));
			renewableItemsModel.setNet_local_amount(rs.getDouble("net_local_amount"));
			renewableItemsModel.setRenewal(rs.getString("renewal_orderhdr_id"));
			renewableItemsModel.setPackage_instance(rs.getString("package_instance"));
			renewableItemsModel.setShip_qty(rs.getString("ship_qty"));
			renewableItemsModel.setBackOrd_qty(rs.getString("backord_qty"));
			//for editOrder API calling
			renewableItemsModel.setCustomerId(rs.getInt("customer_id"));
			renewableItemsModel.setOrderCodeId(rs.getInt("order_code_id"));
			renewableItemsModel.setOrderhdrId(rs.getInt("orderhdr_id"));
			renewableItemsModel.setOrderItemType(rs.getInt("order_item_type"));
			renewableItemsModel.setOrderItemSeq(rs.getInt("order_item_seq"));
			renewableItemsModel.setIsrenewd(1);
		}
		catch(Exception e)
		{
			LOGGER.info("renewableItemsModel : "+e);
			e.printStackTrace();
		}
		return renewableItemsModel;
	}
}
