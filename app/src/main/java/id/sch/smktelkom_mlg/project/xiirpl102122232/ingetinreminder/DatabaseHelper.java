package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Naufal Ramaputra on 13/11/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    // Table Name
    public static final String TABLE_NAME = "kegiatan";
    // Table columns
    public static final String ROW_ID = "_id";
    public static final String ROW_NAMAKEG = "nama";
    public static final String ROW_TGLKEG = "tanggal";
    public static final String ROW_WAKTU = "waktu";
    public static final String ROW_KET = "keterangan";
    private static String DB_NAME = "reminder.sqlite";
    private static String DB_PATH = "";
    private final Context myContext;
    private SQLiteDatabase myDatabase;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        if (Build.VERSION.SDK_INT >= 15) {
            //error
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = Environment.getDataDirectory() + "/data/" + context.getPackageName() + "/databases/";
        }
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void checkAndCopyDatabase() {
        boolean dbExist = checkDatabase();
        if (dbExist) {
            Log.d("TAG", "Database sudah ada");
        } else {
            this.getReadableDatabase();
        }
        try {
            copyDatabase();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG", "Error copy database");
        }
    }

    public boolean checkDatabase() {
        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }

    public void copyDatabase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);

        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDatabase() {
        String myPath = DB_PATH + DB_NAME;
        myDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void close() {
        if (myDatabase != null) {
            myDatabase.close();
        }
        super.close();
    }

    public Cursor QueryData(String query) {
        return myDatabase.rawQuery(query, null);

    }

    public void insert(String name, String tanggal, String waktu, String ket) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROW_NAMAKEG, name);
        contentValues.put(ROW_TGLKEG, tanggal);
        contentValues.put(ROW_WAKTU, waktu);
        contentValues.put(ROW_KET, ket);
        myDatabase.insert(TABLE_NAME, null, contentValues);

    }

    public String[] getArray(int id) {
        Cursor cursor = myDatabase.rawQuery("select * from " + TABLE_NAME + " where " + ROW_ID + " = \"" + id + "\" ", null);

        String[] eminem = new String[cursor.getColumnCount()];  // looping through all rows and adding to list

        try {
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        for (int i = 1; i < cursor.getColumnCount(); i++) {
                            eminem[i - 1] = cursor.getString(i);
                        }
                    } while (cursor.moveToNext());
                }
            }
        } catch (Error e) {

        }

        cursor.close();
        return eminem;
    }
}
