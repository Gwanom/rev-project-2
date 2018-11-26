package com.spotigram.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name="albums")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AlbumsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="album_id")
    private int id;
	@Column(name="album_title")
    private String title;
	@Column(name="artist")
    private int artist;
	
	public AlbumsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlbumsModel(int id, String title, int artist) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getArtist() {
		return artist;
	}

	public void setArtist(int artist) {
		this.artist = artist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + artist;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (artist != other.artist)
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumsModel [id=" + id + ", title=" + title + ", artist=" + artist + "]";
	}
    
}
