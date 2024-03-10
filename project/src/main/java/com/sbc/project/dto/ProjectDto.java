package com.sbc.project.dto;

import java.util.Date;

import com.sbc.project.model.Project;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

	int id; 
	
	String name;
	
	String description;
	
	Date startDate;
	
	Date endDate;
}
