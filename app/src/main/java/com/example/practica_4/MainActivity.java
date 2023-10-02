package com.example.practica_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    TextView mTextField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextField = (TextView)findViewById(R.id.mTextField);

        new CountDownTimer(5000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
               mTextField.setText("Segundos restantes: " + millisUntilFinished / 1000);
            }
            @Override
            public void onFinish() {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i);
            }
        }.start();
        }
}

