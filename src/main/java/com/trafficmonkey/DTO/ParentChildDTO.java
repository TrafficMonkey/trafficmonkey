package com.trafficmonkey.DTO;

import javax.persistence.Column;

public class ParentChildDTO {
	private Long Id;
	private Long parentId;
	private Long childId;
	
	
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
	public Long getChildId() {
		return childId;
	}
	public void setChildId(Long childId) {
		this.childId = childId;
	}
}
