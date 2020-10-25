package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Relation;
import com.bean.Student;
import com.bean.User;

@Repository
public class StudentDao {
	@Autowired
	private SessionFactory sessionFactory;
//	//添加信息
//	public boolean inputinformationupload(Student student) {
//		Session session=sessionFactory.getCurrentSession();
//		Query query=session.createQuery("insert into Student s(user_name,userid,user_phone,user_gender,user_national,user_idnumber,user_birthdate,user_political,user_img,user_desc,user_status)values(?,?,?,?,?,?,?,?,?,?,?)");
//		query.setParameter(0, student.getUser_name());
//		query.setParameter(1, student.getUserid());
//		query.setParameter(2, student.getUser_phone());
//		query.setParameter(3, student.getUser_gender());
//		query.setParameter(4, student.getUser_national());
//		query.setParameter(5, student.getUser_idnumber());
//		query.setParameter(6, student.getUser_birthdate());
//		query.setParameter(7, student.getUser_political());
//		query.setParameter(8, student.getUser_img());
//		query.setParameter(9, student.getUser_desc());
//		query.setParameter(10, student.getUser_status());
//		
//		int result=query.executeUpdate();
//		if(result>0) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	//显示保存后的信息
	public List<Student> selectById(Integer userid){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Student s where userid=?");
//		query.setParameter(0, userid);
//		List<Student> lists=query.list();
//		return lists;
		List<Student> list=query.setParameter(0, userid).list();
		return list;
	}



}
