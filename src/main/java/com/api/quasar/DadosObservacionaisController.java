package com.api.quasar;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	
}
