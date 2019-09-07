package com.artuzi.infinitymongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.artuzi.infinitymongo.entity.Diaria;

public interface DiariaRepository extends MongoRepository<Diaria, String> {

}
