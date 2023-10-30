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
  public Employee findLastEmployee() {
    Iterable<Employee> allEmps =  this.employeeRepository.findAll();
    java.util.Iterator<Employee> it = allEmps.iterator();
    Employee curEmployee = new Employee("G", "G");

    while (it.hasNext()) {
      curEmployee = it.next();
    }
    return curEmployee;
  }

  @PostMapping("/employees")
  public Employee addOneEmployee(@RequestBody Employee employee) {
    return this.employeeRepository.save(employee);
  }
}
