package com.artuzi.infinitymongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.artuzi.infinitymongo.entity.Sequence;

public interface SequenceRepository extends MongoRepository<Sequence, String> {

	public Sequence findByName(String name);
	
}
