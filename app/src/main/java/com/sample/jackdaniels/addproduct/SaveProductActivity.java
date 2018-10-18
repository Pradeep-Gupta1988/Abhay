package com.sample.jackdaniels.addproduct;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.sample.jackdaniels.R;
import com.sample.jackdaniels.base.BaseActivity;
import com.sample.jackdaniels.data.model.Product;
import com.sample.jackdaniels.data.source.saveproducts.SaveProductRepository;
import com.sample.jackdaniels.network.APIRequest;
import com.sample.jackdaniels.util.NativeResourceManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaveProductActivity extends BaseActivity implements SaveProductContract.View {
    private SaveProductContract.Presenter presenter;
    private Button btnSaveProduct;

    @Override
    protected int bindLayout() {
        return R.layout.activity_save_product;
    }

    @Override
    protected void initViews() {
        btnSaveProduct = findViewById(R.id.btnSaveProduct);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new SaveProductPresenter(this, SaveProductRepository.getInstance(),
                new NativeResourceManager(getResources())).onStart();
        btnSaveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product();
                product.setName("Whisky");
                product.setDescription("kdsbksdbsbs");
                product.setPrice(800);
                presenter.addProduct(product);
            }
        });
    }

    @Override
    public void showProgress(String message) {
        showProgress(message);
    }

    @Override
    public void dismissProgress() {
        dismissDialog();
    }

    @Override
    public void onProductAddSuccessfully(Product product) {
        showToast("Product added successfully " + product.getName());
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void onError() {
        showToast("Unable to add the product.");
    }

    @Override
    public void setPresenter(SaveProductContract.Presenter presenter) {
        this.presenter = presenter;
    }

}
