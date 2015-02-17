package com.blueseal.boutique.items;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueseal.boutique.R;

/**
 * Order Item Fragment contains the functionality for the user to create a new order.This fragment communicates with the @link orderSummary.java
 * and displays the order summary depending on the content of the order.
 * <p/>
 * This fragment also contains functionality to update the database and to create a transaction to remote
 */


public class OrderItemFrag extends Fragment //implements addOnBackStackChangedListener
{
    OnOrderItemUpdatedListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.order_item_layout, container, false);
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try {
            mListener = (OnOrderItemUpdatedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnOrderItemUpdatedListener");
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();
    }

    public interface OnOrderItemUpdatedListener
    {
        public void OnOrderItemUpdated(Object obj);
    }
   /* @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
