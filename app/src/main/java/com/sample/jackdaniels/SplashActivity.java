package com.sample.jackdaniels;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.sample.jackdaniels.authentication.LoginActivity;
import com.sample.jackdaniels.base.BaseActivity;
import com.sample.jackdaniels.products.ProductListActivity;

public class SplashActivity extends BaseActivity {
    private Handler handler = new Handler();

    @Override
    protected int bindLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViews() {

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler.postDelayed(runnable, 3000);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(SplashActivity.this, ProductListActivity.class));
            finish();
        }
    };

    @Override
    public void onBackPressed() {
        handler.removeCallbacks(runnable);
        super.onBackPressed();
    }
}
