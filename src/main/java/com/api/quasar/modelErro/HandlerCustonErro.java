package com.api.quasar.modelErro;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.api.quasar.exeptions.ReturnMessageExceptions;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HandlerCustonErro implements ExceptionMapper<ReturnMessageExceptions> {

	@Override
	public Response toResponse(ReturnMessageExceptions exception) {
		
		if (exception instanceof ReturnMessageExceptions) {
			ModelErro erro = new ModelErro(
				null,
				new Date(),
				exception.getMessage(),
				null);	
			return Response.status(Response.Status.BAD_REQUEST).entity(erro).build();
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity("Erro interno por favor entre em contado com o suporte").build();
	}

}
