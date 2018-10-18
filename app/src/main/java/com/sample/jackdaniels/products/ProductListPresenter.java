package com.sample.jackdaniels.products;

import android.content.Intent;

import com.sample.jackdaniels.R;
import com.sample.jackdaniels.addproduct.SaveProductActivity;
import com.sample.jackdaniels.data.model.Product;
import com.sample.jackdaniels.data.model.ProductsWrapper;
import com.sample.jackdaniels.data.source.productlist.ProductListDataSource;
import com.sample.jackdaniels.data.source.productlist.ProductListRepository;
import com.sample.jackdaniels.util.NativeResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductListPresenter implements ProductListContract.Presenter {
    private ProductListContract.View view;
    private ProductListRepository repository;
    private NativeResourceManager nativeResourceManager;
    private ProductListContract.Navigator navigator;

    ProductListPresenter(ProductListContract.View view,
                         ProductListRepository repository,
                         NativeResourceManager nativeResourceManager,
                         ProductListContract.Navigator navigator) {
        this.view = view;
        this.repository = repository;
        this.navigator = navigator;
        this.nativeResourceManager = nativeResourceManager;
        view.setPresenter(this);
    }


    @Override
    public void onStart() {
        getProducts();
    }

    @Override
    public void getProducts() {
        view.showProgress(nativeResourceManager.getString(R.string.fetching_records));
        repository.getProducts(new ProductListDataSource.Callback<ProductsWrapper>() {

            @Override
            public void onSuccess(ProductsWrapper result) {
                view.dismissProgress();
                Map<String, Product> userMap = result.getProductMap();
                List<Product> list = new ArrayList<>();
                for (Map.Entry<String, Product> entry : userMap.entrySet())
                    list.add(entry.getValue());
                view.getProducts(list);
            }

            @Override
            public void onError() {
                view.dismissProgress();
                view.onError();
            }
        });
    }

    @Override
    public void onClick() {
        navigator.callSaveProductScreen(SaveProductActivity.class);
    }
}
