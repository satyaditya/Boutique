package com.blueseal.boutique;

/**
 * Created by Satyaditya on 2/5/15.
 * An utility class that contains the information to be displayed as a part of the
 * order summary.
 */
public final class OrderSummaryCreator
{
    private String orderName = "DUMMY";
    private String orderTimeStamp = "HH:MM:SS";
    private String orderItems = "0";

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

    public void setOrderTimeStamp(String orderTimeStamp)
    {
        this.orderTimeStamp = orderTimeStamp;
    }

    public String getOrderItems()
    {
        return orderItems;
    }

    public void setOrderItems(String orderItems)
    {
        this.orderItems = orderItems;
    }
}
