package com.oconte.david.workmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is the subclass of our WorkRequest
        final OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class).build();

        //A click listener for the button
        //inside the onClick method we will perform the work
        findViewById(R.id.buttonEnqueue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Enqueuing the work request
                WorkManager.getInstance().enqueue(workRequest);
            }
        });
    }
}
