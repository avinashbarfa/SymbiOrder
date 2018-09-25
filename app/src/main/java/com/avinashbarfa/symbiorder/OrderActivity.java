package com.avinashbarfa.symbiorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
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

    EditText edt_items_list, edit_username , edit_address;
    TextView txtview_contact,txt_restName;
    Button btn_place_order;
    UrlLink urlLink = new UrlLink();
    String itemList,address,personName,contactNumber = "9179686919",restaurantID,restaurantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //get back home button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_items_list = findViewById(R.id.items_list);
        edit_username = findViewById(R.id.edit_username);
        edit_address = findViewById(R.id.edit_address);
        txtview_contact = findViewById(R.id.txtview_contact);
        txt_restName = findViewById(R.id.txt_restName);
        restaurantID = getIntent().getStringExtra("restaurant_id");
        restaurantName =  getIntent().getStringExtra("restaurant_name");
        txtview_contact.setText(contactNumber);
        txt_restName.setText(restaurantName);

        btn_place_order = findViewById(R.id.btn_place_order);
        btn_place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            //ends up the activity
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void placeOrder() {
        itemList = edt_items_list.getText().toString();
        address = edit_address.getText().toString();
        personName = edit_username.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlLink.getPlaceOrderURL() , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response+" from "+restaurantName , Toast.LENGTH_LONG).show();
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
