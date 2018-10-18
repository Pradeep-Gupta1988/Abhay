package com.sample.jackdaniels.network;

import com.sample.jackdaniels.data.model.Product;
import com.sample.jackdaniels.data.model.ProductsWrapper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {

    @POST(URLS.ADD_PRODUCT)
    Call<Product> addProduct(@Path("new") String path, @Body Product loginRequest);

    @GET(URLS.GET_PRODUCTS)
    Call<ProductsWrapper> getData();

}
