package com.sarthak.ContentCalendar.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.sarthak.ContentCalendar.model.Status;
import com.sarthak.ContentCalendar.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sarthak.ContentCalendar.model.Content;

@Repository
public class ContentJdbcTemplateRepo {

	private final JdbcTemplate jdbcTemplate;
	
	public ContentJdbcTemplateRepo(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private static Content mapRow(ResultSet rs, int rowNum) throws SQLException{
		return new Content(rs.getInt("id"),
				rs.getString("title"),
				rs.getString("desc"),
				Status.valueOf("status"),
				Type.valueOf(rs.getString("content_type")),
				rs.getObject("date_created", LocalDateTime.class),
				rs.getObject("date_updated", LocalDateTime.class),
				rs.getString("url"));
	}
	
	
	// Using JDBC template to run SQL queries and perform CRUD operations on the database	

	// Function to get all the contents from our database		
	public List<Content> getAllContent(){
		String sql = "Select * from Content";
		List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepo::mapRow);
		return contents;
	}
	
	// Function to create a content in our database
	public void createContent(String title, String desc, String status, String contentType, String url) {
		String sql = "Insert into Content(title, desc, status, contentType, date_created, url) values(?, ?, ?, ?, NOW(), ?)";
		jdbcTemplate.update(sql, title, desc, status, contentType, url);
	}
	
	// Function to update content in our database
	public void updateContent(int id, String title, String desc, String status, String contentType, String url) {
		String sql = "Update Content SET title=?, desc=?, status=?, contentType=?, date_created=NOW(), url=? WHERE id=?";
		jdbcTemplate.update(sql, title, desc, status, contentType, url, id);
	}
	
	// Function to delete content from our database
	public void deleteContent(int id) {
		String sql = "Delete from Content where id=?";
		jdbcTemplate.update(sql, id);	
	}
	
	public Content getContent(int id) {
		String sql = "Select * from Content where id=?";
		Content content = jdbcTemplate.queryForObject(sql, new Object[] {id}, ContentJdbcTemplateRepo::mapRow);
		return content;
	}
	
	
}
