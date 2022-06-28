package com.example.groceryapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.groceryapp.R;
import com.example.groceryapp.models.PopularProducts;

import java.util.List;


public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder>{

    private Context context;
    private List<PopularProducts> popularProductsList;
    public PopularAdapter(Context context,List<PopularProducts> popularProductsList){
        this.context=context;
        this.popularProductsList=popularProductsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_products,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(popularProductsList.get(position).getImg_url()).into(holder.popImg);
        holder.name.setText(popularProductsList.get(position).getName());
        holder.rating.setText(popularProductsList.get(position).getRating());
        holder.discount.setText(popularProductsList.get(position).getDiscount());
        holder.description.setText(popularProductsList.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return popularProductsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView popImg;
        TextView name,discount,rating,description;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            popImg=itemView.findViewById(R.id.pop_img);
            name=itemView.findViewById(R.id.pop_name);
            description=itemView.findViewById(R.id.pop_des);
            discount=itemView.findViewById(R.id.pop_discount);
            rating=itemView.findViewById(R.id.pop_rating);

        }
    }
}
