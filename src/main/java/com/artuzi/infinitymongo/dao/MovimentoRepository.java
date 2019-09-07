package com.artuzi.infinitymongo.dao;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.artuzi.infinitymongo.entity.Movimento;

public interface MovimentoRepository extends MongoRepository<Movimento, String> {

	public ArrayList<Movimento> findByDescricao(String descricao);
	public ArrayList<Movimento> findByIdDiaria(Long idDiaria);
	
}
