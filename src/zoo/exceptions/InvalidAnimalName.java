package zoo.exceptions;

public class InvalidAnimalName extends ZooException {
    private final String receivedName;

    public InvalidAnimalName(String receivedName) {
        this.receivedName = receivedName;
    }

    public String getReceivedName(){
        return receivedName;
    }
}
