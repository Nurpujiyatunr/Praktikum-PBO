import java.util.Scanner;
public class Tugas1 {
    public static void main(String[] args) {
        Scanner scanInput = new Scanner(System.in);
        
        String nama;
        int jmlNilai;
        int Nilai[] = new int[100], max= 0, min =0;
        float total=0;
        
        System.out.print("Nama :");
        nama = scanInput.nextLine();
        System.out.print("Berapa Nilai yang akan diinputkan ? : ");
        jmlNilai = scanInput.nextInt();
        
        for (int p=0; p <jmlNilai; p++) {
            System.out.print("Nilai ke- " + (p+1)+ " : ");
            Nilai[p] = scanInput.nextInt();
            if (p==0) {
                max=Nilai[p];
                min=Nilai[p];
            } else if (min>Nilai[p]) {
                min=Nilai[p];
            } else if (max<Nilai[p]){
                max=Nilai[p]; }
            
            
          total= total+ Nilai[p];
         }
         
        System.out.println("\nNama : " + nama);
        System.out.println("Nilai Tertinggi : " + max);
        System.out.println("Nilai Terendah : " + min);
        System.out.println("Rata-rata Nilai : " + total/jmlNilai);
        
        
        }
        
   
        
        
        
        
        
        
        
        
        
    }
    
}
