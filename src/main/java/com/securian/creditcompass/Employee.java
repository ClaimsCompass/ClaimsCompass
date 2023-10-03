package com.securian.creditcompass;
import jakarta.persistence.*;


@Entity
@Table(name = "employees")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  
  private String firstName;
  
  private String lastName;
  
  // private LocalDate dateOfBirth;
  
  // Hibernate expects entities to have a no-arg constructor,
  // though it does not necessarily have to be public.
  public Employee() {}
  
  //public Employee(String firstName, String lastName, LocalDate dateOfBirth) {
  public Employee(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    // this.dateOfBirth = dateOfBirth;
  }

  public Integer getId() {
    return this.id;
  }
  
  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  // public LocalDate getDateOfBirth() {
    //return this.dateOfBirth;
  //}
}
