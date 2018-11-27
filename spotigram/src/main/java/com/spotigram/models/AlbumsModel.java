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
@Table(name="albums")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AlbumsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="album_id")
    private int id;
	@Column(name="album_title")
    private String title;
	
	@ManyToOne
	@JoinColumn(name="artist") 
    private ArtistsModel artist;
	
	public AlbumsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlbumsModel(int id, String title, ArtistsModel artist) {
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

	public ArtistsModel getArtist() {
		return artist;
	}

	public void setArtist(ArtistsModel artist) {
		this.artist = artist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
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
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
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
