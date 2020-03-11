import javax.swing.*;

public class Swing extends JFrame {
    JPanel panell = new JPanel();
    final JTextField fnama = new JTextField(100);
    JLabel lnama = new JLabel ("Nama Lengkap");
    final JTextField fpanggil = new JTextField(100);
    JLabel lpanggil = new JLabel ("Nama Panggilan");
    final JTextField fnim = new JTextField(15);
    JLabel lnim = new JLabel("Nim ");
    JLabel ljekel = new  JLabel ("Jenis Kelamin");
    JRadioButton rbPria = new JRadioButton("Perempuan");
    JRadioButton rbWanita = new JRadioButton("Laki-Laki");

    JLabel lagama = new JLabel("Agama");
    String[] namaAgama =
            {"Islam", "Kristen", "Katolik", "Hindu", "Budha"};
    JComboBox cmbAgama = new JComboBox(namaAgama);

    JLabel lprodi = new JLabel("Program Studi ");
    String[] namaProdi =
            {"Informatika", "Sistem Informasi", "Teknik Kimia", "Teknik Industri", "D3 Teknik Kimia"};
    JComboBox cmbProdi = new JComboBox(namaProdi);

    final JTextArea falamat = new JTextArea();
    JLabel lalamat = new JLabel("Alamat");

    JButton jbSimpan =new JButton("Save");
    JButton jbBatal =new JButton("Cancel");
    
    public Swing(){
        setTitle("Form Data Diri");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000,1000 );

        ButtonGroup group = new ButtonGroup();
        group.add(rbPria);
        group.add(rbWanita);
        add(lnama);
        lnama.setBounds(10, 10, 150, 20);
        add(fnama);
        fnama.setBounds(130, 10, 250, 20);
        add(lpanggil);
        lpanggil.setBounds(10, 40, 150, 20);
        add(fpanggil);
        fpanggil.setBounds(130, 40, 210, 20);
        add(lnim);
        lnim.setBounds(10, 70, 120, 20);
        add(fnim);
        fnim.setBounds(130, 70, 150, 20);
        add(ljekel);
        ljekel.setBounds(10, 100, 120, 20);
        add(rbPria);
        rbPria.setBounds(130,100, 100, 20);
        add(rbWanita);
        rbWanita.setBounds(230,100, 100, 20);
        add(lagama);
        lagama.setBounds(10,130, 150, 20);
        add(cmbAgama);
        cmbAgama.setBounds(130,130, 150, 20);
        add(lprodi);
        lprodi.setBounds(10, 160, 166, 20);
        add(cmbProdi);
        cmbProdi.setBounds(130, 160, 166,20 );
        add(lalamat);
        lalamat.setBounds(10, 190, 500, 50);
        add(falamat);
        falamat.setBounds(130, 190, 500, 50);
        add(jbSimpan);
        jbSimpan.setBounds(250, 400, 100, 20);
        add(jbBatal);
        jbBatal.setBounds(400,400,100,20);
    }
}

