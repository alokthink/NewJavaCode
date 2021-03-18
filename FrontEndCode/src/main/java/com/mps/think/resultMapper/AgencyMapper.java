package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.AgencyAttributeModel;

public class AgencyMapper implements RowMapper<AgencyAttributeModel> {
	
	@Override
	public AgencyAttributeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		AgencyAttributeModel agencyAttributeModel = new AgencyAttributeModel();
		agencyAttributeModel.setCustomerId(rs.getLong("customer_id"));
		agencyAttributeModel.setAcceptOrd(rs.getString("accept_ord"));
		agencyAttributeModel.setIsBillTo(rs.getInt("agency_bill_to"));
		agencyAttributeModel.setAgencyCode(rs.getString("agency_code"));
		agencyAttributeModel.setAgencyPayTax(rs.getString("agency_pays_tax"));
		agencyAttributeModel.setIsRenewTo(rs.getInt("agency_renew_to"));
		agencyAttributeModel.setCompany(rs.getString("company"));
		agencyAttributeModel.setBundleDiscount(rs.getString("discounts"));
		agencyAttributeModel.setNewOrderCommission(rs.getDouble("new_commission"));
		agencyAttributeModel.setPaymentThershold(rs.getString("payment_threshold"));
		agencyAttributeModel.setRemits(rs.getInt("remit"));
		agencyAttributeModel.setRenewalCommission(rs.getDouble("ren_commission"));
		agencyAttributeModel.setRowVersion(rs.getString("row_version"));
		agencyAttributeModel.setTaxPayedOnGross(rs.getInt("tax_based_on_gross"));
		return agencyAttributeModel;
	}

}
