package com.example.sharan.ei_massignorder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by sharan on 1/6/16.
 */

public class ActUnassigned extends ActionBarActivity implements FragOrders.Callback {
    private final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String DETAILFRAGMENT_TAG = "DFTAG";

    private boolean mTwoPane;
    private String mLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mLocation = Utility.getPreferredLocation(this);

        setContentView(R.layout.act_unassigned);

        FragOrders forecastFragment =  ((FragOrders)getSupportFragmentManager()
                .findFragmentById(R.id.frag_orders));
//        forecastFragment.setUseTodayLayout(!mTwoPane);
//
//        SunshineSyncAdapter.initializeSyncAdapter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            startActivity(new Intent(this, SettingsActivity.class));
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        String location = Utility.getPreferredLocation( this );
//        // update the location in our second pane using the fragment manager
//        if (location != null && !location.equals(mLocation)) {
//            ForecastFragment ff = (ForecastFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_forecast);
//            if ( null != ff ) {
//                ff.onLocationChanged();
//            }
//            DetailFragment df = (DetailFragment)getSupportFragmentManager().findFragmentByTag(DETAILFRAGMENT_TAG);
//            if ( null != df ) {
//                df.onLocationChanged(location);
//            }
//            mLocation = location;
//        }
    }

    @Override
    public void onItemSelected(Uri contentUri) {

        Intent intent = new Intent(this, DetailActivity_U.class)
                .setData(contentUri);
        startActivity(intent);
    }
}
