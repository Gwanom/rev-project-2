package com.spotigram.models;

public class SongsModel {
    private int sg_song_id;
    private String song_title;
    private int album;
    private int artist;
    private String video;
    private String audio_sample;
    
	public SongsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SongsModel(int sg_song_id, String song_title, int album, int artist, String video, String audio_sample) {
		super();
		this.sg_song_id = sg_song_id;
		this.song_title = song_title;
		this.album = album;
		this.artist = artist;
		this.video = video;
		this.audio_sample = audio_sample;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + album;
		result = prime * result + artist;
		result = prime * result + ((audio_sample == null) ? 0 : audio_sample.hashCode());
		result = prime * result + sg_song_id;
		result = prime * result + ((song_title == null) ? 0 : song_title.hashCode());
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
		if (audio_sample == null) {
			if (other.audio_sample != null)
				return false;
		} else if (!audio_sample.equals(other.audio_sample))
			return false;
		if (sg_song_id != other.sg_song_id)
			return false;
		if (song_title == null) {
			if (other.song_title != null)
				return false;
		} else if (!song_title.equals(other.song_title))
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
		return "SongsModel [sg_song_id=" + sg_song_id + ", song_title=" + song_title + ", album=" + album + ", artist="
				+ artist + ", video=" + video + ", audio_sample=" + audio_sample + "]";
	}
	public int getSg_song_id() {
		return sg_song_id;
	}
	public void setSg_song_id(int sg_song_id) {
		this.sg_song_id = sg_song_id;
	}
	public String getSong_title() {
		return song_title;
	}
	public void setSong_title(String song_title) {
		this.song_title = song_title;
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
	public String getAudio_sample() {
		return audio_sample;
	}
	public void setAudio_sample(String audio_sample) {
		this.audio_sample = audio_sample;
	}

}
