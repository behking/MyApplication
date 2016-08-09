package com.example.newuser.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by new user on 8/7/2016.
 */
public class Appcontrolller extends Application{
   private static Appcontrolller instance;
    @Override
    public void onCreate (){
        super.onCreate();
        instance=this;
    }
    public static Appcontrolller getInstance (){
        return instance;
    }
    public static Context getAppContext (){
        return instance.getApplicationContext();
    }
}
