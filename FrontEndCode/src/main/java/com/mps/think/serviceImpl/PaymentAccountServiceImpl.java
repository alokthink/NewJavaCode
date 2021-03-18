package com.mps.think.serviceImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.dao.PaymentAccountDao;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.PaymentAccountModel;
import com.mps.think.process.util.PropertyUtility;
import com.mps.think.service.PaymentAccountService;

import ch.qos.logback.core.status.Status;
import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;
@Service("PaymentAccountService")
public class PaymentAccountServiceImpl implements PaymentAccountService {

	@Autowired
	PaymentAccountDao paymentAccountDao;

	@Override
	public List<DropdownModel> getpaymentTypeList() throws SQLException {
		return paymentAccountDao.getpaymentTypeList();
	}

	@Override
	public void getCardAddress(Long customerId, PaymentAccountModel paymentAccountModel) throws SQLException {
		paymentAccountDao.getCardAddress(customerId, paymentAccountModel);
	}

	@Override
	public String addPaymentAccount(PaymentAccountModel paymentAccountModel) {
		return paymentAccountDao.addPaymentAccount(paymentAccountModel);
	}

	@Override
	public List<Map<String, Object>> getpaymentAccountList(Long customerId) {
		return paymentAccountDao.getpaymentAccountList(customerId);
	}

	@Override
	public List<DropdownModel> getaddressList(Long customerId) throws SQLException {
		return paymentAccountDao.getaddressList(customerId);
	}

	@Override
	public PaymentAccountModel getPaymentAccountDetails(Long customerId,int payment_account_seq) throws ServiceException {
		return paymentAccountDao.getPaymentAccountDetails(customerId,payment_account_seq);
	}

	@Override
	public int updatePaymentAccountDetails(PaymentAccountModel paymentAccountModel,int paymentAccountSeq) {
		return paymentAccountDao.updatePaymentAccountDetails(paymentAccountModel,paymentAccountSeq);
	}

	@Override
	public String clearPaymentAccount(Long customerId, int paymentAccountSeq) {
		return  paymentAccountDao.clearPaymentAccount(customerId, paymentAccountSeq) ;
	}

	@Override
	public Integer getCreditToggleValue() {
		return paymentAccountDao.getCreditCardToggleValue();
	}

	@Override
	public Integer getBankWizardToggleValue() {
		return paymentAccountDao.getBankWizardToggleValue();
	}

	@Override
	public List<Map<String, Object>> getCreditAccountList(Long customerId, Integer active) {
		return paymentAccountDao.getCreditAccountList(customerId, active);
	}

	@Override
	public List<Map<String, Object>> getDebitAccountList(Long customerId, Integer active) {
		return paymentAccountDao.getDebitAccountList(customerId, active);
	}

}
	
	