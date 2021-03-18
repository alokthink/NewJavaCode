package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mps.think.model.PaymentReview;
import com.mps.think.util.PropertyUtilityClass;

public class ReviewAccontingMapper implements org.springframework.jdbc.core.RowMapper<PaymentReview>{
	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewAccontingMapper.class);
	@Override
	public PaymentReview mapRow(ResultSet rs, int rowNum) throws SQLException {
		PaymentReview paymentReview=new PaymentReview();
		try {
			paymentReview.setOrderhdrId(rs.getInt("orderhdr_id"));
			paymentReview.setPostingReference(new PropertyUtilityClass().getConstantValue("journal_deposit_posting_reference_"+rs.getString("posting_reference")));
			paymentReview.setNetAmount(rs.getDouble("net_amount"));
			paymentReview.setTaxAmount(rs.getDouble("tax_amount"));
			paymentReview.setDelAmount(rs.getDouble("del_amount"));
			paymentReview.setComAmount(rs.getDouble("com_amount"));
			paymentReview.setDebitAccount(new PropertyUtilityClass().getConstantValue("journal_deposit_debit_account_"+rs.getString("debit_account")));
			paymentReview.setCreditAccount( new PropertyUtilityClass().getConstantValue("journal_deposit_credit_account_"+rs.getString("credit_account")));
			paymentReview.setOrderItemseq(rs.getInt("order_item_seq"));
			paymentReview.setCustomerId(rs.getString("customer_id")!=null?rs.getString("customer_id").toString():"");
			paymentReview.setQty(rs.getInt("qty"));
			paymentReview.setQtyCreditAccount(new PropertyUtilityClass().getConstantValue("journal_qty_credit_account_"+rs.getString("qty_credit_account")));
			paymentReview.setQtyDebitAccount(new PropertyUtilityClass().getConstantValue("journal_qty_debit_account_"+rs.getString("qty_debit_account")));
			paymentReview.setPaymentSeq(rs.getString("payment_seq")!=null?rs.getString("payment_seq").toString():"");
			paymentReview.setDateStamp(rs.getInt("date_stamp"));
			paymentReview.setJournalId(rs.getInt("journal_id"));
			paymentReview.setRowVersion(rs.getInt("row_version"));
			paymentReview.setJobId(rs.getInt("job_id"));
		}catch(Exception e) {
			LOGGER.info("PaymentReview: "+e);
		}
		return paymentReview;
	}

}
