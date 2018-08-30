package com.qa.persistence.repository;

import com.qa.persistence.domain.CDCollection;

public interface ArtistsRepository {

	String getAllArtistEntries();
	
	String createArtistEntry(String createArtist);
	
	String updateArtistEntry(Long id, String artistToUpdate);
	
	String deleteArtistEntry(Long id);
}
