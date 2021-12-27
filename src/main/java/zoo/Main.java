package zoo;

import zoo.animal.Animal;
import zoo.animal.AnimalType;
import zoo.detail.Coordinate;
import zoo.detail.DetailAnimal;
import zoo.employee.Cleaner;
import zoo.employee.Director;
import zoo.employee.Employee;
import zoo.employee.GondoZoo;
import zoo.exception.GondozooNotAvailable;
import zoo.exception.ZooEmployeeException;
import zoo.task.CleanerTask;
import zoo.task.GondoZooTask;
import zoo.ticket.BookingThread;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

		//a
		Zoo zoo = new Zoo();

		//b
		Employee e1 = new Director("Igazgato Peter", LocalDate.of(1976, 1, 8), Sex.MALE, LocalDate.now());
		zoo.addEmployee(e1);

		//c
		Animal a1 = new Animal(AnimalType.RHINO, "Rino", LocalDate.of(2018, 11, 22), Sex.MALE);
		try {
			zoo.addAnimal(a1);
		} catch (GondozooNotAvailable e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		//d
		Employee e2 = new GondoZoo("Gondozo Meg", LocalDate.of(1976, 1, 8), Sex.FEMALE, Arrays.asList(AnimalType.RHINO), LocalDate.of(2010, 01, 01));
		zoo.addEmployee(e2);

		//e
		try {
			zoo.addAnimal(a1);
		} catch (GondozooNotAvailable e) {
			System.out.println(e.getMessage());
		}

		//f
		Employee e3 = new Director("Igazgato Lois", LocalDate.of(1978, 6, 8), Sex.FEMALE, LocalDate.of(2010, 01, 01));
		zoo.addEmployee(e3);

		//g
		Employee e4 = new GondoZoo("Gondozoo Chris", LocalDate.of(1976, 1, 8), Sex.MALE, Arrays.asList(AnimalType.ELEPHANT),LocalDate.now());
		zoo.addEmployee(e4);

		//h
		Animal a2 = new Animal(AnimalType.ELEPHANT, "Eli", LocalDate.of(2008, 3, 4), Sex.FEMALE);
		try {
			zoo.addAnimal(a2);
		} catch (GondozooNotAvailable e) {
			e.getMessage();
		}

		//i
		zoo.showAnimals();

		//j
		zoo.sortAnimals();

		//2es feladatsor

// 		a)
		Employee e5 = new Cleaner("Cleaner Brian",
					   LocalDate.of(1978, 12, 11),
					   Sex.MALE,
					   Arrays.asList(CleaningArea.TERRARIUM, CleaningArea.KIFUTO),
					   LocalDate.of(2005,11,10));
		zoo.addEmployee(e5);

//		b)
		Employee e6 = new Cleaner("Cleaner Stewie",
					   LocalDate.of(2009, 02, 05),
					   Sex.MALE,
					   Arrays.asList(CleaningArea.KETREC, CleaningArea.MEDENCE),
					   LocalDate.now());
		zoo.addEmployee(e6);

//		c)
		zoo.addCompletedTask(e5, new CleanerTask(CleaningArea.KIFUTO));
		zoo.addCompletedTask(e5, new CleanerTask(CleaningArea.TERRARIUM));
		zoo.addCompletedTask(e2, new GondoZooTask(AnimalType.RHINO));

//		d)
		zoo.showCompletedTasks();

//		3.feladat 3.rész
		DetailAnimal descriptionMammal = new DetailAnimal("Europe", false, 28, 4, DetailAnimal.BasicAnimalClass.MAMMAL);
		DetailAnimal descriptionReptile = new DetailAnimal("Europe", true, 50, 4, DetailAnimal.BasicAnimalClass.REPTILE);
		DetailAnimal descriptionBird = new DetailAnimal("Australia", false, 7, 2, DetailAnimal.BasicAnimalClass.BIRD);
		DetailAnimal descriptionFish = new DetailAnimal("Africa", true, 6, 0, DetailAnimal.BasicAnimalClass.FISH);



		VisitablePlace<DetailAnimal> visitablePlace1 = new VisitablePlace<>(
				AnimalType.RHINO,
				e2,
				new Coordinate(112.242,1521.224),
				descriptionMammal
		);
		visitablePlace1.setAnimals(Arrays.asList(a1));

		zoo.addVisitablePlace(visitablePlace1);

		VisitablePlace<DetailAnimal> visitablePlace2 = new VisitablePlace<>(
				AnimalType.ELEPHANT,
				e4,
				new Coordinate(453.242,6521.224),
				descriptionMammal
		);
		visitablePlace2.setAnimals(Arrays.asList(a2));

		zoo.addVisitablePlace(visitablePlace2);


		Employee tempEmployee = new GondoZoo(
				"Nem itt dolgozó",
				LocalDate.of(1993,12,07),
				Sex.MALE,
				Arrays.asList(AnimalType.EAGLE),
				LocalDate.now());

		VisitablePlace<DetailAnimal> visitablePlace3 = new VisitablePlace<>(
				AnimalType.EAGLE,
				tempEmployee,
				new Coordinate(1712.242,8521.84),
				descriptionBird
		);

		//Error
		//zoo.addVisitablePlace(visitablePlace3);


		VisitablePlace<DetailAnimal> visitablePlace4 = new VisitablePlace<>(
				AnimalType.LION,
				e2,
				new Coordinate(6712.242,5721.84),
				descriptionMammal
		);

		//Error
		//zoo.addVisitablePlace(visitablePlace4);



		zoo.showSpecificAnimalsByType(AnimalType.ELEPHANT);

		ZooSaver.saveZooPrettier(zoo);
		//k
		Zoo zoo2 = new Zoo();

		//l
		Zoo.showZooCount();

		//m
		Zoo.Mover mover = zoo.new Mover();
		mover.moveZoo(zoo2);

		//n
		zoo.showAnimals();
		zoo.showEmployees();

		//o
		zoo2.showAnimals();
		zoo2.showEmployees();

		//p
		try {
			zoo2.releaseEmployee(e1);
		} catch (ZooEmployeeException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		//q
		try {
			zoo2.releaseEmployee(e2);
		} catch (ZooEmployeeException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		//r
		zoo2.sellAnimal(a1);

		//s
		zoo2.sellAnimal(a2);

		//t
		try {
			zoo2.releaseEmployee(e4);
		} catch (ZooEmployeeException e) {
			System.out.println(e.getMessage());
		}

		//u
		zoo2.showAnimals();
		zoo2.showEmployees();

		zoo2.addCompletedTask(e2,new GondoZooTask(AnimalType.RHINO));

		zoo2.showCompletedTasks();

		zoo2.rewardCheck();

		Zoo zoo3 = ZooSaver.loadZooPrettier();

		zoo3.showAnimals();
		zoo3.getEmployeeManager().showCleaners();
//
//		try {
//			BookingThread.runOneThread(zoo3);
//			BookingThread.runTwoThread(zoo3);
//			BookingThread.runFourThread(zoo3);
//			BookingThread.runExecutor(zoo3);
//
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
////		Class<?> animalClass = Class.forName("zoo.animal.Animal");
////		Animal animal = (Animal) animalClass.getDeclaredConstructor().newInstance();


	}
}
