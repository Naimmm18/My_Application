package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnName;
    EditText etBirth;
    EditText etPhone;

    public final static String MESSAGE_KEY = "com.example.myapplication.message_key";
    public final static String BIRTH_KEY = "com.example.myapplication.birth_key";
    public final static String PHONE_KEY = "com.example.myapplication.phone_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendData(View view){
        etName = findViewById(R.id.etName);
        btnName = findViewById(R.id.btnName);
        etBirth = findViewById(R.id.etBirth);
        etPhone = findViewById(R.id.etPhone);

        String message = etName.getText().toString();
        String birthtxt = etBirth.getText().toString();
        String phonetxt = etPhone.getText().toString();

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra(MESSAGE_KEY,message);
        intent.putExtra(BIRTH_KEY,birthtxt);
        intent.putExtra(PHONE_KEY,phonetxt);

        startActivity(intent);

    }
}