package com.artuzi.infinitymongo.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Diaria {
	
	@Id
	private Long id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date diaria;
	
	private String codProduto;
	private String codCanal;
	private String codEmpresa;
	
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDiaria() {
		return diaria;
	}
	public void setDiaria(Date diaria) {
		this.diaria = diaria;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}
	public String getCodCanal() {
		return codCanal;
	}
	public void setCodCanal(String codCanal) {
		this.codCanal = codCanal;
	}
	public String getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	
}
