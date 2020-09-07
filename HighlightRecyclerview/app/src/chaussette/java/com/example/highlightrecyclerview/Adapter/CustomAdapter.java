package com.example.highlightrecyclerview.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.highlightrecyclerview.Common.Common;
import com.example.highlightrecyclerview.Interface.ItemClickListener;
import com.example.highlightrecyclerview.Model.Item;
import com.example.highlightrecyclerview.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView textView;
    public ImageView imageView;

    ItemClickListener itemClickListener;

    int row_index = -1; // Default no row choose.

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        textView = (TextView)itemView.findViewById(R.id.text_view);
        imageView = (ImageView)itemView.findViewById(R.id.image_view);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition());

    }
}

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder>{

    List<Item> items;
    Context context;

    int row_index = -1; // Default no row choose.

    public CustomAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.layout_item, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.textView.setText(items.get(position).getName());
        if (!items.get(position).isChecked())
            holder.imageView.setImageResource(R.drawable.ic_clear_black_24dp);
        else
            holder.imageView.setImageResource(R.drawable.ic_check_black_24dp);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                row_index = position;
                Common.currentItem = items.get(position);
                notifyDataSetChanged();
            }
        });

        // Set highlight color
        if (row_index==position){
            holder.itemView.setBackgroundColor(Color.parseColor("#e53610"));
            holder.textView.setTextColor(Color.parseColor("#e5c410"));
        }
        else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#6ae510"));
            holder.textView.setTextColor(Color.parseColor("#10e5ce"));
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
