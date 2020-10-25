package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.bean.Relation;
import com.bean.User;

@Repository
public class RelationDao {
	@Autowired
	//��ȡ��ͥ��ϵ�б�
	private SessionFactory sessionFactory;
	public List<Relation> select(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Relation");
		List<Relation> list = query.list();
		return list;
	}
	//��ʾ��ǰ�û��ļ�ͥ��ϵ
	public List<Relation> selectRelationById(Integer userid){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Relation r where userid=?");
		List<Relation> list=query.setParameter(0, userid).list();
		return list;
	}


}
