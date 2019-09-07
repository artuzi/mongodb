package com.artuzi.infinitymongo.service;

import java.util.ArrayList;

import com.artuzi.infinitymongo.entity.Movimento;

public interface MovimentoService {

	public ArrayList<Movimento> findMovimentoByDescricao(String descricao);
	public void saveMovimentos(ArrayList<Movimento> movimentos);
	public ArrayList<Movimento> findMovimentoByIdDiaria(Long id);
}
