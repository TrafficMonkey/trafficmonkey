package com.trafficmonkey.DTO;

public class LoginDTO {

	private String email;
	private String password;
	private Boolean isRememberMe;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean isRememberMe() {
		return isRememberMe;
	}
	public void setRememberMe(Boolean isRememberMe) {
		this.isRememberMe = isRememberMe;
	}
}
