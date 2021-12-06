package zoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import zoo.animal.Animal;
import zoo.employee.Director;
import zoo.employee.Employee;
import zoo.employee.GondoZoo;

public class Zoo {
	
	private static int zooCounter;
	private Director director;
	private List<GondoZoo> zookeepers;
	private List<Animal> animals;
	
	public List<Animal> getAnimals() {
		return animals;
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
			System.out.println("Az állatkert igazgazója: " + director.getName());
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
	
	public void addEmployee(Employee employee) {
		if(employee instanceof Director) {
			if(this.director == null) {
				this.director = (Director) employee;
				System.out.println("Az állatkert igazgatója " + director.getName() + " lett!");
			}else {
				System.out.println("Az állatkertnek jelenleg már van igazgatója!");
			}
		}
		else if(employee instanceof GondoZoo) {
			zookeepers.add((GondoZoo)employee);
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
		} else {
			int caredAnimalCounter = 0;
			zookeepers.remove(employee);
			GondoZoo gondoZoo = (GondoZoo) employee;
			for (GondoZoo e : zookeepers) {
				if (e.getCaredAnimalType() == gondoZoo.getCaredAnimalType()) {
					caredAnimalCounter++;
				}
			}
			if (caredAnimalCounter == 0) {
				System.out.println("Az állatkertnek szüksége van " + gondoZoo.getCaredAnimalType() + " gondozóra!");
			}
		}
	}
	
	public void showAnimals() {
		if (animals.isEmpty()) {
			System.out.println("Az állatkert jelenleg üres!");
		}else {
			for (Animal a : animals) {
				System.out.println("Állat fajtája: " + a.getAnimalType() +" neve: " + a.getNickname());
			}
		}
		
	}
	
	public void addAnimal(Animal animal) {
		boolean ableAdopt = false;
		
		for (GondoZoo z : zookeepers) {
			if(z.getCaredAnimalType() == animal.getAnimalType()) {
				ableAdopt = true;
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
