package com.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "informationlist";
		//return "relation";
	}
	@RequestMapping("/updaterelation")
	public String showStudentMessage(HttpSession session,Model model){
		Integer uid=(Integer)session.getAttribute("uid");
		List<Relation> list=relationService.findRelationById(uid);
//		List<Relation> list=relationService.findAll();
		model.addAttribute("relationlist",list);
		System.out.println("先传参到relationaction");
		return "addrelation";
		//return "relation";
	}
	//添加家庭关系
	@RequestMapping("/relationinput")
	public String register(HttpSession session,Model model,@RequestParam("relation_relation") String relation_relation,@RequestParam("relation_name") String relation_name,@RequestParam("relation_telephone") String relation_telephone,@RequestParam("relation_workunits") String relation_workunits) {
		Relation relation=new Relation();
		Integer userid=(Integer)session.getAttribute("uid");
		relation.setUserid(userid);
		relation.setRelation_name(relation_name);
		relation.setRelation_relation(relation_relation);
		relation.setRelation_telephone(relation_telephone);
		relation.setRelation_workunits(relation_workunits);
		boolean result = relationService.addRelation(relation);
		List<Relation> list=relationService.findRelationById(userid);
		model.addAttribute("relationlist",list);
		if(result) {
			return "addrelation";
			//return "redirect:login.do";
		}else {
			model.addAttribute("errormsg", "注册失败");
			return "register";
		}
	}
	//删除某条家庭关系
	@RequestMapping("/deleteRelationById")
	public String deleteCartByid(Integer id,Model model) {
		boolean result=relationService.deleteRelationById(id);
		if(result) {
			return "redirect:updaterelation.do";
		}else {
			model.addAttribute("errormsg", "删除失败");
			return "deletebyid";
		}
	}
	//显示需要修改的某条家庭关系  
	@RequestMapping("/showUpdateRelationById")
	public String showUserMessage(Integer id,HttpSession session,Model model){
		//Integer uid=(Integer)session.getAttribute("uid");
		System.out.println("输出relationid");
		System.out.println(id);
		List<Relation> list=relationService.findRelationByRelationId(id);
		model.addAttribute("relationlist",list);
		return "updaterelation";

	}
	//修改某条家庭关系
	@RequestMapping("/updateRelationmessage")
	public String updateRelationMessage(@RequestParam("relation_id") Integer relation_id,@RequestParam("relation_relation") String relation_relation,@RequestParam("relation_name") String relation_name,@RequestParam("relation_workunits") String relation_workunits,@RequestParam("relation_telephone") String relation_telephone,Integer id,HttpSession session,Model model){
		Relation relation=new Relation();
		relation.setRelation_relation(relation_relation);
		relation.setRelation_name(relation_name);
		relation.setRelation_telephone(relation_telephone);
		relation.setRelation_workunits(relation_workunits);
		boolean result=relationService.updateRelationMessage(relation, relation_id);
		//boolean result=userService.inputinformations(student);
		if(result) {
			
			return "redirect:updaterelation.do"; 
			//showUpdateRelationById
			//return "redirect:informationlist.do"; 
			//return "informationlist";
		}else {
			return "login";
		}


	}

}
