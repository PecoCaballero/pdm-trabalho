package com.example.exercicio06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnDigitaNotas;
    private Button btnExibeMedia;
    private EditText txtNome;
    private TextView lblNota1;
    private TextView lblNota2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnDigitaNotas = (Button) findViewById(R.id.btnOk);
        btnExibeMedia = (Button) findViewById(R.id.btnExibeMedia);
        txtNome = (EditText) findViewById(R.id.txtNome);
        lblNota1 = (TextView) findViewById(R.id.lblNota1);
        lblNota2 = (TextView) findViewById(R.id.lblNota2);


        btnDigitaNotas.setOnClickListener(new EscutadorBotaoDigitaNotas());
        btnExibeMedia.setOnClickListener(new EscutadorBotaoExibeMedia());
    }

    private class EscutadorBotaoDigitaNotas implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), NotasActivity.class);
            startActivityForResult(i, 1);
        }
    }

    private class EscutadorBotaoExibeMedia implements View.OnClickListener {
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), MediaActivity.class);

            String nota1, nota2, nome;

            nome = txtNome.getText().toString();
            nota1 = lblNota1.getText().toString();
            nota2 = lblNota2.getText().toString();

            double media = (Double.parseDouble(nota1) + Double.parseDouble(nota2)) / 2;

            i.putExtra("nome", nome);
            i.putExtra("nota1", lblNota1.getText().toString());
            i.putExtra("nota2", lblNota2.getText().toString());
            i.putExtra("media", media);

            startActivity(i);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                double nota1, nota2;

                nota1 = i.getDoubleExtra("nota1", 0.0);
                nota2 = i.getDoubleExtra("nota2", 0.0);

                lblNota1.setText(Double.toString(nota1));
                lblNota2.setText(Double.toString(nota2));
            }
        }
    }
}
