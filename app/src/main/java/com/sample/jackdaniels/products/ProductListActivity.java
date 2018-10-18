package com.sample.jackdaniels.products;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    private FloatingActionButton fabAdd;
    private RecyclerView rvProductList;

    @Override
    protected int bindLayout() {
        return R.layout.activity_product_list;
    }

    @Override
    protected void initViews() {
        fabAdd = findViewById(R.id.fabAdd);
        rvProductList = findViewById(R.id.rvProductList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ProductListPresenter(this,
                ProductListRepository.getInstance(),
                new NativeResourceManager(getResources()),
                new AppNavigator(this)).onStart();

        fabAdd.setOnClickListener(new View.OnClickListener() {
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
        rvProductList.setLayoutManager(new LinearLayoutManager(this));
        rvProductList.setAdapter(new ProductListAdapter(this, list));
        System.out.println("List is " + list.size());
    }

    @Override
    public void onError() {
    }
}
