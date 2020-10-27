package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Experience;


@Repository
public class ExperienceDao {
	@Autowired
	private SessionFactory sessionFactory;
	//��ȡѧϰ�����б�
	public List<Experience> select(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Experience");
		List<Experience> list = query.list();
		return list;
	}
	//��ʾ��ǰ�û���ѧϰ����
	public List<Experience> selectExperienceById(Integer userid){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Experience e where userid=?");
		List<Experience> list=query.setParameter(0, userid).list();
		return list;
	}
	//��ӵ�ǰ�û�ѧϰ����
	public boolean insertExperience(Experience experience) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(experience);
		return true;
	}
	//ɾ��ĳ��ѧϰ����
	public boolean deleteExperienceById(Integer experience_id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from Experience where experience_id=?");
		int result=query.setParameter(0, experience_id).executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//�޸�ѧϰ����
	public boolean updateExperienceMessage(Experience experience,Integer experience_id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Experience e set e.experience_startdate=?,e.experience_enddate=?,e.experience_place=?,e.experience_position=? where experience_id=?");
		
		query.setParameter(0, experience.getExperience_startdate());
		query.setParameter(1, experience.getExperience_enddate());
		query.setParameter(2, experience.getExperience_place());
		query.setParameter(3, experience.getExperience_position());
		query.setParameter(4, experience_id);

		int result=query.executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	//����ĳ��ѧϰ����
	public List<Experience> selectExperienceByExperienceId(Integer experience_id){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Experience e where experience_id=?");
		List<Experience> list=query.setParameter(0, experience_id).list();
		return list;
	}

}
