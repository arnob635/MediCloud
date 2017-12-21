package sks.jakfromspace.medicloud;

import android.app.Application;
import android.content.Context;

/**
 * Created by JAKfromSpace on 26-Nov-17.
 */

public class ContextFinder extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        ContextFinder.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return ContextFinder.context;
    }


}
