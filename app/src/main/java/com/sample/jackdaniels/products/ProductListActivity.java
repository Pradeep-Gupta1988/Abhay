package com.sample.jackdaniels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.sample.jackdaniels.authentication.VerifyLoginActivity;
import com.sample.jackdaniels.data.model.Product;
import com.sample.jackdaniels.data.model.ProductsWrapper;
import com.sample.jackdaniels.network.APIRequest;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Product product = new Product();
//        product.setName("Hello");
//        product.setDescription("sfoshfhf");
//        product.setPrice(300);
//        APIRequest.getInstance().getProvider().addProduct("", product).enqueue(new Callback<Product>() {
//            @Override
//            public void onResponse(Call<Product> call, Response<Product> response) {
//                System.out.println("Product added ");
//            }
//
//            @Override
//            public void onFailure(Call<Product> call, Throwable t) {
//
//            }
//        });

        APIRequest.getInstance().getProvider().getData().enqueue(new Callback<ProductsWrapper>() {
            @Override
            public void onResponse(Call<ProductsWrapper> call, Response<ProductsWrapper> response) {
                Map<String, Product> userMap = response.body().getProductMap();
                for (Map.Entry<String, Product> entry : userMap.entrySet())
                    System.out.println("Key = " + entry.getKey() +
                            ", Value = " + entry.getValue().getName());
            }

            @Override
            public void onFailure(Call<ProductsWrapper> call, Throwable t) {

            }
        });

    }
}
