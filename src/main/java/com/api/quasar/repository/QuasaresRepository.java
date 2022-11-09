package com.api.quasar.repository;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import com.api.quasar.model.Quasars;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class QuasaresRepository implements PanacheRepositoryBase<Quasars, Long> {
  
	public Optional<Quasars> findByNome(String nome){
		return find("nome",nome.toUpperCase().toLowerCase()).firstResultOptional();
	}
}