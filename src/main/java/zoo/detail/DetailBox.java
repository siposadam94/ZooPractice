package zoo.detail;

public class DetailBox <T> {
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
