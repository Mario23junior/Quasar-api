package com.api.quasar.repository;

import javax.enterprise.context.ApplicationScoped;

import com.api.quasar.model.Quasars;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class QuasaresRepository implements PanacheRepositoryBase<Quasars, Long> {

}
