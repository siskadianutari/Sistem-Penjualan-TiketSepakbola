package Controller;

import Database.Koneksi;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transaksi_Controller {

    Koneksi koneksi;
    ArrayList<Pembeli> arrPembeli;
    ArrayList<Jenis_Tiket> arrJenis;
    ArrayList<Transaksi> arrTransaksi;

    public Transaksi_Controller() {
        this.koneksi = new Koneksi();
        this.arrJenis = new ArrayList<>();
        this.arrPembeli = new ArrayList<>();
        this.arrTransaksi = new ArrayList<>();
    }

    public ArrayList<Transaksi> getDataTransaksi() throws SQLException {
        this.arrTransaksi.clear();
        ResultSet rs = this.koneksi.GetData("SELECT TRANSAKSI_06954.*, PEMBELI_06954.* FROM TRANSAKSI_06954 JOIN PEMBELI_06954 "
                + "ON TRANSAKSI_06954.NIK = PEMBELI_06954.NIK");
        while (rs.next()) {

            Pembeli pembeli = new Pembeli();
            pembeli.setNik(rs.getInt("NIK"));
            pembeli.setNama_pembeli(rs.getString("NAMA_06954"));
            pembeli.setKelaminn(rs.getString("JENIS_KELAMIN"));
            pembeli.setAlamat(rs.getString("ALAMAT"));
            pembeli.setNo_telp(rs.getInt("NO_TELP"));

            Transaksi transaksi = new Transaksi();
            transaksi.setId_transaksi(rs.getInt("ID_TRANSAKSI"));
            transaksi.setTgl_transaksi(rs.getDate("TGL_TRANSAKSI"));
            transaksi.setPembeli(pembeli);
            transaksi.setHarga_total(rs.getDouble("HARGA_TOTAL"));
            this.arrTransaksi.add(transaksi);

            ResultSet rsDetail_Transaksi = this.koneksi.GetData("SELECT * FROM DETAIL_TRANSAKSI_06954 JOIN TRANSAKSI_06954 ON "
                    + "DETAIL_TRANSAKSI_06954.ID_TRANSAKSI = TRANSAKSI_06954.ID_TRANSAKSI JOIN JENIS_TIKET_06954 ON "
                    + "DETAIL_TRANSAKSI_06954.ID_TIKET = JENIS_TIKET_06954.ID_TIKET "
                    + "WHERE DETAIL_TRANSAKSI_06954.ID_TRANSAKSI = " + rs.getString("ID_TRANSAKSI"));
            ArrayList<Detail_Transaksi> dt = new ArrayList<>();

            while (rsDetail_Transaksi.next()) {
                Pembeli p = new Pembeli();
                p.setNik(rs.getInt("NIK"));
                p.setNama_pembeli(rs.getString("NAMA_06954"));
                p.setKelaminn(rs.getString("JENIS_KELAMIN"));
                p.setAlamat(rs.getString("ALAMAT"));
                p.setNo_telp(rs.getInt("NO_TELP"));

                Transaksi t = new Transaksi();
                t.setId_transaksi(rsDetail_Transaksi.getInt("ID_TRANSAKSI"));
                t.setTgl_transaksi(rsDetail_Transaksi.getDate("TGL_TRANSAKSI"));
                t.setPembeli(pembeli);
                t.setHarga_total(rsDetail_Transaksi.getDouble("HARGA_TOTAL"));

                Jenis_Tiket jenis_tiket = new Jenis_Tiket();
                jenis_tiket.setId_tiket(rsDetail_Transaksi.getInt("ID_TIKET"));
                jenis_tiket.setNama_tiket(rsDetail_Transaksi.getString("NAMA_TIKET"));
                jenis_tiket.setHarga_tiket(rsDetail_Transaksi.getInt("HARGA_TIKET"));

                Detail_Transaksi detail_transaksi = new Detail_Transaksi();
                detail_transaksi.setTransaksi(transaksi);
                detail_transaksi.setJenis_tiket(jenis_tiket);
                detail_transaksi.setJumlah(rsDetail_Transaksi.getInt("JUMLAH"));

                dt.add(detail_transaksi);
            }
            transaksi.setArrDetail_Transaksi(dt);

            this.arrTransaksi.add(transaksi);

        }
        return this.arrTransaksi;
    }

    public void insertTransaksi(Transaksi transaksi) {
        try {
            String dateTransaksi = new SimpleDateFormat("dd/MM/yyyy").format(transaksi.getTgl_transaksi());
            this.koneksi.ManipulasiData("INSERT INTO TRANSAKSI_06954 VALUES (ID_TRANSAKSI.NEXTVAL, TO_DATE('" + dateTransaksi
                    + "','dd/MM/yyyy'),'" + transaksi.getPembeli().getNik() + "', " + transaksi.getHarga_total() + ")");
            ResultSet rs = this.koneksi.GetData("SELECT ID_TRANSAKSI.CURRVAL FROM DUAL");
            rs.next();
            int id_transaksi = rs.getInt("CURRVAL");
            for (Detail_Transaksi t : transaksi.getArrDetail_Transaksi()) {
                this.koneksi.ManipulasiData("INSERT INTO DETAIL_TRANSAKSI_06954 VALUES (" + id_transaksi
                        + ", " + t.getJenis_tiket().getId_tiket() + ", " + t.getJumlah() + ")");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
