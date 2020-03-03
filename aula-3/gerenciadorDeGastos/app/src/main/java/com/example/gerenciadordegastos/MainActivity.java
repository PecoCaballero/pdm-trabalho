package com.example.gerenciadordegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Gasto> gastos = new ArrayList<Gasto>();

    private EditText txtGasto;
    private EditText txtValor;

    private Button btnAdiciona;
    private Button btnLista;
    private Button btnTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtGasto = findViewById(R.id.txtGasto);
        txtValor = findViewById(R.id.txtValor);
        btnAdiciona = findViewById(R.id.btnAdiciona);
        btnLista = findViewById(R.id.btnLista);
        btnTotal = findViewById(R.id.btnTotal);

        btnAdiciona.setOnClickListener(new EscutadorBotaoAdiciona());
        btnLista.setOnClickListener(new EscutadorBotaoLista());
        btnTotal.setOnClickListener(new EscutadorBotaoTotal());
    }

    private class EscutadorBotaoAdiciona implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            gastos.add(new Gasto(txtGasto.getText().toString(), Double.parseDouble(txtValor.getText().toString())));
            String msg = "Gasto adicionado";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

    private class EscutadorBotaoLista implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String msg = "";
            for (Gasto gasto : gastos){
                msg = msg + gasto.descricao + '\n';
                msg = msg + gasto.valor + '\n';
                msg = msg + "===========" + "\n";
            }
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

    private class EscutadorBotaoTotal implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            double total = 0;
            for (Gasto gasto : gastos){
               total += gasto.valor;
            }

            String msg = "Total de gastos: " + total;
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

    private class Gasto {

        private String descricao;
        private double valor;

        public Gasto(String descricao, double valor) {
            this.descricao = descricao;
            this.valor = valor;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }
    }
}
