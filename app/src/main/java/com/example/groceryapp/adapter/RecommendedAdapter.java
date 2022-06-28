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
import com.example.groceryapp.models.RecommendedProducts;

import java.util.List;


public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder>{

    private Context context;
    private List<RecommendedProducts> recommendedProductsList;
    public RecommendedAdapter(Context context,List<RecommendedProducts> recommendedProductsList){
        this.context=context;
        this.recommendedProductsList=recommendedProductsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_products,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(recommendedProductsList.get(position).getImg_url()).into(holder.popImg);
        holder.name.setText(recommendedProductsList.get(position).getName());
        holder.rating.setText(recommendedProductsList.get(position).getRating());
        holder.discount.setText(recommendedProductsList.get(position).getDiscount());


    }

    @Override
    public int getItemCount() {
        return recommendedProductsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView popImg;
        TextView name,discount,rating,description;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            popImg=itemView.findViewById(R.id.pop_img);
            name=itemView.findViewById(R.id.pop_name);
            discount=itemView.findViewById(R.id.pop_discount);
            rating=itemView.findViewById(R.id.pop_rating);

        }
    }
}
