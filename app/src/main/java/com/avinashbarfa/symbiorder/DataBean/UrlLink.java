package com.avinashbarfa.symbiorder.DataBean;

public class UrlLink {

    private  String serverIP = "http://192.168.0.106";
    private  String retriveRestaurantURL = getServerIP()+"/SymbiOrder_Backend/retrieve-restaurants.php";
    private  String retriveMyOrdersURL = getServerIP()+"/SymbiOrder_Backend/retrieve-myorders.php";

    public String getServerIP() {
        return serverIP;
    }

    public String getRetriveRestaurantURL() {
        return retriveRestaurantURL;
    }

    public String getRetriveMyOrdersURL() {
        return retriveMyOrdersURL;
    }
}