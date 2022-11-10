package com.api.quasar.service;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import com.api.quasar.dto.DadosObservacionaisDTO;
import com.api.quasar.exeptions.ReturnMessageExceptions;
import com.api.quasar.model.DadosObservacionais;
import com.api.quasar.repository.DadosObservacionaisRepository;

import org.modelmapper.ModelMapper;

@ApplicationScoped
public class DadosObservacionaisService {
  
	private ModelMapper mapper;
	private DadosObservacionaisRepository repository;
	
	public DadosObservacionaisService(ModelMapper mapper, DadosObservacionaisRepository repository) {
 		this.mapper = mapper;
		this.repository = repository;
	}
	
	@Transactional
	public Response saveDadosObser(DadosObservacionaisDTO dadosObserDto) {
		Optional<DadosObservacionais> findDadosObser = repository.findByName(dadosObserDto.getNomeConstalacao());
		if(findDadosObser.isPresent()) {
			throw new ReturnMessageExceptions("Erro ao salvar dados da costelação "
		 +findDadosObser+" por favor tente novamente.");
		}
		DadosObservacionais dadosObser = mapper.map(dadosObserDto,DadosObservacionais.class);
		repository.persist(dadosObser);
		Response saveOut = Response
				.status(Response.Status.CREATED)
				.entity(dadosObserDto)
				.build();
		return saveOut;
	}
	
}
