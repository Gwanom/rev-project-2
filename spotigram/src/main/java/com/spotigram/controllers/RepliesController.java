package com.spotigram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public int saveRepliesModel(@RequestBody RepliesModel rm) {
		return repliesService.save(rm);
	}
	
	@GetMapping("/parent/{postId}")
	public List<RepliesModel> findByParent(@PathVariable int postId) {
		return repliesService.findByParent(postId);
	}
}
