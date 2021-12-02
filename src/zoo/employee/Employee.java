package zoo.employee;

import java.time.LocalDate;

import zoo.Sex;

public abstract class Employee {
	String name;
	LocalDate birthDate;
	Sex sex;
	
	public Employee(String name, LocalDate birthDate, Sex sex) {
		this.name = name;
		this.birthDate = birthDate;
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
}
