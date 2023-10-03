package com.securian.creditcompass;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  private final EmployeeRepository employeeRepository;

  public EmployeeController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }
  @GetMapping("/employees")
  public Iterable<Employee> findAllEmployees() {
    return this.employeeRepository.findAll();
  }

  @PostMapping("/employees")
  public Employee addOneEmployee(@RequestBody Employee employee) {
    return this.employeeRepository.save(employee);
  }
}
