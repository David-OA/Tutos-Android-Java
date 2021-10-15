package com.oconte.david.firestoretuto;

import static android.content.ContentValues.TAG;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.click) ImageButton imageButton;
    @BindView(R.id.click2) ImageButton imageButton2;
    @BindView(R.id.UrlOhoto) TextView textView;
    @BindView(R.id.Username) TextView textView2;
    @BindView(R.id.idUser) TextView textView3;

    @BindView(R.id.addUsername) EditText editText;
    @BindView(R.id.addIdUser) EditText editText2;
    @BindView(R.id.addUrlOhoto) EditText editText3;

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference collectionReference = db.collection("restaurants");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        this.conditionButtonClick();

        this.takeData();

        this.addData();

    }

    public void conditionButtonClick() {
        collectionReference.document("qW5cKz12j6z3eawymJ3d").collection("liked")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        //si document n'est pas vide le boutton prend la couleur verte.
                        if (!queryDocumentSnapshots.isEmpty()) {

                            imageButton.setBackgroundColor(Color.GREEN);

                        }
                    }
                });
    }

    public void takeData() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                collectionReference.document("qW5cKz12j6z3eawymJ3d").collection("liked")
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                imageButton.setBackgroundColor(Color.BLUE);
                                Restaurant restaurant = null;
                                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                                    Log.d(TAG, documentSnapshot.getId() + " => " + documentSnapshot.getData());

                                    restaurant = documentSnapshot.toObject(Restaurant.class);

                                }

                                String userName = Objects.requireNonNull(restaurant).getUserName();
                                String idUser = restaurant.getIdUser();
                                String urlPhoto = restaurant.getUrlPhoto();

                                textView.setText(userName);
                                textView2.setText(idUser);
                                textView3.setText(urlPhoto);

                            }
                        });
            }
        });
    }

    public void addData() {
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String userName = editText.getText().toString();
                    String idUser = editText2.getText().toString();
                    String urlPhoto = editText3.getText().toString();

                    //je crée un new Restaurant avec les info saisies.
                    Restaurant restaurant = new Restaurant(urlPhoto,userName,idUser);

                    // j'ajoute un document ds une collection liked et je specifie le non du document ici l'idUser saisi ds l'éditexte
                    collectionReference.document("qW5cKz12j6z3eawymJ3d")
                            .collection("liked").document(idUser).set(restaurant, SetOptions.merge());

            }
        });
    }


}