package com.musephoria.entity;
// Generated Oct 19, 2015 11:46:19 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Track generated by hbm2java
 */
@Entity
@Table(name = "track", catalog = "musephoria", uniqueConstraints = @UniqueConstraint(columnNames = "CdId") )
@SuppressWarnings("serial")
public class Track implements java.io.Serializable {

	private Integer trackId;
	private Cd cd;
	private String description;
	private String artist;
	private String duration;

	public Track() {
	}

	public Track(Cd cd, String artist, String duration) {
		this.cd = cd;
		this.artist = artist;
		this.duration = duration;
	}

	public Track(Cd cd, String description, String artist, String duration) {
		this.cd = cd;
		this.description = description;
		this.artist = artist;
		this.duration = duration;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "TrackId", unique = true, nullable = false)
	public Integer getTrackId() {
		return this.trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CdId", unique = true, nullable = false)
	public Cd getCd() {
		return this.cd;
	}

	public void setCd(Cd cd) {
		this.cd = cd;
	}

	@Column(name = "Description", length = 25)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Artist", nullable = false, length = 25)
	public String getArtist() {
		return this.artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Column(name = "Duration", nullable = false, length = 25)
	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}