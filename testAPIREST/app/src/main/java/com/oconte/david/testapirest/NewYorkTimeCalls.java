package com.oconte.david.testapirest;

import android.support.annotation.Nullable;

import com.oconte.david.testapirest.AsyncTask.NewYorkTime;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewYorkTimeCalls {
    // 1 - Creating a callback
    public interface Callbacks {
        void onResponse(@Nullable List<NewYorkTime> article);
        void onFailure();
    }

    // 2 - Public method to start fetching
    public static void fetchUserFollowing(Callbacks callbacks, String article){

        // 2.1 - Create a weak reference to callback
        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

        // 2.2 - Get a Retrofit instance and the related endpoints
        NewYorkTime newYorkTimeService = NewYorkTimeService.retrofit.create(NewYorkTime.class);

        // 2.3 - Create the call
        Call<List<NewYorkTime>> call = NewYorkTimeService.getFollowing(article);
        // 2.4 - Start the call
        call.enqueue(new Callback<List<NewYorkTime>>() {

            @Override
            public void onResponse(Call<List<NewYorkTime>> call, Response<List<NewYorkTime>> response) {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<NewYorkTime>> call, Throwable t) {
                // 2.5 - Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }
}
