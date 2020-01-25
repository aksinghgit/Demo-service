package spring.boot.rest.example;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.ResultActions.*;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demo.controller.EmployeeRestController;
import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@ExtendWith(MockitoExtension.class)
@WebMvcTest(EmployeeRestController.class)
public class EmployeeRESTController {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void createEmployeeAPI() throws Exception {

		Employee employee1 = new Employee("Amritesh", 1000, "IT");

		when(employeeRepository.save(any(Employee.class))).thenReturn(employee1);

		mvc.perform(post("/api/employees").content(asJsonString(employee1)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
	}

	@Test
	public void getAllEmployeesAPI() throws Exception {
		Employee employee1 = new Employee("Amritesh", 1000, "IT");
		Employee employee2 = new Employee("Amrit", 2000, "IT");

		when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));

		mvc.perform(MockMvcRequestBuilders.get("/api/employees").accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[*].name").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[*].department").isNotEmpty());
	}

	@Test
	public void getEmployeeByIdAPI() throws Exception {
		Employee employee1 = new Employee("Amritesh", 1000, "IT");
		employee1.setId(1l);

		when(employeeRepository.findById(any(Long.class))).thenReturn(Optional.of(employee1));

		mvc.perform(MockMvcRequestBuilders.get("/api/employees/{employeeId}", 1)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
