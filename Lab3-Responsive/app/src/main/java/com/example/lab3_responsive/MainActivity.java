package com.example.lab3_responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    StringBuilder equation = new StringBuilder();
    ArrayList<Button> buttons = new ArrayList<Button>();
    TextView equationLabel;
    final String equationRegex = "^(\\d+[\\+\\/\\*\\,\\- ]?)*\\d$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equationLabel = findViewById(R.id.textView);

        int[] buttonIds = new int[]{
                R.id.b1, R.id.b2, R.id.b3,
                R.id.b4, R.id.b5, R.id.b6,
                R.id.b7, R.id.b8, R.id.b9,
                R.id.bComma, R.id.b0,
                R.id.bAdd, R.id.bSub, R.id.bDiv, R.id.bMult};

        for (int i : buttonIds) {
            Button button = findViewById(i);
            button.setOnClickListener((View v) -> AppendToEquation(v));
        }

        findViewById(R.id.bResult).setOnClickListener((View v) -> onResult(v));;
    }

    private void AppendToEquation(View v) {
        if (!(v instanceof Button)) {
            Log.e("my-app", "view with on click listener is not a button");
            return;
        }

        Button b = (Button) v;
        String buttonText = b.getText().toString();

        equation.append(buttonText);
        equationLabel.setText(equation.toString());
    }

    public void onResult(View v) {
        if (isEquationValid()) {
            equation.append(" = ");


            equation.append("");
        }
    }

    private boolean isEquationValid() {
        String input = equation.toString();
        Pattern pattern = Pattern.compile(equationRegex);
        return pattern.matcher(input).matches();
    }

    private double getResult(String input) {
        String[] sumParts = input.split("\\+");
        double sum = add(sumParts);
        return sum;
    }

    private double add(String[] sumParts)
    {
        for (String sumPart : sumParts) {
            String[] subParts = sumPart.split("\\-");
            sub(subParts);

        }
    }
    private double sub(String[] subParts) {
        for (String subPart : subParts) {
            String[] divParts = subPart.split("\\/");
            div(divParts);

        }
    }
    private double div(String[] divParts) {
        for (String divPart : divParts) {
            String[] multParts = divPart.split("\\*");
            mult(multParts);

        }
    }
    private double mult(String[] multParts) {
        for (String multPart : multParts) {
            double number = Double.parseDouble(multPart);
        }
    }





    }