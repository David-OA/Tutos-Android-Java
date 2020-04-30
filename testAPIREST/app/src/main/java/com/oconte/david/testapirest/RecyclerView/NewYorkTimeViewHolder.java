package com.oconte.david.testapirest.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.oconte.david.testapirest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewYorkTimeViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.recycler_view_item_title)
    TextView textView;

    public NewYorkTimeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        }

    //public void updateWithNewYorkTimeTitle(NewYorkTime newYorkTime){
      //  this.textView.setText(newYorkTime.getLogin());
       // }
}

