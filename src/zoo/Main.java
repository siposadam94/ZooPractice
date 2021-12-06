package zoo;

import java.math.BigDecimal;
import java.time.LocalDate;

import zoo.animal.Animal;
import zoo.animal.AnimalType;
import zoo.employee.Director;
import zoo.employee.Employee;
import zoo.employee.GondoZoo;

public class Main {

	public static void main(String[] args) {
		//a
		Zoo zoo = new Zoo();
		//b
		Employee e1 = new Director("Igazgato", LocalDate.of(1976, 1, 8), Sex.MALE);
		zoo.addEmployee(e1);
		//c
		Animal a1 = new Animal(AnimalType.RHINO, "Rino", LocalDate.of(2018, 11, 22), Sex.MALE);
		zoo.addAnimal(a1);
		//d
		Employee e2 = new GondoZoo("gondozo3", LocalDate.of(1976, 1, 8), Sex.FEMALE, AnimalType.RHINO);
		zoo.addEmployee(e2);
		//e
		zoo.addAnimal(a1);
		//f
		Employee e3 = new Director("Igazgato2", LocalDate.of(1978, 6, 8), Sex.FEMALE);
		zoo.addEmployee(e3);
		//g
		Employee e4 = new GondoZoo("gondozo1", LocalDate.of(1976, 1, 8), Sex.MALE, AnimalType.ELEPHANT);
		zoo.addEmployee(e4);
		//h
		Animal a2 = new Animal(AnimalType.ELEPHANT, "Eli", LocalDate.of(2008, 3, 4), Sex.FEMALE);
		zoo.addAnimal(a2);
		//i
		zoo.showAnimals();
		//j
		zoo.sortAnimals();
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
	}

}
