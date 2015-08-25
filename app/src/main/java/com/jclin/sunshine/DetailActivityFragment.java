package com.jclin.sunshine;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.ShareActionProvider;
import android.widget.TextView;

public class DetailActivityFragment extends Fragment
{
    private static final String SHARE_FORMAT = "%s#SunshineApp";

    private String _forecastString;

    public DetailActivityFragment()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View detailView = inflater.inflate(R.layout.detail_fragment, container, false);

        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT))
        {
            TextView textView = (TextView) detailView.findViewById(R.id.textview_detailed_forecast);

            _forecastString = intent.getStringExtra(Intent.EXTRA_TEXT);
            textView.setText(_forecastString);
        }
        return detailView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.detail_activity_fragment, menu);

        MenuItem menuItem = menu.findItem(R.id.action_share);

        ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        shareActionProvider.setShareIntent(createShareIntent());
    }

    @NonNull
    private Intent createShareIntent()
    {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, String.format(SHARE_FORMAT, _forecastString));

        return shareIntent;
    }
}
