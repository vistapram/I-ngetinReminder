package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.adapter.DafkegiatanAdapter;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.model.DafKegiatan;

public class Recycler extends AppCompatActivity {

    ArrayList<DafKegiatan> mList = new ArrayList<>();
    DafkegiatanAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new DafkegiatanAdapter(mList);
        recyclerView.setAdapter(mAdapter);

        fillDaftarKegiatan();

    }

    private void fillDaftarKegiatan() {
        Resources resources = getResources();
        String[] arNamaKegiatan = resources.getStringArray(R.array.namakegiatan);
        String[] arKet = resources.getStringArray(R.array.keterangan);

        for (int i = 0; i < arNamaKegiatan.length; i++) {
            mList.add(new DafKegiatan(arNamaKegiatan[i], arKet[i]));
        }
        mAdapter.notifyDataSetChanged();

    }

}