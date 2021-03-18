package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.CustomerOrderModel;
import com.mps.think.wsdl.PaymentWsdl;

import Think.XmlWebServices.Order_payment_select_responsePayment_on_order;

public class CustomerOrderFilterMapper implements RowMapper<CustomerOrderModel> {

	@Override
	public CustomerOrderModel mapRow(ResultSet rs, int arg1) throws SQLException {
		

		CustomerOrderModel customerOrderModel=new CustomerOrderModel();
		try{
		customerOrderModel.setOrderhdr_id(rs.getLong("orderhdr_id"));
		customerOrderModel.setOrder_date(rs.getString("order_date"));
		customerOrderModel.setOrder_code_id(rs.getString("order_code_id"));
		customerOrderModel.setBillToCustomerId(rs.getString("bill_to_customer_id"));
		customerOrderModel.setOrderQty(rs.getInt("order_qty"));
		customerOrderModel.setCurrency(rs.getString("currency"));
		customerOrderModel.setOrderCode(rs.getString("order_code"));
		customerOrderModel.setCharged(rs.getDouble("gross_local_amount"));
		customerOrderModel.setPayment_status(rs.getString("payment_status"));
		if(rs.getString("payment_status").equals("0")){
			customerOrderModel.setNet_base_amount(rs.getString("net_base_amount"));
			customerOrderModel.setGross_local_amount(rs.getString("gross_local_amount"));
			customerOrderModel.setNet_local_amount(rs.getString("net_local_amount"));
			
			
		}
		else if(rs.getString("payment_status").equals("5")){
			
			List<Order_payment_select_responsePayment_on_order> allPaymentList = new PaymentWsdl().fetchAmount(Integer.parseInt(rs.getString("customer_id")));
			 Iterator<Order_payment_select_responsePayment_on_order> itr=allPaymentList.iterator();  
		      String dueAmount="0.0";
		      while(itr.hasNext()) {
		    	  Order_payment_select_responsePayment_on_order orderPayment = itr.next();
		    	  if(orderPayment.getTotal_paid()!=null &&Float.parseFloat(orderPayment.getTotal_paid().toString())!=0){
		    		 dueAmount =String.valueOf((Float.parseFloat(orderPayment.getGross_base_amount().toString()))-(Float.parseFloat(orderPayment.getTotal_paid().toString())));
		    		 customerOrderModel.setNet_base_amount(dueAmount);
		  			customerOrderModel.setGross_local_amount(dueAmount);
		  			customerOrderModel.setNet_local_amount(dueAmount);
		  			customerOrderModel.setDue(rs.getDouble("due"));
		  			customerOrderModel.setDue(rs.getDouble("pay"));
		    		  
		    	  }
			
		  }
		}
		else{
			customerOrderModel.setNet_base_amount(rs.getString("0"));
			customerOrderModel.setGross_local_amount(rs.getString("0"));
			customerOrderModel.setNet_local_amount(rs.getString("0"));
		}
		customerOrderModel.setCustomer_id(rs.getString("customer_id"));
		
		}
		catch(Exception e){
		
		}
		return customerOrderModel;
	}

}
