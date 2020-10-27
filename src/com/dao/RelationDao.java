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
public class RelationDao {
	@Autowired
	//获取家庭关系列表
	private SessionFactory sessionFactory;
	public List<Relation> select(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Relation");
		List<Relation> list = query.list();
		return list;
	}
	//显示当前用户的家庭关系
	public List<Relation> selectRelationById(Integer userid){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Relation r where userid=?");
		List<Relation> list=query.setParameter(0, userid).list();
		return list;
	}
	//添加当前用户家庭关系
	public boolean insertRelation(Relation relation) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(relation);
		return true;
	}
	//删除某条家庭关系
	public boolean deleteRelationById(Integer relation_id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Relation where relation_id=?");
		int result=query.setParameter(0, relation_id).executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//修改家庭信息
	public boolean updateRelationMessage(Relation relation,Integer relation_id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Relation r set r.relation_relation=?,r.relation_name=?,r.relation_telephone=?,r.relation_workunits=? where relation_id=?");
		
		query.setParameter(0, relation.getRelation_relation());
		query.setParameter(1, relation.getRelation_name());
		query.setParameter(2, relation.getRelation_telephone());
		query.setParameter(3, relation.getRelation_workunits());
		query.setParameter(4, relation_id);

		int result=query.executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//查找某条家庭信息
	public List<Relation> selectRelationByRelationId(Integer relation_id){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Relation r where relation_id=?");
		List<Relation> list=query.setParameter(0, relation_id).list();
		return list;
	}


}
