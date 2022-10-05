package com.rohit.relation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class WelcomePage {
	@RequestMapping("/")
	public String showWelcomePage() {
		return "Welcome";
	}
}
