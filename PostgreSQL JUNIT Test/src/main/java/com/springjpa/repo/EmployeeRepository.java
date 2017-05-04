package com.springjpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springjpa.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	List<Employee> findByFirstName(String firstName);
	List<Employee> findByLastName(String lastName);
	//void delete(String firstName, String lastName);
}
