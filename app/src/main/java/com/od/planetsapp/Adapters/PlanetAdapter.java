package com.od.planetsapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.od.planetsapp.Models.PlanetModel;
import com.od.planetsapp.databinding.RowPlanetBinding;
import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<PlanetModel> planetList;

    public PlanetAdapter(Context context, ArrayList<PlanetModel> planetList) {
        this.context = context;
        this.planetList = planetList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(RowPlanetBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        PlanetModel planet = planetList.get(i);
        viewHolder.binding.textViewPlanetName.setText(planet.getName());
        Glide.with(context)
             .load(planet.getImgSrc().get(0).getImg())
             .into(viewHolder.binding.imageViewPlanet);
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private RowPlanetBinding binding;

        public ViewHolder(RowPlanetBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}