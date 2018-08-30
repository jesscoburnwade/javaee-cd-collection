package com.qa.persistence.repository;

import java.util.Collection;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Artists;
import com.qa.persistence.domain.CDCollection;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ArtistDBRepository implements ArtistsRepository{
	
	@PersistenceContext(unitName ="primary")
	EntityManager entityManager;
	
	@Inject
	JSONUtil util;

	@Override
	public String getAllArtistEntries() {
		Query query = entityManager.createQuery("SELECT a FROM CDCollection a");
		Collection<Artists> artistList = (Collection<Artists>) query.getResultList();
		return util.getJSONForObject(artistList);
	}

	@Override
	@Transactional(REQUIRED)
	public String createArtistEntry(String createArtist) {
		Artists artistEntry = util.getObjectForJSON(createArtist, Artists.class);
		entityManager.persist(artistEntry);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateArtistEntry(Long id, String artistToUpdate) {
		CDCollection updatedArtistEntry = util.getObjectForJSON(artistToUpdate, CDCollection.class);
		CDCollection artistFromDB = findArtist(id);
		if (artistToUpdate != null) {
			artistFromDB = updatedArtistEntry;
			entityManager.merge(artistFromDB);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteArtistEntry(Long id) {
		CDCollection artistInDB = findArtist(id);
		if (artistInDB != null) {
			entityManager.remove(artistInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	
	private CDCollection findArtist(Long id) {
		return entityManager.find(CDCollection.class, id);
	}

}
