package com.example.forkidsinfo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    private TextView tvDisplay;
    private String currentInput = ""; // Holds the current number or operation being input
    private String operator = ""; // Holds the current operator (+, -, *, /)
    private double firstOperand = 0;// Holds the first number in an operation
    private boolean isOperatorPressed = false; // Indicates if an operator button was pressed last

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tvDisplay = findViewById(R.id.tvDisplay);

        // Initialize buttons
        initializeButtons();
    }

    private void initializeButtons() {
        int[] numberButtonIds = {
                R.id.btnZero, R.id.btnOne, R.id.btnTwo, R.id.btnThree,
                R.id.btnFour, R.id.btnFive, R.id.btnSix, R.id.btnSeven,
                R.id.btnEight, R.id.btnNine
        };

        int[] operatorButtonIds = {
                R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide
        };

        // Set click listeners for number buttons
        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(this::onNumberButtonClick);
        }

        // Set click listeners for operator buttons
        for (int id : operatorButtonIds) {
            findViewById(id).setOnClickListener(this::onOperatorButtonClick);
        }

        // Set click listeners for other buttons
        findViewById(R.id.btnClear).setOnClickListener(v -> clearAll());
        findViewById(R.id.btnBackspace).setOnClickListener(v -> backspace());
        findViewById(R.id.btnDecimal).setOnClickListener(v -> appendDecimal());
        findViewById(R.id.btnEquals).setOnClickListener(v -> calculateResult());
    }

    private void onNumberButtonClick(View view) {
        Button button = (Button) view;
        String number = button.getText().toString();

        if (isOperatorPressed) {
            currentInput = ""; // Reset input for the next operand
            isOperatorPressed = false;
        }

        currentInput += number;
        tvDisplay.setText(currentInput);
    }

    private void onOperatorButtonClick(View view) {
        Button button = (Button) view;
        String selectedOperator = button.getText().toString();

        if (!currentInput.isEmpty()) {
            if (!operator.isEmpty()) {
                calculateResult(); // Auto-calculate for chained operations
            }
            firstOperand = Double.parseDouble(currentInput);
        }

        operator = selectedOperator;
        isOperatorPressed = true;
    }

    private void appendDecimal() {
        if (!currentInput.contains(".")) {
            currentInput += currentInput.isEmpty() ? "0." : ".";
            tvDisplay.setText(currentInput);
        }
    }

    private void backspace() {
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            tvDisplay.setText(currentInput.isEmpty() ? "0" : currentInput);
        }
    }

    private void clearAll() {
        currentInput = "";
        operator = "";
        firstOperand = 0;
        isOperatorPressed = false;
        tvDisplay.setText("0");
    }

    @SuppressLint("SetTextI18n")
    private void calculateResult() {
        if (operator.isEmpty() || currentInput.isEmpty()) return;

        double secondOperand = Double.parseDouble(currentInput);
        double result = 0;

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "−":
                result = firstOperand - secondOperand;
                break;
            case "×":
                result = firstOperand * secondOperand;
                break;
            case "÷":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    tvDisplay.setText("cannot divide by zero");
                    return;
                }
                break;
        }

        currentInput = String.valueOf(result);
        tvDisplay.setText(currentInput);
        operator = ""; // Reset operator for new calculation
        isOperatorPressed = false;
    }
}
