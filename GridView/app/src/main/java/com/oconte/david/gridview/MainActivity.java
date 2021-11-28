package com.oconte.david.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.gridView = (GridView)findViewById(R.id.gridView);

        WebSite o7planning = new WebSite("o7planning","http://o7planning.org");
        WebSite google = new WebSite("Google","http://google.com");
        WebSite facebook = new WebSite("Facebook","http://facebook.com");
        WebSite eclipse = new WebSite("Eclipse","http://eclipse.org");
        WebSite yahoo = new WebSite("Yahoo","http://yahoo.com");

        WebSite[] webSites = new WebSite[] {o7planning, google, facebook, eclipse, yahoo};

        // android.R.layout.simple_list_item_1 is a constant predefined layout of Android.
        // used to create a GridView with simple GridItem (Only one TextView).

        ArrayAdapter<WebSite> arrayAdapter
                = new ArrayAdapter<WebSite>(this, android.R.layout.simple_list_item_1 , webSites);


        gridView.setAdapter(arrayAdapter);

        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                WebSite website = (WebSite) o;
                Toast.makeText(MainActivity.this, "Selected :" + " " + website.getName()+"\n("+ website.getUrl()+")",
                        Toast.LENGTH_LONG).show();
            }
        });

    }


}