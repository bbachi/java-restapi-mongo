package com.bachinalabs.mongodemo.repository;

import com.bachinalabs.mongodemo.entity.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TodosRepository extends MongoRepository<Todo, String> {

}
