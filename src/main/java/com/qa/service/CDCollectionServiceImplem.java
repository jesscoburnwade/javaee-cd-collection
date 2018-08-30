package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.repository.CDCollectionRepository;

public class CDCollectionServiceImplem implements CDCollectionService {
	
	@Inject
	private CDCollectionRepository cdRepo;

	@Override
	public String getAllCDEntries() {
		return cdRepo.getAllCDEntries();
	}

	@Override
	public String createCDEntry(String entry) {
		return cdRepo.createCDEntry(entry);
	}

	@Override
	public String updateCDEntry(Long id, String entryToUpdate) {
		return cdRepo.updateCDEntry(id, entryToUpdate);
	}

	@Override
	public String deleteCDEntry(Long id) {
		return cdRepo.deleteCDEntry(id);
	}

}
