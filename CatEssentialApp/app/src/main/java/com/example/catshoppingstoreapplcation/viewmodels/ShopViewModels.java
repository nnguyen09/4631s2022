package com.example.catshoppingstoreapplcation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.catshoppingstoreapplcation.models.Product;
import com.example.catshoppingstoreapplcation.repositories.ShopRepo;

import java.util.List;

public class ShopViewModels extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();

    public LiveData<List<Product>> getProduct(){

        return shopRepo.getProducts();
    }
}
