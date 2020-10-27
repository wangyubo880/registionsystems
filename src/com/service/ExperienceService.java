package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Experience;
import com.dao.ExperienceDao;

@Service
@Transactional
public class ExperienceService {
	@Autowired
	private ExperienceDao experienceDao;
	public List<Experience> findAll(){
		 List<Experience> list = experienceDao.select();
		 return list;
	 }
	//��ʾѧϰ����
	public List<Experience> findExperienceById(Integer id){
		List<Experience> list=experienceDao.selectExperienceById(id);
		return list;
	}
	//����ĳ��ѧϰ����
	public List<Experience> findRelationByExperienceId(Integer id){
		List<Experience> list=experienceDao.selectExperienceByExperienceId(id);
		return list;
	}
	//���ѧϰ����
	public boolean addExperience(Experience experience) {
		// TODO Auto-generated method stub
		return experienceDao.insertExperience(experience);
	}
	//ɾ��ĳ��ѧϰ����
	public boolean deleteExperienceById(Integer id) {
		return experienceDao.deleteExperienceById(id);
	}
	//�޸�ѧϰ����
	public boolean updateExperienceMessage(Experience experience,Integer experience_id) {
		return experienceDao.updateExperienceMessage(experience, experience_id);
	}

}
