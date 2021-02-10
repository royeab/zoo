package zoo;

public class Duck implements Animal {
    @Override
    public void printName(){
        System.out.println("Duck");
    }

    @Override
    public void printSound(){
        System.out.println("Ga ga");
    }
}