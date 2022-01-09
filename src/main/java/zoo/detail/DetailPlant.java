package zoo.detail;

public class DetailPlant extends Detail {

    public enum Season {
        SPRING, SUMMER, FALL, WINTER
    }

    private String soilType;
    private boolean isBlooming;
    private Season bloomingSeason;
    private int wateringFrequencyDays;

    public DetailPlant(String origin, String soilType, boolean isBlooming, Season bloomingSeason, int wateringFrequencyDays, boolean isCarnivorous) {
        super(origin, isCarnivorous);
        this.soilType = soilType;
        this.isBlooming = isBlooming;
        this.bloomingSeason = bloomingSeason;
        this.wateringFrequencyDays = wateringFrequencyDays;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public boolean isBlooming() {
        return isBlooming;
    }

    public void setBlooming(boolean blooming) {
        isBlooming = blooming;
    }

    public Season getBloomingSeason() {
        return bloomingSeason;
    }

    public void setBloomingSeason(Season bloomingSeason) {
        this.bloomingSeason = bloomingSeason;
    }

    public int getWateringFrequencyDays() {
        return wateringFrequencyDays;
    }

    public void setWateringFrequencyDays(int wateringFrequencyDays) {
        this.wateringFrequencyDays = wateringFrequencyDays;
    }
}
