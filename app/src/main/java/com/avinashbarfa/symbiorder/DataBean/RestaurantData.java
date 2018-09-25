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

    public String getRestaurantName() {
        return restaurantName;
    }


    public String getRestaurantImageURL() {
        return restaurantImageURL;
    }

}
