package com.mps.think.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

public interface PaymentService {
	public List<DropdownModel> getPaymentType();
	public List<DropdownModel> getPayerCustomer(int customerId,int orderId);
	public List<DropdownModel> getPayerCustomerAddress(int customer_id);
	public List<Map<String, Object>> getCurrencyType();
	public List<PaymentModel> getAllPayment(String customerId,int filterDropdown, String orderhdrId);
	public List<Map<String, Object>> getPaymentAccount();
	public PaymentModel getCustomerDetailsForPayment(String customerId);
	public List<Map<String, Object>> getOrderDetaiils(String customerId);
	public void addPayment(PaymentModel payementModel)throws SQLException;
	public List<CustomerOrderPayment> getCustomerOrder(String customerId,int orderhrdId,int orderItemSeq, int bill_to_customer_id,String currency);
	public Double getExchangeRate(String currency);
	public PaymentModel selectPaymentDetails(int customerId,int paymentSeq);
	public int updatePayment(PaymentModel payementModel);
	public List<PaybreakModel> paymentBreakdown(int paymentSeq,int customerId);
	public List<Map<String, Object>> getPaymentAmount(int paymentSeq,int customerId);
	public List<Map<String, Object>> getDepositSummary(int customerId);
	public List<Map<String, Object>> getOrderItemsDetails(int customerId, int paymentSeq, int orderItemSeq);
	public List<Map<String, Object>> getOrderItemsDetailsEditPage(int customerId,int paymentSeq);
	public Double getUnpaidAmount(int customerId);
	public List<Map<String, Object>> getdefaultCurrency(int customerId);
	public List<Map<String, Object>> partialPaymentDetails(int customerId,int orderId);
	public List<CustomerOrderPayment> getOrdreFilterDropDownResult(int customerId,String balancedue,String payer,String recipient);
	public List<Map<String, Object>> getDepositDetails(int customerId);
	public double fetchPayAmount(int customerId,int orderId, int bill_to_customer_id);
	public List<JournalDepositModel> getDepositDetailsfromJournal(int customerId);
	public boolean depositSave(PaymentModel payementModel);
	public List<Map<String, Object>> searchLookupOrder(OrderItem OrderItem,String firstName,String lastName);
	public List<Map<String, Object>> getReviewPayments(int orderId, int orderItemSeq);
	//public List<Map<String, Object>> getCurrentOrderforPayment(String customerId,int orderId);
	public List<Map<String, Object>> getPayerCustomerAddressForEdit(int customerId, int paymentSeq);
	public List<Map<String, Object>> getWithdrawalDetails(int customerId);
	public List<OrderDetailsModel> viewOrderItemsList(int orderhdr_id, int order_item_seq, int customer_id);
	public List<Map<String, Object>> viewDepositBalance(int customer_id);
	public List<DropdownModel> getTransactionReason();
	public List<CustomerOrderPayment> viewOrderItemsListForDepPay(int customer_id, int orderId, int orderItemSeq);
	public List<Map<String, Object>> getPaymentThresholdData(int orderId,int orderItemSeq);
	public List<Map<String, Object>> getThresholdSettingOptions();
	public List<Object> getPaymentHistory(Long customerId, int paymentSeq) throws SQLException;
	public Boolean checkNoteExist(int customer_id, int payment_seq);
	//public List<Map<String,Object>> getPaymentAccountDetails(Long customerId);
	//public List<Map<String,Object>> getReviewAccountingJournal(int order_item_seq,int orderhdr_id);
	public List<Map<String, Object>> getOrderInformation(int orderhdr_id,int order_item_seq);
	public List<OrderItemAccountModel> getorderAccBreakType(int orderhdr_id,int order_item_seq );
	public List<Map<String, Object>> getAddCustomerDistAddress(int customer_id);
	public List<Map<String, Object>> getDistributionCustomerAddrs(int customer_id, int customer_address_seq);
	public List <Map<String, Object>> getThresholdSettingOptionsWsdl();
	public List<DropdownModel> getpaymentAccountList(int customer_id);
	public  List<Map<String, Object>> getReviewOrderItemDetails(int orderhdr_id,int orderItemSeq);
	public List<PaymentReview> getReviewAccountJournal(int order_item_seq,int orderhdr_id);
	public List<DropdownModel> getOrderList(int paymentSeq, int customerId);
	 public List<PaybreakModel> getpaymentBreakdownBasedOnOrderCode(int orderhdr_id, int order_item_seq);
	public List<Map<String, Object>> getDefaultValuesOnPaymentTypeChange(String payment_type, int payerCustomer);
	public List<DropdownModel> getCurrency();
	public List<DropdownModel> getdefaultPaymentAccountSeq(int customer_id, int payment_seq);
	public List<Map<String, Object>> getpaymentSelectedProcessing(int customer_id, int i);
	public String getDefaultPaymentType();
	public Integer getOverPaymentHandling();
	public List<Map<String, Object>> getdefaultCurrencyinEditPayment(int customer_id, int customer_id2);
	public String getUnderPaymentOption();
	public double getDeliveryAmount();
	public String getPaymentTypeForCustomer(int customer_id);
	 
	public List<DropdownModel>  currencyList(int customerId);
	
	public List<TotalDepositSummaryModel> getTotalDepositList(int customerId);
	public List<DropdownModel> getDefaultPaymentTypeInfo();
	public List<DropdownModel> getPaymentType(int customer_id);
	public List<DropdownModel> getdefaultPaymentAccountSeqInMake(int payerCustomer);
	public List<Map<String, Object>> getdefaultCurrencyFromConfig();
	public String getCreditCardNumber(int customer_id, int payment_seq);

	
	
	


}
