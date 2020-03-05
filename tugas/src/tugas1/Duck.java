package tugas1;

//import tugas.tugas.fly.FlyBehaviour;

import tugas.attack.AttackBehaviour;
import tugas.defend.DefendBehaviour;
import tugas.fly.FlyBehaviour;
import tugas.sound.SoundBehaviour;

//import tugas.tugas.sound.SoundBehaviour;
//import tugas.tugas.attack.AttackBehaviour;
//import tugas.tugas.defend.DefendBehaviour;

public class Duck {
    private FlyBehaviour flyBehaviour;
    private SoundBehaviour soundBehaviour;
    private AttackBehaviour attackBehaviour;
    private DefendBehaviour defendBehaviour;
    
     public Duck( FlyBehaviour terbang, SoundBehaviour suara, AttackBehaviour serang, DefendBehaviour bertahan)
    {
        this.flyBehaviour=terbang;
        this.soundBehaviour=suara;
        this.attackBehaviour=serang;
        this.defendBehaviour=bertahan;
    }
  
     public void gettAttack()
    {
        attackBehaviour.attack();
    }
    public void getSound()
    {
        soundBehaviour.sound();
    }
    public void getFly()
    {
        flyBehaviour.fly();
    }
    public void getDefend()
    {
        defendBehaviour.defend();
    }
         
}
    
