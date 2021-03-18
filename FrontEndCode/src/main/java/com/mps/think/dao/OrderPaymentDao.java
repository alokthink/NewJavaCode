package com.mps.think.dao;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mps.think.model.CustomerAuxiliaryModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.option.model.EditTrail;
import com.mps.think.option.model.Journal;
import com.mps.think.option.model.Paybreak;
import com.mps.think.option.model.Payment;
import com.mps.think.option.model.PaymentReversedPayment;
import com.mps.think.option.model.SupplementalRefund;

public interface OrderPaymentDao {

	public List<Map<String, Object>> getSupplementalRefundDetails(Integer orderHdrId, Integer orderItemSeq);
	public List<DropdownModel> getTransactionReasonByReasonType(String action);
	public int getPaymentSeq(Integer customerId);
	public List<DropdownModel> getCurrencyType();
	public int savePayment(SupplementalRefund payment);
	public int savePaymentReversedPayment(PaymentReversedPayment paymentReversedPayment);
	public int saveJournal(Journal journal);
	public int saveEditTrail(EditTrail editTrail);
	public int savePaybreak(Paybreak paybreak);
	public int saveSupplementalRefund(SupplementalRefund refund);
	
	public List<CustomerAuxiliaryModel> getAuxiliaryFields(String action) throws SQLException;
	
	public List<Map<String, Object>> getAuxiliaryFieldsDetails(int customerId, int serviceSeq);
	public int saveAuxiliaryFieldsDetails(HttpServletRequest request);
	public int saveCustomerLoginAuxiliaryFieldsDetails(HttpServletRequest request);
	public int saveCustomerAddressFieldsDetails(HttpServletRequest request);
	public int savePaymentAuxiliaryFieldsDetails(HttpServletRequest request);
	public List<CustomerAuxiliaryModel> getServiceAuxiliaryFormField() throws SQLException;
	public String saveServiceAuxiliary(HttpServletRequest request) throws SQLException;
	public LinkedHashMap<String, String> setServiceAuxiliaryDetailByID(long customerId, int serviceSeq) throws SQLException;
	public LinkedHashMap<String, String> setPaymentAuxiliaryDetailByID(long customerId, int paymentSeq) throws SQLException;
	public LinkedHashMap<String, String> setCustomerLoginAuxiliaryDetailByID(long customerId) throws SQLException;
	public LinkedHashMap<String, String> setCustomerAddressAuxiliaryDetailByID(long customerId, int customerAddressSeq) throws SQLException;
	public Map<String,Object> showReviewJobHistoryButton(long jobId);
	public List<DropdownModel> getPaymentAccountList(int customerId, int active);
	public List<DropdownModel> getRefundCardDetails(int paymentAccountSeq, int idNbrLastFour);
	public List<Map<String,Object>> getAmountToCurrencyConversion(long orderhdrId, int orderItemSeq);
	public List<Map<String,Object>> getCurrencyDetails(String currency);
	public float covertedAmountByCurrency(float amount, String currency);
	
}
