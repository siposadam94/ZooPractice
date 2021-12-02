package zoo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import zoo.animal.Animal;
import zoo.animal.AnimalType;
import zoo.employee.Director;
import zoo.employee.Employee;
import zoo.employee.GondoZoo;

public class Main {

	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		
		Animal a1 = new Animal(AnimalType.RHINO, "Rini", LocalDate.of(2018, 11, 22), Sex.MALE);
		Animal a2 = new Animal(AnimalType.ELEPHANT, "Eli", LocalDate.of(2008, 3, 4), Sex.FEMALE);
		Animal a3 = new Animal(AnimalType.GORILLA, "Zodd", LocalDate.of(2011, 2, 14), Sex.MALE);
		Animal a4 = new Animal(AnimalType.GORILLA, "Appe", LocalDate.of(2011, 2, 14), Sex.MALE);
		Animal a5 = new Animal(AnimalType.GORILLA, "Seth", LocalDate.of(2008, 4, 17), Sex.FEMALE);
		Animal a6 = new Animal(AnimalType.GORILLA, "Body", LocalDate.of(2017, 6, 18), Sex.MALE);
		
		
		Employee e1 = new Director("Igazgato", LocalDate.of(1976, 1, 8), Sex.MALE);
		Employee e2 = new GondoZoo("gondozo1", LocalDate.of(1976, 1, 8), Sex.MALE, AnimalType.ELEPHANT);
		Employee e3 = new GondoZoo("gondozo2", LocalDate.of(1976, 1, 8), Sex.MALE, AnimalType.GORILLA);
		Employee e4 = new GondoZoo("gondozo3", LocalDate.of(1976, 1, 8), Sex.FEMALE, AnimalType.RHINO);
		
		
		zoo.addEmployee(e1);
		zoo.addEmployee(e2);
		zoo.addEmployee(e3);
		zoo.addEmployee(e4);
		zoo.addAnimal(a1);
		zoo.addAnimal(a2);
		zoo.addAnimal(a3);zoo.addAnimal(a4);zoo.addAnimal(a5);zoo.addAnimal(a6);
		
//		zoo.showAnimals();
//		System.out.println("---------");
//		
//		zoo.sortAnimals();
//		
//		zoo.showAnimals();

	}

}
