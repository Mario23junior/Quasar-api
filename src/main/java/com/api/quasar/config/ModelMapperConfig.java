package com.api.quasar.config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;

import org.modelmapper.ModelMapper;

@Singleton
public class ModelMapperConfig {

	@ApplicationScoped
	public ModelMapper modelmapper() {
		ModelMapper mapper = new ModelMapper();
		return mapper;
	}
}
