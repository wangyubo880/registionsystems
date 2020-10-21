package com.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
			return "informationinput";
		}else {
			model1.addAttribute("errormsg", "��¼ʧ��");
			System.out.println("��¼ʧ��");
			return "index";
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
}
