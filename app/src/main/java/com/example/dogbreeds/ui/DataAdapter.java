package com.example.dogbreeds.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogbreeds.R;
import com.example.dogbreeds.model.DataModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    Context context;
    ArrayList<DataModel> listaDatos;

    public DataAdapter() {
    }

    public void setData(@NonNull Context context, ArrayList<DataModel> listaDatos) {
        this.context = context;
        this.listaDatos = listaDatos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel lista = listaDatos.get(position);
        Picasso.get().load(lista.getBreed()).into(holder.imgVDog);
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgVDog;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgVDog = itemView.findViewById(R.id.imgVDog);
        }
    }
}
