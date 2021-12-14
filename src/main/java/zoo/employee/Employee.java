package zoo.employee;

import zoo.Sex;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Employee implements Serializable {
	private String name;
	private LocalDate birthDate;
	private Sex sex;
	private LocalDate hireDate;
	
	public Employee(String name, LocalDate birthDate, Sex sex, LocalDate hireDate) {
		this.name = name;
		this.birthDate = birthDate;
		this.sex = sex;
		this.hireDate = hireDate;
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
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

}
