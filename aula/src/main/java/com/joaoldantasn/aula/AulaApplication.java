package com.joaoldantasn.aula;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaoldantasn.aula.entities.Employee;
import com.joaoldantasn.aula.services.SalaryService;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {
	
	private SalaryService salaryService;
	
	public AulaApplication(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee("Maria", 4000);
		System.out.println(salaryService.netSalary(employee));
		
	}

}
