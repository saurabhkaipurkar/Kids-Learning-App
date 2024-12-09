package com.example.forkidsinfo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class drawingPad extends AppCompatActivity
{
    FrameLayout drawingFrame;
    Button btnRed, btnGreen, btnBlue, btnYellow, btnPurple, btnCyan, btnMagenta, btnOrange, btnBrown, btnBlack;
    DrawingView drawingView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_pad);

        drawingView = new DrawingView(this, null);
        drawingFrame = findViewById(R.id.drawing_frame);
        drawingFrame.addView(drawingView);

        btnRed = findViewById(R.id.btnRed);
        btnGreen = findViewById(R.id.btnGreen);
        btnBlue = findViewById(R.id.btnBlue);
        btnYellow = findViewById(R.id.btnYellow);
        btnPurple = findViewById(R.id.btnPurple);
        btnCyan = findViewById(R.id.btnCyan);
        btnMagenta = findViewById(R.id.btnMagenta);
        btnOrange = findViewById(R.id.btnOrange);
        btnBrown = findViewById(R.id.btnBrown);
        btnBlack = findViewById(R.id.btnBlack);
        Button btnClear = findViewById(R.id.btnClear);

        btnRed.setOnClickListener(v -> drawingView.changeColor(Color.RED));

        btnGreen.setOnClickListener(v -> drawingView.changeColor(Color.GREEN));

        btnBlue.setOnClickListener(v -> drawingView.changeColor(Color.BLUE));

        btnRed.setOnClickListener(v -> drawingView.changeColor(ContextCompat.getColor(this, R.color.red)));
        btnGreen.setOnClickListener(v -> drawingView.changeColor(ContextCompat.getColor(this, R.color.green)));
        btnBlue.setOnClickListener(v -> drawingView.changeColor(ContextCompat.getColor(this, R.color.blue)));
        btnYellow.setOnClickListener(v -> drawingView.changeColor(ContextCompat.getColor(this, R.color.yellow)));
        btnPurple.setOnClickListener(v -> drawingView.changeColor(ContextCompat.getColor(this, R.color.purple)));
        btnCyan.setOnClickListener(v -> drawingView.changeColor(ContextCompat.getColor(this, R.color.cyan)));
        btnMagenta.setOnClickListener(v -> drawingView.changeColor(ContextCompat.getColor(this, R.color.magenta)));
        btnOrange.setOnClickListener(v -> drawingView.changeColor(ContextCompat.getColor(this, R.color.orange)));
        btnBrown.setOnClickListener(v -> drawingView.changeColor(ContextCompat.getColor(this, R.color.brown)));
        btnBlack.setOnClickListener(v -> drawingView.changeColor(ContextCompat.getColor(this, R.color.black)));
        btnClear.setOnClickListener(v -> drawingView.clearDrawing());

    }
}