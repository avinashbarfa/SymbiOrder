package com.avinashbarfa.symbiorder.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.avinashbarfa.symbiorder.DataBean.RestaurantData;
import com.avinashbarfa.symbiorder.R;

import java.util.List;

/**
 * Created by Avinash Barfa on 9/9/2018.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder>{

    private List<RestaurantData> restaurantDataList;
    private Context context;

    public RestaurantAdapter(List<RestaurantData> restaurantList, Context context) {
        this.restaurantDataList  = restaurantList;
        this.context = context;
    }

    @Override
    public RestaurantAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list,parent,false);
        return new RestaurantAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantAdapter.ViewHolder holder, int position) {
        RestaurantData restaurantData = restaurantDataList.get(position);
        holder.txtRestaurantName.setText(restaurantData.getRestaurantName());


     }

    @Override
    public int getItemCount() {
        return restaurantDataList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtRestaurantName;

        public ViewHolder(View itemView) {
            super(itemView);
            txtRestaurantName = (TextView)itemView.findViewById(R.id.restaurant_name);
        }
    }

}
