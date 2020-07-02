package Model;

/**
 *
 * @author ASUS
 */
public class Detail_Transaksi {

    private Transaksi transaksi;
    private Jenis_Tiket jenis_tiket;
    private Integer jumlah;

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Jenis_Tiket getJenis_tiket() {
        return jenis_tiket;
    }

    public void setJenis_tiket(Jenis_Tiket jenis_tiket) {
        this.jenis_tiket = jenis_tiket;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public void getTransaksi(Transaksi transaksi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getJenis_tiket(Jenis_Tiket jenis_tiket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
