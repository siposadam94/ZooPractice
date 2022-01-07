package zoo.employee;

import zoo.Sex;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Cleaner extends NonDirector {

	public enum CleaningArea {
		TERRARIUM, MEDENCE, KETREC, KIFUTO
	}

	private List<CleaningArea> cleaningArea;

	public Cleaner(String name, LocalDate birthDate, Sex sex, List<CleaningArea> cleaningArea, LocalDate hireDate) {
		super(name, birthDate, sex, hireDate);
		this.cleaningArea = cleaningArea;
	}

	@Override
	public void reward() {
		long daysBetween = ChronoUnit.DAYS.between(getHireDate(), LocalDate.now());
		
		if (daysBetween >= 5 * 365) {
			System.out.println(getName() + " nevű takarító jutalmat kap!");
		}
	}

	public List<CleaningArea> getCleaningArea() {
		return cleaningArea;
	}

	public void setCleaningArea(List<CleaningArea> cleaningArea) {
		this.cleaningArea = cleaningArea;
	}
}
