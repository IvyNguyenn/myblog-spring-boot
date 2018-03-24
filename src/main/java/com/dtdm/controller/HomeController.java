package com.dtdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dtdm.model.Post;
import com.dtdm.service.PostService;

@Controller
public class HomeController {

	@Autowired
	PostService postService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("posts", postService.findAll());
		return "index";
	}
	
	@GetMapping("/post")
	public String showPost(Model model) {
		model.addAttribute(new Post());
		return "post";
	}
	
	@GetMapping("/post/{id}")
	public String editPost(@PathVariable int id, Model model) {
		model.addAttribute("post", postService.findOne(id));
		return "post";
	}
}
