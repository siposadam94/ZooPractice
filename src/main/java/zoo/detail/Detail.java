package zoo.detail;

import java.io.Serializable;

public abstract class Detail implements Serializable {
    private String origin;
    private boolean isCarnivorous;

    public Detail(String origin, boolean isCarnivorous) {
        this.origin = origin;
        this.isCarnivorous = isCarnivorous;
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
}
