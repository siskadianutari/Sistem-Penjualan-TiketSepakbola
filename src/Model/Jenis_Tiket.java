package Model;

/**
 *
 * @author ASUS
 */
public class Jenis_Tiket {
    private Integer id_tiket;
    private String nama_tiket;
    private Integer harga_tiket;

    public Integer getId_tiket() {
        return id_tiket;
    }

    public void setId_tiket(Integer id_tiket) {
        this.id_tiket = id_tiket;
    }

    public String getNama_tiket() {
        return nama_tiket;
    }

    public void setNama_tiket(String nama_tiket) {
        this.nama_tiket = nama_tiket;
    }

    public Integer getHarga_tiket() {
        return harga_tiket;
    }

    public void setHarga_tiket(Integer harga_tiket) {
        this.harga_tiket = harga_tiket;
    }
}
