package com.sample.jackdaniels.products;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.jackdaniels.R;
import com.sample.jackdaniels.data.model.Product;

import java.util.List;

/**
 * jack-danials
 * Created by Administrator on 19-10-2018.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListHolder> {

    private Context context;
    private List<Product> productList;

    ProductListAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public ProductListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemProductList = LayoutInflater.from(context)
                .inflate(R.layout.item_product_list, parent, false);
        return new ProductListHolder(itemProductList);

    }

    @Override
    public void onBindViewHolder(ProductListHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductListHolder extends RecyclerView.ViewHolder {

        public ProductListHolder(View itemView) {
            super(itemView);
        }
    }
}
