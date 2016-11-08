package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class tambah_keg extends AppCompatActivity {
    static final int TIME_DIALOG_ID = 1;
    // variables to save user selected date and time
    public int hour, minute;
    Button btnwaktu;
    TextView etwaktu;
    // declare  the variables to Show/Set the date and time when Time and  Date Picker Dialog first appears
    private int mHour, mMinute;
    // Register  TimePickerDialog listener
    private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        // the callback received when the user "sets" the TimePickerDialog in the dialog
        public void onTimeSet(TimePicker view, int hourOfDay, int min) {
            hour = hourOfDay;
            minute = min;
            // Set the Selected Date in Select date Button
            etwaktu.setText(hour + ":" + minute);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnwaktu = (Button) findViewById(R.id.btnwaktu);
        etwaktu = (TextView) findViewById(R.id.etwaktu);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            // create a new TimePickerDialog with values you want to show
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this, mTimeSetListener, mHour, mMinute, false);

        }
        return null;
    }

}