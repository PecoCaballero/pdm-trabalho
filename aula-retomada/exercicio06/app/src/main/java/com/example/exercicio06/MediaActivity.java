package com.example.exercicio06;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MediaActivity extends AppCompatActivity {



    private TextView lblNome;
    private TextView lblNota1;
    private TextView lblNota2;
    private TextView lblMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        lblNome = (TextView) findViewById(R.id.lblNome);
        lblNota1 = (TextView) findViewById(R.id.lblNota1);
        lblNota2 = (TextView) findViewById(R.id.lblNota2);
        lblMedia = (TextView) findViewById(R.id.lblMedia);

        Intent i = getIntent();

        lblNome.setText(i.getStringExtra("nome"));
        lblNota1.setText(i.getStringExtra("nota1"));
        lblNota2.setText(i.getStringExtra("nota2"));
        lblMedia.setText(Double.toString(i.getDoubleExtra("media", 0.0)));

    }


}
