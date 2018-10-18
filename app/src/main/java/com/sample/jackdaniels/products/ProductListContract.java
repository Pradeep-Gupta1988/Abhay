package com.sample.jackdaniels.products;

import android.content.Intent;

import com.sample.jackdaniels.base.BaseNavigator;
import com.sample.jackdaniels.base.BasePresenter;
import com.sample.jackdaniels.base.BaseView;
import com.sample.jackdaniels.data.model.Product;

import java.util.List;

public interface ProductListContract {

    interface View extends BaseView<Presenter> {
        void showProgress(String message);

        void dismissProgress();

        void getProducts(List<Product> list);

        void onError();
    }

    interface Presenter extends BasePresenter {
        void getProducts();

        void onClick();
    }

    interface Navigator extends BaseNavigator {
        void callSaveProductScreen(Class<?> destination);
    }
}
