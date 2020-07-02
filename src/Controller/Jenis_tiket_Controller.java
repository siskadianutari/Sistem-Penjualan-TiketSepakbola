package Controller;

import Database.Koneksi;
import Model.Jenis_Tiket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Jenis_tiket_Controller {

    Koneksi koneksi;
    ArrayList<Jenis_Tiket> arrJenis_Tiket;

    public Jenis_tiket_Controller() {
        this.koneksi = new Koneksi();
        this.arrJenis_Tiket = new ArrayList<>();
    }

    public ArrayList<Jenis_Tiket> getDataJenis_Tiket() throws SQLException {
        this.arrJenis_Tiket.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM JENIS_TIKET_06954");
        while (rs.next()) {
            Jenis_Tiket jenis_tiket = new Jenis_Tiket();
            jenis_tiket.setId_tiket(rs.getInt("ID_TIKET"));
            jenis_tiket.setNama_tiket(rs.getString("NAMA_TIKET"));
            jenis_tiket.setHarga_tiket(rs.getInt("HARGA_TIKET"));
            this.arrJenis_Tiket.add(jenis_tiket);
        }
        return this.arrJenis_Tiket;
    }
}
