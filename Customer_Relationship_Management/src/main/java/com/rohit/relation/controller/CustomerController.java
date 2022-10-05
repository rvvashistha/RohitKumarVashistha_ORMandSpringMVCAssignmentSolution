package com.rohit.relation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rohit.relation.entity.Customer;
import com.rohit.relation.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String listBooks(Model theModel) {

		// get Books from db
		List<Customer> theCustomer = customerService.findAll();

		// add to the spring model
		theModel.addAttribute("Customer", theCustomer);

		return "list-Customer";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("Customer", theCustomer);

		return "Customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam(value = "customerId", required = false) Integer theid,
			Model theModel) {

		// get the Book from the service
		Customer theCustomer = customerService.findById(theid);

		// set Book as a model attribute to per-populate the form
		theModel.addAttribute("Customer", theCustomer);

		// send over to our form
		return "Customer-form";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("FirstName") String FirstName,
			@RequestParam("LastName") String LastName, @RequestParam("Email") String Email) {

		System.out.println(id);
		Customer theCustomer;
		if (id != 0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirstName(FirstName);
			theCustomer.setLastName(LastName);
			theCustomer.setEmail(Email);
		} else
			theCustomer = new Customer(FirstName, LastName, Email);
		// save the Book
		customerService.save(theCustomer);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customer/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "customerId", required = false) Integer theId) {

		// delete the Book
		customerService.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/customer/list";

	}

}
