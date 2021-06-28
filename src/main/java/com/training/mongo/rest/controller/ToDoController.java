package com.training.mongo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.mongo.rest.DTO.ToDoDTO;
import com.training.mongo.rest.service.ToDoService;

@RestController
@RequestMapping("/api")

public class ToDoController {

	@Autowired
	private ToDoService todoService;

	@GetMapping("/todo-items/{id}")
	public ResponseEntity<ToDoDTO> getToDoItem(@PathVariable("id") String id) {
		return new ResponseEntity<ToDoDTO>(todoService.getToDoItem(id), HttpStatus.OK);
	}

	@GetMapping("/todo-items")
	public ResponseEntity<List<ToDoDTO>> getAllToDoItems() {
		return new ResponseEntity<List<ToDoDTO>>(todoService.getAllToDoItems(), HttpStatus.OK);
	}

	@PostMapping("/todo-items")
	public ResponseEntity<ToDoDTO> saveToDoItem(@RequestBody ToDoDTO ToDoItem) {
		return new ResponseEntity<ToDoDTO>(todoService.saveToDoItem(ToDoItem), HttpStatus.CREATED);
	}

	@PutMapping("/todo-items/{id}")
	public ResponseEntity<ToDoDTO> updateToDoItem(@RequestBody ToDoDTO todoItem, @PathVariable("id") String id) {
		return new ResponseEntity<ToDoDTO>(todoService.updateToDoItem(todoItem, id), HttpStatus.OK);
	}

	@DeleteMapping("/todo-items/{id}")
	public ResponseEntity<String> removeToDoItem(@PathVariable("id") String id) {
		todoService.deleteToDoItem(id);
		return new ResponseEntity<String>("ToDo item with id " + id + " deleted", HttpStatus.OK);
	}

	@DeleteMapping("/todo-items")
	public ResponseEntity<String> removeAllToDoItems() {
		todoService.deleteAllToDoItems();
		return new ResponseEntity<String>("All ToDo items has been deleted", HttpStatus.OK);
	}

}
