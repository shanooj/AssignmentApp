package com.karbaros.myapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;

public class PopUpMenuActivity extends AppCompatActivity {
    Button btnPopup;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_menu);
        btnPopup = (Button) findViewById(R.id.btnchangeBackground);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_pop_up_menu);
    }
    public void changeBackground (View view) {
        //Creating the instance of PopupMenu
        PopupMenu popup = new PopupMenu(PopUpMenuActivity.this, btnPopup);
        //Inflating the Popup using xml file
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.miBlue :
                        relativeLayout.setBackgroundColor(Color.RED);
                        break;
                    case R.id.miGreen :
                        relativeLayout.setBackgroundColor(Color.GREEN);
                        break;
                    case R.id.miGray :
                        relativeLayout.setBackgroundColor(Color.GRAY);
                        break;
                    default:
                        break;
                }

                return true;
            }
        });

        popup.show();//showing popup menu

    }
}
