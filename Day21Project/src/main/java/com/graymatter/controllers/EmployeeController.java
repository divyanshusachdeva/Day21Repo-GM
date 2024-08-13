package com.graymatter.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.graymatter.model.Employee;

import jakarta.annotation.PostConstruct;


@Controller
@ResponseBody
public class EmployeeController {
	
	private List<Employee> empList;

	
	@PostConstruct
	public void setUpEmpList() {
		empList = new ArrayList<Employee>();

		empList.add(new Employee(123, "Divyanshu", 54000));
		empList.add(new Employee(124, "Aman", 32000));
		empList.add(new Employee(125, "Priya", 29000));
		empList.add(new Employee(126, "Swati", 71000));
		empList.add(new Employee(127, "Amit", 68000));
	}

	@RequestMapping("/employee")
	public ModelAndView getAllEmployees() {
		
		
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("empList", empList);
		return mv;
	}
	
	@RequestMapping(value="/employee", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		empList.add(employee);
		return employee;
	}
	
	@RequestMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int empId) {
		
		for(Employee e:empList)
			if(e.getEmpId()==empId)
				return e;
		
		return null;
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable("id") int empId) {
		
		for(Employee e:empList)
			if(e.getEmpId()==empId)
			{
				e.setEmpName(emp.getEmpName());
				e.setEmpSal(emp.getEmpSal());
				return e;
			}
		return null;
		
	}
}
