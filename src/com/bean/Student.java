package com.bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="userinformation")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userinformation_id")
	private Integer userinformation_id;
	@Column(name="userid")
	private Integer userid;
	@Column(name="user_name")
	private String user_name;
	@Column(name="user_phone")
	private String user_phone;
//	@Column(name="user_gender")
//	private Integer user_gender;
	@ManyToOne
	@JoinColumn(name="user_gender")
	private StudentGender studentgender;
	@Column(name="user_national")
	private String user_national;
	@Column(name="user_birthdate")
	private String user_birthdate;
	@Column(name="user_idnumber")
	private String user_idnumber;
	@Column(name="user_political")
	private String user_political;
	@Column(name="user_img")
	private String user_img;
	@Column(name="user_desc")
	private String user_desc;
	@Column(name="user_status")
	private String user_status;
	public Integer getUserinformation_id() {
		return userinformation_id;
	}
	public void setUserinformation_id(Integer userinformation_id) {
		this.userinformation_id = userinformation_id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public StudentGender getStudentgender() {
		return studentgender;
	}
	public void setStudentgender(StudentGender studentgender) {
		this.studentgender = studentgender;
	}
	public String getUser_national() {
		return user_national;
	}
	public void setUser_national(String user_national) {
		this.user_national = user_national;
	}
	public String getUser_birthdate() {
		return user_birthdate;
	}
	public void setUser_birthdate(String user_birthdate) {
		this.user_birthdate = user_birthdate;
	}
	public String getUser_idnumber() {
		return user_idnumber;
	}
	public void setUser_idnumber(String user_idnumber) {
		this.user_idnumber = user_idnumber;
	}
	public String getUser_political() {
		return user_political;
	}
	public void setUser_political(String user_political) {
		this.user_political = user_political;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public String getUser_desc() {
		return user_desc;
	}
	public void setUser_desc(String user_desc) {
		this.user_desc = user_desc;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	
	
	

}
