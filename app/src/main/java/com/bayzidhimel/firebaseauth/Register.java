package com.bayzidhimel.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Document;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class Register extends AppCompatActivity {
    EditText mfullname, mEmail, mpassword, mphone;
    TextView mregister, mlogin;
    FirebaseAuth fAuth;
    ProgressBar progressbar;

    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mfullname = findViewById(R.id.identerFullname);
        mEmail = findViewById(R.id.identerEmail);
        mpassword = findViewById(R.id.idEnterPassoword);
        mphone = findViewById(R.id.idphonenum);
        mregister = findViewById(R.id.idRegister1);
        mlogin = findViewById(R.id.idAlreadyregister);
        fAuth = FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();

        progressbar = findViewById(R.id.idProgessBar);



        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        mregister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();
                String fullName=mfullname.getText().toString();
                String phone = mphone.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Enter Email");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mpassword.setError("Enter passoword");
                    return;
                }

                if (password.length() < 6) {
                    mpassword.setError("Password Less than 6");
                    return;
                }
                progressbar.setVisibility(View.VISIBLE);
                //Register the user Firebase
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "Create User", Toast.LENGTH_LONG).show();
                            userID=fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String,Object> user=new HashMap<>();
                            user.put("fName",fullName);
                            user.put("email",email);
                            user.put("phone",phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG, "onSuccess: User Added Databse"+ userID);
                                }
                            });

                            startActivity(new Intent(getApplicationContext(), Login.class));

                        } else {
                            Toast.makeText(Register.this, "Error" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressbar.setVisibility(View.GONE);
                        }

                    }
                });

            }
        });

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });


    }
}