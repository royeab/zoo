import utilities.FileUtils.FileUtilities;
import utilities.Log.exceptions.LogFileException;
import zoo.*;

import java.util.List;
import java.io.FileNotFoundException;
import java.util.logging.Logger;
import utilities.Log.LogSetup;
import zoo.animal.Animal;
import zoo.exceptions.InvalidAnimalName;

public class Main {

    public static final String INVALID_FILE_MESSAGE = "The file provided was not found\n";
    public static final String LOGGER_EXCEPTION_MESSAGE = "An error has occurred when creating a log file\n";
    public static final String NAME_SPLIT_BY_SPACE = " ";

    private final static Logger logger = Logger.getLogger(LogSetup.LOGGER_NAME);

    public static void main(String[] args) {
        try {
            LogSetup.setupLog();
        }
        catch (LogFileException ioException) {
            logger.severe(LOGGER_EXCEPTION_MESSAGE + ioException);
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
