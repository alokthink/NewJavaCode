package com.mps.think.resultMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.daoImpl.PaymentInfoDaoImpl;
import com.mps.think.model.PaymentModel;
import com.mps.think.util.PropertyUtilityClass;



public class PaymentMapper implements RowMapper<PaymentModel>{
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentInfoDaoImpl.class);
	private static final String ERROR = "Error"; 
	@Override
	public PaymentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		PaymentModel paymentModel = new PaymentModel();
		try{
			paymentModel.setCustomer_id(rs.getInt("customer_id"));
			// paymentModel.setBill_to_customer_id(rs.getInt("bill_to_customer_id"));
			paymentModel.setPayment_seq(rs.getInt("payment_seq"));
			paymentModel.setUser_code(rs.getString("user_code"));
			paymentModel.setCreation_date(rs.getString("creation_date"));
			paymentModel.setPayment_type(rs.getString("payment_type"));
			paymentModel.setPayment_clear_status(new PropertyUtilityClass().getConstantValue("payment_satus.payment_clear_status_"+rs.getString("payment_clear_status")));
			paymentModel.setTransaction_reason(rs.getString("transaction_reason"));
			paymentModel.setCurrency(rs.getString("currency"));	
			paymentModel.setPayAmount(rs.getDouble("pay_currency_amount"));
			//paymentModel.setTransaction_type(rs.getString("transaction_type"));
			paymentModel.setTransaction_type(new PropertyUtilityClass().getConstantValue("payment.tran_type_desc_"+rs.getString("transaction_type")));
			paymentModel.setCheck_number(rs.getString("check_number"));
			paymentModel.setBase_amount(rs.getDouble("base_amount"));
			paymentModel.setPaymentClearStatusDesc(rs.getString("payment_clear_status"));
			paymentModel.setCustomer_deposit_pay_amt(rs.getString("customer_deposit_pay_amt"));
			//select customer_id,payment_seq,user_code,is_reversed,creation_date,user_code,transaction_type,payment_type,currency,payment_clear_status,pay_currency_amount,transaction_reason,check_number from payment where customer_id =?";
			paymentModel.setIs_reversed(rs.getInt("is_reversed"));
			paymentModel.setPayAmount(rs.getDouble("pay_currency_amount"));
			paymentModel.setPay_currency_amount(rs.getDouble("pay_currency_amount"));
			paymentModel.setCredit_card_info(rs.getString("credit_card_info"));
			paymentModel.setCard_verification_value(rs.getString("card_verification_value"));
			paymentModel.setCreditCardStartDate(rs.getString("credit_card_start_date").equals("1900-01-01 00:00:00.0")?null : rs.getString("credit_card_start_date"));
			paymentModel.setCredit_card_issue_id(rs.getString("credit_card_issue_id"));
			paymentModel.setAuth_date(rs.getString("auth_date").equals("1900-01-01 00:00:00.0")?null : rs.getString("auth_date"));
			paymentModel.setAuth_code(rs.getString("auth_code"));
			paymentModel.setRef_nbr(rs.getString("ref_nbr"));
			paymentModel.setClear_date(rs.getString("clear_date").equals("1900-01-01 00:00:00.0")?null : rs.getString("clear_date"));
			paymentModel.setN_settle_retries_left(rs.getString("n_settle_retries_left"));
			paymentModel.setNextSettleRetryDate(rs.getString("next_settle_retry_date"));
			paymentModel.setEffort_nbr(rs.getInt("effort_nbr"));
			//paymentModel.setCurrencyType(rs.getString("currency"));
			paymentModel.setPay_exchange_rate(rs.getDouble("pay_exchange_rate"));
			paymentModel.setExp_date(rs.getString("exp_date").equals("1900-01-01 00:00:00.0")?null : rs.getString("exp_date"));
		}catch(Exception e){
			LOGGER.error(ERROR + e);
		}
		return paymentModel;
	}

}
