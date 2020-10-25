package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentrelation")
public class Relation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="relation_id")
	private Integer relation_id;
	@Column(name="userid")
	private Integer userid;
	@Column(name="userinformation_id")
	private Integer userinformation_id;
	@Column(name="relation_relation")
	private String relation_relation;
	@Column(name="relation_name")
	private String relation_name;
	@Column(name="relation_telephone")
	private String relation_telephone;
	@Column(name="relation_workunits")
	private String relation_workunits;
	public Integer getRelation_id() {
		return relation_id;
	}
	public void setRelation_id(Integer relation_id) {
		this.relation_id = relation_id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getUserinformation_id() {
		return userinformation_id;
	}
	public void setUserinformation_id(Integer userinformation_id) {
		this.userinformation_id = userinformation_id;
	}
	public String getRelation_relation() {
		return relation_relation;
	}
	public void setRelation_relation(String relation_relation) {
		this.relation_relation = relation_relation;
	}
	public String getRelation_name() {
		return relation_name;
	}
	public void setRelation_name(String relation_name) {
		this.relation_name = relation_name;
	}
	public String getRelation_telephone() {
		return relation_telephone;
	}
	public void setRelation_telephone(String relation_telephone) {
		this.relation_telephone = relation_telephone;
	}
	public String getRelation_workunits() {
		return relation_workunits;
	}
	public void setRelation_workunits(String relation_workunits) {
		this.relation_workunits = relation_workunits;
	}
	

}
