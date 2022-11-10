package com.api.quasar.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import com.api.quasar.dto.DadosObservacionaisDTO;
import com.api.quasar.exeptions.ReturnMessageExceptions;
import com.api.quasar.model.DadosObservacionais;
import com.api.quasar.repository.DadosObservacionaisRepository;

import org.modelmapper.ModelMapper;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

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
			throw new ReturnMessageExceptions("Erro ao salvar dados da costelação ,por favor tente novamente.");
		}
		DadosObservacionais dadosObser = mapper.map(dadosObserDto,DadosObservacionais.class);
		repository.persist(dadosObser);
		Response saveOut = Response
				.status(Response.Status.CREATED)
				.entity(dadosObserDto)
				.build();
		return saveOut;
	}
	
	public Response listId(Long id) {
		PanacheQuery<DadosObservacionais> listid = repository.find("id",id);
		if(listid.equals(null)) {
			Response.status(Response.Status.NO_CONTENT).build();
			throw new ReturnMessageExceptions("id não encontrado, por favor tente novamente.");
		} else {
			List<DadosObservacionaisDTO> dtdBase = listid
					.stream()
					.map(dadosObj -> mapper.map(dadosObj, DadosObservacionaisDTO.class))
					.collect(Collectors.toList());
			return Response.status(Response.Status.CREATED)
					.entity(dtdBase).build();
		}
		
	}
	
}
