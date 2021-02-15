package zoo.exceptions;

public class InvalidFilePath extends ZooException{

    public InvalidFilePath(){
        super();
    }
    public InvalidFilePath(String path) {
        super(path);
    }
}
