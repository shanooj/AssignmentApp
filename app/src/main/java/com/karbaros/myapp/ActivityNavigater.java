package com.karbaros.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class ActivityNavigater extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigater);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.setting:
                Intent settingIntent = new Intent(getBaseContext(), Setting.class);
                startActivity(settingIntent);
                break;
            case R.id.aboutUs:
                Intent aboutUsIntent = new Intent(getBaseContext(), AboutUs.class);
                startActivity(aboutUsIntent);
                break;
            case R.id.contact:
                Intent contactIntent = new Intent(getBaseContext(), ContactUs.class);
                startActivity(contactIntent);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    public void navigateActivity(View view) {
        switch (view.getId()) {
            case R.id.ibtnBlankActivity:
                Intent intentMainActivity = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intentMainActivity);
                /*this.overridePendingTransition(R.anim.anim_in_right,R.anim.anim_out_right);*/
                break;
            case R.id.btnNewActivity:
                Intent intentNewActivity = new Intent(getBaseContext(), NewActivity.class);
                startActivity(intentNewActivity);

                break;
            case R.id.btnGreetUser:
                Intent intentGreetingActivity = new Intent(getBaseContext(), GreetingActivity.class);
                startActivity(intentGreetingActivity);
                break;
            case R.id.ibtnCalculator:
                Intent intentCalculatorActivity = new Intent(getBaseContext(), CalculatorActivity.class);
                startActivity(intentCalculatorActivity);
                break;
            case R.id.ibtnBenchmark:
                Intent intentAlgoBenchmarkActivity = new Intent(getBaseContext(), AlgoBenchmarkActivity.class);
                startActivity(intentAlgoBenchmarkActivity);
                break;
            case R.id.btnBasicCalculator:
                Intent intentBasiccalculatorActivity = new Intent(getBaseContext(), BasicCalculatorActivity.class);
                startActivity(intentBasiccalculatorActivity);
                break;
            case R.id.ibtnUserRegV1:
                Intent intentUserRegActivity = new Intent(getBaseContext(), UserRegActivity.class);
                startActivity(intentUserRegActivity);
                break;
            case R.id.btnUserRevV2:
                Intent intentUserRegV2Activity = new Intent(getBaseContext(), UserRegistrationVersion2.class);
                startActivity(intentUserRegV2Activity);
                break;
            case R.id.ibtnMusicPlayer:
                Intent intentDemoMusicPlayerActivity = new Intent(getBaseContext(), DemoMusicPlayer.class);
                startActivity(intentDemoMusicPlayerActivity);
                break;
            case R.id.ibtnCurrencyConverter:
                Intent intentCurrencyConverterActivity = new Intent(getBaseContext(), CurrencyConverterActivity.class);
                startActivity(intentCurrencyConverterActivity);
                break;

            case R.id.ibtnInstagramClone:
                Intent intentSingleSongPlayerActivity = new Intent(getBaseContext(), InstagramCloneActivity.class);
                startActivity(intentSingleSongPlayerActivity);
                break;

            case R.id.ibtnCamera:
                Intent intentCamera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intentCamera);
                break;

            case R.id.ibGallery :
                Intent intentGallery = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //startActivityForResult(i, RESULT_LOAD_IMAGE);
                /*Intent intentGallery = new Intent();
                intentGallery.setType("image*//*");
                intentGallery.setAction(Intent.ACTION_GET_CONTENT);*/
                startActivity(intentGallery);
                break;
            case R.id.ibtnMessage:
                Intent intentMessage = new Intent(Intent.ACTION_MAIN);
                intentMessage.addCategory(Intent.CATEGORY_DEFAULT);
                intentMessage.setType("vnd.android-dir/mms-sms");
                startActivity(intentMessage);
                break;
            case R.id.ibtnDialPad :
                Intent intentDialer = new Intent(Intent.ACTION_DIAL);
               // intent.setData(Uri.parse("tel:0123456789"));
                startActivity(intentDialer);
                break;
            case R.id.ibtnEmertgancyCall :
                Intent intentDialerEmergancy = new Intent(Intent.ACTION_DIAL);
                intentDialerEmergancy.setData(Uri.parse("tel:0123456789"));
                startActivity(intentDialerEmergancy);
                break;

            case R.id.ibtnWatsapp :
                Intent sendIntent = new Intent();
                //sendIntent.setAction(Intent.ACTION_SEND);
                //sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
               // sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
                break;

            case R.id.btnOnResultActivity :
                Intent intentResultActivity = new Intent(getBaseContext(), OnActivityResultDemo.class);
                //intentResultActivity.setData(Uri.parse("tel:0123456789"));
                startActivity(intentResultActivity);
                break;

            case R.id.ibtnWebView:
                Intent intentWebView = new Intent(getBaseContext(),WebViewActivity.class);
                startActivity(intentWebView);
                break;

            case R.id.ibtnAnimation:
                Intent intentAnimation = new Intent(getBaseContext(),AnimationActivity.class);
                startActivity(intentAnimation);
                break;
            default:
                break;
        }
    }
}
