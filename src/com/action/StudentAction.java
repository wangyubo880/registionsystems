package com.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Student;
import com.bean.User;
import com.service.UserService;

@Controller
public class StudentAction {
	@Autowired
	private UserService userService;
	//报名测试3
//	@RequestMapping("/informationinputsss")
//	public String registerss(Student student,@RequestParam("user_img") MultipartFile user_img)throws Exception {
//		System.out.println(user_img);
//	    return "informationinput";
//	}
	//报名测试4
	@RequestMapping("/informationinputsss")
	public String updateMessage(HttpSession session,Model model,HttpServletRequest request,@RequestParam("user_name") String user_name,@RequestParam("userid") Integer userid,@RequestParam("user_phone") String user_phone,@RequestParam("user_gender") String user_gender,@RequestParam("user_national") String user_national,@RequestParam("user_idnumber") String user_idnumber,@RequestParam("user_birthdate") String user_birthdate,@RequestParam("user_political") String user_political,@RequestParam("user_desc") String user_desc,@RequestParam("user_status") String user_status,@RequestParam("user_img") MultipartFile user_img) throws Exception{
		System.out.println(user_img);
		System.out.println(user_name);
		System.out.println(userid);
		System.out.println(user_phone);
		System.out.println(user_gender);
		System.out.println(user_national);
		System.out.println(user_idnumber);
		System.out.println(user_birthdate);
		System.out.println(user_political);
		System.out.println(user_desc);
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
		student.setUser_status(user_status);
		
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
		boolean result=userService.inputinformations(student);
		if(result) {
			return "login";
		}else {
			return "login";
		}
	}

}
