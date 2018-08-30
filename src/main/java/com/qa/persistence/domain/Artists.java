package com.qa.persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ARTISTS")
public class Artists {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "ARTIST_ID")
	private Long artistID;

	@Column(name = "ARTIST_NAME")
	private String artistName;
	
//	@ManyToOne(cascade= CascadeType.ALL)
//	@JoinColumn(name = "ARTISTS")
//	private CDCollection cdEntry;

	public Artists() {
	}
	
	public Artists(String artistName) {
		this.artistName = artistName;
	}
	
	public Long getId() {
		return artistID;
	}

	public void setId(Long id) {
		this.artistID = id;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
//	public CDCollection getCdEntry() {
//		return cdEntry;
//	}
//
//	public void setCdEntry(CDCollection cdEntry) {
//		this.cdEntry = cdEntry;
//	}
}
