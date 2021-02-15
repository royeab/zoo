package zoo.exceptions;

public class ZooException extends Exception {
    public ZooException(){
        super();
    }
    public ZooException(String message) {
        super(message);
    }

    public ZooException(String message, Throwable cause) {
        super(message, cause);
    }
}
