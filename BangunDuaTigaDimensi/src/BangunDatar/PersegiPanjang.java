package BangunDatar;
public class PersegiPanjang extends Bangundatar {
    public PersegiPanjang(double panjang, double lebar) {
        super.panjang=panjang;
        super.lebar=lebar;
        luas();
        keliling();
        
    }
    public double luas() {
        super.luas=panjang*lebar;
        return super.luas;
    }
    public double keliling(){
        super.keliling=2*(panjang*lebar);
        return super.keliling;
    }
    
}
