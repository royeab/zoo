import zoo.*;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static final String ANIMAL_SPLIT_REGEX = " ";
    public static final String INVALID_FILE_MESSAGE = "The file provided was not found";

    public static void main(String[] args) {
        List<String> animalNames = null;

        try {
            animalNames = getAnimalNamesFromGivenFile(args[0]);
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println(INVALID_FILE_MESSAGE);
            fileNotFoundException.printStackTrace();
            System.exit(1);
        }

        try {
            generateAnimalsFromListAndPrintDetails(animalNames);
        }
        catch (InvalidAnimalName invalidAnimalNameException) {
            System.out.println(invalidAnimalNameException.getReceivedName() + " is not a valid animal name!");
        }

    }

    public static void generateAnimalsFromListAndPrintDetails(List<String> animalNames)  throws InvalidAnimalName {
        for (String animalName : animalNames) {
            generateAnimalAndPrintDetails(animalName);
        }
    }

    public static ArrayList<String> getAnimalNamesFromGivenFile(String fileLocation) throws FileNotFoundException {
        ArrayList<String> animalNames = new ArrayList<String>();
        File srcFile = new File(fileLocation);
        Scanner scanner = new Scanner(srcFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] animalNamesArray = line.split(ANIMAL_SPLIT_REGEX);
            animalNames.addAll(Arrays.asList(animalNamesArray));
        }

        return animalNames;
    }

    private static void generateAnimalAndPrintDetails(String animalName){
        AnimalFactory animalFactory = new AnimalFactory();
        Animal generatedAnimal = animalFactory.generateAnimal(animalName);
        generatedAnimal.printSound();
        generatedAnimal.printName();
    }
}
