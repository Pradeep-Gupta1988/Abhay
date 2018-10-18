package com.sample.jackdaniels.data.source.saveproducts;

import com.sample.jackdaniels.data.model.Product;

public class SaveProductRepository implements SaveProductDataSource {
    private static SaveProductRepository instance = null;
    private SaveProductDataSource dataSource;

    private SaveProductRepository() {
        dataSource = new SaveProductDataSourceImp();

    }

    public static synchronized SaveProductRepository getInstance() {
        if (instance == null)
            instance = new SaveProductRepository();
        return instance;
    }


    @Override
    public void saveProduct(Product product, Callback callback) {
        dataSource.saveProduct(product, callback);
    }
}
