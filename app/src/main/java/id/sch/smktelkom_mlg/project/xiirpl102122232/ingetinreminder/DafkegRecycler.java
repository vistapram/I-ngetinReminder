package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.adapter.DafkegiatanAdapter;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.model.Item;

public class DafkegRecycler extends AppCompatActivity {

    Context myContext;
    private ArrayList<Item> mList = new ArrayList<Item>();
    private DafkegiatanAdapter mAdapter;
    private DatabaseHelper databaseHelper;
    private Cursor cursor;

    private GoogleApiClient client;


    private void loadDatabase() {
        databaseHelper = new DatabaseHelper(this, "reminder", null, 1);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dafkeg_recycler);

        setTitle("Daftar Kegiatan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        loadDatabase();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new DafkegiatanAdapter(getParent(), mList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("DafkegRecycler Page") // TODO: Define a title for the content shown.
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