package com.qa.project2.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String songName;

	@Column(nullable = false)
	private String artist;

	@Column(nullable = false)
	private String releaseYear;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String year) {
		this.releaseYear = year;
	}

	public Music(long id, String songName, String artist, String year) {
		super();
		this.id = id;
		this.songName = songName;
		this.artist = artist;
		this.releaseYear = year;
	}

	public Music(String songName, String artist, String year) {
		super();
		this.songName = songName;
		this.artist = artist;
		this.releaseYear = year;
	}

	public Music() {}

	@Override
	public String toString() {
		return "Music [id=" + id + ", songName=" + songName + ", artist=" + artist + ", year=" + releaseYear + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(artist, id, songName, releaseYear);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		return Objects.equals(artist, other.artist) && id == other.id && Objects.equals(songName, other.songName)
				&& Objects.equals(releaseYear, other.releaseYear);
	}
}