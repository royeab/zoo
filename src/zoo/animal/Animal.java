package zoo.animal;
import utilities.Log.LogSetup;
import java.util.logging.Logger;

public abstract class Animal {
    protected String animalName;
    protected String animalSound;
    protected final Logger logger = Logger.getLogger(LogSetup.LOGGER_NAME);

    public void printName() {
        logger.info(animalName);
    }

    public void printSound() {
        logger.info(animalSound);
    }
}