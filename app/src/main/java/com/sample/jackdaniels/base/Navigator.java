package com.sample.jackdaniels.base;


import android.content.Intent;

import java.io.Serializable;

public class Navigator implements BaseNavigator {
    private BaseActivity context;

    public Navigator(BaseActivity context) {
        this.context = context;
    }

    @Override
    public void finish() {
        context.finish();
    }

    @Override
    public void closeApplication() {
        context.finishAffinity();
    }

    protected void startActivity(Class<?> destination) {
        context.startActivity(new Intent(context, destination).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }

    protected void startActivity(Class<?> destination, Serializable serializable) {
        Intent intent = new Intent(context, destination);
        intent.putExtra(SERIALIZE_OBJ, serializable);
        context.startActivity(intent);
    }



}
