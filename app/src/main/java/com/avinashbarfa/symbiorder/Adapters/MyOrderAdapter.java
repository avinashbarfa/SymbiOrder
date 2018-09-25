package com.avinashbarfa.symbiorder.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.avinashbarfa.symbiorder.DataBean.OrdersData;
import com.avinashbarfa.symbiorder.DataBean.UrlLink;
import com.avinashbarfa.symbiorder.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Avinash Barfa on 9/12/2018.
 */

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> implements AdapterView.OnItemClickListener{

    private List<OrdersData> ordersDataList;
    private Context context;
    UrlLink urlLink = new UrlLink();
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
        holder.txtrestaurantName.setText(ordersData.getRestaurantName());
        holder.txtItems.setText(ordersData.getItemsOrdered());
        holder.txtorderedon.setText(String.valueOf(ordersData.getOrderTimeStamp()));

        holder.txttotalamount.setText(String.valueOf(ordersData.getTotalAmount()));
        if("1".equals(String.valueOf(ordersData.getStatus()))){
            holder.txtstatus.setText("Delivered");
        } else{
            holder.txtstatus.setText("Will be Delivered Soon");
        }

        Picasso.with(context).load(urlLink.getServerIP()+ordersData.getRestaurantImageURL()).into(holder.restaurantImageView);
    }

    @Override
    public int getItemCount() {
        return ordersDataList.size();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtrestaurantName,txtItems, txtorderedon, txttotalamount,txtstatus;
        public ImageView restaurantImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            restaurantImageView = itemView.findViewById(R.id.image_restaurant);
            txtrestaurantName = itemView.findViewById(R.id.txtrestaurantName);
            txtItems = itemView.findViewById(R.id.txtItems);
            txtorderedon = itemView.findViewById(R.id.txtorderedon);
            txttotalamount = itemView.findViewById(R.id.txttotalamount);
            txtstatus = itemView.findViewById(R.id.txtstatus);
        }
    }
}
