package com.sample.jackdaniels.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class ProductsWrapper {

    @SerializedName("products")
    @Expose
    private Map<String, Product> productMap;

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<String, Product> productMap) {
        this.productMap = productMap;
    }


}
