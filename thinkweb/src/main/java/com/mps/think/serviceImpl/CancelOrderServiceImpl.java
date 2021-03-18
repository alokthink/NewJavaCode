package com.mps.think.serviceImpl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.dao.CancelOrderDao;
import com.mps.think.model.CancelOrderAttributeModel;
import com.mps.think.model.CancelOrderDetailsModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.ExistingUnpaidOrdersModel;
import com.mps.think.model.RenewableItemsModel;
import com.mps.think.service.CancelOrderService;

import Think.XmlWebServices.Refund_calculate_response;

@Service("CancelOrderService")
public class CancelOrderServiceImpl implements CancelOrderService {
	
	@Autowired
	CancelOrderDao cancelOrderDao;

	@Override
	public List<DropdownModel> getcategory() {
		return cancelOrderDao.getcategory();
	}

	@Override
	public List<DropdownModel> getReasonList() throws SQLException {
		return cancelOrderDao.getReasonList();
	}

	@Override
	public List<DropdownModel> getCurrencyTypeList() throws SQLException {
		return cancelOrderDao.getCurrencyTypeList();
	}

	@Override
	public List<DropdownModel> getPaymentTypeList() throws SQLException {
		return cancelOrderDao.getPaymentTypeList();
	}

	@Override
	public List<DropdownModel> getCancellationRenewalStatusList() {
		return cancelOrderDao.getCancellationRenewalStatusList();
	}

	@Override
	public List<CancelOrderDetailsModel> getOrderDetail(Long orderHdrId, int orderItemSeq) throws SQLException {
		return cancelOrderDao.getOrderDetail(orderHdrId, orderItemSeq);
	}

	@Override
	public Refund_calculate_response getRefundAmount(Long orderHdrId, int orderItemSeq) {
		return cancelOrderDao.getRefundAmount(orderHdrId, orderItemSeq);
	}

	@Override
	public String cancelOrder(CancelOrderAttributeModel cancelOrderAttributeModel) {
		return cancelOrderDao.cancelOrder(cancelOrderAttributeModel);
	}

	@Override
	public boolean getPaymentAccountFlag(Long customerId) {
		return cancelOrderDao.getPaymentAccountFlag(customerId);
	}

	@Override
	public List<DropdownModel> getPaymentAccountList(Long customerId) {
		return cancelOrderDao.getPaymentAccountList(customerId);
	}

	@Override
	public String getCustomerName(Long customerId) {
		return cancelOrderDao.getCustomerName(customerId);
	}

	@Override
	public String getSelectedOrder(Long orderHdrId, int orderItemSeq) {
		return cancelOrderDao.getSelectedOrder(orderHdrId, orderItemSeq);
	}

	@Override
	public String getPaymentType(Long orderHdrId, int orderItemSeq) {
		return cancelOrderDao.getPaymentType(orderHdrId, orderItemSeq);
	}

	@Override
	public String retrievePaymentTypeToCancelOrder() {
		return cancelOrderDao.retrievePaymentTypeToCancelOrderFromDataSource();
	}
	
	@Override
	public int getNoOfSubscripIdInOrder(int subscripId) {
		return cancelOrderDao.getNoOfSubscripIdInOrder(subscripId);
	}

	@Override
	public List<CancelOrderDetailsModel> getEntireSubOrderDetail(int subscripId) {
		return cancelOrderDao.getEntireSubOrderDetail(subscripId);
	}
	
	@Override
	public String getBalanceDue(int customer_id) {
		return cancelOrderDao.getBalanceDueFromDataSource(customer_id);
	}
	
	@Override
	public String getDepositAmount(int cancelled_order_id) {
		return cancelOrderDao.getDepositAmountFromDataSource(cancelled_order_id);
	}
	
	@Override
	public List<ExistingUnpaidOrdersModel> getListOfExistingUnpaidOrders(int customer_id,CancelOrderAttributeModel cancelOrderAttributeModel) {
		return cancelOrderDao.getListOfExistingUnpaidOrdersFromDataSource(customer_id,cancelOrderAttributeModel);
	}

	@Override
	public String returnProduct(CancelOrderAttributeModel cancelOrderAttributeModel) {
		return cancelOrderDao.returnProductDAO(cancelOrderAttributeModel);
	}

	@Override
	public List<RenewableItemsModel> getListOfRenewableItems(CancelOrderAttributeModel cancelOrderAttributeModel) {
		return cancelOrderDao.getListOfRenewableItemsFromDataSource(cancelOrderAttributeModel);
	}

}
