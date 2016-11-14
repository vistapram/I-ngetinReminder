package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.Database;

/**
 * Created by Naufal Ramaputra on 13/11/2016.
 */

public class Reminder {
    private String _id;
    private String namakeg;
    private String tglkeg;
    private String waktu;
    private String file;
    private String ket;

    public Reminder(String _id, String namakeg, String tglkeg, String waktu,
                    String file, String ket) {
        this._id = _id;
        this.namakeg = namakeg;
        this.tglkeg = tglkeg;
        this.waktu = waktu;
        this.file = file;
        this.ket = ket;

        /*String ROW_ID = "_id";
        public static final String ROW_NAMAKEG = "nama";
        public static final String ROW_TGLKEG = "tanggal";
        public static final String ROW_WAKTU = "waktu";
        public static final String ROW_FILE = "file";
        public static final String ROW_KET = "keterangan";*/
    }


    public void setId(String _id) {
        this._id = _id;
    }

    public void setNamakeg(String namakeg) {
        this.namakeg = namakeg;
    }

    public void setTglkeg(String tglkeg) {
        this.tglkeg = tglkeg;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }


    public String setId() {
        return _id;
    }

    public String setNamakeg() {
        return setNamakeg();
    }

    public String setTglKeg() {
        return setTglKeg();
    }

    public String setWaktu() {
        return setWaktu();
    }

    public String setFile() {
        return setFile();
    }

    public String setKet() {
        return setKet();
    }
}

