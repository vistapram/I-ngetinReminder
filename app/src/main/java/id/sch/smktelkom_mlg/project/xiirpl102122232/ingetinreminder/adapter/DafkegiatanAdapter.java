package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.R;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.model.Item;

/**
 * Created by Naufal Ramaputra on 13/11/2016.
 */

public class DafkegiatanAdapter extends RecyclerView.Adapter<DafkegiatanAdapter.ViewHolder> {

    List<Item> kegiatanList = Collections.emptyList();
    private Activity activity;

    public DafkegiatanAdapter(Activity activity, List<Item> kegiatanList) {
        this.activity = activity;
        this.kegiatanList = kegiatanList;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dafkeg_item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tvNamaKegiatan.setText(kegiatanList.get(position).getROW_NAMAKEG());
        holder.tvKeterangan.setText(kegiatanList.get(position).getROW_KET());

    }

    @Override
    public int getItemCount() {
        return kegiatanList.size();
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
