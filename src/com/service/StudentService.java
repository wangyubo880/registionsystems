package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Student;
import com.bean.StudentGender;
import com.dao.StudentDao;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	//��ѯ�Ա����
	//��ѯ���
	public List<StudentGender> showGender(){
		return studentDao.showGender();
	}
	//��ʾ�ϴ������Ϣ
	public List<Student> findStudentById(Integer id){
		//return studentDao.selectById(id);
		List<Student> list=studentDao.selectById(id);
		return list;
	}
	//�޸�ѧ����Ϣ
	public boolean updateStudentMessage(Student student,Integer id) {
		return studentDao.updateStudentMessage(student, id);
	}
	//��ѯ״̬
	public String selectStudentStatus(Integer id) {
		return studentDao.selectStudentStatus(id);
	}


}
