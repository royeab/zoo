import zoo.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

    // Receives File with animal names separated by spaces and prints their names and sounds
    public static void PrintAnimals(String fileloc){
        File srcFile = new File(fileloc);
        AnimalFactory factory = new AnimalFactory();

        // Make sure file can be successfully opened
        try {
            Scanner sc = new Scanner(srcFile);

            // This while loop makes sure we read all lines in the file
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                // Splits the string based on spaces
                String[] animals = line.split(" ");
                for (String animal_name : animals) {
                    Animal animal = factory.generateAnimal(animal_name);
                    animal.printSound();
                    animal.printName();
                }
            }
        }

        // When File not found prints error and call stack
        catch (FileNotFoundException error){
            System.out.println("The file provided was not found");
            error.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrintAnimals(args[0]);
    }
}
