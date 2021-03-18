package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.daoImpl.PaymentInfoDaoImpl;
import com.mps.think.model.JournalDepositModel;
import com.mps.think.util.PropertyUtilityClass;

public class JournalDepositMapper implements RowMapper<JournalDepositModel> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentInfoDaoImpl.class);
	private static final String ERROR = "Error"; 
	@Override
	public JournalDepositModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		JournalDepositModel journalDepositModel = new JournalDepositModel();
		try{
			journalDepositModel.setCustomerId(rs.getInt("customer_id"));
			journalDepositModel.setPaymentSeq(rs.getInt("payment_seq"));
			journalDepositModel.setCreditAccount(rs.getInt("credit_account"));
			journalDepositModel.setDebitAccount(rs.getInt("debit_account"));
			journalDepositModel.setAmount(rs.getFloat("amount"));
			journalDepositModel.setCreditAccountDesc(new PropertyUtilityClass().getConstantValue("journal_deposit_credit_account_"+rs.getString("credit_account")));
			journalDepositModel.setDebitAccountDesc(new PropertyUtilityClass().getConstantValue("journal_deposit_debit_account_"+rs.getString("debit_account")));
			journalDepositModel.setPostingReferenceDesc(new PropertyUtilityClass().getConstantValue("journal_deposit_posting_reference_"+rs.getString("posting_reference")));
			
		}catch(Exception e){
			LOGGER.error(ERROR + e);
		}
		return journalDepositModel;
	}
}
