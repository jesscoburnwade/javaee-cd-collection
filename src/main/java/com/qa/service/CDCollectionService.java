package com.qa.service;

public interface CDCollectionService {

	String getAllCDEntries();
	
	String createCDEntry(String entry);
	
	String updateCDEntry(Long id, String entryToUpdate);
	
	String deleteCDEntry(Long id);
}
