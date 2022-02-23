package com.arxall.tema.demo.elasticsearch.user;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<User, Long> {
	
}
