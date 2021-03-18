package com.mps.think.dao;

import java.sql.SQLException;
import java.util.List;
import com.mps.think.model.CancelOrderAttributeModel;
import com.mps.think.model.CancelOrderDetailsModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.ExistingUnpaidOrdersModel;
import com.mps.think.model.RenewableItemsModel;
import Think.XmlWebServices.Refund_calculate_response;

public interface CancelOrderDao {
	
	public List<DropdownModel> getcategory();
	public List<DropdownModel> getReasonList()
			throws SQLException;
	public List<DropdownModel> getCurrencyTypeList()
			throws SQLException;
	public List<DropdownModel> getPaymentTypeList()
			throws SQLException;
	public List<DropdownModel> getCancellationRenewalStatusList();
	public List<CancelOrderDetailsModel> getOrderDetail(Long orderHdrId,int orderItemSeq) 
			throws SQLException;
	public Refund_calculate_response getRefundAmount(Long orderHdrId,int orderItemSeq);
	public String cancelOrder(CancelOrderAttributeModel cancelOrderAttributeModel);
	public boolean getPaymentAccountFlag(Long customerId);
	public List<DropdownModel> getPaymentAccountList(Long customerId);
	public String getCustomerName(Long customerId);
	public String getSelectedOrder(Long orderHdrId,int orderItemSeq);
	public String getPaymentType(Long orderHdrId, int orderItemSeq);
	public String retrievePaymentTypeToCancelOrderFromDataSource();
	public int getNoOfSubscripIdInOrder(int subscripId);
	public List<CancelOrderDetailsModel> getEntireSubOrderDetail(int subscripId);
	public String getBalanceDueFromDataSource(int customer_id);
	public String getDepositAmountFromDataSource(int cancelled_order_id);
	public List<ExistingUnpaidOrdersModel> getListOfExistingUnpaidOrdersFromDataSource(int customer_id,CancelOrderAttributeModel cancelOrderAttributeModel);
	public String returnProductDAO(CancelOrderAttributeModel cancelOrderAttributeModel);
	public List<RenewableItemsModel> getListOfRenewableItemsFromDataSource(CancelOrderAttributeModel cancelOrderAttributeModel);

}
