package com.spotigram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spotigram.models.SongsModel;
import com.spotigram.services.SongService;

@RestController
@RequestMapping("songs")
public class SongController {
	private SongService songService;
	
	public SongController() {
		super();
	}
	
	@Autowired
	public SongController(SongService songService) {
		super();
		this.songService = songService;
	}
	
	@GetMapping
	public List<SongsModel> findAll(){
		System.out.println(songService.findAll());
		return songService.findAll();
	}
}
