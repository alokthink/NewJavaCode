package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.OrderItem;
import com.mps.think.wsdl.PaymentWsdl;

import Think.XmlWebServices.Order_payment_select_responsePayment_on_order;

public class OrderLookupSearchMapper implements RowMapper<OrderItem>{
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderLookupSearchMapper.class);
	@Override
	public OrderItem mapRow(ResultSet rs, int arg1) throws SQLException {
	
		OrderItem orderItem=new OrderItem();
		try{
			orderItem.setOrderhdrId(rs.getLong("orderhdr_id"));
			orderItem.setOrderItemSeq(rs.getInt("order_item_seq"));
			orderItem.setPayment_status(rs.getString("payment_status"));
			orderItem.setCustomerId(rs.getInt("customer_id"));
			orderItem.setSubscripId(rs.getString("subscrip_id"));
			orderItem.setFullName(rs.getString("fullname"));
			orderItem.setOcId(rs.getInt("oc_id"));
			orderItem.setOrderCodeDescription(rs.getString("description"));
			orderItem.setOrderDate(rs.getString("order_date"));
			orderItem.setOrderCode(rs.getString("order_code"));
			orderItem.setCharged(rs.getDouble("charged"));
			orderItem.setBundleQty(rs.getInt("order_qty"));
			orderItem.setBillToCustomerId(rs.getInt("bill_to_customer_id"));
			orderItem.setCurrency(rs.getString("currency"));
			orderItem.setOrder_status(rs.getString("order_status"));
			orderItem.setRefundStatus(rs.getInt("refund_status"));
			orderItem.setNetLocalAmount(rs.getString("net_local_amount"));
			orderItem.setGrossBaseAmount(rs.getString("gross_base_amount"));
			if(rs.getString("payment_status").equals("0")){
				
				
	  			
				
			}
			else if(rs.getString("payment_status").equals("5")){
				
				List<Order_payment_select_responsePayment_on_order> allPaymentList = new PaymentWsdl().fetchAmount(Integer.parseInt(rs.getString("customer_id")));
				 Iterator<Order_payment_select_responsePayment_on_order> itr=allPaymentList.iterator();  
			      String dueAmount="0.0";
			      while(itr.hasNext()) {
			    	  Order_payment_select_responsePayment_on_order orderPayment = itr.next();
			    	  if(orderPayment.getTotal_paid()!=null &&Float.parseFloat(orderPayment.getTotal_paid().toString())!=0){
			    		 dueAmount =String.valueOf((Float.parseFloat(orderPayment.getGross_base_amount().toString()))-(Float.parseFloat(orderPayment.getTotal_paid().toString())));
			    		 orderItem.setNetBaseAmount(dueAmount);
			    		 orderItem.setGrossLocalAmount(dueAmount);
			  			orderItem.setNetLocalAmount(dueAmount);
			  			
			    		  
			    	  }
				
			  }
			}
			else{
				orderItem.setNetBaseAmount(rs.getString("0"));
				orderItem.setGrossLocalAmount(rs.getString("0"));
				orderItem.setNetLocalAmount(rs.getString("0"));
			}
			
			
					}
		catch(Exception e){
			LOGGER.info("" + e);
		}
		return orderItem;
		
	}

}
