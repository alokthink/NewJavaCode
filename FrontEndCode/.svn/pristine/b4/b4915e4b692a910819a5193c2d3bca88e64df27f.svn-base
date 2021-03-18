package com.mps.think.serviceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.dao.PaymentInfoDao;
import com.mps.think.model.CustomerOrderModel;
import com.mps.think.model.CustomerOrderPayment;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.JournalDepositModel;
import com.mps.think.model.OrderDetailsModel;
import com.mps.think.model.OrderItem;
import com.mps.think.model.OrderItemAccountModel;
import com.mps.think.model.OrderItemAmtBreak;
import com.mps.think.model.PaybreakModel;
import com.mps.think.model.PaymentModel;
import com.mps.think.model.PaymentReview;
import com.mps.think.model.TotalDepositSummaryModel;
import com.mps.think.service.PaymentService;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	PaymentInfoDao paymentInfoDao;
	
	@Override
	public List<DropdownModel>getPaymentType(){
		
		return paymentInfoDao.getPaymentType();
	}
	@Override
	public List<DropdownModel>getPayerCustomer(int customerId, int orderId){
		
		return paymentInfoDao.getPayerCustomer(customerId,orderId);
	}
	@Override
	public List<DropdownModel>getPayerCustomerAddress(int customer_id){
		
		return paymentInfoDao.getPayerCustomerAddress(customer_id);
	}
	@Override
	public List<Map<String, Object>> getCurrencyType(){
		
		return paymentInfoDao.getCurrencyType();
	}
	
	@Override
	public List<PaymentModel> getAllPayment(String customerId,int filterDropdown, String orderhdrId){
		
		return paymentInfoDao.getAllPayment(customerId,filterDropdown,orderhdrId);
	}
	@Override
	public List<Map<String, Object>> getPaymentAccount(){
		
		return paymentInfoDao.getPaymentAccount();
	}
	
	@Override
	public PaymentModel getCustomerDetailsForPayment(String customerId){
		
		return paymentInfoDao.getCustomerDetailsForPayment(customerId);
	}
	@Override
	public List<Map<String, Object>> getOrderDetaiils(String customerId){
		
		return paymentInfoDao.getOrderDetaiils(customerId);
	}
	@Override
	public void addPayment(PaymentModel paymentModel){
		 paymentInfoDao.addPayment(paymentModel);
		
	}

	@Override
	public  List<CustomerOrderPayment> getCustomerOrder(String customerId,int orderId,int orderItemSeq, int bill_to_customer_id,String currency	){
		
		return paymentInfoDao.getCustomerOrder(customerId, orderId,orderItemSeq, bill_to_customer_id,currency);
	}
	
	@Override
	public Double getExchangeRate(String currency){
		
		return paymentInfoDao.getExchangeRate(currency);
	}
	
	
	@Override
	public PaymentModel selectPaymentDetails(int customerId,int paymentSeq){
		
		return paymentInfoDao.selectPaymentDetails(customerId,paymentSeq);
	}
	
	@Override
	public  int updatePayment(PaymentModel payementModel){
		
		return paymentInfoDao.updatePayment(payementModel);
	}
	@Override
	public List<PaybreakModel> paymentBreakdown(int paymentSeq,int customerId){
		
		return paymentInfoDao.paymentBreakdown(paymentSeq,customerId);
	}
     public List<OrderDetailsModel> viewOrderItemsList(int orderhdr_id, int order_item_seq, int customer_id){
		return paymentInfoDao.viewOrderItemsList(orderhdr_id,order_item_seq,customer_id);
	}
     @Override
     public List<CustomerOrderPayment> viewOrderItemsListForDepPay(int customer_id, int orderId, int orderItemSeq){
 		return paymentInfoDao.viewOrderItemsListForDepPay(customer_id,orderId,orderItemSeq);
 	}
	
	@Override
	public List<Map<String, Object>> getPaymentAmount(int paymentSeq,int customerId){
		
		return paymentInfoDao.getPaymentAmount(paymentSeq,customerId);
	}
	@Override
	public List<Map<String, Object>> getDepositSummary(int customer_id){
		
		return paymentInfoDao.getDepositSummary(customer_id);
	}
	@Override
	public List<Map<String, Object>> getOrderItemsDetails(int customerId,int paymentSeq, int orderItemSeq){
		
		return paymentInfoDao.getOrderItemsDetails(customerId,paymentSeq,orderItemSeq);
	}
	@Override
	public List<Map<String, Object>> getOrderItemsDetailsEditPage(int customerId,int paymentSeq){
		
		return paymentInfoDao.getOrderItemsDetailsEditPage(customerId,paymentSeq);
	}
	
	@Override
	public Double getUnpaidAmount(int customerId){
		
		return paymentInfoDao.getUnpaidAmount(customerId);
	}
	
	@Override
	public List<Map<String, Object>> getdefaultCurrency(int customerId){
		
		return paymentInfoDao.getdefaultCurrency(customerId);
	}
	@Override
	public List<Map<String, Object>> partialPaymentDetails(int customerId,int orderId){
		
		return paymentInfoDao.partialPaymentDetails(customerId,orderId);
	}
	@Override
	public List<CustomerOrderPayment> getOrdreFilterDropDownResult(int customerId,String balancedue,String payer,String recipient){
		
		return paymentInfoDao.getOrdreFilterDropDownResult(customerId,balancedue,payer,recipient);
	}
	@Override
	public List<Map<String, Object>> getDepositDetails(int customerId){
		
		return paymentInfoDao.getDepositDetails(customerId);
	}
	
	@Override
	public double fetchPayAmount(int customerId,int orderId, int bill_to_customer_id){
		
		return paymentInfoDao.fetchPayAmount(customerId,orderId,bill_to_customer_id);
	}
	
	@Override
	public List<JournalDepositModel> getDepositDetailsfromJournal(int customerId){
		
		return paymentInfoDao.getDepositDetailsfromJournal(customerId);
	}
	@Override
	public List<Map<String, Object>> getWithdrawalDetails(int customerId){
		
		return paymentInfoDao.getWithdrawalDetails(customerId);
	}
	@Override
	public boolean depositSave(PaymentModel payementModel){
		
		 return paymentInfoDao.depositSave(payementModel);
	}
	@Override
	public List<Map<String, Object>> searchLookupOrder(OrderItem orderItem,String firstName,String lastName){
		
		 return paymentInfoDao.searchLookupOrder(orderItem,firstName,lastName);
	}
	@Override
	public List<Map<String, Object>>getReviewPayments(int orderId,int orderItemSeq){
		
		 return paymentInfoDao.getReviewPayments(orderId,orderItemSeq);
	}
	@Override
	public List<Map<String, Object>>getPayerCustomerAddressForEdit(int customerId, int paymentSeq){
		
		 return paymentInfoDao.getPayerCustomerAddressForEdit( customerId,  paymentSeq);
	}
	/*@Override
	public List<Map<String, Object>> getCurrentOrderforPayment(String customerId,int orderId){
		
		return paymentInfoDao.getCurrentOrderforPayment(customerId,orderId);
	}*/
	public List<Map<String, Object>> viewDepositBalance(int customer_id){
		
		 return paymentInfoDao.viewDepositBalance(customer_id);
	}
	public List<DropdownModel> getTransactionReason(){
		 return paymentInfoDao.getTransactionReason();
	}
	@Override
	public List<Map<String, Object>> getPaymentThresholdData(int orderId, int orderItemSeq) {
		return paymentInfoDao.getPaymentThresholdData(orderId,orderItemSeq);
	}
	@Override
	public List<Map<String, Object>> getThresholdSettingOptions() {
		return paymentInfoDao.getThresholdSettingOptions();
	}
	@Override
	public List<Object> getPaymentHistory(Long customerId, int paymentSeq) throws SQLException {
		return paymentInfoDao.getPaymentHistory(customerId,paymentSeq);
	}
	
	@Override
	public Boolean checkNoteExist(int customer_id, int payment_seq){
		return paymentInfoDao.checkNoteExistOnPayment(customer_id, payment_seq);
	}
	/*@Override
	public List<Map<String, Object>> getPaymentAccountDetails(Long customerId) {
		// TODO Auto-generated method stub
		return paymentInfoDao.getPaymentAccountDetails(customerId);
	}*/
	
	@Override
	public List<Map<String,Object>> getOrderInformation(int orderhdr_id,int order_item_seq) {
		return paymentInfoDao.getOrderInformation(orderhdr_id,order_item_seq);
	}
	
	@Override
	public List<OrderItemAccountModel>  getorderAccBreakType( int orderhdr_id,int order_item_seq) {
		return paymentInfoDao.getorderAccBreakType(orderhdr_id,order_item_seq);
	}
	@Override
	public List<Map<String, Object>> getAddCustomerDistAddress(int customer_id) {
		return paymentInfoDao.getAddCustomerDistAddress(customer_id);
	}
	@Override
	public List<Map<String, Object>> getDistributionCustomerAddrs(int customer_id, int customer_address_seq) {
		return paymentInfoDao.getDistributionCustomerAddrs(customer_id,customer_address_seq);
	}
	@Override
	public List<Map<String, Object>> getThresholdSettingOptionsWsdl() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<DropdownModel> getpaymentAccountList(int payerCustomer) {
		return paymentInfoDao.getpaymentAccountList(payerCustomer);
	}
	@Override
	public List<PaymentReview> getReviewAccountJournal(int order_item_seq,int orderhdr_id) {
		return paymentInfoDao.getReviewAccountJournal(order_item_seq,orderhdr_id);
	}
	@Override
	public  List<Map<String,Object>> getReviewOrderItemDetails(int orderhdr_id,int orderItemseq) {
		return paymentInfoDao. getReviewOrderItemDetails (orderhdr_id,orderItemseq);
	}
	@Override
	public List<DropdownModel> getOrderList(int paymentSeq, int customerId) {
			return paymentInfoDao.getOrderList(paymentSeq, customerId);
	}
	@Override
	public List<PaybreakModel> getpaymentBreakdownBasedOnOrderCode(int orderhdr_id, int order_item_seq) {
	
		return paymentInfoDao.getPaymentBreakDownBasedOnOrderCode(orderhdr_id, order_item_seq);
	}
	@Override
	public List<Map<String, Object>> getDefaultValuesOnPaymentTypeChange(String payment_type, int payerCustomer) {
		
		return paymentInfoDao.getDefaultValuesOnPaymentTypeChange(payment_type, payerCustomer);
	}
	@Override
	public List<DropdownModel> getCurrency() {
		return paymentInfoDao.getCurrency();
	}
	@Override
	public List<DropdownModel> getdefaultPaymentAccountSeq(int payerCustomer, int payment_seq) {
		
		return paymentInfoDao.getdefaultPaymentAccountSeq( payerCustomer, payment_seq);
	}
	
	@Override
	public List<Map<String, Object>> getpaymentSelectedProcessing(int customer_id, int payment_seq) {
		return paymentInfoDao.getpaymentSelectedProcessing( customer_id,payment_seq);
	}
	@Override
	public String getDefaultPaymentType() {
		return paymentInfoDao.getDefaultPaymentType();
	}
	@Override
	public Integer getOverPaymentHandling() {
		return paymentInfoDao.getOverPaymentHandling();
	}
	@Override
	public List<Map<String, Object>> getdefaultCurrencyinEditPayment(int customer_id, int payment_seq) {
		
		return paymentInfoDao.getdefaultCurrencyinEditPayment(customer_id,payment_seq);
	}
	@Override
	public String getUnderPaymentOption() {
		return paymentInfoDao.getUnderPaymentOption();
	}
	@Override
	public double getDeliveryAmount() {
		return paymentInfoDao.getDeliveryAmount();
	}
	@Override
	public String getPaymentTypeForCustomer(int customer_id) {
		return paymentInfoDao.getPaymentTypeForCustomer(customer_id);
	}
	@Override
	public List<DropdownModel> currencyList(int customerId) {
		return   paymentInfoDao.currencyList(customerId);
	}
	@Override
	public List<TotalDepositSummaryModel> getTotalDepositList(int customerId) {
		return  paymentInfoDao.getTotalDepositList(customerId);
	}
	@Override
	public List<DropdownModel> getDefaultPaymentTypeInfo() {
		return paymentInfoDao.getDefaultPaymentTypeInfo();
	}
	@Override
	public List<DropdownModel> getPaymentType(int customer_id) {
		
		return paymentInfoDao.getPaymentType(customer_id);
	}
	@Override
	public List<DropdownModel> getdefaultPaymentAccountSeqInMake(int payerCustomer) {
		return paymentInfoDao.getdefaultPaymentAccountSeqInMake(payerCustomer);
	}
	@Override
	public List<Map<String, Object>> getdefaultCurrencyFromConfig() {
		return paymentInfoDao.getdefaultCurrencyFromConfig();
	}
	@Override
	public String getCreditCardNumber(int customer_id, int payment_seq) {
		return paymentInfoDao.getCreditCardNumber(customer_id,payment_seq);
	}
	
	


}

