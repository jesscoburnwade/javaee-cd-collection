package com.qa.persistence.repository;

public interface CDCollectionRepository {
	
	String getAllCDEntries();
	
	String createCDEntry(String entry);
	
	String updateCDEntry(Long id, String entryToUpdate);
	
	String deleteCDEntry(Long id);
}
