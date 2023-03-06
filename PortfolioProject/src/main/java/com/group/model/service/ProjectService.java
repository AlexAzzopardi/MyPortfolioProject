package com.group.model.service;

import java.util.List;

import com.group.entity.Project;

public interface ProjectService {

	public void addProject(Project project);
	public Project getProjectById(int projectId);
	public List<Project> getAllProjects();
	
}
