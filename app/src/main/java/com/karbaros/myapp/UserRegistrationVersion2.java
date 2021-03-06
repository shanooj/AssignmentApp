package com.karbaros.myapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.karbaros.myapp.utility.AppSupport;
import com.karbaros.myapp.utility.SendMail;

import java.util.Calendar;

public class UserRegistrationVersion2 extends AppCompatActivity {

    private static final String TAG = UserRegistrationVersion2.class.getSimpleName();
    private String password;
    private String mailPassword;
    private String mailUsername;
    private static EditText dateOfBirth;
    private static EditText uName;
    private static EditText phone;
    private static EditText emailAddress;

    public void doRegistration(View view) {
        password = AppSupport.getPassword().toString();
        String subject = "Scret dat";
        if (doValidate()) {
            //code for send mail

            /*Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{ emailAddress.getText().toString()});
            email.putExtra(Intent.EXTRA_SUBJECT, subject);
            email.putExtra(Intent.EXTRA_TEXT, password);

            //need this to prompts email client only
            email.setType("message/rfc822");

            startActivity(Intent.createChooser(email, "Send mail..."));*/

            SendMail sendMail = new SendMail(this, emailAddress.getText().toString().trim(), subject, password);

            sendMail.execute();
        }


    }

    public Boolean doValidate() {
        boolean flag = false;
        int f = 0;


        if (uName.getText().toString().equals(""))
            uName.setError("Please enter Name");
        else
            f++;
        if (emailAddress.getText().toString().equals(""))
            emailAddress.setError("Please Enter Email");
        else {
            if (AppSupport.isValidEmail(emailAddress.getText().toString()) != true)
                emailAddress.setError("Please enter a valid Email");
            else
                f++;
        }

        if (phone.getText().toString().equals(""))
            phone.setError("Please enter mobile Number");
        else
            f++;

        if (dateOfBirth.getText().toString().equals(""))
            dateOfBirth.setError("Please enter Date of birth");
        else
            f++;

        if (f == 4)
            return true;
        else
            return false;

        // Log.i(TAG,password );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration_version2);
        dateOfBirth = (EditText) findViewById(R.id.etDateOfBirth);
        phone = (EditText) findViewById(R.id.etPhoneNumber);
        uName = (EditText) findViewById(R.id.etUname);
        emailAddress = (EditText) findViewById(R.id.etEmailAddress);

        //Action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // showTruitonTimePickerDialog(v);
                showTruitonDatePickerDialog(v);
            }
        });
    }

    public void showTruitonDatePickerDialog(View v) {
        DialogFragment newFragment = new UserRegistrationVersion2.DatePickerFragment();
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
            dateOfBirth.setText(day + "/" + (month + 1) + "/" + year);
        }
    }

}
