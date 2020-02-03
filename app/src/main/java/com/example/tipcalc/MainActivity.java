package com.example.tipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declare needed variables for widgets
    EditText etBill;
    TextView tvTotalTip;
    TextView tvTipPerPerson;
    CheckBox cbService;
    RadioButton rb1, rb2, rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBill = (EditText) findViewById(R.id.editTextBill);
        tvTotalTip = (TextView) findViewById(R.id.textViewTotalTip);
        tvTipPerPerson = (TextView) findViewById(R.id.textViewTipPerPerson);
        cbService = (CheckBox) findViewById(R.id.checkBoxService);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
    }


    public void onClickButtonCalculate(View view) {
        try {
            Double bill = Double.parseDouble(etBill.getText().toString());
            int numPeople = 1;
            if (rb1.isChecked()) {
                numPeople = 1;
            }
            if (rb2.isChecked()) {
                numPeople = 2;
            }
            if (rb3.isChecked()) {
                numPeople = 3;
            }

            Double totalTip;
            if (cbService.isChecked()) {
                totalTip = bill * 0.2;
            } else {
                totalTip = bill * 0.1;
            }

            Double tipPerPerson = totalTip / numPeople;

            tvTotalTip.setText("Total Bill: " + totalTip.toString());
            tvTipPerPerson.setText("Tip per Person: " + tipPerPerson.toString());
        }
        catch(NumberFormatException ex) {
            tvTotalTip.setText("Total Bill: 0");
            tvTipPerPerson.setText("Tip per Person: 0");
        }
    }
}
