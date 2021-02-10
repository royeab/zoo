package zoo;

public class Dog implements Animal {
    @Override
    public void printName(){
        System.out.println("Dog");
    }

    @Override
    public void printSound(){
        System.out.println("How");
    }
}