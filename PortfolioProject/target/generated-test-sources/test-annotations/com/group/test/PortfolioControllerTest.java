package com.group.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.servlet.ModelAndView;

import com.group.controller.PortfolioController;
import com.group.entity.Project;
import com.group.model.service.ProjectService;
import com.group.model.service.ProjectServiceImpl;

class PortfolioControllerTest {
	
    @Mock
    private ProjectServiceImpl projectService;

    @InjectMocks
    private PortfolioController controller;

    @BeforeEach
    void setUp() throws Exception {
        // Set up mock data for projectService
        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1, "Project 1", "Description 1", "Link", "Date", 1.0));
        projects.add(new Project(2, "Project 1", "Description 1", "Link", "Date", 1.0));
        when(projectService.getAllProjects()).thenReturn(projects);
        when(projectService.getProjectById(1)).thenReturn(new Project(1, "Project 1", "Description 1", "Link", "Date", 1.0));
    }

    @Test
    void testAllProjectsPage() {
        // Call controller method
        ModelAndView modelAndView = controller.allProjectsPage();
        System.out.println(modelAndView);

        // Verify that the returned ModelAndView object is not null
        assertNotNull(modelAndView);

        // Verify that the returned ModelAndView object contains the "projects" attribute
        assertNotNull(modelAndView.getModel().get("projects"));
    }

    @Test
    void testProject1Page() {
        // Call controller method with projectId=1
        ModelAndView modelAndView = controller.project1Page(1);

        // Verify that the returned ModelAndView object is not null
        assertNotNull(modelAndView);

        // Verify that the returned ModelAndView object contains the "project" attribute
        assertNotNull(modelAndView.getModel().get("project"));
    }

}