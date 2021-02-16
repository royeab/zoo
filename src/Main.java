import org.apache.logging.log4j.LogManager;
import utilities.FileUtils.FileUtilities;
import zoo.*;
import java.util.List;
import java.io.FileNotFoundException;
import org.apache.logging.log4j.*;
import zoo.animal.Animal;
import zoo.exceptions.InvalidAnimalName;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static final String NAME_SPLIT_BY_SPACE = " ";

    public static void main(String[] args) {
        final String animalNameFilePath = args[0];

        try {
            List<String> animalNames = FileUtilities.getWordsBySplitCondition(animalNameFilePath, NAME_SPLIT_BY_SPACE);
            printAllAnimalsDetails(animalNames);
        }
        catch (FileNotFoundException fileNotFoundException) {
            log.log(Level.FATAL, fileNotFoundException.getMessage(), fileNotFoundException);
        }
    }

    public static void printAllAnimalsDetails(List<String> animalNames) {
        AnimalFactory animalFactory = new AnimalFactory();
        for (String animalName : animalNames) {
            printAnimalDetails(animalName, animalFactory);
        }
    }

    private static void printAnimalDetails(String animalName, AnimalFactory animalFactory) {
        try {
            Animal generatedAnimal = animalFactory.generateAnimal(animalName);
            generatedAnimal.printSound();
            generatedAnimal.printName();
        }

        catch (InvalidAnimalName invalidAnimalName) {
            log.log(Level.WARN, invalidAnimalName.getMessage(), invalidAnimalName);
        }
    }
}
