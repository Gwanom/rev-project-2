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
		
		public SongsModel findBySongTitle(String songTitle) {
			return songRepo.findBySongTitle(songTitle);
		}
		
		public SongsModel findBySgSongId(int songId) {
			return songRepo.findBySongId(songId);
		}

		public int save(SongsModel sm) {
			songRepo.save(sm);
			return sm.getSongId();
		}
}
