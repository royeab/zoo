import zoo.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static ArrayList<String> getNames(String fileloc) throws FileNotFoundException{
        ArrayList<String> names = new ArrayList<String>();
        File srcFile = new File(fileloc);
        Scanner sc = new Scanner(srcFile);

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] animals = line.split(" ");
            names.addAll(Arrays.asList(animals));
        }
        return names;
    }

    // Receives File with animal names separated by spaces and prints their names and sounds
    public static void PrintAnimals(String fileloc) throws FileNotFoundException {
        ArrayList<String> animals = getNames(fileloc);
        AnimalFactory factory = new AnimalFactory();

        for (String animal_name : animals) {
            Animal animal = factory.generateAnimal(animal_name);
            if (animal != null){
                animal.printSound();
                animal.printName();
            }

        }
    }




    public static void main(String[] args) {
        try{
            PrintAnimals(args[0]);
        }
        catch (FileNotFoundException error){
            System.out.println("The file provided was not found");
            error.printStackTrace();
        }
    }
}
