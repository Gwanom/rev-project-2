package com.spotigram.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotigram.models.SongsModel;
import com.spotigram.repos.SongRepo;

@Service
public class SongService {

		@Autowired
		private SongRepo songRepo;
		
		public List<SongsModel> findAll(){
			return songRepo.findAll();
		}
}
