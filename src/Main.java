import org.apache.logging.log4j.LogManager;
import utilities.FileUtils.FileUtilities;
import utilities.Log.exceptions.LogFileException;
import zoo.*;

import java.util.List;
import java.io.FileNotFoundException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.apache.logging.log4j.*;
//import utilities.Log.LogSetup;
import zoo.animal.Animal;
import zoo.exceptions.InvalidAnimalName;

public class Main {

    public static final String INVALID_FILE_MESSAGE = "The file provided was not found";
    public static final String NAME_SPLIT_BY_SPACE = " ";

    private final static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        final String animalNameFilePath = args[0];

        List<String> animalNames;

        try {
            animalNames = FileUtilities.getWordsBySplitCondition(animalNameFilePath, NAME_SPLIT_BY_SPACE);
        }
        catch (FileNotFoundException fileNotFoundException) {
            logger.log(Level.FATAL, INVALID_FILE_MESSAGE, fileNotFoundException);
            return;
        }

        printAllAnimalsDetails(animalNames);
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

        catch (InvalidAnimalName invalidAnimalNameException) {
            logger.log(Level.WARN, invalidAnimalNameException.getMessage(),
                invalidAnimalNameException);
        }
    }
}
