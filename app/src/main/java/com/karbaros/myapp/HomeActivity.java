package com.karbaros.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    public void activityIntent(View view) {
        switch (view.getId()) {
            case R.id.blankApp:
                Intent intentMainActivity = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intentMainActivity);
                break;
            case R.id.newActivity:
                Intent intentNewActivity = new Intent(getBaseContext(), NewActivity.class);
                startActivity(intentNewActivity);
                break;
            case R.id.greetApp:
                Intent intentGreetingActivity = new Intent(getBaseContext(), GreetingActivity.class);
                startActivity(intentGreetingActivity);
                break;
            case R.id.calculatorApp:
                Intent intentCalculatorActivity = new Intent(getBaseContext(), CalculatorActivity.class);
                startActivity(intentCalculatorActivity);
                break;
            case R.id.benchmarkApp:
                Intent intentAlgoBenchmarkActivity = new Intent(getBaseContext(), AlgoBenchmarkActivity.class);
                startActivity(intentAlgoBenchmarkActivity);
                break;
            case R.id.basicCalculatorApp:
                Intent intentBasiccalculatorActivity = new Intent(getBaseContext(), BasicCalculatorActivity.class);
                startActivity(intentBasiccalculatorActivity);
                break;
            case R.id.userRegV1:
                Intent intentUserRegActivity = new Intent(getBaseContext(), UserRegActivity.class);
                startActivity(intentUserRegActivity);
                break;
            case R.id.userRegV2:
                Intent intentUserRegV2Activity = new Intent(getBaseContext(), UserRegistrationVersion2.class);
                startActivity(intentUserRegV2Activity);
                break;
            case R.id.musicPlayer:
                Intent intentDemoMusicPlayerActivity = new Intent(getBaseContext(), DemoMusicPlayer.class);
                startActivity(intentDemoMusicPlayerActivity);
                break;
            case R.id.currencyConverterApp:
                Intent intentCurrencyConverterActivity = new Intent(getBaseContext(), CurrencyConverterActivity.class);
                startActivity(intentCurrencyConverterActivity);
                break;
            case R.id.instaCloneApp:
                Intent intentInstagramCloneActivity = new Intent(getBaseContext(), InstagramClone.class);
                startActivity(intentInstagramCloneActivity);
                break;
            /*case R.id.singleSongPlayerApp:
                Intent intentSingleSongPlayerActivity = new Intent(getBaseContext(), SingleSongPlayer.class);
                startActivity(intentSingleSongPlayerActivity);
                break;*/
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_activity_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
