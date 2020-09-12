package com.example.pdmtrabalho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroActivity extends AppCompatActivity {


    Button btnLogin;
    Button btnCadastrar;
    TextView txtEmail;
    TextView txtSenha;
    TextView lblMsg;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private FirebaseAuth usuarios = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();

        btnLogin = findViewById(R.id.btnLogin);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        lblMsg = findViewById(R.id.lblMessage);

        btnLogin.setOnClickListener(new EscutadorLogin());
        btnCadastrar.setOnClickListener(new EscutadorCadastro());

    }

    class EscutadorLogin implements View.OnClickListener {

        @Override
        public void onClick(View view){
            Intent loginScreen = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(loginScreen);
            finish();
        }

    }

    class EscutadorCadastro implements  View.OnClickListener{
        @Override
        public void onClick(View view){

            String email = txtEmail.getText().toString().trim();
            String senha = txtSenha.getText().toString().trim();

            Usuario user = new Usuario(email, senha);

            usuarios.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // Testa se criou o usuário com sucesso:
                            if ( task.isSuccessful() ) {
                                editor.putString("UID", task.getResult().getUser().getUid());
                                editor.commit();
                                Intent homeScreen = new Intent(getApplicationContext(), HomeScreen.class);
                                startActivity(homeScreen);
                                finish();
                            }
                            else {
                                FirebaseAuthException e = (FirebaseAuthException) task.getException();
                                lblMsg.setText("Erro: " + e.getMessage());
                            }
                        }
                    });


        }
    }
}
