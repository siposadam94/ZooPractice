package zoo.exception;

public class ZooEmployeeException extends ZooException {

    public enum ZooEmployeeExType {
        NoGondozoo("ERROR: Gondozó elbocsátáskor az általa gondozott állatokat nem tudja az állatkert tovább gondozni"),
        NoDirector("ERROR: Igazgató elbocsátás után az állatkertnek nincs igazgatója");

        private final String errorCode;

        ZooEmployeeExType(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorCode() {
            return errorCode;
        }
    }

    public ZooEmployeeExType zooEmployeeExType;

    public ZooEmployeeException(ZooEmployeeExType zooEmployeeExType) {
        this.zooEmployeeExType = zooEmployeeExType;
    }

    @Override
    public String getMessage() {
        return zooEmployeeExType.getErrorCode();
    }
}
