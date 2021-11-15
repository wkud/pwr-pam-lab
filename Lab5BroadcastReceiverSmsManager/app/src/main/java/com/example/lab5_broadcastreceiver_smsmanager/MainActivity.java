package com.example.lab5_broadcastreceiver_smsmanager;

import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // receiving sms
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(new SmsReceiver(), filter);

        // sending sms
        EditText content = findViewById(R.id.smsContent);
        String message = content.getText().toString();

        EditText phoneNumber = findViewById(R.id.smsNumber);
        String address = phoneNumber.getText().toString();

        Button send = findViewById(R.id.sendButton);
        send.setOnClickListener((View v) -> {
            SmsManager smsManager  = SmsManager.getDefault();
            smsManager.sendTextMessage(address, null, message, null, null);
        });

    }
}

