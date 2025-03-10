package com.yaksha.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageDirectiveController {

	@GetMapping("/")
	public String showForm() {
		return "index";
	}

	@GetMapping("/pageDirective")
	public String showPageDirective(Model model) {
		return "pageDirective";
	}
}
