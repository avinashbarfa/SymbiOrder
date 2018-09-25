package com.avinashbarfa.symbiorder.DataBean;

/**
 * Created by Avinash Barfa on 9/11/2018.
 */

public class OrdersData {
    private int orderID;
    private int restaurantID;
    private String restaurantName;
    private int status;
    private String address;
    private long contactNumber;
    private String restaurantImageURL;
    private int totalAmount;
    private String orderTimeStamp;
    private String itemsOrdered;

    public OrdersData(String restaurantName, String restaurantImageURL, String itemsOrdered,String orderTimeStamp,int totalAmount,int status) {
        this.restaurantName = restaurantName;
        this.status = status;
        this.restaurantImageURL = restaurantImageURL;
        this.totalAmount = totalAmount;
        this.orderTimeStamp = orderTimeStamp;
        this.itemsOrdered = itemsOrdered;
    }


    public String getRestaurantName() {
        return restaurantName;
    }

    public int getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public String getRestaurantImageURL() {
        return restaurantImageURL;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public String getOrderTimeStamp() {
        return orderTimeStamp;
    }

    public String getItemsOrdered() {
        return itemsOrdered;
    }
}