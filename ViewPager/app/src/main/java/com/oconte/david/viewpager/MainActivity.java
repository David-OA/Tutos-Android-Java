package com.oconte.david.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ScreenSlidePageFragment screenSlidePageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureAndShowScreenSlidePageFragment();
    }

    private void configureAndShowScreenSlidePageFragment() {

        screenSlidePageFragment = (ScreenSlidePageFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_main_activity);

        if (screenSlidePageFragment == null) {
            screenSlidePageFragment = new ScreenSlidePageFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_main_activity, screenSlidePageFragment)
                    .commit();
        }
    }
}
