package com.example.catshoppingstoreapplcation.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.catshoppingstoreapplcation.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {
    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts(){
        if( mutableProductList == null ){
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 30.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food2", 35.99, true,"https://s7d2.scene7.com/is/image/PetSmart/5297266" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Wet Food", 2.5, true,"https://cdn.petcarerx.com/img/PrdImg/900x900/25579_001_xxl.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Wet Food2", 2.5, true,"https://m.media-amazon.com/images/I/71hbqjD5-XL._AC_SL1406_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Raw Food", 5.99, true,"https://tikipets.com/wp-content/themes/tikipets/img/Tiki-Raw-RealMeat-Mobile.png" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 1299.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 1299.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 1299.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 1299.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 1299.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 1299.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 1299.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 1299.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 1299.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 1299.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 1299.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Cat Dry Food", 1299.0, true,"https://img.chewy.com/is/image/catalog/48901_MAIN._AC_SL1500_V1634573176_.jpg" ));
        mutableProductList.setValue(productList);
    }
}
