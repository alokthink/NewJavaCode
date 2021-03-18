package com.mps.think.resultMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import com.mps.think.model.ExistingUnpaidOrdersModel;
import com.mps.think.util.PropertyUtilityClass;



public class ExistingUnpaidOrdersMapper implements RowMapper<ExistingUnpaidOrdersModel>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ExistingUnpaidOrdersMapper.class);
	
	@Override
	public ExistingUnpaidOrdersModel mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		ExistingUnpaidOrdersModel existingUnpaidOrdersModel=new ExistingUnpaidOrdersModel();
		try
		{
			existingUnpaidOrdersModel.setN(rs.getInt("note_exist"));
			existingUnpaidOrdersModel.setS(rs.getInt("service_exist"));
			existingUnpaidOrdersModel.setOrder(rs.getInt("orderhdr_id"));
			existingUnpaidOrdersModel.setLine(rs.getInt("order_item_seq"));
			existingUnpaidOrdersModel.setDate(rs.getString("order_date"));
			existingUnpaidOrdersModel.setOrder_class(rs.getString("oc"));
			existingUnpaidOrdersModel.setOrder_code(rs.getString("order_code"));
			existingUnpaidOrdersModel.setQty(rs.getInt("order_qty"));
			existingUnpaidOrdersModel.setLiability(rs.getString("n_issues_left"));
			existingUnpaidOrdersModel.setCharged(rs.getDouble("gross_local_amount"));
			existingUnpaidOrdersModel.setOrder_status(new PropertyUtilityClass().getConstantValue("order_item.order_status_"+rs.getInt("order_status")).trim());
			existingUnpaidOrdersModel.setPay_status(new PropertyUtilityClass().getConstantValue("order_item.pay_status_"+rs.getInt("payment_status")).trim());
			existingUnpaidOrdersModel.setAgency(rs.getString("agency_customer_id"));
			existingUnpaidOrdersModel.setBundle_qty(rs.getInt("bundle_qty"));
			existingUnpaidOrdersModel.setAddress_seq(rs.getInt("customer_address_seq"));
			existingUnpaidOrdersModel.setSubscrip_id(rs.getString("subscrip_id"));
			existingUnpaidOrdersModel.setGross_base_amount(rs.getDouble("gross_base_amount"));
			existingUnpaidOrdersModel.setNet_base_amount(rs.getDouble("net_base_amount"));
			existingUnpaidOrdersModel.setNet_local_amount(rs.getDouble("net_local_amount"));
			existingUnpaidOrdersModel.setRenewal(rs.getString("renewal_orderhdr_id"));
			existingUnpaidOrdersModel.setPackage_instance(rs.getString("package_instance"));
			existingUnpaidOrdersModel.setShip_qty(rs.getString("ship_qty"));
			existingUnpaidOrdersModel.setBackOrd_qty(rs.getString("backord_qty"));
			existingUnpaidOrdersModel.setCustomer_id(rs.getInt("customer_id"));
			existingUnpaidOrdersModel.setPayerCustomer(rs.getInt("customer_id"));
			existingUnpaidOrdersModel.setOrderId(rs.getInt("orderhdr_id"));
			existingUnpaidOrdersModel.setOrderItemSeq(rs.getInt("order_item_seq"));
			existingUnpaidOrdersModel.setOrderIdOrderseq(rs.getInt("orderhdr_id")+"-1");
			existingUnpaidOrdersModel.setCurrency(rs.getString("currency"));
			existingUnpaidOrdersModel.setPayAmount(rs.getDouble("gross_base_amount"));
			existingUnpaidOrdersModel.setBase_amount(rs.getDouble("net_base_amount"));
			existingUnpaidOrdersModel.setDoc_ref_id(rs.getInt(1));
			existingUnpaidOrdersModel.setRefund_deposit_pay_amt(rs.getDouble(2));
			existingUnpaidOrdersModel.setPayment_clear_status(0);
		}
		catch(Exception e)
		{
			LOGGER.info("ExistingUnpaidOrdersModel : "+e);
			e.printStackTrace();
		}
		return existingUnpaidOrdersModel;
	}
}