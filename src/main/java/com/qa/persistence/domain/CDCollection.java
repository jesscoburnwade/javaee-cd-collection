package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CD_COLLECTION")
public class CDCollection {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name = "CD_ID")
	private Long id;
	
	@Column(name = "TITLE")
	private String title;
	
	@OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	List<Artists> artist = new ArrayList<>();
	
	public CDCollection() {
	}
	
	public CDCollection(String title, List<Artists> artist) {
		this.title = title;
		this.artist = artist;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Artists> getArtists() {
		return artist;
	}

	public void setArtists(List<Artists> artist) {
		this.artist = artist;
	}
	

}
