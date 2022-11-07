package com.api.quasar.service;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import com.api.quasar.dto.QuasarsDTO;
import com.api.quasar.exeptions.ReturnMessageExceptions;
import com.api.quasar.model.Quasars;
import com.api.quasar.repository.QuasaresRepository;

import org.modelmapper.ModelMapper;

@ApplicationScoped
public class QuasarService {
  
	private QuasaresRepository repository;
	private ModelMapper mapper;
	
	public QuasarService(QuasaresRepository repository,ModelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
 	}
  
	@Transactional
	public Response save(QuasarsDTO quasarsDto) {
		Optional<Quasars> findNome = repository.findByNome(quasarsDto.getNome());
		if(findNome.isPresent()) {
			throw new ReturnMessageExceptions("Erro ao salvar quasar "+findNome+" tente novamente");
		}
		Quasars quasar = mapper.map(quasarsDto, Quasars.class);
		repository.persist(quasar);
		Response saveOutpot = Response
				.status(Response.Status.CREATED)
				.entity(quasarsDto)
				.build();
		return saveOutpot;
	}
	 
}
