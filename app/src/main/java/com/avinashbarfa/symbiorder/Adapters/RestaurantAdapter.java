package com.avinashbarfa.symbiorder.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;


import com.avinashbarfa.symbiorder.DataBean.RestaurantData;
import com.avinashbarfa.symbiorder.DataBean.UrlLink;
import com.avinashbarfa.symbiorder.OrderActivity;
import com.avinashbarfa.symbiorder.R;
import com.avinashbarfa.symbiorder.RestaurantClickListener;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

/**
 * Created by Avinash Barfa on 9/9/2018.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> implements AdapterView.OnItemClickListener{

    private List<RestaurantData> restaurantDataList;
    private Context context;
    UrlLink urlLink = new UrlLink();
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
        final RestaurantData restaurantData = restaurantDataList.get(position);
        holder.txtRestaurantName.setText(restaurantData.getRestaurantName());
        Picasso.with(context).load(urlLink.getServerIP()+restaurantData.getRestaurantImageURL()).into(holder.restaurantImage);
        holder.setRestaurantClickListener(new RestaurantClickListener() {
            @Override
            public void onClick(View view, int position) {
                    System.out.print("ID status :"+restaurantData.getRestaurantID());
                    Intent intent = new Intent(context, OrderActivity.class);
                    intent.putExtra("restaurant_id" , String.valueOf(restaurantData.getRestaurantID()));
                    intent.putExtra("restaurant_name", restaurantData.getRestaurantName());
                    context.startActivity(intent);
            }
        });
     }

    @Override
    public int getItemCount() {
        return restaurantDataList.size();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtRestaurantName;
        public ImageView restaurantImage;
        private RestaurantClickListener restaurantClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            txtRestaurantName = itemView.findViewById(R.id.restaurant_name);
            restaurantImage = itemView.findViewById(R.id.restaurant_image);
            itemView.setOnClickListener(this);
        }

        public void setRestaurantClickListener(RestaurantClickListener restaurantClickListener){
            this.restaurantClickListener = restaurantClickListener;
        }

        @Override
        public void onClick(View v) {
            restaurantClickListener.onClick(v,getAdapterPosition());
        }

    }
}
