package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.R;
import id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder.model.Storage;

/**
 * Created by Vistapram on 2016-11-02.
 */

public class StorageAdapter extends RecyclerView.Adapter<StorageAdapter.ViewHolder>{
    ArrayList<Storage> hotelList;

    public StorageAdapter(ArrayList<Storage> hotelList)
    {
        this.hotelList = hotelList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Storage hotel = hotelList.get(position);
        holder.tvJudul.setText(hotel.judul);
        holder.tvDeskripsi.setText(hotel.deskripsi);
        holder.ivFoto.setImageDrawable(hotel.foto);
    }

    @Override
    public int getItemCount() {
        if(hotelList!=null)
            return hotelList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;
        public ViewHolder(View itemView) {
            super(itemView);
            //      ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            //    tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
        }
    }
}