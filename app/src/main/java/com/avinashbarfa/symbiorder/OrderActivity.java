package com.avinashbarfa.symbiorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.avinashbarfa.symbiorder.DataBean.UrlLink;

import java.util.HashMap;
import java.util.Map;

public class OrderActivity extends AppCompatActivity{

    EditText edt_items_list;
    EditText edit_username;
    EditText edit_contact;
    EditText edit_address;
    TextView txtview_contact;
    Button btn_place_order;
    UrlLink urlLink = new UrlLink();
    String itemList,address,personName,contactNumber = "9179686919",restaurantID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        edt_items_list = (EditText) findViewById(R.id.items_list);
        edit_username = (EditText) findViewById(R.id.edit_username);
        edit_address = (EditText) findViewById(R.id.edit_address);
        txtview_contact = (TextView) findViewById(R.id.txtview_contact);

        restaurantID = getIntent().getStringExtra("restaurant_id");
        txtview_contact.setText(contactNumber);

        btn_place_order = (Button) findViewById(R.id.btn_place_order);
        btn_place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });
    }

    public void placeOrder() {
        itemList = edt_items_list.getText().toString();
        address = edit_address.getText().toString();
        personName = edit_username.getText().toString();
        Log.v("data : ", restaurantID+" "+contactNumber+" "+itemList+" "+address+" "+personName);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlLink.getPlaceOrderURL() , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response , Toast.LENGTH_LONG).show();
                startActivity(new Intent(OrderActivity.this, MyOrderActivity.class));
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.getMessage() , Toast.LENGTH_LONG).show();
                }
            }
        )
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("items_list" , itemList);
                params.put("address" , address);
                params.put("personName", personName);
                params.put("contact" , contactNumber);
                params.put("restaurant", restaurantID);
                params.put("status", "0");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
