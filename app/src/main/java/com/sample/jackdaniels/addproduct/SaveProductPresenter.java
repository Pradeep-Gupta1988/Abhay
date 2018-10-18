package com.sample.jackdaniels.addproduct;

import android.text.TextUtils;

import com.sample.jackdaniels.R;
import com.sample.jackdaniels.data.model.Product;
import com.sample.jackdaniels.data.model.ProductsWrapper;
import com.sample.jackdaniels.data.source.productlist.ProductListDataSource;
import com.sample.jackdaniels.data.source.productlist.ProductListRepository;
import com.sample.jackdaniels.data.source.saveproducts.SaveProductDataSource;
import com.sample.jackdaniels.data.source.saveproducts.SaveProductRepository;
import com.sample.jackdaniels.util.NativeResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SaveProductPresenter implements SaveProductContract.Presenter {
    private SaveProductContract.View view;
    private SaveProductRepository repository;
    private NativeResourceManager nativeResourceManager;

    SaveProductPresenter(SaveProductContract.View view,
                         SaveProductRepository repository,
                         NativeResourceManager nativeResourceManager) {
        this.view = view;
        this.repository = repository;
        this.nativeResourceManager = nativeResourceManager;
        view.setPresenter(this);
    }


    @Override
    public void onStart() {
        // TODO
    }


    @Override
    public void addProduct(final Product product) {
        view.showProgress(nativeResourceManager.getString(R.string.saving_product));
        repository.saveProduct(product, new SaveProductDataSource.Callback<Product>() {
            @Override
            public void onSuccess(Product result) {
                view.dismissProgress();
                if (!TextUtils.isEmpty(result.getName()))
                    view.onProductAddSuccessfully(product);
                view.finishActivity();
            }

            @Override
            public void onError() {
                view.dismissProgress();
                view.onError();
            }
        });
    }
}
