package com.avinashbarfa.symbiorder.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.avinashbarfa.symbiorder.DataBean.OrdersData;
import com.avinashbarfa.symbiorder.MyOrdersClickListener;
import com.avinashbarfa.symbiorder.OrderActivity;
import com.avinashbarfa.symbiorder.OrderDetailActivity;
import com.avinashbarfa.symbiorder.R;

import java.util.List;

/**
 * Created by Avinash Barfa on 9/12/2018.
 */

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> implements AdapterView.OnItemClickListener{

    private List<OrdersData> ordersDataList;
    private Context context;

    public MyOrderAdapter(List<OrdersData> ordersDataList, Context context) {
        this.ordersDataList = ordersDataList;
        this.context = context;
    }
    @Override
    public MyOrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myorder_list,parent,false);
        return new MyOrderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyOrderAdapter.ViewHolder holder, int position) {
        final OrdersData ordersData = ordersDataList.get(position);
        holder.orderID.setText(String.valueOf(ordersData.getOrderID()));
        holder.setMyOrdersClickListener(new MyOrdersClickListener() {
                        @Override
            public void onClick(View view, int position) {
                Toast.makeText(context, String.valueOf(ordersData.getOrderID()),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra("order_id" , String.valueOf(ordersData.getOrderID()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ordersDataList.size();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView orderID;
        private MyOrdersClickListener myOrdersClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            orderID = (TextView) itemView.findViewById(R.id.orderid);
            itemView.setOnClickListener(this);
        }

        public void setMyOrdersClickListener(MyOrdersClickListener myOrdersClickListener){
            this.myOrdersClickListener = myOrdersClickListener;
        }

        @Override
        public void onClick(View v) {
            myOrdersClickListener.onClick(v,getAdapterPosition());
        }

    }
}
