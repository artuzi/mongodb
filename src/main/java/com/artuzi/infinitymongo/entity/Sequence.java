package com.artuzi.infinitymongo.entity;

import org.springframework.data.annotation.Id;

public class Sequence {

	@Id
	private String id;
	private String name;
	private Long value;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	
	
}
