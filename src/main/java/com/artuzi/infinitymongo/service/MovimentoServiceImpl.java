package com.artuzi.infinitymongo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artuzi.infinitymongo.dao.MovimentoRepository;
import com.artuzi.infinitymongo.entity.Movimento;

@Service
public class MovimentoServiceImpl implements MovimentoService{

	@Autowired
	private MovimentoRepository movimentoRepository;
	
	@Override
	public ArrayList<Movimento> findMovimentoByDescricao(String descricao) {
		return movimentoRepository.findByDescricao(descricao);
	}

	@Override
	public void saveMovimentos(ArrayList<Movimento> movimentos) {
		movimentoRepository.saveAll(movimentos);
	}

	@Override
	public ArrayList<Movimento> findMovimentoByIdDiaria(Long idDiaria) {
		// TODO Auto-generated method stub
		
		return movimentoRepository.findByIdDiaria(idDiaria);
	}

}
