package com.sample.jackdaniels.products;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sample.jackdaniels.R;
import com.sample.jackdaniels.base.BaseActivity;
import com.sample.jackdaniels.data.model.Product;
import com.sample.jackdaniels.data.source.productlist.ProductListRepository;
import com.sample.jackdaniels.navigator.AppNavigator;
import com.sample.jackdaniels.util.NativeResourceManager;

import java.util.List;

public class ProductListActivity extends BaseActivity implements ProductListContract.View {
    private ProductListContract.Presenter presenter;
    private Button button;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        button = findViewById(R.id.button);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ProductListPresenter(this,
                ProductListRepository.getInstance(),
                new NativeResourceManager(getResources()),
                new AppNavigator(this)).onStart();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClick();
            }
        });
    }

    @Override
    public void setPresenter(ProductListContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void showProgress(String message) {
        showProgressDialog(message);
    }

    @Override
    public void dismissProgress() {
        dismissDialog();
    }

    @Override
    public void getProducts(List<Product> list) {
        System.out.println("List is "+list.size());
    }

    @Override
    public void onError() {
    }
}
