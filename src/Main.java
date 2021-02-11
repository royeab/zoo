import zoo.*;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static final String ANIMAL_SPLIT_REGEX = " ";
    public static final String INVALID_FILE_MESSAGE = "The file provided was not found";

    private static ArrayList<String> getNamesFromFile(String fileLoc) throws FileNotFoundException {
        ArrayList<String> names = new ArrayList<String>();
        File srcFile = new File(fileLoc);
        Scanner sc = new Scanner(srcFile);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] animals = line.split(ANIMAL_SPLIT_REGEX);
            names.addAll(Arrays.asList(animals));
        }

        return names;
    }

    // Receives File with animal names separated by spaces and prints their names and sounds
    public static void printAnimals(String fileLoc) throws FileNotFoundException {
        ArrayList<String> animals = getNamesFromFile(fileLoc);

        for (String animalName : animals) {
            Animal animal = AnimalFactory.generateAnimal(animalName);
            if (animal != null) {
                animal.printSound();
                animal.printName();
            }
        }
    }


    public static void main(String[] args) {
        try {
            printAnimals(args[0]);
        } catch (FileNotFoundException error) {
            System.out.println(INVALID_FILE_MESSAGE);
            error.printStackTrace();
        }
    }
}
