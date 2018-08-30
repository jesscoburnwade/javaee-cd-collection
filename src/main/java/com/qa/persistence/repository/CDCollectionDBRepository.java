package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

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
public class CDCollectionDBRepository implements CDCollectionRepository {
	
	@PersistenceContext(unitName = "primary")
	EntityManager entityManager;
	
	@Inject
	JSONUtil util;

	@Override
	public String getAllCDEntries() {
		Query query = entityManager.createQuery("SELECT a FROM CDCollection a");
		Collection<CDCollection> cdCollection = (Collection<CDCollection>) query.getResultList();
		return util.getJSONForObject(cdCollection);
	}

	@Override
	@Transactional(REQUIRED)
	public String createCDEntry(String entry) {
		CDCollection cdEntry = util.getObjectForJSON(entry, CDCollection.class);
		entityManager.persist(cdEntry);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateCDEntry(Long id, String entryToUpdate) {
		CDCollection updatedCDEntry = util.getObjectForJSON(entryToUpdate, CDCollection.class);
		CDCollection cdFromDB = findCD(id);
		if (entryToUpdate != null) {
			cdFromDB = updatedCDEntry;
			entityManager.merge(cdFromDB);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteCDEntry(Long id) {
		CDCollection entryInDB = findCD(id);
		if (entryInDB != null) {
			entityManager.remove(entryInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	
	private CDCollection findCD(Long id) {
		return entityManager.find(CDCollection.class, id);
	}
	
	public String getAllArtistEntries() {
		Query query = entityManager.createQuery("SELECT a FROM CDCollection a");
		Collection<Artists> artistList = (Collection<Artists>) query.getResultList();
		return util.getJSONForObject(artistList);
	}

	@Transactional(REQUIRED)
	public String createArtistEntry(String createArtist) {
		Artists artistEntry = util.getObjectForJSON(createArtist, Artists.class);
		entityManager.persist(artistEntry);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

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
