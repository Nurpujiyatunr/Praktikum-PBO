package BangunRuang;

import BangunDatar.Segitiga;

public class PrismaSegitiga extends Segitiga {

    double tinggiPrisma;
    private  double volume ;

    public PrismaSegitiga(double miring,double alas,double tinggi) {
        super(alas,tinggi,miring);
    }

    double  luasSegitiga (){
        return luas ;  
    }

    double Volume (double Tinggi3d){
        this.tinggiPrisma = Tinggi3d;
        volume =   luasSegitiga() * tinggiPrisma ;
        return volume ;
    }

}