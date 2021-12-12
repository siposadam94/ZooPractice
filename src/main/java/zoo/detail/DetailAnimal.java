package zoo.detail;

public class DetailAnimal extends Detail {

    public enum BasicAnimalClass {
        MAMMAL, FISH, BIRD, REPTILE, AMPHIBIAN
    }

    private String origin;
    private boolean isCarnivorous;
    private int averageAge;
    private int numberOfLegs;
    private BasicAnimalClass basicAnimalClass;

    public DetailAnimal(String origin, boolean isCarnivorous, int averageAge, int numberOfLegs, BasicAnimalClass basicAnimalClass) {
        this.origin = origin;
        this.isCarnivorous = isCarnivorous;
        this.averageAge = averageAge;
        this.numberOfLegs = numberOfLegs;
        this.basicAnimalClass = basicAnimalClass;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean isCarnivorous() {
        return isCarnivorous;
    }

    public void setCarnivorous(boolean carnivorous) {
        isCarnivorous = carnivorous;
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
