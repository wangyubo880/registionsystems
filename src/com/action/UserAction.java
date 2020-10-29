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
import com.bean.StudentGender;
import com.bean.User;
import com.service.RelationService;
import com.service.StudentService;
import com.service.UserService;

@Controller
public class UserAction {
	@Autowired
	private UserService userService;
	@Autowired
	private RelationService relationService;
	@Autowired
	private StudentService studentService;
	//查询用户状态
	//用户登录
	@RequestMapping("/login")
	public String login(StudentGender gender,Model model,String username,String userpassword,Model model1,Model model2,HttpSession session,User user) {
		boolean result=userService.login(username, userpassword);
		int uid=userService.selectid(username);
		String status=studentService.selectStudentStatus(uid);
		System.out.println("用户状态");
		System.out.println(status);
		model1.addAttribute("username",username);
		
		model2.addAttribute("userid",uid);
		session.setAttribute("username", username);
		System.out.println(username);
		System.out.println(userpassword);
		session.setAttribute("uid", uid);  //获取userid
		List<StudentGender> genders=studentService.showGender();
		model.addAttribute("genders",genders);
		if(result&&status.equals("1")) {  //状态1 草稿
			
			System.out.println(uid);
			System.out.println("登陆成功");
			return "redirect:informationlist.do"; 
		}
			else if(result&&status.equals("2")){   //状态2 报名成功
				System.out.println("报名成功状态");
				return "login";
				
			}else if(!result){
				model1.addAttribute("errormsg", "登录失败，用户名或密码错误");
				return "index"; //登录失败
			}else {
				return "informationinput";
				//return "redirect:informationinput.do";
				//return "redirect:showgender.do";
			}
			
//			List<Relation> list=relationService.findAll();
//			model.addAttribute("relationlist",list);
			//Integer uid=(Integer)session.getAttribute("uid");
	//		System.out.println(uid);
			//List<Relation> list=relationService.findRelationById(uid);
			//return "redirect:relation.do";  //传给action
			
			//return "relation";  //直接传给jsp
			
//		}else {
//			model1.addAttribute("errormsg", "登录失败");
//			System.out.println("登录失败");
//			//return "index";
//			return "login";
//		}
	}
	
	@RequestMapping("/logins")
	public String logins(Model model,String username,String userpassword,Model model1,Model model2,HttpSession session,User user) {
		boolean result=userService.login(username, userpassword);
		if(result) {
			model1.addAttribute("username",username);
			int uid=userService.selectid(username);
			model2.addAttribute("userid",uid);
			session.setAttribute("username", username);
			System.out.println(username);
			System.out.println(userpassword);
			session.setAttribute("uid", uid);  //获取userid
			System.out.println(uid);
			System.out.println("登陆成功");
//			List<Relation> list=relationService.findAll();
//			model.addAttribute("relationlist",list);
			//Integer uid=(Integer)session.getAttribute("uid");
			System.out.println(uid);
			//List<Relation> list=relationService.findRelationById(uid);
			//return "redirect:relation.do";  //传给action
			return "informationinput";
			//return "relation";  //直接传给jsp
			
		}else {
			model1.addAttribute("errormsg", "登录失败");
			System.out.println("登录失败");
			//return "index";
			return "login";
		}
	}
	
	//用户注册
	@RequestMapping("/register")
	public String register(User user,Model model) {
		boolean result = userService.register(user);
		if(result) {
			return "index";
			//return "redirect:login.do";
		}else {
			model.addAttribute("errormsg", "注册失败");
			return "register";
		}
	}
	//报名错误
	@RequestMapping("/informationinputsss")
	public String informationinput(Student student,Model model,HttpServletRequest request,@RequestParam("user_img") MultipartFile user_img)throws Exception {
		System.out.println(user_img);
	    try {
			//上传图片
			String originalFilename = user_img.getOriginalFilename();	
			if(originalFilename!=null && !originalFilename.equals("")) {
				
				String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\")+1);
				String realPath = request.getServletContext().getRealPath("admins/bookimg");
				FileCopyUtils.copy(user_img.getBytes(), new File(realPath+"\\"+fileName));
				student.setUser_img(fileName);
				//user.setImg(fileName);
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("failMsg","上传图片失败");
			return "login";
		}
		boolean result = userService.informationinput(student,student.getUser_img());
		if(result) {
			return "redirect:login.jsp";
		}else {
			model.addAttribute("errormsg", "注册失败");
			return "register";
		}
	}
	
	//用户报名测试
	@RequestMapping("/informationinputs")
	public String informationinputs(Student student,Model model) {
		boolean result = userService.inputinformations(student);
		if(result) {
			System.out.println("成功");
			return "redirect:login.do";
		}else {
			model.addAttribute("errormsg", "注册失败");
			return "register";
		}
	}
	//报名测试2
	@RequestMapping("/informationinputss")
	public String registers(Student student,Model model,HttpServletRequest request,@RequestParam("user_img") MultipartFile user_img)throws Exception {
		System.out.println(user_img);
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
		boolean result = userService.inputinformationss(student,student.getUser_img());
		if(result) {
			return "redirect:login.jsp";
		}else {
			model.addAttribute("errormsg", "注册失败");
			return "register";
		}
	}
	//报名测试3
//	@RequestMapping("/informationinputsss")
//	public String registerss(Student student,@RequestParam("user_img") MultipartFile user_img)throws Exception {
//		System.out.println(user_img);
//	    return "informationinput";
//	}


}
