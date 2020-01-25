package com.demo.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.service.EmployeeService;

/**
 * @author amritesh
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

 @Autowired
 private EmployeeRepository employeeRepository;

 public void setEmployeeRepository(EmployeeRepository employeeRepository) {
  this.employeeRepository = employeeRepository;
 }
 
 public List<Employee> retrieveEmployees() {
  List<Employee> employees = employeeRepository.findAll();
  return employees;
 }
 
 public Employee getEmployee(Long employeeId) {
  Optional<Employee> optEmp = employeeRepository.findById(employeeId);
  return optEmp.get();
 }
 
 public Employee saveEmployee(Employee employee){
	 Employee emp = employeeRepository.save(employee);
	 System.out.println(employee);
  return emp;
 }
 
 public void deleteEmployee(Long employeeId){
  employeeRepository.deleteById(employeeId);
 }
 
 public Employee updateEmployee(Employee employee) {
  return employeeRepository.save(employee);
 }
}