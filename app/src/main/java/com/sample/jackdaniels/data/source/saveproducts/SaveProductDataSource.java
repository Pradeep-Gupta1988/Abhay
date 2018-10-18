package com.sample.jackdaniels.data.source.saveproducts;

import com.sample.jackdaniels.data.model.Product;

public interface SaveProductDataSource {
    String ID="";
    interface Callback<T> {
        void onSuccess(T result);

        void onError();
    }

    void saveProduct(Product product, Callback callback);
}
