package com.example.highlightrecyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.highlightrecyclerview.Common.Common;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    public ImageView imageView;
    public TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_item);

        textView = (TextView)findViewById(R.id.text_view);
        imageView = (ImageView)findViewById(R.id.image_view);

        textView.setText(Common.currentItem.getName());
        if (Common.currentItem.isChecked())
            imageView.setImageResource(R.drawable.ic_clear_black_24dp);
        else
            imageView.setImageResource(R.drawable.ic_check_black_24dp);
    }
}
