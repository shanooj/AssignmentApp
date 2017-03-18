package com.karbaros.myapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.karbaros.myapp.utility.AppSupport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserRegActivity extends AppCompatActivity {
    private static EditText dob;
    private EditText userName;
    private EditText email;
    private EditText mobile;
    private EditText password;
    private EditText rePassword;
    private Animation animShake;
    private Vibrator mVibrator;


    public void doRegister(View view) {
        String pswd = password.getText().toString();
        String repwds = rePassword.getText().toString();
        String dateOfBirth = dob.getText().toString();
        int year = 0;
        int presentYear = 0;
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date yourDate = parser.parse(dateOfBirth);
            year = yourDate.getYear();
            Calendar calendar = Calendar.getInstance();
            presentYear = calendar.get(Calendar.YEAR);
        } catch (ParseException e) {
            //e.printStackTrace();
        }


        if (userName.getText().toString().equals("")) {
            mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            mVibrator.vibrate(100);
            userName.startAnimation(animShake);
            userName.setError("Please Enter Name");
        }
        if (email.getText().toString().equals("")) {
            email.setError("Please enter Email");
        } else {
            if (AppSupport.isValidEmail(email.getText().toString()) != true)
                email.setError("Please enter valid Email");
        }
        if (mobile.getText().toString().equals(""))
            mobile.setError("Please Enter Number");

        if (pswd.equals(""))
            password.setError("Please enter password");
        else {

            if (pswd.equals(repwds)) {

            } else
                rePassword.setError("Please re-enter password");
        }
        if (presentYear - year > 60)
            dob.setError("Age must be less than 60");


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg);
        dob = (EditText) findViewById(R.id.etDOB);
        userName = (EditText) findViewById(R.id.etUserName);
        email = (EditText) findViewById(R.id.etEmail);
        mobile = (EditText) findViewById(R.id.etMobile);
        password = (EditText) findViewById(R.id.etpassword);
        rePassword = (EditText) findViewById(R.id.etRePassword);
        animShake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_shake);


        //Action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }


        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // showTruitonTimePickerDialog(v);
                showTruitonDatePickerDialog(v);
            }
        });
    }


    public void showTruitonDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            dob.setText(day + "/" + (month + 1) + "/" + year);
        }
    }

    public void showTruitonTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public static class TimePickerFragment extends DialogFragment implements
            TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            dob.setText(dob.getText());
        }
    }
}
