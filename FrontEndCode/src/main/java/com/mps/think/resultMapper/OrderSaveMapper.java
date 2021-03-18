package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.OrderItem;

public class OrderSaveMapper implements RowMapper<OrderItem> {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderSaveMapper.class);

	@Override
	public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderItem orderItem = new OrderItem();

		try{/*
			orderItem.setOrderhdrId(orderhdrId);
			orderItem.setOrderItemSeq(orderItemSeq);
			orderItem.setUserCode(userCode);
			orderItem.setDateStamp(dateStamp);
			orderItem.setOrderItemType(orderItemType);
			orderItem.setOrderDate(orderDate);
			orderItem.setGrossBaseAmount(grossBaseAmount);
			orderItem.setGrossLocalAmount(grossLocalAmount);
			orderItem.setNetBaseAmount(netBaseAmount);
			orderItem.setNetLocalAmount(netLocalAmount);
			orderItem.setHasTax(hasTax);
			orderItem.setHasDeliveryCharge(hasDeliveryCharge);
			orderItem.setBillDate(billDate);
			orderItem.setPaymentStatus(paymentStatus);
			orderItem.setRefundStatus(refundStatus);
			orderItem.setOrderType(orderType);
			orderItem.setHasPremium(hasPremium);
			orderItem.setPrepaymentReq(prepaymentReq);
			orderItem.setProductId(productId);
			orderItem.setIsComplimentary(isComplimentary);
			orderItem.setSubscripStartType();
			orderItem.setDuration(duration);
			orderItem.setRenewalStatus(renewalStatus);
			orderItem.setDeliveryMethodPerm(deliveryMethodPerm);
			orderItem.setChangeQtyFlag(changeQtyFlag);
			orderItem.setnRemainingPaidIssue(nRemainingPaidIssue);
			orderItem.setExtIssleft(extIssleft);
			orderItem.setExtIssTot(extIssTot);
			orderItem.setOrderStatus(orderStatus);
			orderItem.setRenewalCatery(renewalCatery);
			orderItem.setExchangeRate(exchangeRate);
			orderItem.setRateClassId(rateClassId);
			orderItem.setRateClassEffectiveSeq(rateClassEffectiveSeq);
			orderItem.setInventoryId(inventoryId);
			orderItem.setOcId(ocId);
			orderItem.setAutoPayment(autoPayment);
			orderItem.setPerpetualOrder(perpetualOrder);
			orderItem.setBillToCustomerId(billToCustomerId);
			orderItem.setBillToCustomerAddressSeq(billToCustomerAddressSeq);
			orderItem.setRenewToCustomerId();
			orderItem.setRenewToCustomerAddressSeq();
			orderItem.setCustomerId();
			orderItem.setCustomerAddressSeq();
			orderItem.setNoteExist();
			orderItem.setServiceExist();
			orderItem.setMruOrderItemAmtBreakSeq();
			orderItem.setHasBeenRenewed();
			orderItem.setRevenueMethod(0);
			orderItem.setTrialType();
			orderItem.setOrigOrderQty();
			orderItem.setUnitExcess();
			orderItem.setIsProforma();
			orderItem.setNTaxUpdates();
			orderItem.setTotalTaxLocalAmount();
			orderItem.setTotalTaxBaseAmount();
			orderItem.setElectronicDelivery();
			orderItem.setTimeUnitOptions();
			orderItem.setGroupOrder();
			orderItem.setInvoiceDate();
			orderItem.setAutoRenewNotifySent();
			orderItem.setExtendedDays();
			orderItem.setAsynchronousAutoRenew();
			orderItem.setNDaysGraced();
			orderItem.setIsBackOrdered();
			orderItem.setMruGrpMbrItemDtlSeq();	
			orderItem.setOrderCodeID();
			orderItem.setSourceCodeID();
			orderItem.setOrderCodeType();
			orderItem.setOrderClass();
			orderItem.setOrderCode();
			orderItem.setBundleQty();
			orderItem.setOrderQty();
			orderItem.setShipQty();
			orderItem.setBackordQty();
			orderItem.setAmountCharged();
			orderItem.setCurrency();
			orderItem.setDeliveryMethod();
			orderItem.setBillingType();
			
		*/}catch(Exception e){
			LOGGER.info("orderItem : "+e);
		}
		return orderItem;
	}

}
