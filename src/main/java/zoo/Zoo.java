package zoo;

import zoo.animal.Animal;
import zoo.employee.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Zoo {

	class Mover {
		public void moveZoo(Zoo zoo) {
			zoo.animals = new ArrayList<>(animals);

			zoo.employeeManager = new EmployeeManager();
			zoo.employeeManager.setDirector(employeeManager.getDirector());
			zoo.employeeManager.setWorkers(new ArrayList<>(employeeManager.getWorkers()));

			animals.clear();
			employeeManager.setDirector(null);
			employeeManager.getWorkers().clear();
		}
	}
	
	private static int zooCounter;

	static {
		showZooCount();
	}

	private EmployeeManager employeeManager;
	private List<Animal> animals;
	private List<Task> completedTasks;

	{
		System.out.println("Az állatkert megalapulása: " + LocalDate.now());
		zooCounter++;
		employeeManager = new EmployeeManager();
		animals = new ArrayList<>();
		completedTasks = new ArrayList<>();
		System.out.println("Az állatkert sajnos még üres!");
	}

	//Place for constructors

	public List<Animal> getAnimals() {
		return animals;
	}

	public static void showZooCount() {
		System.out.println("Az országnak " + zooCounter + " állatkertje van jelenleg!");
	}

	public void showCompletedTasks() {
		for (Task task : completedTasks) {
			System.out.println(task.toString());
		}
	}

	public void addCompletedTask(Employee worker, Task task) {
		if (worker instanceof NonDirector) {
			if (worker instanceof GondoZoo && task instanceof GondoZooTask) {
				GondoZooTask gondoZooTask = (GondoZooTask)task;
				gondoZooTask.setGondoZoo((GondoZoo)worker);
				completedTasks.add(task);
			} else if (worker instanceof Cleaner && task instanceof CleanerTask) {
				CleanerTask cleanerTask = (CleanerTask)task;
				cleanerTask.setCleaner((Cleaner)worker);
				completedTasks.add(task);
			}
			else {
				System.out.println("Az adott munka nem tartozik a megadott dolgozó munkakörébe!");
			}
			
		} else {
			System.out.println("Nem végezhet feladatot!");
		}
	}

	public void sortAnimals() {
		//Collections.sort(animals,Comparator.comparing(Animal::getAnimalType).thenComparing(Animal::getNickname));
		Collections.sort(animals,new Comparator<Animal>() {

			@Override
			public int compare(Animal o1, Animal o2) {
				
				int num = o1.getAnimalType().toString().compareTo(o2.getAnimalType().toString());
				if (num == 0) {
					return o1.getNickname().compareTo(o2.getNickname());
				}
				return num;
			}
		});
	}
	
	public void showEmployees() {
		employeeManager.showEmployees();
	}
	// 2.1
	public void showCleaners() {
		employeeManager.showCleaners();
	}
	
	public void addEmployee(Employee employee) {
		employeeManager.addEmployee(employee);
	}
	
	public void releseEmployee(Employee employee) {
		employeeManager.releseEmployee(employee);
	}

	public void reward() {
		employeeManager.reward();
	}

	public void showAnimals() {
		if (animals.isEmpty()) {
			System.out.println("Az állatkert jelenleg üres!");
		} else {
			for (Animal a : animals) {
				System.out.println("állat fajtája: " + a.getAnimalType() +" neve: " + a.getNickname());
			}
		}
	}
	
	public void addAnimal(Animal animal) {
		boolean ableAdopt = false;
		
		for (NonDirector employee : employeeManager.getWorkers()) {
			if (employee instanceof GondoZoo ) {
				if (((GondoZoo) employee).getCaredAnimalType().contains(animal.getAnimalType())) {
					ableAdopt = true;
					break;
				}
			}
		}
		
		if (ableAdopt == true) {
			animals.add(animal);
		} else {
			System.out.println("A(z) " + animal.getAnimalType() + " állatot az állatkert jelenleg nem tudja fogadni");
		}
		
	}
	
	public void sellAnimal(Animal animal) {
		animals.remove(animal);
	}

	public void showAnimalsInZooCount() {
		System.out.println("Az állatkertnek " + animals.size() + " lakója van jelenleg!");
	}
}
