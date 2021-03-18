package com.mps.think.model;

import java.util.LinkedHashMap;

public class CustomerAuxiliaryModel {
	
	private String tableName;
	private String columnName;
	private String columnTitle;
	private String columnDatatype;
	private String columnLength;
	private String columnPrecision;
	private String rowVersion;
	private String valueList;
	private String lookupTableName;
	private String lookupDisplayColumnName;
	private String lookupValueColumnName;
	private String renewCarryOver;
	private String custsvcEditDisposition;
	private String defaultValue;
	private String useDatePicker;
	private LinkedHashMap<String, String> values;	
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnTitle() {
		return columnTitle;
	}
	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle;
	}
	public String getColumnDatatype() {
		return columnDatatype;
	}
	public void setColumnDatatype(String columnDatatype) {
		this.columnDatatype = columnDatatype;
	}
	public String getColumnLength() {
		return columnLength;
	}
	public void setColumnLength(String columnLength) {
		this.columnLength = columnLength;
	}
	public String getColumnPrecision() {
		return columnPrecision;
	}
	public void setColumnPrecision(String columnPrecision) {
		this.columnPrecision = columnPrecision;
	}
	public String getRowVersion() {
		return rowVersion;
	}
	public void setRowVersion(String rowVersion) {
		this.rowVersion = rowVersion;
	}
	public String getValueList() {
		return valueList;
	}
	public void setValueList(String valueList) {
		this.valueList = valueList;
	}
	public String getLookupTableName() {
		return lookupTableName;
	}
	public void setLookupTableName(String lookupTableName) {
		this.lookupTableName = lookupTableName;
	}
	public String getLookupDisplayColumnName() {
		return lookupDisplayColumnName;
	}
	public void setLookupDisplayColumnName(String lookupDisplayColumnName) {
		this.lookupDisplayColumnName = lookupDisplayColumnName;
	}
	public String getLookupValueColumnName() {
		return lookupValueColumnName;
	}
	public void setLookupValueColumnName(String lookupValueColumnName) {
		this.lookupValueColumnName = lookupValueColumnName;
	}
	public String getRenewCarryOver() {
		return renewCarryOver;
	}
	public void setRenewCarryOver(String renewCarryOver) {
		this.renewCarryOver = renewCarryOver;
	}
	public String getCustsvcEditDisposition() {
		return custsvcEditDisposition;
	}
	public void setCustsvcEditDisposition(String custsvcEditDisposition) {
		this.custsvcEditDisposition = custsvcEditDisposition;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getUseDatePicker() {
		return useDatePicker;
	}
	public void setUseDatePicker(String useDatePicker) {
		this.useDatePicker = useDatePicker;
	}
	public LinkedHashMap<String, String> getValues() {
		return values;
	}
	public void setValues(LinkedHashMap<String, String> values) {
		this.values = values;
	}
			
}
