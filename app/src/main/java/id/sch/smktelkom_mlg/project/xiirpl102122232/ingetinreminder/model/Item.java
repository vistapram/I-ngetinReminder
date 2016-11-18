package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.model;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Naufal Ramaputra on 15/11/2016.
 */

public class Item {
    int ROW_ID;
    String ROW_NAMAKEG;
    Date ROW_TGLKEG;
    Time ROW_WAKTU;
    String ROW_FILE;
    String ROW_KET;

    public int getROW_ID() {
        return ROW_ID;
    }

    public void setROW_ID(int ROW_ID) {
        this.ROW_ID = ROW_ID;
    }

    public String getROW_NAMAKEG() {
        return ROW_NAMAKEG;
    }

    public void setROW_NAMAKEG(String ROW_NAMAKEG) {
        this.ROW_NAMAKEG = ROW_NAMAKEG;
    }

    public Date getROW_TGLKEG() {
        return ROW_TGLKEG;
    }

    public void setROW_TGLKEG(Date ROW_TGLKEG) {
        this.ROW_TGLKEG = ROW_TGLKEG;
    }

    public Time getROW_WAKTU() {
        return ROW_WAKTU;
    }

    public void setROW_WAKTU(Time ROW_WAKTU) {
        this.ROW_WAKTU = ROW_WAKTU;
    }

    public String getROW_FILE() {
        return ROW_FILE;
    }

    public void setROW_FILE(String ROW_FILE) {
        this.ROW_FILE = ROW_FILE;
    }

    public String getROW_KET() {
        return ROW_KET;
    }

    public void setROW_KET(String ROW_KET) {
        this.ROW_KET = ROW_KET;
    }
}
