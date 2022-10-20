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
    EditText etAddress;
    EditText etEmail;

    public final static String MESSAGE_KEY = "com.example.myapplication.message_key";
    public final static String BIRTH_KEY = "com.example.myapplication.birth_key";
    public final static String PHONE_KEY = "com.example.myapplication.phone_key";
    public final static String ADDRESS_KEY = "com.example.myapplication.address_key";
    public final static String EMAIL_KEY = "com.example.myapplication.email_key";

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
        etAddress = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);

        String message = etName.getText().toString();
        String birthtxt = etBirth.getText().toString();
        String phonetxt = etPhone.getText().toString();
        String addresstxt = etAddress.getText().toString();
        String emailtxt = etEmail.getText().toString();

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra(MESSAGE_KEY,message);
        intent.putExtra(BIRTH_KEY,birthtxt);
        intent.putExtra(PHONE_KEY,phonetxt);
        intent.putExtra(ADDRESS_KEY,addresstxt);
        intent.putExtra(EMAIL_KEY,emailtxt);

        startActivity(intent);

    }
}