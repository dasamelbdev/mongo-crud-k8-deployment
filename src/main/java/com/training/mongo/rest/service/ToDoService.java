package com.training.mongo.rest.service;

import java.util.List;

import com.training.mongo.rest.DTO.ToDoDTO;
import com.training.mongo.rest.entity.ToDo;
import com.training.mongo.rest.exception.ToDoItemNotFoundException;

public interface ToDoService {

	public ToDoDTO saveToDoItem(ToDoDTO todo);

	public ToDoDTO updateToDoItem(ToDoDTO todoDTO, String id) throws ToDoItemNotFoundException;

	public void deleteToDoItem(String id) throws ToDoItemNotFoundException;

	public void deleteAllToDoItems();

	public ToDoDTO getToDoItem(String id) throws ToDoItemNotFoundException;

	public List<ToDoDTO> getAllToDoItems();

}
