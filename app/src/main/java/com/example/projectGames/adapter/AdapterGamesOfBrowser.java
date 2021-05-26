package com.example.projectGames.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectGames.R;
import com.example.projectGames.Utils.CustomItemClick;
import com.example.projectGames.models.ListGamesBrowser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterGamesOfBrowser extends RecyclerView.Adapter<AdapterGamesOfBrowser.HolderBrowserGames> {

    private List<ListGamesBrowser> listGamesBrowsers;
    private final Context context;
    private CustomItemClick listener;

    public AdapterGamesOfBrowser(Context context, CustomItemClick listener) {
        this.context = context;
        this.listGamesBrowsers = new ArrayList<>();
        this.listener = listener;

    }

    @NonNull
    @Override
    public HolderBrowserGames onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.holderbrowsergames, parent, false);
        return new HolderBrowserGames(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderBrowserGames holder, int position) {

        ListGamesBrowser listGamesBrowser = listGamesBrowsers.get(position);

        Picasso.get().load(listGamesBrowser.getThumbnail()).into(holder.myPhoto);
        holder.tvTitle.setText(String.valueOf(listGamesBrowser.getTitle()));
        holder.tvDeveloper.setText(listGamesBrowser.getDeveloper());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listGamesBrowsers.size();
    }


    static class HolderBrowserGames extends RecyclerView.ViewHolder {


        private final ImageView myPhoto;
        private final TextView tvTitle;
        private final TextView tvDeveloper;

        public HolderBrowserGames(@NonNull View v) {
            super(v);

            myPhoto = v.findViewById(R.id.myPhoto);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvDeveloper = v.findViewById(R.id.tvDeveloper);
        }
    }

    public void setList(List<ListGamesBrowser> list) {
        this.listGamesBrowsers = list;
        notifyDataSetChanged();
    }
}
