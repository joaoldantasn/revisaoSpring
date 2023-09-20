package exemploDidatico1.app;

import java.util.Locale;
import java.util.Scanner;

import exemploDidatico1.entities.Employee;
import exemploDidatico1.services.SalaryService;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nome: ");
		String name = sc.nextLine();
		System.out.println("Salário bruto: ");
		double grossSalary = sc.nextDouble();
		
		Employee employee = new Employee(name, grossSalary);
		
		SalaryService salaryService = new SalaryService();
		
		double netSalary = salaryService.netSalary(employee);
		
		System.out.printf("Salário Líquido = %.2f%n", netSalary);
		sc.close();
		
	}

}
