package zoo.exceptions;

public class InvalidFilePath extends ZooException{

    public InvalidFilePath(){
        super();
    }
    public InvalidFilePath(String path) {
        super(path + "Is not a valid file path");
    }

    public InvalidFilePath(String path, Throwable cause) {
        super(path + "Is not a valid file path", cause);
    }
}
