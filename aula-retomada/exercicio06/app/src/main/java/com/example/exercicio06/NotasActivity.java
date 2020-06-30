package com.example.exercicio06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class NotasActivity extends AppCompatActivity {



    private EditText txtNota1;
    private EditText txtNota2;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        btnOk = (Button) findViewById(R.id.btnOk);
        txtNota1 = (EditText) findViewById(R.id.txtNota1);
        txtNota2 = (EditText) findViewById(R.id.txtNota2);

        btnOk.setOnClickListener(new EscutadorBotaoOK());

    }


    private class EscutadorBotaoOK implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            double nota1, nota2;

            nota1 = Double.parseDouble(txtNota1.getText().toString());
            nota2 = Double.parseDouble(txtNota2.getText().toString());


            Intent i = new Intent();

            i.putExtra("nota1", nota1);
            i.putExtra("nota2", nota2);

            setResult(RESULT_OK, i);

            finish();
        }
    }




}
