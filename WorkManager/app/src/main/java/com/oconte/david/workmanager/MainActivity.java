package com.oconte.david.workmanager;

import android.arch.lifecycle.Observer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);


        Data data = new Data.Builder()
                .putString(MyWorker.EXTRA_TITLE, "Message from Activity!")
                .putString(MyWorker.EXTRA_TEXT, "Hi! I have come from activity.")
                .build();

        // Adding Constraints
        /*Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiresDeviceIdle(true)
                .build();
        */

        /*final PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWorker.class, 12, TimeUnit.HOURS)
                .addTag("periodic_work")
                .build();
        */

        //This is the subclass of our WorkRequest
        final OneTimeWorkRequest simpleRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInputData(data)
                //.setConstraints(constraints)
                .build();

        findViewById(R.id.simpleWorkButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkManager.getInstance().enqueue(simpleRequest);
                //WorkManager.getInstance().enqueue(periodicWorkRequest);

            }
        });


        WorkManager.getInstance().getStatusById(simpleRequest.getId())
                .observe(this, new Observer<WorkStatus>() {
                    @Override
                    public void onChanged(@Nullable WorkStatus workStatus) {
                        if (workStatus != null) {
                            mTextView.append("SimpleWorkRequest: " + workStatus.getState().name() + "\n");
                        }

                        if (workStatus != null && workStatus.getState().isFinished()) {
                            String message = workStatus.getOutputData().getString(MyWorker.EXTRA_OUTPUT_MESSAGE, "Default message");
                            mTextView.append("SimpleWorkRequest (Data): " + message);
                        }
                    }
                });


    }
}
