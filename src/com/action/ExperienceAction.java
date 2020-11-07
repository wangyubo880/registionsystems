package com.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Experience;
import com.bean.Relation;
import com.service.ExperienceService;

@Controller
public class ExperienceAction {
	@Autowired
	private ExperienceService experienceService;
	//显示当前用户的学习经历
	@RequestMapping("/experience")
	public String showStudentExperienceMessage(HttpSession session,Model model){
		Integer uid=(Integer)session.getAttribute("uid");
		List<Experience> list=experienceService.findExperienceById(uid);
//		List<Relation> list=relationService.findAll();
		model.addAttribute("experiencelist",list);
		//System.out.println("先传参到relationaction");
		return "informationlistNew";
		//return "relation";
	}
	@RequestMapping("/updateexperience")
	public String showStudentMessage(HttpSession session,Model model){
		Integer uid=(Integer)session.getAttribute("uid");
		List<Experience> list=experienceService.findExperienceById(uid);
//		List<Relation> list=relationService.findAll();
		model.addAttribute("experiencelist",list);
		System.out.println("先传参到relationaction");
		return "addexperience";
		//return "relation";
	}
	//添加学习经历
	@RequestMapping("/experienceinput")
	public String addExperience(HttpSession session,Model model,@RequestParam("experience_startdate") String experience_startdate,@RequestParam("experience_enddate") String experience_enddate,@RequestParam("experience_place") String experience_place,@RequestParam("experience_position") String experience_position) {
		Experience experience=new Experience();
		Integer userid=(Integer)session.getAttribute("uid");
		experience.setExperience_startdate(experience_startdate);
		experience.setUserid(userid);
		experience.setExperience_enddate(experience_enddate);
		experience.setExperience_place(experience_place);
		experience.setExperience_position(experience_position);
		
		boolean result = experienceService.addExperience(experience);
		List<Experience> list=experienceService.findExperienceById(userid);
		model.addAttribute("experiencelist",list);
		if(result) {
			return "addexperience";
			//return "redirect:login.do";
		}else {
			model.addAttribute("errormsg", "注册失败");
			return "register";
		}
	}
	//删除某条学习经历
	@RequestMapping("/deleteExperienceById")
	public String deleteExperienceByid(Integer id,Model model) {
		boolean result=experienceService.deleteExperienceById(id);
		if(result) {
			return "redirect:updateexperience.do";
		}else {
			model.addAttribute("errormsg", "删除失败");
			return "deletebyid";
		}
	}
	//显示需要修改的某条学习经历
	@RequestMapping("/showUpdateExperienceById")
	public String showExperienceMessage(Integer id,HttpSession session,Model model){
		//Integer uid=(Integer)session.getAttribute("uid");
		System.out.println("输出experienceid");
		System.out.println(id);
		List<Experience> list=experienceService.findExperienceByExperienceId(id);
		model.addAttribute("experiencelist",list);
		return "updateexperience";

	}
	//修改某条学习经历
	@RequestMapping("/updateExperiencemessage")
	public String updateExperienceMessage(@RequestParam("experience_startdate") String experience_startdate,@RequestParam("experience_enddate") String experience_enddate,@RequestParam("experience_place") String experience_place,@RequestParam("experience_position") String experience_position,@RequestParam("experience_id") Integer experience_id,HttpSession session,Model model){
		Experience experience=new Experience();
		//Integer userid=(Integer)session.getAttribute("uid");
		experience.setExperience_startdate(experience_startdate);
		experience.setExperience_enddate(experience_enddate);
		experience.setExperience_place(experience_place);
		experience.setExperience_position(experience_position);
		boolean result=experienceService.updateExperienceMessage(experience, experience_id);
		//boolean result=userService.inputinformations(student);
		if(result) {
			
			return "redirect:updateexperience.do"; 
			//showUpdateRelationById
			//return "redirect:informationlist.do"; 
			//return "informationlist";
		}else {
			return "login";
		}


	}

}
