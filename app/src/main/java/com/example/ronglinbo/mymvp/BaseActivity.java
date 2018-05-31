package com.example.ronglinbo.mymvp;

import android.app.Activity;
import android.os.Bundle;

import com.example.ronglinbo.mymvp.presenter.BasePresenter;

/**
 * Created by ronglinbo on 2018/4/15.
 */

public abstract class BaseActivity <V,T extends BasePresenter<V>> extends Activity{
    //表示层的引用
    public T girlPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        girlPresenter=createPresenter();
        girlPresenter.attachView((V)this);


    }


    protected abstract T createPresenter();


    //意外退出也要解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        girlPresenter.detachView();
    }
}
