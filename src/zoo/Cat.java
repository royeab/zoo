package zoo;

public class Cat implements Animal {
    @Override
    public void printName(){
        System.out.println("Cat");
    }

    @Override
    public void printSound(){
        System.out.println("Miao");
    }
}