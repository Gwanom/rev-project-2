package com.spotigram.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotigram.models.ArtistsModel;
import com.spotigram.repos.ArtistRepo;


@Service
public class ArtistServices {
	
	@Autowired
	private ArtistRepo artistRepo;
	
	public List<ArtistsModel> findAll() {
		return artistRepo.findAll();
	}
	
	public List<ArtistsModel> findByName(String name) {
		return artistRepo.findByName(name);
	}
}
