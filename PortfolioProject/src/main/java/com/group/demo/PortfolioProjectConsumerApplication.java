package com.group.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.group.entity.Project;
import com.group.model.service.ProjectService;

@SpringBootApplication(scanBasePackages = "com.group")
@EntityScan(basePackages = "com.group.entity")
@EnableJpaRepositories(basePackages = "com.group.model.persistence")
public class PortfolioProjectConsumerApplication implements CommandLineRunner{
	
	@Autowired
	ProjectService projectService;
	
	public static void main(String[] args) {
		SpringApplication.run(PortfolioProjectConsumerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		String decription1 = "This is a Java Springboot project designed to simulate a basic Banking app allowing for multiple users with their own accounts. You are able to create multiple bank accounts per user, transfer between accounts or deposit or withraw from external accounts. Each transaction is also stored and can be viewed in a transaction history page. This porject was done with many technologies inclusing Java Spring Boot, HTML with thymeleaf, CSS and SQL.";
		String decription2 = "This is a Java Springboot project designed to simulate a basic Shopping cart allowing for the adding and removing of preset products into a basket. The basket is able to hold mulitple products within it and is able to calculate the total price of the basket. When a basket is purchased the order is stored and can be viered. This project was done with many technologies inclusing Java Spring Boot, HTML with thymeleaf, CSS and SQL.";
		
		Project project1 = new Project(1, "Banking App Project", decription1, "https://github.com/AlexAzzopardi/BankingAppProject", "01/03/23", 1.0);
		Project project2 = new Project(2, "Shopping Cart Project", decription2, "https://github.com/AlexAzzopardi/ShoppingCartProject", "30/08/22", 1.0);
		projectService.addProject(project1);
		projectService.addProject(project2);
		
	}
}
