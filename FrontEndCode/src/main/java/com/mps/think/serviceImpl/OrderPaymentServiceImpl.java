package com.mps.think.serviceImpl;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.dao.OrderPaymentDao;
import com.mps.think.model.CustomerAuxiliaryModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.option.model.EditTrail;
import com.mps.think.option.model.Journal;
import com.mps.think.option.model.Paybreak;
import com.mps.think.option.model.Payment;
import com.mps.think.option.model.PaymentReversedPayment;
import com.mps.think.option.model.SupplementalRefund;
import com.mps.think.service.OrderPaymentService;

@Service("OrderPaymentService")
public class OrderPaymentServiceImpl implements OrderPaymentService{
	@Autowired
	OrderPaymentDao orderPaymentDao;
	@Override
	public List<Map<String, Object>> getSupplementalRefundDetails(Integer orderHdrId, Integer orderItemSeq) {
		return orderPaymentDao.getSupplementalRefundDetails(orderHdrId, orderItemSeq);
	}

	@Override
	public List<DropdownModel> getTransactionReasonByReasonType(String action) {
		return orderPaymentDao.getTransactionReasonByReasonType(action);
	}

	@Override
	public int savePayment(SupplementalRefund payment) {
		return orderPaymentDao.savePayment(payment);
	}

	@Override
	public int getPaymentSeq(Integer customerId) {
		return orderPaymentDao.getPaymentSeq(customerId);
	}

	@Override
	public List<DropdownModel> getCurrencyType() {
		return orderPaymentDao.getCurrencyType();
	}

	@Override
	public int savePaymentReversedPayment(PaymentReversedPayment paymentReversedPayment) {
		return orderPaymentDao.savePaymentReversedPayment(paymentReversedPayment);
	}

	@Override
	public int saveJournal(Journal journal) {
		return orderPaymentDao.saveJournal(journal);
	}

	@Override
	public int saveEditTrail(EditTrail editTrail) {
		return orderPaymentDao.saveEditTrail(editTrail);
	}

	@Override
	public int savePaybreak(Paybreak paybreak) {
		return orderPaymentDao.savePaybreak(paybreak);
	}

	@Override
	public int saveSupplementalRefund(SupplementalRefund refund) {
		return orderPaymentDao.saveSupplementalRefund(refund);
	}

	@Override
	public List<CustomerAuxiliaryModel> getServiceAuxiliaryFormField() throws SQLException {
		return orderPaymentDao.getServiceAuxiliaryFormField();
	}

	@Override
	public String saveServiceAuxiliary(HttpServletRequest request) throws SQLException {
		return orderPaymentDao.saveServiceAuxiliary(request);
	}

	@Override
	public LinkedHashMap<String, String> setServiceAuxiliaryDetailByID(long customerId, int serviceSeq)
			throws SQLException {
		return orderPaymentDao.setServiceAuxiliaryDetailByID(customerId, serviceSeq);
	}


	@Override
	public List<Map<String, Object>> getAuxiliaryFieldsDetails(int customerId, int serviceSeq) {
		return orderPaymentDao.getAuxiliaryFieldsDetails(customerId, serviceSeq);
	}

	@Override
	public int saveAuxiliaryFieldsDetails(HttpServletRequest request) {
		return orderPaymentDao.saveAuxiliaryFieldsDetails(request);
	}

	@Override
	public Map<String,Object> showReviewJobHistoryButton(long jobId) {
		return orderPaymentDao.showReviewJobHistoryButton(jobId);
	}

	@Override
	public LinkedHashMap<String, String> setpaymentAuxiliaryDetailByID(long customerId, int paymentSeq)
			throws SQLException {
		return orderPaymentDao.setPaymentAuxiliaryDetailByID(customerId, paymentSeq);
	}

	@Override
	public List<CustomerAuxiliaryModel> getAuxiliaryFields(String action) throws SQLException {
		return orderPaymentDao.getAuxiliaryFields(action);
	}

	@Override
	public int saveCustomerLoginAuxiliaryFieldsDetails(HttpServletRequest request) {
		return orderPaymentDao.saveCustomerLoginAuxiliaryFieldsDetails(request);
	}

	@Override
	public int saveCustomerAddressFieldsDetails(HttpServletRequest request) {
		return orderPaymentDao.saveCustomerAddressFieldsDetails(request);
	}

	@Override
	public int savePaymentAuxiliaryFieldsDetails(HttpServletRequest request) {
		return orderPaymentDao.savePaymentAuxiliaryFieldsDetails(request);
	}

	@Override
	public LinkedHashMap<String, String> setPaymentAuxiliaryDetailByID(long customerId, int paymentSeq)throws SQLException {
		return orderPaymentDao.setPaymentAuxiliaryDetailByID(customerId, paymentSeq);
	}

	@Override
	public LinkedHashMap<String, String> setCustomerLoginAuxiliaryDetailByID(long customerId) throws SQLException {
		return orderPaymentDao.setCustomerLoginAuxiliaryDetailByID(customerId);
	}

	@Override
	public LinkedHashMap<String, String> setCustomerAddressAuxiliaryDetailByID(long customerId, int customerAddressSeq)throws SQLException {
		return orderPaymentDao.setCustomerAddressAuxiliaryDetailByID(customerId, customerAddressSeq);
	}

	@Override
	public List<DropdownModel> getPaymentAccountList(int customerId, int active) {
		return orderPaymentDao.getPaymentAccountList(customerId, active);
	}

	@Override
	public List<DropdownModel> getRefundCardDetails(int paymentAccountSeq, int idNbrLastFour) {
		return orderPaymentDao.getRefundCardDetails(paymentAccountSeq, idNbrLastFour);
	}

	@Override
	public List<Map<String,Object>> getAmountToCurrencyConversion(long orderhdrId, int orderItemSeq) {
		return orderPaymentDao.getAmountToCurrencyConversion(orderhdrId, orderItemSeq);
	}

	@Override
	public List<Map<String, Object>> getCurrencyDetails(String currency) {
		return orderPaymentDao.getCurrencyDetails(currency);
	}

	@Override
	public float covertedAmountByCurrency(float amount, String currency) {
		return orderPaymentDao.covertedAmountByCurrency(amount, currency);
	}

}
