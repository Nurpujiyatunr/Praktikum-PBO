public class MultipleCatch {
    public static void main (String[] args) {
        System.out.println("\n ****** MENGGUNAKAN MULTIPLE " + "CATCH ******\n");
        
        try {
            // exc hanya sebuah variabel yang bisa diubah ubah
            int[] array= new int[9];
            array[9] = 13/1;
            System.out.println("Elemen aarray indeks ke " + "9 adalah" + array[9]);
            System.out.println("Pernytaan dalam blok" + "try setelah bebas dari exception");
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.err.println("Anda mengakses array di" + "luar indeks yang dideklarasikan");
        } catch (NegativeArraySizeException exc) {
            System.err.println("Anda mendeklarasikan array" + " dengan ukuran negatif.");
        } catch (Exception exc) {
            System.err.println("Anda melakukan pembagian" + "bilangan oleh nol");
        }
    }
    
}
