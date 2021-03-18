package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.Customer;

public class CustomerMapper implements RowMapper<Customer> {
	
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Customer customer = new Customer();
		customer.setCompany(rs.getString("company"));
		customer.setCreationDate(rs.getString("creation_date"));
		customer.setCreditStatus(rs.getString("credit_status"));
		//customer.setCusCustomerId(rs.getLong("cus_customer_id"));
		customer.setCustomerCategory(rs.getString("customer_category"));
		customer.setCustomerId(rs.getLong("customer_id"));
		customer.setDefaultBillToCustomerId(rs.getLong("default_bill_to_customer_id"));
		customer.setDefaultCustAddrSeq(rs.getLong("default_cust_addr_seq"));
		customer.setDefaultRenewToCustomerId(rs.getLong("default_renew_to_customer_id"));
		customer.setDefBillToCustAddrSeq(rs.getLong("def_bill_to_cust_addr_seq"));
		customer.setDefRenewToCustAddrSeq(rs.getLong("def_renew_to_cust_addr_seq"));
		customer.setEmail(rs.getString("email"));
		customer.setEmailAuthorization(rs.getString("email_authorization"));
		customer.setFname(rs.getString("fname"));
		customer.setInactive(rs.getInt("inactive"));
		customer.setInitialName(rs.getString("initial_name"));
		customer.setInstitutionalIdentifier(rs.getString("institutional_identifier"));
		customer.setListRentalCategory(rs.getString("list_rental_category"));
		customer.setLname(rs.getString("lname"));
		//customer.setMruCustGrpMbrHistSeq(rs.getLong("mru_cust_grp_mbr_hist_seq"));
		customer.setMruCustomerAddressSeq(rs.getLong("mru_customer_address_seq"));
		customer.setMruCustomerNoteSeq(rs.getLong("mru_customer_note_seq"));
		customer.setMruCustomerProspectSeq(rs.getLong("mru_customer_prospect_seq"));
		customer.setMruDemographicSeq(rs.getLong("mru_demographic_seq"));
		customer.setMruPaymentSeq(rs.getLong("mru_payment_seq"));
		customer.setMruPromotionHistorySeq(rs.getLong("mru_promotion_history_seq"));
		customer.setMruServiceSeq(rs.getLong("mru_service_seq"));
		customer.setNbrTimesIssued(rs.getInt("nbr_times_issued"));
		customer.setOcId(rs.getLong("oc_id"));
		customer.setOldCustomerId(rs.getString("old_customer_id"));
		customer.setOldEmail(rs.getString("old_email"));
		customer.setParentInstIdentifier(rs.getString("parent_inst_identifier"));
		customer.setProspectOnly(rs.getInt("prospect_only"));
		customer.setRowVersion(rs.getString("row_version"));
		customer.setSalesRepresentativeId(rs.getString("sales_representative_id"));
		customer.setSalutation(rs.getString("salutation"));
		customer.setSuffix(rs.getString("suffix"));
		customer.setTitle(rs.getString("title"));
		customer.setUserCode(rs.getString("user_code"));
		return customer;
		
	}

}
