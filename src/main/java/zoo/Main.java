package zoo;

import zoo.animal.Animal;
import zoo.animal.AnimalType;
import zoo.detail.*;
import zoo.employee.Cleaner;
import zoo.employee.Director;
import zoo.employee.Employee;
import zoo.employee.GondoZoo;
import zoo.task.CleanerTask;
import zoo.task.GondoZooTask;
import zoo.ticket.Booking;
import zoo.ticket.BookingThread;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		//a
		Zoo zoo = new Zoo();
		//b
		Employee e1 = new Director("Igazgato Peter", LocalDate.of(1976, 1, 8), Sex.MALE, LocalDate.now());
		zoo.addEmployee(e1);
		//c
		Animal a1 = new Animal(AnimalType.RHINO, "Rino", LocalDate.of(2018, 11, 22), Sex.MALE);
		zoo.addAnimal(a1);
		//d
		Employee e2 = new GondoZoo("Gondozo Meg", LocalDate.of(1976, 1, 8), Sex.FEMALE, Arrays.asList(AnimalType.RHINO), LocalDate.of(2010, 01, 01));
		zoo.addEmployee(e2);
		//e
		zoo.addAnimal(a1);
		//f
		Employee e3 = new Director("Igazgato Lois", LocalDate.of(1978, 6, 8), Sex.FEMALE, LocalDate.of(2010, 01, 01));
		zoo.addEmployee(e3);
		//g
		Employee e4 = new GondoZoo("Gondozoo Chris", LocalDate.of(1976, 1, 8), Sex.MALE, Arrays.asList(AnimalType.ELEPHANT),LocalDate.now());
		zoo.addEmployee(e4);
		//h
		Animal a2 = new Animal(AnimalType.ELEPHANT, "Eli", LocalDate.of(2008, 3, 4), Sex.FEMALE);
		zoo.addAnimal(a2);
		//i
		zoo.showAnimals();
		//j
		zoo.sortAnimals();

		//2es feladatsor

// 		a)
		Employee e5 = new Cleaner("Cleaner Brian",
					   LocalDate.of(2007, 12, 11),
					   Sex.MALE,
					   Arrays.asList(CleaningArea.TERRARIUM, CleaningArea.KIFUTO),
					   LocalDate.now());
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

		// PRÓBA 2/2 part
//		DetailBox<Detail> detail2 = new DetailBox<>(
//				new DetailAnimal("Asia", false, 17, 4, DetailAnimal.BasicAnimalClass.MAMMAL)
//		);

		//3.feladat 3.rész

		VisitablePlace<DetailAnimal> visitablePlace1 = new VisitablePlace<>(
				AnimalType.RHINO,
				e2,
				new Coordinate(112.242,1521.224),
				new DetailAnimal("Europe", false, 19, 4, DetailAnimal.BasicAnimalClass.MAMMAL)
		);
		visitablePlace1.setAnimals(Arrays.asList(a1));

		try {
			zoo.addVisitablePlace(visitablePlace1);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		VisitablePlace<DetailAnimal> visitablePlace2 = new VisitablePlace<>(
				AnimalType.ELEPHANT,
				e2,
				new Coordinate(453.242,6521.224),
				new DetailAnimal("Europe", false, 19, 4, DetailAnimal.BasicAnimalClass.MAMMAL));
		visitablePlace2.setAnimals(Arrays.asList(a2));

		try {
			zoo.addVisitablePlace(visitablePlace2);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		Employee tempEmployee = new GondoZoo(
				"Nem itt dolgozó",
				LocalDate.of(1993,12,07),
				Sex.MALE,
				Arrays.asList(AnimalType.ELEPHANT),
				LocalDate.now());

		VisitablePlace<DetailAnimal> visitablePlace3 = new VisitablePlace<>(
				AnimalType.ELEPHANT,
				tempEmployee,
				new Coordinate(1712.242,8521.84),
				new DetailAnimal("Africa", false, 19, 4, DetailAnimal.BasicAnimalClass.MAMMAL));
		visitablePlace3.setAnimals(Arrays.asList(a2));


		try {
			zoo.addVisitablePlace(visitablePlace3);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		VisitablePlace<DetailAnimal> visitablePlace4 = new VisitablePlace<>(
				AnimalType.LION,
				e2,
				new Coordinate(6712.242,5721.84),
				new DetailAnimal("Africa", true, 19, 4, DetailAnimal.BasicAnimalClass.MAMMAL));

		try {
			zoo.addVisitablePlace(visitablePlace4);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		zoo.showSpecificAnimalsByType(AnimalType.ELEPHANT);

		ZooSaver.saveZoo(zoo);

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
		zoo2.releseEmployee(e1);
		//q
		zoo2.releseEmployee(e2);
		//r
		zoo2.sellAnimal(a1);
		//s
		zoo2.sellAnimal(a2);
		//t
		zoo2.releseEmployee(e4);
		//u
		zoo2.showAnimals();
		zoo2.showEmployees();

		zoo2.addCompletedTask(e2,new GondoZooTask(AnimalType.RHINO));
		zoo2.addCompletedTask(e2,new GondoZooTask(AnimalType.GORILLA));

		zoo2.showCompletedTasks();

		zoo2.reward();

		Zoo zoo3 = ZooSaver.loadZoo();

		zoo3.showAnimals();
		zoo3.getEmployeeManager().showCleaners();

		try {
			BookingThread.runOneThread(zoo3);
			BookingThread.runTwoThread(zoo3);
			BookingThread.runFourThread(zoo3);
			BookingThread.runExecutor(zoo3);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
