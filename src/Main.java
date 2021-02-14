import zoo.*;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import utilities.LogSetup;
import zoo.exceptions.InvalidAnimalName;

import java.io.IOException;

public class Main {
    public static final String ANIMAL_SPLIT_BY_SPACE = " ";
    public static final String INVALID_FILE_MESSAGE = "The file provided was not found\n";

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
            animalNames = getAnimalNamesFromGivenFile(args[0]);
        }
        catch (FileNotFoundException fileNotFoundException) {
            logger.severe(INVALID_FILE_MESSAGE + fileNotFoundException);
            return;
        }

        try {
            generateAnimalsFromListAndPrintDetails(animalNames);
        }
        catch (InvalidAnimalName invalidAnimalNameException) {
            logger.warning(invalidAnimalNameException.getReceivedName() + " is not a valid animal name!\n" +
                    invalidAnimalNameException);
        }

    }

    public static void generateAnimalsFromListAndPrintDetails(List<String> animalNames)  throws InvalidAnimalName {
        for (String animalName : animalNames) {
            generateAnimalAndPrintDetails(animalName);
        }
    }

    public static ArrayList<String> getAnimalNamesFromGivenFile(String fileLocation) throws FileNotFoundException {
        ArrayList<String> animalNames = new ArrayList<>();
        File srcFile = new File(fileLocation);
        Scanner scanner = new Scanner(srcFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] animalNamesArray = line.split(ANIMAL_SPLIT_BY_SPACE);
            animalNames.addAll(Arrays.asList(animalNamesArray));
        }

        return animalNames;
    }

    private static void generateAnimalAndPrintDetails(String animalName) throws InvalidAnimalName{
        AnimalFactory animalFactory = new AnimalFactory();
        Animal generatedAnimal = animalFactory.generateAnimal(animalName);
        generatedAnimal.printSound();
        generatedAnimal.printName();
    }
}
