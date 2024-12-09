package com.example.forkidsinfo;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.forkidsinfo.responses.StoryResponse;
import com.example.forkidsinfo.retrofitapi.ApiService;
import com.google.cloud.texttospeech.v1beta1.AudioConfig;
import com.google.cloud.texttospeech.v1beta1.AudioEncoding;
import com.google.cloud.texttospeech.v1beta1.SsmlVoiceGender;
import com.google.cloud.texttospeech.v1beta1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1beta1.VoiceSelectionParams;
import com.google.cloud.texttospeech.v1beta1.SynthesisInput;
import com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse;
import com.google.protobuf.ByteString;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Stories extends AppCompatActivity
{
    private EditText editText;
    private TextView getStories;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);

        editText = findViewById(R.id.editTextText);
        Button searchButton = findViewById(R.id.search_btn);
        getStories = findViewById(R.id.get_stories);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);

        searchButton.setOnClickListener(v -> {
            String query = editText.getText().toString();
            if (!query.isEmpty()) {
                searchStory(query);
            }
            else {
                Toast.makeText(Stories.this, "Please enter a query", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void searchStory(String query) {
         final String API_KEY = "AIzaSyAAnroJ3a5xQDfINK7Al4rlPlwavAw_iM4";
         final String CX = "012ba35d98dbf49b3";

        apiService.searchStory(API_KEY, CX, query).enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<StoryResponse> call, @NonNull Response<StoryResponse> response) {
                if (response.isSuccessful()) {
                    StoryResponse storyResponse = response.body();
                    if (storyResponse != null && !storyResponse.items.isEmpty()) {
                        String story = storyResponse.items.get(0).snippet;
                        getStories.setText(story);

                        // Trigger Text-to-Speech
                        try {
                            convertTextToSpeech(story);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<StoryResponse> call, @NonNull Throwable t) {
                Toast.makeText(Stories.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void convertTextToSpeech(String storyText) throws IOException {
        // Initialize Text-to-Speech functionality here
        TextToSpeechClient client = TextToSpeechClient.create();
        SynthesisInput input = SynthesisInput.newBuilder()
                .setText(storyText)
                .build();

        VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
                .setLanguageCode("en-US")
                .setSsmlGender(SsmlVoiceGender.FEMALE)
                .build();

        AudioConfig audioConfig = AudioConfig.newBuilder()
                .setAudioEncoding(AudioEncoding.MP3)
                .build();

        SynthesizeSpeechResponse response = client.synthesizeSpeech(input, voice, audioConfig);

        // Play the synthesized audio
        ByteString audioContents = response.getAudioContent();
        try {
            File tempFile = File.createTempFile("story", ".mp3", getCacheDir());
            FileOutputStream out = new FileOutputStream(tempFile);
            out.write(audioContents.toByteArray());
            out.close();

            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(tempFile.getAbsolutePath());
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            Log.d(e.getMessage(), "convertTextToSpeech: ");
        } finally {
            client.close();
        }
    }
}
