package zoo;

import zoo.animal.Animal;
import zoo.animal.AnimalType;
import zoo.employee.*;
import zoo.exception.GondozooNotAvailable;
import zoo.exception.ZooEmployeeException;
import zoo.task.CleanerTask;
import zoo.task.GondoZooTask;
import zoo.task.Task;
import zoo.ticket.Booking;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Zoo implements Serializable {

	class Mover {
		public void moveZoo(Zoo zoo) {
			zoo.animals = new ArrayList<>(animals);

			zoo.employeeManager.setDirector(employeeManager.getDirector());
			zoo.employeeManager.setWorkers(new ArrayList<>(employeeManager.getWorkers()));

			animals.clear();
			employeeManager.setDirector(null);
			employeeManager.getWorkers().clear();

		}
	}
	
	private static int zooCounter = 0;

	static {
		showZooCount();
	}

	private EmployeeManager employeeManager;
	private List<Animal> animals;
	private List<Task> completedTasks;
	private List<VisitablePlace> visitablePlaces;
	private List<Booking> bookings;

	{
		System.out.println("Az állatkert megalapulása: " + LocalDate.now());
		zooCounter++;
		employeeManager = new EmployeeManager();
		animals = new ArrayList<>();
		completedTasks = new ArrayList<>();
		visitablePlaces = new ArrayList<>();
		System.out.println("Az állatkert sajnos még üres!");

		//thread booking
		bookings = Collections.synchronizedList(new ArrayList<>());
	}

	//Place for constructors

	public synchronized void addBooking(Booking booking) {
		bookings.add(booking);
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
		try {
			employeeManager.releaseEmployee(employee);
		} catch (ZooEmployeeException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reward() {
		employeeManager.reward();
	}

	public void showAnimals() {
		if (animals.isEmpty()) {
			System.out.println("Az állatkert jelenleg üres!");
		} else {
			animals.stream()
					.sorted(Comparator.comparing(Animal::getAnimalTypeString))
					.forEach(a -> System.out.println(a.getNickname()));
		}
	}

	public void showSpecificAnimalsByType(AnimalType animalType) {
		if (animals.isEmpty()) {
			System.out.println("Az állatkert jelenleg üres!");
		} else {
			animals.stream()
					.filter(a -> a.getAnimalType().equals(animalType))
					.forEach(a -> System.out.println(a.getNickname()));
		}
	}

	public void addAnimal(Animal animal) {
		boolean ableAdopt = false;
		
		for (NonDirector employee : employeeManager.getWorkers()) {
			if (employee instanceof GondoZoo ) {
				if (((GondoZoo) employee).getCaredAnimalTypes().contains(animal.getAnimalType())) {
					ableAdopt = true;
					break;
				}
			}
		}
		
		if (ableAdopt == true) {
			animals.add(animal);
		} else {
			try {
				try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
					Properties prop = new Properties();

					prop.load(input);

					throw new GondozooNotAvailable( prop.getProperty("error.gondozooNotAvailable") );
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			} catch (GondozooNotAvailable e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println("A(z) " + animal.getAnimalType() + " állatot az állatkert jelenleg nem tudja fogadni");
		}
		
	}
	
	public void sellAnimal(Animal animal) {
		animals.remove(animal);
	}

	public void showAnimalsInZooCount() {
		System.out.println("Az állatkertnek " + animals.size() + " lakója van jelenleg!");
	}

	//Milyen hibát dobjanak? 3/2 feladat és hol kezeljem
	public void addVisitablePlace(VisitablePlace place) throws Exception {

		if (place.getEmployee() != null) {
			if (!(place.getEmployee() instanceof GondoZoo)) {
				throw new Exception("A megadott dolgozó nem GondoZoo!");
			}

			if (!employeeManager.getWorkers().contains( place.getEmployee() )) {
				throw new Exception("A megadott gondoZoo nem dolgozik az állatkertben!");
			}

			if(place.getAnimalType() != null) {
				if (!((GondoZoo)place.getEmployee()).getCaredAnimalTypes().contains(place.getAnimalType())) {
					throw new Exception("A megadott gondoZoo nem foglalkozik ezzel az állattal!");
				}
			}
		}
		visitablePlaces.add(place);
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public List<Booking> getBookings() { return bookings; }

	public EmployeeManager getEmployeeManager() { return employeeManager; }
}
