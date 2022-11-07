package com.api.quasar.service;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import com.api.quasar.dto.QuasarsDTO;
import com.api.quasar.repository.QuasaresRepository;

@ApplicationScoped
public class QuasarService {
  
	private QuasaresRepository repository;
	
	public QuasarService(QuasaresRepository repository) {
		this.repository = repository;
 	}
  
	@Transactional
	public Response save(QuasarsDTO quasarsDto) {
		return null;
	}
}
