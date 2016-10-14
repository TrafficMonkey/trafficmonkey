package com.trafficmonkey.DTO;

public class ParentChildDTO {
	private Long Id;
	private Long parentId;
	private String position ;
	private String sponsorId;
	private RegistrationDTO registration;
	
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public RegistrationDTO getRegistration() {
		return registration;
	}
	public void setRegistration(RegistrationDTO registration) {
		this.registration = registration;
	}
	public String getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}
	
}
