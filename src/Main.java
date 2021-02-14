import utilities.FileUtilities;
import zoo.*;

import java.util.List;
import java.io.FileNotFoundException;
import java.util.logging.Logger;
import utilities.LogSetup;
import zoo.animal.Animal;
import zoo.exceptions.InvalidAnimalName;

import java.io.IOException;

public class Main {

    public static final String INVALID_FILE_MESSAGE = "The file provided was not found\n";
    public static final String NAME_SPLIT_BY_SPACE = " ";

    private final static Logger logger = Logger.getLogger(LogSetup.LOGGER_NAME);

    public static void main(String[] args) {
        try {
            LogSetup.setupLog();
        }
        catch (IOException exception) {
            exception.printStackTrace();
            return;
        }

        List<String> animalNames;
        try {
            animalNames = FileUtilities.getNames(args[0], NAME_SPLIT_BY_SPACE);
        }
        catch (FileNotFoundException fileNotFoundException) {
            logger.severe(INVALID_FILE_MESSAGE + fileNotFoundException);
            return;
        }

        try {
            printAllAnimalsDetails(animalNames);
        }
        catch (InvalidAnimalName invalidAnimalNameException) {
            logger.warning(invalidAnimalNameException.getReceivedName() + " is not a valid animal name!\n" +
                    invalidAnimalNameException);
        }

    }

    public static void printAllAnimalsDetails(List<String> animalNames)  throws InvalidAnimalName {
        AnimalFactory animalFactory = new AnimalFactory();
        for (String animalName : animalNames) {
            printAnimalDetails(animalName, animalFactory);
        }
    }

    private static void printAnimalDetails(String animalName, AnimalFactory animalFactory) throws InvalidAnimalName{
        Animal generatedAnimal = animalFactory.generateAnimal(animalName);
        generatedAnimal.printSound();
        generatedAnimal.printName();
    }
}
