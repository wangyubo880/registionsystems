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
@Table(name="student_national")
public class StudentNational {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="national_id")
	private Integer national_id;
	@Column(name="national_name")
	private String national_name;
	@OneToMany(mappedBy="studentnational",targetEntity=Student.class,cascade=CascadeType.ALL)
	private Set<Student> nationalSet = new HashSet<Student>();
	public Integer getNational_id() {
		return national_id;
	}
	public void setNational_id(Integer national_id) {
		this.national_id = national_id;
	}
	public String getNational_name() {
		return national_name;
	}
	public void setNational_name(String national_name) {
		this.national_name = national_name;
	}
	public Set<Student> getNationalSet() {
		return nationalSet;
	}
	public void setNationalSet(Set<Student> nationalSet) {
		this.nationalSet = nationalSet;
	}
	

}
