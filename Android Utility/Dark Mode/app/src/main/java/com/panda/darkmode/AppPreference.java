package com.panda.darkmode;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreference {
    Context context;
    SharedPreferences sharedPreferences;
    public AppPreference(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("UIMODE",Context.MODE_PRIVATE);

    }
    public void setDarkModeState(boolean enable){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("dark",enable);
        editor.apply();
    }
    public boolean getDarkModeState(){
        return  sharedPreferences.getBoolean("dark",false);
    }
}
