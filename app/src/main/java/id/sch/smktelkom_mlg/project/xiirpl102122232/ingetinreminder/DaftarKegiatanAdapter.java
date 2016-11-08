package id.sch.smktelkom_mlg.project.xiirpl102122232.ingetinreminder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DaftarKegiatanAdapter extends RecyclerView.Adapter<DaftarKegiatanAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_daftarkegiatan, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Tv1;
        TextView Tv2;

        public ViewHolder(View itemView) {
            super(itemView);

            Tv1 = (TextView) itemView.findViewById(R.id.TvPertama);
            Tv2 = (TextView) itemView.findViewById(R.id.TvKedua);
        }
    }
}
