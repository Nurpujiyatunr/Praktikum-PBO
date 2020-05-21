/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nurpujiyatun
 */
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Controller {

    int totalBayar;
    Model model;
    ViewKereta viewkereta;
    ViewTiket viewtiket;

    public Controller (Model model, ViewTiket viewtiket, ViewKereta viewkereta) {
        this.model= model;
        this.viewtiket = viewtiket;
        this.viewkereta = viewkereta;
        
   
        if (model.getBanyakData() != 0) {
            String datapelanggan[][] = model.readpelanggan();
            viewtiket.tabel.setModel((new JTable(datapelanggan, viewtiket.namaKolom)).getModel());
            listenerTabelTiket();
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        if (model.getBanyakData() != 0) {
            String datapelanggan[][] = model.readpelanggan();
            viewkereta.tabel.setModel((new JTable(datapelanggan, viewkereta.namaKolom)).getModel());
            listenerTabel();
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewtiket.jbTambahTiket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = viewtiket.getnama();
                String jeniskelamin = viewtiket.getjeniskelamin();
                String stasiun = viewtiket.getstasiun();
                String kereta= viewtiket.getkereta();
                model.inserttiket(nama, jeniskelamin, stasiun, kereta);

                String datapelanggan[][] = model.readpelanggan();
                viewtiket.tabel.setModel(new JTable(datapelanggan, viewtiket.namaKolom).getModel());
                listenerTabelTiket();
            }
        });
        
        viewkereta.jbTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_kereta = viewkereta.getid();
                String nama = viewkereta.getnama();
                String kelas = viewkereta.getkelas();
                model.insertkereta(id_kereta, nama, kelas);

                String datapelanggan[][] = model.readpelanggan();
                viewkereta.tabel.setModel(new JTable(datapelanggan, viewkereta.namaKolom).getModel());
                listenerTabel();
            }
        });
        
        viewkereta.jbEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_kereta = viewkereta.getid();
                String nama_kereta = viewkereta.getnama();
                String kelas = viewkereta.getkelas();

                model.updatekereta(id_kereta, nama_kereta, kelas);
                
                String datapelanggan[][] = model.readpelanggan();
                viewkereta.tabel.setModel(new JTable(datapelanggan, viewkereta.namaKolom).getModel());
                listenerTabel();
            }
        });
        
        viewkereta.jbHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_kereta = viewkereta.getid();
                String nama_kereta = viewkereta.getnama();
                String kelas = viewkereta.getkelas();

                model.deletepelanggan(id_kereta);
                
                String datapelanggan[][] = model.readpelanggan();
                viewkereta.tabel.setModel(new JTable(datapelanggan, viewkereta.namaKolom).getModel());
                resetFormKereta();
                listenerTabel();
            }
        });
        
        viewtiket.jbBatalTiket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFormTiket();
                
                String datapelanggan[][] = model.readpelanggan();
                viewtiket.tabel.setModel(new JTable(datapelanggan, viewtiket.namaKolom).getModel());
                listenerTabelTiket();
            }
        });
        
         viewkereta.jbBatal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFormTiket();
                
                String datapelanggan[][] = model.readpelanggan();
                viewkereta.tabel.setModel(new JTable(datapelanggan, viewkereta.namaKolom).getModel());
                listenerTabel();
            }
        });
    }

    Controller(Model model, ViewKereta viewkereta, ViewTiket viewtiket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Controller(Model model, ViewKereta viewkereta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Controller(Model model, ViewTiket viewtiket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    /**
     *
     */

    public void listenerTabelTiket() {
        String data[][] = model.readpelanggan();
        String datapelanggan[][] = model.readpelanggan();
        viewtiket.tabel.setModel(new JTable(datapelanggan, viewtiket.namaKolom).getModel());
        viewtiket.tabel.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int row = viewtiket.tabel.getSelectedRow();
                int col = viewtiket.tabel.getSelectedColumn();

                viewtiket.lnama.setText(data[row][0].toString());
                viewtiket.lnama.setEnabled(false);
                viewtiket.ljeniskelamin.setText(data[row][1].toString());
                viewtiket.lstasiun.setText(data[row][2].toString());
                viewtiket.lkereta.setText(data[row][3].toString());
            }
        });
    }
    
    public void listenerTabel() {
        String data[][] = model.readpelanggan();
        String datapelanggan[][] = model.readpelanggan();
        viewkereta.tabel.setModel(new JTable(datapelanggan, viewkereta.namaKolom).getModel());
        viewkereta.tabel.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int row = viewkereta.tabel.getSelectedRow();
                int col = viewkereta.tabel.getSelectedColumn();

                viewkereta.lid.setText(data[row][0].toString());
                viewkereta.lnama.setEnabled(false);
                viewkereta.lkelas.setText(data[row][1].toString());
            }
        });
    }
    
    public void resetFormKereta(){
        viewkereta.lid.setText("");
        viewkereta.lid.setEnabled(true);
        viewkereta.lnama.setText(""); 
        viewkereta.lkelas.setText("");   
        
    }
    
    public void resetFormTiket(){
        viewtiket.lnama.setText("");
        viewtiket.lnama.setEnabled(true);
        viewtiket.cmbJeniskelamin.setSelectedItem("---Pilih---"); 
        viewtiket.cmbStasiun.setSelectedItem("---Pilih---");
        viewtiket.cmbKereta.setSelectedItem("---Pilih");
        
    }



    
}

