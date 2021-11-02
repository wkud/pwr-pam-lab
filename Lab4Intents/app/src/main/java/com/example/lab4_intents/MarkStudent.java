package com.example.lab4_intents;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class MarkStudent extends AppCompatActivity {

    TextView dataReceived;
    Button submit;

    Intent localIntent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_student);

        dataReceived = findViewById(R.id.indexNumber);
        submit = (Button) findViewById(R.id.submitMark);
        submit.setOnClickListener(v -> onClick(v));

        localIntent = getIntent();
        bundle = localIntent.getExtras();
        String indexNumber = bundle.getString("index_number");

        dataReceived.setText(indexNumber);
    }

    public void onClick(View v) {
        float mark = getValueOfRatingBar(R.id.gradeValue);
        String fullName = getStringOfEditText(R.id.studentName);

        bundle.putFloat("mark", mark);
        bundle.putString("full_name", fullName);
        localIntent.putExtras(bundle);
        setResult(Activity.RESULT_OK, localIntent);

        finish();
    }

    private String getStringOfEditText(@IdRes int id) {
        return ((EditText)findViewById(id)).getText().toString();
    }
    private float getValueOfRatingBar(@IdRes int id) {
        return ((RatingBar)findViewById(id)).getRating();
    }
}