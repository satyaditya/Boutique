package com.blueseal.boutique.cart;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueseal.boutique.R;

/**
 * Created by Satyaditya on 2/11/15.
 */
public class OrderSummaryItemFrag extends Fragment
{
    private final String tag = this.getClass().getCanonicalName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.order_summary_layout, container, false);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(tag, "on pause called ");

    }


    @Override
    public void onStop()
    {
        super.onStop();
        Log.d(tag, "on stop called ");

    }
}
