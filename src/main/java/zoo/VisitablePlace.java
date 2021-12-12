package zoo;

import zoo.animal.Animal;
import zoo.animal.AnimalType;
import zoo.detail.Coordinate;
import zoo.detail.Detail;
import zoo.detail.DetailBox;
import zoo.employee.Employee;

import java.util.List;

public class VisitablePlace {

   private List<Animal> animals;
   private AnimalType animalType;
   private Employee employee;
   private Coordinate coordinate;
   private DetailBox<? extends Detail> detail;

    public VisitablePlace() {
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

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public DetailBox<? extends Detail> getDetail() {
        return detail;
    }

    public void setDetail(DetailBox<? extends Detail> detail) {
        this.detail = detail;
    }
}

