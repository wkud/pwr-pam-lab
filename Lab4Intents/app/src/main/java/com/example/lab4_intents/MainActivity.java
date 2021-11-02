package com.example.lab4_intents;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCallbackToButton(R.id.sendSms, v -> sendSms(v));
        setCallbackToButton(R.id.mapsShow, v -> showLocation(v));
        setCallbackToButton(R.id.contactsShow, v -> showContacts(v));
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
        String myData = "content://contacts/people/";
        Intent myActivity2 = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));

        startActivity(myActivity2);
    }

    

    private void setCallbackToButton(@IdRes int id, View.OnClickListener listener) {
        ((Button)findViewById(id)).setOnClickListener(listener);
    }

    private String getStringOfEditText(@IdRes int id) {
        return ((EditText)findViewById(id)).getText().toString();
    }
}