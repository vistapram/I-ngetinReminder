package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.adapter;

import android.app.Activity;
import android.content.Context;
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
 * Created by SMK Telkom SP Malang on 11/20/2016.
 */

public class MainContentAdapter extends RecyclerView.Adapter<MainContentAdapter.ViewHolder> {

    IHotelAdapter mIHotelAdapter;
    List<Item> kegiatanList = Collections.emptyList();
    Context contex;
    private Activity activity;

    public MainContentAdapter(Activity activity, List<Item> kegiatanList) {
        this.activity = activity;
        this.kegiatanList = kegiatanList;
        mIHotelAdapter = (IHotelAdapter) contex;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvNamaKegiatan.setText(kegiatanList.get(position).getROW_NAMAKEG());
        holder.tvKeterangan.setText(kegiatanList.get(position).getROW_KET());
    }

    @Override
    public int getItemCount() {
        return kegiatanList.size();
    }

    public interface IHotelAdapter {
        void doClick(int pos);

        void doEdit(int pos);

        void doDelete(int pos);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaKegiatan;
        TextView tvKeterangan;

        public ViewHolder(View itemView) {
            super(itemView);

            tvNamaKegiatan = (TextView) itemView.findViewById(R.id.textVNamaKegiatan);
            tvKeterangan = (TextView) itemView.findViewById(R.id.textVKeterangan);

            itemView.findViewById(R.id.buttonEdit).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIHotelAdapter.doEdit(getAdapterPosition());
                }
            });

            itemView.findViewById(R.id.buttonDelete).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIHotelAdapter.doDelete(getAdapterPosition());
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIHotelAdapter.doClick(getAdapterPosition());
                }
            });

        }
    }
}
