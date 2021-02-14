package zoo.exceptions;

public class InvalidFilePath extends ZooException{
    private final String path;

    public InvalidFilePath(String path){
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
