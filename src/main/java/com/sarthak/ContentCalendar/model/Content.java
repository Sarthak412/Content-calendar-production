package com.sarthak.ContentCalendar.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;

public record Content(
		
		@Id
		Integer id,
		
		@NotBlank 
		String title, 

		@Column(value="description")
		String desc,
		Status status,
		Type contentType,
		LocalDateTime dateCreated,
		LocalDateTime dateUpdated,
		String url
) {
	
}
