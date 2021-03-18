package com.mps.think.wsdl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Repository;

import com.mps.think.util.PropertyUtilityClass;

import Think.XmlWebServices.Customer_identifier;
import Think.XmlWebServices.Item_data;
import Think.XmlWebServices.Order_item_edit_request;
import Think.XmlWebServices.Order_item_edit_response;
import Think.XmlWebServices.Order_item_information_request;
import Think.XmlWebServices.Order_item_information_response;
import Think.XmlWebServices.Order_item_select_request;
import Think.XmlWebServices.Order_item_select_responseOrder_item;
import Think.XmlWebServices.ThinkSoap;
import Think.XmlWebServices.ThinkWSLocator;
import Think.XmlWebServices.User_login_data;
import Think.XmlWebServices.ZZItemIdentifier;
@Repository
public class OrderItemDataWsdl {
	
	public void getOrderItemData(int orderHdrId){
		Order_item_edit_request orderItemEditRequest = new Order_item_edit_request();
		Order_item_edit_response orderItemEditResponse = new Order_item_edit_response();
		try{
			ThinkSoap soap = null;
			ThinkWSLocator locator = new ThinkWSLocator();
			soap = locator.getThinkSoap();
			
			orderItemEditRequest.setDsn("ucp_cs_web");
			orderItemEditRequest.setDoc_ref_id(1);
			
			User_login_data login=new User_login_data();
			login.setLogin("sa");
			login.setPassword("Think111");
			
			ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
			itemIdentifier.setOrderhdr_id(orderHdrId);
			itemIdentifier.setOrder_item_seq(1);
			
			Item_data item_data = new Item_data();	
			
			orderItemEditRequest.setUser_login_data(login);
			orderItemEditRequest.setItem_identifier(itemIdentifier);
			orderItemEditRequest.setItem_data(item_data);
			
			
			
			orderItemEditResponse = soap.orderItemEdit(orderItemEditRequest);
			System.out.println("orderItemEditResponse = "+orderItemEditResponse);
		}
		catch(Exception e){
			System.out.println("OrderItemDataWsdl : "+e);
		}
	}
	
	
public List<Order_item_information_response> getOrderItemDetails(int oc_id,int CustomerId) throws ServiceException {
		
		Order_item_information_response response=null;
		
		List<Order_item_information_response> responseList=new ArrayList<>();
		
		try {
			ThinkSoap soap = null;
			ThinkWSLocator locator = new ThinkWSLocator();
			soap = locator.getThinkSoap();
			
			
			Order_item_information_request orderRequest=new Order_item_information_request();
			
			User_login_data login=new User_login_data();
			login.setLogin(new PropertyUtilityClass().getQuery("login"));	
			login.setPassword( new PropertyUtilityClass().getQuery("password"));
			
			
			Customer_identifier customer_identifier = new Customer_identifier(); 
			customer_identifier.setCustomer_id(CustomerId);
				
			orderRequest.setUser_login_data(login);
			orderRequest.setCustomer_identifier(customer_identifier);
			orderRequest.setOc_id(oc_id);
			orderRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
			
			
			System.out.println("-------------------------------------");
			response=soap.orderItemInformation(orderRequest);
			System.out.println("---------------------------------------");
			if(response!=null){
				responseList.add(response);
			}
								
			}catch(Exception ex) {
			
  			System.out.println("getorderAddDetails = "+ ex);
  		}
  		return responseList;
		
	}
public List<Order_item_select_responseOrder_item[]> getOrderItemEditDetails(int orderHdrId,int order_item_seq) throws ServiceException {
	
	Order_item_select_responseOrder_item[] response=null;
	String status="true";
	 
	List<Order_item_select_responseOrder_item[]> responseList=new ArrayList<>();
	
	try {
		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		soap = locator.getThinkSoap();
			
		Order_item_select_request orderRequest=new Order_item_select_request();
		
		User_login_data login=new User_login_data();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));
		login.setPassword( new PropertyUtilityClass().getQuery("password"));
		
		ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
		itemIdentifier.setOrderhdr_id(orderHdrId);
		itemIdentifier.setOrder_item_seq(order_item_seq);

		orderRequest.setItem_identifier(itemIdentifier);
		orderRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
		orderRequest.setUser_login_data(login);
		System.out.println("inside wsdl---------------------");
		//response=soap.orderItemSelect(orderRequest);
		response=soap.orderItemSelect(orderRequest);
		System.out.println("after wsdl call.----------------");
		if(response!=null){
			
			responseList.add(response);
		}
		
}catch(Exception ex) {

	System.out.println("getorderAddDetails = "+ ex);
	System.out.println("false");
}


return responseList;

}
}
