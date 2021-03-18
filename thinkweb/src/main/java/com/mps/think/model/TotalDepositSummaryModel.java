package com.mps.think.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TotalDepositSummaryModel {

//private String balanceAvailable;;
//private String initialDeposit;
	private String totalWithDrawlAmount;
	
	private String InitialDeposit;
	private String BalanceDeposit;
	private String InitialDepositbase;
	private String BalanceDepositbase;
	private String currency;
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getInitialDeposit() {
		return InitialDeposit;
	}

	public void setInitialDeposit(String initialDeposit) {
		InitialDeposit = initialDeposit;
	}

	public String getBalanceDeposit() {
		return BalanceDeposit;
	}

	public void setBalanceDeposit(String balanceDeposit) {
		BalanceDeposit = balanceDeposit;
	}

	public String getInitialDepositbase() {
		return InitialDepositbase;
	}

	public void setInitialDepositbase(String initialDepositbase) {
		InitialDepositbase = initialDepositbase;
	}

	public String getBalanceDepositbase() {
		return BalanceDepositbase;
	}

	public void setBalanceDepositbase(String balanceDepositbase) {
		BalanceDepositbase = balanceDepositbase;
	}

	public String getTotalWithDrawlAmount() {
		return totalWithDrawlAmount;
	}

	public void setTotalWithDrawlAmount(String totalWithDrawlAmount) {
		this.totalWithDrawlAmount = totalWithDrawlAmount;
	}

}
