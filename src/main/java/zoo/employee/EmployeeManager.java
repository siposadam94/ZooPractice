package zoo.employee;

import zoo.animal.AnimalType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeManager {
	
	private Director director;
	private List<NonDirector> workers;

	public void showEmployees() {
		if (director != null) {
			System.out.println("Az állatkert igazgatója: " + director.getName());
		} else {
			System.out.println("Az állatkertnek nincs jelenleg igazgatója!");
		}

		if (workers.isEmpty()) {
			System.out.println("Az állatkertnek jelenleg nincs dolgozója!");
		} else {
			for (Employee e : workers) {
				System.out.println("Az állatkert dolgozója: " + e.getName());
			}
		}
	}

	public void showCleaners() {
		for (NonDirector employee : workers) {
			if (employee instanceof Cleaner){
				System.out.println("A takarító neve: " + employee.getName() + " aki a " + ((Cleaner) employee).getCleaningArea() + " -t takarítja.");
			}
		}
	}

	public void addEmployee(Employee employee) {
		if (employee instanceof Director) {
			if (this.director == null) {
				this.director = (Director) employee;
				System.out.println("Az állatkert igazgatója " + director.getName() + " lett!");
			} else {
				System.out.println("Az állatkertnek jelenleg már van igazgatója!");
			}
		} else if (employee instanceof GondoZoo) {
			workers.add((GondoZoo)employee);
		} else if (employee instanceof Cleaner) {
			workers.add((Cleaner)employee);
		} else {

		}
	}

	public void releseEmployee(Employee employee) {
		if (employee instanceof Director) {
			if (this.director == null) {
				System.out.println("Az állatkertnek nincs jelenleg igazgatója!");
			} else {
				System.out.println("Az állatkert " + director.getName() + " igazgatója eltávozott!");
				director = null;
			}
		} else if (employee instanceof Cleaner) {
			workers.remove(employee);
		} else {
			Set<AnimalType> missingAnimalTypeSet = new HashSet<>();
			workers.remove(employee);
			GondoZoo releasedCondoZoo = (GondoZoo) employee;
			for (AnimalType animalType : releasedCondoZoo.getCaredAnimalTypes()) {
				int caredAnimalCounter = 0;
				for (NonDirector worker : workers) {
					if (worker instanceof GondoZoo) {
						if (((GondoZoo)worker).getCaredAnimalTypes().contains(animalType)) {
							caredAnimalCounter++;
						}
					}
				}
				if (caredAnimalCounter == 0) {
					missingAnimalTypeSet.add(animalType);
				}
			}
			if (!missingAnimalTypeSet.isEmpty()) {
				System.out.println("Az állatkertnek szüksége van " + missingAnimalTypeSet + " gondozóra!");
			}
		}
	}

	public void reward() {
		for (NonDirector worker : workers) {
			worker.reward();
		}
	}

	public List<NonDirector> getWorkers() {
		return workers;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public void setWorkers(List<NonDirector> workers) {
		this.workers = workers;
	}

	public EmployeeManager() {
		workers = new ArrayList<>();
	}

	public EmployeeManager(Director director, List<NonDirector> workers) {
		this.director = director;
		this.workers = workers;
	}
}
