package tugas.animal;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Fish f = new Fish();
        Cat c = new Cat("Fluffy");
        Animal a = new Fish();
        Animal e = new Cat();
        Pet p = new Cat();
        f.play();
        c.play();
           e.eat();
           e.walk();
           a.walk();
    }
}
