package zoo;

public abstract class Animal {
    protected String animalName;
    protected String animalSound;

    public void printName() {
        System.out.println(animalName);
    }

    public void printSound() {
        System.out.println(animalSound);
    }
}