package zoo.animal;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class Animal {
    protected String animalName;
    protected String animalSound;

    public void printName() {
        log.info(animalName);
    }

    public void printSound() {
        log.info(animalSound);
    }
}