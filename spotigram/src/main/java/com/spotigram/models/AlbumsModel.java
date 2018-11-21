package com.spotigram.models;

public class AlbumsModel {
    private int album_id;
    private String album_title;
    private int artist;
    
    
    
	public AlbumsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlbumsModel(int album_id, String album_title, int artist) {
		super();
		this.album_id = album_id;
		this.album_title = album_title;
		this.artist = artist;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + album_id;
		result = prime * result + ((album_title == null) ? 0 : album_title.hashCode());
		result = prime * result + artist;
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
		AlbumsModel other = (AlbumsModel) obj;
		if (album_id != other.album_id)
			return false;
		if (album_title == null) {
			if (other.album_title != null)
				return false;
		} else if (!album_title.equals(other.album_title))
			return false;
		if (artist != other.artist)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AlbumsModel [album_id=" + album_id + ", album_title=" + album_title + ", artist=" + artist + "]";
	}
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public String getAlbum_title() {
		return album_title;
	}
	public void setAlbum_title(String album_title) {
		this.album_title = album_title;
	}
	public int getArtist() {
		return artist;
	}
	public void setArtist(int artist) {
		this.artist = artist;
	}
    
    

}
