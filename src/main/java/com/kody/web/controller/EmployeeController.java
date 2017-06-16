package com.kody.web.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kody.web.businessservices.EmployeeBusinessService;
import com.kody.web.dto.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	
	@RequestMapping(value="/tasks",method = RequestMethod.GET,headers="Accept=application/json", produces={"application/json"})
	public @ResponseBody Employee getEmployee(@RequestBody Employee employee){
		
		return null;
	}
	
	@Autowired
	private EmployeeBusinessService employeeBusinessSrvc;

	
	@GetMapping("/all")
	public @ResponseBody List getEmployees() {
		return null;
	}

	@GetMapping(value="/employee/{id}",headers="Accept=application/json", produces={"application/json"})
	public @ResponseBody Employee getEmployee(@PathVariable("id") Long id) {

		Employee employee = employeeBusinessSrvc.get(id);
		if (employee == null) {
			return employee;
		}

		return employee;
	}

	@PostMapping(value = "/employee")
	public @ResponseBody Employee createEmployee(@RequestBody Employee employee) {

		employeeBusinessSrvc.create(employee);

		return employee;
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {

		if (null == employeeBusinessSrvc.delete(id)) {
			return new ResponseEntity<String>("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>(id.toString(), HttpStatus.OK);

	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {

		employee = employeeBusinessSrvc.update(id, employee);
		if (null == employee) {
			employee = new Employee();
			employee.setId(id);
			employee.setFirstName("Not Found");
			return new ResponseEntity<Employee>(employee, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}
