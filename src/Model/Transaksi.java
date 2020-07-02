package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Transaksi {

    private Integer id_transaksi;
    private Date tgl_transaksi;
    private Pembeli pembeli;
    private Double harga_total;
    private ArrayList<Detail_Transaksi> arrDetail_Transaksi;

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public Integer getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(Integer id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Date getTgl_transaksi() {
        return tgl_transaksi;
    }

    public void setTgl_transaksi(Date tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    public Double getHarga_total() {
        return harga_total;
    }

    public void setHarga_total(Double harga_total) {
        this.harga_total = harga_total;
    }

    public ArrayList<Detail_Transaksi> getArrDetail_Transaksi() {
        return arrDetail_Transaksi;
    }

    public void setArrDetail_Transaksi(ArrayList<Detail_Transaksi> arrDetail_Transaksi) {
        this.arrDetail_Transaksi = arrDetail_Transaksi;
    }

}
