package com.mps.think.model;

public class CustomerLoginModel {
	private int customerId;
	private Integer custLoginId;
	private int customerAddSeq;
	private String login;
	private String password;
	private int primaryLogin;
	private Integer passQuestionId;
	private String response;
	private String hint;
	private int invalidAttempts;
	private int lockedOut;
	private String lockStartTime;
	private String tempExpire;
	private String question;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCustomerAddSeq() {
		return customerAddSeq;
	}
	public void setCustomerAddSeq(int customerAddSeq) {
		this.customerAddSeq = customerAddSeq;
	}
	public Integer getCustLoginId() {
		return custLoginId;
	}
	public void setCustLoginId(Integer custLoginId) {
		this.custLoginId = custLoginId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPrimaryLogin() {
		return primaryLogin;
	}
	public void setPrimaryLogin(int primaryLogin) {
		this.primaryLogin = primaryLogin;
	}
	public Integer getPassQuestionId() {
		return passQuestionId;
	}
	public void setPassQuestionId(Integer passQuestionId) {
		this.passQuestionId = passQuestionId;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public int getInvalidAttempts() {
		return invalidAttempts;
	}
	public void setInvalidAttempts(int invalidAttempts) {
		this.invalidAttempts = invalidAttempts;
	}
	public int getLockedOut() {
		return lockedOut;
	}
	public void setLockedOut(int lockedOut) {
		this.lockedOut = lockedOut;
	}
	
	public String getLockStartTime() {
		return lockStartTime;
	}
	public void setLockStartTime(String lockStartTime) {
		this.lockStartTime = lockStartTime;
	}
	public String getTempExpire() {
		return tempExpire;
	}
	public void setTempExpire(String tempExpire) {
		this.tempExpire = tempExpire;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "CustomerLoginModel [customerId=" + customerId + ", custLoginId=" + custLoginId + ", customerAddSeq="
				+ customerAddSeq + ", login=" + login + ", password=" + password + ", primaryLogin=" + primaryLogin
				+ ", passQuestionId=" + passQuestionId + ", response=" + response + ", hint=" + hint
				+ ", invalidAttempts=" + invalidAttempts + ", lockedOut=" + lockedOut + ", lockStartTime="
				+ lockStartTime + ", tempExpire=" + tempExpire + ", question=" + question + "]";
	}
	
	
	
	
	

}
