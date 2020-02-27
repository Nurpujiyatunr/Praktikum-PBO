package BangunDatar;
public class Segitiga extends Bangundatar {
    public Segitiga(double miring,double alas,double tinggi) {
        super.miring=miring;
        super.alas=alas;
        super.tinggi=tinggi;
        luas();
        keliling();
        
      
    }
    public double luas() {
        luas=(alas*tinggi)/2;
        return super.luas;
    }
    public double keliling() {
        super.keliling=alas+tinggi+miring;
        return super.keliling;
    }
    
    
}
