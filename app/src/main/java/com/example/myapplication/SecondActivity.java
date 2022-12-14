package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public final static String MESSAGE_KEY = "com.example.myapplication.message_key";
    public final static String DATE_KEY = "com.example.myapplication.date_key";
    public final static String PHONE_KEY = "com.example.myapplication.phone_key";
    public final static String ADDRESS_KEY = "com.example.myapplication.address_key";
    public final static String EMAIL_KEY = "com.example.myapplication.email_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MESSAGE_KEY);
        String datetxt = intent.getStringExtra(DATE_KEY);
        String phonetxt = intent.getStringExtra(PHONE_KEY);
        String addresstxt = intent.getStringExtra(ADDRESS_KEY);
        String emailtxt = intent.getStringExtra(EMAIL_KEY);

        TextView textview = new TextView(this);
        textview.setTextSize(30);
        textview.setText("NAME : "+message+"\n"+"BIRTHDAY : "+datetxt+"\n"+"NO.PHONE : "+phonetxt+"\n"+"ADDRESS : "+addresstxt+"\n"+"EMAIL : "+emailtxt);
        setContentView(textview);}
}