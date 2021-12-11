package zoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import zoo.animal.Animal;
import zoo.animal.AnimalType;
import zoo.employee.CanDoTask;
import zoo.employee.Cleaner;
import zoo.employee.Director;
import zoo.employee.Employee;
import zoo.employee.GondoZoo;

public class Zoo {
	
	private static int zooCounter;
	private Director director;
	private List<GondoZoo> zookeepers;
	private List<Cleaner> cleaners;
	private List<Animal> animals;
	private List<Task> completedTasks;
	
	public List<Animal> getAnimals() {
		return animals;
	}
	
	public void showCompletedTasks() {
		for (Task task : completedTasks) {
			System.out.println(task.toString());
		}
	}

	public void addCompletedTask(Employee worker, Task task) {
		if(worker instanceof CanDoTask) {
			if (worker instanceof GondoZoo && task instanceof GondoZooTask) {
				GondoZooTask gondoZooTask = (GondoZooTask)task;
				gondoZooTask.setGondoZoo((GondoZoo)worker);
				completedTasks.add(task);
			}
			else if (worker instanceof Cleaner && task instanceof CleanerTask) {
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
	
	public void reward() {
		for (GondoZoo zookeeper : zookeepers) {
			zookeeper.reward();
		}
	}
	
	public void sortAnimals() {
		//Collections.sort(animals,Comparator.comparing(Animal::getAnimalType).thenComparing(Animal::getNickname));
		Collections.sort(animals,new Comparator<Animal>() {

			@Override
			public int compare(Animal o1, Animal o2) {
				
				int num = o1.getAnimalType().toString().compareTo(o2.getAnimalType().toString());
				if(num == 0) {
					return o1.getNickname().compareTo(o2.getNickname());
				}
				return num;
			}
		});
		
	}
	
	public void showEmployees() {
		if(director != null) {
			System.out.println("Az állatkert igazgatója: " + director.getName());
		}else {
			System.out.println("Az állatkertnek nincs jelenleg igazgatója!");
		}
		if(zookeepers.isEmpty()) {
			System.out.println("Az állatkertnek jelenleg nincs dolgozója!");
		}else {
			for (Employee e : zookeepers) {
				System.out.println("Az állatkert dolgozója: " + e.getName());
			}
		}	
	}
	// 2.1
	public void showCleaners() {
		for (Cleaner cleaner : cleaners) {
			System.out.println("A takarító neve: " + cleaner.getName() + " aki a " + cleaner.getCleaningArea() + " -t takarítja.");
		}
	}
	
	public void addEmployee(Employee employee) {
		if(employee instanceof Director) {
			if (this.director == null) {
				this.director = (Director) employee;
				System.out.println("Az állatkert igazgatója " + director.getName() + " lett!");
			}else {
				System.out.println("Az állatkertnek jelenleg már van igazgatója!");
			}
		}
		else if(employee instanceof GondoZoo) {
			zookeepers.add((GondoZoo)employee);
		}
		else if(employee instanceof Cleaner) {
			cleaners.add((Cleaner)employee);
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
			cleaners.remove(employee);
		} else {
			Set<AnimalType> missingAnimalTypeSet = new HashSet<>();
			zookeepers.remove(employee);
			GondoZoo relesedGondoZoo = (GondoZoo) employee;
			for (AnimalType animalType : relesedGondoZoo.getCaredAnimalType()) {
				int caredAnimalCounter = 0;
				for (GondoZoo zookeper : zookeepers) {
					if(zookeper.getCaredAnimalType().contains(animalType)) {
						caredAnimalCounter++;
					}
				}
				if(caredAnimalCounter == 0) {
					missingAnimalTypeSet.add(animalType);
				}
			}
			if(!missingAnimalTypeSet.isEmpty()) {
				System.out.println("Az állatkertnek szüksége van " + missingAnimalTypeSet + " gondozóra!");
			}
		}
	}
	
	public void showAnimals() {
		if (animals.isEmpty()) {
			System.out.println("Az állatkert jelenleg üres!");
		}else {
			for (Animal a : animals) {
				System.out.println("állat fajtája: " + a.getAnimalType() +" neve: " + a.getNickname());
			}
		}
		
	}
	
	public void addAnimal(Animal animal) {
		boolean ableAdopt = false;
		
		for (GondoZoo z : zookeepers) {
			if (z.getCaredAnimalType().contains(animal.getAnimalType()) ) {
				ableAdopt = true;
				break;
			}
		}
		
		if(ableAdopt == true) {
			animals.add(animal);
		}else {
			System.out.println("A(z) " + animal.getAnimalType() + " állatot az állatkert jelenleg nem tudja fogadni");
		}
		
	}
	
	public void sellAnimal(Animal animal) {
		animals.remove(animal);
	}
	
	
	public void showAnimalsInZooCount() {
		System.out.println("Az állatkertnek " + animals.size() + " lakója van jelenleg!");
	}
	
	public static void showZooCount() {
		System.out.println("Az országnak " + zooCounter + " állatkertje van jelenleg!");	
	}
	
	{
		System.out.println("Az állatkert megalapulása: " + LocalDate.now());
		zooCounter++;
		zookeepers = new ArrayList<>();
		animals = new ArrayList<>();
		cleaners = new ArrayList<>();
		completedTasks = new ArrayList<>();
		System.out.println("Az állatkert sajnos még üres!");
	}
	
	static {
		showZooCount();
	}
	
	class Mover {
		
		public void moveZoo(Zoo zoo) {
			zoo.animals = new ArrayList<>(animals);
			animals.clear();
			zoo.director = director;
			director = null;
			zoo.zookeepers = new ArrayList<>(zookeepers);
			zookeepers.clear();
		}
	}
}
