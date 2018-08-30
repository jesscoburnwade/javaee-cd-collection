package com.qa.controller;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.persistence.repository.ArtistsRepository;
import com.qa.service.CDCollectionService;

@Path("/cdentry")
public class CDCollectionController {
	
	@Inject
	private CDCollectionService cdService;
	
	@Inject 
	private ArtistsRepository artRepo;
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllCDEntries() {
		return cdService.getAllCDEntries();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createCDEntry(String entry) {
		return cdService.createCDEntry(entry);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateCDEntry(@PathParam("id") Long id, String entry) {
		return cdService.updateCDEntry(id, entry);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteCDEntry(Long id) {
		return cdService.deleteCDEntry(id);
	}
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllArtistEntries() {
		return artRepo.getAllArtistEntries();
	}
	
//	@Path("/json/artists")
//	@POST
//	@Produces({ "application/json" })
//	public String createArtistEntry(String createArtist) {
//		return artRepo.createArtistEntry(createArtist);
//	}
	
//	@Path("/json/artists/{id}")
//	@PUT
//	@Produces({ "application/json" })
//	public String updateArtistEntry(@PathParam("id") Long id, String artistToUpdate) {
//		return artRepo.updateArtistEntry(id, artistToUpdate);
//	}
	
//	@Path("/json/artists/{id}")
//	@DELETE
//	@Produces({ "application/json" })
//	public String deleteArtistEntry(@PathParam("id") Long id) {
//		return artRepo.deleteArtistEntry(id);
//	}
}
