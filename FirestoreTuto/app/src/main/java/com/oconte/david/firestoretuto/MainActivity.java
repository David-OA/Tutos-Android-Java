package com.oconte.david.firestoretuto;

import static android.content.ContentValues.TAG;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.oconte.david.firestoretuto.databinding.ActivityMainBinding;

import java.util.Objects;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference collectionReference = db.collection("restaurants");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
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

                            binding.click.setBackgroundColor(Color.GREEN);

                        }
                    }
                });
    }

    public void takeData() {
        binding.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                collectionReference.document("qW5cKz12j6z3eawymJ3d").collection("liked")
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                binding.click.setBackgroundColor(Color.BLUE);
                                Restaurant restaurant = null;
                                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                                    Log.d(TAG, documentSnapshot.getId() + " => " + documentSnapshot.getData());

                                    restaurant = documentSnapshot.toObject(Restaurant.class);

                                }

                                String userName = Objects.requireNonNull(restaurant).getUserName();
                                String idUser = restaurant.getIdUser();
                                String urlPhoto = restaurant.getUrlPhoto();

                                binding.userName.setText(userName);
                                binding.idUser.setText(idUser);
                                binding.urlPhoto.setText(urlPhoto);

                            }
                        });
            }
        });
    }

    public void addData() {
        binding.click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String userName = binding.addUsername.getText().toString();
                    String idUser = binding.addIdUser.getText().toString();
                    String urlPhoto = binding.addUrlPhoto.getText().toString();

                    //je crée un new Restaurant avec les info saisies.
                    Restaurant restaurant = new Restaurant(urlPhoto,userName,idUser);

                    // j'ajoute un document ds une collection liked et je specifie le non du document ici l'idUser saisi ds l'éditexte
                    collectionReference.document("qW5cKz12j6z3eawymJ3d")
                            .collection("liked").document(idUser).set(restaurant, SetOptions.merge());

            }
        });
    }


}