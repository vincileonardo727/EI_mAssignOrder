package com.example.sharan.ei_massignorder.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class OrderSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static OrderSyncAdapter sOrderSyncAdapter = null;

    @Override
    public void onCreate() {
        Log.d("OrderSyncService", "onCreate - OrderSyncService");
        synchronized (sSyncAdapterLock) {
            if (sOrderSyncAdapter == null) {
                sOrderSyncAdapter = new OrderSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sOrderSyncAdapter.getSyncAdapterBinder();
    }
}