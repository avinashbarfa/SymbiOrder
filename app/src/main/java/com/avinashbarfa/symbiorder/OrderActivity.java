package com.avinashbarfa.symbiorder;

import android.media.MediaCas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.avinashbarfa.symbiorder.Adapters.RestaurantAdapter;
import com.avinashbarfa.symbiorder.DataBean.RestaurantData;
import com.avinashbarfa.symbiorder.DataBean.UrlLink;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class OrderActivity extends AppCompatActivity{

    EditText items_list;
    EditText edit_username;
    EditText edit_contact;
    EditText edit_address;
    EditText btn_place_order;
    UrlLink urlLink = new UrlLink();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        items_list = (EditText) findViewById(R.id.items_list);
        edit_username = (EditText) findViewById(R.id.edit_username);
        edit_contact = (EditText) findViewById(R.id.edit_address);

        String message = getIntent().getStringExtra("restaurant_id");
        Log.v("Message", message);

        String itemList = items_list.getText().toString();
        String address = edit_address.getText().toString();
        String personName = edit_username.getText().toString();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlLink.getRetriveRestaurantURL() , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("result");

                    for(int i =0; i<array.length();i++){
                        JSONObject object = array.getJSONObject(i);


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
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
                //params.put("category_id" , category_id);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
