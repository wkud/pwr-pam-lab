package com.example.lab5_broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BatteryReceiver extends BroadcastReceiver {

    private int duration = Toast.LENGTH_SHORT;

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case Intent.ACTION_BATTERY_LOW:
                Toast.makeText(context, "low battery", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_BATTERY_OKAY:
                Toast.makeText(context, "battery ok", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "start charging", duration).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "stop charging", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
