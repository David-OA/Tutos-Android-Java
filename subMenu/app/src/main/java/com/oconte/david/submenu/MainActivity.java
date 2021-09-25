package com.oconte.david.submenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Méthode qui se déclenchera lorsque vous appuierez sur le bouton menu du téléphone
    public boolean onCreateOptionsMenu(Menu menu) {

        //Création d'un MenuInflater qui va permettre d'instancier un Menu XML en un objet Menu
        MenuInflater inflater = getMenuInflater();
        //Instanciation du menu XML spécifier en un objet Menu
        inflater.inflate(R.menu.menu, menu);

        //Il n'est pas possible de modifier l'icône d'en-tête du sous-menu via le fichier XML on le fait donc en JAVA
        //menu.getItem(0).getSubMenu().setHeaderIcon(R.drawable.option_white);

        return true;
    }

    //Méthode qui se déclenchera au clic sur un item
    public boolean onOptionsItemSelected(MenuItem item) {
        //On regarde quel item a été cliqué grâce à son id et on déclenche une action
        switch (item.getItemId()) {
            case R.id.option:
                Toast.makeText(MainActivity.this, "Option", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.favoris:
                Toast.makeText(MainActivity.this, "Favoris", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.stats:
                Toast.makeText(MainActivity.this, "Stats", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.quitter:
                //Pour fermer l'application il suffit de faire finish()
                finish();
                return true;
        }
        return false;}
}