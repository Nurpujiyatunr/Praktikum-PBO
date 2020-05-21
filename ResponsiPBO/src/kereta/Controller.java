/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kereta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Nurpujiyatun
 */
public class Controller {
   
    Model mode;
    View view;
    private Model model;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        readDataKereta();
        readTiketKereta();
        
        view.namaKereta = model.readKeretaBox();
        view.btnKembali.addActionListener(ae -> {
            view.getContentPane().removeAll();
            view.refresh();
            new MVC();
        });
        
        view.btnDaftarKereta.addActionListener(ae -> {
            view.getContentPane().removeAll();
            view.refresh();
            showRequest(view.daftarKereta());
        });
        view.btnDaftarTiket.addActionListener(ae -> {
            view.namaKereta = model.readKeretaBox();
            view.getContentPane().removeAll();
            view.refresh();
            showRequest(view.daftarTiket());
        });
        
//        Kereta

        view.tabelKereta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                String[][] data = model.readKereta();
                int row = view.tabelKereta.getSelectedRow();
                view.textIdKereta.setEditable(false);
                view.baris = row;
                view.textIdKereta.setText(data[row][0]);
                view.textNamaKereta.setText(data[row][1]);
                view.textKelasKereta.setText(data[row][2]);
            }
        });

        view.btnTambahKereta.addActionListener(ae -> {
            String idKereta = view.getIdKereta();
            String namaKereta = view.getNamaKereta();
            String kelasKereta = view.getKelasKereta();
            model.insertKereta(idKereta,namaKereta,kelasKereta);
            readDataKereta();
        });
        
        view.btnEditKereta.addActionListener(ae -> {
            System.out.println("Baris = "+ view.getBaris());
            if(view.getBaris()<0){
                JOptionPane.showMessageDialog(null, "Pilih Data yang Ingin Diedit!");
            }
            else{
                String idKereta = view.getIdKereta();
                String namaKereta = view.getNamaKereta();
                String kelasKereta = view.getKelasKereta();
                model.editKereta(idKereta,namaKereta,kelasKereta);
                readDataKereta();
            }
        });
        
        view.btnHapusKereta.addActionListener(ae -> {
            System.out.println("Baris = "+ view.getBaris());
            if(view.getBaris()<0){
                JOptionPane.showMessageDialog(null, "Pilih Data yang Akan Dihapus!");
            }
            else{
                String data = view.getIdKereta();
                model.deleteKereta(data);
                readDataKereta();
            }
        });
        
        view.btnBatalKereta.addActionListener(ae -> clearTextFieldKereta());
        
//        Tiket

        view.btnTambahTiket.addActionListener(ae -> {
            String nama = view.getNama();
            String jenisKelamin = view.getKelamin();
            String stasiunTujuan = view.getStasiun();
            String namaKereta = view.getKereta();
            model.insertTiket(nama, jenisKelamin, stasiunTujuan, namaKereta);
            readTiketKereta();
        });

        view.btnBatalTiket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearTextFieldTiket();
            }
        });
    }

//      Kereta
    
    public void readDataKereta(){
        try {
            String[][] data = new String[model.getBanyakDataKereta()][3];
            data = model.readKereta();
            view.tabelKereta.setModel((new JTable(data, view.kolomKereta)).getModel());
        } catch (IllegalArgumentException i) {
            System.err.println(i); 
        }
    }

//      Tiket
    
    public void readTiketKereta(){
        try {
            String[][] data = new String[model.getBanyakDataTiket()][4];
            data = model.readTiket();
            view.tabelTiket.setModel((new JTable(data, view.kolomTiket)).getModel());
        } catch (IllegalArgumentException i) {
            System.err.println(i); 
        }
    }
    
    public void showRequest (JFrame frame) {
        frame.setVisible(true);
    }
    
    public void clearTextFieldTiket(){
        view.textNama.setText("");
    }
    
    public void clearTextFieldKereta(){
        view.baris = -1;
        view.textIdKereta.setEditable(true);
        view.textIdKereta.setText("");
        view.textNamaKereta.setText("");
        view.textKelasKereta.setText("");
    }
}
