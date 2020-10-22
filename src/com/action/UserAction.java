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
public class UserAction {
	@Autowired
	private UserService userService;
	//�û���¼
	@RequestMapping("/login")
	public String login(String username,String userpassword,Model model1,Model model2,HttpSession session,User user) {
		boolean result=userService.login(username, userpassword);
		if(result) {
			model1.addAttribute("username",username);
			int uid=userService.selectid(username);
			model2.addAttribute("userid",uid);
			session.setAttribute("username", username);
			session.setAttribute("uid", uid);
			System.out.println("��½�ɹ�");
			return "informationinput2";
			//return "redirect:informationinput2.jsp";
		}else {
			model1.addAttribute("errormsg", "��¼ʧ��");
			System.out.println("��¼ʧ��");
			//return "index";
			return "informationinput2";
		}
	}
	//�û�ע��
	@RequestMapping("/register")
	public String register(User user,Model model) {
		boolean result = userService.register(user);
		if(result) {
			return "redirect:login.do";
		}else {
			model.addAttribute("errormsg", "ע��ʧ��");
			return "register";
		}
	}
	//��������
	@RequestMapping("/informationinput")
	public String informationinput(Student student,Model model,HttpServletRequest request,@RequestParam("user_img") MultipartFile user_img)throws Exception {
		System.out.println(user_img);
	    try {
			//�ϴ�ͼƬ
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
			model.addAttribute("failMsg","�ϴ�ͼƬʧ��");
			return "login";
		}
		boolean result = userService.informationinput(student,student.getUser_img());
		if(result) {
			return "redirect:login.jsp";
		}else {
			model.addAttribute("errormsg", "ע��ʧ��");
			return "register";
		}
	}
	
	//�û���������
	@RequestMapping("/informationinputs")
	public String informationinputs(Student student,Model model) {
		boolean result = userService.inputinformations(student);
		if(result) {
			System.out.println("�ɹ�");
			return "redirect:login.do";
		}else {
			model.addAttribute("errormsg", "ע��ʧ��");
			return "register";
		}
	}
	//��������2
	@RequestMapping("/informationinputss")
	public String registers(Student student,Model model,HttpServletRequest request,@RequestParam("user_img") MultipartFile user_img)throws Exception {
		System.out.println(user_img);
	    try {
			//�ϴ�ͼƬ
			String originalFilename = user_img.getOriginalFilename();	
			if(originalFilename!=null && !originalFilename.equals("")) {
				
				String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\")+1);
				String realPath = request.getServletContext().getRealPath("admins/bookimg");
				FileCopyUtils.copy(user_img.getBytes(), new File(realPath+"\\"+fileName));
				student.setUser_img(fileName);
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("failMsg","�ϴ�ͼƬʧ��");
			return "login";
		}
		boolean result = userService.inputinformationss(student,student.getUser_img());
		if(result) {
			return "redirect:login.jsp";
		}else {
			model.addAttribute("errormsg", "ע��ʧ��");
			return "register";
		}
	}
	//��������3
//	@RequestMapping("/informationinputsss")
//	public String registerss(Student student,@RequestParam("user_img") MultipartFile user_img)throws Exception {
//		System.out.println(user_img);
//	    return "informationinput";
//	}


}
