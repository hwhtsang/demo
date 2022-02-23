package com.arxall.tema.demo.mongo.item;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, Long> {
	
}
