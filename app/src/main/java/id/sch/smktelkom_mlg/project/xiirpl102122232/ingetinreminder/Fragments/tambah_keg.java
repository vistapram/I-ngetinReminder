package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.Fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.DatabaseHelper;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.R;

public class tambah_keg extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    EditText etnama, etcatatan, in_date, in_time;
    //CheckBox senin, selasa, rabu, kamis, jumat, sabtu, minggu;
    Button button;
    TextView result, req, jumlah, kelas, ulangi;
    Button btnDatePicker, btnTimePicker, btnTambah;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_keg);
        etnama = (EditText) findViewById(R.id.etnama);
        in_date = (EditText) findViewById(R.id.in_date);
        in_time = (EditText) findViewById(R.id.in_time);
        etcatatan = (EditText) findViewById(R.id.etcatatan);

        /*
        selasa = (CheckBox) findViewById(R.id.selasa);
        senin = (CheckBox) findViewById(R.id.senin);
        rabu = (CheckBox) findViewById(R.id.rabu);
        kamis = (CheckBox) findViewById(R.id.kamis);
        jumat = (CheckBox) findViewById(R.id.jumat);
        sabtu = (CheckBox) findViewById(R.id.sabtu);
        minggu = (CheckBox) findViewById(R.id.minggu);

        senin.setOnCheckedChangeListener(this);
        selasa.setOnCheckedChangeListener(this);
        rabu.setOnCheckedChangeListener(this);
        kamis.setOnCheckedChangeListener(this);
        jumat.setOnCheckedChangeListener(this);
        sabtu.setOnCheckedChangeListener(this);
        minggu.setOnCheckedChangeListener(this);
        */

        btnTambah = (Button) findViewById(R.id.buttonTambah);
        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        txtDate = (EditText) findViewById(R.id.in_date);
        txtTime = (EditText) findViewById(R.id.in_time);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        btnTambah.setOnClickListener(this);

        /*
        final CheckBox checkBox = (CheckBox) findViewById(R.id.senin);
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
        }
        */

    }

    private void doProses() {
        //doSelect();

        DatabaseHelper DB = new DatabaseHelper(this);
        DB.insert(etnama.getText().toString(),
                in_date.getText().toString(),
                in_time.getText().toString(),
                etcatatan.getText().toString());

        String[] arrayArum;
        arrayArum = DB.getArray(1);

        for (int i = 0; i < arrayArum.length; i++) {
            Log.d("EMINEM PUNYA", "doProses: " + arrayArum[i]);
        }

    }

    /*
        private void doSelect() {
            String ulang = "Diulangi pada :\n";

            if (senin.isChecked()) ulang += senin.getText() + "\n";
            if (selasa.isChecked()) ulang += selasa.getText() + "\n";
            if (rabu.isChecked()) ulang += rabu.getText() + "\n";
            if (kamis.isChecked()) ulang += kamis.getText() + "\n";
            if (jumat.isChecked()) ulang += jumat.getText() + "\n";
            if (sabtu.isChecked()) ulang += sabtu.getText() + "\n";
            if (minggu.isChecked()) ulang += minggu.getText() + "\n";

            ulangi.setText(ulang);

        }
    */
    private boolean isValid() {
        boolean valid = true;

        String nama = etnama.getText().toString();

        if (nama.isEmpty()) {
            etnama.setError("Isikan nama kegiatan!");
            valid = false;
        } else if (nama.length() < 5) {
            etnama.setError("Minimal 5 karakter");
            valid = false;
        } else {
            etnama.setError(null);
        }
        return valid;
    }

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

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

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

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if (v == btnTambah) {
            doProses();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}