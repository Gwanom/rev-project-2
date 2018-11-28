package com.spotigram.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spotigram.models.PostsModel;
import com.spotigram.models.UserModel;
import com.spotigram.services.PostService;
import com.spotigram.services.UserServices;

@RestController
@RequestMapping("posts")
public class PostController {
	
	private PostService postService;
	
	public PostController() {
		super();
	}
	
	@Autowired
	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	@GetMapping
	public List<PostsModel> findAll(){
		List<PostsModel> results = postService.findAll();
		System.out.println(results);
		return results;
	}
	
	@GetMapping("/author/{userName}")
	@ResponseBody
	public Object findByUser(@PathVariable String userName){
		List<PostsModel> results = postService.findByAuthor(userName);
		return results;
	}
	
	@GetMapping("/song/{songId}")
	@ResponseBody
	public List<PostsModel> findByTopicSong(@PathVariable int songId){
		List<PostsModel> results = postService.findByTopicSong(songId);
		System.out.println(results);
		return results;
	}
	
	@GetMapping("/album/{albumId}")
	@ResponseBody
	public List<PostsModel> findByTopicAlbum(@PathVariable int albumId){
		List<PostsModel> results = postService.findByTopicSong(albumId);
		System.out.println(results);
		return results;
	}
	
	@GetMapping("/artist/{artistId}")
	@ResponseBody
	public List<PostsModel> findByTopicArtist(@PathVariable int artistId){
		List<PostsModel> results = postService.findByTopicSong(artistId);
		System.out.println(results);
		return results;
	}
}
