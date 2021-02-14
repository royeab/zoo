package utilities.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtilities {
    public static List<String> getNames(String fileLocation, String splitCondition) throws FileNotFoundException {
        List<String> namesList = new ArrayList<>();
        File srcFile = new File(fileLocation);
        Scanner scanner = new Scanner(srcFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] namesArray = line.split(splitCondition);
            Collections.addAll(namesList, namesArray);
        }

        return namesList;
    }
}
