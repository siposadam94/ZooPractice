package zoo.exception;

public class ZooEmployeeException extends ZooException {

    public enum ZooEmployeeExType {
        NoGondozoo("error.zooEmployeeExceptionGondozoo"),
        NoDirector("error.zooEmployeeExceptionDirector");

        private final String errorCode;

        ZooEmployeeExType(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorCode() {
            return errorCode;
        }
    }

    public ZooEmployeeException(String message) {
        super(message);
    }

}
