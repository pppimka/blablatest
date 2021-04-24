package com.blablacar.palii.controller;

import com.blablacar.palii.controller.request.CreateTaskRequest;
import com.blablacar.palii.controller.request.UpdateTaskRequest;
import com.blablacar.palii.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/task")
@RestController
@AllArgsConstructor
public class TaskController {

	private final TaskService taskService;

	@GetMapping
	@Transactional(readOnly = true)
	public ResponseEntity<?> getTasks(
		@RequestParam(value = "departmentId", required = false) String departmentId,
		@RequestParam(value = "sort", defaultValue = "createdDate,ASC", required = false) Sort sort) {

		return new ResponseEntity<>(taskService.getTasks(departmentId, sort), HttpStatus.OK);
	}

	@GetMapping("/{taskId}")
	@Transactional(readOnly = true)
	public ResponseEntity<?> getTaskDetails(@PathVariable("taskId") String taskId) {

		return new ResponseEntity<>(taskService.getTaskDetails(taskId), HttpStatus.OK);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> createNewTask(@RequestParam CreateTaskRequest taskRequest) {
		String id = taskService.createTask(taskRequest);

		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@PatchMapping("/{taskId}")
	@Transactional
	public ResponseEntity<?> updateTask(@PathVariable("taskId") String taskId, @RequestParam UpdateTaskRequest updateTaskRequest) {
		String id = taskService.updateTask(taskId, updateTaskRequest);

		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
