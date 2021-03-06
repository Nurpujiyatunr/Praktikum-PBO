
package aplikasiLaundry;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModelLaundry {

    //mengkoneksikan ke database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/laundryjinni(1)";//nama database kita di slash terakhir
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;//untuk perintah query
    int totalBayar;

    public ModelLaundry() {
        
        try {
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public void insertpelanggan(String kode, String nama, String alamat, String jk, String kategori,String berat) {
        try {
            if ("".equals(kode) || "".equals(nama) || "".equals(alamat)|| "".equals(kategori)|| "".equals(berat) ) {
                System.out.println("Gagal ditambahkan");
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else {
                int hargaKategori = 0;
              
                if (kategori.equalsIgnoreCase("Cuci")){
                    hargaKategori = 4000;
                } else if(kategori.equalsIgnoreCase("Cuci Setrika")) {
                    hargaKategori = 6000;
                } else if(kategori.equalsIgnoreCase("Express 1 jam")){
                    hargaKategori = 24000;
                } else if(kategori.equalsIgnoreCase("Express 1 hari")){
                    hargaKategori = 12000;
                }
                
                totalBayar = hargaKategori*Integer.parseInt(berat);
                System.out.println(totalBayar);
                String query = "INSERT INTO `pelanggan`(`kode`, `nama`, `alamat`,`jk`,`kategori`,`berat`, bayar) VALUES ('" + kode + "','" + nama + "','" + alamat + "','" + jk + "','" + kategori + "', '" + berat + "',"+ totalBayar + ")";//value 1 (id diskip)
                //String '"+String+"' kalau Int "+int+"
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambah");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    
    public void updatepelanggan(String kode, String nama, String alamat, String jk, String kategori,String berat) {
        try {
            if ("".equals(kode) || "".equals(nama) || "".equals(alamat) || "".equals(kategori)|| "".equals(berat)) {
                System.out.println("Gagal ditambahkan");
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else {//`kode`, `nama`, `alamat`,`jk`,`kategori
                int hargaKategori = 0;

                if (kategori.equalsIgnoreCase("Cuci")){
                    hargaKategori = 4000;
                } else if(kategori.equalsIgnoreCase("Cuci Setrika")) {
                    hargaKategori = 6000;
                } else if(kategori.equalsIgnoreCase("Express 1 jam")){
                    hargaKategori = 24000;
                } else if(kategori.equalsIgnoreCase("Express 1 hari")){
                    hargaKategori = 12000;
                }

                totalBayar = hargaKategori*Integer.parseInt(berat);
                System.out.println(totalBayar);
                String query = "UPDATE `pelanggan` SET nama='" + nama + "',alamat='" + alamat + "',jk='" + jk + "',kategori='" + kategori
                        + "', berat = '" + berat + "', bayar = " + totalBayar + " WHERE kode='" + kode + "'";
                //String '"+String+"' kalau Int "+int+"
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil Diedit");
                JOptionPane.showMessageDialog(null, "Data Berhasil Diedit");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readpelanggan() {
        try {
            int jmlData = 0;//menampung jumlah data

            String data[][] = new String[getBanyakData()][7]; //baris, kolom nya ada 3

            String query = "Select * from `pelanggan`"; //pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) { //lanjut kedata selanjutnya jmlData bertambah
                data[jmlData][0] = resultSet.getString("kode"); //kolom nama harus sama besar kecilnya dgn database
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("jk");
                data[jmlData][3] = resultSet.getString("alamat");
                data[jmlData][4] = resultSet.getString("kategori");
                data[jmlData][5] = resultSet.getString("berat");
                data[jmlData][6] = String.valueOf(resultSet.getInt("bayar"));
                jmlData++; //barisnya berpindah terus
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getBanyakData() {//menghitung jumlah baris
        int jmlData = 0;
        try {
            statement = koneksi.createStatement();
            String query = "Select * from `pelanggan`"; //pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) { //lanjut kedata selanjutnya jmlData bertambah
                jmlData++;
            }
            return jmlData;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deletepelanggan(String kode) {
        try {
            if ("".equals(kode)) {
                JOptionPane.showMessageDialog(null, "Gagal Dihapus\nPastikan Isi kode yang ingin dihapus benar !");
            } else {
                String query = "DELETE FROM `pelanggan` WHERE `kode` ='" + kode + "'";
                statement = koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            }
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int HitungTotalbayar(String kategori, String berat){
       
         int hargaKategori = 0;
              
                if (kategori.equalsIgnoreCase("Cuci")){
                    hargaKategori = 4000;
                } else if(kategori.equalsIgnoreCase("Cuci Setrika")) {
                    hargaKategori = 6000;
                } else if(kategori.equalsIgnoreCase("Express 1 jam")){
                    hargaKategori = 24000;
                } else if(kategori.equalsIgnoreCase("Express 1 hari")){
                    hargaKategori = 12000;
                }
                return totalBayar = hargaKategori*Integer.parseInt(berat);

    }

    String[][] totalbayar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}

