package com.spotigram.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="songs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SongsModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int sgSongId;
    private String songTitle;
    private int album;
    private int artist;
    private String video;
    private String audioSample;
    
	public SongsModel() {
		super();
	}
	public SongsModel(int sgSongId, String songTitle, int album, int artist, String video, String audioSample) {
		super();
		this.sgSongId = sgSongId;
		this.songTitle = songTitle;
		this.album = album;
		this.artist = artist;
		this.video = video;
		this.audioSample = audioSample;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + album;
		result = prime * result + artist;
		result = prime * result + ((audioSample == null) ? 0 : audioSample.hashCode());
		result = prime * result + sgSongId;
		result = prime * result + ((songTitle == null) ? 0 : songTitle.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
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
		SongsModel other = (SongsModel) obj;
		if (album != other.album)
			return false;
		if (artist != other.artist)
			return false;
		if (audioSample == null) {
			if (other.audioSample != null)
				return false;
		} else if (!audioSample.equals(other.audioSample))
			return false;
		if (sgSongId != other.sgSongId)
			return false;
		if (songTitle == null) {
			if (other.songTitle != null)
				return false;
		} else if (!songTitle.equals(other.songTitle))
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SongsModel [sgSongId=" + sgSongId + ", songTitle=" + songTitle + ", album=" + album + ", artist="
				+ artist + ", video=" + video + ", audioSample=" + audioSample + "]";
	}
	public int getSgSongId() {
		return sgSongId;
	}
	public void setSgSongId(int sgSongId) {
		this.sgSongId = sgSongId;
	}
	public String getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public int getAlbum() {
		return album;
	}
	public void setAlbum(int album) {
		this.album = album;
	}
	public int getArtist() {
		return artist;
	}
	public void setArtist(int artist) {
		this.artist = artist;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getAudioSample() {
		return audioSample;
	}
	public void setAudioSample(String audioSample) {
		this.audioSample = audioSample;
	}

}
