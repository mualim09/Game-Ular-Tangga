public class pemain{
    private String nama;
    protected int nilai=0;
    private int jumlah;

    public pemain(String nama){
        this.nama=nama;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama=nama;
    }

    public int getNilai(){
        return nilai;
    }

    public void setNilai(int nilai){
        this.nilai+=nilai;
    }
}
