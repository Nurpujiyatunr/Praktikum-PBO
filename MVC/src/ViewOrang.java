import javax.swing.*;
import java.awt.event.*;

public class ViewOrang extends JFrame implements ActionListener, ListenerOrang {

    final JTextField fnamadepan = new JTextField(10);
    final JTextField fnamatengah = new JTextField(10);
    final JTextField fnamabelakang = new JTextField(10);
    JLabel lnamadepan = new JLabel("Nama Depan");
    JLabel lnamatengah = new JLabel("Nama Tengah");
    JLabel lnamabelakang = new JLabel("Nama Belakang");
    JButton btnSave = new JButton("Save");
    JButton btnReset = new JButton("Reset");
    ControllerOrang controllerOrang;
    ModelOrang modelOrang;

    public ViewOrang() {
        setTitle("Coba MVC");
        setDefaultCloseOperation(3);
        setSize(350, 190);


        setLayout(null);
        add(lnamadepan);
        add(fnamadepan);
        add(lnamatengah);
        add(fnamatengah);
        add(lnamabelakang);
        add(fnamabelakang);
        add(btnSave);
        add(btnReset);

        lnamadepan.setBounds(10, 10, 120, 20);
        fnamadepan.setBounds(130, 10, 170, 20);
        lnamatengah.setBounds(10, 35, 120, 20);
        fnamatengah.setBounds(130, 35, 170, 20);
        lnamabelakang.setBounds(10, 60, 120, 20);
        fnamabelakang.setBounds(130, 60, 170, 20);
        btnReset.setBounds(130, 100, 80, 20);
        btnSave.setBounds(220, 100, 80, 20);

        btnSave.addActionListener(this);
        btnReset.addActionListener(this);

        setVisible(true);

        controllerOrang = new ControllerOrang();
        modelOrang = new ModelOrang();
        modelOrang.setOrangListener(this);
        controllerOrang.setMo(modelOrang);
    }

    public JTextField getFnamabelakang() {
        return fnamabelakang;
    }

    public JTextField getFnamadepan() {
        return fnamadepan;
    }

    public JTextField getFnamatengah() {
        return fnamatengah;
    }

    public static void main(String[] args) {
        new ViewOrang();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            controllerOrang.submitForm(this);
        }
        if (e.getSource() == btnReset) {
            controllerOrang.resetForm(this);
        }
    }

    public void onChange(ModelOrang modelOrang) {
        fnamadepan.setText(modelOrang.getNamaDepan());
        fnamatengah.setText(modelOrang.getNamaTengah());
        fnamabelakang.setText(modelOrang.getNamaBelakang());
    }
}