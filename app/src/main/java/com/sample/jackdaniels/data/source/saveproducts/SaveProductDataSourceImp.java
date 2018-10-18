package com.sample.jackdaniels.data.source.saveproducts;


import com.sample.jackdaniels.data.model.Product;
import com.sample.jackdaniels.data.model.ProductsWrapper;
import com.sample.jackdaniels.network.APIRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaveProductDataSourceImp implements SaveProductDataSource {

    @Override
    public void saveProduct(Product product, final Callback callback) {
        APIRequest.getInstance().getProvider().addProduct(ID, product).enqueue(new retrofit2.Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                System.out.println("Success");
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                System.out.println("On Error");

                callback.onError();
            }
        });
    }
}
