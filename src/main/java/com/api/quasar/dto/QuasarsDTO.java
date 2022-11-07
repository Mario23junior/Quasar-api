package com.api.quasar.dto;

import java.util.List;

public class QuasarsDTO {

	private Long id;
	private String nome;
	private String img;
	private String ascensaoDireita;
	private String declinacao;

	private List<DadosObservacionaisDTO> dadosObservacionaisDto;

	public QuasarsDTO() {
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

	public List<DadosObservacionaisDTO> getDadosObservacionaisDto() {
		return dadosObservacionaisDto;
	}

	public void setDadosObservacionaisDto(List<DadosObservacionaisDTO> dadosObservacionaisDto) {
		this.dadosObservacionaisDto = dadosObservacionaisDto;
	}

}
