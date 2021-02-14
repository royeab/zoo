package zoo.exceptions;
import java.lang.Error;

public class InvalidAnimalName extends zooException {
    private final String receivedName;

    public InvalidAnimalName(String receivedName) {
        this.receivedName = receivedName;
    }

    public String getReceivedName(){
        return receivedName;
    }
}
