package com.sample.jackdaniels.data.source.productlist;

public interface ProductListDataSource {
    interface Callback<T> {
        void onSuccess(T result);

        void onError();
    }

    void getProducts(Callback callback);

}
