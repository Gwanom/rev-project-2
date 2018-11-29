package com.spotigram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spotigram.models.RepliesModel;
import com.spotigram.services.RepliesService;

@RestController
@RequestMapping("replies")
public class RepliesController {

	private RepliesService repliesService;

	public RepliesController() {
		super();
	}

	@Autowired
	public RepliesController(RepliesService repliesService) {
		super();
		this.repliesService = repliesService;
	}
	
	@GetMapping
	public List<RepliesModel> findAll(){
		System.out.println("repliescontroller.findall");
		return repliesService.findAll();
	}
	
	@GetMapping("/parent/{postId}")
	public List<RepliesModel> findByParent(@PathVariable int postId) {
		return repliesService.findByParent(postId);
	}
}
