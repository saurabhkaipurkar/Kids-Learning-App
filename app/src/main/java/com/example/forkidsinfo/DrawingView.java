package com.example.forkidsinfo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrawingView extends View
{
    private Paint currentPaint;
    private Path currentPath;
    private List<Stroke> strokes; // List to store all the strokes

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        currentPaint = new Paint();
        currentPaint.setColor(Color.BLACK);
        currentPaint.setAntiAlias(true);
        currentPaint.setStrokeWidth(10f);
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeJoin(Paint.Join.ROUND);

        currentPath = new Path();
        strokes = new ArrayList<>(); // Initialize the list of strokes
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw all the strokes
        for (Stroke stroke : strokes) {
            canvas.drawPath(stroke.getPath(), stroke.getPaint());
        }

        // Draw the current stroke
        if (currentPath != null) {
            canvas.drawPath(currentPath, currentPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentPath = new Path();
                currentPath.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                currentPath.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                // Add the current stroke to the list of strokes
                strokes.add(new Stroke(currentPath, currentPaint));
                currentPath = null;
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    public void changeColor(int color) {
        currentPaint = new Paint(currentPaint); // Create a new Paint object with the current properties
        currentPaint.setColor(color); // Set the new color
    }

    public void clearDrawing() {
        strokes.clear(); // Clear all strokes
        invalidate();
    }

    // A class to represent a stroke (a path with its paint)
    private static class Stroke {
        private final Path path;
        private final Paint paint;

        public Stroke(Path path, Paint paint) {
            this.path = path;
            this.paint = paint;
        }

        public Path getPath() {
            return path;
        }

        public Paint getPaint() {
            return paint;
        }
    }
}

