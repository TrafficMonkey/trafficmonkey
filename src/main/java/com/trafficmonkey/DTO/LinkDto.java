package com.trafficmonkey.DTO;

public class LinkDto {
private Long Id;
private String pageTitle;
private String pageLink;



public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
public String getPageTitle() {
	return pageTitle;
}
public void setPageTitle(String pageTitle) {
	this.pageTitle = pageTitle;
}
public String getPageLink() {
	return pageLink;
}
public void setPageLink(String pageLink) {
	this.pageLink = pageLink;
}
}
