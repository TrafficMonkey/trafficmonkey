package com.trafficmonkey.DTO;

public class PaymentDto {
	private Long user_id;
	private int binaryIncome;
	private int completeBinary;
	private int directReferralIncome;
	private int workAssigmentIncome;
	private int totalIncome;
	private int totalPayoutIncome;
	private int tds;
	private int adminTax;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public int getBinaryIncome() {
		return binaryIncome;
	}
	public void setBinaryIncome(int binaryIncome) {
		this.binaryIncome = binaryIncome;
	}
	public int getCompleteBinary() {
		return completeBinary;
	}
	public void setCompleteBinary(int completeBinary) {
		this.completeBinary = completeBinary;
	}
	public int getDirectReferralIncome() {
		return directReferralIncome;
	}
	public void setDirectReferralIncome(int directReferralIncome) {
		this.directReferralIncome = directReferralIncome;
	}
	public int getWorkAssigmentIncome() {
		return workAssigmentIncome;
	}
	public void setWorkAssigmentIncome(int workAssigmentIncome) {
		this.workAssigmentIncome = workAssigmentIncome;
	}
	public int getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(int totalIncome) {
		this.totalIncome = totalIncome;
	}
	public int getTotalPayoutIncome() {
		return totalPayoutIncome;
	}
	public void setTotalPayoutIncome(int totalPayoutIncome) {
		this.totalPayoutIncome = totalPayoutIncome;
	}
	public int getTds() {
		return tds;
	}
	public void setTds(int tds) {
		this.tds = tds;
	}
	public int getAdminTax() {
		return adminTax;
	}
	public void setAdminTax(int adminTax) {
		this.adminTax = adminTax;
	}

}
