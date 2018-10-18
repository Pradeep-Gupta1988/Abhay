package com.sample.jackdaniels.products.data.source;

import com.sample.jackdaniels.products.data.model.ProductsWrapper;

import java.util.Map;

public interface ProductListDataSource {
    interface Callback<T> {
        void onSuccess(T result);

        void onError();
    }

    void getProducts(Callback callback);

}
