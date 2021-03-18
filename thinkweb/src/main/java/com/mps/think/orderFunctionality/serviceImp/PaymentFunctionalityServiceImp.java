package com.mps.think.orderFunctionality.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.orderFunctionality.dao.PaymentFunctionalityDao;
import com.mps.think.orderFunctionality.service.PaymentFunctionalityService;

	@Service("PaymentFunctionalityService")
	public class PaymentFunctionalityServiceImp implements PaymentFunctionalityService {
		
		@Autowired 
		PaymentFunctionalityDao paymentFunctionalityDao;

		@Override
		public List<Map<String, Object>> getGatewayLogCustomer(int customerId) {
			return paymentFunctionalityDao.getGatewayLogCustomer(customerId);
		}

		@Override
		public List<Map<String, Object>> getGatewayLogSelectedPayment(int customerId, int paymentSeq) {
			return paymentFunctionalityDao.getGatewayLogSelectedPayment(customerId, paymentSeq);
		}

		@Override
		public int deleteGatewayLog(String icsRefNum) {
			return paymentFunctionalityDao.deleteGatewayLog(icsRefNum);
		}
	}


