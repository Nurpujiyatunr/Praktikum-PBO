public class KlausaThrows {
    public static void uji (int angka) {
        if (angka<0) {
            throw new NullPointerException ("KESALAHAN : " + "NULL Pointer Exception");
        } else {
            throw new ArithmeticException ("KESALAHAN : " + "Arithmetic Exception");
        }
    }
    public static void main (String[] args ) {
        System.out.println("\n****** MENGGUNAKAN KLAUSA " + "THROWS *******\n");
        try {
            uji(0);
        } catch (Exception exc) {
            System.err.println("Exception ditangkap di sini");
            System.err.println("\n\tPemberitahuan!!\n" + exc.getMessage());
        }
        System.out.println("\nPernytaan di luar blok trycatch.");
    }
    
}
