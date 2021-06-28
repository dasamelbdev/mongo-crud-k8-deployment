package com.training.mongo.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.mongo.rest.DTO.ToDoDTO;
import com.training.mongo.rest.entity.ToDo;
import com.training.mongo.rest.exception.ExceptionMessages;
import com.training.mongo.rest.exception.ToDoItemNotFoundException;
import com.training.mongo.rest.repository.ToDoRepository;

@Service
public class ToDoServiceImple implements ToDoService {

	@Autowired
	private ToDoRepository todoRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ToDoDTO saveToDoItem(ToDoDTO todoDTO) {
		ToDo todoItem = modelMapper.map(todoDTO, ToDo.class);
		return modelMapper.map(todoRepository.save(todoItem), ToDoDTO.class);

	}

	@Override
	public ToDoDTO updateToDoItem(ToDoDTO todoDTO, String id) throws ToDoItemNotFoundException {

		Optional<ToDo> todoItem = todoRepository.findById(id);
		if (todoItem.isPresent()) {
			ToDo todoEntity = todoItem.get();
			todoEntity.setTaskCategory(todoDTO.getTaskCategory());
			todoEntity.setTaskDescription(todoDTO.getTaskDescription());
			todoEntity.setTaskTile(todoDTO.getTaskTile());
			return modelMapper.map(todoRepository.save(todoEntity), ToDoDTO.class);

		} else
			throw new ToDoItemNotFoundException(ExceptionMessages.TODO_ITEM_NOT_FOUND,id);
	}

	@Override
	public ToDoDTO getToDoItem(String id) throws ToDoItemNotFoundException {
		Optional<ToDo> todoItem = todoRepository.findById(id);
		if (todoItem.isPresent()) {
			ToDo todoEntity = todoItem.get();
			return modelMapper.map(todoEntity, ToDoDTO.class);
		} else
			throw new ToDoItemNotFoundException(ExceptionMessages.TODO_ITEM_NOT_FOUND,id);
	}

	@Override
	public List<ToDoDTO> getAllToDoItems() {
		List<ToDo> todoItems = todoRepository.findAll();
		if (todoItems.isEmpty())
			return new ArrayList<ToDoDTO>();
		else {
			List<ToDoDTO> todoItemList = new ArrayList<>();
			for (int i = 0; i < todoItems.size(); i++) {
				todoItemList.add(modelMapper.map(todoItems.get(i), ToDoDTO.class));
			}
			return todoItemList;
		}
	}

	@Override
	public void deleteToDoItem(String id) throws ToDoItemNotFoundException {
		Optional<ToDo> todoItem = todoRepository.findById(id);
		if (todoItem.isPresent())
			todoRepository.deleteById(id);
		else
			throw new ToDoItemNotFoundException(ExceptionMessages.TODO_ITEM_NOT_FOUND,id);
	}

	@Override
	public void deleteAllToDoItems() throws RuntimeException {
		todoRepository.deleteAll();
	}

}
