package com.securian.creditcompass;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

  @GetMapping("/employee")
  public Optional<Employee> findLastEmployee() {
    long last = this.employeeRepository.count();
    int l = (int)last;
    return this.employeeRepository.findById(l - 1);
  }

  @PostMapping("/employees")
  public Employee addOneEmployee(@RequestBody Employee employee) {
    return this.employeeRepository.save(employee);
  }
}
