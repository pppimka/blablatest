package com.blablacar.palii.repo;

import com.blablacar.palii.controller.response.TaskDetailsView;
import com.blablacar.palii.controller.response.TaskWithDepartmentAndUser;
import com.blablacar.palii.entity.Task;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, String> {

	@Query(value = "SELECT t FROM Task t")
	List<TaskWithDepartmentAndUser> getAll(Sort sort);

	@Query(value = "SELECT t FROM Task t where t.id = :id")
	TaskDetailsView findTaskById(@Param("id") String taskId);

}
