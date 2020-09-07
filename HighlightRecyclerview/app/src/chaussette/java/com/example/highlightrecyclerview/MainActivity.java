package com.example.highlightrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.highlightrecyclerview.Adapter.CustomAdapter;
import com.example.highlightrecyclerview.Model.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView list_item;
    RecyclerView.LayoutManager layoutManager;
    List<Item> items = new ArrayList<>();
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewActivity.class));
            }
        });

        list_item = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        list_item.setHasFixedSize(true);
        list_item.setLayoutManager(layoutManager);
        
        getData();
    }

    private void getData() {
        //Generate data
        for (int i = 0; i<10; i++)
        {
            Item item = new Item();
            item.setName("Item" +i);
            if (i%2 == 0)
                item.setChecked(true);
            else
                item.setChecked(false);

            items.add(item);
        }

        //Create Adapter
        CustomAdapter adapter = new CustomAdapter(items, this);
        list_item.setAdapter(adapter);
    }
}
