package com.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.bean.Experience;
import com.bean.Relation;
import com.bean.Student;
import com.bean.StudentGender;
import com.bean.StudentNational;
import com.service.ExperienceService;
import com.service.RelationService;
import com.service.StudentService;
import com.service.UserService;

@Controller
public class StudentAction {
	@Autowired
	private StudentService studentService;
	@Autowired
	private UserService userService;
	@Autowired
	private RelationService relationService;
	@Autowired
	private ExperienceService experienceService;
	//显示民族类别
	@RequestMapping("/shownational")
	public String showNational(StudentNational national,Model model) {
		List<StudentNational> nationals=studentService.showNational();
		model.addAttribute("nationals",nationals);
		return "national";
	}
	//输入报名信息显示男女
	@RequestMapping("/showgender")
	public String showGender(StudentGender gender,Model model) {
		List<StudentGender> genders=studentService.showGender();
		model.addAttribute("genders",genders);
		return "gender";
	}
	//报名测试3
//	@RequestMapping("/informationinputsss")
//	public String registerss(Student student,@RequestParam("user_img") MultipartFile user_img)throws Exception {
//		System.out.println(user_img);
//	    return "informationinput";
//	}
	//报名测试4
	@RequestMapping("/informationinput")
	public String addMessage(HttpSession session,Model model,HttpServletRequest request,@RequestParam("user_name") String user_name,@RequestParam("user_phone") String user_phone,@RequestParam("studentgender") Integer user_gender,@RequestParam("studentnational") Integer user_national,@RequestParam("user_idnumber") String user_idnumber,@RequestParam("user_birthdate") String user_birthdate,@RequestParam("user_political") String user_political,@RequestParam("user_desc") String user_desc,@RequestParam("user_img") MultipartFile user_img) throws Exception{
//		List<Relation> list=relationService.findAll();
//		model.addAttribute("relationlist",list);
		
		Integer userid=(Integer)session.getAttribute("uid");
		
//		System.out.println(user_img);
//		System.out.println(user_name);
//		System.out.println(userid);
//		System.out.println(user_phone);
//		System.out.println(user_gender);
//		System.out.println(user_national);
//		System.out.println(user_idnumber);
//		System.out.println(user_birthdate);
//		System.out.println(user_political);
//		System.out.println(user_desc);
		Student student = new Student();
		StudentGender gender=new StudentGender();
		gender.setGender_id(user_gender);
		student.setStudentgender(gender);
		StudentNational national=new StudentNational();
		national.setNational_id(user_national);
		student.setStudentnational(national);
		student.setUser_name(user_name);
		student.setUserid(userid);
		student.setUser_phone(user_phone);
		
		//student.setUser_gender(user_gender);
		//student.setUser_national(user_national);
		student.setUser_birthdate(user_birthdate);
		student.setUser_idnumber(user_idnumber);
		student.setUser_political(user_political);
		student.setUser_desc(user_desc);
		student.setUser_status("1");  //状态
		//student.setUserinformation_id(8);
		
//		User user=new User();
//		user.setName(name);
//		user.setUsername(username);
//		user.setAddress(address);
//		user.setEmail(email);
//		user.setPhone(phone);
//		user.setPassword(password);
		try {
			//上传图片
			String originalFilename = user_img.getOriginalFilename();	
			if(originalFilename!=null && !originalFilename.equals("")) {
				
				String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\")+1);
				String realPath = request.getServletContext().getRealPath("admins/bookimg");
				FileCopyUtils.copy(user_img.getBytes(), new File(realPath+"\\"+fileName));
				student.setUser_img(fileName);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("failMsg","上传图片失败");
			return "login";
		}
		//Integer uid=(Integer)session.getAttribute("uid");
		//boolean result=userService.inputinformationsss(student);
		System.out.println(student.getUserid());
		System.out.println(student.getUser_name());
		System.out.println(student.getUser_phone());
		System.out.println(student.getStudentgender());
		//System.out.println(student.getUser_national());
		System.out.println(student.getUser_birthdate());
		System.out.println(student.getUser_idnumber());
		System.out.println(student.getUser_political());
		System.out.println(student.getUser_img());
		System.out.println(student.getUser_desc());
		System.out.println(student.getUser_status());
		boolean result=userService.inputinformations(student);
		if(result) {
			return "redirect:informationlistNew.do"; 
			//return "informationlist";
		}else {
			return "login";
		}
	}
	//第一部分保存后显示
	@RequestMapping("/informationlistNew")
	public String showStudentMessage(StudentGender gender,Model model2,HttpSession session,Model model) throws Exception{
		Integer uid=(Integer)session.getAttribute("uid");
		System.out.println("uid"+uid);
		//根据uid查找性别  
		List<Student> list=studentService.findStudentById(uid);
		model.addAttribute("studentMessagelists",list);
		List<Relation> lists=relationService.findRelationById(uid);
		model.addAttribute("relationlist",lists);
		List<Experience> list2=experienceService.findExperienceById(uid);
		model.addAttribute("experiencelist",list2);
		List<StudentGender> genders=studentService.showGender();
		model2.addAttribute("genders",genders);
		List<StudentNational> nationals=studentService.showNational();
		model.addAttribute("nationals",nationals);
		//return "redirect:relation.do"; 
		return "informationlistNew";
	}
	//修改学生信息
	@RequestMapping("/updatestudentmessage")
	public String updateStudentMessage(HttpSession session,Model model,HttpServletRequest request,@RequestParam("user_name") String user_name,@RequestParam("user_phone") String user_phone,@RequestParam("studentgender") Integer user_gender,@RequestParam("studentnational") Integer user_national,@RequestParam("user_idnumber") String user_idnumber,@RequestParam("user_birthdate") String user_birthdate,@RequestParam("user_political") String user_political,@RequestParam("user_desc") String user_desc,@RequestParam("user_img") MultipartFile user_img) throws Exception{
//		List<Relation> list=relationService.findAll();
//		model.addAttribute("relationlist",list);
		
		Integer userid=(Integer)session.getAttribute("uid");
//		System.out.println(user_img);
//		System.out.println(user_name);
//		System.out.println(userid);
//		System.out.println(user_phone);
//		System.out.println(user_gender);
//		System.out.println(user_national);
//		System.out.println(user_idnumber);
//		System.out.println(user_birthdate);
//		System.out.println(user_political);
//		System.out.println(user_desc);
		Student student = new Student();
		StudentGender gender=new StudentGender();
		gender.setGender_id(user_gender);
		student.setStudentgender(gender);
		StudentNational national=new StudentNational();
		national.setNational_id(user_national);
		student.setStudentnational(national);
		student.setUser_name(user_name);
		student.setUserid(userid);
		student.setUser_phone(user_phone);
		//student.setUser_gender(user_gender);
		//student.setUser_national(user_national);
		student.setUser_birthdate(user_birthdate);
		student.setUser_idnumber(user_idnumber);
		student.setUser_political(user_political);
		student.setUser_desc(user_desc);
		student.setUser_status("1");   //草稿
		//student.setUserinformation_id(8);
		
//		User user=new User();
//		user.setName(name);
//		user.setUsername(username);
//		user.setAddress(address);
//		user.setEmail(email);
//		user.setPhone(phone);
//		user.setPassword(password);
		try {
			//上传图片
			String originalFilename = user_img.getOriginalFilename();	
			if(originalFilename!=null && !originalFilename.equals("")) {
				
				String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\")+1);
				String realPath = request.getServletContext().getRealPath("admins/bookimg");
				FileCopyUtils.copy(user_img.getBytes(), new File(realPath+"\\"+fileName));
				student.setUser_img(fileName);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("failMsg","上传图片失败");
			return "login";
		}
		//Integer uid=(Integer)session.getAttribute("uid");
		//boolean result=userService.inputinformationsss(student);
		System.out.println(student.getUserid());
		System.out.println(student.getUser_name());
		System.out.println(student.getUser_phone());
		//System.out.println(student.getUser_gender());
		//System.out.println(student.getUser_national());
		System.out.println(student.getUser_birthdate());
		System.out.println(student.getUser_idnumber());
		System.out.println(student.getUser_political());
		System.out.println(student.getUser_img());
		System.out.println(student.getUser_desc());
		System.out.println(student.getUser_status());
		boolean result=studentService.updateStudentMessage(student, userid);
		//boolean result=userService.inputinformations(student);
		if(result) {
			return "redirect:informationlistNew.do"; 
			//return "informationlist";
		}else {
			return "login";
		}
	}
	//点击报名 修改状态 显示信息
	@RequestMapping("/enroll")
	public String updateStudentStatusByid(HttpSession session,Model model) {
		Integer userid=(Integer)session.getAttribute("uid");
		System.out.println("显示修改状态的uid");
		System.out.println(userid);
		boolean result=studentService.updateStudentStatus(userid);
		System.out.println("是否修改成功");
		System.out.println(result);
		if(result) {
			return "redirect:enrollMsg.do";
		}else {
			model.addAttribute("errormsg", "提交失败");
			return "index";
		}
	}
	//报名成功展示
	@RequestMapping("/enrollMsg")
	public String showEnrollMessage(StudentGender gender,Model model2,HttpSession session,Model model) throws Exception{
		Integer uid=(Integer)session.getAttribute("uid");
		System.out.println("uid"+uid);
		//根据uid查找性别  
		List<Student> list=studentService.findStudentById(uid);
		model.addAttribute("studentMessagelists",list);
		List<Relation> lists=relationService.findRelationById(uid);
		model.addAttribute("relationlist",lists);
		List<Experience> list2=experienceService.findExperienceById(uid);
		model.addAttribute("experiencelist",list2);
		List<StudentGender> genders=studentService.showGender();
		model2.addAttribute("genders",genders);
		List<StudentNational> nationals=studentService.showNational();
		model.addAttribute("nationals",nationals);
		//return "redirect:relation.do"; 
		return "enrollmessage2";
	}


}
