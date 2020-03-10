package com.example.umescutadorvariosobjetos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        EscutadorMostraBotao escutadorMostraBotao = new EscutadorMostraBotao();

        button1.setOnClickListener(escutadorMostraBotao);
        button2.setOnClickListener(escutadorMostraBotao);
        button3.setOnClickListener(escutadorMostraBotao);
    }

    private class EscutadorMostraBotao implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            Button btn = (Button) v;

            String msg = "";

            switch (btn.getId()){
                case R.id.button1:
                    msg = msg + "btnBotao1\n";
                    break;
                case R.id.button2:
                    msg = msg + "btnBotao2\n";
                    break;
                case R.id.button3:
                    msg = msg + "btnBotao3\n";
                    break;

            }


            msg = msg + btn.getText();

            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

        }
    }
}
