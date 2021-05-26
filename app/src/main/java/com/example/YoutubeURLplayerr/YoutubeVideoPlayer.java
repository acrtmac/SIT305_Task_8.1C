package com.example.YoutubeURLplayerr;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeVideoPlayer extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        youTubePlayerView = findViewById(R.id.youtubePlayer);

        String url = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            url = extras.getString(Configuration.URL_KEY);
        }

        String[] substrings = url.split("/");
        substrings = substrings[substrings.length - 1].split("v=");
        substrings = substrings[substrings.length - 1].split("&t=");

        final String finalUrl = substrings[0];

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(finalUrl);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youTubePlayerView.initialize(Configuration.getApiKey(), onInitializedListener);
    }
}