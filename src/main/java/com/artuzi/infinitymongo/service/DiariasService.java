package com.artuzi.infinitymongo.service;

import java.util.ArrayList;
import java.util.Date;

import com.artuzi.infinitymongo.entity.Diaria;

public interface DiariasService {
	
	public Long geraNovaDiaria(Date diaria);
	public ArrayList<Diaria> findDiariasStatus(String status);
	
}
