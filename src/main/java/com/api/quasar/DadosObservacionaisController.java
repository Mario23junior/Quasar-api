package com.api.quasar;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.api.quasar.dto.DadosObservacionaisDTO;
import com.api.quasar.service.DadosObservacionaisService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/api/dadosobservacionais/")
public class DadosObservacionaisController {
  
	private DadosObservacionaisService service;
    
	@Inject
	public DadosObservacionaisController(DadosObservacionaisService service) {
 		this.service = service;
	}
	
	@POST
	public Response save(DadosObservacionaisDTO dadosObserDto) {
		return service.saveDadosObser(dadosObserDto);
	}
	
	@GET
	@Path("{id}")
	public Response list(@PathParam("id") Long id) {
		return service.listId(id);
	}
	
	@GET
	public Response listAll() {
		return service.listAllDadosObser();
	}
	
	@DELETE
	@Transactional
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		return service.deleteId(id);
	}
	
	@PUT
	@Transactional
	@Path("{id}")
	public Response update(@PathParam("id") Long id, DadosObservacionaisDTO dadosObser) {
		return service.update(id, dadosObser);
	}
}
