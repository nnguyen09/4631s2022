package com.example.catshoppingstoreapplcation.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.catshoppingstoreapplcation.R;
import com.example.catshoppingstoreapplcation.models.cartmodel;

import java.util.ArrayList;

public class cartcustomadapter extends ArrayAdapter<cartmodel> {

    private Context mcontext;
    private int mresource;


    public cartcustomadapter(@NonNull Context context, int resource, @NonNull ArrayList<cartmodel> objects) {
        super(context, resource, objects);
        this.mcontext=context;
        this.mresource=resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= LayoutInflater.from(mcontext);
        convertView=layoutInflater.inflate(mresource,parent,false);

        ImageView imageView=convertView.findViewById(R.id.cartimage);
        TextView textname=convertView.findViewById(R.id.carttextname);
        TextView textdes=convertView.findViewById(R.id.cartprice);
        Glide.with(mcontext).load(getItem(position).getImageUrl()).into(imageView);
        textname.setText(getItem(position).getName());
        textdes.setText(getItem(position).getPrice().toString());




        return convertView;

    }
}
