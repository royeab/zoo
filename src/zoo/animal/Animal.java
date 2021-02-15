package zoo.animal;
//import utilities.Log.LogSetup;
import org.apache.logging.log4j.*;

public abstract class Animal {
    protected String animalName;
    protected String animalSound;
    protected final Logger logger = LogManager.getLogger();

    public void printName() {
        logger.info(animalName);
    }

    public void printSound() {
        logger.info(animalSound);
    }
}