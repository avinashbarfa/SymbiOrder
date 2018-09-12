package com.avinashbarfa.symbiorder.DataBean;

/**
 * Created by Avinash Barfa on 9/11/2018.
 */

public class OrdersData {
    private int orderID;
    private int userID;
    private int restaurantID;
    private int status;
    private String address;
    private long contactNumber;

    public OrdersData(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}