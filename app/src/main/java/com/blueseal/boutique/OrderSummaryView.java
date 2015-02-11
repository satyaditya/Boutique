package com.blueseal.boutique;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Satyaditya on 2/5/15.
 */
public class OrderSummaryView extends View
{
    public OrderSummaryView(Context context)
    {
        super(context);
        init();
    }

    private void init()
    {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            //    inflater.inflate(R.layout.order_summary_layoutold, this);
        }
    }

    @Override
    public void setOnClickListener(OnClickListener l)
    {
        super.setOnClickListener(l);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }
}
