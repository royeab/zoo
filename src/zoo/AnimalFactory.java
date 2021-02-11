package zoo;
import java.util.HashMap;

public class AnimalFactory {
    public static String DOG_NAME = "Dog";
    public static String DUCK_NAME = "Duck";
    public static String CAT_NAME = "Cat";

    public static final HashMap<String, Animal> animalDictionary = new HashMap<String, Animal>();
    static {
        animalDictionary.put(DOG_NAME, new Dog());
        animalDictionary.put(DUCK_NAME, new Duck());
        animalDictionary.put(CAT_NAME, new Cat());
    }

    public static Animal generateAnimal(String animalName) {
        return animalDictionary.get(animalName);
    }
}