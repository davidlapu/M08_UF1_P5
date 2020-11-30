package cat.itb.m08_uf1_p5.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import cat.itb.m08_uf1_p5.R;

import cat.itb.m08_uf1_p5.database.Puntuacio;

public class PuntuacioAdapter extends RecyclerView.Adapter<PuntuacioAdapter.PuntuacioViewHolder> {
    private List<Puntuacio> puntuacioList;

    public PuntuacioAdapter(List<Puntuacio> puntuacioList) {
        this.puntuacioList = puntuacioList;
    }

    static class PuntuacioViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewPuntuacio;


        public PuntuacioViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPuntuacio = itemView.findViewById(R.id.textViewPuntiacio);
        }

        public void bind(Puntuacio puntuacio) {
            textViewName.setText(puntuacio.getUserName());
            textViewPuntuacio.setText(String.valueOf(puntuacio.getPuntuacio()));
        }
    }

    @NonNull
    @Override
    public PuntuacioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.puntuacio_item_list, parent, false);

        return new PuntuacioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PuntuacioViewHolder holder, int position) {
        Puntuacio puntuacio = puntuacioList.get(position);
        holder.bind(puntuacio);
    }

    @Override
    public int getItemCount() {
        return puntuacioList.size();
    }

}
