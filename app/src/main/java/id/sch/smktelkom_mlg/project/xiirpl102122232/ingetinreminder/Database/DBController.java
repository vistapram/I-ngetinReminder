package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Vistapram on 2016-11-07.
 */
public class DBController {

    private DBHelper dbHelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public DBController(Context c) {
        ourcontext = c;
    }

    public DBController open() throws SQLException {
        dbHelper = new DBHelper(ourcontext);
        database = dbHelper.getWritableDatabase();
        return this;

    }

    public void close() {
        dbHelper.close();
    }

    public void insert(Reminder reminder, String _id, String name, String tanggal, String waktu, String file, String ket) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DBHelper.ROW_ID, _id);
        contentValue.put(DBHelper.ROW_NAMAKEG, name);
        contentValue.put(DBHelper.ROW_TGLKEG, tanggal);
        contentValue.put(DBHelper.ROW_WAKTU, waktu);
        contentValue.put(DBHelper.ROW_FILE, file);
        contentValue.put(DBHelper.ROW_KET, ket);
        database.insert(DBHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[]{DBHelper.ROW_ID, DBHelper.ROW_NAMAKEG, DBHelper.ROW_TGLKEG, DBHelper.ROW_WAKTU, DBHelper.ROW_FILE,
                DBHelper.ROW_KET};
        Cursor cursor = database.query(DBHelper.TABLE_NAME, columns, null,
                null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(String _id, String name, String tanggal, String waktu, String file, String ket) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.ROW_NAMAKEG, name);
        contentValues.put(DBHelper.ROW_TGLKEG, tanggal);
        contentValues.put(DBHelper.ROW_WAKTU, waktu);
        contentValues.put(DBHelper.ROW_FILE, file);
        contentValues.put(DBHelper.ROW_KET, ket);
        int i = database.update(DBHelper.TABLE_NAME, contentValues, DBHelper.ROW_ID + " = " + _id, null);
        return i;
    }

    public void delete(String _id) {
        database.delete(DBHelper.TABLE_NAME, DBHelper.ROW_ID + "=" + _id, null);
    }
}