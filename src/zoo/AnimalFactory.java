package zoo;
import zoo.animal.*;
import zoo.exceptions.InvalidAnimalName;

import java.util.HashMap;

public class AnimalFactory {
    public static final String DOG_NAME = "Dog";
    public static final String DUCK_NAME = "Duck";
    public static final String CAT_NAME = "Cat";

    public final HashMap<String, Animal> animalDictionary = new HashMap<String, Animal>();

    public Animal generateAnimal(String animalName) throws InvalidAnimalName{
        if (!animalDictionary.containsKey(animalName)) {
            switch (animalName) {
                case DOG_NAME -> animalDictionary.put(DOG_NAME, new Dog());
                case DUCK_NAME -> animalDictionary.put(DUCK_NAME, new Duck());
                case CAT_NAME -> animalDictionary.put(CAT_NAME, new Cat());
                default -> throw new InvalidAnimalName(animalName);
            }
        }

        return animalDictionary.get(animalName);
    }
}