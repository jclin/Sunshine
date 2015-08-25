package com.jclin.sunshine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.action_settings)
        {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        if (item.getItemId() == R.id.action_view_location_on_map)
        {
            Intent intent = SharedIntents.getViewLocationOnMapIntent(Preferences.getLocation(this));
            if (intent.resolveActivity(this.getPackageManager()) != null)
            {
                startActivity(intent);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
