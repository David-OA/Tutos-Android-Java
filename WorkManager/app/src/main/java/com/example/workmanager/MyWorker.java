package com.example.workmanager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {


    //a public static string that will be used as the key
    //for sending and receiving data
    public static final String TASK_DESC = "task_desc";
    public static final String TASK_DESC2 = "task_desc2";

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    /*
     * This method is responsible for doing the work
     * so whatever work that is needed to be performed
     * we will put it here
     *
     * For example, here I am calling the method displayNotification()
     * It will display a notification
     * So that we will understand the work is executed
     */

    @NonNull
    @Override
    public Result doWork() {

        //getting the input data
        String taskDesc = getInputData().getString(TASK_DESC);

        String taskDesc2 = getInputData().getString(TASK_DESC2);

        displayNotification("My Worker", taskDesc, taskDesc2);

        //setting output data
        Data data = new Data.Builder()
                .putString(TASK_DESC, "The conclusion of the task")
                .putString(TASK_DESC2, "I add some data")
                .build();

        return Result.success(data);
    }

    /*
     * The method is doing nothing but only generating
     * a simple notification
     * If you are confused about it
     * you should check the Android Notification Tutorial
     */

    private void displayNotification(String title, String task, String tasky) {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("simplifiedcoding", "simplifiedcoding", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), "simplifiedcoding")
                .setContentTitle(title)
                .setContentText(task)
                .setContentText(tasky)
                .setSmallIcon(R.mipmap.ic_launcher);

        notificationManager.notify(1, notification.build());
    }
}
