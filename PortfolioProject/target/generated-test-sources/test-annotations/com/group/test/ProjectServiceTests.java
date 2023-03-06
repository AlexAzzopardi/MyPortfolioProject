package com.group.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.group.entity.Project;
import com.group.model.persistence.ProjectDao;
import com.group.model.service.ProjectServiceImpl;

class ProjectServiceTests {

	@InjectMocks
	private ProjectServiceImpl projectService;
	
	@Mock
	private ProjectDao projectDao;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testAddProject() {
		Project project = new Project(1, "Project 1", "Description 1", "Link", "Date", 1.0);
		projectService.addProject(project);
	}
	
	@Test
	void testGetProjectById() {
		Project project = new Project(1, "Project 1", "Description 1", "Link", "Date", 1.0);
		when(projectDao.findById(1)).thenReturn(Optional.of(project));
		assertEquals(project, projectService.getProjectById(1));
	}
	
	@Test
	void testGetAllProjects() {
		List<Project> projects = new ArrayList<>();
		projects.add(new Project(1, "Project 1", "Description 1", "Link", "Date", 1.0));
		projects.add(new Project(2, "Project 1", "Description 1", "Link", "Date", 1.0));
		projects.add(new Project(3, "Project 1", "Description 1", "Link", "Date", 1.0));
		when(projectDao.findAll()).thenReturn(projects);
		assertEquals(projects, projectService.getAllProjects());
	}
	
	@Test
	void testGetProjectByIdNotFound() {
		when(projectDao.findById(1)).thenReturn(Optional.empty());
		assertNull(projectService.getProjectById(1));
	}

}
