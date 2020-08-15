package com.example.pdmtrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnLogin.setOnClickListener(new EscutadorLogin());
        btnCadastrar.setOnClickListener(new EscutadorCadastro());
    }

    class EscutadorLogin implements View.OnClickListener {

        @Override
        public void onClick(View view){
            Intent homeScreen = new Intent(getApplicationContext(), HomeScreen.class);
            startActivity(homeScreen);
        }

    }

    class EscutadorCadastro implements  View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent cadastroScreen = new Intent(getApplicationContext(), CadastroActivity.class);
            startActivity(cadastroScreen);
        }
    }


}
