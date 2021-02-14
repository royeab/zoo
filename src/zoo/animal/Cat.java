package zoo.animal;

import zoo.Animal;

public class Cat extends Animal {
    public static final String CAT_NAME = "Cat";
    public static final String CAT_SOUND = "Miao";

    public Cat() {
        animalName = CAT_NAME;
        animalSound = CAT_SOUND;
    }
}