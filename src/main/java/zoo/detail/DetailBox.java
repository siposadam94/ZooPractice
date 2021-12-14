package zoo.detail;

import java.io.Serializable;

public class DetailBox <T> implements Serializable {
    private T t;

    public DetailBox(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
