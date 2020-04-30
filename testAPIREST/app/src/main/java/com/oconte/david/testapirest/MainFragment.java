package com.oconte.david.testapirest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oconte.david.testapirest.AsyncTask.NewYorkTime;
import com.oconte.david.testapirest.Models.NewYorkTimeArticle;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment implements NewYorkTime.Listeners, NewYorkTimeCalls.Callbacks{

    // FOR DESIGN
    // Declare RecyclerVIew
    @BindView(R.id.fragment_main_textview)
    //RecyclerView recyclerView;

    TextView textView;

    private List<NewYorkTime> newYorkTimeArticle;

    public MainFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    // -----------------
    // ACTIONS
    // -----------------

    @OnClick(R.id.fragment_main_button)
    public void submit(View view) {
        this.executeHttpRequestWhitRetrofit();
    }


    // ------------------
    //  HTTP REQUEST Retrofit
    // ------------------

    private void executeHttpRequestWhitRetrofit(){
        this.updateUIWhenStartingHTTPRequest(newYorkTimeArticle);
        NewYorkTimeCalls.fetchUserFollowing(this, "topstorie");
    }

    /*private void executeHttpRequest(){
        new NewYorkTime(this).execute("https://api.nytimes.com/svc/topstories/v2/science.json?api-key=l0bvAgiwuO57HwCfWGjBaEMWqjUdAMoG");
    }*/

    /*@Override
    public void onResponse(@Nullable List<NewYorkTimeArticle> ) {
        if (newYorkTimeArticle != null) this.updateUIWhenStartingHTTPRequest(newYorkTimeArticle);
    }*/

    @Override
    public void onResponse(@Nullable List<NewYorkTime> users) {

    }

    @Override
    public void onFailure(){
        this.updateUIWhenStopingHTTPRequest("An error happened !");
    }

    @Override
    public void onPreExecute() {
        this.updateUIWhenStartingHTTPRequest(newYorkTimeArticle);
    }

    @Override
    public void doInBackground() { }

    @Override
    public void onPostExecute(String json) {
        this.updateUIWhenStopingHTTPRequest(json);
    }

    // ------------------
    //  UPDATE UI
    // ------------------

    private void updateUIWhenStartingHTTPRequest(List<NewYorkTime> newYorkTimeArticle){
        this.textView.setText("Downloading...");
    }

    private void updateUIWhenStopingHTTPRequest(String response){
        this.textView.setText(response);
    }

    private void updateUIWhitListOfNewYorkTimeArticle(List<NewYorkTimeArticle> articles) {
        StringBuilder stringBuilder = new StringBuilder();
        for (NewYorkTimeArticle article : articles) {
            stringBuilder.append("-"+"");
        }
    }

}
