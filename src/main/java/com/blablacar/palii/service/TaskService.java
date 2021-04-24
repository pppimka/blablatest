package com.blablacar.palii.service;

import com.blablacar.palii.controller.request.CreateTaskRequest;
import com.blablacar.palii.controller.request.UpdateTaskRequest;
import com.blablacar.palii.controller.response.TaskDetailsView;
import com.blablacar.palii.controller.response.TaskWithDepartmentAndUser;
import com.blablacar.palii.entity.Task;
import com.blablacar.palii.repo.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TaskService {

	private final TaskRepository taskRepository;

	public List<TaskWithDepartmentAndUser> getTasks(String departmentId, Sort sort) {
		List<TaskWithDepartmentAndUser> tasks = taskRepository.getAll(sort);
		if (departmentId != null) {
			return tasks.stream().filter(t -> t.getAuthor().getDepartment().getId().equals(departmentId)).collect(Collectors.toList());
		}
		return tasks;
	}

	public TaskDetailsView getTaskDetails(String taskId) {
		return taskRepository.findTaskById(taskId);
	}

	public String createTask(CreateTaskRequest taskRequest) {
		//map request on task entity with links to users
		return "newTaskId";
	}

	public String updateTask(String taskId, UpdateTaskRequest updateTaskRequest) {
		Task taskToUpdate = taskRepository.findById(taskId).orElseThrow(EntityNotFoundException::new);
		//map request and update task entity
		return "updatedTaskId";
	}
}
