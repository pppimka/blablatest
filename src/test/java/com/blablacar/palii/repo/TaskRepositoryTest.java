package com.blablacar.palii.repo;

import com.blablacar.palii.controller.response.TaskDetailsView;
import com.blablacar.palii.controller.response.TaskWithDepartmentAndUser;
import com.blablacar.palii.entity.Department;
import com.blablacar.palii.entity.Task;
import com.blablacar.palii.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TaskRepositoryTest extends BaseTest {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	@Transactional
	public void getAllTest() {
		Department authorDepartment = easyRandom.nextObject(Department.class);
		Department executorDepartment = easyRandom.nextObject(Department.class);
		departmentRepository.saveAll(List.of(authorDepartment, executorDepartment));

		User author = easyRandom.nextObject(User.class);
		author.setDepartment(authorDepartment);
		User executor = easyRandom.nextObject(User.class);
		executor.setDepartment(executorDepartment);
		userRepository.saveAll(List.of(author, executor));

		Task task1 = easyRandom.nextObject(Task.class);
		task1.setAuthor(author);
		task1.setExecutor(executor);
		Task task2 = easyRandom.nextObject(Task.class);
		task1.setAuthor(author);
		taskRepository.saveAll(List.of(task1, task2));

		List<TaskWithDepartmentAndUser> list = taskRepository.getAll(Sort.by("createdDate"));
		Assertions.assertAll(
			() -> assertEquals(2, list.size()),
			() -> assertEquals(2, list.get(0).getAuthor().getRate()));
	}

	@Test
	@Transactional
	public void getTaskDetails() {
		Department authorDepartment = easyRandom.nextObject(Department.class);
		departmentRepository.saveAll(List.of(authorDepartment));

		User author = easyRandom.nextObject(User.class);
		author.setDepartment(authorDepartment);
		userRepository.saveAll(List.of(author));

		Task task1 = easyRandom.nextObject(Task.class);
		task1.setAuthor(author);
		task1 = taskRepository.save(task1);

		TaskDetailsView taskDetails = taskRepository.findTaskById(task1.getId());
		assertNotNull(taskDetails);
	}
}