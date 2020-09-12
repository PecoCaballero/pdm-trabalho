package com.example.pdmtrabalho;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ProdutoScene extends AppCompatActivity {

    Produto produto;

    private TextView txtTitulo;
    private TextView txtDescricao;
    private TextView txtPreco;
    private ImageView imageView;
    private Button btnCompra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        setContentView(R.layout.activity_produto_scene);

        produto = (Produto) intent.getSerializableExtra("produto");

        txtTitulo = findViewById(R.id.txtTitulo);
        txtDescricao = findViewById(R.id.txtDescricao);
        txtPreco = findViewById(R.id.txtPreco);
        imageView = findViewById(R.id.imageView);
        btnCompra = findViewById(R.id.btnComprar);

        txtTitulo.setText(produto.getTitulo());
        txtDescricao.setText(produto.getDescricao());
        txtPreco.setText(Double.toString(produto.getPreco()));
        Picasso.get().load(produto.getImgUrl()).into(imageView);

        btnCompra.setOnClickListener(new EscutadorCompra());
    }

    class EscutadorCompra implements View.OnClickListener {

        @Override
        public void onClick(View view){
            String msg = "Compra de um " + txtTitulo.getText().toString() + " efetuada com sucesso";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }


    }

}
