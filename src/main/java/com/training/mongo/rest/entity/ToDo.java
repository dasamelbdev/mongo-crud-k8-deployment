package com.training.mongo.rest.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "todo-tbl")
public class ToDo {

	@Id
	private String id;
	private String taskCategory;
	private String taskTile;
	private String taskDescription;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTaskCategory() {
		return taskCategory;
	}
	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}
	public String getTaskTile() {
		return taskTile;
	}
	public void setTaskTile(String taskTile) {
		this.taskTile = taskTile;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", taskCategory=" + taskCategory + ", taskTile=" + taskTile + ", taskDescription="
				+ taskDescription + "]";
	}
	
}
