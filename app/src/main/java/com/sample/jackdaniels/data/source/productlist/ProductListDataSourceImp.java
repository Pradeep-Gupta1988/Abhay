package com.sample.jackdaniels.products.data.source;


import com.sample.jackdaniels.network.APIRequest;
import com.sample.jackdaniels.products.data.model.ProductsWrapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListDataSourceImp implements ProductListDataSource {


    @Override
    public void getProducts(final Callback callback) {
        APIRequest.getInstance().getProvider().getData().enqueue(new retrofit2.Callback<ProductsWrapper>() {
            @Override
            public void onResponse(Call<ProductsWrapper> call, Response<ProductsWrapper> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ProductsWrapper> call, Throwable t) {
                callback.onError();
            }
        });
    }
}
