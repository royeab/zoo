package zoo;
import java.lang.Error;

public class InvalidAnimalName extends RuntimeException {
    private final String receivedName;

    public InvalidAnimalName(String receivedName) {
        this.receivedName = receivedName;
    }

    public String getReceivedName(){
        return receivedName;
    }
}
