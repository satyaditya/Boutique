package com.blueseal.boutique.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Satyaditya on 2/5/15.
 * A singleton utility class that contains the information to be displayed as a part of the
 * order summary.
 */
public final class OrderDetails
{
    private static OrderDetails mOsu = null;
    private static List<Order> ordersList = new ArrayList<Order>();

    private OrderDetails()
    {

    }

    public static OrderDetails getInstance()
    {
        if (mOsu == null)
            mOsu = new OrderDetails();

        return mOsu;
    }

    public List<Order> getOrdersList()
    {
        return ordersList;
    }

    //need to maintain the synchronous behaviour here
    public void setOrdersList(List<Order> ordersList)
    {
        this.ordersList = ordersList;
    }

    class Order
    {

        private String orderName = "DUMMY";
        private String orderTimeStamp = "HH:MM:SS";
        private int orderItems = 0;

        public String getOrderName()
        {
            return orderName;
        }

        public void setOrderName(String orderName)
        {
            this.orderName = orderName;
        }

        public String getOrderTimeStamp()
        {
            return orderTimeStamp;
        }

        public void setOrderTimeStamp(String orderTimeStamp) {this.orderTimeStamp = orderTimeStamp;}

        public int getOrderItems()
        {
            return orderItems;
        }

        public void setOrderItems(int orderItems)
        {
            this.orderItems = orderItems;
        }

    }

}
