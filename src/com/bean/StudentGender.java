package com.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student_gender")
public class StudentGender {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="gender_id")
	private Integer gender_id;
	@Column(name="gender_name")
	private String gender_name;
	@OneToMany(mappedBy="studentgender",targetEntity=Student.class,cascade=CascadeType.ALL)
	private Set<Student> genderSet = new HashSet<Student>();
	public Integer getGender_id() {
		return gender_id;
	}
	public void setGender_id(Integer gender_id) {
		this.gender_id = gender_id;
	}
	public String getGender_name() {
		return gender_name;
	}
	public void setGender_name(String gender_name) {
		this.gender_name = gender_name;
	}
	public Set<Student> getGenderSet() {
		return genderSet;
	}
	public void setGenderSet(Set<Student> genderSet) {
		this.genderSet = genderSet;
	}
	

}
