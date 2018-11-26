package com.spotigram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.spotigram.models.AlbumsModel;
import com.spotigram.services.AlbumServices;

@RestController
@RequestMapping("albums")
public class AlbumsControllers {
private AlbumServices album;
	
	public AlbumsControllers() {
		super();
	}
	
	@Autowired
	public AlbumsControllers(AlbumServices album) {
		super();
		this.album = album;
	}
	
	@GetMapping
	public List<AlbumsModel> findAll() {
		System.out.println(album.findAll());
		return album.findAll();
	}
	
	@GetMapping("/id/{id}")
	@ResponseBody
	public AlbumsModel findById(@PathVariable int id) {
		return album.findById(id);
	}
	
	@GetMapping("/title/{title}")
	@ResponseBody
	public List<AlbumsModel> findByTitle(@PathVariable String title) {
		System.out.println(title);
		return album.findByTitle(title);
	}
}
