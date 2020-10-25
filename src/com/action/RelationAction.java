package com.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Relation;
import com.bean.User;
import com.service.RelationService;
@Controller
public class RelationAction {
	@Autowired
	private RelationService relationService;
	@RequestMapping("/relation")
	public String showUserMessage(HttpSession session,Model model){
		Integer uid=(Integer)session.getAttribute("uid");
		List<Relation> list=relationService.findRelationById(uid);
//		List<Relation> list=relationService.findAll();
		model.addAttribute("relationlist",list);
		System.out.println("先传参到relationaction");
		return "informationinput";
		//return "relation";
	}

}
