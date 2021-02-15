package zoo.exceptions;

public class InvalidAnimalName extends ZooException {
    public InvalidAnimalName(){
        super();
    }
    public InvalidAnimalName(String message) {
        super(message + "is not a valid animal name");
    };
    public InvalidAnimalName(String message, Throwable cause){
        super(message + "is not a valid animal name", cause);
    }
}
