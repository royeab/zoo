package zoo.exceptions;

public class InvalidAnimalName extends ZooException {
    public InvalidAnimalName(String message) {
        super(message + "is not a valid animal name");
    }
}
