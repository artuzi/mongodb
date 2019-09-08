package com.artuzi.infinitymongo.service;

import java.util.ArrayList;
import java.util.Date;

import com.artuzi.infinitymongo.entity.Diaria;

public interface DiariaService {
	
	public Long geraNovaDiaria(Date diaria, String codProduto, String codCanal, String codEmpresa);
	public ArrayList<Diaria> findDiariasStatus(String status);
	
}
