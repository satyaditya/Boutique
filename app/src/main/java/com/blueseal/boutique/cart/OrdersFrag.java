package com.blueseal.boutique.cart;

/**
 * Created by Satyaditya on 2/12/15.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueseal.boutique.R;

public class OrdersFrag extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.orders_frag_layout, container, false);
    }

}