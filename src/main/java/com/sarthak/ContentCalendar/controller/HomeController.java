package com.sarthak.ContentCalendar.controller;

import com.sarthak.ContentCalendar.config.ContentCalendarProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("!dev")
@RestController
public class HomeController {

	private final ContentCalendarProperties properties;

	public HomeController(ContentCalendarProperties properties) {
		this.properties = properties;
	}

	@Value("${cc.welcomeMessage: Default message}")
	private String welcomeMessage;

	@Value("${cc.about: Default text}")
	private String about;


	@GetMapping("/")
	public ContentCalendarProperties home(){
		return properties;
	}

}
