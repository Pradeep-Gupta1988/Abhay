package com.sample.jackdaniels.addproduct

import com.sample.jackdaniels.base.BasePresenter
import com.sample.jackdaniels.base.BaseView
import com.sample.jackdaniels.data.model.Product

interface SaveProductContract {

    interface View : BaseView<Presenter> {
        fun onProductAddSuccessfully(list: List<Product>)

        fun onError()
    }

    interface Presenter : BasePresenter {
        fun addProduct(product: Product)
    }
}
