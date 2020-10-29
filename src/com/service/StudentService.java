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
	//查询性别类别
	//查询类别
	public List<StudentGender> showGender(){
		return studentDao.showGender();
	}
	//显示上传后的信息
	public List<Student> findStudentById(Integer id){
		//return studentDao.selectById(id);
		List<Student> list=studentDao.selectById(id);
		return list;
	}
	//修改学生信息
	public boolean updateStudentMessage(Student student,Integer id) {
		return studentDao.updateStudentMessage(student, id);
	}
	//查询状态
	public String selectStudentStatus(Integer id) {
		return studentDao.selectStudentStatus(id);
	}


}
