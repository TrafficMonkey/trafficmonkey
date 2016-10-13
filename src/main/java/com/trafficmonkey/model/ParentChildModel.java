package com.trafficmonkey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parent_child")
public class ParentChildModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long Id;
	@Column(name="parent_id")
	private Long parentId;
	@Column(name="child_id")
	
	
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
