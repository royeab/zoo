package zoo;

public class AnimalFactory {
    public Animal generateAnimal(String name) {
        switch(name) {
            case "Dog":
                return new Dog();

            case "Cat":
                return new Cat();

            case "Duck":
                return new Duck();

            default:
                return null;
        }
    }
}