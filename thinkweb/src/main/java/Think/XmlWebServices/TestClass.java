package Think.XmlWebServices;

public class TestClass 
{
	public void wsdlCall()
	{
	ThinkSoap soap = null;
	try{
	ThinkWSLocator locator = new ThinkWSLocator();
	Order_add_request orderAddRequest = new Order_add_request();
	Order_add_response parametersResponse = new Order_add_response();
	soap = locator.getThinkSoap();
	
	orderAddRequest.setDsn("QADB-Local");
	orderAddRequest.setDoc_ref_id(1);		
	
	User_login_data login=new User_login_data();
	login.setLogin("think");
	login.setPassword("1");
			
	Customer_identifier customer_identifier = new Customer_identifier(); 
	customer_identifier.setCustomer_id(43);
	
	
	Customer_address_identifier customer_address_identifier = new Customer_address_identifier();
	customer_address_identifier.setCustomer_identifier(customer_identifier);
	customer_address_identifier.setCustomer_address_seq(1);
	
	
	Order_data order_data = new Order_data();
	Item_data data =new Item_data();
	
	Item_data[] item_data = new Item_data[1];
	
	data.setOrder_code_id(12);		
	data.setSource_code_id(6);		
	
	item_data[0] = data;
	order_data.setItem_data(item_data);
	
	orderAddRequest.setUser_login_data(login);
	orderAddRequest.setCustomer_address_identifier(customer_address_identifier);
	orderAddRequest.setOrder_data(order_data);
	
	
	/*parameters.setDsn("ucpress_test");*/
	//soap.orderAdd(orderAddRequest);
	parametersResponse = soap.orderAdd(orderAddRequest);
	System.out.println("parametersResponse  = "+parametersResponse);
	}
	catch(Exception e){
		System.out.println();
		e.printStackTrace();
	}}

}
