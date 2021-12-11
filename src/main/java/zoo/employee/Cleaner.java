package zoo.employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import zoo.CleaningArea;
import zoo.Sex;
import zoo.Task;

public class Cleaner extends Employee implements CanDoTask{

	private List<CleaningArea> cleaningArea;

	public Cleaner(String name, LocalDate birthDate, Sex sex, List<CleaningArea> cleaningArea, LocalDate hireDate) {
		super(name, birthDate, sex, hireDate);
		this.cleaningArea = cleaningArea;
	}

	public List<CleaningArea> getCleaningArea() {
		return cleaningArea;
	}

	public void setCleaningArea(List<CleaningArea> cleaningArea) {
		this.cleaningArea = cleaningArea;
	}

	@Override
	public void reward() {
		long daysBetween = ChronoUnit.DAYS.between(getHireDate(), LocalDate.now());
		
		if(daysBetween >= 5 * 365) {
			System.out.println(getName() + " jutalmat kap!");
		}
		
	}
	
}