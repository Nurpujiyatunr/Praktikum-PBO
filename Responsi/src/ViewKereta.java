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


public class ViewKereta extends JFrame{
    
    JPanel panell = new JPanel();
    final JTextField fid = new JTextField(100);
    JLabel lid = new JLabel ("ID Kereta : ");
    
    final JTextField fnama = new JTextField(100);
    JLabel lnama = new JLabel ("Nama Kereta :");
    
    final JTextField fkelas = new JTextField(100);
    JLabel lkelas = new JLabel ("Kelas :");

   
    JButton jbTambah = new JButton ("Tambah");
    JButton jbEdit = new JButton ("Edit");
    JButton jbHapus = new JButton ("Hapus");
    JButton jbBatal = new JButton ("Batal");
    
    
    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Id Kereta", "Nama Kereta", "Kelas"};

    public ViewKereta() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Daftar Kereta ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(655,650);
        
        add(scrollPane);
        scrollPane.setBounds(30, 235, 580, 300);
        
        add(lid);
        lid.setBounds(35, 60, 90, 20);
        add(fid);
        fid.setBounds(140, 60, 170, 20);
        
        add(lnama);
        lnama.setBounds(35, 90, 90, 20);
        add(fnama);
        fnama.setBounds(140, 90, 170, 20);
        
        add(lkelas);
        lkelas.setBounds(35, 120, 90, 20);
        add(fkelas);
        fkelas.setBounds(150, 120, 250, 20);
        
        add(jbTambah);
        jbTambah.setBounds(30, 550, 90, 25);
        
        add(jbEdit);
        jbEdit.setBounds(130, 550, 90, 25);
        
        add(jbHapus);
        jbHapus.setBounds(230, 550, 90, 25);
        
        add(jbBatal);
        jbBatal.setBounds(330,550,90,25);
    }
    

    public String getid() {
        return lid.getText();
    }

    public String getnama() {
        return lnama.getText();
    }

    public String getkelas() {
        return lkelas.getText();
    }


}


    



