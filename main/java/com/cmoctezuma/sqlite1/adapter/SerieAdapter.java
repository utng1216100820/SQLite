package com.own.sqlite1.adapter;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.own.sqlite1.R;
import com.own.sqlite1.model.Anime;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter <AnimeAdapter.AnimeViewHolder> implements View.OnClickListener {
    List<Anime> animes;
    View.OnClickListener listener;

    //Constructor
    public AnimeAdapter(List<Anime> animes){
        this.animes = animes;
    }

    //getter and setter de listener
    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.anime_cell_layout,parent,false);
        AnimeViewHolder holder=new AnimeViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(AnimeViewHolder holder, int position) {
        holder.txvName.setText(animes.get(position).getName());
        holder.txvCreator.setText(animes.get(position).getCreator());
        holder.txvGender.setText(animes.get(position).getGender());
        holder.txvYear.setText(animes.get(position).getYear());
        holder.txvChapters.setText(animes.get(position).getChapters());
        holder.setListener(this);
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public static class AnimeViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        CardView crvAnime;
        TextView txvName;
        TextView txvCreator;
        TextView txvGender;
        TextView txvYear;
        TextView txvChapters;
        ImageButton btnEdit;
        ImageButton btnDelete;
        View.OnClickListener listener;

        public AnimeViewHolder(View itemView) {
            super(itemView);
            crvAnime = (CardView) itemView.findViewById(R.id.crv_anime);
            txvName = (TextView) itemView.findViewById(R.id.txv_name);
            txvCreator = (TextView) itemView.findViewById(R.id.txv_creator);
            txvGender = (TextView) itemView.findViewById(R.id.txv_gender);
            txvYear = (TextView) itemView.findViewById(R.id.txv_year);
            txvChapters = (TextView) itemView.findViewById(R.id.txv_chapters);
            btnEdit = (ImageButton) itemView.findViewById(R.id.btn_edit);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btn_delete);

            btnEdit.setOnClickListener(this);
            btnDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener!=null){
                listener.onClick(v);
            }
        }

        public void setListener(View.OnClickListener listener){
            this.listener=listener;
        }
    }
}//End
