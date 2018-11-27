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
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public int saveArtistsModel(@RequestBody ArtistsModel am) {
		System.out.println(am);
		return artist.save(am);
	}
	
	@GetMapping("/name/{name}")
	@ResponseBody
	public ArtistsModel findByName(@PathVariable String name) {
		System.out.println(name);
		return artist.findByName(name);
	}
	
	@GetMapping("id/{id}")
	@ResponseBody
	public ArtistsModel findById(@PathVariable int id) {
		System.out.println(id);
		return artist.findById(id);
	}
}
