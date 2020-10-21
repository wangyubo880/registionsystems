package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.User;
import com.dao.UserDao;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	//�û���¼
	public boolean login(String username,String userpassword) {
		return userDao.login(username, userpassword);
	}
	public int selectid(String username) {
		return userDao.selectidByname(username);
	}
	//�û�ע��
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return userDao.insert(user);
	}

}
