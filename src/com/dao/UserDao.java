package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Student;
import com.bean.User;

@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	//登录
	public boolean login(String username,String userpassword) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User u where u.username=? and u.userpassword=?");
	    List<User>lists = query.setString(0, username).setString(1, userpassword).list();
		if(lists.size()>0) {
			return true;
		}else {
			return false;
		}
			}
	public List<User> selectById(Integer userid){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where userid=?");
		query.setParameter(0, userid);
		List<User> lists=query.list();
		return lists;
	}
	//根据用户名查找id
	public int selectidByname(String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select u.userid from User u where u.username=?");
		List list=query.setString(0, username).list();
		int id=(int)list.get(0);
		return id;
	}
	//添加用户
	public boolean insert(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}
	//报名信息填写
	public boolean informationinput(Student student,String user_img) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		student.setUser_img(user_img);
		session.save(student);
		return true;
	}
	//报名信息填写测试
	public boolean informationinputs(Student student) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
		return true;
	}
	//报名信息测试2
	public boolean informationinputss(Student student,String user_img) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		student.setUser_img(user_img);
		session.save(student);
		return true;
	}

}
