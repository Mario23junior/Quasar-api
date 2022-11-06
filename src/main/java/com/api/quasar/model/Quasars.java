package com.api.quasar.model;

public class Quasars {

	private Long id;
	private String nome;
	private String img;
	private String ascensaoDireita;
	private String declinacao;

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
