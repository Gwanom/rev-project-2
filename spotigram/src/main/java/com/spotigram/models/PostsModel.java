package com.spotigram.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="posts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PostsModel {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sg_post_id")
	private int postId;
	
	@ManyToOne
	@JoinColumn(name="author_id")
    private UserModel author;
	
	@ManyToOne
	@JoinColumn(name="topic_song")
    private SongsModel topicSong;
	
	@ManyToOne
	@JoinColumn(name="topic_album")
    private AlbumsModel topicAlbum;
	
	@ManyToOne
	@JoinColumn(name="topic_artist")
    private ArtistsModel topicArtist;
	
    private String content;

    public PostsModel() {
		super();
	}

	public PostsModel(int postId, UserModel author, SongsModel topicSong, AlbumsModel topicAlbum,
			ArtistsModel topicArtist, String content) {
		super();
		this.postId = postId;
		this.author = author;
		this.topicSong = topicSong;
		this.topicAlbum = topicAlbum;
		this.topicArtist = topicArtist;
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + postId;
		result = prime * result + ((topicAlbum == null) ? 0 : topicAlbum.hashCode());
		result = prime * result + ((topicArtist == null) ? 0 : topicArtist.hashCode());
		result = prime * result + ((topicSong == null) ? 0 : topicSong.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostsModel other = (PostsModel) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (postId != other.postId)
			return false;
		if (topicAlbum == null) {
			if (other.topicAlbum != null)
				return false;
		} else if (!topicAlbum.equals(other.topicAlbum))
			return false;
		if (topicArtist == null) {
			if (other.topicArtist != null)
				return false;
		} else if (!topicArtist.equals(other.topicArtist))
			return false;
		if (topicSong == null) {
			if (other.topicSong != null)
				return false;
		} else if (!topicSong.equals(other.topicSong))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PostsModel [postId=" + postId + ", author=" + author.getUsername() + 
				", content=" + content + "]";
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public UserModel getAuthor() {
		return author;
	}

	public void setAuthor(UserModel author) {
		this.author = author;
	}

	public SongsModel getTopicSong() {
		return topicSong;
	}

	public void setTopicSong(SongsModel topicSong) {
		this.topicSong = topicSong;
	}

	public AlbumsModel getTopicAlbum() {
		return topicAlbum;
	}

	public void setTopicAlbum(AlbumsModel topicAlbum) {
		this.topicAlbum = topicAlbum;
	}

	public ArtistsModel getTopicArtist() {
		return topicArtist;
	}

	public void setTopicArtist(ArtistsModel topicArtist) {
		this.topicArtist = topicArtist;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
