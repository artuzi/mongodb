package com.artuzi.infinitymongo.dao;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.artuzi.infinitymongo.entity.Diaria;
import com.artuzi.infinitymongo.entity.Sequence;

public interface DiariaRepository extends MongoRepository<Diaria, String> {

	public ArrayList<Diaria> findByStatus(String status);
	
}
