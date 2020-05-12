import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nurpujiyatun
 */
public class Main {
    public static void main (String[]args){
        Scanner input = new Scanner(System.in);
        int jumlah;
        String nama,nim;
        int tesTulis,tesCoding,tesWawancara,tesMicroteaching,tesJaringan;
        String kembali;
        
        
        do {
            try{
                System.out.println("MENU FORM PENDAFTARAN");
                System.out.println("1. Asisten Laboratorium");
                System.out.println("2. Admin Laboratorium");
                System.out.print("Masukan Pilihan :");
                int pilih = input.nextInt();
                
                switch(pilih) {
                    case 1 :
                        System.out.println("\n--------Form Pendaftaran Asisten Laboratorium--------");
                        System.out.println("Berapa banyak data yang akan diinputkan?");
                        jumlah = input.nextInt();
                        for (int p=0; p<jumlah; p++){
                            input.nextLine();
                            System.out.print("Input Nim :");
                            nim = input.nextLine();
                            System.out.print("Input Nama :");
                            nama = input.nextLine();
                            System.out.print("Input Nilai Tes Tulis :");
                            tesTulis = input.nextInt();
                            System.out.print("Input Nilai Tes Coding :");
                            tesCoding = input.nextInt();
                            System.out.print("Input Nilai Tes Wawancara : ");
                            tesWawancara = input.nextInt();
                            System.out.print("Input Nilai Tes Microteaching :");
                            tesMicroteaching = input.nextInt();
                            AsistenLab aslab = new AsistenLab (nama,nim,tesTulis,tesCoding,tesWawancara,tesMicroteaching);
                            aslab.lihatAkhir();
                            System.out.println();
                        }
                        break;
                    case 2 :
                        System.out.println("--------\nForm Pendaftaran Admin Laboratorium----------");
                        System.out.println("Berapa banyak data yang akan diinputkan? :");
                        jumlah = input.nextInt();
                        for (int p=0; p<jumlah; p++){
                            input.nextLine();
                            System.out.print("Input Nim :");
                            nim = input.nextLine();
                            System.out.print("Input Nama :");
                            nama = input.nextLine();
                            System.out.print("Input Nilai Tes Tulis :");
                            tesTulis = input.nextInt();
                            System.out.print("Input Nilai TesCoding :");
                            tesCoding = input.nextInt();
                            System.out.print("Input Nilai Tes Wawancara : ");
                            tesWawancara = input.nextInt();
                            System.out.print("Input Nilai Tes Jaringan :");
                            tesJaringan = input.nextInt();
                            AsistenLab admin= new AsistenLab (nama,nim,tesTulis,tesCoding,tesWawancara,tesJaringan);
                            admin.lihatAkhir();
                            System.out.println();
                        }
                        break;
                }
        } catch (Exception e2){
                System.err.println("Ulangi!!");
        } finally {
                input.nextLine();
                System.out.print("\nKembali ke menu ? (y/n) : ");
                kembali= input.nextLine();
                System.out.println("");
            }
            
    } while (kembali.equals("y"));
    }
}