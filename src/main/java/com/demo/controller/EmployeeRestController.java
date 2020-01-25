package com.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;
 

/**
 * @author amritesh
 *
 */
@RestController
public class EmployeeRestController {
  
 @Autowired
 private EmployeeService employeeService;
  
 public void setEmployeeService(EmployeeService employeeService) {
  this.employeeService = employeeService;
 }
 
 @GetMapping("/api/status")
 public String getStatus() {  
  return "{\"status\": \"success\" }";
 }
 
 @GetMapping("/api/employees")
 public List<Employee> getEmployees() {
  List<Employee> employees = employeeService.retrieveEmployees();
  return employees;
 }
  
 @GetMapping("/api/employees/{employeeId}")
 public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
  return employeeService.getEmployee(employeeId);
 }
  
 @PostMapping("/api/employees")
 public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
  Employee e = employeeService.saveEmployee(employee);
  System.out.println("Employee Saved Successfully" + e );
  return ResponseEntity.status(HttpStatus.CREATED).body(e);
 }
  
 @DeleteMapping("/api/employees/{employeeId}")
 public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
  employeeService.deleteEmployee(employeeId);
  System.out.println("Employee Deleted Successfully");
 }
  
 @PutMapping("/api/employees/{employeeId}")
 public Employee updateEmployee(@RequestBody Employee employee,
   @PathVariable(name="employeeId")Long employeeId){
  Employee emp = employeeService.getEmployee(employeeId);
  if(emp != null){
   employee.setId(employeeId);
   emp = employeeService.updateEmployee(employee);
  }
   return emp;
 }
 
}