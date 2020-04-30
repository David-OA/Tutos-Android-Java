package com.oconte.david.swipetest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class history extends AppCompatActivity {


    ListView mList_history_mood;

    ImageButton avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        mList_history_mood = (ListView) findViewById(R.id.list_history_mood);
        viewListModelMood();

    }

    private void viewListName(){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(history.this, android.R.layout.simple_list_item_1);
        mList_history_mood.setAdapter(adapter);
    }

    private List<ModelMood> genererModelMood(){
        List<ModelMood> ModelMoods = new ArrayList<ModelMood>();
        ModelMoods.add(new ModelMood("Il y a une semaine"));
        ModelMoods.add(new ModelMood("Il y a six jours"));
        ModelMoods.add(new ModelMood("Il y a cinq jours"));
        ModelMoods.add(new ModelMood("Il y a quatre jours"));
        ModelMoods.add(new ModelMood("Il y a trois jours"));
        ModelMoods.add(new ModelMood("Avant-hier"));
        ModelMoods.add(new ModelMood("Hier"));

        return ModelMoods;
    }

    private void viewListModelMood(){
        List<ModelMood> ModelMoods = genererModelMood();

        HistoryMoodAdapter adapter = new HistoryMoodAdapter(history.this, ModelMoods);
        mList_history_mood.setAdapter(adapter);
    }
}

