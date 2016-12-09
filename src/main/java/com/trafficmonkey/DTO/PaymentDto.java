package com.trafficmonkey.DTO;

public class PaymentDto {
	private Long user_id;
	private String userName;
	private float binaryIncome;
	private int completeBinary;
	private float directReferralIncome;
	private float workAssigmentIncome;
	private float totalIncome;
	private int totalPayoutIncome;
	private float tds;
	private float adminTax;
	private int accountNumber;
	private String bankName;
	private String ifscCode;
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public float getBinaryIncome() {
		return binaryIncome;
	}
	public void setBinaryIncome(float binaryIncome) {
		this.binaryIncome = binaryIncome;
	}
	public int getCompleteBinary() {
		return completeBinary;
	}
	public void setCompleteBinary(int completeBinary) {
		this.completeBinary = completeBinary;
	}
	public float getDirectReferralIncome() {
		return directReferralIncome;
	}
	public void setDirectReferralIncome(float directReferralIncome) {
		this.directReferralIncome = directReferralIncome;
	}
	public float getWorkAssigmentIncome() {
		return workAssigmentIncome;
	}
	public void setWorkAssigmentIncome(float workAssigmentIncome) {
		this.workAssigmentIncome = workAssigmentIncome;
	}
	public float getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(float totalIncome) {
		this.totalIncome = totalIncome;
	}
	public int getTotalPayoutIncome() {
		return totalPayoutIncome;
	}
	public void setTotalPayoutIncome(int totalPayoutIncome) {
		this.totalPayoutIncome = totalPayoutIncome;
	}
	public float getTds() {
		return tds;
	}
	public void setTds(float tds) {
		this.tds = tds;
	}
	public float getAdminTax() {
		return adminTax;
	}
	public void setAdminTax(float adminTax) {
		this.adminTax = adminTax;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
}
	
	