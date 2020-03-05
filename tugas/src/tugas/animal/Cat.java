package tugas.animal;

public class Cat extends Animal implements Pet{

    String name;
    
    public Cat() {
        this("");
    }
    
    public Cat(String name) {
        super(4);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
    public void play(){
        System.out.println("Kucing Sedang Bermain");}

    @Override
    void eat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getname() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
