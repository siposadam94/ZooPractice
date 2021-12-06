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
			System.out.println("Az �llatkert igazgaz�ja: " + director.getName());
		}else {
			System.out.println("Az �llatkertnek nincs jelenleg igazgat�ja!");
		}
		if(zookeepers.isEmpty()) {
			System.out.println("Az �llatkertnek jelenleg nincs dolgoz�ja!");
		}else {
			for (Employee e : zookeepers) {
				System.out.println("Az �llatkert dolgoz�ja: " + e.getName());
			}
		}
		
	}
	
	public void addEmployee(Employee employee) {
		if(employee instanceof Director) {
			if(this.director == null) {
				this.director = (Director) employee;
				System.out.println("Az �llatkert igazgat�ja " + director.getName() + " lett!");
			}else {
				System.out.println("Az �llatkertnek jelenleg m�r van igazgat�ja!");
			}
		}
		else if(employee instanceof GondoZoo) {
			zookeepers.add((GondoZoo)employee);
		}
	}
	
	public void releseEmployee(Employee employee) {
		if (employee instanceof Director) {
			if (this.director == null) {
				System.out.println("Az �llatkertnek nincs jelenleg igazgat�ja!");
			} else {
				System.out.println("Az �llatkert " + director.getName() + " igazgat�ja elt�vozott!");
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
				System.out.println("Az �llatkertnek sz�ks�ge van " + gondoZoo.getCaredAnimalType() + " gondoz�ra!");
			}
		}
	}
	
	public void showAnimals() {
		if (animals.isEmpty()) {
			System.out.println("Az �llatkert jelenleg �res!");
		}else {
			for (Animal a : animals) {
				System.out.println("�llat fajt�ja: " + a.getAnimalType() +" neve: " + a.getNickname());
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
			System.out.println("A(z) " + animal.getAnimalType() + " �llatot az �llatkert jelenleg nem tudja fogadni");
		}
		
	}
	
	public void sellAnimal(Animal animal) {
		animals.remove(animal);
	}
	
	
	public void showAnimalsInZooCount() {
		System.out.println("Az �llatkertnek " + animals.size() + " lak�ja van jelenleg!");
	}
	
	public static void showZooCount() {
		System.out.println("Az orsz�gnak " + zooCounter + " �llatkertje van jelenleg!");	
	}
	
	{
		System.out.println("Az �llatkert megalapul�sa: " + LocalDate.now());
		zooCounter++;
		zookeepers = new ArrayList<>();
		animals = new ArrayList<>();
		System.out.println("Az �llatkert sajnos m�g �res!");
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
