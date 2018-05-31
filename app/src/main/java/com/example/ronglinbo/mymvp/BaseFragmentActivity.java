package com.example.ronglinbo.mymvp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.ronglinbo.mymvp.okhttp.ResultHttpInfo;
import com.example.ronglinbo.mymvp.presenter.BasePresenter;
import com.example.ronglinbo.mymvp.presenter.CommonPresenter;
import com.example.ronglinbo.mymvp.view.IGirlView;

/**
 * Created by Administrator on 2018/5/24.
 */

public abstract class BaseFragmentActivity <V,T extends BasePresenter<V>>  extends FragmentActivity{

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


    public void rightToLeft(){
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public void leftToRight(){
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

}
