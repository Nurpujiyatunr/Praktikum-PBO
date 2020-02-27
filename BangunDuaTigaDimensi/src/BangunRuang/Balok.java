package BangunRuang;
import BangunDatar.PersegiPanjang;
public class Balok extends PersegiPanjang {

    double tinggi;
    private double volume ;

    public Balok(double panjang, double lebar) {
        super(panjang, lebar);
    }

    double  luasPersegiPanjang (){
        double luas = 0;
        return luas ;
    }

    double Volume (double Tinggi3d){
        this.tinggi = Tinggi3d;
        volume =   luasPersegiPanjang() * tinggi ;
        return volume ;
    }

}