package com.trafficmonkey.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="work_assigment")
public class WorkAssignmentModel {
    @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="id", unique=true ,nullable=false)
    private Long id;
     @Column(name="user_id")
     private Long userId;
     @Column(name="date")
     private Date date;
     @OneToMany(cascade=CascadeType.ALL,mappedBy="workAssignment")
 	private	List<LinkModel> LinkModel;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<LinkModel> getLinkModel() {
		return LinkModel;
	}
	public void setLinkModel(List<LinkModel> linkModel) {
		LinkModel = linkModel;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}