package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Student;
import com.dao.StudentDao;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	//显示上传后的信息
	public List<Student> findStudentById(Integer id){
		//return studentDao.selectById(id);
		List<Student> list=studentDao.selectById(id);
		return list;
	}


}
