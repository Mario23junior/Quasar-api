package com.api.quasar.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import com.api.quasar.dto.QuasarsDTO;
import com.api.quasar.exeptions.ReturnMessageExceptions;
import com.api.quasar.model.Quasars;
import com.api.quasar.repository.QuasaresRepository;

import org.modelmapper.ModelMapper;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

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
			throw new ReturnMessageExceptions("Erro ao salvar quasar por favor tente novamente");
		}
		Quasars quasar = mapper.map(quasarsDto, Quasars.class);
		repository.persist(quasar);
		Response saveOutpot = Response
				.status(Response.Status.CREATED)
				.entity(quasarsDto)
				.build();
		return saveOutpot;
	}
	
	public Response findAllBase() {
		PanacheQuery<Quasars> listall = repository.findAll();
		if(listall.equals(null)) {
			throw new ReturnMessageExceptions("Ocorreu um erro ao buscar dados , por favor tente novamente.");
		}else {
			List<QuasarsDTO> list = listall.stream()
					.map(baselist -> mapper.map(baselist, QuasarsDTO.class))
					.collect(Collectors.toList());
			return Response.ok(list).build();
		}
	}
	
	public Response listId(Long id) {
		PanacheQuery<Quasars> listId = repository.find("id", id);
		if(listId.equals(null)) {
			Response.status(Response.Status.NO_CONTENT).build();
				throw new ReturnMessageExceptions("Quasar de id :"+id+" não foi encontrado,por favor tente novamente.");
			}else {
				List<QuasarsDTO> dtobase = listId
						.stream()
						.map(convert -> mapper.map(convert,QuasarsDTO.class))
						.collect(Collectors.toList());
				return Response.status(Response.Status.CREATED).entity(dtobase).build();
			}
		}
	
	public Response findByName(String nome) {
		PanacheQuery<Quasars> listName = repository.find("nome", nome.toUpperCase().toLowerCase());
		if(listName.equals(null)) {
			Response.status(Response.Status.NO_CONTENT).build();
				throw new ReturnMessageExceptions("Quasar :"+nome+" não foi encontrado,por favor tente novamente.");
			}else {
				List<QuasarsDTO> dtobase = listName
						.stream()
						.map(convert -> mapper.map(convert,QuasarsDTO.class))
						.collect(Collectors.toList());
				return Response.status(Response.Status.CREATED).entity(dtobase).build();
			}
	}
	
	
	public Response delete(Long id) {
		Quasars quasar = repository.findById(id);
		if(quasar != null) {
			repository.delete(quasar);
			return Response.status(Response.Status.NO_CONTENT).build();
		} else {
			Response.status(Response.Status.NOT_FOUND).build();
			throw new ReturnMessageExceptions("Erro ao deletar quasar de id "+id);
		}
	}
	
	
	public Response update(Long id, QuasarsDTO quasarsDto) {
		Quasars listid = repository.findById(id);
		
		if(listid != null) {
			listid.setNome(quasarsDto.getNome());
			listid.setImg(quasarsDto.getImg());
			listid.setAscensaoDireita(quasarsDto.getAscensaoDireita());
 			listid.setDeclinacao(quasarsDto.getDeclinacao());
 			return Response.status(Response.Status.NO_CONTENT).build();
		} else {
 			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
 