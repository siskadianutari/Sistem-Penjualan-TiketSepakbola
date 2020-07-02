
package Controller;

import Database.Koneksi;
import Model.Pembeli;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Pembeli_Controller {
    private Koneksi koneksi;
    ArrayList<Pembeli> arrPembeli;
    
    
    public Pembeli_Controller(){
        this.koneksi = new Koneksi();                 
        this.arrPembeli = new ArrayList<>();
    
    
    }


// Input data PEMBELI 
    public void inputSelamatDatang(Pembeli pembeli){
    this.koneksi.ManipulasiData("INSERT INTO PEMBELI_06954 (NIK, NAMA_06954, JENIS_KELAMIN, ALAMAT, NO_TELP)"
            + "VALUES('"+pembeli.getNik()+"','"+pembeli.getNama_pembeli()+"','"+pembeli.getKelaminn()+"'"
            + ",'"+pembeli.getAlamat()+"','"+pembeli.getNo_telp()+"')");
    System.out.println("INSERT INTO PEMBELI_06954 (NIK, NAMA_06954, JENIS_KELAMIN, ALAMAT, NO_TELP)"
            + "VALUES('"+pembeli.getNik()+"','"+pembeli.getNama_pembeli()+"','"+pembeli.getKelaminn()+"'"
            + ",'"+pembeli.getAlamat()+"','"+pembeli.getNo_telp()+"')");
    
    }
    public ArrayList<Pembeli> getDataPembeli() throws SQLException{
        this.arrPembeli.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM PEMBELI_06954 ORDER BY NIK ASC");
        while (rs.next()){
            Pembeli pembeli = new Pembeli();
            pembeli.setNik(rs.getInt("NIK"));
            pembeli.setNama_pembeli(rs.getString("NAMA_06954"));
            pembeli.setKelaminn(rs.getString("JENIS_KELAMIN"));
            pembeli.setAlamat(rs.getString("ALAMAT"));
            pembeli.setNo_telp(rs.getInt("NO_TELP"));
         this.arrPembeli.add(pembeli);
        }
        return this.arrPembeli;
    }
}
