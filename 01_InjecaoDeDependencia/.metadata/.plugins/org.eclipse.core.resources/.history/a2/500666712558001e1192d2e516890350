package exemploDidatico1.services;

import exemploDidatico1.entities.Employee;

public class SalaryService {
	
	//Forma Errada
		TaxService taxService = new TaxService();
		PensionService pensionService = new PensionService();
	
	public double netSalary(Employee employee) {
		return employee.getGrossSalary() - taxService.tax(employee.getGrossSalary()) - 
				pensionService.discount(employee.getGrossSalary());
	}

}
