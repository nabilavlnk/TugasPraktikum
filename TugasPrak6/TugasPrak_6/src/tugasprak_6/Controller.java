/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasprak_6;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
public class Controller {

    Model modelPraktikum;
    View viewPraktikum;
    
    public Controller(Model modelPraktikum, View viewPraktikum){
    this.modelPraktikum = modelPraktikum;
    this.viewPraktikum = viewPraktikum;
    
    if(modelPraktikum.getBanyakData()!=0){
    String dataMahasiswa[][] = modelPraktikum.readMahasiswa();
    viewPraktikum.tabel.setModel((new JTable(dataMahasiswa, viewPraktikum.namakolom)).getModel());
    }
    else{
    JOptionPane.showMessageDialog(null, "Data tidak ada");
    }
    
    viewPraktikum.btnTambahPanel.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
    if((viewPraktikum.getNo().equals("")
            || viewPraktikum.getId().equals("")
            || viewPraktikum.getJudul().equals("")
            || viewPraktikum.getTipe().equals("")
            || viewPraktikum.getEpisode().equals("")
            || viewPraktikum.getGenre().equals("")
            || viewPraktikum.getStatus().equals("")
            || viewPraktikum.getRating().equals("")
            )){
    JOptionPane.showMessageDialog(null, "Failed tidak boleh kosong");
    }
    else{
    String no = viewPraktikum.getNo();
    String id = viewPraktikum.getId();
    String judul = viewPraktikum.getJudul();
    String tipe = viewPraktikum.getTipe();
    String episode = viewPraktikum.getEpisode();
    String genre = viewPraktikum.getGenre();
    String status = viewPraktikum.getStatus();
    String rating = viewPraktikum.getRating();
    
    modelPraktikum.insertMahasiswa(no,id,judul,tipe,episode,genre,status,rating);
    viewPraktikum.tfNo.setText("");
    viewPraktikum.tfId.setText("");
    viewPraktikum.tfJudul.setText("");
    viewPraktikum.tfTipe.setText("");
    viewPraktikum.tfEpisode.setText("");
    viewPraktikum.tfGenre.setText("");
    viewPraktikum.cmbStatus.setSelectedItem("");
    viewPraktikum.tfRating.setText("");
    
    String dataMahasiswa[][] = modelPraktikum.readMahasiswa();
    viewPraktikum.tabel.setModel(new JTable(dataMahasiswa, viewPraktikum.namakolom).getModel());
    }
    }
    });
    
    viewPraktikum.btnDeletePanel.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed (ActionEvent e){
            boolean databaru = false;
         if (databaru == true) {
             String query ="delete from `film` where id ='"+viewPraktikum.getId()+"'";
             JOptionPane.showMessageDialog(null, "Data akan dihapus?");
             databaru=true;
             viewPraktikum.tfNo.setText("");
             viewPraktikum.tfId.setText("");
             viewPraktikum.tfJudul.setText("");
             viewPraktikum.tfTipe.setText("");
             viewPraktikum.tfEpisode.setText("");
             viewPraktikum.tfGenre.setText("");
             viewPraktikum.cmbStatus.setSelectedItem("");
             viewPraktikum.tfRating.setText("");
         }}});
    
    viewPraktikum.btnEditPanel.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
        String judul = viewPraktikum.getJudul();
        String tipe = viewPraktikum.getTipe();
        String episode = viewPraktikum.getEpisode();
        String genre = viewPraktikum.getGenre();
        String status = viewPraktikum.getStatus();
        String rating = viewPraktikum.getRating();
                
                int baris = viewPraktikum.tabel.getSelectedRow();
                int kolom = viewPraktikum.tabel.getSelectedColumn();
                String dataterpilih = viewPraktikum.tabel.getValueAt(baris, 2).toString();
                modelPraktikum.updateFilm(judul, tipe, episode, genre, status, rating);
                String datamahasiswa[][] = modelPraktikum.readMahasiswa();
                viewPraktikum.tabel.setModel(new JTable(datamahasiswa, viewPraktikum.namakolom).getModel());
    }    
    });
        
    viewPraktikum.btnExitPanel.addActionListener(new ActionListener(){
        @Override
    public void actionPerformed (ActionEvent e){
        System.exit(0);
    }    
    });
    
    viewPraktikum.tabel.addMouseListener (new MouseAdapter(){
    @Override
    public void mouseClicked(MouseEvent e){
    int baris = viewPraktikum.tabel.getSelectedRow();
    int kolom = viewPraktikum.tabel.getSelectedColumn();
    
    String dataterpilih = viewPraktikum.tabel.getValueAt(baris, 2).toString();
        System.out.println(dataterpilih);
        
        int input = JOptionPane.showConfirmDialog(null, "Apa anda ingin menghapus no "+dataterpilih+ "?", "Pilih opsi ...", JOptionPane.YES_NO_CANCEL_OPTION);
        if(input == 0){
        modelPraktikum.deleteMahasiswa(dataterpilih);
        String dataMahasiswa[][] = modelPraktikum.readMahasiswa();
        viewPraktikum.tabel.setModel(new JTable (dataMahasiswa, viewPraktikum.namakolom).getModel());
        }
        else
        {
        JOptionPane.showMessageDialog(null, "Tidak jadi dihapus");
        }
    }
    
    });
   }
}