package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.Fragments;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.R;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.adapter.StorageAdapter;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.model.Storage;

public class StorageActivity extends Fragment {
    ArrayList<Storage> mList = new ArrayList<>();
    StorageAdapter mAdapter;
    View view;
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_storage,container,false);
        context = getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new StorageAdapter(mList);
        recyclerView.setAdapter(mAdapter);
        fillData();
        return view;
    }

    private void fillData() {
        Resources resources = getResources();
        String [] arJudul = resources.getStringArray(R.array.namakegiatan);
        String [] arDeskripsi = resources.getStringArray(R.array.keterangan);
        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
        Drawable[] arFoto = new Drawable[a.length()];
        for (int i = 0; i < arFoto.length ; i ++)
        {
            BitmapDrawable bd = (BitmapDrawable) a.getDrawable(i);
            RoundedBitmapDrawable rbd = RoundedBitmapDrawableFactory.create(getResources(),bd.getBitmap());
            rbd.setCircular(true);
            arFoto[i] = rbd;
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++)
        {
            mList.add(new Storage(arJudul[i],arDeskripsi[i],arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }
}
