package com.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.Employee;
import com.springjpa.repo.EmployeeRepository;

@RestController
public class WebController {
	@Autowired
	EmployeeRepository repository;
	
	@RequestMapping("/")
	public String homepage(){
		String a = "<html><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"/><table class=\"table table-striped\">";

		a+= "<thead><tr><th>This project will demonstrate a persistent database using PostcreSQL and demonstrate JUnit tests and their importance <br><hr>";
		a += "</th></tr></thead><tr><td>To navigate around, please use the following syntaxes:";
		a += "</td></tr><tr><td>/save <br>";
		a += "</td></tr><tr><td>/findall <br>";
		a += "</td></tr><tr><td>/findbyid?id= <br>";
		a += "</td></tr><tr><td>/findbyfirstname?firstname= <br>";
		a += "</td></tr><tr><td>/findbylastname?lastname= <br>";
		a += "</td></tr><tr><td>/addemployee?firstname=&lastname= <br>";
		a += "</td></tr><tr><td>/delemployee?id= <br></td></tr>";
		
		
	
		return a + "</table></html>";
	}
	
	
	@RequestMapping("/save")
	public String process(){
		repository.save(new Employee("Jack", "Smith"));
		repository.save(new Employee("Adam", "Johnson"));
		repository.save(new Employee("Kim", "Smith"));
		repository.save(new Employee("David", "Williams"));
		repository.save(new Employee("Peter", "Davis"));
		return "Done";
	}
	
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "<html>";
		
		for(Employee e : repository.findAll()){
			result += "<div>" + e.toString() + "</div>";
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName){
		String result = "<html>";
		
		for(Employee e: repository.findByLastName(lastName)){
			result += e.getSurname(); 
		}
		
		return result + "</html>";
	}
	
	
	@RequestMapping("/findbyfirstname")
	public String fetchDataByFirstName(@RequestParam("firstname") String firstName){
		String result = "<html>";
		
		for(Employee e: repository.findByFirstName(firstName)){
			result += e.getFirstname(); 
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/addemployee")
	public String addEmployee(@RequestParam("firstname") String firstName,@RequestParam("lastname") String lastName){
		repository.save(new Employee(firstName,lastName));
		return "added employee: " + firstName +" " + lastName;
	}
	
	@RequestMapping("/delemployee")
	public String deleteById(@RequestParam("id") long id){
		repository.delete(id);
		return "deleted employee with id: " + id;
	}

	
	
}

