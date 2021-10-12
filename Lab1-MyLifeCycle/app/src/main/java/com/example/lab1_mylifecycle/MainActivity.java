package com.example.lab1_mylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        context = getApplicationContext();
        Toast.makeText(context, "onCreate", duration).show();
        Log.i("cyklzycia", "onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(context, "onDestroy", duration).show();
        Log.i("cyklzycia", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(context, "onPause", duration).show();
        Log.i("cyklzycia", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(context, "onRestart", duration).show();
        Log.i("cyklzycia", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(context, "onResume", duration).show();
        Log.i("cyklzycia", "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(context, "onStart", duration).show();
        Log.i("cyklzycia", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(context, "onStop", duration).show();
        Log.i("cyklzycia", "onStop");
    }
}