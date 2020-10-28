package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studyexperience")
public class Experience {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="experience_id")
	private Integer experience_id;
	//private Integer userinformation_id;
	@Column(name="userid")
	private Integer userid;
	@Column(name="experience_startdate")
	private String experience_startdate;
	@Column(name="experience_enddate")
	private String experience_enddate;
	@Column(name="experience_place")
	private String experience_place;
	@Column(name="experience_position")
	private String experience_position;
	public Integer getExperience_id() {
		return experience_id;
	}
	public void setExperience_id(Integer experience_id) {
		this.experience_id = experience_id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getExperience_startdate() {
		return experience_startdate;
	}
	public void setExperience_startdate(String experience_startdate) {
		this.experience_startdate = experience_startdate;
	}
	public String getExperience_enddate() {
		return experience_enddate;
	}
	public void setExperience_enddate(String experience_enddate) {
		this.experience_enddate = experience_enddate;
	}
	public String getExperience_place() {
		return experience_place;
	}
	public void setExperience_place(String experience_place) {
		this.experience_place = experience_place;
	}
	public String getExperience_position() {
		return experience_position;
	}
	public void setExperience_position(String experience_position) {
		this.experience_position = experience_position;
	}
	
	

}
