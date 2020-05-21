/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kereta;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Nurpujiyatun
 */
public class Model {
    
static final String jdbcDriver = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/responsipbo";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;
    
    public Model() {
        try {
            Class.forName(jdbcDriver);
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String getIDKeretaFromNama(String nama_kereta){
        String data = null;
        try {
            String query = "SELECT * FROM kereta where nama_kereta = '"+nama_kereta+"'";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                data = resultSet.getString("id_kereta");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public int getBanyakDataKereta(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM kereta";
            ResultSet setResult = statement.executeQuery(query);
            while(setResult.next()){
                jmlData++;
            }
            return jmlData;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
//      Kereta
    public String[][] readKereta(){
        String[][] data = new String[getBanyakDataKereta()][3];
        try {
            String query = "SELECT * FROM kereta";
            resultSet = statement.executeQuery(query);
            int p=0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("id_kereta");
                data[p][1] = resultSet.getString("nama_kereta");
                data[p][2] = resultSet.getString("kelas");
                p++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!");
        }
        return data;
    }
    
    public void insertKereta(String id_kereta, String nama_kereta, String kelas){
        try {
            System.out.println(id_kereta+nama_kereta+kelas);
            String query = "INSERT INTO kereta VALUES ('"+id_kereta+"','"+nama_kereta+"','"+kelas+"')";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Ditambahkan");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan!");
        }
    }

    
    public String[] readKeretaBox(){
        String[] data = new String[getBanyakDataKereta()];
        int i=0;
        try{
            String query = "SELECT namaKereta FROM kereta";
            ResultSet setResult = statement.executeQuery(query);
            while(setResult.next()){
                data[i] = setResult.getString("nama_kereta");
                i++;
            }
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!");
        }
        return data;
    }
    
    public void editKereta(String id_kereta, String nama_kereta, String kelas){
        try {
            String query = "UPDATE kereta SET nama_kereta ='"+nama_kereta+"', kelas = '"+kelas+"' where id_kereta = '"+id_kereta+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dirubah");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Diedit!");
        }
    }
    
    public void deleteKereta(String id_kereta){
        try {
            String query = "DELETE FROM kereta where id_kereta = '"+id_kereta+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!");
        }
    }
    
//      Tiket

    public int getBanyakDataTiket(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM tiket";
            ResultSet setResult = statement.executeQuery(query);
            while(setResult.next()){
                jmlData++;
            }
            return jmlData;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public String[][] readTiket(){
        String[][] data = new String[getBanyakDataTiket()][4];
        try {
            String query = "SELECT * FROM tiket JOIN kereta ON tiket.id_kereta = kereta.id_kereta";
            resultSet = statement.executeQuery(query);
            int p=0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("tiket.nama");
                data[p][1] = resultSet.getString("tiket.jenis_kelamin");
                data[p][2] = resultSet.getString("tiket.stasiun");
                data[p][3] = resultSet.getString("kereta.kereta");
                p++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!");
        }
        return data;
    }
    
    public void insertTiket(String nama, String jenis_kelamin, String stasiun, String kereta){
        try {
            System.out.println(nama+jenis_kelamin+stasiun+kereta);
            String idKereta = getIDKeretaFromNama(nama);
            System.out.println(kereta);
            String query = "INSERT INTO tiket VALUES ('"+nama+"','"+jenis_kelamin+"','"+stasiun+"','"+kereta+"')";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Ditambahkan");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan!");
        }
    }
}
