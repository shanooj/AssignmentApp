package com.karbaros.myapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by shanu on 03-Mar-17.
 */

public class BreadCastReceverActivity extends BroadcastReceiver {

    public BreadCastReceverActivity() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //String status = NetworkUtil.getConnectivityStatusString(context);

        Toast.makeText(context, "connectivity change", Toast.LENGTH_LONG).show();

    }
}
