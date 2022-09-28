package com.bayzidhimel.firebaseauth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Club extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        btn1=findViewById(R.id.club1);
        btn2=findViewById(R.id.club2);
        btn3=findViewById(R.id.idToastMaster);
        btn4=findViewById(R.id.idenvironment);
        btn5=findViewById(R.id.idfootBallballClub);
        btn6=findViewById(R.id.idhrm);
        btn7=findViewById(R.id.idDance);
        btn8=findViewById(R.id.idEsports);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Club.this,"this is club1",Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Club.this,"this is club1",Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Club.this,"this is club1",Toast.LENGTH_SHORT).show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Club.this,"this is club1",Toast.LENGTH_SHORT).show();
            }
        });
    }
}