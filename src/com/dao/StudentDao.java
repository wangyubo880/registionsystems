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
	//��ѯ״̬
	public String selectStudentStatus(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select s.user_status from Student s where userid=?");
		query.setParameter(0, id);
//		List<Student> list=query.setParameter(0, id).list();
//		String status=list.get(0).toString();
		Object statu = query.uniqueResult();
		if(statu==null) {
			String status="0";
			return status;
		}else {
			String status=statu.toString();
			return status;
		}
		
		
	}
	//�޸�ѧ����Ϣ
	public boolean updateStudentMessage(Student student,Integer userid) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Student s set s.user_name=?,s.user_phone=?,s.user_gender=?,s.user_national=?,s.user_birthdate=?,s.user_idnumber=?,s.user_political=?,s.user_img=?,s.user_desc=? where userid=?");
		
		query.setParameter(0, student.getUser_name());
		query.setParameter(1, student.getUser_phone());
		query.setParameter(2, student.getUser_gender());
		query.setParameter(3, student.getUser_national());
		query.setParameter(4, student.getUser_birthdate());
		query.setParameter(5, student.getUser_idnumber());
		query.setParameter(6, student.getUser_political());
		query.setParameter(7, student.getUser_img());
		query.setParameter(8, student.getUser_desc());
		query.setParameter(9, userid);
		int result=query.executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
//	//�����Ϣ
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
	//��ʾ��������Ϣ
	public List<Student> selectById(Integer userid){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Student s where s.userid=?");
//		query.setParameter(0, userid);
//		List<Student> lists=query.list();
//		return lists;
		List<Student> list=query.setParameter(0, userid).list();
		return list;
	}
//	//��ѯ��ǰ״̬
//	public String selectStatusById(Integer userid) {
//		Session session = sessionFactory.getCurrentSession();
//		Query query=session.createQuery("from Student s where s.userid=?");
//		
//	}
//	
//	//��¼
//	public boolean login(String username,String userpassword) {
//		Session session=sessionFactory.getCurrentSession();
//		Query query=session.createQuery("from User u where u.username=? and u.userpassword=?");
//	    List<User>lists = query.setString(0, username).setString(1, userpassword).list();
//		if(lists.size()>0) {
//			return true;
//		}else {
//			return false;
//		}
//			}
//


}
