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

import com.graymatter.model.Customer;

import jakarta.annotation.PostConstruct;


@Controller
@ResponseBody
public class CustomerController {
	
	private List<Customer> custList;

	
	@PostConstruct
	public void setUpEmpList() {
		custList = new ArrayList<Customer>();

		custList.add(new Customer(123, "Divyanshu", "divyanshu@gmail.com"));
		custList.add(new Customer(124, "Aman", "aman@gmail.com"));
		custList.add(new Customer(125, "Priya", "priya@gmail.com"));
		custList.add(new Customer(126, "Swati", "swati@gmail.com"));
		custList.add(new Customer(127, "Amit", "amit@gmail.com"));
	}

	@RequestMapping("/customer")
	public ModelAndView getAllCustomers() {
		
		
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("custList", custList);
		return mv;
	}
	
	@RequestMapping(value="/customer", method = RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer) {
		custList.add(customer);
		return customer;
	}
	
	@RequestMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable("id") int custId) {
		
		for(Customer e:custList)
			if(e.getCustId()==custId)
				return e;
		
		return null;
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
	public Customer updateEmployee(@RequestBody Customer cust, @PathVariable("id") int custId) {
		
		for(Customer c:custList)
			if(c.getCustId()==custId)
			{
				c.setCustName(cust.getCustName());
				c.setCustEmail(cust.getCustEmail());
				return c;
			}
		return null;
		
	}
}
