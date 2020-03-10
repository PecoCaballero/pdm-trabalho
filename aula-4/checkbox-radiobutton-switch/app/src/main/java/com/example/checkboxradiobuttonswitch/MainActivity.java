package com.example.checkboxradiobuttonswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private CheckBox chk1;
    private CheckBox chk2;
    private CheckBox chk3;
    private Button btnCheck;

    private RadioGroup radioGroup;
    private RadioButton rad1;
    private RadioButton rad2;
    private RadioButton rad3;
    private Button btnRad;

    private Switch swi1;
    private Button btnSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        btnCheck = findViewById(R.id.btnCheck);

        EscutadorCheckBox escutadorCheckBox = new EscutadorCheckBox();
        EscutadorBotaoCheck escutadorBotaoCheck = new EscutadorBotaoCheck();

        chk1.setOnClickListener(escutadorCheckBox);
        chk2.setOnClickListener(escutadorCheckBox);
        chk3.setOnClickListener(escutadorCheckBox);

        btnCheck.setOnClickListener(escutadorBotaoCheck);


        radioGroup = findViewById(R.id.radioGroup);
        rad1 = findViewById(R.id.rad1);
        rad2 = findViewById(R.id.rad2);
        rad3 = findViewById(R.id.rad3);
        btnRad = findViewById(R.id.btnRad);

        EscutadorRadioGroup escutadorRadioGroup = new EscutadorRadioGroup();
        EscutadorBotaoRadio escutadorBotaoRadio = new EscutadorBotaoRadio();

        radioGroup.setOnCheckedChangeListener(escutadorRadioGroup);
        btnRad.setOnClickListener(escutadorBotaoRadio);


        swi1 = findViewById(R.id.swi1);
        btnSwitch = findViewById(R.id.btnSwitch);

        EscutadorSwitch escutadorSwitch = new EscutadorSwitch();
        EscutadorBotaoSwitch escutadorBotaoSwitch = new EscutadorBotaoSwitch();

        swi1.setOnCheckedChangeListener(escutadorSwitch);
        btnSwitch.setOnClickListener(escutadorBotaoSwitch);

    }

    private class EscutadorCheckBox implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            CheckBox ck = (CheckBox) v;

            switch (ck.getId()){
                case R.id.chk1:
                    Toast.makeText(getApplicationContext(), "Check1", Toast.LENGTH_LONG).show();
                    break;
                case R.id.chk2:
                    Toast.makeText(getApplicationContext(), "Check2", Toast.LENGTH_LONG).show();
                    break;
                case R.id.chk3:
                    Toast.makeText(getApplicationContext(), "Check3", Toast.LENGTH_LONG).show();
                    break;
            }

        }
    }

    private class EscutadorBotaoCheck implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            String msg = "";

            if(chk1.isChecked()){
                msg += "Check1 marcado\n";
            }
            if(chk2.isChecked()){
                msg += "Check2 marcado\n";
            }
            if(chk3.isChecked()){
                msg += "Check2 marcado\n";
            }
            if(msg.equals("")){
                Toast.makeText(getApplicationContext(), "nenhuma caixa marcada", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        }
    }

    private class EscutadorRadioGroup implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            String msg = "";

            switch (checkedId){
                case R.id.rad1:
                    msg += "Clicou no Radio 1";
                    break;
                case R.id.rad2:
                    msg += "Clicou no Radio 2";
                    break;
                case R.id.rad3:
                    msg += "Clicou no Radio 3";
                    break;
            }

            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

        }
    }

    private class EscutadorBotaoRadio implements  View.OnClickListener{

        @Override
        public void onClick(View v) {


            int radioSelecionado = radioGroup.getCheckedRadioButtonId();


            if(radioSelecionado == -1){
                Toast.makeText(getApplicationContext(), "Nenhum radio selecionado", Toast.LENGTH_LONG).show();
            } else {
                String msg = "";

                switch (radioSelecionado){
                    case R.id.rad1:
                        msg += "Radio 1 selecionado";
                        break;
                    case R.id.rad2:
                        msg += "Radio 2 selecionado";
                        break;
                    case R.id.rad3:
                        msg += "Radio 3 selecionado";
                        break;
                }

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }

        }
    }

    private class EscutadorSwitch implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            Toast.makeText(getApplicationContext(), "Switch clicado.\n E esta na posicao " + isChecked, Toast.LENGTH_LONG).show();
        }
    }

    private class EscutadorBotaoSwitch implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String msg = "";

            if(swi1.isChecked()){
                msg = "Switch esta na posicao ligado.";
            } else {
                msg = "Switch esta na posicao desligado.";
            }

            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

}
