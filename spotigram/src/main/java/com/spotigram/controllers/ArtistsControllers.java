package com.spotigram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.spotigram.models.AlbumsModel;
import com.spotigram.models.ArtistsModel;
import com.spotigram.services.ArtistServices;

@RestController
@RequestMapping("artists")
public class ArtistsControllers {
	private ArtistServices artist;
	
	public ArtistsControllers() {
		super();
	}
	
	@Autowired
	public ArtistsControllers(ArtistServices artist) {
		super();
		this.artist = artist;
	}
	
	@GetMapping
	public List<ArtistsModel> findAll() {
		System.out.println(artist.findAll());
		return artist.findAll();
	}
	
	@GetMapping("/id/{id}")
	@ResponseBody
	public ArtistsModel findById(@PathVariable int id) {
		return artist.findById(id);
	}
	
	@GetMapping("/name/{name}")
	@ResponseBody
	public List<ArtistsModel> findByName(@PathVariable String name) {
		System.out.println(name);
		return artist.findByName(name);
	}
}
