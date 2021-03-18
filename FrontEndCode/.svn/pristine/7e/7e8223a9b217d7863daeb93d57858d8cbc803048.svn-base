
package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.CustomerAuxiliaryModel;

public class CustomerAuxiliaryMapper implements RowMapper<CustomerAuxiliaryModel>{
	
	@Override
	public CustomerAuxiliaryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerAuxiliaryModel customerAuxiliaryModel = new CustomerAuxiliaryModel();
		customerAuxiliaryModel.setTableName(rs.getString("table_name"));
		customerAuxiliaryModel.setColumnName(rs.getString("column_name"));
		customerAuxiliaryModel.setColumnTitle(rs.getString("column_title"));
		customerAuxiliaryModel.setColumnDatatype(rs.getString("column_datatype"));
		customerAuxiliaryModel.setColumnLength(rs.getString("column_length"));
		customerAuxiliaryModel.setColumnPrecision(rs.getString("column_precision"));
		customerAuxiliaryModel.setRowVersion(rs.getString("row_version"));
		customerAuxiliaryModel.setValueList(rs.getString("value_list"));
		customerAuxiliaryModel.setLookupTableName(rs.getString("lookup_table_name"));
		customerAuxiliaryModel.setLookupDisplayColumnName(rs.getString("lookup_display_column_name"));
		customerAuxiliaryModel.setLookupValueColumnName(rs.getString("lookup_value_column_name"));
		customerAuxiliaryModel.setRenewCarryOver(rs.getString("renew_carry_over"));
		customerAuxiliaryModel.setCustsvcEditDisposition(rs.getString("custsvc_edit_disposition"));
		customerAuxiliaryModel.setDefaultValue(rs.getString("default_value"));
		customerAuxiliaryModel.setUseDatePicker(rs.getString("use_date_picker"));
		LinkedHashMap<String, String> values =new LinkedHashMap<String, String>();
		if(customerAuxiliaryModel.getValueList()!=null) {
			List<String> splitList = new ArrayList<String>(Arrays.asList(customerAuxiliaryModel.getValueList().split(",")));
			for (String value : splitList) {
				values.put(value, value);
				}
			customerAuxiliaryModel.setValues(values);
		}			
		return customerAuxiliaryModel;
	}

}
