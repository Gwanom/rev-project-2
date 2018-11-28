package com.spotigram.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spotigram.models.PostsModel;
import com.spotigram.models.UserModel;
import com.spotigram.repos.PostRepo;
import com.spotigram.repos.UserRepo;

@Service
public class PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public List<PostsModel> findAll(){
		return postRepo.findAll();
	}
	
	public List<PostsModel> findByAuthor(String username){
		List<UserModel> user = userRepo.findByUsername(username);
		return postRepo.findByAuthor(user.get(0));
	}
	
	public List<PostsModel> findByTopicSong(int topicSong){
		return postRepo.findByTopicSong(topicSong);
	}
	
	public List<PostsModel> findByTopicAlbum(int topicAlbum){
		return postRepo.findByTopicAlbum(topicAlbum);
	}
	
	public List<PostsModel> findByTopicArtist(int topicArtist){
		return postRepo.findByTopicArtist(topicArtist);
	}
	
}
