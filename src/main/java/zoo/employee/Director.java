package zoo.employee;

import java.time.LocalDate;

import zoo.Sex;

public class Director extends Employee {

	public Director(String name, LocalDate birthDate, Sex sex, LocalDate hireDate) {
		super(name, birthDate, sex, hireDate);
	}

}
