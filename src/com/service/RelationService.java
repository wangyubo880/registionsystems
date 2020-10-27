package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Relation;
import com.bean.Student;
import com.bean.User;
import com.dao.RelationDao;

@Service
@Transactional
public class RelationService {
	@Autowired
	private RelationDao relationDao;
	public List<Relation> findAll(){
		 List<Relation> list = relationDao.select();
		 return list;
	 }
	//��ʾ��ͥ��ϵ
	public List<Relation> findRelationById(Integer id){
		List<Relation> list=relationDao.selectRelationById(id);
		return list;
	}
	//����ĳ����ͥ��ϵ
	public List<Relation> findRelationByRelationId(Integer id){
		List<Relation> list=relationDao.selectRelationByRelationId(id);
		return list;
	}
	//��Ӽ�ͥ��ϵ
	public boolean addRelation(Relation relation) {
		// TODO Auto-generated method stub
		return relationDao.insertRelation(relation);
	}
	//ɾ��ĳ����ͥ��ϵ
	public boolean deleteRelationById(Integer id) {
		return relationDao.deleteRelationById(id);
	}
	//�޸ļ�ͥ��ϵ
	public boolean updateRelationMessage(Relation relation,Integer relation_id) {
		return relationDao.updateRelationMessage(relation, relation_id);
	}


}
