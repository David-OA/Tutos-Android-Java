package com.oconte.david.testapirest;

import android.database.Observable;

import com.oconte.david.testapirest.Models.NewYorkTimeArticle;
import com.oconte.david.testapirest.Models.NewYorkTimeInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NewYorkTimeService {

    @GET("articles/{article}/v2")
    Observable<List<NewYorkTimeArticle>> getFollowing(@Path("article") String username);

    @GET("/articles/{article}")
    Observable<NewYorkTimeInfo> getUserInfos(@Path("article") String username);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/topstories/v2/science.json?api-key=l0bvAgiwuO57HwCfWGjBaEMWqjUdAMoG")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    /*@GET("https://api.nytimes.com/svc/topstories/v2/science/{article}.json?api-key=l0bvAgiwuO57HwCfWGjBaEMWqjUdAMoG")
    static Call<List<NewYorkTime>> getFollowing(@Path("article") String article) {
        return null;
    }

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/topstories/v2/science.json?api-key=l0bvAgiwuO57HwCfWGjBaEMWqjUdAMoG")
            .addConverterFactory(GsonConverterFactory.create())
            .build();*/
}
