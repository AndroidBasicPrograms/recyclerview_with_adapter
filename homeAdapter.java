package com.example.jayhind.meditationapp.Adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jayhind.meditationapp.Model.homeModel;
import com.example.jayhind.meditationapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Jay Hind on 6/11/2018.
 */

public class homeAdapter extends RecyclerView.Adapter<homeAdapter.homeHolder> {
    ArrayList<homeModel> hModel;
    homeListener listener;

    public homeAdapter(ArrayList<homeModel> hModel, homeListener listener) {
        this.hModel = hModel;
        this.listener = listener;
    }

    @Override
    public homeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_row,parent,false);
        homeHolder h=new homeHolder(view);
        return h;
    }

    @Override
    public void onBindViewHolder(homeHolder holder, int position) {
    final homeModel h=hModel.get(position);
        Picasso.get().load(h.getImageUrl().toString()).into(holder.img);
        holder.tv.setText(h.getTopic());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onUserClick(h);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hModel.size();
    }

    public class homeHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView tv;
        View view;
        public homeHolder(View itemView) {
            super(itemView);
            view=itemView;
            img=itemView.findViewById(R.id.card_view_image);
            tv=itemView.findViewById(R.id.card_view_image_title);
        }
    }

    public interface homeListener
    {
        public void onUserClick(homeModel hModel);
    }
}
