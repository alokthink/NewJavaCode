package com.mps.think.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import com.mps.think.model.DropdownModel;
import com.mps.think.model.PaymentAccountModel;

public interface PaymentAccountDao {
	
	public List<DropdownModel> getpaymentTypeList() throws SQLException;
	public void getCardAddress(Long customerId,PaymentAccountModel paymentAccountModel ) throws SQLException;
	public String addPaymentAccount(PaymentAccountModel paymentAccountModel);
	public List<Map<String, Object>> getpaymentAccountList(Long customerId);
	public List<DropdownModel> getaddressList(Long customerId)throws SQLException;
	public PaymentAccountModel  getPaymentAccountDetails(Long customerId,int payment_account_seq) throws ServiceException;
	public int updatePaymentAccountDetails(PaymentAccountModel paymentAccountModel,int paymentAccountSeq);
	public String clearPaymentAccount(Long customerId,int paymentAccountSeq);
	public Integer getCreditCardToggleValue();
	public Integer getBankWizardToggleValue();
	public List<Map<String, Object>> getCreditAccountList(Long customerId,Integer active);
	public List<Map<String, Object>> getDebitAccountList(Long customerId,Integer active);
	
	//public List<Map<String, Object>>  creditCardValidationDetails(String CardNumber);
	
}
