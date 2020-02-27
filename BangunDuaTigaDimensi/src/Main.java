import java.util.Scanner;
import BangunDatar.*;

public class Main {
   public static void main (String[]args){
       System.out.println("Hitung Luas & keliling Persegi");
       Scanner a=new Scanner (System.in);
       char y;
       int menuBangun,menuBangunDatar,menuBangunRuang;
       do{
           System.out.println("MENU ");
           System.out.println("1.Bangun Datar");
           System.out.println("2.Bangun Ruang");
           System.out.println("Masukan Pilihan anda : ");
           menuBangun = a.nextInt();
           switch (menuBangun) {
               case 1 : 
                   do {
                       System.out.println("MENU BANGUN DATAR");
                       System.out.println("1.Persegi");
                       System.out.println("2.Persegi Panjang ");
                       System.out.println("3.Segitiga");
                       System.out.println("Masukan Pilihan anda :");
                       menuBangunDatar =a.nextInt();
                       switch(menuBangunDatar) {
                           case 1 :
                               
                                double sisi;
                                System.out.println("Sisi: ");
                                sisi=a.nextDouble();

                                Bangundatar persg = new Persegi(sisi);
                                System.out.println("Luas"+ persg.hasilLuas());
                                System.out.println("Keliling"+ persg.hasilKeliling());
                            break;
                           case 2:
                                System.out.println("Hitung Luas & keliling Persegi Panjang");
                                Scanner b=new Scanner (System.in);
                                double panjang;
                                double lebar;
                                System.out.println("Panjang: ");
                                panjang=b.nextDouble();
                                System.out.println("Lebar: ");
                                lebar= b.nextDouble();

                                Bangundatar persgp = new PersegiPanjang(panjang,lebar);
                                System.out.println("Luas"+ persgp.hasilLuas());
                                System.out.println("Keliling"+ persgp.hasilKeliling());
                            break;
                           case 3:
                                System.out.println("Hitung Luas & keliling Segitiga");
                                Scanner c=new Scanner (System.in);
                                double miring = 0;
                                double alas;
                                double tinggi = 0;
                                System.out.println("Alas:");
                                alas=c.nextDouble();
                                System.out.println("Tinggi:");
                                tinggi=c.nextDouble();
                                System.out.println("Miring:");
                                miring=c.nextDouble();

                                Bangundatar segitig = new Segitiga(alas,tinggi,miring);
                                System.out.println("Luas"+ segitig.hasilLuas());
                                System.out.println("Keliling"+ segitig.hasilKeliling());
                            break;
                              
                       }  
                   System.out.println("Kembali ke Menu ? (y/n) : ");
                   y = a.next().charAt(0);
                   }while(y=='y');
                   break;
               case 2 : 
                    do {
                       System.out.println("MENU BANGUN RUANG");
                       System.out.println("1.Balok");
                       System.out.println("2.Kubus ");
                       System.out.println("3.Prisma Segitiga");
                       System.out.println("4.Limas Persegi");
                       System.out.println("5.Limas Persegi Panjang");
                       System.out.println("6.Limas Segitiga");
                       System.out.println("Masukan Pilihan anda :");
                       menuBangunRuang =a.nextInt();
                       
                       
                   System.out.println("Kembali ke Menu ? (y/n) : ");
                   y = a.next().charAt(0);
                   }while(y=='y');
                   break;
               default :System.out.println("Menu Tidak Tersedia"); 
           }
           System.out.println("Kembali ke Menu ? (y/n) : ");
           y = a.next().charAt(0);
       } while(y=='y');
       
      
       
       
       
       
   }
    
}