package com.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.ExperienceService;

@Controller
public class ExperienceAction {
	@Autowired
	private ExperienceService experienceService;

}
