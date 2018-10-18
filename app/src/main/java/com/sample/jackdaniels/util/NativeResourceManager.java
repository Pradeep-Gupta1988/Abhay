package com.sample.jackdaniels.util;

import android.content.res.Resources;

public class NativeResourceManager {
    private Resources resources;

    public NativeResourceManager(Resources resources) {
        this.resources = resources;
    }

    public String getString(int string) {
        return resources.getString(string);
    }

    public int getColor(int color) {
        return resources.getColor(color);
    }
}
