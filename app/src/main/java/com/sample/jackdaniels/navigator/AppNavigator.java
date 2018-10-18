package com.sample.jackdaniels.navigator;

import android.content.Intent;

import com.sample.jackdaniels.authentication.VerifyLoginContract;
import com.sample.jackdaniels.base.BaseActivity;
import com.sample.jackdaniels.base.Navigator;
import com.sample.jackdaniels.products.ProductListContract;

public class AppNavigator extends Navigator implements ProductListContract.Navigator, VerifyLoginContract.Navigator {


    public AppNavigator(BaseActivity context) {
        super(context);
    }

    @Override
    public void callSaveProductScreen(Class<?> destination) {
        startActivity(destination);
    }

    @Override
    public void callProductListScreen(Class<?> destination) {
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(destination);
    }
}
