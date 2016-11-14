package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.R;

//iki skrip e cek pas ngatur jam ambek tanggal iso pop up, tapi yo iku, gak muncul :V
public class Tambah_Keg extends Fragment {
    static final int TIME_DIALOG_ID = 1;
    // variables to save user selected date and time
    public int hour, minute;
    Button btnwaktu;
    TextView etwaktu;
    View view;
    Context context;
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

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2 + 1, arg3);
        }
    };

    private void showDate(int arg1, int i, int arg3) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.Tambah_keg, container, false);
        context = getContext();
        btnwaktu = (Button) view.findViewById(R.id.btnwaktu);
        etwaktu = (TextView) view.findViewById(R.id.etwaktu);

        dateView = (TextView) view.findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);
        return view;
}
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            // create a new TimePickerDialog with values you want to show
            case TIME_DIALOG_ID:
                return new TimePickerDialog(context, mTimeSetListener, mHour, mMinute, false);

        }
        return null;
    }

}