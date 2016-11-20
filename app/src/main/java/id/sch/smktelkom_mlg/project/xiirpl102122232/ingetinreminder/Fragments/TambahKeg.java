package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.Fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.R;

public class TambahKeg extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText etnama, etcatatan;
    //private CheckBox senin, selasa, rabu, kamis, jumat, sabtu, minggu;
    private Button buttonTambah;
    private TextView ulangi;
    private Button btnDatePicker, btnTimePicker;
    private EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private Context context;

    private OnFragmentInteractionListener mListener;

    public TambahKeg() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TambahKeg newInstance(String param1, String param2) {
        TambahKeg fragment = new TambahKeg();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tambah_keg, container, false);
        context = getContext();
        etnama = (EditText) view.findViewById(R.id.etnama);
        etcatatan = (EditText) view.findViewById(R.id.etcatatan);
        /*senin = (CheckBox) view.findViewById(R.id.senin);
        selasa = (CheckBox) view.findViewById(R.id.selasa);
        rabu = (CheckBox) view.findViewById(R.id.rabu);
        kamis = (CheckBox) view.findViewById(R.id.kamis);
        jumat = (CheckBox) view.findViewById(R.id.jumat);
        sabtu = (CheckBox) view.findViewById(R.id.sabtu);
        minggu = (CheckBox) view.findViewById(R.id.minggu);

        senin.setOnCheckedChangeListener(this);
        selasa.setOnCheckedChangeListener(this);
        rabu.setOnCheckedChangeListener(this);
        kamis.setOnCheckedChangeListener(this);
        jumat.setOnCheckedChangeListener(this);
        sabtu.setOnCheckedChangeListener(this);
        minggu.setOnCheckedChangeListener(this);*/

        buttonTambah = (Button) view.findViewById(R.id.buttonTambah);
        btnDatePicker = (Button) view.findViewById(R.id.btn_date);
        btnTimePicker = (Button) view.findViewById(R.id.btn_time);
        txtDate = (EditText) view.findViewById(R.id.in_date);
        txtTime = (EditText) view.findViewById(R.id.in_time);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
           mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(context,
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
            TimePickerDialog timePickerDialog = new TimePickerDialog(context,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
