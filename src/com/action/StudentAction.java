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

import com.bean.Relation;
import com.bean.Student;
import com.bean.User;
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
	//报名测试3
//	@RequestMapping("/informationinputsss")
//	public String registerss(Student student,@RequestParam("user_img") MultipartFile user_img)throws Exception {
//		System.out.println(user_img);
//	    return "informationinput";
//	}
	//报名测试4
	@RequestMapping("/informationinput")
	public String updateMessage(HttpSession session,Model model,HttpServletRequest request,@RequestParam("user_name") String user_name,@RequestParam("user_phone") String user_phone,@RequestParam("user_gender") String user_gender,@RequestParam("user_national") String user_national,@RequestParam("user_idnumber") String user_idnumber,@RequestParam("user_birthdate") String user_birthdate,@RequestParam("user_political") String user_political,@RequestParam("user_desc") String user_desc,@RequestParam("user_img") MultipartFile user_img) throws Exception{
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
		student.setUser_name(user_name);
		student.setUserid(userid);
		student.setUser_phone(user_phone);
		student.setUser_gender(user_gender);
		student.setUser_national(user_national);
		student.setUser_birthdate(user_birthdate);
		student.setUser_idnumber(user_idnumber);
		student.setUser_political(user_political);
		student.setUser_desc(user_desc);
		student.setUser_status("草稿");
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
		System.out.println(student.getUser_gender());
		System.out.println(student.getUser_national());
		System.out.println(student.getUser_birthdate());
		System.out.println(student.getUser_idnumber());
		System.out.println(student.getUser_political());
		System.out.println(student.getUser_img());
		System.out.println(student.getUser_desc());
		System.out.println(student.getUser_status());
		boolean result=userService.inputinformations(student);
		if(result) {
			return "redirect:informationlist.do"; 
			//return "informationlist";
		}else {
			return "login";
		}
	}
	//第一部分保存后显示
	@RequestMapping("/informationlist")
	public String showStudentMessage(HttpSession session,Model model) {
		Integer uid=(Integer)session.getAttribute("uid");
		System.out.println("uid"+uid);
		List<Student> list=studentService.findStudentById(uid);
		model.addAttribute("studentMessagelists",list);
		return "informationlist";
	}
//	@RequestMapping("/relation")
//	public String showUserMessage(HttpSession session,Model model){
//		Integer uid=(Integer)session.getAttribute("uid");
//		List<Relation> list=relationService.findRelationById(uid);
////		List<Relation> list=relationService.findAll();
//		model.addAttribute("relationlist",list);
//		System.out.println("先传参到relationaction");
//		return "informationinput";
//		//return "relation";
//	}

}
