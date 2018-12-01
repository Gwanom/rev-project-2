package com.spotigram.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotigram.models.AlbumsModel;
import com.spotigram.repos.AlbumRepo;

@Service
public class AlbumServices {
	
	@Autowired
	private AlbumRepo albumRepo;
	
	public List<AlbumsModel> findAll() {
		return albumRepo.findAll();
	}
	
	public int save(AlbumsModel am) {
		albumRepo.save(am);
		return am.getId();
	}
	
	public AlbumsModel findById(int id) {
		return albumRepo.findById(id);
	}
	
	public List<AlbumsModel> findByTitle(String title) {
		return albumRepo.findByTitle(title);
	}
}
