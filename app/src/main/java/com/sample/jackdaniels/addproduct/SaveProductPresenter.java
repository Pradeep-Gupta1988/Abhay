package com.sample.jackdaniels.products;

import com.sample.jackdaniels.data.model.Product;
import com.sample.jackdaniels.data.model.ProductsWrapper;
import com.sample.jackdaniels.data.source.productlist.ProductListDataSource;
import com.sample.jackdaniels.data.source.productlist.ProductListRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductListPresenter implements ProductListContract.Presenter {
    private ProductListContract.View view;
    private ProductListRepository repository;

    ProductListPresenter(ProductListContract.View view, ProductListRepository repository) {
        this.view = view;
        this.repository = repository;
        view.setPresenter(this);
    }


    @Override
    public void onStart() {
        getProducts();
    }

    @Override
    public void getProducts() {
        repository.getProducts(new ProductListDataSource.Callback<ProductsWrapper>() {

            @Override
            public void onSuccess(ProductsWrapper result) {
                Map<String, Product> userMap = result.getProductMap();
                List<Product> list = new ArrayList<>();
                for (Map.Entry<String, Product> entry : userMap.entrySet())
                    list.add(entry.getValue());
                view.getProducts(list);
            }

            @Override
            public void onError() {
                view.onError();
            }
        });
    }
}
