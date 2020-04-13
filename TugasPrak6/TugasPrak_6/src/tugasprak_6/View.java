/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasprak_6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame{


    JLabel lNo = new JLabel("# = ");
    JTextField tfNo = new JTextField();
    JLabel lId = new JLabel ("ID = ");
    JTextField tfId = new JTextField();
    JLabel lJudul = new JLabel("Judul = ");
    JTextField tfJudul = new JTextField();
    JLabel lTipe = new JLabel("Tipe = ");
    JTextField tfTipe = new JTextField();
    JLabel lEpisode = new JLabel("Episode = ");
    JTextField tfEpisode = new JTextField();
    JLabel lGenre = new JLabel("Genre = ");
    JTextField tfGenre = new JTextField();
    JLabel lStatus = new JLabel("Status = ");
    String[] Status =
            {"Selesai","Belum Selesai"};
    JComboBox cmbStatus = new JComboBox(Status);
    JLabel lRating = new JLabel("Rating = ");
    JTextField tfRating = new JTextField();
    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnEditPanel = new JButton("Edit");
    JButton btnDeletePanel = new JButton("Delete");
    JButton btnExitPanel = new JButton("Exit");
    JButton btnSearchPanel = new JButton("Search");
    JTextField tfSearch = new JTextField();

    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namakolom[] = {"#", "ID", "Judul", "Tipe", "Episode", "Genre", "Status", "Rating"};
    
    public View(){
    tableModel = new DefaultTableModel (namakolom,0);
    tabel = new JTable (tableModel);
    scrollPane = new JScrollPane (tabel);
    
    setDefaultCloseOperation(3);
    setVisible(true);
    setLayout(null);
    tabel.setSize(5,5);
    tabel.setVisible(true);
    setSize(700,900);
    
    add (lNo);
    lNo.setBounds(5, 230, 90, 20);
    add (tfNo);
    tfNo.setBounds(110, 230, 120, 20);
    add (lId);
    lId.setBounds(5, 260, 90, 20);
    add (tfId);
    tfId.setBounds(110, 260, 120, 20);
    add (lJudul);
    lJudul.setBounds(5, 290, 90, 20);
    add (tfJudul);
    tfJudul.setBounds(110, 290, 120, 20);
    add (lTipe);
    lTipe.setBounds(5, 320, 90, 20);
    add (tfTipe);
    tfTipe.setBounds(110, 320, 120, 20);
    add (lEpisode);
    lEpisode.setBounds(5, 350, 90, 20);
    add (tfEpisode);
    tfEpisode.setBounds(110, 350, 120, 20);
    add (lGenre);
    lGenre.setBounds(5, 380, 90, 20);
    add (tfGenre);
    tfGenre.setBounds(110, 380, 120, 20);
    add (lStatus);
    lStatus.setBounds(5, 410, 90, 20);
    add (cmbStatus);
    cmbStatus.setBounds(110, 410, 120, 20);
    add (lRating);
    lRating.setBounds(5, 440, 90, 20);
    add (tfRating);
    tfRating.setBounds(110, 440, 120, 20);
    add (btnTambahPanel);
    btnTambahPanel.setBounds(20, 480, 90, 20);
    add (btnEditPanel);
    btnEditPanel.setBounds(130, 480, 90, 20);
    add (btnDeletePanel);
    btnDeletePanel.setBounds(240, 480, 90, 20);
    add (btnExitPanel);
    btnExitPanel.setBounds(350, 480, 90, 20);
    add (btnSearchPanel);
    btnSearchPanel.setBounds(20, 520, 90, 20);
    add (tfSearch);
    tfSearch.setBounds(130, 520, 120, 20);
    
    add (scrollPane);
    scrollPane.setBounds(20, 20, 580, 200);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    
    }
    
    public String getNo(){
    return tfNo.getText();
    }
    public String getId(){
    return tfId.getText();
    }
    public String getJudul(){
    return tfJudul.getText();
    }
    public String getTipe(){
    return tfTipe.getText();
    }
    public String getEpisode(){
    return tfEpisode.getText();
    }
    public String getGenre(){
    return tfGenre.getText();
    }
    public String getStatus(){
    return cmbStatus.toString();
    }
    public String getRating(){
    return tfRating.getText();
    }
}
