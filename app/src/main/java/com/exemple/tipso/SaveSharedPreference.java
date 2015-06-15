package com.exemple.tipso;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Akrem on 02/06/2015.
 */
public class SaveSharedPreference {
    static final String PREF_USER_EMAIL= "useremail";
    static final String PREF_USER_PASSWORD= "userpassword";

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setEmailAndPassword(Context ctx, String useremail,String userpassword)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_EMAIL, useremail);
        editor.putString(PREF_USER_PASSWORD, userpassword);
        editor.commit();
    }

    public static String getUserEmail(Context ctx)
    {
        return getSharedPreferences(ctx).getString(PREF_USER_EMAIL, "");
    }
    public static String getUserPassword(Context ctx)
    {
        return getSharedPreferences(ctx).getString(PREF_USER_PASSWORD, "");
    }
}
