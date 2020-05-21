/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nurpujiyatun
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Model {

    //mengkoneksikan ke database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsipbo";//nama database kita di slash terakhir
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;//untuk perintah query
    int totalBayar;

    public Model() {
        
        try {
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

     public void inserttiket(String nama, String jenis_kelamin, String stasiun, String kereta) {
        try {
            if ("".equals(nama) || "".equals(jenis_kelamin) || "".equals(stasiun)|| "".equals(kereta)) {
                System.out.println("Gagal ditambahkan");
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else {
                String query = "INSERT INTO `tiket`(`nama`, `jeniskelamin`, `stasiun`,`kereta`) VALUES ('" + nama + "','" + jenis_kelamin + "','" + stasiun + "','" + kereta + "')";//value 1 (id diskip)
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
    
    public void insertkereta(int id_kereta , String nama_kereta, String kelas) {
        try {
            if ("".equals(id_kereta) || "".equals(nama_kereta) || "".equals(kelas)) {
                System.out.println("Gagal ditambahkan");
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else {
                String query = "INSERT INTO `kereta`(`id_kereta`, `nama_kereta`, `kelas`) VALUES ('" + id_kereta + "','" + nama_kereta + "','" + kelas +"')";//value 1 (id diskip)
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
    
    
    public void updatekereta(int id_kereta, String nama_kereta, String kelas) {
        try {
            if ("".equals(id_kereta) || "".equals(nama_kereta) || "".equals(kelas)) {
                System.out.println("Gagal ditambahkan");
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else {//`kode`, `nama`, `alamat`,`jk`,`kategori
                String query = "UPDATE `kereta` SET id_kereta='" + id_kereta + "',nama_kereta='" + nama_kereta + "',kelas='" + kelas + "' WHERE id_kereta='" + id_kereta + "'";
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
            String query = "Select * from `tiket`"; //pengambilan dara dalam java dari database
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

    public void deletekereta(int id_kereta) {
        try {
            if ("".equals(id_kereta)) {
                JOptionPane.showMessageDialog(null, "Gagal Dihapus\nPastikan Isi kode yang ingin dihapus benar !");
            } else {
                String query = "DELETE FROM `kereta` WHERE `id_kereta` ='" + id_kereta + "'";
                statement = koneksi.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            }
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    void deletepelanggan(String id_kereta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void updatekereta(String id_kereta, String nama_kereta, String kelas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void insertkereta(String id_kereta, String nama, String kelas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

