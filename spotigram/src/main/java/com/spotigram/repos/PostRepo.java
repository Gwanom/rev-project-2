package com.spotigram.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotigram.models.PostsModel;
import com.spotigram.models.UserModel;

public interface PostRepo extends JpaRepository<PostsModel, Integer> {
	List<PostsModel> findByAuthor(UserModel author);
	
	List<PostsModel> findByTopicSong(int topicSong);
	
	List<PostsModel> findByTopicAlbum(int topicAlbum);
	
	List<PostsModel> findByTopicArtist(int topicArtist);
}
