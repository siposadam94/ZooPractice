package zoo.employee;

import zoo.CleaningArea;
import zoo.Sex;

import java.time.LocalDate;
import java.util.List;

public abstract class NonDirector extends Employee {

    abstract void reward();

    public NonDirector(String name, LocalDate birthDate, Sex sex, LocalDate hireDate) {
        super(name, birthDate, sex, hireDate);
    }
}
