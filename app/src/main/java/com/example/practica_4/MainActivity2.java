package com.example.practica_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.provider.MediaStore;
import android.util.Log;
import android.net.Uri;


public class MainActivity2 extends AppCompatActivity {
    private final static String URL_Google = "https://www.google.com";
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 1);
                }
            }
        });
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FBintent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse("fb://profile/100093466083294"));
                    startActivity(FBintent);
            }
        });
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, "Texto a enviar");
                i.setPackage("com.whatsapp"); // Abre WhatsApp
                startActivity(i);
            }
        });
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     Intent i = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse("sms:1234567890"));
                        i.putExtra("sms_body", "Texto a enviar");
                        startActivity(i);

            }
        });
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:48.8588443,2.2943506?q=Torre+Eiffel");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                startActivity(mapIntent);
            }
        });
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(URL_Google));
                startActivity(i);
            }
        });
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL, android.net.Uri.parse("tel:+1234567890"));
                startActivity(i);
            }
        });


        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleriaIntent = new Intent(Intent.ACTION_VIEW);
                galleriaIntent.setDataAndType(Uri.parse("content://media/external/images/media/1"), "image/*");
                startActivity(galleriaIntent);
            }
        });

    }
}


