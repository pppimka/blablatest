package com.blablacar.palii.repo;

import com.blablacar.palii.entity.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department, String> {


}
