package com.avinashbarfa.symbiorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private EditText addItem;
    private Button addBtn;
    private ListView itemsList;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        addItem = findViewById(R.id.add_item);
        addBtn = findViewById(R.id.add_btn);
        itemsList = findViewById(R.id.items_list);


        String message = getIntent().getStringExtra("restaurant_id");
        //String message = bundle.getString("restaurant_id");
        Log.v("Message", message);
        addBtn.setOnClickListener(this);

        ArrayList<String> items = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1 ,items);
        itemsList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_btn:
                String itemEntered = addItem.getText().toString();
                adapter.add(itemEntered);
                addItem.setText("");
                break;
        }
    }
}
