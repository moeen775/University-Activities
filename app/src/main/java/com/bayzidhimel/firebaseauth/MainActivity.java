package com.bayzidhimel.firebaseauth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    TextView fullname,emailaddress,phoneNumber;
    ImageView profileImg;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullname=findViewById(R.id.fullname);
        emailaddress=findViewById(R.id.emailAddress);
        phoneNumber=findViewById(R.id.phoneNumber);
        profileImg=findViewById(R.id.profileimage);
        bottomNavigationView=findViewById(R.id.idbottomNavigation);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();

        userId=fAuth.getCurrentUser().getUid();

        DocumentReference documentReference =fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                phoneNumber.setText(value.getString("phone"));
                emailaddress.setText(value.getString("email"));
                fullname.setText(value.getString("fname"));
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        finish();
                    case R.id.dashboard:
                        Toast.makeText(MainActivity.this,"Dashboard",Toast.LENGTH_LONG).show();
                    case R.id.search:
                        Toast.makeText(MainActivity.this,"Search",Toast.LENGTH_LONG).show();
                    case R.id.profile:
                        Toast.makeText(MainActivity.this,"Profile",Toast.LENGTH_LONG).show();

                }
                return false;
            }
        });

    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));

    }
}