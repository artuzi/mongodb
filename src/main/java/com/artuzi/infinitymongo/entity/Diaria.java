package com.artuzi.infinitymongo.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Diaria {
	
	@Id
	private Long id;
	private Date diaria;
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
	
}
