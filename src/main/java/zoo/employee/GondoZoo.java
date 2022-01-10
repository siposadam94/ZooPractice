package zoo.employee;

import zoo.Sex;
import zoo.animal.AnimalType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class GondoZoo extends NonDirector {
	
	private List<AnimalType> caredAnimalTypes;

	public GondoZoo(String name, LocalDate birthDate, Sex sex, List<AnimalType> caredAnimalType, LocalDate hireDate) {
		super(name, birthDate, sex, hireDate);
		this.caredAnimalTypes = caredAnimalType;
	}

	@Override
	public void reward() {
		long yearsBetween = ChronoUnit.YEARS.between(getHireDate(), LocalDate.now());

		if (yearsBetween >= 5) {
			System.out.println(getName() + " nevű gondozoo jutalmat kap!");
		}
	}

	public List<AnimalType> getCaredAnimalTypes() {
		return caredAnimalTypes;
	}

	public void setCaredAnimalTypes(List<AnimalType> caredAnimalTypes) {
		this.caredAnimalTypes = caredAnimalTypes;
	}
}
