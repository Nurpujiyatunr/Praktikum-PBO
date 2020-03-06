package latihanexception;
public class withoutExceptionHandling {
    public static void main(String[] args) {
        System.out.println("\n********PROGRAM" + "TANPA EXCEPTION HANDLING" + "****\n");
        
    try {
        int hasil= 9/1;
        System.out.println("Hasil pembagian = " + hasil);
        System.out.println("Pernyataan dalam blok" + "try setelah bebas dari exception");
    } 
    catch (ArithmeticException exc) {
        System.out.println("");
        System.err.println("ArithmeticException " + "menangkap exception hasil pembagian" + "oleh nol");
        System.out.println("");
        System.err.println("\n Exception yang di tangkap" + "adalah " + exc);
        System.out.println("");
    }
    finally {
        System.out.println("");
        System.out.println("Pernyataan dalam blok finally");
    }
    System.out.println("\n pernytaan di luar blok " + "trycatch");
   
    }
}

