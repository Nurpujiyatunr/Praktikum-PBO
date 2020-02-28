package abstractInterface;

public class Main {
    public static void main (String[]args) {
        Fish f = new Fish();
        Cat c = new Cat("Fluffy");
        Animal a = new Fish (); //Polymorphisem
        Animal e = new Spider (); //Polymorphisem
        Pet p = new Cat();
        //
        f.play();
        c.play();
        //
        e.eat();
        e.walk();
        //
        a.walk();
    }
    
}
