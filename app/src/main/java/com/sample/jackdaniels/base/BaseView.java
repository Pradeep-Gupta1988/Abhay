package com.sample.jackdaniels.base;

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
