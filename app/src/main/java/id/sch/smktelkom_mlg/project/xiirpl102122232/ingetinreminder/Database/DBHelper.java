package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vistapram on 2016-11-07.
 */
public class DBHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "kegiatan";

    // Table columns
    public static final String ROW_ID = "_id";
    public static final String ROW_NAMAKEG = "nama";
    public static final String ROW_TGLKEG = "tanggal";
    public static final String ROW_WAKTU = "waktu";
    public static final String ROW_FILE = "file";
    public static final String ROW_KET = "keterangan";
    // Database Information
    static final String DB_NAME = "reminder.db";
    // database version
    static final int DB_VERSION = 1;
    // Creating table query
    private static final String CREATE_TABLE = "CREATE TABLE " + DB_NAME + " ( " +
            ROW_ID + " VARCHAR, " + ROW_NAMAKEG + " VARCHAR, " + ROW_TGLKEG + " DATE, "  + ROW_WAKTU + " TIME, "  + ROW_FILE + " VARCHAR, " + ROW_KET + " VARCHAR)";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
