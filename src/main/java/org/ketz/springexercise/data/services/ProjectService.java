package org.ketz.springexercise.data.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.ketz.springexercise.data.entities.Project;

public class ProjectService {

		private List<Project> projects = new LinkedList<>();
		
		public ProjectService(){
			short id=1;
			Project javaProject = this.createProject("Java Project", "This is a Java Project" , id++);
			Project javascriptProject = this.createProject("Javascript Project", "This is a Javascript Project", id++);
			Project htmlProject = this.createProject("HTML Project", "This is an HTML project", id++);
			
			this.projects.addAll(Arrays.asList(new Project[]{javaProject, javascriptProject, htmlProject}));
		}
		
		public List<Project> findAll(){
			return this.projects;
		}
		
		public Project find(Long projectId){
			return this.projects.stream().filter(p -> {
				return p.getProjectId().equals(projectId);
			}).collect(Collectors.toList()).get(0);
		}

		private Project createProject(String title, String description, short id) {
			Project project = new Project();
			project.setName(title);
			project.setAuthorizedFunds(new BigDecimal("100000"));
			project.setAuthorizedHours(new BigDecimal("1000"));
			project.setProjectId(Long.valueOf(id));
			project.setSpecial(false);
			project.setType("multi");
			project.setYear("2015");
			project.setDescription(description);
			return project;
		}
		
		
		
}
