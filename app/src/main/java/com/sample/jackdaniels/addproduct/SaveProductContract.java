package com.sample.jackdaniels.addproduct;

import com.sample.jackdaniels.base.BasePresenter;
import com.sample.jackdaniels.base.BaseView;
import com.sample.jackdaniels.data.model.Product;

import java.util.List;

public interface SaveProductContract {

    interface View extends BaseView<Presenter> {
        void showProgress(String message);

        void dismissProgress();

        void onProductAddSuccessfully(Product product);

        void finishActivity();

        void onError();
    }

    interface Presenter extends BasePresenter {
        void addProduct(Product product);
    }
}
