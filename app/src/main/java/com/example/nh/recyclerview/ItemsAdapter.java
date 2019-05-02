package com.example.nh.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {
Item item;
Context context;
ArrayList<Item> items;


    public ItemsAdapter( Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout,viewGroup,false);

        MyViewHolder holder=new MyViewHolder(v);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.MyViewHolder myViewHolder, int i) {
        item=items.get(i);

        myViewHolder.name.setText(item.getName());
        myViewHolder.team.setText(item.getTeam());
        myViewHolder.createdby.setText(item.getCreatedby());
        myViewHolder.firstappearance.setText(item.getFirstappearance());
        myViewHolder.bio.setText(item.getBio());

        Picasso.with(context).load(item.getImage1()).into(myViewHolder.image1);

//        Picasso.with(getContext()).load(items.getImage()).into(imageView);



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,team,createdby,firstappearance,bio;
        ImageView image1;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            team=itemView.findViewById(R.id.team);
            createdby=itemView.findViewById(R.id.createdby);
            firstappearance=itemView.findViewById(R.id.firstappearance);
            bio=itemView.findViewById(R.id.bio);
            image1=itemView.findViewById(R.id.imag1);




        }
    }
}
