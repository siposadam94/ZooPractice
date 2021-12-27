package zoo;

import zoo.animal.Animal;
import zoo.animal.AnimalType;
import zoo.detail.Coordinate;
import zoo.detail.Detail;
import zoo.employee.Employee;

import java.io.Serializable;
import java.util.List;

public class VisitablePlace<T extends Detail> implements Serializable {

   private List<Animal> animals;
   private AnimalType animalType;
   private Employee employee;
   private Coordinate coordinate;
   private T detail;

    public VisitablePlace(AnimalType animalType, Employee employee, Coordinate coordinate, T detail) {
        this.animalType = animalType;
        this.employee = employee;
        this.coordinate = coordinate;
        this.detail = detail;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) { this.employee = employee; }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }
}

