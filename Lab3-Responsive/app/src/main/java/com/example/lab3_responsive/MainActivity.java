package com.example.lab3_responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    StringBuilder equation = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.b1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { AppendToEquation("1"); }
        });
    }

    private void AppendToEquation(String x) {
        equation.append(x);
    }

    public void onAdd(View v) {

    }

    public void onSub(View v) {

    }

    public void onDiv(View v) {

    }

    public void onMult(View v) {

    }

    public void onResult(View v) {

    }
}