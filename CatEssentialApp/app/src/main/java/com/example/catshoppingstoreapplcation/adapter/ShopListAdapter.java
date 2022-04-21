package com.example.catshoppingstoreapplcation.adapter;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catshoppingstoreapplcation.Login;
import com.example.catshoppingstoreapplcation.R;
import com.example.catshoppingstoreapplcation.Shopping;
import com.example.catshoppingstoreapplcation.Toy;
import com.example.catshoppingstoreapplcation.databinding.ShopRowBinding;
import com.example.catshoppingstoreapplcation.models.Product;
import com.example.catshoppingstoreapplcation.repositories.CartRepo;
import com.example.catshoppingstoreapplcation.views.Food;

import java.util.zip.Inflater;

public class ShopListAdapter extends ListAdapter<Product, ShopListAdapter.ShopViewHolder> {

    Context context;

    public ShopListAdapter() {
        super(Product.itemCallback);
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ShopRowBinding shopRowBinding = ShopRowBinding.inflate(layoutInflater, parent, false);
        return new ShopViewHolder(shopRowBinding,parent.getRootView());
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {

            Product product = getItem(position);

            SharedPreferences sharedPref = context.getSharedPreferences("application", Context.MODE_PRIVATE);
            String categoryselect=sharedPref.getString("Category", "");
             Log.d("Category Select", "onBindViewHolder: "+categoryselect);
             if(categoryselect == product.getCategoryName()){
                 holder.shopRowBinding.setProduct(product);


             }else{
                holder.itemView.setVisibility(View.GONE);
                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0,0));
             }


        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Add to cart Click", "Clicked On Add TO Cart");
                CartRepo.addproductstocart.add(product);

                Intent intent =  new Intent(context, Toy.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


                Log.d("showing carts", "cartitems"+product);
                for(int ii=0;ii<CartRepo.addproductstocart.toArray().length;ii++){

                    Log.d("Added Items", "onClick: "+CartRepo.addproductstocart.get(ii));
                }
            }
        });

    }

    class ShopViewHolder extends RecyclerView.ViewHolder{

        ShopRowBinding shopRowBinding;
        Button addToCartButton;


        public ShopViewHolder(ShopRowBinding binding,@NonNull View itemview){
            super(binding.getRoot());
            this.shopRowBinding=binding;
            addToCartButton=itemView.findViewById(R.id.addToCartButton);
            context=itemview.getContext();

        }



   /*     public ShopViewHolder (ShopRowBinding binding){
            super(binding.getRoot());
            this.shopRowBinding = binding;



        }*/
     }
    public interface ShopInterface{
        void addItem(Product product);
        void onItemClick(Product product);
    }





}
