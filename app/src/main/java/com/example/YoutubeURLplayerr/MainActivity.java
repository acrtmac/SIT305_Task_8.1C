package com.example.YoutubeURLplayerr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText videoURLEditText;
    Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoURLEditText = findViewById(R.id.youtubeLinkEditText);
        playButton = findViewById(R.id.playButton);

    }

    public void playVideo(View view) {

        String url = videoURLEditText.getText().toString();

        Intent intent = new Intent(this, YoutubeVideoPlayer.class);
        intent.putExtra(Configuration.URL_KEY, url);
        startActivity(intent);
    }
}