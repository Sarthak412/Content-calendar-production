package com.sarthak.ContentCalendar.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.sarthak.ContentCalendar.model.Content;
import com.sarthak.ContentCalendar.model.Status;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
	
	List<Content> findAllByTitleContains(String keyword);

	@Query("""
			Select * from Content where status = :status 
			""")
	List<Content> listByStatus(@Param("status") Status status);
	
}
