package zoo.employee;

import java.time.LocalDate;

import zoo.Sex;
import zoo.animal.AnimalType;

public class GondoZoo extends Employee{
	private AnimalType caredAnimalType;

	public GondoZoo(String name, LocalDate birthDate, Sex sex, AnimalType caredAnimal) {
		super(name, birthDate, sex);
		this.caredAnimalType = caredAnimal;
	}

	public AnimalType getCaredAnimalType() {
		return caredAnimalType;
	}

	public void setCaredAnimalType(AnimalType caredAnimal) {
		this.caredAnimalType = caredAnimal;
	}
}
