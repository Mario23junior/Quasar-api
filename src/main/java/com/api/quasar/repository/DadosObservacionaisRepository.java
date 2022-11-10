package com.api.quasar.repository;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import com.api.quasar.model.DadosObservacionais;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class DadosObservacionaisRepository implements PanacheRepositoryBase<DadosObservacionais, Long>{

	public Optional<DadosObservacionais> findByName(String nomeConstalacao) {
		return find("nomeConstalacao",nomeConstalacao.toUpperCase().toLowerCase()).firstResultOptional();
	}

}
