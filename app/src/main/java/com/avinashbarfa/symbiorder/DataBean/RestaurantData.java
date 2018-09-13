package com.avinashbarfa.symbiorder.DataBean;

/**
 * Created by Avinash Barfa on 9/9/2018.
 */

public class RestaurantData {

    private int restaurantID;
    private String restaurantName;
    private String restaurantImageURL;

    public RestaurantData(int restaurantID, String restaurantName,String restaurantImageURL) {
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.restaurantImageURL = restaurantImageURL;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }


    public String getRestaurantImageURL() {
        return restaurantImageURL;
    }

    public void setRestaurantImageURL(String restaurantImageURL) {
        this.restaurantImageURL = restaurantImageURL;
    }
}
