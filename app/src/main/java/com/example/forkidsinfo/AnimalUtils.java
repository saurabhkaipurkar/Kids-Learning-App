package com.example.forkidsinfo;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class AnimalUtils
{
    public static MediaPlayer playAnimalSound(Context context, MediaPlayer currentMediaPlayer, int resource)
    {
        if (currentMediaPlayer != null)
        {
            currentMediaPlayer.stop();
            currentMediaPlayer.release();
        }
        currentMediaPlayer = MediaPlayer.create(context, resource);
        currentMediaPlayer.start();
        return currentMediaPlayer;
    }
    public static void performVibration(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator != null) {
            VibrationEffect vibrationEffect = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrationEffect = VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(vibrationEffect);
            }
        }
    }
}

