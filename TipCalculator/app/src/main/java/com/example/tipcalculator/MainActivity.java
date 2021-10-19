package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText foodName;
    EditText price;
    RatingBar ratingBar;
    RadioGroup tipRadio;
    SeekBar comeBackBar;
    TextView resultPrice;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodName = findViewById(R.id.foodName);
        price = findViewById(R.id.price);
        ratingBar = findViewById(R.id.rating);
        tipRadio = findViewById(R.id.tipRadioGroup);
        comeBackBar = findViewById(R.id.comeBack);
        resultPrice = findViewById(R.id.resultPrice);
        calculateButton = findViewById(R.id.calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float price = CalculateTotalPrice();
                    price = Math.round(price * 100) / 100;

                    resultPrice.setText(price + " zł");
                }
                catch (NumberFormatException exception)
                {
                    Log.e("tip-calc", exception.getMessage());
                }

            }
        });
    }

    private float CalculateTotalPrice()
    {
        float priceValue = Float.parseFloat(price.getText().toString());

        int tipValue = 0;
        switch(tipRadio.getCheckedRadioButtonId())
        {
            case R.id.tip0:
                tipValue = 0;
            case R.id.tip5:
                tipValue = 5;
            case R.id.tip10:
                tipValue = 10;
        }
        float comeBackValue = comeBackBar.getProgress();
        float comeBackMax = comeBackBar.getMax();

        float rating = Math.round(ratingBar.getRating());
        float ratingMax = ratingBar.getMax();

        return priceValue * (1 + tipValue / 100f) * rating / ratingMax * (comeBackValue+1) * comeBackMax;
    }
}