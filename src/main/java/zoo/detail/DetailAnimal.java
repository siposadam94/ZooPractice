package zoo.detail;

public class DetailAnimal extends Detail {

    public enum BasicAnimalClass {
        MAMMAL, FISH, BIRD, REPTILE, AMPHIBIAN
    }

    private int averageAge;
    private int numberOfLegs;
    private BasicAnimalClass basicAnimalClass;

    public DetailAnimal(String origin, boolean isCarnivorous, int averageAge, int numberOfLegs, BasicAnimalClass basicAnimalClass) {
        super(origin, isCarnivorous);
        this.averageAge = averageAge;
        this.numberOfLegs = numberOfLegs;
        this.basicAnimalClass = basicAnimalClass;
    }

    public int getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(int averageAge) {
        this.averageAge = averageAge;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public BasicAnimalClass getBasicAnimalClass() {
        return basicAnimalClass;
    }

    public void setBasicAnimalClass(BasicAnimalClass basicAnimalClass) {
        this.basicAnimalClass = basicAnimalClass;
    }
}
