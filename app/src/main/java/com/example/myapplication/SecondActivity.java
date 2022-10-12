package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public final static String MESSAGE_KEY = "com.example.myapplication.message_key";
    public final static String BIRTH_KEY = "com.example.myapplication.birth_key";
    public final static String PHONE_KEY = "com.example.myapplication.phone_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MESSAGE_KEY);
        String birthtxt = intent.getStringExtra(BIRTH_KEY);
        String phonetxt = intent.getStringExtra(PHONE_KEY);
        TextView textview = new TextView(this);
        textview.setTextSize(45);
        setContentView(textview);

    }
}