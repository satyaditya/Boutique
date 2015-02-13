/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blueseal.boutique.cart;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.blueseal.boutique.R;
import com.blueseal.boutique.items.OrderItemFrag;

/**
 * This class contains the list of orders. Every time an user creates a new order a new view will be created
 * with a default message "create a new order". this view is clickable . Upon clicking this view the user will be taken to the order screen
 * If the user performs activity on the order screen , the clickable view will be view flipped to show the order summary .
 * User will be able to delete or edit an existing order. Each clickable view opens a new fragment called an orderitem. There will be info passed to and fro between
 * the ordersummary and order item.
 */
public class ShoppingCart extends Activity implements OrderItemFrag.OnOrderItemUpdatedListener
{
    /**
     * A static list of country names.
     */
    private static final String[] COUNTRIES = new String[]{
            "Belgium", "France", "Italy", "Germany", "Spain",
            "Austria", "Russia", "Poland", "Croatia", "Greece",
            "Ukraine",
    };
    private final String tag = this.getClass().getCanonicalName();
    OrdersFrag osFrag;
    /**
     * The container view which has layout change animations turned on. In this sample, this view
     * is a {@link android.widget.LinearLayout}.
     */
    private ViewGroup mContainerView;
    private Activity mAct;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_cart_layout);
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
            osFrag = new OrdersFrag();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, osFrag).commit();


        }


        ActionBar actionBar = this.getActionBar();
        if (actionBar != null) {
            Log.d(tag, " action bar is not null .configuring..");
            actionBar.setDisplayHomeAsUpEnabled(false);

        }
    }

    @Override
    public void onStart()
    {
        super.onStart();
        if (osFrag != null)
            mContainerView = (ViewGroup) osFrag.getActivity().findViewById(R.id.container);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_neworder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:

                NavUtils.navigateUpTo(this, new Intent(this, OrderItemFrag.class));
                return true;

            case R.id.action_add_item:
                // Hide the "empty" view since there is now at least one item in the list.
                findViewById(android.R.id.empty).setVisibility(View.GONE);
                addItem();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addItem()
    {
        // Instantiate a new "row" view.
        final ViewGroup newView = (ViewGroup) LayoutInflater.from(this).inflate(
                R.layout.order_summary_layout, mContainerView, false);

        /*  // Set the text in the new row to a random country.
        ((TextView) newView.findViewById(android.R.id.text1)).setText(
                COUNTRIES[(int) (Math.random() * COUNTRIES.length)]);

      // Set a click listener for the "X" button in the row that will remove the row.
        newView.findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener()
        {

        });*/

        // Because mContainerView has android:animateLayoutChanges set to true,
        // adding this view is automatically animated.
        //  newView.findViewById(R.id.delete_button).setOnClickListener(new CancelOrder());
        newView.setOnClickListener(new OrderViewUpdater());
        mContainerView.addView(newView, 0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        // Save some state!
    }
    /**
     * When the back button is pressed we should check the changes the data sent by the orderItemFragment
     * The summaryView has to be updated to show the order item information
     */
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }


    @Override
    public void OnOrderItemUpdated(Object obj)
    {

    }

    private class OrderViewUpdater implements View.OnClickListener
    {
        FragmentManager orderItemFrag;

        @Override
        public void onClick(View v)
        {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            OrderItemFrag orderFrag = new OrderItemFrag();
            fragmentTransaction.replace(R.id.fragment_container, orderFrag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack("ORDER_SUMMARY")
                    .commit();

        }
    }

    private class CancelOrder implements View.OnClickListener
    {

        @Override
        public void onClick(View view)
        {
            // Remove the row from its parent (the container view).
            // Because mContainerView has android:animateLayoutChanges set to true,
            // this removal is automatically animated.
            mContainerView.removeView(view.getRootView());

            // If there are no rows remaining, show the empty view.
            if (mContainerView.getChildCount() == 0) {
                findViewById(android.R.id.empty).setVisibility(View.VISIBLE);
            }
        }
    }
}
