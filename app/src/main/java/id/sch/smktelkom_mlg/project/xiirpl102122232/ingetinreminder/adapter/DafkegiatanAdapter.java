package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.R;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.model.DafKegiatan;

/**
 * Created by Naufal Ramaputra on 13/11/2016.
 */

public class DafkegiatanAdapter extends RecyclerView.Adapter<DafkegiatanAdapter.ViewHolder> {

    ArrayList<DafKegiatan> kegiatanList;

    public DafkegiatanAdapter(ArrayList<DafKegiatan> kegiatanList) {
        this.kegiatanList = kegiatanList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_dafkeg_recycler, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DafKegiatan keg = kegiatanList.get(position);
        holder.tvNamaKegiatan.setText(keg.namakegiatan);
        holder.tvKeterangan.setText(keg.keterangan);

    }

    @Override
    public int getItemCount() {

       /* if (kegiatanList != null)
            return kegiatanList.size();*/
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaKegiatan;
        TextView tvKeterangan;

        public ViewHolder(View itemView) {
            super(itemView);

            tvNamaKegiatan = (TextView) itemView.findViewById(R.id.textViewNamaKegiatan);
            tvKeterangan = (TextView) itemView.findViewById(R.id.textViewKeterangan);

        }
    }

}
