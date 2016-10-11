package com.trafficmonkey.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Registration")
public class RegistrationModel  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "contact")
	private String contact;
	@Column(name = "pancardFlag")
	private String pancardFlag;
	@Column(name = "pancard")
	private String pancard;
	@Column(name = "nominee")
	private String nominee;
	@Column(name = "sponsorId")
	private String sponsorId;
	@Column(name = "sponcerName")
	private String sponcerName;
	@Column(name = "position")
	private String position;
	@Column(name = "planType")
	private String planType;

	@Column(name = "termsAndCondition")
	private String termsAndCondition;
	@OneToOne(cascade=CascadeType.ALL)
	  @JoinColumn(name = "login_id" ) 
	
	private LoginModel loginModel;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	

	public String getPancardFlag() {
		return pancardFlag;
	}

	public void setPancardFlag(String pancardFlag) {
		this.pancardFlag = pancardFlag;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

	public String getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(String sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getSponcerName() {
		return sponcerName;
	}

	public void setSponcerName(String sponcerName) {
		this.sponcerName = sponcerName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getTermsAndCondition() {
		return termsAndCondition;
	}

	public void setTermsAndCondition(String termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}

	public LoginModel getLoginModel() {
		return loginModel;
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}

}
