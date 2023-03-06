package com.group.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.entity.Project;
import com.group.model.persistence.ProjectDao;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	@Override
	public void addProject(Project project) {
		projectDao.save(project);
	}
	
	@Override
	public Project getProjectById(int projectId) {
		return projectDao.findById(projectId).orElse(null);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectDao.findAll();
	}

}
