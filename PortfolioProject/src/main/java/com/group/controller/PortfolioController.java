package com.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.group.model.service.ProjectService;

@Controller
@SessionAttributes({"pages"})
public class PortfolioController {

	@Autowired
	ProjectService projectService;
	
	@RequestMapping("/")
	public ModelAndView homePage() {
		return new ModelAndView("HomePage");
	}
	
	@RequestMapping("/profilePage")
	public ModelAndView profilePage() {
		return new ModelAndView("ProfilePage");
	}
	
	@RequestMapping("/projectPage")
	public ModelAndView allProjectsPage() {
		return new ModelAndView("ProjectPage", "projects", projectService.getAllProjects());
	}
	
	@RequestMapping("/singleProjectPage")
	public ModelAndView project1Page(@RequestParam("projectId") int projectId) {
		return new ModelAndView("SingleProject", "project", projectService.getProjectById(projectId));
	}

}
