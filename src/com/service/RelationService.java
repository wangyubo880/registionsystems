package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Relation;
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
	//显示家庭关系
	public List<Relation> findRelationById(Integer id){
		List<Relation> list=relationDao.selectRelationById(id);
		return list;
	}
	//添加家庭关系
	public boolean addRelation(Relation relation) {
		// TODO Auto-generated method stub
		return relationDao.insertRelation(relation);
	}
	//删除某条家庭关系
	public boolean deleteRelationById(Integer id) {
		return relationDao.deleteRelationById(id);
	}


}
