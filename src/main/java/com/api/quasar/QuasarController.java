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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.api.quasar.dto.QuasarsDTO;
import com.api.quasar.service.QuasarService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/api/quasares/")
public class QuasarController {

	private QuasarService service;
 
	@Inject
	public QuasarController(QuasarService service) {
		this.service = service;
	}

	@POST
	@Transactional
	public Response savequasar(QuasarsDTO quasarsdto) {
		return service.save(quasarsdto);
	}

	@GET
	public Response ListAll() {
		return service.findAllBase();
	}
	
	
	@GET
	@Path("{id}")
	public Response listId(@PathParam("id") Long id) {
		return service.listId(id);
	}
	
	@GET
	@Path("nome")
	public Response listId(@QueryParam("nome") String nome) {
		return service.findByName(nome);
	}
	
	@Transactional
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		return service.delete(id);
	}
	
	@Transactional
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") Long id,QuasarsDTO quasarsdto) {
		return service.update(id, quasarsdto);
	}
}
