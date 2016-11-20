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
 * Created by Vistapram on 2016-11-20.
 */
public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {
    List<Item> KegList = Collections.emptyList();
    private Activity activity;
    public CalendarAdapter(Activity activity, List<Item> kegiatanList) {
        this.activity = activity;
        this.KegList = kegiatanList;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dafkeg_item_list, parent, false);
        CalendarAdapter.ViewHolder vh = new CalendarAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.Keg.setText(KegList.get(position).getROW_NAMAKEG());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Keg;

        public ViewHolder(View itemView) {
            super(itemView);

            Keg = (TextView) itemView.findViewById(R.id.keg);

        }
    }
}
