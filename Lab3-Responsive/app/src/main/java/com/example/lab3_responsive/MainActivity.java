package com.example.lab3_responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    StringBuilder equation = new StringBuilder();
    ArrayList<Button> buttons = new ArrayList<Button>();
    TextView equationLabel;

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

    }
}