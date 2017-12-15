package com.droid.slickboss.receivebc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiveBroadcast extends BroadcastReceiver {
    public ReceiveBroadcast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Broadcast has been received!", Toast.LENGTH_LONG).show();
        
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
    //    throw new UnsupportedOperationException("Not yet implemented");
    }
}
