package com.example.demoemaula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtNota1;
    private EditText txtNota2;

    private TextView lblMedia;

    private Button btnCalcula;
    private Button btnExibe;
    private Button btnSai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);
        lblMedia = findViewById(R.id.lblMedia);
        btnCalcula = findViewById(R.id.btnCalcula);
        btnExibe = findViewById(R.id.btnExibe);
        btnSai = findViewById(R.id.btnSai);

        btnExibe.setOnClickListener(new EscutadorBotaoExibe());

        btnCalcula.setOnClickListener(new EscutadorBotaoCalcula());

        btnSai.setOnClickListener(new EscutadorBotaoSai());
    }

    class EscutadorBotaoSai implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            System.exit(0);
        }
    }

    class EscutadorBotaoCalcula implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            double n1, n2, media;

            n1 = Double.parseDouble( txtNota1.getText().toString() );

            n2 = Double.parseDouble( txtNota2.getText().toString() );

            media = (n1 + n2)/2;

            lblMedia.setText(Double.toString(media));
        }
    }

    class EscutadorBotaoExibe implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            String msg = "";

            msg = msg + txtNome.getText() + "\n";
            msg = msg + txtEmail.getText() + "\n";
            msg = msg + "Notas: " + txtNota1.getText() + " e " + txtNota2.getText();

            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

}