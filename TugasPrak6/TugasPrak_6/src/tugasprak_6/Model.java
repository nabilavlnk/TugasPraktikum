/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasprak_6;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Model {
    
 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/tugas_prak";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public Model(){
    try{
    Class.forName(JDBC_DRIVER);
    koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
    System.out.println("Berhasil");
    }
    catch(Exception ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    System.out.println("Koneksi Gagal");    
    }
    }
    public void insertMahasiswa(String no, String id, String judul, String tipe, String episode, String genre, String status, String rating){
    try{
    String query = "INSERT INTO `film` (`#`, `ID`, `Judul`, `Tipe`, `Episode`, `Genre`, `Status`, `Rating`) VALUES ('"+no+"', '"+id+"', '"+judul+"', '"+tipe+"', '"+episode+"', '"+genre+"', '"+status+"', '"+rating+"')";
    statement = (Statement) koneksi.createStatement();
    statement.executeUpdate(query);
    System.out.println("Berhasil Ditambahkan");
    JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
    }
    catch(Exception sql){
    System.out.println(sql.getMessage());
    JOptionPane.showMessageDialog(null, sql.getMessage());
    }
    }
    
                                   
    public String[][] readMahasiswa(){
    try{
    int jmlData = 0;
    String data[][] = new String[getBanyakData()][8];
    String query = "Select * from `film`";
    ResultSet resultSet = statement.executeQuery(query);
    while (resultSet.next()){
    data[jmlData][0] = resultSet.getString("#");
    data[jmlData][1] = resultSet.getString("ID");
    data[jmlData][2] = resultSet.getString("Judul");
    data[jmlData][3] = resultSet.getString("Tipe");
    data[jmlData][4] = resultSet.getString("Episode");
    data[jmlData][5] = resultSet.getString("Genre");
    data[jmlData][6] = resultSet.getString("Status");
    data[jmlData][7] = resultSet.getString("Rating");
    jmlData++;
    }
    return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return null;
    }
    }
    public int getBanyakData(){
    int jmlData = 0;
    try{
    statement = koneksi.createStatement();
    String query = "Select * from `film`";
    ResultSet resultSet = statement.executeQuery(query);
    while(resultSet.next()){
    jmlData++;
    }
    return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL Error");
        return 0;
    }
    }
    public void deleteMahasiswa (String judul){
    try{
        
    String query = "DELETE FROM `film` WHERE `Judul` = '"+judul+"'";
    statement = koneksi.createStatement();
    statement.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
    }
    
     public void updateFilm(String judul, String tipe, String episode, String genre, String status, String rating){
        String query="Update `film` set `judul` ='"+judul+"', "
                + "tipe='"+tipe+"',"
                + "episode='"+episode+"',"
                + "genre='"+genre+"',"
                + "status='"+status+"',"
                + "rating='"+rating+"'";
                
        try{
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data film berhasil diupdate!");  
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

