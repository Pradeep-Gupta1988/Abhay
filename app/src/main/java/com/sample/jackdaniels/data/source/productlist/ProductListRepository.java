package com.sample.jackdaniels.data.source.productlist;

public class ProductListRepository implements ProductListDataSource {
    private static ProductListRepository instance = null;
    private ProductListDataSource dataSource;

    private ProductListRepository() {
        dataSource = new ProductListDataSourceImp();

    }

    public static synchronized ProductListRepository getInstance() {
        if (instance == null)
            instance = new ProductListRepository();
        return instance;
    }


    @Override
    public void getProducts(Callback callback) {
        dataSource.getProducts(callback);
    }
}
