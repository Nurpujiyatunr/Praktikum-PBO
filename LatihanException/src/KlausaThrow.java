public class KlausaThrow {
    public static void main (String[] args) {
        String input="Throw RuntimeException";
        System.out.println("\n*********MENGGUNAKAN KLAUSA THROW****");
        try {
            if (input.equals ("Throw RuntimeException")) {
                throw new RuntimeException ("Melempar Exception ");
            } else if (input==null) {
                throw new NullPointerException();
            } else {
                System.out.println("Input adalah : " + input);
            }
            System.out.println("\nPernytaan dalam blok try setelah" + "bebas dari pelemparan exception.");
        } catch (Exception exc) {
            System.err.println("Exception ditangkap disini.");
            System.err.println("\nException yang ditangkap adalah " + ""+ exc);
        }
    }
}
