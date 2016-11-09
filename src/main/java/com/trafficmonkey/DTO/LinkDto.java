package com.trafficmonkey.DTO;

public class LinkDto {
private Long LinkId;
private String pageName;
private String pageLink;
public Long getLinkId() {
	return LinkId;
}
public void setLinkId(Long linkId) {
	LinkId = linkId;
}
public String getPageName() {
	return pageName;
}
public void setPageName(String pageName) {
	this.pageName = pageName;
}
public String getPageLink() {
	return pageLink;
}
public void setPageLink(String pageLink) {
	this.pageLink = pageLink;
}
}
