package com.example.sharan.ei_massignorder;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

/**
 * Created by sharan on 1/6/16.
 */
public class FragOrders extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public interface Callback {
        /**
         * DetailFragmentCallback for when an item has been selected.
         */
        public void onItemSelected(Uri dateUri);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        // This is called when a new Loader needs to be created.  This
        // fragment only uses one loader, so we don't care about checking the id.

        // To only show current and future dates, filter the query to return weather only for
        // dates after or including today.

        // Sort order:  Ascending, by date.
        //String sortOrder = WeatherContract.WeatherEntry.COLUMN_DATE + " ASC";

        //String locationSetting = Utility.getPreferredLocation(getActivity());
        //Uri weatherForLocationUri = WeatherContract.WeatherEntry.buildWeatherLocationWithStartDate(
        //        locationSetting, System.currentTimeMillis());

//        return new CursorLoader(getActivity(),
//                weatherForLocationUri,
//                FORECAST_COLUMNS,
//                null,
//                null,
//                sortOrder);

        return new CursorLoader(getActivity(),
                null,
                null,
                null,
                null,
                null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }


}