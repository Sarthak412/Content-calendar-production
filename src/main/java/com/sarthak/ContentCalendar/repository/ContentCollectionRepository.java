package com.sarthak.ContentCalendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;

import com.sarthak.ContentCalendar.model.Content;
import com.sarthak.ContentCalendar.model.Status;
import com.sarthak.ContentCalendar.model.Type;

import jakarta.annotation.PostConstruct;


@Repository
public class ContentCollectionRepository {

	private final List<Content> contentList = new ArrayList<>();
	
	public ContentCollectionRepository() {
		
	}

	// List all functionality
	public List<Content> findAll(){
		return contentList;
	}

	// find content using a Id
	public Optional <Content> findById(Integer id){
		return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
	}

	//	Create functionality
	public void save(Content content) {
		contentList.removeIf(c-> c.id().equals(content.id()));
		contentList.add(content);
	}

	// Read Functionality
	
	// Update Functionality
	public boolean existsById(Integer id) {
		return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
	}
		
	// Delete Functionality
	public void deleteById(Integer id) {
		contentList.removeIf(c-> c.id().equals(id));
	}
	
	@PostConstruct
	private void init() {
		Content c = new Content(1,
				"Content-calendar API",
				"REST API using Spring boot",
				Status.IDEA,
				Type.COURSE,
				LocalDateTime.now(),
				null,
				"sarthakkamble.io");
				
		Content a = new Content(2,
				"Project 50",
				"50 days of proper discipline",
				Status.IDEA,
				Type.COURSE,
				LocalDateTime.now(),
				null,
				"sarthakkamble.io");
		
		contentList.add(c);
		contentList.add(a);		
		
	}
	
}
