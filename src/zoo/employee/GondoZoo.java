package zoo.employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import zoo.Sex;
import zoo.Task;
import zoo.animal.AnimalType;

public class GondoZoo extends Employee implements CanDoTask{
	
	private List<AnimalType> caredAnimalType;

	public GondoZoo(String name, LocalDate birthDate, Sex sex, List<AnimalType> caredAnimalType, LocalDate hireDate) {
		super(name, birthDate, sex, hireDate);
		this.caredAnimalType = caredAnimalType;
	}

	public List<AnimalType> getCaredAnimalType() {
		return caredAnimalType;
	}

	public void setCaredAnimalType(List<AnimalType> caredAnimalType) {
		this.caredAnimalType = caredAnimalType;
	}

	@Override
	public void reward() {
		long daysBetween = ChronoUnit.DAYS.between(getHireDate(), LocalDate.now());
		
		if(daysBetween >= 5 * 365) {
			System.out.println(getName() + " jutalmat kap!");
		}
		
	}

}
