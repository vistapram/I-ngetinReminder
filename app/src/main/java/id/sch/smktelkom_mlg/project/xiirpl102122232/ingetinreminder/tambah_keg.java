package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import java.util.Calendar;

import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.DatabaseHelper;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.R;

public class tambah_keg extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    EditText etnama, etcatatan, in_date, in_time;
    //CheckBox senin, selasa, rabu, kamis, jumat, sabtu, minggu;
    Button button;
    TextView result, req, jumlah, kelas, ulangi;
    Button btnDatePicker, btnTimePicker, btnTambah;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;
    DatabaseHelper controller;
    public Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_keg);
        setTitle("Tambah Kegiatan");
        ctx = this;
        etnama = (EditText) findViewById(R.id.etnama);
        in_date = (EditText) findViewById(R.id.in_date);
        in_time = (EditText) findViewById(R.id.in_time);
        etcatatan = (EditText) findViewById(R.id.etcatatan);
        btnTambah = (Button) findViewById(R.id.buttonTambah);
        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);

        controller = new DatabaseHelper(this, "reminder", null, 1);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        btnTambah.setOnClickListener(this);


        findViewById(R.id.buttonTambah).setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//
//    private void doProses() {
//        DatabaseHelper DB = new DatabaseHelper(this);
//        DB.insert(etnama.getText().toString(),
//                in_date.getText().toString(),
//                in_time.getText().toString(),
//                etcatatan.getText().toString());
//
//        String[] arrayArum;
//        arrayArum = DB.getArray(1);
//
//        for (int i = 0; i < arrayArum.length; i++) {
//            Log.d("EMINEM PUNYA", "doProses: " + arrayArum[i]);
//        }
//
//    }

//    private boolean isValid() {
//        boolean valid = true;
//
//        String nama = etnama.getText().toString();
//
//        if (nama.isEmpty()) {
//            etnama.setError("Isikan nama kegiatan!");
//            valid = false;
//        } else if (nama.length() < 5) {
//            etnama.setError("Minimal 5 karakter");
//            valid = false;
//        } else {
//            etnama.setError(null);
//        }
//        return valid;
//    }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                           in_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            in_time.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if (v == btnTambah) {
            Toast.makeText(ctx, "Task has been saved", Toast.LENGTH_LONG).show();
            controller.insert(etnama.getText().toString(), in_date.getText().toString(), in_time.getText().toString(), etcatatan.getText().toString() );
//            ContentMain fragment = (ContentMain) getSupportFragmentManager().findFragmentById(R.id.content_main);
//            fragment.loadDatabase();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String label = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

//    public void btn_click(View view) {
//        Toast.makeText(getApplicationContext(), "Task has been saved", Toast.LENGTH_LONG).show();
//        controller.insert(etnama.getText().toString(), in_date.getText().toString(), in_time.getText().toString(), etcatatan.getText().toString() );
//    }
}