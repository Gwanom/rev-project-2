package com.spotigram.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="songs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SongsModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sg_song_id")
    private int songId;
    private String songTitle;
    
    @ManyToOne
    @JoinColumn(name="album")
    private AlbumsModel album;
    
    @ManyToOne
    @JoinColumn(name="artist")
    private ArtistsModel artist;
    
    private String video;
    private String audioSample;
    
	public SongsModel() {
		super();
	}
	
	public SongsModel(int songId, String songTitle, AlbumsModel album, ArtistsModel artist, String video,
			String audioSample) {
		super();
		this.songId = songId;
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
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((audioSample == null) ? 0 : audioSample.hashCode());
		result = prime * result + songId;
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
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (audioSample == null) {
			if (other.audioSample != null)
				return false;
		} else if (!audioSample.equals(other.audioSample))
			return false;
		if (songId != other.songId)
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
		return "SongsModel [songId=" + songId + ", songTitle=" + songTitle + ", album=" + album + ", artist="
				+ artist + ", video=" + video + ", audioSample=" + audioSample + "]";
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public AlbumsModel getAlbum() {
		return album;
	}

	public void setAlbum(AlbumsModel album) {
		this.album = album;
	}

	public ArtistsModel getArtist() {
		return artist;
	}

	public void setArtist(ArtistsModel artist) {
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