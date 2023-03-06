package com.group.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Projects")
public class Project {

	@Id
	private int projectId;
	private String projectName;
	@Column(length = 1000)
	private String description;
	private String link;
	private String date;
	private double version;
	
}
