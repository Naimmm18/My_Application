package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnName;
    EditText etPhone;
    EditText etAddress;
    EditText etEmail;

    public final static String MESSAGE_KEY = "com.example.myapplication.message_key";
    public final static String DATE_KEY = "com.example.myapplication.date_key";
    public final static String PHONE_KEY = "com.example.myapplication.phone_key";
    public final static String ADDRESS_KEY = "com.example.myapplication.address_key";
    public final static String EMAIL_KEY = "com.example.myapplication.email_key";

    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
    }

    public void sendData(View view) {
        etName = findViewById(R.id.etName);
        btnName = findViewById(R.id.btnName);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);
        btnName = findViewById(R.id.btnName);

        String message = etName.getText().toString();
        String phonetxt = etPhone.getText().toString();
        String addresstxt = etAddress.getText().toString();
        String emailtxt = etEmail.getText().toString();
        String datetxt = dateButton.getText().toString();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        intent.putExtra(MESSAGE_KEY, message);
        intent.putExtra(DATE_KEY, datetxt);
        intent.putExtra(PHONE_KEY, phonetxt);
        intent.putExtra(ADDRESS_KEY, addresstxt);
        intent.putExtra(EMAIL_KEY, emailtxt);

        startActivity(intent);

        if (etEmail.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "enter email address", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
        }
}

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }
}


