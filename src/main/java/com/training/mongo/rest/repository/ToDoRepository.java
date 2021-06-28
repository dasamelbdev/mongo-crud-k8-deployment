package com.training.mongo.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.mongo.rest.entity.ToDo;
@Repository
public interface ToDoRepository extends MongoRepository<ToDo, String> {
}
