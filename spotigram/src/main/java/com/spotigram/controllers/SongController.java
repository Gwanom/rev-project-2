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
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public int saveSongsModel(@RequestBody SongsModel sm) {
		System.out.println(sm);
		return songService.save(sm);
	}
	
	@GetMapping("/{title}")
	@ResponseBody
	public SongsModel findByName(@PathVariable String title) {
		System.out.println(title);
		return songService.findBySongTitle(title);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public SongsModel findBySgSongId(@PathVariable int id) {
		System.out.println(id);
		return songService.findBySgSongId(id);
	}
}
