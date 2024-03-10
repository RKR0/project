package com.sbc.project.service;

import java.util.List;


import com.sbc.project.dto.ProjectDto;

public interface ProjectService {

	ProjectDto registerNewProject(ProjectDto project);
	
	String deleteProject(Integer projectId);
	
	ProjectDto updateProject(ProjectDto project);
	
	ProjectDto getprojectById(Integer projectId);
	
	List<ProjectDto> getAllProjects();

	
}
