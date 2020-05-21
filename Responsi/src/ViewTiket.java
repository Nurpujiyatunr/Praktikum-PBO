/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nurpujiyatun
 */
import java.awt.Color;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ViewTiket extends JFrame{
    
    JPanel panell = new JPanel();
    final JTextField fnama = new JTextField(100);
    JLabel lnama = new JLabel ("Nama : ");
    final JTextField fpanggil = new JTextField(100);

    JLabel ljeniskelamin = new JLabel ("Jenis Kelamin");
    String[] jeniskelamin = 
                 {"--Pilih--", "Pria", "Wanita"};
    JComboBox cmbJeniskelamin = new JComboBox(jeniskelamin);

    JLabel lstasiun = new JLabel ("Stasiun Tujuan");
    String[] stasiun = 
                 {"--Pilih--","Tugu Jog","Lempuyanga","Maguwo"};
    JComboBox cmbStasiun = new JComboBox (stasiun);

    JLabel lkereta = new JLabel ("Kereta");
    String[] kereta = 
                  {"--Pilih--","Ketandan","Hauha","Prameks","Pratameks","Surya Kencana"};
    JComboBox cmbKereta = new JComboBox (kereta);
    
    
    JButton jbTambahTiket = new JButton ("Tambah");
    JButton jbBatalTiket = new JButton ("Batal");
    
    JButton btnTambahTiket = new JButton("Tambah");
    JButton btnBatalTiket = new JButton("Batal");
    
    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Nama", "Jenis Kelamin", "Stasiun Tujuan", "Kereta"};
    Object lPria;

    public ViewTiket() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Daftar Tiket ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(655,650);
        
        add(scrollPane);
        scrollPane.setBounds(30, 235, 580, 300);
        
       
        add(lnama);
        lnama.setBounds(35, 60, 90, 20);
        add(fnama);
        fnama.setBounds(140, 60, 170, 20);
        
        add(ljeniskelamin);
        ljeniskelamin.setBounds(35, 90, 90, 20);
        add(cmbJeniskelamin);
        cmbJeniskelamin.setBounds(140,90, 170, 20)
                ;
        add(lstasiun);
        lstasiun.setBounds(35,120, 90, 20);
        add(cmbStasiun);
        cmbStasiun.setBounds(140, 120, 170, 20);
        
        add(lkereta);
        lkereta.setBounds(35, 160, 90, 20);
        add(cmbKereta);
        cmbKereta.setBounds(140, 180, 170,20 );
        
        add(jbTambahTiket);
        jbTambahTiket.setBounds(30, 550, 90, 25);
        
        add(jbBatalTiket);
        jbBatalTiket.setBounds(130,550,90,25);
    }
    
      public String getnama() {
        return lnama.getText();
    }

    public String getjeniskelamin() {
        if (cmbJeniskelamin.getSelectedItem().equals("--Pilih--")) {
            return "";
        } else {
            return (String) cmbJeniskelamin.getSelectedItem();
        }
    }
    
    public String getstasiun() {
        if (cmbStasiun.getSelectedItem().equals("--Pilih--")) {
            return "";
        } else {
            return (String) cmbStasiun.getSelectedItem();
        }
    }
    
    public String getkereta() {
        if (cmbKereta.getSelectedItem().equals("--Pilih--")) {
            return "";
        } else {
            return (String) cmbKereta.getSelectedItem();
        }
    }
    
    
}

