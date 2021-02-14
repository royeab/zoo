package zoo.animal;

import zoo.Animal;

public class Duck extends Animal {
    public static final String DUCK_NAME = "Duck";
    public static final String DUCK_SOUND = "Ga ga";

    public Duck() {
        animalName = DUCK_NAME;
        animalSound = DUCK_SOUND;
    }
}