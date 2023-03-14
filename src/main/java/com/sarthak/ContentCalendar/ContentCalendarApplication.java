package com.sarthak.ContentCalendar;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.sarthak.ContentCalendar.config.ContentCalendarProperties;
import com.sarthak.ContentCalendar.model.Content;
import com.sarthak.ContentCalendar.model.Status;
import com.sarthak.ContentCalendar.model.Type;
import com.sarthak.ContentCalendar.repository.ContentRepository;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApplication.class, args);
	}

}
