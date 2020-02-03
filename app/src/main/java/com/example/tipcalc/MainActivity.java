package com.example.tipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declare needed variables for widgets
    EditText etBill;
    EditText etNumPeople;
    TextView tvTotalTip;
    TextView tvTipPerPerson;
    CheckBox cbService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBill = (EditText) findViewById(R.id.editTextBill);
        etNumPeople = (EditText) findViewById(R.id.editTextNumPeople);
        tvTotalTip = (TextView) findViewById(R.id.textViewTotalTip);

        cbService = (CheckBox) findViewById(R.id.checkBoxService);
    }


    public void onClickButtonCalculate(View view) {
        Double bill = Double.parseDouble(etBill.getText().toString());
        Double numPeople = Double.parseDouble(etNumPeople.getText().toString());
        Double totalTip;
        if (cbService.isChecked()) {
             totalTip = bill * 0.2;
        } else {
             totalTip = bill * 0.1;
        }

        Double tipPerPerson = totalTip / numPeople;

        tvTotalTip.setText( "Total Bill: " + totalTip.toString());
        tvTipPerPerson.setText( "Tip per Person: " + tipPerPerson.toString());

    }
}
