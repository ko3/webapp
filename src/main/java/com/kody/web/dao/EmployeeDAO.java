package com.kody.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kody.web.model.Employee;

@Component
public class EmployeeDAO {
	
	private static List<Employee> employees;
	{
		employees = new ArrayList();
		employees.add(new Employee((long) 1, "John", "Doe", "djohn@gmail.com", "121-232-3435"));
		employees.add(new Employee((long)2, "Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
		employees.add(new Employee((long)3, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987"));
	}
	
	public String toString(){
		//String s="{\"employees\":[";
		String s="[";
		boolean first = true;
		for (Employee e : employees) {
			if(!first){
				s=s+",";
			}
			s=s+"{ \"id\":"+e.getId()+", \"employeename\":\""+e.getFirstName()+" "+e.getLastName()+"\", \"emailid\":\""
					+e.getEmail()+"\", \"contact\":\""+e.getMobile()+"\"}";
			first = false;
		}
		//s=s+"]}";
		s=s+"]";
		return s;
	}

	public List list() {
		return employees;
	}

	public Employee get(Long id) {

		for (Employee c : employees) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public Employee create(Employee employee) {
		employee.setId(System.currentTimeMillis());
		employees.add(employee);
		return employee;
	}

	public Long delete(Long id) {

		for (Employee c : employees) {
			if (c.getId().equals(id)) {
				employees.remove(c);
				return id;
			}
		}

		return null;
	}

	public Employee update(Long id, Employee employee) {

		for (Employee c : employees) {
			if (c.getId().equals(id)) {
				employee.setId(c.getId());
				employees.remove(c);
				employees.add(employee);
				return employee;
			}
		}

		return null;
	}
}
