package com.mps.think.model;

public class CustomerDetails {
	private long customerId;
	private String defaultBillToCustomerId;
	private String defBillToCustAddrSeq;
	private String defaultRenewToCustomerId;
	private String defRenewToCustAddrSeq;
	private String mruCustomerAddressSeq;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getDefaultBillToCustomerId() {
		return defaultBillToCustomerId;
	}
	public void setDefaultBillToCustomerId(String defaultBillToCustomerId) {
		this.defaultBillToCustomerId = defaultBillToCustomerId;
	}
	public String getDefBillToCustAddrSeq() {
		return defBillToCustAddrSeq;
	}
	public void setDefBillToCustAddrSeq(String defBillToCustAddrSeq) {
		this.defBillToCustAddrSeq = defBillToCustAddrSeq;
	}
	public String getDefaultRenewToCustomerId() {
		return defaultRenewToCustomerId;
	}
	public void setDefaultRenewToCustomerId(String defaultRenewToCustomerId) {
		this.defaultRenewToCustomerId = defaultRenewToCustomerId;
	}
	public String getDefRenewToCustAddrSeq() {
		return defRenewToCustAddrSeq;
	}
	public void setDefRenewToCustAddrSeq(String defRenewToCustAddrSeq) {
		this.defRenewToCustAddrSeq = defRenewToCustAddrSeq;
	}
	public String getMruCustomerAddressSeq() {
		return mruCustomerAddressSeq;
	}
	public void setMruCustomerAddressSeq(String mruCustomerAddressSeq) {
		this.mruCustomerAddressSeq = mruCustomerAddressSeq;
	}
	@Override
	public String toString() {
		return "CustomerDetails [customerId=" + customerId + ", defaultBillToCustomerId=" + defaultBillToCustomerId
				+ ", defBillToCustAddrSeq=" + defBillToCustAddrSeq + ", defaultRenewToCustomerId="
				+ defaultRenewToCustomerId + ", defRenewToCustAddrSeq=" + defRenewToCustAddrSeq
				+ ", mruCustomerAddressSeq=" + mruCustomerAddressSeq + "]";
	}

	
}
