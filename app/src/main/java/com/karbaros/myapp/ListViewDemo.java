package com.karbaros.myapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewDemo extends AppCompatActivity {
    private ListView lvColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        lvColors = (ListView) findViewById(R.id.lvColors);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.coloer, android.R.layout.simple_list_item_1);
        lvColors.setAdapter(adapter);
        

        lvColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;
                // ListView Clicked item value
                String itemValue = (String) lvColors.getItemAtPosition(position);
                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG).show();
                ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.loutListview);
                if (position == 0)
                    constraintLayout.setBackgroundColor(Color.RED);
                if (position == 1)
                    constraintLayout.setBackgroundColor(Color.BLUE);
                if (position == 2)
                    constraintLayout.setBackgroundColor(Color.GREEN);
                if (position == 3)
                    constraintLayout.setBackgroundColor(Color.YELLOW);
                if (position == 4)
                    constraintLayout.setBackgroundColor(Color.MAGENTA);
                if (position == 5)
                    constraintLayout.setBackgroundColor(Color.CYAN);
            }
        });
    }
}




