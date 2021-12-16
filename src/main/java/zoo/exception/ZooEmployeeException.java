package zoo.exception;

public class ZooEmployeeException extends ZooException {

    public enum ZooEmployeeExType {
        NoGondozoo("Gondozó elbocsátáskor az általa gondozott állatokat nem tudja az állatkert tovább gondozni"),
        NoDirector("Igazgató elbocsátás után az állatkertnek nincs igazgatója");

        private final String errorCode;

        ZooEmployeeExType(String errorCode) {
            this.errorCode = errorCode;
        }
    }

    public ZooEmployeeExType zooEmployeeExType;

    public ZooEmployeeException(ZooEmployeeExType zooEmployeeExType) {
        this.zooEmployeeExType = zooEmployeeExType;
    }

}
