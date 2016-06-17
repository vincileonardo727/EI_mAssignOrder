package com.example.sharan.ei_massignorder;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * {@link OrderAdapter} exposes a list of weather forecasts
 * from a {@link Cursor} to a {@link android.widget.ListView}.
 */
public class OrderAdapter extends CursorAdapter {

    private static final int VIEW_TYPE_COUNT = 2;
    private static final int VIEW_TYPE_TODAY = 0;
    private static final int VIEW_TYPE_FUTURE_DAY = 1;

    // Flag to determine if we want to use a separate view for "today".
    private boolean mUseTodayLayout = true;

    /**
     * Cache of the children views for a forecast list item.
     */
    public static class ViewHolder {
        public final TextView iconView;
        public final TextView dateView;
        public final TextView descriptionView;
//        public final TextView highTempView;
//        public final TextView lowTempView;

        public ViewHolder(View view) {
            iconView = (TextView) view.findViewById(R.id.list_item_name_textview);
            dateView = (TextView) view.findViewById(R.id.list_item_contact_textview);
            descriptionView = (TextView) view.findViewById(R.id.list_item_address_textview);
//            highTempView = (TextView) view.findViewById(R.id.list_item_fassign_textview);
//            lowTempView = (TextView) view.findViewById(R.id.list_item_low_textview);
        }
    }

    public OrderAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Choose the layout type
//        int viewType = getItemViewType(cursor.getPosition());
        int layoutId = -1;
/*        switch (viewType) {
            case VIEW_TYPE_TODAY: {
                layoutId = R.layout.list_item_forecast_today;
                break;
            }
            case VIEW_TYPE_FUTURE_DAY: {
                layoutId = R.layout.list_item_forecast;
                break;
            }
        }*/


        layoutId = R.layout.list_item_forecast;
        
        View view = LayoutInflater.from(context).inflate(layoutId, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ViewHolder viewHolder = (ViewHolder) view.getTag();

 /*       int viewType = getItemViewType(cursor.getPosition());
        switch (viewType) {
            case VIEW_TYPE_TODAY: {
                // Get weather icon
                viewHolder.iconView.setImageResource(Utility.getArtResourceForWeatherCondition(
                        cursor.getInt(FragOrders.COL_WEATHER_CONDITION_ID)));
                break;
            }
            case VIEW_TYPE_FUTURE_DAY: {
                // Get weather icon
                viewHolder.iconView.setImageResource(Utility.getIconResourceForWeatherCondition(
                        cursor.getInt(FragOrders.COL_WEATHER_CONDITION_ID)));
                break;
            }
        }*/

        // Read date from cursor

        String name = cursor.getString(FragOrders.COL_CUST_NAME);
        // Find TextView and set formatted date on it
        viewHolder.iconView.setText(name);
        
        String address = cursor.getString(FragOrders.COL_ADDRESS);
        // Find TextView and set formatted date on it
        viewHolder.descriptionView.setText(address);

        // Read weather forecast from cursor
        String contact = cursor.getString(FragOrders.COL_CONTACT);
        // Find TextView and set weather forecast on it
        viewHolder.dateView.setText(contact);
/*
        String fassign = cursor.getString(FragOrders.COL_FASSIGN);
        // Find TextView and set weather forecast on it
        viewHolder.highTempView.setText(fassign);*/

       /* // For accessibility, add a content description to the icon field
        viewHolder.iconView.setContentDescription(description);

        // Read user preference for metric or imperial temperature units
        boolean isMetric = Utility.isMetric(context);

        // Read high temperature from cursor
        high = cursor.getDouble(FragOrders.COL_WEATHER_MAX_TEMP);
        viewHolder.highTempView.setText(Utility.formatTemperature(context, high));

        // Read low temperature from cursor
        double low = cursor.getDouble(FragOrders.COL_WEATHER_MIN_TEMP);
        viewHolder.lowTempView.setText(Utility.formatTemperature(context, low));*/
    }

    public void setUseTodayLayout(boolean useTodayLayout) {
        mUseTodayLayout = useTodayLayout;
    }

    @Override
    public int getItemViewType(int position) {
//        return (position == 0 && mUseTodayLayout) ? VIEW_TYPE_TODAY : VIEW_TYPE_FUTURE_DAY;
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }
}