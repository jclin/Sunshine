package com.jclin.sunshine;

import android.content.Intent;
import android.net.Uri;

public final class SharedIntents
{
    public static Intent getViewLocationOnMapIntent(String zipcode)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=" + zipcode));

        return intent;
    }

    private SharedIntents()
    {
    }
}
