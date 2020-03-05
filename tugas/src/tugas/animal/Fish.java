package tugas.animal;

public class Fish extends Animal implements Pet{
    String name;
    public Fish(){
    super(0);
    }

    @Override
    void eat() {
        System.out.println("Makan Bakteri");
    }

  
    public String getname() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println("Tidak berjalan tapi berenang");
    }
    

}
