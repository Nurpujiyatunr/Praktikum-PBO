package BangunDatar;
public abstract class Bangundatar {
    
    public double sisi,panjang,lebar,luas,keliling,alas,tinggi,miring;
    public double r;
    public final double phi=3.14;
    
    public abstract double luas();
    public abstract double keliling();
    
 
    public double hasilLuas(){
        //System.out.println("Bangundatar"+luas);
        return this.luas;
    }
    
    public double hasilKeliling(){
        //System.out.println("Bangundatar"+keliling);
        return this.keliling;
    }
}
