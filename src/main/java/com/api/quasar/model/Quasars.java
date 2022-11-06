package com.api.quasar.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Quasars {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String img;
	private String ascensaoDireita;
	private String declinacao;
	
	@OneToMany(mappedBy = "quasars", cascade = CascadeType.ALL)
	private List<DadosObservacionais> dadosObservacionais;

	public Quasars() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getAscensaoDireita() {
		return ascensaoDireita;
	}

	public void setAscensaoDireita(String ascensaoDireita) {
		this.ascensaoDireita = ascensaoDireita;
	}

	public String getDeclinacao() {
		return declinacao;
	}

	public void setDeclinacao(String declinacao) {
		this.declinacao = declinacao;
	}
}
