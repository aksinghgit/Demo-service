package spring.boot.rest.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeServiceImpl employeeService;

	@Mock
	EmployeeRepository employeeRepository;

	@Test
	public void createEmployeeTest() {
		Employee employee = new Employee("Amritesh", 1000, "IT");
		employeeService.saveEmployee(employee);
		verify(employeeRepository, times(1)).save(employee);
	}
	

	@Test
	public void findAllEmployeeTest() {
		Employee employee1 = new Employee("Amritesh", 1000, "IT");
		Employee employee2 = new Employee("Amrit", 2000, "Software");

		when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));
		List<Employee> employees = employeeService.retrieveEmployees();
		
		assertEquals(2,employees.size());
		assertEquals(employeeRepository.findAll().size(), employees.size());
		
	}

	
}