package com.qa.persistence.repository;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.CDCollection;

@ApplicationScoped
@Alternative
public class CDCollectionMapRepository implements CDCollectionRepository{
	
	private Map<Long, CDCollection> entryMap;
	private Long id;

	@Override
	public String getAllCDEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createCDEntry(String entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCDEntry(Long id, String entryToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCDEntry(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
