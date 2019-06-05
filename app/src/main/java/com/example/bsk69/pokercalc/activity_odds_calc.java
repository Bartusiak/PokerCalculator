package com.example.bsk69.pokercalc;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class activity_odds_calc extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odds_calc);



    }

    public void calculateHands(View view){

        EditText editText = (EditText)findViewById(R.id.setOuts);
        TextView textview = (TextView)findViewById(R.id.getChance);
        TextView textview2 = (TextView)findViewById(R.id.resultPlay);
        TextView textview3 = (TextView)findViewById(R.id.doFold);
        EditText editText1 = (EditText)findViewById(R.id.setPot);
        EditText editText2 = (EditText)findViewById(R.id.setCall);

        if (editText.getText().toString().trim().equalsIgnoreCase("") || editText1.getText().toString().trim().equalsIgnoreCase("") || editText2.getText().toString().trim().equalsIgnoreCase("")){
            textview.setText("Nie wprowadziles wszystkich danych !");
            return;
        }

        RadioButton rb = (RadioButton)findViewById(R.id.radioButton);
        RadioButton rb2 = (RadioButton)findViewById(R.id.radioButton2);
        int multiplier=0;

        String outy = editText.getText().toString();
        String pots = editText1.getText().toString();
        String calls = editText2.getText().toString();
        float result = 0;
        //Jesli flop to razy 4 , turn razy 2

        if(rb.isChecked()) {
            multiplier = 2;
        }
        else if (rb2.isChecked())
            multiplier = 4;
        else{
            textview.setText("Wybierz FLOP czy TURN ?");
            return;
        }
        //wyswietl wynik na ekranie
        textview.setText("Szansa na Twoją kartę: " + Integer.toString(Integer.parseInt(outy)*multiplier)+"%");
        textview2.setText("Twoj pot odds: " + Float.toString((Float.parseFloat(calls)/Float.parseFloat(pots)*100))+"%");
        if ((Integer.parseInt(outy)*multiplier) > (Float.parseFloat(calls)/Float.parseFloat(pots)*100) ){
            textview3.setTextColor(Color.GREEN);
            textview3.setText("CALL");
        }
        else{
            textview3.setTextColor(Color.RED);
            textview3.setText("FOLD");
        }
    }

    public void clearAll(View view){
        ((EditText) findViewById(R.id.setOuts)).setText("");
        ((EditText) findViewById(R.id.setCall)).setText("");
        ((EditText) findViewById(R.id.setPot)).setText("");
        ((TextView) findViewById(R.id.resultPlay)).setText("");
        ((TextView) findViewById(R.id.doFold)).setText("");
        ((TextView) findViewById(R.id.getChance)).setText("");
    }




}








