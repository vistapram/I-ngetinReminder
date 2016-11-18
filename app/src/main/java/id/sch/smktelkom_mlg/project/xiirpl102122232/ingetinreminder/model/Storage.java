package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Vistapram on 2016-11-02.
 */

public class Storage {
    public String judul;
    public String deskripsi;
    public Drawable foto;
    public Storage(String judul, String deskripsi, Drawable foto)
    {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }
}
