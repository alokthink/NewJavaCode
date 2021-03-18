package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.CustomerAddressModel;

public class CustomerAddressMapper implements RowMapper<CustomerAddressModel> {

	@Override
	public CustomerAddressModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerAddressModel customerAddressModel = new CustomerAddressModel();

		customerAddressModel.setAddress1(rs.getString("address1"));
		customerAddressModel.setAddress2(rs.getString("address2"));
		customerAddressModel.setAddress3(rs.getString("address3"));
		customerAddressModel.setAddressStatus(rs.getString("address_status"));
		customerAddressModel.setAddressType(rs.getString("address_type"));
		customerAddressModel.setAuditCompanyId(rs.getLong("audit_company_id"));
		customerAddressModel.setAuditCounty(rs.getString("audit_county"));
		customerAddressModel.setAuditNameChange(rs.getInt("audit_name_change"));
		customerAddressModel.setAuditTitleChange(rs.getInt("audit_title_change"));
		customerAddressModel.setCarrier(rs.getString("carrier"));
		customerAddressModel.setCassDate(rs.getLong("cass_date"));
		customerAddressModel.setChangeType(rs.getString("change_type"));
		customerAddressModel.setCity(rs.getString("city"));
		customerAddressModel.setCompany(rs.getString("company"));
		customerAddressModel.setCounty(rs.getString("county"));
		// customerAddressModel.setCusCustomerAddressSeq2(rs.getLong("cus_customer_address_seq2"));
		// customerAddressModel.setCusCustomerId2(rs.getLong("cus_customer_id2"));
		customerAddressModel.setCustomerAddressSeq(rs.getInt("customer_address_seq"));
		customerAddressModel.setCustomerId(rs.getLong("customer_id"));
		customerAddressModel.setDeliveryPoint(rs.getString("delivery_point"));
		customerAddressModel.setDepartment(rs.getString("department"));
		customerAddressModel.setDpBarcode(rs.getString("dp_barcode"));
		customerAddressModel.setEffectiveDate(rs.getString("effective_date"));
		customerAddressModel.setEighthundred(rs.getString("eighthundred"));
		customerAddressModel.setEmail(rs.getString("email"));
		customerAddressModel.setFaxnbr(rs.getString("faxnbr"));
		customerAddressModel.setFname(rs.getString("fname"));
		customerAddressModel.setIgnoredClean(rs.getInt("ignored_clean"));
		customerAddressModel.setInitialName(rs.getString("initial_name"));
		customerAddressModel.setInstitutionalIdentifier(rs.getString("institutional_identifier"));
		customerAddressModel.setLname(rs.getString("lname"));
		customerAddressModel.setLotNbr(rs.getString("lot_nbr"));
		customerAddressModel.setMailstop(rs.getString("mailstop"));
		customerAddressModel.setOldEmail(rs.getString("old_email"));
		customerAddressModel.setPhone(rs.getString("phone"));
		customerAddressModel.setReplaceCustomerAddressSeq(rs.getLong("replace_customer_address_seq"));
		customerAddressModel.setReverseDate(rs.getString("reverse_date"));
		customerAddressModel.setRowVersion(rs.getString("row_version"));
		customerAddressModel.setSalutation(rs.getString("salutation"));
		customerAddressModel.setSpecialTaxId(rs.getInt("special_tax_id"));
		customerAddressModel.setState(rs.getString("state"));
		customerAddressModel.setSuffix(rs.getString("suffix"));
		customerAddressModel.setSuppClean(rs.getInt("supp_clean"));
		customerAddressModel.setTaxIdNumber(rs.getString("tax_id_number"));
		customerAddressModel.setTitle(rs.getString("title"));
		customerAddressModel.setZip(rs.getString("zip"));
		return customerAddressModel;
	}

}
