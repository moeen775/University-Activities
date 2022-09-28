package com.bayzidhimel.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bayzidhimel.firebaseauth.Schools.ScgoolDestails;

public class Home extends AppCompatActivity {

    Button btniub,btnIras,btnbook,btngroup,btnfreecourse,btnschool,btnClub,btncalculator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btniub=findViewById(R.id.iubewb);
        btnIras=findViewById(R.id.idIras);
        btnbook=findViewById(R.id.BOOK_Asset);
        btngroup=findViewById(R.id.idfbgroup);
        btnfreecourse=findViewById(R.id.freecourse);
        btnschool=findViewById(R.id.Schools);
        btnClub=findViewById(R.id.Clubs);
        btncalculator=findViewById(R.id.calculator);


        btniub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),iubWEBView.class));
            }
        });
        btnIras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),iras.class));

            }
        });
        btnschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ScgoolDestails.class));


            }
        });
        btngroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),IUBGroup.class));
                finish();

            }
        });
        btnClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Club.class));

            }
        });
        btncalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),cgpaCalculator.class));

            }
        });
        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnfreecourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }
}