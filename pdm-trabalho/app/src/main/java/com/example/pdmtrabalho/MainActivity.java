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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();
        String session = sharedPreferences.getString("UID", "");

        if(session != null && !session.equals("")){
            System.out.println("Session: " + session);
            Intent homeScreen = new Intent(getApplicationContext(), HomeScreen.class);
            startActivity(homeScreen);
            finish();
        } else {
            btnLogin = findViewById(R.id.btnLogin);
            btnCadastrar = findViewById(R.id.btnCadastrar);
            txtEmail = findViewById(R.id.txtEmail);
            txtSenha = findViewById(R.id.txtSenha);
            lblMsg = findViewById(R.id.lblMessage);

            btnLogin.setOnClickListener(new EscutadorLogin());
            btnCadastrar.setOnClickListener(new EscutadorCadastro());
        }

    }

    class EscutadorLogin implements View.OnClickListener {

        @Override
        public void onClick(View view){


            String email = txtEmail.getText().toString().trim();
            String senha = txtSenha.getText().toString().trim();

            usuarios.signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if ( task.isSuccessful() ) {
                                editor.putString("UID", task.getResult().getUser().getUid());
                                editor.commit();
                                Intent homeScreen = new Intent(getApplicationContext(), HomeScreen.class);
                                startActivity(homeScreen);
                                finish();
                            }
                            else {
                                FirebaseAuthException e = (FirebaseAuthException)task.getException();
                                lblMsg.setText("Erro: " + e.getMessage());
                            }
                        }
                    });
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
