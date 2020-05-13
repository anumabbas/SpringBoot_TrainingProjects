package com.spring.cdk.training.phase3.controller;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import com.spring.cdk.training.phase3.dao.EmployeeRepository;
import com.spring.cdk.training.phase3.model.Employee;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller class for Employee endpoints
 */

@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  EmployeeRepository employeeRepository;

  @PostMapping
  public ResponseEntity<String> saveEmployees(@RequestBody Employee employee){
    Employee savedEmployee = employeeRepository.save(employee);
    return ResponseEntity.ok().body("Success saving employee in Elastic Search with Id =" + savedEmployee.getEmployeeId());
  }

  @GetMapping("/{employeeId}")
  @ResponseBody
  public Employee view(@PathVariable final String employeeId) {
    Employee employee = employeeRepository.findByEmployeeId(employeeId);
    return employee;
  }

  @GetMapping
  @ResponseBody
  public List<Employee> findAll(){
    List<Employee> employees = new ArrayList<Employee>();
    Iterable<Employee> employeesIterable = employeeRepository.findAll();
    employeesIterable.forEach(employees::add);
    return employees;
  }

  @GetMapping("/name/{name}")
  @ResponseBody
  public List<Employee> findByName(@PathVariable final String name) {
    List<Employee> employees = employeeRepository.findByFirstNameAndLastName(name.split(" ")[0] , name.split(" ")[1]);
    return employees;
  }
}
