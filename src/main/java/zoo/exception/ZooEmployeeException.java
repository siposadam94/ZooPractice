package zoo.exception;

public class ZooEmployeeException extends ZooException {

    public enum ZooEmployeeExType {
        NOGONDOZOO("error.zooEmployeeExceptionGondozoo"),
        NODIRECTOR("error.zooEmployeeExceptionDirector");

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
