package tugas1;

import tugas.sound.*;
import tugas.fly.*;
import tugas.attack.*;
import tugas.defend.*;

public class Main {
       public static void main(String[] args) {
        
      
        Duck superbebek=new Duck(new RocketFly(), new ToaSound(), new ArrowAttack(), new ShiledDefend());
        System.out.println("super duck behaviour : ");
        superbebek.getFly();
        superbebek.getSound();
        superbebek.gettAttack();
        superbebek.getDefend();
        
        Duck noob=new Duck(new WingsFly(), new NormalSound(), new SwordAttack(), new ArmorDefend());
        System.out.println("\nnoob duck behaviour : ");
        noob.getFly();
        noob.getSound();
        noob.gettAttack();
        noob.getDefend();
        
        Duck change=new Duck(new PlaneFly(), new ToaSound(), new ArrowAttack(), new ShiledDefend());
        System.out.println("\nSuper Change duck behaviour : ");
        change.getFly();
        change.getSound();
        change.gettAttack();
        change.getDefend();
    }
    
}
