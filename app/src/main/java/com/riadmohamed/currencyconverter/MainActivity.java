package com.riadmohamed.currencyconverter;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText usdEditText = findViewById(R.id.usdEditText);
        final EditText egpEditText = findViewById(R.id.egpEditText);

        Button clearButton = findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                usdEditText.setText("");
                egpEditText.setText("");
            }
        });


        Button button = findViewById(R.id.calculateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String USDString = usdEditText.getText().toString();
                String EGPString = egpEditText.getText().toString();
                if (USDString.length() == 0 & EGPString.length() == 0) {
                  // TODO: Both EditTexts are empty. Do nothing or show a toast saying that the user needs to enter something at one of the EditTexts.
                    Log.d("AllEmoty", "Both EditTexts are empty.");
                    Toast emptyToast = Toast.makeText(getApplicationContext(),
                                                        "Please enter a value to convert.",
                                                        Toast.LENGTH_LONG);
                    emptyToast.setGravity(Gravity.TOP, 0 , 0);
                    emptyToast.show();

                } else if (USDString.length() != 0) {
                    if (EGPString.length() != 0) {
                        // TODO: Both EditTexts are not empty. Show a toast saying that the user need to clear one of the EditTexts before tapping the calculate button.
                        Log.d("NoneEmoty", "Both EditTexts are not empty.");
                        Toast fullToast = Toast.makeText(getApplicationContext(),
                                                            "Please enter a value of USD or EGP, not both.",
                                                            Toast.LENGTH_LONG);
                        fullToast.setGravity(Gravity.TOP, 0, 0);
                        fullToast.show();
                    } else {
                        // MARK: - USD to EGP conversion.
                        // TODO: USD EditText is full. Get the value as double, mult with 16.2. Set the text of the EGP EditText as the result in String.
                        Log.d("EGPEmoty", "EGP EditText is empty.");
                        // Get the string from USD EditText
                        Log.d("USDString", USDString);
                        // Convert to double.
                        Double USDValue = Double.valueOf(USDString);
                        Log.d("USDValue", String.valueOf(USDValue));
                        // Set the result to USDValue * 16.2
                        Double result = USDValue * 16.2;
                        Log.d("resultEGP", String.valueOf(result));
                        // Convert the result to string
                        String finalString = String.valueOf(result);
                        Log.d("finalStringEGP", finalString);
                        // Set the EGP EditText to finalString.
                        egpEditText.setText(finalString);
                    }

                } else if (EGPString.length() != 0) {
                    if (USDString.length() != 0) {
                        // TODO: Both EditTexts are not empty. Show a toast saying that the user need to clear one of the EditTexts before tapping the calculate button.
                        Log.d("NoneEmoty", "Both EditTexts are not empty.");
                    } else {
                        // MARK: -  EGP to USD conversion.
                        // TODO: EGP EditText is full. Get the value as double, div by 16.2. Set the text of the EGP EditText as the result in String.
                        Log.d("USDEmoty", "USD EditText is empty.");
                        // Get the string from EGP EditText
                        Log.d("EGPString", EGPString);
                        // Convert to double.
                        Double EGPValue = Double.valueOf(EGPString);
                        Log.d("EGPValue", String.valueOf(EGPValue));
                        // Set the result to EGPValue / 16.2
                        Double result = EGPValue / 16.2;
                        Log.d("resultUSD", String.valueOf(result));
                        // Convert the result to string
                        String finalString = String.valueOf(result);
                        Log.d("finalStringUSD", finalString);
                        // Set the USD EditText to finalString.
                        usdEditText.setText(finalString);
                    }
                }
            }
        });
    }
}
