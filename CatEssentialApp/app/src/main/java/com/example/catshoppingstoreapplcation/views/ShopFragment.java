package com.example.catshoppingstoreapplcation.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catshoppingstoreapplcation.R;
import com.example.catshoppingstoreapplcation.adapter.ShopListAdapter;
import com.example.catshoppingstoreapplcation.databinding.FragmentShopBinding;
import com.example.catshoppingstoreapplcation.models.Product;
import com.example.catshoppingstoreapplcation.viewmodels.ShopViewModels;

import java.util.List;


public class ShopFragment extends Fragment implements ShopListAdapter.ShopInterface {
    FragmentShopBinding fragmentShopBinding;
    private ShopListAdapter shopListAdapter;
    private ShopViewModels shopViewModels;

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentShopBinding = FragmentShopBinding.inflate(inflater,container, false );

        return fragmentShopBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shopListAdapter = new ShopListAdapter();
        fragmentShopBinding.shopRecyclerView.setAdapter(shopListAdapter);
        fragmentShopBinding.shopRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        fragmentShopBinding.shopRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),DividerItemDecoration.HORIZONTAL));


        shopViewModels = new ViewModelProvider(requireActivity()).get(ShopViewModels.class);
        shopViewModels.getProduct().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                shopListAdapter.submitList(products);
            }
        });
    }

    @Override
    public void addItem(Product product) {

    }

    @Override
    public void onItemClick(Product product) {

    }
}