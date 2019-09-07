package com.artuzi.infinitymongo.entity;

import org.springframework.data.annotation.Id;

public class Movimento {

	@Id
	private String id;
	private Long idDiaria;
	private String descricao;
	private Double valor;
	private String status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Long getIdDiaria() {
		return idDiaria;
	}
	public void setIdDiaria(Long idDiaria) {
		this.idDiaria = idDiaria;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
		
}
