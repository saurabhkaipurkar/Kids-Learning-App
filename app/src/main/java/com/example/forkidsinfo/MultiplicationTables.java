package com.example.forkidsinfo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MultiplicationTables extends AppCompatActivity
{
    EditText Et_text;
    TextView Text_view;
    Button button;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_tables);

        Et_text = findViewById(R.id.inputText);
        Text_view = findViewById(R.id.outputText);
        button = findViewById(R.id.submitButton);

        button.setOnClickListener(view -> {

            try {
                String numberString = Et_text.getText().toString();
                int number = Integer.parseInt(numberString);

                StringBuilder result = new StringBuilder();

                for (int i = 1; i <= 10; i++) {
                    result.append(number).append(" x ").append(i).append(" = ").append(number * i).append("\n");
                }

                Text_view.setText(result.toString());
            } catch (NumberFormatException e) {
                Text_view.setText("Please enter a valid number");
            } catch (Exception e) {
                Text_view.setText("An error occurred");
            }

        });
    }
}