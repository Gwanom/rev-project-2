package com.spotigram.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spotigram.models.AlbumsModel;
import com.spotigram.models.ArtistsModel;
import com.spotigram.models.PostsModel;
import com.spotigram.models.SongsModel;
import com.spotigram.models.UserModel;
import com.spotigram.repos.AlbumRepo;
import com.spotigram.repos.ArtistRepo;
import com.spotigram.repos.PostRepo;
import com.spotigram.repos.SongRepo;
import com.spotigram.repos.UserRepo;

@Service
public class PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private SongRepo songRepo;
	
	@Autowired
	private AlbumRepo albumRepo;
	
	@Autowired
	private ArtistRepo artistRepo;
	
	public List<PostsModel> findAll(){
		return postRepo.findAll();
	}
	
	public int save(PostsModel pm) {
		postRepo.save(pm);
		return pm.getPostId();
	}
	
	public PostsModel findByPostId(int postId) {
		return postRepo.findByPostId(postId);
	}
	
	public List<PostsModel> findByAuthor(String username){
		List<UserModel> user = userRepo.findByUsername(username);
		return postRepo.findByAuthor(user.get(0));
	}
	
	public List<PostsModel> findByTopicSong(String songTitle){
		SongsModel s = songRepo.findBySongTitle(songTitle);
		return postRepo.findByTopicSong(s);
	}
	
	public List<PostsModel> findByTopicAlbum(String title){
		List<AlbumsModel> a = albumRepo.findByTitle(title);
		return postRepo.findByTopicAlbum(a.get(0));
	}
	
	public List<PostsModel> findByTopicArtist(String artist){
		ArtistsModel a = artistRepo.findByName(artist);
		return postRepo.findByTopicArtist(a);
	}
	
}
