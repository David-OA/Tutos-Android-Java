package com.oconte.david.workmanager;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);


        Data data = new Data.Builder()
                .putString(MyWorker.EXTRA_TITLE, "Message from Activity!")
                .putString(MyWorker.EXTRA_TEXT, "Hi! I have come from activity.")
                .build();

        //This is the subclass of our WorkRequest
        final OneTimeWorkRequest simpleRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInputData(data)
                .build();

        findViewById(R.id.simpleWorkButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkManager.getInstance().enqueue(simpleRequest);
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
