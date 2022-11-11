package com.api.quasar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DadosObservacionais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeConstalacao;
	private String desvioVermelho;
	private String tipo;
	private String distancia;
	private String magnetudeAparente;
	private String descricao;

	@ManyToOne
	private Quasars quasars;
	
	public DadosObservacionais() {
		//TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeConstalacao() {
		return nomeConstalacao;
	}


	public void setNomeConstalacao(String nomeConstalacao) {
		this.nomeConstalacao = nomeConstalacao;
	}


	public String getDesvioVermelho() {
		return desvioVermelho;
	}


	public void setDesvioVermelho(String desvioVermelho) {
		this.desvioVermelho = desvioVermelho;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getDistancia() {
		return distancia;
	}


	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}


	public String getMagnetudeAparente() {
		return magnetudeAparente;
	}


	public void setMagnetudeAparente(String magnetudeAparente) {
		this.magnetudeAparente = magnetudeAparente;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Quasars getQuasars() {
		return quasars;
	}


	public void setQuasars(Quasars quasars) {
		this.quasars = quasars;
	}

	 

}
