package BangunDatar;
public class Persegi extends Bangundatar{
    public Persegi(double sisi){
        super.sisi=sisi;
        luas();
        keliling();
        
    }

    public double luas(){
      super.luas=sisi*sisi; //super pengganti this, kalau this untuk claas persegi, kalau super milik kelas parent
       //System.out.println("persegiLuas"+ super.luas);
       return super.luas;
   }
   
   public double keliling(){
       super.keliling=4*sisi;
      // System.out.println("persegiKeliling"+ super.keliling);
       return super.keliling;
   }
   
   
   
    
    
}

