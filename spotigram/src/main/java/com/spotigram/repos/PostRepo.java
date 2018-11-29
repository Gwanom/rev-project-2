package com.spotigram.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotigram.models.AlbumsModel;
import com.spotigram.models.ArtistsModel;
import com.spotigram.models.PostsModel;
import com.spotigram.models.SongsModel;
import com.spotigram.models.UserModel;

public interface PostRepo extends JpaRepository<PostsModel, Integer> {
	PostsModel findByPostId(int postId);
	
	List<PostsModel> findByAuthor(UserModel author);
	
	List<PostsModel> findByTopicSong(SongsModel topicSong);
	
	List<PostsModel> findByTopicAlbum(AlbumsModel topicAlbum);
	
	List<PostsModel> findByTopicArtist(ArtistsModel topicArtist);
}
