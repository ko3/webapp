package com.kody.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kody.web.dao.EmployeeDAO;
import com.kody.web.model.Employee;

@Controller
@RequestMapping("/manager")
public class HelloController {
	
	@Autowired
	EmployeeDAO employeedao;

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces={"application/json"})
	public @ResponseBody String getAllEmployees() {
		
		//return "{\"message\":\"Hello\"}";
		return employeedao.toString();
		//return "{\"name\":\"kfc-kampar\",\"staffName\":[\"mkyong1\",\"mkyong2\"]}";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces={"application/json"})
	public @ResponseBody Employee getEmployee(@PathVariable String id) {
		
		Long idnum = (long) Integer.parseInt(id);
		Employee e = new Employee();
		e.setId(idnum);
		e.setFirstName("Koutilya");
		e.setLastName("Edpuganti");
		e.setEmail("xyz@kl.com");
		e.setMobile("9834871950");
		//e.setDateOfBirth(new Date());;
		return e;

	}

}
