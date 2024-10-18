package com.shias.scafe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shias.scafe.model.Item;

public interface ItemRepository extends MongoRepository<Item, String> {

}
