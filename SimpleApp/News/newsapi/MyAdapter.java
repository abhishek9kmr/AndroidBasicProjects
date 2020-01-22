package com.example.abhishekkumar.newsapi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Abhishek Kumar on 12/31/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<ListItem>arrayList1;
    private Context context;

    public MyAdapter(ArrayList<ListItem> arrayList1, Context context) {
        this.arrayList1 = arrayList1;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final ListItem listItem=arrayList1.get(i);
        viewHolder.title.setText(listItem.getTitle());
        viewHolder.description.setText(listItem.getDescription());
        String urlWeb=listItem.getUrlWeb();
        Picasso.get().load(String.valueOf(listItem.getUrl())).into(viewHolder.imageView);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(context,DetailActivity.class);
                in.putExtra("POSITION",i);
                in.putExtra("IMAGE",listItem.getUrl());
                in.putExtra("TITLE",listItem.getTitle());
                in.putExtra("DESCRIPTION",listItem.getDescription());
                in.putExtra("URLWEB",listItem.getUrlWeb());
                //SINCE NOT PASSED DIRECTLY THROUGH ACTIVITY
                view.getContext().startActivity(in);



            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView title;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
            title=(TextView)itemView.findViewById(R.id.title);
            description=(TextView)itemView.findViewById(R.id.description);
        }
    }
}
