
package com.rupertagnew.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;



@Component
public class DatabaseLoader implements CommandLineRunner {

	private final EmployeeRepository repository;

	@Autowired
	public DatabaseLoader(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Employee("Rupert", "Agnew", "Monday"));
		this.repository.save(new Employee("Stephen", "Hawking", "Monday"));
		this.repository.save(new Employee("Alan", "Turing", "Tuesday "));
		this.repository.save(new Employee("Bill", "Gates", "Friday"));
		
	}
	

	
	
}
