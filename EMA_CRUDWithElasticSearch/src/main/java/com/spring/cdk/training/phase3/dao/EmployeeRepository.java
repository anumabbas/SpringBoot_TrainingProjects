package com.spring.cdk.training.phase3.dao;

import com.spring.cdk.training.phase3.model.Employee;
import java.util.List;

import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    Page<Employee> findByLastName(String lastName, Pageable pageable);

    Employee findByEmployeeId(String employeeId);
}