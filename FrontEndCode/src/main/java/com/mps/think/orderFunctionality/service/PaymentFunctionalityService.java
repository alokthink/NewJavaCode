package com.mps.think.orderFunctionality.service;

import java.util.List;
import java.util.Map;

public interface PaymentFunctionalityService {

	public List<Map<String, Object>> getGatewayLogCustomer(int customerId);

	public List<Map<String, Object>> getGatewayLogSelectedPayment(int customerId, int paymentSeq);

	public int deleteGatewayLog(String icsRefNum);

}


