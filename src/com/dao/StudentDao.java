package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.bean.Student;

@Repository
public class StudentDao {
	@Autowired
	private SessionFactory sessionFactory;
	//添加信息
	//修改商品信息
	public boolean inputinformationupload(Student student) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("insert into Student s(user_name,userid,user_phone,user_gender,user_national,user_idnumber,user_birthdate,user_political,user_img,user_desc,user_status)values(?,?,?,?,?,?,?,?,?,?,?)");
		query.setParameter(0, student.getUser_name());
		query.setParameter(1, student.getUserid());
		query.setParameter(2, student.getUser_phone());
		query.setParameter(3, student.getUser_gender());
		query.setParameter(4, student.getUser_national());
		query.setParameter(5, student.getUser_idnumber());
		query.setParameter(6, student.getUser_birthdate());
		query.setParameter(7, student.getUser_political());
		query.setParameter(8, student.getUser_img());
		query.setParameter(9, student.getUser_desc());
		query.setParameter(10, student.getUser_status());
		
		int result=query.executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	
	//修改商品信息
//	public boolean adminupdateclock(Light light,Integer id) {
//		Session session=sessionFactory.getCurrentSession();
//		Query query=session.createQuery("update Light l set l.name=?,l.price=?,l.img=?,l.clocktype=? where id=?");
//		query.setParameter(0, light.getName());
//		query.setParameter(1, light.getPrice());
//		query.setParameter(2, light.getImg());
//		query.setParameter(3, light.getClocktype());
//		query.setParameter(4, id);
//		int result=query.executeUpdate();
//		if(result>0) {
//			return true;
//		}else {
//			return false;
//		}
//	}

}
