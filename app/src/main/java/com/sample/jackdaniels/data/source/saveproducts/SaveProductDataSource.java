package com.sample.jackdaniels.data.source.saveproducts

import com.sample.jackdaniels.data.model.Product

interface SaveProductDataSource {
    interface Callback<T> {
        fun onSuccess(result: T)

        fun onError()
    }

    fun saveProduct(product: Product, callback: Callback<*>)

    companion object {
        val ID = ""
    }
}
