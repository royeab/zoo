package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtilities {
    public static List<String> getNames(String fileLocation, String splitCondition) throws FileNotFoundException {
        List<String> animalNames = new ArrayList<>();
        File srcFile = new File(fileLocation);
        Scanner scanner = new Scanner(srcFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] animalNamesArray = line.split(splitCondition);
            Collections.addAll(animalNames, animalNamesArray);
        }

        return animalNames;
    }
}
