package com.group.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.entity.Project;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer>{
	
}
