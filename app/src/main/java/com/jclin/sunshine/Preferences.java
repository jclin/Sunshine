package com.jclin.sunshine;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public final class Preferences
{
    public static String getLocation(Context context)
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(
            context.getString(R.string.pref_location_key),
            context.getString(R.string.pref_location_default)
            );
    }

    private Preferences()
    {
    }
}
