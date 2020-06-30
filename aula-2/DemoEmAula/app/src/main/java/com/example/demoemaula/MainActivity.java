package com.example.demoemaula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnDigitaNotas;
    private EditText txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnDigitaNotas = (Button) findViewById(R.id.btnDigiteNotas);
        btnDigitaNotas.setOnClickListener(new EscutadorBotaoDigitaNotas());
    }

    private class EscutadorBotaoDigitaNotas implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), NotasActivity.class);
            startActivity(i);
        }
    }
}
