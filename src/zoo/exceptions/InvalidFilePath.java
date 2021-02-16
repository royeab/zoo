package zoo.exceptions;

public class InvalidFilePath extends ZooException{
    public InvalidFilePath(String path) {
        super(path + "Is not a valid file path");
    }
}
