package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.adapter.DafkegiatanAdapter;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.model.DafKegiatan;

public class DafkegRecycler extends AppCompatActivity {

    ArrayList<DafKegiatan> mList = new ArrayList<>();
    DafkegiatanAdapter mAdapter;
    private RecyclerView recyclerView;
    private DatabaseHelper databaseHelper;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dafkeg_recycler);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new DafkegiatanAdapter(mList);
        recyclerView.setAdapter(mAdapter);

        //loadDatabase();


    }

    private void loadDatabase() {
        databaseHelper = new DatabaseHelper(getParent());
        databaseHelper.checkAndCopyDatabase();
        databaseHelper.openDatabase();
        cursor = databaseHelper.QueryData("select * from kegiatan");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.drawer_layout) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /*private void fillDaftarKegiatan() {
        Resources resources = getResources();
        String[] arNamaKegiatan = resources.getStringArray(R.array.namakegiatan);
        String[] arKet = resources.getStringArray(R.array.keterangan);

        for (int i = 0; i < arNamaKegiatan.length; i++) {
            mList.add(new DafKegiatan(arNamaKegiatan[i], arKet[i]));
        }
        mAdapter.notifyDataSetChanged();

    }*/

}