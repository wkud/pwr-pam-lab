package com.example.lab4_intents;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView gradeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCallbackToButton(R.id.sendSms, v -> sendSms(v));
        setCallbackToButton(R.id.mapsShow, v -> showLocation(v));
        setCallbackToButton(R.id.contactsShow, v -> showContacts(v));
        setCallbackToButton(R.id.gradeMark, v -> markStudent(v));

        gradeResult = findViewById(R.id.gradeResult);
    }

    private void sendSms(View v) {
        String smsNumber = getStringOfEditText(R.id.smsNumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + smsNumber));

        String smsText = getStringOfEditText(R.id.smsText);
        intent.putExtra("sms_body", smsText);

        startActivity(intent);
    }

    private void showLocation(View v) {
        String latitude = getStringOfEditText(R.id.mapsLatitude);
        String longitude = getStringOfEditText(R.id.mapsLongitude);

        String geoCode = String.format("geo:%s,%s", latitude, longitude );;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));

        startActivity(intent);
    }

    private void showContacts(View v) {
        String data = "content://contacts/people/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));

        startActivity(intent);
    }

    private void markStudent(View v) {
        String indexNumber = getStringOfEditText(R.id.gradeIndex);

        Intent intent = new Intent (MainActivity.this, MarkStudent.class);

        Bundle dataBundle = new Bundle();
        dataBundle.putString("index_number", indexNumber);
        intent.putExtras(dataBundle);

        // call Activity2, tell your local listener to wait a
        // response sent to a listener known as 101
        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
                Bundle resultBundle = data.getExtras();
                float mark = resultBundle.getFloat("mark");
                String fullName = resultBundle.getString("full_name");
                gradeResult.setText(String.format("Mark of %s is: %1.1f", fullName, mark));
            }
        }
        catch (Exception e) {
            gradeResult.setText("Problems - " + requestCode + " " + resultCode);
        }
    }//onActivityResult




    private void setCallbackToButton(@IdRes int id, View.OnClickListener listener) {
        ((Button)findViewById(id)).setOnClickListener(listener);
    }

    private String getStringOfEditText(@IdRes int id) {
        return ((EditText)findViewById(id)).getText().toString();
    }
}