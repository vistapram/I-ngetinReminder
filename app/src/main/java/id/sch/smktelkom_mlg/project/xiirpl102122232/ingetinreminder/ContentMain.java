package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.adapter.MainContentAdapter;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.model.Item;

public class ContentMain extends Fragment {
    Context context;
    View v;
    private ArrayList<Item> mList = new ArrayList<Item>();
    private MainContentAdapter mAdapter;
    private DatabaseHelper databaseHelper;
    private Cursor cursor;
    private FloatingActionButton fab;
    private GoogleApiClient client;


    public void loadDatabase() {
        databaseHelper = new DatabaseHelper(context, "reminder", null, 1);
        databaseHelper.checkAndCopyDatabase();
        databaseHelper.openDatabase();
        cursor = databaseHelper.QueryData("select * from kegiatan");

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Item item = new Item();
                    item.setROW_NAMAKEG(cursor.getString(1));
                    item.setROW_KET(cursor.getString(5));
                    mList.add(item);

                } while (cursor.moveToNext());
            }
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Kegiatan Hari ini");

        loadDatabase();
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewContent);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MainContentAdapter(getActivity().getParent(), mList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);

        client = new GoogleApiClient.Builder(context).addApi(AppIndex.API).build();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.content_main);

//        getActivity().setTitle("Kegiatan Hari ini");

//        loadDatabase();
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewContent);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
//        recyclerView.setLayoutManager(layoutManager);
//        mAdapter = new MainContentAdapter(getActivity().getParent(), mList);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(mAdapter);
//
//        client = new GoogleApiClient.Builder(context).addApi(AppIndex.API).build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.content_main, container, false);
        context = v.getContext();
        return v;

    }

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ContentMain Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
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
