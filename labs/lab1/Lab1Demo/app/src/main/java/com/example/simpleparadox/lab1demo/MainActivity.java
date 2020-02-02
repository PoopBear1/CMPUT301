package com.example.simpleparadox.lab1demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tweet importantTweet = new ImportantTweet("Hustle");
        Tweet normalTweet = new NormalTweet("Everyday");

        ArrayList<Tweet> tweets = new ArrayList<>();
        tweets.add(importantTweet);
        tweets.add(normalTweet);



        for(Tweet tweet: tweets){
            Log.d("Tweet Data", tweet.getDate() + ": " + tweet.getMessage());
        }




    }
}
