package com.spotigram.models;

public class PostsModel {
    private int sg_post_id;
    private int author_id;
    private int topic_song;
    private int topic_album;
    private int topic_artist;
    private String content;
    
    
	public PostsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostsModel(int sg_post_id, int author_id, int topic_song, int topic_album, int topic_artist,
			String content) {
		super();
		this.sg_post_id = sg_post_id;
		this.author_id = author_id;
		this.topic_song = topic_song;
		this.topic_album = topic_album;
		this.topic_artist = topic_artist;
		this.content = content;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + author_id;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + sg_post_id;
		result = prime * result + topic_album;
		result = prime * result + topic_artist;
		result = prime * result + topic_song;
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
		if (author_id != other.author_id)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (sg_post_id != other.sg_post_id)
			return false;
		if (topic_album != other.topic_album)
			return false;
		if (topic_artist != other.topic_artist)
			return false;
		if (topic_song != other.topic_song)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PostsModel [sg_post_id=" + sg_post_id + ", author_id=" + author_id + ", topic_song=" + topic_song
				+ ", topic_album=" + topic_album + ", topic_artist=" + topic_artist + ", content=" + content + "]";
	}
	public int getSg_post_id() {
		return sg_post_id;
	}
	public void setSg_post_id(int sg_post_id) {
		this.sg_post_id = sg_post_id;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getTopic_song() {
		return topic_song;
	}
	public void setTopic_song(int topic_song) {
		this.topic_song = topic_song;
	}
	public int getTopic_album() {
		return topic_album;
	}
	public void setTopic_album(int topic_album) {
		this.topic_album = topic_album;
	}
	public int getTopic_artist() {
		return topic_artist;
	}
	public void setTopic_artist(int topic_artist) {
		this.topic_artist = topic_artist;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    
    
    

}
