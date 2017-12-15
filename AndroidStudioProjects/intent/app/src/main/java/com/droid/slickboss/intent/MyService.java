package com.droid.slickboss.intent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * Created by SLICKBOSS on 5/31/2016.
 */
/**
public class MyService extends Service{

    private static final String TAG = "com.droid.slickboss.intent";

    public MyService(){

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       return super.onStartCommand(intent, flags, startId);
        Log.i(TAG, "on start method Called");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<5; i++){
                    long futureTime= System.currentTimeMillis() +5000;
                    while(System.currentTimeMillis()< futureTime){
                        synchronized (this){
                            try{
                                wait(futureTime-System.currentTimeMillis());
                           //     Log.i(TAG, "service is doing something");
                            }catch (Exception e){}


                        }
                    }
                }
            }
        };

        Thread slickThread = new Thread(r);
        slickThread.start();
        return Service.START_STICKY;


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
      //  Log.i(TAG, "on destroy method Called");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
*/