import javax.swing.JOptionPane;

public class ControllerOrang {

    private ModelOrang mo;

    public void setMo(ModelOrang mo) {
        this.mo = mo;
    }

    public void resetForm(ViewOrang viewOrang) {
        String namaDepan = viewOrang.getFnamadepan().getText();
        String namaTengah = viewOrang.getFnamatengah().getText();
        String namaBelakang = viewOrang.getFnamabelakang().getText();

        if (namaDepan.equals("") && namaTengah.equals("") && namaBelakang.equals("")) {
        } else {
            mo.resetForm();
        }
    }

    public void submitForm(ViewOrang viewOrang) {
        String namaDepan = viewOrang.getFnamadepan().getText();
        String namaTengah = viewOrang.getFnamatengah().getText();
        String namaBelakang = viewOrang.getFnamabelakang().getText();

        if (namaDepan.trim().equals("")) {
            JOptionPane.showMessageDialog(viewOrang, "Nama Depan Masih Kosong !");
        } else if (namaTengah.trim().equals("")) {
            JOptionPane.showMessageDialog(viewOrang, "Nama Tengah Masih Kosong !");
        } else if (namaBelakang.trim().equals("")) {
            JOptionPane.showMessageDialog(viewOrang, "Nama Belakang Masih Kosong !");
        } else {
            mo.submitForm(viewOrang);
            mo.resetForm();
        }
    }
}