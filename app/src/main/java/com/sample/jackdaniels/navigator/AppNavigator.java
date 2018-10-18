package com.sample.jackdaniels.navigator;

import android.content.Intent;

import com.sample.jackdaniels.base.BaseActivity;
import com.sample.jackdaniels.base.Navigator;
import com.sample.jackdaniels.products.ProductListContract;

public class AppNavigator extends Navigator implements ProductListContract.Navigator {


    public AppNavigator(BaseActivity context) {
        super(context);
    }


    @Override
    public void callSaveProductScreen(Class<?> destination) {
        startActivity(destination);
    }
}
