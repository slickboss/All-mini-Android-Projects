package com.droid.slickboss.intent;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * Created by SLICKBOSS on 5/31/2016.
 */
public class SlickIntentService extends IntentService{

    private static final  String TAG = "com.droid.slickboss.intent";

    public SlickIntentService(){
        super("SlickintentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // this is what the service does
        Log.i(TAG, "SERVICE HAS NOW STARTED");
    }
}
