package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Relation;
import com.bean.Student;
import com.bean.User;
import com.dao.StudentDao;
import com.dao.UserDao;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
//	@Autowired
//	private StudentDao studentDao;
	//用户登录
	public boolean login(String username,String userpassword) {
		return userDao.login(username, userpassword);
	}
	public int selectid(String username) {
		return userDao.selectidByname(username);
	}
	//用户注册
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return userDao.insert(user);
	}
	//报名信息
	public boolean informationinput(Student student,String user_img) {
		// TODO Auto-generated method stub
		return userDao.informationinput(student, user_img);
	}
	//报名信息测试
	public boolean inputinformations(Student student) {
		// TODO Auto-generated method stub
		return userDao.studentinformationinputs(student);
	}
	//报名信息测试2
	public boolean inputinformationss(Student student,String user_img) {
		// TODO Auto-generated method stub
		return userDao.informationinputss(student, user_img);
	}
	//报名信息测试4
	//修改商品信息
//	public boolean inputinformationsss(Student student) {
//		return studentDao.inputinformationupload(student);
//	}


}
