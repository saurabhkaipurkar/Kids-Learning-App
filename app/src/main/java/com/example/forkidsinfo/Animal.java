package com.example.forkidsinfo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Animal extends AppCompatActivity {

    ImageView
            dog, cat, cow, tiger, elephant, monkey,
            lion, bull, Snake, fox, zebra, goat,
            giraffe, donkey, eagle, gorilla, alligator, crow;

    private MediaPlayer currentMediaPlayer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animal);

        dog = findViewById(R.id.dog);
        cat = findViewById(R.id.cat);
        cow = findViewById(R.id.cow);
        tiger = findViewById(R.id.tiger);
        elephant = findViewById(R.id.elephant);
        monkey = findViewById(R.id.monkey);
        lion = findViewById(R.id.lion);
        bull = findViewById(R.id.bull);
        Snake = findViewById(R.id.snake);
        fox = findViewById(R.id.fox);
        zebra = findViewById(R.id.zebbra);
        goat = findViewById(R.id.goat);
        giraffe = findViewById(R.id.giraffe);
        donkey = findViewById(R.id.donkey);
        eagle = findViewById(R.id.eagle);
        gorilla = findViewById(R.id.gorilla);
        alligator = findViewById(R.id.Alligator);
        crow = findViewById(R.id.crow);

        // Set OnClickListeners
        dog.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.dog);
            AnimalUtils.performVibration(Animal.this);
        });

        cat.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.cat);
            AnimalUtils.performVibration(Animal.this);
        });
        cow.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.cow);
            AnimalUtils.performVibration(Animal.this);
        });
        tiger.setOnClickListener(view -> {
          currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.tiger);
            AnimalUtils.performVibration(Animal.this);
        });
        elephant.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.elephant);
            AnimalUtils.performVibration(Animal.this);
        });
        monkey.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.monkey);
            AnimalUtils.performVibration(Animal.this);
        });
        lion.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.lion);
            AnimalUtils.performVibration(Animal.this);
        });
        bull.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.bull);
            AnimalUtils.performVibration(Animal.this);
        });
        Snake.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.snake);
            AnimalUtils.performVibration(Animal.this);
        });
        fox.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.fox);
            AnimalUtils.performVibration(Animal.this);
        });
        zebra.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.zebra);
            AnimalUtils.performVibration(Animal.this);
        });
        goat.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.goat);
            AnimalUtils.performVibration(Animal.this);
        });
        giraffe.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.giraffe);
            AnimalUtils.performVibration(Animal.this);
        });
        donkey.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.donkey);
            AnimalUtils.performVibration(Animal.this);
        });
        eagle.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.eagle);
            AnimalUtils.performVibration(Animal.this);
        });
        gorilla.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.gorilla);
            AnimalUtils.performVibration(Animal.this);
        });
        alligator.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.alligator);
            AnimalUtils.performVibration(Animal.this);
        });
        crow.setOnClickListener(view -> {
           currentMediaPlayer = AnimalUtils.playAnimalSound(Animal.this, currentMediaPlayer, R.raw.crow);
            AnimalUtils.performVibration(Animal.this);
        });
    }
    protected void onDestroy() {
        super.onDestroy();
        // Release the MediaPlayer when the activity is destroyed to avoid memory leaks
        if (currentMediaPlayer != null) {
            currentMediaPlayer.release();
            currentMediaPlayer = null;
        }
    }
}
