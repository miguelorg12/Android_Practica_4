package com.example.practica_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.provider.MediaStore;

public class MainActivity2 extends AppCompatActivity {
    private  final static String URL_FB = "https://www.facebook.com/";
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });
        btn6 = (Button)findViewById(R.id.btn6);
        //Btn 6 - Abrir navegador - Intent implícito
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(android.net.Uri.parse(URL_FB));
                startActivity(i);
            }
        });
        btn7 = (Button)findViewById(R.id.btn7);
        //Btn 7 - Llamar - Intent implícito
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, android.net.Uri.parse("tel: 1234567890"));
                if(ActivityCompat.checkSelfPermission(MainActivity2.this, android.Manifest.permission.CALL_PHONE) != getPackageManager().PERMISSION_GRANTED)
                    return;
                startActivity(i);
            }
        });

        btn8 = (Button)findViewById(R.id.btn8);

    }
    //Btn 5 - Abrir cámara - Intent explícito
    private void abrirCamara() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(intent,1 );
        }
    }
}

