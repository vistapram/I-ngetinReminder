package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.Fragments;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.DatabaseHelper;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.R;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.model.Item;

/**
 * Created by Vistapram on 2016-11-09.
 */

public class CalendarActivity extends Fragment {
    View view;
    DatabaseHelper databaseHelper;
    Cursor cursor;
    GoogleApiClient client;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Context context;
    String mQuery;
    private ArrayList<Item> mList = new ArrayList<Item>();
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        client = new GoogleApiClient.Builder(context).addApi(AppIndex.API).build();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    public void onCreateOptionsMenu(Menu menu) {
//        getActivity().getMenuInflater().inflate(R.menu.main, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView)
//                MenuItemCompat.getActionView(searchItem);
//        searchView.setOnQueryTextListener(
//                new SearchView.OnQueryTextListener() {
//
//                    @Override
//                    public boolean onQueryTextSubmit(String query) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onQueryTextChange(String newText) {
//                        mQuery = newText.toLowerCase();
//                        doFilter(mQuery);
//                        return true;
//                    }
//                });
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_calendar, container, false);
        context = getContext();
        TextView yLabel = (TextView) view.findViewById(R.id.yLabel);
        TextView mLabel = (TextView) view.findViewById(R.id.mLabel);
        TextView dLabel = (TextView) view.findViewById(R.id.dLabel);
        TextView eLabel = (TextView) view.findViewById(R.id.eLabel);
        TextView keg = (TextView) view.findViewById(R.id.keg);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MMMM/d/E", Locale.US); // Set your locale!
        String strDate = sdf.format(cal.getTime());

        String[] values = strDate.split("/", 0);

        // Confirm
        //        for (int i = 0; i < values.length; i++) {
        //            Log.v("CHECK_DATE", values[i]);
        //        }

        yLabel.setText(values[0]);
        mLabel.setText(values[1]);
        dLabel.setText(values[2]);
        eLabel.setText(values[3]);
        setHasOptionsMenu(true);
        return view;
    }

    //Load Database
    private void loadData() {
        databaseHelper = new DatabaseHelper(context, "reminder", null, 1);
        databaseHelper.checkAndCopyDatabase();
        databaseHelper.openDatabase();
        cursor = databaseHelper.QueryData("select * from kegiatan");
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Item item = new Item();
                    item.setROW_NAMAKEG(cursor.getString(1));
                    mList.add(item);

                } while (cursor.moveToNext());
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onBackPressed() {
    }

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("CalendarActivity Page")
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


}